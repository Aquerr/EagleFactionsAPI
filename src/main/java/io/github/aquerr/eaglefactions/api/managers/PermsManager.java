package io.github.aquerr.eaglefactions.api.managers;

import io.github.aquerr.eaglefactions.api.entities.Claim;
import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.entities.FactionMemberType;
import io.github.aquerr.eaglefactions.api.entities.FactionPermType;

import java.util.LinkedHashMap;
import java.util.Map;
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

    static Map<FactionMemberType, Map<FactionPermType, Boolean>> getDefaultFactionPerms()
    {
        Map<FactionMemberType, Map<FactionPermType, Boolean>> map = new LinkedHashMap<>();
        Map<FactionPermType, Boolean> officerMap = new LinkedHashMap<>();
        Map<FactionPermType, Boolean> membersMap = new LinkedHashMap<>();
        Map<FactionPermType, Boolean> recruitsMap = new LinkedHashMap<>();
        Map<FactionPermType, Boolean> allyMap = new LinkedHashMap<>();
        Map<FactionPermType, Boolean> truceMap = new LinkedHashMap<>();

        officerMap.put(FactionPermType.USE, true);
        officerMap.put(FactionPermType.PLACE, true);
        officerMap.put(FactionPermType.DESTROY, true);
        officerMap.put(FactionPermType.CLAIM, true);
        officerMap.put(FactionPermType.ATTACK, true);
        officerMap.put(FactionPermType.INVITE, true);
        officerMap.put(FactionPermType.CHEST, true);

        membersMap.put(FactionPermType.USE, true);
        membersMap.put(FactionPermType.PLACE, true);
        membersMap.put(FactionPermType.DESTROY, true);
        membersMap.put(FactionPermType.CLAIM, false);
        membersMap.put(FactionPermType.ATTACK, false);
        membersMap.put(FactionPermType.INVITE, true);
        membersMap.put(FactionPermType.CHEST, true);

        recruitsMap.put(FactionPermType.USE, true);
        recruitsMap.put(FactionPermType.PLACE, true);
        recruitsMap.put(FactionPermType.DESTROY, true);
        recruitsMap.put(FactionPermType.CLAIM, false);
        recruitsMap.put(FactionPermType.ATTACK, false);
        recruitsMap.put(FactionPermType.INVITE, false);
        recruitsMap.put(FactionPermType.CHEST, false);

        truceMap.put(FactionPermType.USE, true);
        truceMap.put(FactionPermType.PLACE, false);
        truceMap.put(FactionPermType.DESTROY, false);

        allyMap.put(FactionPermType.USE, true);
        allyMap.put(FactionPermType.PLACE, true);
        allyMap.put(FactionPermType.DESTROY, true);

        map.put(FactionMemberType.OFFICER, officerMap);
        map.put(FactionMemberType.MEMBER, membersMap);
        map.put(FactionMemberType.RECRUIT, recruitsMap);
        map.put(FactionMemberType.TRUCE, truceMap);
        map.put(FactionMemberType.ALLY, allyMap);

        return map;
    }
}
