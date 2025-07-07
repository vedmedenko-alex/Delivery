package com.solvd.delivery.classes.abstracts;

import java.util.HashSet;
import java.util.Set;

import com.solvd.delivery.classes.humans.DeliveryPerson;

public abstract class AbstractCompany<T extends DeliveryPerson> {

    protected String name;
    protected Set<T> employees;

    public AbstractCompany(String name, Set<T> employees) {
        this.name = name;
        this.employees = (employees != null) ? employees : new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<T> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<T> employees) {
        this.employees = employees;
    }

    public abstract void addEmployee(T employee);
}
