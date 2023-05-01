package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.FactionChest;

/**
 * Fired when a {@link net.minecraft.server.level.ServerPlayer} accesses a {@link FactionChest}
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

    interface Pre extends FactionChestEvent {}

    interface Post extends FactionChestEvent {}
}
