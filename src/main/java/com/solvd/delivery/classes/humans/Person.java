package com.solvd.delivery.classes.humans;
import java.util.Objects;

import com.solvd.delivery.classes.enums.HumanType;
import com.solvd.delivery.interfaces.Introduce;

public abstract class Person implements Introduce{

    protected String name;
    protected HumanType humanType;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public abstract void introduce();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public HumanType getHumanType() {
        return humanType;
    }

    public void setHumanType(HumanType humanType) {
        this.humanType = humanType;
    }
}
