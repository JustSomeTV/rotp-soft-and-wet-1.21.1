package com.jst.rotp_soft_and_wet.client.marker;

import com.github.standobyte.jojo.client.ClientPowerCache;
import com.github.standobyte.jojo.client.ui.marker.MarkerRenderer;
import com.github.standobyte.jojo.powersystem.PowerClass;
import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import com.jst.rotp_soft_and_wet.data.LivingData;
import com.jst.rotp_soft_and_wet.data.PlayerDataAccess;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;

import java.util.List;

public class KillerQueenBombAnchorMarker extends MarkerRenderer {

    public KillerQueenBombAnchorMarker(Minecraft mc) {
        super(RipplesOfThePastSoftAndWet.resLoc("textures/icons/bomb_marker.png"), mc);
        renderThroughBlocks = true;
        useStandSkinColor = true;
    }

    @Override
    protected boolean shouldRender() {
        return ClientPowerCache.getPower(PowerClass.STAND) != null;
    }

    @Override
    protected void updatePositions(List<MarkerInstance> list, float partialTick) {

        if (mc.player == null || mc.level == null)
            return;


        LivingData data =
                ((PlayerDataAccess) mc.player).rotp$getLivingData();

        for (int id : data.getMarkedEntities()) {

            Entity entity = mc.level.getEntity(id);

            if (entity != null) {

                list.add(new MarkerInstance(entityMarkerPos(entity, partialTick)));
            }
        }


        for (BlockPos pos : data.getMarkedBlocks()) {

            list.add(new MarkerInstance(
                    blockMarkerPos(pos)
            ));

        }
    }
}
