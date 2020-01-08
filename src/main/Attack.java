package main;

import main.enums.Stat;
import main.enums.Type;

import java.util.Random;
/**
 * Concrete moveSet. Inherits from Move and adds critical multiplier, accuracy, and type.
 * Attack will always be of Stat.Damage.
 * */
public class Attack extends Move{
    private double critical;
    private double accuracy;
    private Type type;
    Random random = new Random();
    public Attack(String name, Stat stat, double value,Type type, double critical, double accuracy){
        super(name, stat, value);
        this.type = type;
        this.critical = critical;
        this.accuracy = accuracy;
    }
    public double getCritical() {
        return critical;
    }

    public void setCritical(double critical) {
        this.critical = critical;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public Type getType() {
        return type;
    }

    /**Calculates final damage based on formula base * (1 + critical + sameTypeBonus + powerLevel).
     * critical, STB, powerLevel will all be values less than 1.0
     * @param player player that initiated attack. Used to get powerLevel*/
    private double calculateDamage(Player player)
    {
        double damage = 0.0;
        damage = this.getValue() * (1+(crit() + SameTypeBonus(player) + (player.getCurrentPokemon().getPower()/100)));
        if((random.nextInt(99)+1) >= (100-this.getAccuracy()))
            return damage;
        else {
            return 0.0;
        }
    }
    /**Calculates critical multiplier based on accuracy.
     * Accuracy / 2 to prevent critical from occurring often. Makes Max chance at occurring 50%*/
    private double crit(){
        double critical = this.getCritical();
        if(random.nextInt(100) >= (100-(this.getAccuracy()/2))) {
            return (critical / 100.0);
        }
        else
            return 0.0;
    }
    /**
     * Calculates bonus damage if move type matches pokemon type
     * Bonus damage based on 0.1 starting bonus + pokemon powerlevel/100*/
    private double SameTypeBonus(Player player)
    {
        double STB = 0.0;
        if(this.getType().equals(player.getCurrentPokemon().getType()))
        {
            STB = 0.1 + (player.getCurrentPokemon().getPower()/100);
        }
        return STB;
    }

    /**
     * Method that attacks enemy pokemon. Calls calc_Damage to determine the damage that will be done to the enemy pokemon.
     * if damage returns at 0.0, this means the pokemon missed based on random generator and accuracy.
     * else removes enemy defense from total damage. At this point if damage is 0.0, this means that the enemy pokemon was greater that
     * players attack.
     * else sets enemy pokemons health - damage
     * Resets enemy's defense at end of attack temporarily until eventHandler is created to handle defense resets.
     * @param player1 player who initiated attack
     * @param player2 enemy player who is being attacked*/
    @Override
    public void action(Player player1, Player player2) {
        double damage = 0.0;
        System.out.printf("%s used %s\n",player1.getCurrentPokemon().getName(), this.getName());
        damage = calculateDamage(player1);
        if(damage == 0.0){
            System.out.printf("%s Missed!\n",player1.getCurrentPokemon().getName());
        }
        else if(damage > 0.0) {
            damage = damage - player2.getCurrentPokemon().getDefense();
            damage = Math.max(damage, 0.0);
            if (damage > 0.0) {
                System.out.printf("%s did %.2f points of damage\n", player1.getCurrentPokemon().getName(), damage);
                player2.getCurrentPokemon().setHealth(player2.getCurrentPokemon().getHealth() - damage);
            }
            else {
                System.out.printf("%s was not effective!\n", this.getName());
            }
        }
        player2.getCurrentPokemon().resetDefense();
    }
}
