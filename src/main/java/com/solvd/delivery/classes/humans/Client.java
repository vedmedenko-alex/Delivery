package com.solvd.delivery.classes.humans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.delivery.App;
import com.solvd.delivery.classes.places.Address;
import com.solvd.delivery.exceptions.InsufficientFundsException;
import com.solvd.delivery.exceptions.IsAdultException;
import com.solvd.delivery.interfaces.ChangeBalance;
import com.solvd.delivery.interfaces.HasAddress;
import com.solvd.delivery.interfaces.IsAdult;
import com.solvd.delivery.interfaces.Payable;

public class Client extends Person implements HasAddress, ChangeBalance, IsAdult, Payable {

    private static final Logger logger = LoggerFactory.getLogger(App.class);
    
    private Address address;
    private double money;
    private final int age;

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
        logger.info("New client " + name + " makes an order");
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
    public void isAdult() throws IsAdultException {
        if (age < 18) {
            throw new IsAdultException("Client " + name + " is not adult!");
        }
    }

    @Override
    public void pay(double amount) throws InsufficientFundsException{
        if (money >= amount) {
            money -= amount;
        } else {
            throw new InsufficientFundsException("Not enough balance to pay " + amount);
        }
    }

    @Override
    public double getBalance() {
        return money;
    }
}
