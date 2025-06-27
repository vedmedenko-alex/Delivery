package Classes;

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
