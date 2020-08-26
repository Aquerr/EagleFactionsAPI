package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.entities.FactionMemberType;
import io.github.aquerr.eaglefactions.api.entities.FactionPlayer;

/**
 * Fired when a {@link FactionPlayer} is being promoted inside {@link Faction}
 */
public interface FactionPromoteEvent extends FactionEvent
{
    interface Pre extends FactionEvent {}

    interface Post extends FactionEvent
    {
        FactionMemberType getPromotedToRank();
    }
}
