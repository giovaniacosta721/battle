package main;

import main.enums.Type;

import java.util.List;

public class Pokemon {

    private String name;
    private double health;
    private Type type;
    private double power;
    private double defense;
    private List<Action> moveList;
    private double original_defense;
    private double max_Health;

    public Pokemon(String name, Type type, double health, double power,double defense) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.power = power;
        this.defense = defense;
        this.original_defense = defense;
        this.max_Health = health;
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
        for (Action move : moveList) {
            rtnString = rtnString + move.getName() + " ";
        }
        return rtnString;
    }

    public double getMax_Health() {
        return max_Health;
    }
    public double getDefense() {
        return defense;
    }

    public double getOriginal_defense() {
        return original_defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
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

    public List<Action> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Action> moveList) {
        this.moveList = moveList;
    }

    public void resetDefense(){
        this.setDefense(this.getOriginal_defense());
    }

}
