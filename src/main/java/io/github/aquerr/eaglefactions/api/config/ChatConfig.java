package io.github.aquerr.eaglefactions.api.config;

import io.github.aquerr.eaglefactions.api.entities.ChatEnum;
import io.github.aquerr.eaglefactions.api.entities.FactionMemberType;
import net.kyori.adventure.text.TextComponent;

import java.util.Map;
import java.util.Set;

public interface ChatConfig
{

	void reload();

	boolean shouldSuppressOtherFactionsMessagesWhileInTeamChat();

	boolean shouldDisplayProtectionSystemMessages();

	TextComponent getFactionStartPrefix();

	TextComponent getFactionEndPrefix();

	String getChatPrefixType();

	boolean canColorTags();

	boolean isFactionPrefixFirstInChat();

	TextComponent getNonFactionPlayerPrefix();

	boolean shouldShowFactionEnterPhrase();

	Map<ChatEnum, Set<FactionMemberType>> getVisibleRanks();
}
