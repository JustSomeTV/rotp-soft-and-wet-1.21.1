package com.jst.rotp_soft_and_wet.init.power.stand;


import com.github.standobyte.jojo.init.power.ModStandAbilities;
import com.github.standobyte.jojo.powersystem.MovesetBuilder;
import com.github.standobyte.jojo.powersystem.ability.controls.InputKey;
import com.github.standobyte.jojo.powersystem.ability.controls.InputMethod;
import com.github.standobyte.jojo.powersystem.standpower.StandStats;
import com.github.standobyte.jojo.powersystem.standpower.StandUnlockableSkill;
import com.jst.rotp_soft_and_wet.init.power.AddonStandAbilities;
import com.jst.rotp_soft_and_wet.powersystem.standpower.type.PaisleyParkType;
import com.jst.rotp_soft_and_wet.powersystem.standpower.type.TheWorldHighVoltageType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

public class StandInitTheWorldHighVoltage {

    @ApiStatus.Internal
    public static TheWorldHighVoltageType create(ResourceLocation id) {
        return new TheWorldHighVoltageType(
                new StandStats.Builder()
                        .power(19)
                        .speed(18.5)
                        .range(5, 10)
                        .durability(20)
                        .precision(12)
                        .build(),

                new MovesetBuilder()

                        .addHumanoidStandStuff()

                        .addAbility("punch", ModStandAbilities.PUNCH)
                        .addAbility("punch2", ModStandAbilities.PUNCH)
                        .addAbility("punch3", ModStandAbilities.PUNCH)
                        .addAbility("punch4", ModStandAbilities.PUNCH)
                        .addAbility("time_stop", ModStandAbilities.TIME_STOP)
                        .addAbility("time_resume", ModStandAbilities.TIME_RESUME)
                        .addAbility("time_invade", ModStandAbilities.TIME_STOP_INVADE)
                        .addAbility("barrage", ModStandAbilities.BARRAGE)
                        .addAbility("heavy_punch", ModStandAbilities.HEAVY_PUNCH)
                        .addAbility("heavy_charged", ModStandAbilities.HEAVY_CHARGED)



                        .makeControlScheme("hotbar")

                        .bind("punch", InputMethod.CLICK, InputKey.LMB)
                        .bind("barrage", InputMethod.HOLD, InputKey.RMB)

                        .bind("time_stop", InputMethod.CLICK, InputKey.RMB.withModifier(InputKey.Modifier.CONTROL))
                        .bind("time_stop", InputMethod.HOLD, InputKey.RMB.withModifier(InputKey.Modifier.CONTROL))

                        .bind("heavy_punch", InputMethod.CLICK, InputKey.RMB)
                        .bind("heavy_charged", InputMethod.HOLD, InputKey.RMB)

                        .finalizeControlScheme()

                        .makeControlScheme("keybinds")

                        .bind("punch", InputMethod.CLICK, InputKey.LMB)

                        .finalizeControlScheme()

                        .addSkill(StandUnlockableSkill.startingAbility("punch"))

                        .addHumanoidStandSkills()

                , id)
                .discTooltipExperimental()
                .init(stand -> stand.discStoryPartPriority = 1);
    }

}
