package com.meizu.common.util;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* renamed from: com.meizu.common.util.d */
public class LunarCalendar {

    /* renamed from: a */
    private static final int[] f4508a = {0, 31, 59, 90, 120, Opcodes.DCMPL, Opcodes.PUTFIELD, 212, 243, 273, ARPMessageType.MSG_TYPE_IMU_CLOSE_RES, 334, 365};

    /* renamed from: b */
    private static final TimeZone f4509b = TimeZone.getTimeZone("UTC");

    /* renamed from: c */
    private static final int[] f4510c = {701770, 8697535, 306771, 677704, 5580477, 861776, 890180, 4631225, 354893, 634178, 2404022, 306762, 6966718, 675154, 861510, 6116026, 742478, 879171, 2714935, 613195, 7642049, 300884, 674632, 5973436, 435536, 447557, 4905656, 177741, 612162, 2398135, 300874, 6703934, 870993, 959814, 5690554, 372046, 177732, 3749688, 601675, 8165055, 824659, 870984, 7185723, 742735, 354885, 4894137, 154957, 601410, 2921910, 693578, 8080061, 445009, 742726, 5593787, 318030, 678723, 3484600, 338764, 9082175, 955730, 436808, 7001404, 701775, 308805, 4871993, 677709, 337474, 4100917, 890185, 7711422, 354897, 617798, 5549755, 306511, 675139, 5056183, 861515, 9261759, 742482, 748103, 6909244, 613200, 301893, 4869049, 674637, 11216322, 435540, 447561, 7002685, 702033, 612166, 5543867, 300879, 412484, 3581239, 959818, 8827583, 371795, 702023, 5846716, 601680, 824901, 5065400, 870988, 894273, 2468534, 354889, 8039869, 154962, 601415, 6067642, 693582, 739907, 4937015, 709962, 9788095, 309843, 678728, 6630332, 338768, 693061, 4672185, 436812, 709953, 2415286, 308810, 6969149, 675409, 861766, 6198074, 873293, 371267, 3585335, 617803, 11841215, 306515, 675144, 7153084, 861519, 873028, 6138424, 744012, 355649, 2403766, 301898, 8014782, 674641, 697670, 5984954, 447054, 711234, 3496759, 603979, 8689601, 300883, 412488, 6726972, 959823, 436804, 4896312, 699980, 601666, 3970869, 824905, 8211133, 870993, 894277, 5614266, 354894, 683331, 4533943, 339275, 9082303, 693587, 739911, 7034171, 709967, 350789, 4873528, 678732, 338754, 3838902, 430921, 7809469, 436817, 709958, 5561018, 308814, 677699, 4532024, 861770, 9343806, 873042, 895559, 6731067, 355663, 306757, 4869817, 675148, 857409, 2986677};

    /* renamed from: d */
    private static final Pattern f4511d = Pattern.compile("(19|20)[0-9]{2}-((0)?[1-9]|1[012])-((0)?[1-9]|(1|2)[0-9]|30)$");

    /* renamed from: a */
    public static final int[] m5140a(int i, int i2, int i3, boolean z) {
        if (i < 1899) {
            i = 1899;
        } else if (i > 2099) {
            i = 2099;
        }
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 12) {
            i2 = 12;
        }
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 30) {
            i3 = 30;
        }
        if (i < 1899 || i > 2099 || i2 < 1 || i2 > 12 || i3 < 1 || i3 > 30) {
            throw new IllegalArgumentException("Illegal lunar date, must be like that:\n\tyear : 1900~2099\n\tmonth : 1~12\n\tday : 1~30\n\terror date:" + i + " " + i2 + " " + i3);
        }
        int i4 = i - 1899;
        int i5 = (f4510c[i4] & 31) - 1;
        if (i4 == 1) {
            i5++;
        }
        if (((f4510c[i4] & 96) >> 5) == 2) {
            i5 += 31;
        }
        int i6 = i5;
        for (int i7 = 1; i7 < i2; i7++) {
            i6 = ((524288 >> (i7 + -1)) & f4510c[i4]) == 0 ? i6 + 29 : i6 + 30;
        }
        int i8 = i6 + i3;
        int i9 = (f4510c[i4] & 15728640) >> 20;
        if (i9 != 0 && (i2 > i9 || (i2 == i9 && z))) {
            i8 = ((524288 >> (i2 - 1)) & f4510c[i4]) == 0 ? i8 + 29 : i8 + 30;
        }
        if (i8 > 366 || (i % 4 != 0 && i8 > 365)) {
            i++;
            i8 = i % 4 == 1 ? i8 - 366 : i8 - 365;
        }
        int[] iArr = new int[3];
        int i10 = 1;
        while (true) {
            if (i10 >= 13) {
                break;
            }
            int i11 = f4508a[i10];
            int i12 = i % 4;
            if (i12 == 0 && i10 > 2) {
                i11++;
            }
            if (i12 == 0 && i10 == 2 && i11 + 1 == i8) {
                iArr[1] = i10;
                iArr[2] = i8 - 31;
                break;
            } else if (i11 >= i8) {
                iArr[1] = i10;
                int i13 = i10 - 1;
                int i14 = f4508a[i13];
                if (i12 == 0 && i10 > 2) {
                    i14++;
                }
                if (i8 > i14) {
                    iArr[2] = i8 - i14;
                } else if (i8 != i14) {
                    iArr[2] = i8;
                } else if (i12 == 0 && i10 == 2) {
                    iArr[2] = (f4508a[i10] - f4508a[i13]) + 1;
                } else {
                    iArr[2] = f4508a[i10] - f4508a[i13];
                }
            } else {
                i10++;
            }
        }
        iArr[0] = i;
        return iArr;
    }

    /* renamed from: a */
    public static final int[] m5139a(int i, int i2, int i3) {
        int[] iArr = new int[4];
        int i4 = 1899;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(1899, 1, 10);
        gregorianCalendar.setTimeZone(f4509b);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(i, i2 - 1, i3);
        gregorianCalendar2.setTimeZone(f4509b);
        int time = (int) ((gregorianCalendar2.getTime().getTime() - gregorianCalendar.getTime().getTime()) / 86400000);
        int i5 = 0;
        int i6 = 0;
        while (i4 <= 2099 && time > 0) {
            i6 = m5141b(i4);
            time -= i6;
            i4++;
        }
        if (time < 0) {
            time += i6;
            i4--;
        }
        iArr[0] = i4;
        int a = m5136a(i4);
        int i7 = time;
        int i8 = 1;
        int i9 = 0;
        while (i8 <= 13 && i7 > 0) {
            i9 = m5137a(i4, i8);
            i7 -= i9;
            i8++;
        }
        if (i7 < 0) {
            i7 += i9;
            i8--;
        }
        if (a != 0 && i8 > a && i8 - 1 == a) {
            i5 = 1;
        }
        iArr[1] = i8;
        iArr[2] = i7 + 1;
        iArr[3] = i5;
        return iArr;
    }

    /* renamed from: a */
    public static final int m5138a(int i, int i2, boolean z) {
        int a = m5136a(i);
        int i3 = (a == 0 || i2 <= a) ? 0 : 1;
        if (!z) {
            return m5137a(i, i2 + i3);
        }
        if (a == 0 || a != i2) {
            return 0;
        }
        return m5137a(i, i2 + 1);
    }

    /* renamed from: b */
    private static int m5141b(int i) {
        int i2 = m5136a(i) != 0 ? 377 : 348;
        int i3 = f4510c[i - 1899] & 1048448;
        for (int i4 = 524288; i4 > 7; i4 >>= 1) {
            if ((i3 & i4) != 0) {
                i2++;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private static int m5137a(int i, int i2) {
        if (i < 1899) {
            i = 1899;
        }
        return (f4510c[i - 1899] & (1048576 >> i2)) == 0 ? 29 : 30;
    }

    /* renamed from: a */
    public static int m5136a(int i) {
        if (i < 1899) {
            i = 1899;
        }
        return (f4510c[Math.min(f4510c.length - 1, i - 1899)] & 15728640) >> 20;
    }
}
