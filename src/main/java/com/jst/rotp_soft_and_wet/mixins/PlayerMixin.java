package com.jst.rotp_soft_and_wet.mixins;

import com.jst.rotp_soft_and_wet.data.LivingData;

import com.jst.rotp_soft_and_wet.data.PlayerDataAccess;
import net.minecraft.world.entity.player.Player;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Player.class)
public class PlayerMixin implements PlayerDataAccess {

    @Unique
    private final LivingData rotp$livingData = new LivingData();

    @Override
    public LivingData rotp$getLivingData() {
        return rotp$livingData;
    }
}