package com.jst.rotp_soft_and_wet.jojoimpl.powers.spin;

import static com.github.standobyte.jojo.core.JojoRegistries.ABILITY_TYPES;
import static com.jst.rotp_soft_and_wet.init.power.AddonPlayerPowers.PLAYER_POWERS;

import com.github.standobyte.jojo.powersystem.MovesetBuilder;
import com.github.standobyte.jojo.powersystem.PowerType;
import com.github.standobyte.jojo.powersystem.playerpower.PlayerPowerType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;

public class SpinPowerType extends PlayerPowerType<SpinData> {
    public static final int UI_COLOR = 0xffc80000;

    protected SpinPowerType(ResourceLocation registryKey, MovesetBuilder abilitySet) {
        super(registryKey, abilitySet);
    }

    public static final DeferredHolder<PlayerPowerType<?>, SpinPowerType> SPIN = PLAYER_POWERS.register(
            "spin", key -> new SpinPowerType(key, new MovesetBuilder()

            ));

    @Override
    public SpinData newDataInstance() {
        return new SpinData();
    }
}
