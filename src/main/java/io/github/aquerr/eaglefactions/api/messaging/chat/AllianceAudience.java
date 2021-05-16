package io.github.aquerr.eaglefactions.api.messaging.chat;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import net.kyori.adventure.audience.Audience;

import java.util.Set;

public interface AllianceAudience extends Audience
{
	/**
	 * Gets factions that are the audience for receiving the alliance messages.
	 * @return the set of factions.
	 */
	Set<Faction> getFactions();
}
