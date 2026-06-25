package com.jst.rotp_soft_and_wet.entity;

import com.github.standobyte.jojo.customobjects.entity_projectile.ModdedProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class SoftAndWetBubbleEntity extends ModdedProjectileEntity {
    protected SoftAndWetBubbleEntity(EntityType<? extends ModdedProjectileEntity> type, LivingEntity shooter, Level level) {
        super(type, shooter, level);
    }

    public SoftAndWetBubbleEntity(
            EntityType<? extends SoftAndWetBubbleEntity> type,
            Level level) {
        super(type, level);
    }

    public SoftAndWetBubbleEntity(Level level, LivingEntity shooter) {
        this(ModEntities.SOFT_AND_WET_BUBBLE.get(), shooter, level);

        setOwner(shooter);

        Vec3 look = shooter.getLookAngle();

        shoot(
                look.x,
                look.y,
                look.z,
                1.5F,
                0.0F
        );
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
}
