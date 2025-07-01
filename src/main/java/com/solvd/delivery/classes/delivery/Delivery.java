package com.solvd.delivery.classes.delivery;

import com.solvd.delivery.classes.food.Food;
import com.solvd.delivery.classes.humans.DeliveryPerson;
import com.solvd.delivery.exceptions.SamePersonException;

public class Delivery {

    private Order order;
    private DeliveryPerson deliveryPerson;
    private double totalPrice;
    private int deliveryTime;

    public Delivery(Order order, DeliveryPerson deliveryPerson, double totalPrice, int deliveryTime) throws SamePersonException {
        if (order == null || order.getItems().isEmpty()) {
            System.out.println("Can't create delivery with an empty order.");
        }
        if (deliveryPerson.getName().equals(order.getClient().getName())) {
            throw new SamePersonException("Delivery person and client cannot be the same person!");
        }
        this.order = order;
        this.deliveryPerson = deliveryPerson;
        this.totalPrice = totalPrice;
        this.deliveryTime = deliveryTime;
    }

    public Order getOrder() {
        return order;
    }

    private void setOrder(Order order) {
        this.order = order;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Override
    public String toString() {
        if (order.getItems().isEmpty()) {
            return "Delivery cancelled: Order is empty.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Ordered by ").append(order.getClient().getName()).append("\n");
        sb.append("Order:\n");
        for (Food item : order.getItems()) {
            sb.append(" - ").append(item.getName()).append(" ").append(item.getPrice()).append(" UAH\n");
        }
        sb.append("Delivery by: ").append(deliveryPerson.getName()).append("\n");
        sb.append("Delivery time: ").append(deliveryTime).append(" min.\n");
        sb.append("Total price: ").append(totalPrice).append(" UAH");

        return sb.toString();
    }
}
