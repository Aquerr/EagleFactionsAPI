package io.github.aquerr.eaglefactions.api.messaging;

import io.github.aquerr.eaglefactions.api.exception.CommandException;
import net.minecraft.network.chat.Component;

public interface MessageService
{
    Component resolveMessageWithPrefix(String messageKey);

    Component resolveMessageWithPrefix(String messageKey, Object... args);

    CommandException resolveExceptionWithMessage(String messageKey);

    CommandException resolveExceptionWithMessage(String messageKey, Object... args);

    CommandException resolveExceptionWithMessageAndThrowable(String messageKey, Throwable throwable);

    Component resolveComponentWithMessage(String messageKey);

    Component resolveComponentWithMessage(String messageKey, Object... args);

    String resolveMessage(String messageKey);

    String resolveMessage(String messageKey, Object... args);
}
