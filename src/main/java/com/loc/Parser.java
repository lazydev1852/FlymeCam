package com.loc;

import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.model.AMapLocationServer;

/* renamed from: com.loc.cc */
public final class Parser {

    /* renamed from: a */
    private StringBuilder f2867a = new StringBuilder();

    /* renamed from: b */
    private AMapLocationClientOption f2868b = new AMapLocationClientOption();

    /* renamed from: a */
    private void m3322a(AMapLocationServer aMapLocationServer, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str2) && (this.f2868b.mo8571t() != AMapLocationClientOption.GeoLanguage.EN ? !str.contains("市") || !str.equals(str2) : !str2.equals(str))) {
            sb2.append(str2);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb2.append(str3);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str4)) {
            sb2.append(str4);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str5)) {
            sb2.append(str5);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str6)) {
            if (TextUtils.isEmpty(str7) || this.f2868b.mo8571t() == AMapLocationClientOption.GeoLanguage.EN) {
                sb2.append("Near " + str6);
                sb = new StringBuilder("Near ");
                sb.append(str6);
            } else {
                sb2.append("靠近");
                sb2.append(str6);
                sb2.append(" ");
                sb = new StringBuilder("在");
                sb.append(str6);
                sb.append("附近");
            }
            aMapLocationServer.mo8529q(sb.toString());
        }
        Bundle bundle = new Bundle();
        bundle.putString("citycode", aMapLocationServer.mo8516k());
        bundle.putString("desc", sb2.toString());
        bundle.putString("adcode", aMapLocationServer.mo8518l());
        aMapLocationServer.setExtras(bundle);
        aMapLocationServer.mo8815y(sb2.toString());
        String l = aMapLocationServer.mo8518l();
        aMapLocationServer.mo8495e((l == null || l.trim().length() <= 0 || this.f2868b.mo8571t() == AMapLocationClientOption.GeoLanguage.EN) ? sb2.toString() : sb2.toString().replace(" ", ""));
    }

    /* renamed from: b */
    private static String m3323b(String str) {
        return "[]".equals(str) ? "" : str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:151:0x026b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x02c2, code lost:
        r14.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ca, code lost:
        r1 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e2, code lost:
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fa, code lost:
        r2 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0115, code lost:
        r2 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x012e, code lost:
        r2 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0147, code lost:
        r2 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0175, code lost:
        r2 = "";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:113:0x01d4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:117:0x01e9 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:131:0x0221 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00b4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x015f */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01b0 A[Catch:{ Throwable -> 0x026d, all -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01bf A[Catch:{ Throwable -> 0x026d, all -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01ef A[Catch:{ Throwable -> 0x026d, all -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01fe A[Catch:{ Throwable -> 0x026d, all -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x020b A[Catch:{ Throwable -> 0x026d, all -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0227 A[Catch:{ Throwable -> 0x026d, all -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x023f A[Catch:{ Throwable -> 0x026d, all -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x026b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:23:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x02c2  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer mo13162a(com.autonavi.aps.amapapi.model.AMapLocationServer r21, byte[] r22) {
        /*
            r20 = this;
            r10 = r20
            r0 = r21
            r11 = 5
            r13 = 0
            if (r22 != 0) goto L_0x002f
            r0.mo8485c((int) r11)     // Catch:{ Throwable -> 0x002b, all -> 0x0027 }
            java.lang.StringBuilder r1 = r10.f2867a     // Catch:{ Throwable -> 0x002b, all -> 0x0027 }
            java.lang.String r2 = "binaryResult is null#0504"
            r1.append(r2)     // Catch:{ Throwable -> 0x002b, all -> 0x0027 }
            java.lang.StringBuilder r1 = r10.f2867a     // Catch:{ Throwable -> 0x002b, all -> 0x0027 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x002b, all -> 0x0027 }
            r0.mo8478a((java.lang.String) r1)     // Catch:{ Throwable -> 0x002b, all -> 0x0027 }
            java.lang.StringBuilder r1 = r10.f2867a     // Catch:{ Throwable -> 0x002b, all -> 0x0027 }
            java.lang.StringBuilder r2 = r10.f2867a     // Catch:{ Throwable -> 0x002b, all -> 0x0027 }
            int r2 = r2.length()     // Catch:{ Throwable -> 0x002b, all -> 0x0027 }
            r1.delete(r13, r2)     // Catch:{ Throwable -> 0x002b, all -> 0x0027 }
            return r0
        L_0x0027:
            r0 = move-exception
            r14 = 0
            goto L_0x02c0
        L_0x002b:
            r0 = move-exception
            r12 = 0
            goto L_0x026f
        L_0x002f:
            java.nio.ByteBuffer r14 = java.nio.ByteBuffer.wrap(r22)     // Catch:{ Throwable -> 0x002b, all -> 0x0027 }
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            if (r1 != 0) goto L_0x004d
            short r1 = r14.getShort()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r0.mo8810t(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.clear()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            if (r14 == 0) goto L_0x004c
            r14.clear()
        L_0x004c:
            return r0
        L_0x004d:
            int r1 = r14.getInt()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            double r1 = (double) r1     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r1 = r1 / r3
            double r1 = com.loc.C1079cp.m3495a((double) r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r0.setLongitude(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            int r1 = r14.getInt()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            double r1 = (double) r1     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            double r1 = r1 / r3
            double r1 = com.loc.C1079cp.m3495a((double) r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r0.setLatitude(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            short r1 = r14.getShort()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            float r1 = (float) r1     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r0.setAccuracy(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r0.mo8811u(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r0.mo8812v(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r15 = 1
            if (r1 != r15) goto L_0x019f
            java.lang.String r1 = ""
            java.lang.String r2 = ""
            java.lang.String r3 = ""
            java.lang.String r4 = ""
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            byte r8 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte[] r8 = new byte[r8]     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get(r8)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r9 = new java.lang.String     // Catch:{ Throwable -> 0x00b4, all -> 0x026b }
            java.lang.String r12 = "UTF-8"
            r9.<init>(r8, r12)     // Catch:{ Throwable -> 0x00b4, all -> 0x026b }
            r0.mo8486c((java.lang.String) r9)     // Catch:{ Throwable -> 0x00b4, all -> 0x026b }
        L_0x00b4:
            byte r8 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte[] r8 = new byte[r8]     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get(r8)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r9 = new java.lang.String     // Catch:{ Throwable -> 0x00cb, all -> 0x026b }
            java.lang.String r12 = "UTF-8"
            r9.<init>(r8, r12)     // Catch:{ Throwable -> 0x00cb, all -> 0x026b }
            r0.mo8498f((java.lang.String) r9)     // Catch:{ Throwable -> 0x00ca, all -> 0x026b }
            goto L_0x00cc
        L_0x00ca:
            r1 = r9
        L_0x00cb:
            r9 = r1
        L_0x00cc:
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r8 = new java.lang.String     // Catch:{ Throwable -> 0x00e3, all -> 0x026b }
            java.lang.String r12 = "UTF-8"
            r8.<init>(r1, r12)     // Catch:{ Throwable -> 0x00e3, all -> 0x026b }
            r0.mo8501g((java.lang.String) r8)     // Catch:{ Throwable -> 0x00e2, all -> 0x026b }
            goto L_0x00e4
        L_0x00e2:
            r2 = r8
        L_0x00e3:
            r8 = r2
        L_0x00e4:
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x00fa, all -> 0x026b }
            java.lang.String r12 = "UTF-8"
            r2.<init>(r1, r12)     // Catch:{ Throwable -> 0x00fa, all -> 0x026b }
            r0.mo8511h((java.lang.String) r2)     // Catch:{ Throwable -> 0x00fb, all -> 0x026b }
            goto L_0x00fb
        L_0x00fa:
            r2 = r3
        L_0x00fb:
            r12 = r2
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x0115, all -> 0x026b }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch:{ Throwable -> 0x0115, all -> 0x026b }
            r0.mo8519l(r2)     // Catch:{ Throwable -> 0x0116, all -> 0x026b }
            r0.mo8491d((java.lang.String) r2)     // Catch:{ Throwable -> 0x0116, all -> 0x026b }
            goto L_0x0116
        L_0x0115:
            r2 = r4
        L_0x0116:
            r16 = r2
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x012e, all -> 0x026b }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch:{ Throwable -> 0x012e, all -> 0x026b }
            r0.mo8521m(r2)     // Catch:{ Throwable -> 0x012f, all -> 0x026b }
            goto L_0x012f
        L_0x012e:
            r2 = r5
        L_0x012f:
            r17 = r2
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x0147, all -> 0x026b }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch:{ Throwable -> 0x0147, all -> 0x026b }
            r0.mo8517k(r2)     // Catch:{ Throwable -> 0x0148, all -> 0x026b }
            goto L_0x0148
        L_0x0147:
            r2 = r6
        L_0x0148:
            r18 = r2
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x015f, all -> 0x026b }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch:{ Throwable -> 0x015f, all -> 0x026b }
            r0.mo8523n(r2)     // Catch:{ Throwable -> 0x015f, all -> 0x026b }
        L_0x015f:
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x0175, all -> 0x026b }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch:{ Throwable -> 0x0175, all -> 0x026b }
            r0.mo8515j(r2)     // Catch:{ Throwable -> 0x0176, all -> 0x026b }
            goto L_0x0176
        L_0x0175:
            r2 = r7
        L_0x0176:
            r19 = r2
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x018d, all -> 0x026b }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch:{ Throwable -> 0x018d, all -> 0x026b }
            r0.mo8513i(r2)     // Catch:{ Throwable -> 0x018d, all -> 0x026b }
        L_0x018d:
            r1 = r20
            r2 = r21
            r3 = r9
            r4 = r8
            r5 = r12
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r1.m3322a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
        L_0x019f:
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            if (r1 != r15) goto L_0x01b9
            r14.getInt()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.getInt()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.getShort()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
        L_0x01b9:
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            if (r1 != r15) goto L_0x01e9
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x01d4, all -> 0x026b }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch:{ Throwable -> 0x01d4, all -> 0x026b }
            r0.mo8525o(r2)     // Catch:{ Throwable -> 0x01d4, all -> 0x026b }
        L_0x01d4:
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x01e9, all -> 0x026b }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch:{ Throwable -> 0x01e9, all -> 0x026b }
            r0.mo8526p(r2)     // Catch:{ Throwable -> 0x01e9, all -> 0x026b }
        L_0x01e9:
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            if (r1 != r15) goto L_0x01f8
            r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.getInt()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
        L_0x01f8:
            byte r1 = r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            if (r1 != r15) goto L_0x0205
            long r1 = r14.getLong()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r0.setTime(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
        L_0x0205:
            short r1 = r14.getShort()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            if (r1 <= 0) goto L_0x0221
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            int r2 = r1.length     // Catch:{ Throwable -> 0x0221, all -> 0x026b }
            if (r2 <= 0) goto L_0x0221
            byte[] r1 = android.util.Base64.decode(r1, r13)     // Catch:{ Throwable -> 0x0221, all -> 0x026b }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x0221, all -> 0x026b }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch:{ Throwable -> 0x0221, all -> 0x026b }
            r0.mo8809s(r2)     // Catch:{ Throwable -> 0x0221, all -> 0x026b }
        L_0x0221:
            short r1 = r14.getShort()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            if (r1 <= 0) goto L_0x022c
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r14.get(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
        L_0x022c:
            java.lang.String r1 = "5.1"
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            double r1 = r1.doubleValue()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            r3 = 4617428107952285286(0x4014666666666666, double:5.1)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x0265
            short r1 = r14.getShort()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            java.lang.String r2 = "-1"
            java.lang.String r3 = r21.mo8796C()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            boolean r2 = r2.equals(r3)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            if (r2 != 0) goto L_0x025b
            r2 = -1
            if (r1 != r2) goto L_0x0254
            r1 = 0
            goto L_0x0257
        L_0x0254:
            if (r1 != 0) goto L_0x0257
            r1 = -1
        L_0x0257:
            r0.mo8510h((int) r1)     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
            goto L_0x0262
        L_0x025b:
            r2 = 101(0x65, float:1.42E-43)
            if (r1 != r2) goto L_0x0257
            r1 = 100
            goto L_0x0257
        L_0x0262:
            r14.get()     // Catch:{ Throwable -> 0x026d, all -> 0x026b }
        L_0x0265:
            if (r14 == 0) goto L_0x02aa
            r14.clear()
            goto L_0x02aa
        L_0x026b:
            r0 = move-exception
            goto L_0x02c0
        L_0x026d:
            r0 = move-exception
            r12 = r14
        L_0x026f:
            com.autonavi.aps.amapapi.model.AMapLocationServer r1 = new com.autonavi.aps.amapapi.model.AMapLocationServer     // Catch:{ all -> 0x02be }
            java.lang.String r2 = ""
            r1.<init>(r2)     // Catch:{ all -> 0x02be }
            r1.mo8485c((int) r11)     // Catch:{ all -> 0x02be }
            java.lang.StringBuilder r2 = r10.f2867a     // Catch:{ all -> 0x02be }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02be }
            java.lang.String r4 = "parser data error:"
            r3.<init>(r4)     // Catch:{ all -> 0x02be }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x02be }
            r3.append(r0)     // Catch:{ all -> 0x02be }
            java.lang.String r0 = "#0505"
            r3.append(r0)     // Catch:{ all -> 0x02be }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x02be }
            r2.append(r0)     // Catch:{ all -> 0x02be }
            r0 = 2054(0x806, float:2.878E-42)
            r2 = 0
            com.loc.ReportUtil.m3435a((java.lang.String) r2, (int) r0)     // Catch:{ all -> 0x02be }
            java.lang.StringBuilder r0 = r10.f2867a     // Catch:{ all -> 0x02be }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02be }
            r1.mo8478a((java.lang.String) r0)     // Catch:{ all -> 0x02be }
            if (r12 == 0) goto L_0x02a9
            r12.clear()
        L_0x02a9:
            r0 = r1
        L_0x02aa:
            java.lang.StringBuilder r1 = r10.f2867a
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x02bd
            java.lang.StringBuilder r1 = r10.f2867a
            java.lang.StringBuilder r2 = r10.f2867a
            int r2 = r2.length()
            r1.delete(r13, r2)
        L_0x02bd:
            return r0
        L_0x02be:
            r0 = move-exception
            r14 = r12
        L_0x02c0:
            if (r14 == 0) goto L_0x02c5
            r14.clear()
        L_0x02c5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.Parser.mo13162a(com.autonavi.aps.amapapi.model.AMapLocationServer, byte[]):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0083 A[Catch:{ Throwable -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0088 A[Catch:{ Throwable -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d3 A[Catch:{ Throwable -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e6 A[Catch:{ Throwable -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00f3 A[Catch:{ Throwable -> 0x010b }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer mo13163a(java.lang.String r13) {
        /*
            r12 = this;
            r0 = 0
            com.autonavi.aps.amapapi.model.AMapLocationServer r10 = new com.autonavi.aps.amapapi.model.AMapLocationServer     // Catch:{ Throwable -> 0x010b }
            java.lang.String r1 = ""
            r10.<init>(r1)     // Catch:{ Throwable -> 0x010b }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Throwable -> 0x010b }
            r1.<init>(r13)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r13 = "regeocode"
            org.json.JSONObject r13 = r1.optJSONObject(r13)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r1 = "addressComponent"
            org.json.JSONObject r1 = r13.optJSONObject(r1)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r2 = "country"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r2 = m3323b(r2)     // Catch:{ Throwable -> 0x010b }
            r10.mo8486c((java.lang.String) r2)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r2 = "province"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r3 = m3323b(r2)     // Catch:{ Throwable -> 0x010b }
            r10.mo8498f((java.lang.String) r3)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r2 = "citycode"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r2 = m3323b(r2)     // Catch:{ Throwable -> 0x010b }
            r10.mo8513i(r2)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r4 = "city"
            java.lang.String r4 = r1.optString(r4)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r5 = "010"
            boolean r5 = r2.endsWith(r5)     // Catch:{ Throwable -> 0x010b }
            if (r5 != 0) goto L_0x006f
            java.lang.String r5 = "021"
            boolean r5 = r2.endsWith(r5)     // Catch:{ Throwable -> 0x010b }
            if (r5 != 0) goto L_0x006f
            java.lang.String r5 = "022"
            boolean r5 = r2.endsWith(r5)     // Catch:{ Throwable -> 0x010b }
            if (r5 != 0) goto L_0x006f
            java.lang.String r5 = "023"
            boolean r2 = r2.endsWith(r5)     // Catch:{ Throwable -> 0x010b }
            if (r2 == 0) goto L_0x0067
            goto L_0x006f
        L_0x0067:
            java.lang.String r2 = m3323b(r4)     // Catch:{ Throwable -> 0x010b }
            r10.mo8501g((java.lang.String) r2)     // Catch:{ Throwable -> 0x010b }
            goto L_0x007d
        L_0x006f:
            if (r3 == 0) goto L_0x007c
            int r2 = r3.length()     // Catch:{ Throwable -> 0x010b }
            if (r2 <= 0) goto L_0x007c
            r10.mo8501g((java.lang.String) r3)     // Catch:{ Throwable -> 0x010b }
            r2 = r3
            goto L_0x007d
        L_0x007c:
            r2 = r4
        L_0x007d:
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x010b }
            if (r4 == 0) goto L_0x0088
            r10.mo8501g((java.lang.String) r3)     // Catch:{ Throwable -> 0x010b }
            r4 = r3
            goto L_0x0089
        L_0x0088:
            r4 = r2
        L_0x0089:
            java.lang.String r2 = "district"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r5 = m3323b(r2)     // Catch:{ Throwable -> 0x010b }
            r10.mo8511h((java.lang.String) r5)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r2 = "adcode"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r9 = m3323b(r2)     // Catch:{ Throwable -> 0x010b }
            r10.mo8515j(r9)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r2 = "streetNumber"
            org.json.JSONObject r1 = r1.optJSONObject(r2)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r2 = "street"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r6 = m3323b(r2)     // Catch:{ Throwable -> 0x010b }
            r10.mo8519l(r6)     // Catch:{ Throwable -> 0x010b }
            r10.mo8491d((java.lang.String) r6)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r2 = "number"
            java.lang.String r1 = r1.optString(r2)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r7 = m3323b(r1)     // Catch:{ Throwable -> 0x010b }
            r10.mo8521m(r7)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r1 = "pois"
            org.json.JSONArray r1 = r13.optJSONArray(r1)     // Catch:{ Throwable -> 0x010b }
            int r2 = r1.length()     // Catch:{ Throwable -> 0x010b }
            r8 = 0
            if (r2 <= 0) goto L_0x00e6
            org.json.JSONObject r1 = r1.getJSONObject(r8)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r2 = "name"
            java.lang.String r1 = r1.optString(r2)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r1 = m3323b(r1)     // Catch:{ Throwable -> 0x010b }
            r10.mo8517k(r1)     // Catch:{ Throwable -> 0x010b }
            r11 = r1
            goto L_0x00e7
        L_0x00e6:
            r11 = r0
        L_0x00e7:
            java.lang.String r1 = "aois"
            org.json.JSONArray r13 = r13.optJSONArray(r1)     // Catch:{ Throwable -> 0x010b }
            int r1 = r13.length()     // Catch:{ Throwable -> 0x010b }
            if (r1 <= 0) goto L_0x0104
            org.json.JSONObject r13 = r13.getJSONObject(r8)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r1 = "name"
            java.lang.String r13 = r13.optString(r1)     // Catch:{ Throwable -> 0x010b }
            java.lang.String r13 = m3323b(r13)     // Catch:{ Throwable -> 0x010b }
            r10.mo8523n(r13)     // Catch:{ Throwable -> 0x010b }
        L_0x0104:
            r1 = r12
            r2 = r10
            r8 = r11
            r1.m3322a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x010b }
            return r10
        L_0x010b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.Parser.mo13163a(java.lang.String):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|(1:4)|5|(1:7)|8|9|(1:13)|14|(1:16)|19|(1:21)|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00ad, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ae, code lost:
        r7 = r5.f2867a;
        r7.append("json exception error:");
        r7.append(r6.getMessage());
        r7.append(r1);
        r7.append("#0703");
        com.loc.CoreUtil.m3389a(r6, "parser", "paseAuthFailurJson");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0054 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0095 A[Catch:{ Throwable -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00dc  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer mo13164a(java.lang.String r6, android.content.Context r7, com.loc.ResponseEntity r8) {
        /*
            r5 = this;
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = new com.autonavi.aps.amapapi.model.AMapLocationServer
            java.lang.String r1 = ""
            r0.<init>(r1)
            r1 = 7
            r0.mo8485c((int) r1)
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r2 = 0
            java.lang.String r3 = "#SHA1AndPackage#"
            r1.append(r3)     // Catch:{ Throwable -> 0x0054 }
            java.lang.String r7 = com.loc.AppInfo.m3665e(r7)     // Catch:{ Throwable -> 0x0054 }
            r1.append(r7)     // Catch:{ Throwable -> 0x0054 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7 = r8.f2588b     // Catch:{ Throwable -> 0x0054 }
            java.lang.String r3 = "gsid"
            java.lang.Object r7 = r7.get(r3)     // Catch:{ Throwable -> 0x0054 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ Throwable -> 0x0054 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Throwable -> 0x0054 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Throwable -> 0x0054 }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Throwable -> 0x0054 }
            if (r3 != 0) goto L_0x003b
            java.lang.String r3 = "#gsid#"
            r1.append(r3)     // Catch:{ Throwable -> 0x0054 }
            r1.append(r7)     // Catch:{ Throwable -> 0x0054 }
        L_0x003b:
            java.lang.String r7 = r8.f2589c     // Catch:{ Throwable -> 0x0054 }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Throwable -> 0x0054 }
            if (r3 != 0) goto L_0x0054
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0054 }
            java.lang.String r4 = "#csid#"
            r3.<init>(r4)     // Catch:{ Throwable -> 0x0054 }
            r3.append(r7)     // Catch:{ Throwable -> 0x0054 }
            java.lang.String r7 = r3.toString()     // Catch:{ Throwable -> 0x0054 }
            r1.append(r7)     // Catch:{ Throwable -> 0x0054 }
        L_0x0054:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Throwable -> 0x00ad }
            r7.<init>(r6)     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r3 = "status"
            boolean r3 = r7.has(r3)     // Catch:{ Throwable -> 0x00ad }
            if (r3 == 0) goto L_0x0069
            java.lang.String r3 = "info"
            boolean r3 = r7.has(r3)     // Catch:{ Throwable -> 0x00ad }
            if (r3 != 0) goto L_0x007b
        L_0x0069:
            java.lang.StringBuilder r3 = r5.f2867a     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r4 = "json is error:"
            r3.append(r4)     // Catch:{ Throwable -> 0x00ad }
            r3.append(r6)     // Catch:{ Throwable -> 0x00ad }
            r3.append(r1)     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r6 = "#0702"
            r3.append(r6)     // Catch:{ Throwable -> 0x00ad }
        L_0x007b:
            java.lang.String r6 = "status"
            java.lang.String r6 = r7.getString(r6)     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r3 = "info"
            java.lang.String r3 = r7.getString(r3)     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r4 = "infocode"
            java.lang.String r7 = r7.getString(r4)     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r4 = "0"
            boolean r6 = r4.equals(r6)     // Catch:{ Throwable -> 0x00ad }
            if (r6 == 0) goto L_0x00cb
            java.lang.StringBuilder r6 = r5.f2867a     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r4 = "auth fail:"
            r6.append(r4)     // Catch:{ Throwable -> 0x00ad }
            r6.append(r3)     // Catch:{ Throwable -> 0x00ad }
            r6.append(r1)     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r4 = "#0701"
            r6.append(r4)     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r6 = r8.f2590d     // Catch:{ Throwable -> 0x00ad }
            com.loc.ReportUtil.m3437a((java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r3)     // Catch:{ Throwable -> 0x00ad }
            goto L_0x00cb
        L_0x00ad:
            r6 = move-exception
            java.lang.StringBuilder r7 = r5.f2867a
            java.lang.String r8 = "json exception error:"
            r7.append(r8)
            java.lang.String r8 = r6.getMessage()
            r7.append(r8)
            r7.append(r1)
            java.lang.String r8 = "#0703"
            r7.append(r8)
            java.lang.String r7 = "parser"
            java.lang.String r8 = "paseAuthFailurJson"
            com.loc.CoreUtil.m3389a(r6, r7, r8)
        L_0x00cb:
            java.lang.StringBuilder r6 = r5.f2867a
            java.lang.String r6 = r6.toString()
            r0.mo8478a((java.lang.String) r6)
            java.lang.StringBuilder r6 = r5.f2867a
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x00e7
            java.lang.StringBuilder r6 = r5.f2867a
            java.lang.StringBuilder r7 = r5.f2867a
            int r7 = r7.length()
            r6.delete(r2, r7)
        L_0x00e7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.Parser.mo13164a(java.lang.String, android.content.Context, com.loc.an):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* renamed from: a */
    public final void mo13165a(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            this.f2868b = new AMapLocationClientOption();
        } else {
            this.f2868b = aMapLocationClientOption;
        }
    }
}
