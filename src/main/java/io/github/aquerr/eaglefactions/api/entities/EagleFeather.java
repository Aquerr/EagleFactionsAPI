package io.github.aquerr.eaglefactions.api.entities;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.Color;

import java.util.ArrayList;
import java.util.List;

public final class EagleFeather
{
    private EagleFeather()
    {

    }

    public static Component getDisplayName()
    {
        return Component.text("Eagle's Feather", TextColor.color(Color.DARK_MAGENTA));
    }

    public static ItemStack getEagleFeatherItem()
    {
        List<Component> eagleFeatherLore = new ArrayList<>();
        eagleFeatherLore.add(Component.text("A mystical feather that comes from").append(Component.text(" The Greatest Eagle",
                Style.style()
                        .color(TextColor.color(Color.YELLOW))
                        .decorate(TextDecoration.BOLD, TextDecoration.ITALIC)
                        .build())));
        eagleFeatherLore.add(Component.empty());
        eagleFeatherLore.add(Component.text("It looks like a key. Maybe it could be used somewhere?",
                Style.style()
                        .color(TextColor.color(Color.GRAY))
                        .decoration(TextDecoration.ITALIC, true)
                        .build()));

        return ItemStack.builder()
               .itemType(ItemTypes.FEATHER)
               .quantity(1)
               .add(Keys.DISPLAY_NAME, getDisplayName())
               .add(Keys.LORE, eagleFeatherLore)
               .build();
    }
}
