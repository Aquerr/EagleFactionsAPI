package io.github.aquerr.eaglefactions.api.entities;

import io.github.aquerr.eaglefactions.api.math.Vector3i;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Claim
{
    private final UUID worldUUID;
    private final Vector3i chunkPosition;

    private final Set<UUID> owners;
    private final boolean accessibleByFaction;

    public Claim(UUID worldUUID, Vector3i chunkPosition)
    {
        this(worldUUID, chunkPosition, Collections.EMPTY_SET, true);
    }

    public Claim(UUID worldUUID, Vector3i chunkPosition, final Set<UUID> owners, final boolean accessibleByFaction)
    {
        this.worldUUID = worldUUID;
        this.chunkPosition = chunkPosition;
        this.accessibleByFaction = accessibleByFaction;
        this.owners = Collections.unmodifiableSet(owners);
    }

    public UUID getWorldUUID()
    {
        return this.worldUUID;
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
        return worldUUID.equals(claim.worldUUID) &&
                chunkPosition.equals(claim.chunkPosition);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(worldUUID, chunkPosition);
    }

    @Override
    public String toString()
    {
        return this.worldUUID.toString() + "|" + this.chunkPosition.toString();
    }
}
