package com.loc;

import android.content.Context;
import dalvik.system.DexFile;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.loc.aa */
public abstract class BaseLoader extends ClassLoader {

    /* renamed from: a */
    protected final Context f2500a;

    /* renamed from: b */
    protected final Map<String, Class<?>> f2501b = new HashMap();

    /* renamed from: c */
    protected DexFile f2502c = null;

    /* renamed from: d */
    volatile boolean f2503d = true;

    /* renamed from: e */
    protected SDKInfo f2504e;

    /* renamed from: f */
    protected String f2505f;

    /* renamed from: g */
    protected volatile boolean f2506g = false;

    /* renamed from: h */
    protected volatile boolean f2507h = false;

    public BaseLoader(Context context, SDKInfo diVar) {
        super(context.getClassLoader());
        this.f2500a = context;
        this.f2504e = diVar;
    }

    /* renamed from: a */
    public final boolean mo12963a() {
        return this.f2502c != null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002b, code lost:
        com.loc.BasicLogHandler.m3844a(r0, "BaseLoader", "releaseDexFile()");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo12964b() {
        /*
            r3 = this;
            java.util.Map<java.lang.String, java.lang.Class<?>> r0 = r3.f2501b     // Catch:{ Throwable -> 0x002a }
            monitor-enter(r0)     // Catch:{ Throwable -> 0x002a }
            java.util.Map<java.lang.String, java.lang.Class<?>> r1 = r3.f2501b     // Catch:{ all -> 0x0027 }
            r1.clear()     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            dalvik.system.DexFile r0 = r3.f2502c     // Catch:{ Throwable -> 0x002a }
            if (r0 == 0) goto L_0x0026
            boolean r0 = r3.f2507h     // Catch:{ Throwable -> 0x002a }
            if (r0 == 0) goto L_0x001e
            dalvik.system.DexFile r0 = r3.f2502c     // Catch:{ Throwable -> 0x002a }
            monitor-enter(r0)     // Catch:{ Throwable -> 0x002a }
            dalvik.system.DexFile r1 = r3.f2502c     // Catch:{ all -> 0x001b }
            r1.wait()     // Catch:{ all -> 0x001b }
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            goto L_0x001e
        L_0x001b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ Throwable -> 0x002a }
            throw r1     // Catch:{ Throwable -> 0x002a }
        L_0x001e:
            r0 = 1
            r3.f2506g = r0     // Catch:{ Throwable -> 0x002a }
            dalvik.system.DexFile r0 = r3.f2502c     // Catch:{ Throwable -> 0x002a }
            r0.close()     // Catch:{ Throwable -> 0x002a }
        L_0x0026:
            return
        L_0x0027:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ Throwable -> 0x002a }
            throw r1     // Catch:{ Throwable -> 0x002a }
        L_0x002a:
            r0 = move-exception
            java.lang.String r1 = "BaseLoader"
            java.lang.String r2 = "releaseDexFile()"
            com.loc.BasicLogHandler.m3844a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.BaseLoader.mo12964b():void");
    }
}
