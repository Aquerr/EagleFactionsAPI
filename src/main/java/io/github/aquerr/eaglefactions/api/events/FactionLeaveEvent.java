package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;

/**
 * Fired when a {@link net.minecraft.server.level.ServerPlayer} leaves a {@link Faction}
 */
public interface FactionLeaveEvent extends FactionEvent
{
    interface Pre extends FactionLeaveEvent {}

    interface Post extends FactionLeaveEvent {}
}
