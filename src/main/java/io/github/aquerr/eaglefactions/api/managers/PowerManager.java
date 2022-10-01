package io.github.aquerr.eaglefactions.api.managers;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.managers.power.provider.FactionMaxPowerProvider;
import io.github.aquerr.eaglefactions.api.managers.power.provider.FactionPowerProvider;

import java.util.Set;
import java.util.UUID;

public interface PowerManager
{
    /**
     * Adds {@link FactionPowerProvider} to providers used to calculate faction's power in {@link PowerManager#getFactionPower(Faction)}
     * @param provider new provider
     */
    void addFactionPowerProvider(FactionPowerProvider provider);

    /**
     * Adds {@link FactionMaxPowerProvider} to providers used to calculate faction's max power in {@link PowerManager#getFactionMaxPower(Faction)}
     * @param provider new provider
     */
    void addFactionMaxPowerProvider(FactionMaxPowerProvider provider);

    /**
     * Overrides providers collection used to calculate faction's power in {@link PowerManager#getFactionPower(Faction)}
     * @param providers new providers
     */
    void setFactionPowerProviders(Set<FactionPowerProvider> providers);

    /**
     * Overrides providers collection used to calculate faction's max power in {@link PowerManager#getFactionMaxPower(Faction)}
     * @param providers new providers
     */
    void setFactionMaxPowerProviders(Set<FactionMaxPowerProvider> providers);

    /**
     * Gets providers used in calculating faction's power
     * @return an unmodifiable set of {@link FactionPowerProvider}
     */
    Set<FactionPowerProvider> getFactionPowerProviders();

    /**
     * Gets providers used in calculating faction's max power
     * @return an unmodifiable set of {@link FactionMaxPowerProvider}
     */
    Set<FactionMaxPowerProvider> getFactionMaxPowerProviders();

    /**
     * Gets player's power for the given player's {@link UUID}
     * @param playerUUID the UUID of the player
     * @return player's power as float or 0 if player could not be found.
     */
    float getPlayerPower(final UUID playerUUID);

    /**
     * Gets player's maximal power for the given player's {@link UUID}
     * @param playerUUID the UUID of the player
     * @return player's maximal power as float or 0 if player could not be found.
     */
    float getPlayerMaxPower(final UUID playerUUID);

    /**
     * Sets the power for the given player.
     *
     * @param playerUUID the UUID of the player.
     * @param power the new power.
     * @return <tt>true</tt> if operation succeed, <tt>false</tt> if not.
     */
    boolean setPlayerPower(UUID playerUUID, float power);

    /**
     * Sets the mnax power for the given player.
     *
     * @param playerUUID the UUID of the player.
     * @param maxpower the new max power.
     * @return <tt>true</tt> if operation succeed, <tt>false</tt> if not.
     */
    boolean setPlayerMaxPower(UUID playerUUID, float maxpower);

    /**
     * Decreases player's power by the amount specified in the config file. Default: 2
     * @param playerUUID the UUID of the player.
     */
    void decreasePower(final UUID playerUUID);

    /**
     * Gets power of the given {@link Faction}
     * @param faction the faction that the power should be get from.
     * @return power of the faction or 9999 if it is SafeZone or WarZone and theirs power property is not set.
     */
    float getFactionPower(final Faction faction);

    /**
     * Gets maximal power of the given {@link Faction}
     * @param faction the faction that the maximal power should be get from.
     * @return maximal power of the faction or 9999 if it is SafeZone or WarZone and theirs maxpower property is not set.
     */
    float getFactionMaxPower(final Faction faction);

    /**
     * Puts a penalty on the player with the given UUID. Penalty can be set in the Eagle Factions config file. By default penalty is equal to 1.
     * @param playerUUID the {@link UUID} of the player that the penalty should be put on.
     */
    void penalty(final UUID playerUUID);

    /**
     * Increments player's power by the amount specified in the config file. Default: 0.04 or 2 if it is a kill award.
     * @param playerUUID the {@link UUID} of the player.
     * @param isKillAward flag for specifying if this power addition is a kill award or not.
     */
    void addPower(final UUID playerUUID, boolean isKillAward);

    /**
     * Starts increasing player's power.
     * Power addition occurs once per minute.
     * Clients should normally never run this method as it is run by Eagle Factions itself when player joins on the server.
     * @param playerUUID the UUID of the player that the power should start increasing.
     */
    void startIncreasingPower(final UUID playerUUID);

    //TODO: Add method for stopping power addition.
}
