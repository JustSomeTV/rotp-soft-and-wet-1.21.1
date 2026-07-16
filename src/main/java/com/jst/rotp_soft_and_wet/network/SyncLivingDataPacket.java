package com.jst.rotp_soft_and_wet.network;

import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import com.jst.rotp_soft_and_wet.data.LivingData;
import com.jst.rotp_soft_and_wet.data.PlayerDataAccess;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.ArrayList;
import java.util.List;

public record SyncLivingDataPacket(List<Integer> markedEntities, List<BlockPos> markedBlocks) implements CustomPacketPayload {

    public static final Type<SyncLivingDataPacket> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(RipplesOfThePastSoftAndWet.MOD_ID, "sync_living_data"));

    public static final StreamCodec<FriendlyByteBuf, SyncLivingDataPacket> STREAM_CODEC = StreamCodec.of(SyncLivingDataPacket::encode,SyncLivingDataPacket::decode);

    private static void encode(FriendlyByteBuf buf, SyncLivingDataPacket packet) {

        buf.writeInt(packet.markedEntities().size());

        for (int id : packet.markedEntities()) {
            buf.writeInt(id);
        }

        buf.writeInt(packet.markedBlocks().size());

        for (BlockPos pos : packet.markedBlocks()) {
            buf.writeBlockPos(pos);
        }
    }

    private static SyncLivingDataPacket decode(FriendlyByteBuf buf) {

        int entityCount = buf.readInt();

        List<Integer> markedEntities = new ArrayList<>();

        for (int i = 0; i < entityCount; i++) {
            markedEntities.add(buf.readInt());
        }

        int blockCount = buf.readInt();

        List<BlockPos> markedBlocks = new ArrayList<>();

        for (int i = 0; i < blockCount; i++) {
            markedBlocks.add(buf.readBlockPos());
        }

        return new SyncLivingDataPacket(markedEntities, markedBlocks);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(SyncLivingDataPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            Minecraft mc = Minecraft.getInstance();

            if (Minecraft.getInstance().player == null) {
                return;
            }

            LivingData livingData = ((PlayerDataAccess) Minecraft.getInstance().player).rotp$getLivingData();

            livingData.setMarkedEntities(packet.markedEntities());
            livingData.setMarkedBlocks(packet.markedBlocks());
        });
    }
}