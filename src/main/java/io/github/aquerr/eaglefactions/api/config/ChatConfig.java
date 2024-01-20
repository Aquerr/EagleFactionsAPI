package io.github.aquerr.eaglefactions.api.config;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;

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

    boolean shouldDisplayFactionTagsInTabList();
}
