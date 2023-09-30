package de.erdbeerbaerlp.mmcmga.mixin;

import de.erdbeerbaerlp.mmcmga.MMCMGA;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.sounds.WeighedSoundEvents;
import net.minecraft.client.sounds.Weighted;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Class used to log all resource locations of registered sounds, used for finding new ones
 */
@Mixin(targets = "net.minecraft.client.sounds.SoundManager.Preparations", remap = false)
public class MixinTest {
    @Redirect(method = "handleRegistration", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/sounds/Sound;getLocation()Lnet/minecraft/resources/ResourceLocation;"))
    private ResourceLocation test(Sound instance) {
        final ResourceLocation location = instance.getLocation();
        MMCMGA.LOGGER.info(location.toString());
        return location;
    }
}
