package com.solvd.delivery.classes.abstracts;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.delivery.App;
import com.solvd.delivery.annotations.MinPriceLimit;
import com.solvd.delivery.classes.humans.Client;
import com.solvd.delivery.classes.places.Restaurant;
import com.solvd.delivery.exceptions.InsufficientFundsException;
import com.solvd.delivery.exceptions.ItemNotFoundException;
import com.solvd.delivery.interfaces.Payable;
import com.solvd.delivery.interfaces.functionalInterfaces.ChangeBalance;

public abstract class AbstractOrder<T extends AbstractItem> {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    protected Client client;
    protected Restaurant restaurant;
    protected ArrayList<T> items = new ArrayList<>();

    public AbstractOrder(Client client, Restaurant restaurant) {
        this.client = client;
        this.restaurant = restaurant;
    }

    public void addItem(String itemName) throws ItemNotFoundException {
        T item = getItemFromMenu(itemName);
        if (item != null) {
            items.add(item);
            logger.info(itemName + " added to order.");
        } else {
            throw new ItemNotFoundException(itemName + " not found in menu.");
        }
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public void setItems(ArrayList<T> items) {
        this.items = items;
    }

    public double totalPrice() {
        // double total = 0;
        // for (T item : items) {
        //     total += item.getPrice();
        // }
        // return total;
        return items.stream().mapToDouble(T::getPrice).sum();
    }

    public Client getClient() {
        return client;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void finalizeOrderAndCharge(ChangeBalance changeBalance) throws InsufficientFundsException {
        double total = totalPrice();

        try {
            Class<?> clazz = this.getClass();
            if (clazz.isAnnotationPresent(MinPriceLimit.class)) {
                MinPriceLimit annotation = clazz.getAnnotation(MinPriceLimit.class);
                double minValue = annotation.min();
                if (total < minValue) {
                    throw new IllegalArgumentException("Minimum order value is : " + minValue + " UAH. Current order value: " + total);
                }
            }
        } catch (Exception e) {
            logger.error("Error in checking minimum order value: {}", e.getMessage());
            throw new RuntimeException(e);
        }

        if (!(client instanceof Payable)) {
            throw new InsufficientFundsException("Client is not eligible to pay.");
        }

        Payable payableClient = (Payable) client;

        if (payableClient.getBalance() < total) {
            throw new InsufficientFundsException("Insufficient funds to pay: " + total + " UAH");
        }

        payableClient.pay(total);
        restaurant.changeBalance(total);
        changeBalance.changeBalance(total);
        logger.info("Client {} payed {} UAH", client.getName(), total);
    }

    protected abstract T getItemFromMenu(String itemName);
}
