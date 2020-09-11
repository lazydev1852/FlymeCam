package com.meizu.media.camera.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.OverScroller;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.p020ar.util.MsgConstants;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HorizontalPickerView extends View {

    /* renamed from: a */
    public static ChangeQuickRedirect f14618a;

    /* renamed from: b */
    private static final LogUtil.C2630a f14619b = new LogUtil.C2630a("HorPickerView");

    /* renamed from: A */
    private int f14620A;

    /* renamed from: B */
    private int f14621B;

    /* renamed from: C */
    private float f14622C;

    /* renamed from: D */
    private Paint f14623D;

    /* renamed from: E */
    private Paint f14624E;

    /* renamed from: F */
    private Paint f14625F;

    /* renamed from: G */
    private int f14626G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public float f14627H;

    /* renamed from: I */
    private int f14628I;

    /* renamed from: J */
    private int f14629J;

    /* renamed from: K */
    private int f14630K;

    /* renamed from: L */
    private int f14631L;

    /* renamed from: M */
    private C2702a f14632M;

    /* renamed from: N */
    private Drawable[] f14633N;

    /* renamed from: O */
    private Drawable[] f14634O;

    /* renamed from: P */
    private boolean f14635P;

    /* renamed from: Q */
    private boolean f14636Q;

    /* renamed from: R */
    private RectF f14637R;

    /* renamed from: S */
    private ValueAnimator f14638S;

    /* renamed from: c */
    private int f14639c;

    /* renamed from: d */
    private OverScroller f14640d;

    /* renamed from: e */
    private VelocityTracker f14641e;

    /* renamed from: f */
    private int f14642f;

    /* renamed from: g */
    private int f14643g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f14644h;

    /* renamed from: i */
    private List<Integer> f14645i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public List<String> f14646j;

    /* renamed from: k */
    private HashMap<Integer, Float> f14647k;

    /* renamed from: l */
    private float f14648l;

    /* renamed from: m */
    private float f14649m;

    /* renamed from: n */
    private float f14650n;

    /* renamed from: o */
    private float f14651o;

    /* renamed from: p */
    private int f14652p;

    /* renamed from: q */
    private float f14653q;

    /* renamed from: r */
    private float f14654r;

    /* renamed from: s */
    private float f14655s;

    /* renamed from: t */
    private float f14656t;

    /* renamed from: u */
    private float f14657u;

    /* renamed from: v */
    private int f14658v;

    /* renamed from: w */
    private boolean f14659w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f14660x;

    /* renamed from: y */
    private boolean f14661y;

    /* renamed from: z */
    private int f14662z;

    /* renamed from: com.meizu.media.camera.views.HorizontalPickerView$a */
    public interface C2702a {
        /* renamed from: a */
        void mo22515a(int i);
    }

    /* renamed from: a */
    private long m16447a(float f) {
        long j = (long) (((double) f) * 3.95d);
        if (j < 150) {
            return 150;
        }
        return j;
    }

    public HorizontalPickerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public HorizontalPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14648l = 15.0f;
        this.f14649m = -1.0f;
        this.f14650n = 2.0f;
        this.f14651o = 8.0f;
        this.f14652p = 1;
        this.f14653q = 18.0f;
        this.f14654r = 20.0f;
        this.f14655s = 24.0f;
        this.f14656t = 2.0f;
        this.f14657u = 14.0f;
        this.f14658v = 1;
        this.f14659w = true;
        this.f14660x = false;
        this.f14661y = false;
        this.f14662z = 0;
        this.f14620A = 0;
        this.f14636Q = true;
        this.f14637R = new RectF();
        m16449a(context, attributeSet);
    }

    /* renamed from: a */
    private void m16449a(Context context, AttributeSet attributeSet) {
        if (!PatchProxy.proxy(new Object[]{context, attributeSet}, this, f14618a, false, 8408, new Class[]{Context.class, AttributeSet.class}, Void.TYPE).isSupported) {
            this.f14640d = new OverScroller(context, new DecelerateInterpolator());
            this.f14640d.setFriction(0.009f);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HorizontalPickerView);
            this.f14659w = obtainStyledAttributes.getBoolean(0, this.f14659w);
            this.f14648l = obtainStyledAttributes.getDimension(8, (float) m16446a(context, this.f14648l));
            this.f14650n = obtainStyledAttributes.getDimension(9, (float) m16446a(context, this.f14650n));
            this.f14651o = obtainStyledAttributes.getDimension(5, (float) m16446a(context, this.f14651o));
            this.f14652p = obtainStyledAttributes.getColor(4, this.f14652p);
            this.f14657u = obtainStyledAttributes.getDimension(16, (float) m16446a(context, this.f14657u));
            this.f14658v = obtainStyledAttributes.getColor(14, this.f14658v);
            this.f14654r = obtainStyledAttributes.getDimension(15, (float) m16446a(context, this.f14654r));
            this.f14655s = obtainStyledAttributes.getDimension(1, (float) m16446a(context, this.f14655s));
            this.f14656t = obtainStyledAttributes.getDimension(2, (float) m16446a(context, this.f14656t));
            this.f14653q = obtainStyledAttributes.getDimension(3, (float) m16446a(context, this.f14653q));
            this.f14639c = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
            Typeface create = Typeface.create("SFDIN-bold", 0);
            this.f14623D = new Paint(1);
            this.f14623D.setTypeface(create);
            this.f14623D.setTextSize(this.f14657u);
            this.f14623D.setColor(this.f14658v);
            this.f14623D.setShadowLayer(2.0f, 0.0f, 1.0f, context.getResources().getColor(R.color.mz_mode_name_shadow_color));
            this.f14622C = m16444a(this.f14623D);
            this.f14624E = new Paint(1);
            this.f14624E.setStrokeWidth(this.f14650n);
            this.f14624E.setColor(this.f14652p);
            this.f14625F = new Paint(1);
            this.f14625F.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.f14625F.setTextSize((float) m16446a(getContext(), 13.0f));
            this.f14625F.setColor(this.f14658v);
            this.f14625F.setShadowLayer(2.0f, 0.0f, 1.0f, context.getResources().getColor(R.color.mz_mode_name_shadow_color));
            obtainStyledAttributes.recycle();
        }
    }

    public void setIntervalNumber(int i) {
        if (i > 0) {
            this.f14660x = true;
            this.f14620A = i;
            return;
        }
        this.f14660x = false;
        this.f14620A = i;
    }

    public void setIsSplit(boolean z) {
        this.f14661y = z;
    }

    /* renamed from: a */
    private int m16446a(Context context, float f) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, new Float(f)}, this, f14618a, false, 8409, new Class[]{Context.class, Float.TYPE}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    private float m16444a(Paint paint) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{paint}, this, f14618a, false, 8410, new Class[]{Paint.class}, Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.bottom - fontMetrics.top;
    }

    public void setTextColor(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14618a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8411, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14623D.setColor(i);
            invalidate();
        }
    }

    public void setTextSize(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f14618a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8412, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f14623D.setTextSize(f);
            invalidate();
        }
    }

    public void setTextMarginTop(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f14618a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8413, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f14654r = f;
            invalidate();
        }
    }

    public void setLineColor(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14618a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8414, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14624E.setColor(i);
            invalidate();
        }
    }

    public void setLineWidth(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f14618a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8415, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f14650n = f;
            invalidate();
        }
    }

    public void setLineSpaceWidth(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f14618a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8416, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f14649m = f;
            invalidate();
        }
    }

    public void setAlphaEnable(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14618a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8417, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f14659w = z;
            invalidate();
        }
    }

    public void setMaxValue(int i) {
        this.f14621B = i;
    }

    public void setValue(List<Integer> list, List<String> list2) {
        if (!PatchProxy.proxy(new Object[]{list, list2}, this, f14618a, false, 8418, new Class[]{List.class, List.class}, Void.TYPE).isSupported && list2 != null) {
            if (list == null) {
                this.f14645i = new ArrayList();
                for (int i = 0; i < list2.size(); i++) {
                    this.f14645i.add(Integer.valueOf(i));
                }
            } else {
                this.f14645i = list;
            }
            if (this.f14647k == null) {
                this.f14647k = new HashMap<>(this.f14645i.size());
            } else {
                this.f14647k.clear();
            }
            this.f14646j = list2;
            for (Integer intValue : this.f14645i) {
                int intValue2 = intValue.intValue();
                float measureText = this.f14623D.measureText(this.f14646j.get(intValue2));
                if (this.f14660x) {
                    this.f14647k.put(Integer.valueOf(intValue2 + (this.f14620A * intValue2)), Float.valueOf(measureText));
                } else {
                    this.f14647k.put(Integer.valueOf(intValue2), Float.valueOf(measureText));
                }
            }
            m16451a(list, list2);
        }
    }

    /* renamed from: a */
    private void m16451a(List<Integer> list, List<String> list2) {
        if (!PatchProxy.proxy(new Object[]{list, list2}, this, f14618a, false, 8419, new Class[]{List.class, List.class}, Void.TYPE).isSupported) {
            if (!this.f14660x) {
                this.f14649m = this.f14649m == -1.0f ? this.f14648l : this.f14649m;
            } else {
                this.f14649m = this.f14648l;
            }
            if (this.f14660x) {
                this.f14626G = (int) (-(((((float) (((this.f14646j.size() - 1) * this.f14620A) + this.f14646j.size())) * this.f14649m) + m16458d(-1)) - (this.f14647k.get(Integer.valueOf(this.f14647k.size() - 1)).floatValue() / 2.0f)));
            } else {
                this.f14626G = (int) (-((((float) (this.f14646j.size() - 1)) * this.f14649m) + m16458d(-1) + ((float) this.f14662z)));
            }
        }
    }

    public void setSelectorValue(String str) {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{str}, this, f14618a, false, 8420, new Class[]{String.class}, Void.TYPE).isSupported) {
            this.f14644h = str;
            if (!this.f14660x) {
                float d = (((float) (-this.f14646j.indexOf(this.f14644h))) * this.f14649m) - m16458d(this.f14646j.indexOf(this.f14644h));
                if (this.f14646j.indexOf(this.f14644h) != 0) {
                    i = this.f14662z;
                }
                this.f14627H = d - ((float) i);
            } else if (!this.f14661y) {
                this.f14627H = ((((float) this.f14626G) + (this.f14623D.measureText(this.f14646j.get(0)) / 2.0f)) * (Float.parseFloat(str) / ((float) this.f14621B))) - (this.f14623D.measureText(this.f14646j.get(0)) / 2.0f);
            } else if ("0".equals(str)) {
                this.f14627H = (-this.f14623D.measureText(this.f14646j.get(0))) / 2.0f;
            } else {
                this.f14627H = ((((((float) this.f14626G) + this.f14623D.measureText(this.f14646j.get(0))) + this.f14649m) * (Float.parseFloat(str) / ((float) this.f14621B))) - this.f14623D.measureText(this.f14646j.get(0))) - this.f14649m;
            }
        }
    }

    /* renamed from: a */
    public void mo22925a() {
        if (!PatchProxy.proxy(new Object[0], this, f14618a, false, 8421, new Class[0], Void.TYPE).isSupported) {
            invalidate();
            m16452a(false);
        }
    }

    public void setOnValueChangeListener(C2702a aVar) {
        this.f14632M = aVar;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)}, this, f14618a, false, 8422, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i > 0 && i2 > 0) {
                this.f14642f = i;
                this.f14643g = i2;
                if (this.f14646j != null) {
                    if (!this.f14660x) {
                        this.f14649m = this.f14649m == -1.0f ? this.f14648l : this.f14649m;
                        this.f14626G = (int) (-((((float) (this.f14646j.size() - 1)) * this.f14649m) + m16458d(-1) + ((float) this.f14662z)));
                    } else {
                        this.f14649m = this.f14648l;
                        this.f14626G = (int) (-(((((float) (((this.f14646j.size() - 1) * this.f14620A) + this.f14646j.size())) * this.f14649m) + m16458d(-1)) - (this.f14647k.get(Integer.valueOf(this.f14647k.size() - 1)).floatValue() / 2.0f)));
                    }
                    setSelectorValue(this.f14644h);
                    invalidate();
                }
            }
        }
    }

    public void draw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f14618a, false, 8423, new Class[]{Canvas.class}, Void.TYPE).isSupported && getVisibility() == 0) {
            super.draw(canvas);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x029c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r17) {
        /*
            r16 = this;
            r7 = r16
            r8 = r17
            r9 = 1
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r10 = 0
            r0[r10] = r8
            com.meizu.savior.ChangeQuickRedirect r2 = f14618a
            java.lang.Class[] r5 = new java.lang.Class[r9]
            java.lang.Class<android.graphics.Canvas> r1 = android.graphics.Canvas.class
            r5[r10] = r1
            java.lang.Class r6 = java.lang.Void.TYPE
            r3 = 0
            r4 = 8424(0x20e8, float:1.1805E-41)
            r1 = r16
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0022
            return
        L_0x0022:
            int r0 = r16.getVisibility()
            if (r0 == 0) goto L_0x0029
            return
        L_0x0029:
            super.onDraw(r17)
            int r0 = r7.f14642f
            int r0 = r0 / 2
            java.util.List<java.lang.String> r1 = r7.f14646j
            if (r1 != 0) goto L_0x0035
            return
        L_0x0035:
            java.util.List<java.lang.String> r1 = r7.f14646j
            int r1 = r1.size()
            int r1 = r1 - r9
            int r2 = r7.f14620A
            int r1 = r1 * r2
            java.util.List<java.lang.String> r2 = r7.f14646j
            int r2 = r2.size()
            int r1 = r1 + r2
            r3 = 0
            r4 = 0
        L_0x0049:
            if (r3 >= r1) goto L_0x02e1
            float r5 = (float) r0
            float r6 = r7.f14627H
            float r6 = r6 + r5
            float r11 = (float) r3
            float r12 = r7.f14649m
            float r11 = r11 * r12
            float r6 = r6 + r11
            float r6 = r6 + r4
            if (r3 != 0) goto L_0x005a
            r11 = 0
            goto L_0x005c
        L_0x005a:
            int r11 = r7.f14662z
        L_0x005c:
            float r11 = (float) r11
            float r6 = r6 + r11
            boolean r11 = r7.f14659w
            if (r11 == 0) goto L_0x0067
            float r5 = r6 - r5
            java.lang.Math.abs(r5)
        L_0x0067:
            boolean r5 = r7.f14660x
            r11 = 1073741824(0x40000000, float:2.0)
            if (r5 == 0) goto L_0x00b9
            if (r3 == 0) goto L_0x00c9
            int r5 = r7.f14620A
            int r5 = r5 * 10
            if (r3 < r5) goto L_0x009f
            java.util.List<java.lang.Integer> r5 = r7.f14645i
            int r12 = r7.f14620A
            int r12 = r12 * 10
            int r12 = r3 - r12
            int r13 = r7.f14620A
            int r12 = r12 % r13
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            boolean r5 = r5.contains(r12)
            if (r5 == 0) goto L_0x00b9
            int r5 = r7.f14620A
            int r5 = r5 * 10
            int r5 = r3 - r5
            int r12 = r7.f14620A
            int r5 = r5 / r12
            int r12 = r7.f14620A
            int r12 = r12 * 10
            int r12 = r3 - r12
            int r13 = r7.f14620A
            int r12 = r12 % r13
            if (r5 != r12) goto L_0x00b9
            goto L_0x00c9
        L_0x009f:
            java.util.List<java.lang.Integer> r5 = r7.f14645i
            int r12 = r7.f14620A
            int r12 = r3 % r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            boolean r5 = r5.contains(r12)
            if (r5 == 0) goto L_0x00b9
            int r5 = r7.f14620A
            int r5 = r3 / r5
            int r12 = r7.f14620A
            int r12 = r3 % r12
            if (r5 == r12) goto L_0x00c9
        L_0x00b9:
            boolean r5 = r7.f14660x
            if (r5 != 0) goto L_0x029f
            java.util.List<java.lang.Integer> r5 = r7.f14645i
            java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
            boolean r5 = r5.contains(r12)
            if (r5 == 0) goto L_0x029f
        L_0x00c9:
            boolean r5 = r7.f14660x
            if (r5 == 0) goto L_0x00f8
            int r5 = r7.f14620A
            int r5 = r5 * 10
            if (r3 < r5) goto L_0x00eb
            java.util.List<java.lang.String> r5 = r7.f14646j
            int r12 = r7.f14620A
            int r12 = r3 % r12
            int r13 = r7.f14620A
            int r13 = r13 * 10
            int r13 = r3 / r13
            int r14 = r7.f14620A
            int r13 = r13 * r14
            int r12 = r12 + r13
            java.lang.Object r5 = r5.get(r12)
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0100
        L_0x00eb:
            java.util.List<java.lang.String> r5 = r7.f14646j
            int r12 = r7.f14620A
            int r12 = r3 % r12
            java.lang.Object r5 = r5.get(r12)
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0100
        L_0x00f8:
            java.util.List<java.lang.String> r5 = r7.f14646j
            java.lang.Object r5 = r5.get(r3)
            java.lang.String r5 = (java.lang.String) r5
        L_0x0100:
            boolean r12 = r7.f14659w
            float r12 = r7.f14627H
            int r12 = r7.m16453b((float) r12)
            if (r12 != r3) goto L_0x0119
            android.graphics.Paint r13 = r7.f14623D
            int r14 = r7.f14652p
            r13.setColor(r14)
            android.graphics.Paint r13 = r7.f14625F
            int r14 = r7.f14652p
            r13.setColor(r14)
            goto L_0x0127
        L_0x0119:
            android.graphics.Paint r13 = r7.f14623D
            int r14 = r7.f14658v
            r13.setColor(r14)
            android.graphics.Paint r13 = r7.f14625F
            int r14 = r7.f14658v
            r13.setColor(r14)
        L_0x0127:
            android.graphics.drawable.Drawable[] r13 = r7.f14633N
            r14 = -1
            if (r13 == 0) goto L_0x01e5
            android.graphics.drawable.Drawable[] r13 = r7.f14634O
            if (r13 == 0) goto L_0x01e5
            if (r12 != r3) goto L_0x0137
            android.graphics.drawable.Drawable[] r12 = r7.f14634O
            r12 = r12[r3]
            goto L_0x013b
        L_0x0137:
            android.graphics.drawable.Drawable[] r12 = r7.f14633N
            r12 = r12[r3]
        L_0x013b:
            if (r12 == 0) goto L_0x01e5
            int r13 = r12.getIntrinsicWidth()
            float r13 = (float) r13
            float r13 = r13 + r6
            float r15 = r7.f14653q
            int r2 = r12.getIntrinsicHeight()
            float r2 = (float) r2
            float r15 = r15 + r2
            int r2 = (int) r6
            float r10 = r7.f14653q
            int r10 = (int) r10
            int r13 = (int) r13
            int r15 = (int) r15
            r12.setBounds(r2, r10, r13, r15)
            r12.draw(r8)
            int r2 = r12.getIntrinsicWidth()
            float r2 = (float) r2
            float r4 = r4 + r2
            boolean r2 = r7.f14635P
            if (r2 == 0) goto L_0x01e3
            java.util.HashMap<java.lang.Integer, java.lang.Float> r2 = r7.f14647k
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
            r2.remove(r10)
            java.util.HashMap<java.lang.Integer, java.lang.Float> r2 = r7.f14647k
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
            int r12 = r12.getIntrinsicWidth()
            float r12 = (float) r12
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            r2.put(r10, r12)
            int r2 = r1 + -1
            if (r3 != r2) goto L_0x01e3
            boolean r2 = r7.f14660x
            if (r2 == 0) goto L_0x01bf
            java.util.List<java.lang.String> r2 = r7.f14646j
            int r2 = r2.size()
            int r2 = r2 - r9
            int r10 = r7.f14620A
            int r2 = r2 * r10
            java.util.List<java.lang.String> r10 = r7.f14646j
            int r10 = r10.size()
            int r2 = r2 + r10
            float r2 = (float) r2
            float r10 = r7.f14649m
            float r2 = r2 * r10
            float r10 = r7.m16458d(r14)
            float r2 = r2 + r10
            java.util.HashMap<java.lang.Integer, java.lang.Float> r10 = r7.f14647k
            java.util.HashMap<java.lang.Integer, java.lang.Float> r12 = r7.f14647k
            int r12 = r12.size()
            int r12 = r12 - r9
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.Object r10 = r10.get(r12)
            java.lang.Float r10 = (java.lang.Float) r10
            float r10 = r10.floatValue()
            float r10 = r10 / r11
            float r2 = r2 - r10
            float r2 = -r2
            int r2 = (int) r2
            r7.f14626G = r2
        L_0x01bd:
            r2 = 0
            goto L_0x01d9
        L_0x01bf:
            java.util.List<java.lang.String> r2 = r7.f14646j
            int r2 = r2.size()
            int r2 = r2 - r9
            float r2 = (float) r2
            float r10 = r7.f14649m
            float r2 = r2 * r10
            float r10 = r7.m16458d(r14)
            float r2 = r2 + r10
            int r10 = r7.f14662z
            float r10 = (float) r10
            float r2 = r2 + r10
            float r2 = -r2
            int r2 = (int) r2
            r7.f14626G = r2
            goto L_0x01bd
        L_0x01d9:
            r7.f14635P = r2
            java.lang.String r2 = r7.f14644h
            r7.setSelectorValue(r2)
            r16.invalidate()
        L_0x01e3:
            r2 = 1
            goto L_0x01e6
        L_0x01e5:
            r2 = 0
        L_0x01e6:
            if (r2 != 0) goto L_0x029c
            android.graphics.Paint r2 = r7.f14623D
            float r2 = r2.measureText(r5)
            float r4 = r4 + r2
            android.content.res.Resources r2 = r16.getResources()
            r10 = 2131755123(0x7f100073, float:1.9141116E38)
            java.lang.String r2 = r2.getString(r10)
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x020e
            float r2 = r7.f14654r
            r10 = 0
            float r2 = r2 + r10
            float r12 = r7.f14622C
            float r12 = r12 / r11
            float r2 = r2 + r12
            android.graphics.Paint r12 = r7.f14625F
            r8.drawText(r5, r6, r2, r12)
            goto L_0x021b
        L_0x020e:
            r10 = 0
            float r2 = r7.f14654r
            float r2 = r2 + r10
            float r12 = r7.f14622C
            float r12 = r12 / r11
            float r2 = r2 + r12
            android.graphics.Paint r12 = r7.f14623D
            r8.drawText(r5, r6, r2, r12)
        L_0x021b:
            boolean r2 = r7.f14635P
            if (r2 == 0) goto L_0x029a
            java.util.HashMap<java.lang.Integer, java.lang.Float> r2 = r7.f14647k
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)
            android.graphics.Paint r12 = r7.f14623D
            float r5 = r12.measureText(r5)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r2.put(r6, r5)
            int r2 = r1 + -1
            if (r3 != r2) goto L_0x029a
            boolean r2 = r7.f14660x
            if (r2 == 0) goto L_0x0275
            java.util.List<java.lang.String> r2 = r7.f14646j
            int r2 = r2.size()
            int r2 = r2 - r9
            int r5 = r7.f14620A
            int r2 = r2 * r5
            java.util.List<java.lang.String> r5 = r7.f14646j
            int r5 = r5.size()
            int r2 = r2 + r5
            float r2 = (float) r2
            float r5 = r7.f14649m
            float r2 = r2 * r5
            float r5 = r7.m16458d(r14)
            float r2 = r2 + r5
            java.util.HashMap<java.lang.Integer, java.lang.Float> r5 = r7.f14647k
            java.util.HashMap<java.lang.Integer, java.lang.Float> r6 = r7.f14647k
            int r6 = r6.size()
            int r6 = r6 - r9
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r5 = r5.get(r6)
            java.lang.Float r5 = (java.lang.Float) r5
            float r5 = r5.floatValue()
            float r5 = r5 / r11
            float r2 = r2 - r5
            float r2 = -r2
            int r2 = (int) r2
            r7.f14626G = r2
        L_0x0273:
            r2 = 0
            goto L_0x028f
        L_0x0275:
            java.util.List<java.lang.String> r2 = r7.f14646j
            int r2 = r2.size()
            int r2 = r2 - r9
            float r2 = (float) r2
            float r5 = r7.f14649m
            float r2 = r2 * r5
            float r5 = r7.m16458d(r14)
            float r2 = r2 + r5
            int r5 = r7.f14662z
            float r5 = (float) r5
            float r2 = r2 + r5
            float r2 = -r2
            int r2 = (int) r2
            r7.f14626G = r2
            goto L_0x0273
        L_0x028f:
            r7.f14635P = r2
            java.lang.String r5 = r7.f14644h
            r7.setSelectorValue(r5)
            r16.invalidate()
            goto L_0x02dc
        L_0x029a:
            r2 = 0
            goto L_0x02dc
        L_0x029c:
            r2 = 0
            r10 = 0
            goto L_0x02dc
        L_0x029f:
            r2 = 0
            r10 = 0
            int r5 = r7.f14642f
            float r5 = (float) r5
            float r5 = r5 / r11
            float r5 = r6 - r5
            float r5 = java.lang.Math.abs(r5)
            float r12 = r7.f14656t
            int r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r5 > 0) goto L_0x02b9
            android.graphics.Paint r5 = r7.f14623D
            int r12 = r7.f14652p
            r5.setColor(r12)
            goto L_0x02c0
        L_0x02b9:
            android.graphics.Paint r5 = r7.f14623D
            int r12 = r7.f14658v
            r5.setColor(r12)
        L_0x02c0:
            android.graphics.RectF r5 = r7.f14637R
            float r12 = r7.f14656t
            float r12 = r12 / r11
            float r12 = r6 - r12
            float r13 = r7.f14655s
            float r14 = r7.f14656t
            float r14 = r14 / r11
            float r6 = r6 + r14
            float r11 = r7.f14655s
            float r14 = r7.f14656t
            float r11 = r11 + r14
            r5.set(r12, r13, r6, r11)
            android.graphics.RectF r5 = r7.f14637R
            android.graphics.Paint r6 = r7.f14623D
            r8.drawOval(r5, r6)
        L_0x02dc:
            int r3 = r3 + 1
            r10 = 0
            goto L_0x0049
        L_0x02e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.views.HorizontalPickerView.onDraw(android.graphics.Canvas):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14618a, false, 8425, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (getVisibility() != 0 || !this.f14636Q) {
            return false;
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        if (this.f14641e == null) {
            this.f14641e = VelocityTracker.obtain();
        }
        this.f14641e.addMovement(motionEvent);
        switch (action) {
            case 0:
                mo22927b();
                this.f14628I = x;
                this.f14630K = x;
                this.f14629J = 0;
                break;
            case 1:
                this.f14628I = 0;
                if (this.f14630K - x != 0) {
                    m16456c();
                    break;
                } else {
                    m16457c(x);
                    break;
                }
            case 2:
                this.f14629J = this.f14628I - x;
                m16459d();
                break;
            case 3:
                return false;
        }
        this.f14628I = x;
        return true;
    }

    /* renamed from: c */
    private void m16457c(int i) {
        int i2 = 0;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f14618a, false, 8426, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            final int b = m16453b(this.f14627H - ((float) (i - (this.f14642f / 2))));
            if ((this.f14660x && (b == 0 || (b < this.f14620A * 10 ? !(!this.f14645i.contains(Integer.valueOf(b % this.f14620A)) || b / this.f14620A != b % this.f14620A) : !(!this.f14645i.contains(Integer.valueOf((b - (this.f14620A * 10)) % this.f14620A)) || (b - (this.f14620A * 10)) / this.f14620A != (b - (this.f14620A * 10)) % this.f14620A)))) || (!this.f14660x && this.f14645i.contains(Integer.valueOf(b)))) {
                float[] fArr = new float[2];
                fArr[0] = this.f14627H;
                float d = (((float) (-b)) * this.f14649m) - m16458d(b);
                if (b != 0) {
                    i2 = this.f14662z;
                }
                fArr[1] = d - ((float) i2);
                this.f14638S = ValueAnimator.ofFloat(fArr);
                this.f14638S.setDuration(225);
                this.f14638S.setInterpolator(new PathInterpolator(0.16f, 0.0f, 0.33f, 1.0f));
                this.f14638S.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f14663a;

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (!PatchProxy.proxy(new Object[]{valueAnimator}, this, f14663a, false, 8442, new Class[]{ValueAnimator.class}, Void.TYPE).isSupported) {
                            float unused = HorizontalPickerView.this.f14627H = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            HorizontalPickerView.this.m16460e();
                            HorizontalPickerView.this.postInvalidate();
                        }
                    }
                });
                this.f14638S.addListener(new Animator.AnimatorListener() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f14665a;

                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (!PatchProxy.proxy(new Object[]{animator}, this, f14665a, false, 8443, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                            if (!HorizontalPickerView.this.f14660x) {
                                String unused = HorizontalPickerView.this.f14644h = (String) HorizontalPickerView.this.f14646j.get(b);
                            } else if (b != -1 && HorizontalPickerView.this.f14660x) {
                                HorizontalPickerView horizontalPickerView = HorizontalPickerView.this;
                                String unused2 = horizontalPickerView.f14644h = b + "";
                            }
                            HorizontalPickerView.this.m16460e();
                            HorizontalPickerView.this.invalidate();
                        }
                    }
                });
                this.f14638S.start();
            }
        }
    }

    /* renamed from: c */
    private void m16456c() {
        if (!PatchProxy.proxy(new Object[0], this, f14618a, false, 8427, new Class[0], Void.TYPE).isSupported) {
            this.f14640d.forceFinished(true);
            this.f14641e.computeCurrentVelocity(MsgConstants.TRACK_CLOSE_CLOUD_RECOGNITION);
            float xVelocity = this.f14641e.getXVelocity();
            if (Math.abs(xVelocity) > 1000.0f) {
                this.f14640d.fling(0, 0, (int) xVelocity, 0, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, 0);
            } else {
                mo22926a(getSelectedIndex());
            }
            this.f14631L = 0;
        }
    }

    /* renamed from: a */
    private void m16452a(boolean z) {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f14618a, false, 8428, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f14638S == null || !this.f14638S.isRunning()) {
                this.f14627H -= (float) this.f14629J;
                if (this.f14627H <= ((float) this.f14626G)) {
                    this.f14627H = (float) this.f14626G;
                } else if (this.f14627H >= (-this.f14647k.get(0).floatValue()) / 2.0f) {
                    this.f14627H = (-this.f14647k.get(0).floatValue()) / 2.0f;
                }
                this.f14628I = 0;
                this.f14631L = 0;
                this.f14629J = 0;
                int b = m16453b(this.f14627H);
                if (b != -1 && !this.f14660x) {
                    this.f14644h = this.f14646j.get(b);
                } else if (b != -1 && this.f14660x) {
                    this.f14644h = b + "";
                }
                if (z) {
                    float[] fArr = new float[2];
                    fArr[0] = this.f14627H;
                    float f = (float) (-b);
                    fArr[1] = ((this.f14649m * f) - m16458d(b)) - ((float) (b == 0 ? 0 : this.f14662z));
                    this.f14638S = ValueAnimator.ofFloat(fArr);
                    ValueAnimator valueAnimator = this.f14638S;
                    float f2 = this.f14627H;
                    float d = (f * this.f14649m) - m16458d(b);
                    if (b != 0) {
                        i = this.f14662z;
                    }
                    valueAnimator.setDuration(m16447a(Math.abs(f2 - (d - ((float) i)))));
                    this.f14638S.setInterpolator(new PathInterpolator(0.16f, 0.0f, 0.33f, 1.0f));
                    this.f14638S.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                        /* renamed from: a */
                        public static ChangeQuickRedirect f14668a;

                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (!PatchProxy.proxy(new Object[]{valueAnimator}, this, f14668a, false, 8444, new Class[]{ValueAnimator.class}, Void.TYPE).isSupported) {
                                float unused = HorizontalPickerView.this.f14627H = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                HorizontalPickerView.this.m16460e();
                                HorizontalPickerView.this.postInvalidate();
                            }
                        }
                    });
                    this.f14638S.start();
                    return;
                }
                float d2 = (((float) (-b)) * this.f14649m) - m16458d(b);
                if (b != 0) {
                    i = this.f14662z;
                }
                this.f14627H = d2 - ((float) i);
                m16460e();
                postInvalidate();
            }
        }
    }

    /* renamed from: d */
    private void m16459d() {
        if (!PatchProxy.proxy(new Object[0], this, f14618a, false, 8429, new Class[0], Void.TYPE).isSupported) {
            if (this.f14638S == null || !this.f14638S.isRunning()) {
                this.f14627H -= (float) this.f14629J;
                if (this.f14627H <= ((float) this.f14626G)) {
                    this.f14627H = (float) this.f14626G;
                    this.f14640d.forceFinished(true);
                } else if (this.f14627H >= (-this.f14647k.get(0).floatValue()) / 2.0f) {
                    this.f14627H = (-this.f14647k.get(0).floatValue()) / 2.0f;
                    this.f14640d.forceFinished(true);
                }
                int b = m16453b(this.f14627H);
                if (b != -1 && !this.f14660x) {
                    this.f14644h = this.f14646j.get(b);
                } else if (b != -1 && this.f14660x) {
                    this.f14644h = b + "";
                }
                m16460e();
                postInvalidate();
                this.f14629J = 0;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m16460e() {
        if (PatchProxy.proxy(new Object[0], this, f14618a, false, 8430, new Class[0], Void.TYPE).isSupported || this.f14632M == null) {
            return;
        }
        if (!this.f14660x) {
            this.f14632M.mo22515a(this.f14646j.indexOf(this.f14644h));
        } else if (this.f14661y) {
            float measureText = ((float) this.f14626G) + this.f14623D.measureText(this.f14646j.get(0)) + this.f14649m;
            if ((-this.f14627H) < this.f14623D.measureText(this.f14646j.get(0)) + (this.f14649m / 2.0f)) {
                this.f14632M.mo22515a(0);
                return;
            }
            int measureText2 = (int) (((((this.f14627H + this.f14623D.measureText(this.f14646j.get(0))) + this.f14649m) / measureText) * ((float) this.f14621B)) + 0.5f);
            C2702a aVar = this.f14632M;
            if (measureText2 == 0) {
                measureText2 = 1;
            }
            aVar.mo22515a(measureText2);
        } else {
            this.f14632M.mo22515a((int) ((((this.f14627H + (this.f14623D.measureText(this.f14646j.get(0)) / 2.0f)) / (((float) this.f14626G) + (this.f14623D.measureText(this.f14646j.get(0)) / 2.0f))) * ((float) this.f14621B)) + 0.5f));
        }
    }

    /* renamed from: b */
    private int m16453b(float f) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Float(f)}, this, f14618a, false, 8431, new Class[]{Float.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (f < ((float) this.f14626G)) {
            f = (float) this.f14626G;
        }
        int round = Math.round(Math.abs(f) / this.f14649m);
        int i = 0;
        while (i <= round) {
            float f2 = 0.0f;
            for (Integer intValue : this.f14647k.keySet()) {
                int intValue2 = intValue.intValue();
                if (intValue2 < i) {
                    f2 += this.f14647k.get(Integer.valueOf(intValue2)).floatValue();
                }
            }
            float f3 = ((((float) (-i)) * this.f14649m) - f2) - ((float) (i == 0 ? 0 : this.f14662z));
            if (this.f14647k.keySet().contains(Integer.valueOf(i))) {
                float f4 = (i == 1 ? ((float) this.f14662z) + (this.f14649m / 2.0f) : this.f14649m / 2.0f) + f3;
                if (f > (f3 - this.f14647k.get(Integer.valueOf(i)).floatValue()) - ((i == 0 ? ((float) this.f14662z) + this.f14649m : this.f14649m) / 2.0f) && f < f4) {
                    return i;
                }
            } else {
                float f5 = (this.f14649m / 2.0f) + f3;
                if (f > (f3 - (this.f14656t / 2.0f)) - (this.f14649m / 2.0f) && f < f5) {
                    return i;
                }
            }
            if (Math.abs(f3 - f) < this.f14649m / 2.0f) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: d */
    private float m16458d(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14618a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 8432, new Class[]{Integer.TYPE}, Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        float f = 0.0f;
        if (i == -1) {
            i = (((this.f14646j.size() - 1) * this.f14620A) + this.f14646j.size()) - 1;
        }
        for (Map.Entry next : this.f14647k.entrySet()) {
            if (((Integer) next.getKey()).intValue() < i) {
                f += ((Float) next.getValue()).floatValue();
            } else if (((Integer) next.getKey()).intValue() == i) {
                f += ((Float) next.getValue()).floatValue() / 2.0f;
            }
        }
        return f;
    }

    /* renamed from: a */
    public void mo22926a(final int i) {
        int i2 = 0;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f14618a, false, 8433, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            float[] fArr = new float[2];
            fArr[0] = this.f14627H;
            float f = (float) (-i);
            fArr[1] = ((this.f14649m * f) - m16458d(i)) - ((float) (i == 0 ? 0 : this.f14662z));
            this.f14638S = ValueAnimator.ofFloat(fArr);
            ValueAnimator valueAnimator = this.f14638S;
            float f2 = this.f14627H;
            float d = (f * this.f14649m) - m16458d(i);
            if (i != 0) {
                i2 = this.f14662z;
            }
            valueAnimator.setDuration(m16447a(Math.abs(f2 - (d - ((float) i2)))));
            this.f14638S.setInterpolator(new PathInterpolator(0.16f, 0.0f, 0.33f, 1.0f));
            this.f14638S.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14670a;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!PatchProxy.proxy(new Object[]{valueAnimator}, this, f14670a, false, 8445, new Class[]{ValueAnimator.class}, Void.TYPE).isSupported) {
                        float unused = HorizontalPickerView.this.f14627H = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        HorizontalPickerView.this.m16460e();
                        HorizontalPickerView.this.postInvalidate();
                    }
                }
            });
            this.f14638S.addListener(new Animator.AnimatorListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14672a;

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f14672a, false, 8446, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                        if (!HorizontalPickerView.this.f14660x) {
                            if (i >= HorizontalPickerView.this.f14646j.size()) {
                                String unused = HorizontalPickerView.this.f14644h = (String) HorizontalPickerView.this.f14646j.get(HorizontalPickerView.this.f14646j.size() - 1);
                            } else if (i >= 0) {
                                String unused2 = HorizontalPickerView.this.f14644h = (String) HorizontalPickerView.this.f14646j.get(i);
                            }
                        } else if (i != -1 && HorizontalPickerView.this.f14660x) {
                            HorizontalPickerView horizontalPickerView = HorizontalPickerView.this;
                            String unused3 = horizontalPickerView.f14644h = i + "";
                        }
                        HorizontalPickerView.this.m16460e();
                        HorizontalPickerView.this.invalidate();
                    }
                }
            });
            this.f14638S.start();
        }
    }

    /* renamed from: b */
    public void mo22928b(int i) {
        float f;
        int i2 = 0;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f14618a, false, 8434, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (!this.f14660x) {
                f = (((float) (-this.f14646j.indexOf(this.f14644h))) * this.f14649m) - m16458d(this.f14646j.indexOf(this.f14644h));
            } else if (this.f14661y) {
                float measureText = ((float) this.f14626G) + this.f14623D.measureText(this.f14646j.get(0)) + this.f14649m;
                if (i == 0) {
                    f = (-this.f14623D.measureText(this.f14646j.get(0))) / 2.0f;
                } else {
                    f = ((measureText * (((float) i) / ((float) this.f14621B))) - this.f14623D.measureText(this.f14646j.get(0))) - this.f14649m;
                }
            } else {
                f = ((((float) this.f14626G) + (this.f14623D.measureText(this.f14646j.get(0)) / 2.0f)) * (((float) i) / ((float) this.f14621B))) - (this.f14623D.measureText(this.f14646j.get(0)) / 2.0f);
            }
            final int b = m16453b(f);
            float[] fArr = new float[2];
            fArr[0] = this.f14627H;
            float d = (((float) (-b)) * this.f14649m) - m16458d(b);
            if (b != 0) {
                i2 = this.f14662z;
            }
            fArr[1] = d - ((float) i2);
            this.f14638S = ValueAnimator.ofFloat(fArr);
            this.f14638S.setDuration(225);
            this.f14638S.setInterpolator(new PathInterpolator(0.16f, 0.0f, 0.33f, 1.0f));
            this.f14638S.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14675a;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!PatchProxy.proxy(new Object[]{valueAnimator}, this, f14675a, false, 8447, new Class[]{ValueAnimator.class}, Void.TYPE).isSupported) {
                        float unused = HorizontalPickerView.this.f14627H = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        HorizontalPickerView.this.m16460e();
                        HorizontalPickerView.this.postInvalidate();
                    }
                }
            });
            this.f14638S.addListener(new Animator.AnimatorListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14677a;

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f14677a, false, 8448, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                        if (!HorizontalPickerView.this.f14660x) {
                            if (b >= HorizontalPickerView.this.f14646j.size()) {
                                String unused = HorizontalPickerView.this.f14644h = (String) HorizontalPickerView.this.f14646j.get(HorizontalPickerView.this.f14646j.size() - 1);
                            } else {
                                String unused2 = HorizontalPickerView.this.f14644h = (String) HorizontalPickerView.this.f14646j.get(b);
                            }
                        } else if (b != -1 && HorizontalPickerView.this.f14660x) {
                            HorizontalPickerView horizontalPickerView = HorizontalPickerView.this;
                            String unused3 = horizontalPickerView.f14644h = b + "";
                        }
                        HorizontalPickerView.this.m16460e();
                        HorizontalPickerView.this.invalidate();
                    }
                }
            });
            this.f14638S.start();
        }
    }

    /* renamed from: b */
    public void mo22927b() {
        if (!PatchProxy.proxy(new Object[0], this, f14618a, false, 8435, new Class[0], Void.TYPE).isSupported) {
            if (this.f14640d != null) {
                this.f14640d.forceFinished(true);
            }
            if (this.f14638S != null) {
                this.f14638S.cancel();
            }
        }
    }

    public int getSelectedIndex() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14618a, false, 8436, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : m16453b(this.f14627H);
    }

    public String getValue() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14618a, false, 8437, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        int b = m16453b(this.f14627H);
        if (b != -1 && !this.f14660x) {
            this.f14644h = this.f14646j.get(b);
        } else if (b != -1 && this.f14660x) {
            this.f14644h = b + "";
        }
        return this.f14644h;
    }

    public void setIconItems(ArrayList<Integer> arrayList) {
        if (!PatchProxy.proxy(new Object[]{arrayList}, this, f14618a, false, 8438, new Class[]{ArrayList.class}, Void.TYPE).isSupported) {
            if (arrayList == null || arrayList.size() == 0) {
                this.f14633N = null;
                return;
            }
            this.f14633N = new Drawable[this.f14645i.size()];
            for (int i = 0; i < this.f14645i.size(); i++) {
                if (arrayList.get(i).intValue() == -1) {
                    this.f14633N[i] = null;
                } else {
                    this.f14633N[i] = getResources().getDrawable(arrayList.get(i).intValue());
                }
            }
            this.f14635P = true;
        }
    }

    public void setIconSelectedItems(ArrayList<Integer> arrayList) {
        if (!PatchProxy.proxy(new Object[]{arrayList}, this, f14618a, false, 8439, new Class[]{ArrayList.class}, Void.TYPE).isSupported) {
            if (arrayList == null || arrayList.size() == 0) {
                this.f14633N = null;
                return;
            }
            this.f14634O = new Drawable[this.f14645i.size()];
            for (int i = 0; i < this.f14645i.size(); i++) {
                if (arrayList.get(i).intValue() == -1) {
                    this.f14634O[i] = null;
                } else {
                    this.f14634O[i] = getResources().getDrawable(arrayList.get(i).intValue());
                }
            }
        }
    }

    public void computeScroll() {
        if (!PatchProxy.proxy(new Object[0], this, f14618a, false, 8440, new Class[0], Void.TYPE).isSupported) {
            super.computeScroll();
            if (!this.f14640d.computeScrollOffset()) {
                return;
            }
            if (this.f14640d.getCurrX() == this.f14640d.getFinalX()) {
                m16452a(true);
                return;
            }
            int currX = this.f14640d.getCurrX();
            this.f14629J = this.f14631L - currX;
            m16459d();
            this.f14631L = currX;
        }
    }

    public void setVisibility(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14618a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8441, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            super.setVisibility(i);
        }
    }

    public void setAutoOffset(int i) {
        this.f14662z = i;
    }

    public void setEnable(boolean z) {
        this.f14636Q = z;
    }
}
