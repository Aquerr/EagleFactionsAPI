package io.github.aquerr.eaglefactions.api.managers.power.provider;

import io.github.aquerr.eaglefactions.api.entities.Faction;

/**
 * Provider used for getting power for faction.
 */
@FunctionalInterface
public interface FactionPowerProvider
{
    /**
     * Gets power for given faction.
     * @param faction the faction
     * @return power for given faction
     */
    float getFactionPower(Faction faction);
}
