package com.solvd.delivery.classes.delivery;

import java.util.Set;

import com.solvd.delivery.classes.abstracts.AbstractCompany;
import com.solvd.delivery.classes.humans.DeliveryPerson;

public class DeliveryCompany extends AbstractCompany {

    public DeliveryCompany(String name, Set<DeliveryPerson> employees) {
        super(name, employees);
    }

    @Override
    public void addEmployee(DeliveryPerson employee) {
        employees.add(employee);
    }
}
