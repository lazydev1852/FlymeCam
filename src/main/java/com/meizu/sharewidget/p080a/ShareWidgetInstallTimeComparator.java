package com.meizu.sharewidget.p080a;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.text.Collator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.sharewidget.a.f */
public class ShareWidgetInstallTimeComparator implements Comparator<ResolveInfo> {

    /* renamed from: a */
    private final Collator f15881a;

    /* renamed from: b */
    private PackageManager f15882b;

    /* renamed from: c */
    private final String f15883c = "com.android.email";

    /* renamed from: d */
    private final String f15884d = "com.android.mms";

    /* renamed from: e */
    private final String f15885e = "com.android.bluetooth";

    /* renamed from: f */
    private final String f15886f = "com.meizu.share";

    /* renamed from: g */
    private final String f15887g = "com.meizu.notepaper";

    /* renamed from: h */
    private final String f15888h = "com.meizu.media.gallery";

    /* renamed from: i */
    private final String f15889i = "com.meizu.media.music";

    /* renamed from: j */
    private final String f15890j = "com.meizu.media.video";

    /* renamed from: k */
    private final String f15891k = "com.android.browser";

    /* renamed from: l */
    private final String f15892l = "com.meizu.filemanager";

    /* renamed from: m */
    private final String f15893m = "com.tencent.mm";

    /* renamed from: n */
    private final String f15894n = "com.sina.weibo";

    /* renamed from: o */
    private final String f15895o = "com.tencent.mobileqq";

    /* renamed from: p */
    private Map<String, PackageInfo> f15896p = new HashMap();

    public ShareWidgetInstallTimeComparator(PackageManager packageManager) {
        this.f15882b = packageManager;
        this.f15881a = Collator.getInstance();
        this.f15881a.setStrength(0);
    }

    /* renamed from: a */
    public int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
        return m17271b(resolveInfo, resolveInfo2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0052 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0053  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m17271b(android.content.pm.ResolveInfo r10, android.content.pm.ResolveInfo r11) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L_0x0006
            if (r11 != 0) goto L_0x0006
            return r0
        L_0x0006:
            r1 = 1
            if (r10 != 0) goto L_0x000a
            return r1
        L_0x000a:
            r2 = -1
            if (r11 != 0) goto L_0x000e
            return r2
        L_0x000e:
            android.content.pm.ActivityInfo r3 = r10.activityInfo
            if (r3 == 0) goto L_0x0015
            android.content.pm.ActivityInfo r10 = r10.activityInfo
            goto L_0x0017
        L_0x0015:
            android.content.pm.ServiceInfo r10 = r10.serviceInfo
        L_0x0017:
            android.content.pm.ActivityInfo r3 = r11.activityInfo
            if (r3 == 0) goto L_0x001e
            android.content.pm.ActivityInfo r11 = r11.activityInfo
            goto L_0x0020
        L_0x001e:
            android.content.pm.ServiceInfo r11 = r11.serviceInfo
        L_0x0020:
            if (r10 != 0) goto L_0x0025
            if (r11 != 0) goto L_0x0025
            return r0
        L_0x0025:
            if (r10 != 0) goto L_0x0028
            return r1
        L_0x0028:
            if (r11 != 0) goto L_0x002b
            return r2
        L_0x002b:
            r3 = 0
            java.lang.String r10 = r10.packageName     // Catch:{ NameNotFoundException -> 0x004a }
            android.content.pm.PackageInfo r10 = r9.m17270a((java.lang.String) r10)     // Catch:{ NameNotFoundException -> 0x004a }
            java.lang.String r11 = r11.packageName     // Catch:{ NameNotFoundException -> 0x004a }
            android.content.pm.PackageInfo r11 = r9.m17270a((java.lang.String) r11)     // Catch:{ NameNotFoundException -> 0x004a }
            long r5 = r10.firstInstallTime     // Catch:{ NameNotFoundException -> 0x004a }
            long r7 = r10.lastUpdateTime     // Catch:{ NameNotFoundException -> 0x004a }
            long r5 = java.lang.Math.max(r5, r7)     // Catch:{ NameNotFoundException -> 0x004a }
            long r7 = r11.firstInstallTime     // Catch:{ NameNotFoundException -> 0x004b }
            long r10 = r11.lastUpdateTime     // Catch:{ NameNotFoundException -> 0x004b }
            long r10 = java.lang.Math.max(r7, r10)     // Catch:{ NameNotFoundException -> 0x004b }
            goto L_0x004c
        L_0x004a:
            r5 = r3
        L_0x004b:
            r10 = r3
        L_0x004c:
            r7 = 0
            long r10 = r10 - r5
            int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r10 <= 0) goto L_0x0053
            return r1
        L_0x0053:
            if (r10 >= 0) goto L_0x0056
            return r2
        L_0x0056:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.sharewidget.p080a.ShareWidgetInstallTimeComparator.m17271b(android.content.pm.ResolveInfo, android.content.pm.ResolveInfo):int");
    }

    /* renamed from: a */
    private PackageInfo m17270a(String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = this.f15896p.get(str);
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo packageInfo2 = this.f15882b.getPackageInfo(str, 0);
        this.f15896p.put(str, packageInfo2);
        return packageInfo2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0082  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<android.content.pm.ResolveInfo> mo24069a(java.util.List<android.content.pm.ResolveInfo> r24) {
        /*
            r23 = this;
            r0 = r24
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.util.Iterator r2 = r24.iterator()
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
        L_0x0019:
            boolean r17 = r2.hasNext()
            if (r17 == 0) goto L_0x0170
            java.lang.Object r17 = r2.next()
            r18 = r2
            r2 = r17
            android.content.pm.ResolveInfo r2 = (android.content.pm.ResolveInfo) r2
            r19 = r15
            android.content.pm.ActivityInfo r15 = r2.activityInfo
            if (r15 == 0) goto L_0x0034
            android.content.pm.ActivityInfo r15 = r2.activityInfo
        L_0x0031:
            r20 = r2
            goto L_0x0037
        L_0x0034:
            android.content.pm.ServiceInfo r15 = r2.serviceInfo
            goto L_0x0031
        L_0x0037:
            java.lang.String r2 = r15.packageName
            r21 = r14
            java.lang.String r14 = "com.android.email"
            boolean r14 = r14.equals(r2)
            if (r14 == 0) goto L_0x004b
            r15 = r19
            r11 = r20
        L_0x0047:
            r14 = r21
            goto L_0x016c
        L_0x004b:
            java.lang.String r14 = "com.android.mms"
            boolean r14 = r14.equals(r2)
            if (r14 == 0) goto L_0x0069
            java.lang.String r14 = r15.name
            r22 = r13
            java.lang.String r13 = "com.android.mms.ui.ComposeMessageActivity"
            boolean r13 = r14.equals(r13)
            if (r13 == 0) goto L_0x006b
            r15 = r19
            r6 = r20
        L_0x0063:
            r14 = r21
        L_0x0065:
            r13 = r22
            goto L_0x016c
        L_0x0069:
            r22 = r13
        L_0x006b:
            java.lang.String r13 = "com.android.bluetooth"
            boolean r13 = r13.equals(r2)
            if (r13 == 0) goto L_0x0082
            java.lang.String r13 = r15.name
            java.lang.String r14 = "com.android.bluetooth.opp.BluetoothOppLauncherActivity"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x0082
            r15 = r19
            r8 = r20
            goto L_0x0063
        L_0x0082:
            java.lang.String r13 = "com.meizu.share"
            boolean r13 = r13.equals(r2)
            if (r13 == 0) goto L_0x0099
            java.lang.String r13 = r15.name
            java.lang.String r14 = "com.meizu.share.BluetoothOppLauncherActivity"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x0099
            r15 = r19
            r9 = r20
            goto L_0x0063
        L_0x0099:
            java.lang.String r13 = "com.meizu.notepaper"
            boolean r13 = r13.equals(r2)
            if (r13 == 0) goto L_0x00a6
            r15 = r19
            r7 = r20
            goto L_0x0063
        L_0x00a6:
            java.lang.String r13 = "com.meizu.media.music"
            boolean r13 = r13.equals(r2)
            if (r13 == 0) goto L_0x00b3
            r15 = r19
            r1 = r20
            goto L_0x0063
        L_0x00b3:
            java.lang.String r13 = "com.meizu.media.video"
            boolean r13 = r13.equals(r2)
            if (r13 == 0) goto L_0x00c0
            r15 = r19
            r3 = r20
            goto L_0x0063
        L_0x00c0:
            java.lang.String r13 = "com.meizu.media.gallery"
            boolean r13 = r13.equals(r2)
            if (r13 == 0) goto L_0x00cd
            r15 = r19
            r4 = r20
            goto L_0x0063
        L_0x00cd:
            java.lang.String r13 = "com.android.browser"
            boolean r13 = r13.equals(r2)
            if (r13 == 0) goto L_0x00da
            r15 = r19
            r5 = r20
            goto L_0x0063
        L_0x00da:
            java.lang.String r13 = "com.tencent.mm"
            boolean r13 = r13.equals(r2)
            if (r13 == 0) goto L_0x00f0
            java.lang.String r13 = r15.name
            java.lang.String r14 = "com.tencent.mm.ui.tools.ShareToTimeLineUI"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x00f0
            r15 = r20
            goto L_0x0063
        L_0x00f0:
            java.lang.String r13 = "com.tencent.mm"
            boolean r13 = r13.equals(r2)
            if (r13 == 0) goto L_0x0108
            java.lang.String r13 = r15.name
            java.lang.String r14 = "com.tencent.mm.ui.tools.ShareImgUI"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x0108
            r15 = r19
            r16 = r20
            goto L_0x0063
        L_0x0108:
            java.lang.String r13 = "com.sina.weibo"
            boolean r13 = r13.equals(r2)
            if (r13 == 0) goto L_0x0120
            java.lang.String r13 = r15.name
            java.lang.String r14 = "com.sina.weibo.composerinde.ComposerDispatchActivity"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x0120
            r15 = r19
            r12 = r20
            goto L_0x0063
        L_0x0120:
            java.lang.String r13 = "com.tencent.mobileqq"
            boolean r13 = r13.equals(r2)
            if (r13 == 0) goto L_0x0138
            java.lang.String r13 = r15.name
            java.lang.String r14 = "com.tencent.mobileqq.activity.JumpActivity"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x0138
            r15 = r19
            r14 = r20
            goto L_0x0065
        L_0x0138:
            java.lang.String r13 = "com.tencent.mobileqq"
            boolean r13 = r13.equals(r2)
            if (r13 == 0) goto L_0x0150
            java.lang.String r13 = r15.name
            java.lang.String r14 = "com.tencent.mobileqq.activity.qfileJumpActivity"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x0150
            r15 = r19
            r13 = r20
            goto L_0x0047
        L_0x0150:
            java.lang.String r13 = "com.meizu.filemanager"
            boolean r2 = r13.equals(r2)
            if (r2 == 0) goto L_0x0168
            java.lang.String r2 = r15.name
            java.lang.String r13 = "com.meizu.flyme.filemanager.qrcode.ui.QrFilesCheckActivity"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0168
            r15 = r19
            r10 = r20
            goto L_0x0063
        L_0x0168:
            r15 = r19
            goto L_0x0063
        L_0x016c:
            r2 = r18
            goto L_0x0019
        L_0x0170:
            r22 = r13
            r21 = r14
            r19 = r15
            r2 = 0
            if (r1 == 0) goto L_0x017f
            r0.remove(r1)
            r0.add(r2, r1)
        L_0x017f:
            if (r3 == 0) goto L_0x0187
            r0.remove(r3)
            r0.add(r2, r3)
        L_0x0187:
            if (r4 == 0) goto L_0x018f
            r0.remove(r4)
            r0.add(r2, r4)
        L_0x018f:
            if (r5 == 0) goto L_0x0197
            r0.remove(r5)
            r0.add(r2, r5)
        L_0x0197:
            if (r6 == 0) goto L_0x019f
            r0.remove(r6)
            r0.add(r2, r6)
        L_0x019f:
            if (r7 == 0) goto L_0x01a7
            r0.remove(r7)
            r0.add(r2, r7)
        L_0x01a7:
            if (r8 == 0) goto L_0x01af
            r0.remove(r8)
            r0.add(r2, r8)
        L_0x01af:
            if (r9 == 0) goto L_0x01b7
            r0.remove(r9)
            r0.add(r2, r9)
        L_0x01b7:
            if (r10 == 0) goto L_0x01bf
            r0.remove(r10)
            r0.add(r2, r10)
        L_0x01bf:
            if (r11 == 0) goto L_0x01c7
            r0.remove(r11)
            r0.add(r2, r11)
        L_0x01c7:
            if (r12 == 0) goto L_0x01cf
            r0.remove(r12)
            r0.add(r2, r12)
        L_0x01cf:
            if (r22 == 0) goto L_0x01d9
            r1 = r22
            r0.remove(r1)
            r0.add(r2, r1)
        L_0x01d9:
            if (r21 == 0) goto L_0x01e3
            r14 = r21
            r0.remove(r14)
            r0.add(r2, r14)
        L_0x01e3:
            if (r19 == 0) goto L_0x01ed
            r15 = r19
            r0.remove(r15)
            r0.add(r2, r15)
        L_0x01ed:
            r1 = r16
            if (r1 == 0) goto L_0x01f7
            r0.remove(r1)
            r0.add(r2, r1)
        L_0x01f7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.sharewidget.p080a.ShareWidgetInstallTimeComparator.mo24069a(java.util.List):java.util.List");
    }
}
