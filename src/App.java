import Classes.Address;
import Classes.Client;
import Classes.Delivery;
import Classes.DeliveryCompany;
import Classes.DeliveryPerson;
import Classes.DeliveryTime;
import Classes.Food;
import Classes.Menu;
import Classes.Order;
import Classes.Restaurant;

public class App {

    public static void main(String[] args) throws Exception {

        Address clientAddress = new Address("Home str.", 23, 1);
        Address restaurantAddress = new Address("Food str.", 10, 1);
        System.out.println(restaurantAddress.typeAddress());

        Food homeDish1 = new Food("Bograch", 50);
        Food homeDish2 = new Food("Varenyki", 30);

        Menu homeMenu = new Menu(homeDish1, homeDish2);
        System.out.println(homeMenu.toString());

        Client client = new Client("Bob", clientAddress, 50, 33); //Play with money, delivery will be canceled if not enough money
        if (client.isAdult()) {
            System.out.println("Allowed to oder alcohol");
        } else {
            System.out.println("Client is underage.");
        }
        System.out.println(client.toString());
        client.introduce();
        Restaurant restaurant = new Restaurant("Home Dishes", restaurantAddress, homeMenu);
        System.out.println(restaurant.toString());

        Order order = new Order(client, restaurant);
        order.addItem("Bograch");
        order.addItem("Varenyki");

        DeliveryCompany company = new DeliveryCompany("Flash Delivery", null);
        DeliveryPerson person = new DeliveryPerson("Barry Alen");
        if (person.equals(client)) {
            System.out.println("Delivery guy and the client can't be the same person");
        } else {
            System.out.println("Delivery guy is approved");
        }        
        System.out.println(person.toString());
        person.introduce();
        company.addEmployee(person);

        DeliveryTime delTime = new DeliveryTime();
        int time = delTime.deliveryTime(clientAddress, restaurantAddress);
        double price = order.totalPrice();

        Delivery delivery = new Delivery(order, person, price, time);

        System.out.println(delivery.toString());
    }
}
