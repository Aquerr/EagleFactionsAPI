package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.entities.FactionPlayer;
import io.github.aquerr.eaglefactions.api.entities.Rank;
import org.spongepowered.api.entity.living.player.Player;

/**
 * Fired when a {@link FactionPlayer} is being promoted inside {@link Faction}
 */
public interface FactionPromoteEvent extends FactionEvent
{
    /**
     * Gets the player that demoted a faction member and thus triggered this event.
     * @return the player that triggered this event.
     */
    default Player getPromotedBy()
    {
        return this.getCreator();
    }

    /**
     * Gets the player that is being demoted.
     * @return the player that is being demoted.
     */
    FactionPlayer getPromotedPlayer();

    interface Pre extends FactionPromoteEvent {}

    interface Post extends FactionPromoteEvent
    {
        Rank getPromotedToRank();
    }
}
