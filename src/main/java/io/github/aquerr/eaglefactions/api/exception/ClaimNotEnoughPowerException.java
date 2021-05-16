package io.github.aquerr.eaglefactions.api.exception;

public class ClaimNotEnoughPowerException extends ClaimException
{
    public ClaimNotEnoughPowerException()
    {
        super("You don't have power to claim more lands!");
    }
}
