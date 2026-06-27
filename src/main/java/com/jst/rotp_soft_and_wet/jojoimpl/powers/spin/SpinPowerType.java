package com.jst.rotp_soft_and_wet.jojoimpl.powers.spin;

import static com.github.standobyte.jojo.init.power.ModStandAbilities.ABILITY_TYPES;
import static com.jst.rotp_soft_and_wet.init.power.AddonPlayerPowers.PLAYER_POWERS;

import com.github.standobyte.jojo.powersystem.MovesetBuilder;
import com.github.standobyte.jojo.powersystem.ability.Ability;
import com.github.standobyte.jojo.powersystem.ability.AbilityType;
import com.github.standobyte.jojo.powersystem.ability.controls.InputKey;
import com.github.standobyte.jojo.powersystem.ability.controls.InputMethod;
import com.github.standobyte.jojo.powersystem.ability.controls.InputUseVanillaMapping;
import com.github.standobyte.jojo.powersystem.playerpower.PlayerPowerType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;

public class SpinPowerType extends PlayerPowerType<SpinData> {
    public static final int UI_COLOR = 0xffc80000;

    public static final DeferredHolder<AbilityType<?>, AbilityType<Ability>> SPIN_SPINNING = ABILITY_TYPES.register(
            "spin_spin_ball", key -> new AbilityType<>(key, Ability::new));

    public static final DeferredHolder<PlayerPowerType<?>, SpinPowerType> SPIN = PLAYER_POWERS.register(
            "spin", key -> new SpinPowerType(key, new MovesetBuilder()

                    .addAbility("spin_spin_ball", SPIN_SPINNING)

                    .makeControlScheme("default")
                    .makeMovesetGroup("moveset_group.spin.misc", new InputUseVanillaMapping("jojo_ripples.key.non_stand_mode"))
                    .bind("spin_spin_ball", InputMethod.HOLD, InputKey.RMB)
                    .finalizeControlScheme()
            ));

    protected SpinPowerType(ResourceLocation registryKey, MovesetBuilder abilitySet) {
        super(registryKey, abilitySet);
    }

    @Override
    public SpinData newDataInstance() {
        return new SpinData();
    }
}
