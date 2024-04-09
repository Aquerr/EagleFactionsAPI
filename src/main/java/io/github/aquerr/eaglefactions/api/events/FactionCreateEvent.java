package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import org.spongepowered.api.entity.living.player.Player;

/**
 * Fired when a {@link Player} creates a {@link Faction}
 */
public interface FactionCreateEvent extends FactionEvent
{
    interface Pre extends FactionCreateEvent {}

    interface Post extends FactionCreateEvent {}
}
