package com.jst.rotp_soft_and_wet.event;

import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import com.jst.rotp_soft_and_wet.entity.ModEntities;
import com.jst.rotp_soft_and_wet.entity.SheerHeartAttackEntity;
import com.jst.rotp_soft_and_wet.entity.client.SoftAndWetBubbleModel;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = RipplesOfThePastSoftAndWet.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SoftAndWetBubbleModel.LAYER_LOCATION, SoftAndWetBubbleModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SHEER_HEART_ATTACK.get(), SheerHeartAttackEntity.createAttributes().build());
    }
}