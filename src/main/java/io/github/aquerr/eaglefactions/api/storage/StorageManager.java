package io.github.aquerr.eaglefactions.api.storage;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.entities.FactionPlayer;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface StorageManager
{
    /**
     * Adds a new faction to the storage and cache. Or, updates an existing faction in the storage and in the cache.
     * @param faction the faction that should be added or updated.
     */
    void saveFaction(final Faction faction);

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

    /**
     * Gets all unique players who were registered/added the the Eagle Factions storage.
     * @return a Set of {@link FactionPlayer} that were added to the Eagle Factions storage.
     */
    Set<FactionPlayer> getServerPlayers();

    /**
     * Adds a player to the storage.
     * @param factionPlayer the faction player.
     * @return <tt>true</tt> if operation succeed or <tt>false</tt> if not.
     */
    boolean savePlayer(FactionPlayer factionPlayer);

    /**
     * Gets the faction player for the given unique id.
     *
     * @param playerUUID the UUID of the player.
     * @return faction player or null if player does not exists.
     */
    @Nullable FactionPlayer getPlayer(UUID playerUUID);

    /**
     * Creates a backup of Eagle Factions data.
     * Backups are placed in /config/eaglefactions/backups.
     *
     * @return <tt>true</tt> if operation succeed or <tt>false</tt> if not
     */
    boolean createBackup();

    /**
     * Restores Eagle Factions data from the given backup.
     * @param backupName the name of the backup file.
     * @return <tt>true</tt> if operation succeed or <tt>false</tt> if not
     */
    boolean restoreBackup(String backupName);

    /**
     * Gets a list of backup files' names.
     * @return the list of backup files.
     */
    List<String> listBackups();
}
