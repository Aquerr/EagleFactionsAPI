package io.github.aquerr.eaglefactions.api.exception;

public class ClaimLimitException extends ClaimException
{
    public ClaimLimitException()
    {
        super("Claim limit hit! You can't claim more territories!");
    }
}
