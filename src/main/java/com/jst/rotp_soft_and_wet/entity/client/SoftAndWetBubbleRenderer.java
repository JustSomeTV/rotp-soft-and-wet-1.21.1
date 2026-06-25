package com.jst.rotp_soft_and_wet.entity.client;

import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import com.jst.rotp_soft_and_wet.entity.SoftAndWetBubbleEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class SoftAndWetBubbleRenderer extends EntityRenderer<SoftAndWetBubbleEntity> {

    private final SoftAndWetBubbleModel model;

    public SoftAndWetBubbleRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new SoftAndWetBubbleModel(
                context.bakeLayer(SoftAndWetBubbleModel.LAYER_LOCATION)
        );
    }

    @Override
    public void render(SoftAndWetBubbleEntity entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        poseStack.pushPose();

        // position offset
        poseStack.translate(0.0, -1.0, 0.0);

        // rotation (optional but recommended)
        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(-entity.getYRot()));

        // animate (safe even if empty)
        model.setupAnim(entity, 0, 0, entity.tickCount + partialTicks, 0, 0);

        VertexConsumer vc = buffer.getBuffer(
                RenderType.entityTranslucent(getTextureLocation(entity))
        );

        model.renderToBuffer(
                poseStack,
                vc,
                packedLight,
                OverlayTexture.NO_OVERLAY
        );

        poseStack.popPose();

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(SoftAndWetBubbleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(
                RipplesOfThePastSoftAndWet.MOD_ID,
                "textures/entity/soft_and_wet_bubble.png"
        );
    }
}