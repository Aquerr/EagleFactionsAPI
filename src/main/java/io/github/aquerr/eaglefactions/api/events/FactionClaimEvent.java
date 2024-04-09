package io.github.aquerr.eaglefactions.api.events;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3i;

/**
 * Fired when a {@link Player} claims a chunk at a given {@link Vector3i}.
 */
public interface FactionClaimEvent extends FactionEvent
{
    /**
     * Gets the world in which the claim event was triggered in.
     * @return {@link ServerWorld} object.
     */
    ServerWorld getWorld();

    /**
     * Gets the chunk position of the claim where the claim event was triggered in.
     *
     * Can be null if player unclaimed all claims.
     *
     * @return chunk position as {@link Vector3i}
     */
    Vector3i getChunkPosition();

    interface Claim extends FactionClaimEvent
    {
        interface Pre extends Claim {}

        interface Post extends Claim {}
    }

    interface Unclaim extends FactionClaimEvent
    {
        interface Pre extends Unclaim {}

        interface Post extends Unclaim {}
    }
}
