package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import org.spongepowered.api.entity.living.player.Player;

/**
 * Fired when a {@link Player} is being invited to a {@link Faction}
 */
public interface FactionInviteEvent extends FactionEvent
{
    /**
     * @return {@link Player} who has been invited to the faction.
     */
    Player getInvitedPlayer();

    interface Pre extends FactionInviteEvent {}

    interface Post extends FactionInviteEvent {}
}
