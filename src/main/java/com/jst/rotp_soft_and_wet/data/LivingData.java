package com.jst.rotp_soft_and_wet.data;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;

import java.util.*;

public class LivingData {
    private final Set<Integer> markedEntities = new HashSet<>();
    private final Set<BlockPos> markedBlocks = new HashSet<>();

    public Set<Integer> getMarkedEntities() {
        return markedEntities;
    }

    public Set<BlockPos> getMarkedBlocks() {
        return markedBlocks;
    }

    public void markEntity(Entity entity) {
        markedEntities.add(entity.getId());
    }

    public void markBlock(BlockPos pos) {
        markedBlocks.add(pos.immutable());
    }

    public void clearMarks() {
        markedEntities.clear();
        markedBlocks.clear();
    }

    public void copyFrom(LivingData data) {
        this.markedEntities.clear();
        this.markedEntities.addAll(data.markedEntities);

        this.markedBlocks.clear();
        this.markedBlocks.addAll(data.markedBlocks);
    }

    public void setMarkedEntities(Collection<Integer> entities) {
        markedEntities.clear();
        markedEntities.addAll(entities);
    }

    public void setMarkedBlocks(Collection<BlockPos> blocks) {
        markedBlocks.clear();
        markedBlocks.addAll(blocks);
    }
}