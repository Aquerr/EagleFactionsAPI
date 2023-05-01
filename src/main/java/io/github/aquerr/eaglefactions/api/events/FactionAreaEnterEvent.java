package io.github.aquerr.eaglefactions.api.events;

import com.mojang.math.Vector3d;
import io.github.aquerr.eaglefactions.api.entities.Faction;
import net.minecraft.server.level.ServerPlayer;

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
	ServerPlayer getCreator();

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
	 * See {@link org.spongepowered.api.event.entity.MoveEntityEvent} for information about this method.
	 */
	Vector3d getOriginalPosition();

	/**
	 * See {@link org.spongepowered.api.event.entity.MoveEntityEvent} for information about this method.
	 */
	Vector3d getDestinationPosition();

	/**
	 * See {@link org.spongepowered.api.event.entity.MoveEntityEvent} for information about this method.
	 */
	void setDestinationPosition(Vector3d position);

	interface Pre extends FactionAreaEnterEvent
	{

	}

	interface Post extends FactionAreaEnterEvent
	{

	}
}
