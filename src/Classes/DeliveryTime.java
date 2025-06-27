package Classes;

public class DeliveryTime {

    public int deliveryTime(Address clientAddress, Address restaurantAddress) {
        if (clientAddress.getStreet().equals(restaurantAddress.getStreet())) {
            return 15;
        }
        return 30;
    }
}
