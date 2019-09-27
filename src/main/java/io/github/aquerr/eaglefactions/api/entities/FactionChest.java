package io.github.aquerr.eaglefactions.api.entities;

import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;

import java.io.Serializable;
import java.util.List;

public interface FactionChest
{
    /**
     * Gets name of the faction this chest belongs to.
     * @return the name of the faction.
     */
    String getFactionName();

    /**
     * Gets items that this chest contains.
     * @return a list of {@link SlotItem} that this chest contains.
     */
    List<SlotItem> getItems();

    /**
     * Gets this faction chest inventory.
     * @return {@link Inventory} instance that is associated with this faction chest.
     */
    Inventory getInventory();

    @ConfigSerializable
    interface SlotItem extends Serializable
    {
        /**
         * Gets chest column number where this item is placed.
         * @return the number of the column where the item is placed.
         */
        int getColumn();

        /**
         * Gets chest row number where this item is placed.
         * @return the number of the column where the item is placed.
         */
        int getRow();

        /**
         * Gets an instance of {@link ItemStack} from the SlotItem.
         * @return an ItemStack from this particular SlotItem.
         */
        ItemStack getItem();
    }
}
