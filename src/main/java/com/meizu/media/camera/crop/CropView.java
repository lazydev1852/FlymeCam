package com.meizu.media.camera.crop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserView;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class CropView extends View {

    /* renamed from: a */
    public static ChangeQuickRedirect f9197a;

    /* renamed from: A */
    private int f9198A = 32;

    /* renamed from: B */
    private int f9199B = -822083584;

    /* renamed from: C */
    private int f9200C = 1593835520;

    /* renamed from: D */
    private int f9201D = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    /* renamed from: E */
    private int f9202E = 90;

    /* renamed from: F */
    private int f9203F = 40;

    /* renamed from: G */
    private float f9204G = 20.0f;

    /* renamed from: H */
    private float f9205H = 10.0f;

    /* renamed from: I */
    private DashPathEffect f9206I = new DashPathEffect(new float[]{this.f9204G, this.f9204G + this.f9205H}, 0.0f);

    /* renamed from: J */
    private Mode f9207J = Mode.NONE;

    /* renamed from: b */
    private final LogUtil.C2630a f9208b = new LogUtil.C2630a("CropView");

    /* renamed from: c */
    private RectF f9209c = new RectF();

    /* renamed from: d */
    private RectF f9210d = new RectF();

    /* renamed from: e */
    private RectF f9211e = new RectF();

    /* renamed from: f */
    private RectF f9212f = new RectF();

    /* renamed from: g */
    private Rect f9213g = new Rect();

    /* renamed from: h */
    private Bitmap f9214h;

    /* renamed from: i */
    private Paint f9215i = new Paint();

    /* renamed from: j */
    private Paint f9216j = new Paint();

    /* renamed from: k */
    private Paint f9217k = new Paint();

    /* renamed from: l */
    private NinePatchDrawable f9218l;

    /* renamed from: m */
    private CropObject f9219m = null;

    /* renamed from: n */
    private Drawable f9220n;

    /* renamed from: o */
    private int f9221o;

    /* renamed from: p */
    private int f9222p = 0;

    /* renamed from: q */
    private boolean f9223q = false;

    /* renamed from: r */
    private Matrix f9224r = null;

    /* renamed from: s */
    private Matrix f9225s = null;

    /* renamed from: t */
    private boolean f9226t = false;

    /* renamed from: u */
    private float f9227u = 0.0f;

    /* renamed from: v */
    private float f9228v = 0.0f;

    /* renamed from: w */
    private float f9229w = 0.0f;

    /* renamed from: x */
    private float f9230x = 0.0f;

    /* renamed from: y */
    private boolean f9231y = false;

    /* renamed from: z */
    private int f9232z = 15;

    private enum Mode {
        NONE,
        MOVE;
        
        public static ChangeQuickRedirect changeQuickRedirect;
    }

    public CropView(Context context) {
        super(context);
        setup(context);
    }

    public CropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup(context);
    }

    public CropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setup(context);
    }

    private void setup(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f9197a, false, 3320, new Class[]{Context.class}, Void.TYPE).isSupported) {
            Resources resources = context.getResources();
            this.f9218l = (NinePatchDrawable) resources.getDrawable(R.drawable.geometry_shadow);
            this.f9220n = resources.getDrawable(R.drawable.camera_crop);
            this.f9221o = (int) resources.getDimension(R.dimen.crop_indicator_size);
            this.f9232z = (int) resources.getDimension(R.dimen.shadow_margin);
            this.f9198A = (int) resources.getDimension(R.dimen.preview_margin);
            this.f9202E = (int) resources.getDimension(R.dimen.crop_min_side);
            this.f9203F = (int) resources.getDimension(R.dimen.crop_touch_tolerance);
            this.f9199B = resources.getColor(R.color.crop_shadow_color);
            this.f9200C = resources.getColor(R.color.crop_shadow_wp_color);
            this.f9201D = resources.getColor(R.color.crop_wp_markers);
            this.f9204G = resources.getDimension(R.dimen.wp_selector_dash_length);
            this.f9205H = resources.getDimension(R.dimen.wp_selector_off_length);
        }
    }

    /* renamed from: a */
    public void mo19769a(Bitmap bitmap, RectF rectF, RectF rectF2, int i) {
        Object[] objArr = {bitmap, rectF, rectF2, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9197a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 3321, new Class[]{Bitmap.class, RectF.class, RectF.class, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f9214h = bitmap;
            this.f9209c = new RectF(0.0f, 0.0f, (float) this.f9214h.getWidth(), (float) this.f9214h.getHeight());
            this.f9210d = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            if (this.f9219m != null) {
                RectF a = this.f9219m.mo19794a();
                RectF b = this.f9219m.mo19799b();
                if (a != rectF || b != rectF2 || this.f9222p != i) {
                    this.f9222p = i;
                    this.f9219m.mo19797a(rectF, rectF2);
                    m9683c();
                    return;
                }
                return;
            }
            this.f9222p = i;
            this.f9219m = new CropObject(rectF2, rectF, 0);
            m9683c();
        }
    }

    public RectF getCrop() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9197a, false, 3322, new Class[0], RectF.class);
        return proxy.isSupported ? (RectF) proxy.result : this.f9219m.mo19794a();
    }

    public RectF getPhoto() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9197a, false, 3323, new Class[0], RectF.class);
        return proxy.isSupported ? (RectF) proxy.result : this.f9219m.mo19799b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f9197a, false, 3324, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.f9224r == null || this.f9225s == null) {
            return true;
        }
        float[] fArr = {x, y};
        this.f9225s.mapPoints(fArr);
        float f = fArr[0];
        float f2 = fArr[1];
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (this.f9207J == Mode.NONE) {
                    if (!this.f9219m.mo19801b(f, f2)) {
                        this.f9223q = this.f9219m.mo19806e(16);
                    }
                    this.f9227u = f;
                    this.f9228v = f2;
                    this.f9207J = Mode.MOVE;
                    break;
                }
                break;
            case 1:
                if (this.f9207J == Mode.MOVE) {
                    this.f9219m.mo19806e(0);
                    this.f9223q = false;
                    this.f9227u = f;
                    this.f9228v = f2;
                    this.f9207J = Mode.NONE;
                    break;
                }
                break;
            case 2:
                if (this.f9207J == Mode.MOVE) {
                    this.f9219m.mo19803c(f - this.f9227u, f2 - this.f9228v);
                    this.f9227u = f;
                    this.f9228v = f2;
                    break;
                }
                break;
        }
        invalidate();
        return true;
    }

    /* renamed from: b */
    private void m9682b() {
        if (!PatchProxy.proxy(new Object[0], this, f9197a, false, 3325, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15956e(this.f9208b, "crop reset called");
            this.f9207J = Mode.NONE;
            this.f9219m = null;
            this.f9222p = 0;
            this.f9223q = false;
            m9683c();
        }
    }

    /* renamed from: c */
    private void m9683c() {
        if (!PatchProxy.proxy(new Object[0], this, f9197a, false, 3326, new Class[0], Void.TYPE).isSupported) {
            this.f9224r = null;
            this.f9225s = null;
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo19767a() {
        this.f9226t = true;
    }

    /* renamed from: a */
    public void mo19768a(float f, float f2) {
        if (!PatchProxy.proxy(new Object[]{new Float(f), new Float(f2)}, this, f9197a, false, 3330, new Class[]{Float.TYPE, Float.TYPE}, Void.TYPE).isSupported) {
            if (f <= 0.0f || f2 <= 0.0f) {
                throw new IllegalArgumentException("Bad arguments to applyAspect");
            }
            if ((this.f9222p < 0 ? -this.f9222p : this.f9222p) % 180 == 90) {
                float f3 = f2;
                f2 = f;
                f = f3;
            }
            if (!this.f9219m.mo19798a(f, f2)) {
                LogUtil.m15956e(this.f9208b, "failed to set aspect ratio");
            }
            invalidate();
        }
    }

    public void setWallpaperSpotlight(float f, float f2) {
        this.f9229w = f;
        this.f9230x = f2;
        if (this.f9229w > 0.0f && this.f9230x > 0.0f) {
            this.f9231y = true;
        }
    }

    /* renamed from: a */
    private int m9681a(int i, int i2, int i3) {
        int i4 = (1 << i3) - 1;
        int i5 = i & i4;
        int i6 = i2 % i3;
        return (i & (~i4)) | ((i5 << i6) & i4) | (i5 >> (i3 - i6));
    }

    /* renamed from: a */
    private int m9680a(int i, float f) {
        Object[] objArr = {new Integer(i), new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f9197a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 3331, new Class[]{Integer.TYPE, Float.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int a = CropMath.m9718a(f);
        if (a == 90) {
            return m9681a(i, 1, 4);
        }
        if (a == 180) {
            return m9681a(i, 2, 4);
        }
        if (a != 270) {
            return i;
        }
        return m9681a(i, 3, 4);
    }

    public void onDraw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f9197a, false, 3332, new Class[]{Canvas.class}, Void.TYPE).isSupported && this.f9214h != null) {
            if (this.f9226t) {
                this.f9226t = false;
                m9683c();
            }
            this.f9210d.inset((float) this.f9198A, (float) this.f9198A);
            if (this.f9219m == null) {
                m9682b();
                this.f9219m = new CropObject(this.f9209c, this.f9209c, 0);
            }
            if (this.f9224r == null || this.f9225s == null) {
                this.f9224r = new Matrix();
                this.f9224r.reset();
                if (!CropDrawingUtils.m9705a(this.f9224r, this.f9209c, this.f9210d, this.f9222p)) {
                    LogUtil.m15956e(this.f9208b, "failed to get screen matrix");
                    this.f9224r = null;
                    return;
                }
                this.f9225s = new Matrix();
                this.f9225s.reset();
                if (!this.f9224r.invert(this.f9225s)) {
                    LogUtil.m15956e(this.f9208b, "could not invert display matrix");
                    this.f9225s = null;
                    return;
                }
                this.f9219m.mo19800b(this.f9225s.mapRadius((float) this.f9202E));
                this.f9219m.mo19795a(this.f9225s.mapRadius((float) this.f9203F));
            }
            this.f9211e.set(this.f9209c);
            if (this.f9224r.mapRect(this.f9211e)) {
                int mapRadius = (int) this.f9224r.mapRadius((float) this.f9232z);
                this.f9211e.roundOut(this.f9213g);
                this.f9213g.set(this.f9213g.left - mapRadius, this.f9213g.top - mapRadius, this.f9213g.right + mapRadius, this.f9213g.bottom + mapRadius);
                this.f9218l.setBounds(this.f9213g);
                this.f9218l.draw(canvas);
            }
            this.f9215i.setAntiAlias(true);
            this.f9215i.setFilterBitmap(true);
            canvas.drawBitmap(this.f9214h, this.f9224r, this.f9215i);
            this.f9219m.mo19796a(this.f9212f);
            if (this.f9224r.mapRect(this.f9212f)) {
                this.f9216j.setColor(this.f9199B);
                this.f9216j.setStyle(Paint.Style.FILL);
                CropDrawingUtils.m9700a(canvas, this.f9216j, this.f9212f, this.f9211e);
                CropDrawingUtils.m9706b(canvas, this.f9212f);
                if (!this.f9231y) {
                    CropDrawingUtils.m9701a(canvas, this.f9212f);
                } else {
                    this.f9217k.setColor(this.f9201D);
                    this.f9217k.setStrokeWidth(3.0f);
                    this.f9217k.setStyle(Paint.Style.STROKE);
                    this.f9217k.setPathEffect(this.f9206I);
                    this.f9216j.setColor(this.f9200C);
                    CropDrawingUtils.m9702a(canvas, this.f9212f, this.f9229w, this.f9230x, this.f9217k, this.f9216j);
                }
                CropDrawingUtils.m9704a(canvas, this.f9220n, this.f9221o, this.f9212f, this.f9219m.mo19804d(), m9680a(this.f9219m.mo19802c(), (float) this.f9222p));
            }
        }
    }
}
