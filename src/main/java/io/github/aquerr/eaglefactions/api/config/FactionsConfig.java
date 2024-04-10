package io.github.aquerr.eaglefactions.api.config;

import io.github.aquerr.eaglefactions.api.entities.Rank;
import org.spongepowered.configurate.ConfigurationNode;
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
		private ConfigurationNode value;

		public CostConfigDefinition()
		{

		}

		public String getType()
		{
			return type;
		}

		public ConfigurationNode getValue()
		{
			return value;
		}

		public void setType(String type)
		{
			this.type = type;
		}

		public void setValue(ConfigurationNode value)
		{
			this.value = value;
		}
	}
}
