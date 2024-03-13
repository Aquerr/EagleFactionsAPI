package io.github.aquerr.eaglefactions.api.managers.claim;

import io.github.aquerr.eaglefactions.api.entities.Claim;
import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.exception.CouldNotClaimException;

/**
 * A strategy for claiming a territory/chunk.
 *
 * Consider using {@link AbstractClaimStrategy} instead of implementing this interface by yourself.
 *
 * To use your strategy simply override the strategy used by the plugin by using {@link io.github.aquerr.eaglefactions.api.logic.FactionLogic#setClaimStrategy(ClaimStrategy)}
 */
public interface ClaimStrategy
{
    /**
     * Performs the claim.
     *
     * Implementations of this method should invoke
     * {@link io.github.aquerr.eaglefactions.api.logic.FactionLogic#addClaim(Faction, Claim)} at the end.
     *
     * @see AbstractClaimStrategy
     * @param claimContext the claim context.
     */
    void claim(ClaimContext claimContext) throws CouldNotClaimException;
}
