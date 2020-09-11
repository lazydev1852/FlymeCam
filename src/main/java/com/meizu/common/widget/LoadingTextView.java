package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.p060a.PathInterpolatorCompat;

public class LoadingTextView extends TextView {

    /* renamed from: F */
    private static int f5645F = 83;

    /* renamed from: G */
    private static int f5646G = 917;

    /* renamed from: H */
    private static int f5647H = 160;

    /* renamed from: I */
    private static float f5648I = (255.0f / ((float) f5645F));

    /* renamed from: o */
    private static int f5649o = 3;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public Rect f5650A;

    /* renamed from: B */
    private AnimatorSet f5651B;

    /* renamed from: C */
    private ValueAnimator f5652C;

    /* renamed from: D */
    private ValueAnimator f5653D;

    /* renamed from: E */
    private ValueAnimator f5654E;

    /* renamed from: a */
    private Paint f5655a;

    /* renamed from: b */
    private Paint f5656b;

    /* renamed from: c */
    private CharSequence f5657c;

    /* renamed from: d */
    private int f5658d;

    /* renamed from: e */
    private int[] f5659e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public float f5660f;

    /* renamed from: g */
    private AnimatorSet f5661g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ValueAnimator f5662h;

    /* renamed from: i */
    private ValueAnimator f5663i;

    /* renamed from: j */
    private int f5664j;

    /* renamed from: k */
    private int f5665k;

    /* renamed from: l */
    private int f5666l;

    /* renamed from: m */
    private int f5667m;

    /* renamed from: n */
    private int f5668n;

    /* renamed from: p */
    private CharSequence f5669p;

    /* renamed from: q */
    private int f5670q;

    /* renamed from: r */
    private int f5671r;

    /* renamed from: s */
    private Drawable f5672s;

    /* renamed from: t */
    private Drawable f5673t;

    /* renamed from: u */
    private float f5674u;

    /* renamed from: v */
    private int f5675v;

    /* renamed from: w */
    private int f5676w;

    /* renamed from: x */
    private int f5677x;

    /* renamed from: y */
    private int f5678y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public Paint f5679z;

    public LoadingTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LoadingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5661g = null;
        this.f5662h = null;
        this.f5663i = null;
        this.f5670q = 0;
        this.f5671r = 1;
        this.f5676w = 400;
        this.f5677x = this.f5676w / 2;
        this.f5678y = 51;
        this.f5650A = new Rect();
        this.f5651B = null;
        this.f5652C = null;
        this.f5653D = null;
        this.f5654E = null;
        m5870a(context, attributeSet);
        m5876c();
        m5880e();
    }

    /* renamed from: a */
    private void m5870a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LoadingTextView, R.attr.MeizuCommon_LoadingTextStyle, 0);
        if (obtainStyledAttributes != null) {
            try {
                this.f5657c = obtainStyledAttributes.getString(R.styleable.LoadingTextView_mcLoadingText);
                this.f5669p = obtainStyledAttributes.getString(R.styleable.LoadingTextView_mcErrorText);
                this.f5658d = obtainStyledAttributes.getInt(R.styleable.LoadingTextView_mcDotRadius, (int) getResources().getDimension(R.dimen.down_dot_radius));
                this.f5666l = obtainStyledAttributes.getColor(R.styleable.LoadingTextView_mcLoadingTextColor, getResources().getColor(R.color.down_load_text_color));
                this.f5667m = obtainStyledAttributes.getColor(R.styleable.LoadingTextView_mcDotColor, getResources().getColor(R.color.down_load_dot_color));
                this.f5668n = obtainStyledAttributes.getInt(R.styleable.LoadingTextView_mcDotNum, f5649o);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* renamed from: c */
    private void m5876c() {
        setGravity(17);
        this.f5655a = new Paint();
        this.f5655a.setAntiAlias(true);
        this.f5655a.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.f5655a.setColor(this.f5666l);
        this.f5655a.setTextSize(getResources().getDimension(R.dimen.down_load_text_size));
        this.f5656b = new Paint();
        this.f5656b.setAntiAlias(true);
        this.f5656b.setColor(this.f5667m);
        this.f5656b.setTextSize(getResources().getDimension(R.dimen.down_load_dot_size));
        this.f5659e = new int[this.f5668n];
        m5879d();
        this.f5665k = (int) getResources().getDimension(R.dimen.down_dot_translate);
        this.f5672s = getResources().getDrawable(R.drawable.mz_loading_textview_icon_next_arrow);
        this.f5673t = getResources().getDrawable(R.drawable.mz_loading_textview_icon_refresh);
        this.f5674u = getResources().getDimension(R.dimen.error_icon_margin);
        this.f5675v = getResources().getColor(R.color.list_hovered_background);
        this.f5679z = new Paint();
        this.f5679z.setAntiAlias(true);
        this.f5679z.setColor(this.f5675v);
        this.f5679z.setTextSize(getResources().getDimension(R.dimen.down_load_dot_size));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f5670q == 1) {
            m5877c(canvas);
        } else {
            m5871a(canvas);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m5879d() {
        for (int i = 0; i < this.f5659e.length; i++) {
            this.f5659e[i] = 0;
        }
    }

    /* renamed from: a */
    private void m5871a(Canvas canvas) {
        m5872b(canvas);
    }

    /* renamed from: b */
    private void m5872b(Canvas canvas) {
        float height = ((float) (canvas.getHeight() / 2)) - ((this.f5655a.descent() / 2.0f) + (this.f5655a.ascent() / 2.0f));
        if (this.f5657c == null) {
            this.f5657c = "";
        }
        float measureText = this.f5655a.measureText(this.f5657c.toString());
        canvas.drawText(this.f5657c.toString(), (((float) getMeasuredWidth()) - measureText) / 2.0f, height, this.f5655a);
        this.f5655a.setShader((Shader) null);
        for (int i = 0; i < this.f5668n; i++) {
            this.f5656b.setAlpha(this.f5659e[i]);
            canvas.drawCircle(((((float) getMeasuredWidth()) + measureText) / 2.0f) + (((float) i) * getResources().getDimension(R.dimen.down_dot_gap)) + this.f5660f, height, (float) this.f5658d, this.f5656b);
        }
    }

    /* renamed from: c */
    private void m5877c(Canvas canvas) {
        float height = ((float) (canvas.getHeight() / 2)) - ((this.f5655a.descent() / 2.0f) + (this.f5655a.ascent() / 2.0f));
        if (this.f5669p == null) {
            this.f5669p = "";
        }
        float measureText = this.f5655a.measureText(this.f5669p.toString());
        canvas.drawText(this.f5669p.toString(), (((float) getMeasuredWidth()) - measureText) / 2.0f, height, this.f5655a);
        float height2 = (float) ((canvas.getHeight() / 2) - (((BitmapDrawable) this.f5672s).getBitmap().getHeight() / 2));
        if (this.f5671r == 1) {
            canvas.drawBitmap(((BitmapDrawable) this.f5672s).getBitmap(), ((((float) getMeasuredWidth()) + measureText) / 2.0f) + this.f5674u, height2, (Paint) null);
        } else if (this.f5671r == 2) {
            canvas.drawBitmap(((BitmapDrawable) this.f5673t).getBitmap(), ((((float) getMeasuredWidth()) + measureText) / 2.0f) + this.f5674u, height2, (Paint) null);
        }
        canvas.drawRect(this.f5650A, this.f5679z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5869a(float f) {
        for (int i = 0; i < this.f5659e.length; i++) {
            this.f5659e[(this.f5659e.length - 1) - i] = (int) Math.max(0.0f, Math.min(Math.min(255.0f, Math.max(0.0f, f - ((float) (f5647H * i))) * f5648I), 255.0f - (f5648I * (f - ((float) ((f5647H * i) + (f5645F + f5646G)))))));
        }
    }

    /* renamed from: e */
    private void m5880e() {
        this.f5663i = ValueAnimator.ofFloat(new float[]{0.0f, (float) this.f5665k});
        this.f5663i.setInterpolator(new PathInterpolatorCompat(0.11f, 0.0f, 0.12f, 1.0f));
        this.f5663i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = LoadingTextView.this.f5660f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LoadingTextView.this.invalidate();
            }
        });
        this.f5663i.setDuration((long) this.f5664j);
        this.f5663i.setRepeatMode(1);
        this.f5663i.setRepeatCount(-1);
        this.f5664j = (f5647H * (this.f5668n - 1)) + f5645F + f5646G + f5645F;
        this.f5662h = ValueAnimator.ofFloat(new float[]{0.0f, (float) this.f5664j});
        this.f5662h.setDuration((long) this.f5664j);
        this.f5662h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoadingTextView.this.m5869a(((Float) LoadingTextView.this.f5662h.getAnimatedValue()).floatValue());
            }
        });
        this.f5662h.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                LoadingTextView.this.m5879d();
            }

            public void onAnimationEnd(Animator animator) {
                LoadingTextView.this.m5879d();
            }
        });
        this.f5662h.setRepeatMode(1);
        this.f5662h.setRepeatCount(-1);
        this.f5661g = new AnimatorSet();
        this.f5661g.play(this.f5663i).with(this.f5662h);
    }

    public void setDotColor(int i) {
        this.f5656b.setColor(i);
    }

    public void setLoadingTextColor(int i) {
        this.f5655a.setColor(i);
    }

    public String getLoadText() {
        return (String) this.f5657c;
    }

    public void setLoadText(String str) {
        this.f5657c = str;
    }

    /* renamed from: a */
    public void mo16900a() {
        if (this.f5661g != null) {
            this.f5661g.cancel();
            this.f5661g.removeAllListeners();
            this.f5661g = null;
        }
        if (this.f5662h != null) {
            this.f5662h.cancel();
            this.f5662h.removeAllUpdateListeners();
            this.f5662h = null;
        }
        if (this.f5663i != null) {
            this.f5663i.cancel();
            this.f5663i.removeAllUpdateListeners();
            this.f5663i = null;
        }
    }

    /* renamed from: f */
    private void m5881f() {
        if (this.f5661g == null || !this.f5661g.isRunning()) {
            m5880e();
            this.f5661g.start();
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            if (this.f5670q == 1) {
                mo16901b();
            } else {
                mo16900a();
            }
        } else if (!isShown()) {
        } else {
            if (this.f5670q == 1) {
                m5883h();
            } else {
                m5881f();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            if (this.f5670q == 1) {
                mo16901b();
            } else {
                mo16900a();
            }
        } else if (!isShown()) {
        } else {
            if (this.f5670q == 1) {
                m5883h();
            } else {
                m5881f();
            }
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            if (this.f5670q == 1) {
                m5883h();
            } else {
                m5881f();
            }
        } else if (i != 4 && i != 8) {
        } else {
            if (this.f5670q == 1) {
                mo16901b();
            } else {
                mo16900a();
            }
        }
    }

    public void setErrorStatus(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.f5669p = str;
        }
        if (this.f5650A == null) {
            this.f5650A = new Rect();
        }
        this.f5650A.set(0, 0, 0, getHeight());
        this.f5670q = 1;
        mo16900a();
        m5883h();
        invalidate();
    }

    public void setLoadingStatus() {
        this.f5670q = 0;
        mo16901b();
        m5881f();
        invalidate();
    }

    public void setErrorBitmapType(int i) {
        this.f5671r = i;
        invalidate();
    }

    public void setBackgroundAlpha(int i) {
        this.f5678y = i;
    }

    /* renamed from: g */
    private void m5882g() {
        this.f5654E = ValueAnimator.ofInt(new int[]{0, getWidth()});
        this.f5654E.setInterpolator(new PathInterpolatorCompat(0.1f, 0.57f, 0.2f, 1.0f));
        this.f5654E.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoadingTextView.this.f5650A.right = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                LoadingTextView.this.invalidate();
            }
        });
        this.f5654E.setDuration((long) this.f5676w);
        this.f5653D = ValueAnimator.ofInt(new int[]{this.f5678y, 0});
        this.f5653D.setDuration((long) this.f5677x);
        this.f5653D.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoadingTextView.this.f5679z.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.f5652C = ValueAnimator.ofInt(new int[]{this.f5678y, 0});
        this.f5652C.setDuration((long) this.f5676w);
        this.f5654E.setInterpolator(new PathInterpolatorCompat(0.33f, 0.0f, 0.67f, 1.0f));
        this.f5652C.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoadingTextView.this.f5679z.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.f5651B = new AnimatorSet();
        this.f5651B.play(this.f5654E).with(this.f5652C);
    }

    /* renamed from: b */
    public void mo16901b() {
        if (this.f5654E != null) {
            this.f5654E.cancel();
            this.f5654E.removeAllListeners();
            this.f5654E = null;
        }
        if (this.f5652C != null) {
            this.f5652C.cancel();
            this.f5652C.removeAllUpdateListeners();
            this.f5652C = null;
        }
        if (this.f5653D != null) {
            this.f5653D.cancel();
            this.f5653D.removeAllUpdateListeners();
            this.f5653D = null;
        }
        if (this.f5654E != null) {
            this.f5654E.cancel();
            this.f5654E.removeAllUpdateListeners();
            this.f5654E = null;
        }
    }

    /* renamed from: h */
    private void m5883h() {
        if (this.f5651B == null || !this.f5651B.isRunning()) {
            m5882g();
            this.f5651B.start();
        }
    }
}
