package com.meizu.media.camera.animation;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.view.animation.PathInterpolator;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.animation.p */
public class TimeLoadingAnim {

    /* renamed from: a */
    public static ChangeQuickRedirect f7873a;

    /* renamed from: b */
    private float f7874b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f7875c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f7876d = false;

    /* renamed from: e */
    private Paint f7877e;

    /* renamed from: f */
    private Paint f7878f;

    /* renamed from: g */
    private float f7879g;

    /* renamed from: h */
    private float f7880h;

    /* renamed from: i */
    private float f7881i;

    /* renamed from: j */
    private String f7882j;

    /* renamed from: k */
    private String f7883k;

    /* renamed from: l */
    private RectF f7884l;

    /* renamed from: m */
    private int f7885m = -1;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public float f7886n;

    /* renamed from: o */
    private long f7887o = -1;

    /* renamed from: p */
    private long f7888p = -1;

    /* renamed from: q */
    private boolean f7889q = false;

    /* renamed from: r */
    private boolean f7890r = false;

    /* renamed from: s */
    private boolean f7891s = true;

    /* renamed from: t */
    private IUpdateCallback f7892t;

    /* renamed from: u */
    private PathInterpolator f7893u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Handler f7894v = new Handler(new Handler.Callback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f7895a;

        public boolean handleMessage(Message message) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{message}, this, f7895a, false, 2479, new Class[]{Message.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            if (message.what == 1) {
                if (TimeLoadingAnim.this.f7886n != 360.0f) {
                    TimeLoadingAnim.this.f7894v.sendEmptyMessageDelayed(1, 100);
                    return true;
                }
                boolean unused = TimeLoadingAnim.this.f7875c = false;
                boolean unused2 = TimeLoadingAnim.this.f7876d = true;
            }
            return true;
        }
    });

    public TimeLoadingAnim(Resources resources, IUpdateCallback eVar) {
        this.f7892t = eVar;
        this.f7893u = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        m8239b(resources);
    }

    /* renamed from: b */
    private void m8239b(Resources resources) {
        if (!PatchProxy.proxy(new Object[]{resources}, this, f7873a, false, 2467, new Class[]{Resources.class}, Void.TYPE).isSupported) {
            this.f7877e = new Paint();
            this.f7877e.setAntiAlias(true);
            this.f7877e.setDither(true);
            this.f7877e.setStyle(Paint.Style.STROKE);
            this.f7877e.setColor(resources.getColor(R.color.white));
            this.f7877e.setStrokeCap(Paint.Cap.ROUND);
            this.f7878f = new Paint();
            this.f7878f.setColor(-1);
            this.f7878f.setTextSize(resources.getDimension(R.dimen.mz_font_size_14sp));
            this.f7878f.setTextAlign(Paint.Align.CENTER);
            this.f7878f.setAntiAlias(true);
            this.f7878f.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.f7878f.setShadowLayer(2.0f, 0.0f, 1.0f, resources.getColor(R.color.mz_mode_name_shadow_color));
            this.f7883k = resources.getString(R.string.mz_refocus_hint);
            this.f7882j = resources.getString(R.string.mz_refocus_hint_handling);
            this.f7879g = -this.f7878f.getFontMetrics().ascent;
            this.f7880h = (float) (CameraUtil.m15809a() / 2);
            this.f7881i = resources.getDimension(R.dimen.mz_shutter_time_loading_vertical_position);
            if (!DeviceHelper.f13874aa && NavigationBarUtils.m15973a(resources)) {
                this.f7881i -= (float) resources.getDimensionPixelSize(R.dimen.mz_camera_navigation_bar_height);
            }
        }
    }

    /* renamed from: a */
    public void mo18979a(Resources resources) {
        if (!PatchProxy.proxy(new Object[]{resources}, this, f7873a, false, 2468, new Class[]{Resources.class}, Void.TYPE).isSupported) {
            float dimension = resources.getDimension(R.dimen.mz_shutter_time_loading_thick);
            float dimension2 = resources.getDimension(R.dimen.mz_shutter_time_loading_radius);
            this.f7877e.setStrokeWidth(dimension);
            this.f7884l = new RectF(CaptureAnimView.f7585b - dimension2, CaptureAnimView.f7586c - dimension2, CaptureAnimView.f7585b + dimension2, CaptureAnimView.f7586c + dimension2);
        }
    }

    /* renamed from: a */
    public void mo18978a(int i, boolean z) {
        Object[] objArr = {new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7873a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2469, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f7894v.removeMessages(1);
            this.f7885m = i;
            this.f7874b = 1.0f;
            this.f7886n = 0.0f;
            this.f7887o = -1;
            this.f7875c = true;
            this.f7891s = true;
            this.f7890r = z;
            this.f7892t.mo18841r();
        }
    }

    /* renamed from: a */
    public void mo18977a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f7873a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2470, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            mo18978a(i, true);
        }
    }

    /* renamed from: a */
    public void mo18976a() {
        if (!PatchProxy.proxy(new Object[0], this, f7873a, false, 2471, new Class[0], Void.TYPE).isSupported) {
            this.f7889q = true;
            this.f7892t.mo18841r();
        }
    }

    /* renamed from: b */
    public void mo18982b() {
        if (!PatchProxy.proxy(new Object[0], this, f7873a, false, 2472, new Class[0], Void.TYPE).isSupported) {
            this.f7889q = false;
            this.f7892t.mo18841r();
        }
    }

    /* renamed from: a */
    public void mo18980a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f7873a, false, 2473, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                this.f7894v.removeMessages(1);
                this.f7874b = 0.0f;
                this.f7875c = false;
                this.f7876d = false;
                this.f7892t.mo18841r();
            } else if (this.f7886n >= 360.0f) {
                this.f7875c = false;
                this.f7876d = true;
                this.f7892t.mo18841r();
            } else {
                if (this.f7875c) {
                    this.f7891s = false;
                }
                this.f7894v.sendEmptyMessage(1);
            }
        }
    }

    /* renamed from: a */
    public boolean mo18981a(Canvas canvas) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{canvas}, this, f7873a, false, 2474, new Class[]{Canvas.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f7876d) {
            m8238b(System.currentTimeMillis());
            m8235a(canvas, false);
            return true;
        } else if (this.f7875c) {
            m8233a(System.currentTimeMillis());
            m8235a(canvas, this.f7891s);
            return true;
        } else if (!this.f7889q) {
            return false;
        } else {
            m8234a(canvas, this.f7883k);
            return true;
        }
    }

    /* renamed from: a */
    private void m8235a(Canvas canvas, boolean z) {
        if (!PatchProxy.proxy(new Object[]{canvas, new Byte(z ? (byte) 1 : 0)}, this, f7873a, false, 2475, new Class[]{Canvas.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f7877e.setAlpha((int) (this.f7874b * 255.0f));
            canvas.drawArc(this.f7884l, 270.0f, this.f7886n, false, this.f7877e);
            if (z) {
                m8234a(canvas, this.f7883k);
            }
            this.f7892t.mo18841r();
        }
    }

    /* renamed from: a */
    private void m8234a(Canvas canvas, String str) {
        Class[] clsArr = {Canvas.class, String.class};
        if (!PatchProxy.proxy(new Object[]{canvas, str}, this, f7873a, false, 2476, clsArr, Void.TYPE).isSupported) {
            canvas.drawText(str, this.f7880h, this.f7881i + this.f7879g, this.f7878f);
        }
    }

    /* renamed from: a */
    private void m8233a(long j) {
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f7873a, false, 2477, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f7887o == -1) {
                this.f7887o = j;
            }
            float f = ((float) (j - this.f7887o)) / ((float) this.f7885m);
            boolean z = f >= 1.0f;
            if (f >= 0.0f && f <= 1.0f) {
                this.f7886n = C1825q.m8249a(f, 1.0f) * 360.0f;
            }
            if (z) {
                if (this.f7890r) {
                    this.f7875c = false;
                    this.f7876d = true;
                    this.f7888p = -1;
                    this.f7887o = -1;
                }
                this.f7886n = 360.0f;
            }
        }
    }

    /* renamed from: b */
    private void m8238b(long j) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f7873a, false, 2478, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f7888p == -1) {
                this.f7888p = j;
            }
            float f = ((float) (j - this.f7888p)) / 160.0f;
            if (f < 1.0f) {
                z = false;
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.f7874b = 1.0f - (this.f7893u.getInterpolation(f) * 1.0f);
            }
            if (z) {
                this.f7888p = -1;
                this.f7876d = false;
            }
        }
    }

    /* renamed from: c */
    public boolean mo18983c() {
        return this.f7875c;
    }
}
