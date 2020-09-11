package com.meizu.update.install;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.p000pm.IPackageInstallObserver;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import com.meizu.p055b.ReflectHelper;
import com.meizu.update.UpdateInfo;
import com.meizu.update.util.Loger;
import java.io.File;
import java.util.List;

public class InstallHelper {

    public enum InstallStatus {
        NOT_SUPPORT,
        SUCCESS,
        FAILED;
        
        /* access modifiers changed from: private */
        public int mErrorCode;

        /* access modifiers changed from: protected */
        public void setErrorCode(int i) {
            this.mErrorCode = i;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(Unknown Source)
        	at java.util.ArrayList.get(Unknown Source)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    @androidx.annotation.RequiresApi(api = 21)
    /* renamed from: a */
    public static com.meizu.update.install.InstallHelper.InstallStatus m17778a(android.content.Context r19, java.lang.String r20) {
        /*
            r1 = r19
            r2 = r20
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 28
            if (r0 >= r3) goto L_0x0012
            java.lang.String r0 = "doInstallOverAndroidP error Api!"
            com.meizu.update.util.Loger.m17943d(r0)
            com.meizu.update.install.InstallHelper$InstallStatus r0 = com.meizu.update.install.InstallHelper.InstallStatus.FAILED
            return r0
        L_0x0012:
            java.lang.Object r3 = new java.lang.Object
            r3.<init>()
            com.meizu.update.install.InstallHelper$InstallStatus r4 = com.meizu.update.install.InstallHelper.InstallStatus.SUCCESS
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            int unused = r4.mErrorCode = r5
            android.content.pm.PackageManager r0 = r19.getPackageManager()
            android.content.pm.PackageInstaller$SessionParams r6 = new android.content.pm.PackageInstaller$SessionParams
            r7 = 1
            r6.<init>(r7)
            android.content.pm.PackageInstaller r0 = r0.getPackageInstaller()
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x0132, all -> 0x012f }
            r8.<init>(r2)     // Catch:{ Exception -> 0x0132, all -> 0x012f }
            int r6 = r0.createSession(r6)     // Catch:{ Exception -> 0x0132, all -> 0x012f }
            r9 = 65535(0xffff, float:9.1834E-41)
            byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x0132, all -> 0x012f }
            android.content.pm.PackageInstaller$Session r14 = r0.openSession(r6)     // Catch:{ Exception -> 0x0132, all -> 0x012f }
            long r15 = r8.length()     // Catch:{ Exception -> 0x012b, all -> 0x0128 }
            r12 = -1
            java.io.FileInputStream r13 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0086, all -> 0x0080 }
            r13.<init>(r8)     // Catch:{ Exception -> 0x0086, all -> 0x0080 }
            java.lang.String r11 = "InstallSession"
            r17 = 0
            r10 = r14
            r8 = r13
            r7 = -1
            r12 = r17
            r5 = r14
            r14 = r15
            java.io.OutputStream r10 = r10.openWrite(r11, r12, r14)     // Catch:{ Exception -> 0x0075, all -> 0x0073 }
        L_0x0057:
            int r0 = r8.read(r9)     // Catch:{ Exception -> 0x0071 }
            if (r0 == r7) goto L_0x0062
            r11 = 0
            r10.write(r9, r11, r0)     // Catch:{ Exception -> 0x0071 }
            goto L_0x0057
        L_0x0062:
            java.lang.String r0 = "doInstallOverAndroidP : session fsync"
            com.meizu.update.util.Loger.m17942c(r0)     // Catch:{ Exception -> 0x0071 }
            r5.fsync(r10)     // Catch:{ Exception -> 0x0071 }
            com.meizu.update.util.Utility.m17966a((java.io.Closeable) r8)     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
        L_0x006d:
            com.meizu.update.util.Utility.m17966a((java.io.Closeable) r10)     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            goto L_0x00a7
        L_0x0071:
            r0 = move-exception
            goto L_0x008b
        L_0x0073:
            r0 = move-exception
            goto L_0x0083
        L_0x0075:
            r0 = move-exception
            goto L_0x008a
        L_0x0077:
            r0 = move-exception
            r8 = r13
            r5 = r14
            goto L_0x0083
        L_0x007b:
            r0 = move-exception
            r8 = r13
            r5 = r14
            r7 = -1
            goto L_0x008a
        L_0x0080:
            r0 = move-exception
            r5 = r14
            r8 = 0
        L_0x0083:
            r10 = 0
            goto L_0x011d
        L_0x0086:
            r0 = move-exception
            r5 = r14
            r7 = -1
            r8 = 0
        L_0x008a:
            r10 = 0
        L_0x008b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x011c }
            r9.<init>()     // Catch:{ all -> 0x011c }
            java.lang.String r11 = "doInstallOverAndroidP write steam error : "
            r9.append(r11)     // Catch:{ all -> 0x011c }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x011c }
            r9.append(r0)     // Catch:{ all -> 0x011c }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x011c }
            com.meizu.update.util.Loger.m17943d(r0)     // Catch:{ all -> 0x011c }
            com.meizu.update.util.Utility.m17966a((java.io.Closeable) r8)     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            goto L_0x006d
        L_0x00a7:
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            r0.<init>()     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            java.lang.String r8 = r19.getPackageName()     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            java.lang.String r8 = m17787c(r8)     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            r0.addAction(r8)     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            com.meizu.update.install.InstallHelper$1 r8 = new com.meizu.update.install.InstallHelper$1     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            r8.<init>(r1, r4, r3)     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            r1.registerReceiver(r8, r0)     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            m17781a((android.content.Context) r1, (android.content.pm.PackageInstaller.Session) r5, (int) r6)     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            r0.<init>()     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            java.lang.String r1 = "session commit: "
            r0.append(r1)     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            r0.append(r2)     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            com.meizu.update.util.Loger.m17942c(r0)     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            monitor-enter(r3)     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            int r0 = r4.getErrorCode()     // Catch:{ all -> 0x0119 }
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r1) goto L_0x00f4
            r0 = 120000(0x1d4c0, double:5.9288E-319)
            r3.wait(r0)     // Catch:{ InterruptedException -> 0x00e6 }
            goto L_0x00f4
        L_0x00e6:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()     // Catch:{ all -> 0x0119 }
            com.meizu.update.install.InstallHelper$InstallStatus r0 = com.meizu.update.install.InstallHelper.InstallStatus.FAILED     // Catch:{ all -> 0x0119 }
            monitor-exit(r3)     // Catch:{ all -> 0x0119 }
            if (r5 == 0) goto L_0x00f3
            r5.close()
        L_0x00f3:
            return r0
        L_0x00f4:
            monitor-exit(r3)     // Catch:{ all -> 0x0119 }
            int r0 = r4.getErrorCode()     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            if (r0 == 0) goto L_0x0113
            int r0 = r4.getErrorCode()     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            if (r0 != r7) goto L_0x0104
            com.meizu.update.install.InstallHelper$InstallStatus r0 = com.meizu.update.install.InstallHelper.InstallStatus.NOT_SUPPORT     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            goto L_0x0106
        L_0x0104:
            com.meizu.update.install.InstallHelper$InstallStatus r0 = com.meizu.update.install.InstallHelper.InstallStatus.FAILED     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
        L_0x0106:
            int r1 = r4.getErrorCode()     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            r0.setErrorCode(r1)     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            if (r5 == 0) goto L_0x0112
            r5.close()
        L_0x0112:
            return r0
        L_0x0113:
            if (r5 == 0) goto L_0x0118
            r5.close()
        L_0x0118:
            return r4
        L_0x0119:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0119 }
            throw r0     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
        L_0x011c:
            r0 = move-exception
        L_0x011d:
            com.meizu.update.util.Utility.m17966a((java.io.Closeable) r8)     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            com.meizu.update.util.Utility.m17966a((java.io.Closeable) r10)     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
            throw r0     // Catch:{ Exception -> 0x0126, all -> 0x0124 }
        L_0x0124:
            r0 = move-exception
            goto L_0x0145
        L_0x0126:
            r0 = move-exception
            goto L_0x012d
        L_0x0128:
            r0 = move-exception
            r5 = r14
            goto L_0x0145
        L_0x012b:
            r0 = move-exception
            r5 = r14
        L_0x012d:
            r7 = r5
            goto L_0x0134
        L_0x012f:
            r0 = move-exception
            r5 = 0
            goto L_0x0145
        L_0x0132:
            r0 = move-exception
            r7 = 0
        L_0x0134:
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0143 }
            com.meizu.update.util.Loger.m17942c(r0)     // Catch:{ all -> 0x0143 }
            if (r7 == 0) goto L_0x0140
            r7.close()
        L_0x0140:
            com.meizu.update.install.InstallHelper$InstallStatus r0 = com.meizu.update.install.InstallHelper.InstallStatus.NOT_SUPPORT
            return r0
        L_0x0143:
            r0 = move-exception
            r5 = r7
        L_0x0145:
            if (r5 == 0) goto L_0x014a
            r5.close()
        L_0x014a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.install.InstallHelper.m17778a(android.content.Context, java.lang.String):com.meizu.update.install.InstallHelper$InstallStatus");
    }

    @RequiresApi(api = 21)
    /* renamed from: a */
    private static void m17781a(Context context, PackageInstaller.Session session, int i) {
        session.commit(PendingIntent.getBroadcast(context, i, new Intent(m17787c(context.getPackageName())), 134217728).getIntentSender());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static String m17787c(String str) {
        return String.format("%s.InstallSession.ACTION_INSTALL_CALLBACK:%s", new Object[]{str, str});
    }

    /* renamed from: b */
    public static InstallStatus m17784b(Context context, String str) {
        final Object obj = new Object();
        final InstallStatus installStatus = InstallStatus.SUCCESS;
        int unused = installStatus.mErrorCode = Integer.MIN_VALUE;
        try {
            int intValue = ((Integer) ReflectHelper.m4010a("android.content.pm.PackageManager", "INSTALL_REPLACE_EXISTING")).intValue();
            final int intValue2 = ((Integer) ReflectHelper.m4010a("android.content.pm.PackageManager", "INSTALL_SUCCEEDED")).intValue();
            PackageManager packageManager = context.getPackageManager();
            Class[] clsArr = {Uri.class, IPackageInstallObserver.class, Integer.TYPE, String.class};
            ReflectHelper.m4009a((Object) packageManager, "installPackage", (Class<?>[]) clsArr, new Object[]{Uri.parse("file://" + str), new IPackageInstallObserver.C0000a() {
                public void packageInstalled(String str, int i) throws RemoteException {
                    if (i != intValue2) {
                        Loger.m17942c("install return code : " + i);
                    }
                    installStatus.setErrorCode(i);
                    synchronized (obj) {
                        obj.notify();
                    }
                }
            }, Integer.valueOf(intValue), null});
            synchronized (obj) {
                try {
                    obj.wait(120000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return InstallStatus.FAILED;
                }
            }
            if (installStatus.getErrorCode() == intValue2) {
                return installStatus;
            }
            InstallStatus installStatus2 = InstallStatus.FAILED;
            installStatus2.setErrorCode(installStatus.getErrorCode());
            return installStatus2;
        } catch (Exception e2) {
            Loger.m17938a(context, "background install error :" + e2.getMessage());
            e2.printStackTrace();
            return InstallStatus.NOT_SUPPORT;
        }
    }

    /* renamed from: c */
    public static final Intent m17786c(Context context, String str) {
        Uri uri;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        File file = new File(str);
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                intent.setFlags(1);
                uri = FileProvider.getUriForFile(context, context.getPackageName() + ".update.fileProvider", file);
            } catch (Exception e) {
                Loger.m17943d("getUriForFile Exception : " + e.getMessage());
                uri = Uri.fromFile(file);
            }
        } else {
            uri = Uri.fromFile(file);
        }
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        return intent;
    }

    /* renamed from: a */
    public static final void m17782a(Context context, String str, UpdateInfo updateInfo) {
        Intent c = m17786c(context, str);
        if (!(context instanceof Activity)) {
            c.addFlags(268435456);
        }
        context.startActivity(c);
    }

    /* renamed from: a */
    public static final InstallStatus m17779a(Context context, final String str, boolean z) {
        String str2;
        String str3;
        if (!(context.getPackageManager().checkPermission("com.meizu.flyme.update.permission.EXTERNAL_INSTALL", context.getPackageName()) == 0) || !m17783a(context)) {
            Loger.m17942c("not support external install service");
            return InstallStatus.NOT_SUPPORT;
        }
        final Object obj = new Object();
        final InstallStatus installStatus = InstallStatus.SUCCESS;
        int unused = installStatus.mErrorCode = Integer.MIN_VALUE;
        IntentFilter intentFilter = new IntentFilter(m17780a(context.getPackageName()));
        C30223 r3 = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                Bundle bundleExtra = intent.getBundleExtra("install_info");
                if (bundleExtra != null) {
                    String string = bundleExtra.getString("apk_path");
                    int i = bundleExtra.getInt("status_code");
                    if (str.equals(string)) {
                        Loger.m17942c("external install call back status = " + i);
                        int unused = installStatus.mErrorCode = i;
                        synchronized (obj) {
                            obj.notify();
                        }
                    }
                }
            }
        };
        try {
            context.registerReceiver(r3, intentFilter);
            Intent a = m17777a();
            a.putExtra("reqeust_pkg", context.getPackageName());
            a.putExtra("apk_path", str);
            a.putExtra("silent_update", z);
            context.startService(a);
            synchronized (obj) {
                if (installStatus.getErrorCode() == Integer.MIN_VALUE) {
                    try {
                        Loger.m17942c("external install lock and wait call back");
                        obj.wait(150000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Loger.m17942c("external install wait lock error " + e.getMessage());
                        InstallStatus installStatus2 = InstallStatus.FAILED;
                        try {
                            context.unregisterReceiver(r3);
                            Loger.m17941b("unregisterReceiver install call back");
                        } catch (Exception e2) {
                            Loger.m17942c("unregisterReceiver error : " + e2.getMessage());
                        }
                        return installStatus2;
                    }
                }
            }
            if (installStatus.getErrorCode() != Integer.MAX_VALUE) {
                InstallStatus installStatus3 = installStatus.getErrorCode() == -1 ? InstallStatus.NOT_SUPPORT : InstallStatus.FAILED;
                installStatus3.setErrorCode(installStatus.getErrorCode());
                try {
                    context.unregisterReceiver(r3);
                    Loger.m17941b("unregisterReceiver install call back");
                } catch (Exception e3) {
                    Loger.m17942c("unregisterReceiver error : " + e3.getMessage());
                }
                return installStatus3;
            }
            try {
                context.unregisterReceiver(r3);
                Loger.m17941b("unregisterReceiver install call back");
            } catch (Exception e4) {
                Loger.m17942c("unregisterReceiver error : " + e4.getMessage());
            }
            return installStatus;
        } catch (Exception e5) {
            try {
                Loger.m17938a(context, "external install error :" + e5.getMessage());
                return InstallStatus.NOT_SUPPORT;
            } finally {
                try {
                    context.unregisterReceiver(r3);
                    str3 = "unregisterReceiver install call back";
                    Loger.m17941b(str3);
                } catch (Exception e6) {
                    StringBuilder sb = new StringBuilder();
                    str2 = "unregisterReceiver error : ";
                    sb.append(str2);
                    sb.append(e6.getMessage());
                    Loger.m17942c(sb.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public static String m17780a(String str) {
        return String.format("%s.FLYME_ACTION_INSTALL_CALLBACK", new Object[]{str});
    }

    /* renamed from: a */
    private static boolean m17783a(Context context) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(m17777a(), 0);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static Intent m17777a() {
        Intent intent = new Intent("com.meizu.flyme.update.intent.action.EXTERNAL_INSTALL");
        intent.setPackage("com.meizu.flyme.update");
        return intent;
    }
}
