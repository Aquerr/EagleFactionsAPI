package io.github.aquerr.eaglefactions.api.entities;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.entity.living.player.Player;

import java.util.*;

public class Claim
{
    private final UUID worldUUID;
    private final Vector3i chunkPosition;

    private final List<UUID> owners;
    private final boolean accessibleByFaction;

//    public static Claim valueOf(String claimAsString)
//    {
//        String[] worldUUIDAndChunkPosition = claimAsString.split("\\|");
//        UUID worldUUID = UUID.fromString(worldUUIDAndChunkPosition[0]);
//        String[] vectors = worldUUIDAndChunkPosition[1].replace("(", "").replace(")", "").replace(" ", "").split(",");
//        int x = Integer.parseInt(vectors[0]);
//        int y = Integer.parseInt(vectors[1]);
//        int z = Integer.parseInt(vectors[2]);
//        Vector3i chunkPosition = Vector3i.from(x, y, z);
//        return new Claim(worldUUID, chunkPosition);
//    }

    public Claim(UUID worldUUID, Vector3i chunkPosition)
    {
        this(worldUUID, chunkPosition, new ArrayList<>(), true);
    }

    public Claim(UUID worldUUID, Vector3i chunkPosition, final List<UUID> owners, final boolean accessibleByFaction)
    {
        this.worldUUID = worldUUID;
        this.chunkPosition = chunkPosition;
        this.accessibleByFaction = accessibleByFaction;
        this.owners = Collections.unmodifiableList(owners);
    }

    public UUID getWorldUUID()
    {
        return this.worldUUID;
    }

    public Vector3i getChunkPosition()
    {
        return this.chunkPosition;
    }

    public List<UUID> getOwners()
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
