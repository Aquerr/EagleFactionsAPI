package io.github.aquerr.eaglefactions.api.config;

public interface BluemapConfig
{
    void reload();

    boolean isBluemapIntegrationEnabled();

    int getBluemapFactionColor();

    int getBluemapSafezoneColor();

    int getBluemapWarzoneColor();

    String getBluemapFactionHomeIcon();

    boolean showBluemapFactionLeader();

    boolean showBluemapMemberInfo();
}
