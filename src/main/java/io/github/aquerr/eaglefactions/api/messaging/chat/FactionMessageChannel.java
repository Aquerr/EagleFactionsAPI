package io.github.aquerr.eaglefactions.api.messaging.chat;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import org.spongepowered.api.text.channel.MessageChannel;

public interface FactionMessageChannel extends MessageChannel
{
	/**
	 * Gets the faction that this channel is sending messages to.
	 * @return the faction.
	 */
	Faction getFaction();
}
