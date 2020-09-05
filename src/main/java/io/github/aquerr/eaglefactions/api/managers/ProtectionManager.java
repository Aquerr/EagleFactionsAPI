package io.github.aquerr.eaglefactions.api.managers;

import io.github.aquerr.eaglefactions.api.entities.FactionType;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public interface ProtectionManager
{
    /**
     * @deprecated use {@link #canBreak(BlockSnapshot, User, boolean)} instead.
     * Will be removed in next API release.
     *
     * Checks if a {@link User} can break blocks at the given {@link Location<World>}
     * @param location that should be checked for block break.
     * @param player who will be tested for the given location.
     * @param shouldNotify determines if user should be notified about not having access to that location.
     * @return <tt>true</tt> if player can break block or <tt>false</tt> if not
     */
    @Deprecated
    default ProtectionResult canBreak(final Location<World> location, final User player, final boolean shouldNotify)
    {
        return canBreak(BlockSnapshot.builder().from(location).build(), player, shouldNotify);
    }

    /**
     * Checks if a {@link User} can break the given {@link BlockSnapshot}
     * @param blockSnapshot that should be checked for block break.
     * @param player who preformed block break.
     * @param shouldNotify determines if user should be notified about not having access to break block.
     * @return <tt>true</tt> if player can break block or <tt>false</tt> if not
     */
    ProtectionResult canBreak(final BlockSnapshot blockSnapshot, final User player, final boolean shouldNotify);

    /**
     * @deprecated use {@link #canBreak(BlockSnapshot)} instead.
     * Will be removed in next API release.
     *
     * Checks if a block can be destroyed at the given {@link Location<World>}
     * @param location that should be checked for block break.
     * @return <tt>true</tt> if block can be destroyed at the given location or <tt>false</tt> if not
     */
    @Deprecated
    default ProtectionResult canBreak(final Location<World> location)
    {
        return canBreak(BlockSnapshot.builder().from(location).build());
    }

    /**
     * Checks if the given {@link BlockSnapshot} can be destroyed.
     * @param blockSnapshot that should be checked.
     * @return <tt>true</tt> if block can be destroyed or <tt>false</tt> if not
     */
    ProtectionResult canBreak(final BlockSnapshot blockSnapshot);

    /**
     * @deprecated use {@link #canPlace(BlockSnapshot, User, boolean)} instead.
     * Will be removed in next API release.
     *
     * Checks if a {@link User} can place blocks at the given {@link Location<World>}
     * @param location that should be checked for block place.
     * @param player who will be tested for the given location.
     * @param shouldNotify determines if user should be notified about not having access to that location.
     * @return <tt>true</tt> if block can be placed at the given location or <tt>false</tt> if not
     */
    @Deprecated
    default ProtectionResult canPlace(final Location<World> location, final User player, final boolean shouldNotify)
    {
        return canPlace(BlockSnapshot.builder().from(location).build(), player, shouldNotify);
    }

    /**
     * Checks if a {@link User} can place the given {@link BlockSnapshot}.
     * @param blockSnapshot that should be checked for block place.
     * @param player who placed the block.
     * @param shouldNotify determines if user should be notified about not having access to place block.
     * @return <tt>true</tt> if block can be placed at the given location or <tt>false</tt> if not
     */
    ProtectionResult canPlace(final BlockSnapshot blockSnapshot, final User player, final boolean shouldNotify);

    /**
     * Checks if a {@link User} can explode blocks at the given {@link Location<World>}
     * @param location that should be checked for block explosion.
     * @param player who will be tested.
     * @param shouldNotify determines if user should be notified about not having access to that location.
     * @return <tt>true</tt> if blocks can be exploded at the given location or <tt>false</tt> if not
     */
    ProtectionResult canExplode(final Location<World> location, final User player, final boolean shouldNotify);

    /**
     * Checks if blocks can explode at the given {@link Location<World>}
     * @param location that should be check for block explosion.
     * @return <tt>true</tt> if blocks can be exploded at the given location or <tt>false</tt> if not
     */
    ProtectionResult canExplode(final Location<World> location);

    /**
     * Checks if the player can hit the given entity.
     * @param entity the entity
     * @param player the player that hit entity
     * @param shouldNotify determines if user should be notified about not having access to hit entity.
     * @return <tt>true</tt> if player can hit entity, <tt>false</tt> if not.
     */
    ProtectionResult canHitEntity(final Entity entity, final Player player, final boolean shouldNotify);

    /**
     * Checks if the location can be notified from the given location.
     * @param sourceLocation the source location
     * @param notifiedLocation the notified location
     * @return <tt>true</tt> if location can be notified, <tt>false</tt> if not.
     */
    ProtectionResult canNotifyBlock(Location<World> sourceLocation, Location<World> notifiedLocation);

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
     * Checks if a {@link User} can interact with block at the given location.
     * @param blockLocation block location that should be checked.
     * @param player who should be tested for block interaction.
     * @param shouldNotify determines if user should be notified about not having access to that location.
     * @return <tt>true</tt> if player can interact with block or <tt>false</tt> if not
     */
    ProtectionResult canInteractWithBlock(final Location<World> blockLocation, final User player, final boolean shouldNotify);

    /**
     * Checks if a {@link User} can use an item at the given location.
     * @param location that should be checked for item use.
     * @param user who should be tested for the given location.
     * @param usedItem {@link ItemStackSnapshot} that should be tested.
     * @param shouldNotify determines if user should be notified about not having access to that location.
     * @return <tt>true</tt> if user can use the item in the given location or <tt>false</tt> if not
     */
    ProtectionResult canUseItem(final Location<World> location, final User user, final ItemStackSnapshot usedItem, final boolean shouldNotify);
}
