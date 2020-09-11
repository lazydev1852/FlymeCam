package com.meizu.camera.effectlib.panorama;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class PanoramaPreviewView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: a */
    public static ChangeQuickRedirect f4080a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public HandlerThread f4081b;

    /* renamed from: c */
    private C1196a f4082c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f4083d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f4084e;

    /* renamed from: com.meizu.camera.effectlib.panorama.PanoramaPreviewView$b */
    private class C1197b {

        /* renamed from: a */
        Bitmap f4096a;

        /* renamed from: b */
        int f4097b;

        /* renamed from: c */
        int f4098c;

        /* renamed from: d */
        boolean f4099d;

        /* renamed from: e */
        boolean f4100e;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public PanoramaPreviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PanoramaPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PanoramaPreviewView(Context context) {
        super(context);
    }

    public int getViewWidth() {
        return this.f4083d;
    }

    public int getViewHeight() {
        return this.f4084e;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Object[] objArr = {surfaceTexture, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f4080a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 479, new Class[]{SurfaceTexture.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f4083d = i;
            this.f4084e = i2;
            this.f4081b = new HandlerThread("Pano Preview Handler Thread");
            this.f4081b.start();
            this.f4082c = new C1196a(this.f4081b.getLooper());
            this.f4082c.mo14379a((TextureView) this);
            this.f4082c.mo14376a();
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{surfaceTexture}, this, f4080a, false, 480, new Class[]{SurfaceTexture.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        this.f4082c.mo14380b();
        return false;
    }

    /* renamed from: com.meizu.camera.effectlib.panorama.PanoramaPreviewView$a */
    protected class C1196a extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f4085a;

        /* renamed from: c */
        private final ConditionVariable f4087c = new ConditionVariable();

        /* renamed from: d */
        private Bitmap f4088d;

        /* renamed from: e */
        private Canvas f4089e;

        /* renamed from: f */
        private final Paint f4090f = new Paint();

        /* renamed from: g */
        private final Paint f4091g = new Paint();

        /* renamed from: h */
        private final Paint f4092h = new Paint();

        /* renamed from: i */
        private Rect f4093i = new Rect(0, 0, 0, 0);

        /* renamed from: j */
        private TextureView f4094j;

        /* renamed from: k */
        private boolean f4095k = false;

        public C1196a(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r10) {
            /*
                r9 = this;
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r8 = 0
                r1[r8] = r10
                com.meizu.savior.ChangeQuickRedirect r3 = f4085a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class<android.os.Message> r2 = android.os.Message.class
                r6[r8] = r2
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 484(0x1e4, float:6.78E-43)
                r2 = r9
                com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r1 = r1.isSupported
                if (r1 == 0) goto L_0x001d
                return
            L_0x001d:
                int r1 = r10.what     // Catch:{ Exception -> 0x0181 }
                r2 = 0
                r3 = 0
                switch(r1) {
                    case 0: goto L_0x012d;
                    case 1: goto L_0x00fd;
                    case 2: goto L_0x0069;
                    case 3: goto L_0x0040;
                    case 4: goto L_0x0026;
                    default: goto L_0x0024;
                }     // Catch:{ Exception -> 0x0181 }
            L_0x0024:
                goto L_0x0179
            L_0x0026:
                r9.f4095k = r8     // Catch:{ Exception -> 0x0181 }
                android.graphics.Bitmap r10 = r9.f4088d     // Catch:{ Exception -> 0x0181 }
                if (r10 == 0) goto L_0x0033
                android.graphics.Bitmap r10 = r9.f4088d     // Catch:{ Exception -> 0x0181 }
                r10.recycle()     // Catch:{ Exception -> 0x0181 }
                r9.f4088d = r2     // Catch:{ Exception -> 0x0181 }
            L_0x0033:
                r9.f4089e = r2     // Catch:{ Exception -> 0x0181 }
                com.meizu.camera.effectlib.panorama.PanoramaPreviewView r10 = com.meizu.camera.effectlib.panorama.PanoramaPreviewView.this     // Catch:{ Exception -> 0x0181 }
                android.os.HandlerThread r10 = r10.f4081b     // Catch:{ Exception -> 0x0181 }
                r10.quit()     // Catch:{ Exception -> 0x0181 }
                goto L_0x0179
            L_0x0040:
                boolean r10 = r9.f4095k     // Catch:{ Exception -> 0x0181 }
                if (r10 == 0) goto L_0x0179
                android.view.TextureView r10 = r9.f4094j     // Catch:{ Exception -> 0x0181 }
                android.graphics.Canvas r10 = r10.lockCanvas(r2)     // Catch:{ Exception -> 0x0181 }
                if (r10 == 0) goto L_0x0179
                android.graphics.Bitmap r0 = r9.f4088d     // Catch:{ Exception -> 0x005c }
                android.graphics.Paint r1 = r9.f4090f     // Catch:{ Exception -> 0x005c }
                r10.drawBitmap(r0, r3, r3, r1)     // Catch:{ Exception -> 0x005c }
                android.view.TextureView r0 = r9.f4094j     // Catch:{ Exception -> 0x0181 }
            L_0x0055:
                r0.unlockCanvasAndPost(r10)     // Catch:{ Exception -> 0x0181 }
                goto L_0x0179
            L_0x005a:
                r0 = move-exception
                goto L_0x0063
            L_0x005c:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ all -> 0x005a }
                android.view.TextureView r0 = r9.f4094j     // Catch:{ Exception -> 0x0181 }
                goto L_0x0055
            L_0x0063:
                android.view.TextureView r1 = r9.f4094j     // Catch:{ Exception -> 0x0181 }
                r1.unlockCanvasAndPost(r10)     // Catch:{ Exception -> 0x0181 }
                throw r0     // Catch:{ Exception -> 0x0181 }
            L_0x0069:
                boolean r0 = r9.f4095k     // Catch:{ Exception -> 0x0181 }
                if (r0 == 0) goto L_0x0179
                android.view.TextureView r0 = r9.f4094j     // Catch:{ Exception -> 0x0181 }
                android.graphics.Canvas r0 = r0.lockCanvas(r2)     // Catch:{ Exception -> 0x0181 }
                if (r0 == 0) goto L_0x0179
                java.lang.Object r10 = r10.obj     // Catch:{ Exception -> 0x00f0 }
                com.meizu.camera.effectlib.panorama.PanoramaPreviewView$b r10 = (com.meizu.camera.effectlib.panorama.PanoramaPreviewView.C1197b) r10     // Catch:{ Exception -> 0x00f0 }
                android.graphics.Canvas r1 = r9.f4089e     // Catch:{ Exception -> 0x00f0 }
                android.graphics.Bitmap r2 = r10.f4096a     // Catch:{ Exception -> 0x00f0 }
                int r4 = r10.f4097b     // Catch:{ Exception -> 0x00f0 }
                float r4 = (float) r4     // Catch:{ Exception -> 0x00f0 }
                int r5 = r10.f4098c     // Catch:{ Exception -> 0x00f0 }
                float r5 = (float) r5     // Catch:{ Exception -> 0x00f0 }
                android.graphics.Paint r6 = r9.f4090f     // Catch:{ Exception -> 0x00f0 }
                r1.drawBitmap(r2, r4, r5, r6)     // Catch:{ Exception -> 0x00f0 }
                boolean r1 = r10.f4100e     // Catch:{ Exception -> 0x00f0 }
                if (r1 == 0) goto L_0x00ad
                android.graphics.Rect r1 = r9.f4093i     // Catch:{ Exception -> 0x00f0 }
                int r2 = r10.f4097b     // Catch:{ Exception -> 0x00f0 }
                int r4 = com.meizu.imageproc.PanoramaStitcher.m6359a()     // Catch:{ Exception -> 0x00f0 }
                int r4 = r4 / 2
                int r2 = r2 - r4
                int r4 = r10.f4098c     // Catch:{ Exception -> 0x00f0 }
                int r5 = r10.f4097b     // Catch:{ Exception -> 0x00f0 }
                int r6 = com.meizu.imageproc.PanoramaStitcher.m6359a()     // Catch:{ Exception -> 0x00f0 }
                int r6 = r6 / 2
                int r5 = r5 + r6
                int r6 = r10.f4098c     // Catch:{ Exception -> 0x00f0 }
                int r7 = com.meizu.imageproc.PanoramaStitcher.m6361b()     // Catch:{ Exception -> 0x00f0 }
                int r6 = r6 + r7
                r1.set(r2, r4, r5, r6)     // Catch:{ Exception -> 0x00f0 }
                goto L_0x00c4
            L_0x00ad:
                android.graphics.Rect r1 = r9.f4093i     // Catch:{ Exception -> 0x00f0 }
                int r2 = r10.f4097b     // Catch:{ Exception -> 0x00f0 }
                int r4 = r10.f4098c     // Catch:{ Exception -> 0x00f0 }
                int r5 = r10.f4097b     // Catch:{ Exception -> 0x00f0 }
                int r6 = com.meizu.imageproc.PanoramaStitcher.m6359a()     // Catch:{ Exception -> 0x00f0 }
                int r5 = r5 + r6
                int r6 = r10.f4098c     // Catch:{ Exception -> 0x00f0 }
                int r7 = com.meizu.imageproc.PanoramaStitcher.m6361b()     // Catch:{ Exception -> 0x00f0 }
                int r6 = r6 + r7
                r1.set(r2, r4, r5, r6)     // Catch:{ Exception -> 0x00f0 }
            L_0x00c4:
                android.graphics.Bitmap r1 = r10.f4096a     // Catch:{ Exception -> 0x00f0 }
                if (r1 == 0) goto L_0x00cd
                android.graphics.Bitmap r1 = r10.f4096a     // Catch:{ Exception -> 0x00f0 }
                r1.recycle()     // Catch:{ Exception -> 0x00f0 }
            L_0x00cd:
                android.graphics.Bitmap r1 = r9.f4088d     // Catch:{ Exception -> 0x00f0 }
                android.graphics.Paint r2 = r9.f4090f     // Catch:{ Exception -> 0x00f0 }
                r0.drawBitmap(r1, r3, r3, r2)     // Catch:{ Exception -> 0x00f0 }
                boolean r10 = r10.f4099d     // Catch:{ Exception -> 0x00f0 }
                if (r10 == 0) goto L_0x00e0
                android.graphics.Rect r10 = r9.f4093i     // Catch:{ Exception -> 0x00f0 }
                android.graphics.Paint r1 = r9.f4092h     // Catch:{ Exception -> 0x00f0 }
                r0.drawRect(r10, r1)     // Catch:{ Exception -> 0x00f0 }
                goto L_0x00e7
            L_0x00e0:
                android.graphics.Rect r10 = r9.f4093i     // Catch:{ Exception -> 0x00f0 }
                android.graphics.Paint r1 = r9.f4091g     // Catch:{ Exception -> 0x00f0 }
                r0.drawRect(r10, r1)     // Catch:{ Exception -> 0x00f0 }
            L_0x00e7:
                android.view.TextureView r10 = r9.f4094j     // Catch:{ Exception -> 0x0181 }
            L_0x00e9:
                r10.unlockCanvasAndPost(r0)     // Catch:{ Exception -> 0x0181 }
                goto L_0x0179
            L_0x00ee:
                r10 = move-exception
                goto L_0x00f7
            L_0x00f0:
                r10 = move-exception
                r10.printStackTrace()     // Catch:{ all -> 0x00ee }
                android.view.TextureView r10 = r9.f4094j     // Catch:{ Exception -> 0x0181 }
                goto L_0x00e9
            L_0x00f7:
                android.view.TextureView r1 = r9.f4094j     // Catch:{ Exception -> 0x0181 }
                r1.unlockCanvasAndPost(r0)     // Catch:{ Exception -> 0x0181 }
                throw r10     // Catch:{ Exception -> 0x0181 }
            L_0x00fd:
                boolean r10 = r9.f4095k     // Catch:{ Exception -> 0x0181 }
                if (r10 == 0) goto L_0x0179
                android.view.TextureView r10 = r9.f4094j     // Catch:{ Exception -> 0x0181 }
                android.graphics.Canvas r10 = r10.lockCanvas(r2)     // Catch:{ Exception -> 0x0181 }
                if (r10 == 0) goto L_0x0179
                android.graphics.Canvas r0 = r9.f4089e     // Catch:{ Exception -> 0x0120 }
                r1 = -7829368(0xffffffffff888888, float:NaN)
                r0.drawColor(r1)     // Catch:{ Exception -> 0x0120 }
                android.graphics.Bitmap r0 = r9.f4088d     // Catch:{ Exception -> 0x0120 }
                android.graphics.Paint r1 = r9.f4090f     // Catch:{ Exception -> 0x0120 }
                r10.drawBitmap(r0, r3, r3, r1)     // Catch:{ Exception -> 0x0120 }
                android.view.TextureView r0 = r9.f4094j     // Catch:{ Exception -> 0x0181 }
            L_0x011a:
                r0.unlockCanvasAndPost(r10)     // Catch:{ Exception -> 0x0181 }
                goto L_0x0179
            L_0x011e:
                r0 = move-exception
                goto L_0x0127
            L_0x0120:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ all -> 0x011e }
                android.view.TextureView r0 = r9.f4094j     // Catch:{ Exception -> 0x0181 }
                goto L_0x011a
            L_0x0127:
                android.view.TextureView r1 = r9.f4094j     // Catch:{ Exception -> 0x0181 }
                r1.unlockCanvasAndPost(r10)     // Catch:{ Exception -> 0x0181 }
                throw r0     // Catch:{ Exception -> 0x0181 }
            L_0x012d:
                r9.f4095k = r0     // Catch:{ Exception -> 0x0181 }
                android.graphics.Paint r0 = r9.f4091g     // Catch:{ Exception -> 0x0181 }
                r1 = 1073741824(0x40000000, float:2.0)
                r0.setStrokeWidth(r1)     // Catch:{ Exception -> 0x0181 }
                android.graphics.Paint r0 = r9.f4091g     // Catch:{ Exception -> 0x0181 }
                android.graphics.Paint$Style r2 = android.graphics.Paint.Style.STROKE     // Catch:{ Exception -> 0x0181 }
                r0.setStyle(r2)     // Catch:{ Exception -> 0x0181 }
                android.graphics.Paint r0 = r9.f4091g     // Catch:{ Exception -> 0x0181 }
                r2 = -1
                r0.setColor(r2)     // Catch:{ Exception -> 0x0181 }
                android.graphics.Paint r0 = r9.f4092h     // Catch:{ Exception -> 0x0181 }
                r0.setStrokeWidth(r1)     // Catch:{ Exception -> 0x0181 }
                android.graphics.Paint r0 = r9.f4092h     // Catch:{ Exception -> 0x0181 }
                android.graphics.Paint$Style r1 = android.graphics.Paint.Style.STROKE     // Catch:{ Exception -> 0x0181 }
                r0.setStyle(r1)     // Catch:{ Exception -> 0x0181 }
                android.graphics.Paint r0 = r9.f4092h     // Catch:{ Exception -> 0x0181 }
                r1 = -65536(0xffffffffffff0000, float:NaN)
                r0.setColor(r1)     // Catch:{ Exception -> 0x0181 }
                java.lang.Object r10 = r10.obj     // Catch:{ Exception -> 0x0181 }
                android.view.TextureView r10 = (android.view.TextureView) r10     // Catch:{ Exception -> 0x0181 }
                r9.f4094j = r10     // Catch:{ Exception -> 0x0181 }
                com.meizu.camera.effectlib.panorama.PanoramaPreviewView r10 = com.meizu.camera.effectlib.panorama.PanoramaPreviewView.this     // Catch:{ Exception -> 0x0181 }
                int r10 = r10.f4083d     // Catch:{ Exception -> 0x0181 }
                com.meizu.camera.effectlib.panorama.PanoramaPreviewView r0 = com.meizu.camera.effectlib.panorama.PanoramaPreviewView.this     // Catch:{ Exception -> 0x0181 }
                int r0 = r0.f4084e     // Catch:{ Exception -> 0x0181 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x0181 }
                android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r10, r0, r1)     // Catch:{ Exception -> 0x0181 }
                r9.f4088d = r10     // Catch:{ Exception -> 0x0181 }
                android.graphics.Canvas r10 = new android.graphics.Canvas     // Catch:{ Exception -> 0x0181 }
                android.graphics.Bitmap r0 = r9.f4088d     // Catch:{ Exception -> 0x0181 }
                r10.<init>(r0)     // Catch:{ Exception -> 0x0181 }
                r9.f4089e = r10     // Catch:{ Exception -> 0x0181 }
            L_0x0179:
                android.os.ConditionVariable r10 = r9.f4087c
                r10.open()
                goto L_0x0186
            L_0x017f:
                r10 = move-exception
                goto L_0x0187
            L_0x0181:
                r10 = move-exception
                r10.printStackTrace()     // Catch:{ all -> 0x017f }
                goto L_0x0179
            L_0x0186:
                return
            L_0x0187:
                android.os.ConditionVariable r0 = r9.f4087c
                r0.open()
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.panorama.PanoramaPreviewView.C1196a.handleMessage(android.os.Message):void");
        }

        /* renamed from: a */
        public void mo14377a(int i) {
            Object[] objArr = {new Integer(i)};
            ChangeQuickRedirect changeQuickRedirect = f4085a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 485, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                this.f4087c.close();
                sendEmptyMessage(i);
                this.f4087c.block();
            }
        }

        /* renamed from: a */
        public void mo14378a(int i, Object obj) {
            Object[] objArr = {new Integer(i), obj};
            ChangeQuickRedirect changeQuickRedirect = f4085a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 486, new Class[]{Integer.TYPE, Object.class}, Void.TYPE).isSupported) {
                this.f4087c.close();
                obtainMessage(i, obj).sendToTarget();
                this.f4087c.block();
            }
        }

        /* renamed from: a */
        public void mo14379a(TextureView textureView) {
            if (!PatchProxy.proxy(new Object[]{textureView}, this, f4085a, false, 487, new Class[]{TextureView.class}, Void.TYPE).isSupported) {
                mo14378a(0, textureView);
            }
        }

        /* renamed from: a */
        public void mo14376a() {
            if (!PatchProxy.proxy(new Object[0], this, f4085a, false, 488, new Class[0], Void.TYPE).isSupported) {
                sendEmptyMessage(1);
            }
        }

        /* renamed from: b */
        public void mo14380b() {
            if (!PatchProxy.proxy(new Object[0], this, f4085a, false, 491, new Class[0], Void.TYPE).isSupported) {
                mo14377a(4);
            }
        }
    }
}
