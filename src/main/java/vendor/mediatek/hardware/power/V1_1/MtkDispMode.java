package vendor.mediatek.hardware.power.V1_1;

import java.util.ArrayList;

public final class MtkDispMode {
    public static final int DISP_MODE_DEFAULT = 0;
    public static final int DISP_MODE_EN = 1;
    public static final int DISP_MODE_NUM = 2;

    public static final String toString(int i) {
        if (i == 0) {
            return "DISP_MODE_DEFAULT";
        }
        if (i == 1) {
            return "DISP_MODE_EN";
        }
        if (i == 2) {
            return "DISP_MODE_NUM";
        }
        return "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("DISP_MODE_DEFAULT");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("DISP_MODE_EN");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("DISP_MODE_NUM");
            i2 |= 2;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
