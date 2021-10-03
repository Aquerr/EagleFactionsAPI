package io.github.aquerr.eaglefactions.api.config;

import io.github.aquerr.eaglefactions.api.entities.ChatEnum;
import io.github.aquerr.eaglefactions.api.entities.FactionMemberType;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColor;

import java.util.Map;
import java.util.Set;

public interface ChatConfig
{
	void reload();

	boolean shouldSuppressOtherFactionsMessagesWhileInTeamChat();

	boolean shouldDisplayProtectionSystemMessages();

	Text getFactionStartPrefix();

	Text getFactionEndPrefix();

	String getChatPrefixType();

	boolean canColorTags();

	TextColor getDefaultTagColor();

	boolean isFactionPrefixFirstInChat();

	Text getNonFactionPlayerPrefix();

	boolean shouldShowFactionEnterPhrase();

	Map<ChatEnum, Set<FactionMemberType>> getVisibleRanks();
}
