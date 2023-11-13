package io.github.aquerr.eaglefactions.api.config;

public interface DynmapConfig extends ConfigReloadable
{
	boolean isDynmapIntegrationEnabled();

	int getDynmapFactionColor();

	int getDynmapSafezoneColor();

	int getDynmapWarzoneColor();

	String getDynmapFactionHomeIcon();

	boolean showDynmapFactionLeader();

	boolean showDynmapMemberInfo();
}
