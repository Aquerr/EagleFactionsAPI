package io.github.aquerr.eaglefactions.api.config;

import io.github.aquerr.eaglefactions.api.entities.Rank;

import java.util.List;
import java.util.Map;

public interface FactionsConfig extends ConfigReloadable
{
	String getLanguageTag();

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

	boolean shouldDelayClaim();

	int getClaimDelay();

	boolean shouldClaimByItems();

	Map<String, Integer> getRequiredItemsToClaim();

	boolean canUseFactionChest();

	boolean requireConnectedClaims();

	boolean getFactionCreationByItems();

	Map<String, Integer> getRequiredItemsToCreateFaction();

	boolean getBlockEnteringFactions();

	boolean shouldBlockEnteringSafezoneFromWarzone();

	boolean canAttackOnlyAtNight();

	long getMaxInactiveTime();

	boolean shouldNotifyWhenFactionRemoved();
	boolean shouldNotifyWHenFactionCreated();

	boolean shouldShowOnlyPlayerFactionsClaimsInMap();
	
	boolean shouldRegenerateChunksWhenFactionRemoved();

	boolean shouldInformAboutAttack();
	boolean shouldInformAboutDestroy();
	boolean shouldShowAttackedClaim();
	boolean shouldShowDestroyedClaim();

    boolean shouldShowAttackInBossBar();

	List<Rank> getDefaultRanks();

	String getDefaultRankName();
}
