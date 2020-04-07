package io.github.aquerr.eaglefactions.api.managers;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.entities.FactionMemberType;
import io.github.aquerr.eaglefactions.api.entities.FactionPermType;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public interface PermsManager
{
    boolean canBreakBlock(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction);
    boolean canPlaceBlock(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction);
    boolean canInteract(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction);
    boolean canClaim(final UUID playerUUID, final Faction playerFaction);
    boolean canAttack(final UUID playerUUID, final Faction playerFaction);
    boolean canInvite(final UUID playerUUID, final Faction playerFaction);

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

        membersMap.put(FactionPermType.USE, true);
        membersMap.put(FactionPermType.PLACE, true);
        membersMap.put(FactionPermType.DESTROY, true);
        membersMap.put(FactionPermType.CLAIM, false);
        membersMap.put(FactionPermType.ATTACK, false);
        membersMap.put(FactionPermType.INVITE, true);

        recruitsMap.put(FactionPermType.USE, true);
        recruitsMap.put(FactionPermType.PLACE, true);
        recruitsMap.put(FactionPermType.DESTROY, true);
        recruitsMap.put(FactionPermType.CLAIM, false);
        recruitsMap.put(FactionPermType.ATTACK, false);
        recruitsMap.put(FactionPermType.INVITE, false);

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
