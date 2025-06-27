package Classes;

public class Address extends Place {

    private int apartment;

    public Address(String street, int building, int apartment) {
        super(street, building);
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
        return ("Address: " + street + ", " + building + "ap. " + apartment);
    }
}
