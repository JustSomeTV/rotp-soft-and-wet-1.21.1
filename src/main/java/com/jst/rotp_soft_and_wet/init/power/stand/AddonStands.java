package com.jst.rotp_soft_and_wet.init.power.stand;

import com.github.standobyte.jojo.core.JojoRegistries;
import com.github.standobyte.jojo.init.power.ModStands;
import com.github.standobyte.jojo.powersystem.standpower.type.StandType;
import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import com.jst.rotp_soft_and_wet.powersystem.standpower.type.PaisleyParkType;
import com.jst.rotp_soft_and_wet.powersystem.standpower.type.SilverChariotType;
import com.jst.rotp_soft_and_wet.powersystem.standpower.type.SoftAndWetType;
import com.jst.rotp_soft_and_wet.powersystem.standpower.type.TheWorldHighVoltageType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class AddonStands {
    public static final DeferredRegister<StandType> STANDS = DeferredRegister.create(JojoRegistries.DEFAULT_STANDS_REG, RipplesOfThePastSoftAndWet.MOD_ID);

    public static final DeferredHolder<StandType, SoftAndWetType> SOFT_AND_WET = STANDS.register("soft_and_wet", StandInitSoftAndWet::create);

    public static final DeferredHolder<StandType, SilverChariotType> SILVER_CHARIOT = STANDS.register("silver_chariot", StandInitSilverChariot::create);

    public static final DeferredHolder<StandType, PaisleyParkType> PAISLEY_PARK = STANDS.register("paisley_park", StandInitPaisleyPark::create);

    public static final DeferredHolder<StandType, TheWorldHighVoltageType> THE_WORLD_HIGH_VOLTAGE = STANDS.register("the_world_high_voltage", StandInitTheWorldHighVoltage::create);

    static{
        ModStands.PLAYER_CAN_GET_FROM_ARROW.add(SOFT_AND_WET);
    }
}
