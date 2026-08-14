package com.fooze.disablesablebutton;

import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.contents.TranslatableContents;

public final class SableButtonHelper {
    private SableButtonHelper() {
    }

    public static boolean isSableButton(Button button) {
        return button.getMessage().getContents() instanceof TranslatableContents contents
                && contents.getKey().equals("options.sable_menu");
    }
}