package io.github.aquerr.eaglefactions.api.entities;

import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;

import java.io.Serializable;
import java.util.List;

public interface FactionChest
{
    String getFactionName();

    List<SlotItem> getItems();

    ItemStack getAtPosition(int row, int column);

    Inventory toInventory();


    @ConfigSerializable
    interface SlotItem extends Serializable
    {
        int getColumn();

        int getRow();

        ItemStack getItem();
    }
}
