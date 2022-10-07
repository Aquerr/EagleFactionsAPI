package io.github.aquerr.eaglefactions.api.config;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface ProtectionConfig
{
	void reload() throws IOException;

	Set<String> getClaimableWorldNames();

	Set<String> getNotClaimableWorldNames();

	Set<String> getSafeZoneWorldNames();

	Set<String> getWarZoneWorldNames();

	WhiteList getFactionWhitelists();

	WhiteList getSafeZoneWhitelists();

	WhiteList getWarZoneWhitelists();

	WhiteList getWildernessWhitelists();

	Set<String> getDetectedWorldNames();


	void addWorld(String worldName);

	boolean shouldProtectWildernessFromPlayers();

	boolean shouldAllowExplosionsByOtherPlayersInClaims();

	boolean shouldProtectWarzoneFromPlayers();

    List<String> getBlockedCommandsInOtherFactionsTerritory();

    interface WhiteList
	{
		Set<String> getWhiteListedItems();

		Set<String> getWhiteListedPlaceDestroyBlocks();

		Set<String> getWhiteListedInteractBlocks();

		default boolean isItemWhiteListed(String itemId)
		{
			final Set<String> test = getWhiteListedItems();
			return test.contains(itemId);
		}

		default boolean isBlockWhitelistedForPlaceDestroy(String blockId)
		{
			return getWhiteListedPlaceDestroyBlocks().contains(blockId);
		}

		default boolean isBlockWhiteListedForInteraction(String blockId)
		{
			return getWhiteListedInteractBlocks().contains(blockId);
		}
	}
}
