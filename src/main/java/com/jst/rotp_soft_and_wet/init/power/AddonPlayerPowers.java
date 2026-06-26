package com.jst.rotp_soft_and_wet.init.power;

import com.github.standobyte.jojo.core.JojoRegistries;
import com.github.standobyte.jojo.powersystem.playerpower.PlayerPowerType;
import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import com.jst.rotp_soft_and_wet.jojoimpl.powers.spin.SpinPowerType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AddonPlayerPowers {
    public static final DeferredRegister<PlayerPowerType<?>> PLAYER_POWERS = DeferredRegister.create(JojoRegistries.PLAYER_POWER_TYPES_REG, RipplesOfThePastSoftAndWet.MOD_ID);

    public static final Supplier<SpinPowerType> SPIN = SpinPowerType.SPIN;
}
