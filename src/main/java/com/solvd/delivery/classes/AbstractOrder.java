package main.java.com.solvd.delivery.classes;

import java.util.ArrayList;

import main.java.com.solvd.delivery.interfaces.Payable;

public abstract class AbstractOrder<T extends AbstractItem> {

    protected Client client;
    protected Restaurant restaurant;
    protected ArrayList<T> items = new ArrayList<>();

    public AbstractOrder(Client client, Restaurant restaurant) {
        this.client = client;
        this.restaurant = restaurant;
    }

    // public void addItem(String itemName) {
    //     T item = getItemFromMenu(itemName);
    //     if (item != null) {
    //         items.add(item);
    //     }
    // }

    public void addItem(String itemName) {
        if (!(client instanceof Payable)) {
            System.out.println("Client is not eligible to pay.");
            return;
        }

        T item = getItemFromMenu(itemName);
        if (item != null) {
            Payable payableClient = (Payable) client;
            if (payableClient.getBalance() >= item.getPrice()) {
                items.add(item);
                payableClient.pay(item.getPrice());
                restaurant.changeBalance(item.getPrice());
                System.out.println(itemName + " added to order.");
            } else {
                System.out.println("Insufficient funds for " + itemName);
            }
        } else {
            System.out.println(itemName + " not found in menu.");
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
