import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Enemy {
    uses dk.sdu.mmmi.common.enemy.EnemySPI;
    requires Common;
    requires CommonEnemy;
    provides IGamePluginService with dk.sdu.mmmi.enemysystem.EnemyPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.enemysystem.EnemyControlSystem;
}
