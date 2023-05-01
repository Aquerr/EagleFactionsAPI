package io.github.aquerr.eaglefactions.api.managers;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.entities.FactionMemberType;
import io.github.aquerr.eaglefactions.api.entities.FactionPlayer;
import io.github.aquerr.eaglefactions.api.exception.PlayerNotInFactionException;
import net.minecraft.server.level.ServerPlayer;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface RankManager
{
    /**
     * Demotes a player to lower rank in a faction.
     * @param player the player that issued demotion. Can be null if is is not the player that issued demotion e.g. console.
     * @param targetPlayer the {@link FactionPlayer} that should be demoted.
     * @return {@link FactionMemberType} that the player has been demoted to. Returns same rank if it has not been changed.
     */
    FactionMemberType demotePlayer(@Nullable ServerPlayer player, FactionPlayer targetPlayer) throws PlayerNotInFactionException;

    /**
     * Promotes a player to higher rank in a faction.
     * @param player the player that issued promotion. Can be null if is is not the player that issued promotion e.g. console.
     * @param targetPlayer the {@link FactionPlayer} that should be promoted.
     * @return {@link FactionMemberType} that the player has been promoted to. Returns same rank if it has not been changed.
     */
    FactionMemberType promotePlayer(@Nullable ServerPlayer player, FactionPlayer targetPlayer) throws PlayerNotInFactionException;

    /**
     * Sets player as leader in the given faction.
     * The old leader is moved to officers.
     * @param targetPlayer the player that should be set as leader. Can be null.
     * @param faction the faction.
     */
    boolean setLeader(@Nullable FactionPlayer targetPlayer, final Faction faction);
}
