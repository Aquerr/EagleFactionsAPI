package io.github.aquerr.eaglefactions.api.entities;

import java.util.Set;

/**
 * Helper interface that represents an object that holds protection flags.
 */
public interface ProtectionFlags
{
    /**
     * Gets immutable Set containing protection flags.
     * @return
     */
    Set<ProtectionFlag> getProtectionFlags();

    /**
     * Gets value for given flag type.
     *
     * @param type the type
     * @return <tt>true</tt> if flag is set to true, <tt>false</tt> if flag is set to false OR it does not exist.
     */
    boolean getValueForFlag(ProtectionFlagType type);

    /**
     * Inserts or updates existing protection flag
     * @param protectionFlag the protection flag to insert
     */
    void putFlag(ProtectionFlag protectionFlag);
}
