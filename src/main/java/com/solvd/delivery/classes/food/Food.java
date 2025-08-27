package com.solvd.delivery.classes.food;

import com.solvd.delivery.classes.abstracts.AbstractItem;
import com.solvd.delivery.classes.enums.ItemType;

public class Food extends AbstractItem {

    public Food(String name, double price) {
        super(name, price);

        setType(ItemType.FOOD);
    }
}
