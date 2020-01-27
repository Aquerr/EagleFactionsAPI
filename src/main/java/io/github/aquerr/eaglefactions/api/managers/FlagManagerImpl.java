package io.github.aquerr.eaglefactions.api.managers;

import com.google.inject.Singleton;
import io.github.aquerr.eaglefactions.api.EagleFactions;
import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.entities.FactionFlagTypes;
import io.github.aquerr.eaglefactions.api.entities.FactionMemberType;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Singleton
public class FlagManagerImpl implements FlagManager
{
    private static FlagManagerImpl INSTANCE = null;
    private final EagleFactions plugin;

    private FlagManagerImpl(EagleFactions plugin)
    {
        this.plugin = plugin;
        INSTANCE = this;
    }

    public static FlagManagerImpl getInstance(final EagleFactions eagleFactions)
    {
        if (INSTANCE == null)
            return new FlagManagerImpl(eagleFactions);
        else return INSTANCE;
    }

    @Override
    public boolean canBreakBlock(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction)
    {
        return checkFlag(playerUUID, playerFaction, chunkFaction, FactionFlagTypes.DESTROY);
    }

    @Override
    public boolean canPlaceBlock(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction)
    {
        return checkFlag(playerUUID, playerFaction, chunkFaction, FactionFlagTypes.PLACE);
    }

    @Override
    public boolean canInteract(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction)
    {
        return checkFlag(playerUUID, playerFaction, chunkFaction, FactionFlagTypes.USE);
    }

    @Override
    public boolean canClaim(final UUID playerUUID, final Faction playerFaction)
    {
        return checkFlag(playerUUID, playerFaction, FactionFlagTypes.CLAIM);
    }

    @Override
    public boolean canAttack(final UUID playerUUID, final Faction playerFaction)
    {
        return checkFlag(playerUUID, playerFaction, FactionFlagTypes.CLAIM);
    }

    @Override
    public boolean canInvite(final UUID playerUUID, final Faction playerFaction)
    {
        return checkFlag(playerUUID, playerFaction, FactionFlagTypes.INVITE);
    }

    private boolean checkFlag(final UUID playerUUID, final Faction playerFaction, final FactionFlagTypes flagTypes)
    {
        final FactionMemberType memberType = plugin.getPlayerManager().getFactionMemberType(playerUUID, playerFaction);
        return playerFaction.getFlags().get(memberType).get(flagTypes);
    }

    private boolean checkFlag(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction, final FactionFlagTypes flagType)
    {
        if (playerFaction.getName().equals(chunkFaction.getName()))
        {
            final FactionMemberType memberType = plugin.getPlayerManager().getFactionMemberType(playerUUID, playerFaction);
            return chunkFaction.getFlags().get(memberType).get(flagType);
        }
        else if (playerFaction.getAlliances().contains(chunkFaction.getName()))
        {
            return chunkFaction.getFlags().get(FactionMemberType.ALLY).get(flagType);
        }
        else if (playerFaction.getTruces().contains(chunkFaction.getName()))
        {
            return chunkFaction.getFlags().get(FactionMemberType.TRUCE).get(flagType);
        }
        return false;
    }

    public static Map<FactionMemberType, Map<FactionFlagTypes, Boolean>> getDefaultFactionFlags()
    {
        Map<FactionMemberType, Map<FactionFlagTypes, Boolean>> map = new LinkedHashMap<>();
        Map<FactionFlagTypes, Boolean> leaderMap = new LinkedHashMap<>();
        Map<FactionFlagTypes, Boolean> officerMap = new LinkedHashMap<>();
        Map<FactionFlagTypes, Boolean> membersMap = new LinkedHashMap<>();
        Map<FactionFlagTypes, Boolean> recruitsMap = new LinkedHashMap<>();
        Map<FactionFlagTypes, Boolean> allyMap = new LinkedHashMap<>();
        Map<FactionFlagTypes, Boolean> truceMap = new LinkedHashMap<>();

        leaderMap.put(FactionFlagTypes.USE, true);
        leaderMap.put(FactionFlagTypes.PLACE, true);
        leaderMap.put(FactionFlagTypes.DESTROY, true);
        leaderMap.put(FactionFlagTypes.CLAIM, true);
        leaderMap.put(FactionFlagTypes.ATTACK, true);
        leaderMap.put(FactionFlagTypes.INVITE, true);

        officerMap.put(FactionFlagTypes.USE, true);
        officerMap.put(FactionFlagTypes.PLACE, true);
        officerMap.put(FactionFlagTypes.DESTROY, true);
        officerMap.put(FactionFlagTypes.CLAIM, true);
        officerMap.put(FactionFlagTypes.ATTACK, true);
        officerMap.put(FactionFlagTypes.INVITE, true);

        membersMap.put(FactionFlagTypes.USE, true);
        membersMap.put(FactionFlagTypes.PLACE, true);
        membersMap.put(FactionFlagTypes.DESTROY, true);
        membersMap.put(FactionFlagTypes.CLAIM, false);
        membersMap.put(FactionFlagTypes.ATTACK, false);
        membersMap.put(FactionFlagTypes.INVITE, true);

        recruitsMap.put(FactionFlagTypes.USE, true);
        recruitsMap.put(FactionFlagTypes.PLACE, true);
        recruitsMap.put(FactionFlagTypes.DESTROY, true);
        recruitsMap.put(FactionFlagTypes.CLAIM, false);
        recruitsMap.put(FactionFlagTypes.ATTACK, false);
        recruitsMap.put(FactionFlagTypes.INVITE, false);

        truceMap.put(FactionFlagTypes.USE, true);
        truceMap.put(FactionFlagTypes.PLACE, false);
        truceMap.put(FactionFlagTypes.DESTROY, false);

        allyMap.put(FactionFlagTypes.USE, true);
        allyMap.put(FactionFlagTypes.PLACE, true);
        allyMap.put(FactionFlagTypes.DESTROY, true);

        map.put(FactionMemberType.LEADER, leaderMap);
        map.put(FactionMemberType.OFFICER, officerMap);
        map.put(FactionMemberType.MEMBER, membersMap);
        map.put(FactionMemberType.RECRUIT, recruitsMap);
        map.put(FactionMemberType.TRUCE, truceMap);
        map.put(FactionMemberType.ALLY, allyMap);

        return map;
    }
}
