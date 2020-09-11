package vendor.mediatek.hardware.power.V1_1;

import java.util.ArrayList;

public final class MtkActState {
    public static final int STATE_DEAD = 3;
    public static final int STATE_DESTORYED = 2;
    public static final int STATE_PAUSED = 0;
    public static final int STATE_RESUMED = 1;
    public static final int STATE_STOPPED = 4;

    public static final String toString(int i) {
        if (i == 0) {
            return "STATE_PAUSED";
        }
        if (i == 1) {
            return "STATE_RESUMED";
        }
        if (i == 2) {
            return "STATE_DESTORYED";
        }
        if (i == 3) {
            return "STATE_DEAD";
        }
        if (i == 4) {
            return "STATE_STOPPED";
        }
        return "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("STATE_PAUSED");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("STATE_RESUMED");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("STATE_DESTORYED");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("STATE_DEAD");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("STATE_STOPPED");
            i2 |= 4;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
