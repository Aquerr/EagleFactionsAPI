package io.github.aquerr.eaglefactions.api.managers;

import io.github.aquerr.eaglefactions.api.entities.Faction;

import java.util.UUID;

public interface PermsManager
{
    boolean canBreakBlock(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction);
    boolean canPlaceBlock(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction);
    boolean canInteract(final UUID playerUUID, final Faction playerFaction, final Faction chunkFaction);
    boolean canClaim(final UUID playerUUID, final Faction playerFaction);
    boolean canAttack(final UUID playerUUID, final Faction playerFaction);
    boolean canInvite(final UUID playerUUID, final Faction playerFaction);
}
