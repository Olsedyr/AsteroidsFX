package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;


/**
 *
 * This interface describes the contract for game plugin
 */
public interface IGamePluginService {


    /**
     *
     * @param gameData
     * @param world
     * Pre-conditions:
     * - The 'gameData'  must not be null.
     * - The 'world'  must not be null.
     *
     * Post-conditions:
     * - The game plugin started based on the given game data and world.
     */
    void start(GameData gameData, World world);


    /**
     *
     * @param gameData
     * @param world
     */
    void stop(GameData gameData, World world);
}
