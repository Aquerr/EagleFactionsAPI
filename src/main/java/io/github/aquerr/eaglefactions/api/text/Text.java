package io.github.aquerr.eaglefactions.api.text;

import java.util.Objects;

public class Text
{
    private String value;
    private String color = "white";

    public Text(String value, String color)
    {
        this.value = value;
        this.color = color;
    }

    public Text(String value)
    {
        this.value = value;
    }

    public static Text of(String value)
    {
        return new Text(value);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(value, text.value) && Objects.equals(color, text.color);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(value, color);
    }

    @Override
    public String toString()
    {
        return "Text{" +
                "value='" + value + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
