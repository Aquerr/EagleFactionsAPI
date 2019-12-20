package io.github.aquerr.eaglefactions.api.events;

import io.github.aquerr.eaglefactions.api.entities.Faction;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.world.World;

import java.util.Optional;

/**
 * Event that is fired when player enters or leave a claimed territory.
 *
 * This event is NOT fired if player moves between territories which belongs to the same faction.
 */
public interface FactionAreaEnterEvent extends Event, Cancellable
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

	/**
	 * Checks if the event has been cancelled.
	 * @return true if cancelled, false if not.
	 */
	boolean isCancelled();

	/**
	 * Sets the status of the event.
	 * @param cancelled
	 */
	void setCancelled(boolean cancelled);

	/**
	 * See {@link org.spongepowered.api.event.entity.MoveEntityEvent} for information about this method.
	 */
	Transform<World> getFromTransform();

	/**
	 * See {@link org.spongepowered.api.event.entity.MoveEntityEvent} for information about this method.
	 */
	Transform<World> getToTransform();

	/**
	 * See {@link org.spongepowered.api.event.entity.MoveEntityEvent} for information about this method.
	 */
	void setToTransform(Transform<World> transform);
}
