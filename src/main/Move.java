package main;

import main.enums.Stat;
import main.enums.Type;

public class Move {

    private Type type;
    private Stat stat;
    private double value;
    private double accuracy;
    private double critical;

    public Move(Type type, Stat stat, double value, double accuracy, double critical) {
        this.type = type;
        this.stat = stat;
        this.value = value;
        this.accuracy = accuracy;
        this.critical = critical;
    }

    public void attack(Pokemon pokemon) {
        pokemon.setHealth(pokemon.getHealth() - value);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getCritical() {
        return critical;
    }

    public void setCritical(double critical) {
        this.critical = critical;
    }
}
