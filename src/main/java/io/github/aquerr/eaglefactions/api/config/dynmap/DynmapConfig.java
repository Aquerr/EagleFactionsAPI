package io.github.aquerr.eaglefactions.api.config.dynmap;

public interface DynmapConfig
{
	boolean isDynmapIntegrationEnabled();

	int getDynmapFactionColor();

	int getDynmapSafezoneColor();

	int getDynmapWarzoneColor();

	String getDynmapFactionHomeIcon();

	boolean showDynmapFactionLeader();

	boolean showDynmapMemberInfo();
}
