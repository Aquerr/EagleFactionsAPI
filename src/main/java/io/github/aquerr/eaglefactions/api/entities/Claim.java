package io.github.aquerr.eaglefactions.api.entities;

import com.flowpowered.math.vector.Vector3i;

import java.util.Objects;
import java.util.UUID;

public class Claim
{
    private final UUID worldUUID;
    private final Vector3i chunkPosition;

    public static Claim valueOf(String claimAsString)
    {
        String[] worldUUIDAndChunkPosition = claimAsString.split("\\|");
        UUID worldUUID = UUID.fromString(worldUUIDAndChunkPosition[0]);
        String[] vectors = worldUUIDAndChunkPosition[1].replace("(", "").replace(")", "").replace(" ", "").split(",");
        int x = Integer.parseInt(vectors[0]);
        int y = Integer.parseInt(vectors[1]);
        int z = Integer.parseInt(vectors[2]);
        Vector3i chunkPosition = Vector3i.from(x, y, z);
        return new Claim(worldUUID, chunkPosition);
    }

    public Claim(UUID worldUUID, Vector3i chunkPosition)
    {
        this.worldUUID = worldUUID;
        this.chunkPosition = chunkPosition;
    }

    public UUID getWorldUUID()
    {
        return this.worldUUID;
    }

    public Vector3i getChunkPosition()
    {
        return this.chunkPosition;
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
