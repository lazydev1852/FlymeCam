package flyme.support.p092v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.annotation.DrawableRes;
import androidx.core.p005os.ParcelableCompat;
import androidx.core.p005os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.PagerAdapter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: flyme.support.v4.view.ViewPager */
public class ViewPager extends ViewGroup {

    /* renamed from: a */
    private static final boolean f16464a = "eng".equals(Build.TYPE);
    /* access modifiers changed from: private */

    /* renamed from: aC */
    public static final float[] f16465aC = {0.0f, 0.0f, 0.003365234f, 0.01357806f, 0.030720964f, 0.05475371f, 0.08548926f, 0.12255032f, 0.16538717f, 0.21324258f, 0.2652047f, 0.32024413f, 0.37725833f, 0.4351431f, 0.49284747f, 0.5494277f, 0.6040792f, 0.6561299f, 0.7050707f, 0.7505254f, 0.7922336f, 0.8300537f, 0.86390066f, 0.8937803f, 0.91972214f, 0.94181687f, 0.9601534f, 0.974861f, 0.98606336f, 0.99389625f, 0.99851006f, 1.0f};

    /* renamed from: aD */
    private static final Interpolator f16466aD = new Interpolator() {
        public float getInterpolation(float f) {
            if (f <= 0.0f) {
                return ViewPager.f16465aC[0];
            }
            if (f >= 1.0f) {
                return ViewPager.f16465aC[ViewPager.f16465aC.length - 1];
            }
            float length = 1.0f / ((float) (ViewPager.f16465aC.length - 1));
            int i = (int) (f / length);
            return ViewPager.f16465aC[i] + (((ViewPager.f16465aC[i + 1] - ViewPager.f16465aC[i]) * (f - (((float) i) * length))) / length);
        }
    };

    /* renamed from: aG */
    private static final Interpolator f16467aG = PathInterpolatorCompat.create(0.33f, 0.0f, 0.2f, 1.0f);

    /* renamed from: ax */
    private static final C3057h f16468ax = new C3057h();

    /* renamed from: ay */
    private static final C3058i f16469ay = new C3058i();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final int[] f16470b = {16842931};

    /* renamed from: d */
    private static final Comparator<C3051b> f16471d = new Comparator<C3051b>() {
        /* renamed from: a */
        public int compare(C3051b bVar, C3051b bVar2) {
            return bVar.f16552b - bVar2.f16552b;
        }
    };

    /* renamed from: e */
    private static final Interpolator f16472e = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: A */
    private C3056g f16473A;

    /* renamed from: B */
    private int f16474B;

    /* renamed from: C */
    private Drawable f16475C;

    /* renamed from: D */
    private int f16476D;

    /* renamed from: E */
    private int f16477E;

    /* renamed from: F */
    private float f16478F = -3.4028235E38f;

    /* renamed from: G */
    private float f16479G = Float.MAX_VALUE;

    /* renamed from: H */
    private int f16480H;

    /* renamed from: I */
    private int f16481I;

    /* renamed from: J */
    private boolean f16482J;

    /* renamed from: K */
    private boolean f16483K;

    /* renamed from: L */
    private boolean f16484L;

    /* renamed from: M */
    private int f16485M = 1;

    /* renamed from: N */
    private boolean f16486N;

    /* renamed from: O */
    private boolean f16487O;

    /* renamed from: P */
    private int f16488P;

    /* renamed from: Q */
    private int f16489Q;

    /* renamed from: R */
    private int f16490R;

    /* renamed from: S */
    private float f16491S;

    /* renamed from: T */
    private float f16492T;

    /* renamed from: U */
    private float f16493U;

    /* renamed from: V */
    private float f16494V;

    /* renamed from: W */
    private int f16495W = -1;

    /* renamed from: aA */
    private int f16496aA = 0;

    /* renamed from: aB */
    private float f16497aB = 0.5f;

    /* renamed from: aE */
    private Interpolator f16498aE;

    /* renamed from: aF */
    private Interpolator f16499aF;

    /* renamed from: aa */
    private VelocityTracker f16500aa;

    /* renamed from: ab */
    private int f16501ab;

    /* renamed from: ac */
    private int f16502ac;

    /* renamed from: ad */
    private int f16503ad;

    /* renamed from: ae */
    private int f16504ae;

    /* renamed from: af */
    private Rect f16505af;

    /* renamed from: ag */
    private int f16506ag;

    /* renamed from: ah */
    private int f16507ah = -1;

    /* renamed from: ai */
    private boolean f16508ai;

    /* renamed from: aj */
    private EdgeEffectCompat f16509aj;

    /* renamed from: ak */
    private EdgeEffectCompat f16510ak;

    /* renamed from: al */
    private boolean f16511al = true;

    /* renamed from: am */
    private boolean f16512am = false;

    /* renamed from: an */
    private boolean f16513an;

    /* renamed from: ao */
    private int f16514ao;

    /* renamed from: ap */
    private List<C3054e> f16515ap;

    /* renamed from: aq */
    private C3054e f16516aq;

    /* renamed from: ar */
    private C3054e f16517ar;

    /* renamed from: as */
    private C3053d f16518as;

    /* renamed from: at */
    private C3055f f16519at;

    /* renamed from: au */
    private Method f16520au;

    /* renamed from: av */
    private int f16521av;

    /* renamed from: aw */
    private LinkedList<View> f16522aw;

    /* renamed from: az */
    private final Runnable f16523az = new Runnable() {
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.mo24957g();
        }
    };

    /* renamed from: c */
    private int f16524c;

    /* renamed from: f */
    private final ArrayList<C3051b> f16525f = new ArrayList<>();

    /* renamed from: g */
    private final C3051b f16526g = new C3051b();

    /* renamed from: h */
    private final Rect f16527h = new Rect();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public PagerAdapter f16528i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f16529j;

    /* renamed from: k */
    private volatile FlipMode f16530k = FlipMode.FLIP_MODE_DEFAULT;

    /* renamed from: l */
    private volatile boolean f16531l;

    /* renamed from: m */
    private int f16532m;

    /* renamed from: n */
    private int f16533n;

    /* renamed from: o */
    private volatile boolean f16534o;

    /* renamed from: p */
    private int f16535p;

    /* renamed from: q */
    private int f16536q;

    /* renamed from: r */
    private int f16537r;

    /* renamed from: s */
    private Drawable f16538s;

    /* renamed from: t */
    private Drawable f16539t;

    /* renamed from: u */
    private int f16540u;

    /* renamed from: v */
    private Context f16541v;

    /* renamed from: w */
    private int f16542w = -1;

    /* renamed from: x */
    private Parcelable f16543x = null;

    /* renamed from: y */
    private ClassLoader f16544y = null;

    /* renamed from: z */
    private Scroller f16545z;

    /* renamed from: flyme.support.v4.view.ViewPager$FlipMode */
    public enum FlipMode {
        FLIP_MODE_DEFAULT,
        FLIP_MODE_OVERLAY
    }

    /* renamed from: flyme.support.v4.view.ViewPager$a */
    interface C3050a {
    }

    /* renamed from: flyme.support.v4.view.ViewPager$d */
    interface C3053d {
        /* renamed from: a */
        void mo25006a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* renamed from: flyme.support.v4.view.ViewPager$e */
    public interface C3054e {
        /* renamed from: a */
        void mo17729a(int i);

        /* renamed from: a */
        void mo17730a(int i, float f, int i2);

        /* renamed from: b */
        void mo17731b(int i);
    }

    /* renamed from: flyme.support.v4.view.ViewPager$f */
    public interface C3055f {
        /* renamed from: a */
        void mo24908a(View view, float f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo24886a(float f) {
        return f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo24889c() {
        return true;
    }

    /* renamed from: flyme.support.v4.view.ViewPager$b */
    static class C3051b {

        /* renamed from: a */
        Object f16551a;

        /* renamed from: b */
        int f16552b;

        /* renamed from: c */
        boolean f16553c;

        /* renamed from: d */
        float f16554d;

        /* renamed from: e */
        float f16555e;

        /* renamed from: f */
        View f16556f;

        /* renamed from: g */
        int f16557g;

        C3051b() {
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.f16541v = context;
        mo24955e();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16541v = context;
        mo24955e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo24955e() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f16545z = new Scroller(context, f16472e);
        this.f16498aE = f16472e;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f16490R = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.f16501ab = (int) (400.0f * f);
        this.f16502ac = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f16509aj = new EdgeEffectCompat(context);
        this.f16510ak = new EdgeEffectCompat(context);
        this.f16503ad = (int) (25.0f * f);
        this.f16504ae = (int) (2.0f * f);
        this.f16488P = (int) (f * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        if (FlipMode.FLIP_MODE_OVERLAY == this.f16530k) {
            setChildrenDrawingOrderEnabledCompat(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f16523az);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: private */
    public void setScrollState(int i) {
        if (this.f16496aA != i) {
            this.f16496aA = i;
            if (this.f16519at != null) {
                m18087b(i != 0);
            }
            m18094g(i);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.f16528i != null) {
            this.f16528i.unregisterDataSetObserver(this.f16473A);
            this.f16528i.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.f16525f.size(); i++) {
                C3051b bVar = this.f16525f.get(i);
                this.f16528i.destroyItem((ViewGroup) this, bVar.f16552b, bVar.f16551a);
            }
            this.f16528i.finishUpdate((ViewGroup) this);
            this.f16525f.clear();
            mo24887a();
            this.f16529j = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter2 = this.f16528i;
        this.f16528i = pagerAdapter;
        this.f16524c = 0;
        if (this.f16528i != null) {
            if (this.f16473A == null) {
                this.f16473A = new C3056g();
            }
            this.f16528i.registerDataSetObserver(this.f16473A);
            this.f16484L = false;
            boolean z = this.f16511al;
            this.f16511al = true;
            this.f16524c = this.f16528i.getCount();
            if (this.f16542w >= 0) {
                this.f16528i.restoreState(this.f16543x, this.f16544y);
                mo24934a(this.f16542w, false, true);
                this.f16542w = -1;
                this.f16543x = null;
                this.f16544y = null;
            } else if (!z) {
                mo24957g();
            } else {
                requestLayout();
            }
        }
        if (this.f16518as != null && pagerAdapter2 != pagerAdapter) {
            this.f16518as.mo25006a(pagerAdapter2, pagerAdapter);
        }
    }

    /* renamed from: a */
    private void mo24887a() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C3052c) getChildAt(i).getLayoutParams()).f16558a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public PagerAdapter getAdapter() {
        return this.f16528i;
    }

    /* access modifiers changed from: package-private */
    public void setOnAdapterChangeListener(C3053d dVar) {
        this.f16518as = dVar;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.f16484L = false;
        mo24934a(i, !this.f16511al, false);
    }

    public void setCurrentItem(int i, int i2) {
        if (i != this.f16529j) {
            if (this.f16499aF != null) {
                setInterpolator(this.f16499aF);
                this.f16499aF = null;
            }
            if (this.f16498aE == f16472e) {
                setInterpolator(f16467aG);
            }
        }
        this.f16484L = false;
        if (this.f16511al || i2 <= 0) {
            mo24934a(i, false, false);
        }
        if (this.f16528i == null || this.f16528i.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (this.f16529j != i || this.f16525f.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f16528i.getCount()) {
                i = this.f16528i.getCount() - 1;
            }
            int i3 = this.f16485M;
            if (i > this.f16529j + i3 || i < this.f16529j - i3) {
                for (int i4 = 0; i4 < this.f16525f.size(); i4++) {
                    this.f16525f.get(i4).f16553c = true;
                }
            }
            boolean z = this.f16529j != i;
            mo24931a(i);
            C3051b b = mo24943b(i);
            int clientWidth = b != null ? (int) (((float) getClientWidth()) * Math.max(this.f16478F, Math.min(b.f16555e, this.f16479G))) : 0;
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int i5 = clientWidth - scrollX;
            int i6 = 0 - scrollY;
            if (i5 == 0 && i6 == 0) {
                m18081a(false);
                mo24957g();
                setScrollState(0);
                return;
            }
            setScrollingCacheEnabled(true);
            setScrollState(2);
            int max = Math.max(1, Math.min(i2, 5000));
            if (FlipMode.FLIP_MODE_OVERLAY == this.f16530k) {
                setInterpolator(f16466aD);
            }
            this.f16545z.startScroll(scrollX, scrollY, i5, i6, max);
            ViewCompat.postInvalidateOnAnimation(this);
            if (z) {
                m18093f(i);
            }
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void setCurrentItem(int i, boolean z) {
        this.f16484L = false;
        mo24934a(i, z, false);
    }

    public int getCurrentItem() {
        return this.f16529j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24934a(int i, boolean z, boolean z2) {
        mo24935a(i, z, z2, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24935a(int i, boolean z, boolean z2, int i2) {
        if (this.f16528i == null || this.f16528i.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f16529j != i || this.f16525f.size() == 0) {
            boolean z3 = true;
            if (i < 0) {
                i = 0;
            } else if (i >= this.f16528i.getCount()) {
                i = this.f16528i.getCount() - 1;
            }
            int i3 = this.f16485M;
            if (i > this.f16529j + i3 || i < this.f16529j - i3) {
                for (int i4 = 0; i4 < this.f16525f.size(); i4++) {
                    this.f16525f.get(i4).f16553c = true;
                }
            }
            if (this.f16529j == i) {
                z3 = false;
            }
            if (this.f16511al) {
                this.f16529j = i;
                if (z3) {
                    m18093f(i);
                }
                requestLayout();
                return;
            }
            mo24931a(i);
            m18077a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    /* renamed from: a */
    private void m18077a(int i, boolean z, int i2, boolean z2) {
        C3051b b = mo24943b(i);
        int clientWidth = b != null ? (int) (((float) getClientWidth()) * Math.max(this.f16478F, Math.min(b.f16555e, this.f16479G))) : 0;
        if (z) {
            if (z2) {
                m18093f(i);
            }
            mo24933a(clientWidth, 0, i2);
            return;
        }
        if (z2) {
            m18093f(i);
        }
        m18081a(false);
        scrollTo(clientWidth, 0);
        m18092e(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(C3054e eVar) {
        this.f16516aq = eVar;
    }

    /* renamed from: a */
    public void mo24936a(C3054e eVar) {
        if (this.f16515ap == null) {
            this.f16515ap = new ArrayList();
        }
        this.f16515ap.add(eVar);
    }

    /* renamed from: b */
    public void mo24945b(C3054e eVar) {
        if (this.f16515ap != null) {
            this.f16515ap.remove(eVar);
        }
    }

    public void setPageTransformer(boolean z, C3055f fVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            int i = 1;
            boolean z2 = fVar != null;
            boolean z3 = z2 != (this.f16519at != null);
            this.f16519at = fVar;
            setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                if (z) {
                    i = 2;
                }
                this.f16521av = i;
            } else {
                this.f16521av = 0;
            }
            if (z3) {
                mo24957g();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.f16520au == null) {
                Class<ViewGroup> cls = ViewGroup.class;
                try {
                    this.f16520au = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (NoSuchMethodException e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.f16520au.setAccessible(true);
                this.f16520au.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f16521av == 2) {
            i2 = (i - 1) - i2;
        }
        if (this.f16522aw.size() == 0) {
            return i2;
        }
        if (i2 > 0 && i2 >= this.f16522aw.size()) {
            i2 = this.f16522aw.size() - 1;
        }
        return ((C3052c) this.f16522aw.get(i2).getLayoutParams()).f16563f;
    }

    public int getOffscreenPageLimit() {
        return this.f16485M;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f16485M) {
            this.f16485M = i;
            mo24957g();
        }
    }

    public void setPageMargin(int i) {
        if (FlipMode.FLIP_MODE_OVERLAY != this.f16530k) {
            int i2 = this.f16474B;
            this.f16474B = i;
            int width = getWidth();
            m18076a(width, width, i, i2);
            requestLayout();
        }
    }

    public int getPageMargin() {
        return this.f16474B;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f16475C = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(@DrawableRes int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f16475C;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f16475C;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float mo24942b(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24933a(int i, int i2, int i3) {
        int i4;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = i - scrollX;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            m18081a(false);
            mo24957g();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f = (float) clientWidth;
        float f2 = (float) i7;
        float b = f2 + (mo24942b(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / f)) * f2);
        int abs = Math.abs(i3);
        if (abs > 0) {
            i4 = Math.round(Math.abs(b / ((float) abs)) * 1000.0f) * 4;
        } else {
            float abs2 = ((float) Math.abs(i5)) / ((f * this.f16528i.getPageWidth(this.f16529j)) + ((float) this.f16474B));
            i4 = (FlipMode.FLIP_MODE_OVERLAY != this.f16530k || abs2 < 1.0f) ? (int) ((abs2 + 1.0f) * 100.0f) : (int) ((abs2 + 4.0f) * 100.0f);
        }
        this.f16545z.startScroll(scrollX, scrollY, i5, i6, Math.min(i4, 600));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3051b mo24929a(int i, int i2) {
        C3051b bVar = new C3051b();
        bVar.f16552b = i;
        bVar.f16551a = this.f16528i.instantiateItem((ViewGroup) this, i);
        bVar.f16554d = this.f16528i.getPageWidth(i);
        if (i2 < 0 || i2 >= this.f16525f.size()) {
            bVar.f16557g = this.f16525f.size();
            this.f16525f.add(bVar);
        } else {
            this.f16525f.add(i2, bVar);
            bVar.f16557g = i2;
        }
        return bVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo24956f() {
        int count = this.f16528i.getCount();
        this.f16524c = count;
        boolean z = this.f16525f.size() < (this.f16485M * 2) + 1 && this.f16525f.size() < count;
        int i = this.f16529j;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.f16525f.size()) {
            C3051b bVar = this.f16525f.get(i2);
            int itemPosition = this.f16528i.getItemPosition(bVar.f16551a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f16525f.remove(i2);
                    i2--;
                    if (!z2) {
                        this.f16528i.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.f16528i.destroyItem((ViewGroup) this, bVar.f16552b, bVar.f16551a);
                    if (this.f16529j == bVar.f16552b) {
                        i = Math.max(0, Math.min(this.f16529j, count - 1));
                    }
                } else if (bVar.f16552b != itemPosition) {
                    if (bVar.f16552b == this.f16529j) {
                        i = itemPosition;
                    }
                    bVar.f16552b = itemPosition;
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.f16528i.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f16525f, f16471d);
        if (FlipMode.FLIP_MODE_OVERLAY == this.f16530k) {
            mo24888b();
        }
        if (z) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                C3052c cVar = (C3052c) getChildAt(i3).getLayoutParams();
                if (!cVar.f16558a) {
                    cVar.f16560c = 0.0f;
                }
            }
            mo24934a(i, false, true);
            requestLayout();
        }
    }

    /* renamed from: b */
    private void mo24888b() {
        int clientWidth = getClientWidth();
        int paddingLeft = getPaddingLeft();
        int scrollX = getScrollX();
        for (int i = 0; i < this.f16525f.size(); i++) {
            C3051b bVar = this.f16525f.get(i);
            bVar.f16557g = i;
            if (((int) (((float) clientWidth) * bVar.f16555e)) + paddingLeft == scrollX) {
                this.f16532m = i;
            }
            if (bVar.f16552b == this.f16529j) {
                this.f16533n = i;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo24957g() {
        mo24931a(this.f16529j);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        if (r9.f16552b == r0.f16529j) goto L_0x008e;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo24931a(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.f16529j
            if (r2 == r1) goto L_0x0031
            int r2 = r0.f16529j
            if (r2 >= r1) goto L_0x000f
            r2 = 66
            goto L_0x0011
        L_0x000f:
            r2 = 17
        L_0x0011:
            int r4 = r0.f16529j
            flyme.support.v4.view.ViewPager$b r4 = r0.mo24943b((int) r4)
            r0.f16529j = r1
            androidx.viewpager.widget.PagerAdapter r1 = r0.f16528i
            if (r1 == 0) goto L_0x0027
            boolean r1 = r0.f16484L
            if (r1 != 0) goto L_0x0027
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x0033
        L_0x0027:
            flyme.support.v4.view.ViewPager$FlipMode r1 = flyme.support.p092v4.view.ViewPager.FlipMode.FLIP_MODE_OVERLAY
            flyme.support.v4.view.ViewPager$FlipMode r5 = r0.f16530k
            if (r1 != r5) goto L_0x0033
            r17.mo24888b()
            goto L_0x0033
        L_0x0031:
            r2 = 2
            r4 = 0
        L_0x0033:
            androidx.viewpager.widget.PagerAdapter r1 = r0.f16528i
            if (r1 != 0) goto L_0x003b
            r17.m18090d()
            return
        L_0x003b:
            boolean r1 = r0.f16484L
            if (r1 == 0) goto L_0x0043
            r17.m18090d()
            return
        L_0x0043:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x004a
            return
        L_0x004a:
            androidx.viewpager.widget.PagerAdapter r1 = r0.f16528i
            r1.startUpdate((android.view.ViewGroup) r0)
            int r1 = r0.f16485M
            int r5 = r0.f16529j
            int r5 = r5 - r1
            r6 = 0
            int r5 = java.lang.Math.max(r6, r5)
            androidx.viewpager.widget.PagerAdapter r7 = r0.f16528i
            int r7 = r7.getCount()
            int r8 = r7 + -1
            int r9 = r0.f16529j
            int r9 = r9 + r1
            int r1 = java.lang.Math.min(r8, r9)
            int r8 = r0.f16524c
            if (r7 != r8) goto L_0x0244
            r8 = 0
        L_0x006d:
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r9 = r0.f16525f
            int r9 = r9.size()
            if (r8 >= r9) goto L_0x008d
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r9 = r0.f16525f
            java.lang.Object r9 = r9.get(r8)
            flyme.support.v4.view.ViewPager$b r9 = (flyme.support.p092v4.view.ViewPager.C3051b) r9
            int r10 = r9.f16552b
            int r11 = r0.f16529j
            if (r10 < r11) goto L_0x008a
            int r10 = r9.f16552b
            int r11 = r0.f16529j
            if (r10 != r11) goto L_0x008d
            goto L_0x008e
        L_0x008a:
            int r8 = r8 + 1
            goto L_0x006d
        L_0x008d:
            r9 = 0
        L_0x008e:
            if (r9 != 0) goto L_0x0098
            if (r7 <= 0) goto L_0x0098
            int r9 = r0.f16529j
            flyme.support.v4.view.ViewPager$b r9 = r0.mo24929a((int) r9, (int) r8)
        L_0x0098:
            if (r9 == 0) goto L_0x01b9
            int r11 = r8 + -1
            if (r11 < 0) goto L_0x00a7
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r12 = r0.f16525f
            java.lang.Object r12 = r12.get(r11)
            flyme.support.v4.view.ViewPager$b r12 = (flyme.support.p092v4.view.ViewPager.C3051b) r12
            goto L_0x00a8
        L_0x00a7:
            r12 = 0
        L_0x00a8:
            int r13 = r17.getClientWidth()
            r14 = 1073741824(0x40000000, float:2.0)
            if (r13 > 0) goto L_0x00b2
            r3 = 0
            goto L_0x00be
        L_0x00b2:
            float r15 = r9.f16554d
            float r15 = r14 - r15
            int r3 = r17.getPaddingLeft()
            float r3 = (float) r3
            float r6 = (float) r13
            float r3 = r3 / r6
            float r3 = r3 + r15
        L_0x00be:
            int r6 = r0.f16529j
            int r6 = r6 + -1
            r15 = r8
            r8 = 0
        L_0x00c4:
            if (r6 < 0) goto L_0x0123
            int r16 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r16 < 0) goto L_0x00f2
            if (r6 >= r5) goto L_0x00f2
            if (r12 != 0) goto L_0x00cf
            goto L_0x0123
        L_0x00cf:
            int r10 = r12.f16552b
            if (r6 != r10) goto L_0x0120
            boolean r10 = r12.f16553c
            if (r10 != 0) goto L_0x0120
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r10 = r0.f16525f
            r10.remove(r11)
            androidx.viewpager.widget.PagerAdapter r10 = r0.f16528i
            java.lang.Object r12 = r12.f16551a
            r10.destroyItem((android.view.ViewGroup) r0, (int) r6, (java.lang.Object) r12)
            int r11 = r11 + -1
            int r15 = r15 + -1
            if (r11 < 0) goto L_0x011e
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r10 = r0.f16525f
            java.lang.Object r10 = r10.get(r11)
            flyme.support.v4.view.ViewPager$b r10 = (flyme.support.p092v4.view.ViewPager.C3051b) r10
            goto L_0x011f
        L_0x00f2:
            if (r12 == 0) goto L_0x0108
            int r10 = r12.f16552b
            if (r6 != r10) goto L_0x0108
            float r10 = r12.f16554d
            float r8 = r8 + r10
            int r11 = r11 + -1
            if (r11 < 0) goto L_0x011e
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r10 = r0.f16525f
            java.lang.Object r10 = r10.get(r11)
            flyme.support.v4.view.ViewPager$b r10 = (flyme.support.p092v4.view.ViewPager.C3051b) r10
            goto L_0x011f
        L_0x0108:
            int r10 = r11 + 1
            flyme.support.v4.view.ViewPager$b r10 = r0.mo24929a((int) r6, (int) r10)
            float r10 = r10.f16554d
            float r8 = r8 + r10
            int r15 = r15 + 1
            if (r11 < 0) goto L_0x011e
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r10 = r0.f16525f
            java.lang.Object r10 = r10.get(r11)
            flyme.support.v4.view.ViewPager$b r10 = (flyme.support.p092v4.view.ViewPager.C3051b) r10
            goto L_0x011f
        L_0x011e:
            r10 = 0
        L_0x011f:
            r12 = r10
        L_0x0120:
            int r6 = r6 + -1
            goto L_0x00c4
        L_0x0123:
            float r3 = r9.f16554d
            int r5 = r15 + 1
            int r6 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r6 >= 0) goto L_0x01b6
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r6 = r0.f16525f
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x013c
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r6 = r0.f16525f
            java.lang.Object r6 = r6.get(r5)
            flyme.support.v4.view.ViewPager$b r6 = (flyme.support.p092v4.view.ViewPager.C3051b) r6
            goto L_0x013d
        L_0x013c:
            r6 = 0
        L_0x013d:
            if (r13 > 0) goto L_0x0141
            r10 = 0
            goto L_0x014a
        L_0x0141:
            int r8 = r17.getPaddingRight()
            float r8 = (float) r8
            float r10 = (float) r13
            float r8 = r8 / r10
            float r10 = r8 + r14
        L_0x014a:
            int r8 = r0.f16529j
        L_0x014c:
            int r8 = r8 + 1
            if (r8 >= r7) goto L_0x01b6
            int r11 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r11 < 0) goto L_0x0180
            if (r8 <= r1) goto L_0x0180
            if (r6 != 0) goto L_0x0159
            goto L_0x01b6
        L_0x0159:
            int r11 = r6.f16552b
            if (r8 != r11) goto L_0x01b5
            boolean r11 = r6.f16553c
            if (r11 != 0) goto L_0x01b5
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r11 = r0.f16525f
            r11.remove(r5)
            androidx.viewpager.widget.PagerAdapter r11 = r0.f16528i
            java.lang.Object r6 = r6.f16551a
            r11.destroyItem((android.view.ViewGroup) r0, (int) r8, (java.lang.Object) r6)
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r6 = r0.f16525f
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x017e
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r6 = r0.f16525f
            java.lang.Object r6 = r6.get(r5)
            flyme.support.v4.view.ViewPager$b r6 = (flyme.support.p092v4.view.ViewPager.C3051b) r6
            goto L_0x01b5
        L_0x017e:
            r6 = 0
            goto L_0x01b5
        L_0x0180:
            if (r6 == 0) goto L_0x019c
            int r11 = r6.f16552b
            if (r8 != r11) goto L_0x019c
            float r6 = r6.f16554d
            float r3 = r3 + r6
            int r5 = r5 + 1
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r6 = r0.f16525f
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x017e
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r6 = r0.f16525f
            java.lang.Object r6 = r6.get(r5)
            flyme.support.v4.view.ViewPager$b r6 = (flyme.support.p092v4.view.ViewPager.C3051b) r6
            goto L_0x01b5
        L_0x019c:
            flyme.support.v4.view.ViewPager$b r6 = r0.mo24929a((int) r8, (int) r5)
            int r5 = r5 + 1
            float r6 = r6.f16554d
            float r3 = r3 + r6
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r6 = r0.f16525f
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x017e
            java.util.ArrayList<flyme.support.v4.view.ViewPager$b> r6 = r0.f16525f
            java.lang.Object r6 = r6.get(r5)
            flyme.support.v4.view.ViewPager$b r6 = (flyme.support.p092v4.view.ViewPager.C3051b) r6
        L_0x01b5:
            goto L_0x014c
        L_0x01b6:
            r0.m18079a((flyme.support.p092v4.view.ViewPager.C3051b) r9, (int) r15, (flyme.support.p092v4.view.ViewPager.C3051b) r4)
        L_0x01b9:
            androidx.viewpager.widget.PagerAdapter r1 = r0.f16528i
            int r3 = r0.f16529j
            if (r9 == 0) goto L_0x01c2
            java.lang.Object r4 = r9.f16551a
            goto L_0x01c3
        L_0x01c2:
            r4 = 0
        L_0x01c3:
            r1.setPrimaryItem((android.view.ViewGroup) r0, (int) r3, (java.lang.Object) r4)
            androidx.viewpager.widget.PagerAdapter r1 = r0.f16528i
            r1.finishUpdate((android.view.ViewGroup) r0)
            int r1 = r17.getChildCount()
            r3 = 0
        L_0x01d0:
            if (r3 >= r1) goto L_0x01fc
            android.view.View r4 = r0.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            flyme.support.v4.view.ViewPager$c r5 = (flyme.support.p092v4.view.ViewPager.C3052c) r5
            r5.f16563f = r3
            boolean r6 = r5.f16558a
            if (r6 != 0) goto L_0x01f8
            float r6 = r5.f16560c
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x01f9
            flyme.support.v4.view.ViewPager$b r4 = r0.mo24930a((android.view.View) r4)
            if (r4 == 0) goto L_0x01f9
            float r6 = r4.f16554d
            r5.f16560c = r6
            int r4 = r4.f16552b
            r5.f16562e = r4
            goto L_0x01f9
        L_0x01f8:
            r7 = 0
        L_0x01f9:
            int r3 = r3 + 1
            goto L_0x01d0
        L_0x01fc:
            r17.m18090d()
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x023a
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x0210
            flyme.support.v4.view.ViewPager$b r3 = r0.mo24944b((android.view.View) r1)
            goto L_0x0211
        L_0x0210:
            r3 = 0
        L_0x0211:
            if (r3 == 0) goto L_0x0219
            int r1 = r3.f16552b
            int r3 = r0.f16529j
            if (r1 == r3) goto L_0x023a
        L_0x0219:
            r1 = 0
        L_0x021a:
            int r3 = r17.getChildCount()
            if (r1 >= r3) goto L_0x023a
            android.view.View r3 = r0.getChildAt(r1)
            flyme.support.v4.view.ViewPager$b r4 = r0.mo24930a((android.view.View) r3)
            if (r4 == 0) goto L_0x0237
            int r4 = r4.f16552b
            int r5 = r0.f16529j
            if (r4 != r5) goto L_0x0237
            boolean r3 = r3.requestFocus(r2)
            if (r3 == 0) goto L_0x0237
            goto L_0x023a
        L_0x0237:
            int r1 = r1 + 1
            goto L_0x021a
        L_0x023a:
            flyme.support.v4.view.ViewPager$FlipMode r1 = flyme.support.p092v4.view.ViewPager.FlipMode.FLIP_MODE_OVERLAY
            flyme.support.v4.view.ViewPager$FlipMode r2 = r0.f16530k
            if (r1 != r2) goto L_0x0243
            r17.mo24888b()
        L_0x0243:
            return
        L_0x0244:
            android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x0251 }
            int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x0251 }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x0251 }
            goto L_0x0259
        L_0x0251:
            int r1 = r17.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x0259:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.append(r4)
            int r4 = r0.f16524c
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class r1 = r17.getClass()
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            androidx.viewpager.widget.PagerAdapter r1 = r0.f16528i
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p092v4.view.ViewPager.mo24931a(int):void");
    }

    /* renamed from: d */
    private void m18090d() {
        int i = 0;
        if (FlipMode.FLIP_MODE_OVERLAY == this.f16530k) {
            if (this.f16522aw == null) {
                this.f16522aw = new LinkedList<>();
            } else {
                this.f16522aw.clear();
            }
            int childCount = getChildCount();
            while (i < childCount) {
                this.f16522aw.add(getChildAt(i));
                i++;
            }
            Collections.sort(this.f16522aw, f16469ay);
        } else if (this.f16521av != 0) {
            if (this.f16522aw == null) {
                this.f16522aw = new LinkedList<>();
            } else {
                this.f16522aw.clear();
            }
            int childCount2 = getChildCount();
            while (i < childCount2) {
                this.f16522aw.add(getChildAt(i));
                i++;
            }
            Collections.sort(this.f16522aw, f16468ax);
        }
    }

    /* renamed from: a */
    private void m18079a(C3051b bVar, int i, C3051b bVar2) {
        C3051b bVar3;
        C3051b bVar4;
        int count = this.f16528i.getCount();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? ((float) this.f16474B) / ((float) clientWidth) : 0.0f;
        if (bVar2 != null) {
            int i2 = bVar2.f16552b;
            if (i2 < bVar.f16552b) {
                float f2 = bVar2.f16555e + bVar2.f16554d + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= bVar.f16552b && i4 < this.f16525f.size()) {
                    Object obj = this.f16525f.get(i4);
                    while (true) {
                        bVar4 = (C3051b) obj;
                        if (i3 > bVar4.f16552b && i4 < this.f16525f.size() - 1) {
                            i4++;
                            obj = this.f16525f.get(i4);
                        }
                    }
                    while (i3 < bVar4.f16552b) {
                        f2 += this.f16528i.getPageWidth(i3) + f;
                        i3++;
                    }
                    bVar4.f16555e = f2;
                    f2 += bVar4.f16554d + f;
                    i3++;
                }
            } else if (i2 > bVar.f16552b) {
                int size = this.f16525f.size() - 1;
                float f3 = bVar2.f16555e;
                while (true) {
                    i2--;
                    if (i2 < bVar.f16552b || size < 0) {
                        break;
                    }
                    Object obj2 = this.f16525f.get(size);
                    while (true) {
                        bVar3 = (C3051b) obj2;
                        if (i2 < bVar3.f16552b && size > 0) {
                            size--;
                            obj2 = this.f16525f.get(size);
                        }
                    }
                    while (i2 > bVar3.f16552b) {
                        f3 -= this.f16528i.getPageWidth(i2) + f;
                        i2--;
                    }
                    f3 -= bVar3.f16554d + f;
                    bVar3.f16555e = f3;
                }
            }
        }
        int size2 = this.f16525f.size();
        float f4 = bVar.f16555e;
        int i5 = bVar.f16552b - 1;
        this.f16478F = bVar.f16552b == 0 ? bVar.f16555e : -3.4028235E38f;
        int i6 = count - 1;
        this.f16479G = bVar.f16552b == i6 ? (bVar.f16555e + bVar.f16554d) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            C3051b bVar5 = this.f16525f.get(i7);
            while (i5 > bVar5.f16552b) {
                f4 -= this.f16528i.getPageWidth(i5) + f;
                i5--;
            }
            f4 -= bVar5.f16554d + f;
            bVar5.f16555e = f4;
            if (bVar5.f16552b == 0) {
                this.f16478F = f4;
            }
            i7--;
            i5--;
        }
        float f5 = bVar.f16555e + bVar.f16554d + f;
        int i8 = bVar.f16552b + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            C3051b bVar6 = this.f16525f.get(i9);
            while (i8 < bVar6.f16552b) {
                f5 += this.f16528i.getPageWidth(i8) + f;
                i8++;
            }
            if (bVar6.f16552b == i6) {
                this.f16479G = (bVar6.f16554d + f5) - 1.0f;
            }
            bVar6.f16555e = f5;
            f5 += bVar6.f16554d + f;
            i9++;
            i8++;
        }
        this.f16512am = false;
    }

    /* renamed from: flyme.support.v4.view.ViewPager$SavedState */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });

        /* renamed from: a */
        int f16548a;

        /* renamed from: b */
        Parcelable f16549b;

        /* renamed from: c */
        ClassLoader f16550c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f16548a);
            parcel.writeParcelable(this.f16549b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f16548a + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f16548a = parcel.readInt();
            this.f16549b = parcel.readParcelable(classLoader);
            this.f16550c = classLoader;
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f16548a = this.f16529j;
        if (this.f16528i != null) {
            savedState.f16549b = this.f16528i.saveState();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.f16528i != null) {
            this.f16528i.restoreState(savedState.f16549b, savedState.f16550c);
            mo24934a(savedState.f16548a, false, true);
            return;
        }
        this.f16542w = savedState.f16548a;
        this.f16543x = savedState.f16549b;
        this.f16544y = savedState.f16550c;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C3052c cVar = (C3052c) layoutParams;
        cVar.f16558a |= view instanceof C3050a;
        if (!this.f16482J) {
            super.addView(view, i, layoutParams);
        } else if (cVar == null || !cVar.f16558a) {
            cVar.f16561d = true;
            addViewInLayout(view, i, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.f16482J) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3051b mo24930a(View view) {
        for (int i = 0; i < this.f16525f.size(); i++) {
            C3051b bVar = this.f16525f.get(i);
            if (this.f16528i.isViewFromObject(view, bVar.f16551a)) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C3051b mo24944b(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return mo24930a(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C3051b mo24943b(int i) {
        for (int i2 = 0; i2 < this.f16525f.size(); i2++) {
            C3051b bVar = this.f16525f.get(i2);
            if (bVar.f16552b == i) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f16511al = true;
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i, int i2) {
        view.measure(i, i2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = 0
            r2 = r17
            int r2 = getDefaultSize(r1, r2)
            r3 = r18
            int r3 = getDefaultSize(r1, r3)
            r0.setMeasuredDimension(r2, r3)
            int r2 = r16.getMeasuredWidth()
            int r3 = r2 / 10
            int r4 = r0.f16488P
            int r3 = java.lang.Math.min(r3, r4)
            r0.f16489Q = r3
            int r3 = r16.getPaddingLeft()
            int r2 = r2 - r3
            int r3 = r16.getPaddingRight()
            int r2 = r2 - r3
            int r3 = r16.getMeasuredHeight()
            int r4 = r16.getPaddingTop()
            int r3 = r3 - r4
            int r4 = r16.getPaddingBottom()
            int r3 = r3 - r4
            int r4 = r16.getChildCount()
            r5 = r3
            r3 = r2
            r2 = 0
        L_0x003f:
            r6 = 8
            r7 = 1
            r8 = 1073741824(0x40000000, float:2.0)
            if (r2 >= r4) goto L_0x00c6
            android.view.View r9 = r0.getChildAt(r2)
            int r10 = r9.getVisibility()
            if (r10 == r6) goto L_0x00c1
            android.view.ViewGroup$LayoutParams r6 = r9.getLayoutParams()
            flyme.support.v4.view.ViewPager$c r6 = (flyme.support.p092v4.view.ViewPager.C3052c) r6
            if (r6 == 0) goto L_0x00c1
            boolean r10 = r6.f16558a
            if (r10 == 0) goto L_0x00c1
            int r10 = r6.f16559b
            r10 = r10 & 7
            int r11 = r6.f16559b
            r11 = r11 & 112(0x70, float:1.57E-43)
            r12 = 48
            if (r11 == r12) goto L_0x006f
            r12 = 80
            if (r11 != r12) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r11 = 0
            goto L_0x0070
        L_0x006f:
            r11 = 1
        L_0x0070:
            r12 = 3
            if (r10 == r12) goto L_0x0078
            r12 = 5
            if (r10 != r12) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r7 = 0
        L_0x0078:
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r11 == 0) goto L_0x0081
            r10 = 1073741824(0x40000000, float:2.0)
        L_0x007e:
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0085
        L_0x0081:
            if (r7 == 0) goto L_0x007e
            r12 = 1073741824(0x40000000, float:2.0)
        L_0x0085:
            int r13 = r6.width
            r14 = -1
            r15 = -2
            if (r13 == r15) goto L_0x0097
            int r10 = r6.width
            if (r10 == r14) goto L_0x0093
            int r10 = r6.width
            r13 = r10
            goto L_0x0094
        L_0x0093:
            r13 = r3
        L_0x0094:
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x0098
        L_0x0097:
            r13 = r3
        L_0x0098:
            int r1 = r6.height
            if (r1 == r15) goto L_0x00a5
            int r1 = r6.height
            if (r1 == r14) goto L_0x00a3
            int r1 = r6.height
            goto L_0x00a7
        L_0x00a3:
            r1 = r5
            goto L_0x00a7
        L_0x00a5:
            r1 = r5
            r8 = r12
        L_0x00a7:
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r13, r10)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            r0.measureChild(r9, r6, r1)
            if (r11 == 0) goto L_0x00ba
            int r1 = r9.getMeasuredHeight()
            int r5 = r5 - r1
            goto L_0x00c1
        L_0x00ba:
            if (r7 == 0) goto L_0x00c1
            int r1 = r9.getMeasuredWidth()
            int r3 = r3 - r1
        L_0x00c1:
            int r2 = r2 + 1
            r1 = 0
            goto L_0x003f
        L_0x00c6:
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r8)
            r0.f16480H = r1
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
            r0.f16481I = r1
            r0.f16482J = r7
            r16.mo24957g()
            r1 = 0
            r0.f16482J = r1
            int r2 = r16.getChildCount()
        L_0x00de:
            if (r1 >= r2) goto L_0x0108
            android.view.View r4 = r0.getChildAt(r1)
            int r5 = r4.getVisibility()
            if (r5 == r6) goto L_0x0105
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            flyme.support.v4.view.ViewPager$c r5 = (flyme.support.p092v4.view.ViewPager.C3052c) r5
            if (r5 == 0) goto L_0x00f6
            boolean r7 = r5.f16558a
            if (r7 != 0) goto L_0x0105
        L_0x00f6:
            float r7 = (float) r3
            float r5 = r5.f16560c
            float r7 = r7 * r5
            int r5 = (int) r7
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
            int r7 = r0.f16481I
            r0.measureChild(r4, r5, r7)
        L_0x0105:
            int r1 = r1 + 1
            goto L_0x00de
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p092v4.view.ViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m18076a(i, i3, this.f16474B, this.f16474B);
        }
    }

    /* renamed from: a */
    private void m18076a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f16525f.isEmpty()) {
            C3051b b = mo24943b(this.f16529j);
            int min = (int) ((b != null ? Math.min(b.f16555e, this.f16479G) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m18081a(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = ((i - getPaddingLeft()) - getPaddingRight()) + i3;
        int scrollX = (int) ((((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))) * ((float) paddingLeft));
        scrollTo(scrollX, getScrollY());
        int duration = this.f16545z.getDuration() - this.f16545z.timePassed();
        C3051b b2 = mo24943b(this.f16529j);
        if (b2 != null) {
            this.f16545z.startScroll(scrollX, 0, (int) ((b2.f16555e * ((float) i)) - ((float) scrollX)), 0, duration);
        } else {
            this.f16545z.startScroll(scrollX, 0, -(scrollX % paddingLeft), 0, duration);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean z2;
        C3051b a;
        int i6;
        int i7;
        int childCount = getChildCount();
        int i8 = i3 - i;
        int i9 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i10 = paddingBottom;
        int i11 = 0;
        int i12 = paddingTop;
        int i13 = paddingLeft;
        int i14 = 0;
        while (true) {
            i5 = 8;
            if (i14 >= childCount) {
                break;
            }
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                C3052c cVar = (C3052c) childAt.getLayoutParams();
                if (cVar.f16558a) {
                    int i15 = cVar.f16559b & 7;
                    int i16 = cVar.f16559b & 112;
                    if (i15 == 1) {
                        i6 = Math.max((i8 - childAt.getMeasuredWidth()) / 2, i13);
                    } else if (i15 == 3) {
                        i6 = i13;
                        i13 = childAt.getMeasuredWidth() + i13;
                    } else if (i15 != 5) {
                        i6 = i13;
                    } else {
                        i6 = (i8 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i16 == 16) {
                        i7 = Math.max((i9 - childAt.getMeasuredHeight()) / 2, i12);
                    } else if (i16 == 48) {
                        i7 = i12;
                        i12 = childAt.getMeasuredHeight() + i12;
                    } else if (i16 != 80) {
                        i7 = i12;
                    } else {
                        i7 = (i9 - i10) - childAt.getMeasuredHeight();
                        i10 += childAt.getMeasuredHeight();
                    }
                    int i17 = i6 + scrollX;
                    childAt.layout(i17, i7, childAt.getMeasuredWidth() + i17, i7 + childAt.getMeasuredHeight());
                    i11++;
                }
            }
            i14++;
        }
        int i18 = (i8 - i13) - paddingRight;
        int i19 = 0;
        while (i19 < childCount) {
            View childAt2 = getChildAt(i19);
            if (childAt2.getVisibility() != i5) {
                C3052c cVar2 = (C3052c) childAt2.getLayoutParams();
                if (!cVar2.f16558a && (a = mo24930a(childAt2)) != null) {
                    float f = (float) i18;
                    int i20 = ((int) (a.f16555e * f)) + i13;
                    if (cVar2.f16561d) {
                        cVar2.f16561d = false;
                        measureChild(childAt2, View.MeasureSpec.makeMeasureSpec((int) (f * cVar2.f16560c), 1073741824), View.MeasureSpec.makeMeasureSpec((i9 - i12) - i10, 1073741824));
                    }
                    a.f16556f = childAt2;
                    childAt2.layout(i20, i12, childAt2.getMeasuredWidth() + i20, childAt2.getMeasuredHeight() + i12);
                }
            }
            i19++;
            i5 = 8;
        }
        this.f16476D = i12;
        this.f16477E = i9 - i10;
        this.f16514ao = i11;
        if (FlipMode.FLIP_MODE_OVERLAY == this.f16530k) {
            this.f16531l = true;
            mo24888b();
            m18091d(scrollX);
        }
        if (this.f16511al) {
            z2 = false;
            m18077a(this.f16529j, false, 0, false);
        } else {
            z2 = false;
        }
        this.f16511al = z2;
    }

    public void computeScroll() {
        if (this.f16545z.isFinished() || !this.f16545z.computeScrollOffset()) {
            m18081a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f16545z.getCurrX();
        int currY = this.f16545z.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            if (FlipMode.FLIP_MODE_OVERLAY == this.f16530k) {
                m18091d(currX);
            }
            scrollTo(currX, currY);
            if (!m18092e(currX)) {
                this.f16545z.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* renamed from: d */
    private void m18091d(int i) {
        int i2;
        int i3;
        int i4;
        C3051b bVar;
        int i5 = i;
        if (this.f16525f.size() != 0) {
            int paddingLeft = getPaddingLeft();
            int clientWidth = getClientWidth();
            int size = this.f16532m >= this.f16525f.size() ? this.f16525f.size() - 1 : this.f16532m < 0 ? 0 : this.f16532m;
            float f = (float) clientWidth;
            int i6 = ((int) (this.f16525f.get(size).f16555e * f)) + paddingLeft;
            View view = this.f16525f.get(size).f16556f;
            int i7 = size - 1;
            C3051b bVar2 = i7 >= 0 ? this.f16525f.get(i7) : null;
            int i8 = size + 1;
            C3051b bVar3 = i8 < this.f16525f.size() ? this.f16525f.get(i8) : null;
            View view2 = bVar2 != null ? bVar2.f16556f : null;
            View view3 = bVar3 != null ? bVar3.f16556f : null;
            int i9 = i5 - i6;
            if (i9 >= (this.f16474B / 2) + clientWidth) {
                size = i8;
            } else if (i9 <= (-((this.f16474B / 2) + clientWidth))) {
                size = i7;
            }
            if (size < 0) {
                size = 0;
            } else if (size >= this.f16525f.size()) {
                size = this.f16525f.size() - 1;
            }
            if (this.f16532m != size) {
                this.f16532m = size;
                i6 = ((int) (this.f16525f.get(size).f16555e * f)) + paddingLeft;
                view = this.f16525f.get(size).f16556f;
                if (view != null) {
                    view.offsetLeftAndRight(i6 - view.getLeft());
                }
                if (size + 2 < this.f16525f.size() && view3 != null) {
                    view3.offsetLeftAndRight((((int) (bVar3.f16555e * f)) + paddingLeft) - view3.getLeft());
                }
                if (size - 2 >= 0 && view2 != null) {
                    view2.offsetLeftAndRight((((int) (bVar2.f16555e * f)) + paddingLeft) - view2.getLeft());
                }
                int i10 = size - 1;
                if (i10 >= 0) {
                    bVar = this.f16525f.get(i10);
                    i4 = 1;
                } else {
                    i4 = 1;
                    bVar = null;
                }
                int i11 = size + i4;
                bVar3 = i11 < this.f16525f.size() ? this.f16525f.get(i11) : null;
                view2 = bVar2 != null ? bVar2.f16556f : null;
                view3 = bVar3 != null ? bVar3.f16556f : null;
                i9 = i5 - i6;
            }
            if (view != null) {
                this.f16536q = view.getMeasuredHeight();
                this.f16537r = view.getTop();
                C3051b bVar4 = (this.f16533n < 0 || this.f16533n >= this.f16525f.size()) ? null : this.f16525f.get(this.f16533n);
                int i12 = bVar4 != null ? ((int) (bVar4.f16555e * f)) + paddingLeft : 0;
                if (bVar3 == null || view3 == null) {
                    i3 = 0;
                    i2 = 0;
                } else {
                    i3 = ((int) (bVar3.f16555e * f)) + paddingLeft;
                    i2 = ((i3 - (clientWidth / 2)) - (this.f16474B / 2)) + (i9 / 2);
                }
                int i13 = (bVar2 == null || view2 == null) ? 0 : paddingLeft + ((int) (f * bVar2.f16555e));
                if ((bVar4 != null && i5 == i12) || i5 == i6) {
                    this.f16534o = false;
                    if (view3 != null) {
                        view3.offsetLeftAndRight(i3 - view3.getLeft());
                    }
                    if (view2 != null) {
                        view2.offsetLeftAndRight(i13 - view2.getLeft());
                    }
                    view.offsetLeftAndRight(i6 - view.getLeft());
                } else if (i9 >= 0 && view3 != null) {
                    this.f16535p = view.getRight();
                    this.f16540u = (int) (102.0d - (((((double) i9) * 1.0d) / ((double) clientWidth)) * 102.0d));
                    this.f16534o = true;
                    view3.offsetLeftAndRight(i2 - view3.getLeft());
                } else if (i9 < 0 && view2 != null) {
                    this.f16535p = view2.getRight();
                    this.f16540u = (int) (((((double) (-i9)) * 1.0d) / ((double) clientWidth)) * 102.0d);
                    this.f16534o = true;
                    view.offsetLeftAndRight((i6 + (i9 / 2)) - view.getLeft());
                }
            }
        }
    }

    /* renamed from: e */
    private boolean m18092e(int i) {
        if (this.f16525f.size() == 0) {
            this.f16513an = false;
            mo24932a(0, 0.0f, 0);
            if (this.f16513an) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C3051b m = m18097m();
        int clientWidth = getClientWidth();
        int i2 = this.f16474B + clientWidth;
        float f = (float) clientWidth;
        float f2 = ((float) this.f16474B) / f;
        int i3 = m.f16552b;
        float f3 = ((((float) i) / f) - m.f16555e) / (m.f16554d + f2);
        this.f16513an = false;
        mo24932a(i3, f3, (int) (((float) i2) * f3));
        if (this.f16513an) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063  */
    @androidx.annotation.CallSuper
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo24932a(int r12, float r13, int r14) {
        /*
            r11 = this;
            int r0 = r11.f16514ao
            r1 = 1
            if (r0 <= 0) goto L_0x006a
            int r0 = r11.getScrollX()
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r4 = r11.getWidth()
            int r5 = r11.getChildCount()
            r6 = 0
        L_0x001a:
            if (r6 >= r5) goto L_0x006a
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            flyme.support.v4.view.ViewPager$c r8 = (flyme.support.p092v4.view.ViewPager.C3052c) r8
            boolean r9 = r8.f16558a
            if (r9 != 0) goto L_0x002b
            goto L_0x0067
        L_0x002b:
            int r8 = r8.f16559b
            r8 = r8 & 7
            if (r8 == r1) goto L_0x004c
            r9 = 3
            if (r8 == r9) goto L_0x0046
            r9 = 5
            if (r8 == r9) goto L_0x0039
            r8 = r2
            goto L_0x005b
        L_0x0039:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredWidth()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredWidth()
            int r3 = r3 + r9
            goto L_0x0058
        L_0x0046:
            int r8 = r7.getWidth()
            int r8 = r8 + r2
            goto L_0x005b
        L_0x004c:
            int r8 = r7.getMeasuredWidth()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
        L_0x0058:
            r10 = r8
            r8 = r2
            r2 = r10
        L_0x005b:
            int r2 = r2 + r0
            int r9 = r7.getLeft()
            int r2 = r2 - r9
            if (r2 == 0) goto L_0x0066
            r7.offsetLeftAndRight(r2)
        L_0x0066:
            r2 = r8
        L_0x0067:
            int r6 = r6 + 1
            goto L_0x001a
        L_0x006a:
            r11.m18086b(r12, r13, r14)
            r11.mo24967h()
            r11.f16513an = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p092v4.view.ViewPager.mo24932a(int, float, int):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo24967h() {
        if (this.f16519at != null) {
            int scrollX = getScrollX();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (!((C3052c) childAt.getLayoutParams()).f16558a) {
                    this.f16519at.mo24908a(childAt, ((float) (childAt.getLeft() - scrollX)) / ((float) getClientWidth()));
                }
            }
        }
    }

    /* renamed from: b */
    private void m18086b(int i, float f, int i2) {
        if (this.f16516aq != null) {
            this.f16516aq.mo17730a(i, f, i2);
        }
        if (this.f16515ap != null) {
            int size = this.f16515ap.size();
            for (int i3 = 0; i3 < size; i3++) {
                C3054e eVar = this.f16515ap.get(i3);
                if (eVar != null) {
                    eVar.mo17730a(i, f, i2);
                }
            }
        }
        if (this.f16517ar != null) {
            this.f16517ar.mo17730a(i, f, i2);
        }
    }

    /* renamed from: f */
    private void m18093f(int i) {
        if (this.f16516aq != null) {
            this.f16516aq.mo17729a(i);
        }
        if (this.f16515ap != null) {
            int size = this.f16515ap.size();
            for (int i2 = 0; i2 < size; i2++) {
                C3054e eVar = this.f16515ap.get(i2);
                if (eVar != null) {
                    eVar.mo17729a(i);
                }
            }
        }
        if (this.f16517ar != null) {
            this.f16517ar.mo17729a(i);
        }
    }

    /* renamed from: g */
    private void m18094g(int i) {
        if (this.f16516aq != null) {
            this.f16516aq.mo17731b(i);
        }
        if (this.f16515ap != null) {
            int size = this.f16515ap.size();
            for (int i2 = 0; i2 < size; i2++) {
                C3054e eVar = this.f16515ap.get(i2);
                if (eVar != null) {
                    eVar.mo17731b(i);
                }
            }
        }
        if (this.f16517ar != null) {
            this.f16517ar.mo17731b(i);
        }
    }

    /* renamed from: a */
    private void m18081a(boolean z) {
        boolean z2 = this.f16496aA == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f16545z.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f16545z.getCurrX();
            int currY = this.f16545z.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
                if (currX != scrollX) {
                    m18092e(currX);
                }
            }
        }
        this.f16484L = false;
        boolean z3 = z2;
        for (int i = 0; i < this.f16525f.size(); i++) {
            C3051b bVar = this.f16525f.get(i);
            if (bVar.f16553c) {
                bVar.f16553c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            ViewCompat.postOnAnimation(this, this.f16523az);
        } else {
            this.f16523az.run();
        }
    }

    /* renamed from: a */
    private boolean m18082a(float f, float f2) {
        return (f < ((float) this.f16489Q) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f16489Q)) && f2 < 0.0f);
    }

    /* renamed from: b */
    private void m18087b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewCompat.setLayerType(getChildAt(i), z ? 2 : 0, (Paint) null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            if (action == 1 && this.f16486N) {
                VelocityTracker velocityTracker = this.f16500aa;
                velocityTracker.computeCurrentVelocity(1000, (float) this.f16502ac);
                int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.f16495W);
                this.f16484L = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                C3051b m = m18097m();
                int i = m.f16552b;
                float f = ((((float) scrollX) / ((float) clientWidth)) - m.f16555e) / m.f16554d;
                int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent2, this.f16495W);
                if (findPointerIndex == -1) {
                    Log.e("ViewPager", "Invalid pointerId=" + this.f16495W + " in onTouchEvent ACTION_UP");
                } else {
                    mo24935a(m18072a(i, f, xVelocity, (int) (MotionEventCompat.getX(motionEvent2, findPointerIndex) - this.f16493U)), true, true, xVelocity);
                    this.f16495W = -1;
                    m18100p();
                    if (this.f16509aj.onRelease() || this.f16510ak.onRelease()) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                }
            }
            this.f16486N = false;
            this.f16487O = false;
            this.f16495W = -1;
            if (this.f16500aa != null) {
                this.f16500aa.recycle();
                this.f16500aa = null;
            }
            return false;
        }
        if (action != 0) {
            if (this.f16486N) {
                return true;
            }
            if (this.f16487O) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.f16493U = x;
            this.f16491S = x;
            float y = motionEvent.getY();
            this.f16494V = y;
            this.f16492T = y;
            this.f16495W = MotionEventCompat.getPointerId(motionEvent2, 0);
            this.f16487O = false;
            this.f16545z.computeScrollOffset();
            if (this.f16496aA != 2 || Math.abs(this.f16545z.getFinalX() - this.f16545z.getCurrX()) <= this.f16504ae) {
                m18081a(false);
                this.f16486N = false;
            } else {
                this.f16545z.abortAnimation();
                this.f16484L = false;
                mo24957g();
                this.f16486N = true;
                m18088c(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.f16495W;
            if (i2 != -1) {
                int findPointerIndex2 = MotionEventCompat.findPointerIndex(motionEvent2, i2);
                if (findPointerIndex2 == -1) {
                    Log.e("ViewPager", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent ACTION_MOVE");
                } else {
                    float x2 = MotionEventCompat.getX(motionEvent2, findPointerIndex2);
                    float f2 = x2 - this.f16491S;
                    float abs = Math.abs(f2);
                    float y2 = MotionEventCompat.getY(motionEvent2, findPointerIndex2);
                    float abs2 = Math.abs(y2 - this.f16494V);
                    int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    if (i3 != 0 && !m18082a(this.f16491S, f2)) {
                        if (mo24938a(this, false, (int) f2, (int) x2, (int) y2)) {
                            this.f16491S = x2;
                            this.f16492T = y2;
                            this.f16487O = true;
                            return false;
                        }
                    }
                    if (abs >= ((float) this.f16507ah) || abs2 >= ((float) this.f16507ah) || !m18083a(motionEvent2, this.f16505af)) {
                        if (abs > ((float) this.f16490R) && abs > abs2) {
                            this.f16486N = true;
                            m18088c(true);
                            setScrollState(1);
                            this.f16491S = i3 > 0 ? this.f16493U + ((float) this.f16490R) : this.f16493U - ((float) this.f16490R);
                            this.f16492T = y2;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f16490R)) {
                            this.f16487O = true;
                        }
                        if (this.f16486N && m18089c(x2)) {
                            ViewCompat.postInvalidateOnAnimation(this);
                        }
                    } else {
                        if (f16464a) {
                            Log.d("ViewPager", "xDiff = " + abs + ", yDiff = " + abs2 + ", mTouchSlopAdj = " + this.f16507ah);
                        }
                        return false;
                    }
                }
            }
        } else if (action == 6) {
            m18078a(motionEvent);
        }
        if (this.f16500aa == null) {
            this.f16500aa = VelocityTracker.obtain();
        }
        this.f16500aa.addMovement(motionEvent2);
        return this.f16486N;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f16508ai) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || this.f16528i == null || this.f16528i.getCount() == 0 || this.f16525f == null || this.f16525f.size() == 0) {
            return false;
        }
        if (this.f16500aa == null) {
            this.f16500aa = VelocityTracker.obtain();
        }
        this.f16500aa.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f16545z.abortAnimation();
                this.f16484L = false;
                mo24957g();
                float x = motionEvent.getX();
                this.f16493U = x;
                this.f16491S = x;
                float y = motionEvent.getY();
                this.f16494V = y;
                this.f16492T = y;
                this.f16495W = MotionEventCompat.getPointerId(motionEvent, 0);
                break;
            case 1:
                if (this.f16486N) {
                    VelocityTracker velocityTracker = this.f16500aa;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f16502ac);
                    int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.f16495W);
                    this.f16484L = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    C3051b m = m18097m();
                    int i = m.f16552b;
                    float f = ((((float) scrollX) / ((float) clientWidth)) - m.f16555e) / m.f16554d;
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f16495W);
                    if (findPointerIndex == -1) {
                        if (f16464a) {
                            Log.e("ViewPager", "Invalid pointerId=" + this.f16495W + " in onTouchEvent ACTION_UP");
                            break;
                        }
                    } else {
                        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                        if (findPointerIndex >= 0 && findPointerIndex < pointerCount) {
                            if (FlipMode.FLIP_MODE_OVERLAY == this.f16530k) {
                                setInterpolator(f16472e);
                            }
                            mo24935a(m18072a(i, f, xVelocity, (int) (MotionEventCompat.getX(motionEvent, findPointerIndex) - this.f16493U)), true, true, xVelocity);
                            this.f16495W = -1;
                            m18100p();
                            z = this.f16509aj.onRelease() | this.f16510ak.onRelease();
                            break;
                        } else {
                            mo24934a(i, true, true);
                            this.f16495W = -1;
                            m18100p();
                            z = this.f16509aj.onRelease() | this.f16510ak.onRelease();
                            break;
                        }
                    }
                }
                break;
            case 2:
                if (this.f16498aE != f16472e) {
                    this.f16499aF = this.f16498aE;
                    setInterpolator(f16472e);
                }
                if (!this.f16486N) {
                    int findPointerIndex2 = MotionEventCompat.findPointerIndex(motionEvent, this.f16495W);
                    if (findPointerIndex2 == -1) {
                        if (f16464a) {
                            Log.e("ViewPager", "Invalid pointerId=" + this.f16495W + " in onTouchEvent ACTION_MOVE");
                            break;
                        }
                    } else {
                        float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex2);
                        float abs = Math.abs(x2 - this.f16491S);
                        float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex2);
                        float abs2 = Math.abs(y2 - this.f16492T);
                        if (abs > ((float) this.f16490R) && abs > abs2) {
                            this.f16486N = true;
                            m18088c(true);
                            this.f16491S = x2 - this.f16493U > 0.0f ? this.f16493U + ((float) this.f16490R) : this.f16493U - ((float) this.f16490R);
                            this.f16492T = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.f16486N) {
                    int findPointerIndex3 = MotionEventCompat.findPointerIndex(motionEvent, this.f16495W);
                    int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
                    if (findPointerIndex3 >= 0 && findPointerIndex3 < pointerCount2) {
                        z = false | m18089c(MotionEventCompat.getX(motionEvent, findPointerIndex3));
                        break;
                    }
                }
                break;
            case 3:
                if (this.f16486N) {
                    m18077a(this.f16529j, true, 0, false);
                    this.f16495W = -1;
                    m18100p();
                    z = this.f16509aj.onRelease() | this.f16510ak.onRelease();
                    break;
                }
                break;
            case 5:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.f16491S = MotionEventCompat.getX(motionEvent, actionIndex);
                this.f16495W = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                break;
            case 6:
                m18078a(motionEvent);
                this.f16491S = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f16495W));
                break;
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    /* renamed from: c */
    private void m18088c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: c */
    private boolean m18089c(float f) {
        boolean z;
        float f2 = this.f16491S - f;
        this.f16491S = f;
        float scrollX = ((float) getScrollX()) + mo24886a(f2);
        float clientWidth = (float) getClientWidth();
        float f3 = this.f16478F * clientWidth;
        float f4 = this.f16479G * clientWidth;
        boolean z2 = false;
        C3051b bVar = this.f16525f.get(0);
        boolean z3 = true;
        C3051b bVar2 = this.f16525f.get(this.f16525f.size() - 1);
        if (bVar.f16552b != 0) {
            f3 = bVar.f16555e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.f16552b != this.f16528i.getCount() - 1) {
            f4 = bVar2.f16555e * clientWidth;
            z3 = false;
        }
        if (scrollX < f3) {
            if (z) {
                z2 = this.f16509aj.onPull(Math.abs(f3 - scrollX) / clientWidth);
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z3) {
                z2 = this.f16510ak.onPull(Math.abs(scrollX - f4) / clientWidth);
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.f16491S += scrollX - ((float) i);
        if (FlipMode.FLIP_MODE_OVERLAY == this.f16530k) {
            m18091d(i);
        }
        scrollTo(i, getScrollY());
        m18092e(i);
        return z2;
    }

    /* renamed from: m */
    private C3051b m18097m() {
        int i;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.f16474B) / ((float) clientWidth) : 0.0f;
        C3051b bVar = null;
        int i2 = 0;
        boolean z = true;
        int i3 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i2 < this.f16525f.size()) {
            C3051b bVar2 = this.f16525f.get(i2);
            if (!z && bVar2.f16552b != (i = i3 + 1)) {
                bVar2 = this.f16526g;
                bVar2.f16555e = f2 + f3 + f;
                bVar2.f16552b = i;
                bVar2.f16554d = this.f16528i.getPageWidth(bVar2.f16552b);
                i2--;
            }
            f2 = bVar2.f16555e;
            float f4 = bVar2.f16554d + f2 + f;
            if (!z && scrollX < f2) {
                return bVar;
            }
            if (scrollX < f4 || i2 == this.f16525f.size() - 1) {
                return bVar2;
            }
            i3 = bVar2.f16552b;
            f3 = bVar2.f16554d;
            i2++;
            bVar = bVar2;
            z = false;
        }
        return bVar;
    }

    public void setMinAutoFlingDistance(float f) {
        this.f16497aB = f;
    }

    /* renamed from: a */
    private int m18072a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f16503ad || !mo24889c() || Math.abs(i2) <= this.f16501ab) {
            if (this.f16529j > i) {
                if (1.0f - f < this.f16497aB) {
                    i++;
                }
            } else if (f >= this.f16497aB) {
                i++;
            }
        } else if (i2 <= 0) {
            i++;
        }
        return this.f16525f.size() > 0 ? Math.max(this.f16525f.get(0).f16552b, Math.min(i, this.f16525f.get(this.f16525f.size() - 1).f16552b)) : i;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    /* renamed from: n */
    private boolean m18098n() {
        if (this.f16531l) {
            this.f16531l = false;
            if (this.f16538s != null) {
                this.f16538s.setBounds(0, 0, this.f16538s.getIntrinsicWidth(), this.f16536q);
            }
            if (this.f16539t != null) {
                this.f16539t.setBounds(0, 0, getClientWidth(), this.f16536q);
            }
            if (this.f16538s == null || this.f16539t == null) {
                return false;
            }
            return true;
        } else if (this.f16538s == null || this.f16539t == null) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: o */
    private boolean m18099o() {
        return m18098n();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (FlipMode.FLIP_MODE_OVERLAY == this.f16530k && this.f16534o && m18099o()) {
            canvas.save();
            canvas.translate((float) this.f16535p, (float) this.f16537r);
            this.f16538s.draw(canvas);
            this.f16539t.setAlpha(this.f16540u);
            this.f16539t.draw(canvas);
            canvas.restore();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.f16474B > 0 && this.f16475C != null && this.f16525f.size() > 0 && this.f16528i != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f4 = (float) width;
            float f5 = ((float) this.f16474B) / f4;
            int i = 0;
            C3051b bVar = this.f16525f.get(0);
            float f6 = bVar.f16555e;
            int size = this.f16525f.size();
            int i2 = bVar.f16552b;
            int i3 = this.f16525f.get(size - 1).f16552b;
            while (i2 < i3) {
                while (i2 > bVar.f16552b && i < size) {
                    i++;
                    bVar = this.f16525f.get(i);
                }
                if (i2 == bVar.f16552b) {
                    f2 = (bVar.f16555e + bVar.f16554d) * f4;
                    f = bVar.f16555e + bVar.f16554d + f5;
                } else {
                    float pageWidth = this.f16528i.getPageWidth(i2);
                    f = f6 + pageWidth + f5;
                    f2 = (f6 + pageWidth) * f4;
                }
                if (((float) this.f16474B) + f2 > ((float) scrollX)) {
                    f3 = f5;
                    this.f16475C.setBounds((int) f2, this.f16476D, (int) (((float) this.f16474B) + f2 + 0.5f), this.f16477E);
                    this.f16475C.draw(canvas);
                } else {
                    Canvas canvas2 = canvas;
                    f3 = f5;
                }
                if (f2 <= ((float) (scrollX + width))) {
                    i2++;
                    f6 = f;
                    f5 = f3;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m18078a(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f16495W) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f16491S = MotionEventCompat.getX(motionEvent, i);
            this.f16495W = MotionEventCompat.getPointerId(motionEvent, i);
            if (this.f16500aa != null) {
                this.f16500aa.clear();
            }
        }
    }

    /* renamed from: p */
    private void m18100p() {
        this.f16486N = false;
        this.f16487O = false;
        if (this.f16500aa != null) {
            this.f16500aa.recycle();
            this.f16500aa = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f16483K != z) {
            this.f16483K = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        if (this.f16528i == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.f16478F))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollX >= ((int) (((float) clientWidth) * this.f16479G))) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo24938a(View view, boolean z, int i, int i2, int i3) {
        int i4;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom()) {
                    if (mo24938a(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z || !ViewCompat.canScrollHorizontally(view, -i)) {
            return false;
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || mo24937a(keyEvent);
    }

    /* renamed from: a */
    public boolean mo24937a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                switch (keyCode) {
                    case 21:
                        return mo24946c(17);
                    case 22:
                        return mo24946c(66);
                }
            } else if (Build.VERSION.SDK_INT >= 11) {
                if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
                    return mo24946c(2);
                }
                if (KeyEvent.metaStateHasModifiers(keyEvent.getMetaState(), 1)) {
                    return mo24946c(1);
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public boolean mo24946c(int i) {
        boolean requestFocus;
        boolean z;
        View findFocus = findFocus();
        boolean z2 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus != null && findNextFocus != view) {
            if (i == 17) {
                int i2 = m18073a(this.f16527h, findNextFocus).left;
                int i3 = m18073a(this.f16527h, view).left;
                if (view == null || i2 < i3) {
                    requestFocus = findNextFocus.requestFocus();
                } else {
                    requestFocus = mo24968i();
                }
            } else if (i == 66) {
                int i4 = m18073a(this.f16527h, findNextFocus).left;
                int i5 = m18073a(this.f16527h, view).left;
                if (view == null || i4 > i5) {
                    requestFocus = findNextFocus.requestFocus();
                } else {
                    requestFocus = mo24969j();
                }
            }
            z2 = requestFocus;
        } else if (i == 17 || i == 1) {
            z2 = mo24968i();
        } else if (i == 66 || i == 2) {
            z2 = mo24969j();
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z2;
    }

    /* renamed from: a */
    private Rect m18073a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo24968i() {
        if (this.f16529j <= 0) {
            return false;
        }
        setCurrentItem(this.f16529j - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public boolean mo24969j() {
        if (this.f16528i == null || this.f16529j >= this.f16528i.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.f16529j + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        C3051b a;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (a = mo24930a(childAt)) != null && a.f16552b == this.f16529j) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        C3051b a;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a = mo24930a(childAt)) != null && a.f16552b == this.f16529j) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        C3051b a;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i3 = 0;
            i2 = 1;
        } else {
            i3 = childCount - 1;
            i2 = -1;
        }
        while (i3 != i4) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (a = mo24930a(childAt)) != null && a.f16552b == this.f16529j && childAt.requestFocus(i, rect)) {
                return true;
            }
            i3 += i2;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C3051b a;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a = mo24930a(childAt)) != null && a.f16552b == this.f16529j && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public void setFlipMode(FlipMode flipMode) {
        if (this.f16530k != flipMode) {
            this.f16530k = flipMode;
            if (FlipMode.FLIP_MODE_OVERLAY == this.f16530k) {
                this.f16474B = 0;
                mo24888b();
                setChildrenDrawingOrderEnabledCompat(true);
            } else {
                setChildrenDrawingOrderEnabledCompat(false);
            }
            m18090d();
            requestLayout();
        }
    }

    public FlipMode getFlipMode() {
        return this.f16530k;
    }

    public void setShadowResource(int i, int i2) {
        if (i != 0) {
            this.f16538s = getContext().getResources().getDrawable(i);
            this.f16531l = true;
        }
        if (i2 != 0) {
            this.f16539t = getContext().getResources().getDrawable(i2);
            this.f16531l = true;
        }
    }

    public void setShadow(Drawable drawable, Drawable drawable2) {
        if (drawable != this.f16538s) {
            this.f16538s = drawable;
            this.f16531l = true;
        }
        if (drawable2 != this.f16539t) {
            this.f16539t = drawable2;
            this.f16531l = true;
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        if (this.f16545z != null && !this.f16545z.isFinished()) {
            this.f16545z.forceFinished(true);
        }
        if (interpolator != null && this.f16498aE != interpolator) {
            this.f16498aE = interpolator;
            this.f16545z = new Scroller(this.f16541v, interpolator);
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C3052c();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C3052c) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C3052c(getContext(), attributeSet);
    }

    /* renamed from: flyme.support.v4.view.ViewPager$MyAccessibilityDelegate */
    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
            obtain.setScrollable(m18125a());
            if (accessibilityEvent.getEventType() == 4096 && ViewPager.this.f16528i != null) {
                obtain.setItemCount(ViewPager.this.f16528i.getCount());
                obtain.setFromIndex(ViewPager.this.f16529j);
                obtain.setToIndex(ViewPager.this.f16529j);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(m18125a());
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager.this.setCurrentItem(ViewPager.this.f16529j - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager.this.setCurrentItem(ViewPager.this.f16529j + 1);
                return true;
            }
        }

        /* renamed from: a */
        private boolean m18125a() {
            return ViewPager.this.f16528i != null && ViewPager.this.f16528i.getCount() > 1;
        }
    }

    /* renamed from: flyme.support.v4.view.ViewPager$g */
    private class C3056g extends DataSetObserver {
        private C3056g() {
        }

        public void onChanged() {
            ViewPager.this.mo24956f();
        }

        public void onInvalidated() {
            ViewPager.this.mo24956f();
        }
    }

    /* renamed from: flyme.support.v4.view.ViewPager$c */
    public static class C3052c extends ViewGroup.LayoutParams {

        /* renamed from: a */
        public boolean f16558a;

        /* renamed from: b */
        public int f16559b;

        /* renamed from: c */
        float f16560c = 0.0f;

        /* renamed from: d */
        boolean f16561d;

        /* renamed from: e */
        int f16562e;

        /* renamed from: f */
        int f16563f;

        public C3052c() {
            super(-1, -1);
        }

        public C3052c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f16470b);
            this.f16559b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: flyme.support.v4.view.ViewPager$h */
    static class C3057h implements Comparator<View> {
        C3057h() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            C3052c cVar = (C3052c) view.getLayoutParams();
            C3052c cVar2 = (C3052c) view2.getLayoutParams();
            if (cVar.f16558a != cVar2.f16558a) {
                return cVar.f16558a ? 1 : -1;
            }
            return cVar.f16562e - cVar2.f16562e;
        }
    }

    public void setRectSlopScaleInTab(int i, int i2, int i3, int i4, float f, int i5) {
        this.f16505af = new Rect();
        this.f16505af.left = i;
        this.f16505af.top = i2;
        this.f16505af.right = i3;
        this.f16505af.bottom = i4;
        this.f16507ah = (int) (((float) this.f16490R) * f);
        this.f16506ag = i5;
        if (f16464a) {
            Log.d("ViewPager", "setRectSlopScaleInTab mSpecRect = " + this.f16505af + ", coef = " + f + ", specTab = " + this.f16506ag);
        }
    }

    /* renamed from: a */
    private boolean m18083a(MotionEvent motionEvent, Rect rect) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (f16464a) {
            Log.d("ViewPager", "pointInRect x = " + rawX + ", y = " + rawY + ", rect = " + rect);
        }
        if (rect == null || this.f16529j != this.f16506ag || rawX < ((float) rect.left) || rawX > ((float) rect.right) || rawY < ((float) rect.top) || rawY > ((float) rect.bottom)) {
            return false;
        }
        return true;
    }

    /* renamed from: flyme.support.v4.view.ViewPager$i */
    static class C3058i implements Comparator<View> {
        C3058i() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            C3052c cVar = (C3052c) view.getLayoutParams();
            C3052c cVar2 = (C3052c) view2.getLayoutParams();
            if (cVar.f16558a != cVar2.f16558a) {
                return cVar.f16558a ? 1 : -1;
            }
            return cVar2.f16562e - cVar.f16562e;
        }
    }
}
