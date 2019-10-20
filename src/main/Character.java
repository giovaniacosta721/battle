package main;

import main.enums.AttackType;

public class Character {

    private AttackType type;
    private Modifier mod;
    private double health;
    private double power;

    public Character(AttackType type, double health, double power) {
        this.type = type;
        this.health = health;
        this.power = power;
        this.mod =  new Modifier(1,null);

    }

    public void attack(Character victim) {
        //TODO: Change amount to remove from victim health based on damage modifier.
        victim.setHealth(victim.getHealth() - (power * mod.getValue()));
    }

    public void setModifier(Modifier mod) {
        this.mod = mod;
    }

    public double getHealth() {
        return  health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public AttackType getType() {
        return type;
    }

    public void setType(AttackType type) {
        this.type = type;
    }
}
