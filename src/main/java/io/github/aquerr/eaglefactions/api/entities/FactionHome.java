package io.github.aquerr.eaglefactions.api.entities;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;

public class FactionHome
{
    private final Vector3i blockPosition;
    private final String worldId;

    public FactionHome(@Nullable String worldId, @Nullable Vector3i blockPosition)
    {
        this.blockPosition = blockPosition;
        this.worldId = worldId;
    }

    public static FactionHome from(String worldIdAndBlockPositionString)
    {
        if (worldIdAndBlockPositionString == null || worldIdAndBlockPositionString.isEmpty())
            return null;

        try
        {
            String splitter = "\\|";
            String worldIdString = worldIdAndBlockPositionString.split(splitter)[0];
            String vectorsString = worldIdAndBlockPositionString.split(splitter)[1];

            String[] vectors = vectorsString.replace("(", "").replace(")", "").replace(" ", "").split(",");

            int x = Integer.parseInt(vectors[0]);
            int y = Integer.parseInt(vectors[1]);
            int z = Integer.parseInt(vectors[2]);

            Vector3i blockPosition = Vector3i.from(x, y, z);

            return new FactionHome(worldIdString, blockPosition);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
    }

    public String getWorldId()
    {
        return worldId;
    }

    public Vector3i getBlockPosition()
    {
        return blockPosition;
    }

    @Override
    public String toString()
    {
        return this.worldId.toString() + "|" + this.blockPosition.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactionHome that = (FactionHome) o;
        return Objects.equals(blockPosition, that.blockPosition) && Objects.equals(worldId, that.worldId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(blockPosition, worldId);
    }
}
