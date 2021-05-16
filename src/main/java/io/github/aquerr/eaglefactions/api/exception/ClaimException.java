package io.github.aquerr.eaglefactions.api.exception;

public class ClaimException extends Exception
{
    public ClaimException()
    {
        super();
    }

    public ClaimException(String message)
    {
        super(message);
    }

    public ClaimException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
