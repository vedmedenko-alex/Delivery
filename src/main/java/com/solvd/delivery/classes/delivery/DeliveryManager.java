package com.solvd.delivery.classes.delivery;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.delivery.classes.humans.DeliveryPerson;
import com.solvd.delivery.exceptions.DiffCityException;
import com.solvd.delivery.exceptions.SamePersonException;
import com.solvd.delivery.classes.delivery.DeliveryCompany;

public class DeliveryManager {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryManager.class);

    private Queue<Order> orderQueue = new LinkedList<>();
    private final DeliveryCompany deliveryCompany;
    private final Set<DeliveryPerson> busyDeliveryPersons = new HashSet<>();

    public DeliveryManager(DeliveryCompany deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public void addOrder(Order order) {
        orderQueue.offer(order);
        logger.info("Order queued for client: {}", order.getClient().getName());
    }

    public boolean hasPendingOrders() {
        return !orderQueue.isEmpty();
    }

    public Set<DeliveryPerson> getAvailableDeliveryPersons() {
        Set<DeliveryPerson> available = new HashSet<>(deliveryCompany.getEmployees());
        available.removeAll(busyDeliveryPersons);
        return available;
    }

    public boolean hasAvailableDeliveryPersons() {
        return !getAvailableDeliveryPersons().isEmpty();
    }

    public Delivery processNextOrder(DeliveryTime deliveryTimeCalculator) throws DiffCityException, SamePersonException {
        if (orderQueue.isEmpty()) {
            logger.warn("No pending orders");
            return null;
        }

        Set<DeliveryPerson> available = getAvailableDeliveryPersons();
        if (available.isEmpty()) {
            logger.warn("No available delivery persons");
            return null;
        }

        Order order = orderQueue.poll();
        DeliveryPerson deliveryPerson = available.iterator().next();
        busyDeliveryPersons.add(deliveryPerson);

        int deliveryTime = deliveryTimeCalculator.deliveryTime(
                order.getClient().getAddress(), order.getRestaurant().getAddress()
        );

        Delivery delivery = new Delivery(order, deliveryPerson, order.totalPrice(), deliveryTime);
        logger.info("{} goes to {}", deliveryPerson.getName(), order.getClient().getName());

        return delivery;
    }
}
