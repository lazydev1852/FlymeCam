package vendor.mediatek.hardware.power.V1_1;

import java.util.ArrayList;

public final class MtkPowerHint {
    public static final int MTK_POWER_HINT_ACT_SWITCH = 12;
    public static final int MTK_POWER_HINT_APP_ROTATE = 14;
    public static final int MTK_POWER_HINT_APP_TOUCH = 15;
    public static final int MTK_POWER_HINT_BASE = 9;
    public static final int MTK_POWER_HINT_EXT_LAUNCH = 24;
    public static final int MTK_POWER_HINT_FPSGO = 22;
    public static final int MTK_POWER_HINT_FRAME_UPDATE = 16;
    public static final int MTK_POWER_HINT_GALLERY_BOOST = 18;
    public static final int MTK_POWER_HINT_GALLERY_STEREO_BOOST = 19;
    public static final int MTK_POWER_HINT_GAME_LAUNCH = 13;
    public static final int MTK_POWER_HINT_GAMING = 17;
    public static final int MTK_POWER_HINT_INTERACTION = 2;
    public static final int MTK_POWER_HINT_LAUNCH = 8;
    public static final int MTK_POWER_HINT_LOW_POWER = 5;
    public static final int MTK_POWER_HINT_NONE = 0;
    public static final int MTK_POWER_HINT_NUM = 36;
    public static final int MTK_POWER_HINT_PACK_SWITCH = 11;
    public static final int MTK_POWER_HINT_PMS_INSTALL = 23;
    public static final int MTK_POWER_HINT_PROCESS_CREATE = 10;
    public static final int MTK_POWER_HINT_RESV_I = 26;
    public static final int MTK_POWER_HINT_RESV_II = 27;
    public static final int MTK_POWER_HINT_RESV_III = 28;
    public static final int MTK_POWER_HINT_RESV_IV = 29;
    public static final int MTK_POWER_HINT_RESV_IX = 34;
    public static final int MTK_POWER_HINT_RESV_V = 30;
    public static final int MTK_POWER_HINT_RESV_VI = 31;
    public static final int MTK_POWER_HINT_RESV_VII = 32;
    public static final int MTK_POWER_HINT_RESV_VIII = 33;
    public static final int MTK_POWER_HINT_RESV_X = 35;
    public static final int MTK_POWER_HINT_SP = 6;
    public static final int MTK_POWER_HINT_SPORTS = 20;
    public static final int MTK_POWER_HINT_TEST_MODE = 21;
    public static final int MTK_POWER_HINT_VIDEO_DECODE = 4;
    public static final int MTK_POWER_HINT_VIDEO_ENCODE = 3;
    public static final int MTK_POWER_HINT_VR = 7;
    public static final int MTK_POWER_HINT_VSYNC = 1;
    public static final int MTK_POWER_HINT_WIPHY_SPEED_DL = 25;

    public static final String toString(int i) {
        if (i == 0) {
            return "MTK_POWER_HINT_NONE";
        }
        if (i == 1) {
            return "MTK_POWER_HINT_VSYNC";
        }
        if (i == 2) {
            return "MTK_POWER_HINT_INTERACTION";
        }
        if (i == 3) {
            return "MTK_POWER_HINT_VIDEO_ENCODE";
        }
        if (i == 4) {
            return "MTK_POWER_HINT_VIDEO_DECODE";
        }
        if (i == 5) {
            return "MTK_POWER_HINT_LOW_POWER";
        }
        if (i == 6) {
            return "MTK_POWER_HINT_SP";
        }
        if (i == 7) {
            return "MTK_POWER_HINT_VR";
        }
        if (i == 8) {
            return "MTK_POWER_HINT_LAUNCH";
        }
        if (i == 9) {
            return "MTK_POWER_HINT_BASE";
        }
        if (i == 10) {
            return "MTK_POWER_HINT_PROCESS_CREATE";
        }
        if (i == 11) {
            return "MTK_POWER_HINT_PACK_SWITCH";
        }
        if (i == 12) {
            return "MTK_POWER_HINT_ACT_SWITCH";
        }
        if (i == 13) {
            return "MTK_POWER_HINT_GAME_LAUNCH";
        }
        if (i == 14) {
            return "MTK_POWER_HINT_APP_ROTATE";
        }
        if (i == 15) {
            return "MTK_POWER_HINT_APP_TOUCH";
        }
        if (i == 16) {
            return "MTK_POWER_HINT_FRAME_UPDATE";
        }
        if (i == 17) {
            return "MTK_POWER_HINT_GAMING";
        }
        if (i == 18) {
            return "MTK_POWER_HINT_GALLERY_BOOST";
        }
        if (i == 19) {
            return "MTK_POWER_HINT_GALLERY_STEREO_BOOST";
        }
        if (i == 20) {
            return "MTK_POWER_HINT_SPORTS";
        }
        if (i == 21) {
            return "MTK_POWER_HINT_TEST_MODE";
        }
        if (i == 22) {
            return "MTK_POWER_HINT_FPSGO";
        }
        if (i == 23) {
            return "MTK_POWER_HINT_PMS_INSTALL";
        }
        if (i == 24) {
            return "MTK_POWER_HINT_EXT_LAUNCH";
        }
        if (i == 25) {
            return "MTK_POWER_HINT_WIPHY_SPEED_DL";
        }
        if (i == 26) {
            return "MTK_POWER_HINT_RESV_I";
        }
        if (i == 27) {
            return "MTK_POWER_HINT_RESV_II";
        }
        if (i == 28) {
            return "MTK_POWER_HINT_RESV_III";
        }
        if (i == 29) {
            return "MTK_POWER_HINT_RESV_IV";
        }
        if (i == 30) {
            return "MTK_POWER_HINT_RESV_V";
        }
        if (i == 31) {
            return "MTK_POWER_HINT_RESV_VI";
        }
        if (i == 32) {
            return "MTK_POWER_HINT_RESV_VII";
        }
        if (i == 33) {
            return "MTK_POWER_HINT_RESV_VIII";
        }
        if (i == 34) {
            return "MTK_POWER_HINT_RESV_IX";
        }
        if (i == 35) {
            return "MTK_POWER_HINT_RESV_X";
        }
        if (i == 36) {
            return "MTK_POWER_HINT_NUM";
        }
        return "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("MTK_POWER_HINT_NONE");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("MTK_POWER_HINT_VSYNC");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("MTK_POWER_HINT_INTERACTION");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("MTK_POWER_HINT_VIDEO_ENCODE");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("MTK_POWER_HINT_VIDEO_DECODE");
            i2 |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("MTK_POWER_HINT_LOW_POWER");
            i2 |= 5;
        }
        if ((i & 6) == 6) {
            arrayList.add("MTK_POWER_HINT_SP");
            i2 |= 6;
        }
        if ((i & 7) == 7) {
            arrayList.add("MTK_POWER_HINT_VR");
            i2 |= 7;
        }
        if ((i & 8) == 8) {
            arrayList.add("MTK_POWER_HINT_LAUNCH");
            i2 |= 8;
        }
        if ((i & 9) == 9) {
            arrayList.add("MTK_POWER_HINT_BASE");
            i2 |= 9;
        }
        if ((i & 10) == 10) {
            arrayList.add("MTK_POWER_HINT_PROCESS_CREATE");
            i2 |= 10;
        }
        if ((i & 11) == 11) {
            arrayList.add("MTK_POWER_HINT_PACK_SWITCH");
            i2 |= 11;
        }
        if ((i & 12) == 12) {
            arrayList.add("MTK_POWER_HINT_ACT_SWITCH");
            i2 |= 12;
        }
        if ((i & 13) == 13) {
            arrayList.add("MTK_POWER_HINT_GAME_LAUNCH");
            i2 |= 13;
        }
        if ((i & 14) == 14) {
            arrayList.add("MTK_POWER_HINT_APP_ROTATE");
            i2 |= 14;
        }
        if ((i & 15) == 15) {
            arrayList.add("MTK_POWER_HINT_APP_TOUCH");
            i2 |= 15;
        }
        if ((i & 16) == 16) {
            arrayList.add("MTK_POWER_HINT_FRAME_UPDATE");
            i2 |= 16;
        }
        if ((i & 17) == 17) {
            arrayList.add("MTK_POWER_HINT_GAMING");
            i2 |= 17;
        }
        if ((i & 18) == 18) {
            arrayList.add("MTK_POWER_HINT_GALLERY_BOOST");
            i2 |= 18;
        }
        if ((i & 19) == 19) {
            arrayList.add("MTK_POWER_HINT_GALLERY_STEREO_BOOST");
            i2 |= 19;
        }
        if ((i & 20) == 20) {
            arrayList.add("MTK_POWER_HINT_SPORTS");
            i2 |= 20;
        }
        if ((i & 21) == 21) {
            arrayList.add("MTK_POWER_HINT_TEST_MODE");
            i2 |= 21;
        }
        if ((i & 22) == 22) {
            arrayList.add("MTK_POWER_HINT_FPSGO");
            i2 |= 22;
        }
        if ((i & 23) == 23) {
            arrayList.add("MTK_POWER_HINT_PMS_INSTALL");
            i2 |= 23;
        }
        if ((i & 24) == 24) {
            arrayList.add("MTK_POWER_HINT_EXT_LAUNCH");
            i2 |= 24;
        }
        if ((i & 25) == 25) {
            arrayList.add("MTK_POWER_HINT_WIPHY_SPEED_DL");
            i2 |= 25;
        }
        if ((i & 26) == 26) {
            arrayList.add("MTK_POWER_HINT_RESV_I");
            i2 |= 26;
        }
        if ((i & 27) == 27) {
            arrayList.add("MTK_POWER_HINT_RESV_II");
            i2 |= 27;
        }
        if ((i & 28) == 28) {
            arrayList.add("MTK_POWER_HINT_RESV_III");
            i2 |= 28;
        }
        if ((i & 29) == 29) {
            arrayList.add("MTK_POWER_HINT_RESV_IV");
            i2 |= 29;
        }
        if ((i & 30) == 30) {
            arrayList.add("MTK_POWER_HINT_RESV_V");
            i2 |= 30;
        }
        if ((i & 31) == 31) {
            arrayList.add("MTK_POWER_HINT_RESV_VI");
            i2 |= 31;
        }
        if ((i & 32) == 32) {
            arrayList.add("MTK_POWER_HINT_RESV_VII");
            i2 |= 32;
        }
        if ((i & 33) == 33) {
            arrayList.add("MTK_POWER_HINT_RESV_VIII");
            i2 |= 33;
        }
        if ((i & 34) == 34) {
            arrayList.add("MTK_POWER_HINT_RESV_IX");
            i2 |= 34;
        }
        if ((i & 35) == 35) {
            arrayList.add("MTK_POWER_HINT_RESV_X");
            i2 |= 35;
        }
        if ((i & 36) == 36) {
            arrayList.add("MTK_POWER_HINT_NUM");
            i2 |= 36;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
