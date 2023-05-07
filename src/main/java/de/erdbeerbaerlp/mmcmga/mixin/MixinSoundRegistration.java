package de.erdbeerbaerlp.mmcmga.mixin;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.resources.sounds.SoundEventRegistration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(SoundEventRegistration.class)
public class MixinSoundRegistration {
    @Inject(method = "getSounds", cancellable = true, at = @At(value = "RETURN", target = "Lnet/minecraft/client/resources/sounds/SoundEventRegistration;sounds:Ljava/util/List;"))
    public void getSounds(CallbackInfoReturnable<List<Sound>> cir) {
        final List<Sound> allSounds = cir.getReturnValue();
        final ArrayList<Sound> filteredSounds = new ArrayList<>();
        for (Sound sound : allSounds) {
            switch (sound.getLocation().getPath()) {
                case "music/game/a_familiar_room":
                case "music/game/bromeliad":
                case "music/game/relic":
                case "music/game/crescent_dunes":
                case "music/game/left_to_bloom":
                case "music/game/floating_dream":
                case "music/game/comforting_memories":
                case "music/game/one_more_day":
                case "music/game/echo_in_the_wind":
                case "music/game/infinite_amethyst":
                case "music/game/ancestry":
                case "music/game/wending":
                case "music/game/an_ordinary_day":
                case "music/game/stand_tall":
                case "music/game/nether/soulsand_valley/so_below":
                case "music/game/nether/nether_wastes/rubedo":
                case "music/game/nether/crimson_forest/chrysopoeia":
                case "music/game/swamp/aerie":
                    continue;
                default:
                    filteredSounds.add(sound);
            }
        }
        cir.setReturnValue(filteredSounds);
    }
}
