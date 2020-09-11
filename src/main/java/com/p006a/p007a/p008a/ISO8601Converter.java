package com.p006a.p007a.p008a;

import com.p006a.p007a.XMPDateTime;
import com.p006a.p007a.XMPException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* renamed from: com.a.a.a.e */
public final class ISO8601Converter {
    /* renamed from: a */
    public static XMPDateTime m59a(String str) throws XMPException {
        return m60a(str, new XMPDateTimeImpl());
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x020a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x020b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.p006a.p007a.XMPDateTime m60a(java.lang.String r13, com.p006a.p007a.XMPDateTime r14) throws com.p006a.p007a.XMPException {
        /*
            com.p006a.p007a.p008a.ParameterAsserts.m64a((java.lang.Object) r13)
            com.a.a.a.i r0 = new com.a.a.a.i
            r0.<init>(r13)
            r13 = 0
            char r1 = r0.mo7511a(r13)
            r2 = 84
            r3 = 58
            r4 = 1
            if (r1 == r2) goto L_0x0031
            int r1 = r0.mo7512a()
            r5 = 2
            if (r1 < r5) goto L_0x0021
            char r1 = r0.mo7511a(r4)
            if (r1 == r3) goto L_0x0031
        L_0x0021:
            int r1 = r0.mo7512a()
            r6 = 3
            if (r1 < r6) goto L_0x002f
            char r1 = r0.mo7511a(r5)
            if (r1 != r3) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r1 = 0
            goto L_0x0032
        L_0x0031:
            r1 = 1
        L_0x0032:
            r5 = 45
            r6 = 5
            if (r1 != 0) goto L_0x00c2
            char r7 = r0.mo7511a(r13)
            if (r7 != r5) goto L_0x0040
            r0.mo7516d()
        L_0x0040:
            java.lang.String r7 = "Invalid year in date string"
            r8 = 9999(0x270f, float:1.4012E-41)
            int r7 = r0.mo7513a(r7, r8)
            boolean r8 = r0.mo7514b()
            if (r8 == 0) goto L_0x005d
            char r8 = r0.mo7515c()
            if (r8 != r5) goto L_0x0055
            goto L_0x005d
        L_0x0055:
            com.a.a.c r13 = new com.a.a.c
            java.lang.String r14 = "Invalid date string, after year"
            r13.<init>(r14, r6)
            throw r13
        L_0x005d:
            char r8 = r0.mo7511a(r13)
            if (r8 != r5) goto L_0x0064
            int r7 = -r7
        L_0x0064:
            r14.mo7470a((int) r7)
            boolean r7 = r0.mo7514b()
            if (r7 != 0) goto L_0x006e
            return r14
        L_0x006e:
            r0.mo7516d()
            java.lang.String r7 = "Invalid month in date string"
            r8 = 12
            int r7 = r0.mo7513a(r7, r8)
            boolean r8 = r0.mo7514b()
            if (r8 == 0) goto L_0x008e
            char r8 = r0.mo7515c()
            if (r8 != r5) goto L_0x0086
            goto L_0x008e
        L_0x0086:
            com.a.a.c r13 = new com.a.a.c
            java.lang.String r14 = "Invalid date string, after month"
            r13.<init>(r14, r6)
            throw r13
        L_0x008e:
            r14.mo7473b(r7)
            boolean r7 = r0.mo7514b()
            if (r7 != 0) goto L_0x0098
            return r14
        L_0x0098:
            r0.mo7516d()
            java.lang.String r7 = "Invalid day in date string"
            r8 = 31
            int r7 = r0.mo7513a(r7, r8)
            boolean r8 = r0.mo7514b()
            if (r8 == 0) goto L_0x00b8
            char r8 = r0.mo7515c()
            if (r8 != r2) goto L_0x00b0
            goto L_0x00b8
        L_0x00b0:
            com.a.a.c r13 = new com.a.a.c
            java.lang.String r14 = "Invalid date string, after day"
            r13.<init>(r14, r6)
            throw r13
        L_0x00b8:
            r14.mo7475c(r7)
            boolean r7 = r0.mo7514b()
            if (r7 != 0) goto L_0x00c8
            return r14
        L_0x00c2:
            r14.mo7473b(r4)
            r14.mo7475c(r4)
        L_0x00c8:
            char r7 = r0.mo7515c()
            if (r7 != r2) goto L_0x00d2
            r0.mo7516d()
            goto L_0x00d4
        L_0x00d2:
            if (r1 == 0) goto L_0x021b
        L_0x00d4:
            java.lang.String r1 = "Invalid hour in date string"
            r2 = 23
            int r1 = r0.mo7513a(r1, r2)
            char r7 = r0.mo7515c()
            if (r7 != r3) goto L_0x0213
            r14.mo7477d(r1)
            r0.mo7516d()
            java.lang.String r1 = "Invalid minute in date string"
            r7 = 59
            int r1 = r0.mo7513a(r1, r7)
            boolean r8 = r0.mo7514b()
            r9 = 43
            r10 = 90
            if (r8 == 0) goto L_0x011b
            char r8 = r0.mo7515c()
            if (r8 == r3) goto L_0x011b
            char r8 = r0.mo7515c()
            if (r8 == r10) goto L_0x011b
            char r8 = r0.mo7515c()
            if (r8 == r9) goto L_0x011b
            char r8 = r0.mo7515c()
            if (r8 != r5) goto L_0x0113
            goto L_0x011b
        L_0x0113:
            com.a.a.c r13 = new com.a.a.c
            java.lang.String r14 = "Invalid date string, after minute"
            r13.<init>(r14, r6)
            throw r13
        L_0x011b:
            r14.mo7479e(r1)
            char r1 = r0.mo7515c()
            if (r1 != r3) goto L_0x01a2
            r0.mo7516d()
            java.lang.String r1 = "Invalid whole seconds in date string"
            int r1 = r0.mo7513a(r1, r7)
            boolean r8 = r0.mo7514b()
            r11 = 46
            if (r8 == 0) goto L_0x0156
            char r8 = r0.mo7515c()
            if (r8 == r11) goto L_0x0156
            char r8 = r0.mo7515c()
            if (r8 == r10) goto L_0x0156
            char r8 = r0.mo7515c()
            if (r8 == r9) goto L_0x0156
            char r8 = r0.mo7515c()
            if (r8 != r5) goto L_0x014e
            goto L_0x0156
        L_0x014e:
            com.a.a.c r13 = new com.a.a.c
            java.lang.String r14 = "Invalid date string, after whole seconds"
            r13.<init>(r14, r6)
            throw r13
        L_0x0156:
            r14.mo7481f(r1)
            char r1 = r0.mo7515c()
            if (r1 != r11) goto L_0x01a2
            r0.mo7516d()
            int r1 = r0.mo7517e()
            java.lang.String r8 = "Invalid fractional seconds in date string"
            r11 = 999999999(0x3b9ac9ff, float:0.004723787)
            int r8 = r0.mo7513a(r8, r11)
            char r11 = r0.mo7515c()
            if (r11 == r10) goto L_0x018a
            char r11 = r0.mo7515c()
            if (r11 == r9) goto L_0x018a
            char r11 = r0.mo7515c()
            if (r11 != r5) goto L_0x0182
            goto L_0x018a
        L_0x0182:
            com.a.a.c r13 = new com.a.a.c
            java.lang.String r14 = "Invalid date string, after fractional second"
            r13.<init>(r14, r6)
            throw r13
        L_0x018a:
            int r11 = r0.mo7517e()
            int r11 = r11 - r1
        L_0x018f:
            r1 = 9
            if (r11 <= r1) goto L_0x0198
            int r8 = r8 / 10
            int r11 = r11 + -1
            goto L_0x018f
        L_0x0198:
            if (r11 >= r1) goto L_0x019f
            int r8 = r8 * 10
            int r11 = r11 + 1
            goto L_0x0198
        L_0x019f:
            r14.mo7483g(r8)
        L_0x01a2:
            char r1 = r0.mo7515c()
            if (r1 != r10) goto L_0x01ac
            r0.mo7516d()
            goto L_0x01ed
        L_0x01ac:
            boolean r1 = r0.mo7514b()
            if (r1 == 0) goto L_0x01ed
            char r13 = r0.mo7515c()
            if (r13 != r9) goto L_0x01ba
            r13 = 1
            goto L_0x01c1
        L_0x01ba:
            char r13 = r0.mo7515c()
            if (r13 != r5) goto L_0x01e5
            r13 = -1
        L_0x01c1:
            r0.mo7516d()
            java.lang.String r1 = "Invalid time zone hour in date string"
            int r1 = r0.mo7513a(r1, r2)
            char r2 = r0.mo7515c()
            if (r2 != r3) goto L_0x01dd
            r0.mo7516d()
            java.lang.String r2 = "Invalid time zone minute in date string"
            int r2 = r0.mo7513a(r2, r7)
            r12 = r1
            r1 = r13
            r13 = r12
            goto L_0x01ef
        L_0x01dd:
            com.a.a.c r13 = new com.a.a.c
            java.lang.String r14 = "Invalid date string, after time zone hour"
            r13.<init>(r14, r6)
            throw r13
        L_0x01e5:
            com.a.a.c r13 = new com.a.a.c
            java.lang.String r14 = "Time zone must begin with 'Z', '+', or '-'"
            r13.<init>(r14, r6)
            throw r13
        L_0x01ed:
            r1 = 0
            r2 = 0
        L_0x01ef:
            int r13 = r13 * 3600
            int r13 = r13 * 1000
            int r2 = r2 * 60
            int r2 = r2 * 1000
            int r13 = r13 + r2
            int r13 = r13 * r1
            java.util.SimpleTimeZone r1 = new java.util.SimpleTimeZone
            java.lang.String r2 = ""
            r1.<init>(r13, r2)
            r14.mo7471a((java.util.TimeZone) r1)
            boolean r13 = r0.mo7514b()
            if (r13 != 0) goto L_0x020b
            return r14
        L_0x020b:
            com.a.a.c r13 = new com.a.a.c
            java.lang.String r14 = "Invalid date string, extra chars at end"
            r13.<init>(r14, r6)
            throw r13
        L_0x0213:
            com.a.a.c r13 = new com.a.a.c
            java.lang.String r14 = "Invalid date string, after hour"
            r13.<init>(r14, r6)
            throw r13
        L_0x021b:
            com.a.a.c r13 = new com.a.a.c
            java.lang.String r14 = "Invalid date string, missing 'T' after date"
            r13.<init>(r14, r6)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p006a.p007a.p008a.ISO8601Converter.m60a(java.lang.String, com.a.a.a):com.a.a.a");
    }

    /* renamed from: a */
    public static String m61a(XMPDateTime aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        DecimalFormat decimalFormat = new DecimalFormat("0000", new DecimalFormatSymbols(Locale.ENGLISH));
        stringBuffer.append(decimalFormat.format((long) aVar.mo7469a()));
        if (aVar.mo7472b() == 0) {
            return stringBuffer.toString();
        }
        decimalFormat.applyPattern("'-'00");
        stringBuffer.append(decimalFormat.format((long) aVar.mo7472b()));
        if (aVar.mo7474c() == 0) {
            return stringBuffer.toString();
        }
        stringBuffer.append(decimalFormat.format((long) aVar.mo7474c()));
        if (!(aVar.mo7476d() == 0 && aVar.mo7478e() == 0 && aVar.mo7480f() == 0 && aVar.mo7482g() == 0 && (aVar.mo7484h() == null || aVar.mo7484h().getRawOffset() == 0))) {
            stringBuffer.append('T');
            decimalFormat.applyPattern("00");
            stringBuffer.append(decimalFormat.format((long) aVar.mo7476d()));
            stringBuffer.append(':');
            stringBuffer.append(decimalFormat.format((long) aVar.mo7478e()));
            if (!(aVar.mo7480f() == 0 && aVar.mo7482g() == 0)) {
                decimalFormat.applyPattern(":00.#########");
                stringBuffer.append(decimalFormat.format(((double) aVar.mo7480f()) + (((double) aVar.mo7482g()) / 1.0E9d)));
            }
            if (aVar.mo7484h() != null) {
                int offset = aVar.mo7484h().getOffset(aVar.mo7485i().getTimeInMillis());
                if (offset == 0) {
                    stringBuffer.append('Z');
                } else {
                    int i = offset / 3600000;
                    int abs = Math.abs((offset % 3600000) / 60000);
                    decimalFormat.applyPattern("+00;-00");
                    stringBuffer.append(decimalFormat.format((long) i));
                    decimalFormat.applyPattern(":00");
                    stringBuffer.append(decimalFormat.format((long) abs));
                }
            }
        }
        return stringBuffer.toString();
    }
}
