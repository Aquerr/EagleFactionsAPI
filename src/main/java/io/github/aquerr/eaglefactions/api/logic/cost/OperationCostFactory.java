package io.github.aquerr.eaglefactions.api.logic.cost;

import org.spongepowered.api.item.inventory.ItemStack;

import java.util.List;

/**
 * A factory that can build a cost/payment strategy for an operation.
 *
 * Use its methods to build a {@link OperationCost} object.
 */
public interface OperationCostFactory
{
    /**
     * An operation cost where player pays with its power.
     * @param power the power to take from player.
     * @return and instance of {@link OperationCost}.
     */
    OperationPowerCost power(float power);

    /**
     * An operation cost where player is required to have a certain amount of power.
     * Power is NOT taken from player.
     * @param power the power that player should have to make an operation.
     * @return and instance of {@link OperationCost}.
     */
    OperationHavingPowerCost havingPower(float power);

    /**
     * An operation cost where player is required to have certain items. Items will be taken from player's inventory.
     * @param items the items to take from player.
     * @return and instance of {@link OperationCost}.
     */
    OperationItemsCost items(List<ItemStack> items);
}
