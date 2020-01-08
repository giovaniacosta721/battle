package main;

import main.enums.Stat;
import main.enums.Type;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    /*Pokemon userPokemon = null;
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
    );*/
    Scanner scanner = new Scanner(System.in);
    Player player1 = new Player("Player 1");
    Player player2 = new Player("Player 2");

    Pokemon bulbasaur = new Pokemon("Bulbasaur",Type.Grass,150,50,10);
    Pokemon charmander = new Pokemon("Charmander", Type.Fire, 200,75,5);
    Pokemon squirtle = new Pokemon("Squirtle", Type.Water,100,20, 20);


    List<Action> bulbasaurMoveList = List.of(
            new Attack("Vine Whip", Stat.Damage,50,Type.Water,50,50),
            new Attack("Razor Leaf",Stat.Damage, 10, Type.Water,90,50),
            new Defend("Seed Bomb",Stat.Defense,15),
            new Recover("Solar Beam", Stat.Recovery,25)
    );
    List<Action> charmanderMoveList = List.of(
            new Attack("Ember", Stat.Damage,50,Type.Water,50,50),
            new Attack("Flame Thrower",Stat.Damage, 10, Type.Water,90,100),
            new Defend("Fire Spin",Stat.Defense,15),
            new Recover("Inferno", Stat.Recovery,25)
    );
    List<Action> squirtleMoveList = List.of(
            new Attack("Water Gun", Stat.Damage,50,Type.Water,50,50),
            new Attack("Water Fall",Stat.Damage, 10, Type.Water,90,50),
            new Defend("Surf",Stat.Defense,15),
            new Recover("Bubble", Stat.Recovery,25)
    );


    Random random = new Random();

    public void battle() {
        //Print line to choose Pokemon
        System.out.println("Choose your Pokemon:");
        System.out.println("Bulbasaur, Charmander, Squirtle");

        //Read in user input
        String input;
        input = scanner.nextLine();

        createPokemon(input);

        battleBeginSummary(player1, player2);

        battleLoop();

        endBattle();

    }

    /**
     * Will create the Pokemon specified by user input.
     * @param input User-input String. Must be spelled and capitalized correctly.
     */

    private void createPokemon(String input) {
        while (player1.getCurrentPokemon() == null || player2.getCurrentPokemon() == null) {
            if (input.equals("Bulbasaur")) {
                player1.addPokemon(bulbasaur);
                player1.setCurrentPokemon(bulbasaur);
                bulbasaur.setMoveList(bulbasaurMoveList);
                player2.addPokemon(charmander);
                player2.setCurrentPokemon(charmander);
                charmander.setMoveList(charmanderMoveList);
            } else if (input.equals("Charmander")) {
                player1.addPokemon(charmander);
                player1.setCurrentPokemon(charmander);
                charmander.setMoveList(charmanderMoveList);
                player2.addPokemon(squirtle);
                player2.setCurrentPokemon(squirtle);
                squirtle.setMoveList(squirtleMoveList);
            } else if (input.equals("Squirtle")) {
                player1.addPokemon(squirtle);
                player1.setCurrentPokemon(squirtle);
                squirtle.setMoveList(squirtleMoveList);
                player2.addPokemon(bulbasaur);
                player2.setCurrentPokemon(bulbasaur);
                bulbasaur.setMoveList(bulbasaurMoveList);
            } else {
                System.out.println("Please re-enter Pokemon name.");
                input = scanner.nextLine();
            }
        }
    }

    private void battleBeginSummary(Player player, Player player2) {
        System.out.println("Player");
        System.out.println(player.getCurrentPokemon().toString());
        System.out.println("Enemy");
        System.out.println(player2.getCurrentPokemon().toString());
    }

    /**
     * Main battle loop. Will break out of the method when player or enemy Pokemon health reaches zero.
     */

    private void battleLoop() {
        String input;
        Action playerMove;
        player1.setTurn(true);
        while (player1.getCurrentPokemon().getHealth() > 0 && player2.getCurrentPokemon().getHealth() > 0) {
            if (player1.isTurn()) {
                System.out.println("Player Turn");
                System.out.println(
                        player1.getCurrentPokemon().getMoveList().get(0).getName() + ", " +
                        player1.getCurrentPokemon().getMoveList().get(1).getName() + ", " +
                        player1.getCurrentPokemon().getMoveList().get(2).getName() + ", " +
                        player1.getCurrentPokemon().getMoveList().get(3).getName()
                );
                input = scanner.nextLine();
                playerMove = checkMove(input);
                if (playerMove == null) {
                    System.out.println("Please re-enter the move name.");
                } else {
                   playerMove.action(player1,player2);
                   player1.setTurn(false);
                   display();
                }
            } else if (!player1.isTurn()) {
                System.out.println("Enemy Turn");
                playerMove = player2.getCurrentPokemon().getMoveList().get(random.nextInt(4));
                playerMove.action(player2,player1);
                player1.setTurn(true);
                display();
            }
        }
    }

    private Action checkMove(String playerMove) {
        for (Action move : player1.getCurrentPokemon().getMoveList()) {
            if (playerMove.equals(move.getName())) {
                return move;
            }
        }
        return null;
    }

    private void endBattle() {
        if (player1.getCurrentPokemon().getHealth() <= 0) {
            System.out.println("Enemy player won!");
        } else if (player2.getCurrentPokemon().getHealth() <= 0) {
            System.out.println("You won!");
        }
    }

    /*Created display for own personal testing to see current health of player 1 pokemon and player 2 pokemon*/
    public void display(){
        System.out.println("User Pokemon Health: " + player1.getCurrentPokemon().getHealth());
        System.out.println("Enemy Pokemon Health: " + player2.getCurrentPokemon().getHealth());
    }
}
