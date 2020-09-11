package android.hardware.power.V1_0;

import java.util.ArrayList;

public final class Feature {
    public static final int POWER_FEATURE_DOUBLE_TAP_TO_WAKE = 1;

    public static final String toString(int i) {
        if (i == 1) {
            return "POWER_FEATURE_DOUBLE_TAP_TO_WAKE";
        }
        return "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("POWER_FEATURE_DOUBLE_TAP_TO_WAKE");
        } else {
            i2 = 0;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
