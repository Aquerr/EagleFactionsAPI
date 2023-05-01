package io.github.aquerr.eaglefactions.api.config;

import io.github.aquerr.eaglefactions.api.entities.ChatEnum;
import io.github.aquerr.eaglefactions.api.entities.FactionMemberType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;

import java.util.Map;
import java.util.Set;

public interface ChatConfig
{
	void reload();

	boolean shouldSuppressOtherFactionsMessagesWhileInTeamChat();

	boolean shouldDisplayProtectionSystemMessages();

	Component getFactionStartPrefix();

	Component getFactionEndPrefix();

	String getChatPrefixType();

	boolean canColorTags();

	TextColor getDefaultTagColor();

	boolean isFactionPrefixFirstInChat();

	Component getNonFactionPlayerPrefix();

	boolean shouldShowFactionEnterPhrase();

	Map<ChatEnum, Set<FactionMemberType>> getVisibleRanks();
}
