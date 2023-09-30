package de.erdbeerbaerlp.mmcmga;

import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;

public class MixinCon implements IMixinConnector {
    /**
     * Connect to Mixin
     */
    @Override
    public void connect() {
        Mixins.addConfiguration("MMCMGA.mixins.json");
    }
}