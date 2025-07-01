package com.solvd.delivery.classes.abstracts;

import java.util.ArrayList;

import com.solvd.delivery.classes.humans.DeliveryPerson;

public abstract class AbstractCompany {

    protected String name;
    protected ArrayList<DeliveryPerson> employees;

    public AbstractCompany(String name, ArrayList<DeliveryPerson> employees) {
        this.name = name;
        this.employees = (employees != null) ? employees : new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<DeliveryPerson> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<DeliveryPerson> employees) {
        this.employees = employees;
    }

    public abstract void addEmployee(DeliveryPerson employee);
}
