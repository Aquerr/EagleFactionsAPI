package io.github.aquerr.eaglefactions.api.config;

public interface BluemapConfig extends ConfigReloadable
{
    boolean isBluemapIntegrationEnabled();

    int getBluemapFactionColor();

    int getBluemapSafezoneColor();

    int getBluemapWarzoneColor();

    String getBluemapFactionHomeIcon();

    boolean showBluemapFactionLeader();

    boolean showBluemapMemberInfo();
}
