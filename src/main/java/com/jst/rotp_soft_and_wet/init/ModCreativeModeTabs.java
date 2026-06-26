package com.jst.rotp_soft_and_wet.init;

import com.github.standobyte.jojo.init.ModItemDataComponents;
import com.github.standobyte.jojo.mechanics.standdisc.StandDiscItem;
import com.github.standobyte.jojo.mechanics.standdisc.StandWrittenOnDisc;
import com.github.standobyte.jojo.powersystem.standpower.StandInstance;
import com.github.standobyte.jojo.powersystem.standpower.type.StandType;
import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import com.jst.rotp_soft_and_wet.init.power.stand.AddonStands;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RipplesOfThePastSoftAndWet.MOD_ID);

    private static ItemStack standDisc(DeferredHolder<StandType, ?> stand) {
        return StandDiscItem.withStand(new StandInstance(stand.get()));
    }

    public static final Supplier<CreativeModeTab> SOFT_AND_WET_TAB = CREATIVE_MODE_TAB.register("soft_and_wet_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MOD_LOGO.get()))
                    .title(Component.translatable("creativetab.soft_and_wet.soft_and_wet_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ROKAKAKA.get());
                        output.accept(ModItems.STEEL_BALL.get());
                        output.accept(standDisc(AddonStands.SOFT_AND_WET));
                        output.accept(standDisc(AddonStands.PAISLEY_PARK));
                    })
                    .build());

    public static void register(IEventBus eventBus) {

        CREATIVE_MODE_TAB.register(eventBus);
    }
}
