package com.solvd.delivery.classes.food;

import com.solvd.delivery.classes.abstracts.AbstractItem;

public class Beverages extends AbstractItem {

    private final boolean alcohol;

    public Beverages(String name, double price, boolean alcohol) {
        super(name, price);
        this.alcohol = alcohol;
    }

    public boolean getAlcohol() {
        return alcohol;
    }

}
