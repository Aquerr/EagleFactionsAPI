package io.github.aquerr.eaglefactions.api.entities;

import org.spongepowered.api.entity.living.player.User;

import java.util.Optional;
import java.util.UUID;

public interface FactionPlayer
{
    String getName();

    UUID getUniqueId();

    Optional<String> getFactionName();

    Optional<FactionMemberType> getFactionRole();

    Optional<User> getUser();
}
