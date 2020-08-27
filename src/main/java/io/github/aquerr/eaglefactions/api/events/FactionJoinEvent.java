package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import org.spongepowered.api.entity.living.player.Player;

/**
 * Fired when a {@link Player} joins a {@link Faction}
 */
public interface FactionJoinEvent extends FactionEvent
{
    interface Pre extends FactionJoinEvent {}

    interface Post extends FactionJoinEvent {}
}
