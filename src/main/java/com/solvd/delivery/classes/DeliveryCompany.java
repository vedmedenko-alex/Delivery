package main.java.com.solvd.delivery.classes;

import java.util.ArrayList;

public class DeliveryCompany extends AbstractCompany {

    public DeliveryCompany(String name, ArrayList<DeliveryPerson> employees) {
        super(name, employees);
    }

    @Override
    public void addEmployee(DeliveryPerson employee) {
        employees.add(employee);
    }
}
