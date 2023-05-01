package io.github.aquerr.eaglefactions.api.messaging.placeholder;

import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;

/**
 * Service for parsing and resolving EagleFactions placeholders.
 */
public interface PlaceholderService
{
    /**
     * Resolves given {@link Placeholder} on provided {@link net.minecraft.server.level.ServerPlayer}
     * @param serverPlayer that the placeholder will be resolved on.
     * @param placeholder to resolve.
     * @return optional String as result. Empty when placeholder could not be resolved.
     */
    Optional<String> resolvePlaceholder(ServerPlayer serverPlayer, Placeholder placeholder);
}
