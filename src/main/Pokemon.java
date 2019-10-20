package main;

import main.enums.Type;

public class Pokemon {

    private Type type;
    private double health;
    private double power;

    public Pokemon(Type type, double health, double strength) {
        this.type = type;
        this.health = health;
    }

    public double getHealth() {
        return  health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
