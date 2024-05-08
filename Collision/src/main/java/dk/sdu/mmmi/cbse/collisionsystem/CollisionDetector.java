package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.CommonEnemyss.Enemyss;
import dk.sdu.mmmi.cbse.asteroid.AsteroidSplitterImpl;
import dk.sdu.mmmi.cbse.common.asteroids.Asteroid;
import dk.sdu.mmmi.cbse.common.asteroids.IAsteroidSplitter;
import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.playersystem.Player;

public class CollisionDetector implements IPostEntityProcessingService {

    private IAsteroidSplitter asteroidSplitter = new AsteroidSplitterImpl();

    public CollisionDetector(){

    }

    public CollisionDetector(IAsteroidSplitter asteroidSplitter) {
        this.asteroidSplitter = asteroidSplitter;
    }




    @Override
    public void process(GameData gameData, World world) {

        for (Entity bullet : world.getEntities(Bullet.class)) {
            for (Entity asteroid : world.getEntities(Asteroid.class)) {
                if (collides(bullet, asteroid)) {
                    world.removeEntity(bullet);
                    asteroidSplitter.createSplitAsteroid(asteroid, world);

                    break;
                }
            }
        }

        for (Entity bullet : world.getEntities(Bullet.class)) {

            for (Entity enemy : world.getEntities(Enemyss.class)) {
                if (collides(bullet, enemy)) {
                    if(enemy.getLives() == 0){
                        world.removeEntity(enemy);
                        world.removeEntity(bullet);
                    }else{
                        enemy.setLives(enemy.getLives()-1);
                        System.out.println(enemy.getLives());
                        world.removeEntity(bullet);
                    }
                    break;
                }
            }
        }



        for (Entity bullet : world.getEntities(Bullet.class)) {

            for (Entity playership : world.getEntities(Player.class)) {
                if (collides(bullet, playership)) {
                    if(playership.getLives() == 0){
                        world.removeEntity(playership);
                        world.removeEntity(bullet);
                        System.out.println(playership.getLives());
                    }else{
                        playership.setLives(playership.getLives()-1);
                        world.removeEntity(bullet);
                    }

                    break;
                }
            }
        }


    }


    public Boolean collides(Entity entity1, Entity entity2) {
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }


}