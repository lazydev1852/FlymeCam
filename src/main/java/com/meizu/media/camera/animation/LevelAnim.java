package com.meizu.media.camera.animation;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.AnimationUtils;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.animation.f */
public class LevelAnim {

    /* renamed from: a */
    public static ChangeQuickRedirect f7671a;

    /* renamed from: b */
    private boolean f7672b = false;

    /* renamed from: c */
    private float f7673c;

    /* renamed from: d */
    private float f7674d;

    /* renamed from: e */
    private float f7675e;

    /* renamed from: f */
    private RectF f7676f;

    /* renamed from: g */
    private Paint f7677g;

    /* renamed from: h */
    private Paint f7678h;

    /* renamed from: i */
    private int f7679i;

    /* renamed from: j */
    private int f7680j;

    /* renamed from: k */
    private float f7681k;

    /* renamed from: l */
    private float f7682l;

    /* renamed from: m */
    private float f7683m;

    /* renamed from: n */
    private long f7684n = 0;

    /* renamed from: o */
    private long f7685o = 0;

    /* renamed from: p */
    private boolean f7686p;

    /* renamed from: q */
    private int f7687q;

    /* renamed from: r */
    private int f7688r;

    /* renamed from: s */
    private int f7689s;

    /* renamed from: t */
    private long f7690t = 0;

    /* renamed from: u */
    private long f7691u = 0;

    /* renamed from: v */
    private boolean f7692v;

    /* renamed from: w */
    private IUpdateCallback f7693w;

    public LevelAnim(Resources resources, IUpdateCallback eVar) {
        this.f7693w = eVar;
        m8116b(resources);
    }

    /* renamed from: b */
    private void m8116b(Resources resources) {
        if (!PatchProxy.proxy(new Object[]{resources}, this, f7671a, false, 2368, new Class[]{Resources.class}, Void.TYPE).isSupported) {
            this.f7679i = resources.getColor(R.color.mz_level_bg);
            this.f7680j = resources.getColor(R.color.mz_level_fg);
            this.f7677g = new Paint();
            this.f7677g.setColor(this.f7680j);
            this.f7677g.setAntiAlias(true);
            this.f7677g.setDither(true);
            this.f7677g.setStyle(Paint.Style.STROKE);
            this.f7678h = new Paint(this.f7677g);
            this.f7678h.setColor(this.f7679i);
        }
    }

    /* renamed from: a */
    public void mo18889a(Resources resources) {
        if (!PatchProxy.proxy(new Object[]{resources}, this, f7671a, false, 2369, new Class[]{Resources.class}, Void.TYPE).isSupported) {
            float f = CaptureAnimView.f7588e;
            float dimension = resources.getDimension(R.dimen.mz_level_circle_thick);
            this.f7674d = f - (dimension / 2.0f);
            this.f7673c = this.f7674d * 1.1f;
            this.f7675e = this.f7674d;
            this.f7677g.setStrokeWidth(dimension);
            this.f7678h.setStrokeWidth(dimension);
            this.f7676f = new RectF(CaptureAnimView.f7585b - this.f7675e, CaptureAnimView.f7586c - this.f7675e, CaptureAnimView.f7585b + this.f7675e, CaptureAnimView.f7586c + this.f7675e);
        }
    }

    /* renamed from: a */
    public void mo18891a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7671a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2370, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!(!z || this.f7677g == null || this.f7678h == null)) {
                this.f7677g.setColor(this.f7680j);
                this.f7678h.setColor(this.f7679i);
            }
            this.f7672b = z;
            this.f7693w.mo18841r();
        }
    }

    /* renamed from: a */
    public void mo18890a(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f7671a, false, 2371, new Class[]{Canvas.class}, Void.TYPE).isSupported && this.f7672b) {
            m8117b(canvas);
        }
    }

    /* renamed from: b */
    private void m8117b(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f7671a, false, 2372, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            float f = this.f7675e - this.f7674d;
            int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i != 0) {
                float f2 = -f;
                this.f7676f.inset(f2, f2);
            }
            if (this.f7687q != this.f7688r) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                if (currentAnimationTimeMillis < this.f7691u) {
                    int i2 = (int) (currentAnimationTimeMillis - this.f7690t);
                    int i3 = this.f7689s;
                    if (!this.f7692v) {
                        i2 = -i2;
                    }
                    int i4 = i3 + ((i2 * 100) / 1000);
                    this.f7687q = i4 >= 0 ? i4 % 360 : (i4 % 360) + 360;
                    this.f7693w.mo18841r();
                } else {
                    this.f7687q = this.f7688r;
                }
            }
            canvas.save();
            canvas.rotate((float) (-this.f7687q), CaptureAnimView.f7585b, CaptureAnimView.f7586c);
            canvas.drawArc(this.f7676f, 0.0f, 180.0f, false, this.f7678h);
            if (Math.abs(this.f7682l - this.f7681k) > 10.0f) {
                long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                if (currentAnimationTimeMillis2 < this.f7685o) {
                    int i5 = (int) (currentAnimationTimeMillis2 - this.f7684n);
                    float f3 = this.f7683m;
                    if (!this.f7686p) {
                        i5 = -i5;
                    }
                    float f4 = f3 + ((float) ((i5 * 100) / 1000));
                    this.f7681k = f4 >= 0.0f ? f4 % 360.0f : (f4 % 360.0f) + 360.0f;
                    this.f7693w.mo18841r();
                } else {
                    this.f7681k = this.f7682l;
                }
            }
            canvas.drawArc(this.f7676f, -this.f7681k, 180.0f, false, this.f7677g);
            canvas.restore();
            if (i != 0) {
                this.f7676f.inset(f, f);
            }
        }
    }

    /* renamed from: a */
    public void mo18888a(int i, int i2) {
        boolean z = false;
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f7671a, false, 2373, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (Math.abs(i) > 45) {
                i = i > 0 ? 45 : -45;
            }
            this.f7682l = (float) i;
            if (Math.abs(this.f7682l - this.f7681k) > 10.0f) {
                this.f7683m = this.f7681k;
                this.f7684n = AnimationUtils.currentAnimationTimeMillis();
                float f = this.f7682l - this.f7681k;
                if (f < 0.0f) {
                    f += 360.0f;
                }
                if (f > 180.0f) {
                    f -= 360.0f;
                }
                this.f7686p = f >= 0.0f;
                this.f7685o = (long) (((float) this.f7684n) + ((Math.abs(f) * 1000.0f) / 100.0f));
                this.f7693w.mo18841r();
            }
            int i3 = i2 >= 0 ? i2 % 360 : (i2 % 360) + 360;
            if (i3 != this.f7688r) {
                this.f7688r = i3;
                this.f7689s = this.f7687q;
                this.f7690t = AnimationUtils.currentAnimationTimeMillis();
                int i4 = this.f7688r - this.f7687q;
                if (i4 < 0) {
                    i4 += 360;
                }
                if (i4 > 180) {
                    i4 -= 360;
                }
                if (i4 >= 0) {
                    z = true;
                }
                this.f7692v = z;
                this.f7691u = this.f7690t + ((long) ((Math.abs(i4) * 1000) / 100));
                this.f7693w.mo18841r();
            }
        }
    }
}
