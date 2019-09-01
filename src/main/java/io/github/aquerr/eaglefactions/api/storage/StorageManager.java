package io.github.aquerr.eaglefactions.api.storage;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.entities.IFactionPlayer;

import javax.annotation.Nullable;
import java.util.Set;
import java.util.UUID;

public interface StorageManager
{
    /**
     * Adds a new faction to the storage and cache. Or, updates an existing faction in the storage and in the cache.
     * @param faction the faction that should be added or updated.
     */
    void addOrUpdateFaction(final Faction faction);

    /**
     * Deletes faction from the storage and cache.
     * @param factionName name of the faction that should be deleted.
     * @return <tt>true</tt> if operation succeed or <tt>false</tt> if not
     */
    boolean deleteFaction(final String factionName);

    /**
     * Gets a faction from the storage.
     * If there is no faction with given faction name then <tt>null</tt> is returned.
     * @param factionName the name of the faction to get
     * @return faction or null if faction does not exist
     */
    @Nullable
    Faction getFaction(final String factionName);

    /**
     * Reloads storage. If any changes have been made in the files or database manually then this method loads all data into the storage cache.
     */
    void reloadStorage();

    //TODO: This method should be updated. It should not be needed to send player's name here.
    /**
     * Checks if the player exists in the storage.
     * @param playerUUID the UUID of the player
     * @param playerName the name of the player
     * @return <tt>true</tt> if the player exists or <tt>false</tt> if not
     */
    boolean checkIfPlayerExists(final UUID playerUUID, final String playerName);

    /**
     * Adds a player to the storage.
     * @param playerUUID the UUID of the player
     * @param playerName the name of the player
     * @param startingPower player's starting power
     * @param maxpower player's maximal power
     * @return <tt>true</tt> if operation succeed or <tt>false</tt> if not.
     */
    boolean addPlayer(final UUID playerUUID, final String playerName, final float startingPower, final float maxpower);


    /**
     * Sets if player died lastly in the WarZone.
     * @param playerUUID the UUID of the player
     * @param didDieInWarZone a flag indicating if player died in the WarZone or not.
     * @return <tt>true</tt> if operation succeed or <tt>false</tt> if not.
     */
    boolean setDeathInWarzone(final UUID playerUUID, final boolean didDieInWarZone);

    /**
     * Gets last death in WarZone property for the given player uuid.
     * @param playerUUID the UUID of the player.
     * @return <tt>true</tt> if player died recently in the WarZone or <tt>false</tt> if not.
     */
    boolean getLastDeathInWarzone(final UUID playerUUID);

    /**
     * Gets player's power.
     * @param playerUUID the UUID of the player.
     * @return player's power as float.
     */
    float getPlayerPower(final UUID playerUUID);

    /**
     * Sets player's power.
     * @param playerUUID the UUID of the player.
     * @param power the power that should be set for the player.
     * @return <tt>true</tt> if operation succeed or <tt>false</tt> if not
     */
    boolean setPlayerPower(final UUID playerUUID, final float power);

    /**
     * Gets player's maximal power.
     * @param playerUUID the UUID of the player.
     * @return player's maximal power.
     */
    float getPlayerMaxPower(final UUID playerUUID);

    /**
     * Sets player's maximal power.
     * @param playerUUID the UUID of the player.
     * @param maxpower the power that should be set as maximal power for the given player.
     * @return <tt>true</tt> if operation succeed or <tt>false</tt> if not
     */
    boolean setPlayerMaxPower(final UUID playerUUID, final float maxpower);

    /**
     * Gets all unique players who were registered/added the the Eagle Factions storage.
     * @return a Set of {@link IFactionPlayer} that were added to the Eagle Factions storage.
     */
    Set<IFactionPlayer> getServerPlayers();

    /**
     * Similar to {@link #getServerPlayerNames()} but gets only players names which were added to the Eagle Factions storage.
     * @return an instance of {@link Set<String>} which contains all unique players added to Eagle Factions storage.
     */
    Set<String> getServerPlayerNames();

    /**
     * Gets player's name from the storage.
     * @param playerUUID the UUID of the player.
     * @return player's name or empty string if the player does not exist or name property is not set.
     */
    String getPlayerName(final UUID playerUUID);

    /**
     * Updates player's name in the storage.
     * @param playerUUID the UUID of the player.
     * @param playerName the name of the player.
     * @return <tt>true</tt> if operation succeed or <tt>false</tt> if not
     */
    boolean updatePlayerName(final UUID playerUUID, final String playerName);
}
