package io.github.aquerr.eaglefactions.api.config;

import org.spongepowered.api.text.Text;

public interface ChatConfig
{

	void reload();

	boolean shouldSupressOtherFactionsMessagesWhileInTeamChat();

	boolean shouldDisplayProtectionSystemMessages();

	Text getFactionStartPrefix();

	Text getFactionEndPrefix();

	String getChatPrefixType();

	boolean shouldDisplayRank();

	boolean canColorTags();

	boolean isFactionPrefixFirstInChat();
}
