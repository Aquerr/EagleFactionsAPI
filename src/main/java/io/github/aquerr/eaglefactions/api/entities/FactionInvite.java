package io.github.aquerr.eaglefactions.api.entities;

import java.util.UUID;

public interface FactionInvite extends AcceptableInvite
{
    String getSenderFaction();

    UUID getInvitedPlayerUniqueId();
}
