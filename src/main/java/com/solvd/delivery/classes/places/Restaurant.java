package com.solvd.delivery.classes.places;

import com.solvd.delivery.interfaces.HasAddress;
import com.solvd.delivery.classes.food.Menu;
import com.solvd.delivery.interfaces.ChangeBalance;
import com.solvd.delivery.interfaces.Introduce;

public class Restaurant implements HasAddress, Introduce, ChangeBalance {

    private String name;
    private Address address;
    private Menu menu;
    private double income = 0;

    public Restaurant(String name, Address address, Menu menu) {
        this.name = name;
        this.address = address;
        this.menu = menu;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public void setAddress(Address address) {
        this.address = address;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void introduce() {
        System.out.println("New Restaurant " + name + " is opened");
    }

    @Override
    public String toString() {
        return "Restaurant " + name + " { " + address.typeAddress() + " }";
    }

    @Override
    public void changeBalance(double price) {
        this.income += price;
    }
}
