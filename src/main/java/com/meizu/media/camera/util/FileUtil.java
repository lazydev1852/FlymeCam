package com.meizu.media.camera.util;

import android.content.Context;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.meizu.media.camera.util.t */
public class FileUtil {

    /* renamed from: a */
    public static ChangeQuickRedirect f14344a;

    /* renamed from: b */
    private static LogUtil.C2630a f14345b = new LogUtil.C2630a(com.meizu.cloud.pushsdk.notification.util.FileUtil.TAG);

    /* renamed from: a */
    public static boolean m16260a(String str, String str2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2}, (Object) null, f14344a, true, 8061, new Class[]{String.class, String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return m16267c(str, str2);
        }
        if (file.isDirectory()) {
            return m16268d(str, str2);
        }
        return false;
    }

    /* renamed from: c */
    private static boolean m16267c(String str, String str2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2}, (Object) null, f14344a, true, 8062, new Class[]{String.class, String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!new File(str).exists()) {
            return false;
        }
        String str3 = str2 + str.substring(str.lastIndexOf(File.separator));
        if (str3.equals(str)) {
            return false;
        }
        File file = new File(str3);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        new File(str2).mkdirs();
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0096 A[LOOP:0: B:16:0x0070->B:25:0x0096, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0099 A[EDGE_INSN: B:28:0x0099->B:26:0x0099 ?: BREAK  , SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m16268d(java.lang.String r10, java.lang.String r11) {
        /*
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            r9 = 1
            r1[r9] = r11
            com.meizu.savior.ChangeQuickRedirect r3 = f14344a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r8] = r0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r9] = r0
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r2 = 0
            r4 = 1
            r5 = 8064(0x1f80, float:1.13E-41)
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x002c
            java.lang.Object r10 = r0.result
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            return r10
        L_0x002c:
            java.io.File r0 = new java.io.File
            r0.<init>(r10)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x0038
            return r8
        L_0x0038:
            java.lang.String r1 = m16264b(r10)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            java.lang.String r11 = java.io.File.separator
            r2.append(r11)
            r2.append(r1)
            java.lang.String r11 = r2.toString()
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x0057
            return r8
        L_0x0057:
            java.io.File r10 = new java.io.File
            r10.<init>(r11)
            boolean r1 = r10.exists()
            if (r1 == 0) goto L_0x0063
            return r8
        L_0x0063:
            r10.mkdirs()
            java.io.File[] r10 = r0.listFiles()
            int r0 = r10.length
            if (r0 != 0) goto L_0x006e
            goto L_0x0099
        L_0x006e:
            int r0 = r10.length
            r9 = 0
        L_0x0070:
            if (r8 >= r0) goto L_0x0099
            r1 = r10[r8]
            boolean r2 = r1.isFile()
            if (r2 == 0) goto L_0x0084
            java.lang.String r1 = r1.getAbsolutePath()
            boolean r1 = m16267c(r1, r11)
        L_0x0082:
            r9 = r1
            goto L_0x0093
        L_0x0084:
            boolean r2 = r1.isDirectory()
            if (r2 == 0) goto L_0x0093
            java.lang.String r1 = r1.getAbsolutePath()
            boolean r1 = m16268d(r1, r11)
            goto L_0x0082
        L_0x0093:
            if (r9 != 0) goto L_0x0096
            goto L_0x0099
        L_0x0096:
            int r8 = r8 + 1
            goto L_0x0070
        L_0x0099:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.FileUtil.m16268d(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: b */
    private static String m16264b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14344a, true, 8065, new Class[]{String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.lastIndexOf(File.separator));
        }
        return str.substring(str.lastIndexOf(File.separator) + 1);
    }

    /* renamed from: a */
    public static boolean m16258a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14344a, true, 8066, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        File file = new File(str);
        if (file.isDirectory()) {
            return m16266c(file.getAbsolutePath());
        }
        if (file.isFile()) {
            return file.delete();
        }
        return false;
    }

    /* renamed from: c */
    private static boolean m16266c(String str) {
        boolean z = true;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14344a, true, 8067, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        File file = new File(str);
        if (!file.isDirectory()) {
            return true;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isFile()) {
                z = file2.delete();
            } else if (file2.isDirectory()) {
                z = m16266c(file2.getAbsolutePath());
            }
            if (!z) {
                break;
            }
        }
        return file.delete();
    }

    /* renamed from: b */
    public static boolean m16265b(String str, String str2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2}, (Object) null, f14344a, true, 8068, new Class[]{String.class, String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return m16260a(str, str2) && m16258a(str);
    }

    /* renamed from: a */
    public static void m16257a(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        if (!PatchProxy.proxy(new Object[]{context, str, str2}, (Object) null, f14344a, true, 8069, new Class[]{Context.class, String.class, String.class}, Void.TYPE).isSupported) {
            InputStream inputStream = null;
            try {
                String substring = str.substring(str.lastIndexOf(File.separator));
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(str2 + substring);
                InputStream open = context.getAssets().open(str);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e) {
                    inputStream = open;
                    e = e;
                    fileOutputStream = null;
                    try {
                        e.printStackTrace();
                        C2644av.m16096a((Closeable) inputStream);
                        C2644av.m16096a((Closeable) fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        C2644av.m16096a((Closeable) inputStream);
                        C2644av.m16096a((Closeable) fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    inputStream = open;
                    th = th2;
                    fileOutputStream = null;
                    C2644av.m16096a((Closeable) inputStream);
                    C2644av.m16096a((Closeable) fileOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    C2644av.m16096a((Closeable) open);
                } catch (Exception e2) {
                    inputStream = open;
                    e = e2;
                    e.printStackTrace();
                    C2644av.m16096a((Closeable) inputStream);
                    C2644av.m16096a((Closeable) fileOutputStream);
                } catch (Throwable th3) {
                    inputStream = open;
                    th = th3;
                    C2644av.m16096a((Closeable) inputStream);
                    C2644av.m16096a((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                e.printStackTrace();
                C2644av.m16096a((Closeable) inputStream);
                C2644av.m16096a((Closeable) fileOutputStream);
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                C2644av.m16096a((Closeable) inputStream);
                C2644av.m16096a((Closeable) fileOutputStream);
                throw th;
            }
            C2644av.m16096a((Closeable) fileOutputStream);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e4, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e5, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e9, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ea, code lost:
        r12 = r7;
        r7 = r6;
        r6 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00fc, code lost:
        r5 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0113, code lost:
        r13 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0113 A[ExcHandler: all (th java.lang.Throwable), PHI: r4 
  PHI: (r4v11 java.io.Closeable) = (r4v9 java.io.BufferedOutputStream), (r4v9 java.io.BufferedOutputStream), (r4v13 java.io.Closeable), (r4v13 java.io.Closeable), (r4v9 java.io.BufferedOutputStream) binds: [B:10:0x0046, B:13:0x004c, B:51:0x00fd, B:52:?, B:46:0x00f4] A[DONT_GENERATE, DONT_INLINE], Splitter:B:10:0x0046] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m16261a(java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            r0 = 3
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r13
            r9 = 1
            r1[r9] = r14
            r2 = 2
            r1[r2] = r15
            com.meizu.savior.ChangeQuickRedirect r3 = f14344a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r8] = r0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r9] = r0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r2] = r0
            java.lang.Class r7 = java.lang.Boolean.TYPE
            r2 = 0
            r4 = 1
            r5 = 8070(0x1f86, float:1.1308E-41)
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x0033
            java.lang.Object r13 = r0.result
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            return r13
        L_0x0033:
            r0 = 4096(0x1000, float:5.74E-42)
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            r2.<init>(r14)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.util.zip.ZipInputStream r3 = new java.util.zip.ZipInputStream     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x011a, all -> 0x0117 }
            r4 = r1
        L_0x0046:
            java.util.zip.ZipEntry r5 = r3.getNextEntry()     // Catch:{ Exception -> 0x0115, all -> 0x0113 }
            if (r5 == 0) goto L_0x0102
            byte[] r6 = new byte[r0]     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            java.lang.String r7 = r5.getName()     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            java.lang.String r10 = "."
            int r5 = r5.lastIndexOf(r10)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            int r5 = r5 + r9
            java.lang.String r5 = r7.substring(r5)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            java.lang.String r7 = "zip"
            boolean r7 = r7.equals(r5)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            if (r7 == 0) goto L_0x0080
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            r5.<init>()     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            r5.append(r13)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            java.lang.String r7 = "."
            r5.append(r7)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            java.lang.String r7 = "zip"
            r5.append(r7)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            goto L_0x0094
        L_0x0080:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            r7.<init>()     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            r7.append(r13)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            java.lang.String r10 = "."
            r7.append(r10)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            r7.append(r5)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
        L_0x0094:
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            r10.<init>()     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            r10.append(r15)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            java.lang.String r11 = java.io.File.separator     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            r10.append(r11)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            r10.append(r5)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            java.lang.String r5 = r10.toString()     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            r7.<init>(r5)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            java.lang.String r10 = r7.getParent()     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            r5.<init>(r10)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            boolean r10 = r5.exists()     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            if (r10 != 0) goto L_0x00bf
            r5.mkdirs()     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
        L_0x00bf:
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            r5.<init>(r7)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ Throwable -> 0x00e7, all -> 0x00e4 }
            r7.<init>(r5, r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x00e4 }
            r5.close()     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
        L_0x00cc:
            int r4 = r3.read(r6, r8, r0)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r5 = -1
            if (r4 == r5) goto L_0x00d7
            r7.write(r6, r8, r4)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            goto L_0x00cc
        L_0x00d7:
            r7.flush()     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r4 = r7
            goto L_0x0046
        L_0x00dd:
            r13 = move-exception
            r4 = r7
            goto L_0x0136
        L_0x00e1:
            r5 = move-exception
            r4 = r7
            goto L_0x00fd
        L_0x00e4:
            r6 = move-exception
            r7 = r1
            goto L_0x00ed
        L_0x00e7:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x00e9 }
        L_0x00e9:
            r7 = move-exception
            r12 = r7
            r7 = r6
            r6 = r12
        L_0x00ed:
            if (r7 == 0) goto L_0x00f8
            r5.close()     // Catch:{ Throwable -> 0x00f3 }
            goto L_0x00fb
        L_0x00f3:
            r5 = move-exception
            r7.addSuppressed(r5)     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
            goto L_0x00fb
        L_0x00f8:
            r5.close()     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
        L_0x00fb:
            throw r6     // Catch:{ Exception -> 0x00fc, all -> 0x0113 }
        L_0x00fc:
            r5 = move-exception
        L_0x00fd:
            r5.printStackTrace()     // Catch:{ Exception -> 0x0115, all -> 0x0113 }
            goto L_0x0046
        L_0x0102:
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r2)
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r3)
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r4)
            boolean r13 = m16258a(r14)
            if (r13 != 0) goto L_0x0112
            return r8
        L_0x0112:
            return r9
        L_0x0113:
            r13 = move-exception
            goto L_0x0136
        L_0x0115:
            r13 = move-exception
            goto L_0x011d
        L_0x0117:
            r13 = move-exception
            r3 = r1
            goto L_0x0122
        L_0x011a:
            r13 = move-exception
            r3 = r1
            r4 = r3
        L_0x011d:
            r1 = r2
            goto L_0x0127
        L_0x011f:
            r13 = move-exception
            r2 = r1
            r3 = r2
        L_0x0122:
            r4 = r3
            goto L_0x0136
        L_0x0124:
            r13 = move-exception
            r3 = r1
            r4 = r3
        L_0x0127:
            r13.printStackTrace()     // Catch:{ all -> 0x0134 }
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r1)
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r3)
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r4)
            return r8
        L_0x0134:
            r13 = move-exception
            r2 = r1
        L_0x0136:
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r2)
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r3)
            com.meizu.media.camera.util.C2644av.m16096a((java.io.Closeable) r4)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.FileUtil.m16261a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    public static boolean m16262a(String str, String str2, String str3, boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2, str3, new Byte(z ? (byte) 1 : 0)}, (Object) null, f14344a, true, 8071, new Class[]{String.class, String.class, String.class, Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        try {
            if (!m16263a(str, new ZipInputStream(new FileInputStream(str2)), str3, z) || !m16258a(str2)) {
                return false;
            }
            return true;
        } catch (FileNotFoundException e) {
            LogUtil.m15949b(f14345b, e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m16259a(String str, InputStream inputStream, String str2) {
        ChangeQuickRedirect changeQuickRedirect = f14344a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, inputStream, str2}, (Object) null, changeQuickRedirect, true, 8072, new Class[]{String.class, InputStream.class, String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return m16263a(str, new ZipInputStream(inputStream), str2, false);
    }

    /* renamed from: a */
    private static boolean m16263a(String str, ZipInputStream zipInputStream, String str2, boolean z) {
        String str3;
        FileOutputStream fileOutputStream;
        Throwable th;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, zipInputStream, str2, new Byte(z ? (byte) 1 : 0)}, (Object) null, f14344a, true, 8073, new Class[]{String.class, ZipInputStream.class, String.class, Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (str.isEmpty()) {
                        str3 = nextEntry.getName();
                    } else {
                        str3 = str + File.separator + nextEntry.getName();
                    }
                    if (z) {
                        str3 = str3.substring(str3.lastIndexOf("/") + 1);
                    }
                    if (!nextEntry.isDirectory()) {
                        File file = new File(str2 + File.separator + str3);
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                            file.createNewFile();
                        }
                        fileOutputStream = new FileOutputStream(file);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            fileOutputStream.flush();
                        }
                        fileOutputStream.close();
                    } else if (!z) {
                        new File(str2 + File.separator + str3.substring(0, str3.length() - 1)).mkdirs();
                    }
                } else {
                    C2644av.m16096a((Closeable) zipInputStream);
                    return true;
                }
            } catch (Exception e) {
                try {
                    LogUtil.m15949b(f14345b, e.getMessage());
                    return false;
                } finally {
                    C2644av.m16096a((Closeable) zipInputStream);
                }
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009f, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a0, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a4, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a5, code lost:
        r8 = r2;
        r2 = r9;
        r9 = r8;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.fastjson.JSONObject m16256a(android.content.Context r9, java.lang.String r10) {
        /*
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r9
            r3 = 1
            r1[r3] = r10
            com.meizu.savior.ChangeQuickRedirect r4 = f14344a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.content.Context> r0 = android.content.Context.class
            r6[r2] = r0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r3] = r0
            java.lang.Class<com.alibaba.fastjson.JSONObject> r7 = com.alibaba.fastjson.JSONObject.class
            r2 = 0
            r0 = 1
            r5 = 8074(0x1f8a, float:1.1314E-41)
            r3 = r4
            r4 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x002a
            java.lang.Object r9 = r0.result
            com.alibaba.fastjson.JSONObject r9 = (com.alibaba.fastjson.JSONObject) r9
            return r9
        L_0x002a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.meizu.media.camera.Storage r1 = com.meizu.media.camera.Storage.m7750a()
            java.lang.String r9 = r1.mo18619a((android.content.Context) r9)
            r0.append(r9)
            java.lang.String r9 = java.io.File.separator
            r0.append(r9)
            r0.append(r10)
            java.lang.String r9 = java.io.File.separator
            r0.append(r9)
            java.lang.String r9 = "config.json"
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            java.io.File r0 = new java.io.File
            r0.<init>(r9)
            boolean r0 = r0.exists()
            r1 = 0
            if (r0 != 0) goto L_0x0073
            com.meizu.media.camera.util.ac$a r10 = f14345b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "ar config not exist! "
            r0.append(r2)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r10, (java.lang.String) r9)
            return r1
        L_0x0073:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00b7 }
            r0.<init>(r9)     // Catch:{ Exception -> 0x00b7 }
            java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x00a2, all -> 0x009f }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Throwable -> 0x00a2, all -> 0x009f }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r0, r3)     // Catch:{ Throwable -> 0x00a2, all -> 0x009f }
            r9.<init>(r2)     // Catch:{ Throwable -> 0x00a2, all -> 0x009f }
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ Throwable -> 0x00a2, all -> 0x009f }
            r2.<init>()     // Catch:{ Throwable -> 0x00a2, all -> 0x009f }
        L_0x0089:
            java.lang.String r3 = r9.readLine()     // Catch:{ Throwable -> 0x00a2, all -> 0x009f }
            if (r3 == 0) goto L_0x0093
            r2.append(r3)     // Catch:{ Throwable -> 0x00a2, all -> 0x009f }
            goto L_0x0089
        L_0x0093:
            java.lang.String r9 = r2.toString()     // Catch:{ Throwable -> 0x00a2, all -> 0x009f }
            com.alibaba.fastjson.JSONObject r9 = com.alibaba.fastjson.JSON.parseObject(r9)     // Catch:{ Throwable -> 0x00a2, all -> 0x009f }
            r0.close()     // Catch:{ Exception -> 0x00b7 }
            return r9
        L_0x009f:
            r9 = move-exception
            r2 = r1
            goto L_0x00a8
        L_0x00a2:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            r2 = move-exception
            r8 = r2
            r2 = r9
            r9 = r8
        L_0x00a8:
            if (r2 == 0) goto L_0x00b3
            r0.close()     // Catch:{ Throwable -> 0x00ae }
            goto L_0x00b6
        L_0x00ae:
            r0 = move-exception
            r2.addSuppressed(r0)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00b6
        L_0x00b3:
            r0.close()     // Catch:{ Exception -> 0x00b7 }
        L_0x00b6:
            throw r9     // Catch:{ Exception -> 0x00b7 }
        L_0x00b7:
            r9 = move-exception
            com.meizu.media.camera.util.ac$a r0 = f14345b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getARStickerConfig id: "
            r2.append(r3)
            r2.append(r10)
            java.lang.String r10 = " Err: "
            r2.append(r10)
            java.lang.String r9 = r9.getMessage()
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.FileUtil.m16256a(android.content.Context, java.lang.String):com.alibaba.fastjson.JSONObject");
    }
}
