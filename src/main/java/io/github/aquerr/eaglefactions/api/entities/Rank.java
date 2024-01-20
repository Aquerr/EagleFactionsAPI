package io.github.aquerr.eaglefactions.api.entities;

import java.util.Objects;
import java.util.Set;

public interface Rank
{
    String getName();

    void setName(String name);

    String getDisplayName();

    int getLadderPosition();

    Set<FactionPermission> getPermissions();

    boolean canDisplayInChat();

    Builder toBuilder();

    /**
     * Checks if rank is the same as the current rank.
     *
     * Default implementation treats rank names as unique values,
     * thus two ranks with same name are considered same rank.
     *
     * @param rank the rank to check against this rank
     * @return true if same, false if not.
     */
    default boolean isSameRank(Rank rank)
    {
        return Objects.equals(this.getName().toLowerCase(), rank.getName().toLowerCase());
    }

    interface Builder
    {
        Builder name(String name);

        Builder displayName(String displayName);

        Builder ladderPosition(int ladderPosition);

        Builder permissions(Set<FactionPermission> permissions);

        Builder permission(FactionPermission permission);

        Builder displayInChat(boolean displayInChat);

        Rank build();
    }
}
