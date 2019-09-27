package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.entity.MoveEntityEvent;

import java.util.Optional;

public interface FactionAreaEnterEvent extends MoveEntityEvent
{
	/**
	 * Gets the player that triggered the event.
	 * @return {@link Player} object.
	 */
	Player getCreator();

	/**
	 * Gets faction owning the claim (chunk) that the player has entered to.
	 *
	 * @return Faction or Optional.empty if left claim belongs to wilderness.
	 *
	 * Clients can cancel this event by sending <tt>true</tt> to {@link Cancellable#setCancelled(boolean)} method.
	 */
	Optional<Faction> getEnteredFaction();

	/**
	 * Gets faction owning the claim (chunk) that player has left.
	 *
	 * @return Faction or Optional.empty if entered claim belongs to wilderness.
	 *
	 * Clients can cancel this event by sending <tt>true</tt> to {@link Cancellable#setCancelled(boolean)} method.
	 */
	Optional<Faction> getLeftFaction();
}
