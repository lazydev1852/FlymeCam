package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.meizu.common.R;
import com.meizu.common.p060a.PathInterpolatorCompat;

public class SwimmingAnimationView extends View {

    /* renamed from: a */
    private Paint f6209a;

    /* renamed from: b */
    private int f6210b;

    /* renamed from: c */
    private int f6211c;

    /* renamed from: d */
    private int f6212d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public float f6213e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public float f6214f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f6215g;

    /* renamed from: h */
    private Context f6216h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Animator f6217i;

    /* renamed from: j */
    private volatile boolean f6218j;

    /* renamed from: k */
    private PathInterpolatorCompat f6219k;

    /* renamed from: l */
    private PathInterpolatorCompat f6220l;

    /* renamed from: m */
    private C1537b f6221m;

    /* renamed from: n */
    private Animator.AnimatorListener f6222n;

    /* renamed from: com.meizu.common.widget.SwimmingAnimationView$b */
    private interface C1537b {
        /* renamed from: a */
        void mo17444a(float f, float f2, float f3);
    }

    public SwimmingAnimationView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public SwimmingAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwimmingAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6218j = false;
        this.f6219k = new PathInterpolatorCompat(0.66f, 0.0f, 0.67f, 1.0f);
        this.f6220l = new PathInterpolatorCompat(0.33f, 0.0f, 0.27f, 1.0f);
        this.f6221m = new C1537b() {
            /* renamed from: a */
            public void mo17444a(float f, float f2, float f3) {
                float unused = SwimmingAnimationView.this.f6213e = f;
                float unused2 = SwimmingAnimationView.this.f6214f = f2;
                float unused3 = SwimmingAnimationView.this.f6215g = f3;
                SwimmingAnimationView.this.invalidate();
            }
        };
        this.f6222n = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (Settings.Global.getFloat(SwimmingAnimationView.this.getContext().getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f) {
                    SwimmingAnimationView.this.post(new Runnable() {
                        @TargetApi(17)
                        public void run() {
                            SwimmingAnimationView.this.f6217i.start();
                        }
                    });
                    return;
                }
                Log.d("SwimmingAnimationView", "onAnimationEnd, animatorDurationScale == 0, stopAnimator");
                SwimmingAnimationView.this.mo17438b();
            }
        };
        this.f6216h = context;
        TypedArray obtainStyledAttributes = this.f6216h.obtainStyledAttributes(attributeSet, R.styleable.SwimmingAnimationView);
        int color = obtainStyledAttributes.getColor(R.styleable.SwimmingAnimationView_mzCircleColor, -12807940);
        this.f6210b = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SwimmingAnimationView_mzCircleRadius, getResources().getDimensionPixelOffset(R.dimen.mz_swimming_circle_radius));
        this.f6211c = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SwimmingAnimationView_mzCircleGap, getResources().getDimensionPixelOffset(R.dimen.mz_swimming_circle_gap));
        this.f6212d = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SwimmingAnimationView_mzCircleDistance, getResources().getDimensionPixelOffset(R.dimen.mz_swimming_circle_distance));
        obtainStyledAttributes.recycle();
        this.f6209a = new Paint();
        this.f6209a.setAntiAlias(true);
        this.f6209a.setStyle(Paint.Style.FILL);
        this.f6209a.setColor(color);
        this.f6217i = m6181d();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawCircle((float) this.f6210b, ((float) this.f6210b) + this.f6213e, (float) this.f6210b, this.f6209a);
        canvas.drawCircle((float) ((this.f6210b * 3) + this.f6211c), ((float) this.f6210b) + this.f6214f, (float) this.f6210b, this.f6209a);
        canvas.drawCircle((float) ((this.f6210b * 5) + (this.f6211c * 2)), ((float) this.f6210b) + this.f6215g, (float) this.f6210b, this.f6209a);
    }

    @UiThread
    /* renamed from: a */
    public void mo17437a() {
        if (!this.f6218j) {
            this.f6218j = true;
            this.f6217i.addListener(this.f6222n);
            this.f6217i.start();
            Log.d("SwimmingAnimationView", "startAnimator");
        }
    }

    @UiThread
    /* renamed from: b */
    public void mo17438b() {
        if (this.f6218j) {
            this.f6218j = false;
            this.f6217i.removeAllListeners();
            this.f6217i.cancel();
            mo17439c();
            Log.d("SwimmingAnimationView", "stopAnimator");
        }
    }

    /* renamed from: d */
    private Animator m6181d() {
        C1536a aVar = new C1536a();
        aVar.mo17448a(this.f6221m);
        aVar.mo17447a((float) this.f6212d, 450, this.f6219k, 520, this.f6220l, 0);
        aVar.mo17449b((float) this.f6212d, 450, this.f6219k, 520, this.f6220l, 83);
        aVar.mo17450c((float) this.f6212d, 450, this.f6219k, 520, this.f6220l, 166);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, (float) 970});
        ofFloat.setDuration(970);
        ofFloat.addUpdateListener(aVar);
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }

    /* renamed from: com.meizu.common.widget.SwimmingAnimationView$a */
    static class C1536a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        private float f6226a;

        /* renamed from: b */
        private long f6227b;

        /* renamed from: c */
        private Interpolator f6228c;

        /* renamed from: d */
        private long f6229d;

        /* renamed from: e */
        private Interpolator f6230e;

        /* renamed from: f */
        private long f6231f;

        /* renamed from: g */
        private float f6232g;

        /* renamed from: h */
        private long f6233h;

        /* renamed from: i */
        private Interpolator f6234i;

        /* renamed from: j */
        private long f6235j;

        /* renamed from: k */
        private Interpolator f6236k;

        /* renamed from: l */
        private long f6237l;

        /* renamed from: m */
        private float f6238m;

        /* renamed from: n */
        private long f6239n;

        /* renamed from: o */
        private Interpolator f6240o;

        /* renamed from: p */
        private long f6241p;

        /* renamed from: q */
        private Interpolator f6242q;

        /* renamed from: r */
        private long f6243r;

        /* renamed from: s */
        private C1537b f6244s;

        C1536a() {
        }

        /* renamed from: a */
        public void mo17447a(float f, long j, Interpolator interpolator, long j2, Interpolator interpolator2, long j3) {
            this.f6226a = f;
            this.f6227b = j;
            this.f6228c = interpolator;
            this.f6229d = j2;
            this.f6230e = interpolator2;
            this.f6231f = j3;
        }

        /* renamed from: b */
        public void mo17449b(float f, long j, Interpolator interpolator, long j2, Interpolator interpolator2, long j3) {
            this.f6232g = f;
            this.f6233h = j;
            this.f6234i = interpolator;
            this.f6235j = j2;
            this.f6236k = interpolator2;
            this.f6237l = j3;
        }

        /* renamed from: c */
        public void mo17450c(float f, long j, Interpolator interpolator, long j2, Interpolator interpolator2, long j3) {
            this.f6238m = f;
            this.f6239n = j;
            this.f6240o = interpolator;
            this.f6241p = j2;
            this.f6242q = interpolator2;
            this.f6243r = j3;
        }

        /* renamed from: a */
        public void mo17448a(C1537b bVar) {
            this.f6244s = bVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.f6244s != null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f6244s.mo17444a(m6187a(floatValue, this.f6231f, this.f6227b, this.f6229d, this.f6226a, this.f6228c, this.f6230e), m6187a(floatValue, this.f6237l, this.f6233h, this.f6235j, this.f6232g, this.f6234i, this.f6236k), m6187a(floatValue, this.f6243r, this.f6239n, this.f6241p, this.f6238m, this.f6240o, this.f6242q));
            }
        }

        /* renamed from: a */
        private float m6187a(float f, long j, long j2, long j3, float f2, Interpolator interpolator, Interpolator interpolator2) {
            float f3 = f - ((float) j);
            if (f3 < 0.0f) {
                f3 += (float) (j2 + j3);
            }
            float f4 = (float) j2;
            if (f3 < f4) {
                return m6186a(0.0f, f2, interpolator, f3 / f4);
            }
            return m6186a(f2, 0.0f, interpolator2, (f3 - f4) / ((float) j3));
        }

        /* renamed from: a */
        private float m6186a(float f, float f2, Interpolator interpolator, float f3) {
            return f + ((f2 - f) * interpolator.getInterpolation(f3));
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        Log.d("SwimmingAnimationView", "onVisibilityChanged=" + i + ", isShown=" + isShown() + ", getVisibility=" + getVisibility());
        m6178a(i);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        Log.d("SwimmingAnimationView", "onWindowVisibilityChanged:" + i + ", isShown=" + isShown());
        m6178a(i);
    }

    /* renamed from: a */
    private void m6178a(int i) {
        if (i != 0 || !isShown()) {
            mo17438b();
        } else {
            mo17437a();
        }
    }

    /* renamed from: c */
    public void mo17439c() {
        this.f6213e = 0.0f;
        this.f6214f = 0.0f;
        this.f6215g = 0.0f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = (this.f6210b * 2 * 3) + (this.f6211c * 2);
        int i4 = (this.f6210b * 2) + this.f6212d;
        setMeasuredDimension(resolveSizeAndState(i3 + getPaddingLeft() + getPaddingRight(), i, 0), resolveSizeAndState(i4 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }
}
