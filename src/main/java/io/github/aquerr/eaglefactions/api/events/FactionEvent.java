package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import net.minecraft.server.level.ServerPlayer;

/**
 * Base event for all events related to {@link Faction}
 */
public interface FactionEvent extends Event, Cancellable
{
    /**
     * Gets the player that triggered the event.
     * @return {@link ServerPlayer} object.
     */
    ServerPlayer getCreator();

    /**
     * Gets faction that this event is related to.
     * Clients can cancel this event by sending <tt>true</tt> to {@link Cancellable#setCancelled(boolean)} method.
     */
    Faction getFaction();
}
