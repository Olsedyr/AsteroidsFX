package dk.sdu.mmmi.Enemyss;

import dk.sdu.mmmi.CommonEnemyss.Enemyss;
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class EnemyssProcessor implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {

        for (Entity enemy : world.getEntities(Enemyss.class)) {
            double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
            double changeY = Math.sin(Math.toRadians(enemy.getRotation()));

            enemy.setX(enemy.getX() + changeX * 0.5);
            enemy.setY(enemy.getY() + changeY * 0.5);

            if (enemy.getX() < 0) {
                enemy.setX(enemy.getX() - gameData.getDisplayWidth());
            }

            if (enemy.getX() > gameData.getDisplayWidth()) {
                enemy.setX(enemy.getX() % gameData.getDisplayWidth());
            }

            if (enemy.getY() < 0) {
                enemy.setY(enemy.getY() - gameData.getDisplayHeight());
            }

            if (enemy.getY() > gameData.getDisplayHeight()) {
                enemy.setY(enemy.getY() % gameData.getDisplayHeight());
            }

            Random random = new Random();

// Check for a random condition
            if (random.nextDouble() < 0.1) {
                // Adjust the probability by changing the value (0.1 in this case, represents 10% chance)
                getBulletSPIs().stream().findFirst().ifPresent(
                        spi -> {world.addEntity(spi.createBullet(enemy, gameData));}
                );
            }

        }

    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
