package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.drawble.CircularAnimatedDrawable;
import com.meizu.common.drawble.CircularProgressDrawable;
import com.meizu.common.drawble.StrokeGradientDrawable;
import com.meizu.common.p060a.PathInterpolatorCompat;
import com.meizu.common.util.ResourceUtils;

public class CircularProgressButton extends Button {

    /* renamed from: V */
    private static int f4756V = 800;

    /* renamed from: A */
    private Drawable f4757A;

    /* renamed from: B */
    private boolean f4758B;

    /* renamed from: C */
    private boolean f4759C;

    /* renamed from: D */
    private C1380a f4760D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public ColorStateList f4761E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public ColorStateList f4762F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public ColorStateList f4763G;

    /* renamed from: H */
    private ColorStateList f4764H;

    /* renamed from: I */
    private ColorStateList f4765I;

    /* renamed from: J */
    private ColorStateList f4766J;

    /* renamed from: K */
    private boolean f4767K;

    /* renamed from: L */
    private boolean f4768L;

    /* renamed from: M */
    private boolean f4769M;

    /* renamed from: N */
    private int f4770N;

    /* renamed from: O */
    private int f4771O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public boolean f4772P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public boolean f4773Q;

    /* renamed from: R */
    private int f4774R;

    /* renamed from: S */
    private int f4775S;

    /* renamed from: T */
    private int f4776T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public boolean f4777U;

    /* renamed from: W */
    private ValueAnimator f4778W;

    /* renamed from: a */
    private StrokeGradientDrawable f4779a;
    /* access modifiers changed from: private */

    /* renamed from: aa */
    public int f4780aa;

    /* renamed from: ab */
    private C1384b f4781ab;

    /* renamed from: ac */
    private C1384b f4782ac;

    /* renamed from: ad */
    private C1384b f4783ad;

    /* renamed from: ae */
    private C1384b f4784ae;

    /* renamed from: b */
    private CircularAnimatedDrawable f4785b;

    /* renamed from: c */
    private CircularProgressDrawable f4786c;

    /* renamed from: d */
    private ColorStateList f4787d;

    /* renamed from: e */
    private ColorStateList f4788e;

    /* renamed from: f */
    private ColorStateList f4789f;

    /* renamed from: g */
    private StateListDrawable f4790g;

    /* renamed from: h */
    private StateListDrawable f4791h;

    /* renamed from: i */
    private StateListDrawable f4792i;

    /* renamed from: j */
    private StateListDrawable f4793j;

    /* renamed from: k */
    private StateListDrawable f4794k;

    /* renamed from: l */
    private State f4795l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f4796m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f4797n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f4798o;

    /* renamed from: p */
    private String f4799p;

    /* renamed from: q */
    private int f4800q;

    /* renamed from: r */
    private int f4801r;

    /* renamed from: s */
    private int f4802s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f4803t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f4804u;

    /* renamed from: v */
    private int f4805v;

    /* renamed from: w */
    private int f4806w;

    /* renamed from: x */
    private float f4807x;

    /* renamed from: y */
    private boolean f4808y;

    /* renamed from: z */
    private boolean f4809z;

    public enum State {
        PROGRESS,
        IDLE,
        COMPLETE,
        ERROR
    }

    /* renamed from: com.meizu.common.widget.CircularProgressButton$b */
    interface C1384b {
        /* renamed from: a */
        void mo16277a();
    }

    public CircularProgressButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_CircularProgressButton);
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4759C = true;
        this.f4767K = false;
        this.f4768L = false;
        this.f4769M = true;
        this.f4771O = 0;
        this.f4772P = true;
        this.f4776T = 0;
        this.f4781ab = new C1384b() {
            /* renamed from: a */
            public void mo16277a() {
                boolean unused = CircularProgressButton.this.f4777U = false;
                CircularProgressButton.this.setClickable(true);
                CircularProgressButton.this.setText((CharSequence) null);
                CircularProgressButton.this.requestLayout();
            }
        };
        this.f4782ac = new C1384b() {
            /* renamed from: a */
            public void mo16277a() {
                if (CircularProgressButton.this.f4803t != 0) {
                    CircularProgressButton.this.setText((CharSequence) null);
                    CircularProgressButton.this.setIcon(CircularProgressButton.this.f4803t);
                } else {
                    CircularProgressButton.this.setText(CircularProgressButton.this.f4797n);
                }
                float unused = CircularProgressButton.this.m5319c();
                boolean unused2 = CircularProgressButton.this.f4777U = false;
                CircularProgressButton.this.setClickable(true);
                CircularProgressButton.this.setTextColor(CircularProgressButton.this.f4762F);
            }
        };
        this.f4783ad = new C1384b() {
            /* renamed from: a */
            public void mo16277a() {
                CircularProgressButton.this.mo16239a();
                CircularProgressButton.this.setText(CircularProgressButton.this.f4796m);
                float unused = CircularProgressButton.this.m5319c();
                boolean unused2 = CircularProgressButton.this.f4777U = false;
                CircularProgressButton.this.setClickable(true);
                CircularProgressButton.this.setTextColor(CircularProgressButton.this.f4761E);
            }
        };
        this.f4784ae = new C1384b() {
            /* renamed from: a */
            public void mo16277a() {
                if (CircularProgressButton.this.f4804u != 0) {
                    CircularProgressButton.this.setText((CharSequence) null);
                    CircularProgressButton.this.setIcon(CircularProgressButton.this.f4804u);
                } else {
                    CircularProgressButton.this.setText(CircularProgressButton.this.f4798o);
                }
                boolean unused = CircularProgressButton.this.f4777U = false;
                CircularProgressButton.this.setClickable(true);
                CircularProgressButton.this.setTextColor(CircularProgressButton.this.f4763G);
            }
        };
        m5304a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m5304a(Context context, AttributeSet attributeSet, int i) {
        m5316b(context, attributeSet, i);
        this.f4775S = 100;
        this.f4795l = State.IDLE;
        setText(this.f4796m);
        m5319c();
        m5329f();
        m5327e();
        m5331g();
        m5325d();
        this.f4794k = this.f4790g;
        setBackgroundCompat((Drawable) null);
    }

    /* renamed from: b */
    private void m5316b(Context context, AttributeSet attributeSet, int i) {
        TypedArray a = mo16238a(context, attributeSet, R.styleable.CircularProgressButton, i);
        if (a != null) {
            this.f4805v = a.getDimensionPixelSize(R.styleable.CircularProgressButton_mcCirButtonStrokeWidth, (int) getContext().getResources().getDimension(R.dimen.mc_cir_progress_button_stroke_width));
            this.f4774R = this.f4805v;
            this.f4796m = a.getString(R.styleable.CircularProgressButton_mcCirButtonTextIdle);
            this.f4797n = a.getString(R.styleable.CircularProgressButton_mcCirButtonTextComplete);
            this.f4798o = a.getString(R.styleable.CircularProgressButton_mcCirButtonTextError);
            this.f4799p = a.getString(R.styleable.CircularProgressButton_mcCirButtonTextProgress);
            this.f4803t = a.getResourceId(R.styleable.CircularProgressButton_mcCirButtonIconComplete, 0);
            this.f4804u = a.getResourceId(R.styleable.CircularProgressButton_mcCirButtonIconError, 0);
            this.f4807x = a.getDimension(R.styleable.CircularProgressButton_mcCirButtonCornerRadius, 0.0f);
            this.f4806w = a.getDimensionPixelSize(R.styleable.CircularProgressButton_mcCirButtonPaddingProgress, 0);
            int resourceId = a.getResourceId(R.styleable.CircularProgressButton_mcCirButtonSelectorIdle, R.color.mc_cir_progress_button_blue);
            this.f4787d = getResources().getColorStateList(resourceId);
            this.f4764H = getResources().getColorStateList(a.getResourceId(R.styleable.CircularProgressButton_mcCirButtonStrokeColorIdle, resourceId));
            int resourceId2 = a.getResourceId(R.styleable.CircularProgressButton_mcCirButtonSelectorComplete, R.color.mc_cir_progress_button_green);
            this.f4788e = getResources().getColorStateList(resourceId2);
            this.f4765I = getResources().getColorStateList(a.getResourceId(R.styleable.CircularProgressButton_mcCirButtonStrokeColorComplete, resourceId2));
            int resourceId3 = a.getResourceId(R.styleable.CircularProgressButton_mcCirButtonSelectorError, R.color.mc_cir_progress_button_red);
            this.f4789f = getResources().getColorStateList(resourceId3);
            this.f4766J = getResources().getColorStateList(a.getResourceId(R.styleable.CircularProgressButton_mcCirButtonStrokeColorError, resourceId3));
            this.f4800q = a.getColor(R.styleable.CircularProgressButton_mcCirButtonColorProgress, mo16236a(R.color.mc_cir_progress_button_white));
            this.f4801r = a.getColor(R.styleable.CircularProgressButton_mcCirButtonColorIndicator, mo16236a(R.color.mc_cir_progress_button_blue));
            this.f4802s = a.getColor(R.styleable.CircularProgressButton_mcCirButtonColorIndicatorBackground, mo16236a(R.color.mc_cir_progress_button_blank));
            this.f4763G = a.getColorStateList(R.styleable.CircularProgressButton_mcCirButtonTextColorError);
            if (this.f4763G == null) {
                this.f4763G = getTextColors();
            }
            this.f4761E = a.getColorStateList(R.styleable.CircularProgressButton_mcCirButtonTextColorIdle);
            if (this.f4761E == null) {
                this.f4761E = getTextColors();
            }
            this.f4762F = a.getColorStateList(R.styleable.CircularProgressButton_mcCirButtonTextColorComplete);
            if (this.f4762F == null) {
                this.f4762F = getTextColors();
            }
            this.f4769M = a.getBoolean(R.styleable.CircularProgressButton_mcCirButtonAutoFitPadding, true);
            a.recycle();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public float m5319c() {
        setEllipsize(TextUtils.TruncateAt.END);
        setMaxLines(1);
        if (!this.f4769M || getText() == null) {
            return 0.0f;
        }
        float a = (float) mo16237a((Paint) getPaint(), getText().toString());
        int a2 = (int) ResourceUtils.m5160a(12.0f, getContext());
        if (((float) (a2 * 2)) + a < ((float) ((int) ResourceUtils.m5160a(90.0f, getContext())))) {
            setPadding(a2, 0, a2, 0);
            return a;
        }
        int a3 = (int) ResourceUtils.m5160a(8.0f, getContext());
        setPadding(a3, 0, a3, 0);
        return a;
    }

    /* renamed from: d */
    private void m5325d() {
        StrokeGradientDrawable a = m5302a(m5313b(this.f4789f), m5313b(this.f4766J));
        if (this.f4792i == null) {
            this.f4792i = new StateListDrawable();
            this.f4792i.setCallback(this);
        }
        this.f4792i.addState(new int[]{16842919}, a.getGradientDrawable());
        this.f4792i.addState(StateSet.WILD_CARD, this.f4779a.getGradientDrawable());
        this.f4792i.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
    }

    /* renamed from: e */
    private void m5327e() {
        StrokeGradientDrawable a = m5302a(m5313b(this.f4788e), m5313b(this.f4765I));
        if (this.f4791h == null) {
            this.f4791h = new StateListDrawable();
            this.f4791h.setCallback(this);
        }
        this.f4791h.addState(new int[]{16842919}, a.getGradientDrawable());
        this.f4791h.addState(StateSet.WILD_CARD, this.f4779a.getGradientDrawable());
        this.f4791h.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
    }

    /* renamed from: f */
    private void m5329f() {
        int a = m5300a(this.f4787d);
        int b = m5313b(this.f4787d);
        int c = m5321c(this.f4787d);
        int d = m5323d(this.f4787d);
        int a2 = m5300a(this.f4764H);
        int b2 = m5313b(this.f4764H);
        int c2 = m5321c(this.f4764H);
        int d2 = m5323d(this.f4764H);
        if (this.f4779a == null) {
            this.f4779a = m5302a(a, a2);
        }
        StrokeGradientDrawable a3 = m5302a(d, d2);
        StrokeGradientDrawable a4 = m5302a(c, c2);
        StrokeGradientDrawable a5 = m5302a(b, b2);
        if (this.f4790g == null) {
            this.f4790g = new StateListDrawable();
            this.f4790g.setCallback(this);
        }
        this.f4790g.addState(new int[]{16842919}, a5.getGradientDrawable());
        this.f4790g.addState(new int[]{16842908}, a4.getGradientDrawable());
        this.f4790g.addState(new int[]{-16842910}, a3.getGradientDrawable());
        this.f4790g.addState(StateSet.WILD_CARD, this.f4779a.getGradientDrawable());
        this.f4790g.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
    }

    /* renamed from: g */
    private void m5331g() {
        if (this.f4793j == null) {
            this.f4793j = new StateListDrawable();
            this.f4793j.setCallback(this);
        }
        this.f4793j.addState(StateSet.WILD_CARD, this.f4779a.getGradientDrawable());
        int abs = (Math.abs(getWidth() - getHeight()) / 2) + this.f4806w;
        this.f4793j.setBounds(abs, this.f4806w, (getWidth() - abs) - this.f4806w, getHeight() - this.f4806w);
    }

    /* renamed from: a */
    private int m5300a(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842910}, 0);
    }

    /* renamed from: b */
    private int m5313b(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842919}, 0);
    }

    /* renamed from: c */
    private int m5321c(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842908}, 0);
    }

    /* renamed from: d */
    private int m5323d(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{-16842910}, 0);
    }

    /* renamed from: a */
    private StrokeGradientDrawable m5302a(int i, int i2) {
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.mc_cir_pro_btn_background).mutate();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(this.f4807x);
        StrokeGradientDrawable strokeGradientDrawable = new StrokeGradientDrawable(gradientDrawable);
        strokeGradientDrawable.setStrokeColor(i2);
        strokeGradientDrawable.setStrokeWidth(this.f4805v);
        return strokeGradientDrawable;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        Rect h = m5332h();
        m5308a((Drawable) this.f4790g, getDrawableState());
        m5308a((Drawable) this.f4791h, getDrawableState());
        m5308a((Drawable) this.f4792i, getDrawableState());
        m5308a((Drawable) this.f4793j, getDrawableState());
        m5306a(h);
        super.drawableStateChanged();
    }

    /* renamed from: h */
    private Rect m5332h() {
        if (!this.f4777U) {
            return null;
        }
        Rect rect = new Rect();
        rect.set(this.f4779a.getGradientDrawable().getBounds());
        return rect;
    }

    /* renamed from: a */
    private void m5306a(Rect rect) {
        if (this.f4777U && rect != null) {
            this.f4779a.getGradientDrawable().setBounds(rect);
        }
    }

    /* renamed from: a */
    private void m5308a(Drawable drawable, int[] iArr) {
        if (drawable != null) {
            drawable.setState(iArr);
        }
    }

    public void setPressed(boolean z) {
        if (!z || !this.f4777U) {
            super.setPressed(z);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo16236a(int i) {
        return getResources().getColor(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public TypedArray mo16238a(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return context.obtainStyledAttributes(attributeSet, iArr, i, 0);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4795l != State.PROGRESS || this.f4777U) {
            if (this.f4785b != null) {
                this.f4785b.setAllowLoading(false);
            }
        } else if (this.f4808y) {
            m5305a(canvas);
        } else {
            m5317b(canvas);
        }
    }

    /* renamed from: a */
    private void m5305a(Canvas canvas) {
        if (this.f4785b == null) {
            int width = (getWidth() - getHeight()) / 2;
            this.f4785b = new CircularAnimatedDrawable(this.f4801r, (float) this.f4774R);
            int i = this.f4806w + width;
            int width2 = (getWidth() - width) - this.f4806w;
            int height = getHeight() - this.f4806w;
            this.f4785b.setBounds(i, this.f4806w, width2, height);
            this.f4785b.setCallback(this);
            this.f4785b.start();
            return;
        }
        this.f4785b.setAllowLoading(true);
        this.f4785b.draw(canvas);
    }

    /* renamed from: b */
    private void m5317b(Canvas canvas) {
        if (this.f4786c == null) {
            this.f4786c = new CircularProgressDrawable(getHeight() - (this.f4806w * 2), this.f4774R, this.f4801r);
            int width = ((getWidth() - getHeight()) / 2) + this.f4806w;
            this.f4786c.setBounds(width, this.f4806w, width, this.f4806w);
        }
        if (this.f4758B) {
            this.f4758B = false;
            this.f4786c.setCenterIcon(this.f4757A);
            if (this.f4757A == null) {
                this.f4786c.setShowCenterIcon(this.f4767K);
            }
        }
        float f = (-(180.0f / ((float) this.f4775S))) * 2.0f * ((float) this.f4780aa);
        this.f4786c.setStartAngle(((180.0f / ((float) this.f4775S)) * ((float) this.f4780aa)) + 90.0f);
        this.f4786c.setSweepAngle(f);
        this.f4786c.draw(canvas);
    }

    public void setIndeterminateProgressMode(boolean z) {
        this.f4808y = z;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f4785b || drawable == this.f4793j || drawable == this.f4790g || drawable == this.f4792i || drawable == this.f4791h || super.verifyDrawable(drawable);
    }

    /* renamed from: i */
    private C1380a m5335i() {
        this.f4777U = true;
        setClickable(false);
        this.f4760D = new C1380a(this, this.f4779a);
        this.f4760D.mo16285a(this.f4807x);
        this.f4760D.mo16289b(this.f4807x);
        this.f4760D.mo16290b(getWidth());
        this.f4760D.mo16293c(getWidth());
        if (this.f4809z || !this.f4759C) {
            this.f4760D.mo16286a(1);
        } else {
            this.f4760D.mo16286a(240);
        }
        this.f4809z = false;
        return this.f4760D;
    }

    /* renamed from: a */
    private C1380a m5303a(float f, float f2, int i, int i2) {
        this.f4777U = true;
        setClickable(false);
        this.f4760D = new C1380a(this, this.f4779a);
        this.f4760D.mo16285a(f);
        this.f4760D.mo16289b(f2);
        this.f4760D.mo16292c((float) this.f4806w);
        this.f4760D.mo16290b(i);
        this.f4760D.mo16293c(i2);
        if (this.f4809z || !this.f4759C) {
            this.f4760D.mo16286a(1);
        } else {
            this.f4760D.mo16286a(240);
        }
        this.f4809z = false;
        return this.f4760D;
    }

    /* renamed from: a */
    public int mo16237a(Paint paint, String str) {
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, this).toString();
        }
        return (int) paint.measureText(str);
    }

    /* renamed from: j */
    private void m5337j() {
        if (this.f4771O == 0) {
            this.f4771O = getWidth();
        }
        if (!this.f4772P || this.f4773Q) {
            this.f4770N = mo16237a((Paint) getPaint(), this.f4798o) + getCompoundPaddingLeft() + getCompoundPaddingRight();
        } else {
            this.f4770N = getWidth();
        }
        setWidth(this.f4770N);
        setText(this.f4799p);
        m5319c();
        C1380a a = m5303a(this.f4807x, (float) getHeight(), this.f4770N, getHeight());
        a.mo16294d(m5300a(this.f4787d));
        a.mo16295e(this.f4800q);
        a.mo16296f(m5300a(this.f4764H));
        a.mo16297g(this.f4802s);
        a.mo16298h(this.f4805v);
        a.mo16299i(this.f4774R);
        a.mo16287a(this.f4781ab);
        setState(State.PROGRESS);
        this.f4794k = this.f4793j;
        a.mo16284a();
    }

    /* renamed from: k */
    private void m5338k() {
        C1380a a = m5303a((float) getHeight(), this.f4807x, getHeight(), getWidth());
        a.mo16294d(this.f4800q);
        a.mo16296f(this.f4801r);
        a.mo16297g(m5300a(this.f4765I));
        a.mo16295e(m5300a(this.f4788e));
        a.mo16298h(this.f4774R);
        a.mo16299i(this.f4805v);
        a.mo16287a(this.f4782ac);
        setState(State.COMPLETE);
        this.f4794k = this.f4791h;
        a.mo16284a();
    }

    /* renamed from: l */
    private void m5339l() {
        C1380a i = m5335i();
        i.mo16294d(m5300a(this.f4787d));
        i.mo16296f(m5300a(this.f4764H));
        i.mo16295e(m5300a(this.f4788e));
        i.mo16297g(m5300a(this.f4765I));
        i.mo16287a(this.f4782ac);
        setState(State.COMPLETE);
        this.f4794k = this.f4791h;
        i.mo16284a();
    }

    /* renamed from: m */
    private void m5340m() {
        C1380a i = m5335i();
        i.mo16294d(m5300a(this.f4788e));
        i.mo16295e(m5300a(this.f4787d));
        i.mo16296f(m5300a(this.f4765I));
        i.mo16297g(m5300a(this.f4764H));
        i.mo16287a(this.f4783ad);
        setState(State.IDLE);
        this.f4794k = this.f4790g;
        i.mo16284a();
    }

    /* renamed from: n */
    private void m5341n() {
        C1380a i = m5335i();
        i.mo16294d(m5300a(this.f4789f));
        i.mo16295e(m5300a(this.f4787d));
        i.mo16296f(m5300a(this.f4766J));
        i.mo16297g(m5300a(this.f4764H));
        i.mo16287a(this.f4783ad);
        setState(State.IDLE);
        this.f4794k = this.f4790g;
        i.mo16284a();
    }

    /* renamed from: o */
    private void m5342o() {
        C1380a i = m5335i();
        i.mo16294d(m5300a(this.f4787d));
        i.mo16295e(m5300a(this.f4789f));
        i.mo16296f(m5300a(this.f4764H));
        i.mo16297g(m5300a(this.f4766J));
        i.mo16287a(this.f4784ae);
        setState(State.ERROR);
        this.f4794k = this.f4792i;
        i.mo16284a();
    }

    /* renamed from: p */
    private void m5343p() {
        this.f4760D = new C1380a(this, this.f4779a);
        this.f4760D.mo16294d(this.f4800q);
        this.f4760D.mo16295e(m5300a(this.f4789f));
        this.f4760D.mo16296f(this.f4801r);
        this.f4760D.mo16297g(m5300a(this.f4766J));
        this.f4760D.mo16287a((C1384b) new C1384b() {
            /* renamed from: a */
            public void mo16277a() {
                if (CircularProgressButton.this.f4804u != 0) {
                    CircularProgressButton.this.setText((CharSequence) null);
                    CircularProgressButton.this.setIcon(CircularProgressButton.this.f4804u);
                    return;
                }
                CircularProgressButton.this.setWidth(CircularProgressButton.this.mo16237a((Paint) CircularProgressButton.this.getPaint(), CircularProgressButton.this.f4798o) + CircularProgressButton.this.getCompoundPaddingRight() + CircularProgressButton.this.getCompoundPaddingLeft());
                CircularProgressButton.this.setText(CircularProgressButton.this.f4798o);
                boolean unused = CircularProgressButton.this.f4772P = false;
                boolean unused2 = CircularProgressButton.this.f4773Q = true;
            }
        });
        setState(State.ERROR);
        this.f4794k = this.f4792i;
        this.f4760D.mo16288b();
    }

    /* renamed from: q */
    private void m5344q() {
        C1380a a = m5303a((float) getHeight(), this.f4807x, getHeight(), getWidth());
        a.mo16294d(this.f4800q);
        a.mo16295e(m5300a(this.f4789f));
        a.mo16296f(this.f4801r);
        a.mo16297g(m5300a(this.f4766J));
        a.mo16298h(this.f4774R);
        a.mo16299i(this.f4805v);
        a.mo16287a(this.f4784ae);
        setState(State.ERROR);
        this.f4794k = this.f4792i;
        a.mo16284a();
    }

    /* renamed from: r */
    private void m5345r() {
        C1380a a = m5303a((float) getHeight(), this.f4807x, getHeight(), getWidth());
        a.mo16294d(this.f4800q);
        a.mo16295e(m5300a(this.f4787d));
        a.mo16296f(this.f4801r);
        a.mo16297g(m5300a(this.f4764H));
        a.mo16298h(this.f4774R);
        a.mo16299i(this.f4805v);
        a.mo16287a((C1384b) new C1384b() {
            /* renamed from: a */
            public void mo16277a() {
                CircularProgressButton.this.mo16239a();
                CircularProgressButton.this.setText(CircularProgressButton.this.f4796m);
                float unused = CircularProgressButton.this.m5319c();
                boolean unused2 = CircularProgressButton.this.f4777U = false;
                CircularProgressButton.this.setClickable(true);
            }
        });
        setState(State.IDLE);
        this.f4794k = this.f4790g;
        a.mo16284a();
    }

    /* access modifiers changed from: private */
    public void setIcon(int i) {
        Drawable drawable = getResources().getDrawable(i);
        if (drawable != null) {
            setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
            setPadding((getWidth() / 2) - (drawable.getIntrinsicWidth() / 2), 0, 0, 0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo16239a() {
        setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        setPadding(0, 0, 0, 0);
    }

    @SuppressLint({"NewApi"})
    public void setBackgroundCompat(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    public void setProgress(int i, boolean z) {
        this.f4776T = i;
        this.f4759C = z;
        if (!this.f4777U && getWidth() != 0) {
            if (this.f4776T >= this.f4775S) {
                if (this.f4795l == State.PROGRESS) {
                    m5338k();
                } else if (this.f4795l == State.IDLE) {
                    m5339l();
                }
            } else if (this.f4776T > 0) {
                if (this.f4795l == State.IDLE || this.f4795l == State.ERROR) {
                    m5337j();
                } else if (this.f4795l == State.PROGRESS) {
                    m5348u();
                    if (z) {
                        m5347t();
                        return;
                    }
                    this.f4780aa = this.f4776T;
                    invalidate();
                }
            } else if (this.f4776T == -1) {
                if (this.f4795l == State.PROGRESS) {
                    m5344q();
                } else if (this.f4795l == State.IDLE) {
                    m5342o();
                }
            } else if (this.f4776T != 0) {
            } else {
                if (this.f4795l == State.COMPLETE) {
                    m5340m();
                } else if (this.f4795l == State.PROGRESS) {
                    m5345r();
                } else if (this.f4795l == State.ERROR) {
                    m5341n();
                }
            }
        }
    }

    @Deprecated
    public void setProgress(int i) {
        setProgress(i, true);
    }

    public int getProgress() {
        return this.f4776T;
    }

    public void setBackgroundColor(int i) {
        this.f4779a.getGradientDrawable().setColor(i);
    }

    public void setStrokeColor(int i) {
        this.f4779a.setStrokeColor(i);
    }

    public String getIdleText() {
        return this.f4796m;
    }

    public String getCompleteText() {
        return this.f4797n;
    }

    public String getErrorText() {
        return this.f4798o;
    }

    public void setIdleText(String str) {
        this.f4796m = str;
    }

    public void setCompleteText(String str) {
        this.f4797n = str;
    }

    public void setErrorText(String str) {
        this.f4798o = str;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            setState(this.f4795l, false, false);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int unused = savedState.f4820c = this.f4776T;
        boolean unused2 = savedState.f4818a = this.f4808y;
        boolean unused3 = savedState.f4819b = true;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f4776T = savedState.f4820c;
            this.f4808y = savedState.f4818a;
            this.f4809z = savedState.f4819b;
            super.onRestoreInstanceState(savedState.getSuperState());
            setProgress(this.f4776T);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f4818a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public boolean f4819b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f4820c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f4820c = parcel.readInt();
            boolean z = false;
            this.f4818a = parcel.readInt() == 1;
            this.f4819b = parcel.readInt() == 1 ? true : z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4820c);
            parcel.writeInt(this.f4818a ? 1 : 0);
            parcel.writeInt(this.f4819b ? 1 : 0);
        }
    }

    /* renamed from: com.meizu.common.widget.CircularProgressButton$a */
    class C1380a {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public C1384b f4822b;

        /* renamed from: c */
        private int f4823c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public int f4824d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public int f4825e;

        /* renamed from: f */
        private int f4826f;

        /* renamed from: g */
        private int f4827g;

        /* renamed from: h */
        private int f4828h;

        /* renamed from: i */
        private int f4829i;

        /* renamed from: j */
        private float f4830j;

        /* renamed from: k */
        private float f4831k;

        /* renamed from: l */
        private int f4832l;

        /* renamed from: m */
        private int f4833m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public float f4834n;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public TextView f4835o;

        /* renamed from: p */
        private StrokeGradientDrawable f4836p;

        /* renamed from: q */
        private AnimatorSet f4837q;

        public C1380a(TextView textView, StrokeGradientDrawable strokeGradientDrawable) {
            this.f4835o = textView;
            this.f4836p = strokeGradientDrawable;
        }

        /* renamed from: a */
        public void mo16286a(int i) {
            this.f4823c = i;
        }

        /* renamed from: a */
        public void mo16287a(C1384b bVar) {
            this.f4822b = bVar;
        }

        /* renamed from: b */
        public void mo16290b(int i) {
            this.f4824d = i;
        }

        /* renamed from: c */
        public void mo16293c(int i) {
            this.f4825e = i;
        }

        /* renamed from: d */
        public void mo16294d(int i) {
            this.f4826f = i;
        }

        /* renamed from: e */
        public void mo16295e(int i) {
            this.f4827g = i;
        }

        /* renamed from: f */
        public void mo16296f(int i) {
            this.f4828h = i;
        }

        /* renamed from: g */
        public void mo16297g(int i) {
            this.f4829i = i;
        }

        /* renamed from: a */
        public void mo16285a(float f) {
            this.f4830j = f;
        }

        /* renamed from: b */
        public void mo16289b(float f) {
            this.f4831k = f;
        }

        /* renamed from: c */
        public void mo16292c(float f) {
            this.f4834n = f;
        }

        /* renamed from: h */
        public void mo16298h(int i) {
            this.f4832l = i;
        }

        /* renamed from: i */
        public void mo16299i(int i) {
            this.f4833m = i;
        }

        /* renamed from: a */
        public void mo16284a() {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f4824d, this.f4825e});
            final GradientDrawable gradientDrawable = this.f4836p.getGradientDrawable();
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int i;
                    int i2;
                    int i3;
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    if (C1380a.this.f4824d > C1380a.this.f4825e) {
                        i2 = (C1380a.this.f4824d - num.intValue()) / 2;
                        i3 = C1380a.this.f4824d - i2;
                        i = (int) (C1380a.this.f4834n * valueAnimator.getAnimatedFraction());
                    } else {
                        i2 = (C1380a.this.f4825e - num.intValue()) / 2;
                        i3 = C1380a.this.f4825e - i2;
                        i = (int) (C1380a.this.f4834n - (C1380a.this.f4834n * valueAnimator.getAnimatedFraction()));
                    }
                    gradientDrawable.setBounds(i2 + i, i, (i3 - i) - 1, (C1380a.this.f4835o.getHeight() - i) - 1);
                    CircularProgressButton.this.invalidate();
                }
            });
            ObjectAnimator ofInt2 = ObjectAnimator.ofInt(gradientDrawable, "color", new int[]{this.f4826f, this.f4827g});
            ofInt2.setEvaluator(new ArgbEvaluator());
            ObjectAnimator ofInt3 = ObjectAnimator.ofInt(this.f4836p, "strokeColor", new int[]{this.f4828h, this.f4829i});
            ofInt3.setEvaluator(new ArgbEvaluator());
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(gradientDrawable, "cornerRadius", new float[]{this.f4830j, this.f4831k});
            ObjectAnimator ofInt4 = ObjectAnimator.ofInt(this.f4836p, "strokeWidth", new int[]{this.f4832l, this.f4833m});
            this.f4837q = new AnimatorSet();
            this.f4837q.setInterpolator(CircularProgressButton.this.getInterpolator());
            this.f4837q.setDuration((long) this.f4823c);
            this.f4837q.playTogether(new Animator[]{ofInt, ofInt2, ofInt3, ofFloat, ofInt4});
            this.f4837q.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (C1380a.this.f4822b != null) {
                        C1380a.this.f4822b.mo16277a();
                    }
                }
            });
            this.f4837q.start();
        }

        /* renamed from: b */
        public void mo16288b() {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f4836p.getGradientDrawable(), "color", new int[]{this.f4826f, this.f4827g});
            ofInt.setEvaluator(new ArgbEvaluator());
            ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this.f4836p, "strokeColor", new int[]{this.f4828h, this.f4829i});
            ofInt2.setEvaluator(new ArgbEvaluator());
            this.f4837q = new AnimatorSet();
            this.f4837q.setInterpolator(CircularProgressButton.this.getInterpolator());
            this.f4837q.setDuration((long) this.f4823c);
            this.f4837q.playTogether(new Animator[]{ofInt, ofInt2});
            this.f4837q.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (C1380a.this.f4822b != null) {
                        C1380a.this.f4822b.mo16277a();
                    }
                }
            });
            this.f4837q.start();
        }

        /* renamed from: c */
        public void mo16291c() {
            this.f4837q.end();
            this.f4837q.removeAllListeners();
        }
    }

    public void setProgressCenterIcon(Drawable drawable) {
        this.f4757A = drawable;
        this.f4758B = true;
    }

    public void setShowCenterIcon(boolean z) {
        this.f4767K = z;
        this.f4758B = true;
    }

    /* renamed from: s */
    private void m5346s() {
        m5309a(State.IDLE, (Drawable) this.f4790g);
        m5309a(State.COMPLETE, (Drawable) this.f4791h);
        m5309a(State.ERROR, (Drawable) this.f4792i);
        m5309a(this.f4795l, (Drawable) this.f4779a.getGradientDrawable());
    }

    /* renamed from: a */
    private void m5309a(State state, Drawable drawable) {
        if (drawable != null) {
            if (state == State.PROGRESS) {
                int abs = (Math.abs(getWidth() - getHeight()) / 2) + this.f4806w;
                drawable.setBounds(abs, this.f4806w, (getWidth() - abs) - this.f4806w, getHeight() - this.f4806w);
                return;
            }
            drawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
        }
    }

    public void setState(State state, boolean z, boolean z2) {
        if (state != this.f4795l) {
            this.f4759C = z;
            if (!z) {
                m5310a(state, false);
            } else if (!this.f4777U && getWidth() != 0) {
                switch (state) {
                    case COMPLETE:
                        switch (this.f4795l) {
                            case PROGRESS:
                                m5338k();
                                return;
                            case IDLE:
                                m5339l();
                                return;
                            default:
                                return;
                        }
                    case ERROR:
                        switch (this.f4795l) {
                            case PROGRESS:
                                if (mo16237a((Paint) getPaint(), this.f4798o) + getCompoundPaddingRight() + getCompoundPaddingLeft() <= this.f4771O || this.f4798o == null) {
                                    m5344q();
                                    return;
                                } else {
                                    m5343p();
                                    return;
                                }
                            case IDLE:
                                m5342o();
                                return;
                            default:
                                return;
                        }
                    case PROGRESS:
                        if (this.f4795l != State.PROGRESS) {
                            m5337j();
                            return;
                        }
                        return;
                    case IDLE:
                        switch (this.f4795l) {
                            case COMPLETE:
                                m5340m();
                                return;
                            case ERROR:
                                m5341n();
                                return;
                            case PROGRESS:
                                m5345r();
                                return;
                            default:
                                return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m5310a(State state, boolean z) {
        int i;
        if (z || state != this.f4795l) {
            mo16240b();
            String str = "";
            int a = m5300a(this.f4787d);
            int a2 = m5300a(this.f4787d);
            ColorStateList textColors = getTextColors();
            switch (state) {
                case COMPLETE:
                    a = m5300a(this.f4788e);
                    a2 = m5300a(this.f4765I);
                    str = this.f4797n;
                    setState(State.COMPLETE);
                    textColors = this.f4762F;
                    this.f4794k = this.f4791h;
                    break;
                case ERROR:
                    a = m5300a(this.f4789f);
                    a2 = m5300a(this.f4766J);
                    str = this.f4798o;
                    setState(State.ERROR);
                    textColors = this.f4763G;
                    this.f4794k = this.f4792i;
                    break;
                case PROGRESS:
                    a = this.f4800q;
                    a2 = this.f4802s;
                    setState(State.PROGRESS);
                    this.f4794k = this.f4793j;
                    break;
                case IDLE:
                    a = m5300a(this.f4787d);
                    a2 = m5300a(this.f4764H);
                    str = this.f4796m;
                    setState(State.IDLE);
                    textColors = this.f4761E;
                    this.f4794k = this.f4790g;
                    break;
            }
            GradientDrawable gradientDrawable = this.f4779a.getGradientDrawable();
            if (state == State.PROGRESS) {
                int abs = (Math.abs(getWidth() - getHeight()) / 2) + this.f4806w;
                gradientDrawable.setBounds(abs, this.f4806w, (getWidth() - abs) - this.f4806w, getHeight() - this.f4806w);
                i = this.f4774R;
            } else {
                i = this.f4805v;
                gradientDrawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
            }
            gradientDrawable.setColor(a);
            this.f4779a.setStrokeWidth(i);
            this.f4779a.setStrokeColor(a2);
            setText(str);
            setTextColor(textColors);
            invalidate();
        }
    }

    public void setProgressForState(int i, boolean z) {
        if (this.f4795l == State.PROGRESS) {
            this.f4776T = i;
            m5348u();
            if (z) {
                m5347t();
                return;
            }
            this.f4780aa = this.f4776T;
            invalidate();
        }
    }

    public void setProgressForState(int i) {
        setProgressForState(i, false);
    }

    /* renamed from: t */
    private void m5347t() {
        this.f4778W = ValueAnimator.ofInt(new int[]{this.f4780aa, this.f4776T});
        this.f4778W.setDuration((long) f4756V);
        this.f4778W.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f4778W.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = CircularProgressButton.this.f4780aa = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                CircularProgressButton.this.invalidate();
            }
        });
        this.f4778W.start();
    }

    /* renamed from: u */
    private void m5348u() {
        if (this.f4778W != null) {
            this.f4778W.cancel();
            this.f4778W.removeAllUpdateListeners();
            this.f4778W.removeAllListeners();
        }
    }

    public State getState() {
        return this.f4795l;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo16240b();
    }

    /* renamed from: b */
    public void mo16240b() {
        if (this.f4760D != null) {
            this.f4760D.mo16291c();
        }
    }

    public void setStateColorSelector(State state, ColorStateList colorStateList, ColorStateList colorStateList2) {
        if (colorStateList != null && colorStateList2 != null) {
            int i = C13788.f4817a[state.ordinal()];
            if (i != 4) {
                switch (i) {
                    case 1:
                        this.f4788e = colorStateList;
                        this.f4765I = colorStateList2;
                        break;
                    case 2:
                        this.f4789f = colorStateList;
                        this.f4766J = colorStateList2;
                        break;
                }
            } else {
                this.f4787d = colorStateList;
                this.f4764H = colorStateList2;
            }
            this.f4779a = null;
            this.f4790g = null;
            this.f4793j = null;
            this.f4791h = null;
            this.f4792i = null;
            m5329f();
            m5331g();
            m5325d();
            m5327e();
            if (this.f4795l == state) {
                setBackgroundFromState(state);
            }
            m5310a(this.f4795l, true);
            drawableStateChanged();
        }
    }

    private void setBackgroundFromState(State state) {
        switch (state) {
            case COMPLETE:
                this.f4794k = this.f4791h;
                return;
            case ERROR:
                this.f4794k = this.f4792i;
                return;
            case PROGRESS:
                this.f4794k = this.f4793j;
                return;
            case IDLE:
                this.f4794k = this.f4790g;
                return;
            default:
                return;
        }
    }

    private void setState(State state) {
        if (this.f4795l != state) {
            this.f4795l = state;
        }
    }

    public void setStateTextColor(State state, ColorStateList colorStateList) {
        int i = C13788.f4817a[state.ordinal()];
        if (i != 4) {
            switch (i) {
                case 1:
                    this.f4762F = colorStateList;
                    break;
                case 2:
                    this.f4763G = colorStateList;
                    break;
            }
        } else {
            this.f4761E = colorStateList;
        }
        if (this.f4795l == state) {
            invalidate();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f4768L || !this.f4777U) {
            this.f4768L = false;
            m5346s();
        }
        if (!this.f4777U || !isPressed()) {
            if (this.f4794k != null) {
                if ((getScrollX() | getScrollY()) == 0) {
                    switch (this.f4795l) {
                        case COMPLETE:
                            m5307a((Drawable) this.f4791h, canvas);
                            break;
                        case ERROR:
                            m5307a((Drawable) this.f4792i, canvas);
                            break;
                        case PROGRESS:
                            m5307a((Drawable) this.f4793j, canvas);
                            break;
                        case IDLE:
                            m5307a((Drawable) this.f4790g, canvas);
                            break;
                    }
                } else {
                    canvas.translate((float) getScrollX(), (float) getScrollY());
                    this.f4794k.draw(canvas);
                    canvas.translate((float) (-getScrollX()), (float) (-getScrollY()));
                }
            }
            super.draw(canvas);
            return;
        }
        super.draw(canvas);
    }

    /* renamed from: a */
    private void m5307a(Drawable drawable, Canvas canvas) {
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    public void setStateText(State state, String str) {
        int i = C13788.f4817a[state.ordinal()];
        if (i != 4) {
            switch (i) {
                case 1:
                    this.f4797n = str;
                    break;
                case 2:
                    this.f4798o = str;
                    break;
            }
        } else {
            this.f4796m = str;
        }
        if (this.f4795l == state && !this.f4777U) {
            setTextForState(state);
        }
    }

    private void setTextForState(State state) {
        int i = C13788.f4817a[state.ordinal()];
        if (i != 4) {
            switch (i) {
                case 1:
                    setText(this.f4797n);
                    m5319c();
                    return;
                case 2:
                    setText(this.f4798o);
                    m5319c();
                    return;
                default:
                    return;
            }
        } else {
            setText(this.f4796m);
            m5319c();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f4785b = null;
        this.f4786c = null;
        this.f4758B = true;
        this.f4768L = true;
    }

    /* access modifiers changed from: private */
    public Interpolator getInterpolator() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(0.2f, 0.38f, 0.1f, 1.0f);
        }
        return new PathInterpolatorCompat(0.2f, 0.38f, 0.1f, 1.0f);
    }

    public void setProgressIndicatorColor(int i) {
        this.f4801r = i;
        this.f4785b = null;
        this.f4786c = null;
    }

    public void setProgressStrokeWidth(int i) {
        m5331g();
        if (i > 0 && this.f4774R != i) {
            this.f4774R = i;
            if (this.f4785b != null) {
                this.f4785b.setStrokeWidth(i);
            }
            if (this.f4786c != null) {
                this.f4786c.setStrokeWidth(i);
            }
        }
    }

    public void setIndicatorBackgroundColor(int i) {
        if (this.f4802s != i) {
            this.f4802s = i;
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CircularProgressButton.class.getName());
    }
}
