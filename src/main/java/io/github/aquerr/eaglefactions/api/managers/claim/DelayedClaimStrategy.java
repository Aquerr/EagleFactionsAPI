package io.github.aquerr.eaglefactions.api.managers.claim;

import io.github.aquerr.eaglefactions.api.exception.CouldNotClaimException;

/**
 * A strategy that wraps another {@link ClaimStrategy} and contains information about delay time.
 *
 * Wrap your claim strategies with help of this class to achieve claim delay.
 */
public class DelayedClaimStrategy implements ClaimStrategy
{
    private final ClaimStrategy claimStrategy;
    private final int delay;
    private final boolean requireStayingInChunk;

    public DelayedClaimStrategy(ClaimStrategy claimStrategy,
                                int claimDelay,
                                boolean requireStayingInChunk)
    {
        if (claimStrategy instanceof DelayedClaimStrategy)
            throw new IllegalArgumentException("DelayedClaimStrategy cannot accept DelayedClaimStrategy!");

        this.claimStrategy = claimStrategy;
        this.delay = claimDelay;
        this.requireStayingInChunk = requireStayingInChunk;
    }

    @Override
    public void claim(ClaimContext claimContext) throws CouldNotClaimException
    {
        claimStrategy.claim(claimContext);
    }

    /**
     * The delay after which a claim should take place.
     */
    public int getDelay()
    {
        return delay;
    }

    /**
     * Determines if player should stay in chunk that is being claimed.
     */
    public boolean isRequireStayingInChunk()
    {
        return requireStayingInChunk;
    }
}
