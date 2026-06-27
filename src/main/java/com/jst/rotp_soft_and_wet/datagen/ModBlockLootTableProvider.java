package com.jst.rotp_soft_and_wet.datagen;

import com.jst.rotp_soft_and_wet.init.ModBlocks;
import com.jst.rotp_soft_and_wet.init.ModItems;
import com.jst.rotp_soft_and_wet.init.custom.RokakakaCropBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.ROKAKAKA_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RokakakaCropBlock.AGE, 3));

        this.add(ModBlocks.ROKAKAKA_CROP.get(), this.createCropDrops(ModBlocks.ROKAKAKA_CROP.get(),
                ModItems.ROKAKAKA.get(), ModItems.ROKAKAKA_SEEDS.get(), lootItemConditionBuilder));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
