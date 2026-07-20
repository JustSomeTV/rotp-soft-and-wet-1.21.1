package com.jst.rotp_soft_and_wet.jojoimpl.stands.killerqueen8;

import com.github.standobyte.jojo.powersystem.ability.AbilityId;
import com.github.standobyte.jojo.powersystem.ability.AbilityType;
import com.github.standobyte.jojo.powersystem.ability.EntityActionAbility;
import com.github.standobyte.jojo.powersystem.ability.controls.InputMethod;
import com.github.standobyte.jojo.powersystem.ability.input.ActionInputBuffer;
import com.github.standobyte.jojo.powersystem.entityaction.HeldInput;
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

    private static final int MAX_SHA = 4;

    private int getActiveSHA(Player player) {
        return player.level().getEntitiesOfClass(SheerHeartAttackEntity.class,
                player.getBoundingBox().inflate(512),
                sha -> sha.isAlive() && player.equals(sha.getOwner())).size();
    }

    @Override
    public HeldInput onKeyPress(Level level, LivingEntity user, FriendlyByteBuf extraClientInput, InputMethod inputMethod, float clickHoldResolveTime, ActionInputBuffer.BufferingState bufferingState) {
        if (!level.isClientSide) if (user instanceof Player player) {
            if (getActiveSHA(player) <= MAX_SHA) {
                boolean alreadyExists = level.getEntitiesOfClass(
                        SheerHeartAttackEntity.class,
                        player.getBoundingBox().inflate(512),
                        entity -> player.getUUID().equals(entity.getOwnerUUID())
                ).stream().findAny().isPresent();

                SheerHeartAttackEntity entity = new SheerHeartAttackEntity(
                        ModEntities.SHEER_HEART_ATTACK.get(), level
                );

                entity.setOwnerUUID(player.getUUID());
                entity.moveTo(player.getX(), player.getY(), player.getZ());

                level.addFreshEntity(entity);
            }
        }
        return  null;
    }
}
