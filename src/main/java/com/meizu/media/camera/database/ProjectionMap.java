package com.meizu.media.camera.database;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.media.camera.database.c */
public class ProjectionMap extends HashMap<String, String> {

    /* renamed from: a */
    public static ChangeQuickRedirect f9498a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String[] f9499b;

    /* renamed from: com.meizu.media.camera.database.c$a */
    /* compiled from: ProjectionMap */
    public static class C2038a {

        /* renamed from: a */
        public static ChangeQuickRedirect f9500a;

        /* renamed from: b */
        private ProjectionMap f9501b = new ProjectionMap();

        /* renamed from: a */
        public C2038a mo19974a(String str) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f9500a, false, 3437, new Class[]{String.class}, C2038a.class);
            if (proxy.isSupported) {
                return (C2038a) proxy.result;
            }
            this.f9501b.m9990b(str, str);
            return this;
        }

        /* renamed from: a */
        public ProjectionMap mo19975a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9500a, false, 3441, new Class[0], ProjectionMap.class);
            if (proxy.isSupported) {
                return (ProjectionMap) proxy.result;
            }
            String[] strArr = new String[this.f9501b.size()];
            this.f9501b.keySet().toArray(strArr);
            Arrays.sort(strArr);
            String[] unused = this.f9501b.f9499b = strArr;
            return this.f9501b;
        }
    }

    /* renamed from: a */
    public static C2038a m9987a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f9498a, true, 3433, new Class[0], C2038a.class);
        return proxy.isSupported ? (C2038a) proxy.result : new C2038a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9990b(String str, String str2) {
        Class[] clsArr = {String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2}, this, f9498a, false, 3434, clsArr, Void.TYPE).isSupported) {
            super.put(str, str2);
        }
    }

    /* renamed from: a */
    public String put(String str, String str2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, str2}, this, f9498a, false, 3435, new Class[]{String.class, String.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        throw new UnsupportedOperationException();
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        if (!PatchProxy.proxy(new Object[]{map}, this, f9498a, false, 3436, new Class[]{Map.class}, Void.TYPE).isSupported) {
            throw new UnsupportedOperationException();
        }
    }
}
