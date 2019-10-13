package test;

import main.Character;
import org.junit.Test;
import util.Types;

import static junit.framework.TestCase.assertEquals;

public class CharacterTest {

    @Test
    public void testAttack() {
        Character victim = new Character(Types.Fire, 100, 10);
        Character attacker = new Character(Types.Fire, 100, 10);

        assertEquals(victim.getHealth(), 100);

        attacker.attack(victim);

        assertEquals(victim.getHealth(), 90);
    }

}
