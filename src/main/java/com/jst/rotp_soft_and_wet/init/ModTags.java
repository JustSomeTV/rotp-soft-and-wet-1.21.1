package com.jst.rotp_soft_and_wet.init;

import com.jst.rotp_soft_and_wet.core.RipplesOfThePastSoftAndWet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {

    public static final TagKey<Item> SPIN_ITEMS = createModTag("spin_items");

    private static TagKey<Item> createModTag(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(RipplesOfThePastSoftAndWet.MOD_ID, name));
    }

    private static TagKey<Item> createCommonTag(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", name));
    }
}
