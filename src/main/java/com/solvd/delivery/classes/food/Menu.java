package com.solvd.delivery.classes.food;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

    private ArrayList<Food> dishes;

    public Menu(Food... dishes) {
        this.dishes = new ArrayList<>(Arrays.asList(dishes));
    }

    public void addDish(Food dish) {
        dishes.add(dish);
    }

    public void setDish(ArrayList<Food> dishes) {
        this.dishes = dishes;
    }

    public Food getDish(String name) {
        for (Food dish : dishes) {
            if (dish.getName().equals(name)) {
                return dish;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu: \n");
        for (Food dish : dishes) {
            sb.append(" - ").append(dish.getName()).append("\n");
        }
        return sb.toString();
    }
}
