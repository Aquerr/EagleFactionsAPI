package io.github.aquerr.eaglefactions.api.entities;

/**
 * Created by Aquerr on 2017-08-04.
 */
public interface AllyRequest extends AcceptableInvite
{
    String getSenderFaction();

    String getInvitedFaction();
}
