package io.github.aquerr.eaglefactions.api.exception;

public class CouldNotClaimException extends Exception
{
    public CouldNotClaimException()
    {

    }

    public CouldNotClaimException(String message)
    {
        super(message);
    }

    public CouldNotClaimException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
