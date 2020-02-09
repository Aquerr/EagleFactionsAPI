package io.github.aquerr.eaglefactions.api.messaging.chat;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import org.spongepowered.api.text.channel.MessageChannel;

import java.util.Set;

public interface AllianceMessageChannel extends MessageChannel
{
	/**
	 * Gets factions that this channel is sending messages to.
	 * @return the set of factions.
	 */
	Set<Faction> getFactions();
}
