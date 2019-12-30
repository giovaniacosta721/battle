package main;

import main.enums.Stat;
import main.enums.Type;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Battle {

    Scanner scanner = new Scanner(System.in);
    Pokemon userPokemon = null;
    Pokemon enemyPokemon = null;
    Pokemon bulbasaur = this.userPokemon = new Pokemon("Bulbasaur", Type.Grass, 150, 50);
    Pokemon charmander = this.userPokemon = new Pokemon("Charmander", Type.Fire, 75, 150);
    Pokemon squirtle = this.userPokemon = new Pokemon("Squirtle", Type.Water, 100, 75);
    List<Move> bulbasaurMoveList = List.of(
            new Move("Vine Whip", Type.Water, Stat.Damage, 50.0, 50.0, 50.0),
            new Move("Razor Leaf", Type.Water, Stat.Damage, 10.0, 90.0, 50.0),
            new Move("Seed Bomb", Type.Water, Stat.Damage, 70.0, 05.0, 50.0),
            new Move("Solar Beam", Type.Water, Stat.Damage, 20.0, 50.0, 50.0)
            );
    List<Move> charmanderMoveList = List.of(
            new Move("Ember", Type.Water, Stat.Damage, 50.0, 50.0, 50.0),
            new Move("Flamethrower", Type.Water, Stat.Damage, 10.0, 90.0, 50.0),
            new Move("Fire Spin", Type.Water, Stat.Damage, 70.0, 05.0, 50.0),
            new Move("Inferno", Type.Water, Stat.Damage, 20.0, 50.0, 50.0)
    );
    List<Move> squirtleMoveList = List.of(
            new Move("Water Gun", Type.Water, Stat.Damage, 50.0, 50.0, 50.0),
            new Move("Waterfall", Type.Water, Stat.Damage, 10.0, 90.0, 50.0),
            new Move("Surf", Type.Water, Stat.Damage, 70.0, 05.0, 50.0),
            new Move("Bubble", Type.Water, Stat.Damage, 20.0, 50.0, 50.0)
    );

    boolean playerTurn = true;
    Random random = new Random();

    public void battle() {
        //Print line to choose Pokemon
        System.out.println("Choose your Pokemon:");
        System.out.println("Bulbasaur, Charmander, Squirtle");

        //Read in user input
        String input;
        input = scanner.nextLine();

        createPokemon(input);

        battleBeginSummary(userPokemon, enemyPokemon);

        battleLoop();

        endBattle();

    }

    /**
     * Will create the Pokemon specified by user input.
     * @param input User-input String. Must be spelled and capitalized correctly.
     */

    private void createPokemon(String input) {
        while (userPokemon == null || enemyPokemon == null) {
            if (input.equals("Bulbasaur")) {
                userPokemon = bulbasaur;
                userPokemon.setMoveList(bulbasaurMoveList);
                enemyPokemon = charmander;
                enemyPokemon.setMoveList(charmanderMoveList);
            } else if (input.equals("Charmander")) {
                userPokemon = charmander;
                userPokemon.setMoveList(charmanderMoveList);
                enemyPokemon = squirtle;
                enemyPokemon.setMoveList(squirtleMoveList);
            } else if (input.equals("Squirtle")) {
                userPokemon = squirtle;
                userPokemon.setMoveList(squirtleMoveList);
                enemyPokemon = bulbasaur;
                enemyPokemon.setMoveList(bulbasaurMoveList);
            } else {
                System.out.println("Please re-enter Pokemon name.");
            }
        }
    }

    private void battleBeginSummary(Pokemon userPokemon, Pokemon enemyPokemon) {
        System.out.println("Player");
        System.out.println(userPokemon.toString());
        System.out.println("Enemy");
        System.out.println(enemyPokemon.toString());
    }

    /**
     * Main battle loop. Will break out of the method when player or enemy Pokemon health reaches zero.
     */

    private void battleLoop() {
        String input;
        Move playerMove;
        while (userPokemon.getHealth() > 0 && enemyPokemon.getHealth() > 0) {
            if (playerTurn) {
                System.out.println("Player Turn");
                System.out.println(
                        userPokemon.getMoveList().get(0).getName() + ", " +
                        userPokemon.getMoveList().get(1).getName() + ", " +
                        userPokemon.getMoveList().get(2).getName() + ", " +
                        userPokemon.getMoveList().get(3).getName()
                );
                input = scanner.nextLine();
                playerMove = checkMove(input, userPokemon.getMoveList());
                if (playerMove == null) {
                    System.out.println("Please re-enter the move name.");
                } else {
                    playerMove.attack(enemyPokemon);
                    playerTurn = false;
                }
            } else if (!playerTurn) {
                System.out.println("Enemy Turn");
                playerMove = enemyPokemon.getMoveList().get(random.nextInt(4));
                playerMove.attack(userPokemon);
                playerTurn = true;
            }
        }
    }

    private Move checkMove(String playerMove, List<Move> moveList) {
        for (Move move : moveList) {
            if (playerMove.equals(move.getName())) {
                return move;
            }
        }
        return null;
    }

    private void endBattle() {
        if (userPokemon.getHealth() <= 0) {
            System.out.println("Enemy player won!");
        } else if (enemyPokemon.getHealth() <= 0) {
            System.out.println("You won!");
        }
    }

}
