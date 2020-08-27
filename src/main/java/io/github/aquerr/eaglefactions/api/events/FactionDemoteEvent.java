package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.FactionMemberType;
import io.github.aquerr.eaglefactions.api.entities.FactionPlayer;
import org.spongepowered.api.entity.living.player.Player;

public interface FactionDemoteEvent extends FactionEvent
{
    /**
     * Gets the player that demoted a faction member and thus triggered this event.
     * @return the player that triggered this event.
     */
    default Player getDemotedBy()
    {
        return this.getCreator();
    }

    /**
     * Gets the player that is being demoted.
     * @return the player that is being demoted.
     */
    FactionPlayer getDemotedPlayer();

    interface Pre extends FactionDemoteEvent {}

    interface Post extends FactionDemoteEvent
    {
        FactionMemberType getDemotedToRank();
    }
}
