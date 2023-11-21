package io.github.aquerr.eaglefactions.api.config;

import io.github.aquerr.eaglefactions.api.entities.ChatEnum;
import io.github.aquerr.eaglefactions.api.entities.FactionMemberType;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;

import java.util.Map;
import java.util.Set;

public interface ChatConfig extends ConfigReloadable
{
	boolean shouldSuppressOtherFactionsMessagesWhileInTeamChat();

	boolean shouldDisplayProtectionSystemMessages();

	TextComponent getFactionStartPrefix();

	TextComponent getFactionEndPrefix();

	String getChatPrefixType();

	boolean canColorTags();

	TextColor getDefaultTagColor();

	boolean isFactionPrefixFirstInChat();

	TextComponent getNonFactionPlayerPrefix();

	boolean shouldShowFactionEnterPhrase();

	Map<ChatEnum, Set<FactionMemberType>> getVisibleRanks();

    boolean shouldDisplayFactionTagsInTabList();
}
