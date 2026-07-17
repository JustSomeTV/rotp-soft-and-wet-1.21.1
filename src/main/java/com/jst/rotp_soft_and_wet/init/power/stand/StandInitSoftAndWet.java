package com.jst.rotp_soft_and_wet.init.power.stand;

import static com.github.standobyte.jojo.init.power.ModStands.SWITCH_SPECIAL;
import static com.github.standobyte.jojo.init.power.ModStands.USE_SPECIAL;

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

                        .addAbility("bubble_barrage", AddonStandAbilities.BUBBLE_BARRAGE)
                        .addAbility("bubble_shoot", AddonStandAbilities.BUBBLE_SHOOT)
                        .addAbility("bubble_blinding", AddonStandAbilities.BUBBLE_BLINDING)
                        .addAbility("bubble_friction", AddonStandAbilities.BUBBLE_FRICTION)
                        .addAbility("bubble_moisture", AddonStandAbilities.BUBBLE_MOISTURE)

                        .addAbility("punch", ModStandAbilities.PUNCH)
                        .addAbility("punch2", ModStandAbilities.PUNCH)
                        .addAbility("punch3", ModStandAbilities.PUNCH)
                        .addAbility("punch4", ModStandAbilities.PUNCH)
                        .addAbility("barrage", ModStandAbilities.BARRAGE)
                        .addAbility("heavy_punch", ModStandAbilities.HEAVY_PUNCH)

                        .makeControlScheme("hotbar")
                        .makeHotbar(0, USE_SPECIAL, SWITCH_SPECIAL)

                        .bind("punch", InputMethod.CLICK, InputKey.LMB)
                        .bind("barrage", InputMethod.HOLD, InputKey.LMB)
                        .bind("heavy_punch", InputMethod.CLICK, InputKey.RMB)
                        .bind("bubble_shoot", InputMethod.CLICK, InputKey.RMB.withModifier(InputKey.Modifier.CONTROL))

                        .addToHotbar("bubble_barrage",0, InputMethod.HOLD)
                        .addToHotbar("bubble_blinding",0, InputMethod.HOLD)
                        .addToHotbar("bubble_moisture",0, InputMethod.HOLD)
                        .addToHotbar("bubble_friction",0, InputMethod.HOLD)


                        .finalizeControlScheme()

                        .makeControlScheme("keybinds")

                        .bind("punch", InputMethod.CLICK, InputKey.LMB)
                        .bind("barrage", InputMethod.HOLD, InputKey.LMB)
                        .bind("heavy_punch", InputMethod.CLICK, InputKey.RMB)
                        .bind("bubble_shoot", InputMethod.HOLD, InputKey.C)
                        .bind("bubble_barrage", InputMethod.HOLD, InputKey.C.withModifier(InputKey.Modifier.CONTROL))

                        .finalizeControlScheme()

                        .addSkill(StandUnlockableSkill.startingAbility("punch"))
                        .addSkill(StandUnlockableSkill.startingAbility("barrage"))
                        .addSkill(StandUnlockableSkill.startingAbility("heavy_punch"))
                        //.addSkill(StandUnlockableSkill.startingAbility("heavy_charged").prerequisiteSkill("heavy_punch"))
                        .addSkill(StandUnlockableSkill.startingAbility("bubble_shoot"))
                        .addSkill(StandUnlockableSkill.unlockableAbility("bubble_barrage", 175).prerequisiteSkill("bubble_shoot"))
                        .addSkill(StandUnlockableSkill.unlockableAbility("bubble_blinding", 350).prerequisiteSkill("bubble_friction"))
                        .addSkill(StandUnlockableSkill.unlockableAbility("bubble_moisture", 225).prerequisiteSkill("bubble_barrage"))
                        .addSkill(StandUnlockableSkill.unlockableAbility("bubble_friction", 275).prerequisiteSkill("bubble_moisture"))



                        .addHumanoidStandSkills()

                , id)
                .discTooltipWIP()
                .init(stand -> stand.discStoryPartPriority = 0);
    }

}
