package io.github.aquerr.eaglefactions.api.entities;

import org.spongepowered.api.text.Text;

import java.time.Instant;
import java.util.*;

public interface Faction
{
    /**
     * Gets faction name.
     * @return the name of the faction.
     */
    String getName();

    /**
     * Gets faction tag.
     * The tag can be colored if colored-tags setting is turned on.
     *
     * @return the tag of the faction.
     */
    Text getTag();

    /**
     * Gets faction description.
     * @return the description of the faction.
     */
    String getDescription();

    /**
     * Gets faction message of the day.
     * @return the message of the day of the faction.
     */
    String getMessageOfTheDay();

    /**
     * Gets faction home object which contains information about the world and position in that world.
     * @return the faction home of the faction.
     */
    FactionHome getHome();

    /**
     * Gets faction alliances.
     * @return A Set of unique alliances.
     */
    Set<String> getAlliances();

    /**
     * Gets faction claims.
     * @return A Set of unique claims.
     */
    Set<Claim> getClaims();

    /**
     * Gets faction enemies.
     * @return A Set of unique enemies.
     */
    Set<String> getEnemies();

    /**
     * Gets faction members.
     * @return A Set of unique members UUIDs.
     */
    Set<UUID> getMembers();

    /**
     * Gets faction officers.
     * @return A Set of unique officers UUIDs.
     */
    Set<UUID> getOfficers();

    /**
     * Gets faction recruits.
     * @return A Set of unique recruits UUIDs.
     */
    Set<UUID> getRecruits();

    /**
     * Gets faction flags.
     * @return A key-value representation of faction flags where {@link FactionMemberType} is the key and {@link Map<FactionFlagTypes, Boolean>} is a value.
     */
    Map<FactionMemberType, Map<FactionFlagTypes, Boolean>> getFlags();

    /**
     * Gets faction leader.
     * @return the {@link UUID} of the faction leader.
     */
    UUID getLeader();

    /**
     * Gets faction last online date.
     * @return an instance of {@link Instant} with time where the faction was last online.
     */
    Instant getLastOnline();

    /**
     * Checks what member the given player is.
     * @param playerUUID the UUID of the player.
     * @return faction member type for the given player.
     */
    FactionMemberType getPlayerMemberType(UUID playerUUID);

    /**
     * Gets faction chest.
     * @return the chest of the faction.
     */
    FactionChest getChest();

    /**
     * Checks if the given player UUID exists in that faction.
     * @param playerUUID the UUID of the player.
     * @return <tt>true</tt> if player exists, <tt>false</tt> if not.
     */
    boolean containsPlayer(UUID playerUUID);

    /**
     * Converts the faction to the builder.
     * @return a builder used to build a new faction instance.
     */
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
