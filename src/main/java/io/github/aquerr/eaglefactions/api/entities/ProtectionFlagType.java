package io.github.aquerr.eaglefactions.api.entities;

/**
 * En enum representing protection flag types which can be applied on a faction.
 */
public enum ProtectionFlagType
{
    /**
     * Flag representing if monsters should spawn in faction's territory.
     */
    SPAWN_MONSTERS("SPAWN_MONSTERS"),

    /**
     * Flag representing if animals should spawn in faction's territory.
     */
    SPAWN_ANIMALS("SPAWN_ANIMALS"),

    /**
     * Flag representing if fire should spread in faction's territory.
     */
    FIRE_SPREAD("FIRE_SPREAD"),

    /**
     * Flag representing if explosions are allowed in faction's territory.
     */
    ALLOW_EXPLOSION("ALLOW_EXPLOSION"),

    /**
     * Flag representing if mob grief is allowed in faction's territory.
     */
    MOB_GRIEF("MOB_GRIEF"),

    /**
     * Flag representing if PVP is allowed in faction's territory.
     */
    PVP("PVP"),

    /**
     * Flag representing if power can be lost in faction's territory.
     */
    TERRITORY_POWER_LOSS("TERRITORY_POWER_LOSS");

    private final String name;

    ProtectionFlagType(final String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
