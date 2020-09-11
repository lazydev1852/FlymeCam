package com.meizu.common.datetimepicker;

/* renamed from: com.meizu.common.datetimepicker.a */
/* compiled from: Utils */
public class C1299a {
    /* renamed from: a */
    public static int m4861a(int i, int i2) {
        switch (i) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 1:
                return i2 % 4 == 0 ? 29 : 28;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            default:
                throw new IllegalArgumentException("Invalid Month");
        }
    }
}
