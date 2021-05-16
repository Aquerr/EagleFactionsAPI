package io.github.aquerr.eaglefactions.api.entities;

import com.flowpowered.math.vector.Vector3i;
import io.github.aquerr.eaglefactions.api.logic.FactionLogic;
import io.github.aquerr.eaglefactions.api.managers.PowerManager;
import org.spongepowered.api.text.Text;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Faction is an immutable object that stores all information (but power) needed for faction to work.
 *
 * To change faction data use {@link FactionLogic}
 * To get faction power use {@link PowerManager}
 */
public interface Faction extends Comparable<Faction>
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
     * Gets faction leader.
     * @return the {@link UUID} of the faction leader.
     */
    UUID getLeader();

    /**
     * Gets faction truces.
     * @return the {@link Set} of unique truces.
     */
    Set<String> getTruces();

    /**
     * Gets faction alliances.
     * @return the {@link Set} of unique alliances.
     */
    Set<String> getAlliances();

    /**
     * Gets faction claims.
     * @return the {@link Set} of unique claims.
     */
    Set<Claim> getClaims();

    /**
     * Gets faction enemies.
     * @return the {@link Set} of unique enemies.
     */
    Set<String> getEnemies();

    /**
     * Gets faction members.
     * @return the {@link Set} of unique members UUIDs.
     */
    Set<UUID> getMembers();

    /**
     * Gets faction officers.
     * @return the {@link Set} of unique officers UUIDs.
     */
    Set<UUID> getOfficers();

    /**
     * Gets faction recruits.
     * @return the {@link Set} of unique recruits UUIDs.
     */
    Set<UUID> getRecruits();

    /**
     * Gets all players from the faction (recruits + members + officers + leader).
     * @return the {@link Set} of unique players UUIDs.
     */
    Set<UUID> getPlayers();

    /**
     * Gets faction permissions.
     * @return A key-value representation of faction permissions where {@link FactionMemberType} is the key and {@link Map< FactionPermType , Boolean>} is a value.
     */
    Map<FactionMemberType, Map<FactionPermType, Boolean>> getPerms();

    /**
     * Gets faction last online date.
     * @return an instance of {@link Instant} with time where the faction was last online.
     */
    Instant getLastOnline();

    /**
     * Checks what member the given player is.
     * @param playerUUID the UUID of the player.
     * @return faction member type for the given player or {@link FactionMemberType#NONE}
     * if player is not a member of this faction and is not in alliance/truce with this faction.
     */
    FactionMemberType getPlayerMemberType(final UUID playerUUID);

    /**
     * Gets faction chest.
     * @return the chest of the faction.
     */
    FactionChest getChest();

    /**
     * Checks if this faction is public.
     * @return <tt>true</tt> if faction is public, <tt>false</tt> if not.
     */
    boolean isPublic();

    /**
     * Checks if the given player UUID exists in that faction.
     * @param playerUUID the UUID of the player.
     * @return <tt>true</tt> if player exists, <tt>false</tt> if not.
     */
    boolean containsPlayer(final UUID playerUUID);

    /**
     * Checks if this faction is SafeZone.
     * @return <tt>true<tt/> if it is SafeZone, <tt>false</tt>> if not.
     */
    default boolean isSafeZone()
    {
        return getName().equalsIgnoreCase("safezone");
    }

    /**
     * Checks if this faction is WarZone.
     * @return <tt>true<tt/> if it is WarZone, <tt>false</tt>> if not.
     */
    default boolean isWarZone()
    {
        return getName().equalsIgnoreCase("warzone");
    }

    /**
     * Checks if the given faction is in alliance with this faction.
     * @param faction the faction that will be checked.
     * @return <tt>true</tt> if faction is an ally, <tt>false</tt> if not.
     */
    default boolean isAlly(final Faction faction)
    {
        return getAlliances().contains(faction.getName());
    }

    /**
     * Checks if the given faction is in truce with this faction.
     * @param faction the faction that will be checked.
     * @return <tt>true</tt> if faction is in truce, <tt>false</tt> if not.
     */
    default boolean isTruce(final Faction faction)
    {
        return getTruces().contains(faction.getName());
    }

    /**
     * Checks if the given faction is an enemy to this faction.
     * @param faction the faction that will be checked.
     * @return <tt>true</tt> if faction is an enemy, <tt>false</tt> if not.
     */
    default boolean isEnemy(final Faction faction)
    {
        return getEnemies().contains(faction.getName());
    }

    default Optional<Claim> getClaimAt(final UUID worldUUID, final Vector3i chunkPosition)
    {
        for (final Claim claim : getClaims())
        {
            if (claim.getWorldUUID().equals(worldUUID) && claim.getChunkPosition().equals(chunkPosition))
            {
                return Optional.of(claim);
            }
        }
        return Optional.empty();
    }

    /**
     * Converts the faction to the builder.
     * @return a builder used to build a new faction instance.
     */
    Builder toBuilder();

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

        Builder setTruces(final Set<String> truces);

        Builder setEnemies(final Set<String> enemies);

        Builder setClaims(final Set<Claim> claims);

        Builder setHome(final FactionHome home);

        Builder setLastOnline(final Instant lastOnline);

        Builder setPerms(final Map<FactionMemberType, Map<FactionPermType, Boolean>> perms);

        Builder setChest(final FactionChest chest);

        Builder setIsPublic(final boolean isPublic);

        Faction build();
    }
}
