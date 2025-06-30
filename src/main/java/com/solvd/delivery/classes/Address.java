package com.solvd.delivery.classes;

public class Address extends Place {

    private int apartment;

    public Address(String city, String street, int building, int apartment, double latitude, double longitude) {
        super(city, street, building, latitude, longitude);
        this.apartment = apartment;
    }


    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public String typeAddress() {
        return ("City: " + city + ", " + "Address: " + street + ", " + building + "ap. " + apartment);
    }
}
