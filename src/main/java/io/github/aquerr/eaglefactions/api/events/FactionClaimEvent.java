package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.math.Vector3i;
import net.minecraft.world.level.Level;

/**
 * Fired when a {@link net.minecraft.server.level.ServerPlayer} claims a chunk at a given {@link Vector3i}.
 */
public interface FactionClaimEvent extends FactionEvent
{
    /**
     * Gets the world in which the claim event was triggered in.
     * @return {@link Level} object.
     */
    Level getWorld();

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
        /**
         * @return <tt>true</tt> if territory is being claimed by items or <tt>false</tt> if it is not
         */
        boolean isClaimedByItems();

        interface Pre extends Claim {}

        interface Post extends Claim {}
    }

    interface Unclaim extends FactionClaimEvent
    {
        interface Pre extends Unclaim {}

        interface Post extends Unclaim {}
    }
}
