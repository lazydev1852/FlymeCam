package com.meizu.media.camera.app;

import android.annotation.TargetApi;
import android.os.StatFs;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.app.h */
public interface StorageProvider {

    /* renamed from: com.meizu.media.camera.app.h$a */
    /* compiled from: StorageProvider */
    public interface C1833a {
        /* renamed from: a */
        void mo17703a(String str, String str2);
    }

    /* renamed from: a */
    void mo18992a(C1833a aVar);

    /* renamed from: b */
    void mo18993b(C1833a aVar);

    /* renamed from: b */
    boolean mo18994b();

    /* renamed from: c */
    C1834b mo18995c();

    /* renamed from: d */
    C1834b mo18996d();

    /* renamed from: com.meizu.media.camera.app.h$b */
    /* compiled from: StorageProvider */
    public static class C1834b {

        /* renamed from: a */
        public static ChangeQuickRedirect f7954a;

        /* renamed from: b */
        String f7955b;

        /* renamed from: c */
        String f7956c;

        /* renamed from: d */
        boolean f7957d;

        /* renamed from: a */
        public String mo19033a() {
            return this.f7955b;
        }

        /* renamed from: b */
        public boolean mo19034b() {
            return this.f7957d;
        }

        /* renamed from: c */
        public boolean mo19035c() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7954a, false, 2558, new Class[0], Boolean.TYPE);
            return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : this.f7956c.equals("mounted");
        }

        @TargetApi(18)
        /* renamed from: d */
        public long mo19036d() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7954a, false, 2561, new Class[0], Long.TYPE);
            if (proxy.isSupported) {
                return ((Long) proxy.result).longValue();
            }
            if (!this.f7956c.equals("mounted")) {
                return 0;
            }
            StatFs statFs = new StatFs(this.f7955b);
            return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        }

        public String toString() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7954a, false, 2563, new Class[0], String.class);
            if (proxy.isSupported) {
                return (String) proxy.result;
            }
            return this.f7955b + " " + this.f7956c;
        }
    }
}
