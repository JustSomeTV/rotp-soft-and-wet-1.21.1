package com.jst.rotp_soft_and_wet.jojoimpl.powers.spin.data;

import com.github.standobyte.jojo.util.objects_java.Lerp;
import com.jst.rotp_soft_and_wet.jojoimpl.powers.spin.SpinData;

public class SpinDataEnergy {
    public final SpinData spin;

    public SpinDataEnergy(SpinData spin) {
        this.spin = spin;
    }

    public Lerp.FloatValue energyAmount = new Lerp.FloatValue();

    public boolean isFocusingGoldenRatio;
    public int focusTicks;

    public Lerp.FloatValue _maxEnergy = new Lerp.FloatValue();
    public int maxAmountIncreaseNoDecayTime;

    public float getEnergy() {
        return energyAmount.get();
    }

    public float getCurMaxEnergy() {
        return _maxEnergy.get();
    }

    public float getMaxEnergyPassive() {
        return 2500;
    }

    public float getMaxEnergyPossible() {
        return 1000;
    }
}
