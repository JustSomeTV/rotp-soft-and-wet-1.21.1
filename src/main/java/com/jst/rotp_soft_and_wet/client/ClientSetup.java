package com.jst.rotp_soft_and_wet.client;

import com.github.standobyte.jojo.client.ui.marker.MarkerRenderer;
import com.jst.rotp_soft_and_wet.client.marker.KillerQueenBombAnchorMarker;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(
        modid = "rotp_soft_and_wet",
        value = Dist.CLIENT
)
public class ClientSetup {

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MarkerRenderer.registerMarkerRenderer(
                    new KillerQueenBombAnchorMarker(
                            Minecraft.getInstance()
                    )
            );
        });
    }
}
