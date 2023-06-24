package io.github.aquerr.eaglefactions.api.exception;

public class CommandException extends RuntimeException
{
    public CommandException(String message)
    {
        super(message);
    }

    public CommandException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
