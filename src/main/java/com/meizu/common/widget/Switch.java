package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.CompoundButton;
import com.meizu.common.R;
import com.meizu.common.p060a.PathInterpolatorCompat;
import java.lang.reflect.Field;

public class Switch extends CompoundButton {

    /* renamed from: J */
    private static final int[] f6245J = {16842912};

    /* renamed from: M */
    private static Field f6246M;

    /* renamed from: j */
    private static int[] f6247j;

    /* renamed from: A */
    private Interpolator f6248A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public ValueAnimator f6249B;

    /* renamed from: C */
    private Interpolator f6250C;

    /* renamed from: D */
    private AnimatorSet f6251D;

    /* renamed from: E */
    private int f6252E;

    /* renamed from: F */
    private int f6253F;

    /* renamed from: G */
    private int f6254G;

    /* renamed from: H */
    private int f6255H;

    /* renamed from: I */
    private final Rect f6256I;

    /* renamed from: K */
    private boolean f6257K;

    /* renamed from: L */
    private boolean f6258L;

    /* renamed from: N */
    private C1554d f6259N;

    /* renamed from: O */
    private AttributeSet f6260O;

    /* renamed from: P */
    private int f6261P;

    /* renamed from: a */
    public CharSequence f6262a;

    /* renamed from: b */
    public CharSequence f6263b;

    /* renamed from: c */
    private Drawable f6264c;

    /* renamed from: d */
    private Drawable f6265d;

    /* renamed from: e */
    private C1557h f6266e;

    /* renamed from: f */
    private boolean f6267f;

    /* renamed from: g */
    private int f6268g;

    /* renamed from: h */
    private int f6269h;

    /* renamed from: i */
    private boolean f6270i;

    /* renamed from: k */
    private int f6271k;

    /* renamed from: l */
    private int f6272l;

    /* renamed from: m */
    private float f6273m;

    /* renamed from: n */
    private float f6274n;

    /* renamed from: o */
    private VelocityTracker f6275o;

    /* renamed from: p */
    private int f6276p;

    /* renamed from: q */
    private float f6277q;

    /* renamed from: r */
    private int f6278r;

    /* renamed from: s */
    private int f6279s;

    /* renamed from: t */
    private int f6280t;

    /* renamed from: u */
    private int f6281u;

    /* renamed from: v */
    private int f6282v;

    /* renamed from: w */
    private int f6283w;

    /* renamed from: x */
    private int f6284x;

    /* renamed from: y */
    private TextPaint f6285y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public ValueAnimator f6286z;

    /* renamed from: a */
    public float mo17452a(float f, float f2, float f3) {
        return f < f2 ? f + ((f2 - f) * f3) : f - ((f - f2) * f3);
    }

    /* renamed from: a */
    public int mo17453a(float f, float f2, boolean z) {
        return z ? (int) (f * 255.0f) : (int) (f2 * 255.0f);
    }

    /* renamed from: a */
    public int mo17454a(float f, int i, int i2) {
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        int i3 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        return ((i3 + ((int) (((float) (((i2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & 255) - i4)) * f))) << 16) | ((i5 + ((int) (((float) (((i2 >> 8) & 255) - i5)) * f))) << 8) | (i6 + ((int) (f * ((float) ((i2 & 255) - i6)))));
    }

    public Switch(Context context) {
        this(context, (AttributeSet) null);
    }

    public Switch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_Switch);
    }

    public Switch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6267f = false;
        this.f6275o = VelocityTracker.obtain();
        this.f6256I = new Rect();
        this.f6257K = false;
        this.f6258L = false;
        this.f6260O = attributeSet;
        this.f6285y = new TextPaint(1);
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Switch, i, 0);
        this.f6258L = obtainStyledAttributes.getBoolean(R.styleable.Switch_mcIgnoreSysNightMode, false);
        this.f6285y.density = resources.getDisplayMetrics().density;
        if (!m6201c() || this.f6258L) {
            this.f6264c = obtainStyledAttributes.getDrawable(R.styleable.Switch_mcTrack);
            if (this.f6264c == null) {
                this.f6264c = resources.getDrawable(R.drawable.mc_switch_anim_track);
            }
            this.f6253F = obtainStyledAttributes.getColor(R.styleable.Switch_mcThumbOffColor, getResources().getColor(R.color.mc_switch_thumb_off_color));
        } else {
            this.f6264c = obtainStyledAttributes.getDrawable(R.styleable.Switch_mcTrackSysNightMode);
            if (this.f6264c == null) {
                this.f6264c = resources.getDrawable(R.drawable.mc_switch_anim_track_sys_nightmode);
            }
            this.f6253F = obtainStyledAttributes.getColor(R.styleable.Switch_mcThumbOffColorSysNightMode, getResources().getColor(R.color.mc_switch_thumb_off_sys_nightmode_color));
        }
        if (this.f6264c != null) {
            this.f6264c.setCallback(this);
        }
        this.f6265d = obtainStyledAttributes.getDrawable(R.styleable.Switch_mcDarkTrack);
        if (this.f6265d == null) {
            this.f6265d = resources.getDrawable(R.drawable.mc_switch_anim_track_dark);
        }
        this.f6268g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Switch_mcSwitchMinWidth, 0);
        this.f6269h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Switch_mcSwitchPadding, 48);
        this.f6270i = false;
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.Switch_mcUseWhiteStyle, false);
        this.f6252E = obtainStyledAttributes.getColor(R.styleable.Switch_mcThumbOnColor, getResources().getColor(R.color.mz_theme_color_blue));
        this.f6254G = obtainStyledAttributes.getColor(R.styleable.Switch_mcDarkThumbOnColor, getResources().getColor(R.color.mz_theme_color_blue));
        this.f6255H = obtainStyledAttributes.getColor(R.styleable.Switch_mcDarkThumbOffColor, getResources().getColor(R.color.mc_switch_dark_thumb_off_color));
        obtainStyledAttributes.recycle();
        f6247j = new int[]{16843044, 16843045};
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f6247j, 16843839, 0);
        this.f6262a = obtainStyledAttributes2.getText(0);
        this.f6263b = obtainStyledAttributes2.getText(1);
        obtainStyledAttributes2.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f6272l = viewConfiguration.getScaledTouchSlop();
        this.f6276p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f6266e = m6194a(getResources().getDimensionPixelOffset(R.dimen.mz_switch_thumb_padding_left), getResources().getDimensionPixelOffset(R.dimen.mz_switch_thumb_padding_right));
        this.f6259N = C1554d.m6259a(this.f6266e);
        this.f6259N.mo17555a(this.f6253F, this.f6252E).mo17556b(this.f6255H, this.f6254G).mo17558d(getResources().getDimensionPixelOffset(R.dimen.mz_switch_thumb_from_height), getResources().getDimensionPixelOffset(R.dimen.mz_switch_thumb_to_height)).mo17559e(getResources().getDimensionPixelOffset(R.dimen.mz_switch_thumb_from_width), getResources().getDimensionPixelOffset(R.dimen.mz_switch_thumb_to_width)).mo17557c(getResources().getDimensionPixelOffset(R.dimen.mz_switch_thumb_from_corner_radius), getResources().getDimensionPixelOffset(R.dimen.mz_switch_thumb_to_corner_radius)).mo17554a(1.0f, 0.25f);
        this.f6266e.mo17596d().setCallback(this);
        if (z) {
            setStyleWhite();
        }
        refreshDrawableState();
        setChecked(isChecked());
    }

    /* renamed from: c */
    private boolean m6201c() {
        int i = getResources().getConfiguration().uiMode & 48;
        this.f6261P = i;
        return i == 32;
    }

    /* renamed from: d */
    private void m6202d() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(this.f6260O, R.styleable.Switch, R.attr.MeizuCommon_Switch, 0);
        if (!m6201c() || this.f6258L) {
            this.f6264c = obtainStyledAttributes.getDrawable(R.styleable.Switch_mcTrack);
            if (this.f6264c == null) {
                this.f6264c = getResources().getDrawable(R.drawable.mc_switch_anim_track);
            }
            this.f6253F = obtainStyledAttributes.getColor(R.styleable.Switch_mcThumbOffColor, getResources().getColor(R.color.mc_switch_thumb_off_color));
        } else {
            this.f6264c = obtainStyledAttributes.getDrawable(R.styleable.Switch_mcTrackSysNightMode);
            if (this.f6264c == null) {
                this.f6264c = getResources().getDrawable(R.drawable.mc_switch_anim_track_sys_nightmode);
            }
            this.f6253F = obtainStyledAttributes.getColor(R.styleable.Switch_mcThumbOffColorSysNightMode, getResources().getColor(R.color.mc_switch_thumb_off_sys_nightmode_color));
        }
        if (this.f6264c != null) {
            this.f6264c.setCallback(this);
        }
        if (this.f6259N != null) {
            this.f6259N.mo17555a(this.f6253F, this.f6252E);
            setThumbPosition(this.f6277q);
        }
        obtainStyledAttributes.recycle();
        refreshDrawableState();
    }

    public void setSwitchPadding(int i) {
        this.f6269h = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.f6269h;
    }

    public void setSwitchMinWidth(int i) {
        this.f6268g = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.f6268g;
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.f6264c != null) {
            this.f6264c.setCallback((Drawable.Callback) null);
        }
        this.f6264c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawableStateChanged();
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(getContext().getResources().getDrawable(i));
    }

    public Drawable getTrackDrawable() {
        return this.f6264c;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        Rect rect = this.f6256I;
        if (this.f6266e != null) {
            this.f6266e.mo17596d().getPadding(rect);
            i4 = Math.max((this.f6266e.mo17596d().getIntrinsicWidth() - rect.left) - rect.right, Math.max(this.f6259N.f6348f, this.f6259N.f6349g));
            i3 = this.f6266e.mo17596d().getIntrinsicHeight();
        } else {
            i4 = 0;
            i3 = 0;
        }
        this.f6280t = i4;
        if (this.f6264c != null) {
            this.f6264c.getPadding(rect);
            i5 = this.f6264c.getIntrinsicHeight();
        } else {
            rect.setEmpty();
            i5 = 0;
        }
        int i6 = rect.left;
        int i7 = rect.right;
        C1552b bVar = C1552b.f6338a;
        if (this.f6266e != null) {
            i6 = Math.max(i6, 0);
            i7 = Math.max(i7, 0);
            bVar = C1552b.m6257a(this.f6266e.mo17598e(), 0, this.f6266e.mo17600f(), 0);
        }
        int max = Math.max(this.f6268g, (this.f6280t * 2) + i6 + i7 + bVar.f6339b + bVar.f6341d);
        int max2 = Math.max(i5, i3);
        this.f6278r = max;
        this.f6279s = max2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    /* renamed from: a */
    private boolean m6198a(float f, float f2) {
        return f > ((float) this.f6281u) && f < ((float) this.f6283w) && f2 > ((float) this.f6282v) && f2 < ((float) this.f6284x);
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f6275o.addMovement(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (isEnabled() && m6198a(x, y)) {
                    this.f6271k = 1;
                    this.f6273m = x;
                    this.f6274n = y;
                    break;
                }
            case 1:
            case 3:
                if (this.f6271k != 2) {
                    this.f6271k = 0;
                    this.f6275o.clear();
                    break;
                } else {
                    m6200b(motionEvent);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
            case 2:
                switch (this.f6271k) {
                    case 1:
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x2 - this.f6273m) > ((float) this.f6272l) || Math.abs(y2 - this.f6274n) > ((float) this.f6272l)) {
                            this.f6271k = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f6273m = x2;
                            this.f6274n = y2;
                            return true;
                        }
                    case 2:
                        float x3 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f = x3 - this.f6273m;
                        float f2 = thumbScrollRange != 0 ? f / ((float) thumbScrollRange) : f > 0.0f ? 1.0f : -1.0f;
                        if (mo17458b()) {
                            f2 = -f2;
                        }
                        float a = C1553c.m6258a(this.f6277q + f2, 0.0f, 1.0f);
                        if (a != this.f6277q) {
                            this.f6273m = x3;
                            setThumbPosition(a);
                        }
                        return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private void m6195a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* renamed from: b */
    private void m6200b(MotionEvent motionEvent) {
        this.f6271k = 0;
        boolean z = true;
        if (motionEvent.getAction() == 1 && isEnabled()) {
            this.f6275o.computeCurrentVelocity(1000);
            float xVelocity = this.f6275o.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.f6276p)) {
                z = getTargetCheckedState();
            } else if (!mo17458b() ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                z = false;
            }
        } else {
            z = isChecked();
        }
        setCheckedWithHapticFeedback(z, false);
        m6195a(motionEvent);
    }

    /* renamed from: a */
    private void m6197a(boolean z) {
        float f = z ? 1.04f : -0.04f;
        float f2 = z ? 1.0f : 0.0f;
        if (this.f6251D != null && this.f6251D.isRunning()) {
            this.f6251D.removeAllListeners();
            this.f6251D.cancel();
        }
        if (this.f6286z != null && this.f6286z.isRunning()) {
            this.f6286z.removeAllUpdateListeners();
            this.f6286z.cancel();
        }
        this.f6286z = ValueAnimator.ofFloat(new float[]{this.f6277q, f});
        if (this.f6248A == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f6248A = new PathInterpolator(0.35f, 0.56f, 0.2f, 1.0f);
            } else {
                this.f6248A = new PathInterpolatorCompat(0.35f, 0.56f, 0.2f, 1.0f);
            }
        }
        this.f6286z.setInterpolator(this.f6248A);
        this.f6286z.setDuration(220);
        this.f6286z.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Switch.this.setThumbPosition(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.f6286z.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Switch.this.f6286z.removeAllUpdateListeners();
            }
        });
        if (this.f6249B != null && this.f6249B.isRunning()) {
            this.f6249B.removeAllUpdateListeners();
            this.f6249B.cancel();
        }
        this.f6249B = ValueAnimator.ofFloat(new float[]{f, f2});
        if (this.f6250C == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f6250C = new PathInterpolator(0.33f, 0.0f, 0.2f, 1.0f);
            } else {
                this.f6250C = new PathInterpolatorCompat(0.33f, 0.0f, 0.2f, 1.0f);
            }
        }
        this.f6249B.setInterpolator(this.f6250C);
        this.f6249B.setDuration(280);
        this.f6249B.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Switch.this.setThumbPosition(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.f6249B.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Switch.this.f6249B.removeAllUpdateListeners();
            }
        });
        this.f6251D = new AnimatorSet();
        this.f6251D.play(this.f6249B).after(this.f6286z);
        this.f6251D.start();
    }

    /* renamed from: a */
    public void mo17456a() {
        try {
            if (m6203e()) {
                performHapticFeedback(31022);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    private boolean m6203e() {
        try {
            if (f6246M == null) {
                f6246M = Class.forName("flyme.config.FlymeFeature").getDeclaredField("SHELL_HAPTICFEEDBACK_MOTOR");
            }
            return f6246M.getBoolean((Object) null);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: f */
    private void m6204f() {
        if (this.f6251D != null) {
            this.f6251D.cancel();
        }
    }

    private boolean getTargetCheckedState() {
        return this.f6277q > 0.5f;
    }

    /* access modifiers changed from: private */
    public void setThumbPosition(float f) {
        int i;
        this.f6277q = f;
        float max = f < 0.0f ? Math.max(f, 0.0f) : Math.min(f, 1.0f);
        if (this.f6259N != null) {
            this.f6266e.mo17595c(mo17459c(this.f6259N.f6348f, this.f6259N.f6349g, f));
            this.f6266e.mo17593b(mo17457b(this.f6259N.f6346d, this.f6259N.f6347e, f));
            this.f6266e.mo17590a(mo17452a(this.f6259N.f6344b, this.f6259N.f6345c, max));
            if (this.f6257K) {
                i = mo17455a(this.f6259N.f6352j, this.f6259N.f6353k, max);
            } else {
                i = mo17455a(this.f6259N.f6350h, this.f6259N.f6351i, max);
            }
            this.f6266e.mo17601f(mo17453a(this.f6259N.f6354l, this.f6259N.f6355m, isEnabled()));
            this.f6266e.mo17591a(i);
        }
        invalidate();
    }

    public void toggle() {
        setCheckedWithHapticFeedback(!isChecked());
    }

    public void setChecked(boolean z) {
        setChecked(z, true);
    }

    public void setCheckedWithHapticFeedback(boolean z, boolean z2) {
        if (isChecked() != z) {
            mo17456a();
        }
        setChecked(z, z2);
    }

    public void setCheckedWithHapticFeedback(boolean z) {
        setCheckedWithHapticFeedback(z, true);
    }

    public void setChecked(boolean z, boolean z2) {
        float f = 0.0f;
        if (isChecked() != z) {
            super.setChecked(z);
            boolean isChecked = isChecked();
            if (!z2 || Build.VERSION.SDK_INT < 19 || !isAttachedToWindow() || !isLaidOut()) {
                m6204f();
                if (isChecked) {
                    f = 1.0f;
                }
                setThumbPosition(f);
                return;
            }
            m6197a(isChecked);
        } else if (this.f6251D == null || !this.f6251D.isRunning()) {
            if (z) {
                f = 1.0f;
            }
            setThumbPosition(f);
        }
    }

    public boolean isLaidOut() {
        return getWidth() > 0 && getHeight() > 0;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f6259N != null && this.f6266e != null) {
            this.f6266e.mo17601f(mo17453a(this.f6259N.f6354l, this.f6259N.f6355m, z));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        super.onLayout(z, i, i2, i3, i4);
        int i10 = 0;
        if (this.f6266e != null) {
            Rect rect = this.f6256I;
            if (this.f6264c != null) {
                this.f6264c.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            C1552b bVar = C1552b.f6338a;
            int max = Math.max(0, bVar.f6339b - rect.left);
            i5 = Math.max(0, bVar.f6341d - rect.right);
            i10 = max;
        } else {
            i5 = 0;
        }
        if (mo17458b()) {
            i7 = getPaddingLeft() + i10;
            i6 = ((this.f6278r + i7) - i10) - i5;
        } else {
            i6 = (getWidth() - getPaddingRight()) - i5;
            i7 = (i6 - this.f6278r) + i10 + i5;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i9 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.f6279s / 2);
            i8 = this.f6279s + i9;
        } else if (gravity != 80) {
            i9 = getPaddingTop();
            i8 = this.f6279s + i9;
        } else {
            i8 = getHeight() - getPaddingBottom();
            i9 = i8 - this.f6279s;
        }
        this.f6281u = i7;
        this.f6282v = i9;
        this.f6284x = i8;
        this.f6283w = i6;
    }

    public void draw(Canvas canvas) {
        C1552b bVar;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Rect rect = this.f6256I;
        int i7 = this.f6281u;
        int i8 = this.f6282v;
        int i9 = this.f6283w;
        int i10 = this.f6284x;
        int thumbOffset = getThumbOffset() + i7;
        if (this.f6266e != null) {
            bVar = C1552b.f6338a;
        } else {
            bVar = C1552b.f6338a;
        }
        if (this.f6264c != null) {
            this.f6264c.getPadding(rect);
            thumbOffset += rect.left;
            if (bVar != C1552b.f6338a) {
                if (bVar.f6339b > rect.left) {
                    i7 += bVar.f6339b - rect.left;
                }
                i6 = bVar.f6340c > rect.top ? (bVar.f6340c - rect.top) + i8 : i8;
                i5 = bVar.f6341d > rect.right ? i9 - (bVar.f6341d - rect.right) : i9;
                if (bVar.f6342e > rect.bottom) {
                    i10 -= bVar.f6342e - rect.bottom;
                }
            } else {
                i6 = i8;
                i5 = i9;
            }
            this.f6264c.setBounds(i7, i6, i5, i10);
        }
        if (this.f6266e != null) {
            this.f6266e.mo17596d().getPadding(rect);
            if (mo17458b()) {
                i = (i9 - getThumbOffset()) - this.f6266e.mo17598e();
                i4 = i - this.f6266e.mo17594c();
                i2 = i8 + ((this.f6279s - this.f6266e.mo17592b()) / 2);
                i3 = this.f6266e.mo17592b() + i2;
            } else {
                i4 = this.f6266e.mo17598e() + thumbOffset;
                i = i4 + this.f6266e.mo17594c();
                i2 = i8 + ((this.f6279s - this.f6266e.mo17592b()) / 2);
                i3 = this.f6266e.mo17592b() + i2;
            }
            this.f6266e.mo17596d().setBounds(i4, i2, i, i3);
            this.f6266e.mo17596d().setColorFilter(this.f6266e.mo17589a(), PorterDuff.Mode.SRC_ATOP);
        }
        super.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = this.f6256I;
        Drawable drawable = this.f6264c;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        GradientDrawable d = this.f6266e.mo17596d();
        if (drawable != null) {
            if (!this.f6270i || d == null) {
                drawable.draw(canvas);
            } else {
                C1552b bVar = C1552b.f6338a;
                d.copyBounds(rect);
                rect.left += bVar.f6339b;
                rect.right -= bVar.f6341d;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (d != null) {
            d.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public int getCompoundPaddingLeft() {
        if (!mo17458b()) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f6278r;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f6269h : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (mo17458b()) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f6278r;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f6269h : compoundPaddingRight;
    }

    /* renamed from: b */
    public boolean mo17458b() {
        if (Build.VERSION.SDK_INT < 17 || getLayoutDirection() != 1) {
            return false;
        }
        return true;
    }

    private int getThumbOffset() {
        return (int) ((getThumbValue() * ((float) getThumbScrollRange())) + 0.5f);
    }

    private float getThumbValue() {
        return this.f6277q;
    }

    private int getThumbScrollRange() {
        C1552b bVar;
        if (this.f6264c == null) {
            return 0;
        }
        Rect rect = this.f6256I;
        this.f6264c.getPadding(rect);
        if (this.f6266e.mo17596d() != null) {
            bVar = C1552b.m6257a(this.f6266e.mo17598e(), 0, this.f6266e.mo17600f(), 0);
        } else {
            bVar = C1552b.f6338a;
        }
        return ((((this.f6278r - this.f6280t) - rect.left) - rect.right) - bVar.f6339b) - bVar.f6341d;
    }

    /* renamed from: a */
    private C1557h m6194a(int i, int i2) {
        C1557h hVar = new C1557h(new GradientDrawable());
        hVar.mo17596d().setShape(0);
        hVar.mo17597d(i);
        hVar.mo17599e(i2);
        return hVar;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f6245J);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (!(this.f6266e == null || this.f6266e.mo17596d() == null)) {
            this.f6266e.mo17596d().setState(drawableState);
        }
        if (this.f6264c != null) {
            this.f6264c.setState(drawableState);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || (this.f6266e != null && drawable == this.f6266e.mo17596d()) || drawable == this.f6264c;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f6266e.mo17596d() != null) {
            this.f6266e.mo17596d().jumpToCurrentState();
        }
        if (this.f6264c != null) {
            this.f6264c.jumpToCurrentState();
        }
        if (this.f6251D != null && this.f6251D.isRunning()) {
            this.f6251D.end();
            this.f6251D = null;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Switch.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Switch.class.getName());
        CharSequence charSequence = isChecked() ? this.f6262a : this.f6263b;
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    public void setStyleWhite() {
        if (!this.f6257K) {
            this.f6264c = this.f6265d;
            if (this.f6264c == null) {
                setStyleDefault();
                return;
            }
            this.f6264c.setCallback(this);
            this.f6267f = true;
            this.f6257K = true;
            refreshDrawableState();
            if (this.f6251D == null || !this.f6251D.isRunning()) {
                setThumbPosition(this.f6277q);
            }
            invalidate();
        }
    }

    public void setStyleDefault() {
        this.f6257K = false;
        m6202d();
        this.f6266e.mo17596d().setCallback(this);
        invalidate();
    }

    public void setThumbOnColor(int i) {
        this.f6252E = i;
        if (this.f6259N != null) {
            this.f6259N.mo17555a(this.f6253F, this.f6252E);
            setThumbPosition(this.f6277q);
        }
        invalidate();
    }

    public void setThumbOffColor(int i) {
        this.f6253F = i;
        if (this.f6259N != null) {
            this.f6259N.mo17555a(this.f6253F, this.f6252E);
            setThumbPosition(this.f6277q);
        }
        invalidate();
    }

    public void setDarkThumbOnColor(int i) {
        this.f6254G = i;
        if (this.f6259N != null) {
            this.f6259N.mo17556b(this.f6255H, this.f6254G);
            setThumbPosition(this.f6277q);
        }
        invalidate();
    }

    public void setDarkThumbOffColor(int i) {
        this.f6255H = i;
        if (this.f6259N != null) {
            this.f6259N.mo17556b(this.f6255H, this.f6254G);
            setThumbPosition(this.f6277q);
        }
        invalidate();
    }

    public void setIgnoreSystemNightMode(boolean z) {
        this.f6258L = z;
        m6202d();
        invalidate();
    }

    /* renamed from: a */
    public int mo17455a(int i, int i2, float f) {
        return mo17454a(f, i, i2);
    }

    /* renamed from: b */
    public int mo17457b(int i, int i2, float f) {
        if (i < i2) {
            return i + Math.round(((float) (i2 - i)) * f);
        }
        return i - Math.round(((float) (i - i2)) * f);
    }

    /* renamed from: c */
    public int mo17459c(int i, int i2, float f) {
        if (i < i2) {
            return i + Math.round(((float) (i2 - i)) * f);
        }
        return i - Math.round(((float) (i - i2)) * f);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f6249B != null) {
            this.f6249B.removeAllListeners();
        }
        if (this.f6286z != null) {
            this.f6249B.removeAllListeners();
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.uiMode & 48;
        if (i != this.f6261P) {
            this.f6261P = i;
            m6202d();
            invalidate();
        }
    }
}
