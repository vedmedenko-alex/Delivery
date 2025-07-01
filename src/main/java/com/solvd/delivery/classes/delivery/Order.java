package com.solvd.delivery.classes.delivery;

import com.solvd.delivery.classes.abstracts.AbstractOrder;
import com.solvd.delivery.classes.food.Food;
import com.solvd.delivery.classes.humans.Client;
import com.solvd.delivery.classes.places.Restaurant;

public class Order extends AbstractOrder<Food> {

    public Order(Client client, Restaurant restaurant) {
        super(client, restaurant);
    }

    @Override
    protected Food getItemFromMenu(String foodName) {
        return restaurant.getMenu().getDish(foodName);
    }
}
