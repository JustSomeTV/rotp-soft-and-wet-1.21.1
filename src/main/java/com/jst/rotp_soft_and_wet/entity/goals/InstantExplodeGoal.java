package com.jst.rotp_soft_and_wet.entity.goals;

import com.jst.rotp_soft_and_wet.entity.SheerHeartAttackEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class InstantExplodeGoal extends Goal {
    private final SheerHeartAttackEntity entity;
    private LivingEntity target;
    private final double explosionDistanceSq = 3.0D;

    public InstantExplodeGoal(SheerHeartAttackEntity entity) {
        this.entity = entity;

        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        this.target = this.entity.getTarget();

        return this.target != null && this.target.isAlive();
    }

    @Override
    public void start() {
        this.entity.getNavigation().moveTo(this.target, 1.25D);
    }

    @Override
    public void tick() {
        if (this.target == null) return;

        this.entity.getNavigation().moveTo(this.target, 1.25D);

        if (this.entity.distanceToSqr(this.target) <= this.explosionDistanceSq) {
            this.entity.triggerInstantExplosion();
        }
    }
}
