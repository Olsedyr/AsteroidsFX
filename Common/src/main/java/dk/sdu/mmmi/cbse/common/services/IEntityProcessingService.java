package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;


/**
 *
 * This interface describes the contract for services that process entities
 */
public interface IEntityProcessingService {

    /**
     *
     *
     *
     * @param gameData
     * @param world
     * @throws Exception
     *
     * Pre-conditions:
     * - The 'gameData'  must not be null.
     * - The 'world'  must not be null.
     *
     * Post-conditions:
     * - The method processes entities within the game based on the provided game data and world.
     * - Any exception during processing is propagated (not caught within the method).
     */
    void process(GameData gameData, World world);
}
