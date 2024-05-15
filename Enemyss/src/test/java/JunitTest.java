import static org.junit.jupiter.api.Assertions.*;

import dk.sdu.mmmi.CommonEnemyss.Enemyss;
import dk.sdu.mmmi.Enemyss.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class JunitTest {

    private Enemyss enemy;

    @BeforeEach
    public void setUp(){
        enemy = new Enemyss();
        enemy.setLives(3);
        enemy.setX(0);
        enemy.setY(0);
    }

    @Test
    public void testMove(){
        double oldX = enemy.getX();
        double oldY = enemy.getY();

        enemy.setX(5);
        enemy.setY(10);

        assertNotEquals(oldX, enemy.getX(), "movedx");

        assertNotEquals(oldY, enemy.getY(), "movedY");
    }



    @Test
    public void testLoseLife(){
        enemy.setLives(enemy.getLives()-1);
        assertEquals(2, enemy.getLives(), "2 lives");

        enemy.setLives(enemy.getLives()-1);
        assertEquals(1, enemy.getLives(), "1 lives");

        enemy.setLives(enemy.getLives()-1);
        assertEquals(0, enemy.getLives(), "0 lives");


    }


    @Test
    public void testIsAlive() {
        assertTrue(enemy.isAlive(), "Enemy should be alive initially");

        enemy.setLives(enemy.getLives()-1);
        enemy.setLives(enemy.getLives()-1);
        enemy.setLives(enemy.getLives()-1);

        assertFalse(enemy.isAlive(), "Enemy should be dead after losing all lives");
    }

}
