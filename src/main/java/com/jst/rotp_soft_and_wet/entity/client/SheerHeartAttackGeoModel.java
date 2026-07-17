package com.jst.rotp_soft_and_wet.entity.client;

import com.github.standobyte.jojo.client.standskin.StandSkin;
import com.github.standobyte.jojo.client.standskin.StandSkinsLoader;
import com.github.standobyte.jojo.powersystem.standpower.StandPower;
import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import com.jst.rotp_soft_and_wet.entity.SheerHeartAttackEntity;
import com.jst.rotp_soft_and_wet.init.power.stand.AddonStands;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SheerHeartAttackGeoModel extends GeoModel<SheerHeartAttackEntity> {
    private static final ResourceLocation TEXTURE =  ResourceLocation.fromNamespaceAndPath(RipplesOfThePastSoftAndWet.MOD_ID, "textures/entity/sheer_heart_attack.png");

    @Override
    public ResourceLocation getModelResource(SheerHeartAttackEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("rotp_soft_and_wet", "geo/sheer_heart_attack.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SheerHeartAttackEntity sheerHeartAttackEntity) {
        if(sheerHeartAttackEntity.getOwner() != null){
            StandPower standData = StandPower.get(sheerHeartAttackEntity.getOwner());
            if(standData != null && standData.getPowerType() == AddonStands.KILLER_QUEEN_8.get()){
                StandSkin standSkin = StandSkinsLoader.getInstance().getSkin(standData);
                return  standSkin.getTexture(TEXTURE);
            }
            return TEXTURE;
        }
        return TEXTURE;
    }

    @Override
    public ResourceLocation getAnimationResource(SheerHeartAttackEntity animatable) {
        return null;
    }
}
