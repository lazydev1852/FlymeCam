package vendor.mediatek.hardware.power.V1_1;

import java.util.ArrayList;

public final class MtkQueryCmd {
    public static final int CMD_GET_CLUSTER_CPU_FREQ_MAX = 4;
    public static final int CMD_GET_CLUSTER_CPU_FREQ_MIN = 3;
    public static final int CMD_GET_CLUSTER_CPU_NUM = 2;
    public static final int CMD_GET_CLUSTER_NUM = 1;
    public static final int CMD_GET_FOREGROUND_PID = 6;
    public static final int CMD_GET_FOREGROUND_TYPE = 7;
    public static final int CMD_GET_GPU_FREQ_COUNT = 5;
    public static final int CMD_GET_WALT_DURATION = 9;
    public static final int CMD_GET_WALT_FOLLOW = 8;

    public static final String toString(int i) {
        if (i == 1) {
            return "CMD_GET_CLUSTER_NUM";
        }
        if (i == 2) {
            return "CMD_GET_CLUSTER_CPU_NUM";
        }
        if (i == 3) {
            return "CMD_GET_CLUSTER_CPU_FREQ_MIN";
        }
        if (i == 4) {
            return "CMD_GET_CLUSTER_CPU_FREQ_MAX";
        }
        if (i == 5) {
            return "CMD_GET_GPU_FREQ_COUNT";
        }
        if (i == 6) {
            return "CMD_GET_FOREGROUND_PID";
        }
        if (i == 7) {
            return "CMD_GET_FOREGROUND_TYPE";
        }
        if (i == 8) {
            return "CMD_GET_WALT_FOLLOW";
        }
        if (i == 9) {
            return "CMD_GET_WALT_DURATION";
        }
        return "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("CMD_GET_CLUSTER_NUM");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("CMD_GET_CLUSTER_CPU_NUM");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("CMD_GET_CLUSTER_CPU_FREQ_MIN");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("CMD_GET_CLUSTER_CPU_FREQ_MAX");
            i2 |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("CMD_GET_GPU_FREQ_COUNT");
            i2 |= 5;
        }
        if ((i & 6) == 6) {
            arrayList.add("CMD_GET_FOREGROUND_PID");
            i2 |= 6;
        }
        if ((i & 7) == 7) {
            arrayList.add("CMD_GET_FOREGROUND_TYPE");
            i2 |= 7;
        }
        if ((i & 8) == 8) {
            arrayList.add("CMD_GET_WALT_FOLLOW");
            i2 |= 8;
        }
        if ((i & 9) == 9) {
            arrayList.add("CMD_GET_WALT_DURATION");
            i2 |= 9;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
