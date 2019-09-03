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
     * Gets an item from the given position in this chest.
     * @param row the row in the chest.
     * @param column the column in the chest.
     * @return an {@link ItemStack} or a <tt>null</tt> if item could not be found.
     */
    ItemStack getAtPosition(int row, int column);

    /**
     * Converts this faction chest to {@link Inventory} which can be then opened by the player.
     * @return an instance of {@link Inventory} which contains items of this faction chest.
     */
    Inventory toInventory();

    @ConfigSerializable
    interface SlotItem extends Serializable
    {
        /**
         * Gets chest column number where this item is placed.
         * @return
         */
        int getColumn();

        /**
         * Gets chest row number where this item is placed.
         * @return
         */
        int getRow();

        /**
         * Gets an instance of {@link ItemStack} from the SlotItem.
         * @return an ItemStack from this particular SlotItem.
         */
        ItemStack getItem();
    }
}
