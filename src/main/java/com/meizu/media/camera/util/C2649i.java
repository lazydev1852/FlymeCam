package com.meizu.media.camera.util;

import com.meizu.media.camera.CameraActivity;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.meizu.media.camera.util.i */
/* compiled from: ByteArrayPool */
public class C2649i {

    /* renamed from: a */
    public static ChangeQuickRedirect f14246a;

    /* renamed from: b */
    private static C2649i f14247b;

    /* renamed from: c */
    private static int f14248c;

    /* renamed from: d */
    private static int f14249d;

    /* renamed from: e */
    private static String f14250e;

    /* renamed from: f */
    private int f14251f;

    /* renamed from: g */
    private List<BurstData> f14252g = new ArrayList();

    public C2649i(int i) {
        this.f14251f = i;
        f14248c = 0;
    }

    /* renamed from: a */
    public static void m16155a(CameraActivity cameraActivity) {
        if (!PatchProxy.proxy(new Object[]{cameraActivity}, (Object) null, f14246a, true, 7797, new Class[]{CameraActivity.class}, Void.TYPE).isSupported) {
            String path = cameraActivity.getCacheDir().getPath();
            File file = new File(path + "/burstCache");
            if (file.mkdir() || file.isDirectory()) {
                f14250e = file.getPath();
            }
        }
    }

    /* renamed from: a */
    public static void m16154a() {
        String[] list;
        if (!PatchProxy.proxy(new Object[0], (Object) null, f14246a, true, 7798, new Class[0], Void.TYPE).isSupported) {
            File file = new File(f14250e);
            if (file.isDirectory() && (list = file.list()) != null) {
                for (String file2 : list) {
                    new File(file, file2).delete();
                }
            }
        }
    }

    /* renamed from: a */
    public static C2649i m16153a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14246a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 7799, new Class[]{Integer.TYPE}, C2649i.class);
        if (proxy.isSupported) {
            return (C2649i) proxy.result;
        }
        if (f14247b == null) {
            C2649i iVar = new C2649i(i);
            f14247b = iVar;
            return iVar;
        }
        if (f14247b.f14251f != i) {
            f14247b.m16159f();
            f14247b.f14251f = i;
        }
        return f14247b;
    }

    @NotNull
    /* renamed from: b */
    public synchronized BurstData mo22732b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14246a, false, 7800, new Class[0], BurstData.class);
        if (proxy.isSupported) {
            return (BurstData) proxy.result;
        } else if (f14248c >= 314572800) {
            return new BurstData((byte[]) null, true, f14250e + "/" + System.currentTimeMillis(), this.f14251f);
        } else if (this.f14252g.size() > 0) {
            f14249d -= this.f14251f;
            return this.f14252g.remove(0);
        } else {
            f14248c += this.f14251f;
            return new BurstData(new byte[this.f14251f], false, (String) null, this.f14251f);
        }
    }

    @NotNull
    /* renamed from: c */
    public synchronized byte[] mo22733c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14246a, false, 7801, new Class[0], byte[].class);
        if (proxy.isSupported) {
            return (byte[]) proxy.result;
        } else if (f14248c >= 314572800) {
            return new byte[this.f14251f];
        } else if (this.f14252g.size() > 0) {
            f14249d -= this.f14251f;
            return this.f14252g.remove(0).mo22728a();
        } else {
            f14248c += this.f14251f;
            return new byte[this.f14251f];
        }
    }

    /* renamed from: a */
    public static synchronized void m16156a(byte[] bArr, BurstData hVar) {
        synchronized (C2649i.class) {
            if (!PatchProxy.proxy(new Object[]{bArr, hVar}, (Object) null, f14246a, true, 7802, new Class[]{byte[].class, BurstData.class}, Void.TYPE).isSupported) {
                if (hVar.mo22729b() && hVar.mo22730c() != null) {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(hVar.mo22730c());
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo22731a(byte[] r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0043 }
            r8 = 0
            r1[r8] = r10     // Catch:{ all -> 0x0043 }
            com.meizu.savior.ChangeQuickRedirect r3 = f14246a     // Catch:{ all -> 0x0043 }
            r4 = 0
            r5 = 7803(0x1e7b, float:1.0934E-41)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0043 }
            java.lang.Class<byte[]> r0 = byte[].class
            r6[r8] = r0     // Catch:{ all -> 0x0043 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0043 }
            r2 = r9
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0043 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x001f
            monitor-exit(r9)
            return
        L_0x001f:
            int r0 = f14248c     // Catch:{ all -> 0x0043 }
            r1 = 314572800(0x12c00000, float:1.21169035E-27)
            if (r0 > r1) goto L_0x003a
            java.util.List<com.meizu.media.camera.util.h> r0 = r9.f14252g     // Catch:{ all -> 0x0043 }
            com.meizu.media.camera.util.h r1 = new com.meizu.media.camera.util.h     // Catch:{ all -> 0x0043 }
            r2 = 0
            int r3 = r9.f14251f     // Catch:{ all -> 0x0043 }
            r1.<init>(r10, r8, r2, r3)     // Catch:{ all -> 0x0043 }
            r0.add(r1)     // Catch:{ all -> 0x0043 }
            int r10 = f14249d     // Catch:{ all -> 0x0043 }
            int r0 = r9.f14251f     // Catch:{ all -> 0x0043 }
            int r10 = r10 + r0
            f14249d = r10     // Catch:{ all -> 0x0043 }
            goto L_0x0041
        L_0x003a:
            int r10 = f14248c     // Catch:{ all -> 0x0043 }
            int r0 = r9.f14251f     // Catch:{ all -> 0x0043 }
            int r10 = r10 - r0
            f14248c = r10     // Catch:{ all -> 0x0043 }
        L_0x0041:
            monitor-exit(r9)
            return
        L_0x0043:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.C2649i.mo22731a(byte[]):void");
    }

    /* renamed from: f */
    private void m16159f() {
        if (!PatchProxy.proxy(new Object[0], this, f14246a, false, 7804, new Class[0], Void.TYPE).isSupported) {
            this.f14252g.clear();
            f14248c = 0;
            f14249d = 0;
        }
    }

    /* renamed from: d */
    public static void m16157d() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, f14246a, true, 7805, new Class[0], Void.TYPE).isSupported && f14247b != null) {
            f14247b.m16159f();
            m16154a();
            f14247b = null;
        }
    }

    /* renamed from: e */
    public static boolean m16158e() {
        if (f14249d <= 0 || 314572800 - f14248c >= 104857600 || f14248c - f14249d < 104857600) {
            return true;
        }
        return false;
    }
}
