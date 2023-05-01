package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import net.minecraft.server.level.ServerPlayer;

/**
 * Fired when a {@link net.minecraft.server.level.ServerPlayer} disbands a {@link Faction}.
 */
public interface FactionDisbandEvent extends FactionEvent
{

    /**
     * Tells if the faction was removed by the FactionRemover due to inactivity time.
     * @return
     */
    boolean removedDueToInactivity();

    /**
     * Tells if the faction was removed by a player with Admin Mode.
     * @return
     */
    boolean forceRemovedByAdmin();

    /**
     * Can be null if {@link FactionDisbandEvent#removedDueToInactivity()} returns true
     *
     * @return the player that triggered disband event
     */
    @Override
    ServerPlayer getCreator();

    interface Pre extends FactionDisbandEvent {}

    interface Post extends FactionDisbandEvent {}
}
