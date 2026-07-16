package com.jst.rotp_soft_and_wet.core;

import com.jst.rotp_soft_and_wet.data.ModAttachments;
import com.jst.rotp_soft_and_wet.entity.ModEntities;
import com.jst.rotp_soft_and_wet.entity.client.SheerHeartAttackRenderer;
import com.jst.rotp_soft_and_wet.entity.client.SoftAndWetBubbleRenderer;
import com.jst.rotp_soft_and_wet.init.AddonSoundEvents;
import com.jst.rotp_soft_and_wet.init.ModBlocks;
import com.jst.rotp_soft_and_wet.init.ModCreativeModeTabs;
import com.jst.rotp_soft_and_wet.init.ModItems;
import com.jst.rotp_soft_and_wet.init.power.AddonPlayerPowers;
import com.jst.rotp_soft_and_wet.init.power.AddonStandAbilities;
import com.jst.rotp_soft_and_wet.init.power.stand.AddonStands;
import com.jst.rotp_soft_and_wet.network.ModNetwork;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(RipplesOfThePastSoftAndWet.MOD_ID)
public class RipplesOfThePastSoftAndWet {

    public static final String MOD_ID = "rotp_soft_and_wet";

    @Deprecated
    public static final Logger LOGGER = LogUtils.getLogger();
    public RipplesOfThePastSoftAndWet(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(ModNetwork::register);
        modEventBus.register(this);

        ModEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        AddonPlayerPowers.PLAYER_POWERS.register(modEventBus);
        AddonStands.STANDS.register(modEventBus);
        AddonSoundEvents.SOUNDS.register(modEventBus);
        AddonStandAbilities.load();

        ModAttachments.ATTACHMENTS.register(modEventBus);
    }

    @SubscribeEvent
    private void commonSetup(FMLCommonSetupEvent event) {
    }

    public static ResourceLocation resLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.SOFT_AND_WET_BUBBLE.get(), SoftAndWetBubbleRenderer::new);
            EntityRenderers.register(ModEntities.SHEER_HEART_ATTACK.get(), SheerHeartAttackRenderer::new);
        }
    }
}
