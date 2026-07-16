package com.jst.rotp_soft_and_wet.init.power;

import static com.github.standobyte.jojo.core.JojoRegistries.ABILITY_TYPES;

import com.github.standobyte.jojo.powersystem.ability.AbilityType;
import com.jst.rotp_soft_and_wet.jojoimpl.stands.killerqueen8.DeleteSheerHeartAttack;
import com.jst.rotp_soft_and_wet.jojoimpl.stands.killerqueen8.DetonateBombAbility;
import com.jst.rotp_soft_and_wet.jojoimpl.stands.killerqueen8.MarkBombAbility;
import com.jst.rotp_soft_and_wet.jojoimpl.stands.killerqueen8.SummonSheerHeartAttack;
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

    public static final DeferredHolder<AbilityType<?>,AbilityType<SummonSheerHeartAttack>> SHEER_HEART_ATTACK_SUMMON = ABILITY_TYPES.register(
            "sheer_heart_attack_summon", key -> new AbilityType<>(key, SummonSheerHeartAttack::new));

    public static final DeferredHolder<AbilityType<?>,AbilityType<DeleteSheerHeartAttack>> SHEER_HEART_ATTACK_DELETE= ABILITY_TYPES.register(
            "sheer_heart_attack_delete", key -> new AbilityType<>(key, DeleteSheerHeartAttack::new));

    public static final DeferredHolder<AbilityType<?>,AbilityType<MarkBombAbility>> BOMB_MARKER = ABILITY_TYPES.register(
            "mark_bomb", key -> new AbilityType<>(key, MarkBombAbility::new));

    public static final DeferredHolder<AbilityType<?>,AbilityType<DetonateBombAbility>> BOMB_DETONATE = ABILITY_TYPES.register(
            "detonate_bomb", key -> new AbilityType<>(key, DetonateBombAbility::new));
}
