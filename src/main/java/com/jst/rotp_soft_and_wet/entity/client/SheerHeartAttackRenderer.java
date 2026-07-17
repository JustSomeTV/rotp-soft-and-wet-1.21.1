package com.jst.rotp_soft_and_wet.entity.client;

import com.jst.rotp_soft_and_wet.entity.SheerHeartAttackEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SheerHeartAttackRenderer extends GeoEntityRenderer<SheerHeartAttackEntity> {

    public SheerHeartAttackRenderer(EntityRendererProvider.Context context) {
        super(context, new SheerHeartAttackGeoModel());
    }
}