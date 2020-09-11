package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.meizu.common.R;
import com.meizu.common.p060a.PathInterpolatorCompat;

public class LoadingAnimationView extends View {

    /* renamed from: A */
    private float f5559A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public AnimatorSet f5560B;

    /* renamed from: C */
    private volatile boolean f5561C;

    /* renamed from: D */
    private float f5562D;

    /* renamed from: E */
    private Animator.AnimatorListener f5563E;

    /* renamed from: a */
    private Paint f5564a;

    /* renamed from: b */
    private Paint f5565b;

    /* renamed from: c */
    private Paint f5566c;

    /* renamed from: d */
    private int f5567d;

    /* renamed from: e */
    private int f5568e;

    /* renamed from: f */
    private int f5569f;

    /* renamed from: g */
    private float f5570g;

    /* renamed from: h */
    private float f5571h;

    /* renamed from: i */
    private float f5572i;

    /* renamed from: j */
    private float f5573j;

    /* renamed from: k */
    private float f5574k;

    /* renamed from: l */
    private float f5575l;

    /* renamed from: m */
    private float f5576m;

    /* renamed from: n */
    private float f5577n;

    /* renamed from: o */
    private float f5578o;

    /* renamed from: p */
    private float f5579p;

    /* renamed from: q */
    private final String[] f5580q;

    /* renamed from: r */
    private final String[] f5581r;

    /* renamed from: s */
    private final String[] f5582s;

    /* renamed from: t */
    private boolean f5583t;

    /* renamed from: u */
    private boolean f5584u;

    /* renamed from: v */
    private boolean f5585v;

    /* renamed from: w */
    private float f5586w;

    /* renamed from: x */
    private float f5587x;

    /* renamed from: y */
    private float f5588y;

    /* renamed from: z */
    private float f5589z;

    public LoadingAnimationView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public LoadingAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5567d = 255;
        this.f5568e = 255;
        this.f5569f = 255;
        this.f5580q = new String[]{"crPosition", "cbPosition", "cgPosition"};
        this.f5581r = new String[]{"rAlpha", "bAlpha", "gAlpha"};
        this.f5582s = new String[]{"crRadius", "cbRadius", "cgRadius"};
        this.f5583t = false;
        this.f5584u = false;
        this.f5585v = false;
        this.f5561C = false;
        this.f5562D = 1.0f;
        this.f5563E = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (Settings.Global.getFloat(LoadingAnimationView.this.getContext().getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f) {
                    LoadingAnimationView.this.post(new Runnable() {
                        @TargetApi(17)
                        public void run() {
                            LoadingAnimationView.this.f5560B.start();
                        }
                    });
                    return;
                }
                Log.d("LoadingAnimationView", "onAnimationEnd, animatorDurationScale == 0, stopAnimator");
                LoadingAnimationView.this.mo16881b();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ApplyingAnimationView);
        this.f5562D = obtainStyledAttributes.getFloat(R.styleable.ApplyingAnimationView_mcApplyingAnimationScale, this.f5562D);
        obtainStyledAttributes.recycle();
        m5855b(context);
        this.f5560B = m5860e();
    }

    /* renamed from: b */
    private void m5855b(Context context) {
        m5857c(context);
        this.f5564a = m5858d();
        this.f5564a.setColor(-11687857);
        this.f5565b = m5858d();
        this.f5565b.setColor(-11699757);
        this.f5566c = m5858d();
        this.f5566c.setColor(14576188);
    }

    /* renamed from: c */
    private void m5857c(Context context) {
        float a = mo16879a(context) * this.f5562D;
        this.f5570g = 7.0f * a;
        this.f5571h = this.f5570g * 0.5f;
        this.f5586w = 0.0f;
        this.f5587x = 15.0f * a;
        this.f5588y = 30.0f * a;
        this.f5589z = 27.6f * a;
        this.f5559A = a * 2.6f;
        this.f5572i = getX() + this.f5571h + (this.f5562D * 2.0f);
        this.f5573j = getY();
    }

    /* renamed from: d */
    private Paint m5858d() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f5574k < this.f5571h) {
            canvas.drawCircle(this.f5572i + this.f5577n, this.f5573j + this.f5570g, this.f5574k, this.f5564a);
            this.f5583t = true;
        }
        if (this.f5575l < this.f5571h) {
            canvas.drawCircle(this.f5572i + this.f5578o, this.f5573j + this.f5570g, this.f5575l, this.f5565b);
            this.f5584u = true;
        }
        if (this.f5576m < this.f5571h) {
            canvas.drawCircle(this.f5572i + this.f5579p, this.f5573j + this.f5570g, this.f5576m, this.f5566c);
            this.f5585v = true;
        }
        if (!this.f5583t) {
            canvas.drawCircle(this.f5572i + this.f5577n, this.f5573j + this.f5570g, this.f5574k, this.f5564a);
        }
        if (!this.f5584u) {
            canvas.drawCircle(this.f5572i + this.f5578o, this.f5573j + this.f5570g, this.f5575l, this.f5565b);
        }
        if (!this.f5585v) {
            canvas.drawCircle(this.f5572i + this.f5579p, this.f5573j + this.f5570g, this.f5576m, this.f5566c);
        }
        this.f5583t = false;
        this.f5584u = false;
        this.f5585v = false;
    }

    @UiThread
    /* renamed from: a */
    public void mo16880a() {
        if (!this.f5561C) {
            this.f5561C = true;
            this.f5560B.addListener(this.f5563E);
            this.f5560B.start();
            Log.d("LoadingAnimationView", "startAnimator");
        }
    }

    @UiThread
    /* renamed from: b */
    public void mo16881b() {
        if (this.f5561C) {
            this.f5561C = false;
            this.f5560B.removeAllListeners();
            this.f5560B.cancel();
            mo16882c();
            Log.d("LoadingAnimationView", "stopAnimator");
        }
    }

    /* renamed from: e */
    private AnimatorSet m5860e() {
        Animator a = m5852a(0);
        Animator a2 = m5852a(1);
        Animator a3 = m5852a(2);
        Animator b = m5854b(0);
        Animator b2 = m5854b(1);
        Animator b3 = m5854b(2);
        Animator c = m5856c(0);
        Animator c2 = m5856c(1);
        Animator c3 = m5856c(2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{a, a2, a3, b, b2, b3, c, c2, c3});
        return animatorSet;
    }

    /* renamed from: a */
    private Animator m5852a(int i) {
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[5];
        objectAnimatorArr[0] = ObjectAnimator.ofFloat(this, this.f5580q[i], new float[]{0.0f, this.f5587x});
        objectAnimatorArr[0].setDuration(704);
        objectAnimatorArr[0].setInterpolator(new PathInterpolatorCompat(0.21f, 0.0f, 0.35f, 0.471f));
        objectAnimatorArr[1] = ObjectAnimator.ofFloat(this, this.f5580q[i], new float[]{this.f5587x, this.f5588y});
        objectAnimatorArr[1].setDuration(704);
        objectAnimatorArr[1].setInterpolator(new PathInterpolatorCompat(0.24f, 0.341f, 0.41f, 1.0f));
        objectAnimatorArr[2] = ObjectAnimator.ofFloat(this, this.f5580q[i], new float[]{this.f5588y, this.f5589z});
        objectAnimatorArr[2].setDuration(224);
        objectAnimatorArr[2].setInterpolator(new PathInterpolatorCompat(0.25f, 0.0f, 0.61f, 0.48f));
        objectAnimatorArr[3] = ObjectAnimator.ofFloat(this, this.f5580q[i], new float[]{this.f5589z, this.f5559A});
        objectAnimatorArr[3].setDuration(160);
        objectAnimatorArr[3].setInterpolator(new PathInterpolatorCompat(0.4f, 0.07f, 0.66f, 0.965f));
        objectAnimatorArr[4] = ObjectAnimator.ofFloat(this, this.f5580q[i], new float[]{this.f5559A, this.f5586w});
        objectAnimatorArr[4].setDuration(320);
        objectAnimatorArr[4].setInterpolator(new PathInterpolatorCompat(0.31f, 0.62f, 0.66f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{objectAnimatorArr[i % 5], objectAnimatorArr[(i + 1) % 5], objectAnimatorArr[(i + 2) % 5], objectAnimatorArr[(i + 3) % 5], objectAnimatorArr[(i + 4) % 5]});
        return animatorSet;
    }

    /* renamed from: b */
    private Animator m5854b(int i) {
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[5];
        objectAnimatorArr[0] = ObjectAnimator.ofFloat(this, this.f5582s[i], new float[]{this.f5571h, this.f5570g});
        objectAnimatorArr[0].setInterpolator(new PathInterpolatorCompat(0.24f, 0.209f, 0.25f, 1.0f));
        objectAnimatorArr[0].setDuration(704);
        objectAnimatorArr[1] = ObjectAnimator.ofFloat(this, this.f5582s[i], new float[]{this.f5570g, this.f5571h});
        objectAnimatorArr[1].setInterpolator(new PathInterpolatorCompat(0.29f, 0.0f, 0.32f, 0.631f));
        objectAnimatorArr[1].setDuration(704);
        objectAnimatorArr[2] = ObjectAnimator.ofFloat(this, this.f5582s[i], new float[]{this.f5571h, this.f5570g * 0.3f});
        objectAnimatorArr[2].setInterpolator(new PathInterpolatorCompat(0.36f, 0.27f, 0.5f, 0.675f));
        objectAnimatorArr[2].setDuration(224);
        objectAnimatorArr[3] = ObjectAnimator.ofFloat(this, this.f5582s[i], new float[]{this.f5570g * 0.25f, this.f5570g * 0.34f});
        objectAnimatorArr[3].setInterpolator(new PathInterpolatorCompat(0.18f, 0.45f, 0.66f, 0.3f));
        objectAnimatorArr[3].setDuration(160);
        objectAnimatorArr[4] = ObjectAnimator.ofFloat(this, this.f5582s[i], new float[]{this.f5570g * 0.34f, this.f5571h});
        objectAnimatorArr[4].setInterpolator(new PathInterpolatorCompat(0.26f, 0.265f, 0.59f, 0.61f));
        objectAnimatorArr[4].setDuration(320);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{objectAnimatorArr[i % 5], objectAnimatorArr[(i + 1) % 5], objectAnimatorArr[(i + 2) % 5], objectAnimatorArr[(i + 3) % 5], objectAnimatorArr[(i + 4) % 5]});
        return animatorSet;
    }

    /* renamed from: c */
    private Animator m5856c(int i) {
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[5];
        objectAnimatorArr[0] = ObjectAnimator.ofInt(this, this.f5581r[i], new int[]{255, 255});
        objectAnimatorArr[0].setDuration(704);
        objectAnimatorArr[1] = ObjectAnimator.ofInt(this, this.f5581r[i], new int[]{255, 255});
        objectAnimatorArr[1].setDuration(704);
        objectAnimatorArr[2] = ObjectAnimator.ofInt(this, this.f5581r[i], new int[]{255, 255});
        objectAnimatorArr[2].setDuration(224);
        objectAnimatorArr[3] = ObjectAnimator.ofInt(this, this.f5581r[i], new int[]{0, 0});
        objectAnimatorArr[3].setDuration(160);
        objectAnimatorArr[4] = ObjectAnimator.ofInt(this, this.f5581r[i], new int[]{255, 255});
        objectAnimatorArr[4].setDuration(320);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{objectAnimatorArr[i % 5], objectAnimatorArr[(i + 1) % 5], objectAnimatorArr[(i + 2) % 5], objectAnimatorArr[(i + 3) % 5], objectAnimatorArr[(i + 4) % 5]});
        return animatorSet;
    }

    private void setRAlpha(int i) {
        this.f5567d = Math.round((float) i);
        this.f5564a.setAlpha(this.f5567d);
    }

    private void setBAlpha(int i) {
        this.f5568e = Math.round((float) i);
        this.f5565b.setAlpha(this.f5568e);
    }

    private void setGAlpha(int i) {
        this.f5569f = Math.round((float) i);
        this.f5566c.setAlpha(this.f5569f);
    }

    private void setCrRadius(float f) {
        this.f5574k = f;
    }

    private void setCbRadius(float f) {
        this.f5575l = f;
    }

    private void setCgRadius(float f) {
        this.f5576m = f;
    }

    private void setCrPosition(float f) {
        this.f5577n = f;
    }

    private void setCbPosition(float f) {
        this.f5578o = f;
    }

    private void setCgPosition(float f) {
        this.f5579p = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        Log.d("LoadingAnimationView", "onVisibilityChanged=" + i + ", isShown=" + isShown() + ", getVisibility=" + getVisibility());
        m5859d(i);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        Log.d("LoadingAnimationView", "onWindowVisibilityChanged:" + i + ", isShown=" + isShown());
        m5859d(i);
    }

    /* renamed from: d */
    private void m5859d(int i) {
        if (i != 0 || !isShown()) {
            mo16881b();
        } else {
            mo16880a();
        }
    }

    /* renamed from: c */
    public void mo16882c() {
        this.f5577n = 0.0f;
        this.f5579p = 0.0f;
        this.f5578o = 0.0f;
        this.f5574k = 0.0f;
        this.f5575l = 0.0f;
        this.f5576m = 0.0f;
        this.f5567d = 255;
        this.f5568e = 255;
        this.f5569f = 255;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int round = Math.round((this.f5588y - this.f5586w) + this.f5570g + (this.f5562D * 4.0f) + 0.5f);
        int round2 = Math.round((this.f5570g * 2.0f) + 0.5f);
        setMeasuredDimension(resolveSizeAndState(round + getPaddingLeft() + getPaddingRight(), i, 0), resolveSizeAndState(round2 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    /* renamed from: a */
    public float mo16879a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ApplyingAnimationView.class.getName());
    }
}
