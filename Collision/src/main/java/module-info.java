import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    requires CommonAsteroids;
    requires Asteroid;
    requires CommonBullet;
    requires CommonEnemyss;
    requires Player;
    requires spring.context;
    requires spring.beans;
    provides IPostEntityProcessingService with dk.sdu.mmmi.cbse.collisionsystem.CollisionDetector;
}