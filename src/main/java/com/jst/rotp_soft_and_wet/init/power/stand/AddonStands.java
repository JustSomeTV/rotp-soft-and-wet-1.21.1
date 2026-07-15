package com.jst.rotp_soft_and_wet.init.power.stand;

import com.github.standobyte.jojo.core.JojoRegistries;
import com.github.standobyte.jojo.init.power.ModStandAbilities;
import com.github.standobyte.jojo.init.power.ModStands;
import com.github.standobyte.jojo.powersystem.standpower.type.StandType;
import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import com.jst.rotp_soft_and_wet.powersystem.standpower.type.KillerQueen8Type;
import com.jst.rotp_soft_and_wet.powersystem.standpower.type.PaisleyParkType;
import com.jst.rotp_soft_and_wet.powersystem.standpower.type.SoftAndWetType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class AddonStands {
    public static final DeferredRegister<StandType> STANDS = DeferredRegister.create(JojoRegistries.DEFAULT_STANDS_REG, RipplesOfThePastSoftAndWet.MOD_ID);

    public static final DeferredHolder<StandType, SoftAndWetType> SOFT_AND_WET = STANDS.register("soft_and_wet", StandInitSoftAndWet::create);

    public static final DeferredHolder<StandType, PaisleyParkType> PAISLEY_PARK = STANDS.register("paisley_park", StandInitPaisleyPark::create);

    public static final DeferredHolder<StandType, KillerQueen8Type> KILLER_QUEEN_8 = STANDS.register("killer_queen_8", StandInitKillerQueen8::create);

    static{
        ModStands.PLAYER_CAN_GET_FROM_ARROW.add(SOFT_AND_WET);
        ModStands.PLAYER_CAN_GET_FROM_ARROW.add(KILLER_QUEEN_8);
    }
}
