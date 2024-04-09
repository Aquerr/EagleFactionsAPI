package io.github.aquerr.eaglefactions.api.logic.cost;

import io.github.aquerr.eaglefactions.api.exception.CostNotSatisfiedException;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

/**
 * Represents a cost for an operation.
 *
 * Used for faction creation and territory/chunk claiming.
 *
 * There are few builtin operation costs available through you via {@link OperationCostFactory}
 * that can be acquired from {@link io.github.aquerr.eaglefactions.api.EagleFactions} instance.
 *
 * You can still implement this interface on your own if the builtin costs are not enough.

 * @see OperationCostFactory
 */
public interface OperationCost
{
    void pay(ServerPlayer serverPlayer) throws CostNotSatisfiedException;
}
