package Classes;
import Iterfaces.ChangeBalance;
import Iterfaces.HasAddress;
import Iterfaces.IsAdult;
import Iterfaces.Payable;

public class Client extends Person implements HasAddress, ChangeBalance, IsAdult, Payable {

    private Address address;
    private double money;
    private int age;

    public Client(String name, Address address, double money, int age) {
        super(name);
        this.address = address;
        this.money = money;
        this.age = age;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public void introduce() {
        System.out.println("New client " + name + " makes an order");
    }

    @Override
    public String toString() {
        return "Client { name = " + name + " }";
    }

    @Override
    public void changeBalance(double price) {
        this.money -= price;
    }

    @Override
    public boolean isAdult() {
        return age >= 18;
    }

    @Override
    public void pay(double amount) {
        if (money >= amount) {
            money -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public double getBalance() {
        return money;
    }
}
