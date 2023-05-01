package io.github.aquerr.eaglefactions.api.entities;

import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;
import java.util.UUID;

/**
 * Represents a faction player.
 */
public interface FactionPlayer
{
    /**
     * Gets last known player's name.
     * @return the name of the player as {@link String}
     */
    String getName();

    /**
     * Gets player's unique id.
     * @return the {@link UUID} of the player.
     */
    UUID getUniqueId();

    /**
     * Gets player's faction.
     * @return the {@link Optional} that contains a Faction object if player is in a faction.
     */
    Optional<Faction> getFaction();

    /**
     * Gets player's faction name.
     * @return the name of the faction as {@link Optional<String>} or {@link Optional#empty()} if player is not in a faction.
     */
    default Optional<String> getFactionName()
    {
        return getFaction().map(Faction::getName);
    }

    /**
     * Gets player's faction member type (rank).
     * @return the {@link FactionMemberType} of the player.
     */
    FactionMemberType getFactionRole();

    /**
     * Checks if the player is online.
     * @return <tt>true</tt> if player is online or <tt>false</tt> if not.
     */
    boolean isOnline();

    /**
     * Gets player's power.
     * @return player's power as floating number.
     */
    float getPower();

    /**
     * Gets player's maxpower.
     * @return player's maxpower as floating number.
     */
    float getMaxPower();

    /**
     * Gets {@link net.minecraft.server.level.ServerPlayer} instance from the current player.
     * @return the {@link net.minecraft.server.level.ServerPlayer} instance or {@link Optional#empty()} if instance could not be found.
     */
    Optional<ServerPlayer> getServerPlayer();

    /**
     * Checks if the given player recently died in WarZone.
     * @return <tt>true</tt> if yes, <tt>false</tt> if not.
     */
    boolean diedInWarZone();
}
