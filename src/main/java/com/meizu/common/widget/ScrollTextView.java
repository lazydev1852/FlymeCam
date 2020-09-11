package com.meizu.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.view.ViewCompat;
import com.meizu.common.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ScrollTextView extends View {

    /* renamed from: G */
    private static Field f6009G = null;

    /* renamed from: b */
    private static String f6010b = "ScrollTextView";

    /* renamed from: A */
    private float f6011A;

    /* renamed from: B */
    private float f6012B;

    /* renamed from: C */
    private List<Float> f6013C;

    /* renamed from: D */
    private List<Integer> f6014D;

    /* renamed from: E */
    private boolean f6015E;

    /* renamed from: F */
    private C1506j f6016F;

    /* renamed from: H */
    private List<C1498c> f6017H;

    /* renamed from: I */
    private List<C1500e> f6018I;

    /* renamed from: J */
    private List<C1499d> f6019J;

    /* renamed from: K */
    private Context f6020K;

    /* renamed from: L */
    private C1505i f6021L;

    /* renamed from: a */
    boolean f6022a;

    /* renamed from: c */
    private Paint f6023c;

    /* renamed from: d */
    private int f6024d;

    /* renamed from: e */
    private int f6025e;

    /* renamed from: f */
    private float f6026f;

    /* renamed from: g */
    private float f6027g;

    /* renamed from: h */
    private int f6028h;

    /* renamed from: i */
    private int f6029i;

    /* renamed from: j */
    private float f6030j;

    /* renamed from: k */
    private float f6031k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C1503h f6032l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f6033m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f6034n;

    /* renamed from: o */
    private int f6035o;

    /* renamed from: p */
    private int f6036p;

    /* renamed from: q */
    private C1510k f6037q;

    /* renamed from: r */
    private int f6038r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public C1502g f6039s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C1497b f6040t;

    /* renamed from: u */
    private Shader f6041u;

    /* renamed from: v */
    private Matrix f6042v;

    /* renamed from: w */
    private Paint f6043w;

    /* renamed from: x */
    private float f6044x;

    /* renamed from: y */
    private boolean f6045y;

    /* renamed from: z */
    private float f6046z;

    /* renamed from: com.meizu.common.widget.ScrollTextView$b */
    public interface C1497b {
        /* renamed from: a */
        void mo16383a(View view, int i, int i2);

        /* renamed from: c */
        String mo16387c(int i);
    }

    /* renamed from: com.meizu.common.widget.ScrollTextView$c */
    public interface C1498c {
        /* renamed from: a */
        void mo17245a(ScrollTextView scrollTextView, int i, int i2);
    }

    /* renamed from: com.meizu.common.widget.ScrollTextView$d */
    public interface C1499d {
        /* renamed from: a */
        void mo17246a(ScrollTextView scrollTextView, int i);
    }

    /* renamed from: com.meizu.common.widget.ScrollTextView$e */
    public interface C1500e {
        /* renamed from: a */
        void mo16370a(ScrollTextView scrollTextView);

        /* renamed from: b */
        void mo16374b(ScrollTextView scrollTextView);
    }

    /* renamed from: com.meizu.common.widget.ScrollTextView$i */
    private interface C1505i {
        /* renamed from: a */
        void mo17240a();

        /* renamed from: a */
        void mo17241a(int i);

        /* renamed from: b */
        void mo17242b();

        /* renamed from: c */
        void mo17243c();
    }

    public ScrollTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6023c = new Paint(1);
        this.f6024d = 0;
        this.f6025e = 5;
        this.f6026f = 0.0f;
        this.f6027g = 0.0f;
        this.f6022a = false;
        this.f6045y = true;
        this.f6015E = true;
        this.f6017H = new LinkedList();
        this.f6018I = new LinkedList();
        this.f6019J = new LinkedList();
        this.f6021L = new C1505i() {
            /* renamed from: a */
            public void mo17240a() {
                boolean unused = ScrollTextView.this.f6033m = true;
                ScrollTextView.this.mo17187a();
            }

            /* renamed from: a */
            public void mo17241a(int i) {
                ScrollTextView.this.m6022e(i);
                int height = ScrollTextView.this.getHeight();
                if (ScrollTextView.this.f6034n > height) {
                    int unused = ScrollTextView.this.f6034n = height;
                    ScrollTextView.this.f6032l.mo17252a();
                    return;
                }
                int i2 = -height;
                if (ScrollTextView.this.f6034n < i2) {
                    int unused2 = ScrollTextView.this.f6034n = i2;
                    ScrollTextView.this.f6032l.mo17252a();
                }
            }

            /* renamed from: b */
            public void mo17242b() {
                if (ScrollTextView.this.f6033m) {
                    ScrollTextView.this.mo17193b();
                    boolean unused = ScrollTextView.this.f6033m = false;
                }
                int unused2 = ScrollTextView.this.f6034n = 0;
                ScrollTextView.this.invalidate();
            }

            /* renamed from: c */
            public void mo17243c() {
                int i;
                if (!ScrollTextView.this.f6022a && ScrollTextView.this.getCurrentItem() < ScrollTextView.this.f6039s.mo17250b()) {
                    ScrollTextView.this.mo17200d(ScrollTextView.this.f6039s.mo17250b() - ScrollTextView.this.getCurrentItem(), 0);
                } else if (!ScrollTextView.this.f6022a && ScrollTextView.this.getCurrentItem() > ScrollTextView.this.f6039s.mo17251c()) {
                    ScrollTextView.this.mo17200d(ScrollTextView.this.f6039s.mo17251c() - ScrollTextView.this.getCurrentItem(), 0);
                } else if (Math.abs(ScrollTextView.this.f6034n) > 1) {
                    if (ScrollTextView.this.f6034n > 0) {
                        i = (-ScrollTextView.this.getItemHeight()) + ScrollTextView.this.f6034n;
                    } else {
                        i = ScrollTextView.this.f6034n < 0 ? ScrollTextView.this.getItemHeight() + ScrollTextView.this.f6034n : 0;
                    }
                    ScrollTextView.this.f6032l.mo17253a(i, 0);
                }
            }
        };
        m6010a(context);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollTextView(Context context) {
        super(context);
        this.f6023c = new Paint(1);
        this.f6024d = 0;
        this.f6025e = 5;
        this.f6026f = 0.0f;
        this.f6027g = 0.0f;
        this.f6022a = false;
        this.f6045y = true;
        this.f6015E = true;
        this.f6017H = new LinkedList();
        this.f6018I = new LinkedList();
        this.f6019J = new LinkedList();
        this.f6021L = new C1505i() {
            /* renamed from: a */
            public void mo17240a() {
                boolean unused = ScrollTextView.this.f6033m = true;
                ScrollTextView.this.mo17187a();
            }

            /* renamed from: a */
            public void mo17241a(int i) {
                ScrollTextView.this.m6022e(i);
                int height = ScrollTextView.this.getHeight();
                if (ScrollTextView.this.f6034n > height) {
                    int unused = ScrollTextView.this.f6034n = height;
                    ScrollTextView.this.f6032l.mo17252a();
                    return;
                }
                int i2 = -height;
                if (ScrollTextView.this.f6034n < i2) {
                    int unused2 = ScrollTextView.this.f6034n = i2;
                    ScrollTextView.this.f6032l.mo17252a();
                }
            }

            /* renamed from: b */
            public void mo17242b() {
                if (ScrollTextView.this.f6033m) {
                    ScrollTextView.this.mo17193b();
                    boolean unused = ScrollTextView.this.f6033m = false;
                }
                int unused2 = ScrollTextView.this.f6034n = 0;
                ScrollTextView.this.invalidate();
            }

            /* renamed from: c */
            public void mo17243c() {
                int i;
                if (!ScrollTextView.this.f6022a && ScrollTextView.this.getCurrentItem() < ScrollTextView.this.f6039s.mo17250b()) {
                    ScrollTextView.this.mo17200d(ScrollTextView.this.f6039s.mo17250b() - ScrollTextView.this.getCurrentItem(), 0);
                } else if (!ScrollTextView.this.f6022a && ScrollTextView.this.getCurrentItem() > ScrollTextView.this.f6039s.mo17251c()) {
                    ScrollTextView.this.mo17200d(ScrollTextView.this.f6039s.mo17251c() - ScrollTextView.this.getCurrentItem(), 0);
                } else if (Math.abs(ScrollTextView.this.f6034n) > 1) {
                    if (ScrollTextView.this.f6034n > 0) {
                        i = (-ScrollTextView.this.getItemHeight()) + ScrollTextView.this.f6034n;
                    } else {
                        i = ScrollTextView.this.f6034n < 0 ? ScrollTextView.this.getItemHeight() + ScrollTextView.this.f6034n : 0;
                    }
                    ScrollTextView.this.f6032l.mo17253a(i, 0);
                }
            }
        };
        m6010a(context);
    }

    /* renamed from: a */
    private void m6010a(Context context) {
        this.f6020K = context;
        this.f6013C = new ArrayList();
        this.f6032l = new C1503h(getContext(), this.f6021L);
        this.f6031k = context.getResources().getDimension(R.dimen.mc_picker_selected_number_size);
        this.f6030j = context.getResources().getDimension(R.dimen.mc_picker_normal_number_size);
        this.f6026f = context.getResources().getDimension(R.dimen.mc_picker_select_item_height);
        this.f6027g = context.getResources().getDimension(R.dimen.mc_picker_normal_item_height);
        this.f6028h = context.getResources().getColor(R.color.mc_picker_selected_color);
        this.f6029i = context.getResources().getColor(R.color.mc_picker_unselected_color);
        setTextPreference(this.f6031k, this.f6030j, this.f6026f, this.f6027g);
        setTextColor(this.f6028h, this.f6029i);
        this.f6039s = new C1502g(this);
        this.f6042v = new Matrix();
        this.f6041u = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP);
        this.f6043w = new Paint();
        this.f6043w.setShader(this.f6041u);
        this.f6044x = context.getResources().getDimension(R.dimen.mc_picker_fading_height);
        this.f6037q = new C1510k(this);
        this.f6023c.setTextAlign(Paint.Align.CENTER);
        m6025f();
        this.f6016F = new C1506j();
        mo17191a((C1498c) new C1501f());
        mo17191a((C1498c) new C1511l());
    }

    /* renamed from: a */
    public void mo17188a(int i) {
        mo17190a(i, this.f6024d, 0, i - 1);
    }

    /* renamed from: a */
    public void mo17189a(int i, int i2) {
        this.f6024d += i2;
        mo17190a(i, this.f6024d, 0, i - 1);
    }

    /* renamed from: b */
    public void mo17194b(int i) {
        mo17190a(this.f6039s.mo17247a(), i, this.f6039s.mo17250b(), this.f6039s.mo17251c());
    }

    /* renamed from: b */
    public void mo17195b(int i, int i2) {
        mo17190a(i, i2, 0, i - 1);
    }

    /* renamed from: a */
    public void mo17190a(int i, int i2, int i3, int i4) {
        mo17199d();
        if (i >= 0) {
            setViewAdapter(this.f6039s.mo17248a(i, i3, i4));
            int i5 = this.f6024d;
            if (i2 != this.f6024d) {
                this.f6024d = Math.max(i2, i3);
                if (this.f6024d > i4 || this.f6024d >= i) {
                    this.f6024d = Math.min(i4, i);
                }
            }
            if (!(i5 == this.f6024d || this.f6040t == null)) {
                this.f6040t.mo16383a(this, i5, this.f6024d);
            }
            invalidate();
        }
    }

    public void setData(C1497b bVar, int i, int i2, int i3) {
        setData(bVar, -1.0f, i, i2, i3, 0, i2 - 1, true);
    }

    public void setData(C1497b bVar, float f, int i, int i2, int i3, int i4, int i5, boolean z) {
        setIDataAdapter(bVar);
        this.f6025e = i3;
        this.f6022a = z;
        if (f == -1.0f) {
            this.f6035o = getResources().getDimensionPixelSize(R.dimen.mc_picker_offset_y);
        } else {
            this.f6035o = (int) (f * getContext().getResources().getDisplayMetrics().density);
        }
        if (i2 < this.f6025e || i5 + 1 < i2 || i4 > 0) {
            this.f6022a = false;
        }
        mo17190a(i2, i, i4, i5);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f6032l.mo17254a(interpolator);
    }

    public int getVisibleItems() {
        return this.f6025e;
    }

    public void setVisibleItems(int i) {
        this.f6025e = i;
    }

    public C1502g getViewAdapter() {
        return this.f6039s;
    }

    private void setViewAdapter(C1502g gVar) {
        this.f6039s = gVar;
        invalidate();
    }

    /* renamed from: a */
    public void mo17191a(C1498c cVar) {
        this.f6017H.add(cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo17197c(int i, int i2) {
        for (C1498c a : this.f6017H) {
            a.mo17245a(this, i, i2);
        }
    }

    /* renamed from: a */
    public void mo17192a(C1500e eVar) {
        this.f6018I.add(eVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo17187a() {
        for (C1500e a : this.f6018I) {
            a.mo16370a(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo17193b() {
        if (this.f6040t != null) {
            this.f6040t.mo16383a(this, 0, getCurrentItem());
        }
        for (C1500e b : this.f6018I) {
            b.mo16374b(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo17196c(int i) {
        setCurrentItem(i, true);
        for (C1499d a : this.f6019J) {
            a.mo17246a(this, i);
        }
    }

    public int getCurrentItem() {
        return this.f6024d;
    }

    public void setCurrentItem(int i, boolean z) {
        int min;
        if (this.f6039s != null && this.f6039s.mo17247a() != 0) {
            int a = this.f6039s.mo17247a();
            if (i < 0 || i >= a) {
                if (this.f6022a) {
                    while (i < 0) {
                        i += a;
                    }
                    i %= a;
                } else {
                    return;
                }
            }
            if (i == this.f6024d) {
                return;
            }
            if (z) {
                int i2 = i - this.f6024d;
                if (this.f6022a && (min = (a + Math.min(i, this.f6024d)) - Math.max(i, this.f6024d)) < Math.abs(i2)) {
                    i2 = i2 < 0 ? min : -min;
                }
                mo17200d(i2, 0);
                return;
            }
            this.f6034n = 0;
            int i3 = this.f6024d;
            this.f6024d = i;
            mo17197c(i3, this.f6024d);
            invalidate();
        }
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    /* renamed from: c */
    public boolean mo17198c() {
        return this.f6022a;
    }

    public void setCyclic(boolean z) {
        this.f6022a = z;
        invalidate();
    }

    /* access modifiers changed from: private */
    public int getItemHeight() {
        return (int) this.f6027g;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(i, (int) ((((float) (this.f6025e - 1)) * this.f6027g) + this.f6026f));
    }

    public void setHorizontalOffset(int i) {
        this.f6036p = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f6039s != null && this.f6039s.mo17247a() > 0) {
            m6023e();
            m6017b(canvas);
        }
        if (this.f6045y) {
            m6011a(canvas);
        }
    }

    /* renamed from: a */
    private void m6011a(Canvas canvas) {
        this.f6042v.setScale(1.0f, this.f6044x);
        this.f6041u.setLocalMatrix(this.f6042v);
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), this.f6044x, this.f6043w);
        this.f6042v.setScale(1.0f, this.f6044x);
        this.f6042v.postRotate(180.0f);
        this.f6042v.postTranslate(0.0f, (float) getHeight());
        this.f6041u.setLocalMatrix(this.f6042v);
        canvas.drawRect(0.0f, ((float) getHeight()) - this.f6044x, (float) getWidth(), (float) getHeight(), this.f6043w);
    }

    /* renamed from: b */
    private void m6017b(Canvas canvas) {
        int i;
        float itemHeight = (float) (((-(((this.f6024d - this.f6038r) * getItemHeight()) + ((((int) this.f6026f) - getHeight()) / 2))) + this.f6034n) - getItemHeight());
        canvas.translate((float) this.f6036p, itemHeight);
        if (this.f6034n > 0) {
            i = this.f6034n;
        } else {
            i = getItemHeight() + this.f6034n;
        }
        float itemHeight2 = (((float) i) * 1.0f) / ((float) getItemHeight());
        for (int i2 = 0; i2 < this.f6037q.mo17269c(); i2++) {
            float a = m6008a(i2, itemHeight2);
            canvas.translate(0.0f, a);
            itemHeight += a;
            canvas.drawText(m6020d(i2), (float) (getWidth() / 2), (this.f6027g / 2.0f) - this.f6012B, this.f6023c);
        }
        canvas.translate(0.0f, -itemHeight);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m6020d(int r3) {
        /*
            r2 = this;
            int r0 = r2.f6038r
            int r3 = r3 + r0
            com.meizu.common.widget.ScrollTextView$g r0 = r2.f6039s
            java.lang.String r0 = r0.mo17249a(r3)
            if (r3 >= 0) goto L_0x0021
            com.meizu.common.widget.ScrollTextView$g r0 = r2.f6039s
            int r0 = r0.mo17247a()
            int r0 = r0 + r3
            boolean r3 = r2.f6022a
            if (r3 == 0) goto L_0x001e
            com.meizu.common.widget.ScrollTextView$g r3 = r2.f6039s
            java.lang.String r3 = r3.mo17249a(r0)
        L_0x001c:
            r0 = r3
            goto L_0x003e
        L_0x001e:
            java.lang.String r3 = ""
            goto L_0x001c
        L_0x0021:
            com.meizu.common.widget.ScrollTextView$g r1 = r2.f6039s
            int r1 = r1.mo17247a()
            if (r3 < r1) goto L_0x003e
            com.meizu.common.widget.ScrollTextView$g r0 = r2.f6039s
            int r0 = r0.mo17247a()
            int r3 = r3 - r0
            boolean r0 = r2.f6022a
            if (r0 == 0) goto L_0x003b
            com.meizu.common.widget.ScrollTextView$g r0 = r2.f6039s
            java.lang.String r3 = r0.mo17249a(r3)
            goto L_0x001c
        L_0x003b:
            java.lang.String r3 = ""
            goto L_0x001c
        L_0x003e:
            if (r0 != 0) goto L_0x0042
            java.lang.String r0 = ""
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.ScrollTextView.m6020d(int):java.lang.String");
    }

    /* renamed from: a */
    private float m6008a(int i, float f) {
        float itemHeight = (float) getItemHeight();
        int i2 = (int) (this.f6026f - this.f6027g);
        int i3 = this.f6025e / 2;
        if (i >= i3) {
            if (i == i3) {
                itemHeight += (((float) i2) * f) / 2.0f;
            } else if (i == i3 + 1) {
                itemHeight += (float) (i2 / 2);
                f = 1.0f - f;
            } else if (i == i3 + 2) {
                f = 1.0f - f;
                itemHeight += (((float) i2) * f) / 2.0f;
            } else {
                f = 1.0f - f;
            }
        }
        m6016b(i, f);
        return itemHeight;
    }

    /* renamed from: b */
    private void m6016b(int i, float f) {
        float f2;
        float f3;
        int i2;
        int i3;
        int i4 = this.f6025e / 2;
        int i5 = this.f6028h;
        int i6 = this.f6029i;
        float f4 = this.f6031k;
        float f5 = this.f6030j;
        if (i < i4 || i > i4 + 1) {
            this.f6012B = this.f6011A;
        } else {
            this.f6012B = this.f6011A + ((this.f6046z - this.f6011A) * f);
        }
        if (i > i4) {
            i = this.f6025e - i;
        }
        if (i > i4) {
            i = i4;
        }
        if (i < 0) {
            i = 0;
        }
        if (i == 0) {
            int intValue = this.f6014D.get(i).intValue();
            int intValue2 = this.f6014D.get(i).intValue();
            float floatValue = this.f6013C.get(i).floatValue();
            f2 = this.f6013C.get(i).floatValue();
            f3 = floatValue;
            i2 = intValue2;
            i3 = intValue;
            f = 0.0f;
        } else if (i < i4) {
            i3 = this.f6014D.get(i).intValue();
            int i7 = i - 1;
            i2 = this.f6014D.get(i7).intValue();
            float floatValue2 = this.f6013C.get(i).floatValue();
            float floatValue3 = this.f6013C.get(i7).floatValue();
            f3 = floatValue2;
            f2 = floatValue3;
        } else {
            i3 = this.f6028h;
            int i8 = i - 1;
            i2 = this.f6014D.get(i8).intValue();
            f3 = this.f6031k;
            f2 = this.f6013C.get(i8).floatValue();
        }
        int alpha = Color.alpha(i3);
        int red = Color.red(i3);
        int green = Color.green(i3);
        int blue = Color.blue(i3);
        int alpha2 = Color.alpha(i2);
        int red2 = Color.red(i2);
        int green2 = Color.green(i2);
        int blue2 = Color.blue(i2);
        this.f6023c.setColor(Color.argb(alpha2 + ((int) (((float) (alpha - alpha2)) * f)), red2 + ((int) (((float) (red - red2)) * f)), green2 + ((int) (((float) (green - green2)) * f)), blue2 + ((int) (((float) (blue - blue2)) * f))));
        this.f6023c.setTextSize(f2 + ((f3 - f2) * f));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        if (!isEnabled() || getViewAdapter() == null) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 1:
                if (!this.f6033m) {
                    int y = ((int) motionEvent.getY()) - (getHeight() / 2);
                    if (y < 0) {
                        i = (int) (((float) y) + ((this.f6026f / 2.0f) - ((float) getItemHeight())));
                    } else {
                        i = (int) (((float) y) - ((this.f6026f / 2.0f) - ((float) getItemHeight())));
                    }
                    int itemHeight = i / getItemHeight();
                    if (itemHeight != 0 && m6026f(this.f6024d + itemHeight)) {
                        mo17196c(this.f6024d + itemHeight);
                        break;
                    }
                }
                break;
            case 2:
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(this.f6015E);
                    break;
                }
                break;
        }
        return this.f6032l.mo17255a(motionEvent);
    }

    /* access modifiers changed from: private */
    public int getYScrollEnd() {
        if (this.f6022a) {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        return this.f6034n + ((int) (((float) (getScrollEndItem() - getCurrentItem())) * this.f6027g));
    }

    /* access modifiers changed from: private */
    public int getYScrollStart() {
        if (this.f6022a) {
            return -2147483647;
        }
        return this.f6034n + ((int) (((float) (getScrollStartItem() - getCurrentItem())) * this.f6027g));
    }

    private int getScrollEndItem() {
        int a = this.f6039s.mo17247a();
        if (this.f6022a) {
            return 0;
        }
        return a <= this.f6025e ? a - 1 : a - 1;
    }

    private int getScrollStartItem() {
        int a = this.f6039s.mo17247a();
        if (this.f6022a) {
            return 0;
        }
        int i = this.f6025e;
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m6022e(int i) {
        if (!mo17198c()) {
            if (this.f6024d == getScrollStartItem() && i > 0) {
                return;
            }
            if (this.f6024d == getScrollEndItem() && i < 0) {
                return;
            }
        }
        int a = this.f6039s.mo17247a();
        if (a == 1) {
            this.f6034n = 0;
        } else {
            this.f6034n += i;
        }
        int itemHeight = getItemHeight();
        int i2 = this.f6034n / itemHeight;
        int i3 = this.f6024d - i2;
        if (this.f6022a && a > 0) {
            while (i3 < 0) {
                i3 += a;
            }
            i3 %= a;
        } else if (i3 < getScrollStartItem()) {
            i2 = this.f6024d - getScrollStartItem();
            i3 = getScrollStartItem();
        } else if (i3 > getScrollEndItem()) {
            i2 = this.f6024d - getScrollEndItem();
            i3 = getScrollEndItem();
        } else if (i3 != getScrollEndItem()) {
            getScrollStartItem();
        }
        int i4 = this.f6034n;
        if (i3 != this.f6024d) {
            setCurrentItem(i3, false);
        } else {
            invalidate();
        }
        this.f6034n = i4 - (i2 * itemHeight);
        if (this.f6034n > getHeight() && getHeight() != 0) {
            this.f6034n = (this.f6034n % getHeight()) + getHeight();
        }
    }

    /* renamed from: d */
    public void mo17200d(int i, int i2) {
        this.f6032l.mo17253a((i * getItemHeight()) + this.f6034n, i2);
    }

    private C1510k getItemsRange() {
        if (getItemHeight() == 0) {
            return null;
        }
        int i = this.f6024d;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 2;
            if (getItemHeight() * i3 >= getHeight()) {
                break;
            }
            i--;
            i2 = i3;
        }
        if (this.f6034n != 0) {
            if (this.f6034n > 0) {
                i--;
            }
            int itemHeight = this.f6034n / getItemHeight();
            i -= itemHeight;
            i2 = (int) (((double) (i2 + 1)) + Math.asin((double) itemHeight));
        }
        return this.f6037q.mo17267a(i, i2);
    }

    /* renamed from: e */
    private boolean m6023e() {
        this.f6037q = getItemsRange();
        if (this.f6038r <= this.f6037q.mo17266a() || this.f6038r > this.f6037q.mo17268b()) {
            this.f6038r = this.f6037q.mo17266a();
            return false;
        }
        int i = this.f6038r;
        while (true) {
            i--;
            if (i < this.f6037q.mo17266a()) {
                return false;
            }
            this.f6038r = i;
        }
    }

    /* renamed from: f */
    private void m6025f() {
        this.f6023c.setTextSize(this.f6031k);
        Paint.FontMetricsInt fontMetricsInt = this.f6023c.getFontMetricsInt();
        this.f6046z = (float) ((fontMetricsInt.bottom + fontMetricsInt.top) / 2);
        this.f6023c.setTextSize(this.f6030j);
        Paint.FontMetricsInt fontMetricsInt2 = this.f6023c.getFontMetricsInt();
        this.f6011A = (float) ((fontMetricsInt2.bottom + fontMetricsInt2.top) / 2);
    }

    /* renamed from: f */
    private boolean m6026f(int i) {
        return this.f6039s != null && this.f6039s.mo17247a() > 0 && (this.f6022a || (i >= 0 && i < this.f6039s.mo17247a()));
    }

    /* renamed from: d */
    public void mo17199d() {
        if (this.f6032l != null) {
            this.f6032l.mo17252a();
        }
    }

    public void setTextColor(int i, int i2) {
        this.f6028h = i;
        this.f6029i = i2;
        this.f6014D = new ArrayList();
        int i3 = this.f6025e - 1;
        for (int i4 = 0; i4 < i3 / 2; i4++) {
            this.f6014D.add(new Integer(this.f6029i));
        }
        invalidate();
    }

    public void setTextColor(int i, List<Integer> list) {
        this.f6028h = i;
        if (!(list == null || this.f6014D == list)) {
            this.f6029i = list.get(0).intValue();
            this.f6014D = new ArrayList();
            int i2 = this.f6025e - 1;
            for (int i3 = 0; i3 < i2 / 2; i3++) {
                int size = list.size();
                if (i3 < size) {
                    this.f6014D.add(new Integer(list.get(i3).intValue()));
                } else {
                    this.f6014D.add(new Integer(list.get(size - 1).intValue()));
                }
            }
        }
        invalidate();
    }

    public void setSelectTextColor(int i) {
        if (this.f6028h != i) {
            setTextColor(i, this.f6014D);
        }
    }

    public void setNormalTextColor(int i) {
        if (this.f6029i != i) {
            setTextColor(this.f6028h, i);
        }
    }

    public void setNormalTextColor(List<Integer> list) {
        if (list == null) {
            setTextColor(this.f6028h, list);
        }
    }

    public void setTextPreference(float f, float f2, float f3, float f4) {
        this.f6026f = f3;
        this.f6027g = f4;
        this.f6031k = f;
        this.f6030j = f2;
        this.f6013C = new ArrayList();
        int i = this.f6025e - 1;
        for (int i2 = 0; i2 < i / 2; i2++) {
            this.f6013C.add(new Float(this.f6030j));
        }
        m6025f();
        invalidate();
    }

    public void setTextSize(float f, float f2) {
        setTextPreference(f, f2, this.f6026f, this.f6027g);
    }

    public void setNormalTextSize(float f) {
        setTextPreference(this.f6031k, f, this.f6026f, this.f6027g);
    }

    public void setSelectTextSize(float f) {
        setTextPreference(f, this.f6030j, this.f6026f, this.f6027g);
    }

    public void setItemHeight(float f, float f2) {
        setTextPreference(this.f6031k, this.f6030j, f, f2);
    }

    public void setSelectItemHeight(float f) {
        setTextPreference(this.f6031k, this.f6030j, f, this.f6027g);
    }

    public void setNormalItemHeight(float f) {
        setTextPreference(this.f6031k, this.f6030j, this.f6026f, f);
    }

    public void setIDataAdapter(C1497b bVar) {
        this.f6040t = bVar;
    }

    public C1497b getIDataAdapter() {
        return this.f6040t;
    }

    public int getItemsCount() {
        return this.f6039s.mo17247a();
    }

    public void setTypeface(Typeface typeface) {
        this.f6023c.setTypeface(typeface);
        m6025f();
        invalidate();
    }

    public void setIsDrawFading(boolean z) {
        this.f6045y = z;
    }

    /* renamed from: com.meizu.common.widget.ScrollTextView$k */
    private class C1510k {

        /* renamed from: b */
        private int f6079b;

        /* renamed from: c */
        private int f6080c;

        public C1510k(ScrollTextView scrollTextView) {
            this(0, 0);
        }

        public C1510k(int i, int i2) {
            this.f6079b = i;
            this.f6080c = i2;
        }

        /* renamed from: a */
        public int mo17266a() {
            return this.f6079b;
        }

        /* renamed from: b */
        public int mo17268b() {
            return (mo17266a() + mo17269c()) - 1;
        }

        /* renamed from: c */
        public int mo17269c() {
            return this.f6080c;
        }

        /* renamed from: a */
        public C1510k mo17267a(int i, int i2) {
            this.f6079b = i;
            this.f6080c = i2;
            return this;
        }
    }

    /* renamed from: com.meizu.common.widget.ScrollTextView$g */
    private class C1502g {

        /* renamed from: b */
        private int f6051b;

        /* renamed from: c */
        private int f6052c;

        /* renamed from: d */
        private int f6053d;

        public C1502g(ScrollTextView scrollTextView) {
            this(10, 0, 9);
        }

        public C1502g(int i, int i2, int i3) {
            this.f6051b = 0;
            this.f6052c = 0;
            this.f6053d = 0;
            mo17248a(i, i2, i3);
        }

        /* renamed from: a */
        public String mo17249a(int i) {
            if (i < 0 || i >= mo17247a() || ScrollTextView.this.f6040t == null) {
                return null;
            }
            return ScrollTextView.this.f6040t.mo16387c(i);
        }

        /* renamed from: a */
        public int mo17247a() {
            return this.f6053d;
        }

        /* renamed from: a */
        public C1502g mo17248a(int i, int i2, int i3) {
            this.f6051b = i2;
            this.f6052c = i3;
            this.f6053d = i;
            return this;
        }

        /* renamed from: b */
        public int mo17250b() {
            return this.f6051b;
        }

        /* renamed from: c */
        public int mo17251c() {
            return this.f6052c;
        }
    }

    /* renamed from: com.meizu.common.widget.ScrollTextView$h */
    private class C1503h {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public C1505i f6055b;

        /* renamed from: c */
        private Context f6056c;

        /* renamed from: d */
        private GestureDetector f6057d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public Scroller f6058e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public int f6059f;

        /* renamed from: g */
        private float f6060g;

        /* renamed from: h */
        private boolean f6061h;

        /* renamed from: i */
        private GestureDetector.SimpleOnGestureListener f6062i = new GestureDetector.SimpleOnGestureListener() {
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return true;
            }

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                int i;
                int i2;
                int unused = C1503h.this.f6059f = 0;
                int g = ScrollTextView.this.getYScrollEnd();
                C1503h.this.f6058e.fling(0, C1503h.this.f6059f, 0, (int) (-f2), 0, 0, ScrollTextView.this.getYScrollStart(), g);
                int finalY = C1503h.this.f6058e.getFinalY();
                int e = finalY % ScrollTextView.this.getItemHeight();
                if (e != 0) {
                    if (e > 0) {
                        i = finalY + (ScrollTextView.this.getItemHeight() - e);
                    } else {
                        i = finalY - (ScrollTextView.this.getItemHeight() + e);
                    }
                    if (ScrollTextView.this.f6034n > 0) {
                        i2 = (i + ScrollTextView.this.f6034n) - ScrollTextView.this.getItemHeight();
                    } else {
                        i2 = i + ScrollTextView.this.getItemHeight() + ScrollTextView.this.f6034n;
                    }
                    if (i2 > ScrollTextView.this.getItemHeight()) {
                        i2 -= ScrollTextView.this.getItemHeight();
                    } else if (i2 < (-ScrollTextView.this.getItemHeight())) {
                        i2 += ScrollTextView.this.getItemHeight();
                    }
                    C1503h.this.f6058e.setFinalY(i2);
                }
                C1503h.this.m6067a(0);
                return true;
            }
        };

        /* renamed from: j */
        private final int f6063j = 0;

        /* renamed from: k */
        private final int f6064k = 1;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public Handler f6065l = new C1496a(this);

        public C1503h(Context context, C1505i iVar) {
            this.f6057d = new GestureDetector(context, this.f6062i);
            this.f6057d.setIsLongpressEnabled(false);
            this.f6058e = new Scroller(context);
            this.f6055b = iVar;
            this.f6056c = context;
        }

        /* renamed from: a */
        public void mo17254a(Interpolator interpolator) {
            this.f6058e.forceFinished(true);
            this.f6058e = new Scroller(this.f6056c, interpolator);
        }

        /* renamed from: a */
        public void mo17253a(int i, int i2) {
            this.f6058e.forceFinished(true);
            this.f6059f = 0;
            this.f6058e.startScroll(0, 0, 0, i, i2 != 0 ? i2 : 400);
            m6067a(0);
            m6074e();
        }

        /* renamed from: a */
        public void mo17252a() {
            this.f6058e.forceFinished(true);
        }

        /* renamed from: a */
        public boolean mo17255a(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                switch (action) {
                    case 2:
                        int y = (int) (motionEvent.getY() - this.f6060g);
                        if (y != 0) {
                            m6074e();
                            this.f6055b.mo17241a(y);
                            this.f6060g = motionEvent.getY();
                            break;
                        }
                        break;
                    case 3:
                        m6073d();
                        break;
                }
            } else {
                this.f6060g = motionEvent.getY();
                this.f6058e.forceFinished(true);
                m6071c();
                mo17256b();
            }
            if (!this.f6057d.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
                m6073d();
            }
            return true;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m6067a(int i) {
            m6071c();
            this.f6065l.sendEmptyMessage(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public void m6071c() {
            this.f6065l.removeMessages(0);
            this.f6065l.removeMessages(1);
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public void m6073d() {
            this.f6055b.mo17243c();
            m6067a(1);
        }

        /* renamed from: e */
        private void m6074e() {
            if (!this.f6061h) {
                this.f6061h = true;
                this.f6055b.mo17240a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo17256b() {
            if (this.f6061h) {
                this.f6055b.mo17242b();
                this.f6061h = false;
            }
        }
    }

    /* renamed from: com.meizu.common.widget.ScrollTextView$a */
    private static class C1496a extends Handler {

        /* renamed from: a */
        private final WeakReference<C1503h> f6048a;

        public C1496a(C1503h hVar) {
            this.f6048a = new WeakReference<>(hVar);
        }

        public void handleMessage(Message message) {
            C1503h hVar = (C1503h) this.f6048a.get();
            if (hVar != null) {
                hVar.f6058e.computeScrollOffset();
                int currY = hVar.f6058e.getCurrY();
                int unused = hVar.f6059f = currY;
                hVar.f6055b.mo17241a(hVar.f6059f - currY);
                if (Math.abs(currY - hVar.f6058e.getFinalY()) < 1) {
                    hVar.f6058e.getFinalY();
                    hVar.f6058e.forceFinished(true);
                }
                if (!hVar.f6058e.isFinished()) {
                    hVar.f6065l.sendEmptyMessage(message.what);
                } else if (message.what == 0) {
                    hVar.m6073d();
                } else {
                    hVar.mo17256b();
                }
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ScrollTextView.class.getName());
    }

    public void setNormalTextSize(List<Float> list) {
        if (list != null) {
            setTextPreference(this.f6031k, list, this.f6026f, this.f6027g);
        }
    }

    public void setTextSize(float f, List<Float> list) {
        if (f != this.f6031k || list != null) {
            setTextPreference(f, list, this.f6026f, this.f6027g);
        }
    }

    public void setTextPreference(float f, List<Float> list, float f2, float f3) {
        if (this.f6026f != f2 || this.f6027g != f3 || this.f6031k != f || list != null) {
            this.f6026f = f2;
            this.f6031k = f;
            this.f6027g = f3;
            if (!(list == null || this.f6013C == list)) {
                this.f6030j = list.get(0).floatValue();
                this.f6013C = new ArrayList();
                int i = this.f6025e - 1;
                for (int i2 = 0; i2 < i / 2; i2++) {
                    int size = list.size();
                    if (i2 < size) {
                        this.f6013C.add(new Float(list.get(i2).floatValue()));
                    } else {
                        this.f6013C.add(new Float(list.get(size - 1).floatValue()));
                    }
                }
            }
            m6025f();
            invalidate();
        }
    }

    public void setFadingHeight(float f) {
        if (this.f6044x != f) {
            this.f6044x = f;
            invalidate();
        }
    }

    public void setParentRequestDisallowInterceptTouchEvent(boolean z) {
        this.f6015E = z;
    }

    /* renamed from: com.meizu.common.widget.ScrollTextView$j */
    private static class C1506j {

        /* renamed from: a */
        public SoundPool f6067a;

        /* renamed from: b */
        public boolean f6068b;

        /* renamed from: c */
        public int f6069c;

        /* renamed from: d */
        public Context f6070d;

        /* renamed from: e */
        public boolean f6071e;

        /* renamed from: f */
        private Thread f6072f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public Handler f6073g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public Looper f6074h;

        private C1506j() {
            this.f6072f = null;
            this.f6073g = null;
            this.f6074h = null;
        }

        /* renamed from: a */
        public void mo17260a(Context context) {
            this.f6070d = context.getApplicationContext();
            this.f6068b = false;
            this.f6072f = new Thread(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
                    android.os.Looper.loop();
                 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0087 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r6 = this;
                        int r0 = android.os.Build.VERSION.SDK_INT
                        r1 = 0
                        r2 = 1
                        r3 = 21
                        if (r0 < r3) goto L_0x0028
                        android.media.SoundPool$Builder r0 = new android.media.SoundPool$Builder
                        r0.<init>()
                        r0.setMaxStreams(r2)
                        android.media.AudioAttributes$Builder r3 = new android.media.AudioAttributes$Builder
                        r3.<init>()
                        r3.setLegacyStreamType(r2)
                        android.media.AudioAttributes r3 = r3.build()
                        r0.setAudioAttributes(r3)
                        com.meizu.common.widget.ScrollTextView$j r3 = com.meizu.common.widget.ScrollTextView.C1506j.this
                        android.media.SoundPool r0 = r0.build()
                        r3.f6067a = r0
                        goto L_0x0031
                    L_0x0028:
                        com.meizu.common.widget.ScrollTextView$j r0 = com.meizu.common.widget.ScrollTextView.C1506j.this
                        android.media.SoundPool r3 = new android.media.SoundPool
                        r3.<init>(r2, r2, r1)
                        r0.f6067a = r3
                    L_0x0031:
                        com.meizu.common.widget.ScrollTextView$j r0 = com.meizu.common.widget.ScrollTextView.C1506j.this
                        android.media.SoundPool r0 = r0.f6067a
                        com.meizu.common.widget.ScrollTextView$j$1$1 r3 = new com.meizu.common.widget.ScrollTextView$j$1$1
                        r3.<init>()
                        r0.setOnLoadCompleteListener(r3)
                        com.meizu.common.widget.ScrollTextView$j r0 = com.meizu.common.widget.ScrollTextView.C1506j.this     // Catch:{ Exception -> 0x0087 }
                        com.meizu.common.widget.ScrollTextView$j r3 = com.meizu.common.widget.ScrollTextView.C1506j.this     // Catch:{ Exception -> 0x0087 }
                        android.media.SoundPool r3 = r3.f6067a     // Catch:{ Exception -> 0x0087 }
                        com.meizu.common.widget.ScrollTextView$j r4 = com.meizu.common.widget.ScrollTextView.C1506j.this     // Catch:{ Exception -> 0x0087 }
                        android.content.Context r4 = r4.f6070d     // Catch:{ Exception -> 0x0087 }
                        int r5 = com.meizu.common.R.raw.mc_picker_scrolled     // Catch:{ Exception -> 0x0087 }
                        int r2 = r3.load(r4, r5, r2)     // Catch:{ Exception -> 0x0087 }
                        r0.f6069c = r2     // Catch:{ Exception -> 0x0087 }
                        android.os.Looper.prepare()     // Catch:{ Exception -> 0x0087 }
                        com.meizu.common.widget.ScrollTextView$j r0 = com.meizu.common.widget.ScrollTextView.C1506j.this     // Catch:{ Exception -> 0x0087 }
                        monitor-enter(r0)     // Catch:{ Exception -> 0x0087 }
                        com.meizu.common.widget.ScrollTextView$j r2 = com.meizu.common.widget.ScrollTextView.C1506j.this     // Catch:{ all -> 0x0082 }
                        boolean r2 = r2.f6071e     // Catch:{ all -> 0x0082 }
                        if (r2 == 0) goto L_0x0064
                        monitor-exit(r0)     // Catch:{ all -> 0x0082 }
                        com.meizu.common.widget.ScrollTextView$j r0 = com.meizu.common.widget.ScrollTextView.C1506j.this
                        android.media.SoundPool r0 = r0.f6067a
                        r0.release()
                        return
                    L_0x0064:
                        com.meizu.common.widget.ScrollTextView$j r2 = com.meizu.common.widget.ScrollTextView.C1506j.this     // Catch:{ all -> 0x0082 }
                        android.os.Looper r3 = android.os.Looper.myLooper()     // Catch:{ all -> 0x0082 }
                        android.os.Looper unused = r2.f6074h = r3     // Catch:{ all -> 0x0082 }
                        com.meizu.common.widget.ScrollTextView$j r2 = com.meizu.common.widget.ScrollTextView.C1506j.this     // Catch:{ all -> 0x0082 }
                        android.os.Handler r3 = new android.os.Handler     // Catch:{ all -> 0x0082 }
                        com.meizu.common.widget.ScrollTextView$j r4 = com.meizu.common.widget.ScrollTextView.C1506j.this     // Catch:{ all -> 0x0082 }
                        android.os.Looper r4 = r4.f6074h     // Catch:{ all -> 0x0082 }
                        r3.<init>(r4)     // Catch:{ all -> 0x0082 }
                        android.os.Handler unused = r2.f6073g = r3     // Catch:{ all -> 0x0082 }
                        monitor-exit(r0)     // Catch:{ all -> 0x0082 }
                        android.os.Looper.loop()     // Catch:{ Exception -> 0x0087 }
                        goto L_0x008b
                    L_0x0082:
                        r2 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x0082 }
                        throw r2     // Catch:{ Exception -> 0x0087 }
                    L_0x0085:
                        r0 = move-exception
                        goto L_0x0093
                    L_0x0087:
                        com.meizu.common.widget.ScrollTextView$j r0 = com.meizu.common.widget.ScrollTextView.C1506j.this     // Catch:{ all -> 0x0085 }
                        r0.f6068b = r1     // Catch:{ all -> 0x0085 }
                    L_0x008b:
                        com.meizu.common.widget.ScrollTextView$j r0 = com.meizu.common.widget.ScrollTextView.C1506j.this
                        android.media.SoundPool r0 = r0.f6067a
                        r0.release()
                        return
                    L_0x0093:
                        com.meizu.common.widget.ScrollTextView$j r1 = com.meizu.common.widget.ScrollTextView.C1506j.this
                        android.media.SoundPool r1 = r1.f6067a
                        r1.release()
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.ScrollTextView.C1506j.C15071.run():void");
                }
            });
            this.f6072f.start();
        }

        /* renamed from: a */
        public void mo17259a() {
            if (this.f6073g != null) {
                this.f6073g.post(new Runnable() {
                    public void run() {
                        if (C1506j.this.f6068b && C1506j.this.m6090c()) {
                            C1506j.this.f6067a.play(C1506j.this.f6069c, 0.5f, 0.5f, 0, 0, 1.0f);
                        }
                    }
                });
            }
        }

        /* renamed from: b */
        public void mo17261b() {
            synchronized (this) {
                this.f6071e = true;
                if (this.f6073g != null) {
                    this.f6073g.removeCallbacksAndMessages((Object) null);
                    if (this.f6068b) {
                        this.f6067a.unload(this.f6069c);
                    }
                    this.f6067a.release();
                    this.f6074h.quit();
                    this.f6072f = null;
                    this.f6068b = false;
                    this.f6070d = null;
                    this.f6073g = null;
                }
            }
        }

        /* renamed from: b */
        public void mo17262b(Context context) {
            if (!this.f6068b) {
                mo17260a(context);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public boolean m6090c() {
            return (this.f6070d == null || Settings.System.getInt(this.f6070d.getContentResolver(), "sound_effects_enabled", 0) == 0) ? false : true;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6016F != null) {
            this.f6016F.mo17262b(this.f6020K);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f6016F != null) {
            this.f6016F.mo17261b();
        }
        if (this.f6032l != null) {
            this.f6032l.m6071c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m6028g() {
        if (this.f6016F != null) {
            this.f6016F.mo17259a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m6030h() {
        if (m6032i()) {
            performHapticFeedback(21000);
        }
    }

    /* renamed from: i */
    private boolean m6032i() {
        try {
            if (f6009G == null) {
                f6009G = Class.forName("flyme.config.FlymeFeature").getDeclaredField("SHELL_HAPTICFEEDBACK_MOTOR");
            }
            return f6009G.getBoolean((Object) null);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: com.meizu.common.widget.ScrollTextView$f */
    private class C1501f implements C1498c {
        private C1501f() {
        }

        /* renamed from: a */
        public void mo17245a(ScrollTextView scrollTextView, int i, int i2) {
            ScrollTextView.this.m6028g();
        }
    }

    /* renamed from: com.meizu.common.widget.ScrollTextView$l */
    private class C1511l implements C1498c {
        private C1511l() {
        }

        /* renamed from: a */
        public void mo17245a(ScrollTextView scrollTextView, int i, int i2) {
            ScrollTextView.this.m6030h();
        }
    }

    /* renamed from: a */
    public int mo17186a(String str) {
        if (str == null || str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        this.f6023c.setTextSize(this.f6031k);
        this.f6023c.getTextWidths(str, fArr);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += (int) Math.ceil((double) fArr[i2]);
        }
        return i;
    }
}
