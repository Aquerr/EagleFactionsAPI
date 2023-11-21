package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;

/**
 * Fired when {@link Faction}'s tag color is being updated.
 */
public interface FactionTagColorUpdateEvent extends FactionEvent
{
    /**
     * @return new color.
     */
    NamedTextColor getNewColor();

    /**
     * @return old color.
     */
    NamedTextColor getOldColor();

    interface Pre extends FactionTagColorUpdateEvent
    {}

    interface Post extends FactionTagColorUpdateEvent
    {}
}
