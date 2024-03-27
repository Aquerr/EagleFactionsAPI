package io.github.aquerr.eaglefactions.api.managers;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import io.github.aquerr.eaglefactions.api.entities.FactionPermission;
import io.github.aquerr.eaglefactions.api.entities.FactionPlayer;
import io.github.aquerr.eaglefactions.api.entities.Rank;
import io.github.aquerr.eaglefactions.api.entities.RelationType;
import io.github.aquerr.eaglefactions.api.exception.ActionNotAllowedException;
import io.github.aquerr.eaglefactions.api.exception.PlayerNotInFactionException;
import io.github.aquerr.eaglefactions.api.exception.RankAlreadyExistsException;
import io.github.aquerr.eaglefactions.api.exception.RankLadderPositionOutOfRange;
import io.github.aquerr.eaglefactions.api.exception.RankNotExistsException;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface RankManager
{
    /**
     * Sets player as leader in the given faction.
     * The old leader is moved to officers.
     * @param targetPlayer the player that should be set as leader. Can be null.
     * @param faction the faction.
     */
    boolean setLeader(@Nullable FactionPlayer targetPlayer, final Faction faction);

    void assignRank(Faction faction, FactionPlayer targetPlayer, Rank rank) throws PlayerNotInFactionException, RankNotExistsException;

    void createRank(Faction faction, String rankName, int ladderPosition) throws RankAlreadyExistsException, RankLadderPositionOutOfRange;

    void deleteRank(Faction faction, Rank rank) throws RankNotExistsException, ActionNotAllowedException;

    void setRankPermission(Faction faction, Rank rank, FactionPermission permission) throws RankNotExistsException;

    void setRankDisplayName(Faction faction, Rank rank, String displayName) throws RankNotExistsException;

    void setRankPosition(Faction faction, Rank rank, int ladderPosition) throws RankLadderPositionOutOfRange, RankNotExistsException, ActionNotAllowedException;

    void setRelationPermission(Faction faction, RelationType relationType, FactionPermission permission);

    void setRankDisplayInChat(Faction faction, Rank rank, boolean displayInChat) throws RankNotExistsException;
}
