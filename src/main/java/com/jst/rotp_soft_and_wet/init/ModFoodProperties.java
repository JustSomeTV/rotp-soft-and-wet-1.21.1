package com.jst.rotp_soft_and_wet.init;

import com.github.standobyte.jojo.init.ModStatusEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties ROKAKAKA = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(ModStatusEffects.STAND_VIRUS, 120), 0.1F).build();
}