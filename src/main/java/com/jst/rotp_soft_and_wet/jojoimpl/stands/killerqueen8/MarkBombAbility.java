package com.jst.rotp_soft_and_wet.jojoimpl.stands.killerqueen8;

import com.github.standobyte.jojo.powersystem.ability.AbilityId;
import com.github.standobyte.jojo.powersystem.ability.AbilityType;
import com.github.standobyte.jojo.powersystem.ability.EntityActionAbility;
import com.github.standobyte.jojo.powersystem.ability.controls.InputMethod;
import com.github.standobyte.jojo.powersystem.ability.input.ActionInputBuffer;
import com.github.standobyte.jojo.powersystem.entityaction.HeldInput;
import com.jst.rotp_soft_and_wet.data.LivingData;
import com.jst.rotp_soft_and_wet.data.ModAttachments;
import com.jst.rotp_soft_and_wet.data.PlayerDataAccess;
import com.jst.rotp_soft_and_wet.network.SyncLivingDataPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.ArrayList;

public class MarkBombAbility extends EntityActionAbility {

    public MarkBombAbility(AbilityType<?> abilityType, AbilityId abilityId) {
        super(abilityType, abilityId);
    }

    @Override
    public HeldInput onKeyPress(Level level, LivingEntity user, FriendlyByteBuf extraClientInput, InputMethod inputMethod, float clickHoldResolveTime, ActionInputBuffer.BufferingState bufferingState) {
        if (!level.isClientSide) if (user instanceof Player player) {
            LivingData data = ((PlayerDataAccess) player).rotp$getLivingData();

            BlockHitResult block = getLookedAtBlock(player);
            LivingEntity entity = getLookedAtEntity(player);

            if (entity != null && block != null) {
                double entityDistance = entity.distanceToSqr(player);
                double blockDistance = player.getEyePosition().distanceToSqr(block.getLocation());

                if (entityDistance < blockDistance) {
                    data.markEntity(entity);
                } else {
                    data.markBlock(block.getBlockPos());
                }
            }
            else if (entity != null) {
                data.markEntity(entity);
            }

            else if (block != null) {
                data.markBlock(block.getBlockPos());
            }

            if (player instanceof ServerPlayer serverPlayer) {
                PacketDistributor.sendToPlayer(
                        serverPlayer, new SyncLivingDataPacket(new ArrayList<>(data.getMarkedEntities()), new ArrayList<>(data.getMarkedBlocks()))
                );
            }
        }
        return  null;
    }

    private LivingEntity getLookedAtEntity(Player player) {
        double range = 2.0;

        Vec3 eyePos = player.getEyePosition();
        Vec3 lookVec = player.getLookAngle();
        Vec3 endPos = eyePos.add(lookVec.scale(range));

        AABB searchbox = player.getBoundingBox()
                .expandTowards(lookVec.scale(range))
                .inflate(1.0);

        EntityHitResult hitResult = ProjectileUtil.getEntityHitResult(
                player.level(),player,eyePos,endPos,searchbox,entity -> entity instanceof LivingEntity && entity != player
        );

        if (hitResult != null && hitResult.getEntity() instanceof LivingEntity livingEntity) {
            return livingEntity;
        }

        return null;
    }

    private BlockHitResult getLookedAtBlock(Player player) {
        double range = 2.0;

        Vec3 eyePos = player.getEyePosition();
        Vec3 lookVec = player.getLookAngle();
        Vec3 endPos = eyePos.add(lookVec.scale(range));

        BlockHitResult result = player.level().clip(
                new ClipContext(eyePos,endPos,ClipContext.Block.OUTLINE,ClipContext.Fluid.NONE,player)
        );

        return result.getType() == HitResult.Type.BLOCK ? result : null;
    }
}
