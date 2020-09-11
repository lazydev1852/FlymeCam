package vendor.mediatek.hardware.power.V1_1;

import java.util.ArrayList;

public final class MtkDfpsMode {
    public static final int DFPS_MODE_ARR = 2;
    public static final int DFPS_MODE_DEFAULT = 0;
    public static final int DFPS_MODE_FRR = 1;
    public static final int DFPS_MODE_INTERNAL_SW = 3;
    public static final int DFPS_MODE_MAXIMUM = 4;

    public static final String toString(int i) {
        if (i == 0) {
            return "DFPS_MODE_DEFAULT";
        }
        if (i == 1) {
            return "DFPS_MODE_FRR";
        }
        if (i == 2) {
            return "DFPS_MODE_ARR";
        }
        if (i == 3) {
            return "DFPS_MODE_INTERNAL_SW";
        }
        if (i == 4) {
            return "DFPS_MODE_MAXIMUM";
        }
        return "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("DFPS_MODE_DEFAULT");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("DFPS_MODE_FRR");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("DFPS_MODE_ARR");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("DFPS_MODE_INTERNAL_SW");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("DFPS_MODE_MAXIMUM");
            i2 |= 4;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
