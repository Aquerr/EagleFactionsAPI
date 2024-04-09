package io.github.aquerr.eaglefactions.api.managers.creation;

import io.github.aquerr.eaglefactions.api.exception.CouldNotCreateFactionException;
import io.github.aquerr.eaglefactions.api.logic.cost.OperationCost;
import net.kyori.adventure.audience.Audience;

import java.util.List;

/**
 * A manager responsible for creating factions.
 *
 * It is used when player/console creates the faction through command.
 * The default implementation of this manager collects payment from player for creating the faction and runs creation events.
 *
 * You should prefer using this manager to preserve creation logic instead of saving faction directly to storage via {@link io.github.aquerr.eaglefactions.api.storage.StorageManager}.
 */
public interface FactionCreationManager
{

    void setCreationCosts(List<OperationCost> creationCosts);

    void addCreationCost(OperationCost creationCost);

    void createFaction(Audience audience, String factionName, String factionTag) throws CouldNotCreateFactionException;
}
