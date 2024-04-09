package io.github.aquerr.eaglefactions.api.config;

import io.github.aquerr.eaglefactions.api.entities.Rank;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;

import java.util.List;
import java.util.Map;

public interface FactionsConfig extends ConfigReloadable
{
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

	boolean canUseFactionChest();

	boolean requireConnectedClaims();

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

	List<CostConfigDefinition> getFactionCreationOperationCostDefinitions();

	List<CostConfigDefinition> getClaimOperationCostDefinitions();

	@ConfigSerializable
	class CostConfigDefinition
	{
		@Setting("type")
		private String type;
		@Setting("value")
		private Object value;

		public CostConfigDefinition(String type, Object value)
		{
			this.type = type;
			this.value = value;
		}

		public String getType()
		{
			return type;
		}

		public Object getValue()
		{
			return value;
		}
	}
}
