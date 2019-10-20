package test;

import main.Move;
import main.Pokemon;
import main.enums.Stat;
import main.enums.Type;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MoveTest {

    private Move move;
    private Pokemon victim;

    @Before
    public void setUp() {
        move = new Move(Type.Fire, Stat.Damage, 10, 100, 0);
        victim = new Pokemon(Type.Fire, 100);
    }

    /**
     * Testing baseline attack functionality with no other factors considered.
     * Attacker Power: 10
     * Initial Victim Health: 100
     * Expected Victim Health: 90
     */
    @Test
    public void testAttack() {
        assertEquals(victim.getHealth(), 100,.0001);
        move.attack(victim);
        assertEquals(victim.getHealth(), 90,.0001);
    }

    /**
     * Testing attack functionality with damage modified.
     * Attacker Power: 10
     * Modifier: Damage, 2.0
     * Initial Victim Health:
     * Expected Victim Health: 80
     */
    @Test
    public void testDamageBoostedAttack() {
        assertEquals(victim.getHealth(), 100, .0001);
        move.attack(victim);
        assertEquals(victim.getHealth(), 80 , .0001);
    }



}
