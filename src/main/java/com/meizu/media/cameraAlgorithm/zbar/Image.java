package com.meizu.media.cameraAlgorithm.zbar;

import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class Image {
    public static ChangeQuickRedirect changeQuickRedirect;
    private Object data;
    private long mPeer;

    static {
        System.loadLibrary("zbarjni");
        init();
    }

    public Image() {
        this.mPeer = create();
    }

    public Image(int i, int i2) {
        this();
        setSize(i, i2);
    }

    public Image(int i, int i2, String str) {
        this();
        setSize(i, i2);
        setFormatTrans(str);
    }

    Image(long j) {
        this.mPeer = j;
    }

    public Image(String str) {
        this();
        setFormatTrans(str);
    }

    private native long convert(long j, String str);

    private native long create();

    private native void destroy(long j);

    private native long getSymbols(long j);

    private static native void init();

    private void setFormatTrans(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 8978, new Class[]{String.class}, Void.TYPE).isSupported) {
            setFormat(str);
        }
    }

    public Image convert(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, changeQuickRedirect, false, 8981, new Class[]{String.class}, Image.class);
        if (proxy.isSupported) {
            return (Image) proxy.result;
        }
        long convert = convert(this.mPeer, str);
        if (convert == 0) {
            return null;
        }
        return new Image(convert);
    }

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
            r5 = 8980(0x2314, float:1.2584E-41)
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
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.cameraAlgorithm.zbar.Image.destroy():void");
    }

    public void finalize() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 8979, new Class[0], Void.TYPE).isSupported) {
            destroy();
        }
    }

    public native int[] getCrop();

    public native byte[] getData();

    public native String getFormat();

    public native int getHeight();

    public native int getSequence();

    public native int[] getSize();

    public ZbarDecoder getSymbols() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 8982, new Class[0], ZbarDecoder.class);
        return proxy.isSupported ? (ZbarDecoder) proxy.result : new ZbarDecoder(getSymbols(this.mPeer));
    }

    public native int getWidth();

    public native void setCrop(int i, int i2, int i3, int i4);

    public native void setCrop(int[] iArr);

    public native void setData(byte[] bArr);

    public native void setData(int[] iArr);

    public final native void setFormat(String str);

    public native void setSequence(int i);

    public native void setSize(int i, int i2);

    public native void setSize(int[] iArr);
}
