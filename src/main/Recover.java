package main;

import main.enums.Stat;

/**
 * Concrete MoveSet that increases health*/
public class Recover extends Move {

    public Recover(String name, Stat stat, double value){
        super(name, stat,value);
    }

    /**
     * Overriden from Move. Used to increase pokemon health. Checks to see if the increase in health will go past pokemon max health,
     * if it does, it will set health to max health.
     * Otherwise, will increase health by move's value.
     * @param player1 player who initiated health recovery.
     * @param player2 Not Used in method but necessary since inherited from Move*/
    @Override
    public void action(Player player1, Player player2) {
        double healing = this.getValue();
        double health = player1.getCurrentPokemon().getHealth();
        healing = Math.min(health + healing, player1.getCurrentPokemon().getMax_Health());
        System.out.printf("%s used %s\n", player1.getCurrentPokemon().getName(), this.getName());
        if(healing == player1.getCurrentPokemon().getMax_Health())
        {
            System.out.printf("%s fully recovered!\n",player1.getCurrentPokemon().getName());
        }
        else if(healing < player1.getCurrentPokemon().getMax_Health()){
            System.out.printf("%s recovered %.2f points of health!\n",player1.getCurrentPokemon().getName(),this.getValue());
        }
        player1.getCurrentPokemon().setHealth(healing);
    }
    @Override
    public String toString(){
        return "" + this.getName() + "\n\tRecover: " +
                this.getValue();
    }
}
