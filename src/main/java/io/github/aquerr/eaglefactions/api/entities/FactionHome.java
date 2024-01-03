package io.github.aquerr.eaglefactions.api.entities;

import com.google.common.base.Strings;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;
import java.util.UUID;

public class FactionHome
{
    private final Vector3i blockPosition;
    private final UUID worldUUID;

    public FactionHome(@Nullable UUID worldUUID, @Nullable Vector3i blockPosition)
    {
        this.blockPosition = blockPosition;
        this.worldUUID = worldUUID;
    }

    public static FactionHome from(String worldUUIDAndBlockPositionString)
    {
        if (Strings.isNullOrEmpty(worldUUIDAndBlockPositionString))
            return null;

        try
        {
            String splitter = "\\|";
            String worldUUIDString = worldUUIDAndBlockPositionString.split(splitter)[0];
            String vectorsString = worldUUIDAndBlockPositionString.split(splitter)[1];

            String[] vectors = vectorsString.replace("(", "").replace(")", "").replace(" ", "").split(",");

            int x = Integer.parseInt(vectors[0]);
            int y = Integer.parseInt(vectors[1]);
            int z = Integer.parseInt(vectors[2]);

            Vector3i blockPosition = Vector3i.from(x, y, z);

            UUID worldUUID = UUID.fromString(worldUUIDString);
            return new FactionHome(worldUUID, blockPosition);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
    }

    public UUID getWorldUUID()
    {
        return worldUUID;
    }

    public Vector3i getBlockPosition()
    {
        return blockPosition;
    }

    @Override
    public String toString()
    {
        return this.worldUUID.toString() + "|" + this.blockPosition.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactionHome that = (FactionHome) o;
        return Objects.equals(blockPosition, that.blockPosition) && Objects.equals(worldUUID, that.worldUUID);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(blockPosition, worldUUID);
    }
}
