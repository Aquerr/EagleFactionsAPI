package io.github.aquerr.eaglefactions.api.managers;

import io.github.aquerr.eaglefactions.api.entities.*;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

public interface InvitationManager
{
    boolean acceptInvitation(FactionInvite factionInvite);

    boolean sendInvitation(ServerPlayer senderPlayer, ServerPlayer invitedPlayer, Faction sourceFaction);

    boolean joinAndNotify(ServerPlayer player, Faction faction);

    void acceptAllyRequest(AllyRequest allyRequest);

    boolean sendAllyRequest(ServerPlayer player, Faction sourceFaction, Faction targetFaction);

    boolean sendTruceRequest(ServerPlayer player, Faction sourceFaction, Faction targetFaction);

    void acceptTruceRequest(TruceRequest truceRequest);

    boolean sendArmisticeOrWarRequest(ServerPlayer player, Faction sourceFaction, Faction targetFaction);

    void acceptArmisticeRequest(ArmisticeRequest armisticeRequest);
}
