
import dk.sdu.mmmi.Enemyss.EnemyssProcessor;
import dk.sdu.mmmi.Enemyss.EnemyssPlugin;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

module Enemy {
    requires Common;
    requires CommonBullet;
    requires CommonEnemyss;
    uses dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
    provides IGamePluginService with EnemyssPlugin;
    provides IEntityProcessingService with EnemyssProcessor;
}