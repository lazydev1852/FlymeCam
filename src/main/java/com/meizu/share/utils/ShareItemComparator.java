package com.meizu.share.utils;

import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.meizu.share.p079b.DisplayResolveInfo;
import com.meizu.share.p079b.UsageInfo;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ShareItemComparator implements Comparator<DisplayResolveInfo> {

    /* renamed from: a */
    private Map<String, PackageInfo> f15758a = new HashMap();

    /* renamed from: b */
    private ShareWidgetUsageSharedPreferences f15759b;

    /* renamed from: c */
    private PackageManager f15760c;

    enum AppWeight {
        MUSIC("com.meizu.media.music", (int) null, 0),
        VIDEO("com.meizu.media.video", (int) null, 1),
        GALLERY("com.meizu.media.gallery", (int) null, 2),
        BROWSER("com.android.browser", (int) null, 3),
        MMS("com.android.mms", "com.android.mms.ui.ComposeMessageActivity", 4),
        NOTE_PAPER("com.meizu.notepaper", (int) null, 5),
        BT_OPP("com.android.bluetooth", "com.android.bluetooth.opp.BluetoothOppLauncherActivity", 6),
        BT("com.meizu.share", "com.meizu.share.BluetoothOppLauncherActivity", 7),
        FILE_QR_CODE("com.meizu.filemanager", "com.meizu.flyme.filemanager.qrcode.ui.QrFilesCheckActivity", 8),
        EMAIL("com.android.email", (int) null, 9),
        WEIBO("com.sina.weibo", "com.sina.weibo.composerinde.ComposerDispatchActivity", 10),
        QQ_FILE("com.tencent.mobileqq", "com.tencent.mobileqq.activity.qfileJumpActivity", 11),
        QQ_FRIEND("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity", 12),
        WECHAT_MOMENT("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI", 13),
        WECHAT_FRIEND("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI", 14);
        
        /* access modifiers changed from: private */
        public String className;
        /* access modifiers changed from: private */
        public String packageName;
        /* access modifiers changed from: private */
        public int weight;

        private AppWeight(String str, String str2, int i) {
            this.packageName = str;
            this.className = str2;
            this.weight = i;
        }
    }

    @WorkerThread
    public ShareItemComparator(Context context) {
        this.f15759b = ShareWidgetUsageSharedPreferences.m17206a(context);
        this.f15760c = context.getPackageManager();
    }

    @WorkerThread
    /* renamed from: a */
    public int compare(DisplayResolveInfo bVar, DisplayResolveInfo bVar2) {
        C2826a a = m17166a((Object) bVar, (Object) bVar2);
        if (a.f15762a) {
            return a.f15763b;
        }
        ResolveInfo resolveInfo = bVar.f15734a;
        ResolveInfo resolveInfo2 = bVar2.f15734a;
        C2826a a2 = m17166a((Object) resolveInfo, (Object) resolveInfo2);
        if (a2.f15762a) {
            return a2.f15763b;
        }
        ComponentInfo componentInfo = resolveInfo.activityInfo != null ? resolveInfo.activityInfo : resolveInfo.serviceInfo;
        ComponentInfo componentInfo2 = resolveInfo2.activityInfo != null ? resolveInfo2.activityInfo : resolveInfo2.serviceInfo;
        C2826a a3 = m17166a((Object) componentInfo, (Object) componentInfo2);
        if (a3.f15762a) {
            return a3.f15763b;
        }
        C2826a a4 = m17165a(resolveInfo, resolveInfo2);
        if (a4.f15762a) {
            return a4.f15763b;
        }
        C2826a a5 = m17164a(componentInfo, componentInfo2);
        if (a5.f15762a) {
            return a5.f15763b;
        }
        C2826a b = m17167b(componentInfo, componentInfo2);
        if (b.f15762a) {
            return b.f15763b;
        }
        return 0;
    }

    /* renamed from: a */
    private C2826a m17166a(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return C2826a.m17170a(0);
        }
        if (obj == null) {
            return C2826a.m17170a(1);
        }
        if (obj2 == null) {
            return C2826a.m17170a(-1);
        }
        return C2826a.m17169a();
    }

    /* renamed from: a */
    private C2826a m17165a(@NonNull ResolveInfo resolveInfo, @NonNull ResolveInfo resolveInfo2) {
        UsageInfo b = this.f15759b.mo24031b(resolveInfo);
        UsageInfo b2 = this.f15759b.mo24031b(resolveInfo2);
        int a = b2.mo23983a() - b.mo23983a();
        int i = -1;
        if (a != 0) {
            if (a > 0) {
                i = 1;
            }
            return C2826a.m17170a(i);
        }
        int i2 = ((b2.mo23986b() - b.mo23986b()) > 0 ? 1 : ((b2.mo23986b() - b.mo23986b()) == 0 ? 0 : -1));
        if (i2 > 0) {
            return C2826a.m17170a(1);
        }
        if (i2 < 0) {
            return C2826a.m17170a(-1);
        }
        return C2826a.m17169a();
    }

    /* renamed from: a */
    private C2826a m17164a(@NonNull ComponentInfo componentInfo, @NonNull ComponentInfo componentInfo2) {
        int a = m17162a(componentInfo2) - m17162a(componentInfo);
        if (a == 0) {
            return C2826a.m17169a();
        }
        return C2826a.m17170a(a > 0 ? 1 : -1);
    }

    /* renamed from: a */
    private int m17162a(ComponentInfo componentInfo) {
        for (AppWeight appWeight : AppWeight.values()) {
            if (appWeight.packageName.equals(componentInfo.packageName) && (appWeight.className == null || appWeight.className.equals(componentInfo.name))) {
                return appWeight.weight;
            }
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.meizu.share.utils.ShareItemComparator.C2826a m17167b(@androidx.annotation.NonNull android.content.pm.ComponentInfo r7, @androidx.annotation.NonNull android.content.pm.ComponentInfo r8) {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r7 = r7.packageName     // Catch:{ NameNotFoundException -> 0x001f }
            android.content.pm.PackageInfo r7 = r6.m17163a((java.lang.String) r7)     // Catch:{ NameNotFoundException -> 0x001f }
            java.lang.String r8 = r8.packageName     // Catch:{ NameNotFoundException -> 0x001f }
            android.content.pm.PackageInfo r8 = r6.m17163a((java.lang.String) r8)     // Catch:{ NameNotFoundException -> 0x001f }
            long r2 = r7.firstInstallTime     // Catch:{ NameNotFoundException -> 0x001f }
            long r4 = r7.lastUpdateTime     // Catch:{ NameNotFoundException -> 0x001f }
            long r2 = java.lang.Math.max(r2, r4)     // Catch:{ NameNotFoundException -> 0x001f }
            long r4 = r8.firstInstallTime     // Catch:{ NameNotFoundException -> 0x0020 }
            long r7 = r8.lastUpdateTime     // Catch:{ NameNotFoundException -> 0x0020 }
            long r7 = java.lang.Math.max(r4, r7)     // Catch:{ NameNotFoundException -> 0x0020 }
            goto L_0x0021
        L_0x001f:
            r2 = r0
        L_0x0020:
            r7 = r0
        L_0x0021:
            r4 = 0
            long r7 = r7 - r2
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x0031
            if (r7 <= 0) goto L_0x002b
            r7 = 1
            goto L_0x002c
        L_0x002b:
            r7 = -1
        L_0x002c:
            com.meizu.share.utils.ShareItemComparator$a r7 = com.meizu.share.utils.ShareItemComparator.C2826a.m17170a(r7)
            return r7
        L_0x0031:
            com.meizu.share.utils.ShareItemComparator$a r7 = com.meizu.share.utils.ShareItemComparator.C2826a.m17169a()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.share.utils.ShareItemComparator.m17167b(android.content.pm.ComponentInfo, android.content.pm.ComponentInfo):com.meizu.share.utils.ShareItemComparator$a");
    }

    /* renamed from: a */
    private PackageInfo m17163a(String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = this.f15758a.get(str);
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo packageInfo2 = this.f15760c.getPackageInfo(str, 0);
        this.f15758a.put(str, packageInfo2);
        return packageInfo2;
    }

    /* renamed from: com.meizu.share.utils.ShareItemComparator$a */
    static class C2826a {

        /* renamed from: a */
        boolean f15762a;

        /* renamed from: b */
        int f15763b;

        private C2826a(boolean z, int i) {
            this.f15762a = z;
            this.f15763b = i;
        }

        private C2826a(boolean z) {
            this.f15762a = z;
        }

        /* renamed from: a */
        static C2826a m17170a(int i) {
            return new C2826a(true, i);
        }

        /* renamed from: a */
        static C2826a m17169a() {
            return new C2826a(false);
        }
    }
}
