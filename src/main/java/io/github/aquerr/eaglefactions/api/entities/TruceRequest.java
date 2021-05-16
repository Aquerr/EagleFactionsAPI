package io.github.aquerr.eaglefactions.api.entities;

public interface TruceRequest extends AcceptableInvite
{
    String getSenderFaction();

    String getInvitedFaction();
}
