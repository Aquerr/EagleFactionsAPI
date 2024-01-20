package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.entities.FactionPlayer;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Fired when leader {@link FactionPlayer} changes inside {@link Faction}
 */
public interface FactionLeaderChangeEvent extends FactionEvent
{
    /**
     * Gets the new leader of the faction.
     * @return the new leader.
     */
    @Nullable FactionPlayer getNewLeader();

    interface Pre extends FactionLeaderChangeEvent
    {}

    interface Post extends FactionLeaderChangeEvent
    { }
}
