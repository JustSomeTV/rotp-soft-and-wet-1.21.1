package com.jst.rotp_soft_and_wet.entity;

import com.jst.rotp_soft_and_wet.entity.goals.InstantExplodeGoal;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class SheerHeartAttackEntity extends Monster{
    private final float explosionRadius = 3.0F;

    public SheerHeartAttackEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    public void setOwnerUUID(@Nullable UUID uuid) {
        entityData.set(OWNER_UUID, Optional.ofNullable(uuid));
    }

    private static final EntityDataAccessor<Optional<UUID>> OWNER_UUID =
            SynchedEntityData.defineId(SheerHeartAttackEntity.class, EntityDataSerializers.OPTIONAL_UUID);

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);

        builder.define(OWNER_UUID, Optional.empty());
    }

    @Nullable
    public UUID getOwnerUUID() {
        return entityData.get(OWNER_UUID).orElse(null);
    }

    @Nullable
    public LivingEntity getOwner(){
        UUID uuid = getOwnerUUID();

        if (uuid == null){
            return null;
        }

        if (!(level() instanceof ServerLevel server))
            return null;

        Entity entity = server.getEntity(uuid);

        return entity instanceof LivingEntity living
                ? living
                : null;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);

        UUID owner = getOwnerUUID();

        if (owner != null){
            tag.putUUID("Owner", owner);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);

        if (tag.hasUUID("Owner")){
            entityData.set(OWNER_UUID, Optional.of(tag.getUUID("Owner")));
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new InstantExplodeGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, 10, false, true, target -> target != this.getOwner()));
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
