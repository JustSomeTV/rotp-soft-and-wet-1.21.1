package com.jst.rotp_soft_and_wet.entity;

import com.jst.rotp_soft_and_wet.entity.goals.InstantExplodeGoal;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SheerHeartAttackEntity extends Creeper {
    private final float explosionRadius = 3.0F;

    public SheerHeartAttackEntity(EntityType<? extends Creeper> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new InstantExplodeGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, false));
    }

    public void triggerInstantExplosion() {
        if (!this.level().isClientSide) {
            this.dead = true;
            this.level().explode(
                    this,
                    this.getX(),this.getY(),this.getZ(),
                    this.explosionRadius,
                    Level.ExplosionInteraction.NONE
            );
            this.discard();
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.ARMOR, 255d)
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.MOVEMENT_SPEED, 0.25d)
                .add(Attributes.KNOCKBACK_RESISTANCE, 255.0d)
                .add(Attributes.MAX_HEALTH, 255.0d)
                .add(Attributes.FALL_DAMAGE_MULTIPLIER, 0d)
                .add(Attributes.ARMOR_TOUGHNESS, 255d)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 255d)
                .add(Attributes.ATTACK_DAMAGE, 0D);
    }


}
