package com.jst.rotp_soft_and_wet.network;

import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class ModNetwork {
    public static void register(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(RipplesOfThePastSoftAndWet.MOD_ID);

        registrar.playToClient(
                SyncLivingDataPacket.TYPE,
                SyncLivingDataPacket.STREAM_CODEC,
                SyncLivingDataPacket::handle
        );
    }
}
