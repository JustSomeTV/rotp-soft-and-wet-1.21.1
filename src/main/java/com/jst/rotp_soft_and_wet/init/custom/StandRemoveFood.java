package com.jst.rotp_soft_and_wet.init.custom;

import com.github.standobyte.jojo.powersystem.standpower.StandPower;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class StandRemoveFood extends Item {
    public StandRemoveFood(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (!level.isClientSide && entity instanceof Player player) {
            StandPower stand = StandPower.get(player);

            if (stand != null && stand.hasPower()) {
                stand.setStand(null);
            }
        }
        return result;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasControlDown()) {
            tooltipComponents.add(Component.translatable("tooltip.rotp_soft_and_wet.rokakaka.shift_down"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
