package com.solvd.delivery;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.delivery.classes.delivery.Delivery;
import com.solvd.delivery.classes.delivery.DeliveryCompany;
import com.solvd.delivery.classes.delivery.DeliveryManager;
import com.solvd.delivery.classes.delivery.DeliveryTime;
import com.solvd.delivery.classes.delivery.Order;
import com.solvd.delivery.classes.food.Beverages;
import com.solvd.delivery.classes.food.Food;
import com.solvd.delivery.classes.food.Menu;
import com.solvd.delivery.classes.humans.Client;
import com.solvd.delivery.classes.humans.DeliveryPerson;
import com.solvd.delivery.classes.places.Address;
import com.solvd.delivery.classes.places.Restaurant;
import com.solvd.delivery.exceptions.DiffCityException;
import com.solvd.delivery.exceptions.InsufficientFundsException;
import com.solvd.delivery.exceptions.IsAdultException;
import com.solvd.delivery.exceptions.ItemNotFoundException;
import com.solvd.delivery.exceptions.SamePersonException;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws DiffCityException, SamePersonException {

        Address clientAddress = new Address("Ghotem", "Home str.", 23, 1, 12.5, 15);
        Address restaurantAddress = new Address("Ghotem", "Food str.", 10, 1, 7.4, 11.7);
        logger.info(restaurantAddress.typeAddress());

        Food homeDish1 = new Food("Bograch", 50);
        Food homeDish2 = new Food("Varenyki", 30);
        Food homeDish3 = new Food("Cake Kyevski", 45);
        Beverages beverage1 = new Beverages("Wine", 40, true);
        Food homeDish4 = new Food("Cake Symskiy kashtan", 55);
        Beverages beverage2 = new Beverages("Gorilka", 20, true);

        Menu homeMenu = new Menu(homeDish1, homeDish2, homeDish3, beverage1, homeDish4, beverage2);
        logger.info(homeMenu.toString());
        homeMenu.printMenu();
        homeMenu.printOrderedMenu();

        Client client = new Client("Bob", clientAddress, 800, 33); //Play with money, delivery will be canceled if not enough money
        try {
            client.isAdult();
        } catch (IsAdultException e) {
            logger.warn(e.getMessage());
        }
        logger.info(client.toString());
        client.introduce();
        Restaurant restaurant = new Restaurant("Home Dishes", restaurantAddress, homeMenu);
        logger.info(restaurant.toString());

        Order order1 = new Order(client, restaurant);
        try {
            order1.addItem("Bograch");
            order1.addItem("Varenyki");
            order1.addItem("Kvas");
        } catch (InsufficientFundsException e) {
            logger.warn("Payment problem: " + e.getMessage());
        } catch (ItemNotFoundException e) {
            logger.error("No such item in menu. " + e.getMessage());
        }

        Order order2 = new Order(client, restaurant);
        try {
            order2.addItem("Cake Symskiy kashtan");
            order2.addItem("Gorilka");
        } catch (InsufficientFundsException e) {
            logger.warn("Payment problem: " + e.getMessage());
        } catch (ItemNotFoundException e) {
            logger.error("No such item in menu. " + e.getMessage());
        }

        // Queue<Order> orderQueue = new LinkedList<>();
        // orderQueue.add(order1);
        // orderQueue.add(order2);
        Set<DeliveryPerson> employees = new HashSet<>();
        DeliveryCompany company = new DeliveryCompany("Flash Delivery", employees);
        DeliveryPerson person1 = new DeliveryPerson("Barry Alen");
        DeliveryPerson person2 = new DeliveryPerson("Clarc Kent");
        logger.info(person1.toString());
        person1.introduce();
        employees.add(person1);
        employees.add(person2);

        DeliveryManager manager = new DeliveryManager(company);

        manager.addOrder(order1);
        manager.addOrder(order2);

        DeliveryTime deliveryTimeCalculator = new DeliveryTime();

        while (manager.hasPendingOrders() && manager.hasAvailableDeliveryPersons()) {
            Delivery delivery = manager.processNextOrder(deliveryTimeCalculator);
            System.out.println(delivery);
        }

        // try {
        //     DeliveryTime delTime = new DeliveryTime();
        //     int time = delTime.deliveryTime(clientAddress, restaurantAddress);
        //     double price = order1.totalPrice();
        //     try {
        //         Delivery delivery = new Delivery(order1, person, price, time);
        //         logger.info(delivery.toString());
        //     } catch (SamePersonException e) {
        //         logger.error(e.getMessage());
        //     }
        // } catch (DiffCityException e) {
        //     logger.error(e.getMessage());
        // }
    }
}
