package Classes;

public class Order extends AbstractOrder<Food> {

    public Order(Client client, Restaurant restaurant) {
        super(client, restaurant);
    }

    @Override
    protected Food getItemFromMenu(String foodName) {
        return restaurant.getMenu().getDish(foodName);
    }
}
