package com.loc;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* renamed from: com.loc.ac */
public final class DynamicLoader extends BaseLoader {

    /* renamed from: i */
    private PublicKey f2509i = null;

    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0087 */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b4 A[SYNTHETIC, Splitter:B:47:0x00b4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    DynamicLoader(final android.content.Context r7, com.loc.SDKInfo r8) throws java.lang.Exception {
        /*
            r6 = this;
            r6.<init>(r7, r8)
            r0 = 0
            r6.f2509i = r0
            java.lang.String r1 = r8.mo13272a()
            java.lang.String r8 = r8.mo13274b()
            java.lang.String r8 = com.loc.DexFileManager.m3934b((android.content.Context) r7, (java.lang.String) r1, (java.lang.String) r8)
            java.lang.String r1 = com.loc.DexFileManager.m3924a((android.content.Context) r7)
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            if (r2 != 0) goto L_0x00c8
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x00c8
            java.io.File r2 = new java.io.File
            r2.<init>(r8)
            com.loc.y r3 = com.loc.LoaderFactory.m3976b()
            com.loc.di r4 = r6.f2504e
            com.loc.y$a r3 = r3.mo13331a(r4)
            boolean r3 = r3.f3441b
            if (r3 != 0) goto L_0x00c0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r4 = java.io.File.separator
            r3.append(r4)
            java.lang.String r2 = r2.getName()
            java.lang.String r2 = com.loc.DexFileManager.m3928a((java.lang.String) r2)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r3 = 0
            dalvik.system.DexFile r4 = r6.f2502c     // Catch:{ Throwable -> 0x00a2 }
            if (r4 == 0) goto L_0x0057
            goto L_0x0087
        L_0x0057:
            com.loc.y r4 = com.loc.LoaderFactory.m3976b()     // Catch:{ Throwable -> 0x00a2 }
            com.loc.di r5 = r6.f2504e     // Catch:{ Throwable -> 0x00a2 }
            com.loc.y$a r4 = r4.mo13331a(r5)     // Catch:{ Throwable -> 0x00a2 }
            if (r4 == 0) goto L_0x006d
            r0 = 1
            r4.f3440a = r0     // Catch:{ Throwable -> 0x006a, all -> 0x0067 }
            goto L_0x006d
        L_0x0067:
            r7 = move-exception
            r0 = r4
            goto L_0x00b2
        L_0x006a:
            r7 = move-exception
            r0 = r4
            goto L_0x00a3
        L_0x006d:
            r6.mo12964b()     // Catch:{ Throwable -> 0x006a, all -> 0x0067 }
            boolean r0 = r4.f3441b     // Catch:{ Throwable -> 0x006a, all -> 0x0067 }
            if (r0 != 0) goto L_0x0098
            dalvik.system.DexFile r0 = dalvik.system.DexFile.loadDex(r8, r2, r3)     // Catch:{ Throwable -> 0x006a, all -> 0x0067 }
            r6.f2502c = r0     // Catch:{ Throwable -> 0x006a, all -> 0x0067 }
            if (r4 == 0) goto L_0x0087
            r4.f3440a = r3     // Catch:{ Throwable -> 0x0087 }
            monitor-enter(r4)     // Catch:{ Throwable -> 0x0087 }
            r4.notify()     // Catch:{ all -> 0x0084 }
            monitor-exit(r4)     // Catch:{ all -> 0x0084 }
            goto L_0x0087
        L_0x0084:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ Throwable -> 0x0087 }
            throw r0     // Catch:{ Throwable -> 0x0087 }
        L_0x0087:
            com.loc.y r0 = com.loc.LoaderFactory.m3976b()     // Catch:{ Throwable -> 0x0097 }
            java.util.concurrent.ExecutorService r0 = r0.mo13332a()     // Catch:{ Throwable -> 0x0097 }
            com.loc.ac$1 r2 = new com.loc.ac$1     // Catch:{ Throwable -> 0x0097 }
            r2.<init>(r7, r8, r1)     // Catch:{ Throwable -> 0x0097 }
            r0.submit(r2)     // Catch:{ Throwable -> 0x0097 }
        L_0x0097:
            return
        L_0x0098:
            java.lang.Exception r7 = new java.lang.Exception     // Catch:{ Throwable -> 0x006a, all -> 0x0067 }
            java.lang.String r8 = "file is downloading"
            r7.<init>(r8)     // Catch:{ Throwable -> 0x006a, all -> 0x0067 }
            throw r7     // Catch:{ Throwable -> 0x006a, all -> 0x0067 }
        L_0x00a0:
            r7 = move-exception
            goto L_0x00b2
        L_0x00a2:
            r7 = move-exception
        L_0x00a3:
            java.lang.String r8 = "dLoader"
            java.lang.String r1 = "loadFile"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r7, (java.lang.String) r8, (java.lang.String) r1)     // Catch:{ all -> 0x00a0 }
            java.lang.Exception r7 = new java.lang.Exception     // Catch:{ all -> 0x00a0 }
            java.lang.String r8 = "load file fail"
            r7.<init>(r8)     // Catch:{ all -> 0x00a0 }
            throw r7     // Catch:{ all -> 0x00a0 }
        L_0x00b2:
            if (r0 == 0) goto L_0x00bf
            r0.f3440a = r3     // Catch:{ Throwable -> 0x00bf }
            monitor-enter(r0)     // Catch:{ Throwable -> 0x00bf }
            r0.notify()     // Catch:{ all -> 0x00bc }
            monitor-exit(r0)     // Catch:{ all -> 0x00bc }
            goto L_0x00bf
        L_0x00bc:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ Throwable -> 0x00bf }
            throw r8     // Catch:{ Throwable -> 0x00bf }
        L_0x00bf:
            throw r7
        L_0x00c0:
            java.lang.Exception r7 = new java.lang.Exception
            java.lang.String r8 = "file is downloading"
            r7.<init>(r8)
            throw r7
        L_0x00c8:
            java.lang.Exception r7 = new java.lang.Exception
            java.lang.String r8 = "dexPath or dexOutputDir is null."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DynamicLoader.<init>(android.content.Context, com.loc.di):void");
    }

    /* renamed from: a */
    private static void m2934a(JarFile jarFile, JarEntry jarEntry) throws IOException {
        InputStream inputStream = null;
        try {
            InputStream inputStream2 = jarFile.getInputStream(jarEntry);
            try {
                do {
                } while (inputStream2.read(new byte[8192]) > 0);
                try {
                    C1120z.m3982a((Closeable) inputStream2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStream2;
                C1120z.m3982a((Closeable) inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            BasicLogHandler.m3844a(th, "DyLoader", "loadJa");
            C1120z.m3982a((Closeable) inputStream);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0044 A[SYNTHETIC, Splitter:B:37:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x004a A[SYNTHETIC, Splitter:B:42:0x004a] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m2935a(java.io.File r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.security.PublicKey r2 = r4.f2509i     // Catch:{ Throwable -> 0x003a }
            if (r2 != 0) goto L_0x000c
            java.security.PublicKey r2 = com.loc.C1120z.m3981a()     // Catch:{ Throwable -> 0x003a }
            r4.f2509i = r2     // Catch:{ Throwable -> 0x003a }
        L_0x000c:
            java.util.jar.JarFile r2 = new java.util.jar.JarFile     // Catch:{ Throwable -> 0x003a }
            r2.<init>(r5)     // Catch:{ Throwable -> 0x003a }
            java.lang.String r5 = "classes.dex"
            java.util.jar.JarEntry r5 = r2.getJarEntry(r5)     // Catch:{ Throwable -> 0x0035, all -> 0x0032 }
            if (r5 != 0) goto L_0x001d
            r2.close()     // Catch:{ Throwable -> 0x001c }
        L_0x001c:
            return r0
        L_0x001d:
            m2934a(r2, r5)     // Catch:{ Throwable -> 0x0035, all -> 0x0032 }
            java.security.cert.Certificate[] r5 = r5.getCertificates()     // Catch:{ Throwable -> 0x0035, all -> 0x0032 }
            if (r5 != 0) goto L_0x002a
            r2.close()     // Catch:{ Throwable -> 0x0029 }
        L_0x0029:
            return r0
        L_0x002a:
            boolean r5 = r4.m2936a((java.security.cert.Certificate[]) r5)     // Catch:{ Throwable -> 0x0035, all -> 0x0032 }
            r2.close()     // Catch:{ Throwable -> 0x0031 }
        L_0x0031:
            return r5
        L_0x0032:
            r5 = move-exception
            r1 = r2
            goto L_0x0048
        L_0x0035:
            r5 = move-exception
            r1 = r2
            goto L_0x003b
        L_0x0038:
            r5 = move-exception
            goto L_0x0048
        L_0x003a:
            r5 = move-exception
        L_0x003b:
            java.lang.String r2 = "DyLoader"
            java.lang.String r3 = "verify"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r5, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x0047
            r1.close()     // Catch:{ Throwable -> 0x0047 }
        L_0x0047:
            return r0
        L_0x0048:
            if (r1 == 0) goto L_0x004d
            r1.close()     // Catch:{ Throwable -> 0x004d }
        L_0x004d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DynamicLoader.m2935a(java.io.File):boolean");
    }

    /* renamed from: a */
    private boolean m2936a(Certificate[] certificateArr) {
        int length;
        try {
            if (certificateArr.length <= 0 || (length = certificateArr.length - 1) < 0) {
                return false;
            }
            certificateArr[length].verify(this.f2509i);
            return true;
        } catch (Exception e) {
            BasicLogHandler.m3844a((Throwable) e, "DyLoader", "check");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f0 A[Catch:{ Throwable -> 0x00f8 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo12968a(android.content.Context r11, java.lang.String r12, java.lang.String r13) throws java.lang.Exception {
        /*
            r10 = this;
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            r0.getTime()
            com.loc.n r0 = new com.loc.n     // Catch:{ Throwable -> 0x00f8 }
            com.loc.v r1 = com.loc.DynamicFileDBCreator.m3942b()     // Catch:{ Throwable -> 0x00f8 }
            r0.<init>(r11, r1)     // Catch:{ Throwable -> 0x00f8 }
            java.io.File r11 = new java.io.File     // Catch:{ Throwable -> 0x00f8 }
            r11.<init>(r12)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r12 = r11.getName()     // Catch:{ Throwable -> 0x00f8 }
            com.loc.w r12 = com.loc.DexFileManager.C1115a.m3939a(r0, r12)     // Catch:{ Throwable -> 0x00f8 }
            if (r12 == 0) goto L_0x0026
            java.lang.String r12 = r12.mo13325e()     // Catch:{ Throwable -> 0x00f8 }
            r10.f2505f = r12     // Catch:{ Throwable -> 0x00f8 }
        L_0x0026:
            com.loc.di r12 = r10.f2504e     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r1 = r11.getAbsolutePath()     // Catch:{ Throwable -> 0x00f8 }
            java.io.File r2 = new java.io.File     // Catch:{ Throwable -> 0x00f8 }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x00f8 }
            boolean r2 = r10.m2935a((java.io.File) r2)     // Catch:{ Throwable -> 0x00f8 }
            r3 = 0
            if (r2 == 0) goto L_0x004b
            android.content.Context r2 = r10.f2500a     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r4 = r12.mo13272a()     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r5 = r12.mo13274b()     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r2 = com.loc.DexFileManager.m3927a((android.content.Context) r2, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ Throwable -> 0x00f8 }
            boolean r12 = com.loc.C1120z.m3989a(r0, r2, r1, r12)     // Catch:{ Throwable -> 0x00f8 }
            goto L_0x004c
        L_0x004b:
            r12 = 0
        L_0x004c:
            if (r12 != 0) goto L_0x0070
            r10.f2503d = r3     // Catch:{ Throwable -> 0x00f8 }
            android.content.Context r12 = r10.f2500a     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r1 = r11.getName()     // Catch:{ Throwable -> 0x00f8 }
            com.loc.DexFileManager.m3931a((android.content.Context) r12, (com.loc.DBOperation) r0, (java.lang.String) r1)     // Catch:{ Throwable -> 0x00f8 }
            android.content.Context r12 = r10.f2500a     // Catch:{ Throwable -> 0x00f8 }
            com.loc.di r1 = r10.f2504e     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r12 = com.loc.DexFileManager.m3925a((android.content.Context) r12, (com.loc.DBOperation) r0, (com.loc.SDKInfo) r1)     // Catch:{ Throwable -> 0x00f8 }
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Throwable -> 0x00f8 }
            if (r1 != 0) goto L_0x0070
            r10.f2505f = r12     // Catch:{ Throwable -> 0x00f8 }
            android.content.Context r12 = r10.f2500a     // Catch:{ Throwable -> 0x00f8 }
            com.loc.di r1 = r10.f2504e     // Catch:{ Throwable -> 0x00f8 }
            com.loc.DexFileManager.m3929a((android.content.Context) r12, (com.loc.SDKInfo) r1)     // Catch:{ Throwable -> 0x00f8 }
        L_0x0070:
            boolean r12 = r11.exists()     // Catch:{ Throwable -> 0x00f8 }
            if (r12 != 0) goto L_0x0077
            return
        L_0x0077:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00f8 }
            r12.<init>()     // Catch:{ Throwable -> 0x00f8 }
            r12.append(r13)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r13 = java.io.File.separator     // Catch:{ Throwable -> 0x00f8 }
            r12.append(r13)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r13 = r11.getName()     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r13 = com.loc.DexFileManager.m3928a((java.lang.String) r13)     // Catch:{ Throwable -> 0x00f8 }
            r12.append(r13)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r12 = r12.toString()     // Catch:{ Throwable -> 0x00f8 }
            java.io.File r13 = new java.io.File     // Catch:{ Throwable -> 0x00f8 }
            r13.<init>(r12)     // Catch:{ Throwable -> 0x00f8 }
            boolean r12 = r13.exists()     // Catch:{ Throwable -> 0x00f8 }
            if (r12 == 0) goto L_0x0100
            java.lang.String r11 = r11.getName()     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r11 = com.loc.DexFileManager.m3928a((java.lang.String) r11)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r9 = r10.f2505f     // Catch:{ Throwable -> 0x00f8 }
            android.content.Context r12 = r10.f2500a     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r12 = com.loc.DexFileManager.m3926a((android.content.Context) r12, (java.lang.String) r11)     // Catch:{ Throwable -> 0x00f8 }
            com.loc.di r13 = r10.f2504e     // Catch:{ Throwable -> 0x00f8 }
            boolean r13 = com.loc.C1120z.m3989a(r0, r11, r12, r13)     // Catch:{ Throwable -> 0x00f8 }
            if (r13 != 0) goto L_0x00ed
            com.loc.w r13 = com.loc.DexFileManager.C1115a.m3939a(r0, r11)     // Catch:{ Throwable -> 0x00f8 }
            if (r13 == 0) goto L_0x00bd
            goto L_0x00ee
        L_0x00bd:
            java.lang.String r13 = r10.f2505f     // Catch:{ Throwable -> 0x00f8 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Throwable -> 0x00f8 }
            if (r13 != 0) goto L_0x00ed
            com.loc.w$a r13 = new com.loc.w$a     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r6 = com.loc.MD5.m3759a((java.lang.String) r12)     // Catch:{ Throwable -> 0x00f8 }
            com.loc.di r12 = r10.f2504e     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r7 = r12.mo13272a()     // Catch:{ Throwable -> 0x00f8 }
            com.loc.di r12 = r10.f2504e     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r8 = r12.mo13274b()     // Catch:{ Throwable -> 0x00f8 }
            r4 = r13
            r5 = r11
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r12 = "useod"
            com.loc.w$a r12 = r13.mo13327a((java.lang.String) r12)     // Catch:{ Throwable -> 0x00f8 }
            com.loc.w r12 = r12.mo13328a()     // Catch:{ Throwable -> 0x00f8 }
            java.lang.String r11 = com.loc.DynamicPlugin.m3948b(r11)     // Catch:{ Throwable -> 0x00f8 }
            r0.mo13301a((java.lang.Object) r12, (java.lang.String) r11)     // Catch:{ Throwable -> 0x00f8 }
        L_0x00ed:
            r3 = 1
        L_0x00ee:
            if (r3 != 0) goto L_0x0100
            android.content.Context r11 = r10.f2500a     // Catch:{ Throwable -> 0x00f8 }
            com.loc.di r12 = r10.f2504e     // Catch:{ Throwable -> 0x00f8 }
            com.loc.DexFileManager.m3929a((android.content.Context) r11, (com.loc.SDKInfo) r12)     // Catch:{ Throwable -> 0x00f8 }
            goto L_0x0100
        L_0x00f8:
            r11 = move-exception
            java.lang.String r12 = "dLoader"
            java.lang.String r13 = "verifyD()"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r11, (java.lang.String) r12, (java.lang.String) r13)
        L_0x0100:
            java.util.Date r11 = new java.util.Date
            r11.<init>()
            r11.getTime()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DynamicLoader.mo12968a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0070, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0072, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        com.loc.BasicLogHandler.m3844a(r1, "dLoader", "findCl");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x007f, code lost:
        throw new java.lang.ClassNotFoundException(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0080, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0081, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0082, code lost:
        r6.f2507h = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0084, code lost:
        throw r7;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0080 A[Catch:{ all -> 0x0070 }, ExcHandler: ClassNotFoundException (r7v1 'e' java.lang.ClassNotFoundException A[CUSTOM_DECLARE, Catch:{  }])] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Class<?> findClass(java.lang.String r7) throws java.lang.ClassNotFoundException {
        /*
            r6 = this;
            r0 = 0
            dalvik.system.DexFile r1 = r6.f2502c     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
            if (r1 == 0) goto L_0x006a
            r1 = 0
            java.util.Map r2 = r6.f2501b     // Catch:{ Throwable -> 0x001b, ClassNotFoundException -> 0x0080 }
            monitor-enter(r2)     // Catch:{ Throwable -> 0x001b, ClassNotFoundException -> 0x0080 }
            java.util.Map r3 = r6.f2501b     // Catch:{ all -> 0x0018 }
            java.lang.Object r3 = r3.get(r7)     // Catch:{ all -> 0x0018 }
            java.lang.Class r3 = (java.lang.Class) r3     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
            goto L_0x0024
        L_0x0013:
            r1 = move-exception
            r5 = r3
            r3 = r1
            r1 = r5
            goto L_0x0019
        L_0x0018:
            r3 = move-exception
        L_0x0019:
            monitor-exit(r2)     // Catch:{ Throwable -> 0x001b, ClassNotFoundException -> 0x0080 }
            throw r3     // Catch:{ Throwable -> 0x001b, ClassNotFoundException -> 0x0080 }
        L_0x001b:
            r2 = move-exception
            r3 = r1
            java.lang.String r1 = "dLoader"
            java.lang.String r4 = "findCl"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r2, (java.lang.String) r1, (java.lang.String) r4)     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        L_0x0024:
            if (r3 == 0) goto L_0x0029
            r6.f2507h = r0
            return r3
        L_0x0029:
            boolean r1 = r6.f2506g     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
            if (r1 != 0) goto L_0x0064
            r1 = 1
            r6.f2507h = r1     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
            dalvik.system.DexFile r1 = r6.f2502c     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
            java.lang.Class r1 = r1.loadClass(r7, r6)     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
            dalvik.system.DexFile r2 = r6.f2502c     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
            monitor-enter(r2)     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
            dalvik.system.DexFile r3 = r6.f2502c     // Catch:{ all -> 0x0061 }
            r3.notify()     // Catch:{ all -> 0x0061 }
            monitor-exit(r2)     // Catch:{ all -> 0x0061 }
            r6.f2507h = r0     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
            if (r1 == 0) goto L_0x005b
            java.util.Map r2 = r6.f2501b     // Catch:{ Throwable -> 0x0050, ClassNotFoundException -> 0x0080 }
            monitor-enter(r2)     // Catch:{ Throwable -> 0x0050, ClassNotFoundException -> 0x0080 }
            java.util.Map r3 = r6.f2501b     // Catch:{ all -> 0x004d }
            r3.put(r7, r1)     // Catch:{ all -> 0x004d }
            monitor-exit(r2)     // Catch:{ all -> 0x004d }
            goto L_0x0058
        L_0x004d:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ Throwable -> 0x0050, ClassNotFoundException -> 0x0080 }
            throw r3     // Catch:{ Throwable -> 0x0050, ClassNotFoundException -> 0x0080 }
        L_0x0050:
            r2 = move-exception
            java.lang.String r3 = "dLoader"
            java.lang.String r4 = "findCl"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        L_0x0058:
            r6.f2507h = r0
            return r1
        L_0x005b:
            java.lang.ClassNotFoundException r1 = new java.lang.ClassNotFoundException     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
            r1.<init>(r7)     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        L_0x0061:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        L_0x0064:
            java.lang.ClassNotFoundException r1 = new java.lang.ClassNotFoundException     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
            r1.<init>(r7)     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        L_0x006a:
            java.lang.ClassNotFoundException r1 = new java.lang.ClassNotFoundException     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
            r1.<init>(r7)     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x0080, Throwable -> 0x0072 }
        L_0x0070:
            r7 = move-exception
            goto L_0x0082
        L_0x0072:
            r1 = move-exception
            java.lang.String r2 = "dLoader"
            java.lang.String r3 = "findCl"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0070 }
            java.lang.ClassNotFoundException r1 = new java.lang.ClassNotFoundException     // Catch:{ all -> 0x0070 }
            r1.<init>(r7)     // Catch:{ all -> 0x0070 }
            throw r1     // Catch:{ all -> 0x0070 }
        L_0x0080:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0070 }
        L_0x0082:
            r6.f2507h = r0
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.DynamicLoader.findClass(java.lang.String):java.lang.Class");
    }
}
