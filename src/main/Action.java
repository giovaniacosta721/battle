package main;

import main.enums.Stat;
import main.enums.Type;

/**
 * Interface that will be used as basis for different Pokemon actions. These actions can affect enemy Pokemon stats, the
 * performing Pokemon's stats, or an ally's stats.
 */

public interface Action {

    void action(Player player1, Player player2);
    String toString();

    String getName();
    void setName(String name);

    Type getType();
    void setType(Type type);

    double getValue();
    void setValue(double value);

    Stat getStat();
    void setStat(Stat stat);
}
