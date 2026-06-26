package com.jst.rotp_soft_and_wet.jojoimpl.stands.softandwet;

import com.github.standobyte.jojo.powersystem.ability.AbilityId;
import com.github.standobyte.jojo.powersystem.ability.AbilityType;
import com.github.standobyte.jojo.powersystem.ability.AbilityUsageGroup;
import com.github.standobyte.jojo.powersystem.ability.EntityActionAbility;
import com.github.standobyte.jojo.powersystem.ability.controls.InputMethod;
import com.github.standobyte.jojo.powersystem.ability.input.ActionInputBuffer.BufferingState;
import com.github.standobyte.jojo.powersystem.entityaction.HeldInput;
import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import com.jst.rotp_soft_and_wet.entity.SoftAndWetBubbleEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class SoftAndWetBubbleMoisture extends EntityActionAbility {

    public SoftAndWetBubbleMoisture(AbilityType<?> abilityType, AbilityId abilityId) {
        super(abilityType, abilityId);
        usageGroup = AbilityUsageGroup.COMBAT;
    }

    SoftAndWetBubbleEntity entity;

    @Override
    public HeldInput onKeyPress(Level level, LivingEntity user, FriendlyByteBuf extraClientInput, InputMethod inputMethod, float clickHoldResolveTime, BufferingState bufferingState) {
        if (!level.isClientSide) if (user instanceof Player player) {
            //Launch Projectile
            SoftAndWetBubbleEntity bubbleProjectile = new SoftAndWetBubbleEntity(level, player);
            bubbleProjectile.setBubbleType(SoftAndWetBubbleEntity.BubbleType.MOISTURE);
            Vec3 look = player.getLookAngle();
            bubbleProjectile.shoot(
                    look.x,
                    look.y,
                    look.z,
                    0.75F,
                    0.0F);
            level.addFreshEntity(bubbleProjectile);
        }
        return  null;
    }
}