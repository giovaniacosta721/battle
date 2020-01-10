package main;

import main.enums.Stat;

/**
 * Concrete MoveSet that increases defense value*/
public class Defend extends Move{

    public Defend(String name, Stat stat, double value)
    {
        super(name,stat,value);
    }

    /**
     * Method used to Increase pokemon's defense.
     * @param player1 Pokemon to increase defense.
     * @param player2 Not Used in method but needed since inherited from Move*/
    @Override
    public void action(Player player1, Player player2) {
        player1.getCurrentPokemon().setDefense(player1.getCurrentPokemon().getDefense() + this.getValue());
        System.out.printf("%s used %s\n",player1.getCurrentPokemon().getName(),this.getName());
        System.out.printf("%s increased defense by %.2f\n",player1.getCurrentPokemon().getName(), this.getValue());
    }
    @Override
    public String toString(){
        return "" + this.getName() + "\n\tDefense: " +
                this.getValue();
    }
}
