package io.github.aquerr.eaglefactions.api.entities;

import net.minecraft.world.item.ItemStack;

/**
 * Represents a mystical feather that comes from The Greatest Eagle.
 *
 * It's an item used to open protected chests in factions' territories.
 *
 * Obtainable in-game through an admin command, but can be used by every player when given.
 */
public interface EagleFeather
{
    ItemStack asItemStack();
}
