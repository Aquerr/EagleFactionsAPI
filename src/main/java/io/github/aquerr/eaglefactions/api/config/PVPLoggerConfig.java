package io.github.aquerr.eaglefactions.api.config;

import java.util.Set;

public interface PVPLoggerConfig
{
	void reload();

	boolean isPVPLoggerActive();

	int getPVPLoggerBlockTime();

	Set<String> getBlockedCommandsDuringFight();

	boolean shouldDisplayPvpLoggerInScoreboard();
}
