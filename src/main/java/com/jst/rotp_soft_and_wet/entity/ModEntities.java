package com.jst.rotp_soft_and_wet.entity;

import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import net.minecraft.core.registries.BuiltInRegistries;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, RipplesOfThePastSoftAndWet.MOD_ID);

    public static final Supplier<EntityType<SoftAndWetBubbleEntity>> SOFT_AND_WET_BUBBLE =
            ENTITY_TYPES.register("bubble", () -> EntityType.Builder.<SoftAndWetBubbleEntity>of(SoftAndWetBubbleEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).build("bubble"));

    public static final Supplier<EntityType<SheerHeartAttackEntity>> SHEER_HEART_ATTACK =
            ENTITY_TYPES.register("sheer_heart_attack", () -> EntityType.Builder.<SheerHeartAttackEntity>of(SheerHeartAttackEntity::new, MobCategory.MONSTER)
                    .sized(0.75F, 0.75F).build("sheer_heart_attack"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
