package com.solvd.delivery.classes.humans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.delivery.App;
import com.solvd.delivery.classes.enums.HumanType;

public class DeliveryPerson extends Person {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public DeliveryPerson(String name) {
        super(name);
        setHumanType(HumanType.DELIVERY_PERSON);
    }

    @Override
    public void introduce() {
        logger.info("New " + humanType + " " + name);
    }

    @Override
    public String toString() {
        return humanType +" { name = " + name + " }";
    }

}
