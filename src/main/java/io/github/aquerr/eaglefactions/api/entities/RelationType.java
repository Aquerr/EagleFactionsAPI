package io.github.aquerr.eaglefactions.api.entities;

import java.util.Optional;
import java.util.stream.Stream;

public enum RelationType
{
    NONE("NONE"), // Also known as armistice,
    SAME_FACTION("SAME_FACTION"),
    ALLIANCE("ALLIANCE"),
    TRUCE("TRUCE"),
    ENEMY("ENEMY");

    final String name;

    RelationType(final String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public static Optional<RelationType> findByName(String name)
    {
        return Stream.of(values())
                .filter(relationType -> relationType.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
