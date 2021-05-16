package io.github.aquerr.eaglefactions.api.exception;

public class ClaimNotConnectedException extends ClaimException
{
    public ClaimNotConnectedException()
    {
        super("Claim is not connected to other claims!");
    }
}
