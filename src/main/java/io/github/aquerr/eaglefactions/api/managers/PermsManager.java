package io.github.aquerr.eaglefactions.api.managers;

import io.github.aquerr.eaglefactions.api.entities.Claim;
import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.entities.FactionPermission;

import java.util.UUID;

public interface PermsManager
{
    /**
     * Checks if a player with the given UUID has permission for breaking blocks at the given claim.
     * @param playerUUID the UUID of the player.
     * @param playerFaction player's faction.
     * @param chunkFaction faction at chunk.
     * @param claim the claim that belongs to the faction at the given chunk.
     * @return <tt>true</tt> if player can interact, <tt>false</tt> if not.
     */
    boolean canBreakBlock(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction, final Claim claim);

    /**
     * Checks if a player with the given UUID has permission for placing blocks at the given claim.
     * @param playerUUID the UUID of the player.
     * @param playerFaction player's faction.
     * @param chunkFaction faction at chunk.
     * @param claim the claim that belongs to the faction at the given chunk.
     * @return <tt>true</tt> if player can interact, <tt>false</tt> if not.
     */
    boolean canPlaceBlock(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction, final Claim claim);

    /**
     * Checks if a player with the given UUID has permission for interacting at the given position.
     * @param playerUUID the UUID of the player.
     * @param playerFaction player's faction.
     * @param chunkFaction faction at chunk.
     * @param claim the claim that belongs to the faction at the given chunk.
     * @return <tt>true</tt> if player can interact, <tt>false</tt> if not.
     */
    boolean canInteract(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction, final Claim claim);

    /**
     * Checks if a player with the given UUID has permission for claiming territories.
     * @param playerUUID the UUID of the player.
     * @param playerFaction player's faction.
     * @return <tt>true</tt> if player can claim territories, <tt>false</tt> if not.
     */
    boolean canClaim(final UUID playerUUID, final Faction playerFaction);

    /**
     * Checks if a player with the given UUID has permission for attacking enemy claims.
     * @param playerUUID the UUID of the player.
     * @param playerFaction player's faction.
     * @return <tt>true</tt> if player can preform attack on enemy claims, <tt>false</tt> if not.
     */
    boolean canAttack(final UUID playerUUID, final Faction playerFaction);

    /**
     * Checks if a player with the given UUID has permission for inviting others to faction.
     * @param playerUUID the UUID of the player.
     * @param playerFaction player's faction.
     * @return <tt>true</tt> if player can invite others, <tt>false</tt> if not.
     */
    boolean canInvite(final UUID playerUUID, final Faction playerFaction);

    /**
     * Checks if a player with the given UUID has permission for opening faction's chest.
     * @param playerUUID the UUID of the player.
     * @param playerFaction player's faction.
     * @return <tt>true</tt> if player can open faction's chest, <tt>false</tt> if not.
     */
    boolean canUseChest(final UUID playerUUID, final Faction playerFaction);

    /**
     * Checks if the given player has given permission inside given faction.
     * @param playerUUID the player UUID
     * @param playerFaction the faction
     * @return <tt>true</tt> if player has given permission, <tt>false</tt> if not.
     */
    boolean hasPermission(final UUID playerUUID, final Faction playerFaction, final FactionPermission permission);
}
