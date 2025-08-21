package com.solvd.delivery.classes.delivery;

import com.solvd.delivery.classes.places.Address;
import com.solvd.delivery.exceptions.DiffCityException;
import com.solvd.delivery.interfaces.functionalInterfaces.DistanceCalculator;

public class DeliveryTime {

    private final DistanceCalculator calculator;

    public DeliveryTime(DistanceCalculator calculator) {
        this.calculator = calculator;
    }
    
    public int deliveryTime(Address clientAddress, Address restaurantAddress) throws DiffCityException {
        if (clientAddress.city().equals(restaurantAddress.city())) {
            // double distance = Math.sqrt(Math.pow(restaurantAddress.getLatitude() - clientAddress.getLatitude(),2) + Math.pow(restaurantAddress.getLongitude() - clientAddress.getLongitude(),2));
            double distance = calculator.calculate(clientAddress, restaurantAddress);
            if (distance >= 100) {
                return 15;
            } else {
                return 30;
            }
        } else {
            throw new DiffCityException("Delivery isn't availiable in your city");
        }
    }
}
