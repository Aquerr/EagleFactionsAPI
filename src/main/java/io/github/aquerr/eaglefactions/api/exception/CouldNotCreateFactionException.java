package io.github.aquerr.eaglefactions.api.exception;

public class CouldNotCreateFactionException extends Exception
{
    public CouldNotCreateFactionException()
    {
    }

    public CouldNotCreateFactionException(String message)
    {
        super(message);
    }

    public CouldNotCreateFactionException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CouldNotCreateFactionException(Throwable cause)
    {
        super(cause);
    }
}
