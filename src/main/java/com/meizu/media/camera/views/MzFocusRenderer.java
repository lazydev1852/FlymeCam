package com.meizu.media.camera.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.animation.PathInterpolator;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.meizu.media.camera.R;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.views.g */
public class MzFocusRenderer extends OverlayRenderer implements FocusIndicator, Rotatable {

    /* renamed from: A */
    private static final LogUtil.C2630a f15295A = new LogUtil.C2630a("MzFocusRenderer");

    /* renamed from: Q */
    private static final PathInterpolator f15296Q = new PathInterpolator(0.18f, 0.17f, 0.05f, 1.0f);

    /* renamed from: R */
    private static final PathInterpolator f15297R = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: a */
    public static ChangeQuickRedirect f15298a;

    /* renamed from: B */
    private volatile int f15299B;

    /* renamed from: C */
    private float f15300C = 1.5f;

    /* renamed from: D */
    private long f15301D = -1;

    /* renamed from: E */
    private Matrix f15302E = new Matrix();

    /* renamed from: F */
    private int f15303F;

    /* renamed from: G */
    private int f15304G;

    /* renamed from: H */
    private int f15305H;

    /* renamed from: I */
    private int f15306I;

    /* renamed from: J */
    private int f15307J;

    /* renamed from: K */
    private RectF f15308K;

    /* renamed from: L */
    private Bitmap f15309L;

    /* renamed from: M */
    private Bitmap f15310M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public int f15311N = 255;

    /* renamed from: O */
    private Runnable f15312O = new C2742a();

    /* renamed from: P */
    private Runnable f15313P = new C2744c();

    /* renamed from: S */
    private boolean f15314S = false;

    /* renamed from: T */
    private Paint f15315T;

    /* renamed from: U */
    private PaintFlagsDrawFilter f15316U;

    /* renamed from: V */
    private C2745d f15317V;

    /* renamed from: W */
    private RectF f15318W = new RectF();

    /* renamed from: X */
    private C2743b f15319X;

    /* renamed from: Y */
    private float f15320Y;

    /* renamed from: Z */
    private float f15321Z;

    /* renamed from: aa */
    private float f15322aa;

    /* renamed from: ab */
    private float f15323ab;

    /* renamed from: ac */
    private float f15324ac;

    /* renamed from: ad */
    private float f15325ad;

    /* renamed from: ae */
    private float f15326ae;

    /* renamed from: af */
    private float f15327af;

    /* renamed from: b */
    int f15328b;

    /* renamed from: c */
    int f15329c = 2;

    /* renamed from: d */
    float f15330d;

    /* renamed from: e */
    float f15331e;

    /* renamed from: f */
    int f15332f;

    /* renamed from: g */
    int f15333g;

    /* renamed from: h */
    float f15334h;

    /* renamed from: i */
    float f15335i;

    /* renamed from: j */
    float f15336j;

    /* renamed from: k */
    float f15337k;

    /* renamed from: l */
    boolean f15338l = false;

    /* renamed from: m */
    int f15339m;

    /* renamed from: n */
    int f15340n;

    /* renamed from: o */
    boolean f15341o = true;

    /* renamed from: p */
    boolean f15342p = false;

    /* renamed from: q */
    int f15343q = 0;

    /* renamed from: r */
    int f15344r = 0;

    /* renamed from: s */
    boolean f15345s = false;

    /* renamed from: com.meizu.media.camera.views.g$b */
    /* compiled from: MzFocusRenderer */
    public interface C2743b {
        /* renamed from: a */
        void mo20247a();

        /* renamed from: a */
        void mo20248a(float f);

        /* renamed from: b */
        void mo20249b();
    }

    /* renamed from: com.meizu.media.camera.views.g$d */
    /* compiled from: MzFocusRenderer */
    public interface C2745d {
        /* renamed from: B */
        C2743b mo20378B();
    }

    /* renamed from: b */
    public void mo22845b(boolean z) {
    }

    /* renamed from: e */
    public void mo23338e(boolean z) {
    }

    /* renamed from: com.meizu.media.camera.views.g$a */
    /* compiled from: MzFocusRenderer */
    private class C2742a implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f15346a;

        private C2742a() {
        }

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f15346a, false, 8587, new Class[0], Void.TYPE).isSupported) {
                MzFocusRenderer.this.mo22844b();
            }
        }
    }

    /* renamed from: com.meizu.media.camera.views.g$c */
    /* compiled from: MzFocusRenderer */
    private class C2744c implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f15348a;

        private C2744c() {
        }

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f15348a, false, 8588, new Class[0], Void.TYPE).isSupported) {
                int unused = MzFocusRenderer.this.f15311N = Opcodes.IFEQ;
                MzFocusRenderer.this.f15342p = false;
                MzFocusRenderer.this.mo23407o();
            }
        }
    }

    public MzFocusRenderer(Context context) {
        m16726a(context);
    }

    /* renamed from: a */
    private void m16726a(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f15298a, false, 8558, new Class[]{Context.class}, Void.TYPE).isSupported) {
            this.f15309L = BitmapFactory.decodeResource(context.getResources(), R.drawable.mz_ic_focus_with_exposure);
            this.f15310M = BitmapFactory.decodeResource(context.getResources(), R.drawable.mz_screen_exposure_thumb);
            this.f15332f = this.f15310M.getHeight();
            this.f15333g = this.f15310M.getWidth();
            this.f15328b = CameraUtil.m15810a(144);
            this.f15339m = CameraUtil.m15810a(55);
            this.f15340n = ContextCompat.getColor(context, R.color.mz_screen_exposure_compensation_bar_color);
            this.f15307J = (int) ((((float) this.f15309L.getWidth()) * 1.0f) / 2.0f);
            this.f15315T = new Paint();
            this.f15315T.setAlpha(this.f15311N);
            this.f15315T.setStrokeWidth((float) this.f15329c);
            this.f15315T.setColor(this.f15340n);
            this.f15316U = new PaintFlagsDrawFilter(0, 3);
        }
    }

    /* renamed from: a */
    public void mo23327a(int i, int i2, RectF rectF, RectF rectF2) {
        boolean z = false;
        Object[] objArr = {new Integer(i), new Integer(i2), rectF, rectF2};
        ChangeQuickRedirect changeQuickRedirect = f15298a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8559, new Class[]{Integer.TYPE, Integer.TYPE, RectF.class, RectF.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f15295A;
            StringBuilder sb = new StringBuilder();
            sb.append("setFocus: x = ");
            sb.append(i);
            sb.append(" y = ");
            sb.append(i2);
            sb.append(" previewArea.contains(x, y) = ");
            float f = (float) i;
            float f2 = (float) i2;
            sb.append(rectF.contains(f, f2));
            sb.append(", gestureRect.contains(x, y) = ");
            sb.append(rectF2.contains(f, f2));
            LogUtil.m15942a(aVar, sb.toString());
            if (rectF2.contains(f, f2)) {
                if (f == rectF.centerX() && f2 == rectF.centerY()) {
                    z = true;
                }
                this.f15341o = z;
                this.f15318W = rectF2;
                this.f15308K = rectF;
                mo22844b();
                int i3 = ((int) this.f15308K.left) + this.f15307J;
                int i4 = ((int) this.f15308K.right) - this.f15307J;
                int i5 = ((int) this.f15308K.top) + this.f15307J;
                int i6 = ((int) this.f15308K.bottom) - this.f15307J;
                if (i > i4) {
                    i = i4;
                } else if (i < i3) {
                    i = i3;
                }
                if (i2 > i6) {
                    i2 = i6;
                } else if (i2 < i5) {
                    i2 = i5;
                }
                this.f15303F = i;
                this.f15304G = i2;
            }
        }
    }

    /* renamed from: c */
    public void mo23334c(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15298a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8560, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && !z) {
            m16734p();
        }
    }

    /* renamed from: a */
    public void mo23326a(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f15298a, false, 8561, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            mo22844b();
        }
    }

    /* renamed from: d */
    public void mo23336d(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15298a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8562, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!z) {
                mo22844b();
            }
            this.f15314S = z;
        }
    }

    /* renamed from: a */
    public void mo23325a() {
        if (!PatchProxy.proxy(new Object[0], this, f15298a, false, 8563, new Class[0], Void.TYPE).isSupported && mo23404k()) {
            this.f15345s = true;
            mo23403f(false);
        }
    }

    /* renamed from: c */
    public void mo23333c() {
        if (!PatchProxy.proxy(new Object[0], this, f15298a, false, 8564, new Class[0], Void.TYPE).isSupported && this.f15345s) {
            mo23403f(true);
            this.f15345s = false;
        }
    }

    /* renamed from: d */
    public void mo23335d() {
        if (!PatchProxy.proxy(new Object[0], this, f15298a, false, 8565, new Class[0], Void.TYPE).isSupported && this.f15345s) {
            mo23403f(true);
            this.f15345s = false;
        }
    }

    /* renamed from: e */
    public void mo23337e() {
        if (!PatchProxy.proxy(new Object[0], this, f15298a, false, 8566, new Class[0], Void.TYPE).isSupported) {
            this.f15334h = 0.0f;
            this.f15342p = false;
            if (this.f15338l) {
                mo23342i();
            }
            if (this.f15319X != null && this.f15557z) {
                this.f15319X.mo20248a(this.f15334h);
            }
        }
    }

    /* renamed from: a */
    public void mo23331a(C2745d dVar) {
        this.f15317V = dVar;
    }

    /* renamed from: f */
    public boolean mo23339f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f15298a, false, 8567, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f15314S && mo23404k();
    }

    /* renamed from: g */
    public int mo23340g() {
        return this.f15344r;
    }

    public void setOrientation(int i, boolean z) {
        Object[] objArr = {new Integer(i), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15298a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8569, new Class[]{Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported && this.f15343q != i) {
            this.f15343q = i;
            mo23407o();
        }
    }

    /* renamed from: a */
    public void mo23330a(C2743b bVar) {
        this.f15319X = bVar;
    }

    /* renamed from: h */
    public void mo23341h() {
        if (!PatchProxy.proxy(new Object[0], this, f15298a, false, 8570, new Class[0], Void.TYPE).isSupported) {
            if (this.f15552u != null) {
                this.f15552u.removeCallbacks(this.f15312O);
                this.f15552u.removeCallbacks(this.f15313P);
            }
            m16734p();
            if (this.f15319X != null) {
                this.f15319X.mo20247a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo23342i() {
        if (!PatchProxy.proxy(new Object[0], this, f15298a, false, 8571, new Class[0], Void.TYPE).isSupported && this.f15338l) {
            this.f15338l = false;
            this.f15552u.removeCallbacks(this.f15313P);
            this.f15552u.postDelayed(this.f15313P, 3000);
            if (this.f15319X != null) {
                this.f15319X.mo20249b();
            }
        }
    }

    /* renamed from: j */
    public float mo23343j() {
        return ((-this.f15334h) * 2.0f) / ((float) this.f15328b);
    }

    /* renamed from: a */
    public void mo23329a(MotionEvent motionEvent) {
        if (!PatchProxy.proxy(new Object[]{motionEvent}, this, f15298a, false, 8572, new Class[]{MotionEvent.class}, Void.TYPE).isSupported && this.f15338l) {
            if (this.f15344r != this.f15343q) {
                this.f15344r = this.f15343q;
                this.f15337k = this.f15331e;
                this.f15336j = this.f15330d;
            }
            int i = this.f15343q;
            if (i == 0) {
                this.f15335i = (motionEvent.getY() - this.f15337k) / 10.0f;
                this.f15337k = motionEvent.getY();
            } else if (i == 90) {
                this.f15335i = (motionEvent.getX() - this.f15336j) / 10.0f;
                this.f15336j = motionEvent.getX();
            } else if (i == 180) {
                this.f15335i = (this.f15337k - motionEvent.getY()) / 10.0f;
                this.f15337k = motionEvent.getY();
            } else if (i == 270) {
                this.f15335i = (this.f15336j - motionEvent.getX()) / 10.0f;
                this.f15336j = motionEvent.getX();
            }
            LogUtil.m15942a(f15295A, "mTrackOffset:" + this.f15335i);
            if (!this.f15342p && (this.f15335i >= 1.0f || this.f15335i <= -1.0f)) {
                this.f15342p = true;
            }
            LogUtil.m15942a(f15295A, "mShowExposureBar:" + this.f15342p);
            if (this.f15342p) {
                this.f15334h += this.f15335i;
                LogUtil.m15942a(f15295A, "mExposureOffset:" + this.f15334h);
                if (this.f15334h > ((float) (this.f15328b / 2))) {
                    this.f15334h = (float) (this.f15328b / 2);
                } else if (this.f15334h < ((float) ((-this.f15328b) / 2))) {
                    this.f15334h = (float) ((-this.f15328b) / 2);
                } else {
                    mo23407o();
                    if (this.f15319X == null && this.f15317V != null) {
                        LogUtil.m15952c(f15295A, "mOnSeekBarChangeListener == null !!!");
                        this.f15319X = this.f15317V.mo20378B();
                    }
                    this.f15319X.mo20248a(mo23343j());
                }
            }
        }
    }

    /* renamed from: b */
    public void mo23332b(MotionEvent motionEvent) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{motionEvent}, this, f15298a, false, 8573, new Class[]{MotionEvent.class}, Void.TYPE).isSupported) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f15336j = motionEvent.getX();
                    this.f15337k = motionEvent.getY();
                    if (this.f15318W == null || !this.f15318W.contains(this.f15336j, this.f15337k) || this.f15308K == null || !this.f15308K.contains(this.f15336j, this.f15337k) || this.f15341o) {
                        z = false;
                    }
                    this.f15338l = z;
                    if (this.f15338l) {
                        mo23341h();
                        return;
                    }
                    return;
                case 1:
                    mo23329a(motionEvent);
                    mo23342i();
                    return;
                case 2:
                    mo23329a(motionEvent);
                    return;
                case 3:
                    mo23342i();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public void mo23328a(RectF rectF, boolean z) {
        if (!PatchProxy.proxy(new Object[]{rectF, new Byte(z ? (byte) 1 : 0)}, this, f15298a, false, 8574, new Class[]{RectF.class, Boolean.TYPE}, Void.TYPE).isSupported && !m16735q()) {
            this.f15552u.removeCallbacks(this.f15312O);
            this.f15552u.removeCallbacks(this.f15313P);
            this.f15305H = (int) rectF.centerX();
            this.f15306I = (int) rectF.centerY();
            this.f15301D = -1;
            this.f15299B = 1;
            mo23403f(true);
            if (!this.f15341o) {
                this.f15552u.postDelayed(this.f15313P, 3000);
            }
        }
    }

    /* renamed from: a */
    public void mo22840a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f15298a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8575, new Class[]{Long.TYPE}, Void.TYPE).isSupported && !m16735q()) {
            this.f15552u.removeCallbacks(this.f15312O);
            if (this.f15299B == 1) {
                this.f15299B = 2;
                mo23407o();
            }
            if (j != -1 && this.f15341o) {
                this.f15552u.postDelayed(this.f15312O, j);
            }
        }
    }

    /* renamed from: p */
    private void m16734p() {
        this.f15311N = 255;
    }

    /* renamed from: a */
    public void mo22842a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15298a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8576, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && !m16735q()) {
            this.f15552u.removeCallbacks(this.f15312O);
            if (this.f15299B == 1) {
                this.f15299B = 3;
                mo23407o();
            }
            if (z) {
                this.f15552u.postDelayed(this.f15312O, 800);
            }
        }
    }

    /* renamed from: b */
    public void mo22844b() {
        if (!PatchProxy.proxy(new Object[0], this, f15298a, false, 8577, new Class[0], Void.TYPE).isSupported) {
            if (this.f15314S) {
                mo23337e();
            }
            if (this.f15552u != null) {
                this.f15552u.removeCallbacks(this.f15312O);
                this.f15552u.removeCallbacks(this.f15313P);
            }
            mo23403f(false);
            this.f15303F = 0;
            this.f15304G = 0;
            this.f15301D = -1;
            m16734p();
        }
    }

    /* renamed from: b */
    private void m16729b(long j) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f15298a, false, 8578, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f15301D == -1) {
                this.f15301D = j;
            }
            float f = ((float) (j - this.f15301D)) / 240.0f;
            float f2 = ((float) (j - this.f15301D)) / 96.0f;
            if (f2 >= 0.0f && f2 <= 1.0f) {
                this.f15311N = (int) (f15297R.getInterpolation(f2) * 255.0f);
            } else if (f > 1.0f && j - this.f15301D < 3000) {
                this.f15311N = 255;
            }
            if (f < 1.0f) {
                z = false;
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.f15300C = 1.5f - (f15296Q.getInterpolation(f) * 0.5f);
            }
            if (z) {
                this.f15300C = 1.0f;
            } else {
                mo23407o();
            }
        }
    }

    /* renamed from: a */
    public void mo20787a(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15298a, false, 8579, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            m16729b(System.currentTimeMillis());
            if ((this.f15299B == 1 || this.f15299B == 2 || this.f15299B == 3 || this.f15299B == 4) && this.f15309L != null && !this.f15309L.isRecycled()) {
                m16727a(this.f15309L, canvas);
                if (this.f15314S && !this.f15341o && this.f15310M != null && !this.f15310M.isRecycled()) {
                    m16730b(this.f15310M, canvas);
                }
            }
        }
    }

    /* renamed from: a */
    private void m16727a(Bitmap bitmap, Canvas canvas) {
        Class[] clsArr = {Bitmap.class, Canvas.class};
        if (!PatchProxy.proxy(new Object[]{bitmap, canvas}, this, f15298a, false, 8580, clsArr, Void.TYPE).isSupported) {
            canvas.save();
            if (this.f15303F == 0) {
                this.f15303F = this.f15305H;
            }
            if (this.f15304G == 0) {
                this.f15304G = this.f15306I;
            }
            float width = ((float) this.f15303F) - ((((float) bitmap.getWidth()) * this.f15300C) / 2.0f);
            float height = ((float) this.f15304G) - ((((float) bitmap.getHeight()) * this.f15300C) / 2.0f);
            this.f15302E.reset();
            this.f15302E.preTranslate(width, height);
            this.f15302E.postScale(this.f15300C, this.f15300C, width, height);
            if (this.f15315T != null) {
                this.f15315T.setAlpha(this.f15311N);
            }
            canvas.setDrawFilter(this.f15316U);
            canvas.drawBitmap(bitmap, this.f15302E, this.f15315T);
            canvas.restore();
        }
    }

    /* renamed from: b */
    private void m16730b(Bitmap bitmap, Canvas canvas) {
        Class[] clsArr = {Bitmap.class, Canvas.class};
        if (!PatchProxy.proxy(new Object[]{bitmap, canvas}, this, f15298a, false, 8581, clsArr, Void.TYPE).isSupported) {
            canvas.save();
            if (this.f15303F == 0) {
                this.f15303F = this.f15305H;
            }
            if (this.f15304G == 0) {
                this.f15304G = this.f15306I;
            }
            int i = this.f15343q;
            if (i == 0) {
                m16728a(canvas, bitmap);
            } else if (i == 90) {
                m16732c(canvas, bitmap);
            } else if (i == 180) {
                m16731b(canvas, bitmap);
            } else if (i == 270) {
                m16733d(canvas, bitmap);
            }
            canvas.restore();
        }
    }

    /* renamed from: a */
    private void m16728a(Canvas canvas, Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{canvas, bitmap}, this, f15298a, false, 8582, new Class[]{Canvas.class, Bitmap.class}, Void.TYPE).isSupported) {
            float f = (float) (this.f15303F + ((this.f15308K.right - ((float) this.f15303F)) - ((float) (this.f15333g / 2)) < ((float) this.f15339m) ? -this.f15339m : this.f15339m));
            float f2 = f - ((float) (this.f15333g / 2));
            float f3 = ((float) (this.f15304G - (this.f15332f / 2))) + this.f15334h;
            if (f3 < this.f15308K.top) {
                f3 = this.f15308K.top;
            } else if (((float) this.f15332f) + f3 > this.f15308K.bottom) {
                f3 = this.f15308K.bottom - ((float) this.f15332f);
            }
            this.f15330d = ((float) (this.f15332f / 2)) + f2;
            this.f15331e = ((float) (this.f15332f / 2)) + f3;
            this.f15302E.reset();
            this.f15302E.preTranslate(f2, f3);
            if (this.f15315T != null) {
                this.f15315T.setAlpha(this.f15311N);
            }
            canvas.setDrawFilter(this.f15316U);
            canvas.drawBitmap(bitmap, this.f15302E, this.f15315T);
            if (this.f15342p) {
                this.f15320Y = ((float) this.f15304G) - this.f15308K.top < ((float) (this.f15328b / 2)) ? this.f15308K.top : (float) (this.f15304G - (this.f15328b / 2));
                this.f15321Z = f;
                this.f15322aa = f3 - 9.0f;
                this.f15323ab = f;
                canvas.setDrawFilter(this.f15316U);
                if (this.f15322aa > this.f15320Y) {
                    canvas.drawLine(this.f15321Z, this.f15320Y, this.f15323ab, this.f15322aa, this.f15315T);
                }
                this.f15324ac = f3 + ((float) this.f15332f) + 9.0f;
                this.f15325ad = f;
                this.f15326ae = this.f15308K.bottom - ((float) this.f15304G) < ((float) (this.f15328b / 2)) ? this.f15308K.bottom : (float) (this.f15304G + (this.f15328b / 2));
                this.f15327af = f;
                if (this.f15326ae > this.f15324ac) {
                    canvas.drawLine(this.f15325ad, this.f15324ac, this.f15327af, this.f15326ae, this.f15315T);
                }
            }
        }
    }

    /* renamed from: b */
    private void m16731b(Canvas canvas, Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{canvas, bitmap}, this, f15298a, false, 8583, new Class[]{Canvas.class, Bitmap.class}, Void.TYPE).isSupported) {
            float f = (float) (this.f15303F + ((((float) this.f15303F) - this.f15308K.left) - ((float) (this.f15333g / 2)) < ((float) this.f15339m) ? this.f15339m : -this.f15339m));
            float f2 = f - ((float) (this.f15333g / 2));
            float f3 = ((float) (this.f15304G - (this.f15332f / 2))) - this.f15334h;
            if (f3 < this.f15308K.top) {
                f3 = this.f15308K.top;
            } else if (((float) this.f15332f) + f3 > this.f15308K.bottom) {
                f3 = this.f15308K.bottom - ((float) this.f15332f);
            }
            this.f15330d = ((float) (this.f15332f / 2)) + f2;
            this.f15331e = ((float) (this.f15332f / 2)) + f3;
            this.f15302E.reset();
            this.f15302E.setRotate((float) this.f15343q);
            this.f15302E.postTranslate(f2 + ((float) this.f15332f), ((float) this.f15332f) + f3);
            if (this.f15315T != null) {
                this.f15315T.setAlpha(this.f15311N);
            }
            canvas.setDrawFilter(this.f15316U);
            canvas.drawBitmap(bitmap, this.f15302E, this.f15315T);
            if (this.f15342p) {
                this.f15320Y = this.f15308K.bottom - ((float) this.f15304G) < ((float) (this.f15328b / 2)) ? this.f15308K.bottom : (float) (this.f15304G + (this.f15328b / 2));
                this.f15321Z = f;
                this.f15322aa = ((float) this.f15332f) + f3 + 9.0f;
                this.f15323ab = f;
                canvas.setDrawFilter(this.f15316U);
                if (this.f15322aa < this.f15320Y) {
                    canvas.drawLine(this.f15321Z, this.f15320Y, this.f15323ab, this.f15322aa, this.f15315T);
                }
                this.f15324ac = f3 - 9.0f;
                this.f15325ad = f;
                this.f15326ae = ((float) this.f15304G) - this.f15308K.top < ((float) (this.f15328b / 2)) ? this.f15308K.top : (float) (this.f15304G - (this.f15328b / 2));
                this.f15327af = f;
                if (this.f15326ae < this.f15324ac) {
                    canvas.drawLine(this.f15325ad, this.f15324ac, this.f15327af, this.f15326ae, this.f15315T);
                }
            }
        }
    }

    /* renamed from: c */
    private void m16732c(Canvas canvas, Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{canvas, bitmap}, this, f15298a, false, 8584, new Class[]{Canvas.class, Bitmap.class}, Void.TYPE).isSupported) {
            float f = (float) (this.f15304G + ((((float) this.f15304G) - this.f15308K.top) - ((float) (this.f15333g / 2)) < ((float) this.f15339m) ? this.f15339m : -this.f15339m));
            float f2 = f - ((float) (this.f15333g / 2));
            float f3 = ((float) (this.f15303F - (this.f15332f / 2))) + this.f15334h;
            if (f3 < this.f15308K.left) {
                f3 = this.f15308K.left;
            } else if (((float) this.f15332f) + f3 > this.f15308K.right) {
                f3 = this.f15308K.right - ((float) this.f15332f);
            }
            this.f15330d = ((float) (this.f15333g / 2)) + f3;
            this.f15331e = ((float) (this.f15333g / 2)) + f2;
            this.f15302E.reset();
            this.f15302E.setRotate(270.0f);
            this.f15302E.postTranslate(f3, f2 + ((float) this.f15332f));
            if (this.f15315T != null) {
                this.f15315T.setAlpha(this.f15311N);
            }
            canvas.setDrawFilter(this.f15316U);
            canvas.drawBitmap(bitmap, this.f15302E, this.f15315T);
            if (this.f15342p) {
                this.f15321Z = ((float) this.f15303F) - this.f15308K.left < ((float) (this.f15328b / 2)) ? this.f15308K.left : (float) (this.f15303F - (this.f15328b / 2));
                this.f15320Y = f;
                this.f15323ab = f3 - 9.0f;
                this.f15322aa = f;
                canvas.setDrawFilter(this.f15316U);
                if (this.f15323ab > this.f15321Z) {
                    canvas.drawLine(this.f15321Z, this.f15320Y, this.f15323ab, this.f15322aa, this.f15315T);
                }
                this.f15325ad = f3 + ((float) this.f15332f) + 9.0f;
                this.f15324ac = f;
                this.f15327af = this.f15308K.right - ((float) this.f15303F) < ((float) (this.f15328b / 2)) ? this.f15308K.right : (float) (this.f15303F + (this.f15328b / 2));
                this.f15326ae = f;
                if (this.f15327af > this.f15325ad) {
                    canvas.drawLine(this.f15325ad, this.f15324ac, this.f15327af, this.f15326ae, this.f15315T);
                }
            }
        }
    }

    /* renamed from: d */
    private void m16733d(Canvas canvas, Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{canvas, bitmap}, this, f15298a, false, 8585, new Class[]{Canvas.class, Bitmap.class}, Void.TYPE).isSupported) {
            float f = (float) (this.f15304G + ((this.f15308K.bottom - ((float) this.f15304G)) - ((float) (this.f15333g / 2)) < ((float) this.f15339m) ? -this.f15339m : this.f15339m));
            float f2 = f - ((float) (this.f15333g / 2));
            float f3 = ((float) (this.f15303F - (this.f15332f / 2))) - this.f15334h;
            if (f3 < this.f15308K.left) {
                f3 = this.f15308K.left;
            } else if (((float) this.f15332f) + f3 > this.f15308K.right) {
                f3 = this.f15308K.right - ((float) this.f15332f);
            }
            this.f15330d = ((float) (this.f15332f / 2)) + f3;
            this.f15331e = ((float) (this.f15333g / 2)) + f2;
            this.f15302E.reset();
            this.f15302E.setRotate(90.0f);
            this.f15302E.postTranslate(((float) this.f15332f) + f3, f2);
            if (this.f15315T != null) {
                this.f15315T.setAlpha(this.f15311N);
            }
            canvas.setDrawFilter(this.f15316U);
            canvas.drawBitmap(bitmap, this.f15302E, this.f15315T);
            if (this.f15342p) {
                this.f15321Z = ((float) this.f15303F) - this.f15308K.left < ((float) (this.f15328b / 2)) ? this.f15308K.left : (float) (this.f15303F - (this.f15328b / 2));
                this.f15320Y = f;
                this.f15323ab = f3 - 9.0f;
                this.f15322aa = f;
                canvas.setDrawFilter(this.f15316U);
                if (this.f15323ab > this.f15321Z) {
                    canvas.drawLine(this.f15321Z, this.f15320Y, this.f15323ab, this.f15322aa, this.f15315T);
                }
                this.f15325ad = f3 + ((float) this.f15332f) + 9.0f;
                this.f15324ac = f;
                this.f15327af = this.f15308K.right - ((float) this.f15303F) < ((float) (this.f15328b / 2)) ? this.f15308K.right : (float) (this.f15303F + (this.f15328b / 2));
                this.f15326ae = f;
                if (this.f15327af > this.f15325ad) {
                    canvas.drawLine(this.f15325ad, this.f15324ac, this.f15327af, this.f15326ae, this.f15315T);
                }
            }
        }
    }

    /* renamed from: q */
    private boolean m16735q() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f15298a, false, 8586, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return CameraModeType.m10946a().equals(CameraModeType.ModeType.BARCODE) || CameraModeType.m10946a().equals(CameraModeType.ModeType.NightVision);
    }
}
