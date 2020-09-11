package com.meizu.common.widget;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import com.meizu.common.R;

public class GradientLayout extends LinearLayout {

    /* renamed from: A */
    private int f5305A;

    /* renamed from: B */
    private float f5306B;

    /* renamed from: C */
    private float f5307C;

    /* renamed from: D */
    private float f5308D;

    /* renamed from: E */
    private float f5309E;

    /* renamed from: F */
    private float f5310F;

    /* renamed from: G */
    private float f5311G;

    /* renamed from: H */
    private float f5312H;

    /* renamed from: I */
    private float f5313I;

    /* renamed from: J */
    private float f5314J;

    /* renamed from: K */
    private float f5315K;

    /* renamed from: L */
    private float f5316L;

    /* renamed from: M */
    private float f5317M;

    /* renamed from: N */
    private float f5318N;

    /* renamed from: O */
    private float f5319O;

    /* renamed from: P */
    private float f5320P;

    /* renamed from: Q */
    private float f5321Q;

    /* renamed from: R */
    private float f5322R;

    /* renamed from: S */
    private long f5323S;

    /* renamed from: T */
    private long f5324T;

    /* renamed from: U */
    private boolean f5325U;

    /* renamed from: V */
    private boolean f5326V;

    /* renamed from: W */
    private boolean f5327W;

    /* renamed from: a */
    private final int f5328a;

    /* renamed from: aa */
    private boolean f5329aa;

    /* renamed from: ab */
    private boolean f5330ab;

    /* renamed from: ac */
    private boolean f5331ac;

    /* renamed from: ad */
    private boolean f5332ad;

    /* renamed from: ae */
    private boolean f5333ae;

    /* renamed from: af */
    private boolean f5334af;

    /* renamed from: ag */
    private Paint f5335ag;

    /* renamed from: ah */
    private Paint f5336ah;

    /* renamed from: ai */
    private Paint f5337ai;

    /* renamed from: aj */
    private Drawable f5338aj;

    /* renamed from: ak */
    private ObjectAnimator f5339ak;

    /* renamed from: al */
    private ObjectAnimator f5340al;

    /* renamed from: am */
    private TimeInterpolator f5341am;

    /* renamed from: b */
    private final int f5342b;

    /* renamed from: c */
    private final int f5343c;

    /* renamed from: d */
    private final int f5344d;

    /* renamed from: e */
    private float f5345e;

    /* renamed from: f */
    private float f5346f;

    /* renamed from: g */
    private final float f5347g;

    /* renamed from: h */
    private final float f5348h;

    /* renamed from: i */
    private final long f5349i;

    /* renamed from: j */
    private final long f5350j;

    /* renamed from: k */
    private final String f5351k;

    /* renamed from: l */
    private final String f5352l;

    /* renamed from: m */
    private final String f5353m;

    /* renamed from: n */
    private RectF f5354n;

    /* renamed from: o */
    private Camera f5355o;

    /* renamed from: p */
    private Matrix f5356p;

    /* renamed from: q */
    private Matrix f5357q;

    /* renamed from: r */
    private int f5358r;

    /* renamed from: s */
    private int f5359s;

    /* renamed from: t */
    private int f5360t;

    /* renamed from: u */
    private int f5361u;

    /* renamed from: v */
    private int f5362v;

    /* renamed from: w */
    private int f5363w;

    /* renamed from: x */
    private int f5364x;

    /* renamed from: y */
    private int f5365y;

    /* renamed from: z */
    private int f5366z;

    public GradientLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public GradientLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5328a = -16711936;
        this.f5342b = 0;
        this.f5343c = 1;
        this.f5344d = -1710619;
        this.f5345e = 5.0f;
        this.f5346f = 0.95f;
        this.f5347g = 1.0f;
        this.f5348h = 0.1f;
        this.f5349i = 128;
        this.f5350j = 352;
        this.f5351k = "canvasScale";
        this.f5352l = "canvasRotationY";
        this.f5353m = "canvasRotationZ";
        this.f5354n = new RectF();
        this.f5355o = new Camera();
        this.f5356p = new Matrix();
        this.f5357q = new Matrix();
        this.f5358r = 654311424;
        this.f5359s = 0;
        this.f5360t = 76;
        this.f5362v = -16711936;
        this.f5363w = -16711936;
        this.f5306B = 1.0f;
        this.f5307C = 1.0f;
        this.f5308D = 0.0f;
        this.f5309E = 0.0f;
        this.f5325U = false;
        this.f5326V = false;
        this.f5327W = true;
        this.f5329aa = false;
        this.f5330ab = false;
        this.f5331ac = false;
        this.f5332ad = false;
        this.f5333ae = true;
        this.f5334af = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GradientLayout, 0, 0);
        if (obtainStyledAttributes != null) {
            this.f5362v = obtainStyledAttributes.getColor(R.styleable.GradientLayout_mcLeftColor, this.f5362v);
            this.f5363w = obtainStyledAttributes.getColor(R.styleable.GradientLayout_mcRightColor, this.f5363w);
            this.f5361u = obtainStyledAttributes.getInt(R.styleable.GradientLayout_mcShape, 0);
            this.f5327W = obtainStyledAttributes.getBoolean(R.styleable.GradientLayout_mcDrawShadow, true);
            this.f5329aa = obtainStyledAttributes.getBoolean(R.styleable.GradientLayout_mcEnableRotateY, false);
            this.f5332ad = obtainStyledAttributes.getBoolean(R.styleable.GradientLayout_mcOnlyDrawShadow, false);
            this.f5333ae = obtainStyledAttributes.getBoolean(R.styleable.GradientLayout_mcGreyWhenDisabled, true);
            this.f5334af = obtainStyledAttributes.getBoolean(R.styleable.GradientLayout_mcEnableDrawBackground, true);
            obtainStyledAttributes.recycle();
        }
        m5785a();
    }

    /* renamed from: a */
    private void m5785a() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f5341am = new PathInterpolator(0.33f, 0.0f, 0.33f, 1.0f);
        } else {
            this.f5341am = new AccelerateDecelerateInterpolator();
        }
        this.f5335ag = new Paint();
        this.f5335ag.setAntiAlias(true);
        this.f5364x = this.f5335ag.getAlpha();
        this.f5336ah = new Paint(this.f5335ag);
        this.f5336ah.setAntiAlias(true);
        this.f5336ah.setColor(this.f5362v);
        this.f5337ai = new Paint(this.f5336ah);
        this.f5337ai.setColor(-1710619);
        setOrientation(0);
        setGravity(17);
        this.f5312H = (float) ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f5313I = this.f5312H;
        this.f5322R = getResources().getDisplayMetrics().density;
    }

    public void setupShadowDrawable() {
        if (!this.f5327W) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.f5361u == 1) {
                this.f5338aj = getResources().getDrawable(R.drawable.mc_gradient_layout_circle_shadow, (Resources.Theme) null);
            } else {
                this.f5338aj = getResources().getDrawable(R.drawable.mc_gradient_layout_shadow, (Resources.Theme) null);
            }
        } else if (this.f5361u == 1) {
            this.f5338aj = getResources().getDrawable(R.drawable.mc_gradient_layout_circle_shadow);
        } else {
            this.f5338aj = getResources().getDrawable(R.drawable.mc_gradient_layout_shadow);
        }
    }

    public void setOrientation(int i) {
        if (i == 0) {
            super.setOrientation(i);
            return;
        }
        throw new IllegalStateException("Orientation must be HORIZONTAL");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f5354n.set(0.0f, 0.0f, (float) i, (float) i2);
        this.f5365y = i;
        this.f5366z = i2;
        this.f5318N = (float) (this.f5365y / 2);
        this.f5319O = (float) (this.f5366z / 2);
        this.f5305A = this.f5366z / 2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        this.f5336ah.setColor(m5784a(this.f5362v));
        if (this.f5354n.width() > 0.0f && this.f5354n.height() > 0.0f) {
            if (isEnabled()) {
                canvas.scale(this.f5307C, this.f5307C, this.f5318N, this.f5319O);
                if (this.f5334af) {
                    m5787a(canvas);
                }
            } else if (this.f5334af) {
                canvas.drawRoundRect(this.f5354n, (float) this.f5305A, (float) this.f5305A, this.f5337ai);
            }
        }
        super.dispatchDraw(canvas);
    }

    /* renamed from: a */
    private void m5787a(Canvas canvas) {
        canvas.save();
        canvas.drawRoundRect(this.f5354n, (float) this.f5305A, (float) this.f5305A, this.f5336ah);
        canvas.restore();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f5332ad) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!isEnabled()) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                m5788a(motionEvent);
                break;
            case 1:
            case 3:
                if (!this.f5326V) {
                    m5792c(motionEvent);
                }
                this.f5326V = false;
                break;
            case 2:
                if (!this.f5326V) {
                    m5790b(motionEvent);
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f5332ad) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    /* renamed from: a */
    private void m5788a(MotionEvent motionEvent) {
        this.f5323S = System.currentTimeMillis();
        this.f5320P = motionEvent.getX();
        this.f5321Q = motionEvent.getY();
        this.f5317M = this.f5320P;
        this.f5315K = 0.0f;
        m5786a(this.f5320P);
        m5789b();
        this.f5339ak.start();
    }

    /* renamed from: b */
    private void m5790b(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z = true;
        if (x < 0.0f - this.f5313I || x > ((float) this.f5365y) + this.f5313I || y < 0.0f || y > ((float) this.f5366z)) {
            this.f5326V = true;
        }
        if (!this.f5326V && this.f5330ab) {
            if ((this.f5320P >= this.f5316L || x <= this.f5316L) && (this.f5320P <= this.f5316L || x >= this.f5316L)) {
                z = false;
            }
            this.f5326V = z;
        }
        if (this.f5326V) {
            m5792c(motionEvent);
        }
    }

    /* renamed from: a */
    private void m5786a(float f) {
        float f2 = (f - this.f5318N) / this.f5318N;
        if (f2 < -1.0f) {
            f2 = -1.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.f5308D = f2 * this.f5345e;
        if (f < this.f5318N) {
            setRotationPivot((float) this.f5365y);
        } else {
            setRotationPivot(0.0f);
        }
    }

    /* renamed from: c */
    private void m5792c(MotionEvent motionEvent) {
        this.f5325U = false;
        this.f5324T = System.currentTimeMillis();
        long j = this.f5324T - this.f5323S;
        m5791c();
        if (j < 128) {
            this.f5340al.setStartDelay(128 - j);
        } else {
            this.f5340al.setStartDelay(0);
        }
        this.f5340al.start();
    }

    /* renamed from: b */
    private void m5789b() {
        this.f5306B = this.f5346f;
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("canvasRotationY", new float[]{0.0f, this.f5308D});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("canvasScale", new float[]{1.0f, this.f5306B});
        if (this.f5339ak == null) {
            if (this.f5329aa) {
                this.f5339ak = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat, ofFloat2});
            } else {
                this.f5339ak = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat2});
            }
            this.f5339ak.setInterpolator(this.f5341am);
            this.f5339ak.setDuration(128);
        } else if (this.f5329aa) {
            this.f5339ak.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2});
        } else {
            this.f5339ak.setValues(new PropertyValuesHolder[]{ofFloat2});
        }
    }

    /* renamed from: c */
    private void m5791c() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("canvasRotationY", new float[]{this.f5308D, 0.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("canvasScale", new float[]{this.f5306B, 1.0f});
        if (this.f5340al == null) {
            if (this.f5329aa) {
                this.f5340al = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat, ofFloat2});
            } else {
                this.f5340al = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat2});
            }
            this.f5340al.setInterpolator(this.f5341am);
            this.f5340al.setDuration(352);
        } else if (this.f5329aa) {
            this.f5340al.setValues(new PropertyValuesHolder[]{ofFloat, ofFloat2});
        } else {
            this.f5340al.setValues(new PropertyValuesHolder[]{ofFloat2});
        }
    }

    public void setLeftColor(int i) {
        this.f5362v = i;
        this.f5336ah.setColor(i);
        postInvalidate();
    }

    public void setRightColor(int i) {
        this.f5363w = i;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public float getCanvasScale() {
        return this.f5307C;
    }

    /* access modifiers changed from: protected */
    public void setCanvasScale(float f) {
        this.f5307C = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public float getCanvasRotationY() {
        return this.f5310F;
    }

    /* access modifiers changed from: protected */
    public void setCanvasRotationY(float f) {
        this.f5310F = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public float getCanvasRotationZ() {
        return this.f5311G;
    }

    /* access modifiers changed from: protected */
    public void setCanvasRotationZ(float f) {
        this.f5311G = f;
        invalidate();
    }

    private void setRotationPivot(float f) {
        this.f5314J = f;
    }

    public void setEnableRotateY(boolean z) {
        this.f5329aa = z;
    }

    public boolean getEnableRotateY() {
        return this.f5329aa;
    }

    public void setShouldDrawShadow(boolean z) {
        this.f5327W = z;
        if (this.f5327W && this.f5338aj == null) {
            setupShadowDrawable();
        }
        invalidate();
    }

    public int getDisableColorAlpha() {
        return this.f5360t;
    }

    public void setDisableColorAlpha(int i) {
        if (i >= 0 && i <= 255) {
            this.f5360t = i;
        }
    }

    public void setOnlyDrawShadow(boolean z) {
        this.f5332ad = z;
        invalidate();
    }

    /* renamed from: a */
    private int m5784a(int i) {
        if (this.f5307C == 1.0f) {
            return i;
        }
        float f = (1.0f - this.f5307C) / (1.0f - this.f5346f);
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = fArr[1] + (0.05f * f);
        fArr[2] = fArr[2] - (f * 0.1f);
        return Color.HSVToColor(fArr);
    }
}
