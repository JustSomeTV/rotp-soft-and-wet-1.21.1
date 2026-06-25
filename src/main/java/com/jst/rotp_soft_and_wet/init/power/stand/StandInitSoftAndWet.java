package com.jst.rotp_soft_and_wet.init.power.stand;

import com.github.standobyte.jojo.init.power.ModStandAbilities;
import com.github.standobyte.jojo.powersystem.MovesetBuilder;
import com.github.standobyte.jojo.powersystem.ability.controls.InputKey;
import com.github.standobyte.jojo.powersystem.ability.controls.InputMethod;
import com.github.standobyte.jojo.powersystem.standpower.StandStats;
import com.github.standobyte.jojo.powersystem.standpower.StandUnlockableSkill;
import com.jst.rotp_soft_and_wet.init.power.AddonStandAbilities;
import com.jst.rotp_soft_and_wet.powersystem.standpower.type.SoftAndWetType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

public class StandInitSoftAndWet {

    @ApiStatus.Internal
    public static SoftAndWetType create(ResourceLocation id) {
        return new SoftAndWetType(
                new StandStats.Builder()
                        .power(10)
                        .speed(12)
                        .range(2, 8)
                        .durability(11)
                        .precision(10)
                        .build(),

                new MovesetBuilder()

                        .addHumanoidStandStuff()

                        //.addAbility("bubble_launch", AddonStandAbilities.BUBBLE_LAUNCH)

                        .addAbility("punch", ModStandAbilities.PUNCH)
                        .addAbility("punch2", ModStandAbilities.PUNCH)
                        .addAbility("punch3", ModStandAbilities.PUNCH)
                        .addAbility("punch4", ModStandAbilities.PUNCH)
                        .addAbility("barrage", ModStandAbilities.BARRAGE)
                        .addAbility("heavy_punch", ModStandAbilities.HEAVY_PUNCH)
                        .addAbility("finisher", ModStandAbilities.HEAVY_PUNCH, punch -> {
                            punch.initIsFinisher();
                        })
                        .addAbility("heavy_charged", ModStandAbilities.HEAVY_CHARGED)

                        .makeControlScheme("hotbar")

                        .bind("punch", InputMethod.CLICK, InputKey.LMB)
                        .bind("barrage", InputMethod.HOLD, InputKey.LMB)
                        .bind("heavy_punch", InputMethod.CLICK, InputKey.RMB)
                        .bind("heavy_charged", InputMethod.HOLD, InputKey.RMB)
                        .bind("bubble_launch", InputMethod.HOLD, InputKey.LMB.withModifier(InputKey.Modifier.CONTROL))


                        .finalizeControlScheme()

                        .makeControlScheme("keybinds")

                        .bind("punch", InputMethod.CLICK, InputKey.LMB)
                        .bind("barrage", InputMethod.HOLD, InputKey.LMB)
                        .bind("heavy_punch", InputMethod.CLICK, InputKey.RMB)
                        .bind("heavy_charged", InputMethod.HOLD, InputKey.RMB)
                        .bind("bubble_launch", InputMethod.HOLD, InputKey.C)

                        .finalizeControlScheme()

                        .addSkill(StandUnlockableSkill.startingAbility("punch"))
                        .addSkill(StandUnlockableSkill.startingAbility("barrage"))
                        .addSkill(StandUnlockableSkill.startingAbility("heavy_punch"))
                        .addSkill(StandUnlockableSkill.startingAbility("heavy_charged").prerequisiteSkill("heavy_punch"))
                        .addSkill(StandUnlockableSkill.unlockableAbility("bubble_launch", 125).prerequisiteSkill("punch"))

                        .addHumanoidStandSkills()

                , id)
                .discTooltipWIP()
                .init(stand -> stand.discStoryPartPriority = 0);
    }

}
