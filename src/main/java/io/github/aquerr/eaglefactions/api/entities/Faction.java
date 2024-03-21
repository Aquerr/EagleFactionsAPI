package io.github.aquerr.eaglefactions.api.entities;

import io.github.aquerr.eaglefactions.api.logic.FactionLogic;
import io.github.aquerr.eaglefactions.api.managers.PowerManager;
import net.kyori.adventure.text.TextComponent;
import org.spongepowered.math.vector.Vector3i;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Faction is an immutable object that stores all information (but power) needed for faction to work.
 *
 * To change faction data use {@link FactionLogic}
 * To get faction power use {@link PowerManager}
 */
public interface Faction extends Comparable<Faction>, Inviter, InviteAcceptor
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
    TextComponent getTag();

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
     * @return the faction home of the faction or empty {@link Optional}.
     */
    Optional<FactionHome> getHome();

    /**
     * Gets faction leader.
     *
     * @return the {@link FactionMember} of the faction leader.
     */
    Optional<FactionMember> getLeader();

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

    Rank getLeaderRank();

    Optional<Rank> getRank(String rankName);

    /**
     * Gets faction members.
     * @return the {@link Set} of unique members.
     */
    Set<FactionMember> getMembers();

    /**
     * Gets faction ranks with their in-faction permission.
     */
    List<Rank> getRanks();

    /**
     * Gets default rank in faction.
     */
    Rank getDefaultRank();

    /**
     * Gets faction last online date.
     * @return an instance of {@link Instant} with time when the faction was last online.
     */
    Instant getLastOnline();

    /**
     * Gets faction creation date.
     * @return an instance of {@link Instant} representing the date-time when faction was created.
     */
    Instant getCreatedDate();

    /**
     * Gets permissions for given relation type.
     * @param relationType the type of relation.
     * @return the set containing the permissions that the given relation have inside this faction's territory.
     */
    Set<FactionPermission> getRelationPermissions(RelationType relationType);

    /**
     * Gets ranks for the given player inside the faction.
     * @param playerUUID the UUID of the player.
     * @return ranks for the given player.
     */
    Set<Rank> getPlayerRanks(UUID playerUUID);

    /**
     * Gets relation type between given faction and this faction.
     * @param faction the other faction.
     * @return the {@link RelationType}
     */
    RelationType getRelationTo(final Faction faction);

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
     * Gets value for given flag type.
     *
     * @param type the type
     * @return <tt>true</tt> if flag is set to true, <tt>false</tt> if flag is set to false OR it does not exist.
     */
    boolean getProtectionFlagValue(ProtectionFlagType type);

    /**
     * Gets protection flags set.
     *
     * Note: Modifications on returned Set does not affect the actual protection flags inside faction.
     *
     * @return the protection flags for this faction.
     */
    Set<ProtectionFlag> getProtectionFlags();

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
        Builder name(final String name);

        Builder tag(final TextComponent tag);

        Builder description(final String description);

        Builder messageOfTheDay(final String messageOfTheDay);

        Builder leader(final UUID leader);

        Builder members(final Set<FactionMember> members);

        Builder alliances(final Set<String> alliances);

        Builder truces(final Set<String> truces);

        Builder enemies(final Set<String> enemies);

        Builder claims(final Set<Claim> claims);

        Builder home(final FactionHome home);

        Builder lastOnline(final Instant lastOnline);

        Builder createdDate(final Instant createdDate);

        Builder ranks(List<Rank> ranks);

        Builder alliancePermissions(Set<FactionPermission> permissions);

        Builder trucePermissions(Set<FactionPermission> permissions);

        Builder chest(final FactionChest chest);

        Builder isPublic(final boolean isPublic);

        Builder protectionFlags(final Set<ProtectionFlag> protectionFlags);

        Faction build();
    }
}
