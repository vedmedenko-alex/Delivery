package com.solvd.delivery.classes;

import com.solvd.delivery.exceptions.DiffCityException;

public class DeliveryTime {

    public int deliveryTime(Address clientAddress, Address restaurantAddress) throws DiffCityException {
        if (clientAddress.getCity().equals(restaurantAddress.getCity())) {
            double distance = Math.sqrt(Math.pow(restaurantAddress.getLatitude() - clientAddress.getLatitude(),2) + Math.pow(restaurantAddress.getLongitude() - clientAddress.getLongitude(),2));
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
