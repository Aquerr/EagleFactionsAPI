package io.github.aquerr.eaglefactions.api.managers.claim.provider;

import io.github.aquerr.eaglefactions.api.entities.Faction;

/**
 * Provider used for getting maximal claim count for faction.
 */
@FunctionalInterface
public interface FactionMaxClaimCountProvider
{
    /**
     * Gets maximal claim count for given faction.
     * @param faction the faction
     * @return max claim count for given faction
     */
    int getMaxClaimCount(Faction faction);
}
