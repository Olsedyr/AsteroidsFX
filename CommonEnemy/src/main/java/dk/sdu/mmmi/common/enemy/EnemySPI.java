package dk.sdu.mmmi.common.enemy;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

public interface EnemySPI {

    Entity createEnemyShip(GameData gameData);
}