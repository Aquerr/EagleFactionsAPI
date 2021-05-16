package io.github.aquerr.eaglefactions.api.entities;

public interface ArmisticeRequest extends AcceptableInvite
{
    String getSenderFaction();

    String getInvitedFaction();
}
