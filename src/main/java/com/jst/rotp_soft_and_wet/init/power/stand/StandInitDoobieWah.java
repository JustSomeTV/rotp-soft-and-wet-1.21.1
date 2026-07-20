package com.jst.rotp_soft_and_wet.init.power.stand;


import com.github.standobyte.jojo.init.power.ModStandAbilities;
import com.github.standobyte.jojo.powersystem.MovesetBuilder;
import com.github.standobyte.jojo.powersystem.ability.controls.InputKey;
import com.github.standobyte.jojo.powersystem.ability.controls.InputMethod;
import com.github.standobyte.jojo.powersystem.standpower.StandStats;
import com.github.standobyte.jojo.powersystem.standpower.StandUnlockableSkill;
import com.github.standobyte.jojo.powersystem.standpower.entity.EntityStandType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

public class StandInitDoobieWah {

    @ApiStatus.Internal
    public static EntityStandType create(ResourceLocation id) {
        return new EntityStandType(
                new StandStats.Builder()
                        .power(0)
                        .speed(0)
                        .range(15, 100)
                        .durability(17)
                        .precision(7)
                        .build(),

                new MovesetBuilder()

                        .addHumanoidStandStuff()

                        .addAbility("punch", ModStandAbilities.PUNCH)
                        .addAbility("punch2", ModStandAbilities.PUNCH)
                        .addAbility("punch3", ModStandAbilities.PUNCH)
                        .addAbility("punch4", ModStandAbilities.PUNCH)

                        .makeControlScheme("hotbar")

                        .bind("punch", InputMethod.CLICK, InputKey.LMB)

                        .finalizeControlScheme()

                        .makeControlScheme("keybinds")

                        .bind("punch", InputMethod.CLICK, InputKey.LMB)

                        .finalizeControlScheme()

                        .addSkill(StandUnlockableSkill.startingAbility("punch"))

                        .addHumanoidStandSkills()

                , id)
                .discTooltipExperimental();
    }

}
