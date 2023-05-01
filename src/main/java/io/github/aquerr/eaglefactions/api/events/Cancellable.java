package io.github.aquerr.eaglefactions.api.events;

public interface Cancellable
{
    boolean isCancelled();

    void setCancelled(boolean cancel);
}
