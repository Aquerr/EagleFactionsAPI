package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;

/**
 * Fired when a {@link net.minecraft.server.level.ServerPlayer} joins a {@link Faction}
 */
public interface FactionJoinEvent extends FactionEvent
{
    interface Pre extends FactionJoinEvent {}

    interface Post extends FactionJoinEvent {}
}
