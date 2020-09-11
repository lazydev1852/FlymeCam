package com.meizu.media.camera.animation;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.animation.PathInterpolator;
import com.baidu.p020ar.base.MsgField;
import com.meizu.camera.MeizuCamera;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.animation.j */
public class SplashAnim {

    /* renamed from: a */
    public static ChangeQuickRedirect f7769a;

    /* renamed from: b */
    private RectF f7770b;

    /* renamed from: c */
    private int f7771c = 0;

    /* renamed from: d */
    private long f7772d = -1;

    /* renamed from: e */
    private boolean f7773e = false;

    /* renamed from: f */
    private boolean f7774f = false;

    /* renamed from: g */
    private C1810a f7775g;

    /* renamed from: h */
    private PathInterpolator f7776h;

    /* renamed from: i */
    private IUpdateCallback f7777i;

    /* renamed from: com.meizu.media.camera.animation.j$a */
    /* compiled from: SplashAnim */
    public interface C1810a {
        /* renamed from: a */
        void mo18929a();
    }

    public SplashAnim(IUpdateCallback eVar) {
        this.f7777i = eVar;
        this.f7776h = new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);
    }

    /* renamed from: a */
    public void mo18928a(C1810a aVar) {
        this.f7775g = aVar;
    }

    /* renamed from: a */
    public void mo18927a(RectF rectF) {
        if (!PatchProxy.proxy(new Object[]{rectF}, this, f7769a, false, MsgField.MSG_PADDLE_IMG_SEG_ENABLE, new Class[]{RectF.class}, Void.TYPE).isSupported) {
            if (!(this.f7770b != null && this.f7770b.height() == rectF.height() && this.f7770b.top == rectF.top)) {
                this.f7770b = new RectF(rectF);
            }
            this.f7771c = 0;
            this.f7773e = true;
            this.f7777i.mo18841r();
        }
    }

    /* renamed from: a */
    public void mo18926a(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f7769a, false, 2412, new Class[]{Canvas.class}, Void.TYPE).isSupported && this.f7773e) {
            m8172b(canvas);
        }
    }

    /* renamed from: b */
    private void m8172b(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f7769a, false, 2413, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            if (this.f7774f) {
                m8171b(System.currentTimeMillis());
            } else {
                m8170a(System.currentTimeMillis());
            }
            canvas.save();
            canvas.clipRect(this.f7770b);
            canvas.drawARGB(this.f7771c, 0, 0, 0);
            canvas.restore();
            this.f7777i.mo18841r();
        }
    }

    /* renamed from: a */
    private void m8170a(long j) {
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f7769a, false, 2414, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f7772d == -1) {
                this.f7772d = j;
            }
            float f = ((float) (j - this.f7772d)) / 40.0f;
            boolean z = f >= 1.0f;
            if (f >= 0.0f && f <= 1.0f) {
                this.f7771c = ((int) (this.f7776h.getInterpolation(f) * 204.0f)) + 0;
            }
            if (z) {
                this.f7772d = -1;
                this.f7771c = MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY;
                this.f7774f = true;
                m8171b(j);
            }
        }
    }

    /* renamed from: b */
    private void m8171b(long j) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f7769a, false, 2415, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f7772d == -1) {
                if (this.f7775g != null) {
                    this.f7775g.mo18929a();
                }
                this.f7772d = j;
            }
            float f = ((float) (j - this.f7772d)) / 120.0f;
            if (f < 1.0f) {
                z = false;
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.f7771c = 204 - ((int) (this.f7776h.getInterpolation(f) * 204.0f));
            }
            if (z) {
                this.f7772d = -1;
                this.f7771c = 0;
                this.f7773e = false;
                this.f7774f = false;
            }
        }
    }
}
