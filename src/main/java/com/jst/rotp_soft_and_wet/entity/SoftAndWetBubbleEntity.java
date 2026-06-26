package com.jst.rotp_soft_and_wet.entity;

import com.github.standobyte.jojo.customobjects.entity_projectile.ModdedProjectileEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class SoftAndWetBubbleEntity extends ModdedProjectileEntity {
    public enum BubbleType {
        NORMAL,
        BLINDNESS,
        FRICTION,
        MOISTURE
    }

    private BubbleType bubbleType = BubbleType.NORMAL;

    public void setBubbleType(BubbleType type) {
        this.bubbleType = type;
    }

    public BubbleType getBubbleType() {
        return bubbleType;
    }

    protected SoftAndWetBubbleEntity(EntityType<? extends ModdedProjectileEntity> type, LivingEntity shooter, Level level) {
        super(type, shooter, level);
    }

    public SoftAndWetBubbleEntity(
            EntityType<? extends SoftAndWetBubbleEntity> type, Level level) {
        super(type, level);
    }

    public SoftAndWetBubbleEntity(Level level, LivingEntity shooter) {
        this(ModEntities.SOFT_AND_WET_BUBBLE.get(), shooter, level);

        setOwner(shooter);

        Vec3 look = shooter.getLookAngle();

        shoot(look.x, look.y, look.z, 1.5F, 0.0F);
    }


    @Override
    public int ticksLifespan() {
        return 180;
    }

    @Override
    protected float getBaseDamage() {
        return 4;
    }

    @Override
    protected float getMaxHardnessBreakable() {
        return 0;
    }

    @Override
    public boolean standDamage() {
        return true;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (!(result.getEntity() instanceof LivingEntity target)) {
            discard();
            return;
        }

        switch (bubbleType) {
            case BLINDNESS:
                target.addEffect(
                        new MobEffectInstance(MobEffects.BLINDNESS, 100, 0));
                break;
            case FRICTION:
                target.addEffect(
                        new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 255));
                break;
            case MOISTURE:
                target.addEffect(
                        new MobEffectInstance(MobEffects.WEAKNESS, 120, 1));
                break;
        }
        discard();
    }
}
