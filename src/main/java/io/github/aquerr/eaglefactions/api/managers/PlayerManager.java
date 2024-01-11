package io.github.aquerr.eaglefactions.api.managers;

import io.github.aquerr.eaglefactions.api.entities.FactionPlayer;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface PlayerManager
{
    /**
     * Adds new player to the cache and storage.
     * @param playerUUID the uuid of the player.
     * @param name the name of the player.
     * @return <tt>true</tt> if operation succeed or <tt>false</tt> if not.
     */
    boolean addPlayer(UUID playerUUID, String name);

    /**
     * Gets player for the given UUID.
     * @param playerUUID the uuid of the player.
     * @return the player.
     */
    Optional<ServerPlayer> getPlayer(UUID playerUUID);

    /**
     * Saves/persists the faction player.
     *
     * @param factionPlayer the faction player.
     * @return <tt>true</tt> if operation succeed or <tt>false</tt> if not.
     */
    boolean savePlayer(final FactionPlayer factionPlayer);

    /**
     * Gets faction player for the given UUID.
     *
     * @param playerUUID the UUID of the player.
     * @return the faction player if found, otherwise Optional.empty().
     */
    Optional<FactionPlayer> getFactionPlayer(UUID playerUUID);

    /**
     *  Checks if a player with the given player uuid is currently online.
     *
     * @param playerUUID the UUID of hte player.
     * @return <tt>true</tt> if player is online, <tt>false</tt> if not.
     */
    boolean isPlayerOnline(UUID playerUUID);

    /**
     * Gets the set of faction players that were playing on this server.
     *
     * @return the set of faction player.
     */
    Set<FactionPlayer> getServerPlayers();

    /**
     * @return boolean value that indicates if player has admin mode.
     *
     * All players that toggled admin mode by using admin command or
     * have "eaglefactions.adminmode" permission are considered as admins.
     */
    boolean hasAdminMode(final User player);

    /**
     * Activates factions admin mode for the given player.
     * @param player the player admin mode should be activated for.
     * @return <tt>true</tt> if operation succeeded, <tt>false</tt> if not.
     */
    boolean activateAdminMode(final User player);

    /**
     * Deactivates factions admin mode for the given player.
     * @param player the player admin mode should be deactivated for.
     * @return <tt>true</tt> if operation succeeded, <tt>false</tt> if not.
     */
    boolean deactivateAdminMode(final User player);

    /**
     * Gets a set consists of players with admin mode.
     * @return set with players who have admin mode on.
     */
    Set<ServerPlayer> getAdminModePlayers();

    /**
     * Sets player's last death location to warzone.
     * @param playerUUID the UUID of the player.
     * @param didDie the value.
     */
    void setDeathInWarZone(UUID playerUUID, boolean didDie);
}
