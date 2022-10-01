package io.github.aquerr.eaglefactions.api.managers.power.provider;

import io.github.aquerr.eaglefactions.api.entities.Faction;

/**
 * Provider used for getting maximal power for faction.
 */
@FunctionalInterface
public interface FactionMaxPowerProvider
{
    /**
     * Gets maximal power for given faction.
     * @param faction the faction
     * @return max power for given faction
     */
    float getFactionMaxPower(Faction faction);
}
