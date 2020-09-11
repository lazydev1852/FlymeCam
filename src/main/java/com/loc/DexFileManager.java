package com.loc;

import android.content.Context;
import java.io.File;
import java.util.List;

/* renamed from: com.loc.t */
public final class DexFileManager {

    /* renamed from: com.loc.t$a */
    /* compiled from: DexFileManager */
    public static class C1115a {
        /* renamed from: a */
        static DynamicPlugin m3939a(DBOperation nVar, String str) {
            List<DynamicPlugin> b = nVar.mo13304b(DynamicPlugin.m3948b(str), DynamicPlugin.class);
            if (b == null || b.size() <= 0) {
                return null;
            }
            return b.get(0);
        }

        /* renamed from: a */
        public static List<DynamicPlugin> m3940a(DBOperation nVar, String str, String str2) {
            return nVar.mo13304b(DynamicPlugin.m3949b(str, str2), DynamicPlugin.class);
        }
    }

    /* renamed from: a */
    static String m3924a(Context context) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "pngex";
    }

    /* renamed from: a */
    static String m3925a(Context context, DBOperation nVar, SDKInfo diVar) {
        List<DynamicPlugin> b = nVar.mo13304b(DynamicPlugin.m3949b(diVar.mo13272a(), "copy"), DynamicPlugin.class);
        if (b == null || b.size() == 0) {
            return null;
        }
        C1120z.m3983a(b);
        int i = 0;
        while (i < b.size()) {
            DynamicPlugin wVar = b.get(i);
            String a = wVar.mo13320a();
            if (C1120z.m3989a(nVar, a, m3926a(context, a), diVar)) {
                try {
                    m3930a(context, nVar, diVar, m3926a(context, wVar.mo13320a()), wVar.mo13325e());
                    return wVar.mo13325e();
                } catch (Throwable th) {
                    BasicLogHandler.m3844a(th, "FileManager", "loadAvailableD");
                }
            } else {
                m3937c(context, nVar, wVar.mo13320a());
                i++;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m3926a(Context context, String str) {
        return m3924a(context) + File.separator + str;
    }

    /* renamed from: a */
    static String m3927a(Context context, String str, String str2) {
        String v = DeviceInfo.m3733v(context);
        return MD5.m3762b(str + str2 + v) + ".jar";
    }

    /* renamed from: a */
    static String m3928a(String str) {
        return str + ".o";
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m3929a(android.content.Context r12, com.loc.SDKInfo r13) {
        /*
            com.loc.y r0 = com.loc.LoaderFactory.m3976b()     // Catch:{ Throwable -> 0x00bb }
            com.loc.y$a r0 = r0.mo13331a(r13)     // Catch:{ Throwable -> 0x00bb }
            if (r0 == 0) goto L_0x0017
            boolean r1 = r0.f3440a     // Catch:{ Throwable -> 0x00bb }
            if (r1 == 0) goto L_0x0017
            monitor-enter(r0)     // Catch:{ Throwable -> 0x00bb }
            r0.wait()     // Catch:{ all -> 0x0014 }
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            goto L_0x0017
        L_0x0014:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ Throwable -> 0x00bb }
            throw r12     // Catch:{ Throwable -> 0x00bb }
        L_0x0017:
            r1 = 1
            r0.f3441b = r1     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r1 = r13.mo13272a()     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r2 = r13.mo13274b()     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r1 = m3934b((android.content.Context) r12, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00bb }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x00bb }
            if (r2 == 0) goto L_0x002d
            return
        L_0x002d:
            java.io.File r2 = new java.io.File     // Catch:{ Throwable -> 0x00bb }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x00bb }
            java.io.File r3 = r2.getParentFile()     // Catch:{ Throwable -> 0x00bb }
            boolean r4 = r2.exists()     // Catch:{ Throwable -> 0x00bb }
            if (r4 != 0) goto L_0x0050
            if (r3 == 0) goto L_0x004f
            boolean r0 = r3.exists()     // Catch:{ Throwable -> 0x00bb }
            if (r0 == 0) goto L_0x004f
            java.lang.String r0 = r13.mo13272a()     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r13 = r13.mo13274b()     // Catch:{ Throwable -> 0x00bb }
            m3938c((android.content.Context) r12, (java.lang.String) r0, (java.lang.String) r13)     // Catch:{ Throwable -> 0x00bb }
        L_0x004f:
            return
        L_0x0050:
            java.lang.String r3 = r2.getName()     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r3 = m3928a((java.lang.String) r3)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r3 = m3926a((android.content.Context) r12, (java.lang.String) r3)     // Catch:{ Throwable -> 0x00bb }
            r4 = 0
            dalvik.system.DexFile r1 = dalvik.system.DexFile.loadDex(r1, r3, r4)     // Catch:{ Throwable -> 0x00bb }
            if (r1 == 0) goto L_0x00b8
            r1.close()     // Catch:{ Throwable -> 0x00bb }
            r1 = 0
            com.loc.n r5 = new com.loc.n     // Catch:{ Throwable -> 0x00bb }
            com.loc.v r6 = com.loc.DynamicFileDBCreator.m3942b()     // Catch:{ Throwable -> 0x00bb }
            r5.<init>(r12, r6)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r12 = r2.getName()     // Catch:{ Throwable -> 0x00bb }
            com.loc.w r12 = com.loc.DexFileManager.C1115a.m3939a(r5, r12)     // Catch:{ Throwable -> 0x00bb }
            if (r12 == 0) goto L_0x007e
            java.lang.String r1 = r12.mo13325e()     // Catch:{ Throwable -> 0x00bb }
        L_0x007e:
            r11 = r1
            java.io.File r12 = new java.io.File     // Catch:{ Throwable -> 0x00bb }
            r12.<init>(r3)     // Catch:{ Throwable -> 0x00bb }
            boolean r1 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Throwable -> 0x00bb }
            if (r1 != 0) goto L_0x00b8
            boolean r1 = r12.exists()     // Catch:{ Throwable -> 0x00bb }
            if (r1 == 0) goto L_0x00b8
            java.lang.String r8 = com.loc.MD5.m3759a((java.lang.String) r3)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r12 = r12.getName()     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r9 = r13.mo13272a()     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r10 = r13.mo13274b()     // Catch:{ Throwable -> 0x00bb }
            com.loc.w$a r13 = new com.loc.w$a     // Catch:{ Throwable -> 0x00bb }
            r6 = r13
            r7 = r12
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r1 = "useod"
            com.loc.w$a r13 = r13.mo13327a((java.lang.String) r1)     // Catch:{ Throwable -> 0x00bb }
            com.loc.w r13 = r13.mo13328a()     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r12 = com.loc.DynamicPlugin.m3948b(r12)     // Catch:{ Throwable -> 0x00bb }
            r5.mo13301a((java.lang.Object) r13, (java.lang.String) r12)     // Catch:{ Throwable -> 0x00bb }
        L_0x00b8:
            r0.f3441b = r4     // Catch:{ Throwable -> 0x00bb }
            return
        L_0x00bb:
            r12 = move-exception
            java.lang.String r13 = "BaseLoader"
            java.lang.String r0 = "getInstanceByThread()"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r12, (java.lang.String) r13, (java.lang.String) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DexFileManager.m3929a(android.content.Context, com.loc.di):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f4 A[SYNTHETIC, Splitter:B:71:0x00f4] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m3930a(android.content.Context r16, com.loc.DBOperation r17, com.loc.SDKInfo r18, java.lang.String r19, java.lang.String r20) throws java.lang.Throwable {
        /*
            r0 = r16
            r1 = r17
            r2 = 0
            r3 = 0
            java.lang.String r7 = r18.mo13272a()     // Catch:{ Throwable -> 0x00d8, all -> 0x00d3 }
            com.loc.y r4 = com.loc.LoaderFactory.m3976b()     // Catch:{ Throwable -> 0x00d8, all -> 0x00d3 }
            r5 = r18
            com.loc.y$a r10 = r4.mo13331a(r5)     // Catch:{ Throwable -> 0x00d8, all -> 0x00d3 }
            if (r10 == 0) goto L_0x002c
            boolean r4 = r10.f3440a     // Catch:{ Throwable -> 0x0028, all -> 0x0023 }
            if (r4 == 0) goto L_0x002c
            monitor-enter(r10)     // Catch:{ Throwable -> 0x0028, all -> 0x0023 }
            r10.wait()     // Catch:{ all -> 0x0020 }
            monitor-exit(r10)     // Catch:{ all -> 0x0020 }
            goto L_0x002c
        L_0x0020:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ Throwable -> 0x0028, all -> 0x0023 }
            throw r0     // Catch:{ Throwable -> 0x0028, all -> 0x0023 }
        L_0x0023:
            r0 = move-exception
            r1 = r0
            r11 = r2
            goto L_0x00e0
        L_0x0028:
            r0 = move-exception
            r12 = r2
            goto L_0x00db
        L_0x002c:
            r4 = 1
            r10.f3441b = r4     // Catch:{ Throwable -> 0x0028, all -> 0x0023 }
            java.lang.String r4 = r18.mo13274b()     // Catch:{ Throwable -> 0x0028, all -> 0x0023 }
            java.lang.String r6 = m3927a((android.content.Context) r0, (java.lang.String) r7, (java.lang.String) r4)     // Catch:{ Throwable -> 0x0028, all -> 0x0023 }
            m3931a((android.content.Context) r0, (com.loc.DBOperation) r1, (java.lang.String) r6)     // Catch:{ Throwable -> 0x0028, all -> 0x0023 }
            java.io.File r4 = new java.io.File     // Catch:{ Throwable -> 0x0028, all -> 0x0023 }
            r8 = r19
            r4.<init>(r8)     // Catch:{ Throwable -> 0x0028, all -> 0x0023 }
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0028, all -> 0x0023 }
            r11.<init>(r4)     // Catch:{ Throwable -> 0x0028, all -> 0x0023 }
            r4 = 32
            byte[] r4 = new byte[r4]     // Catch:{ Throwable -> 0x00cf, all -> 0x00cc }
            r11.read(r4)     // Catch:{ Throwable -> 0x00cf, all -> 0x00cc }
            java.io.File r4 = new java.io.File     // Catch:{ Throwable -> 0x00cf, all -> 0x00cc }
            java.lang.String r8 = r18.mo13274b()     // Catch:{ Throwable -> 0x00cf, all -> 0x00cc }
            java.lang.String r0 = m3934b((android.content.Context) r0, (java.lang.String) r7, (java.lang.String) r8)     // Catch:{ Throwable -> 0x00cf, all -> 0x00cc }
            r4.<init>(r0)     // Catch:{ Throwable -> 0x00cf, all -> 0x00cc }
            java.io.RandomAccessFile r12 = new java.io.RandomAccessFile     // Catch:{ Throwable -> 0x00cf, all -> 0x00cc }
            java.lang.String r0 = "rw"
            r12.<init>(r4, r0)     // Catch:{ Throwable -> 0x00cf, all -> 0x00cc }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r0]     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            r8 = 0
        L_0x0066:
            int r9 = r11.read(r2)     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            if (r9 <= 0) goto L_0x0084
            if (r9 != r0) goto L_0x0076
            long r13 = (long) r8     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            r12.seek(r13)     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            r12.write(r2)     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            goto L_0x0082
        L_0x0076:
            byte[] r13 = new byte[r9]     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            java.lang.System.arraycopy(r2, r3, r13, r3, r9)     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            long r14 = (long) r8     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            r12.seek(r14)     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            r12.write(r13)     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
        L_0x0082:
            int r8 = r8 + r9
            goto L_0x0066
        L_0x0084:
            java.lang.String r0 = r4.getAbsolutePath()     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            java.lang.String r0 = com.loc.MD5.m3759a((java.lang.String) r0)     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            com.loc.w$a r2 = new com.loc.w$a     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            java.lang.String r8 = r18.mo13274b()     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            r4 = r2
            r5 = r6
            r6 = r0
            r9 = r20
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            java.lang.String r0 = "used"
            com.loc.w$a r0 = r2.mo13327a((java.lang.String) r0)     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            com.loc.w r0 = r0.mo13328a()     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            java.lang.String r2 = r0.mo13320a()     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            java.lang.String r2 = com.loc.DynamicPlugin.m3948b(r2)     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            r1.mo13301a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00ca, all -> 0x00c7 }
            com.loc.C1120z.m3982a((java.io.Closeable) r11)     // Catch:{ Throwable -> 0x00b3 }
            goto L_0x00b8
        L_0x00b3:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x00b8:
            com.loc.C1120z.m3982a((java.io.Closeable) r12)     // Catch:{ Throwable -> 0x00bc }
            goto L_0x00c1
        L_0x00bc:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x00c1:
            if (r10 == 0) goto L_0x00c6
            r10.f3441b = r3     // Catch:{ Throwable -> 0x00c6 }
        L_0x00c6:
            return
        L_0x00c7:
            r0 = move-exception
            r1 = r0
            goto L_0x00df
        L_0x00ca:
            r0 = move-exception
            goto L_0x00d1
        L_0x00cc:
            r0 = move-exception
            r1 = r0
            goto L_0x00e0
        L_0x00cf:
            r0 = move-exception
            r12 = r2
        L_0x00d1:
            r2 = r11
            goto L_0x00db
        L_0x00d3:
            r0 = move-exception
            r1 = r0
            r10 = r2
            r11 = r10
            goto L_0x00e0
        L_0x00d8:
            r0 = move-exception
            r10 = r2
            r12 = r10
        L_0x00db:
            throw r0     // Catch:{ all -> 0x00dc }
        L_0x00dc:
            r0 = move-exception
            r1 = r0
            r11 = r2
        L_0x00df:
            r2 = r12
        L_0x00e0:
            com.loc.C1120z.m3982a((java.io.Closeable) r11)     // Catch:{ Throwable -> 0x00e4 }
            goto L_0x00e9
        L_0x00e4:
            r0 = move-exception
            r4 = r0
            r4.printStackTrace()
        L_0x00e9:
            com.loc.C1120z.m3982a((java.io.Closeable) r2)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00f2
        L_0x00ed:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x00f2:
            if (r10 == 0) goto L_0x00f6
            r10.f3441b = r3     // Catch:{ Throwable -> 0x00f6 }
        L_0x00f6:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DexFileManager.m3930a(android.content.Context, com.loc.n, com.loc.di, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    static void m3931a(Context context, DBOperation nVar, String str) {
        m3937c(context, nVar, m3928a(str));
        m3937c(context, nVar, str);
    }

    /* renamed from: a */
    static void m3932a(Context context, File file, SDKInfo diVar) {
        File parentFile = file.getParentFile();
        if (!file.exists() && parentFile != null && parentFile.exists()) {
            m3938c(context, diVar.mo13272a(), diVar.mo13274b());
        }
    }

    /* renamed from: a */
    static void m3933a(DBOperation nVar, Context context, String str) {
        List<DynamicPlugin> a = C1115a.m3940a(nVar, str, "used");
        if (a != null && a.size() > 0) {
            for (DynamicPlugin next : a) {
                if (next != null && next.mo13322c().equals(str)) {
                    m3931a(context, nVar, next.mo13320a());
                    List<DynamicPlugin> b = nVar.mo13304b(DynamicPlugin.m3946a(str, next.mo13325e()), DynamicPlugin.class);
                    if (b != null && b.size() > 0) {
                        DynamicPlugin wVar = b.get(0);
                        wVar.mo13323c("errorstatus");
                        nVar.mo13301a((Object) wVar, DynamicPlugin.m3948b(wVar.mo13320a()));
                        File file = new File(m3926a(context, wVar.mo13320a()));
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    static String m3934b(Context context, String str, String str2) {
        return m3926a(context, m3927a(context, str, str2));
    }

    /* renamed from: b */
    static void m3936b(Context context, String str) {
        DBOperation nVar = new DBOperation(context, DynamicFileDBCreator.m3942b());
        List<DynamicPlugin> a = C1115a.m3940a(nVar, str, "copy");
        C1120z.m3983a(a);
        if (a != null) {
            if (a.size() > 1) {
                int size = a.size();
                for (int i = 1; i < size; i++) {
                    m3937c(context, nVar, a.get(i).mo13320a());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m3937c(Context context, DBOperation nVar, String str) {
        File file = new File(m3926a(context, str));
        if (file.exists()) {
            file.delete();
        }
        nVar.mo13302a(DynamicPlugin.m3948b(str), DynamicPlugin.class);
    }

    /* renamed from: c */
    private static void m3938c(final Context context, final String str, final String str2) {
        try {
            LoaderFactory.m3976b().mo13332a().submit(new Runnable() {
                public final void run() {
                    try {
                        DBOperation nVar = new DBOperation(context, DynamicFileDBCreator.m3942b());
                        List<DynamicPlugin> b = nVar.mo13304b(DynamicPlugin.m3945a(str), DynamicPlugin.class);
                        if (b != null && b.size() > 0) {
                            for (DynamicPlugin next : b) {
                                if (!str2.equalsIgnoreCase(next.mo13324d())) {
                                    DexFileManager.m3937c(context, nVar, next.mo13320a());
                                }
                            }
                        }
                    } catch (Throwable th) {
                        BasicLogHandler.m3844a(th, "FileManager", "clearUnSuitableV");
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
