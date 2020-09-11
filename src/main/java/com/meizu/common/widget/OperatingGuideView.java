package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.meizu.common.R;

public class OperatingGuideView extends View {

    /* renamed from: x */
    private static final Interpolator f5782x = PathInterpolatorCompat.create(0.3f, 0.0f, 0.67f, 1.0f);

    /* renamed from: y */
    private static final Interpolator f5783y = PathInterpolatorCompat.create(0.44f, 0.0f, 0.34f, 1.0f);

    /* renamed from: A */
    private float f5784A;

    /* renamed from: B */
    private boolean f5785B;

    /* renamed from: C */
    private int f5786C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public AnimatorSet f5787D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f5788E;

    /* renamed from: a */
    private float f5789a;

    /* renamed from: b */
    private float f5790b;

    /* renamed from: c */
    private Paint f5791c;

    /* renamed from: d */
    private Path f5792d;

    /* renamed from: e */
    private float f5793e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public float f5794f;

    /* renamed from: g */
    private float f5795g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f5796h;

    /* renamed from: i */
    private int f5797i;

    /* renamed from: j */
    private int f5798j;

    /* renamed from: k */
    private float f5799k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public float f5800l;

    /* renamed from: m */
    private float f5801m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public float f5802n;

    /* renamed from: o */
    private float f5803o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public float f5804p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public float f5805q;

    /* renamed from: r */
    private LinearGradient f5806r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public float f5807s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f5808t;

    /* renamed from: u */
    private float f5809u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public float f5810v;

    /* renamed from: w */
    private int f5811w;

    /* renamed from: z */
    private float f5812z;

    public OperatingGuideView(Context context) {
        this(context, (AttributeSet) null);
    }

    public OperatingGuideView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5797i = ViewCompat.MEASURED_SIZE_MASK;
        this.f5798j = ViewCompat.MEASURED_SIZE_MASK;
        this.f5799k = 0.7f;
        this.f5800l = 0.7f;
        this.f5801m = 0.18f;
        this.f5803o = 0.6f;
        this.f5804p = this.f5803o;
        this.f5805q = this.f5803o;
        this.f5811w = -1;
        this.f5786C = 1;
        Resources resources = context.getResources();
        this.f5793e = (float) resources.getDimensionPixelSize(R.dimen.mz_operating_guide_inner_circle_radius);
        this.f5795g = (float) resources.getDimensionPixelSize(R.dimen.mz_operating_guide_outer_circle_radius);
        this.f5809u = (float) resources.getDimensionPixelSize(R.dimen.mz_operating_guide_scroll_distance);
        this.f5812z = ((float) resources.getDimensionPixelSize(R.dimen.mz_operating_guide_stretch_length)) - (this.f5795g * 2.0f);
        this.f5784A = this.f5795g * 3.0f;
        this.f5791c = new Paint(1);
        this.f5791c.setStyle(Paint.Style.FILL);
        this.f5792d = new Path();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m5920a(canvas);
        if (this.f5811w == 5 || this.f5811w == 6) {
            int save = canvas.save();
            canvas.rotate(180.0f, this.f5789a / 2.0f, this.f5790b / 2.0f);
            m5920a(canvas);
            canvas.restoreToCount(save);
            return;
        }
        int i = 1;
        if (this.f5786C <= 1) {
            return;
        }
        if (this.f5811w == 1 || this.f5811w == 2) {
            while (i < this.f5786C) {
                int save2 = canvas.save();
                canvas.translate(0.0f, this.f5784A * ((float) i));
                m5920a(canvas);
                canvas.restoreToCount(save2);
                i++;
            }
        } else if (this.f5811w == 3 || this.f5811w == 4) {
            while (i < this.f5786C) {
                int save3 = canvas.save();
                canvas.translate(this.f5784A * ((float) i), 0.0f);
                m5920a(canvas);
                canvas.restoreToCount(save3);
                i++;
            }
        }
    }

    /* renamed from: a */
    private void m5920a(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        int i;
        int i2;
        Canvas canvas2 = canvas;
        int save = canvas.save();
        boolean z = true;
        if (this.f5811w == 1) {
            canvas2.translate(this.f5789a - ((this.f5795g * 2.0f) * 1.2f), 0.0f);
            canvas2.rotate(180.0f, this.f5795g * 1.2f, this.f5795g * 1.2f);
        } else if (this.f5811w == 4) {
            canvas2.rotate(90.0f, this.f5795g * 1.2f, this.f5795g * 1.2f);
        } else if (this.f5811w == 3) {
            canvas2.rotate(270.0f, this.f5795g * 1.2f, this.f5795g * 1.2f);
            canvas2.translate(-(this.f5790b - ((this.f5795g * 2.0f) * 1.2f)), 0.0f);
        } else if (this.f5811w == 5) {
            canvas2.translate(this.f5789a - ((this.f5795g * 2.0f) * 1.2f), 0.0f);
            canvas2.rotate(135.0f, this.f5795g * 1.2f, this.f5795g * 1.2f);
        } else if (this.f5811w == 6) {
            float sin = (float) (Math.sin(0.7853981633974483d) * ((double) this.f5809u));
            canvas2.translate(((this.f5789a - (this.f5795g * 2.0f)) - sin) - (this.f5795g * 0.2f), sin);
            canvas2.rotate(-45.0f, this.f5795g, this.f5795g);
        }
        this.f5791c.setColor(this.f5797i);
        this.f5791c.setAlpha((int) (this.f5800l * 255.0f));
        this.f5791c.setStyle(Paint.Style.FILL);
        canvas2.drawCircle(this.f5807s, this.f5808t, this.f5794f, this.f5791c);
        this.f5791c.setStyle(Paint.Style.STROKE);
        this.f5791c.setStrokeWidth(this.f5796h * 2.0f);
        this.f5791c.setStrokeCap(Paint.Cap.ROUND);
        if (this.f5811w == 0) {
            z = false;
        }
        if (z) {
            f4 = this.f5807s;
            f3 = this.f5808t;
            f2 = f4 - this.f5810v;
            f = this.f5808t;
            if (this.f5810v == 0.0f) {
                i2 = (((int) ((((this.f5803o / this.f5801m) * this.f5802n) * 255.0f) + 0.5f)) << 24) | this.f5798j;
                i = i2;
            } else {
                int i3 = (((int) ((this.f5804p * 255.0f) + 0.5f)) << 24) | this.f5798j;
                i2 = (((int) ((this.f5805q * 255.0f) + 0.5f)) << 24) | this.f5798j;
                i = i3;
            }
            this.f5806r = new LinearGradient(Math.max(0.0f, this.f5796h + f4), f3, f2 - this.f5796h, f3, i2, i, Shader.TileMode.CLAMP);
            this.f5791c.setShader(this.f5806r);
        } else {
            f4 = this.f5807s;
            f3 = this.f5808t;
            this.f5791c.setColor(this.f5798j);
            this.f5791c.setAlpha((int) (this.f5802n * 255.0f));
            f2 = f4;
            f = f3;
        }
        this.f5792d.reset();
        this.f5792d.moveTo(f4, f3);
        this.f5792d.lineTo(f2, f);
        canvas2.drawPath(this.f5792d, this.f5791c);
        this.f5791c.setShader((Shader) null);
        canvas2.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m5936h();
        setMeasuredDimension((int) this.f5789a, (int) this.f5790b);
    }

    /* renamed from: c */
    private AnimatorSet m5925c() {
        m5938i();
        AnimatorSet d = m5928d();
        AnimatorSet g = m5934g();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f5801m, 0.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.f5802n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ofFloat.setInterpolator(f5782x);
        ofFloat.setDuration(150);
        g.playTogether(new Animator[]{ofFloat});
        g.setStartDelay(500);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{d, g});
        return animatorSet;
    }

    /* renamed from: d */
    private AnimatorSet m5928d() {
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{((this.f5793e * 2.0f) * 1.2f) / 2.0f, this.f5793e});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.f5794f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat.setDuration(200);
        ofFloat.setInterpolator(f5782x);
        AnimatorSet.Builder play = animatorSet.play(ofFloat);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, this.f5799k});
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.f5800l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ofFloat2.setInterpolator(f5782x);
        ofFloat2.setDuration(200);
        play.with(ofFloat2);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, this.f5795g});
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.f5796h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ofFloat3.setInterpolator(f5782x);
        ofFloat3.setDuration(200);
        play.with(ofFloat3);
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{0.0f, this.f5801m});
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.f5802n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ofFloat4.setInterpolator(f5782x);
        ofFloat4.setDuration(200);
        play.with(ofFloat4);
        return animatorSet;
    }

    /* renamed from: e */
    private AnimatorSet m5930e() {
        m5938i();
        AnimatorSet d = m5928d();
        AnimatorSet f = m5932f();
        AnimatorSet g = m5934g();
        if (this.f5785B) {
            f.setStartDelay(500);
            g.setStartDelay(1000);
        } else {
            f.setStartDelay(100);
            g.setStartDelay(600);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{d, f, g});
        return animatorSet;
    }

    /* renamed from: f */
    private AnimatorSet m5932f() {
        AnimatorSet animatorSet = new AnimatorSet();
        float f = this.f5795g * 1.2f;
        float f2 = this.f5807s;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f2, this.f5809u + f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.f5807s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat.setDuration(800);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{f, f});
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.f5808t = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat2.setDuration(800);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, this.f5812z});
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.f5810v = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat3.setDuration(500);
        ofFloat3.setStartDelay(100);
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{this.f5812z, 0.0f});
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.f5810v = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat4.setDuration(200);
        ofFloat4.setStartDelay(500);
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(new float[]{this.f5803o, 0.0f});
        ofFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.f5804p = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat5.setDuration(800);
        ofFloat5.setInterpolator(f5782x);
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(new float[]{this.f5803o, 0.0f});
        ofFloat6.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.f5805q = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat6.setDuration(150);
        ofFloat6.setStartDelay(800);
        ofFloat6.setInterpolator(f5782x);
        animatorSet.setInterpolator(f5783y);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat3, ofFloat5, ofFloat4, ofFloat6});
        return animatorSet;
    }

    /* renamed from: g */
    private AnimatorSet m5934g() {
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f5793e, ((this.f5793e * 2.0f) * 1.2f) / 2.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.f5794f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OperatingGuideView.this.invalidate();
            }
        });
        ofFloat.setDuration(200);
        ofFloat.setInterpolator(f5782x);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{this.f5799k, 0.0f});
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.f5800l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ofFloat2.setInterpolator(f5782x);
        ofFloat2.setDuration(200);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{this.f5795g, ((this.f5795g * 2.0f) * 1.2f) / 2.0f});
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = OperatingGuideView.this.f5796h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ofFloat3.setInterpolator(f5782x);
        ofFloat3.setDuration(200);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        return animatorSet;
    }

    /* renamed from: h */
    private void m5936h() {
        switch (this.f5811w) {
            case 0:
                this.f5789a = this.f5795g * 2.0f * 1.2f;
                this.f5790b = this.f5789a;
                break;
            case 1:
            case 2:
                this.f5789a = this.f5809u + this.f5795g + (this.f5795g * 1.2f);
                this.f5790b = (this.f5795g * 2.0f * 1.2f) + (((float) (this.f5786C - 1)) * this.f5784A);
                break;
            case 3:
            case 4:
                this.f5790b = this.f5809u + this.f5795g + (this.f5795g * 1.2f);
                this.f5789a = (this.f5795g * 2.0f * 1.2f) + (((float) (this.f5786C - 1)) * this.f5784A);
                break;
            case 5:
                this.f5789a = ((float) (Math.sin(0.7853981633974483d) * ((double) ((this.f5809u * 2.0f) + this.f5784A)))) + (this.f5795g * 2.0f);
                this.f5790b = this.f5789a;
                break;
            case 6:
                this.f5789a = ((float) (Math.sin(0.7853981633974483d) * ((double) ((this.f5809u * 2.0f) + this.f5784A)))) + (this.f5795g * 2.0f * 1.2f);
                this.f5790b = this.f5789a;
                break;
            default:
                throw new IllegalArgumentException("incorrect operation type!");
        }
        this.f5810v = 0.0f;
        this.f5804p = this.f5803o;
        this.f5805q = this.f5803o;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m5938i() {
        if (this.f5811w != 0) {
            this.f5807s = this.f5795g;
            this.f5808t = this.f5795g * 1.2f;
        } else {
            this.f5807s = this.f5795g * 1.2f;
            this.f5808t = this.f5795g * 1.2f;
        }
        this.f5810v = 0.0f;
        this.f5804p = this.f5803o;
        this.f5805q = this.f5803o;
        this.f5796h = 0.0f;
        this.f5794f = 0.0f;
    }

    public void setOperationType(int i) {
        if (this.f5811w == -1) {
            this.f5811w = i;
            return;
        }
        throw new IllegalStateException("can't change the operation type");
    }

    public void setDrag(boolean z) {
        this.f5785B = z;
    }

    public void setGesturePoints(int i) {
        this.f5786C = i;
    }

    /* renamed from: a */
    public void mo16995a() {
        if (this.f5787D == null) {
            switch (this.f5811w) {
                case 0:
                    this.f5787D = m5925c();
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    this.f5787D = m5930e();
                    break;
                default:
                    throw new IllegalArgumentException("incorrect operation type!");
            }
        }
        this.f5787D.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                OperatingGuideView.this.m5938i();
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!OperatingGuideView.this.f5788E) {
                    OperatingGuideView.this.postDelayed(new Runnable() {
                        public void run() {
                            if (!OperatingGuideView.this.f5788E) {
                                OperatingGuideView.this.f5787D.start();
                            }
                        }
                    }, 100);
                }
            }
        });
        this.f5788E = false;
        this.f5787D.start();
    }

    /* renamed from: b */
    public void mo16996b() {
        this.f5788E = true;
        if (this.f5787D != null) {
            this.f5787D.cancel();
            this.f5787D.end();
        }
    }
}
