package main;

import main.enums.Type;

import java.util.List;

public class Pokemon {

    private String name;
    private double health;
    private Type type;
    private double power;
    private List<Move> moveList;


    public Pokemon(String name, Type type, double health, double strength) {
        this.name = name;
        this.type = type;
        this.health = health;
    }

    @Override
    public String toString() {
        return "Pokemon: " + this.name + ", " +
                "Type: " + this.type + ", " +
                "Health: " + this.health + ", "  +
                "Power: " + this.power;
    }

    public String moveListToString() {
        String rtnString = "";
        for (Move move : moveList) {
            rtnString = rtnString + move.getName() + " ";
        }
        return rtnString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

}
