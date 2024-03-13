package io.github.aquerr.eaglefactions.api.managers.claim;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.exception.RequiredItemsNotFoundException;
import io.github.aquerr.eaglefactions.api.messaging.MessageService;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.world.server.ServerLocation;

import java.util.List;

/**
 * Contains information about the claiming.
 */
public interface ClaimContext
{
    /**
     * Represents the location that is going to be claimed.
     * @return the {@link ServerLocation}
     */
    ServerLocation getServerLocation();

    /**
     * Represents the player that is going to claim the territory.
     * @return the {@link ServerPlayer}
     */
    ServerPlayer getServerPlayer();

    /**
     * Represents the faction that is going to claim the territory.
     * @return the {@link Faction}
     */
    Faction getFaction();

    /**
     * The {@link MessageService} used for getting localized messages.
     * @return the {@link MessageService}
     */
    MessageService getMessageService();

    /**
     * Helper method used for consuming player items if needed.
     * @param itemStacks the items to consume from player
     * @throws RequiredItemsNotFoundException if player does not have the required items.
     * No items will be taken from player when exception is thrown.
     */
    void consumePlayerItems(List<ItemStack> itemStacks) throws RequiredItemsNotFoundException;
}
