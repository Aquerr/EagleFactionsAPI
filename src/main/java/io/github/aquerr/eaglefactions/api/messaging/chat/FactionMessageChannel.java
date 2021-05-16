package io.github.aquerr.eaglefactions.api.messaging.chat;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import net.kyori.adventure.audience.Audience;

public interface FactionMessageChannel extends Audience
{
	/**
	 * Gets faction that are the audience for receiving the faction messages.
	 * @return the faction.
	 */
	Faction getFaction();
}
