package io.github.aquerr.eaglefactions.api.exception;

import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.registry.RegistryTypes;

import java.util.Arrays;
import java.util.List;

public class RequiredItemsNotFoundException extends Exception
{
    private final transient ItemStack missingItem;
    private final transient List<ItemStack> allRequiredItems;

    public RequiredItemsNotFoundException(ItemStack missingItem, List<ItemStack> allRequiredItems)
    {
        super();
        this.missingItem = missingItem;
        this.allRequiredItems = allRequiredItems;
    }

    public String requiredItemsAsString()
    {
        return Arrays.toString(allRequiredItems.stream()
                .map(this::asStringWithCount)
                .toArray());
    }

    public String missingItemAsString()
    {
        return asStringWithCount(this.missingItem);
    }

    private String asStringWithCount(ItemStack itemStack)
    {
        return itemStack.type().key(RegistryTypes.ITEM_TYPE).asString() + " x" + itemStack.quantity();
    }
}
