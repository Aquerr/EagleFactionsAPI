package io.github.aquerr.eaglefactions.api.managers;

/**
 * Protection Manager's Result object.
 *
 * Contains the result data that tells if protection is bypassed and why.
 */
public class ProtectionResult
{
    /**
     * Has access.
     */
    public static ProtectionResult ok()
    {
        return builder().hasAccess(true).build();
    }

    /**
     * Has access because of admin mode.
     */
    public static ProtectionResult okAdmin()
    {
        return builder().hasAccess(true).isAdmin(true).build();
    }

    /**
     * Access granted by eagle's feather.
     */
    public static ProtectionResult okEagleFeather()
    {
        return builder().hasAccess(true).hasEagleFeather(true).build();
    }

    /**
     * Has access in safe zone.
     */
    public static ProtectionResult okSafeZone()
    {
        return builder().hasAccess(true).isSafeZone(true).build();
    }

    /**
     * Has access in war zone.
     */
    public static ProtectionResult okWarZone()
    {
        return builder().hasAccess(true).isWarZone(true).build();
    }

    /**
     * Has access because of faction's permission.
     */
    public static ProtectionResult okFactionPerm()
    {
        return builder().hasAccess(true).factionPerm(true).build();
    }

    /**
     * Forbidden access.
     */
    public static ProtectionResult forbidden()
    {
        return builder().build();
    }

    /**
     * Forbidden access in safe zone.
     */
    public static ProtectionResult forbiddenSafeZone()
    {
        return builder().isSafeZone(true).build();
    }

    /**
     * Forbidden access in war zone.
     */
    public static ProtectionResult forbiddenWarZone()
    {
        return builder().isWarZone(true).build();
    }

    public static Builder builder()
    {
        return new Builder();
    }

    private final boolean hasAccess;
    private final boolean isSafeZone;
    private final boolean isWarZone;
    private final boolean isEagleFeather;
    private final boolean factionPerm;
    private final boolean isAdmin;

    ProtectionResult(final Builder builder)
    {
        this.hasAccess = builder.hasAccess;
        this.isSafeZone = builder.isSafeZone;
        this.isWarZone = builder.isWarZone;
        this.isEagleFeather = builder.hasEagleFeather;
        this.factionPerm = builder.hasFactionPerm;
        this.isAdmin = builder.isAdmin;
    }

    public boolean hasAccess()
    {
        return this.hasAccess;
    }

    public boolean isEagleFeather()
    {
        return this.isEagleFeather;
    }

    public boolean isSafeZone()
    {
        return this.isSafeZone;
    }

    public boolean isWarZone()
    {
        return this.isWarZone;
    }

    public boolean hasFactionPerms()
    {
        return this.factionPerm;
    }

    public boolean isAdmin()
    {
        return this.isAdmin;
    }

    public static class Builder
    {
        private boolean hasAccess;
        private boolean isSafeZone;
        private boolean isWarZone;
        private boolean hasEagleFeather;
        private boolean hasFactionPerm;
        private boolean isAdmin;

        public Builder()
        {
            this.hasAccess = false;
            this.isSafeZone = false;
            this.isWarZone = false;
            this.hasEagleFeather = false;
            this.hasFactionPerm = false;
            this.isAdmin = false;
        }

        public Builder hasAccess(final boolean hasAccess)
        {
            this.hasAccess = hasAccess;
            return this;
        }

        public Builder isAdmin(final boolean isAdmin)
        {
            this.isAdmin = isAdmin;
            return this;
        }

        public Builder hasEagleFeather(final boolean hasEagleFeather)
        {
            this.hasEagleFeather = hasEagleFeather;
            return this;
        }

        public Builder isSafeZone(final boolean isSafeZone)
        {
            this.isSafeZone = isSafeZone;
            return this;
        }

        public Builder isWarZone(final boolean isWarZone)
        {
            this.isWarZone = isWarZone;
            return this;
        }

        public Builder factionPerm(final boolean hasFactionPerm)
        {
            this.hasFactionPerm = hasFactionPerm;
            return this;
        }

        public ProtectionResult build()
        {
            return new ProtectionResult(this);
        }
    }
}
