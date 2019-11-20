package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.FactionPlayer;

public interface FactionKickEvent extends FactionEvent
{
    /**
     * @return the {@link FactionPlayer} who has been kicked from the faction.
     */
    FactionPlayer getKickedPlayer();
}
