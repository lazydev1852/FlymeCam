package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Scroller;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.meizu.common.R;
import java.util.List;

public class HorizontalWheelView extends View {

    /* renamed from: A */
    private Paint f5411A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public C1449a f5412B;

    /* renamed from: C */
    private int f5413C;

    /* renamed from: D */
    private Paint f5414D;

    /* renamed from: E */
    private Path f5415E;

    /* renamed from: F */
    private float f5416F;

    /* renamed from: G */
    private int f5417G;

    /* renamed from: H */
    private float f5418H;

    /* renamed from: I */
    private float f5419I;

    /* renamed from: J */
    private boolean f5420J;

    /* renamed from: K */
    private float f5421K;

    /* renamed from: L */
    private boolean f5422L;

    /* renamed from: M */
    private int f5423M;

    /* renamed from: N */
    private int f5424N;

    /* renamed from: O */
    private boolean f5425O;

    /* renamed from: P */
    private float f5426P;

    /* renamed from: Q */
    private float f5427Q;

    /* renamed from: R */
    private int f5428R;

    /* renamed from: S */
    private boolean f5429S;

    /* renamed from: T */
    private boolean f5430T;

    /* renamed from: U */
    private boolean f5431U;

    /* renamed from: a */
    private float f5432a;

    /* renamed from: b */
    private float f5433b;

    /* renamed from: c */
    private float f5434c;

    /* renamed from: d */
    private int f5435d;

    /* renamed from: e */
    private int f5436e;

    /* renamed from: f */
    private Paint f5437f;

    /* renamed from: g */
    private float f5438g;

    /* renamed from: h */
    private int f5439h;

    /* renamed from: i */
    private List<String> f5440i;

    /* renamed from: j */
    private boolean f5441j;

    /* renamed from: k */
    private boolean f5442k;

    /* renamed from: l */
    private boolean f5443l;

    /* renamed from: m */
    private float f5444m;

    /* renamed from: n */
    private float f5445n;

    /* renamed from: o */
    private float f5446o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f5447p;

    /* renamed from: q */
    private float f5448q;

    /* renamed from: r */
    private int f5449r;

    /* renamed from: s */
    private int f5450s;

    /* renamed from: t */
    private float f5451t;

    /* renamed from: u */
    private float f5452u;

    /* renamed from: v */
    private int f5453v;

    /* renamed from: w */
    private Scroller f5454w;

    /* renamed from: x */
    private VelocityTracker f5455x;

    /* renamed from: y */
    private int f5456y;

    /* renamed from: z */
    private int f5457z;

    /* renamed from: com.meizu.common.widget.HorizontalWheelView$a */
    public interface C1449a {
        /* renamed from: a */
        void mo16790a(float f);
    }

    public HorizontalWheelView(Context context) {
        this(context, (AttributeSet) null);
    }

    public HorizontalWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5434c = 18.0f;
        this.f5435d = SupportMenu.CATEGORY_MASK;
        this.f5436e = ViewCompat.MEASURED_STATE_MASK;
        this.f5438g = 18.0f;
        this.f5439h = 100;
        this.f5442k = true;
        this.f5444m = 2.0f;
        this.f5445n = 1.0f;
        this.f5447p = 0;
        this.f5448q = 20.0f;
        this.f5451t = 10.0f;
        this.f5452u = 10.0f;
        this.f5456y = ViewCompat.MEASURED_STATE_MASK;
        this.f5457z = ViewCompat.MEASURED_STATE_MASK;
        this.f5413C = 5;
        this.f5416F = 0.0f;
        this.f5418H = 5.0f;
        this.f5419I = 0.0f;
        this.f5420J = true;
        this.f5428R = -1;
        this.f5429S = false;
        this.f5430T = false;
        this.f5431U = false;
        m5802a();
        m5805a(context, attributeSet);
        this.f5437f = new TextPaint(1);
        this.f5437f.setTextSize(this.f5438g);
        this.f5437f.setColor(this.f5436e);
        Rect rect = new Rect();
        this.f5437f.getTextBounds("0", 0, 1, rect);
        this.f5433b = ((float) getPaddingTop()) + this.f5451t + ((float) rect.height());
        this.f5432a = this.f5433b + this.f5434c;
        this.f5411A = new Paint(1);
        this.f5411A.setColor(this.f5456y);
        if (this.f5422L) {
            this.f5411A.setStrokeCap(Paint.Cap.ROUND);
        }
        this.f5452u *= this.f5446o;
        this.f5415E = new Path();
        this.f5414D = new Paint(1);
        this.f5414D.setStyle(Paint.Style.FILL);
        this.f5414D.setColor(this.f5435d);
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.f5429S = accessibilityManager.isEnabled();
        }
        if (this.f5429S) {
            setFocusable(true);
        }
        m5814f();
    }

    /* renamed from: a */
    private void m5802a() {
        this.f5454w = new Scroller(getContext());
        this.f5446o = (float) ((int) getContext().getResources().getDisplayMetrics().density);
        this.f5438g *= this.f5446o;
        this.f5448q *= this.f5446o;
        this.f5453v = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.f5434c *= this.f5446o;
        this.f5445n *= this.f5446o;
        this.f5444m *= this.f5446o;
        this.f5451t *= this.f5446o;
        this.f5418H *= this.f5446o;
        this.f5421K = ((float) this.f5439h) * this.f5448q;
        this.f5426P = this.f5446o * 3.0f;
        this.f5427Q = this.f5446o * 15.0f;
    }

    /* renamed from: a */
    private void m5805a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HorizontalWheelView, 0, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.HorizontalWheelView_mcScaleDistance) {
                this.f5448q = (float) ((int) obtainStyledAttributes.getDimension(index, this.f5448q));
            } else if (index == R.styleable.HorizontalWheelView_mcTextColor) {
                this.f5436e = obtainStyledAttributes.getColor(index, ViewCompat.MEASURED_STATE_MASK);
            } else if (index == R.styleable.HorizontalWheelView_mcTextSize) {
                this.f5438g = (float) ((int) obtainStyledAttributes.getDimension(index, this.f5438g));
                this.f5421K = ((float) this.f5439h) * this.f5448q;
            } else if (index == R.styleable.HorizontalWheelView_mcSelectedColor) {
                this.f5435d = obtainStyledAttributes.getColor(index, SupportMenu.CATEGORY_MASK);
            } else if (index == R.styleable.HorizontalWheelView_mcLineColor) {
                this.f5456y = obtainStyledAttributes.getColor(index, ViewCompat.MEASURED_STATE_MASK);
            } else if (index == R.styleable.HorizontalWheelView_mcLineWidth) {
                this.f5444m = obtainStyledAttributes.getDimension(index, this.f5444m);
            } else if (index == R.styleable.HorizontalWheelView_mcLineHeight) {
                this.f5434c = obtainStyledAttributes.getDimension(index, this.f5434c);
            } else if (index == R.styleable.HorizontalWheelView_mcLittleLineWidth) {
                this.f5445n = obtainStyledAttributes.getDimension(index, this.f5445n);
            } else if (index == R.styleable.HorizontalWheelView_mcLittleLineColor) {
                this.f5457z = obtainStyledAttributes.getColor(index, ViewCompat.MEASURED_STATE_MASK);
            } else if (index == R.styleable.HorizontalWheelView_mcTriangleSideLength) {
                this.f5452u = obtainStyledAttributes.getDimension(index, this.f5452u);
            } else if (index == R.styleable.HorizontalWheelView_mcShowNumber) {
                this.f5413C = obtainStyledAttributes.getInt(index, this.f5413C);
            } else if (index == R.styleable.HorizontalWheelView_mcTextMarginBottom) {
                this.f5451t = obtainStyledAttributes.getDimension(index, this.f5451t);
            } else if (index == R.styleable.HorizontalWheelView_mcLineMarginBottom) {
                this.f5418H = obtainStyledAttributes.getDimension(index, this.f5418H);
            } else if (index == R.styleable.HorizontalWheelView_mcDamping) {
                this.f5419I = obtainStyledAttributes.getFloat(index, this.f5419I);
                if (this.f5419I > 1.0f) {
                    this.f5419I = 1.0f;
                } else if (this.f5419I < 0.0f) {
                    this.f5419I = 0.0f;
                }
            } else if (index == R.styleable.HorizontalWheelView_mcPaintRound) {
                this.f5422L = obtainStyledAttributes.getBoolean(index, false);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public float getSelected() {
        return (float) this.f5447p;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f5450s = getWidth();
        if (this.f5450s != 0 && this.f5442k) {
            this.f5416F = ((float) this.f5447p) * this.f5448q;
            m5809b();
            this.f5417G = (((int) (((float) this.f5450s) / this.f5448q)) / 2) + 1;
            this.f5442k = false;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    /* renamed from: b */
    private void m5809b() {
        this.f5424N = this.f5450s / 2;
        float f = this.f5432a + this.f5418H;
        float sin = ((float) ((int) (Math.sin(1.0471975511965976d) * ((double) this.f5452u)))) + f;
        this.f5415E.moveTo((float) this.f5424N, f);
        this.f5415E.lineTo(((float) this.f5424N) - (this.f5452u / 2.0f), sin);
        this.f5415E.lineTo(((float) this.f5424N) + (this.f5452u / 2.0f), sin);
        this.f5415E.close();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m5810b(canvas);
        m5806a(canvas);
    }

    /* renamed from: a */
    private void m5806a(Canvas canvas) {
        canvas.drawPath(this.f5415E, this.f5414D);
    }

    /* renamed from: b */
    private void m5810b(Canvas canvas) {
        int i;
        int i2;
        canvas.save();
        float f = this.f5416F % this.f5448q;
        int i3 = (int) (this.f5416F / this.f5448q);
        if (i3 != this.f5447p) {
            this.f5447p = i3;
            m5812d();
            if (this.f5425O && this.f5447p == this.f5428R) {
                m5814f();
            }
        }
        float f2 = ((float) (this.f5450s / 2)) - f;
        for (int i4 = 0; i4 < this.f5417G; i4++) {
            float f3 = (float) i4;
            float f4 = f2 + (this.f5448q * f3);
            if (((float) getPaddingRight()) + f4 < ((float) this.f5450s) && (i2 = i3 + i4) <= this.f5439h) {
                if (i2 % this.f5413C == 0) {
                    String a = m5801a(i2);
                    PointF a2 = m5800a(a, this.f5437f, f4);
                    canvas.drawText(a, a2.x, a2.y, this.f5437f);
                    m5804a(this.f5456y, this.f5444m, f4);
                    canvas.drawLine(f4, this.f5433b, f4, this.f5432a, this.f5411A);
                } else {
                    m5804a(this.f5457z, this.f5445n, f4);
                    canvas.drawLine(f4, this.f5433b + (this.f5434c / 4.0f), f4, this.f5432a - (this.f5434c / 4.0f), this.f5411A);
                }
            }
            float f5 = f2 - (f3 * this.f5448q);
            if (f5 > ((float) getPaddingLeft()) && (i = i3 - i4) >= 0) {
                if (i % this.f5413C == 0) {
                    String a3 = m5801a(i);
                    PointF a4 = m5800a(a3, this.f5437f, f5);
                    canvas.drawText(a3, a4.x, a4.y, this.f5437f);
                    m5804a(this.f5456y, this.f5444m, f5);
                    canvas.drawLine(f5, this.f5433b, f5, this.f5432a, this.f5411A);
                } else {
                    m5804a(this.f5457z, this.f5445n, f5);
                    this.f5411A.setStrokeWidth(this.f5445n);
                    canvas.drawLine(f5, this.f5433b + (this.f5434c / 4.0f), f5, this.f5432a - (this.f5434c / 4.0f), this.f5411A);
                }
            }
        }
        canvas.restore();
    }

    /* renamed from: a */
    private String m5801a(int i) {
        if (this.f5440i == null || this.f5440i.size() <= 0 || i >= this.f5440i.size() || i < 0) {
            return String.valueOf(i);
        }
        return this.f5440i.get(i);
    }

    /* renamed from: a */
    private void m5804a(int i, float f, float f2) {
        this.f5411A.setStrokeWidth(f);
        if (Math.abs(f2 - ((float) (this.f5450s / 2))) < this.f5448q) {
            m5803a(i, Math.abs(f2 - ((float) (this.f5450s / 2))) / this.f5448q);
        } else {
            this.f5411A.setColor(i);
        }
    }

    /* renamed from: a */
    private PointF m5800a(String str, Paint paint, float f) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        PointF pointF = new PointF();
        pointF.set(f - ((float) (rect.width() / 2)), (float) (getPaddingTop() + rect.height()));
        return pointF;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f5420J || this.f5443l) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        if (this.f5455x == null) {
            this.f5455x = VelocityTracker.obtain();
        }
        this.f5455x.addMovement(motionEvent);
        this.f5441j = false;
        switch (action) {
            case 0:
                this.f5454w.forceFinished(true);
                this.f5449r = x;
                this.f5423M = x;
                this.f5430T = true;
                this.f5425O = false;
                break;
            case 1:
            case 3:
                this.f5430T = false;
                this.f5425O = false;
                if (Math.abs(this.f5423M - this.f5449r) < 5) {
                    float f = this.f5416F + ((float) (this.f5423M - this.f5424N));
                    if (f >= (-this.f5426P) && f <= this.f5421K + this.f5426P) {
                        int round = Math.round(f / (this.f5448q * ((float) this.f5413C)));
                        if (Math.abs(f - ((((float) round) * this.f5448q) * ((float) this.f5413C))) < this.f5427Q && this.f5447p != this.f5413C * round) {
                            this.f5425O = true;
                            this.f5428R = round * this.f5413C;
                            mo16769a(this.f5428R, 500);
                            this.f5443l = true;
                        }
                    }
                }
                if (!this.f5425O) {
                    this.f5449r = 0;
                    invalidate();
                    m5811c();
                    return true;
                }
                break;
            case 2:
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                float f2 = (float) (this.f5449r - x);
                if ((f2 < 0.0f || this.f5416F < this.f5421K) && (f2 > 0.0f || this.f5416F > 0.0f)) {
                    this.f5416F += m5798a(f2);
                    invalidate();
                    break;
                } else {
                    return true;
                }
        }
        this.f5449r = x;
        return true;
    }

    /* renamed from: c */
    private void m5811c() {
        this.f5455x.computeCurrentVelocity(1000);
        float xVelocity = this.f5455x.getXVelocity();
        if (Math.abs(xVelocity) > ((float) this.f5453v)) {
            this.f5441j = true;
            this.f5454w.fling(0, 0, (int) ((1.0f - this.f5419I) * xVelocity), 0, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, 0);
            return;
        }
        m5813e();
    }

    /* renamed from: d */
    private void m5812d() {
        if (this.f5412B != null) {
            post(new Runnable() {
                public void run() {
                    HorizontalWheelView.this.f5412B.mo16790a((float) HorizontalWheelView.this.f5447p);
                }
            });
        }
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.f5454w.computeScrollOffset()) {
            int currX = this.f5454w.getCurrX();
            if (this.f5441j) {
                float f = (float) (this.f5449r - currX);
                this.f5449r = currX;
                if ((f < 0.0f || this.f5416F < this.f5421K) && (f > 0.0f || this.f5416F > 0.0f)) {
                    this.f5416F += m5798a(f);
                } else {
                    this.f5454w.forceFinished(true);
                    m5814f();
                    this.f5441j = false;
                    return;
                }
            } else {
                this.f5416F = (float) currX;
            }
            postInvalidate();
        } else if (this.f5441j) {
            m5813e();
        } else {
            this.f5428R = -1;
            this.f5443l = false;
            if (!this.f5430T && !this.f5425O && !this.f5431U) {
                m5814f();
            }
            if (this.f5431U) {
                this.f5431U = false;
            }
        }
    }

    /* renamed from: a */
    private float m5798a(float f) {
        if (this.f5416F + f < 0.0f) {
            return -this.f5416F;
        }
        return this.f5416F + f > this.f5421K ? this.f5421K - this.f5416F : f;
    }

    /* renamed from: e */
    private void m5813e() {
        this.f5441j = false;
        this.f5420J = true;
        this.f5454w.forceFinished(true);
        this.f5416F = (float) Math.round(this.f5416F);
        this.f5454w.startScroll((int) this.f5416F, 0, (int) ((float) Math.round(m5807b(this.f5416F % this.f5448q))), 0, 1000);
        postInvalidate();
    }

    /* renamed from: b */
    private float m5807b(float f) {
        if (f <= this.f5448q / 2.0f) {
            return -f;
        }
        return this.f5448q - f;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f5455x != null) {
            this.f5455x.recycle();
        }
    }

    /* renamed from: a */
    private void m5803a(int i, float f) {
        int i2 = this.f5435d;
        int alpha = Color.alpha(i2);
        int red = Color.red(i2);
        int green = Color.green(i2);
        int blue = Color.blue(i2);
        float f2 = 1.0f - f;
        this.f5411A.setColor(Color.argb((int) ((((float) alpha) * f2) + (((float) Color.alpha(i)) * f)), (int) ((((float) red) * f2) + (((float) Color.red(i)) * f)), (int) ((((float) green) * f2) + (((float) Color.green(i)) * f)), (int) ((((float) blue) * f2) + (((float) Color.blue(i)) * f))));
    }

    /* renamed from: a */
    public void mo16769a(int i, int i2) {
        this.f5441j = false;
        this.f5454w.forceFinished(true);
        this.f5454w.startScroll((int) this.f5416F, 0, (int) ((((float) i) * this.f5448q) - this.f5416F), 0, i2);
        invalidate();
    }

    public void setData(List<String> list, int i) {
        this.f5454w.forceFinished(true);
        this.f5440i = list;
        this.f5439h = list.size();
        this.f5421K = ((float) this.f5439h) * this.f5448q;
        setSelectNotDraw(i);
        invalidate();
    }

    public void setSelect(int i) {
        this.f5454w.forceFinished(true);
        setSelectNotDraw(i);
        invalidate();
    }

    private void setSelectNotDraw(int i) {
        if (i > this.f5439h) {
            this.f5447p = this.f5439h;
        } else if (i < 0) {
            this.f5447p = 0;
        } else {
            this.f5447p = i;
        }
        this.f5416F = ((float) this.f5447p) * this.f5448q;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setTotalMove(float r5) {
        /*
            r4 = this;
            android.widget.Scroller r0 = r4.f5454w
            r1 = 1
            r0.forceFinished(r1)
            r4.f5431U = r1
            r0 = 0
            r4.f5425O = r0
            r2 = 0
            int r3 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0019
            float r3 = r4.f5416F
            int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r3 == 0) goto L_0x0019
            r4.f5416F = r2
            goto L_0x0034
        L_0x0019:
            float r2 = r4.f5421K
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x002c
            float r2 = r4.f5416F
            float r3 = r4.f5421K
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x002c
            float r5 = r4.f5421K
            r4.f5416F = r5
            goto L_0x0034
        L_0x002c:
            float r2 = r4.f5416F
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0035
            r4.f5416F = r5
        L_0x0034:
            r0 = 1
        L_0x0035:
            if (r0 == 0) goto L_0x003a
            r4.invalidate()
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.HorizontalWheelView.setTotalMove(float):void");
    }

    public void setOnValueChangeListener(C1449a aVar) {
        this.f5412B = aVar;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        if (this.f5428R != -1) {
            bundle.putInt("selected", this.f5428R);
        } else {
            bundle.putInt("selected", this.f5447p);
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setSelect(bundle.getInt("selected"));
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setAllowScroll(boolean z) {
        this.f5420J = z;
    }

    public void setScaleDistance(float f) {
        this.f5448q = f;
        invalidate();
    }

    public float getScaleDistance() {
        return this.f5448q;
    }

    public void setSelectedColor(int i) {
        this.f5435d = i;
        invalidate();
    }

    public void setTextColor(int i) {
        this.f5436e = i;
    }

    public float getTotalMove() {
        return this.f5416F;
    }

    /* renamed from: f */
    private void m5814f() {
        if (this.f5429S) {
            setContentDescription(String.valueOf(this.f5447p));
            sendAccessibilityEvent(4);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(HorizontalWheelView.class.getName());
    }
}
