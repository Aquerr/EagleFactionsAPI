package io.github.aquerr.eaglefactions.api.managers;

import com.google.inject.Singleton;
import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.entities.FactionPermType;
import io.github.aquerr.eaglefactions.api.entities.FactionMemberType;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Singleton
public class PermsManagerImpl implements PermsManager
{
    private final PlayerManager playerManager;

    public PermsManagerImpl(final PlayerManager playerManager)
    {
        this.playerManager = playerManager;
    }

    @Override
    public boolean canBreakBlock(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction)
    {
        return checkFlag(playerUUID, playerFaction, chunkFaction, FactionPermType.DESTROY);
    }

    @Override
    public boolean canPlaceBlock(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction)
    {
        return checkFlag(playerUUID, playerFaction, chunkFaction, FactionPermType.PLACE);
    }

    @Override
    public boolean canInteract(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction)
    {
        return checkFlag(playerUUID, playerFaction, chunkFaction, FactionPermType.USE);
    }

    @Override
    public boolean canClaim(final UUID playerUUID, final Faction playerFaction)
    {
        return checkFlag(playerUUID, playerFaction, FactionPermType.CLAIM);
    }

    @Override
    public boolean canAttack(final UUID playerUUID, final Faction playerFaction)
    {
        return checkFlag(playerUUID, playerFaction, FactionPermType.CLAIM);
    }

    @Override
    public boolean canInvite(final UUID playerUUID, final Faction playerFaction)
    {
        return checkFlag(playerUUID, playerFaction, FactionPermType.INVITE);
    }

    private boolean checkFlag(final UUID playerUUID, final Faction playerFaction, final FactionPermType flagTypes)
    {
        final FactionMemberType memberType = this.playerManager.getFactionMemberType(playerUUID, playerFaction);
        return playerFaction.getPerms().get(memberType).get(flagTypes);
    }

    private boolean checkFlag(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction, final FactionPermType flagType)
    {
        if (playerFaction.getName().equals(chunkFaction.getName()))
        {
            final FactionMemberType memberType = this.playerManager.getFactionMemberType(playerUUID, playerFaction);
            return chunkFaction.getPerms().get(memberType).get(flagType);
        }
        else if (playerFaction.getAlliances().contains(chunkFaction.getName()))
        {
            return chunkFaction.getPerms().get(FactionMemberType.ALLY).get(flagType);
        }
        else if (playerFaction.getTruces().contains(chunkFaction.getName()))
        {
            return chunkFaction.getPerms().get(FactionMemberType.TRUCE).get(flagType);
        }
        return false;
    }

    public static Map<FactionMemberType, Map<FactionPermType, Boolean>> getDefaultFactionPerms()
    {
        Map<FactionMemberType, Map<FactionPermType, Boolean>> map = new LinkedHashMap<>();
        Map<FactionPermType, Boolean> leaderMap = new LinkedHashMap<>();
        Map<FactionPermType, Boolean> officerMap = new LinkedHashMap<>();
        Map<FactionPermType, Boolean> membersMap = new LinkedHashMap<>();
        Map<FactionPermType, Boolean> recruitsMap = new LinkedHashMap<>();
        Map<FactionPermType, Boolean> allyMap = new LinkedHashMap<>();
        Map<FactionPermType, Boolean> truceMap = new LinkedHashMap<>();

        leaderMap.put(FactionPermType.USE, true);
        leaderMap.put(FactionPermType.PLACE, true);
        leaderMap.put(FactionPermType.DESTROY, true);
        leaderMap.put(FactionPermType.CLAIM, true);
        leaderMap.put(FactionPermType.ATTACK, true);
        leaderMap.put(FactionPermType.INVITE, true);

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

        map.put(FactionMemberType.LEADER, leaderMap);
        map.put(FactionMemberType.OFFICER, officerMap);
        map.put(FactionMemberType.MEMBER, membersMap);
        map.put(FactionMemberType.RECRUIT, recruitsMap);
        map.put(FactionMemberType.TRUCE, truceMap);
        map.put(FactionMemberType.ALLY, allyMap);

        return map;
    }
}
