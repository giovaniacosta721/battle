package main;

import main.enums.Stat;

public class Modifier {

    private double value;
    private Stat stat;

    public Modifier(double value, Stat stat) {
        this.value = value;
        this.stat = stat;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
