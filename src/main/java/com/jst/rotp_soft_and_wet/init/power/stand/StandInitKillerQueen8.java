package com.jst.rotp_soft_and_wet.init.power.stand;

import static com.github.standobyte.jojo.init.power.ModStands.SWITCH_SPECIAL;
import static com.github.standobyte.jojo.init.power.ModStands.USE_SPECIAL;

import com.github.standobyte.jojo.init.power.ModStandAbilities;
import com.github.standobyte.jojo.powersystem.MovesetBuilder;
import com.github.standobyte.jojo.powersystem.ability.controls.InputKey;
import com.github.standobyte.jojo.powersystem.ability.controls.InputMethod;
import com.github.standobyte.jojo.powersystem.standpower.StandStats;
import com.github.standobyte.jojo.powersystem.standpower.StandUnlockableSkill;
import com.github.standobyte.jojo.powersystem.standpower.entity.EntityStandType;
import com.jst.rotp_soft_and_wet.init.power.AddonStandAbilities;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

public class StandInitKillerQueen8 {

    @ApiStatus.Internal
    public static EntityStandType create(ResourceLocation id) {
        return new EntityStandType(
                new StandStats.Builder()
                        .power(15)
                        .speed(12)
                        .range(2, 8)
                        .durability(12)
                        .precision(12)
                        .build(),

                new MovesetBuilder()

                        .addHumanoidStandStuff()

                        .addAbility("sha_normal", AddonStandAbilities.SHEER_HEART_ATTACK_SUMMON)
                        .addAbility("sha_delete", AddonStandAbilities.SHEER_HEART_ATTACK_DELETE)
                        .addAbility("mark_bomb", AddonStandAbilities.BOMB_MARKER)
                        .addAbility("detonate_bomb", AddonStandAbilities.BOMB_DETONATE)

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
                        .bind("heavy_punch", InputMethod.CLICK, InputKey.LMB.withModifier(InputKey.Modifier.CONTROL))
                        .bind("mark_bomb",InputMethod.CLICK, InputKey.RMB)
                        .bind("detonate_bomb", InputMethod.CLICK, InputKey.RMB.withModifier(InputKey.Modifier.CONTROL))
                        .bind("sha_normal",InputMethod.HOLD, InputKey.RMB)
                        .bind("sha_delete", InputMethod.HOLD, InputKey.RMB.withModifier(InputKey.Modifier.CONTROL))

                        .addToHotbar("sha_normal",0, InputMethod.CLICK)
                        .addToHotbar("sha_delete",0, InputMethod.CLICK)
                        .addToHotbar("mark_bomb",0, InputMethod.CLICK)
                        .addToHotbar("detonate_bomb",0, InputMethod.CLICK)

                        .finalizeControlScheme()

                        .makeControlScheme("keybinds")

                        .bind("punch", InputMethod.CLICK, InputKey.LMB)
                        .bind("barrage", InputMethod.HOLD, InputKey.LMB)
                        .bind("heavy_punch", InputMethod.CLICK, InputKey.RMB)

                        .finalizeControlScheme()

                        .addSkill(StandUnlockableSkill.startingAbility("punch"))
                        .addSkill(StandUnlockableSkill.startingAbility("barrage"))
                        .addSkill(StandUnlockableSkill.startingAbility("heavy_punch"))
                        .addSkill(StandUnlockableSkill.startingAbility("heavy_charged").prerequisiteSkill("heavy_punch"))

                        .addHumanoidStandSkills()

                , id)
                .discTooltipWIP()
                .init(stand -> stand.discStoryPartPriority = 1);
    }

}
