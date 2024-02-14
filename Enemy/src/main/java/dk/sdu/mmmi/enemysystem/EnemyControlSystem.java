package dk.sdu.mmmi.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.common.enemy.EnemySPI;
import dk.sdu.mmmi.common.enemy.Enemy;


import java.util.*;

import static java.util.stream.Collectors.toList;

public class EnemyControlSystem implements IEntityProcessingService, EnemySPI {

    private static final Random random = new Random();

    private static  final int max_enemies = 6;

    private final List<Entity> enemies = new ArrayList<>();

    @Override
    public void process(GameData gameData, World world) {
        for (Entity enemy : world.getEntities(Enemy.class)) {
            // Randomly change rotation
            if (random.nextDouble() < 0.01) {
                enemy.setRotation(random.nextInt(360));
            }


            /*
            if(gameData.getKeys().isDown(GameKeys.SPACE)) {
               getEnemySPIs().stream().findFirst().ifPresent(
                        spi -> {world.addEntity(spi.createEnemyShip( gameData));}
                );



                /*
                Entity enemyShip = createEnemyShip(gameData);
                enemies.add(enemyShip);
                world.addEntity(enemyShip);




            }

             */

            // Calculate new position based on rotation
            double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
            double changeY = Math.sin(Math.toRadians(enemy.getRotation()));
            enemy.setX(enemy.getX() + changeX * 0.5); // Adjust the speed as needed
            enemy.setY(enemy.getY() + changeY * 0.5); // Adjust the speed as needed

            // Wrap around the screen if the enemy goes out of bounds
            wrapAroundScreen(enemy, gameData);
        }
    }


    private void wrapAroundScreen(Entity entity, GameData gameData) {
        if (entity.getX() < 0) {
            entity.setX(gameData.getDisplayWidth() - 1);
        }

        if (entity.getX() > gameData.getDisplayWidth()) {
            entity.setX(1);
        }

        if (entity.getY() < 0) {
            entity.setY(gameData.getDisplayHeight() - 1);
        }

        if (entity.getY() > gameData.getDisplayHeight()) {
            entity.setY(1);
        }
    }

    @Override
    public Entity createEnemyShip(GameData gameData) {
        Entity enemyShip = new Enemy();
        enemyShip.setPolygonCoordinates(-5,-5,10,0,-5,5);
        enemyShip.setX(gameData.getDisplayHeight()/3);
        enemyShip.setY(gameData.getDisplayWidth()/4);
        return enemyShip;
    }

}