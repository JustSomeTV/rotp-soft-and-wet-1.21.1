package com.jst.rotp_soft_and_wet.init.power.stand;


import com.github.standobyte.jojo.init.power.ModStandAbilities;
import com.github.standobyte.jojo.powersystem.MovesetBuilder;
import com.github.standobyte.jojo.powersystem.ability.controls.InputKey;
import com.github.standobyte.jojo.powersystem.ability.controls.InputMethod;
import com.github.standobyte.jojo.powersystem.standpower.StandStats;
import com.github.standobyte.jojo.powersystem.standpower.StandUnlockableSkill;
import com.jst.rotp_soft_and_wet.init.power.AddonStandAbilities;
import com.jst.rotp_soft_and_wet.powersystem.standpower.type.PaisleyParkType;
import com.jst.rotp_soft_and_wet.powersystem.standpower.type.SilverChariotType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

public class StandInitSilverChariot {

    @ApiStatus.Internal
    public static SilverChariotType create(ResourceLocation id) {
        return new SilverChariotType(
                new StandStats.Builder()
                        .power(10)
                        .speed(16)
                        .range(3, 10)
                        .durability(12)
                        .precision(12)
                        .build(),

                new MovesetBuilder()

                        .addHumanoidStandStuff()

                        .addAbility("punch", ModStandAbilities.PUNCH)
                        .addAbility("punch2", ModStandAbilities.PUNCH)

                        .makeControlScheme("hotbar")

                        .bind("punch", InputMethod.CLICK, InputKey.LMB)

                        .finalizeControlScheme()

                        .makeControlScheme("keybinds")

                        .bind("punch", InputMethod.CLICK, InputKey.LMB)

                        .finalizeControlScheme()

                        .addSkill(StandUnlockableSkill.startingAbility("punch"))

                        .addHumanoidStandSkills()

                , id)
                .discTooltipWIP();
    }

}
