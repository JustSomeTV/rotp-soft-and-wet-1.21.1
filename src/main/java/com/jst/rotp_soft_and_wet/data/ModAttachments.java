package com.jst.rotp_soft_and_wet.data;

import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(
            NeoForgeRegistries.ATTACHMENT_TYPES,
            RipplesOfThePastSoftAndWet.MOD_ID);

    public static final Supplier<AttachmentType<LivingData>> LIVING_DATA = ATTACHMENTS.register("living_data",
            () -> AttachmentType.builder((Supplier<LivingData>) LivingData::new).build());

    public static void register(IEventBus bus) {
        ATTACHMENTS.register(bus);
    }
}
