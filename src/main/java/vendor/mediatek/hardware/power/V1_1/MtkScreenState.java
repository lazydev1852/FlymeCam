package vendor.mediatek.hardware.power.V1_1;

import java.util.ArrayList;

public final class MtkScreenState {
    public static final int SCREEN_OFF_DISABLE = 0;
    public static final int SCREEN_OFF_ENABLE = 1;
    public static final int SCREEN_OFF_WAIT_RESTORE = 2;

    public static final String toString(int i) {
        if (i == 0) {
            return "SCREEN_OFF_DISABLE";
        }
        if (i == 1) {
            return "SCREEN_OFF_ENABLE";
        }
        if (i == 2) {
            return "SCREEN_OFF_WAIT_RESTORE";
        }
        return "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("SCREEN_OFF_DISABLE");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("SCREEN_OFF_ENABLE");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("SCREEN_OFF_WAIT_RESTORE");
            i2 |= 2;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
