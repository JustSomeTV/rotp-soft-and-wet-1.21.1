package com.jst.rotp_soft_and_wet.jojoimpl.stands.killerqueen8;

import com.github.standobyte.jojo.powersystem.ability.AbilityId;
import com.github.standobyte.jojo.powersystem.ability.AbilityType;
import com.github.standobyte.jojo.powersystem.ability.EntityActionAbility;
import com.github.standobyte.jojo.powersystem.ability.controls.InputMethod;
import com.github.standobyte.jojo.powersystem.ability.input.ActionInputBuffer;
import com.github.standobyte.jojo.powersystem.entityaction.HeldInput;
import com.jst.rotp_soft_and_wet.data.LivingData;
import com.jst.rotp_soft_and_wet.data.PlayerDataAccess;
import com.jst.rotp_soft_and_wet.network.SyncLivingDataPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.ArrayList;

public class DetonateBombAbility extends EntityActionAbility {

    public DetonateBombAbility(AbilityType<?> abilityType, AbilityId abilityId) {
        super(abilityType, abilityId);
    }

    @Override
    public HeldInput onKeyPress(Level level, LivingEntity user, FriendlyByteBuf extraClientInput, InputMethod inputMethod, float clickHoldResolveTime, ActionInputBuffer.BufferingState bufferingState) {
        if (!level.isClientSide) if (user instanceof Player player) {
            LivingData data = ((PlayerDataAccess) player).rotp$getLivingData();

            for(int id : data.getMarkedEntities()) {
                Entity entity = level.getEntity(id);

                if (entity != null) {
                    level.explode(player,entity.getX(),entity.getY(),entity.getZ(),3.0f,Level.ExplosionInteraction.MOB);
                }
            }

            for(BlockPos pos : data.getMarkedBlocks()) {
                level.explode(player,pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 3.0f, Level.ExplosionInteraction.BLOCK);
            }

            data.clearMarks();

            PacketDistributor.sendToPlayer(
                    (ServerPlayer) player, new SyncLivingDataPacket(new ArrayList<>(data.getMarkedEntities()), new ArrayList<>(data.getMarkedBlocks()))
            );
        }
        return  null;
    }
}
