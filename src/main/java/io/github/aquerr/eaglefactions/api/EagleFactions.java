package io.github.aquerr.eaglefactions.api;

import io.github.aquerr.eaglefactions.api.config.Configuration;
import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.entities.FactionMemberType;
import io.github.aquerr.eaglefactions.api.entities.FactionPlayer;
import io.github.aquerr.eaglefactions.api.logic.AttackLogic;
import io.github.aquerr.eaglefactions.api.logic.FactionLogic;
import io.github.aquerr.eaglefactions.api.logic.PVPLogger;
import io.github.aquerr.eaglefactions.api.managers.PermsManager;
import io.github.aquerr.eaglefactions.api.managers.PlayerManager;
import io.github.aquerr.eaglefactions.api.managers.PowerManager;
import io.github.aquerr.eaglefactions.api.managers.ProtectionManager;
import io.github.aquerr.eaglefactions.api.storage.StorageManager;
import org.spongepowered.api.text.Text;

import java.net.URL;
import java.nio.file.Path;
import java.util.UUID;

public interface EagleFactions
{
    /**
     * Prints info from Eagle Factions in the server chat channel.
     * @param message that will be printed.
     */
    void printInfo(final String message);

    /**
     * Gets Eagle Factions configuration object. Used to access any EF config related settings.
     * @return instance of {@link Configuration}
     */
    Configuration getConfiguration();

    /**
     * Get Eagle Factions config path.
     * @return Path to the config folder.
     */
    Path getConfigDir();

    /**
     * Gets Eagle Factions resource file.
     * @param fileName to get from resources
     * @return <tt>URL</tt> object of that file or <tt>null</tt> if file could not be found.
     */
    URL getResource(final String fileName);

    /**
     * @return instance of {@link PlayerManager}
     */
    PlayerManager getPlayerManager();

    /**
     * @return instance of {@link PermsManager}
     */
    PermsManager getPermsManager();

    /**
     * @return instance of {@link PowerManager}
     */
    PowerManager getPowerManager();

    /**
     * @return instance of IProtectionManager
     */
    ProtectionManager getProtectionManager();

    /**
     * @return instance of {@link PVPLogger}
     */
    PVPLogger getPVPLogger();

    /**
     * @return instance of {@link FactionLogic}
     */
    FactionLogic getFactionLogic();

    /**
     * @return instance of {@link AttackLogic}
     */
    AttackLogic getAttackLogic();

    /**
     * @return instance of {@link StorageManager}
     */
    StorageManager getStorageManager();

    /**
     * Gets instance of {@link Faction.Builder} used to create a faction object.
     *
     * To persist faction, use {@link FactionLogic}.
     *
     * @param name the name of the faction.
     * @param tag the tag of the faction.
     * @param leader the UUID of the faction's leader.
     * @return new instance of {@link Faction.Builder}
     */
    Faction.Builder getBuilderForFaction(final String name, final Text tag, final UUID leader);

    /**
     * Creates new faction player object.
     *
     * To persist it, use {@link PlayerManager}.
     *
     * @param playerName player's name
     * @param uniqueId player's UUID
     * @param faction player's faction at the given point of time. Can be null. Is immutable, modification's should be done through {@link FactionLogic}.
     * @param power player's power.
     * @param maxpower player's maxpower
     * @param factionRole player's faction role {@link FactionMemberType}. If null is passed then {@link FactionMemberType#NONE} is used.
     * @param diedInWarZone did player recently die in warzone?
     * @return an instance of {@link FactionPlayer}
     */
    FactionPlayer createNewFactionPlayer(String playerName, UUID uniqueId, Faction faction, float power, float maxpower, FactionMemberType factionRole, boolean diedInWarZone);
}
