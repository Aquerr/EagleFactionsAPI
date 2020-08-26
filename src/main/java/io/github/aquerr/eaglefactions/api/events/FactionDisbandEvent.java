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

    interface Pre extends FactionEvent {}

    interface Post extends FactionEvent {}
}
