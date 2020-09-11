package com.meizu.media.camera.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import android.view.View;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/* renamed from: com.meizu.media.camera.util.av */
/* compiled from: Utils */
public class C2644av {

    /* renamed from: a */
    public static ChangeQuickRedirect f14189a = null;

    /* renamed from: b */
    public static boolean f14190b = true;

    /* renamed from: c */
    public static boolean f14191c = false;

    /* renamed from: d */
    private static String f14192d;

    /* renamed from: a */
    public static void m16099a(String str, Object... objArr) {
    }

    /* renamed from: a */
    public static void m16101a(boolean z, boolean z2, String str, Object... objArr) {
    }

    /* renamed from: a */
    private static boolean m16102a(char c) {
        return (c == 0 || c == 9 || c == 10 || c == 13 || (c >= ' ' && c <= 55295) || ((c >= 57344 && c <= 65533) || (c >= 0 && c <= 65535))) ? false : true;
    }

    /* renamed from: a */
    public static void m16100a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14189a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 8252, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && !z) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public static <T> T m16095a(T t) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{t}, (Object) null, f14189a, true, 8253, new Class[]{Object.class}, Object.class);
        if (proxy.isSupported) {
            return (Object) proxy.result;
        }
        if (t == null) {
            Log.w("Utils", "current reference is null!!!");
        }
        return t;
    }

    /* renamed from: a */
    public static void m16096a(Closeable closeable) {
        if (!PatchProxy.proxy(new Object[]{closeable}, (Object) null, f14189a, true, 8254, new Class[]{Closeable.class}, Void.TYPE).isSupported && closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                Log.w("Utils", "close fail", th);
            }
        }
    }

    /* renamed from: a */
    public static boolean m16105a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14189a, true, 8255, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return str == null || str.trim().length() == 0;
    }

    /* renamed from: b */
    public static boolean m16111b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14189a, true, 8256, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (m16102a(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static int m16112c(String str) {
        int i = 0;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14189a, true, 8257, new Class[]{String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int i2 = 0;
        while (i < str.length()) {
            int i3 = i + 1;
            i2 = str.substring(i, i3).matches("[Α-￥]") ? i2 + 2 : i2 + 1;
            i = i3;
        }
        return i2;
    }

    /* renamed from: a */
    public static boolean m16104a(Context context, String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, str}, (Object) null, f14189a, true, 8258, new Class[]{Context.class, String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                String str2 = installedPackages.get(i).packageName;
                if (str != null && str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static void m16098a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (!PatchProxy.proxy(new Object[]{str, bArr}, (Object) null, f14189a, true, 8259, new Class[]{String.class, byte[].class}, Void.TYPE).isSupported) {
            Log.i("Utils", "writeToFile :" + str);
            try {
                File file = new File(str);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file.getAbsoluteFile(), true);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } catch (IOException e) {
                Log.e("Utils", "writeToFile Exception", e);
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0099  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m16097a(java.lang.String r9, android.graphics.Bitmap r10) {
        /*
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r9
            r3 = 1
            r1[r3] = r10
            com.meizu.savior.ChangeQuickRedirect r4 = f14189a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r2] = r0
            java.lang.Class<android.graphics.Bitmap> r0 = android.graphics.Bitmap.class
            r6[r3] = r0
            java.lang.Class r7 = java.lang.Void.TYPE
            r2 = 0
            r0 = 1
            r5 = 8262(0x2046, float:1.1578E-41)
            r3 = r4
            r4 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0026
            return
        L_0x0026:
            java.lang.String r0 = "Utils"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SaveJpeg:"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r0, r1)
            if (r10 == 0) goto L_0x00b6
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            r1.<init>(r9)     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0066 }
            r9.<init>(r1)     // Catch:{ IOException -> 0x0066 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x0061, all -> 0x005c }
            r2 = 95
            r10.compress(r0, r2, r9)     // Catch:{ IOException -> 0x0061, all -> 0x005c }
            r1.close()     // Catch:{ IOException -> 0x005a }
            r9.flush()     // Catch:{ IOException -> 0x005a }
            r9.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x0092
        L_0x005a:
            r9 = move-exception
            goto L_0x0088
        L_0x005c:
            r0 = move-exception
            r8 = r0
            r0 = r9
            r9 = r8
            goto L_0x0097
        L_0x0061:
            r0 = move-exception
            r8 = r0
            r0 = r9
            r9 = r8
            goto L_0x006d
        L_0x0066:
            r9 = move-exception
            goto L_0x006d
        L_0x0068:
            r9 = move-exception
            r1 = r0
            goto L_0x0097
        L_0x006b:
            r9 = move-exception
            r1 = r0
        L_0x006d:
            java.lang.String r2 = "Utils"
            java.lang.String r3 = "FileOutputStream fail to call the write() method"
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x0096 }
            r9.printStackTrace()     // Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x0092
            if (r1 == 0) goto L_0x0081
            r1.close()     // Catch:{ IOException -> 0x007f }
            goto L_0x0081
        L_0x007f:
            r9 = move-exception
            goto L_0x0088
        L_0x0081:
            r0.flush()     // Catch:{ IOException -> 0x007f }
            r0.close()     // Catch:{ IOException -> 0x007f }
            goto L_0x0092
        L_0x0088:
            r9.printStackTrace()
            java.lang.String r9 = "Utils"
            java.lang.String r0 = "fail to close fops"
            android.util.Log.e(r9, r0)
        L_0x0092:
            r10.recycle()
            goto L_0x00b6
        L_0x0096:
            r9 = move-exception
        L_0x0097:
            if (r0 == 0) goto L_0x00b2
            if (r1 == 0) goto L_0x00a1
            r1.close()     // Catch:{ IOException -> 0x009f }
            goto L_0x00a1
        L_0x009f:
            r0 = move-exception
            goto L_0x00a8
        L_0x00a1:
            r0.flush()     // Catch:{ IOException -> 0x009f }
            r0.close()     // Catch:{ IOException -> 0x009f }
            goto L_0x00b2
        L_0x00a8:
            r0.printStackTrace()
            java.lang.String r0 = "Utils"
            java.lang.String r1 = "fail to close fops"
            android.util.Log.e(r0, r1)
        L_0x00b2:
            r10.recycle()
            throw r9
        L_0x00b6:
            java.lang.String r9 = "Utils"
            java.lang.String r10 = "SaveJpeg end"
            android.util.Log.i(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.C2644av.m16097a(java.lang.String, android.graphics.Bitmap):void");
    }

    /* renamed from: a */
    public static Object[] m16108a(int i, Object[] objArr) {
        Object[] objArr2 = new Object[(objArr.length - 1)];
        for (int i2 = 0; i2 < objArr.length - 1; i2++) {
            if (i2 < i) {
                objArr2[i2] = objArr[i2];
            } else {
                objArr2[i2] = objArr[i2 + 1];
            }
        }
        return objArr2;
    }

    /* renamed from: a */
    public static View[] m16107a(int i, View[] viewArr) {
        View[] viewArr2 = new View[(viewArr.length - 1)];
        for (int i2 = 0; i2 < viewArr.length - 1; i2++) {
            if (i2 < i) {
                viewArr2[i2] = viewArr[i2];
            } else {
                viewArr2[i2] = viewArr[i2 + 1];
            }
        }
        return viewArr2;
    }

    /* renamed from: a */
    public static short[] m16109a(byte[] bArr) {
        int length = bArr.length >> 1;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            sArr[i] = (short) ((bArr[i2] & 255) | (bArr[i2 + 1] << 8));
        }
        return sArr;
    }

    /* renamed from: b */
    public static int m16110b(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i += (bArr[i2] & 255) << ((3 - i2) * 8);
        }
        return i;
    }

    /* renamed from: a */
    public static byte[] m16106a(short[] sArr) {
        int length = sArr.length;
        byte[] bArr = new byte[(length << 1)];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i2 + 1] = (byte) ((sArr[i] >> 8) & 255);
            bArr[i2] = (byte) ((sArr[i] >> 0) & 255);
        }
        return bArr;
    }

    /* renamed from: a */
    public static boolean m16103a(float f, float f2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Float(f), new Float(f2)}, (Object) null, f14189a, true, 8263, new Class[]{Float.TYPE, Float.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return Math.abs(f - f2) <= 1.0E-5f;
    }
}
