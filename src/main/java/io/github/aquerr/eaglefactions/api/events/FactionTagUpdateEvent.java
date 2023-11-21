package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import net.kyori.adventure.text.TextComponent;

/**
 * Fired when {@link Faction}'s tag (text, not color) is being updated.
 */
public interface FactionTagUpdateEvent extends FactionEvent
{
    /**
     * @return new tag.
     */
    String getNewTag();

    /**
     * @return old tag.
     */
    TextComponent getOldTag();

    interface Pre extends FactionTagUpdateEvent {}

    interface Post extends FactionTagUpdateEvent {}
}
