package main.java.com.solvd.delivery.classes;

public abstract class Place {

    protected String street;
    protected int building;

    public Place(String street, int building) {
        this.street = street;
        this.building = building;
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

    public abstract String typeAddress();
}
