package io.github.aquerr.eaglefactions.api.managers.claim;

import io.github.aquerr.eaglefactions.api.exception.CouldNotClaimException;
import io.github.aquerr.eaglefactions.api.logic.FactionLogic;

public class NoCostClaimStrategy extends AbstractClaimStrategy
{
    public NoCostClaimStrategy(FactionLogic factionLogic)
    {
        super(factionLogic);
    }

    @Override
    protected void preClaim(ClaimContext context) throws CouldNotClaimException
    {
        // Do nothing. No additional claim cost.
    }
}
