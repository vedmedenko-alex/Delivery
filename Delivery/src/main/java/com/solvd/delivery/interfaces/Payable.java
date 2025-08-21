package com.solvd.delivery.interfaces;

import com.solvd.delivery.exceptions.InsufficientFundsException;

public interface Payable {
    void pay(double amount) throws InsufficientFundsException;
    double getBalance();
}
