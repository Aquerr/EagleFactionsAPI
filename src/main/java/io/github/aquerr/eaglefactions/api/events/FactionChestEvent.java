package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.FactionChest;
import org.spongepowered.api.entity.living.player.Player;

/**
 * Fired when a {@link Player} accesses a {@link FactionChest}
 */
public interface FactionChestEvent extends FactionEvent
{
    /**
     * Gets faction chest.
     * @return the faction chest
     */
    default FactionChest getFactionChest()
    {
        return getFaction().getChest();
    }

    interface Pre extends FactionEvent {}

    interface Post extends FactionEvent {}
}
