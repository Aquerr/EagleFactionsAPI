package io.github.aquerr.eaglefactions.api.entities;

import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;

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
     * @return {@link net.minecraft.world.inventory.InventoryMenu} instance that is associated with this faction chest.
     */
    InventoryMenu getInventory();

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
         * Gets an instance of {@link net.minecraft.world.item.ItemStack} from the SlotItem.
         * @return an ItemStack from this particular SlotItem.
         */
        ItemStack getItem();
    }
}
