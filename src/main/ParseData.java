package main;

import main.enums.Stat;
import main.enums.Type;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ParseData {
    //private Node data;
    private String fireSource = "src/main/Pokemon_Data/Types/Fire_Type";
    private String waterSource = "src/main/Pokemon_Data/Types/Water_Type";
    private String grassSource = "src/main/Pokemon_Data/Types/Grass_Type";
    private List<Node> data;
    private List<Action> moveList = new ArrayList<>();
    private Node temp = new Node();
    private Pokemon pokemon;


    public ParseData() throws FileNotFoundException {
        File pokemon = new File("src/main/Pokemon_Data/Pokemon");
        Scanner sc = new Scanner(pokemon);
        data = new ArrayList<>();
        sc.nextLine();
        while(sc.hasNextLine())
        {
            temp.name = sc.next();
            temp.type = getType(sc.next());
            data.add(temp);
            temp = new Node();
        }
        sc.close();
        display();
    }
    public void pokemonSetup(Player player, String input) throws FileNotFoundException {
        int index = 0;
        for(int i = 0; i<data.size(); i++){
            if(input.equals(data.get(i).name)){
                index = i;
                switch (data.get(index).type){
                    case Fire:{
                        player.addPokemon(createPokemon(fireSource,index));
                        break;
                    }
                    case Water:{
                        player.addPokemon(createPokemon(waterSource,index));
                        break;
                    }
                    case Grass:{
                        player.addPokemon(createPokemon(grassSource,index));
                        break;
                    }
                }
                break;
            }
        }

    }
    private Pokemon createPokemon(String source,int index) throws FileNotFoundException {
        File cp = new File(source);
        Scanner sc = new Scanner(cp);
        String temp;
        String[] pokemonData = null;
        sc.nextLine();
        while(sc.hasNextLine()){
            temp = sc.nextLine();
            pokemonData = temp.split(" ");
            if(pokemonData[0].equals(data.get(index).name)){
                pokemon = new Pokemon(pokemonData[0],data.get(index).type,
                        Double.parseDouble(pokemonData[1]),
                        Double.parseDouble(pokemonData[3]),
                        Double.parseDouble(pokemonData[2]));
                pokemon.setMoveList(setMoves(pokemonData[4]));
                break;
            }
        }
        sc.close();
        return pokemon;
    }
    private void prepareMoveList(String source) throws FileNotFoundException {
        File moveListfile = new File(source);
        Scanner read = new Scanner(moveListfile);
        String temp;
        read.nextLine();
        while(read.hasNextLine()){
            temp = read.nextLine();
            String[] moveData = temp.split(" ");
            moveData[1] = moveData[1].replace('-',' ');
            switch (moveData[0]){
                case "Damage":{
                    moveList.add(new Attack(moveData[1],Stat.Damage,Double.parseDouble(moveData[2]),getType(moveData[3]),
                            Double.parseDouble(moveData[4]),Double.parseDouble(moveData[5])));
                    break;
                }
                case "Defend":{
                    moveList.add(new Defend(moveData[1],Stat.Defense,Double.parseDouble(moveData[2])));
                    break;
                }
                case "Recovery":{
                    moveList.add(new Recover(moveData[1],Stat.Recovery,Double.parseDouble(moveData[2])));
                    break;
                }
                default:
                    break;
            }
            moveData = null;
        }
        read.close();
    }
    private List<Action> setMoves(String source) throws FileNotFoundException {
        List<Action> action = new ArrayList<>();
        prepareMoveList(source);
        Collections.shuffle(moveList);
        for(int i=0; i<moveList.size() && i<4; i++){
            action.add(moveList.get(i));
        }
        return action;
    }

    private Type getType(String input){
        switch (input){
            case "Fire": {
                return Type.Fire;
            }
            case "Water":{
                return Type.Water;
            }
            case "Grass":{
                return Type.Grass;
            }
            default:
                return null;
        }
    }
    private void display(){
        for(int i = 0; i<data.size(); i++){
            System.out.println(data.get(i).name);
        }

    }
    public class Node{
        protected String name;
        protected Type type;
    }
}
