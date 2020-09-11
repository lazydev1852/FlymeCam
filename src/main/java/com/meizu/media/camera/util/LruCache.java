package com.meizu.media.camera.util;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.meizu.media.camera.util.ad */
public class LruCache<K, V> {

    /* renamed from: a */
    public static ChangeQuickRedirect f14076a;

    /* renamed from: b */
    protected final HashMap<K, V> f14077b;

    /* renamed from: c */
    private final HashMap<K, C2632a<K, V>> f14078c = new HashMap<>();

    /* renamed from: d */
    private ReferenceQueue<V> f14079d = new ReferenceQueue<>();

    public LruCache(int i) {
        final int i2 = i;
        this.f14077b = new LinkedHashMap<K, V>(16, 0.75f, true) {

            /* renamed from: a */
            public static ChangeQuickRedirect f14080a;

            public boolean removeEldestEntry(Map.Entry<K, V> entry) {
                PatchProxyResult proxy = PatchProxy.proxy(new Object[]{entry}, this, f14080a, false, 8135, new Class[]{Map.Entry.class}, Boolean.TYPE);
                if (proxy.isSupported) {
                    return ((Boolean) proxy.result).booleanValue();
                }
                return LruCache.this.mo22659a() > i2;
            }
        };
    }

    /* renamed from: a */
    public int mo22659a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14076a, false, 8129, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f14077b.size();
    }

    /* renamed from: b */
    private void m15957b() {
        if (!PatchProxy.proxy(new Object[0], this, f14076a, false, 8130, new Class[0], Void.TYPE).isSupported) {
            C2632a aVar = (C2632a) this.f14079d.poll();
            while (aVar != null) {
                this.f14078c.remove(aVar.f14083a);
                aVar = (C2632a) this.f14079d.poll();
            }
        }
    }

    /* renamed from: a */
    public synchronized boolean mo22661a(K k) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{k}, this, f14076a, false, 8131, new Class[]{Object.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        m15957b();
        return this.f14078c.containsKey(k);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
        return r9;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized V mo22660a(K r9, V r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x004f }
            r2 = 0
            r1[r2] = r9     // Catch:{ all -> 0x004f }
            r3 = 1
            r1[r3] = r10     // Catch:{ all -> 0x004f }
            com.meizu.savior.ChangeQuickRedirect r4 = f14076a     // Catch:{ all -> 0x004f }
            r5 = 0
            r6 = 8132(0x1fc4, float:1.1395E-41)
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x004f }
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            r0[r2] = r7     // Catch:{ all -> 0x004f }
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            r0[r3] = r2     // Catch:{ all -> 0x004f }
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            r2 = r8
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x004f }
            boolean r1 = r0.isSupported     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x002e
            java.lang.Object r9 = r0.result     // Catch:{ all -> 0x004f }
            java.lang.Object r9 = (java.lang.Object) r9     // Catch:{ all -> 0x004f }
            monitor-exit(r8)
            return r9
        L_0x002e:
            r8.m15957b()     // Catch:{ all -> 0x004f }
            java.util.HashMap<K, V> r0 = r8.f14077b     // Catch:{ all -> 0x004f }
            r0.put(r9, r10)     // Catch:{ all -> 0x004f }
            java.util.HashMap<K, com.meizu.media.camera.util.ad$a<K, V>> r0 = r8.f14078c     // Catch:{ all -> 0x004f }
            com.meizu.media.camera.util.ad$a r1 = new com.meizu.media.camera.util.ad$a     // Catch:{ all -> 0x004f }
            java.lang.ref.ReferenceQueue<V> r2 = r8.f14079d     // Catch:{ all -> 0x004f }
            r1.<init>(r9, r10, r2)     // Catch:{ all -> 0x004f }
            java.lang.Object r9 = r0.put(r9, r1)     // Catch:{ all -> 0x004f }
            com.meizu.media.camera.util.ad$a r9 = (com.meizu.media.camera.util.LruCache.C2632a) r9     // Catch:{ all -> 0x004f }
            if (r9 != 0) goto L_0x0049
            r9 = 0
            goto L_0x004d
        L_0x0049:
            java.lang.Object r9 = r9.get()     // Catch:{ all -> 0x004f }
        L_0x004d:
            monitor-exit(r8)
            return r9
        L_0x004f:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.LruCache.mo22660a(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        return r9;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized V mo22662b(K r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0042 }
            r2 = 0
            r1[r2] = r9     // Catch:{ all -> 0x0042 }
            com.meizu.savior.ChangeQuickRedirect r3 = f14076a     // Catch:{ all -> 0x0042 }
            r4 = 0
            r5 = 8133(0x1fc5, float:1.1397E-41)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0042 }
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            r6[r2] = r0     // Catch:{ all -> 0x0042 }
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            r2 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0042 }
            boolean r1 = r0.isSupported     // Catch:{ all -> 0x0042 }
            if (r1 == 0) goto L_0x0023
            java.lang.Object r9 = r0.result     // Catch:{ all -> 0x0042 }
            java.lang.Object r9 = (java.lang.Object) r9     // Catch:{ all -> 0x0042 }
            monitor-exit(r8)
            return r9
        L_0x0023:
            r8.m15957b()     // Catch:{ all -> 0x0042 }
            java.util.HashMap<K, V> r0 = r8.f14077b     // Catch:{ all -> 0x0042 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0030
            monitor-exit(r8)
            return r0
        L_0x0030:
            java.util.HashMap<K, com.meizu.media.camera.util.ad$a<K, V>> r0 = r8.f14078c     // Catch:{ all -> 0x0042 }
            java.lang.Object r9 = r0.get(r9)     // Catch:{ all -> 0x0042 }
            com.meizu.media.camera.util.ad$a r9 = (com.meizu.media.camera.util.LruCache.C2632a) r9     // Catch:{ all -> 0x0042 }
            if (r9 != 0) goto L_0x003c
            r9 = 0
            goto L_0x0040
        L_0x003c:
            java.lang.Object r9 = r9.get()     // Catch:{ all -> 0x0042 }
        L_0x0040:
            monitor-exit(r8)
            return r9
        L_0x0042:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.LruCache.mo22662b(java.lang.Object):java.lang.Object");
    }

    /* renamed from: com.meizu.media.camera.util.ad$a */
    /* compiled from: LruCache */
    private static class C2632a<K, V> extends WeakReference<V> {

        /* renamed from: a */
        K f14083a;

        public C2632a(K k, V v, ReferenceQueue<V> referenceQueue) {
            super(v, referenceQueue);
            this.f14083a = k;
        }
    }
}
