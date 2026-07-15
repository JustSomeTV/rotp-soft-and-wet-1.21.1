package com.jst.rotp_soft_and_wet.entity.client;

import com.github.standobyte.jojo.client.ClientGlobals;
import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import com.jst.rotp_soft_and_wet.entity.SheerHeartAttackEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class SheerHeartAttackRenderer extends MobRenderer<SheerHeartAttackEntity, SheerHeartAttackModel<SheerHeartAttackEntity>> {
    public SheerHeartAttackRenderer(EntityRendererProvider.Context context) {
        super(context, new SheerHeartAttackModel<>(context.bakeLayer(SheerHeartAttackModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(SheerHeartAttackEntity sheerHeartAttackEntity) {
        return ResourceLocation.fromNamespaceAndPath(RipplesOfThePastSoftAndWet.MOD_ID, "textures/entity/sheer_heart_attack.png");
    }

    @Override
    public void render(SheerHeartAttackEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (!ClientGlobals.canSeeStands) {
            return;
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    protected boolean shouldShowName(SheerHeartAttackEntity entity) {
        if (!ClientGlobals.canSeeStands) {
            return false;
        }

        return super.shouldShowName(entity);
    }
}