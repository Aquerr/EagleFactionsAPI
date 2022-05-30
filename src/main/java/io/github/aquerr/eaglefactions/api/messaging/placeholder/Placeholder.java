package io.github.aquerr.eaglefactions.api.messaging.placeholder;

/**
 * Default enum with placeholders available in EagleFactions.
 */
public enum Placeholder
{
    FACTION_NAME("faction_name"),
    FACTION_TAG("faction_tag"),
    FACTION_TAG_WITH_BRACKETS("faction_tag_with_brackets"),
    FACTION_POWER("faction_power"),
    FACTION_MAX_POWER("faction_maxpower"),
    FACTION_LAST_ONLINE("faction_last_online"),
    FACTION_CLAIMS_COUNT("claims_count"),
    FACTION_OFFICERS_COUNT("officers_count"),
    FACTION_MEMBERS_COUNT("members_count"),
    FACTION_RECRUITS_COUNT("recruits_count"),
    FACTION_ALLIANCES("alliances"),
    FACTION_ENEMIES("enemies"),
    FACTION_TRUCES("truces"),

    PLAYER_POWER("player_power"),
    PLAYER_MAX_POWER("player_maxpower"),
    PLAYER_LAST_ONLINE("player_last_online");

    private final String name;

    Placeholder(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
