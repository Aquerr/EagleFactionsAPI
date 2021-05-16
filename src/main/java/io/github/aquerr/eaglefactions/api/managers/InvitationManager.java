package io.github.aquerr.eaglefactions.api.managers;

import io.github.aquerr.eaglefactions.api.entities.*;
import org.spongepowered.api.entity.living.player.Player;

public interface InvitationManager
{
    boolean acceptInvitation(FactionInvite factionInvite);

    boolean sendInvitation(Player senderPlayer, Player invitedPlayer, Faction sourceFaction);

    boolean joinAndNotify(Player player, Faction faction);

    void acceptAllyRequest(AllyRequest allyRequest);

    boolean sendAllyRequest(Player player, Faction sourceFaction, Faction targetFaction);

    boolean sendTruceRequest(Player player, Faction sourceFaction, Faction targetFaction);

    void acceptTruceRequest(TruceRequest truceRequest);

    boolean sendArmisticeOrWarRequest(Player player, Faction sourceFaction, Faction targetFaction);

    void acceptArmisticeRequest(ArmisticeRequest armisticeRequest);
}
