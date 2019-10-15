package test;

import main.Character;
import main.Modifier;
import main.enums.Stat;
import org.junit.Test;
import main.enums.AttackType;

import static junit.framework.TestCase.assertEquals;

public class CharacterTest {

    /**
     * Testing baseline attack functionality with no other factors considered.
     * Attacker Power: 10
     * Initial Victim Health: 100
     * Expected Victim Health: 90
     */
    @Test
    public void testAttack() {
        Character attacker = new Character(AttackType.Fire, 100, 10);
        Character victim = new Character(AttackType.Fire, 100, 10);

        assertEquals(victim.getHealth(), 100);

        attacker.attack(victim);

        assertEquals(victim.getHealth(), 90);
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
        Character attacker = new Character(AttackType.Fire, 100, 10);
        Character victim = new Character(AttackType.Fire, 100, 10);

        attacker.setModifier(new Modifier(2.0, Stat.Damage));

        assertEquals(victim.getHealth(), 100);

        attacker.attack(victim);

        assertEquals(victim.getHealth(), 80);
    }



}
