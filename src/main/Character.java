package main;

import util.Types;

public class Character {

    private Types type;
    private int health;
    private int power;

    public Character(Types type, int health, int power) {
        this.type = type;
        this.health = health;
        this.power = power;
    }

    public void attack(Character victim) {
        victim.setHealth(victim.getHealth() - power);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }
}
