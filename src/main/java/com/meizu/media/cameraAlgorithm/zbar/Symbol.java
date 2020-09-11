package com.meizu.media.cameraAlgorithm.zbar;

import androidx.appcompat.widget.ActivityChooserView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class Symbol {
    public static final int CODABAR = 38;
    public static final int CODE128 = 128;
    public static final int CODE39 = 39;
    public static final int CODE93 = 93;
    public static final int DATABAR = 34;
    public static final int DATABAR_EXP = 35;
    public static final int EAN13 = 13;
    public static final int EAN8 = 8;
    public static final int I25 = 25;
    public static final int ISBN10 = 10;
    public static final int ISBN13 = 14;
    public static final int NONE = 0;
    public static final int PARTIAL = 1;
    public static final int PDF417 = 57;
    public static final int QRCODE = 64;
    public static final int UPCA = 12;
    public static final int UPCE = 9;
    public static ChangeQuickRedirect changeQuickRedirect;
    private long mPeer;
    private int type;

    static {
        System.loadLibrary("zbarjni");
        init();
    }

    Symbol(long j) {
        this.mPeer = j;
    }

    private native void destroy(long j);

    private native long getComponents(long j);

    private native int getLocationSize(long j);

    private native int getLocationX(long j, int i);

    private native int getLocationY(long j, int i);

    private native int getType(long j);

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
            r5 = 8988(0x231c, float:1.2595E-41)
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
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.cameraAlgorithm.zbar.Symbol.destroy():void");
    }

    public void finalize() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 8987, new Class[0], Void.TYPE).isSupported) {
            destroy();
        }
    }

    public int[] getBounds() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 8990, new Class[0], int[].class);
        if (proxy.isSupported) {
            return (int[]) proxy.result;
        }
        int locationSize = getLocationSize(this.mPeer);
        if (locationSize <= 0) {
            return null;
        }
        int[] iArr = new int[4];
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MIN_VALUE;
        for (int i5 = 0; i5 < locationSize; i5++) {
            int locationX = getLocationX(this.mPeer, i5);
            if (i > locationX) {
                i = locationX;
            }
            if (i3 < locationX) {
                i3 = locationX;
            }
            int locationY = getLocationY(this.mPeer, i5);
            if (i2 > locationY) {
                i2 = locationY;
            }
            if (i4 < locationY) {
                i4 = locationY;
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3 - i;
        iArr[3] = i4 - i2;
        return iArr;
    }

    public ZbarDecoder getComponents() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 8992, new Class[0], ZbarDecoder.class);
        return proxy.isSupported ? (ZbarDecoder) proxy.result : new ZbarDecoder(getComponents(this.mPeer));
    }

    public native int getConfigMask();

    public native int getCount();

    public native String getData();

    public native byte[] getDataBytes();

    public int[] getLocationPoint(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, changeQuickRedirect, false, 8991, new Class[]{Integer.TYPE}, int[].class);
        if (proxy.isSupported) {
            return (int[]) proxy.result;
        }
        return new int[]{getLocationX(this.mPeer, i), getLocationY(this.mPeer, i)};
    }

    public native int getModifierMask();

    public native int getOrientation();

    public native int getQuality();

    public int getType() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 8989, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.type == 0) {
            this.type = getType(this.mPeer);
        }
        return this.type;
    }

    /* access modifiers changed from: package-private */
    public native long next();
}
