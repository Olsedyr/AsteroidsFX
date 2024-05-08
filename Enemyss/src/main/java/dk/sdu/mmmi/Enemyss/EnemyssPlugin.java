package dk.sdu.mmmi.Enemyss;


import dk.sdu.mmmi.CommonEnemyss.Enemyss;
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Collection;
import java.util.Random;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;
import org.springframework.stereotype.Component;


@Component
public class EnemyssPlugin implements IGamePluginService {
    @Override
    public void start(GameData gameData, World world) {
        Entity Enemyss = createEnemy(gameData);
        world.addEntity(Enemyss);
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        for (Entity Enemyss : world.getEntities(Enemyss.class)) {
            world.removeEntity(Enemyss);
        }

    }

    private Entity createEnemy(GameData gameData) {
        Entity enemyss = new Enemyss();
        enemyss.setType("Enemy");
        enemyss.setLives(3);
        Random rnd = new Random();
        int size = rnd.nextInt(10) + 5;
        enemyss.setPolygonCoordinates(12, -1, 8, -1, 8, -3, 6, -3, 6, -5, -2, -5, -2, -7, 0, -7, 0, -9, -10, -9, -10, -5, -8, -5, -8, -3, -6, -3, -6, -1, -10, -1, -10, 1, -6, 1, -6, 3, -8, 3, -8, 5, -10, 5, -10, 9, 0, 9, 0, 7, -2, 7, -2, 5, 2, 5, 2, 1, 4, 1, 4, -1, 2, -1, 2, -3, 4, -3, 4, -1, 6, -1, 6, 1, 4, 1, 4, 3, 2, 3, 2, 5, 6, 5, 6, 3, 8, 3, 8, 1, 12, 1);
        enemyss.setX(0);
        enemyss.setY(0);
        enemyss.setRadius(size);
        enemyss.setRotation(rnd.nextInt(90));
        return enemyss;
    }


}