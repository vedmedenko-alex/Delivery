package Classes;

public class DeliveryPerson extends Person {

    public DeliveryPerson(String name) {
        super(name);
    }

    @Override
    public void introduce() {
        System.out.println("New delivery guy" + name);
    }

    @Override
    public String toString() {
        return "DeliveryPerson { name = " + name + " }";
    }

}
