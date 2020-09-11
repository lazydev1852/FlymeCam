package android.hardware.power.V1_0;

import java.util.ArrayList;

public final class PowerHint {
    public static final int INTERACTION = 2;
    public static final int LAUNCH = 8;
    public static final int LOW_POWER = 5;
    public static final int SUSTAINED_PERFORMANCE = 6;
    public static final int VIDEO_DECODE = 4;
    public static final int VIDEO_ENCODE = 3;
    public static final int VR_MODE = 7;
    public static final int VSYNC = 1;

    public static final String toString(int i) {
        if (i == 1) {
            return "VSYNC";
        }
        if (i == 2) {
            return "INTERACTION";
        }
        if (i == 3) {
            return "VIDEO_ENCODE";
        }
        if (i == 4) {
            return "VIDEO_DECODE";
        }
        if (i == 5) {
            return "LOW_POWER";
        }
        if (i == 6) {
            return "SUSTAINED_PERFORMANCE";
        }
        if (i == 7) {
            return "VR_MODE";
        }
        if (i == 8) {
            return "LAUNCH";
        }
        return "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("VSYNC");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("INTERACTION");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("VIDEO_ENCODE");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("VIDEO_DECODE");
            i2 |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("LOW_POWER");
            i2 |= 5;
        }
        if ((i & 6) == 6) {
            arrayList.add("SUSTAINED_PERFORMANCE");
            i2 |= 6;
        }
        if ((i & 7) == 7) {
            arrayList.add("VR_MODE");
            i2 |= 7;
        }
        if ((i & 8) == 8) {
            arrayList.add("LAUNCH");
            i2 |= 8;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
