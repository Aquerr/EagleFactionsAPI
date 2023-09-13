package io.github.aquerr.eaglefactions.api.config;

public interface HomeConfig
{
    void reload();
    int getHomeCooldown();
    int getHomeDelayTime();
    boolean canHomeBetweenWorlds();
    boolean canPlaceHomeOutsideFactionClaim();
    boolean shouldBlockHomeAfterDeathInOwnFaction();
    int getHomeBlockTimeAfterDeathInOwnFaction();
    boolean shouldSpawnAtHomeAfterDeath();
    boolean isSourceTeleportAnimationEnabled();
    boolean isDestinationTeleportAnimationEnabled();
}
