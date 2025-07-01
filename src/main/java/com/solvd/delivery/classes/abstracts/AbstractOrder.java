package com.solvd.delivery.classes.abstracts;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.delivery.App;
import com.solvd.delivery.classes.humans.Client;
import com.solvd.delivery.classes.places.Restaurant;
import com.solvd.delivery.exceptions.InsufficientFundsException;
import com.solvd.delivery.exceptions.ItemNotFoundException;
import com.solvd.delivery.interfaces.Payable;

public abstract class AbstractOrder<T extends AbstractItem> {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    protected Client client;
    protected Restaurant restaurant;
    protected ArrayList<T> items = new ArrayList<>();

    public AbstractOrder(Client client, Restaurant restaurant) {
        this.client = client;
        this.restaurant = restaurant;
    }

    public void addItem(String itemName) throws InsufficientFundsException, ItemNotFoundException {
        if (!(client instanceof Payable)) {
            throw new InsufficientFundsException("Client is not eligible to pay.");
        }

        T item = getItemFromMenu(itemName);
        if (item != null) {
            Payable payableClient = (Payable) client;
            if (payableClient.getBalance() >= item.getPrice()) {
                items.add(item);
                payableClient.pay(item.getPrice());
                restaurant.changeBalance(item.getPrice());
                logger.info(itemName + " added to order.");
            } else {
                throw new InsufficientFundsException("Insufficient funds for " + itemName);
            }
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
        double total = 0;
        for (T item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void changeBalance(Client client, Restaurant restaurant) {
        restaurant.changeBalance(totalPrice());
        client.changeBalance(totalPrice());
    }

    protected abstract T getItemFromMenu(String itemName);
}
