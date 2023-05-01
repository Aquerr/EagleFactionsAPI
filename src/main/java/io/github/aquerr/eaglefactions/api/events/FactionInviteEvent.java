package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import net.minecraft.server.level.ServerPlayer;

/**
 * Fired when a {@link net.minecraft.server.level.ServerPlayer} is being invited to a {@link Faction}
 */
public interface FactionInviteEvent extends FactionEvent
{
    /**
     * @return {@link net.minecraft.server.level.ServerPlayer} who has been invited to the faction.
     */
    ServerPlayer getInvitedPlayer();

    interface Pre extends FactionInviteEvent {}

    interface Post extends FactionInviteEvent {}
}
