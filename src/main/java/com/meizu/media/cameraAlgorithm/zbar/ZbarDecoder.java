package com.meizu.media.cameraAlgorithm.zbar;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.AbstractCollection;
import java.util.Iterator;

public class ZbarDecoder extends AbstractCollection<Symbol> {
    public static ChangeQuickRedirect changeQuickRedirect;
    private long mPeer;

    static {
        System.loadLibrary("zbarjni");
        init();
    }

    ZbarDecoder(long j) {
        this.mPeer = j;
    }

    private native void destroy(long j);

    private native long firstSymbol(long j);

    private static native void init();

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void destroy() {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0029 }
            com.meizu.savior.ChangeQuickRedirect r3 = changeQuickRedirect     // Catch:{ all -> 0x0029 }
            r4 = 0
            r5 = 8996(0x2324, float:1.2606E-41)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0029 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0029 }
            r2 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0029 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0018
            monitor-exit(r8)
            return
        L_0x0018:
            long r0 = r8.mPeer     // Catch:{ all -> 0x0029 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0027
            long r0 = r8.mPeer     // Catch:{ all -> 0x0029 }
            r8.destroy(r0)     // Catch:{ all -> 0x0029 }
            r8.mPeer = r2     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r8)
            return
        L_0x0029:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.cameraAlgorithm.zbar.ZbarDecoder.destroy():void");
    }

    public void finalize() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 8995, new Class[0], Void.TYPE).isSupported) {
            destroy();
        }
    }

    public Iterator<Symbol> iterator() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 8997, new Class[0], Iterator.class);
        if (proxy.isSupported) {
            return (Iterator) proxy.result;
        }
        long firstSymbol = firstSymbol(this.mPeer);
        return firstSymbol == 0 ? new SymbolIterator((Symbol) null) : new SymbolIterator(new Symbol(firstSymbol));
    }

    public native int size();
}
