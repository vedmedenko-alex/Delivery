package com.solvd.delivery.classes.humans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.delivery.App;

public class DeliveryPerson extends Person {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public DeliveryPerson(String name) {
        super(name);
    }

    @Override
    public void introduce() {
        logger.info("New delivery guy " + name);
    }

    @Override
    public String toString() {
        return "DeliveryPerson { name = " + name + " }";
    }

}
