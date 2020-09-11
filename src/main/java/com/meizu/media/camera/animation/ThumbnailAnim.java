package com.meizu.media.camera.animation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.SystemClock;
import android.view.animation.PathInterpolator;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.animation.n */
public class ThumbnailAnim {

    /* renamed from: a */
    public static ChangeQuickRedirect f7841a;

    /* renamed from: i */
    private static float f7842i;

    /* renamed from: b */
    private Paint f7843b;

    /* renamed from: c */
    private PorterDuffXfermode f7844c;

    /* renamed from: d */
    private Bitmap f7845d;

    /* renamed from: e */
    private float f7846e;

    /* renamed from: f */
    private float f7847f = -1.0f;

    /* renamed from: g */
    private float f7848g;

    /* renamed from: h */
    private Matrix f7849h;

    /* renamed from: j */
    private float f7850j;

    /* renamed from: k */
    private long f7851k = -1;

    /* renamed from: l */
    private int f7852l = 120;

    /* renamed from: m */
    private boolean f7853m = false;

    /* renamed from: n */
    private int f7854n;

    /* renamed from: o */
    private IUpdateCallback f7855o;

    /* renamed from: p */
    private C1820a f7856p;

    /* renamed from: q */
    private PathInterpolator f7857q;

    /* renamed from: com.meizu.media.camera.animation.n$a */
    /* compiled from: ThumbnailAnim */
    public interface C1820a {
        /* renamed from: v */
        void mo18847v();
    }

    public ThumbnailAnim(IUpdateCallback eVar, C1820a aVar) {
        this.f7855o = eVar;
        this.f7856p = aVar;
        m8205a();
    }

    /* renamed from: a */
    private void m8205a() {
        if (!PatchProxy.proxy(new Object[0], this, f7841a, false, 2455, new Class[0], Void.TYPE).isSupported) {
            this.f7846e = ((float) CameraUtil.m15903i()) / 2.0f;
            f7842i = (float) CameraUtil.m15903i();
            this.f7850j = f7842i;
            this.f7849h = new Matrix();
            this.f7844c = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            this.f7843b = new Paint();
            this.f7843b.setStyle(Paint.Style.STROKE);
            this.f7843b.setStrokeWidth(this.f7846e * 2.0f);
            this.f7857q = new PathInterpolator(0.16f, 0.0f, 0.16f, 1.0f);
        }
    }

    /* renamed from: a */
    public void mo18961a(float f, float f2) {
        if (this.f7847f == -1.0f) {
            this.f7847f = f;
            this.f7848g = f2;
        }
    }

    /* renamed from: a */
    public void mo18962a(int i) {
        this.f7854n = i;
    }

    /* renamed from: a */
    public void mo18963a(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f7841a, false, 2457, new Class[]{Canvas.class}, Void.TYPE).isSupported && this.f7853m) {
            m8207b(canvas);
        }
    }

    /* renamed from: b */
    private void m8207b(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f7841a, false, 2458, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            m8206a(SystemClock.uptimeMillis());
            int saveLayer = canvas.saveLayer(this.f7847f - this.f7846e, this.f7848g - (this.f7846e * 3.0f), this.f7847f + this.f7846e, this.f7848g + this.f7846e, (Paint) null, 31);
            this.f7849h.reset();
            this.f7849h.postTranslate(this.f7847f - this.f7846e, (this.f7848g - this.f7846e) - this.f7850j);
            this.f7849h.postRotate((float) (360 - this.f7854n), this.f7847f, this.f7848g - this.f7850j);
            try {
                canvas.drawBitmap(this.f7845d, this.f7849h, (Paint) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f7843b.setXfermode(this.f7844c);
            canvas.drawCircle(this.f7847f, this.f7848g, this.f7846e * 2.0f, this.f7843b);
            this.f7843b.setXfermode((Xfermode) null);
            canvas.restoreToCount(saveLayer);
            this.f7855o.mo18841r();
        }
    }

    /* renamed from: a */
    private void m8206a(long j) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f7841a, false, 2459, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f7851k == -1) {
                this.f7851k = j;
            }
            float f = ((float) (j - this.f7851k)) / ((float) this.f7852l);
            if (f < 1.0f) {
                z = false;
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.f7850j = f7842i - ((f7842i - 0.0f) * this.f7857q.getInterpolation(f));
            }
            if (z) {
                this.f7853m = false;
                this.f7855o.mo18841r();
                this.f7856p.mo18847v();
            }
        }
    }

    /* renamed from: a */
    public void mo18960a(float f) {
        this.f7848g = f;
    }
}
