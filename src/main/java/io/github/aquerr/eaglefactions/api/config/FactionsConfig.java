package io.github.aquerr.eaglefactions.api.config;

import java.util.Map;

public interface FactionsConfig
{
	void reload();

	String getLanguageFileName();

	int getMaxNameLength();

	int getMinNameLength();

	int getMaxTagLength();

	int getMinTagLength();

	boolean isPlayerLimit();

	int getPlayerLimit();

	int getAttackTime();

    float getPercentageDamageReductionInOwnTerritory();

    boolean isFactionFriendlyFire();

	boolean isTruceFriendlyFire();

	boolean isAllianceFriendlyFire();

	int getHomeDelayTime();

	int getHomeCooldown();

	boolean shouldDelayClaim();

	int getClaimDelay();

	boolean shouldBlockHomeAfterDeathInOwnFaction();

	int getHomeBlockTimeAfterDeathInOwnFaction();

	boolean shouldClaimByItems();

	Map<String, Integer> getRequiredItemsToClaim();

	boolean canUseFactionChest();

	boolean requireConnectedClaims();

	boolean getFactionCreationByItems();

	Map<String, Integer> getRequiredItemsToCreateFaction();

	boolean getBlockEnteringFactions();

	boolean shouldBlockEnteringSafezoneFromWarzone();

	boolean shouldSpawnAtHomeAfterDeath();

	boolean canAttackOnlyAtNight();

	boolean canHomeBetweenWorlds();

	long getMaxInactiveTime();

	boolean shouldNotifyWhenFactionRemoved();
	boolean shouldNotifyWHenFactionCreated();

	boolean shouldShowOnlyPlayerFactionsClaimsInMap();
	
	boolean shouldRegenerateChunksWhenFactionRemoved();

	boolean canPlaceHomeOutsideFactionClaim();

	boolean shouldInformAboutAttack();
	boolean shouldInformAboutDestroy();
	boolean shouldShowAttackedClaim();
	boolean shouldShowDestroyedClaim();

    boolean shouldShowAttackInBossBar();
}
