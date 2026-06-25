package com.jst.rotp_soft_and_wet.init.power;

import static com.github.standobyte.jojo.core.JojoRegistries.ABILITY_TYPES;

import com.github.standobyte.jojo.powersystem.ability.AbilityType;
import com.jst.rotp_soft_and_wet.jojoimpl.stands.softandwet.*;
import net.neoforged.neoforge.registries.DeferredHolder;

public class AddonStandAbilities {
    public static void load() {}

    public static final DeferredHolder<AbilityType<?>,AbilityType<SoftAndWetBubbleBarrage>> BUBBLE_BARRAGE = ABILITY_TYPES.register(
            "bubble_barrage", key -> new AbilityType<>(key, SoftAndWetBubbleBarrage::new));

    public static final DeferredHolder<AbilityType<?>,AbilityType<SoftAndWetBubbleShoot>> BUBBLE_SHOOT = ABILITY_TYPES.register(
            "bubble_shoot", key -> new AbilityType<>(key, SoftAndWetBubbleShoot::new));

    public static final DeferredHolder<AbilityType<?>,AbilityType<SoftAndWetBubbleBlindness>> BUBBLE_BLINDING = ABILITY_TYPES.register(
            "bubble_blinding", key -> new AbilityType<>(key, SoftAndWetBubbleBlindness::new));

    public static final DeferredHolder<AbilityType<?>,AbilityType<SoftAndWetBubbleFriction>> BUBBLE_FRICTION = ABILITY_TYPES.register(
            "bubble_friction", key -> new AbilityType<>(key, SoftAndWetBubbleFriction::new));

    public static final DeferredHolder<AbilityType<?>,AbilityType<SoftAndWetBubbleMoisture>> BUBBLE_MOISTURE = ABILITY_TYPES.register(
            "bubble_moisture", key -> new AbilityType<>(key, SoftAndWetBubbleMoisture::new));
}
