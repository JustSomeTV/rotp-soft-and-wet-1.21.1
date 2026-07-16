package com.jst.rotp_soft_and_wet.jojoimpl.stands.killerqueen8;

import com.github.standobyte.jojo.powersystem.ability.AbilityId;
import com.github.standobyte.jojo.powersystem.ability.AbilityType;
import com.github.standobyte.jojo.powersystem.ability.EntityActionAbility;
import com.github.standobyte.jojo.powersystem.ability.controls.InputMethod;
import com.github.standobyte.jojo.powersystem.ability.input.ActionInputBuffer;
import com.github.standobyte.jojo.powersystem.entityaction.HeldInput;
import com.jst.rotp_soft_and_wet.entity.SheerHeartAttackEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class DeleteSheerHeartAttack extends EntityActionAbility {

    public DeleteSheerHeartAttack(AbilityType<?> abilityType, AbilityId abilityId) {
        super(abilityType, abilityId);
    }

    @Override
    public HeldInput onKeyPress(Level level, LivingEntity user, FriendlyByteBuf extraClientInput, InputMethod inputMethod, float clickHoldResolveTime, ActionInputBuffer.BufferingState bufferingState) {
        if (!level.isClientSide) if (user instanceof Player player) {
            for (SheerHeartAttackEntity entity : level.getEntitiesOfClass(SheerHeartAttackEntity.class, player.getBoundingBox().inflate(512)
            )) {
                if (player.getUUID().equals(entity.getOwnerUUID())) {
                    entity.discard();
                }
            }
        }
        return  null;
    }
}
