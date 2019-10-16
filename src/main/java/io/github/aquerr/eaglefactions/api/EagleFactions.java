package io.github.aquerr.eaglefactions.api;

import io.github.aquerr.eaglefactions.api.config.Configuration;
import io.github.aquerr.eaglefactions.api.logic.AttackLogic;
import io.github.aquerr.eaglefactions.api.logic.FactionLogic;
import io.github.aquerr.eaglefactions.api.logic.PVPLogger;
import io.github.aquerr.eaglefactions.api.managers.FlagManager;
import io.github.aquerr.eaglefactions.api.managers.PlayerManager;
import io.github.aquerr.eaglefactions.api.managers.PowerManager;
import io.github.aquerr.eaglefactions.api.managers.ProtectionManager;
import io.github.aquerr.eaglefactions.api.storage.StorageManager;

import java.net.URL;
import java.nio.file.Path;

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
     * @return instance of {@link FlagManager}
     */
    FlagManager getFlagManager();

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
}
