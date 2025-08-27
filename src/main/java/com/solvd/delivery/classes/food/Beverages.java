package com.solvd.delivery.classes.food;

import com.solvd.delivery.classes.abstracts.AbstractItem;
import com.solvd.delivery.classes.enums.ItemType;

public class Beverages extends AbstractItem {

    private final boolean alcohol;

    public Beverages(String name, double price, boolean alcohol) {
        super(name, price);
        this.alcohol = alcohol;

        setType(ItemType.BEVERAGE);
    }

    public boolean getAlcohol() {
        return alcohol;
    }

}
