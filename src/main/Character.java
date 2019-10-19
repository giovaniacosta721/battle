package main;

import main.enums.AttackType;

public class Character {

    private AttackType type;
    private Modifier mod;
    private int health;
    private int power;

    public Character(AttackType type, int health, int power) {
        this.type = type;
        this.health = health;
        this.power = power;
    }

    public void attack(Character victim) {
        //TODO: Change amount to remove from victim health based on damage modifier.
        victim.setHealth(victim.getHealth() - power);
    }

    public void setModifier(Modifier mod) {
        this.mod = mod;
    }

    public int getHealth() {
        return health + 100;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public AttackType getType() {
        return type;
    }

    public void setType(AttackType type) {
        this.type = type;
    }
}
