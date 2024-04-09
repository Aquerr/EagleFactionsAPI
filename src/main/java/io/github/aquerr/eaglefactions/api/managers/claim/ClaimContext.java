package io.github.aquerr.eaglefactions.api.managers.claim;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.world.server.ServerLocation;

/**
 * Contains information about the claiming.
 */
public interface ClaimContext
{
    /**
     * Represents the location that is going to be claimed.
     * @return the {@link ServerLocation}
     */
    ServerLocation getServerLocation();

    /**
     * Represents the player that is going to claim the territory.
     * @return the {@link ServerPlayer}
     */
    ServerPlayer getServerPlayer();

    /**
     * Represents the faction that is going to claim the territory.
     * @return the {@link Faction}
     */
    Faction getFaction();
}
