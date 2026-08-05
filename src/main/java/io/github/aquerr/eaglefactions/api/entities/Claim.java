package io.github.aquerr.eaglefactions.api.entities;

import org.spongepowered.math.vector.Vector3i;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Claim
{
    private final String worldId;
    private final Vector3i chunkPosition;

    private final Set<UUID> owners;
    private final boolean accessibleByFaction;

    public Claim(String worldId, Vector3i chunkPosition)
    {
        this(worldId, chunkPosition, Collections.emptySet(), true);
    }

    public Claim(String worldId, Vector3i chunkPosition, final Set<UUID> owners, final boolean accessibleByFaction)
    {
        this.worldId = worldId;
        this.chunkPosition = chunkPosition;
        this.accessibleByFaction = accessibleByFaction;
        this.owners = Collections.unmodifiableSet(owners);
    }

    public String getWorldId()
    {
        return this.worldId;
    }

    public Vector3i getChunkPosition()
    {
        return this.chunkPosition;
    }

    public Set<UUID> getOwners()
    {
        return this.owners;
    }

    public boolean isAccessibleByFaction()
    {
        return this.accessibleByFaction;
    }

    public boolean hasAccess(final UUID playerUniqueId)
    {
        if (this.accessibleByFaction)
            return true;
        return this.owners.contains(playerUniqueId);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Claim claim = (Claim) o;
        return worldId.equals(claim.worldId) &&
                chunkPosition.equals(claim.chunkPosition);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(worldId, chunkPosition);
    }

    @Override
    public String toString()
    {
        return this.worldId + "|" + this.chunkPosition.toString();
    }
}
