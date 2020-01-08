package main;

import main.enums.Stat;
import main.enums.Type;
/**
 * Move implements Action and defines default getters and setters for name, stat, and value.
 * action() will stay as abstract. This method will be used by move sets to actually do the defined move
 * */
abstract public class Move implements Action{

    private String name;
    private Stat stat;
    private double value;

    public Move(String name, Stat stat, double value) {
        this.name = name;
        this.stat = stat;
        this.value = value;
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
    public Stat getStat() {
        return stat;
    }

    @Override
    public void setStat(Stat stat) {
        this.stat = stat;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    abstract public void action(Player player1, Player player2);


}
