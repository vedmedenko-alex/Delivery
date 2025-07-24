package com.solvd.delivery.interfaces.functionalInterfaces;

import com.solvd.delivery.classes.humans.Client;
import com.solvd.delivery.classes.places.Restaurant;

@FunctionalInterface
public interface BalanceUpdater {

    void update(Client client, Restaurant restaurant, double amount);
}
