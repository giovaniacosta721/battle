package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Player will be the main source of information in the hierarchy. It contains a list of 6 Pokemons which in turn contain a list of Moves per Pokemon.
 * CurrentPokemon used to keep track of pokemon currently used for the battle.
 * isTurn used to help keep better track of player turn in battleLoop*/
public class Player {

    private String name;
    private Pokemon currentPokemon;
    final private int maxPokemon = 6;
    private boolean isTurn;
    List<Pokemon> pokemons;

    /**
     * Default Constructor used if List of Pokemons has not been created before player.
     * Assumes player has not chosen pokemon yet.
     * @param name the name of the player
     * since curentPokemon is null, will have to set that manualy at time of battle, otherWise will create an error.*/
    public Player(String name){
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.setCurrentPokemon(null);
        this.isTurn = false;
    }
    /**
     * Constructor used assuming that a roster of pokemons has already been created prior to the creation of player.
     * @param  name the name of the player
     * @param pokemons ArrayList of type pokemons. Should be a max of 6
     * sets currentPokemon by default to be the first pokemon of the list*/
    public Player(String name, List<Pokemon> pokemons){
        this.name = name;
        this.pokemons = pokemons;
        this.setCurrentPokemon(pokemons.get(0));
        this.isTurn = false;
    }
    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pokemon getCurrentPokemon() {
        return currentPokemon;
    }

    public void setCurrentPokemon(Pokemon currentPokemon) {
        this.currentPokemon = currentPokemon;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
    /**
     * Used to add a pokemon to player roster. Will only add pokemon if player does not already have 6 pokemon in roster.
     * @param pokemon Pokemon to attempt to add to roster.*/
    public void addPokemon(Pokemon pokemon){
        if(pokemons.size() < maxPokemon)
            pokemons.add(pokemon);
        else
            System.out.println("You already have 6 pokemon.");
    }
}
