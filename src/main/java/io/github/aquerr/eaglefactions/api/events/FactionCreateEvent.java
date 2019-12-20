package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import org.spongepowered.api.entity.living.player.Player;

/**
 * Fired when a {@link Player} creates a {@link Faction}
 */
public interface FactionCreateEvent extends FactionEvent
{
    /**
     * <strong>Currently unimplemented</strong>
     *
     * @return <tt>true</tt> if faction is being created by items or <tt>false</tt> if it is not
     */
    boolean isCreatedByItems();
}
