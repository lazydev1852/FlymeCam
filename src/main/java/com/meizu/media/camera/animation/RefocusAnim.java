package com.meizu.media.camera.animation;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.animation.g */
public class RefocusAnim {

    /* renamed from: a */
    public static ChangeQuickRedirect f7694a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f7695b = false;

    /* renamed from: c */
    private Paint f7696c;

    /* renamed from: d */
    private Paint f7697d;

    /* renamed from: e */
    private float f7698e;

    /* renamed from: f */
    private float f7699f;

    /* renamed from: g */
    private float f7700g;

    /* renamed from: h */
    private String f7701h;

    /* renamed from: i */
    private String f7702i;

    /* renamed from: j */
    private RectF f7703j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public float f7704k;

    /* renamed from: l */
    private long f7705l = -1;

    /* renamed from: m */
    private boolean f7706m = false;

    /* renamed from: n */
    private boolean f7707n = false;

    /* renamed from: o */
    private IUpdateCallback f7708o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public C1803a f7709p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Handler f7710q = new Handler(new Handler.Callback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f7711a;

        public boolean handleMessage(Message message) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{message}, this, f7711a, false, 2384, new Class[]{Message.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            if (message.what == 1) {
                if (RefocusAnim.this.f7704k != 360.0f) {
                    RefocusAnim.this.f7710q.sendEmptyMessageDelayed(1, 100);
                    return true;
                }
                boolean unused = RefocusAnim.this.f7695b = false;
                RefocusAnim.this.f7709p.mo18816a(false, true);
            }
            return true;
        }
    });

    /* renamed from: com.meizu.media.camera.animation.g$a */
    /* compiled from: RefocusAnim */
    public interface C1803a {
        /* renamed from: a */
        void mo18816a(boolean z, boolean z2);
    }

    public RefocusAnim(Resources resources, IUpdateCallback eVar, C1803a aVar) {
        this.f7708o = eVar;
        this.f7709p = aVar;
        m8127b(resources);
    }

    /* renamed from: b */
    private void m8127b(Resources resources) {
        if (!PatchProxy.proxy(new Object[]{resources}, this, f7694a, false, 2374, new Class[]{Resources.class}, Void.TYPE).isSupported) {
            this.f7696c = new Paint();
            this.f7696c.setAntiAlias(true);
            this.f7696c.setDither(true);
            this.f7696c.setStyle(Paint.Style.STROKE);
            this.f7696c.setColor(resources.getColor(R.color.mz_button_text_color_coral));
            this.f7697d = new Paint();
            this.f7697d.setColor(-1);
            this.f7697d.setTextSize(resources.getDimension(R.dimen.mz_font_size_14sp));
            this.f7697d.setShadowLayer(2.0f, 0.0f, 1.0f, resources.getColor(R.color.mz_mode_name_shadow_color));
            this.f7697d.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.f7697d.setTextAlign(Paint.Align.CENTER);
            this.f7697d.setAntiAlias(true);
            this.f7702i = resources.getString(R.string.mz_refocus_hint);
            this.f7701h = resources.getString(R.string.mz_refocus_hint_handling);
            this.f7698e = (-this.f7697d.ascent()) - this.f7697d.descent();
            this.f7699f = (float) (CameraUtil.m15809a() / 2);
            this.f7700g = ((float) CameraUtil.m15881c()) - resources.getDimension(R.dimen.mz_burst_text_margin_bottom);
        }
    }

    /* renamed from: a */
    public void mo18893a(Resources resources) {
        if (!PatchProxy.proxy(new Object[]{resources}, this, f7694a, false, 2375, new Class[]{Resources.class}, Void.TYPE).isSupported) {
            float f = CaptureAnimView.f7588e;
            float f2 = f - CaptureAnimView.f7589f;
            float f3 = f - (f2 / 2.0f);
            this.f7696c.setStrokeWidth(f2);
            this.f7703j = new RectF(CaptureAnimView.f7585b - f3, CaptureAnimView.f7586c - f3, CaptureAnimView.f7585b + f3, CaptureAnimView.f7586c + f3);
        }
    }

    /* renamed from: a */
    public void mo18892a() {
        if (!PatchProxy.proxy(new Object[0], this, f7694a, false, 2376, new Class[0], Void.TYPE).isSupported) {
            this.f7710q.removeMessages(1);
            this.f7704k = 0.0f;
            this.f7705l = -1;
            this.f7695b = true;
            this.f7706m = false;
            this.f7708o.mo18841r();
        }
    }

    /* renamed from: b */
    public void mo18896b() {
        this.f7706m = true;
    }

    /* renamed from: a */
    public void mo18894a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f7694a, false, 2379, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                this.f7710q.removeMessages(1);
                this.f7695b = false;
                this.f7709p.mo18816a(false, true);
                this.f7708o.mo18841r();
                return;
            }
            this.f7710q.sendEmptyMessage(1);
        }
    }

    /* renamed from: a */
    public boolean mo18895a(Canvas canvas) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{canvas}, this, f7694a, false, 2380, new Class[]{Canvas.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f7695b) {
            m8128b(canvas);
            return true;
        } else if (!this.f7707n) {
            return false;
        } else {
            m8124a(canvas, this.f7702i);
            return true;
        }
    }

    /* renamed from: b */
    private void m8128b(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f7694a, false, 2381, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            m8123a(System.currentTimeMillis());
            canvas.drawArc(this.f7703j, 0.0f, this.f7704k, false, this.f7696c);
            if (this.f7706m) {
                m8124a(canvas, this.f7701h);
            } else {
                m8124a(canvas, this.f7702i);
            }
            this.f7708o.mo18841r();
        }
    }

    /* renamed from: a */
    private void m8124a(Canvas canvas, String str) {
        Class[] clsArr = {Canvas.class, String.class};
        if (!PatchProxy.proxy(new Object[]{canvas, str}, this, f7694a, false, 2382, clsArr, Void.TYPE).isSupported) {
            canvas.drawText(str, this.f7699f, this.f7700g - this.f7698e, this.f7697d);
        }
    }

    /* renamed from: a */
    private void m8123a(long j) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f7694a, false, 2383, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f7705l == -1) {
                this.f7705l = j;
            }
            float f = ((float) (j - this.f7705l)) / 2000.0f;
            if (f < 1.0f) {
                z = false;
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.f7704k = C1825q.m8249a(f, 1.0f) * 360.0f;
            }
            if (z) {
                this.f7704k = 360.0f;
            }
        }
    }

    /* renamed from: c */
    public boolean mo18897c() {
        return this.f7695b;
    }
}
