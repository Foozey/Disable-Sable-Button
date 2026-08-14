package com.fooze.disablesablebutton.mixin;

import com.fooze.disablesablebutton.SableButtonHelper;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.layouts.LayoutSettings;
import net.minecraft.client.gui.layouts.LinearLayout;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LinearLayout.class)
public abstract class LinearLayoutMixin {
    @Inject(method = "addChild(Lnet/minecraft/client/gui/layouts/LayoutElement;Lnet/minecraft/client/gui/layouts/LayoutSettings;)Lnet/minecraft/client/gui/layouts/LayoutElement;", at = @At("HEAD"), cancellable = true)
    private <T extends LayoutElement> void disablesablebutton$skipSableButton(
            T child, LayoutSettings settings, CallbackInfoReturnable<T> callback) {
        if (child instanceof Button button && SableButtonHelper.isSableButton(button)) {
            callback.setReturnValue(child);
        }
    }
}