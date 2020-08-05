package io.github.aquerr.eaglefactions.api.logic;

import com.flowpowered.math.vector.Vector3i;
import io.github.aquerr.eaglefactions.api.entities.*;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.format.TextColor;

import javax.annotation.Nullable;
import java.time.Instant;
import java.util.*;

/**
 * Interface for all faction related actions.
 *
 * Other plugins should always use this class for interacting with factions.
 */
public interface FactionLogic
{
    /**
     * Gets {@link Faction} for the given player {@link UUID}.
     * @param playerUUID the UUID of the player who's faction should be looked for.
     * @return {@link Optional<Faction>} if the given player is in a faction or
     * {@link Optional#empty()} if the given player is not in a faction.
     */
    Optional<Faction> getFactionByPlayerUUID(UUID playerUUID);

    /**
     * Gets {@link Faction} for the given chunk location {@link Vector3i} in the given world UUID {@link UUID}.
     * @param worldUUID the UUID of the world
     * @param chunk the location of the chunk
     * @return {@link Optional<Faction>} if the given chunk claimed by a faction or
     * {@link Optional#empty()} if the given chunk is not claimed by any faction.
     */
    Optional<Faction> getFactionByChunk(UUID worldUUID, Vector3i chunk);

    /**
     * Gets {@link Faction} by the given faction name.
     * @param factionName the name of the faction that should be looked for.
     * @return {@link Faction} or <tt>null</tt> if factions could not be found.
     */
    @Nullable
    Faction getFactionByName(String factionName);

    /**
     * Gets a {@link List<Player>} that contains all online players in a given {@link Faction}
     * @param faction the faction that should be used to get online players from.
     * @return {@link List<Player>} list with online players in the given faction.
     */
    List<Player> getOnlinePlayers(Faction faction);

    /**
     * Gets all faction names that exists on the server.
     * @return {@link Set<String>} that contains all faction names on the server.
     */
    Set<String> getFactionsNames();

    /**
     * Gets a {@link Map} that contains all factions that exists on the server from the plugin cache.
     * @return {@link Map} instance where keys are factions names and values are factions objects.
     */
    Map<String, Faction> getFactions();

    /**
     * Adds/Creates a new faction to the cache and storage.
     * @param faction that should be added to the storage.
     */
    void addFaction(Faction faction);

    /**
     * Disbands/Deletes a faction.
     * @param factionName name of the faction that should be disbanded/deleted.
     * @return <tt>true</tt> if operation succeeded or <tt>false</tt> if it did not.
     */
    boolean disbandFaction(String factionName);

    /**
     * Joins a player to the given faction.
     * This method first tries to get the faction object and then puts the player in the faction recruits list.
     * @param playerUUID the UUID of the player that should be added to the given faction.
     * @param factionName the name of the faction.
     */
    void joinFaction(UUID playerUUID, String factionName);

    /**
     * Joins a player to the given faction.
     * This method first tries to get the faction object and then removes player from it.
     * @param playerUUID the UUID of the player that should be removed from the faction.
     * @param factionName the name of the faction.
     */
    void leaveFaction(UUID playerUUID, String factionName);

    /**
     * Creates a truce between given factions.
     * @param playerFactionName  the name of the first faction.
     * @param invitedFactionName the name of the second faction.
     */
    void addTruce(String playerFactionName, String invitedFactionName);

    /**
     * Disbands a truce between given factions.
     * @param playerFactionName  the name of the first faction.
     * @param removedFactionName the name of the second faction.
     */
    void removeTruce(String playerFactionName, String removedFactionName);

    /**
     * Creates an alliance between given factions.
     * @param playerFactionName  the name of the first faction.
     * @param invitedFactionName the name of the second faction.
     */
    void addAlly(String playerFactionName, String invitedFactionName);

    /**
     * Disbands an alliance between given factions.
     * @param playerFactionName  the name of the first faction.
     * @param removedFactionName the name of the second faction.
     */
    void removeAlly(String playerFactionName, String removedFactionName);

    /**
     * Sets enemy state between given factions.
     * @param playerFactionName  the name of the first faction.
     * @param enemyFactionName the name of the second faction.
     */
    void addEnemy(String playerFactionName, String enemyFactionName);

    /**
     * Removes enemy state between given factions.
     * @param playerFactionName  the name of the first faction.
     * @param enemyFactionName the name of the second faction.
     */
    void removeEnemy(String playerFactionName, String enemyFactionName);

    /**
     * Sets player as leader in the given faction.
     * @param newLeaderUUID the UUID of the player that should be set as leader.
     * @param playerFactionName the name of the faction.
     */
    void setLeader(UUID newLeaderUUID, String playerFactionName);

    /**
     * Gets all claimed chunks on the server.
     * @return {@link Set<Claim>} that contains all claimed chunks.
     */
    Map<Claim, Optional<Faction>> getAllClaims();

    /**
     * Adds claims to the given faction.
     * @param faction the faction that should acquire claims.
     * @param claims list of claims that should be added to the faction.
     */
    void addClaims(Faction faction, List<Claim> claims);

    /**
     * Directly adds a claim to the given faction.
     *
     * Consider using {@link FactionLogic#startClaiming(Player, Faction, UUID, Vector3i)}
     * if you want to preform the full claiming mechanism (claiming with delay, claiming by using items).
     *
     * @param faction the faction that should acquire claim.
     * @param claim the claim that should be added to the faction.
     */
    void addClaim(Faction faction, Claim claim);

    /**
     * Directly adds a claim from the given faction.
     * @param faction the faction that should lost a claim.
     * @param claim the claim that should be removed from the faction.
     */
    void removeClaim(Faction faction, Claim claim);

    /**
     * Works the same like {@link FactionLogic#removeClaim(Faction, Claim)} but it is used after successful attack to spawn different particles.
     * @param faction the faction that should lost a claim.
     * @param claim the claim that should be removed from the faction.
     */
	void destroyClaim(Faction faction, Claim claim);

    /**
     * Checks if the chunk {@link Vector3i} in the given world {@link UUID} is claimed.
     * @param worldUUID the UUID of the world
     * @param chunk the position of the chunk
     * @return <tt>true</tt> if chunk is claimed or <tt>false</tt> if it is not.
     */
	boolean isClaimed(UUID worldUUID, Vector3i chunk);

    /**
     * Checks if a {@link Claim} is connected to other claims in the given {@link Faction}
     * @param faction the faction object to preform check against
     * @param claimToCheck the claim that should be checked
     * @return <tt>true</tt> if chunk is connected to other claims or <tt>false</tt> if it is not.
     */
    boolean isClaimConnected(Faction faction, Claim claimToCheck);

    /**
     * Adds new owner of the given claim.
     * @param faction the faction that owns the claim.
     * @param claim the claim
     * @param owner the owner that should be added as owner of the given claim.
     * @return <tt>true</tt> if operation succeeded, <tt>false</tt> if not.
     */
    boolean addClaimOwner(final Faction faction, final Claim claim, final UUID owner);

    /**
     * Removes owner of the given claim.
     * @param faction the faction that owns the claim.
     * @param claim the claim
     * @param owner the owner that should be removed from the given claim.
     * @return <tt>true</tt> if operation succeeded, <tt>false</tt> if not.
     */
    boolean removeClaimOwner(final Faction faction, final Claim claim, final UUID owner);

    /**
     * Sets claims accessibility by faction.
     * @param faction the faction that own the claim.
     * @param claim the claim.
     * @param isAccessibleByFaction the
     * @return <tt>true</tt> if operation succeeded, <tt>false</tt> if not.
     */
    void setClaimAccessibleByFaction(final Faction faction, final Claim claim, final boolean isAccessibleByFaction);

    /**
     * Sets home for the given {@link Faction}
     * @param faction the faction for which home should be set
     * @param home new faction's home.
     */
    void setHome(Faction faction, @Nullable FactionHome home);

    /**
     * Gets the list of all factions tags used on the server.
     * @return {@link List<String>} that contains all factions tags.
     */
    List<String> getFactionsTags();

    /**
     * Checks if the given faction has online players on the server.
     * @param faction the faction that check should be run against.
     * @return <tt>true</tt> if there are player on the server that are in that faction or <tt>false</tt> if this faction has no players who are currently online.
     */
    boolean hasOnlinePlayers(Faction faction);

    /**
     * Removes all claims of the given faction.
     * @param faction the faction that claims should be removed.
     */
    void removeAllClaims(Faction faction);

    /**
     * Kicks player from the given faction.
     * @param playerUUID the UUId of the player that should be kicked.
     * @param factionName the name of the faction that the player should be kicked from.
     */
    void kickPlayer(UUID playerUUID, String factionName);

    /**
     * Starts claiming for the given chunk.
     * This method should be used instead
     * @param player the player that is trying to claim a chunk.
     * @param faction the faction that claim should be run for. This parameter will be removed in future API versions.
     * @param worldUUID the world UUID of the given chunk
     * @param chunkPosition the chunk location
     */
    void startClaiming(Player player, Faction faction, UUID worldUUID, Vector3i chunkPosition);

    /**
     * Adds claim by using items that are specified in the config file.
     * @param player the player that is trying to claim a chunk.
     * @param faction the faction that claim should be run for. This parameter will be removed in future API versions.
     * @param worldUUID the world UUID of the given chunk
     * @param chunkPosition the chunk location
     * @return
     */
    boolean addClaimByItems(Player player, Faction faction, UUID worldUUID, Vector3i chunkPosition);

    /**
     * Changes permission of the given {@link FactionPermType} for the given {@link FactionMemberType} in the faction.
     * @param faction the faction that should be edited.
     * @param factionMemberType the faction member type that should be affected.
     * @param factionPermType the faction flag type that should be changed.
     * @param flagValue new boolean value.
     */
    void togglePerm(Faction faction, FactionMemberType factionMemberType, FactionPermType factionPermType, Boolean flagValue);

    /**
     * Changes color of the faction tag.
     * @param faction the faction that should be affected.
     * @param textColor new {@link TextColor} that should be used for the faction tag.
     */
    void changeTagColor(Faction faction, TextColor textColor);

    /**
     * Promotes a player to higher rank in a faction.
     * @param faction that will be affected by this change.
     * @param playerToPromote the UUID of the player that should be promoted.
     * @return {@link FactionMemberType} that player has been promoted to.
     */
    FactionMemberType promotePlayer(Faction faction, UUID playerToPromote);

    /**
     * Promotes a player to lower rank in a faction.
     * @param faction that will be affected by this change.
     * @param playerToDemote the UUID of the player that should be demoted.
     * @return {@link FactionMemberType} that player has been demoted to.
     */
    FactionMemberType demotePlayer(Faction faction, UUID playerToDemote);

    /**
     * Sets faction last online time.
     * @param faction that should be affected by this change.
     * @param instantTime new time as {@link Instant}
     */
    void setLastOnline(Faction faction, Instant instantTime);

    /**
     * Changes the name of the faction.
     * @param faction that should be affected by this change.
     * @param newFactionName new faction name.
     */
    void renameFaction(Faction faction, String newFactionName);

    /**
     * Changes the tag of the faction.
     * @param faction that should be affected by this change.
     * @param newTag new faction tag.
     */
    void changeTag(Faction faction, String newTag);

    /**
     * Sets faction chest.
     * @param faction that should be affected by this change.s
     * @param inventory new {@link FactionChest}
     */
    void setChest(Faction faction, FactionChest inventory);

    /**
     * Sets faction description.
     * @param faction that should be affected by this change.
     * @param description new description.
     */
    void setDescription(Faction faction, String description);

    /**
     * Sets faction message of the day.
     * @param faction that should be affected by this change.
     * @param motd new message of the day.
     */
    void setMessageOfTheDay(Faction faction, String motd);

    /**
     * Sets if faction is public (people can join it without invitation) or private (normal faction).
     * @param faction that should be affected by this change.
     * @param isPublic boolean value, <tt>true</tt> if faction should be public, <tt>false</tt> if not.
     */
	void setIsPublic(Faction faction, boolean isPublic);
}
