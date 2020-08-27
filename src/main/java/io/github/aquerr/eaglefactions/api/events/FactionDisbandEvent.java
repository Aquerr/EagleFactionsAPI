package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import org.spongepowered.api.entity.living.player.Player;

/**
 * Fired when a {@link Player} disbands a {@link Faction}.
 */
public interface FactionDisbandEvent extends FactionEvent
{

    /**
     * Tells if faction was removed by FactionRemover due to inactivity time.
     * @return
     */
    boolean removedDueToInactivity();

    /**
     * Tells if faction was removed by player with Admin Mode.
     * @return
     */
    boolean forceRemovedByAdmin();

    /**
     * Can be null if {@link FactionDisbandEvent#removedDueToInactivity()} returns true
     *
     * @return the player that triggered disband event
     */
    @Override
    Player getCreator();

    interface Pre extends FactionDisbandEvent {}

    interface Post extends FactionDisbandEvent {}
}
