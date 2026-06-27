package com.jst.rotp_soft_and_wet.jojoimpl.powers.spin.abilities;

import com.github.standobyte.jojo.client.ClientProxy;
import com.github.standobyte.jojo.powersystem.ability.AbilityId;
import com.github.standobyte.jojo.powersystem.ability.AbilityType;
import com.github.standobyte.jojo.powersystem.ability.EntityActionAbility;
import com.github.standobyte.jojo.powersystem.entityaction.ActionPhase;
import com.github.standobyte.jojo.powersystem.entityaction.EntityActionInstance;
import com.github.standobyte.jojo.powersystem.entityaction.type.EntityActionType;
import com.github.standobyte.jojo.powersystem.playerpower.PlayerPower;
import com.jst.rotp_soft_and_wet.init.power.AddonPlayerPowers;
import com.jst.rotp_soft_and_wet.jojoimpl.powers.spin.SpinData;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.Nullable;

public class SpinSpinItem extends EntityActionAbility {
    public SpinSpinItem(AbilityType<?> abilityType, AbilityId abilityId) {
        super(abilityType, abilityId);
        setButtonHoldPhase(ActionPhase.PERFORM);
    }

    public static class SpinItem extends EntityActionInstance {
        SpinData spin;

        public SpinItem(EntityActionType ability) {
            super(ability);
            userWalkSpeed = 0.5F;
        }

        @Override
        public void onActionSet(@Nullable EntityActionInstance prevAction) {
            LivingEntity user = performer;
            boolean clientSide = user.level().isClientSide;
            if (!clientSide || user == ClientProxy.getClientPlayer()) {
                spin = PlayerPower.getPowerData(user, AddonPlayerPowers.SPIN).orElse(null);
            }
        }

        @Override
        public void onButtonStopHold() {
            startRecovery();
        }

        @Override
        public void onSetPhase(ActionPhase newPhase) {
            if (spin != null) {

            }
        }
    }
}