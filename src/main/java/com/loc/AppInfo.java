package com.loc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.p020ar.util.SystemInfoUtil;
import java.security.MessageDigest;
import java.util.Locale;

/* renamed from: com.loc.cy */
public final class AppInfo {

    /* renamed from: a */
    static String f3177a = null;

    /* renamed from: b */
    static boolean f3178b = false;

    /* renamed from: c */
    private static String f3179c = "";

    /* renamed from: d */
    private static String f3180d = "";

    /* renamed from: e */
    private static String f3181e = "";

    /* renamed from: f */
    private static String f3182f = "";

    /* renamed from: a */
    public static String m3657a(Context context) {
        try {
            return m3668h(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f3182f;
        }
    }

    /* renamed from: a */
    static void m3658a(final Context context, final String str) {
        if (!TextUtils.isEmpty(str)) {
            f3182f = str;
            if (context != null) {
                SDKLogHandler.m3869d().submit(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c A[SYNTHETIC, Splitter:B:24:0x004c] */
                    /* JADX WARNING: Removed duplicated region for block: B:30:0x0057 A[SYNTHETIC, Splitter:B:30:0x0057] */
                    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                            r5 = this;
                            r0 = 0
                            android.content.Context r1 = r2     // Catch:{ Throwable -> 0x0042 }
                            java.lang.String r2 = "k.store"
                            java.lang.String r1 = com.loc.C1108h.m3856c(r1, r2)     // Catch:{ Throwable -> 0x0042 }
                            java.io.File r2 = new java.io.File     // Catch:{ Throwable -> 0x0042 }
                            r2.<init>(r1)     // Catch:{ Throwable -> 0x0042 }
                            java.io.File r1 = r2.getParentFile()     // Catch:{ Throwable -> 0x0042 }
                            boolean r1 = r1.exists()     // Catch:{ Throwable -> 0x0042 }
                            if (r1 != 0) goto L_0x001f
                            java.io.File r1 = r2.getParentFile()     // Catch:{ Throwable -> 0x0042 }
                            r1.mkdirs()     // Catch:{ Throwable -> 0x0042 }
                        L_0x001f:
                            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Throwable -> 0x0042 }
                            r1.<init>(r2)     // Catch:{ Throwable -> 0x0042 }
                            java.lang.String r0 = r3     // Catch:{ Throwable -> 0x003b, all -> 0x0036 }
                            byte[] r0 = com.loc.C1107dj.m3818a((java.lang.String) r0)     // Catch:{ Throwable -> 0x003b, all -> 0x0036 }
                            r1.write(r0)     // Catch:{ Throwable -> 0x003b, all -> 0x0036 }
                            r1.close()     // Catch:{ Throwable -> 0x0031 }
                            return
                        L_0x0031:
                            r0 = move-exception
                            r0.printStackTrace()
                            return
                        L_0x0036:
                            r0 = move-exception
                            r4 = r1
                            r1 = r0
                            r0 = r4
                            goto L_0x0055
                        L_0x003b:
                            r0 = move-exception
                            r4 = r1
                            r1 = r0
                            r0 = r4
                            goto L_0x0043
                        L_0x0040:
                            r1 = move-exception
                            goto L_0x0055
                        L_0x0042:
                            r1 = move-exception
                        L_0x0043:
                            java.lang.String r2 = "AI"
                            java.lang.String r3 = "stf"
                            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0040 }
                            if (r0 == 0) goto L_0x0054
                            r0.close()     // Catch:{ Throwable -> 0x0050 }
                            return
                        L_0x0050:
                            r0 = move-exception
                            r0.printStackTrace()
                        L_0x0054:
                            return
                        L_0x0055:
                            if (r0 == 0) goto L_0x005f
                            r0.close()     // Catch:{ Throwable -> 0x005b }
                            goto L_0x005f
                        L_0x005b:
                            r0 = move-exception
                            r0.printStackTrace()
                        L_0x005f:
                            throw r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.loc.AppInfo.C10911.run():void");
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public static void m3659a(String str) {
        f3180d = str;
    }

    /* renamed from: a */
    static boolean m3660a() {
        try {
            if (f3178b) {
                return true;
            }
            if (m3662b(f3177a)) {
                f3178b = true;
                return true;
            } else if (!TextUtils.isEmpty(f3177a)) {
                f3178b = false;
                f3177a = null;
                return false;
            } else if (m3662b(f3180d)) {
                f3178b = true;
                return true;
            } else {
                if (!TextUtils.isEmpty(f3180d)) {
                    f3178b = false;
                    f3180d = null;
                    return false;
                }
                return true;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public static String m3661b(Context context) {
        try {
            if (!"".equals(f3179c)) {
                return f3179c;
            }
            PackageManager packageManager = context.getPackageManager();
            f3179c = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return f3179c;
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "AI", "gAN");
        }
    }

    /* renamed from: b */
    private static boolean m3662b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c : str.toCharArray()) {
            if (('A' > c || c > 'z') && (('0' > c || c > ':') && c != '.')) {
                try {
                    SDKLogHandler.m3866b(C1107dj.m3804a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static String m3663c(Context context) {
        try {
            if (f3180d != null && !"".equals(f3180d)) {
                return f3180d;
            }
            String packageName = context.getPackageName();
            f3180d = packageName;
            if (!m3662b(packageName)) {
                f3180d = context.getPackageName();
            }
            return f3180d;
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "AI", "gpck");
        }
    }

    /* renamed from: d */
    public static String m3664d(Context context) {
        try {
            if (!"".equals(f3181e)) {
                return f3181e;
            }
            f3181e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return f3181e == null ? "" : f3181e;
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "AI", "gAV");
        }
    }

    /* renamed from: e */
    public static String m3665e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance("SHA1").digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(SystemInfoUtil.COLON);
            }
            String str = packageInfo.packageName;
            if (m3662b(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(f3180d)) {
                str = m3663c(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            f3177a = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "AI", "gsp");
            return f3177a;
        }
    }

    /* renamed from: f */
    public static String m3666f(Context context) {
        try {
            return m3668h(context);
        } catch (Throwable th) {
            BasicLogHandler.m3844a(th, "AI", "gKy");
            return f3182f;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0052 A[Catch:{ Throwable -> 0x0056, all -> 0x0067 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005c A[SYNTHETIC, Splitter:B:32:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006a A[SYNTHETIC, Splitter:B:38:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m3667g(android.content.Context r5) {
        /*
            java.lang.String r0 = "k.store"
            java.lang.String r5 = com.loc.C1108h.m3856c(r5, r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            if (r5 != 0) goto L_0x0014
            java.lang.String r5 = ""
            return r5
        L_0x0014:
            r5 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0041, all -> 0x003d }
            r1.<init>(r0)     // Catch:{ Throwable -> 0x0041, all -> 0x003d }
            int r5 = r1.available()     // Catch:{ Throwable -> 0x003b }
            byte[] r5 = new byte[r5]     // Catch:{ Throwable -> 0x003b }
            r1.read(r5)     // Catch:{ Throwable -> 0x003b }
            java.lang.String r5 = com.loc.C1107dj.m3810a((byte[]) r5)     // Catch:{ Throwable -> 0x003b }
            int r2 = r5.length()     // Catch:{ Throwable -> 0x003b }
            r3 = 32
            if (r2 != r3) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            java.lang.String r5 = ""
        L_0x0032:
            r1.close()     // Catch:{ Throwable -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003a:
            return r5
        L_0x003b:
            r5 = move-exception
            goto L_0x0045
        L_0x003d:
            r0 = move-exception
            r1 = r5
            r5 = r0
            goto L_0x0068
        L_0x0041:
            r1 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
        L_0x0045:
            java.lang.String r2 = "AI"
            java.lang.String r3 = "gKe"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r5, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0067 }
            boolean r5 = r0.exists()     // Catch:{ Throwable -> 0x0056 }
            if (r5 == 0) goto L_0x005a
            r0.delete()     // Catch:{ Throwable -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x0067 }
        L_0x005a:
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ Throwable -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0064:
            java.lang.String r5 = ""
            return r5
        L_0x0067:
            r5 = move-exception
        L_0x0068:
            if (r1 == 0) goto L_0x0072
            r1.close()     // Catch:{ Throwable -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0072:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.AppInfo.m3667g(android.content.Context):java.lang.String");
    }

    /* renamed from: h */
    private static String m3668h(Context context) throws PackageManager.NameNotFoundException {
        if (f3182f == null || f3182f.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return f3182f;
            }
            String string = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
            f3182f = string;
            if (string == null) {
                f3182f = m3667g(context);
            }
        }
        return f3182f;
    }
}
