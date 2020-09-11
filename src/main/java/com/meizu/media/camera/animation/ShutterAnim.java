package com.meizu.media.camera.animation;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Typeface;
import android.view.animation.PathInterpolator;
import com.baidu.p020ar.base.MsgField;
import com.meizu.media.camera.R;
import com.meizu.media.camera.mode.ManualMode;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.animation.i */
public class ShutterAnim {

    /* renamed from: a */
    public static ChangeQuickRedirect f7730a;

    /* renamed from: A */
    private float f7731A;

    /* renamed from: B */
    private float f7732B;

    /* renamed from: C */
    private float f7733C;

    /* renamed from: D */
    private Typeface f7734D;

    /* renamed from: E */
    private boolean f7735E = false;

    /* renamed from: F */
    private boolean f7736F = false;

    /* renamed from: G */
    private boolean f7737G = false;

    /* renamed from: H */
    private boolean f7738H = false;

    /* renamed from: I */
    private Resources f7739I;

    /* renamed from: J */
    private IUpdateCallback f7740J;

    /* renamed from: K */
    private C1809a f7741K;

    /* renamed from: L */
    private PathInterpolator f7742L;

    /* renamed from: M */
    private PathInterpolator f7743M;

    /* renamed from: b */
    private boolean f7744b = false;

    /* renamed from: c */
    private boolean f7745c = false;

    /* renamed from: d */
    private boolean f7746d = false;

    /* renamed from: e */
    private boolean f7747e = false;

    /* renamed from: f */
    private boolean f7748f = false;

    /* renamed from: g */
    private boolean f7749g = false;

    /* renamed from: h */
    private long f7750h = -1;

    /* renamed from: i */
    private float f7751i;

    /* renamed from: j */
    private float f7752j;

    /* renamed from: k */
    private Matrix f7753k;

    /* renamed from: l */
    private Bitmap f7754l;

    /* renamed from: m */
    private long f7755m = 0;

    /* renamed from: n */
    private long f7756n = 0;

    /* renamed from: o */
    private boolean f7757o = false;

    /* renamed from: p */
    private float f7758p;

    /* renamed from: q */
    private Matrix f7759q;

    /* renamed from: r */
    private Bitmap f7760r;

    /* renamed from: s */
    private PaintFlagsDrawFilter f7761s;

    /* renamed from: t */
    private boolean f7762t = true;

    /* renamed from: u */
    private String f7763u;

    /* renamed from: v */
    private Paint f7764v;

    /* renamed from: w */
    private float f7765w;

    /* renamed from: x */
    private float f7766x;

    /* renamed from: y */
    private float f7767y;

    /* renamed from: z */
    private Paint f7768z;

    /* renamed from: com.meizu.media.camera.animation.i$a */
    /* compiled from: ShutterAnim */
    public interface C1809a {
        /* renamed from: a */
        void mo18816a(boolean z, boolean z2);

        /* renamed from: s */
        void mo18842s();

        /* renamed from: t */
        void mo18845t();

        /* renamed from: u */
        void mo18846u();
    }

    /* renamed from: a */
    public boolean mo18920a() {
        return this.f7755m > 1000;
    }

    public ShutterAnim(Resources resources, IUpdateCallback eVar, C1809a aVar) {
        this.f7740J = eVar;
        this.f7741K = aVar;
        this.f7739I = resources;
        m8150a(resources);
        this.f7752j = 1.0f;
        this.f7742L = new PathInterpolator(0.05f, 0.0f, 0.1f, 1.0f);
        this.f7743M = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    }

    /* renamed from: a */
    private void m8150a(Resources resources) {
        if (!PatchProxy.proxy(new Object[]{resources}, this, f7730a, false, 2394, new Class[]{Resources.class}, Void.TYPE).isSupported) {
            this.f7754l = BitmapFactory.decodeResource(resources, R.drawable.mz_btn_shutter_default);
            this.f7760r = BitmapFactory.decodeResource(resources, R.drawable.mz_btn_shutter_bg);
            this.f7761s = new PaintFlagsDrawFilter(0, 3);
            this.f7751i = 1.0f;
            this.f7758p = 1.0f;
            this.f7753k = new Matrix();
            this.f7759q = new Matrix();
            this.f7764v = new Paint();
            this.f7764v.setColor(-1);
            this.f7734D = Typeface.create("sans-serif-medium", 0);
            this.f7764v.setTextSize(resources.getDimension(R.dimen.mz_font_size_14sp));
            this.f7764v.setTextAlign(Paint.Align.CENTER);
            this.f7764v.setTypeface(this.f7734D);
            this.f7764v.setShadowLayer(2.0f, 0.0f, 1.0f, resources.getColor(R.color.mz_mode_name_shadow_color));
            this.f7764v.setAntiAlias(true);
            this.f7768z = new Paint(this.f7764v);
            this.f7734D = Typeface.create("SFDIN-Medium", 0);
            this.f7768z.setTypeface(this.f7734D);
            this.f7768z.setShadowLayer(2.0f, 0.0f, 1.0f, resources.getColor(R.color.mz_mode_name_shadow_color));
            this.f7768z.setTextSize(resources.getDimension(R.dimen.mz_font_size_18sp));
            this.f7731A = -this.f7768z.getFontMetrics().ascent;
            this.f7732B = (float) (CameraUtil.m15809a() / 2);
            this.f7767y = (-this.f7764v.ascent()) - this.f7764v.descent();
            this.f7765w = (float) (CameraUtil.m15809a() / 2);
            m8153b(resources);
        }
    }

    /* renamed from: b */
    private void m8153b(Resources resources) {
        if (!PatchProxy.proxy(new Object[]{resources}, this, f7730a, false, 2395, new Class[]{Resources.class}, Void.TYPE).isSupported && resources != null) {
            if (!this.f7738H) {
                this.f7766x = ((float) CameraUtil.m15865b()) - (((float) (CameraUtil.m15897f() + resources.getDimensionPixelOffset(R.dimen.mz_manual_wheel_view_height))) + resources.getDimension(R.dimen.mz_manual_capture_hint_marginBottom));
            }
            if (NavigationBarUtils.m15972a() || this.f7738H) {
                this.f7766x = ((float) CameraUtil.m15865b()) - (((float) CameraUtil.m15897f()) + resources.getDimension(R.dimen.mz_manual_capture_hint_marginBottom));
            }
            this.f7733C = resources.getDimension(R.dimen.mz_shutter_time_hint_vertical_position);
            if (!DeviceHelper.f13874aa && NavigationBarUtils.m15973a(resources)) {
                this.f7733C -= (float) resources.getDimensionPixelSize(R.dimen.mz_camera_navigation_bar_height);
            }
        }
    }

    /* renamed from: b */
    public void mo18921b() {
        if (!PatchProxy.proxy(new Object[0], this, f7730a, false, 2396, new Class[0], Void.TYPE).isSupported && this.f7750h == -1 && !this.f7744b && !this.f7736F && !this.f7745c && !this.f7746d) {
            this.f7744b = true;
            if (this.f7755m > ManualMode.f10868b) {
                this.f7757o = true;
            }
            this.f7740J.mo18841r();
        }
    }

    /* renamed from: a */
    public void mo18919a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7730a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2397, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported && this.f7750h == -1 && !this.f7744b && !this.f7736F && !this.f7745c && !this.f7746d) {
            this.f7744b = true;
            this.f7746d = true;
            this.f7748f = z2;
            this.f7749g = z;
            this.f7740J.mo18841r();
        }
    }

    /* renamed from: c */
    public void mo18922c() {
        if (!PatchProxy.proxy(new Object[0], this, f7730a, false, 2398, new Class[0], Void.TYPE).isSupported) {
            this.f7737G = true;
            this.f7740J.mo18841r();
        }
    }

    /* renamed from: d */
    public void mo18923d() {
        if (!PatchProxy.proxy(new Object[0], this, f7730a, false, 2399, new Class[0], Void.TYPE).isSupported) {
            this.f7735E = true;
            this.f7740J.mo18841r();
        }
    }

    /* renamed from: e */
    public void mo18924e() {
        if (!PatchProxy.proxy(new Object[0], this, f7730a, false, MsgField.MSG_PADDLE_INIT, new Class[0], Void.TYPE).isSupported) {
            this.f7744b = false;
            this.f7740J.mo18841r();
            this.f7741K.mo18846u();
            this.f7741K.mo18816a(true, false);
            this.f7751i = 1.0f;
            this.f7750h = -1;
            this.f7745c = false;
            this.f7757o = false;
        }
    }

    /* renamed from: a */
    public void mo18917a(long j, boolean z) {
        Object[] objArr = {new Long(j), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7730a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, MsgField.MSG_PADDLE_GESTURE_ENABLE, new Class[]{Long.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f7755m = j;
            if (this.f7738H != z) {
                this.f7738H = z;
                m8153b(this.f7739I);
            }
            this.f7762t = true;
        }
    }

    /* renamed from: f */
    public void mo18925f() {
        if (!PatchProxy.proxy(new Object[0], this, f7730a, false, 2402, new Class[0], Void.TYPE).isSupported && this.f7735E && this.f7736F) {
            this.f7736F = false;
            this.f7750h = -1;
            this.f7745c = true;
            this.f7740J.mo18841r();
        }
    }

    /* renamed from: a */
    private void m8151a(Canvas canvas, String str) {
        Class[] clsArr = {Canvas.class, String.class};
        if (!PatchProxy.proxy(new Object[]{canvas, str}, this, f7730a, false, 2403, clsArr, Void.TYPE).isSupported) {
            canvas.drawText(C1825q.m8253a(this.f7756n), this.f7732B, this.f7733C + this.f7731A, this.f7768z);
        }
    }

    /* renamed from: a */
    public void mo18918a(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f7730a, false, 2404, new Class[]{Canvas.class}, Void.TYPE).isSupported && this.f7744b) {
            if (!this.f7736F) {
                if (this.f7757o) {
                    m8152b(System.currentTimeMillis());
                } else if (this.f7745c) {
                    m8155c(System.currentTimeMillis());
                } else if (this.f7746d) {
                    m8156d(System.currentTimeMillis());
                } else {
                    m8149a(System.currentTimeMillis());
                }
            }
            if (this.f7757o) {
                m8154b(canvas);
            }
            if (this.f7757o) {
                m8151a(canvas, this.f7763u);
            }
            this.f7740J.mo18841r();
        }
    }

    /* renamed from: b */
    private void m8154b(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f7730a, false, 2406, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            if (this.f7762t) {
                this.f7762t = false;
                return;
            }
            canvas.save();
            this.f7759q.reset();
            this.f7759q.preTranslate(CaptureAnimView.f7585b - CaptureAnimView.f7588e, CaptureAnimView.f7586c - CaptureAnimView.f7588e);
            this.f7759q.preScale(this.f7758p, this.f7758p, CaptureAnimView.f7588e, CaptureAnimView.f7588e);
            canvas.drawBitmap(this.f7760r, this.f7759q, (Paint) null);
            canvas.restore();
        }
    }

    /* renamed from: a */
    private void m8149a(long j) {
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f7730a, false, 2407, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f7750h == -1) {
                this.f7750h = j;
                this.f7741K.mo18842s();
            }
            float f = ((float) (j - this.f7750h)) / 100.0f;
            boolean z = f >= 1.0f;
            if (f >= 0.0f && f <= 1.0f) {
                this.f7751i = 1.0f - (this.f7742L.getInterpolation(f) * 0.100000024f);
            }
            if (z) {
                this.f7751i = 0.9f;
                if (this.f7735E) {
                    this.f7736F = true;
                } else if (this.f7737G) {
                    this.f7745c = true;
                    this.f7737G = false;
                }
                this.f7750h = -1;
            }
        }
    }

    /* renamed from: b */
    private void m8152b(long j) {
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f7730a, false, 2408, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f7750h == -1) {
                this.f7750h = j;
                this.f7756n = this.f7755m;
                this.f7741K.mo18842s();
                this.f7741K.mo18845t();
            }
            long j2 = this.f7755m;
            long j3 = j - this.f7750h;
            float f = ((float) j3) / ((float) j2);
            boolean z = f >= 1.0f;
            if (f >= 0.0f && f <= 1.0f) {
                this.f7756n = j2 - j3;
            }
            float f2 = ((float) (j - this.f7750h)) / 160.0f;
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.f7752j = 1.0f - (this.f7743M.getInterpolation(f2) * 0.65f);
            }
            if (z) {
                this.f7750h = -1;
                this.f7757o = false;
                this.f7746d = true;
                this.f7755m = 0;
                this.f7758p = 1.0f;
                this.f7756n = 0;
                this.f7741K.mo18846u();
            }
        }
    }

    /* renamed from: c */
    private void m8155c(long j) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f7730a, false, 2409, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f7750h == -1) {
                this.f7750h = j;
            }
            float f = ((float) (j - this.f7750h)) / 100.0f;
            if (f < 1.0f) {
                z = false;
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.f7751i = (this.f7742L.getInterpolation(f) * 0.100000024f) + 0.9f;
            }
            if (z) {
                this.f7751i = 1.0f;
                this.f7750h = -1;
                this.f7745c = false;
                this.f7744b = false;
                this.f7741K.mo18816a(this.f7735E, false);
                this.f7735E = false;
            }
        }
    }

    /* renamed from: d */
    private void m8156d(long j) {
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f7730a, false, 2410, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f7750h == -1) {
                this.f7750h = j;
            }
            float f = ((float) (j - this.f7750h)) / 160.0f;
            boolean z = f >= 1.0f;
            if (f >= 0.0f && f <= 1.0f) {
                float interpolation = this.f7743M.getInterpolation(f);
                if (this.f7749g) {
                    this.f7752j = 1.0f - (interpolation * 0.65f);
                } else {
                    this.f7752j = (interpolation * 0.65f) + 0.35f;
                }
            }
            if (z) {
                this.f7750h = -1;
                this.f7746d = false;
                this.f7744b = false;
                this.f7741K.mo18816a(this.f7735E, true ^ this.f7748f);
                this.f7748f = false;
                this.f7735E = false;
            }
        }
    }
}
