package com.solvd.delivery.interfaces.functionalInterfaces;

import com.solvd.delivery.classes.food.Beverages;

@FunctionalInterface
public interface IsAlcoholic {
    boolean check(Beverages beverage);
}
