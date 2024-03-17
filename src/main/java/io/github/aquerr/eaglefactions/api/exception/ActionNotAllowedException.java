package io.github.aquerr.eaglefactions.api.exception;

public class ActionNotAllowedException extends Exception
{
    public ActionNotAllowedException()
    {
    }

    public ActionNotAllowedException(String message)
    {
        super(message);
    }

    public ActionNotAllowedException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
