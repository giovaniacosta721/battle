package main;

import main.enums.Stat;
import main.enums.Type;

/**Interface that will be used as basis for different moveSets.*/
public interface Action {

    String getName();
    void setName(String name);
    //Type getType();
    double getValue();
    void setValue(double value);
    Stat getStat();
    void setStat(Stat stat);
    void action(Player player1, Player player2);
}
