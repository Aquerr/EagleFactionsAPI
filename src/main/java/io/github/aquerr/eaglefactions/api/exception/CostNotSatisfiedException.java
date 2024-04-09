package io.github.aquerr.eaglefactions.api.exception;

public class CostNotSatisfiedException extends Exception
{
    public CostNotSatisfiedException()
    {
    }

    public CostNotSatisfiedException(String message)
    {
        super(message);
    }

    public CostNotSatisfiedException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CostNotSatisfiedException(Throwable cause)
    {
        super(cause);
    }
}
