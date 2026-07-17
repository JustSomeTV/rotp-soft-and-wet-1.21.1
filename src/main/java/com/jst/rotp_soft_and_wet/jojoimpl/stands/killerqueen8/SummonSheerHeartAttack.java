package com.jst.rotp_soft_and_wet.jojoimpl.stands.killerqueen8;

import com.github.standobyte.jojo.powersystem.ability.AbilityId;
import com.github.standobyte.jojo.powersystem.ability.AbilityType;
import com.github.standobyte.jojo.powersystem.ability.EntityActionAbility;
import com.github.standobyte.jojo.powersystem.ability.controls.InputMethod;
import com.github.standobyte.jojo.powersystem.ability.input.ActionInputBuffer;
import com.github.standobyte.jojo.powersystem.entityaction.HeldInput;
import com.github.standobyte.jojo.powersystem.standpower.StandPower;
import com.jst.rotp_soft_and_wet.entity.ModEntities;
import com.jst.rotp_soft_and_wet.entity.SheerHeartAttackEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SummonSheerHeartAttack extends EntityActionAbility {

    public SummonSheerHeartAttack(AbilityType<?> abilityType, AbilityId abilityId) {
        super(abilityType, abilityId);
    }

    @Override
    public HeldInput onKeyPress(Level level, LivingEntity user, FriendlyByteBuf extraClientInput, InputMethod inputMethod, float clickHoldResolveTime, ActionInputBuffer.BufferingState bufferingState) {
        if (!level.isClientSide) if (user instanceof Player player) {
        	StandPower userPower = StandPower.get(user);

            boolean alreadyExists = level.getEntitiesOfClass(
                    SheerHeartAttackEntity.class,
                    player.getBoundingBox().inflate(512),
                    entity -> player.getUUID().equals(entity.getOwnerUUID())
            ).stream().findAny().isPresent();

            if (alreadyExists) {
                return null;
            }

            SheerHeartAttackEntity entity = new SheerHeartAttackEntity(
                    ModEntities.SHEER_HEART_ATTACK.get(), level
            );

            entity.setStandSkinIdFrom(userPower);
            entity.setOwnerUUID(player.getUUID());
            entity.moveTo(player.getX(), player.getY(), player.getZ());

            level.addFreshEntity(entity);
        }
        return  null;
    }
}
