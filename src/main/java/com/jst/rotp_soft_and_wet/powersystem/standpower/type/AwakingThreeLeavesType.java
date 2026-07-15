package com.jst.rotp_soft_and_wet.powersystem.standpower.type;

import com.github.standobyte.jojo.init.ModSoundEvents;
import com.github.standobyte.jojo.network.s2c.StandEntitySoundPacket;
import com.github.standobyte.jojo.network.s2c.TrSetStandEntityPacket;
import com.github.standobyte.jojo.powersystem.MovesetBuilder;
import com.github.standobyte.jojo.powersystem.entityaction.ActionPhase;
import com.github.standobyte.jojo.powersystem.entityaction.EntityActionInstance;
import com.github.standobyte.jojo.powersystem.entityaction.netcode.SyncType;
import com.github.standobyte.jojo.powersystem.standpower.StandPower;
import com.github.standobyte.jojo.powersystem.standpower.StandStats;
import com.github.standobyte.jojo.powersystem.standpower.entity.EntityStandType;
import com.github.standobyte.jojo.powersystem.standpower.entity.StandEntity;
import com.github.standobyte.jojoimpl.stands._entitybase.StandEntityUnsummonAction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.function.Consumer;

public class AwakingThreeLeavesType extends EntityStandType {
    public AwakingThreeLeavesType(StandStats stats, MovesetBuilder moveset, ResourceLocation id) {
        super(stats, moveset, id);
    }

    @Override
    public void onUserSummonCommand(LivingEntity user, StandPower standPower) {
        if (!standPower.isSummoned()) {
            summon(standPower.getUser(), standPower);
        }
        else {
            StandEntity standEntity = (StandEntity) standPower.getSummonedStand();
            EntityActionInstance curAction = standEntity.getCurStandAction();
            if (standEntity.isArmsOnlyMode()) {
                standEntity.fullSummonFromArms();
            }
            else {
                if (curAction != null) {
                    if (curAction.ability instanceof StandEntityUnsummonAction) {
                        forceUnsummon(user, standPower);
                        return;
                    }
                    else if ((curAction.phase == ActionPhase.BUTTON_CHARGE || curAction.phase == ActionPhase.WINDUP) && curAction.canBeCancelledInto(null)) {
                        standEntity.getStandActionComponent().setAction(null, SyncType.TRACKING_AND_SELF);
                        return;
                    }
                }

                unsummon(user, standPower);
            }
        }
    }

    @Override
    public boolean summon(LivingEntity user, StandPower standPower) {
        return summon(user, standPower, entity -> {}, true);
    }

    public boolean summon(LivingEntity user, StandPower standPower, Consumer<StandEntity> beforeTheSummon, boolean addToWorld) {
        if (!standPower.canUsePower()) {
            return false;
        }

        Level level = user.level();
        if (!level.isClientSide()) {
            if (!standPower.isSummoned()) {
                StandEntity standEntity = entityType.value.create(level)
                        .withStandType(this);
                standEntity.refreshDimensions();
                standEntity.copyPosition(user);
                standEntity.copyStandUserRotation(user);
                standPower.setSummonedStand(standEntity);
                beforeTheSummon.accept(standEntity);

                if (addToWorld) {
                    finalizeStandSummonFromAction(user, standPower, standEntity, true);
                }
                return true;
            }
        }

        return false;
    }

    public void finalizeStandSummonFromAction(LivingEntity user, StandPower standPower, StandEntity standEntity, boolean addToWorld) {
        Level level = user.level();
        if (!level.isClientSide() && !standEntity.isAddedToLevel()) {
            if (addToWorld) {
                level.addFreshEntity(standEntity);
                PacketDistributor.sendToPlayersTrackingEntityAndSelf(user, new StandEntitySoundPacket(standEntity, ModSoundEvents.STAND_SUMMON, 1, 1));
                PacketDistributor.sendToPlayersTrackingEntityAndSelf(user, new TrSetStandEntityPacket(user.getId(), standEntity.getId()));
            }
            else {
                forceUnsummon(user, standPower);
            }
        }
    }

    @Override
    public void unsummon(LivingEntity user, StandPower standPower) {
        if (!user.level().isClientSide()) {
            StandEntity standEntity = ((StandEntity) standPower.getSummonedStand());
            if (standEntity != null) {
                standEntity.onUnsummonUserInput();
            }
        }
    }

    @Override
    public void forceUnsummon(LivingEntity user, StandPower standPower) {
        if (!user.level().isClientSide()) {
            StandEntity standEntity = standPower.getSummonedStandEntity();
            if (standEntity != null) {
                standPower.setSummonedStand(null);
                standEntity.remove(Entity.RemovalReason.DISCARDED);
            }
            PacketDistributor.sendToPlayersTrackingEntityAndSelf(user, new TrSetStandEntityPacket(user.getId(), 0));
        }
    }

    @Override
    public boolean showHUD(StandPower standPower) {
        if (super.showHUD(standPower)) {
            StandEntity standEntity = standPower.getSummonedStandEntity();
            if (standEntity != null) {
                EntityActionInstance curAction = standEntity.getCurStandAction();
                return !(curAction != null && curAction.ability instanceof StandEntityUnsummonAction);
            }
        }

        return false;
    }

    public EntityType<?> getEntityType() {
        return entityType.value;
    }
}