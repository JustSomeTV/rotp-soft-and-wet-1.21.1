package com.jst.rotp_soft_and_wet.init;

import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import com.jst.rotp_soft_and_wet.init.custom.StandRemoveFood;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.awt.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RipplesOfThePastSoftAndWet.MOD_ID);

    //Mod Logo
    public static final DeferredItem<Item> MOD_LOGO = ITEMS.register("mod_logo",
            () -> new Item(new Item.Properties()));

    //Misc Items
    public static final DeferredItem<Item> ROKAKAKA = ITEMS.register("rokakaka",
            () -> new StandRemoveFood(new Item.Properties().food(ModFoodProperties.ROKAKAKA)));
    public static final DeferredItem<Item> ROKAKAKA_SEEDS = ITEMS.register("rokakaka_seeds",
            () -> new ItemNameBlockItem(ModBlocks.ROKAKAKA_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> STEEL_BALL = ITEMS.register("steel_ball",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}