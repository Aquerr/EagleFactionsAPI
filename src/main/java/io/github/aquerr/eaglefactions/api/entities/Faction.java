package io.github.aquerr.eaglefactions.api.entities;

import io.github.aquerr.eaglefactions.api.managers.FlagManager;
import org.spongepowered.api.text.Text;

import java.time.Instant;
import java.util.*;

public interface Faction
{
    String getName();

    Text getTag();

    String getDescription();

    String getMessageOfTheDay();

    FactionHome getHome();

    Set<String> getAlliances();

    Set<Claim> getClaims();

    Set<String> getEnemies();

    Set<UUID> getMembers();

    Set<UUID> getOfficers();

    Set<UUID> getRecruits();

    Map<FactionMemberType, Map<FactionFlagTypes, Boolean>> getFlags();

    UUID getLeader();

    Instant getLastOnline();

    FactionMemberType getPlayerMemberType(UUID playerUUID);

    FactionChest getChest();

    boolean containsPlayer(UUID playerUUID);

    Builder toBuilder();

//    static Builder builder(final String name, final Text tag, final UUID leader)
//    {
//        return new Builder(name, tag, leader);
//    }

    //Builder
    interface Builder
    {
        Builder setName(final String name);

        Builder setTag(final Text tag);

        Builder setDescription(final String description);

        Builder setMessageOfTheDay(final String messageOfTheDay);

        Builder setLeader(final UUID leaderUUID);

        Builder setRecruits(final Set<UUID> recruits);

        Builder setMembers(final Set<UUID> members);

        Builder setOfficers(final Set<UUID> officers);

        Builder setAlliances(final Set<String> alliances);

        Builder setEnemies(final Set<String> enemies);

        Builder setClaims(final Set<Claim> claims);

        Builder setHome(final FactionHome home);

        Builder setLastOnline(final Instant lastOnline);

        Builder setFlags(final Map<FactionMemberType, Map<FactionFlagTypes, Boolean>> flags);

        Builder setChest(final FactionChest chest);

        Faction build();
    }
}
