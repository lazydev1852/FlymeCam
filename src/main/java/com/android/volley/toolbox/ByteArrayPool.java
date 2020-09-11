package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.android.volley.toolbox.d */
public class ByteArrayPool {

    /* renamed from: a */
    protected static final Comparator<byte[]> f363a = new Comparator<byte[]>() {
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };

    /* renamed from: b */
    private final List<byte[]> f364b = new ArrayList();

    /* renamed from: c */
    private final List<byte[]> f365c = new ArrayList(64);

    /* renamed from: d */
    private int f366d = 0;

    /* renamed from: e */
    private final int f367e;

    public ByteArrayPool(int i) {
        this.f367e = i;
    }

    /* renamed from: a */
    public synchronized byte[] mo8728a(int i) {
        for (int i2 = 0; i2 < this.f365c.size(); i2++) {
            byte[] bArr = this.f365c.get(i2);
            if (bArr.length >= i) {
                this.f366d -= bArr.length;
                this.f365c.remove(i2);
                this.f364b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo8727a(byte[] r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x002e
            int r0 = r3.length     // Catch:{ all -> 0x002b }
            int r1 = r2.f367e     // Catch:{ all -> 0x002b }
            if (r0 <= r1) goto L_0x0009
            goto L_0x002e
        L_0x0009:
            java.util.List<byte[]> r0 = r2.f364b     // Catch:{ all -> 0x002b }
            r0.add(r3)     // Catch:{ all -> 0x002b }
            java.util.List<byte[]> r0 = r2.f365c     // Catch:{ all -> 0x002b }
            java.util.Comparator<byte[]> r1 = f363a     // Catch:{ all -> 0x002b }
            int r0 = java.util.Collections.binarySearch(r0, r3, r1)     // Catch:{ all -> 0x002b }
            if (r0 >= 0) goto L_0x001b
            int r0 = -r0
            int r0 = r0 + -1
        L_0x001b:
            java.util.List<byte[]> r1 = r2.f365c     // Catch:{ all -> 0x002b }
            r1.add(r0, r3)     // Catch:{ all -> 0x002b }
            int r0 = r2.f366d     // Catch:{ all -> 0x002b }
            int r3 = r3.length     // Catch:{ all -> 0x002b }
            int r0 = r0 + r3
            r2.f366d = r0     // Catch:{ all -> 0x002b }
            r2.m633a()     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x002e:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.ByteArrayPool.mo8727a(byte[]):void");
    }

    /* renamed from: a */
    private synchronized void m633a() {
        while (this.f366d > this.f367e) {
            byte[] remove = this.f364b.remove(0);
            this.f365c.remove(remove);
            this.f366d -= remove.length;
        }
    }
}
