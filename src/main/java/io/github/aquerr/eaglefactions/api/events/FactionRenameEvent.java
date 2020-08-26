package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;

/**
 * Fired when {@link Faction}'s name is being renamed to a different name.
 */
public interface FactionRenameEvent extends FactionEvent
{
    String getNewFactionName();

    interface Pre extends FactionEvent {}

    interface Post extends FactionEvent {}
}
