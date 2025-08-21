package com.solvd.delivery.classes.places;

import com.solvd.delivery.classes.enums.PlaceType;

public abstract class Place {

    protected String city;
    protected String street;
    protected int building;
    protected double latitude;
    protected double longitude;
    private PlaceType placeType;

    public Place(String city, String street, int building, double latitude, double longitude) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public abstract String typeAddress();

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
    }
}
