package com.jst.rotp_soft_and_wet.core;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = RipplesOfThePastSoftAndWet.MOD_ID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = RipplesOfThePastSoftAndWet.MOD_ID, value = Dist.CLIENT)
public class RipplesOfThePastSoftAndWetClient {
    public RipplesOfThePastSoftAndWetClient(ModContainer container) {

    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        RipplesOfThePastSoftAndWet.LOGGER.info("ROTP: Soft And Wet Loaded");
    }
}
