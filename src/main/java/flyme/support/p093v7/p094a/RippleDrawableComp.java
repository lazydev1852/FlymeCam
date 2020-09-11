package flyme.support.p093v7.p094a;

import android.animation.ValueAnimator;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.view.ViewCompat;
import com.alibaba.fastjson.asm.Opcodes;
import flyme.support.p093v7.appcompat.R;
import java.lang.ref.WeakReference;

/* renamed from: flyme.support.v7.a.b */
public class RippleDrawableComp extends Drawable {

    /* renamed from: a */
    private static final Interpolator f16567a = m18147g();

    /* renamed from: b */
    private static final Interpolator f16568b = m18150h();

    /* renamed from: c */
    private WeakReference<View> f16569c;

    /* renamed from: d */
    private Drawable f16570d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Paint f16571e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Paint f16572f;

    /* renamed from: g */
    private int f16573g = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: h */
    private int f16574h = 75;

    /* renamed from: i */
    private int f16575i = ViewCompat.MEASURED_STATE_MASK;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f16576j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f16577k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f16578l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f16579m = 0;

    /* renamed from: n */
    private int f16580n;

    /* renamed from: o */
    private int f16581o;

    /* renamed from: p */
    private int f16582p = 0;

    /* renamed from: q */
    private int f16583q = 0;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f16584r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f16585s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f16586t = false;

    /* renamed from: u */
    private ValueAnimator f16587u;

    /* renamed from: v */
    private boolean f16588v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f16589w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f16590x;

    public boolean isStateful() {
        return true;
    }

    public RippleDrawableComp(View view, int i) {
        if (view != null) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.MzRippleDrawableComp, i, 0);
            this.f16575i = obtainStyledAttributes.getColor(R.styleable.MzRippleDrawableComp_mzRippleColor, ViewCompat.MEASURED_STATE_MASK);
            this.f16584r = Color.alpha(this.f16575i);
            this.f16577k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzRippleDrawableComp_mzStartRadius, -1);
            this.f16579m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MzRippleDrawableComp_mzMaxRadius, 0);
            this.f16585s = obtainStyledAttributes.getBoolean(R.styleable.MzRippleDrawableComp_mzUseFadeOut, false);
            this.f16588v = obtainStyledAttributes.getBoolean(R.styleable.MzRippleDrawableComp_mzAutoLightBackground, true);
            this.f16589w = obtainStyledAttributes.getBoolean(R.styleable.MzRippleDrawableComp_mzRippleFade, true);
            this.f16582p = obtainStyledAttributes.getInt(R.styleable.MzRippleDrawableComp_mzInDuration, Opcodes.IF_ICMPNE);
            this.f16583q = obtainStyledAttributes.getInt(R.styleable.MzRippleDrawableComp_mzOutDuration, 320);
            this.f16590x = obtainStyledAttributes.getBoolean(R.styleable.MzRippleDrawableComp_mzShrink, true);
            obtainStyledAttributes.recycle();
            this.f16571e = new Paint();
            this.f16571e.setColor(this.f16575i);
            this.f16571e.setAlpha(this.f16584r);
            this.f16571e.setAntiAlias(true);
            this.f16572f = new Paint();
            this.f16572f.setColor(this.f16575i);
            this.f16572f.setAlpha(this.f16584r / 2);
            this.f16572f.setAntiAlias(true);
            this.f16569c = new WeakReference<>(view);
            this.f16576j = this.f16577k;
            mo25020a();
            return;
        }
        throw new IllegalArgumentException("you must use a view to create a RippleDrawableComp");
    }

    /* renamed from: a */
    public void mo25020a() {
        if (this.f16569c != null) {
            ((View) this.f16569c.get()).setClickable(true);
            ((View) this.f16569c.get()).addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    RippleDrawableComp.this.m18141d();
                }
            });
            ((View) this.f16569c.get()).post(new Runnable() {
                public void run() {
                    RippleDrawableComp.this.m18141d();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m18141d() {
        View view = (View) this.f16569c.get();
        if (view != null) {
            this.f16580n = view.getWidth();
            this.f16581o = view.getHeight();
            setBounds(new Rect(0, 0, this.f16580n, this.f16581o));
            if (this.f16579m <= 0) {
                this.f16579m = ((int) Math.hypot((double) this.f16580n, (double) this.f16581o)) / 2;
            }
            if (this.f16577k < 0) {
                this.f16577k = (int) (((float) this.f16579m) * 0.825f);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z = true;
            }
            if (i == 16842919) {
                z2 = true;
            }
        }
        if (z && z2) {
            this.f16586t = true;
            mo25021b();
        } else if (this.f16586t) {
            this.f16586t = false;
            invalidateSelf();
            if (!this.f16578l && this.f16589w) {
                mo25022c();
            }
        }
        return onStateChange;
    }

    public void setBounds(Rect rect) {
        if (this.f16570d != null) {
            this.f16570d.setBounds(rect);
        }
    }

    public void setAlpha(int i) {
        this.f16584r = i;
        this.f16571e.setAlpha(this.f16584r);
    }

    /* renamed from: b */
    public void mo25021b() {
        m18143e();
        this.f16571e.setAlpha(this.f16584r);
        this.f16572f.setAlpha(this.f16584r / 2);
        this.f16578l = true;
        this.f16576j = this.f16577k;
        this.f16587u = ValueAnimator.ofInt(new int[]{this.f16576j, this.f16579m});
        this.f16587u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                int unused = RippleDrawableComp.this.f16576j = intValue;
                if (RippleDrawableComp.this.f16579m <= intValue) {
                    boolean unused2 = RippleDrawableComp.this.f16578l = false;
                    if (!RippleDrawableComp.this.f16586t && RippleDrawableComp.this.f16589w) {
                        RippleDrawableComp.this.mo25022c();
                    }
                }
                RippleDrawableComp.this.invalidateSelf();
            }
        });
        this.f16587u.setDuration((long) this.f16582p);
        this.f16587u.setInterpolator(f16567a);
        this.f16587u.start();
    }

    /* renamed from: c */
    public void mo25022c() {
        m18143e();
        this.f16571e.setAlpha(this.f16584r);
        this.f16578l = true;
        this.f16576j = this.f16579m;
        final float f = ((float) this.f16577k) / ((float) this.f16579m);
        this.f16587u = ValueAnimator.ofInt(new int[]{this.f16579m, this.f16577k});
        this.f16587u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (RippleDrawableComp.this.f16590x) {
                    int unused = RippleDrawableComp.this.f16576j = intValue;
                }
                if (RippleDrawableComp.this.f16577k >= intValue) {
                    boolean unused2 = RippleDrawableComp.this.f16578l = false;
                }
                if (RippleDrawableComp.this.f16585s) {
                    int h = (int) (((float) RippleDrawableComp.this.f16584r) * (((((float) intValue) / ((float) RippleDrawableComp.this.f16579m)) - f) / (1.0f - f)));
                    RippleDrawableComp.this.f16571e.setAlpha(h);
                    RippleDrawableComp.this.f16572f.setAlpha(h / 2);
                }
                RippleDrawableComp.this.invalidateSelf();
            }
        });
        this.f16587u.setDuration((long) this.f16583q);
        this.f16587u.setInterpolator(f16568b);
        this.f16587u.start();
    }

    /* renamed from: e */
    private void m18143e() {
        if (this.f16587u == null) {
            return;
        }
        if (this.f16587u.isStarted() || this.f16587u.isRunning()) {
            this.f16587u.cancel();
        }
    }

    public void draw(Canvas canvas) {
        m18146f();
        if (this.f16570d != null) {
            this.f16570d.draw(canvas);
        }
        if (this.f16578l || this.f16586t) {
            if (this.f16588v) {
                canvas.drawCircle((float) (this.f16580n / 2), (float) (this.f16581o / 2), (float) this.f16579m, this.f16572f);
            }
            canvas.drawCircle((float) (this.f16580n / 2), (float) (this.f16581o / 2), (float) this.f16576j, this.f16571e);
        }
    }

    /* renamed from: f */
    private void m18146f() {
        if (Build.MODEL.equals("vivo X3t")) {
            setBounds(-(this.f16579m + (this.f16580n / 2)), -(this.f16579m + (this.f16581o / 2)), this.f16579m + (this.f16580n / 2), this.f16579m + (this.f16581o / 2));
        }
    }

    public int getOpacity() {
        return this.f16584r;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f16571e.setColorFilter(colorFilter);
    }

    /* renamed from: g */
    private static Interpolator m18147g() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
        }
        return new DecelerateInterpolator();
    }

    /* renamed from: h */
    private static Interpolator m18150h() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(0.66f, 0.0f, 0.67f, 1.0f);
        }
        return new DecelerateInterpolator();
    }
}
