package io.github.aquerr.eaglefactions.api.exception;

import org.spongepowered.api.item.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class RequiredItemsNotFoundException extends Exception
{
    private final ItemStack missingItem;
    private final List<ItemStack> allRequiredItems;

    public RequiredItemsNotFoundException(ItemStack missingItem, List<ItemStack> allRequiredItems)
    {
        super();
        this.missingItem = missingItem;
        this.allRequiredItems = allRequiredItems;
    }

    @Override
    public String getMessage()
    {
        return "Could not found required items in player's inventory. All required items: " + buildAllRequiredItemsMessage() + ". Missing item = " + missingItem;
    }

    public String buildAllRequiredItemsMessage()
    {
        return Arrays.toString(allRequiredItems.stream()
                .map(itemStack -> itemStack.getType().getId() + ":" + itemStack.getQuantity())
                .toArray());
    }
}
