package io.github.aquerr.eaglefactions.api.messaging.chat;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import net.kyori.adventure.audience.ForwardingAudience;

public interface FactionAudience extends ForwardingAudience
{
	/**
	 * Gets faction that this audience represents.
	 * @return the faction.
	 */
	Faction getFaction();
}
