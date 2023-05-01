package io.github.aquerr.eaglefactions.api.math;

public class Vector3i implements Comparable<Vector3i>
{
    private final int x;
    private final int y;
    private final int z;

    public static Vector3i from(int x, int y, int z)
    {
        return new Vector3i(x, y, z);
    }

    public Vector3i(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int lengthSquared() {
        return x * x + y * y + z * z;
    }

    @Override
    public int compareTo(Vector3i v)
    {
        return lengthSquared() - v.lengthSquared();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
