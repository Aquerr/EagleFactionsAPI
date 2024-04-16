package io.github.aquerr.eaglefactions.api.managers.claim;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.exception.CouldNotClaimException;
import io.github.aquerr.eaglefactions.api.logic.cost.OperationCost;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.world.server.ServerLocation;

import java.util.List;

/**
 * A manager responsible for performing claim operation.
 *
 * It is used when player claims a territory either via claim command or map command.
 * The default implementation of this manager collects payment from player for claiming the chunk and runs claim events.
 *
 * You should prefer using this manager to preserve claiming logic instead of saving faction directly to storage via {@link io.github.aquerr.eaglefactions.api.storage.StorageManager}.
 */
public interface ClaimManager
{
    /**
     * Sets (overrides) claim costs list.
     * @param claimCosts the claim costs.
     */
    void setClaimCosts(List<OperationCost> claimCosts);

    /**
     * Adds new claim cost to the existing claim costs list.
     * @param claimCost the claim cost.
     */
    void addClaimCost(OperationCost claimCost);

    /**
     * Performs the claim operation.
     * @param player the player
     * @param faction the faction
     * @param serverLocation the location
     * @throws CouldNotClaimException when could not claim given location
     */
    void claim(ServerPlayer player, Faction faction, ServerLocation serverLocation) throws CouldNotClaimException;

    /**
     * Performs the claim operation, however you can overwrite the delay claim setting here which is normally taken from config file.
     * @param player the player
     * @param faction the faction
     * @param serverLocation the location
     * @throws CouldNotClaimException when could not claim given location
     */
    void claim(ServerPlayer player,
               Faction faction,
               ServerLocation serverLocation,
               boolean shouldDelayClaim) throws CouldNotClaimException;
}
