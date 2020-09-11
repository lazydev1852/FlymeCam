package vendor.mediatek.hardware.power.V1_1;

import java.util.ArrayList;

public final class MtkHintOp {
    public static final int MTK_HINT_ALWAYS_ENABLE = 268435455;

    public static final String toString(int i) {
        if (i == 268435455) {
            return "MTK_HINT_ALWAYS_ENABLE";
        }
        return "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = MTK_HINT_ALWAYS_ENABLE;
        if ((i & MTK_HINT_ALWAYS_ENABLE) == 268435455) {
            arrayList.add("MTK_HINT_ALWAYS_ENABLE");
        } else {
            i2 = 0;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
