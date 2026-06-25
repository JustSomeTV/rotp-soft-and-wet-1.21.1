package com.jst.rotp_soft_and_wet.init.power;

import static com.github.standobyte.jojo.core.JojoRegistries.ABILITY_TYPES;

import com.github.standobyte.jojo.powersystem.ability.AbilityType;
import com.jst.rotp_soft_and_wet.jojoimpl.stands.softandwet.SoftAndWetBubbleLaunch;
import net.neoforged.neoforge.registries.DeferredHolder;

public class AddonStandAbilities {
    public static void load() {}

    public static final DeferredHolder<AbilityType<?>,AbilityType<SoftAndWetBubbleLaunch>> BUBBLE_LAUNCH = ABILITY_TYPES.register(
            "bubble_launch", key -> new AbilityType<>(key, SoftAndWetBubbleLaunch::new));

//    public static final DeferredHolder<AbilityType<?>, AbilityType<ShotAbility>> EMP_SHOT = ABILITY_TYPES.register(
//            "emp_shot", key -> new AbilityType<>(key, ShotAbility::new));
}
