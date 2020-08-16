package io.github.aquerr.eaglefactions.api.events;

public interface FactionRenameEvent extends FactionEvent
{
    String getNewFactionName();
}
