package io.github.aquerr.eaglefactions.api.entities;

import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Strings;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.UUID;

public class FactionHome
{
    private final Vector3i BlockPosition;
    private final UUID WorldUUID;

    public FactionHome(@Nullable UUID worldUUID, @Nullable Vector3i blockPosition)
    {
        this.BlockPosition = blockPosition;
        this.WorldUUID = worldUUID;
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
        return WorldUUID;
    }

    public Vector3i getBlockPosition()
    {
        return BlockPosition;
    }

    @Override
    public String toString()
    {
        return this.WorldUUID.toString() + "|" + this.BlockPosition.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactionHome that = (FactionHome) o;
        return Objects.equals(BlockPosition, that.BlockPosition) && Objects.equals(WorldUUID, that.WorldUUID);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(BlockPosition, WorldUUID);
    }
}
