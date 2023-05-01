package io.github.aquerr.eaglefactions.api.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import java.util.Objects;

public class ServerLocation
{
    private final BlockPos blockPos;
    private final Level level;

    public static ServerLocation of(Level level, BlockPos blockPos)
    {
        return new ServerLocation(level, blockPos);
    }

    private ServerLocation(Level level, BlockPos blockPos)
    {
        this.level = level;
        this.blockPos = blockPos;
    }

    public BlockPos getBlockPos()
    {
        return blockPos;
    }

    public Level getLevel()
    {
        return level;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerLocation that = (ServerLocation) o;
        return Objects.equals(blockPos, that.blockPos) && Objects.equals(level, that.level);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(blockPos, level);
    }

    @Override
    public String toString()
    {
        return "ServerLocation{" +
                "blockPos=" + blockPos +
                ", level=" + level +
                '}';
    }
}
