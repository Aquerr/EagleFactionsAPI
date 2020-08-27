package io.github.aquerr.eaglefactions.api.logic;

import com.flowpowered.math.vector.Vector3i;
import io.github.aquerr.eaglefactions.api.entities.Faction;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.UUID;

/**
 * Interface for all attack related actions.
 */
public interface AttackLogic
{
    /**
     * Attacks a given {@link Vector3i} chunk.
     * @param player who is attacking the chunk.
     * @param attackedChunk a chunk that is being attacked.
     */
    void attack(Player player, Vector3i attackedChunk);

    /**
     * Blocks claiming function the the given faction.
     * Blocking time is currently set to 120 seconds.
     * @param factionName the name of the faction that should be blocked from claiming.
     */
    void blockClaiming(String factionName);

    /**
     * Starts claiming function restorer.
     * This method should normally never be fired by an external plugin.
     * Claiming restorer starts automatically for the faction that has been attacked.
     * @param factionName the name of the faction for which claiming restorer should be started.
     */
    void runClaimingRestorer(String factionName);

    /**
     * Informs the given faction about the attack.
     * @param faction that should be notified about an attack.
     *
     */
    void informAboutAttack(Faction faction, Location<World> chunkLocation);

    /**
     * Informs the given faction about the chunk being destroyed (unclaimed).
     * @param faction that should be notified about chunk being destroyed.
     * @param chunkLocation the location in which the chunk has been destroyed.
     */
    void informAboutDestroying(Faction faction, Location<World> chunkLocation);

    /**
     * Blocks home command for the given player.
     * @param playerUUID of the player that should be blocked.
     */
    void blockHome(UUID playerUUID);

    /**
     * Starts home command usage restorer.
     * @param playerUUID of the player that should have home command usage restored.
     */
    void runHomeUsageRestorer(UUID playerUUID);
}
