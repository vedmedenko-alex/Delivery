package com.solvd.delivery.classes.food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.delivery.App;
import com.solvd.delivery.classes.abstracts.AbstractItem;

public class Menu<T extends AbstractItem> {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    private ArrayList<T> storage;
    private final Map<String, Double> dishPrices = new HashMap<>();
    private TreeMap<Double, String> dishRate = new TreeMap<>();

    public Menu(T... dishes) {
        this.storage = new ArrayList<>();

        for (T dish : dishes) {
            this.storage.add(dish);
            this.dishPrices.put(dish.getName(), dish.getPrice());
            this.dishRate.put(dish.getPrice(), dish.getName());
        }
    }

    public void addDish(T dish) {
        dishPrices.put(dish.getName(), dish.getPrice());
        dishRate.put(dish.getPrice(), dish.getName());
    }

    public void setDishes(T... dishes) {
        dishPrices.clear();
        dishRate.clear();
        for (T dish : dishes) {
            dishPrices.put(dish.getName(), dish.getPrice());
            dishRate.put(dish.getPrice(), dish.getName());
        }
    }

 
    public T getDish(String name) {
        for (T dish : storage) {
            if (dish.getName().equals(name)) {
                return dish;
            }
        }
        return null;
    }

    public Double getPrice(String dishName) {
        return dishPrices.get(dishName);
    }

    public String getMostExpensiveDishName() {
        return dishRate.lastEntry().getValue();
    }

    public String getCheapestDishName() {
        return dishRate.firstEntry().getValue();
    }    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu: \n");
        for (T dish : storage) {
            sb.append(" - ").append(dish.getName()).append("\n");
        }
        return sb.toString();
    }


    public void printMenu() {
        logger.info("Menu:");
        for (Map.Entry<String, Double> entry : dishPrices.entrySet()) {
            logger.info(entry.getKey() + " " + entry.getValue()); 
        }
    }

    public void printOrderedMenu() {
        logger.info("Menu ordered by price:");
        for (Entry<Double, String> entry : dishRate.entrySet()) {
            logger.info(entry.getKey() + " " + entry.getValue()); 
        }
    }
}
