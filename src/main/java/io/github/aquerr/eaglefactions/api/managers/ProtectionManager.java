package io.github.aquerr.eaglefactions.api.managers;

import io.github.aquerr.eaglefactions.api.entities.FactionType;
import io.github.aquerr.eaglefactions.api.util.ServerLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.BlockSnapshot;

public interface ProtectionManager
{
    /**
     * Checks if a {@link net.minecraft.server.level.ServerPlayer} can break the given {@link net.minecraftforge.common.util.BlockSnapshot}
     * @param blockSnapshot that should be checked for block break.
     * @param player who preformed block break.
     * @param shouldNotify determines if user should be notified about not having access to break block.
     * @return <tt>true</tt> if player can break block or <tt>false</tt> if not
     */
    ProtectionResult canBreak(final BlockSnapshot blockSnapshot, final ServerPlayer player, final boolean shouldNotify);

    /**
     * Checks if the given {@link BlockSnapshot} can be destroyed.
     * @param blockSnapshot that should be checked.
     * @return <tt>true</tt> if block can be destroyed or <tt>false</tt> if not
     */
    ProtectionResult canBreak(final BlockSnapshot blockSnapshot);

    /**
     * Checks if a {@link ServerPlayer} can place the given {@link BlockSnapshot}.
     * @param blockSnapshot that should be checked for block place.
     * @param player who placed the block.
     * @param shouldNotify determines if user should be notified about not having access to place block.
     * @return <tt>true</tt> if block can be placed at the given location or <tt>false</tt> if not
     */
    ProtectionResult canPlace(final BlockSnapshot blockSnapshot, final ServerPlayer player, final boolean shouldNotify);

    /**
     * Checks if a {@link ServerPlayer} can explode blocks at the given {@link ServerLocation}
     * @param location that should be checked for block explosion.
     * @param player who will be tested.
     * @param shouldNotify determines if user should be notified about not having access to that location.
     * @return <tt>true</tt> if blocks can be exploded at the given location or <tt>false</tt> if not
     */
    ProtectionResult canExplode(final ServerLocation location, final ServerPlayer player, final boolean shouldNotify);

    /**
     * Checks if blocks can explode at the given {@link ServerLocation}
     * @param location that should be check for block explosion.
     * @return <tt>true</tt> if blocks can be exploded at the given location or <tt>false</tt> if not
     */
    ProtectionResult canExplode(final ServerLocation location);

    /**
     * Checks if the player can hit the given entity.
     * @param entity the entity
     * @param player the player that hit entity
     * @param shouldNotify determines if user should be notified about not having access to hit entity.
     * @return <tt>true</tt> if player can hit entity, <tt>false</tt> if not.
     */
    ProtectionResult canHitEntity(final Entity entity, final ServerPlayer player, final boolean shouldNotify);

    /**
     * Checks if the location can be notified from the given location.
     * @param sourceLocation the source location
     * @param notifiedLocation the notified location
     * @return <tt>true</tt> if location can be notified, <tt>false</tt> if not.
     */
    ProtectionResult canNotifyBlock(ServerLocation sourceLocation, ServerLocation notifiedLocation);

    /**
     * Checks if the given item id is white-listed by Eagle Factions.
     * @param itemId for the item that should be tested.
     *
     * Item id should be in the following format: modid:name or minecraft:name
     * e.g. minecraft:bucket or enderio:windmill
     *
     * @return <tt>true</tt> if the item is white-listed or <tt>false</tt> if it is not.
     *
     */
    boolean isItemWhitelisted(final String itemId, final FactionType factionType);

    /**
     * Checks if the given item or block id is white-listed for placing and destroying by Eagle Factions.
     * @param itemOrBlockId of the item/block that should be tested.
     * @return <tt>true</tt> if item/block is white-listed or <tt>false</tt> if it is not.
     */
    boolean isBlockWhitelistedForPlaceDestroy(final String itemOrBlockId, final FactionType factionType);

    /**
     * Checks if the given block id is white-listed for interaction by Eagle Factions.
     * @param blockId of the block that should be tested.
     * @return <tt>true</tt> if block is white-listed or <tt>false</tt> if not.
     */
    boolean isBlockWhitelistedForInteraction(final String blockId, final FactionType factionType);

    /**
     * Checks if a {@link ServerPlayer} can interact with block at the given location.
     * @param blockLocation block location that should be checked.
     * @param player who should be tested for block interaction.
     * @param shouldNotify determines if user should be notified about not having access to that location.
     * @return <tt>true</tt> if player can interact with block or <tt>false</tt> if not
     */
    ProtectionResult canInteractWithBlock(final ServerLocation blockLocation, final ServerPlayer player, final boolean shouldNotify);

    /**
     * Checks if a {@link ServerPlayer} can use an item at the given location.
     * @param location that should be checked for item use.
     * @param user who should be tested for the given location.
     * @param usedItem {@link ItemStack} that should be tested.
     * @param shouldNotify determines if user should be notified about not having access to that location.
     * @return <tt>true</tt> if user can use the item in the given location or <tt>false</tt> if not
     */
    ProtectionResult canUseItem(final ServerLocation location, final ServerPlayer user, final ItemStack usedItem, final boolean shouldNotify);

    /**
     * Checks if the given server location is safe zone.
     * @param location the server location to check.
     * @return <tt>true</tt> if it is safe zone, <tt>false</tt> if not.
     */
    boolean isSafeZone(ServerLocation location);
}
