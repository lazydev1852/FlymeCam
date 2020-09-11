package com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.Matrix;
import android.util.Log;
import android.view.Surface;
import com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoFilter;
import com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.EGLBase;
import com.meizu.media.mzfunnysnapsdk.Utils.MatrixUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public final class RenderHandler implements Runnable {
    private static final boolean DEBUG = false;
    private static final String TAG = "RenderHandler";
    public static ChangeQuickRedirect changeQuickRedirect;

    /* renamed from: SM */
    private float[] f15618SM = {0.0f};
    private int height = 0;
    private Bitmap mBitmap;
    private EGLBase mEgl;
    private EGLBase.EglSurface mInputSurface;
    private boolean mIsRecordable;
    private boolean mIsWaterMark = true;
    private float[] mMatrix = new float[32];
    private int mRequestDraw;
    private boolean mRequestRelease;
    private boolean mRequestSetEglContext;
    private Resources mRes;
    private EGLContext mShard_context;
    private ShortVideoFilter mShowFilter;
    private Object mSurface;
    private final Object mSync = new Object();
    private int mTexId = -1;
    private int mVideoAngle = 0;
    private float[] mvp_matrix = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float[] smMatrix0 = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float[] smMatrix180 = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float[] smMatrix270 = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float[] smMatrix90 = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    private float[] smMatrixSrc = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float[] tex_matrix = {0.0f, -1.0f, 0.0f, 0.6f, 1.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    private float[] tex_matrix1 = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    private int width = 0;

    /* JADX WARNING: Can't wrap try/catch for region: R(8:6|7|(1:9)(1:10)|11|12|13|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0046 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.RenderHandler createHandler(java.lang.String r8) {
        /*
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r8
            com.meizu.savior.ChangeQuickRedirect r3 = changeQuickRedirect
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r2] = r0
            java.lang.Class<com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.RenderHandler> r7 = com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.RenderHandler.class
            r2 = 0
            r4 = 1
            r5 = 9347(0x2483, float:1.3098E-41)
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x0021
            java.lang.Object r8 = r0.result
            com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.RenderHandler r8 = (com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.RenderHandler) r8
            return r8
        L_0x0021:
            com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.RenderHandler r0 = new com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.RenderHandler
            r0.<init>()
            java.lang.String r1 = "FunnySnapFlowVideo"
            java.lang.String r2 = "Render -createHandler()"
            android.util.Log.i(r1, r2)
            java.lang.Object r1 = r0.mSync
            monitor-enter(r1)
            java.lang.Thread r2 = new java.lang.Thread     // Catch:{ all -> 0x0048 }
            boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0048 }
            if (r3 != 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            java.lang.String r8 = "RenderHandler"
        L_0x003b:
            r2.<init>(r0, r8)     // Catch:{ all -> 0x0048 }
            r2.start()     // Catch:{ all -> 0x0048 }
            java.lang.Object r8 = r0.mSync     // Catch:{ InterruptedException -> 0x0046 }
            r8.wait()     // Catch:{ InterruptedException -> 0x0046 }
        L_0x0046:
            monitor-exit(r1)     // Catch:{ all -> 0x0048 }
            return r0
        L_0x0048:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0048 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.RenderHandler.createHandler(java.lang.String):com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.RenderHandler");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:18|19|20|21|22|23) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x00fc */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setEglContext(android.content.res.Resources r24, android.opengl.EGLContext r25, int r26, java.lang.Object r27, boolean r28, float[] r29, int r30, int r31, android.graphics.Bitmap r32) {
        /*
            r23 = this;
            r8 = r23
            r0 = r24
            r9 = r25
            r10 = r26
            r11 = r27
            r12 = r28
            r13 = r29
            r14 = r30
            r15 = r31
            r7 = r32
            r1 = 9
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r6 = 0
            r2[r6] = r0
            r5 = 1
            r2[r5] = r9
            java.lang.Integer r3 = new java.lang.Integer
            r3.<init>(r10)
            r4 = 2
            r2[r4] = r3
            r3 = 3
            r2[r3] = r11
            java.lang.Byte r3 = new java.lang.Byte
            r3.<init>(r12)
            r17 = 4
            r2[r17] = r3
            r3 = 5
            r2[r3] = r13
            java.lang.Integer r3 = new java.lang.Integer
            r3.<init>(r14)
            r19 = 6
            r2[r19] = r3
            java.lang.Integer r3 = new java.lang.Integer
            r3.<init>(r15)
            r20 = 7
            r2[r20] = r3
            r3 = 8
            r2[r3] = r7
            com.meizu.savior.ChangeQuickRedirect r21 = changeQuickRedirect
            java.lang.Class[] r1 = new java.lang.Class[r1]
            java.lang.Class<android.content.res.Resources> r22 = android.content.res.Resources.class
            r1[r6] = r22
            java.lang.Class<android.opengl.EGLContext> r22 = android.opengl.EGLContext.class
            r1[r5] = r22
            java.lang.Class r22 = java.lang.Integer.TYPE
            r1[r4] = r22
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            r16 = 3
            r1[r16] = r4
            java.lang.Class r4 = java.lang.Boolean.TYPE
            r1[r17] = r4
            java.lang.Class<float[]> r4 = float[].class
            r16 = 5
            r1[r16] = r4
            java.lang.Class r4 = java.lang.Integer.TYPE
            r1[r19] = r4
            java.lang.Class r4 = java.lang.Integer.TYPE
            r1[r20] = r4
            java.lang.Class<android.graphics.Bitmap> r4 = android.graphics.Bitmap.class
            r1[r3] = r4
            java.lang.Class r16 = java.lang.Void.TYPE
            r4 = 0
            r17 = 9348(0x2484, float:1.31E-41)
            r18 = r1
            r1 = r2
            r2 = r23
            r3 = r21
            r5 = r17
            r6 = r18
            r12 = r7
            r7 = r16
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0093
            return
        L_0x0093:
            java.lang.String r1 = "FunnySnapFlowVideo"
            java.lang.String r2 = "Render - set EGL Context()"
            android.util.Log.i(r1, r2)
            boolean r1 = r11 instanceof android.view.Surface
            if (r1 != 0) goto L_0x00be
            boolean r1 = r11 instanceof android.graphics.SurfaceTexture
            if (r1 != 0) goto L_0x00be
            boolean r1 = r11 instanceof android.view.SurfaceHolder
            if (r1 == 0) goto L_0x00a7
            goto L_0x00be
        L_0x00a7:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "unsupported window type:"
            r1.append(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00be:
            java.lang.Object r1 = r8.mSync
            monitor-enter(r1)
            boolean r2 = r8.mRequestRelease     // Catch:{ all -> 0x00fe }
            if (r2 == 0) goto L_0x00c7
            monitor-exit(r1)     // Catch:{ all -> 0x00fe }
            return
        L_0x00c7:
            r8.mRes = r0     // Catch:{ all -> 0x00fe }
            r8.mShard_context = r9     // Catch:{ all -> 0x00fe }
            r8.mTexId = r10     // Catch:{ all -> 0x00fe }
            r8.mSurface = r11     // Catch:{ all -> 0x00fe }
            java.lang.String r0 = "FunnySnapFlowVideo"
            java.lang.String r2 = "Render - set EGL Context - surface"
            android.util.Log.i(r0, r2)     // Catch:{ all -> 0x00fe }
            r8.width = r14     // Catch:{ all -> 0x00fe }
            r8.height = r15     // Catch:{ all -> 0x00fe }
            r8.f15618SM = r13     // Catch:{ all -> 0x00fe }
            r8.mBitmap = r12     // Catch:{ all -> 0x00fe }
            r0 = r28
            r8.mIsRecordable = r0     // Catch:{ all -> 0x00fe }
            r0 = 1
            r8.mRequestSetEglContext = r0     // Catch:{ all -> 0x00fe }
            float[] r0 = r8.mMatrix     // Catch:{ all -> 0x00fe }
            r2 = 0
            android.opengl.Matrix.setIdentityM(r0, r2)     // Catch:{ all -> 0x00fe }
            float[] r0 = r8.mMatrix     // Catch:{ all -> 0x00fe }
            r2 = 16
            android.opengl.Matrix.setIdentityM(r0, r2)     // Catch:{ all -> 0x00fe }
            java.lang.Object r0 = r8.mSync     // Catch:{ all -> 0x00fe }
            r0.notifyAll()     // Catch:{ all -> 0x00fe }
            java.lang.Object r0 = r8.mSync     // Catch:{ InterruptedException -> 0x00fc }
            r0.wait()     // Catch:{ InterruptedException -> 0x00fc }
        L_0x00fc:
            monitor-exit(r1)     // Catch:{ all -> 0x00fe }
            return
        L_0x00fe:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00fe }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.RenderHandler.setEglContext(android.content.res.Resources, android.opengl.EGLContext, int, java.lang.Object, boolean, float[], int, int, android.graphics.Bitmap):void");
    }

    public final void setVideoAngle(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9349, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.mSync) {
                if (!this.mRequestRelease) {
                    this.mVideoAngle = i;
                    Log.i("FunnySnapFlowVideo", "Media Video angle : " + this.mVideoAngle);
                }
            }
        }
    }

    public void setWaterMarkEnable(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9350, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            synchronized (this.mSync) {
                if (!this.mRequestRelease) {
                    this.mIsWaterMark = z;
                    Log.i("FunnySnapFlowVideo", "Media Video setWaterMarkEnable : " + this.mIsWaterMark);
                }
            }
        }
    }

    public final void draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9351, new Class[0], Void.TYPE).isSupported) {
            draw(this.mTexId, this.mMatrix, (float[]) null);
        }
    }

    public final void draw(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9352, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            draw(i, this.mMatrix, (float[]) null);
        }
    }

    public final void draw(float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, changeQuickRedirect, false, 9353, new Class[]{float[].class}, Void.TYPE).isSupported) {
            draw(this.mTexId, fArr, (float[]) null);
        }
    }

    public final void draw(float[] fArr, float[] fArr2) {
        Class[] clsArr = {float[].class, float[].class};
        if (!PatchProxy.proxy(new Object[]{fArr, fArr2}, this, changeQuickRedirect, false, 9354, clsArr, Void.TYPE).isSupported) {
            draw(this.mTexId, fArr, fArr2);
        }
    }

    public final void draw(int i, float[] fArr) {
        Object[] objArr = {new Integer(i), fArr};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9355, new Class[]{Integer.TYPE, float[].class}, Void.TYPE).isSupported) {
            draw(i, fArr, (float[]) null);
        }
    }

    public final void draw(int i, float[] fArr, float[] fArr2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), fArr, fArr2}, this, changeQuickRedirect, false, 9356, new Class[]{Integer.TYPE, float[].class, float[].class}, Void.TYPE).isSupported) {
            synchronized (this.mSync) {
                if (!this.mRequestRelease) {
                    this.mTexId = i;
                    if (fArr == null || fArr.length < 16) {
                        Matrix.setIdentityM(this.mMatrix, 0);
                    } else {
                        System.arraycopy(fArr, 0, this.mMatrix, 0, 16);
                    }
                    if (fArr2 == null || fArr2.length < 16) {
                        Matrix.setIdentityM(this.mMatrix, 16);
                    } else {
                        System.arraycopy(fArr2, 0, this.mMatrix, 16, 16);
                    }
                    this.mRequestDraw++;
                    this.mSync.notifyAll();
                }
            }
        }
    }

    public boolean isValid() {
        boolean z = false;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9357, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        Log.i("FunnySnapFlowVideo", "Render - isValid()");
        synchronized (this.mSync) {
            Log.i("FunnySnapFlowVideo", "mSurface = isValid");
            if (!(this.mSurface instanceof Surface) || ((Surface) this.mSurface).isValid()) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:10|11|12|13|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void release() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = changeQuickRedirect
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 9358(0x248e, float:1.3113E-41)
            r2 = r8
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0016
            return
        L_0x0016:
            java.lang.String r0 = "FunnySnapFlowVideo"
            java.lang.String r1 = "Render - release()"
            android.util.Log.i(r0, r1)
            java.lang.Object r0 = r8.mSync
            monitor-enter(r0)
            boolean r1 = r8.mRequestRelease     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0026
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0026:
            r1 = 1
            r8.mRequestRelease = r1     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r8.mSync     // Catch:{ all -> 0x0035 }
            r1.notifyAll()     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r8.mSync     // Catch:{ InterruptedException -> 0x0033 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0033 }
        L_0x0033:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0035:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.RenderHandler.release():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
        if (r1 == false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0052, code lost:
        if (r8.mEgl == null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0056, code lost:
        if (r8.mTexId < 0) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0058, code lost:
        r8.mInputSurface.makeCurrent();
        r8.mShowFilter.setTextureId(r8.mTexId);
        r8.mShowFilter.draw();
        r8.mInputSurface.swap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006f, code lost:
        r1 = r8.mSync;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0071, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r8.mSync.wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0079, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x008f, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = changeQuickRedirect
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 9359(0x248f, float:1.3115E-41)
            r2 = r8
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            java.lang.String r1 = "FunnySnapFlowVideo"
            java.lang.String r2 = "Render - run()"
            android.util.Log.i(r1, r2)
            java.lang.Object r1 = r8.mSync
            monitor-enter(r1)
            r8.mRequestRelease = r0     // Catch:{ all -> 0x0093 }
            r8.mRequestSetEglContext = r0     // Catch:{ all -> 0x0093 }
            r8.mRequestDraw = r0     // Catch:{ all -> 0x0093 }
            java.lang.Object r2 = r8.mSync     // Catch:{ all -> 0x0093 }
            r2.notifyAll()     // Catch:{ all -> 0x0093 }
            monitor-exit(r1)     // Catch:{ all -> 0x0093 }
        L_0x002c:
            java.lang.Object r2 = r8.mSync
            monitor-enter(r2)
            boolean r1 = r8.mRequestRelease     // Catch:{ all -> 0x0090 }
            r3 = 1
            if (r1 == 0) goto L_0x0036
            monitor-exit(r2)     // Catch:{ all -> 0x0090 }
            goto L_0x007c
        L_0x0036:
            boolean r1 = r8.mRequestSetEglContext     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x003f
            r8.mRequestSetEglContext = r0     // Catch:{ all -> 0x0090 }
            r8.internalPrepare()     // Catch:{ all -> 0x0090 }
        L_0x003f:
            int r1 = r8.mRequestDraw     // Catch:{ all -> 0x0090 }
            if (r1 <= 0) goto L_0x0045
            r1 = 1
            goto L_0x0046
        L_0x0045:
            r1 = 0
        L_0x0046:
            if (r1 == 0) goto L_0x004d
            int r4 = r8.mRequestDraw     // Catch:{ all -> 0x0090 }
            int r4 = r4 - r3
            r8.mRequestDraw = r4     // Catch:{ all -> 0x0090 }
        L_0x004d:
            monitor-exit(r2)     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x006f
            com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.EGLBase r1 = r8.mEgl
            if (r1 == 0) goto L_0x002c
            int r1 = r8.mTexId
            if (r1 < 0) goto L_0x002c
            com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.EGLBase$EglSurface r1 = r8.mInputSurface
            r1.makeCurrent()
            com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoFilter r1 = r8.mShowFilter
            int r2 = r8.mTexId
            r1.setTextureId(r2)
            com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoFilter r1 = r8.mShowFilter
            r1.draw()
            com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.EGLBase$EglSurface r1 = r8.mInputSurface
            r1.swap()
            goto L_0x002c
        L_0x006f:
            java.lang.Object r1 = r8.mSync
            monitor-enter(r1)
            java.lang.Object r2 = r8.mSync     // Catch:{ InterruptedException -> 0x007b }
            r2.wait()     // Catch:{ InterruptedException -> 0x007b }
            monitor-exit(r1)     // Catch:{ all -> 0x0079 }
            goto L_0x002c
        L_0x0079:
            r0 = move-exception
            goto L_0x008e
        L_0x007b:
            monitor-exit(r1)     // Catch:{ all -> 0x0079 }
        L_0x007c:
            java.lang.Object r0 = r8.mSync
            monitor-enter(r0)
            r8.mRequestRelease = r3     // Catch:{ all -> 0x008b }
            r8.internalRelease()     // Catch:{ all -> 0x008b }
            java.lang.Object r1 = r8.mSync     // Catch:{ all -> 0x008b }
            r1.notifyAll()     // Catch:{ all -> 0x008b }
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            return
        L_0x008b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            throw r1
        L_0x008e:
            monitor-exit(r1)     // Catch:{ all -> 0x0079 }
            throw r0
        L_0x0090:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0090 }
            throw r0
        L_0x0093:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0093 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.mzfunnysnapsdk.ShortVideoEncoder.ShortVideoGLUtils.RenderHandler.run():void");
    }

    private final void internalPrepare() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9360, new Class[0], Void.TYPE).isSupported) {
            Log.i("FunnySnapFlowVideo", "Render - inter Prepare");
            internalRelease();
            this.mEgl = new EGLBase(this.mShard_context, false, this.mIsRecordable);
            this.mInputSurface = this.mEgl.createFromSurface(this.mSurface);
            this.mInputSurface.makeCurrent();
            new float[1][0] = 0.0f;
            float[] rotate = MatrixUtils.rotate(this.smMatrixSrc, (float) this.mVideoAngle);
            Log.i("FunnySnapFlowVideo", "Render width : " + this.width + ", height : " + this.height + ", mVideoAngle : " + this.mVideoAngle);
            this.mShowFilter = new ShortVideoFilter(this.mRes);
            this.mShowFilter.setEnableWaterMark(this.mIsWaterMark);
            if (this.mIsWaterMark) {
                this.mShowFilter.setWaterMark(this.mBitmap);
            }
            this.mShowFilter.create();
            this.mShowFilter.setSize(this.width, this.height);
            this.mShowFilter.setMatrix(rotate);
            Log.i("FunnySnapFlowVideo", " Render - inter Prepare() mTexId : " + this.mTexId + ", mSurface : " + this.mSurface);
            this.mSurface = null;
            this.mSync.notifyAll();
        }
    }

    private final void internalRelease() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9361, new Class[0], Void.TYPE).isSupported) {
            Log.i("FunnySnapFlowVideo", "Render - inter Release()");
            if (this.mInputSurface != null) {
                this.mInputSurface.release();
                this.mInputSurface = null;
            }
            if (this.mEgl != null) {
                this.mEgl.release();
                this.mEgl = null;
            }
        }
    }
}
