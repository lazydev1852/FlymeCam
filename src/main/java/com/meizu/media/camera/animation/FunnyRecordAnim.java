package com.meizu.media.camera.animation;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import androidx.core.internal.view.SupportMenu;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.animation.c */
public class FunnyRecordAnim {

    /* renamed from: a */
    public static ChangeQuickRedirect f7639a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f7640b = false;

    /* renamed from: c */
    private Paint f7641c;

    /* renamed from: d */
    private Paint f7642d;

    /* renamed from: e */
    private Paint f7643e;

    /* renamed from: f */
    private RectF f7644f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f7645g;

    /* renamed from: h */
    private long f7646h = -1;

    /* renamed from: i */
    private float f7647i;

    /* renamed from: j */
    private float f7648j;

    /* renamed from: k */
    private IUpdateCallback f7649k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Handler f7650l = new Handler(new Handler.Callback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f7651a;

        public boolean handleMessage(Message message) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{message}, this, f7651a, false, 2357, new Class[]{Message.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            if (message.what == 1) {
                if (FunnyRecordAnim.this.f7645g != 360.0f) {
                    FunnyRecordAnim.this.f7650l.sendEmptyMessageDelayed(1, 100);
                    return true;
                }
                boolean unused = FunnyRecordAnim.this.f7640b = false;
            }
            return true;
        }
    });

    public FunnyRecordAnim(Resources resources, IUpdateCallback eVar) {
        this.f7649k = eVar;
        m8097b(resources);
    }

    /* renamed from: b */
    private void m8097b(Resources resources) {
        if (!PatchProxy.proxy(new Object[]{resources}, this, f7639a, false, 2350, new Class[]{Resources.class}, Void.TYPE).isSupported) {
            this.f7641c = new Paint();
            this.f7641c.setAntiAlias(true);
            this.f7641c.setDither(true);
            this.f7641c.setStyle(Paint.Style.STROKE);
            this.f7641c.setColor(-1);
            this.f7642d = new Paint();
            this.f7642d.setAntiAlias(true);
            this.f7642d.setDither(true);
            this.f7642d.setStyle(Paint.Style.FILL);
            this.f7642d.setColor(resources.getColor(R.color.mz_line_gray));
            this.f7643e = new Paint();
            this.f7643e.setAntiAlias(true);
            this.f7643e.setDither(true);
            this.f7643e.setStyle(Paint.Style.FILL);
            this.f7643e.setColor(SupportMenu.CATEGORY_MASK);
        }
    }

    /* renamed from: a */
    public void mo18877a(Resources resources) {
        if (!PatchProxy.proxy(new Object[]{resources}, this, f7639a, false, 2351, new Class[]{Resources.class}, Void.TYPE).isSupported) {
            this.f7647i = resources.getDimension(R.dimen.mz_funny_snap_record_shutter_bg_radius);
            this.f7648j = resources.getDimension(R.dimen.mz_funny_snap_record_shutter_dot_radius);
            float dimension = resources.getDimension(R.dimen.mz_funny_snap_record_shutter_ring_width);
            float f = this.f7647i - (dimension / 2.0f);
            this.f7641c.setStrokeWidth(dimension);
            this.f7644f = new RectF(CaptureAnimView.f7585b - f, CaptureAnimView.f7586c - f, CaptureAnimView.f7585b + f, CaptureAnimView.f7586c + f);
        }
    }

    /* renamed from: a */
    public void mo18876a() {
        if (!PatchProxy.proxy(new Object[0], this, f7639a, false, 2352, new Class[0], Void.TYPE).isSupported) {
            this.f7650l.removeMessages(1);
            this.f7645g = -90.0f;
            this.f7646h = -1;
            this.f7640b = true;
            this.f7649k.mo18841r();
        }
    }

    /* renamed from: a */
    public void mo18878a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f7639a, false, 2353, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                this.f7650l.removeMessages(1);
                this.f7640b = false;
                this.f7649k.mo18841r();
                return;
            }
            this.f7650l.sendEmptyMessage(1);
        }
    }

    /* renamed from: a */
    public boolean mo18879a(Canvas canvas) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{canvas}, this, f7639a, false, 2354, new Class[]{Canvas.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!this.f7640b) {
            return false;
        }
        m8099c(canvas);
        m8098b(canvas);
        return true;
    }

    /* renamed from: b */
    private void m8098b(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f7639a, false, 2355, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            m8094a(System.currentTimeMillis());
            canvas.drawArc(this.f7644f, -90.0f, this.f7645g, false, this.f7641c);
            this.f7649k.mo18841r();
        }
    }

    /* renamed from: c */
    private void m8099c(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f7639a, false, 2356, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            canvas.drawCircle(CaptureAnimView.f7585b, CaptureAnimView.f7586c, this.f7648j, this.f7643e);
            canvas.drawCircle(CaptureAnimView.f7585b, CaptureAnimView.f7586c, this.f7647i, this.f7642d);
        }
    }

    /* renamed from: a */
    private void m8094a(long j) {
        if (this.f7646h == -1) {
            this.f7646h = j;
        }
        float f = ((float) (j - this.f7646h)) / 10000.0f;
        boolean z = f >= 1.0f;
        if (f >= 0.0f && f <= 1.0f) {
            this.f7645g = f * 360.0f;
        }
        if (z) {
            this.f7645g = 360.0f;
        }
    }
}
