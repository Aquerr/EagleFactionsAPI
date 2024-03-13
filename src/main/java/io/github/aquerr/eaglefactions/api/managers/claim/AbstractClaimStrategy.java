package io.github.aquerr.eaglefactions.api.managers.claim;

import io.github.aquerr.eaglefactions.api.entities.Claim;
import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.exception.CouldNotClaimException;
import io.github.aquerr.eaglefactions.api.logic.FactionLogic;

/**
 * A helper abstract class that already implements {@link ClaimStrategy#claim(ClaimContext)}
 * and allows you to run any logic before the actual claim addition by providing {@link AbstractClaimStrategy#preClaim(ClaimContext)}.
 *
 * Classes that extend this class should not try to save claim inside {@link AbstractClaimStrategy#preClaim(ClaimContext)} method.
 *
 * @see ClaimByItemsStrategy to get to know how to use this abstract class.
 */
public abstract class AbstractClaimStrategy implements ClaimStrategy
{
    protected final FactionLogic factionLogic;

    protected AbstractClaimStrategy(FactionLogic factionLogic)
    {
        this.factionLogic = factionLogic;
    }

    protected void addClaim(Faction faction, Claim claim)
    {
        this.factionLogic.addClaim(faction, claim);
    }

    protected abstract void preClaim(ClaimContext context) throws CouldNotClaimException;

    @Override
    public void claim(ClaimContext context) throws CouldNotClaimException
    {
        preClaim(context);
        addClaim(context.getFaction(), new Claim(
                context.getServerLocation().world().uniqueId(),
                context.getServerLocation().chunkPosition()
        ));
    }
}
