package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import com.meizu.common.R;

public class ApplyingAnimationView extends View {

    /* renamed from: A */
    private boolean f4648A;

    /* renamed from: B */
    private float f4649B;

    /* renamed from: C */
    private float f4650C;

    /* renamed from: D */
    private float f4651D;

    /* renamed from: E */
    private float f4652E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public AnimatorSet f4653F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f4654G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f4655H;

    /* renamed from: I */
    private float f4656I;

    /* renamed from: a */
    private Paint f4657a;

    /* renamed from: b */
    private Paint f4658b;

    /* renamed from: c */
    private Paint f4659c;

    /* renamed from: d */
    private Paint f4660d;

    /* renamed from: e */
    private int f4661e;

    /* renamed from: f */
    private int f4662f;

    /* renamed from: g */
    private int f4663g;

    /* renamed from: h */
    private int f4664h;

    /* renamed from: i */
    private float f4665i;

    /* renamed from: j */
    private float f4666j;

    /* renamed from: k */
    private float f4667k;

    /* renamed from: l */
    private float f4668l;

    /* renamed from: m */
    private float f4669m;

    /* renamed from: n */
    private float f4670n;

    /* renamed from: o */
    private float f4671o;

    /* renamed from: p */
    private float f4672p;

    /* renamed from: q */
    private float f4673q;

    /* renamed from: r */
    private float f4674r;

    /* renamed from: s */
    private float f4675s;

    /* renamed from: t */
    private float f4676t;

    /* renamed from: u */
    private final String[] f4677u;

    /* renamed from: v */
    private final String[] f4678v;

    /* renamed from: w */
    private final String[] f4679w;

    /* renamed from: x */
    private boolean f4680x;

    /* renamed from: y */
    private boolean f4681y;

    /* renamed from: z */
    private boolean f4682z;

    public ApplyingAnimationView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public ApplyingAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ApplyingAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4661e = 255;
        this.f4662f = 255;
        this.f4663g = 255;
        this.f4664h = 255;
        this.f4677u = new String[]{"crPosition", "cbPosition", "cgPosition", "coPosition"};
        this.f4678v = new String[]{"rAlpha", "bAlpha", "gAlpha", "oAlpha"};
        this.f4679w = new String[]{"crRadius", "cbRadius", "cgRadius", "coRadius"};
        this.f4680x = false;
        this.f4681y = false;
        this.f4682z = false;
        this.f4648A = false;
        this.f4654G = false;
        this.f4655H = false;
        this.f4656I = 1.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ApplyingAnimationView);
        this.f4656I = obtainStyledAttributes.getFloat(R.styleable.ApplyingAnimationView_mcApplyingAnimationScale, this.f4656I);
        obtainStyledAttributes.recycle();
        m5245b(context);
    }

    /* renamed from: b */
    private void m5245b(Context context) {
        m5249c(context);
        this.f4657a = m5239a();
        this.f4657a.setColor(-1357238);
        this.f4658b = m5239a();
        this.f4658b.setColor(-16737828);
        this.f4659c = m5239a();
        this.f4659c.setColor(110475);
        this.f4660d = m5239a();
        this.f4660d.setColor(-620493);
    }

    /* renamed from: c */
    private void m5249c(Context context) {
        float a = mo16158a(context) * this.f4656I;
        this.f4665i = 6.0f * a;
        this.f4666j = this.f4665i * 0.5f;
        this.f4649B = 0.0f;
        this.f4650C = 12.3f * a;
        this.f4651D = 24.0f * a;
        this.f4652E = a * 11.0f;
        this.f4667k = getX() + this.f4666j + (this.f4656I * 2.0f);
        this.f4668l = getY();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f4669m < this.f4666j) {
            canvas.drawCircle(this.f4667k + this.f4673q, this.f4668l + this.f4665i, this.f4669m, this.f4657a);
            this.f4680x = true;
        }
        if (this.f4670n < this.f4666j) {
            canvas.drawCircle(this.f4667k + this.f4674r, this.f4668l + this.f4665i, this.f4670n, this.f4658b);
            this.f4681y = true;
        }
        if (this.f4671o < this.f4666j) {
            canvas.drawCircle(this.f4667k + this.f4675s, this.f4668l + this.f4665i, this.f4671o, this.f4659c);
            this.f4682z = true;
        }
        if (this.f4672p < this.f4666j) {
            canvas.drawCircle(this.f4667k + this.f4676t, this.f4668l + this.f4665i, this.f4672p, this.f4660d);
            this.f4648A = true;
        }
        if (!this.f4680x) {
            canvas.drawCircle(this.f4667k + this.f4673q, this.f4668l + this.f4665i, this.f4669m, this.f4657a);
        }
        if (!this.f4681y) {
            canvas.drawCircle(this.f4667k + this.f4674r, this.f4668l + this.f4665i, this.f4670n, this.f4658b);
        }
        if (!this.f4682z) {
            canvas.drawCircle(this.f4667k + this.f4675s, this.f4668l + this.f4665i, this.f4671o, this.f4659c);
        }
        if (!this.f4648A) {
            canvas.drawCircle(this.f4667k + this.f4676t, this.f4668l + this.f4665i, this.f4672p, this.f4660d);
        }
        this.f4680x = false;
        this.f4681y = false;
        this.f4682z = false;
        this.f4648A = false;
    }

    /* renamed from: a */
    private Paint m5239a() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    /* renamed from: b */
    private void m5244b() {
        if (!this.f4655H) {
            Animator a = m5238a(0);
            Animator a2 = m5238a(1);
            Animator a3 = m5238a(2);
            Animator a4 = m5238a(3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{a, a2, a3, a4});
            Animator b = m5242b(0);
            Animator b2 = m5242b(1);
            Animator b3 = m5242b(2);
            Animator b4 = m5242b(3);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(new Animator[]{b, b2, b3, b4});
            Animator c = m5247c(0);
            Animator c2 = m5247c(1);
            Animator c3 = m5247c(2);
            Animator c4 = m5247c(3);
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(new Animator[]{c, c2, c3, c4});
            this.f4653F = new AnimatorSet();
            this.f4653F.playTogether(new Animator[]{animatorSet, animatorSet2, animatorSet3});
            this.f4653F.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (Settings.Global.getFloat(ApplyingAnimationView.this.getContext().getContentResolver(), "animator_duration_scale", 1.0f) == 0.0f) {
                        return;
                    }
                    if (!ApplyingAnimationView.this.f4654G && ApplyingAnimationView.this.f4653F != null) {
                        ApplyingAnimationView.this.f4653F.start();
                    } else if (ApplyingAnimationView.this.f4653F != null) {
                        boolean unused = ApplyingAnimationView.this.f4654G = false;
                        boolean unused2 = ApplyingAnimationView.this.f4655H = false;
                    }
                }
            });
            this.f4655H = true;
            this.f4653F.start();
        }
    }

    /* renamed from: a */
    private Animator m5238a(int i) {
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[4];
        objectAnimatorArr[0] = ObjectAnimator.ofFloat(this, this.f4677u[i], new float[]{0.0f, this.f4650C});
        objectAnimatorArr[0].setDuration(704);
        objectAnimatorArr[0].setInterpolator(new PathInterpolator(0.21f, 0.0f, 0.35f, 0.471f));
        objectAnimatorArr[1] = ObjectAnimator.ofFloat(this, this.f4677u[i], new float[]{this.f4650C, this.f4651D});
        objectAnimatorArr[1].setDuration(704);
        objectAnimatorArr[1].setInterpolator(new PathInterpolator(0.24f, 0.341f, 0.41f, 1.0f));
        objectAnimatorArr[2] = ObjectAnimator.ofFloat(this, this.f4677u[i], new float[]{this.f4651D, this.f4652E});
        objectAnimatorArr[2].setDuration(672);
        objectAnimatorArr[2].setInterpolator(new PathInterpolator(0.26f, 0.0f, 0.87f, 0.758f));
        objectAnimatorArr[3] = ObjectAnimator.ofFloat(this, this.f4677u[i], new float[]{this.f4652E, this.f4649B});
        objectAnimatorArr[3].setDuration(736);
        objectAnimatorArr[3].setInterpolator(new PathInterpolator(0.18f, 0.434f, 0.59f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{objectAnimatorArr[i % 4], objectAnimatorArr[(i + 1) % 4], objectAnimatorArr[(i + 2) % 4], objectAnimatorArr[(i + 3) % 4]});
        return animatorSet;
    }

    /* renamed from: b */
    private Animator m5242b(int i) {
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[4];
        objectAnimatorArr[0] = ObjectAnimator.ofFloat(this, this.f4679w[i], new float[]{this.f4666j, this.f4665i});
        objectAnimatorArr[0].setInterpolator(new PathInterpolator(0.24f, 0.209f, 0.25f, 1.0f));
        objectAnimatorArr[0].setDuration(720);
        objectAnimatorArr[1] = ObjectAnimator.ofFloat(this, this.f4679w[i], new float[]{this.f4665i, this.f4666j});
        objectAnimatorArr[1].setInterpolator(new PathInterpolator(0.29f, 0.0f, 0.32f, 0.631f));
        objectAnimatorArr[1].setDuration(704);
        objectAnimatorArr[2] = ObjectAnimator.ofFloat(this, this.f4679w[i], new float[]{this.f4666j, this.f4665i * 0.25f});
        objectAnimatorArr[2].setInterpolator(new PathInterpolator(0.2f, 0.337f, 0.17f, 1.0f));
        objectAnimatorArr[2].setDuration(704);
        objectAnimatorArr[3] = ObjectAnimator.ofFloat(this, this.f4679w[i], new float[]{this.f4665i * 0.25f, this.f4666j});
        objectAnimatorArr[3].setInterpolator(new PathInterpolator(0.19f, 0.0f, 0.37f, 0.31f));
        objectAnimatorArr[3].setDuration(688);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{objectAnimatorArr[i % 4], objectAnimatorArr[(i + 1) % 4], objectAnimatorArr[(i + 2) % 4], objectAnimatorArr[(i + 3) % 4]});
        return animatorSet;
    }

    /* renamed from: c */
    private Animator m5247c(int i) {
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[4];
        objectAnimatorArr[0] = ObjectAnimator.ofInt(this, this.f4678v[i], new int[]{255, 255});
        objectAnimatorArr[0].setDuration(720);
        objectAnimatorArr[1] = ObjectAnimator.ofInt(this, this.f4678v[i], new int[]{255, 255});
        objectAnimatorArr[1].setDuration(704);
        objectAnimatorArr[2] = ObjectAnimator.ofInt(this, this.f4678v[i], new int[]{255, 0, 0, 0});
        objectAnimatorArr[2].setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f));
        objectAnimatorArr[2].setDuration(704);
        objectAnimatorArr[3] = ObjectAnimator.ofInt(this, this.f4678v[i], new int[]{0, 255, 255});
        objectAnimatorArr[3].setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f));
        objectAnimatorArr[3].setDuration(688);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{objectAnimatorArr[i % 4], objectAnimatorArr[(i + 1) % 4], objectAnimatorArr[(i + 2) % 4], objectAnimatorArr[(i + 3) % 4]});
        return animatorSet;
    }

    private void setRAlpha(int i) {
        this.f4661e = Math.round((float) i);
        this.f4657a.setAlpha(this.f4661e);
    }

    private void setBAlpha(int i) {
        this.f4662f = Math.round((float) i);
        this.f4658b.setAlpha(this.f4662f);
    }

    private void setGAlpha(int i) {
        this.f4663g = Math.round((float) i);
        this.f4659c.setAlpha(this.f4663g);
    }

    private void setOAlpha(int i) {
        this.f4664h = Math.round((float) i);
        this.f4660d.setAlpha(this.f4664h);
    }

    private void setCrRadius(float f) {
        this.f4669m = f;
    }

    private void setCbRadius(float f) {
        this.f4670n = f;
    }

    private void setCgRadius(float f) {
        this.f4671o = f;
    }

    private void setCoRadius(float f) {
        this.f4672p = f;
    }

    private void setCrPosition(float f) {
        this.f4673q = f;
    }

    private void setCbPosition(float f) {
        this.f4674r = f;
    }

    private void setCgPosition(float f) {
        this.f4675s = f;
    }

    private void setCoPosition(float f) {
        this.f4676t = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            m5248c();
        } else if (isShown()) {
            m5244b();
            this.f4654G = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            m5248c();
        } else if (isShown()) {
            m5244b();
            this.f4654G = false;
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            m5244b();
            this.f4654G = false;
        } else if (i == 4 || i == 8) {
            m5248c();
        }
    }

    /* renamed from: c */
    private void m5248c() {
        if (this.f4653F != null) {
            this.f4653F.cancel();
            this.f4654G = true;
            this.f4655H = false;
            this.f4653F = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int round = Math.round((this.f4651D - this.f4649B) + this.f4665i + (this.f4656I * 4.0f) + 0.5f);
        int round2 = Math.round((this.f4665i * 2.0f) + 0.5f);
        setMeasuredDimension(resolveSizeAndState(round + getPaddingLeft() + getPaddingRight(), i, 0), resolveSizeAndState(round2 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    /* renamed from: a */
    public float mo16158a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ApplyingAnimationView.class.getName());
    }
}
