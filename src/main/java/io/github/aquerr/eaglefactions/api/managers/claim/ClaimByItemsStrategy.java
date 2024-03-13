package io.github.aquerr.eaglefactions.api.managers.claim;

import io.github.aquerr.eaglefactions.api.exception.CouldNotClaimException;
import io.github.aquerr.eaglefactions.api.exception.RequiredItemsNotFoundException;
import io.github.aquerr.eaglefactions.api.logic.FactionLogic;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.List;

public class ClaimByItemsStrategy extends AbstractClaimStrategy
{
    private final List<ItemStack> itemsCost;

    public ClaimByItemsStrategy(FactionLogic factionLogic,
                                List<ItemStack> itemsCost)
    {
        super(factionLogic);
        this.itemsCost = itemsCost;
    }

    @Override
    protected void preClaim(ClaimContext context) throws CouldNotClaimException
    {
        try
        {
            context.consumePlayerItems(itemsCost);
        }
        catch (RequiredItemsNotFoundException e)
        {
            throw new CouldNotClaimException(context.getMessageService().resolveMessage("error.command.claim.not-enough-resources", e.buildAllRequiredItemsMessage()), e);
        }
    }
}
