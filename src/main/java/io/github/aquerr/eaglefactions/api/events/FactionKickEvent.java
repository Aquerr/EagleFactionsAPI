package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.entities.FactionPlayer;
import org.spongepowered.api.entity.living.player.Player;

/**
 * Fired when a {@link FactionPlayer} is being kicked from a {@link Faction}
 */
public interface FactionKickEvent extends FactionEvent
{
    /**
     * @return the {@link FactionPlayer} who has been kicked from the faction.
     */
    FactionPlayer getKickedPlayer();

    interface Pre extends FactionEvent {}

    interface Post extends FactionEvent {}
}
