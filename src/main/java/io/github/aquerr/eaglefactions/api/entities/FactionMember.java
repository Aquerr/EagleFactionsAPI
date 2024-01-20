package io.github.aquerr.eaglefactions.api.entities;

import java.util.Set;
import java.util.UUID;

public interface FactionMember
{
    /**
     * Gets the unique identifier of the faction member. Equal to player unique id.
     * @return the UUID of the member.
     */
    UUID getUniqueId();

    /**
     * Gets the rank name of the member.
     * @return the name of rank.
     */
    Set<String> getRankNames();
}
