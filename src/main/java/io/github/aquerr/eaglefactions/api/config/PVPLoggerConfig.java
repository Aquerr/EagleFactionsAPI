package io.github.aquerr.eaglefactions.api.config;

import java.util.Set;

public interface PVPLoggerConfig extends ConfigReloadable
{
	boolean isPVPLoggerActive();

	int getPVPLoggerBlockTime();

	Set<String> getBlockedCommandsDuringFight();

	boolean shouldDisplayPvpLoggerInScoreboard();
}
