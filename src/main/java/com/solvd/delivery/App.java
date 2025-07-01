package com.solvd.delivery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.delivery.classes.humans.Client;
import com.solvd.delivery.classes.delivery.Delivery;
import com.solvd.delivery.classes.delivery.DeliveryCompany;
import com.solvd.delivery.classes.delivery.DeliveryTime;
import com.solvd.delivery.classes.delivery.Order;
import com.solvd.delivery.classes.food.Food;
import com.solvd.delivery.classes.food.Menu;
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

    public static void main(String[] args) throws Exception {

        Address clientAddress = new Address("Ghotem", "Home str.", 23, 1, 12.5, 15);
        Address restaurantAddress = new Address("Metropolis", "Food str.", 10, 1,7.4, 11.7);
        System.out.println(restaurantAddress.typeAddress());

        Food homeDish1 = new Food("Bograch", 50);
        Food homeDish2 = new Food("Varenyki", 30);

        Menu homeMenu = new Menu(homeDish1, homeDish2);
        System.out.println(homeMenu.toString());

        Client client = new Client("Bob", clientAddress, 80, 33); //Play with money, delivery will be canceled if not enough money
        try { 
            client.isAdult();
        } catch (IsAdultException e) {
            logger.warn(e.getMessage());
        }
        System.out.println(client.toString());
        client.introduce();
        Restaurant restaurant = new Restaurant("Home Dishes", restaurantAddress, homeMenu);
        System.out.println(restaurant.toString());

        Order order = new Order(client, restaurant);
        try {
            order.addItem("Bograch");
            order.addItem("Varenyki");
            order.addItem("Kvas");
        } catch (InsufficientFundsException e) {
            logger.warn("Payment problem: " + e.getMessage());
        } catch (ItemNotFoundException e) {
            logger.error("No such item in menu. " + e.getMessage());
        }

        DeliveryCompany company = new DeliveryCompany("Flash Delivery", null);
        DeliveryPerson person = new DeliveryPerson("Barry Alen");
        System.out.println(person.toString());
        person.introduce();
        company.addEmployee(person);

        try {
            DeliveryTime delTime = new DeliveryTime();
            int time = delTime.deliveryTime(clientAddress, restaurantAddress);
            double price = order.totalPrice();
            try {
                Delivery delivery = new Delivery(order, person, price, time);
                System.out.println(delivery.toString());
            } catch (SamePersonException e) {
                logger.error(e.getMessage());
            }
        } catch (DiffCityException e) {
            logger.error(e.getMessage());
        }

        // logger.info("This is an INFO message");
        // logger.warn("This is an WARN message");
        // logger.error("This is an ERROR message");
    }
}
