package com.solvd.delivery.classes.abstracts;

import com.solvd.delivery.classes.enums.ItemType;

public abstract class AbstractItem {

    protected String name;
    protected double price;
    private ItemType type;

    public AbstractItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
