package com.solvd.delivery.classes.delivery;

import java.util.ArrayList;

import com.solvd.delivery.classes.abstracts.AbstractCompany;
import com.solvd.delivery.classes.humans.DeliveryPerson;

public class DeliveryCompany extends AbstractCompany {

    public DeliveryCompany(String name, ArrayList<DeliveryPerson> employees) {
        super(name, employees);
    }

    @Override
    public void addEmployee(DeliveryPerson employee) {
        employees.add(employee);
    }
}
