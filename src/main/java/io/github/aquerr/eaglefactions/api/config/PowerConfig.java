package io.github.aquerr.eaglefactions.api.config;

public interface PowerConfig extends ConfigReloadable
{
	float getGlobalMaxPower();

	float getStartingPower();

	float getPowerIncrement();

	float getPowerDecrement();

	float getKillAward();

	float getPenalty();

	float getNeededPowerPercentageToAttack();
}
