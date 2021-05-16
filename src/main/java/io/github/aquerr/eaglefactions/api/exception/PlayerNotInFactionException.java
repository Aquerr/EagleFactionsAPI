package io.github.aquerr.eaglefactions.api.exception;

import io.github.aquerr.eaglefactions.api.entities.FactionPlayer;

public class PlayerNotInFactionException extends Exception
{
    public PlayerNotInFactionException(final FactionPlayer factionPlayer)
    {
        super("Player " + factionPlayer.getName() + " is not in faction!");
    }
}
