package com.solvd.delivery.interfaces.functionalInterfaces;

import com.solvd.delivery.classes.places.Address;

@FunctionalInterface
public interface DistanceCalculator {

    double calculate(Address a1, Address a2);
}
