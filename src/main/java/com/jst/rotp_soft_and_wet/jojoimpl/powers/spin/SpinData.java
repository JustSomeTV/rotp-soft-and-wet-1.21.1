package com.jst.rotp_soft_and_wet.jojoimpl.powers.spin;

import com.github.standobyte.jojo.powersystem.Power;
import com.github.standobyte.jojo.powersystem.playerpower.PlayerPowerData;
import com.jst.rotp_soft_and_wet.jojoimpl.powers.spin.data.SpinDataSkills;
import com.jst.rotp_soft_and_wet.jojoimpl.powers.spin.data.SpinDataStats;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.LivingEntity;

public class SpinData extends PlayerPowerData {
    public SpinDataStats stats = new SpinDataStats(this);
    public SpinDataSkills skills = new SpinDataSkills(this);

    public SpinData() {
        super(SpinPowerType.SPIN.get());
    }

    @Override
    public void tick(Power<?> userPower) {
        super.tick(userPower);
        LivingEntity user = userPower.getUser();
    }

    @Override
    public CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag nbt = super.serializeNBT(provider);

        return nbt;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag nbt) {
        super.deserializeNBT(provider, nbt);
    }

    @Override
    public void toBuf(FriendlyByteBuf buf, boolean isSentToTracking) {

    }

    @Override
    public void fromBuf(FriendlyByteBuf buf, boolean isSentToTracking) {

    }
}
