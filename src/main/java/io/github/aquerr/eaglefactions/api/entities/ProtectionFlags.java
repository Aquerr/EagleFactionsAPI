package io.github.aquerr.eaglefactions.api.entities;

import java.util.Set;

/**
 * Helper interface that represents an object that can provide protection flags and get their values.
 */
public interface ProtectionFlags
{
    Set<ProtectionFlag> getProtectionFlags();

    /**
     * Gets value for given flag type.
     *
     * @param type the type
     * @return <tt>true</tt> if flag is set to true, <tt>false</tt> if flag is set to false OR it does not exist.
     */
    boolean getValueForFlag(ProtectionFlagType type);
}
