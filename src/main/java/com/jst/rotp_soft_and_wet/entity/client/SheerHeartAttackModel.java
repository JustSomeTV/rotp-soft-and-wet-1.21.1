package com.jst.rotp_soft_and_wet.entity.client;

import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import com.jst.rotp_soft_and_wet.entity.SheerHeartAttackEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class SheerHeartAttackModel<T extends SheerHeartAttackEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(RipplesOfThePastSoftAndWet.MOD_ID, "sheer_heart_attack"), "main");
    private final ModelPart bb_main;

    public SheerHeartAttackModel(ModelPart root) {
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-4.25F, -2.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(20, 0).addBox(2.25F, -2.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(28, 23).addBox(-4.5F, -3.0F, -4.5F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(12, 23).addBox(-1.5F, -5.0F, -5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 23).addBox(-1.5F, -8.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(32, 10).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.25F))
                .texOffs(28, 34).addBox(-4.5F, -3.0F, -4.5F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(SheerHeartAttackEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return bb_main;
    }
}