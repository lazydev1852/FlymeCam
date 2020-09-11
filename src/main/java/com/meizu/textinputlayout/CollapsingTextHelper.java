package com.meizu.textinputlayout;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* renamed from: com.meizu.textinputlayout.b */
public final class CollapsingTextHelper {

    /* renamed from: a */
    private static final boolean f16078a = (Build.VERSION.SDK_INT < 18);

    /* renamed from: b */
    private static final Paint f16079b = null;

    /* renamed from: A */
    private float f16080A;

    /* renamed from: B */
    private float f16081B;

    /* renamed from: C */
    private float f16082C;

    /* renamed from: D */
    private float f16083D;

    /* renamed from: E */
    private boolean f16084E;

    /* renamed from: F */
    private final TextPaint f16085F;

    /* renamed from: G */
    private Interpolator f16086G;

    /* renamed from: H */
    private Interpolator f16087H;

    /* renamed from: c */
    private final View f16088c;

    /* renamed from: d */
    private boolean f16089d;

    /* renamed from: e */
    private float f16090e;

    /* renamed from: f */
    private final Rect f16091f;

    /* renamed from: g */
    private final Rect f16092g;

    /* renamed from: h */
    private final RectF f16093h;

    /* renamed from: i */
    private int f16094i = 16;

    /* renamed from: j */
    private int f16095j = 16;

    /* renamed from: k */
    private float f16096k = 15.0f;

    /* renamed from: l */
    private float f16097l = 15.0f;

    /* renamed from: m */
    private int f16098m;

    /* renamed from: n */
    private int f16099n;

    /* renamed from: o */
    private float f16100o;

    /* renamed from: p */
    private float f16101p;

    /* renamed from: q */
    private float f16102q;

    /* renamed from: r */
    private float f16103r;

    /* renamed from: s */
    private float f16104s;

    /* renamed from: t */
    private float f16105t;

    /* renamed from: u */
    private CharSequence f16106u;

    /* renamed from: v */
    private CharSequence f16107v;

    /* renamed from: w */
    private boolean f16108w;

    /* renamed from: x */
    private boolean f16109x;

    /* renamed from: y */
    private Bitmap f16110y;

    /* renamed from: z */
    private Paint f16111z;

    static {
        if (f16079b != null) {
            f16079b.setAntiAlias(true);
            f16079b.setColor(-65281);
        }
    }

    public CollapsingTextHelper(View view) {
        this.f16088c = view;
        this.f16085F = new TextPaint();
        this.f16085F.setAntiAlias(true);
        this.f16092g = new Rect();
        this.f16091f = new Rect();
        this.f16093h = new RectF();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24646a(Interpolator interpolator) {
        this.f16087H = interpolator;
        mo24657e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo24652b(Interpolator interpolator) {
        this.f16086G = interpolator;
        mo24657e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24641a(float f) {
        if (this.f16096k != f) {
            this.f16096k = f;
            mo24657e();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24642a(int i) {
        if (this.f16099n != i) {
            this.f16099n = i;
            mo24657e();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo24650b(int i) {
        if (this.f16098m != i) {
            this.f16098m = i;
            mo24657e();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24643a(int i, int i2, int i3, int i4) {
        if (!m17438a(this.f16091f, i, i2, i3, i4)) {
            this.f16091f.set(i, i2, i3, i4);
            this.f16084E = true;
            mo24640a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo24651b(int i, int i2, int i3, int i4) {
        if (!m17438a(this.f16092g, i, i2, i3, i4)) {
            this.f16092g.set(i, i2, i3, i4);
            this.f16084E = true;
            mo24640a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24640a() {
        this.f16089d = this.f16092g.width() > 0 && this.f16092g.height() > 0 && this.f16091f.width() > 0 && this.f16091f.height() > 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo24654c(int i) {
        if (this.f16094i != i) {
            this.f16094i = i;
            mo24657e();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo24656d(int i) {
        if (this.f16095j != i) {
            this.f16095j = i;
            mo24657e();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo24658e(int i) {
        TypedArray obtainStyledAttributes = this.f16088c.getContext().obtainStyledAttributes(i, R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColor)) {
            this.f16099n = C2964d.m17468a(this.f16088c.getContext());
            if (this.f16099n == 0) {
                this.f16099n = -16776961;
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textSize)) {
            this.f16097l = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, (int) this.f16097l);
        }
        obtainStyledAttributes.recycle();
        mo24657e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24645a(Typeface typeface) {
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        if (this.f16085F.getTypeface() != typeface) {
            this.f16085F.setTypeface(typeface);
            mo24657e();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Typeface mo24648b() {
        return this.f16085F.getTypeface();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo24649b(float f) {
        float a = MathUtils.m17467a(f, 0.0f, 1.0f);
        if (a != this.f16090e) {
            this.f16090e = a;
            m17442h();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public float mo24653c() {
        return this.f16090e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public float mo24655d() {
        return this.f16097l;
    }

    /* renamed from: h */
    private void m17442h() {
        float f = this.f16090e;
        m17440c(f);
        this.f16104s = m17435a(this.f16102q, this.f16103r, f, this.f16086G);
        this.f16105t = m17435a(this.f16100o, this.f16101p, f, this.f16086G);
        m17441d(m17435a(this.f16096k, this.f16097l, f, this.f16087H));
        if (this.f16099n != this.f16098m) {
            this.f16085F.setColor(m17436a(this.f16098m, this.f16099n, f));
        } else {
            this.f16085F.setColor(this.f16099n);
        }
        ViewCompat.postInvalidateOnAnimation(this.f16088c);
    }

    /* renamed from: i */
    private void m17443i() {
        this.f16085F.setTextSize(this.f16097l);
        float f = 0.0f;
        float measureText = this.f16107v != null ? this.f16085F.measureText(this.f16107v, 0, this.f16107v.length()) : 0.0f;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f16095j, this.f16108w ? 1 : 0);
        int i = absoluteGravity & 112;
        if (i == 48) {
            this.f16101p = ((float) this.f16092g.top) - this.f16085F.ascent();
        } else if (i != 80) {
            this.f16101p = ((float) this.f16092g.centerY()) + (((this.f16085F.descent() - this.f16085F.ascent()) / 2.0f) - this.f16085F.descent());
        } else {
            this.f16101p = (float) this.f16092g.bottom;
        }
        int i2 = absoluteGravity & 7;
        if (i2 == 1) {
            this.f16103r = ((float) this.f16092g.centerX()) - (measureText / 2.0f);
        } else if (i2 != 5) {
            this.f16103r = (float) this.f16092g.left;
        } else {
            this.f16103r = ((float) this.f16092g.right) - measureText;
        }
        this.f16085F.setTextSize(this.f16096k);
        if (this.f16107v != null) {
            f = this.f16085F.measureText(this.f16107v, 0, this.f16107v.length());
        }
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.f16094i, this.f16108w ? 1 : 0);
        int i3 = absoluteGravity2 & 112;
        if (i3 == 48) {
            this.f16100o = ((float) this.f16091f.top) - this.f16085F.ascent();
        } else if (i3 != 80) {
            this.f16100o = ((float) this.f16091f.centerY()) + (((this.f16085F.descent() - this.f16085F.ascent()) / 2.0f) - this.f16085F.descent());
        } else {
            this.f16100o = (float) this.f16091f.bottom;
        }
        int i4 = absoluteGravity2 & 7;
        if (i4 == 1) {
            this.f16102q = ((float) this.f16091f.centerX()) - (f / 2.0f);
        } else if (i4 != 5) {
            this.f16102q = (float) this.f16091f.left;
        } else {
            this.f16102q = ((float) this.f16091f.right) - f;
        }
        m17445k();
    }

    /* renamed from: c */
    private void m17440c(float f) {
        this.f16093h.left = m17435a((float) this.f16091f.left, (float) this.f16092g.left, f, this.f16086G);
        this.f16093h.top = m17435a(this.f16100o, this.f16101p, f, this.f16086G);
        this.f16093h.right = m17435a((float) this.f16091f.right, (float) this.f16092g.right, f, this.f16086G);
        this.f16093h.bottom = m17435a((float) this.f16091f.bottom, (float) this.f16092g.bottom, f, this.f16086G);
    }

    /* renamed from: a */
    public void mo24644a(Canvas canvas) {
        float f;
        int save = canvas.save();
        if (this.f16107v != null && this.f16089d) {
            float f2 = this.f16104s;
            float f3 = this.f16105t;
            boolean z = this.f16109x && this.f16110y != null;
            this.f16085F.setTextSize(this.f16083D);
            if (z) {
                f = this.f16080A * this.f16082C;
                float f4 = this.f16081B;
                float f5 = this.f16082C;
            } else {
                f = this.f16085F.ascent() * this.f16082C;
                this.f16085F.descent();
                float f6 = this.f16082C;
            }
            if (z) {
                f3 += f;
            }
            float f7 = f3;
            if (this.f16082C != 1.0f) {
                canvas.scale(this.f16082C, this.f16082C, f2, f7);
            }
            if (z) {
                canvas.drawBitmap(this.f16110y, f2, f7, this.f16111z);
            } else {
                canvas.drawText(this.f16107v, 0, this.f16107v.length(), f2, f7, this.f16085F);
            }
        }
        canvas.restoreToCount(save);
    }

    /* renamed from: b */
    private boolean m17439b(CharSequence charSequence) {
        return ViewCompat.getLayoutDirection(this.f16088c) == 1;
    }

    /* renamed from: d */
    private void m17441d(float f) {
        float f2;
        float f3;
        boolean z;
        if (this.f16106u != null) {
            if (m17437a(f, this.f16097l)) {
                f2 = (float) this.f16092g.width();
                f3 = this.f16097l;
                this.f16082C = 1.0f;
            } else {
                float width = (float) this.f16091f.width();
                float f4 = this.f16096k;
                if (m17437a(f, this.f16096k)) {
                    this.f16082C = 1.0f;
                } else {
                    this.f16082C = f / this.f16096k;
                }
                f2 = width;
                f3 = f4;
            }
            boolean z2 = true;
            if (f2 > 0.0f) {
                z = this.f16083D != f3 || this.f16084E;
                this.f16083D = f3;
                this.f16084E = false;
            } else {
                z = false;
            }
            if (this.f16107v == null || z) {
                this.f16085F.setTextSize(this.f16083D);
                CharSequence ellipsize = TextUtils.ellipsize(this.f16106u, this.f16085F, f2, TextUtils.TruncateAt.END);
                if (this.f16107v == null || !this.f16107v.equals(ellipsize)) {
                    this.f16107v = ellipsize;
                }
                this.f16108w = m17439b(this.f16107v);
            }
            if (!f16078a || this.f16082C == 1.0f) {
                z2 = false;
            }
            this.f16109x = z2;
            if (this.f16109x) {
                m17444j();
            }
            ViewCompat.postInvalidateOnAnimation(this.f16088c);
        }
    }

    /* renamed from: j */
    private void m17444j() {
        if (this.f16110y == null && !this.f16091f.isEmpty() && !TextUtils.isEmpty(this.f16107v)) {
            this.f16085F.setTextSize(this.f16096k);
            this.f16085F.setColor(this.f16098m);
            this.f16080A = this.f16085F.ascent();
            this.f16081B = this.f16085F.descent();
            int round = Math.round(this.f16085F.measureText(this.f16107v, 0, this.f16107v.length()));
            int round2 = Math.round(this.f16081B - this.f16080A);
            if (round > 0 || round2 > 0) {
                this.f16110y = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                new Canvas(this.f16110y).drawText(this.f16107v, 0, this.f16107v.length(), 0.0f, ((float) round2) - this.f16085F.descent(), this.f16085F);
                if (this.f16111z == null) {
                    this.f16111z = new Paint(3);
                }
            }
        }
    }

    /* renamed from: e */
    public void mo24657e() {
        if (this.f16088c.getHeight() > 0 && this.f16088c.getWidth() > 0) {
            m17443i();
            m17442h();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24647a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f16106u)) {
            this.f16106u = charSequence;
            this.f16107v = null;
            m17445k();
            mo24657e();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public CharSequence mo24659f() {
        return this.f16106u;
    }

    /* renamed from: k */
    private void m17445k() {
        if (this.f16110y != null) {
            this.f16110y.recycle();
            this.f16110y = null;
        }
    }

    /* renamed from: a */
    private static boolean m17437a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo24660g() {
        return this.f16099n;
    }

    /* renamed from: a */
    private static int m17436a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((((float) Color.blue(i)) * f2) + (((float) Color.blue(i2)) * f)));
    }

    /* renamed from: a */
    private static float m17435a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return AnimationUtils.m17434a(f, f2, f3);
    }

    /* renamed from: a */
    private static boolean m17438a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
