package main;

import main.enums.Type;

public class Attack {

    private String name;
    private int power;
    private Type type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }


    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

}
