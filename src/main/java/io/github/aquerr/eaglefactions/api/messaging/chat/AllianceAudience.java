package io.github.aquerr.eaglefactions.api.messaging.chat;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import net.kyori.adventure.audience.ForwardingAudience;

import java.util.Set;

public interface AllianceAudience extends ForwardingAudience
{
	/**
	 * Gets factions that this audience represents.
	 * @return the set of factions.
	 */
	Set<Faction> getFactions();
}
