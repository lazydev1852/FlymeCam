package vendor.mediatek.hardware.power.V1_1;

import java.util.ArrayList;

public final class MtkCusPowerHint {
    public static final int MTK_CUS_AUDIO_LATENCY_DL = 0;
    public static final int MTK_CUS_AUDIO_LATENCY_UL = 1;
    public static final int MTK_CUS_AUDIO_Power_DL = 2;
    public static final int MTK_CUS_HINT_NUM = 3;

    public static final String toString(int i) {
        if (i == 0) {
            return "MTK_CUS_AUDIO_LATENCY_DL";
        }
        if (i == 1) {
            return "MTK_CUS_AUDIO_LATENCY_UL";
        }
        if (i == 2) {
            return "MTK_CUS_AUDIO_Power_DL";
        }
        if (i == 3) {
            return "MTK_CUS_HINT_NUM";
        }
        return "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("MTK_CUS_AUDIO_LATENCY_DL");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("MTK_CUS_AUDIO_LATENCY_UL");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("MTK_CUS_AUDIO_Power_DL");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("MTK_CUS_HINT_NUM");
            i2 |= 3;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
