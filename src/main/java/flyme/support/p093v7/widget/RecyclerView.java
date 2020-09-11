package flyme.support.p093v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.p005os.ParcelableCompat;
import androidx.core.p005os.ParcelableCompatCreatorCallbacks;
import androidx.core.p005os.TraceCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.core.widget.ScrollerCompat;
import androidx.customview.view.AbsSavedState;
import com.baidu.p020ar.base.MsgField;
import com.baidu.p020ar.util.MsgConstants;
import flyme.support.p093v7.R;
import flyme.support.p093v7.widget.AdapterHelper;
import flyme.support.p093v7.widget.ChildHelper;
import flyme.support.p093v7.widget.GapWorker;
import flyme.support.p093v7.widget.ViewBoundsCheck;
import flyme.support.p093v7.widget.ViewInfoStore;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* renamed from: flyme.support.v7.widget.RecyclerView */
public class RecyclerView extends ViewGroup implements NestedScrollingChild, ScrollingView {

    /* renamed from: a */
    private static final int[] f17935a = {16843830};

    /* renamed from: ai */
    static final Interpolator f17936ai = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: b */
    private static final int[] f17937b = {16842987};
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final boolean f17938c = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: d */
    private static final boolean f17939d = (Build.VERSION.SDK_INT <= 15);

    /* renamed from: e */
    private static final boolean f17940e = (Build.VERSION.SDK_INT <= 15);

    /* renamed from: f */
    private static final Class<?>[] f17941f = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};

    /* renamed from: x */
    static final boolean f17942x = (Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20);

    /* renamed from: y */
    static final boolean f17943y = (Build.VERSION.SDK_INT >= 23);

    /* renamed from: z */
    static final boolean f17944z = (Build.VERSION.SDK_INT >= 16);

    /* renamed from: A */
    final C3279p f17945A;

    /* renamed from: B */
    final C3277n f17946B;

    /* renamed from: C */
    AdapterHelper f17947C;

    /* renamed from: D */
    ChildHelper f17948D;

    /* renamed from: E */
    final ViewInfoStore f17949E;

    /* renamed from: F */
    boolean f17950F;

    /* renamed from: G */
    final Runnable f17951G;

    /* renamed from: H */
    final Rect f17952H;

    /* renamed from: I */
    final RectF f17953I;

    /* renamed from: J */
    C3260a f17954J;
    @VisibleForTesting

    /* renamed from: K */
    C3266g f17955K;

    /* renamed from: L */
    C3278o f17956L;

    /* renamed from: M */
    final ArrayList<C3265f> f17957M;

    /* renamed from: N */
    boolean f17958N;

    /* renamed from: O */
    boolean f17959O;

    /* renamed from: P */
    boolean f17960P;
    @VisibleForTesting

    /* renamed from: Q */
    boolean f17961Q;

    /* renamed from: R */
    boolean f17962R;

    /* renamed from: S */
    boolean f17963S;

    /* renamed from: T */
    boolean f17964T;

    /* renamed from: U */
    boolean f17965U;

    /* renamed from: V */
    ItemAnimator f17966V;

    /* renamed from: W */
    final C3285t f17967W;

    /* renamed from: aA */
    private final int[] f17968aA;

    /* renamed from: aB */
    private final int[] f17969aB;

    /* renamed from: aC */
    private final int[] f17970aC;

    /* renamed from: aD */
    private Runnable f17971aD;

    /* renamed from: aE */
    private int f17972aE;

    /* renamed from: aF */
    private int f17973aF;

    /* renamed from: aG */
    private final ViewInfoStore.C3351b f17974aG;

    /* renamed from: aH */
    private boolean f17975aH;

    /* renamed from: aa */
    GapWorker f17976aa;

    /* renamed from: ab */
    GapWorker.C3332a f17977ab;

    /* renamed from: ac */
    final C3283r f17978ac;

    /* renamed from: ad */
    boolean f17979ad;

    /* renamed from: ae */
    boolean f17980ae;

    /* renamed from: af */
    boolean f17981af;

    /* renamed from: ag */
    RecyclerViewAccessibilityDelegate f17982ag;
    @VisibleForTesting

    /* renamed from: ah */
    final List<C3286u> f17983ah;

    /* renamed from: aj */
    private VelocityTracker f17984aj;

    /* renamed from: ak */
    private int f17985ak;

    /* renamed from: al */
    private int f17986al;

    /* renamed from: am */
    private int f17987am;

    /* renamed from: an */
    private int f17988an;

    /* renamed from: ao */
    private int f17989ao;

    /* renamed from: ap */
    private C3272j f17990ap;

    /* renamed from: aq */
    private final int f17991aq;

    /* renamed from: ar */
    private final int f17992ar;

    /* renamed from: as */
    private float f17993as;

    /* renamed from: at */
    private boolean f17994at;

    /* renamed from: au */
    private C3274l f17995au;

    /* renamed from: av */
    private List<C3274l> f17996av;

    /* renamed from: aw */
    private ItemAnimator.C3257b f17997aw;

    /* renamed from: ax */
    private C3263d f17998ax;

    /* renamed from: ay */
    private final int[] f17999ay;

    /* renamed from: az */
    private NestedScrollingChildHelper f18000az;

    /* renamed from: g */
    private SavedState f18001g;

    /* renamed from: h */
    private final Rect f18002h;

    /* renamed from: i */
    private final ArrayList<C3273k> f18003i;

    /* renamed from: j */
    private C3273k f18004j;

    /* renamed from: k */
    private int f18005k;

    /* renamed from: l */
    private boolean f18006l;

    /* renamed from: m */
    private int f18007m;

    /* renamed from: n */
    private final AccessibilityManager f18008n;

    /* renamed from: o */
    private List<C3271i> f18009o;

    /* renamed from: p */
    private int f18010p;

    /* renamed from: q */
    private int f18011q;

    /* renamed from: r */
    private EdgeEffectCompat f18012r;

    /* renamed from: s */
    private EdgeEffectCompat f18013s;

    /* renamed from: t */
    private EdgeEffectCompat f18014t;

    /* renamed from: u */
    private EdgeEffectCompat f18015u;

    /* renamed from: v */
    private int f18016v;

    /* renamed from: w */
    private int f18017w;

    /* renamed from: flyme.support.v7.widget.RecyclerView$d */
    public interface C3263d {
        /* renamed from: a */
        int mo26546a(int i, int i2);
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$i */
    public interface C3271i {
        /* renamed from: a */
        void mo26671a(View view);

        /* renamed from: b */
        void mo26672b(View view);
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$j */
    public static abstract class C3272j {
        /* renamed from: a */
        public abstract boolean mo26673a(int i, int i2);
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$k */
    public interface C3273k {
        /* renamed from: a */
        void mo22325a(boolean z);

        /* renamed from: a */
        boolean mo22326a(RecyclerView recyclerView, MotionEvent motionEvent);

        /* renamed from: b */
        void mo22327b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$l */
    public static abstract class C3274l {
        /* renamed from: a */
        public void mo20071a(RecyclerView recyclerView, int i) {
        }

        /* renamed from: a */
        public void mo20072a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$o */
    public interface C3278o {
        /* renamed from: a */
        void mo26721a(C3286u uVar);
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$s */
    public static abstract class C3284s {
        /* renamed from: a */
        public abstract View mo26751a(C3277n nVar, int i, int i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26151a(View view, int i) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo26156b() {
    }

    /* renamed from: d */
    public void mo26164d(int i, int i2) {
    }

    /* renamed from: k */
    public void mo26433k(View view) {
    }

    /* renamed from: l */
    public void mo26435l(int i) {
    }

    /* renamed from: l */
    public void mo26436l(View view) {
    }

    public RecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17945A = new C3279p();
        this.f17946B = new C3277n();
        this.f17949E = new ViewInfoStore();
        this.f17951G = new Runnable() {
            public void run() {
                if (RecyclerView.this.f17961Q && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.f17958N) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.f17963S) {
                        RecyclerView.this.f17962R = true;
                    } else {
                        RecyclerView.this.mo26441o();
                    }
                }
            }
        };
        this.f17952H = new Rect();
        this.f18002h = new Rect();
        this.f17953I = new RectF();
        this.f17957M = new ArrayList<>();
        this.f18003i = new ArrayList<>();
        this.f18005k = 0;
        this.f17965U = false;
        this.f18010p = 0;
        this.f18011q = 0;
        this.f17966V = new DefaultItemAnimator();
        this.f18016v = 0;
        this.f18017w = -1;
        this.f17993as = Float.MIN_VALUE;
        boolean z = true;
        this.f17994at = true;
        this.f17967W = new C3285t();
        this.f17977ab = f17938c ? new GapWorker.C3332a() : null;
        this.f17978ac = new C3283r();
        this.f17979ad = false;
        this.f17980ae = false;
        this.f17997aw = new C3264e();
        this.f17981af = false;
        this.f17999ay = new int[2];
        this.f17968aA = new int[2];
        this.f17969aB = new int[2];
        this.f17970aC = new int[2];
        this.f17983ah = new ArrayList();
        this.f17971aD = new Runnable() {
            public void run() {
                if (RecyclerView.this.f17966V != null) {
                    RecyclerView.this.f17966V.mo26027a();
                }
                RecyclerView.this.f17981af = false;
            }
        };
        this.f17972aE = -1;
        this.f17973aF = -1;
        this.f17974aG = new ViewInfoStore.C3351b() {
            /* renamed from: a */
            public void mo26491a(C3286u uVar, @NonNull ItemAnimator.C3258c cVar, @Nullable ItemAnimator.C3258c cVar2) {
                RecyclerView.this.f17946B.mo26708c(uVar);
                RecyclerView.this.mo26385b(uVar, cVar, cVar2);
            }

            /* renamed from: b */
            public void mo26492b(C3286u uVar, ItemAnimator.C3258c cVar, ItemAnimator.C3258c cVar2) {
                RecyclerView.this.mo26376a(uVar, cVar, cVar2);
            }

            /* renamed from: c */
            public void mo26493c(C3286u uVar, @NonNull ItemAnimator.C3258c cVar, @NonNull ItemAnimator.C3258c cVar2) {
                uVar.mo26768b(false);
                if (RecyclerView.this.f17965U) {
                    if (RecyclerView.this.f17966V.mo26518a(uVar, uVar, cVar, cVar2)) {
                        RecyclerView.this.mo26351A();
                    }
                } else if (RecyclerView.this.f17966V.mo26520c(uVar, cVar, cVar2)) {
                    RecyclerView.this.mo26351A();
                }
            }

            /* renamed from: a */
            public void mo26490a(C3286u uVar) {
                RecyclerView.this.f17955K.mo26581a(uVar.f18121j, RecyclerView.this.f17946B);
            }
        };
        this.f17975aH = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f17937b, i, 0);
            this.f17950F = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.f17950F = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f17989ao = viewConfiguration.getScaledTouchSlop();
        this.f17991aq = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f17992ar = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f17966V.mo26516a(this.f17997aw);
        mo26438m();
        mo26161c();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.f18008n = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i, 0);
            String string = obtainStyledAttributes2.getString(R.styleable.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.f17960P = obtainStyledAttributes2.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
            if (this.f17960P) {
                mo26370a((StateListDrawable) obtainStyledAttributes2.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            m19578a(context, string, attributeSet, i, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f17935a, i, 0);
                boolean z2 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
                z = z2;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public String mo26434l() {
        return " " + super.toString() + ", adapter:" + this.f17954J + ", layout:" + this.f17955K + ", context:" + getContext();
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.f17982ag;
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.f17982ag = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, this.f17982ag);
    }

    /* renamed from: a */
    private void m19578a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                String a = m19575a(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = classLoader.loadClass(a).asSubclass(C3266g.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(f17941f);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                    } catch (NoSuchMethodException e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((C3266g) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a, e2);
                } catch (ClassNotFoundException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a, e3);
                } catch (InvocationTargetException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e4);
                } catch (InstantiationException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a, e6);
                } catch (ClassCastException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a, e7);
                }
            }
        }
    }

    /* renamed from: a */
    private String m19575a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    /* renamed from: c */
    private void mo26161c() {
        this.f17948D = new ChildHelper(new ChildHelper.C3326b() {
            /* renamed from: a */
            public int mo26494a() {
                return RecyclerView.this.getChildCount();
            }

            /* renamed from: a */
            public void mo26497a(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.mo26450p(view);
            }

            /* renamed from: a */
            public int mo26495a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            /* renamed from: a */
            public void mo26496a(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.mo26442o(childAt);
                }
                RecyclerView.this.removeViewAt(i);
            }

            /* renamed from: b */
            public View mo26499b(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            /* renamed from: b */
            public void mo26501b() {
                int a = mo26494a();
                for (int i = 0; i < a; i++) {
                    RecyclerView.this.mo26442o(mo26499b(i));
                }
                RecyclerView.this.removeAllViews();
            }

            /* renamed from: b */
            public C3286u mo26500b(View view) {
                return RecyclerView.m19601h(view);
            }

            /* renamed from: a */
            public void mo26498a(View view, int i, ViewGroup.LayoutParams layoutParams) {
                C3286u h = RecyclerView.m19601h(view);
                if (h != null) {
                    if (h.mo26786t() || h.mo26771e()) {
                        h.mo26781o();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + h);
                    }
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            /* renamed from: c */
            public void mo26502c(int i) {
                C3286u h;
                View b = mo26499b(i);
                if (!(b == null || (h = RecyclerView.m19601h(b)) == null)) {
                    if (!h.mo26786t() || h.mo26771e()) {
                        h.mo26767b(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + h);
                    }
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            /* renamed from: c */
            public void mo26503c(View view) {
                C3286u h = RecyclerView.m19601h(view);
                if (h != null) {
                    h.m20055a(RecyclerView.this);
                }
            }

            /* renamed from: d */
            public void mo26504d(View view) {
                C3286u h = RecyclerView.m19601h(view);
                if (h != null) {
                    h.m20059b(RecyclerView.this);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo26438m() {
        this.f17947C = new AdapterHelper(new AdapterHelper.C3323a() {
            /* renamed from: a */
            public C3286u mo26505a(int i) {
                C3286u a = RecyclerView.this.mo26365a(i, true);
                if (a != null && !RecyclerView.this.f17948D.mo27092c(a.f18121j)) {
                    return a;
                }
                return null;
            }

            /* renamed from: a */
            public void mo26506a(int i, int i2) {
                RecyclerView.this.mo26369a(i, i2, true);
                RecyclerView.this.f17979ad = true;
                RecyclerView.this.f17978ac.f18094b += i2;
            }

            /* renamed from: b */
            public void mo26509b(int i, int i2) {
                RecyclerView.this.mo26369a(i, i2, false);
                RecyclerView.this.f17979ad = true;
            }

            /* renamed from: a */
            public void mo26507a(int i, int i2, Object obj) {
                RecyclerView.this.mo26368a(i, i2, obj);
                RecyclerView.this.f17980ae = true;
            }

            /* renamed from: a */
            public void mo26508a(AdapterHelper.C3324b bVar) {
                mo26512c(bVar);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: c */
            public void mo26512c(AdapterHelper.C3324b bVar) {
                int i = bVar.f18448a;
                if (i == 4) {
                    RecyclerView.this.f17955K.mo26594a(RecyclerView.this, bVar.f18449b, bVar.f18451d, bVar.f18450c);
                } else if (i != 8) {
                    switch (i) {
                        case 1:
                            RecyclerView.this.f17955K.mo26592a(RecyclerView.this, bVar.f18449b, bVar.f18451d);
                            return;
                        case 2:
                            RecyclerView.this.f17955K.mo26614b(RecyclerView.this, bVar.f18449b, bVar.f18451d);
                            return;
                        default:
                            return;
                    }
                } else {
                    RecyclerView.this.f17955K.mo26593a(RecyclerView.this, bVar.f18449b, bVar.f18451d, 1);
                }
            }

            /* renamed from: b */
            public void mo26510b(AdapterHelper.C3324b bVar) {
                mo26512c(bVar);
            }

            /* renamed from: c */
            public void mo26511c(int i, int i2) {
                RecyclerView.this.mo26430j(i, i2);
                RecyclerView.this.f17979ad = true;
            }

            /* renamed from: d */
            public void mo26513d(int i, int i2) {
                RecyclerView.this.mo26426i(i, i2);
                RecyclerView.this.f17979ad = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.f17959O = z;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.f17950F) {
            mo26482v();
        }
        this.f17950F = z;
        super.setClipToPadding(z);
        if (this.f17961Q) {
            requestLayout();
        }
    }

    public boolean getClipToPadding() {
        return this.f17950F;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.f17989ao = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.f17989ao = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(C3260a aVar) {
        setLayoutFrozen(false);
        m19581a(aVar, false, true);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo26440n() {
        if (this.f17966V != null) {
            this.f17966V.mo26039d();
        }
        if (this.f17955K != null) {
            this.f17955K.mo26620c(this.f17946B);
            this.f17955K.mo26612b(this.f17946B);
        }
        this.f17946B.mo26688a();
    }

    /* renamed from: a */
    private void m19581a(C3260a aVar, boolean z, boolean z2) {
        if (this.f17954J != null) {
            this.f17954J.mo23926b((C3262c) this.f17945A);
            this.f17954J.mo23932c(this);
        }
        if (!z || z2) {
            mo26440n();
        }
        this.f17947C.mo27064a();
        C3260a aVar2 = this.f17954J;
        this.f17954J = aVar;
        if (aVar != null) {
            aVar.mo23921a((C3262c) this.f17945A);
            aVar.mo23923a(this);
        }
        if (this.f17955K != null) {
            this.f17955K.mo26584a(aVar2, this.f17954J);
        }
        this.f17946B.mo26693a(aVar2, this.f17954J, z);
        this.f17978ac.f18097e = true;
        mo26356F();
    }

    public C3260a getAdapter() {
        return this.f17954J;
    }

    public void setRecyclerListener(C3278o oVar) {
        this.f17956L = oVar;
    }

    public int getBaseline() {
        if (this.f17955K != null) {
            return this.f17955K.mo26657w();
        }
        return super.getBaseline();
    }

    public void setLayoutManager(C3266g gVar) {
        if (gVar != this.f17955K) {
            mo26451q();
            if (this.f17955K != null) {
                if (this.f17966V != null) {
                    this.f17966V.mo26039d();
                }
                this.f17955K.mo26620c(this.f17946B);
                this.f17955K.mo26612b(this.f17946B);
                this.f17946B.mo26688a();
                if (this.f17958N) {
                    this.f17955K.mo26615b(this, this.f17946B);
                }
                this.f17955K.mo26613b((RecyclerView) null);
                this.f17955K = null;
            } else {
                this.f17946B.mo26688a();
            }
            this.f17948D.mo27081a();
            this.f17955K = gVar;
            if (gVar != null) {
                if (gVar.f18048r == null) {
                    this.f17955K.mo26613b(this);
                    if (this.f17958N) {
                        this.f17955K.mo26621c(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + gVar + " is already attached to a RecyclerView: " + gVar.f18048r);
                }
            }
            this.f17946B.mo26700b();
            requestLayout();
        }
    }

    public void setOnFlingListener(@Nullable C3272j jVar) {
        this.f17990ap = jVar;
    }

    @Nullable
    public C3272j getOnFlingListener() {
        return this.f17990ap;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f18001g != null) {
            savedState.mo26534a(this.f18001g);
        } else if (this.f17955K != null) {
            savedState.f18033a = this.f17955K.mo26090f();
        } else {
            savedState.f18033a = null;
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.f18001g = (SavedState) parcelable;
        super.onRestoreInstanceState(this.f18001g.getSuperState());
        if (this.f17955K != null && this.f18001g.f18033a != null) {
            this.f17955K.mo26064a(this.f18001g.f18033a);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* renamed from: e */
    private void m19598e(C3286u uVar) {
        View view = uVar.f18121j;
        boolean z = view.getParent() == this;
        this.f17946B.mo26708c(mo26395e(view));
        if (uVar.mo26786t()) {
            this.f17948D.mo27084a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.f17948D.mo27086a(view, true);
        } else {
            this.f17948D.mo27094d(view);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo26390d(View view) {
        mo26449p();
        boolean f = this.f17948D.mo27097f(view);
        if (f) {
            C3286u h = m19601h(view);
            this.f17946B.mo26708c(h);
            this.f17946B.mo26703b(h);
        }
        mo26387c(!f);
        return f;
    }

    public C3266g getLayoutManager() {
        return this.f17955K;
    }

    public C3275m getRecycledViewPool() {
        return this.f17946B.mo26716g();
    }

    public void setRecycledViewPool(C3275m mVar) {
        this.f17946B.mo26694a(mVar);
    }

    public void setViewCacheExtension(C3284s sVar) {
        this.f17946B.mo26695a(sVar);
    }

    public void setItemViewCacheSize(int i) {
        this.f17946B.mo26689a(i);
    }

    public int getScrollState() {
        return this.f18016v;
    }

    /* access modifiers changed from: protected */
    public void setScrollState(int i) {
        if (i != this.f18016v) {
            this.f18016v = i;
            if (i != 2) {
                mo26170e();
            }
            mo26439m(i);
        }
    }

    /* renamed from: a */
    public void mo26372a(C3265f fVar, int i) {
        if (this.f17955K != null) {
            this.f17955K.mo26071a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f17957M.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.f17957M.add(fVar);
        } else {
            this.f17957M.add(i, fVar);
        }
        mo26352B();
        requestLayout();
    }

    /* renamed from: a */
    public void mo26371a(C3265f fVar) {
        mo26372a(fVar, -1);
    }

    /* renamed from: b */
    public void mo26382b(C3265f fVar) {
        if (this.f17955K != null) {
            this.f17955K.mo26071a("Cannot remove item decoration during a scroll  or layout");
        }
        this.f17957M.remove(fVar);
        if (this.f17957M.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        mo26352B();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(C3263d dVar) {
        if (dVar != this.f17998ax) {
            this.f17998ax = dVar;
            setChildrenDrawingOrderEnabled(this.f17998ax != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(C3274l lVar) {
        this.f17995au = lVar;
    }

    /* renamed from: a */
    public void mo26374a(C3274l lVar) {
        if (this.f17996av == null) {
            this.f17996av = new ArrayList();
        }
        this.f17996av.add(lVar);
    }

    /* renamed from: b */
    public void mo26384b(C3274l lVar) {
        if (this.f17996av != null) {
            this.f17996av.remove(lVar);
        }
    }

    /* renamed from: e */
    public void mo26396e(int i) {
        if (!this.f17963S) {
            mo26451q();
            if (this.f17955K == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            this.f17955K.mo26086e(i);
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo26399f(int i) {
        if (this.f17955K != null) {
            this.f17955K.mo26086e(i);
            awakenScrollBars();
        }
    }

    /* renamed from: g */
    public void mo26403g(int i) {
        if (!this.f17963S) {
            if (this.f17955K == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                this.f17955K.mo20065a(this, this.f17978ac, i);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollBy(int i, int i2) {
        if (this.f17955K == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f17963S) {
            boolean a = this.f17955K.mo22258a();
            boolean g = this.f17955K.mo26092g();
            if (a || g) {
                if (!a) {
                    i = 0;
                }
                if (!g) {
                    i2 = 0;
                }
                mo26378a(i, i2, (MotionEvent) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo26441o() {
        if (!this.f17961Q || this.f17965U) {
            TraceCompat.beginSection("RV FullInvalidate");
            mo26148a();
            TraceCompat.endSection();
        } else if (this.f17947C.mo27074d()) {
            if (this.f17947C.mo27068a(4) && !this.f17947C.mo27068a(11)) {
                TraceCompat.beginSection("RV PartialInvalidate");
                mo26449p();
                mo26483w();
                this.f17947C.mo27071b();
                if (!this.f17962R) {
                    if (mo26163d()) {
                        mo26148a();
                    } else {
                        this.f17947C.mo27073c();
                    }
                }
                mo26387c(true);
                mo26484x();
                TraceCompat.endSection();
            } else if (this.f17947C.mo27074d()) {
                TraceCompat.beginSection("RV FullInvalidate");
                mo26148a();
                TraceCompat.endSection();
            }
        }
    }

    /* renamed from: d */
    private boolean mo26163d() {
        int b = this.f17948D.mo27087b();
        for (int i = 0; i < b; i++) {
            C3286u h = m19601h(this.f17948D.mo27089b(i));
            if (h != null && !h.mo26771e() && h.mo26793z()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo26378a(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        mo26441o();
        if (this.f17954J != null) {
            mo26449p();
            mo26483w();
            TraceCompat.beginSection("RV Scroll");
            if (i != 0) {
                i6 = this.f17955K.mo26057a(i, this.f17946B, this.f17978ac);
                i5 = i - i6;
            } else {
                i6 = 0;
                i5 = 0;
            }
            if (i2 != 0) {
                i4 = this.f17955K.mo26073b(i2, this.f17946B, this.f17978ac);
                i3 = i2 - i4;
            } else {
                i4 = 0;
                i3 = 0;
            }
            TraceCompat.endSection();
            mo26358H();
            mo26484x();
            mo26387c(false);
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        if (!mo26360J() && !this.f17957M.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i6, i4, i5, i3, this.f17968aA)) {
            this.f17987am -= this.f17968aA[0];
            this.f17988an -= this.f17968aA[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.f17968aA[0], (float) this.f17968aA[1]);
            }
            int[] iArr = this.f17970aC;
            iArr[0] = iArr[0] + this.f17968aA[0];
            int[] iArr2 = this.f17970aC;
            iArr2[1] = iArr2[1] + this.f17968aA[1];
        } else if (ViewCompat.getOverScrollMode(this) != 2 && (ViewCompat.getOverScrollMode(this) != 1 || !mo26360J())) {
            if (motionEvent != null) {
                m19576a(motionEvent.getX(), (float) i5, motionEvent.getY(), (float) i3);
            }
            mo26400f(i, i2);
        }
        if (!(i6 == 0 && i4 == 0)) {
            mo26432k(i6, i4);
        }
        if (!mo26360J() && !awakenScrollBars()) {
            invalidate();
        }
        if (i6 == 0 && i4 == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        if (this.f17955K != null && this.f17955K.mo22258a()) {
            return this.f17955K.mo26079c(this.f17978ac);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.f17955K != null && this.f17955K.mo22258a()) {
            return this.f17955K.mo26085e(this.f17978ac);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.f17955K != null && this.f17955K.mo22258a()) {
            return this.f17955K.mo26091g(this.f17978ac);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.f17955K != null && this.f17955K.mo26092g()) {
            return this.f17955K.mo26083d(this.f17978ac);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.f17955K != null && this.f17955K.mo26092g()) {
            return this.f17955K.mo26089f(this.f17978ac);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.f17955K != null && this.f17955K.mo26092g()) {
            return this.f17955K.mo26094h(this.f17978ac);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo26449p() {
        this.f18005k++;
        if (this.f18005k == 1 && !this.f17963S) {
            this.f17962R = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo26387c(boolean z) {
        if (this.f18005k < 1) {
            this.f18005k = 1;
        }
        if (!z) {
            this.f17962R = false;
        }
        if (this.f18005k == 1) {
            if (z && this.f17962R && !this.f17963S && this.f17955K != null && this.f17954J != null) {
                mo26148a();
            }
            if (!this.f17963S) {
                this.f17962R = false;
            }
        }
        this.f18005k--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.f17963S) {
            mo26377a("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.f17963S = false;
                if (!(!this.f17962R || this.f17955K == null || this.f17954J == null)) {
                    requestLayout();
                }
                this.f17962R = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f17963S = true;
            this.f18006l = true;
            mo26451q();
        }
    }

    /* renamed from: e */
    public void mo26397e(int i, int i2) {
        mo26367a(i, i2, (Interpolator) null);
    }

    /* renamed from: a */
    public void mo26367a(int i, int i2, Interpolator interpolator) {
        if (this.f17955K == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f17963S) {
            if (!this.f17955K.mo22258a()) {
                i = 0;
            }
            if (!this.f17955K.mo26092g()) {
                i2 = 0;
            }
            if (i != 0 || i2 != 0) {
                this.f17967W.mo26757a(i, i2, interpolator);
            }
        }
    }

    /* renamed from: a */
    public boolean mo20050a(int i, int i2) {
        if (this.f17955K == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f17963S) {
            return false;
        } else {
            boolean a = this.f17955K.mo22258a();
            boolean g = this.f17955K.mo26092g();
            if (!a || Math.abs(i) < this.f17991aq) {
                i = 0;
            }
            if (!g || Math.abs(i2) < this.f17991aq) {
                i2 = 0;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            float f = (float) i;
            float f2 = (float) i2;
            if (!dispatchNestedPreFling(f, f2)) {
                boolean z = a || g;
                dispatchNestedFling(f, f2, z);
                if (this.f17990ap != null && this.f17990ap.mo26673a(i, i2)) {
                    return true;
                }
                if (z) {
                    this.f17967W.mo26753a(Math.max(-this.f17992ar, Math.min(i, this.f17992ar)), Math.max(-this.f17992ar, Math.min(i2, this.f17992ar)));
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: q */
    public void mo26451q() {
        setScrollState(0);
        mo26170e();
    }

    /* renamed from: e */
    private void mo26170e() {
        this.f17967W.mo26758b();
        if (this.f17955K != null) {
            this.f17955K.mo26566J();
        }
    }

    public int getMinFlingVelocity() {
        return this.f17991aq;
    }

    public int getMaxFlingVelocity() {
        return this.f17992ar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (r6.f18013s.onPull((-r10) / ((float) getHeight()), r7 / ((float) getWidth())) != false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007a, code lost:
        if (r6.f18015u.onPull(r10 / ((float) getHeight()), 1.0f - (r7 / ((float) getWidth()))) != false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0020, code lost:
        if (r6.f18012r.onPull((-r8) / ((float) getWidth()), 1.0f - (r9 / ((float) getHeight()))) != false) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003e, code lost:
        if (r6.f18014t.onPull(r8 / ((float) getWidth()), r9 / ((float) getHeight())) != false) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m19576a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L_0x0024
            r6.mo26452r()
            androidx.core.widget.EdgeEffectCompat r1 = r6.f18012r
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            boolean r9 = r1.onPull(r4, r9)
            if (r9 == 0) goto L_0x0041
        L_0x0022:
            r9 = 1
            goto L_0x0042
        L_0x0024:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x0041
            r6.mo26458s()
            androidx.core.widget.EdgeEffectCompat r1 = r6.f18014t
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            boolean r9 = r1.onPull(r4, r9)
            if (r9 == 0) goto L_0x0041
            goto L_0x0022
        L_0x0041:
            r9 = 0
        L_0x0042:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x005f
            r6.mo26480t()
            androidx.core.widget.EdgeEffectCompat r1 = r6.f18013s
            float r2 = -r10
            int r4 = r6.getHeight()
            float r4 = (float) r4
            float r2 = r2 / r4
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            boolean r7 = r1.onPull(r2, r7)
            if (r7 == 0) goto L_0x007d
            goto L_0x007e
        L_0x005f:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x007d
            r6.mo26481u()
            androidx.core.widget.EdgeEffectCompat r1 = r6.f18015u
            int r4 = r6.getHeight()
            float r4 = (float) r4
            float r4 = r10 / r4
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r7 = r7 / r5
            float r2 = r2 - r7
            boolean r7 = r1.onPull(r4, r2)
            if (r7 == 0) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r3 = r9
        L_0x007e:
            if (r3 != 0) goto L_0x0088
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L_0x0088
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x008b
        L_0x0088:
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(r6)
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.RecyclerView.m19576a(float, float, float, float):void");
    }

    /* renamed from: f */
    private void mo26171f() {
        boolean onRelease = this.f18012r != null ? this.f18012r.onRelease() : false;
        if (this.f18013s != null) {
            onRelease |= this.f18013s.onRelease();
        }
        if (this.f18014t != null) {
            onRelease |= this.f18014t.onRelease();
        }
        if (this.f18015u != null) {
            onRelease |= this.f18015u.onRelease();
        }
        if (onRelease) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo26400f(int i, int i2) {
        boolean onRelease = (this.f18012r == null || this.f18012r.isFinished() || i <= 0) ? false : this.f18012r.onRelease();
        if (this.f18014t != null && !this.f18014t.isFinished() && i < 0) {
            onRelease |= this.f18014t.onRelease();
        }
        if (this.f18013s != null && !this.f18013s.isFinished() && i2 > 0) {
            onRelease |= this.f18013s.onRelease();
        }
        if (this.f18015u != null && !this.f18015u.isFinished() && i2 < 0) {
            onRelease |= this.f18015u.onRelease();
        }
        if (onRelease) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo26404g(int i, int i2) {
        if (i < 0) {
            mo26452r();
            this.f18012r.onAbsorb(-i);
        } else if (i > 0) {
            mo26458s();
            this.f18014t.onAbsorb(i);
        }
        if (i2 < 0) {
            mo26480t();
            this.f18013s.onAbsorb(-i2);
        } else if (i2 > 0) {
            mo26481u();
            this.f18015u.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo26452r() {
        if (this.f18012r == null) {
            this.f18012r = new EdgeEffectCompat(getContext());
            if (this.f17950F) {
                this.f18012r.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f18012r.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void mo26458s() {
        if (this.f18014t == null) {
            this.f18014t = new EdgeEffectCompat(getContext());
            if (this.f17950F) {
                this.f18014t.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f18014t.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public void mo26480t() {
        if (this.f18013s == null) {
            this.f18013s = new EdgeEffectCompat(getContext());
            if (this.f17950F) {
                this.f18013s.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f18013s.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void mo26481u() {
        if (this.f18015u == null) {
            this.f18015u = new EdgeEffectCompat(getContext());
            if (this.f17950F) {
                this.f18015u.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f18015u.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo26482v() {
        this.f18015u = null;
        this.f18013s = null;
        this.f18014t = null;
        this.f18012r = null;
    }

    public View focusSearch(View view, int i) {
        View view2;
        boolean z;
        View d = this.f17955K.mo26625d(view, i);
        if (d != null) {
            return d;
        }
        boolean z2 = this.f17954J != null && this.f17955K != null && !mo26486z() && !this.f17963S;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z2 || !(i == 2 || i == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus != null || !z2) {
                view2 = findNextFocus;
            } else {
                mo26441o();
                if (mo26398f(view) == null) {
                    return null;
                }
                mo26449p();
                view2 = this.f17955K.mo26060a(view, i, this.f17946B, this.f17978ac);
                mo26387c(false);
            }
        } else {
            if (this.f17955K.mo26092g()) {
                int i2 = i == 2 ? 130 : 33;
                z = instance.findNextFocus(this, view, i2) == null;
                if (f17939d) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.f17955K.mo22258a()) {
                int i3 = (this.f17955K.mo26656v() == 1) ^ (i == 2) ? 66 : 17;
                z = instance.findNextFocus(this, view, i3) == null;
                if (f17939d) {
                    i = i3;
                }
            }
            if (z) {
                mo26441o();
                if (mo26398f(view) == null) {
                    return null;
                }
                mo26449p();
                this.f17955K.mo26060a(view, i, this.f17946B, this.f17978ac);
                mo26387c(false);
            }
            view2 = instance.findNextFocus(this, view, i);
        }
        if (view2 == null || view2.hasFocusable()) {
            return m19588a(view, view2, i) ? view2 : super.focusSearch(view, i);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        }
        m19580a(view2, (View) null);
        return view;
    }

    /* renamed from: a */
    private boolean m19588a(View view, View view2, int i) {
        boolean z = false;
        if (view2 == null || view2 == this) {
            return false;
        }
        if (view == null) {
            return true;
        }
        if (i != 2 && i != 1) {
            return m19592b(view, view2, i);
        }
        boolean z2 = this.f17955K.mo26656v() == 1;
        if (i == 2) {
            z = true;
        }
        if (m19592b(view, view2, z ^ z2 ? 66 : 17)) {
            return true;
        }
        if (i == 2) {
            return m19592b(view, view2, 130);
        }
        return m19592b(view, view2, 33);
    }

    /* renamed from: b */
    private boolean m19592b(View view, View view2, int i) {
        this.f17952H.set(0, 0, view.getWidth(), view.getHeight());
        this.f18002h.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f17952H);
        offsetDescendantRectToMyCoords(view2, this.f18002h);
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i == 130) {
                        return (this.f17952H.top < this.f18002h.top || this.f17952H.bottom <= this.f18002h.top) && this.f17952H.bottom < this.f18002h.bottom;
                    }
                    throw new IllegalArgumentException("direction must be absolute. received:" + i);
                } else if ((this.f17952H.left < this.f18002h.left || this.f17952H.right <= this.f18002h.left) && this.f17952H.right < this.f18002h.right) {
                    return true;
                } else {
                    return false;
                }
            } else if ((this.f17952H.bottom > this.f18002h.bottom || this.f17952H.top >= this.f18002h.bottom) && this.f17952H.top > this.f18002h.top) {
                return true;
            } else {
                return false;
            }
        } else if ((this.f17952H.right > this.f18002h.right || this.f17952H.left >= this.f18002h.right) && this.f17952H.left > this.f18002h.left) {
            return true;
        } else {
            return false;
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f17955K.mo26605a(this, this.f17978ac, view, view2) && view2 != null) {
            m19580a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    /* renamed from: a */
    private void m19580a(@NonNull View view, @Nullable View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f17952H.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof C3270h) {
            C3270h hVar = (C3270h) layoutParams;
            if (!hVar.f18061e) {
                Rect rect = hVar.f18060d;
                this.f17952H.left -= rect.left;
                this.f17952H.right += rect.right;
                this.f17952H.top -= rect.top;
                this.f17952H.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f17952H);
            offsetRectIntoDescendantCoords(view, this.f17952H);
        }
        this.f17955K.mo26603a(this, view, this.f17952H, !this.f17961Q, view2 == null);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f17955K.mo26602a(this, view, rect, z);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.f17955K == null || !this.f17955K.mo26606a(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (mo26486z()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0058, code lost:
        if (r0 >= 30.0f) goto L_0x005d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.f18010p = r0
            r1 = 1
            r4.f17958N = r1
            boolean r2 = r4.f17961Q
            if (r2 == 0) goto L_0x0014
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r4.f17961Q = r1
            flyme.support.v7.widget.RecyclerView$g r1 = r4.f17955K
            if (r1 == 0) goto L_0x0020
            flyme.support.v7.widget.RecyclerView$g r1 = r4.f17955K
            r1.mo26621c((flyme.support.p093v7.widget.RecyclerView) r4)
        L_0x0020:
            r4.f17981af = r0
            boolean r0 = f17938c
            if (r0 == 0) goto L_0x0072
            java.lang.ThreadLocal<flyme.support.v7.widget.j> r0 = flyme.support.p093v7.widget.GapWorker.f18500a
            java.lang.Object r0 = r0.get()
            flyme.support.v7.widget.j r0 = (flyme.support.p093v7.widget.GapWorker) r0
            r4.f17976aa = r0
            flyme.support.v7.widget.j r0 = r4.f17976aa
            if (r0 != 0) goto L_0x006d
            flyme.support.v7.widget.j r0 = new flyme.support.v7.widget.j
            r0.<init>()
            r4.f17976aa = r0
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 25
            if (r1 < r2) goto L_0x0046
            android.view.Display r0 = androidx.core.view.ViewCompat.getDisplay(r4)
        L_0x0046:
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L_0x005b
            if (r0 == 0) goto L_0x005b
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r0 = 1114636288(0x42700000, float:60.0)
        L_0x005d:
            flyme.support.v7.widget.j r1 = r4.f17976aa
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.f18504d = r2
            java.lang.ThreadLocal<flyme.support.v7.widget.j> r0 = flyme.support.p093v7.widget.GapWorker.f18500a
            flyme.support.v7.widget.j r1 = r4.f17976aa
            r0.set(r1)
        L_0x006d:
            flyme.support.v7.widget.j r0 = r4.f17976aa
            r0.mo27167a((flyme.support.p093v7.widget.RecyclerView) r4)
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.RecyclerView.onAttachedToWindow():void");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f17966V != null) {
            this.f17966V.mo26039d();
        }
        mo26451q();
        this.f17958N = false;
        if (this.f17955K != null) {
            this.f17955K.mo26615b(this, this.f17946B);
        }
        this.f17983ah.clear();
        removeCallbacks(this.f17971aD);
        this.f17949E.mo27277b();
        if (f17938c) {
            this.f17976aa.mo27169b(this);
            this.f17976aa = null;
        }
    }

    public boolean isAttachedToWindow() {
        return this.f17958N;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26377a(String str) {
        if (mo26486z()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
            }
            throw new IllegalStateException(str);
        } else if (this.f18011q > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(""));
        }
    }

    /* renamed from: a */
    public void mo26373a(C3273k kVar) {
        this.f18003i.add(kVar);
    }

    /* renamed from: b */
    public void mo26383b(C3273k kVar) {
        this.f18003i.remove(kVar);
        if (this.f18004j == kVar) {
            this.f18004j = null;
        }
    }

    /* renamed from: a */
    private boolean m19587a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f18004j = null;
        }
        int size = this.f18003i.size();
        int i = 0;
        while (i < size) {
            C3273k kVar = this.f18003i.get(i);
            if (!kVar.mo22326a(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.f18004j = kVar;
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private boolean m19591b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f18004j != null) {
            if (action == 0) {
                this.f18004j = null;
            } else {
                this.f18004j.mo22327b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.f18004j = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.f18003i.size();
            for (int i = 0; i < size; i++) {
                C3273k kVar = this.f18003i.get(i);
                if (kVar.mo22326a(this, motionEvent)) {
                    this.f18004j = kVar;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.f17963S) {
            return false;
        }
        if (m19587a(motionEvent)) {
            mo26185h();
            return true;
        } else if (this.f17955K == null) {
            return false;
        } else {
            boolean a = this.f17955K.mo22258a();
            boolean g = this.f17955K.mo26092g();
            if (this.f17984aj == null) {
                this.f17984aj = VelocityTracker.obtain();
            }
            this.f17984aj.addMovement(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            switch (actionMasked) {
                case 0:
                    if (this.f18006l) {
                        this.f18006l = false;
                    }
                    this.f18017w = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.f17987am = x;
                    this.f17985ak = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.f17988an = y;
                    this.f17986al = y;
                    if (this.f18016v == 2) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                        setScrollState(1);
                    }
                    int[] iArr = this.f17970aC;
                    this.f17970aC[1] = 0;
                    iArr[0] = 0;
                    int i = a ? 1 : 0;
                    if (g) {
                        i |= 2;
                    }
                    startNestedScroll(i);
                    break;
                case 1:
                    this.f17984aj.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.f18017w);
                    if (findPointerIndex >= 0) {
                        int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                        int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                        if (this.f18016v != 1) {
                            int i2 = x2 - this.f17985ak;
                            int i3 = y2 - this.f17986al;
                            int i4 = -1;
                            if (!a || Math.abs(i2) <= this.f17989ao) {
                                z = false;
                            } else {
                                this.f17987am = this.f17985ak + (this.f17989ao * (i2 < 0 ? -1 : 1));
                                z = true;
                            }
                            if (g && Math.abs(i3) > this.f17989ao) {
                                int i5 = this.f17986al;
                                int i6 = this.f17989ao;
                                if (i3 >= 0) {
                                    i4 = 1;
                                }
                                this.f17988an = i5 + (i6 * i4);
                                z = true;
                            }
                            if (z) {
                                setScrollState(1);
                                break;
                            }
                        }
                    } else {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f18017w + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    break;
                case 3:
                    mo26185h();
                    break;
                case 5:
                    this.f18017w = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.f17987am = x3;
                    this.f17985ak = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.f17988an = y3;
                    this.f17986al = y3;
                    break;
                case 6:
                    m19594c(motionEvent);
                    break;
            }
            if (this.f18016v == 1) {
                return true;
            }
            return false;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.f18003i.size();
        for (int i = 0; i < size; i++) {
            this.f18003i.get(i).mo22325a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        boolean z;
        boolean z2 = false;
        if (this.f17963S || this.f18006l) {
            return false;
        }
        if (m19591b(motionEvent)) {
            mo26185h();
            return true;
        } else if (this.f17955K == null) {
            return false;
        } else {
            boolean a = this.f17955K.mo22258a();
            boolean g = this.f17955K.mo26092g();
            if (this.f17984aj == null) {
                this.f17984aj = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (actionMasked == 0) {
                int[] iArr = this.f17970aC;
                this.f17970aC[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.f17970aC[0], (float) this.f17970aC[1]);
            switch (actionMasked) {
                case 0:
                    this.f18017w = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.f17987am = x;
                    this.f17985ak = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.f17988an = y;
                    this.f17986al = y;
                    int i3 = a ? 1 : 0;
                    if (g) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3);
                    break;
                case 1:
                    this.f17984aj.addMovement(obtain);
                    this.f17984aj.computeCurrentVelocity(1000, (float) this.f17992ar);
                    float f = a ? -VelocityTrackerCompat.getXVelocity(this.f17984aj, this.f18017w) : 0.0f;
                    float f2 = g ? -VelocityTrackerCompat.getYVelocity(this.f17984aj, this.f18017w) : 0.0f;
                    if (mo26360J()) {
                        setScrollState(0);
                    } else if ((f == 0.0f && f2 == 0.0f) || !mo20050a((int) f, (int) f2)) {
                        setScrollState(0);
                    }
                    mo26172g();
                    z2 = true;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.f18017w);
                    if (findPointerIndex >= 0) {
                        int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                        int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                        int i4 = this.f17987am - x2;
                        int i5 = this.f17988an - y2;
                        if (dispatchNestedPreScroll(i4, i5, this.f17969aB, this.f17968aA)) {
                            i4 -= this.f17969aB[0];
                            i5 -= this.f17969aB[1];
                            obtain.offsetLocation((float) this.f17968aA[0], (float) this.f17968aA[1]);
                            int[] iArr2 = this.f17970aC;
                            iArr2[0] = iArr2[0] + this.f17968aA[0];
                            int[] iArr3 = this.f17970aC;
                            iArr3[1] = iArr3[1] + this.f17968aA[1];
                        }
                        if (this.f18016v != 1) {
                            if (!a || Math.abs(i2) <= this.f17989ao) {
                                z = false;
                            } else {
                                if (i2 > 0) {
                                    i2 -= this.f17989ao;
                                } else {
                                    i2 += this.f17989ao;
                                }
                                z = true;
                            }
                            if (g && Math.abs(i) > this.f17989ao) {
                                if (i > 0) {
                                    i -= this.f17989ao;
                                } else {
                                    i += this.f17989ao;
                                }
                                z = true;
                            }
                            if (z) {
                                setScrollState(1);
                            }
                        }
                        if (this.f18016v == 1) {
                            this.f17987am = x2 - this.f17968aA[0];
                            this.f17988an = y2 - this.f17968aA[1];
                            if (mo26378a(a ? i2 : 0, g ? i : 0, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            if (!(this.f17976aa == null || (i2 == 0 && i == 0))) {
                                this.f17976aa.mo27168a(this, i2, i);
                                break;
                            }
                        }
                    } else {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f18017w + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    break;
                case 3:
                    mo26185h();
                    break;
                case 5:
                    this.f18017w = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.f17987am = x3;
                    this.f17985ak = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.f17988an = y3;
                    this.f17986al = y3;
                    break;
                case 6:
                    m19594c(motionEvent);
                    break;
            }
            if (!z2) {
                this.f17984aj.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    /* renamed from: g */
    private void mo26172g() {
        if (this.f17984aj != null) {
            this.f17984aj.clear();
        }
        stopNestedScroll();
        mo26171f();
    }

    /* renamed from: h */
    private void mo26185h() {
        mo26172g();
        setScrollState(0);
    }

    /* renamed from: c */
    private void m19594c(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.f18017w) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f18017w = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.f17987am = x;
            this.f17985ak = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.f17988an = y;
            this.f17986al = y;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (this.f17955K != null && !this.f17963S && (motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8) {
            float f = this.f17955K.mo26092g() ? -MotionEventCompat.getAxisValue(motionEvent, 9) : 0.0f;
            float axisValue = this.f17955K.mo22258a() ? MotionEventCompat.getAxisValue(motionEvent, 10) : 0.0f;
            if (!(f == 0.0f && axisValue == 0.0f)) {
                float scrollFactor = getScrollFactor();
                mo26378a((int) (axisValue * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    private float getScrollFactor() {
        if (this.f17993as == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.f17993as = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.f17993as;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f17955K == null) {
            mo26423h(i, i2);
            return;
        }
        boolean z = false;
        if (this.f17955K.f18054x) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.f17955K.mo26586a(this.f17946B, this.f17978ac, i, i2);
            if (!z && this.f17954J != null) {
                if (this.f17978ac.f18095c == 1) {
                    m19571R();
                }
                this.f17955K.mo26626d(i, i2);
                this.f17978ac.f18100h = true;
                m19572S();
                this.f17955K.mo26629e(i, i2);
                if (this.f17955K.mo26100n()) {
                    this.f17955K.mo26626d(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.f17978ac.f18100h = true;
                    m19572S();
                    this.f17955K.mo26629e(i, i2);
                }
            }
        } else if (this.f17959O) {
            this.f17955K.mo26586a(this.f17946B, this.f17978ac, i, i2);
        } else {
            if (this.f17964T) {
                mo26449p();
                mo26483w();
                m19605k();
                mo26484x();
                if (this.f17978ac.f18102j) {
                    this.f17978ac.f18098f = true;
                } else {
                    this.f17947C.mo27075e();
                    this.f17978ac.f18098f = false;
                }
                this.f17964T = false;
                mo26387c(false);
            }
            if (this.f17954J != null) {
                this.f17978ac.f18096d = this.f17954J.mo20093a();
            } else {
                this.f17978ac.f18096d = 0;
            }
            mo26449p();
            this.f17955K.mo26586a(this.f17946B, this.f17978ac, i, i2);
            mo26387c(false);
            this.f17978ac.f18098f = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo26423h(int i, int i2) {
        setMeasuredDimension(C3266g.m19786a(i, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), C3266g.m19786a(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            mo26482v();
        }
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        if (this.f17966V != null) {
            this.f17966V.mo26039d();
            this.f17966V.mo26516a((ItemAnimator.C3257b) null);
        }
        this.f17966V = itemAnimator;
        if (this.f17966V != null) {
            this.f17966V.mo26516a(this.f17997aw);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public void mo26483w() {
        this.f18010p++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public void mo26484x() {
        this.f18010p--;
        if (this.f18010p < 1) {
            this.f18010p = 0;
            mo26186i();
            mo26359I();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public boolean mo26485y() {
        return this.f18008n != null && this.f18008n.isEnabled();
    }

    /* renamed from: i */
    private void mo26186i() {
        int i = this.f18007m;
        this.f18007m = 0;
        if (i != 0 && mo26485y()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.setContentChangeTypes(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    /* renamed from: z */
    public boolean mo26486z() {
        return this.f18010p > 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo26379a(AccessibilityEvent accessibilityEvent) {
        if (!mo26486z()) {
            return false;
        }
        int contentChangeTypes = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent) : 0;
        if (contentChangeTypes == 0) {
            contentChangeTypes = 0;
        }
        this.f18007m = contentChangeTypes | this.f18007m;
        return true;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!mo26379a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public ItemAnimator getItemAnimator() {
        return this.f17966V;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public void mo26351A() {
        if (!this.f17981af && this.f17958N) {
            ViewCompat.postOnAnimation(this, this.f17971aD);
            this.f17981af = true;
        }
    }

    /* renamed from: j */
    private boolean m19604j() {
        return this.f17966V != null && this.f17955K.mo26087e();
    }

    /* renamed from: k */
    private void m19605k() {
        if (this.f17965U) {
            this.f17947C.mo27064a();
            this.f17955K.mo26591a(this);
        }
        if (m19604j()) {
            this.f17947C.mo27071b();
        } else {
            this.f17947C.mo27075e();
        }
        boolean z = false;
        boolean z2 = this.f17979ad || this.f17980ae;
        this.f17978ac.f18101i = this.f17961Q && this.f17966V != null && (this.f17965U || z2 || this.f17955K.f18052v) && (!this.f17965U || this.f17954J.mo23933d());
        C3283r rVar = this.f17978ac;
        if (this.f17978ac.f18101i && z2 && !this.f17965U && m19604j()) {
            z = true;
        }
        rVar.f18102j = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26148a() {
        if (this.f17954J == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f17955K == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.f17978ac.f18100h = false;
            if (this.f17978ac.f18095c == 1) {
                m19571R();
                this.f17955K.mo26634f(this);
                m19572S();
            } else if (!this.f17947C.mo27076f() && this.f17955K.mo26557A() == getWidth() && this.f17955K.mo26558B() == getHeight()) {
                this.f17955K.mo26634f(this);
            } else {
                this.f17955K.mo26634f(this);
                m19572S();
            }
            m19573T();
        }
    }

    /* renamed from: N */
    private void m19567N() {
        int i;
        C3286u uVar = null;
        View focusedChild = (!this.f17994at || !hasFocus() || this.f17954J == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            uVar = mo26402g(focusedChild);
        }
        if (uVar == null) {
            m19568O();
            return;
        }
        this.f17978ac.f18104l = this.f17954J.mo23933d() ? uVar.mo26775i() : -1;
        C3283r rVar = this.f17978ac;
        if (this.f17965U) {
            i = -1;
        } else if (uVar.mo26785s()) {
            i = uVar.f18124m;
        } else {
            i = uVar.mo26773g();
        }
        rVar.f18103k = i;
        this.f17978ac.f18105m = mo26147a(uVar.f18121j);
    }

    /* renamed from: O */
    private void m19568O() {
        this.f17978ac.f18104l = -1;
        this.f17978ac.f18103k = -1;
        this.f17978ac.f18105m = -1;
    }

    @Nullable
    /* renamed from: P */
    private View m19569P() {
        C3286u i;
        int i2 = this.f17978ac.f18103k != -1 ? this.f17978ac.f18103k : 0;
        int f = this.f17978ac.mo26749f();
        int i3 = i2;
        while (i3 < f) {
            C3286u i4 = mo26425i(i3);
            if (i4 == null) {
                break;
            } else if (i4.f18121j.hasFocusable()) {
                return i4.f18121j;
            } else {
                i3++;
            }
        }
        int min = Math.min(f, i2);
        while (true) {
            min--;
            if (min < 0 || (i = mo26425i(min)) == null) {
                return null;
            }
            if (i.f18121j.hasFocusable()) {
                return i.f18121j;
            }
        }
    }

    /* renamed from: Q */
    private void m19570Q() {
        View view;
        if (this.f17994at && this.f17954J != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!f17940e || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.f17948D.mo27092c(focusedChild)) {
                            return;
                        }
                    } else if (this.f17948D.mo27087b() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view2 = null;
                C3286u a = (this.f17978ac.f18104l == -1 || !this.f17954J.mo23933d()) ? null : mo26366a(this.f17978ac.f18104l);
                if (a != null && !this.f17948D.mo27092c(a.f18121j) && a.f18121j.hasFocusable()) {
                    view2 = a.f18121j;
                } else if (this.f17948D.mo27087b() > 0) {
                    view2 = m19569P();
                }
                if (view2 != null) {
                    if (((long) this.f17978ac.f18105m) == -1 || (view = view2.findViewById(this.f17978ac.f18105m)) == null || !view.isFocusable()) {
                        view = view2;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    /* renamed from: a */
    private int mo26147a(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    /* renamed from: R */
    private void m19571R() {
        boolean z = true;
        this.f17978ac.mo26742a(1);
        this.f17978ac.f18100h = false;
        mo26449p();
        this.f17949E.mo27271a();
        mo26483w();
        m19605k();
        m19567N();
        C3283r rVar = this.f17978ac;
        if (!this.f17978ac.f18101i || !this.f17980ae) {
            z = false;
        }
        rVar.f18099g = z;
        this.f17980ae = false;
        this.f17979ad = false;
        this.f17978ac.f18098f = this.f17978ac.f18102j;
        this.f17978ac.f18096d = this.f17954J.mo20093a();
        m19586a(this.f17999ay);
        if (this.f17978ac.f18101i) {
            int b = this.f17948D.mo27087b();
            for (int i = 0; i < b; i++) {
                C3286u h = m19601h(this.f17948D.mo27089b(i));
                if (!h.mo26771e() && (!h.mo26782p() || this.f17954J.mo23933d())) {
                    this.f17949E.mo27273a(h, this.f17966V.mo26515a(this.f17978ac, h, ItemAnimator.m19715e(h), h.mo26790w()));
                    if (this.f17978ac.f18099g && h.mo26793z() && !h.mo26785s() && !h.mo26771e() && !h.mo26782p()) {
                        this.f17949E.mo27272a(mo26363a(h), h);
                    }
                }
            }
        }
        if (this.f17978ac.f18102j) {
            mo26353C();
            boolean z2 = this.f17978ac.f18097e;
            this.f17978ac.f18097e = false;
            this.f17955K.mo26082c(this.f17946B, this.f17978ac);
            this.f17978ac.f18097e = z2;
            for (int i2 = 0; i2 < this.f17948D.mo27087b(); i2++) {
                C3286u h2 = m19601h(this.f17948D.mo27089b(i2));
                if (!h2.mo26771e() && !this.f17949E.mo27281d(h2)) {
                    int e = ItemAnimator.m19715e(h2);
                    boolean a = h2.mo26766a(8192);
                    if (!a) {
                        e |= 4096;
                    }
                    ItemAnimator.C3258c a2 = this.f17966V.mo26515a(this.f17978ac, h2, e, h2.mo26790w());
                    if (a) {
                        mo26375a(h2, a2);
                    } else {
                        this.f17949E.mo27278b(h2, a2);
                    }
                }
            }
            mo26354D();
        } else {
            mo26354D();
        }
        mo26484x();
        mo26387c(false);
        this.f17978ac.f18095c = 2;
        mo26156b();
    }

    /* renamed from: S */
    private void m19572S() {
        mo26449p();
        mo26483w();
        this.f17978ac.mo26742a(6);
        this.f17947C.mo27075e();
        this.f17978ac.f18096d = this.f17954J.mo20093a();
        this.f17978ac.f18094b = 0;
        this.f17978ac.f18098f = false;
        this.f17955K.mo26082c(this.f17946B, this.f17978ac);
        this.f17978ac.f18097e = false;
        this.f18001g = null;
        this.f17978ac.f18101i = this.f17978ac.f18101i && this.f17966V != null;
        this.f17978ac.f18095c = 4;
        mo26484x();
        mo26387c(false);
    }

    /* renamed from: T */
    private void m19573T() {
        this.f17978ac.mo26742a(4);
        mo26449p();
        mo26483w();
        this.f17978ac.f18095c = 1;
        if (this.f17978ac.f18101i) {
            for (int b = this.f17948D.mo27087b() - 1; b >= 0; b--) {
                C3286u h = m19601h(this.f17948D.mo27089b(b));
                if (!h.mo26771e()) {
                    long a = mo26363a(h);
                    ItemAnimator.C3258c a2 = this.f17966V.mo26514a(this.f17978ac, h);
                    C3286u a3 = this.f17949E.mo27270a(a);
                    if (a3 == null || a3.mo26771e()) {
                        this.f17949E.mo27280c(h, a2);
                    } else {
                        boolean a4 = this.f17949E.mo27275a(a3);
                        boolean a5 = this.f17949E.mo27275a(h);
                        if (!a4 || a3 != h) {
                            ItemAnimator.C3258c b2 = this.f17949E.mo27276b(a3);
                            this.f17949E.mo27280c(h, a2);
                            ItemAnimator.C3258c c = this.f17949E.mo27279c(h);
                            if (b2 == null) {
                                m19577a(a, h, a3);
                            } else {
                                m19582a(a3, h, b2, c, a4, a5);
                            }
                        } else {
                            this.f17949E.mo27280c(h, a2);
                        }
                    }
                }
            }
            this.f17949E.mo27274a(this.f17974aG);
        }
        this.f17955K.mo26612b(this.f17946B);
        this.f17978ac.f18093a = this.f17978ac.f18096d;
        this.f17965U = false;
        this.f17978ac.f18101i = false;
        this.f17978ac.f18102j = false;
        this.f17955K.f18052v = false;
        if (this.f17946B.f18070b != null) {
            this.f17946B.f18070b.clear();
        }
        if (this.f17955K.f18056z) {
            this.f17955K.f18055y = 0;
            this.f17955K.f18056z = false;
            this.f17946B.mo26700b();
        }
        this.f17955K.mo26068a(this.f17978ac);
        mo26484x();
        mo26387c(false);
        this.f17949E.mo27271a();
        if (mo26157b(this.f17999ay[0], this.f17999ay[1])) {
            mo26432k(0, 0);
        }
        m19570Q();
        m19568O();
    }

    /* renamed from: a */
    private void m19577a(long j, C3286u uVar, C3286u uVar2) {
        int b = this.f17948D.mo27087b();
        int i = 0;
        while (i < b) {
            C3286u h = m19601h(this.f17948D.mo27089b(i));
            if (h == uVar || mo26363a(h) != j) {
                i++;
            } else if (this.f17954J == null || !this.f17954J.mo23933d()) {
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + h + " \n View Holder 2:" + uVar);
            } else {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + h + " \n View Holder 2:" + uVar);
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + uVar2 + " cannot be found but it is necessary for " + uVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26375a(C3286u uVar, ItemAnimator.C3258c cVar) {
        uVar.mo26761a(0, 8192);
        if (this.f17978ac.f18099g && uVar.mo26793z() && !uVar.mo26785s() && !uVar.mo26771e()) {
            this.f17949E.mo27272a(mo26363a(uVar), uVar);
        }
        this.f17949E.mo27273a(uVar, cVar);
    }

    /* renamed from: a */
    private void m19586a(int[] iArr) {
        int b = this.f17948D.mo27087b();
        if (b == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < b; i3++) {
            C3286u h = m19601h(this.f17948D.mo27089b(i3));
            if (!h.mo26771e()) {
                int f = h.mo26772f();
                if (f < i) {
                    i = f;
                }
                if (f > i2) {
                    i2 = f;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    /* renamed from: b */
    private boolean mo26157b(int i, int i2) {
        m19586a(this.f17999ay);
        return (this.f17999ay[0] == i && this.f17999ay[1] == i2) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z) {
        C3286u h = m19601h(view);
        if (h != null) {
            if (h.mo26786t()) {
                h.mo26781o();
            } else if (!h.mo26771e()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + h);
            }
        }
        mo26442o(view);
        super.removeDetachedView(view, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo26363a(C3286u uVar) {
        return this.f17954J.mo23933d() ? uVar.mo26775i() : (long) uVar.f18123l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26376a(@NonNull C3286u uVar, @Nullable ItemAnimator.C3258c cVar, @NonNull ItemAnimator.C3258c cVar2) {
        uVar.mo26768b(false);
        if (this.f17966V.mo26519b(uVar, cVar, cVar2)) {
            mo26351A();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo26385b(@NonNull C3286u uVar, @NonNull ItemAnimator.C3258c cVar, @Nullable ItemAnimator.C3258c cVar2) {
        m19598e(uVar);
        uVar.mo26768b(false);
        if (this.f17966V.mo26517a(uVar, cVar, cVar2)) {
            mo26351A();
        }
    }

    /* renamed from: a */
    private void m19582a(@NonNull C3286u uVar, @NonNull C3286u uVar2, @NonNull ItemAnimator.C3258c cVar, @NonNull ItemAnimator.C3258c cVar2, boolean z, boolean z2) {
        uVar.mo26768b(false);
        if (z) {
            m19598e(uVar);
        }
        if (uVar != uVar2) {
            if (z2) {
                m19598e(uVar2);
            }
            uVar.f18128q = uVar2;
            m19598e(uVar);
            this.f17946B.mo26708c(uVar);
            uVar2.mo26768b(false);
            uVar2.f18129r = uVar;
        }
        if (this.f17966V.mo26518a(uVar, uVar2, cVar, cVar2)) {
            mo26351A();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.beginSection("RV OnLayout");
        mo26148a();
        TraceCompat.endSection();
        this.f17961Q = true;
    }

    public void requestLayout() {
        if (this.f18005k != 0 || this.f17963S) {
            this.f17962R = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public void mo26352B() {
        int c = this.f17948D.mo27090c();
        for (int i = 0; i < c; i++) {
            ((C3270h) this.f17948D.mo27093d(i).getLayoutParams()).f18061e = true;
        }
        this.f17946B.mo26720k();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int size = this.f17957M.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            this.f17957M.get(i).mo26548a(canvas, this, this.f17978ac);
        }
        if (this.f17966V != null && this.f17957M.size() > 0 && this.f17966V.mo26035b()) {
            z = true;
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f17957M.size();
        for (int i = 0; i < size; i++) {
            this.f17957M.get(i).mo26554c(canvas, this, this.f17978ac);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C3270h) && this.f17955K.mo26599a((C3270h) layoutParams);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.f17955K != null) {
            return this.f17955K.mo26075b();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.f17955K != null) {
            return this.f17955K.mo26570a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.f17955K != null) {
            return this.f17955K.mo26571a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public void mo26353C() {
        int c = this.f17948D.mo27090c();
        for (int i = 0; i < c; i++) {
            C3286u h = m19601h(this.f17948D.mo27093d(i));
            if (!h.mo26771e()) {
                h.mo26770d();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public void mo26354D() {
        int c = this.f17948D.mo27090c();
        for (int i = 0; i < c; i++) {
            C3286u h = m19601h(this.f17948D.mo27093d(i));
            if (!h.mo26771e()) {
                h.mo26769c();
            }
        }
        this.f17946B.mo26719j();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo26426i(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int c = this.f17948D.mo27090c();
        if (i < i2) {
            i5 = i;
            i4 = i2;
            i3 = -1;
        } else {
            i4 = i;
            i5 = i2;
            i3 = 1;
        }
        for (int i6 = 0; i6 < c; i6++) {
            C3286u h = m19601h(this.f17948D.mo27093d(i6));
            if (h != null && h.f18123l >= i5 && h.f18123l <= i4) {
                if (h.f18123l == i) {
                    h.mo26763a(i2 - i, false);
                } else {
                    h.mo26763a(i3, false);
                }
                this.f17978ac.f18097e = true;
            }
        }
        this.f17946B.mo26690a(i, i2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo26430j(int i, int i2) {
        int c = this.f17948D.mo27090c();
        this.f17978ac.f18097e = true;
        for (int i3 = 0; i3 < c; i3++) {
            C3286u h = m19601h(this.f17948D.mo27093d(i3));
            if (h != null && !h.mo26771e() && h.f18123l >= i) {
                h.mo26763a(i2, false);
                this.f17978ac.f18097e = true;
            }
        }
        this.f17946B.mo26701b(i, i2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26369a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.f17948D.mo27090c();
        this.f17978ac.f18097e = true;
        for (int i4 = 0; i4 < c; i4++) {
            C3286u h = m19601h(this.f17948D.mo27093d(i4));
            if (h != null && !h.mo26771e()) {
                if (h.f18123l >= i3) {
                    h.mo26763a(-i2, z);
                    this.f17978ac.f18097e = true;
                } else if (h.f18123l >= i) {
                    h.mo26762a(i - 1, -i2, z);
                    this.f17978ac.f18097e = true;
                }
            }
        }
        this.f17946B.mo26691a(i, i2, z);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26368a(int i, int i2, Object obj) {
        int c = this.f17948D.mo27090c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View d = this.f17948D.mo27093d(i4);
            C3286u h = m19601h(d);
            if (h != null && !h.mo26771e() && h.f18123l >= i && h.f18123l < i3) {
                h.mo26767b(2);
                h.mo26765a(obj);
                ((C3270h) d.getLayoutParams()).f18061e = true;
            }
        }
        this.f17946B.mo26706c(i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo26386b(C3286u uVar) {
        return this.f17966V == null || this.f17966V.mo26033a(uVar, uVar.mo26790w());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public void mo26355E() {
        if (!this.f17965U) {
            this.f17965U = true;
            int c = this.f17948D.mo27090c();
            for (int i = 0; i < c; i++) {
                C3286u h = m19601h(this.f17948D.mo27093d(i));
                if (h != null && !h.mo26771e()) {
                    h.mo26767b(512);
                }
            }
            this.f17946B.mo26717h();
            mo26356F();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F */
    public void mo26356F() {
        int c = this.f17948D.mo27090c();
        for (int i = 0; i < c; i++) {
            C3286u h = m19601h(this.f17948D.mo27093d(i));
            if (h != null && !h.mo26771e()) {
                h.mo26767b(6);
            }
        }
        mo26352B();
        this.f17946B.mo26718i();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f17994at;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.f17994at = z;
    }

    /* renamed from: e */
    public C3286u mo26395e(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return m19601h(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Nullable
    /* renamed from: f */
    public View mo26398f(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    @Nullable
    /* renamed from: g */
    public C3286u mo26402g(View view) {
        View f = mo26398f(view);
        if (f == null) {
            return null;
        }
        return mo26395e(f);
    }

    /* renamed from: h */
    static C3286u m19601h(View view) {
        if (view == null) {
            return null;
        }
        return ((C3270h) view.getLayoutParams()).f18059c;
    }

    /* renamed from: i */
    public int mo26424i(View view) {
        C3286u h = m19601h(view);
        if (h != null) {
            return h.mo26773g();
        }
        return -1;
    }

    /* renamed from: j */
    public int mo26428j(View view) {
        C3286u h = m19601h(view);
        if (h != null) {
            return h.mo26772f();
        }
        return -1;
    }

    /* renamed from: h */
    public C3286u mo26422h(int i) {
        return mo26365a(i, false);
    }

    /* renamed from: i */
    public C3286u mo26425i(int i) {
        C3286u uVar = null;
        if (this.f17965U) {
            return null;
        }
        int c = this.f17948D.mo27090c();
        for (int i2 = 0; i2 < c; i2++) {
            C3286u h = m19601h(this.f17948D.mo27093d(i2));
            if (h != null && !h.mo26785s() && mo26389d(h) == i) {
                if (!this.f17948D.mo27092c(h.f18121j)) {
                    return h;
                }
                uVar = h;
            }
        }
        return uVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3286u mo26365a(int i, boolean z) {
        int c = this.f17948D.mo27090c();
        C3286u uVar = null;
        for (int i2 = 0; i2 < c; i2++) {
            C3286u h = m19601h(this.f17948D.mo27093d(i2));
            if (h != null && !h.mo26785s()) {
                if (z) {
                    if (h.f18123l != i) {
                        continue;
                    }
                } else if (h.mo26772f() != i) {
                    continue;
                }
                if (!this.f17948D.mo27092c(h.f18121j)) {
                    return h;
                }
                uVar = h;
            }
        }
        return uVar;
    }

    /* renamed from: a */
    public C3286u mo26366a(long j) {
        C3286u uVar = null;
        if (this.f17954J == null || !this.f17954J.mo23933d()) {
            return null;
        }
        int c = this.f17948D.mo27090c();
        for (int i = 0; i < c; i++) {
            C3286u h = m19601h(this.f17948D.mo27093d(i));
            if (h != null && !h.mo26785s() && h.mo26775i() == j) {
                if (!this.f17948D.mo27092c(h.f18121j)) {
                    return h;
                }
                uVar = h;
            }
        }
        return uVar;
    }

    /* renamed from: a */
    public View mo26364a(float f, float f2) {
        for (int b = this.f17948D.mo27087b() - 1; b >= 0; b--) {
            View b2 = this.f17948D.mo27089b(b);
            float translationX = ViewCompat.getTranslationX(b2);
            float translationY = ViewCompat.getTranslationY(b2);
            if (f >= ((float) b2.getLeft()) + translationX && f <= ((float) b2.getRight()) + translationX && f2 >= ((float) b2.getTop()) + translationY && f2 <= ((float) b2.getBottom()) + translationY) {
                return b2;
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    /* renamed from: j */
    public void mo26429j(int i) {
        int b = this.f17948D.mo27087b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f17948D.mo27089b(i2).offsetTopAndBottom(i);
        }
    }

    /* renamed from: k */
    public void mo26431k(int i) {
        int b = this.f17948D.mo27087b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f17948D.mo27089b(i2).offsetLeftAndRight(i);
        }
    }

    /* renamed from: a */
    static void m19579a(View view, Rect rect) {
        C3270h hVar = (C3270h) view.getLayoutParams();
        Rect rect2 = hVar.f18060d;
        rect.set((view.getLeft() - rect2.left) - hVar.leftMargin, (view.getTop() - rect2.top) - hVar.topMargin, view.getRight() + rect2.right + hVar.rightMargin, view.getBottom() + rect2.bottom + hVar.bottomMargin);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public Rect mo26437m(View view) {
        C3270h hVar = (C3270h) view.getLayoutParams();
        if (!hVar.f18061e) {
            return hVar.f18060d;
        }
        if (this.f17978ac.mo26744a() && (hVar.mo26669e() || hVar.mo26667c())) {
            return hVar.f18060d;
        }
        Rect rect = hVar.f18060d;
        rect.set(0, 0, 0, 0);
        int size = this.f17957M.size();
        for (int i = 0; i < size; i++) {
            this.f17952H.set(0, 0, 0, 0);
            this.f17957M.get(i).mo23920a(this.f17952H, view, this, this.f17978ac);
            rect.left += this.f17952H.left;
            rect.top += this.f17952H.top;
            rect.right += this.f17952H.right;
            rect.bottom += this.f17952H.bottom;
        }
        hVar.f18061e = false;
        return rect;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo26432k(int i, int i2) {
        this.f18011q++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        mo26164d(i, i2);
        if (this.f17995au != null) {
            this.f17995au.mo20072a(this, i, i2);
        }
        if (this.f17996av != null) {
            for (int size = this.f17996av.size() - 1; size >= 0; size--) {
                this.f17996av.get(size).mo20072a(this, i, i2);
            }
        }
        this.f18011q--;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo26439m(int i) {
        if (this.f17955K != null) {
            this.f17955K.mo26647l(i);
        }
        mo26435l(i);
        if (this.f17995au != null) {
            this.f17995au.mo20071a(this, i);
        }
        if (this.f17996av != null) {
            for (int size = this.f17996av.size() - 1; size >= 0; size--) {
                this.f17996av.get(size).mo20071a(this, i);
            }
        }
    }

    /* renamed from: G */
    public boolean mo26357G() {
        return !this.f17961Q || this.f17965U || this.f17947C.mo27074d();
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$t */
    class C3285t implements Runnable {

        /* renamed from: a */
        Interpolator f18108a = RecyclerView.f17936ai;

        /* renamed from: c */
        private int f18110c;

        /* renamed from: d */
        private int f18111d;

        /* renamed from: e */
        private ScrollerCompat f18112e;

        /* renamed from: f */
        private boolean f18113f = false;

        /* renamed from: g */
        private boolean f18114g = false;

        public C3285t() {
            this.f18112e = ScrollerCompat.create(RecyclerView.this.getContext(), RecyclerView.f17936ai);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00fe, code lost:
            if (r12 > 0) goto L_0x0102;
         */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00fa  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x010a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r17 = this;
                r0 = r17
                flyme.support.v7.widget.RecyclerView r1 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$g r1 = r1.f17955K
                if (r1 != 0) goto L_0x000c
                r17.mo26758b()
                return
            L_0x000c:
                r17.m20041c()
                flyme.support.v7.widget.RecyclerView r1 = flyme.support.p093v7.widget.RecyclerView.this
                r1.mo26441o()
                androidx.core.widget.ScrollerCompat r1 = r0.f18112e
                flyme.support.v7.widget.RecyclerView r2 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$g r2 = r2.f17955K
                flyme.support.v7.widget.RecyclerView$q r2 = r2.f18051u
                boolean r3 = r1.computeScrollOffset()
                r4 = 0
                if (r3 == 0) goto L_0x019a
                int r3 = r1.getCurrX()
                int r5 = r1.getCurrY()
                int r6 = r0.f18110c
                int r6 = r3 - r6
                int r7 = r0.f18111d
                int r7 = r5 - r7
                r0.f18110c = r3
                r0.f18111d = r5
                flyme.support.v7.widget.RecyclerView r8 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$a r8 = r8.f17954J
                r9 = 1
                if (r8 == 0) goto L_0x00c3
                flyme.support.v7.widget.RecyclerView r8 = flyme.support.p093v7.widget.RecyclerView.this
                r8.mo26449p()
                flyme.support.v7.widget.RecyclerView r8 = flyme.support.p093v7.widget.RecyclerView.this
                r8.mo26483w()
                java.lang.String r8 = "RV Scroll"
                androidx.core.p005os.TraceCompat.beginSection(r8)
                if (r6 == 0) goto L_0x0062
                flyme.support.v7.widget.RecyclerView r8 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$g r8 = r8.f17955K
                flyme.support.v7.widget.RecyclerView r10 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$n r10 = r10.f17946B
                flyme.support.v7.widget.RecyclerView r11 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$r r11 = r11.f17978ac
                int r8 = r8.mo26057a((int) r6, (flyme.support.p093v7.widget.RecyclerView.C3277n) r10, (flyme.support.p093v7.widget.RecyclerView.C3283r) r11)
                int r10 = r6 - r8
                goto L_0x0064
            L_0x0062:
                r8 = 0
                r10 = 0
            L_0x0064:
                if (r7 == 0) goto L_0x0079
                flyme.support.v7.widget.RecyclerView r11 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$g r11 = r11.f17955K
                flyme.support.v7.widget.RecyclerView r12 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$n r12 = r12.f17946B
                flyme.support.v7.widget.RecyclerView r13 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$r r13 = r13.f17978ac
                int r11 = r11.mo26073b((int) r7, (flyme.support.p093v7.widget.RecyclerView.C3277n) r12, (flyme.support.p093v7.widget.RecyclerView.C3283r) r13)
                int r12 = r7 - r11
                goto L_0x007b
            L_0x0079:
                r11 = 0
                r12 = 0
            L_0x007b:
                androidx.core.p005os.TraceCompat.endSection()
                flyme.support.v7.widget.RecyclerView r13 = flyme.support.p093v7.widget.RecyclerView.this
                r13.mo26358H()
                flyme.support.v7.widget.RecyclerView r13 = flyme.support.p093v7.widget.RecyclerView.this
                r13.mo26484x()
                flyme.support.v7.widget.RecyclerView r13 = flyme.support.p093v7.widget.RecyclerView.this
                r13.mo26387c((boolean) r4)
                if (r2 == 0) goto L_0x00c7
                boolean r13 = r2.mo26734g()
                if (r13 != 0) goto L_0x00c7
                boolean r13 = r2.mo26735h()
                if (r13 == 0) goto L_0x00c7
                flyme.support.v7.widget.RecyclerView r13 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$r r13 = r13.f17978ac
                int r13 = r13.mo26749f()
                if (r13 != 0) goto L_0x00a9
                r2.mo26733f()
                goto L_0x00c7
            L_0x00a9:
                int r14 = r2.mo26736i()
                if (r14 < r13) goto L_0x00bb
                int r13 = r13 - r9
                r2.mo26730d(r13)
                int r13 = r6 - r10
                int r14 = r7 - r12
                r2.m20005a((int) r13, (int) r14)
                goto L_0x00c7
            L_0x00bb:
                int r13 = r6 - r10
                int r14 = r7 - r12
                r2.m20005a((int) r13, (int) r14)
                goto L_0x00c7
            L_0x00c3:
                r8 = 0
                r10 = 0
                r11 = 0
                r12 = 0
            L_0x00c7:
                flyme.support.v7.widget.RecyclerView r13 = flyme.support.p093v7.widget.RecyclerView.this
                java.util.ArrayList<flyme.support.v7.widget.RecyclerView$f> r13 = r13.f17957M
                boolean r13 = r13.isEmpty()
                if (r13 != 0) goto L_0x00d6
                flyme.support.v7.widget.RecyclerView r13 = flyme.support.p093v7.widget.RecyclerView.this
                r13.invalidate()
            L_0x00d6:
                flyme.support.v7.widget.RecyclerView r13 = flyme.support.p093v7.widget.RecyclerView.this
                int r13 = r13.getOverScrollMode()
                r14 = 2
                if (r13 == r14) goto L_0x00e4
                flyme.support.v7.widget.RecyclerView r13 = flyme.support.p093v7.widget.RecyclerView.this
                r13.mo26400f(r6, r7)
            L_0x00e4:
                if (r10 != 0) goto L_0x00e8
                if (r12 == 0) goto L_0x0126
            L_0x00e8:
                float r13 = r1.getCurrVelocity()
                int r13 = (int) r13
                if (r10 == r3) goto L_0x00f7
                if (r10 >= 0) goto L_0x00f3
                int r15 = -r13
                goto L_0x00f8
            L_0x00f3:
                if (r10 <= 0) goto L_0x00f7
                r15 = r13
                goto L_0x00f8
            L_0x00f7:
                r15 = 0
            L_0x00f8:
                if (r12 == r5) goto L_0x0101
                if (r12 >= 0) goto L_0x00fe
                int r13 = -r13
                goto L_0x0102
            L_0x00fe:
                if (r12 <= 0) goto L_0x0101
                goto L_0x0102
            L_0x0101:
                r13 = 0
            L_0x0102:
                flyme.support.v7.widget.RecyclerView r9 = flyme.support.p093v7.widget.RecyclerView.this
                int r9 = r9.getOverScrollMode()
                if (r9 == r14) goto L_0x010f
                flyme.support.v7.widget.RecyclerView r9 = flyme.support.p093v7.widget.RecyclerView.this
                r9.mo26404g(r15, r13)
            L_0x010f:
                if (r15 != 0) goto L_0x0119
                if (r10 == r3) goto L_0x0119
                int r3 = r1.getFinalX()
                if (r3 != 0) goto L_0x0126
            L_0x0119:
                if (r13 != 0) goto L_0x0123
                if (r12 == r5) goto L_0x0123
                int r3 = r1.getFinalY()
                if (r3 != 0) goto L_0x0126
            L_0x0123:
                r1.abortAnimation()
            L_0x0126:
                if (r8 != 0) goto L_0x012a
                if (r11 == 0) goto L_0x012f
            L_0x012a:
                flyme.support.v7.widget.RecyclerView r3 = flyme.support.p093v7.widget.RecyclerView.this
                r3.mo26432k(r8, r11)
            L_0x012f:
                flyme.support.v7.widget.RecyclerView r3 = flyme.support.p093v7.widget.RecyclerView.this
                boolean r3 = r3.awakenScrollBars()
                if (r3 != 0) goto L_0x013c
                flyme.support.v7.widget.RecyclerView r3 = flyme.support.p093v7.widget.RecyclerView.this
                r3.invalidate()
            L_0x013c:
                if (r7 == 0) goto L_0x014c
                flyme.support.v7.widget.RecyclerView r3 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$g r3 = r3.f17955K
                boolean r3 = r3.mo26092g()
                if (r3 == 0) goto L_0x014c
                if (r11 != r7) goto L_0x014c
                r3 = 1
                goto L_0x014d
            L_0x014c:
                r3 = 0
            L_0x014d:
                if (r6 == 0) goto L_0x015d
                flyme.support.v7.widget.RecyclerView r5 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$g r5 = r5.f17955K
                boolean r5 = r5.mo22258a()
                if (r5 == 0) goto L_0x015d
                if (r8 != r6) goto L_0x015d
                r5 = 1
                goto L_0x015e
            L_0x015d:
                r5 = 0
            L_0x015e:
                if (r6 != 0) goto L_0x0162
                if (r7 == 0) goto L_0x016a
            L_0x0162:
                if (r5 != 0) goto L_0x016a
                if (r3 == 0) goto L_0x0167
                goto L_0x016a
            L_0x0167:
                r16 = 0
                goto L_0x016c
            L_0x016a:
                r16 = 1
            L_0x016c:
                boolean r1 = r1.isFinished()
                if (r1 != 0) goto L_0x0188
                if (r16 != 0) goto L_0x0175
                goto L_0x0188
            L_0x0175:
                r17.mo26752a()
                flyme.support.v7.widget.RecyclerView r1 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.j r1 = r1.f17976aa
                if (r1 == 0) goto L_0x019a
                flyme.support.v7.widget.RecyclerView r1 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.j r1 = r1.f17976aa
                flyme.support.v7.widget.RecyclerView r3 = flyme.support.p093v7.widget.RecyclerView.this
                r1.mo27168a((flyme.support.p093v7.widget.RecyclerView) r3, (int) r6, (int) r7)
                goto L_0x019a
            L_0x0188:
                flyme.support.v7.widget.RecyclerView r1 = flyme.support.p093v7.widget.RecyclerView.this
                r1.setScrollState(r4)
                boolean r1 = flyme.support.p093v7.widget.RecyclerView.f17938c
                if (r1 == 0) goto L_0x019a
                flyme.support.v7.widget.RecyclerView r1 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.j$a r1 = r1.f17977ab
                r1.mo27173a()
            L_0x019a:
                if (r2 == 0) goto L_0x01ac
                boolean r1 = r2.mo26734g()
                if (r1 == 0) goto L_0x01a5
                r2.m20005a((int) r4, (int) r4)
            L_0x01a5:
                boolean r1 = r0.f18114g
                if (r1 != 0) goto L_0x01ac
                r2.mo26733f()
            L_0x01ac:
                r17.m20042d()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.RecyclerView.C3285t.run():void");
        }

        /* renamed from: c */
        private void m20041c() {
            this.f18114g = false;
            this.f18113f = true;
        }

        /* renamed from: d */
        private void m20042d() {
            this.f18113f = false;
            if (this.f18114g) {
                mo26752a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26752a() {
            if (this.f18113f) {
                this.f18114g = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        /* renamed from: a */
        public void mo26753a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f18111d = 0;
            this.f18110c = 0;
            this.f18112e.fling(0, 0, i, i2, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            mo26752a();
        }

        /* renamed from: b */
        public void mo26759b(int i, int i2) {
            mo26755a(i, i2, 0, 0);
        }

        /* renamed from: a */
        public void mo26755a(int i, int i2, int i3, int i4) {
            mo26754a(i, i2, m20040b(i, i2, i3, i4));
        }

        /* renamed from: a */
        private float m20039a(float f) {
            return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        }

        /* renamed from: b */
        private int m20040b(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i6 = width / 2;
            float f = (float) width;
            float f2 = (float) i6;
            float a = f2 + (m20039a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(a / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((((float) abs) / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, MsgField.IMSG_SAVE_PICTURE);
        }

        /* renamed from: a */
        public void mo26754a(int i, int i2, int i3) {
            mo26756a(i, i2, i3, RecyclerView.f17936ai);
        }

        /* renamed from: a */
        public void mo26757a(int i, int i2, Interpolator interpolator) {
            int b = m20040b(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.f17936ai;
            }
            mo26756a(i, i2, b, interpolator);
        }

        /* renamed from: a */
        public void mo26756a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f18108a != interpolator) {
                this.f18108a = interpolator;
                this.f18112e = ScrollerCompat.create(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f18111d = 0;
            this.f18110c = 0;
            this.f18112e.startScroll(0, 0, i, i2, i3);
            mo26752a();
        }

        /* renamed from: b */
        public void mo26758b() {
            RecyclerView.this.removeCallbacks(this);
            this.f18112e.abortAnimation();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public void mo26358H() {
        int b = this.f17948D.mo27087b();
        for (int i = 0; i < b; i++) {
            View b2 = this.f17948D.mo27089b(i);
            C3286u e = mo26395e(b2);
            if (!(e == null || e.f18129r == null)) {
                View view = e.f18129r.f18121j;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$p */
    private class C3279p extends C3262c {
        C3279p() {
        }

        /* renamed from: a */
        public void mo23939a() {
            RecyclerView.this.mo26377a((String) null);
            RecyclerView.this.f17978ac.f18097e = true;
            RecyclerView.this.mo26355E();
            if (!RecyclerView.this.f17947C.mo27074d()) {
                RecyclerView.this.requestLayout();
            }
        }

        /* renamed from: a */
        public void mo23941a(int i, int i2, Object obj) {
            RecyclerView.this.mo26377a((String) null);
            if (RecyclerView.this.f17947C.mo27069a(i, i2, obj)) {
                mo26722b();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26722b() {
            if (!RecyclerView.f17944z || !RecyclerView.this.f17959O || !RecyclerView.this.f17958N) {
                RecyclerView.this.f17964T = true;
                RecyclerView.this.requestLayout();
                return;
            }
            ViewCompat.postOnAnimation(RecyclerView.this, RecyclerView.this.f17951G);
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$m */
    public static class C3275m {

        /* renamed from: a */
        SparseArray<C3276a> f18063a = new SparseArray<>();

        /* renamed from: b */
        private int f18064b = 0;

        /* renamed from: flyme.support.v7.widget.RecyclerView$m$a */
        static class C3276a {

            /* renamed from: a */
            ArrayList<C3286u> f18065a = new ArrayList<>();

            /* renamed from: b */
            int f18066b = 5;

            /* renamed from: c */
            long f18067c = 0;

            /* renamed from: d */
            long f18068d = 0;

            C3276a() {
            }
        }

        /* renamed from: a */
        public void mo26676a() {
            for (int i = 0; i < this.f18063a.size(); i++) {
                this.f18063a.valueAt(i).f18065a.clear();
            }
        }

        /* renamed from: a */
        public C3286u mo26675a(int i) {
            C3276a aVar = this.f18063a.get(i);
            if (aVar == null || aVar.f18065a.isEmpty()) {
                return null;
            }
            ArrayList<C3286u> arrayList = aVar.f18065a;
            return arrayList.remove(arrayList.size() - 1);
        }

        /* renamed from: a */
        public void mo26680a(C3286u uVar) {
            int j = uVar.mo26776j();
            ArrayList<C3286u> arrayList = m19949b(j).f18065a;
            if (this.f18063a.get(j).f18066b > arrayList.size()) {
                uVar.mo26791x();
                arrayList.add(uVar);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public long mo26674a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26677a(int i, long j) {
            C3276a b = m19949b(i);
            b.f18067c = mo26674a(b.f18067c, j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26683b(int i, long j) {
            C3276a b = m19949b(i);
            b.f18068d = mo26674a(b.f18068d, j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo26681a(int i, long j, long j2) {
            long j3 = m19949b(i).f18067c;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo26684b(int i, long j, long j2) {
            long j3 = m19949b(i).f18068d;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26678a(C3260a aVar) {
            this.f18064b++;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26682b() {
            this.f18064b--;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26679a(C3260a aVar, C3260a aVar2, boolean z) {
            if (aVar != null) {
                mo26682b();
            }
            if (!z && this.f18064b == 0) {
                mo26676a();
            }
            if (aVar2 != null) {
                mo26678a(aVar2);
            }
        }

        /* renamed from: b */
        private C3276a m19949b(int i) {
            C3276a aVar = this.f18063a.get(i);
            if (aVar != null) {
                return aVar;
            }
            C3276a aVar2 = new C3276a();
            this.f18063a.put(i, aVar2);
            return aVar2;
        }
    }

    @Nullable
    /* renamed from: n */
    static RecyclerView m19606n(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView n = m19606n(viewGroup.getChildAt(i));
            if (n != null) {
                return n;
            }
        }
        return null;
    }

    /* renamed from: c */
    static void m19595c(@NonNull C3286u uVar) {
        if (uVar.f18122k != null) {
            View view = (View) uVar.f18122k.get();
            while (view != null) {
                if (view != uVar.f18121j) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            uVar.f18122k = null;
        }
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (f17938c) {
            return System.nanoTime();
        }
        return 0;
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$n */
    public final class C3277n {

        /* renamed from: a */
        final ArrayList<C3286u> f18069a = new ArrayList<>();

        /* renamed from: b */
        ArrayList<C3286u> f18070b = null;

        /* renamed from: c */
        final ArrayList<C3286u> f18071c = new ArrayList<>();

        /* renamed from: d */
        int f18072d = 2;

        /* renamed from: e */
        C3275m f18073e;

        /* renamed from: g */
        private final List<C3286u> f18075g = Collections.unmodifiableList(this.f18069a);

        /* renamed from: h */
        private int f18076h = 2;

        /* renamed from: i */
        private C3284s f18077i;

        public C3277n() {
        }

        /* renamed from: a */
        public void mo26688a() {
            this.f18069a.clear();
            mo26709d();
        }

        /* renamed from: a */
        public void mo26689a(int i) {
            this.f18076h = i;
            mo26700b();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26700b() {
            this.f18072d = this.f18076h + (RecyclerView.this.f17955K != null ? RecyclerView.this.f17955K.f18055y : 0);
            for (int size = this.f18071c.size() - 1; size >= 0 && this.f18071c.size() > this.f18072d; size--) {
                mo26710d(size);
            }
        }

        /* renamed from: c */
        public List<C3286u> mo26705c() {
            return this.f18075g;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo26697a(C3286u uVar) {
            if (uVar.mo26785s()) {
                return RecyclerView.this.f17978ac.mo26744a();
            }
            if (uVar.f18123l < 0 || uVar.f18123l >= RecyclerView.this.f17954J.mo20093a()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + uVar);
            } else if (!RecyclerView.this.f17978ac.mo26744a() && RecyclerView.this.f17954J.mo22520a_(uVar.f18123l) != uVar.mo26776j()) {
                return false;
            } else {
                if (!RecyclerView.this.f17954J.mo23933d() || uVar.mo26775i() == RecyclerView.this.f17954J.mo20100c(uVar.f18123l)) {
                    return true;
                }
                return false;
            }
        }

        /* renamed from: a */
        private boolean m19962a(C3286u uVar, int i, int i2, long j) {
            uVar.f18133v = RecyclerView.this;
            int j2 = uVar.mo26776j();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.f18073e.mo26684b(j2, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.f17954J.mo26539b(uVar, i);
            this.f18073e.mo26683b(uVar.mo26776j(), RecyclerView.this.getNanoTime() - nanoTime);
            m19963d(uVar.f18121j);
            if (!RecyclerView.this.f17978ac.mo26744a()) {
                return true;
            }
            uVar.f18127p = i2;
            return true;
        }

        /* renamed from: b */
        public int mo26698b(int i) {
            if (i < 0 || i >= RecyclerView.this.f17978ac.mo26749f()) {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.f17978ac.mo26749f());
            } else if (!RecyclerView.this.f17978ac.mo26744a()) {
                return i;
            } else {
                return RecyclerView.this.f17947C.mo27070b(i);
            }
        }

        /* renamed from: c */
        public View mo26704c(int i) {
            View a = mo26685a(i, false);
            RecyclerView.this.mo26151a(a, i);
            return a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public View mo26685a(int i, boolean z) {
            return mo26686a(i, z, Long.MAX_VALUE).f18121j;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0174  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x019f  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01a2  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x01d2  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x01e0  */
        @androidx.annotation.Nullable
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public flyme.support.p093v7.widget.RecyclerView.C3286u mo26686a(int r17, boolean r18, long r19) {
            /*
                r16 = this;
                r6 = r16
                r3 = r17
                r0 = r18
                if (r3 < 0) goto L_0x0203
                flyme.support.v7.widget.RecyclerView r1 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$r r1 = r1.f17978ac
                int r1 = r1.mo26749f()
                if (r3 >= r1) goto L_0x0203
                flyme.support.v7.widget.RecyclerView r1 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$r r1 = r1.f17978ac
                boolean r1 = r1.mo26744a()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                flyme.support.v7.widget.RecyclerView$u r1 = r16.mo26714f(r17)
                if (r1 == 0) goto L_0x0028
                r4 = 1
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                flyme.support.v7.widget.RecyclerView$u r1 = r16.mo26699b((int) r17, (boolean) r18)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.mo26697a((flyme.support.p093v7.widget.RecyclerView.C3286u) r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.mo26767b((int) r5)
                boolean r5 = r1.mo26777k()
                if (r5 == 0) goto L_0x004e
                flyme.support.v7.widget.RecyclerView r5 = flyme.support.p093v7.widget.RecyclerView.this
                android.view.View r9 = r1.f18121j
                r5.removeDetachedView(r9, r8)
                r1.mo26778l()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.mo26779m()
                if (r5 == 0) goto L_0x0057
                r1.mo26780n()
            L_0x0057:
                r6.mo26703b((flyme.support.p093v7.widget.RecyclerView.C3286u) r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = 1
            L_0x005d:
                if (r1 != 0) goto L_0x0153
                flyme.support.v7.widget.RecyclerView r5 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.c r5 = r5.f17947C
                int r5 = r5.mo27070b((int) r3)
                if (r5 < 0) goto L_0x0124
                flyme.support.v7.widget.RecyclerView r9 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$a r9 = r9.f17954J
                int r9 = r9.mo20093a()
                if (r5 >= r9) goto L_0x0124
                flyme.support.v7.widget.RecyclerView r9 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$a r9 = r9.f17954J
                int r9 = r9.mo22520a_(r5)
                flyme.support.v7.widget.RecyclerView r10 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$a r10 = r10.f17954J
                boolean r10 = r10.mo23933d()
                if (r10 == 0) goto L_0x0096
                flyme.support.v7.widget.RecyclerView r1 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$a r1 = r1.f17954J
                long r10 = r1.mo20100c((int) r5)
                flyme.support.v7.widget.RecyclerView$u r1 = r6.mo26687a((long) r10, (int) r9, (boolean) r0)
                if (r1 == 0) goto L_0x0096
                r1.f18123l = r5
                r4 = 1
            L_0x0096:
                if (r1 != 0) goto L_0x00c3
                flyme.support.v7.widget.RecyclerView$s r0 = r6.f18077i
                if (r0 == 0) goto L_0x00c3
                flyme.support.v7.widget.RecyclerView$s r0 = r6.f18077i
                android.view.View r0 = r0.mo26751a(r6, r3, r9)
                if (r0 == 0) goto L_0x00c3
                flyme.support.v7.widget.RecyclerView r1 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$u r1 = r1.mo26395e((android.view.View) r0)
                if (r1 == 0) goto L_0x00bb
                boolean r0 = r1.mo26771e()
                if (r0 != 0) goto L_0x00b3
                goto L_0x00c3
            L_0x00b3:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r0.<init>(r1)
                throw r0
            L_0x00bb:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r0.<init>(r1)
                throw r0
            L_0x00c3:
                if (r1 != 0) goto L_0x00d9
                flyme.support.v7.widget.RecyclerView$m r0 = r16.mo26716g()
                flyme.support.v7.widget.RecyclerView$u r1 = r0.mo26675a((int) r9)
                if (r1 == 0) goto L_0x00d9
                r1.mo26791x()
                boolean r0 = flyme.support.p093v7.widget.RecyclerView.f17942x
                if (r0 == 0) goto L_0x00d9
                r6.m19964e((flyme.support.p093v7.widget.RecyclerView.C3286u) r1)
            L_0x00d9:
                if (r1 != 0) goto L_0x0153
                flyme.support.v7.widget.RecyclerView r0 = flyme.support.p093v7.widget.RecyclerView.this
                long r0 = r0.getNanoTime()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
                if (r5 == 0) goto L_0x00f7
                flyme.support.v7.widget.RecyclerView$m r10 = r6.f18073e
                r11 = r9
                r12 = r0
                r14 = r19
                boolean r5 = r10.mo26681a((int) r11, (long) r12, (long) r14)
                if (r5 != 0) goto L_0x00f7
                return r2
            L_0x00f7:
                flyme.support.v7.widget.RecyclerView r2 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$a r2 = r2.f17954J
                flyme.support.v7.widget.RecyclerView r5 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$u r2 = r2.mo26540c(r5, r9)
                boolean r5 = flyme.support.p093v7.widget.RecyclerView.f17938c
                if (r5 == 0) goto L_0x0116
                android.view.View r5 = r2.f18121j
                flyme.support.v7.widget.RecyclerView r5 = flyme.support.p093v7.widget.RecyclerView.m19606n(r5)
                if (r5 == 0) goto L_0x0116
                java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
                r10.<init>(r5)
                r2.f18122k = r10
            L_0x0116:
                flyme.support.v7.widget.RecyclerView r5 = flyme.support.p093v7.widget.RecyclerView.this
                long r10 = r5.getNanoTime()
                flyme.support.v7.widget.RecyclerView$m r5 = r6.f18073e
                long r10 = r10 - r0
                r5.mo26677a((int) r9, (long) r10)
                r10 = r2
                goto L_0x0154
            L_0x0124:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ").state:"
                r1.append(r2)
                flyme.support.v7.widget.RecyclerView r2 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$r r2 = r2.f17978ac
                int r2 = r2.mo26749f()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0153:
                r10 = r1
            L_0x0154:
                r9 = r4
                if (r9 == 0) goto L_0x018f
                flyme.support.v7.widget.RecyclerView r0 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$r r0 = r0.f17978ac
                boolean r0 = r0.mo26744a()
                if (r0 != 0) goto L_0x018f
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r10.mo26766a((int) r0)
                if (r1 == 0) goto L_0x018f
                r10.mo26761a((int) r8, (int) r0)
                flyme.support.v7.widget.RecyclerView r0 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$r r0 = r0.f17978ac
                boolean r0 = r0.f18101i
                if (r0 == 0) goto L_0x018f
                int r0 = flyme.support.p093v7.widget.RecyclerView.ItemAnimator.m19715e(r10)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                flyme.support.v7.widget.RecyclerView r1 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$ItemAnimator r1 = r1.f17966V
                flyme.support.v7.widget.RecyclerView r2 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$r r2 = r2.f17978ac
                java.util.List r4 = r10.mo26790w()
                flyme.support.v7.widget.RecyclerView$ItemAnimator$c r0 = r1.mo26515a((flyme.support.p093v7.widget.RecyclerView.C3283r) r2, (flyme.support.p093v7.widget.RecyclerView.C3286u) r10, (int) r0, (java.util.List<java.lang.Object>) r4)
                flyme.support.v7.widget.RecyclerView r1 = flyme.support.p093v7.widget.RecyclerView.this
                r1.mo26375a((flyme.support.p093v7.widget.RecyclerView.C3286u) r10, (flyme.support.p093v7.widget.RecyclerView.ItemAnimator.C3258c) r0)
            L_0x018f:
                flyme.support.v7.widget.RecyclerView r0 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$r r0 = r0.f17978ac
                boolean r0 = r0.mo26744a()
                if (r0 == 0) goto L_0x01a2
                boolean r0 = r10.mo26784r()
                if (r0 == 0) goto L_0x01a2
                r10.f18127p = r3
                goto L_0x01b5
            L_0x01a2:
                boolean r0 = r10.mo26784r()
                if (r0 == 0) goto L_0x01b7
                boolean r0 = r10.mo26783q()
                if (r0 != 0) goto L_0x01b7
                boolean r0 = r10.mo26782p()
                if (r0 == 0) goto L_0x01b5
                goto L_0x01b7
            L_0x01b5:
                r0 = 0
                goto L_0x01ca
            L_0x01b7:
                flyme.support.v7.widget.RecyclerView r0 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.c r0 = r0.f17947C
                int r2 = r0.mo27070b((int) r3)
                r0 = r16
                r1 = r10
                r3 = r17
                r4 = r19
                boolean r0 = r0.m19962a(r1, r2, r3, r4)
            L_0x01ca:
                android.view.View r1 = r10.f18121j
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x01e0
                flyme.support.v7.widget.RecyclerView r1 = flyme.support.p093v7.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
                flyme.support.v7.widget.RecyclerView$h r1 = (flyme.support.p093v7.widget.RecyclerView.C3270h) r1
                android.view.View r2 = r10.f18121j
                r2.setLayoutParams(r1)
                goto L_0x01f8
            L_0x01e0:
                flyme.support.v7.widget.RecyclerView r2 = flyme.support.p093v7.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x01f6
                flyme.support.v7.widget.RecyclerView r2 = flyme.support.p093v7.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                flyme.support.v7.widget.RecyclerView$h r1 = (flyme.support.p093v7.widget.RecyclerView.C3270h) r1
                android.view.View r2 = r10.f18121j
                r2.setLayoutParams(r1)
                goto L_0x01f8
            L_0x01f6:
                flyme.support.v7.widget.RecyclerView$h r1 = (flyme.support.p093v7.widget.RecyclerView.C3270h) r1
            L_0x01f8:
                r1.f18059c = r10
                if (r9 == 0) goto L_0x01ff
                if (r0 == 0) goto L_0x01ff
                goto L_0x0200
            L_0x01ff:
                r7 = 0
            L_0x0200:
                r1.f18062f = r7
                return r10
            L_0x0203:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                flyme.support.v7.widget.RecyclerView r2 = flyme.support.p093v7.widget.RecyclerView.this
                flyme.support.v7.widget.RecyclerView$r r2 = r2.f17978ac
                int r2 = r2.mo26749f()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.RecyclerView.C3277n.mo26686a(int, boolean, long):flyme.support.v7.widget.RecyclerView$u");
        }

        /* renamed from: d */
        private void m19963d(View view) {
            if (RecyclerView.this.mo26485y()) {
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                if (!ViewCompat.hasAccessibilityDelegate(view)) {
                    ViewCompat.setAccessibilityDelegate(view, RecyclerView.this.f17982ag.mo26795b());
                }
            }
        }

        /* renamed from: e */
        private void m19964e(C3286u uVar) {
            if (uVar.f18121j instanceof ViewGroup) {
                m19961a((ViewGroup) uVar.f18121j, false);
            }
        }

        /* renamed from: a */
        private void m19961a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m19961a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        /* renamed from: a */
        public void mo26692a(View view) {
            C3286u h = RecyclerView.m19601h(view);
            if (h.mo26786t()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (h.mo26777k()) {
                h.mo26778l();
            } else if (h.mo26779m()) {
                h.mo26780n();
            }
            mo26703b(h);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo26709d() {
            for (int size = this.f18071c.size() - 1; size >= 0; size--) {
                mo26710d(size);
            }
            this.f18071c.clear();
            if (RecyclerView.f17938c) {
                RecyclerView.this.f17977ab.mo27173a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo26710d(int i) {
            mo26696a(this.f18071c.get(i), true);
            this.f18071c.remove(i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26703b(C3286u uVar) {
            boolean z;
            boolean z2 = false;
            if (uVar.mo26777k() || uVar.f18121j.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(uVar.mo26777k());
                sb.append(" isAttached:");
                if (uVar.f18121j.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                throw new IllegalArgumentException(sb.toString());
            } else if (uVar.mo26786t()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + uVar);
            } else if (!uVar.mo26771e()) {
                boolean a = uVar.m20051A();
                if ((RecyclerView.this.f17954J != null && a && RecyclerView.this.f17954J.mo23934d(uVar)) || uVar.mo26792y()) {
                    if (this.f18072d <= 0 || uVar.mo26766a(526)) {
                        z = false;
                    } else {
                        int size = this.f18071c.size();
                        if (size >= this.f18072d && size > 0) {
                            mo26710d(0);
                            size--;
                        }
                        if (RecyclerView.f17938c && size > 0 && !RecyclerView.this.f17977ab.mo27176a(uVar.f18123l)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.f17977ab.mo27176a(this.f18071c.get(i).f18123l)) {
                                    break;
                                }
                                i--;
                            }
                            size = i + 1;
                        }
                        this.f18071c.add(size, uVar);
                        z = true;
                    }
                    if (!z) {
                        mo26696a(uVar, true);
                        z2 = true;
                    }
                } else {
                    z = false;
                }
                RecyclerView.this.f17949E.mo27284g(uVar);
                if (!z && !z2 && a) {
                    uVar.f18133v = null;
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26696a(C3286u uVar, boolean z) {
            RecyclerView.m19595c(uVar);
            ViewCompat.setAccessibilityDelegate(uVar.f18121j, (AccessibilityDelegateCompat) null);
            if (z) {
                mo26711d(uVar);
            }
            uVar.f18133v = null;
            mo26716g().mo26680a(uVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26702b(View view) {
            C3286u h = RecyclerView.m19601h(view);
            C3277n unused = h.f18118d = null;
            boolean unused2 = h.f18119e = false;
            h.mo26780n();
            mo26703b(h);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo26707c(View view) {
            C3286u h = RecyclerView.m19601h(view);
            if (!h.mo26766a(12) && h.mo26793z() && !RecyclerView.this.mo26386b(h)) {
                if (this.f18070b == null) {
                    this.f18070b = new ArrayList<>();
                }
                h.mo26764a(this, true);
                this.f18070b.add(h);
            } else if (!h.mo26782p() || h.mo26785s() || RecyclerView.this.f17954J.mo23933d()) {
                h.mo26764a(this, false);
                this.f18069a.add(h);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo26708c(C3286u uVar) {
            if (uVar.f18119e) {
                this.f18070b.remove(uVar);
            } else {
                this.f18069a.remove(uVar);
            }
            C3277n unused = uVar.f18118d = null;
            boolean unused2 = uVar.f18119e = false;
            uVar.mo26780n();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public int mo26712e() {
            return this.f18069a.size();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public View mo26713e(int i) {
            return this.f18069a.get(i).f18121j;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo26715f() {
            this.f18069a.clear();
            if (this.f18070b != null) {
                this.f18070b.clear();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public C3286u mo26714f(int i) {
            int size;
            int b;
            if (this.f18070b == null || (size = this.f18070b.size()) == 0) {
                return null;
            }
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                C3286u uVar = this.f18070b.get(i3);
                if (uVar.mo26779m() || uVar.mo26772f() != i) {
                    i3++;
                } else {
                    uVar.mo26767b(32);
                    return uVar;
                }
            }
            if (RecyclerView.this.f17954J.mo23933d() && (b = RecyclerView.this.f17947C.mo27070b(i)) > 0 && b < RecyclerView.this.f17954J.mo20093a()) {
                long c = RecyclerView.this.f17954J.mo20100c(b);
                while (i2 < size) {
                    C3286u uVar2 = this.f18070b.get(i2);
                    if (uVar2.mo26779m() || uVar2.mo26775i() != c) {
                        i2++;
                    } else {
                        uVar2.mo26767b(32);
                        return uVar2;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C3286u mo26699b(int i, boolean z) {
            View c;
            int size = this.f18069a.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                C3286u uVar = this.f18069a.get(i3);
                if (uVar.mo26779m() || uVar.mo26772f() != i || uVar.mo26782p() || (!RecyclerView.this.f17978ac.f18098f && uVar.mo26785s())) {
                    i3++;
                } else {
                    uVar.mo26767b(32);
                    return uVar;
                }
            }
            if (z || (c = RecyclerView.this.f17948D.mo27091c(i)) == null) {
                int size2 = this.f18071c.size();
                while (i2 < size2) {
                    C3286u uVar2 = this.f18071c.get(i2);
                    if (uVar2.mo26782p() || uVar2.mo26772f() != i) {
                        i2++;
                    } else {
                        if (!z) {
                            this.f18071c.remove(i2);
                        }
                        return uVar2;
                    }
                }
                return null;
            }
            C3286u h = RecyclerView.m19601h(c);
            RecyclerView.this.f17948D.mo27096e(c);
            int b = RecyclerView.this.f17948D.mo27088b(c);
            if (b != -1) {
                RecyclerView.this.f17948D.mo27095e(b);
                mo26707c(c);
                h.mo26767b(8224);
                return h;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + h);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C3286u mo26687a(long j, int i, boolean z) {
            for (int size = this.f18069a.size() - 1; size >= 0; size--) {
                C3286u uVar = this.f18069a.get(size);
                if (uVar.mo26775i() == j && !uVar.mo26779m()) {
                    if (i == uVar.mo26776j()) {
                        uVar.mo26767b(32);
                        if (uVar.mo26785s() && !RecyclerView.this.f17978ac.mo26744a()) {
                            uVar.mo26761a(2, 14);
                        }
                        return uVar;
                    } else if (!z) {
                        this.f18069a.remove(size);
                        RecyclerView.this.removeDetachedView(uVar.f18121j, false);
                        mo26702b(uVar.f18121j);
                    }
                }
            }
            int size2 = this.f18071c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                C3286u uVar2 = this.f18071c.get(size2);
                if (uVar2.mo26775i() == j) {
                    if (i == uVar2.mo26776j()) {
                        if (!z) {
                            this.f18071c.remove(size2);
                        }
                        return uVar2;
                    } else if (!z) {
                        mo26710d(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo26711d(C3286u uVar) {
            if (RecyclerView.this.f17956L != null) {
                RecyclerView.this.f17956L.mo26721a(uVar);
            }
            if (RecyclerView.this.f17954J != null) {
                RecyclerView.this.f17954J.mo20096a(uVar);
            }
            if (RecyclerView.this.f17978ac != null) {
                RecyclerView.this.f17949E.mo27284g(uVar);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26693a(C3260a aVar, C3260a aVar2, boolean z) {
            mo26688a();
            mo26716g().mo26679a(aVar, aVar2, z);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26690a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i5 = i;
                i4 = i2;
                i3 = -1;
            } else {
                i4 = i;
                i5 = i2;
                i3 = 1;
            }
            int size = this.f18071c.size();
            for (int i6 = 0; i6 < size; i6++) {
                C3286u uVar = this.f18071c.get(i6);
                if (uVar != null && uVar.f18123l >= i5 && uVar.f18123l <= i4) {
                    if (uVar.f18123l == i) {
                        uVar.mo26763a(i2 - i, false);
                    } else {
                        uVar.mo26763a(i3, false);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26701b(int i, int i2) {
            int size = this.f18071c.size();
            for (int i3 = 0; i3 < size; i3++) {
                C3286u uVar = this.f18071c.get(i3);
                if (uVar != null && uVar.f18123l >= i) {
                    uVar.mo26763a(i2, true);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26691a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f18071c.size() - 1; size >= 0; size--) {
                C3286u uVar = this.f18071c.get(size);
                if (uVar != null) {
                    if (uVar.f18123l >= i3) {
                        uVar.mo26763a(-i2, z);
                    } else if (uVar.f18123l >= i) {
                        uVar.mo26767b(8);
                        mo26710d(size);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26695a(C3284s sVar) {
            this.f18077i = sVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26694a(C3275m mVar) {
            if (this.f18073e != null) {
                this.f18073e.mo26682b();
            }
            this.f18073e = mVar;
            if (mVar != null) {
                this.f18073e.mo26678a(RecyclerView.this.getAdapter());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public C3275m mo26716g() {
            if (this.f18073e == null) {
                this.f18073e = new C3275m();
            }
            return this.f18073e;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo26706c(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.f18071c.size() - 1; size >= 0; size--) {
                C3286u uVar = this.f18071c.get(size);
                if (uVar != null && (i3 = uVar.f18123l) >= i && i3 < i4) {
                    uVar.mo26767b(2);
                    mo26710d(size);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo26717h() {
            int size = this.f18071c.size();
            for (int i = 0; i < size; i++) {
                C3286u uVar = this.f18071c.get(i);
                if (uVar != null) {
                    uVar.mo26767b(512);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void mo26718i() {
            if (RecyclerView.this.f17954J == null || !RecyclerView.this.f17954J.mo23933d()) {
                mo26709d();
                return;
            }
            int size = this.f18071c.size();
            for (int i = 0; i < size; i++) {
                C3286u uVar = this.f18071c.get(i);
                if (uVar != null) {
                    uVar.mo26767b(6);
                    uVar.mo26765a((Object) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void mo26719j() {
            int size = this.f18071c.size();
            for (int i = 0; i < size; i++) {
                this.f18071c.get(i).mo26769c();
            }
            int size2 = this.f18069a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f18069a.get(i2).mo26769c();
            }
            if (this.f18070b != null) {
                int size3 = this.f18070b.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f18070b.get(i3).mo26769c();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void mo26720k() {
            int size = this.f18071c.size();
            for (int i = 0; i < size; i++) {
                C3270h hVar = (C3270h) this.f18071c.get(i).f18121j.getLayoutParams();
                if (hVar != null) {
                    hVar.f18061e = true;
                }
            }
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$a */
    public static abstract class C3260a<VH extends C3286u> {

        /* renamed from: a */
        private final C3261b f18034a = new C3261b();

        /* renamed from: b */
        private boolean f18035b = false;

        /* renamed from: a */
        public abstract int mo20093a();

        /* renamed from: a */
        public void mo20096a(VH vh) {
        }

        /* renamed from: a */
        public abstract void mo20097a(VH vh, int i);

        /* renamed from: a */
        public void mo23923a(RecyclerView recyclerView) {
        }

        /* renamed from: a_ */
        public int mo22520a_(int i) {
            return 0;
        }

        /* renamed from: b */
        public abstract VH mo20098b(ViewGroup viewGroup, int i);

        /* renamed from: b */
        public void mo23927b(VH vh) {
        }

        /* renamed from: c */
        public long mo20100c(int i) {
            return -1;
        }

        /* renamed from: c */
        public void mo23931c(VH vh) {
        }

        /* renamed from: c */
        public void mo23932c(RecyclerView recyclerView) {
        }

        /* renamed from: d */
        public boolean mo23934d(VH vh) {
            return false;
        }

        /* renamed from: f */
        public boolean mo23936f(int i) {
            return true;
        }

        /* renamed from: g */
        public boolean mo23937g(int i) {
            return true;
        }

        /* renamed from: a */
        public void mo23922a(VH vh, int i, List<Object> list) {
            mo20097a(vh, i);
        }

        /* renamed from: c */
        public final VH mo26540c(ViewGroup viewGroup, int i) {
            TraceCompat.beginSection("RV CreateView");
            VH b = mo20098b(viewGroup, i);
            b.f18126o = i;
            TraceCompat.endSection();
            return b;
        }

        /* renamed from: b */
        public final void mo26539b(VH vh, int i) {
            vh.f18123l = i;
            if (mo23933d()) {
                vh.f18125n = mo20100c(i);
            }
            vh.mo26761a(1, 519);
            TraceCompat.beginSection("RV OnBindView");
            mo23922a(vh, i, vh.mo26790w());
            vh.mo26789v();
            ViewGroup.LayoutParams layoutParams = vh.f18121j.getLayoutParams();
            if (layoutParams instanceof C3270h) {
                ((C3270h) layoutParams).f18061e = true;
            }
            TraceCompat.endSection();
        }

        /* renamed from: d */
        public boolean mo23933d() {
            return this.f18035b;
        }

        /* renamed from: a */
        public void mo23921a(C3262c cVar) {
            this.f18034a.registerObserver(cVar);
        }

        /* renamed from: b */
        public void mo23926b(C3262c cVar) {
            this.f18034a.unregisterObserver(cVar);
        }

        /* renamed from: f */
        public final void mo26541f() {
            this.f18034a.mo26543a();
        }

        /* renamed from: h */
        public final void mo26542h(int i) {
            this.f18034a.mo26544a(i, 1);
        }

        /* renamed from: a */
        public final void mo26537a(int i, int i2) {
            this.f18034a.mo26544a(i, i2);
        }

        /* renamed from: a */
        public final void mo26538a(int i, int i2, Object obj) {
            this.f18034a.mo26545a(i, i2, obj);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo26442o(View view) {
        C3286u h = m19601h(view);
        mo26436l(view);
        if (!(this.f17954J == null || h == null)) {
            this.f17954J.mo23931c(h);
        }
        if (this.f18009o != null) {
            for (int size = this.f18009o.size() - 1; size >= 0; size--) {
                this.f18009o.get(size).mo26672b(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo26450p(View view) {
        C3286u h = m19601h(view);
        mo26433k(view);
        if (!(this.f17954J == null || h == null)) {
            this.f17954J.mo23927b(h);
        }
        if (this.f18009o != null) {
            for (int size = this.f18009o.size() - 1; size >= 0; size--) {
                this.f18009o.get(size).mo26671a(view);
            }
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$g */
    public static abstract class C3266g {

        /* renamed from: a */
        private final ViewBoundsCheck.C3321b f18039a = new ViewBoundsCheck.C3321b() {
            /* renamed from: a */
            public View mo26663a(int i) {
                return C3266g.this.mo26641i(i);
            }

            /* renamed from: a */
            public int mo26661a() {
                return C3266g.this.mo26559C();
            }

            /* renamed from: b */
            public int mo26664b() {
                return C3266g.this.mo26557A() - C3266g.this.mo26561E();
            }

            /* renamed from: a */
            public int mo26662a(View view) {
                return C3266g.this.mo26638h(view) - ((C3270h) view.getLayoutParams()).leftMargin;
            }

            /* renamed from: b */
            public int mo26665b(View view) {
                return C3266g.this.mo26642j(view) + ((C3270h) view.getLayoutParams()).rightMargin;
            }
        };

        /* renamed from: b */
        private final ViewBoundsCheck.C3321b f18040b = new ViewBoundsCheck.C3321b() {
            /* renamed from: a */
            public View mo26663a(int i) {
                return C3266g.this.mo26641i(i);
            }

            /* renamed from: a */
            public int mo26661a() {
                return C3266g.this.mo26560D();
            }

            /* renamed from: b */
            public int mo26664b() {
                return C3266g.this.mo26558B() - C3266g.this.mo26562F();
            }

            /* renamed from: a */
            public int mo26662a(View view) {
                return C3266g.this.mo26640i(view) - ((C3270h) view.getLayoutParams()).topMargin;
            }

            /* renamed from: b */
            public int mo26665b(View view) {
                return C3266g.this.mo26644k(view) + ((C3270h) view.getLayoutParams()).bottomMargin;
            }
        };

        /* renamed from: c */
        private boolean f18041c = true;

        /* renamed from: d */
        private boolean f18042d = true;

        /* renamed from: e */
        private int f18043e;

        /* renamed from: f */
        private int f18044f;

        /* renamed from: g */
        private int f18045g;

        /* renamed from: h */
        private int f18046h;

        /* renamed from: q */
        ChildHelper f18047q;

        /* renamed from: r */
        RecyclerView f18048r;

        /* renamed from: s */
        ViewBoundsCheck f18049s = new ViewBoundsCheck(this.f18039a);

        /* renamed from: t */
        ViewBoundsCheck f18050t = new ViewBoundsCheck(this.f18040b);
        @Nullable

        /* renamed from: u */
        C3280q f18051u;

        /* renamed from: v */
        boolean f18052v = false;

        /* renamed from: w */
        boolean f18053w = false;

        /* renamed from: x */
        boolean f18054x = false;

        /* renamed from: y */
        int f18055y;

        /* renamed from: z */
        boolean f18056z;

        /* renamed from: flyme.support.v7.widget.RecyclerView$g$a */
        public interface C3269a {
            /* renamed from: b */
            void mo26666b(int i, int i2);
        }

        /* renamed from: a */
        public int mo26057a(int i, C3277n nVar, C3283r rVar) {
            return 0;
        }

        @Nullable
        /* renamed from: a */
        public View mo26060a(View view, int i, C3277n nVar, C3283r rVar) {
            return null;
        }

        /* renamed from: a */
        public void mo26062a(int i, int i2, C3283r rVar, C3269a aVar) {
        }

        /* renamed from: a */
        public void mo26063a(int i, C3269a aVar) {
        }

        /* renamed from: a */
        public void mo26064a(Parcelable parcelable) {
        }

        /* renamed from: a */
        public void mo26584a(C3260a aVar, C3260a aVar2) {
        }

        /* renamed from: a */
        public void mo26068a(C3283r rVar) {
        }

        /* renamed from: a */
        public void mo26591a(RecyclerView recyclerView) {
        }

        /* renamed from: a */
        public void mo26592a(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: a */
        public void mo26593a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        /* renamed from: a */
        public boolean mo22258a() {
            return false;
        }

        /* renamed from: a */
        public boolean mo26599a(C3270h hVar) {
            return hVar != null;
        }

        /* renamed from: a */
        public boolean mo26601a(C3277n nVar, C3283r rVar, View view, int i, Bundle bundle) {
            return false;
        }

        /* renamed from: a */
        public boolean mo26606a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        /* renamed from: b */
        public int mo26073b(int i, C3277n nVar, C3283r rVar) {
            return 0;
        }

        /* renamed from: b */
        public abstract C3270h mo26075b();

        /* renamed from: b */
        public void mo26614b(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: c */
        public int mo26079c(C3283r rVar) {
            return 0;
        }

        /* renamed from: c */
        public void mo26622c(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: d */
        public int mo26624d(C3277n nVar, C3283r rVar) {
            return 0;
        }

        /* renamed from: d */
        public int mo26083d(C3283r rVar) {
            return 0;
        }

        /* renamed from: d */
        public View mo26625d(View view, int i) {
            return null;
        }

        @CallSuper
        /* renamed from: d */
        public void mo26627d(RecyclerView recyclerView) {
        }

        /* renamed from: e */
        public int mo26085e(C3283r rVar) {
            return 0;
        }

        /* renamed from: e */
        public void mo26086e(int i) {
        }

        @Deprecated
        /* renamed from: e */
        public void mo26630e(RecyclerView recyclerView) {
        }

        /* renamed from: e */
        public boolean mo26087e() {
            return false;
        }

        /* renamed from: e */
        public boolean mo26631e(C3277n nVar, C3283r rVar) {
            return false;
        }

        /* renamed from: f */
        public int mo26089f(C3283r rVar) {
            return 0;
        }

        /* renamed from: f */
        public Parcelable mo26090f() {
            return null;
        }

        /* renamed from: g */
        public int mo26091g(C3283r rVar) {
            return 0;
        }

        /* renamed from: g */
        public boolean mo26092g() {
            return false;
        }

        /* renamed from: h */
        public int mo26094h(C3283r rVar) {
            return 0;
        }

        /* renamed from: l */
        public void mo26647l(int i) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public boolean mo26100n() {
            return false;
        }

        /* renamed from: w */
        public int mo26657w() {
            return -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26613b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f18048r = null;
                this.f18047q = null;
                this.f18045g = 0;
                this.f18046h = 0;
            } else {
                this.f18048r = recyclerView;
                this.f18047q = recyclerView.f17948D;
                this.f18045g = recyclerView.getWidth();
                this.f18046h = recyclerView.getHeight();
            }
            this.f18043e = 1073741824;
            this.f18044f = 1073741824;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo26626d(int i, int i2) {
            this.f18045g = View.MeasureSpec.getSize(i);
            this.f18043e = View.MeasureSpec.getMode(i);
            if (this.f18043e == 0 && !RecyclerView.f17943y) {
                this.f18045g = 0;
            }
            this.f18046h = View.MeasureSpec.getSize(i2);
            this.f18044f = View.MeasureSpec.getMode(i2);
            if (this.f18044f == 0 && !RecyclerView.f17943y) {
                this.f18046h = 0;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo26629e(int i, int i2) {
            int x = mo26658x();
            if (x == 0) {
                this.f18048r.mo26423h(i, i2);
                return;
            }
            int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i4 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < x; i7++) {
                View i8 = mo26641i(i7);
                Rect rect = this.f18048r.f17952H;
                mo26579a(i8, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.f18048r.f17952H.set(i3, i4, i5, i6);
            mo26573a(this.f18048r.f17952H, i, i2);
        }

        /* renamed from: a */
        public void mo26573a(Rect rect, int i, int i2) {
            mo26637g(m19786a(i, rect.width() + mo26559C() + mo26561E(), mo26564H()), m19786a(i2, rect.height() + mo26560D() + mo26562F(), mo26565I()));
        }

        /* renamed from: q */
        public void mo26651q() {
            if (this.f18048r != null) {
                this.f18048r.requestLayout();
            }
        }

        /* renamed from: a */
        public static int m19786a(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        /* renamed from: a */
        public void mo26071a(String str) {
            if (this.f18048r != null) {
                this.f18048r.mo26377a(str);
            }
        }

        /* renamed from: b */
        public void mo26616b(boolean z) {
            this.f18054x = z;
        }

        /* renamed from: r */
        public final boolean mo26652r() {
            return this.f18042d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo26621c(RecyclerView recyclerView) {
            this.f18053w = true;
            mo26627d(recyclerView);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26615b(RecyclerView recyclerView, C3277n nVar) {
            this.f18053w = false;
            mo26070a(recyclerView, nVar);
        }

        /* renamed from: s */
        public boolean mo26653s() {
            return this.f18053w;
        }

        /* renamed from: a */
        public boolean mo26607a(Runnable runnable) {
            if (this.f18048r != null) {
                return this.f18048r.removeCallbacks(runnable);
            }
            return false;
        }

        @CallSuper
        /* renamed from: a */
        public void mo26070a(RecyclerView recyclerView, C3277n nVar) {
            mo26630e(recyclerView);
        }

        /* renamed from: t */
        public boolean mo26654t() {
            return this.f18048r != null && this.f18048r.f17950F;
        }

        /* renamed from: c */
        public void mo26082c(C3277n nVar, C3283r rVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        /* renamed from: a */
        public C3270h mo26571a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof C3270h) {
                return new C3270h((C3270h) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new C3270h((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new C3270h(layoutParams);
        }

        /* renamed from: a */
        public C3270h mo26570a(Context context, AttributeSet attributeSet) {
            return new C3270h(context, attributeSet);
        }

        /* renamed from: a */
        public void mo20065a(RecyclerView recyclerView, C3283r rVar, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        /* renamed from: a */
        public void mo26590a(C3280q qVar) {
            if (!(this.f18051u == null || qVar == this.f18051u || !this.f18051u.mo26735h())) {
                this.f18051u.mo26733f();
            }
            this.f18051u = qVar;
            this.f18051u.mo26727a(this.f18048r, this);
        }

        /* renamed from: u */
        public boolean mo26655u() {
            return this.f18051u != null && this.f18051u.mo26735h();
        }

        /* renamed from: v */
        public int mo26656v() {
            return ViewCompat.getLayoutDirection(this.f18048r);
        }

        /* renamed from: a */
        public void mo26574a(View view) {
            mo26575a(view, -1);
        }

        /* renamed from: a */
        public void mo26575a(View view, int i) {
            m19789a(view, i, true);
        }

        /* renamed from: b */
        public void mo26609b(View view) {
            mo26610b(view, -1);
        }

        /* renamed from: b */
        public void mo26610b(View view, int i) {
            m19789a(view, i, false);
        }

        /* renamed from: a */
        private void m19789a(View view, int i, boolean z) {
            C3286u h = RecyclerView.m19601h(view);
            if (z || h.mo26785s()) {
                this.f18048r.f17949E.mo27282e(h);
            } else {
                this.f18048r.f17949E.mo27283f(h);
            }
            C3270h hVar = (C3270h) view.getLayoutParams();
            if (h.mo26779m() || h.mo26777k()) {
                if (h.mo26777k()) {
                    h.mo26778l();
                } else {
                    h.mo26780n();
                }
                this.f18047q.mo27084a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f18048r) {
                int b = this.f18047q.mo27088b(view);
                if (i == -1) {
                    i = this.f18047q.mo27087b();
                }
                if (b == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f18048r.indexOfChild(view));
                } else if (b != i) {
                    this.f18048r.f17955K.mo26633f(b, i);
                }
            } else {
                this.f18047q.mo27085a(view, i, false);
                hVar.f18061e = true;
                if (this.f18051u != null && this.f18051u.mo26735h()) {
                    this.f18051u.mo26729b(view);
                }
            }
            if (hVar.f18062f) {
                h.f18121j.invalidate();
                hVar.f18062f = false;
            }
        }

        /* renamed from: c */
        public void mo26618c(View view) {
            this.f18047q.mo27083a(view);
        }

        /* renamed from: g */
        public void mo26636g(int i) {
            if (mo26641i(i) != null) {
                this.f18047q.mo27082a(i);
            }
        }

        /* renamed from: d */
        public int mo26623d(View view) {
            return ((C3270h) view.getLayoutParams()).mo26670f();
        }

        @Nullable
        /* renamed from: e */
        public View mo26628e(View view) {
            View f;
            if (this.f18048r == null || (f = this.f18048r.mo26398f(view)) == null || this.f18047q.mo27092c(f)) {
                return null;
            }
            return f;
        }

        /* renamed from: c */
        public View mo26080c(int i) {
            int x = mo26658x();
            for (int i2 = 0; i2 < x; i2++) {
                View i3 = mo26641i(i2);
                C3286u h = RecyclerView.m19601h(i3);
                if (h != null && h.mo26772f() == i && !h.mo26771e() && (this.f18048r.f17978ac.mo26744a() || !h.mo26785s())) {
                    return i3;
                }
            }
            return null;
        }

        /* renamed from: h */
        public void mo26639h(int i) {
            m19788a(i, mo26641i(i));
        }

        /* renamed from: a */
        private void m19788a(int i, View view) {
            this.f18047q.mo27095e(i);
        }

        /* renamed from: a */
        public void mo26578a(View view, int i, C3270h hVar) {
            C3286u h = RecyclerView.m19601h(view);
            if (h.mo26785s()) {
                this.f18048r.f17949E.mo27282e(h);
            } else {
                this.f18048r.f17949E.mo27283f(h);
            }
            this.f18047q.mo27084a(view, i, hVar, h.mo26785s());
        }

        /* renamed from: c */
        public void mo26619c(View view, int i) {
            mo26578a(view, i, (C3270h) view.getLayoutParams());
        }

        /* renamed from: f */
        public void mo26633f(int i, int i2) {
            View i3 = mo26641i(i);
            if (i3 != null) {
                mo26639h(i);
                mo26619c(i3, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
        }

        /* renamed from: a */
        public void mo26581a(View view, C3277n nVar) {
            mo26618c(view);
            nVar.mo26692a(view);
        }

        /* renamed from: a */
        public void mo26572a(int i, C3277n nVar) {
            View i2 = mo26641i(i);
            mo26636g(i);
            nVar.mo26692a(i2);
        }

        /* renamed from: x */
        public int mo26658x() {
            if (this.f18047q != null) {
                return this.f18047q.mo27087b();
            }
            return 0;
        }

        /* renamed from: i */
        public View mo26641i(int i) {
            if (this.f18047q != null) {
                return this.f18047q.mo27089b(i);
            }
            return null;
        }

        /* renamed from: y */
        public int mo26659y() {
            return this.f18043e;
        }

        /* renamed from: z */
        public int mo26660z() {
            return this.f18044f;
        }

        /* renamed from: A */
        public int mo26557A() {
            return this.f18045g;
        }

        /* renamed from: B */
        public int mo26558B() {
            return this.f18046h;
        }

        /* renamed from: C */
        public int mo26559C() {
            if (this.f18048r != null) {
                return this.f18048r.getPaddingLeft();
            }
            return 0;
        }

        /* renamed from: D */
        public int mo26560D() {
            if (this.f18048r != null) {
                return this.f18048r.getPaddingTop();
            }
            return 0;
        }

        /* renamed from: E */
        public int mo26561E() {
            if (this.f18048r != null) {
                return this.f18048r.getPaddingRight();
            }
            return 0;
        }

        /* renamed from: F */
        public int mo26562F() {
            if (this.f18048r != null) {
                return this.f18048r.getPaddingBottom();
            }
            return 0;
        }

        /* renamed from: G */
        public View mo26563G() {
            View focusedChild;
            if (this.f18048r == null || (focusedChild = this.f18048r.getFocusedChild()) == null || this.f18047q.mo27092c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        /* renamed from: j */
        public void mo26643j(int i) {
            if (this.f18048r != null) {
                this.f18048r.mo26431k(i);
            }
        }

        /* renamed from: k */
        public void mo26645k(int i) {
            if (this.f18048r != null) {
                this.f18048r.mo26429j(i);
            }
        }

        /* renamed from: a */
        public void mo26585a(C3277n nVar) {
            for (int x = mo26658x() - 1; x >= 0; x--) {
                m19791a(nVar, x, mo26641i(x));
            }
        }

        /* renamed from: a */
        private void m19791a(C3277n nVar, int i, View view) {
            C3286u h = RecyclerView.m19601h(view);
            if (!h.mo26771e()) {
                if (!h.mo26782p() || h.mo26785s() || this.f18048r.f17954J.mo23933d()) {
                    mo26639h(i);
                    nVar.mo26707c(view);
                    this.f18048r.f17949E.mo27285h(h);
                    return;
                }
                mo26636g(i);
                nVar.mo26703b(h);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26612b(C3277n nVar) {
            int e = nVar.mo26712e();
            for (int i = e - 1; i >= 0; i--) {
                View e2 = nVar.mo26713e(i);
                C3286u h = RecyclerView.m19601h(e2);
                if (!h.mo26771e()) {
                    h.mo26768b(false);
                    if (h.mo26786t()) {
                        this.f18048r.removeDetachedView(e2, false);
                    }
                    if (this.f18048r.f17966V != null) {
                        this.f18048r.f17966V.mo26040d(h);
                    }
                    h.mo26768b(true);
                    nVar.mo26702b(e2);
                }
            }
            nVar.mo26715f();
            if (e > 0) {
                this.f18048r.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo26596a(View view, int i, int i2, C3270h hVar) {
            return !this.f18041c || !m19793b(view.getMeasuredWidth(), i, hVar.width) || !m19793b(view.getMeasuredHeight(), i2, hVar.height);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo26617b(View view, int i, int i2, C3270h hVar) {
            return view.isLayoutRequested() || !this.f18041c || !m19793b(view.getWidth(), i, hVar.width) || !m19793b(view.getHeight(), i2, hVar.height);
        }

        /* renamed from: b */
        private static boolean m19793b(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        /* renamed from: a */
        public void mo26576a(View view, int i, int i2) {
            C3270h hVar = (C3270h) view.getLayoutParams();
            Rect m = this.f18048r.mo26437m(view);
            int i3 = i + m.left + m.right;
            int i4 = i2 + m.top + m.bottom;
            int a = m19787a(mo26557A(), mo26659y(), mo26559C() + mo26561E() + hVar.leftMargin + hVar.rightMargin + i3, hVar.width, mo22258a());
            int a2 = m19787a(mo26558B(), mo26660z(), mo26560D() + mo26562F() + hVar.topMargin + hVar.bottomMargin + i4, hVar.height, mo26092g());
            if (mo26617b(view, a, a2, hVar)) {
                view.measure(a, a2);
            }
        }

        /* renamed from: a */
        public static int m19787a(int i, int i2, int i3, int i4, boolean z) {
            int i5;
            int i6 = i - i3;
            int i7 = 0;
            int max = Math.max(0, i6);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 == Integer.MIN_VALUE || (i2 != 0 && i2 == 1073741824)) {
                            i5 = max;
                        } else {
                            i2 = 0;
                            i5 = 0;
                        }
                        i7 = i2;
                        max = i5;
                        return View.MeasureSpec.makeMeasureSpec(max, i7);
                    }
                    max = 0;
                    return View.MeasureSpec.makeMeasureSpec(max, i7);
                }
            } else if (i4 < 0) {
                if (i4 == -1) {
                    i7 = i2;
                } else {
                    if (i4 == -2) {
                        if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                            i7 = Integer.MIN_VALUE;
                        }
                    }
                    max = 0;
                }
                return View.MeasureSpec.makeMeasureSpec(max, i7);
            }
            max = i4;
            i7 = 1073741824;
            return View.MeasureSpec.makeMeasureSpec(max, i7);
        }

        /* renamed from: f */
        public int mo26632f(View view) {
            Rect rect = ((C3270h) view.getLayoutParams()).f18060d;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        /* renamed from: g */
        public int mo26635g(View view) {
            Rect rect = ((C3270h) view.getLayoutParams()).f18060d;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        /* renamed from: a */
        public void mo26577a(View view, int i, int i2, int i3, int i4) {
            C3270h hVar = (C3270h) view.getLayoutParams();
            Rect rect = hVar.f18060d;
            view.layout(i + rect.left + hVar.leftMargin, i2 + rect.top + hVar.topMargin, (i3 - rect.right) - hVar.rightMargin, (i4 - rect.bottom) - hVar.bottomMargin);
        }

        /* renamed from: a */
        public void mo26582a(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((C3270h) view.getLayoutParams()).f18060d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.f18048r == null || (matrix = ViewCompat.getMatrix(view)) == null || matrix.isIdentity())) {
                RectF rectF = this.f18048r.f17953I;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        /* renamed from: a */
        public void mo26579a(View view, Rect rect) {
            RecyclerView.m19579a(view, rect);
        }

        /* renamed from: h */
        public int mo26638h(View view) {
            return view.getLeft() - mo26649n(view);
        }

        /* renamed from: i */
        public int mo26640i(View view) {
            return view.getTop() - mo26646l(view);
        }

        /* renamed from: j */
        public int mo26642j(View view) {
            return view.getRight() + mo26650o(view);
        }

        /* renamed from: k */
        public int mo26644k(View view) {
            return view.getBottom() + mo26648m(view);
        }

        /* renamed from: b */
        public void mo26611b(View view, Rect rect) {
            if (this.f18048r == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.f18048r.mo26437m(view));
            }
        }

        /* renamed from: l */
        public int mo26646l(View view) {
            return ((C3270h) view.getLayoutParams()).f18060d.top;
        }

        /* renamed from: m */
        public int mo26648m(View view) {
            return ((C3270h) view.getLayoutParams()).f18060d.bottom;
        }

        /* renamed from: n */
        public int mo26649n(View view) {
            return ((C3270h) view.getLayoutParams()).f18060d.left;
        }

        /* renamed from: o */
        public int mo26650o(View view) {
            return ((C3270h) view.getLayoutParams()).f18060d.right;
        }

        /* renamed from: b */
        private int[] m19794b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int C = mo26559C();
            int D = mo26560D();
            int A = mo26557A() - mo26561E();
            int B = mo26558B() - mo26562F();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i = left - C;
            int min = Math.min(0, i);
            int i2 = top - D;
            int min2 = Math.min(0, i2);
            int i3 = width - A;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height - B);
            if (mo26656v() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        /* renamed from: a */
        public boolean mo26602a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return mo26603a(recyclerView, view, rect, z, false);
        }

        /* renamed from: a */
        public boolean mo26603a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] b = m19794b(recyclerView, view, rect, z);
            int i = b[0];
            int i2 = b[1];
            if ((z2 && !m19795d(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.mo26397e(i, i2);
            }
            return true;
        }

        /* renamed from: a */
        public boolean mo26598a(@NonNull View view, boolean z, boolean z2) {
            boolean z3 = this.f18049s.mo27036a(view, 24579) && this.f18050t.mo27036a(view, 24579);
            return z ? z3 : !z3;
        }

        /* renamed from: d */
        private boolean m19795d(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int C = mo26559C();
            int D = mo26560D();
            int A = mo26557A() - mo26561E();
            int B = mo26558B() - mo26562F();
            Rect rect = this.f18048r.f17952H;
            mo26579a(focusedChild, rect);
            if (rect.left - i >= A || rect.right - i <= C || rect.top - i2 >= B || rect.bottom - i2 <= D) {
                return false;
            }
            return true;
        }

        @Deprecated
        /* renamed from: a */
        public boolean mo26604a(RecyclerView recyclerView, View view, View view2) {
            return mo26655u() || recyclerView.mo26486z();
        }

        /* renamed from: a */
        public boolean mo26605a(RecyclerView recyclerView, C3283r rVar, View view, View view2) {
            return mo26604a(recyclerView, view, view2);
        }

        /* renamed from: a */
        public void mo26594a(RecyclerView recyclerView, int i, int i2, Object obj) {
            mo26622c(recyclerView, i, i2);
        }

        /* renamed from: a */
        public void mo26586a(C3277n nVar, C3283r rVar, int i, int i2) {
            this.f18048r.mo26423h(i, i2);
        }

        /* renamed from: g */
        public void mo26637g(int i, int i2) {
            this.f18048r.setMeasuredDimension(i, i2);
        }

        /* renamed from: H */
        public int mo26564H() {
            return ViewCompat.getMinimumWidth(this.f18048r);
        }

        /* renamed from: I */
        public int mo26565I() {
            return ViewCompat.getMinimumHeight(this.f18048r);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: J */
        public void mo26566J() {
            if (this.f18051u != null) {
                this.f18051u.mo26733f();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m19792b(C3280q qVar) {
            if (this.f18051u == qVar) {
                this.f18051u = null;
            }
        }

        /* renamed from: c */
        public void mo26620c(C3277n nVar) {
            for (int x = mo26658x() - 1; x >= 0; x--) {
                if (!RecyclerView.m19601h(mo26641i(x)).mo26771e()) {
                    mo26572a(x, nVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26583a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            mo26589a(this.f18048r.f17946B, this.f18048r.f17978ac, accessibilityNodeInfoCompat);
        }

        /* renamed from: a */
        public void mo26589a(C3277n nVar, C3283r rVar, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewCompat.canScrollVertically(this.f18048r, -1) || ViewCompat.canScrollHorizontally(this.f18048r, -1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (ViewCompat.canScrollVertically(this.f18048r, 1) || ViewCompat.canScrollHorizontally(this.f18048r, 1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(mo26569a(nVar, rVar), mo26608b(nVar, rVar), mo26631e(nVar, rVar), mo26624d(nVar, rVar)));
        }

        /* renamed from: a */
        public void mo26065a(AccessibilityEvent accessibilityEvent) {
            mo26588a(this.f18048r.f17946B, this.f18048r.f17978ac, accessibilityEvent);
        }

        /* renamed from: a */
        public void mo26588a(C3277n nVar, C3283r rVar, AccessibilityEvent accessibilityEvent) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            if (this.f18048r != null && asRecord != null) {
                boolean z = true;
                if (!ViewCompat.canScrollVertically(this.f18048r, 1) && !ViewCompat.canScrollVertically(this.f18048r, -1) && !ViewCompat.canScrollHorizontally(this.f18048r, -1) && !ViewCompat.canScrollHorizontally(this.f18048r, 1)) {
                    z = false;
                }
                asRecord.setScrollable(z);
                if (this.f18048r.f17954J != null) {
                    asRecord.setItemCount(this.f18048r.f17954J.mo20093a());
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26580a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            C3286u h = RecyclerView.m19601h(view);
            if (h != null && !h.mo26785s() && !this.f18047q.mo27092c(h.f18121j)) {
                mo26587a(this.f18048r.f17946B, this.f18048r.f17978ac, view, accessibilityNodeInfoCompat);
            }
        }

        /* renamed from: a */
        public void mo26587a(C3277n nVar, C3283r rVar, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(mo26092g() ? mo26623d(view) : 0, 1, mo22258a() ? mo26623d(view) : 0, 1, false, false));
        }

        /* renamed from: K */
        public void mo26567K() {
            this.f18052v = true;
        }

        /* renamed from: a */
        public int mo26569a(C3277n nVar, C3283r rVar) {
            if (this.f18048r == null || this.f18048r.f17954J == null || !mo26092g()) {
                return 1;
            }
            return this.f18048r.f17954J.mo20093a();
        }

        /* renamed from: b */
        public int mo26608b(C3277n nVar, C3283r rVar) {
            if (this.f18048r == null || this.f18048r.f17954J == null || !mo22258a()) {
                return 1;
            }
            return this.f18048r.f17954J.mo20093a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo26595a(int i, Bundle bundle) {
            return mo26600a(this.f18048r.f17946B, this.f18048r.f17978ac, i, bundle);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0074 A[ADDED_TO_REGION] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo26600a(flyme.support.p093v7.widget.RecyclerView.C3277n r2, flyme.support.p093v7.widget.RecyclerView.C3283r r3, int r4, android.os.Bundle r5) {
            /*
                r1 = this;
                flyme.support.v7.widget.RecyclerView r2 = r1.f18048r
                r3 = 0
                if (r2 != 0) goto L_0x0006
                return r3
            L_0x0006:
                r2 = 4096(0x1000, float:5.74E-42)
                r5 = 1
                if (r4 == r2) goto L_0x0044
                r2 = 8192(0x2000, float:1.14794E-41)
                if (r4 == r2) goto L_0x0012
                r2 = 0
            L_0x0010:
                r4 = 0
                goto L_0x0072
            L_0x0012:
                flyme.support.v7.widget.RecyclerView r2 = r1.f18048r
                r4 = -1
                boolean r2 = androidx.core.view.ViewCompat.canScrollVertically(r2, r4)
                if (r2 == 0) goto L_0x002b
                int r2 = r1.mo26558B()
                int r0 = r1.mo26560D()
                int r2 = r2 - r0
                int r0 = r1.mo26562F()
                int r2 = r2 - r0
                int r2 = -r2
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                flyme.support.v7.widget.RecyclerView r0 = r1.f18048r
                boolean r4 = androidx.core.view.ViewCompat.canScrollHorizontally(r0, r4)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.mo26557A()
                int r0 = r1.mo26559C()
                int r4 = r4 - r0
                int r0 = r1.mo26561E()
                int r4 = r4 - r0
                int r4 = -r4
                goto L_0x0072
            L_0x0044:
                flyme.support.v7.widget.RecyclerView r2 = r1.f18048r
                boolean r2 = androidx.core.view.ViewCompat.canScrollVertically(r2, r5)
                if (r2 == 0) goto L_0x005b
                int r2 = r1.mo26558B()
                int r4 = r1.mo26560D()
                int r2 = r2 - r4
                int r4 = r1.mo26562F()
                int r2 = r2 - r4
                goto L_0x005c
            L_0x005b:
                r2 = 0
            L_0x005c:
                flyme.support.v7.widget.RecyclerView r4 = r1.f18048r
                boolean r4 = androidx.core.view.ViewCompat.canScrollHorizontally(r4, r5)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.mo26557A()
                int r0 = r1.mo26559C()
                int r4 = r4 - r0
                int r0 = r1.mo26561E()
                int r4 = r4 - r0
            L_0x0072:
                if (r2 != 0) goto L_0x0077
                if (r4 != 0) goto L_0x0077
                return r3
            L_0x0077:
                flyme.support.v7.widget.RecyclerView r3 = r1.f18048r
                r3.scrollBy(r4, r2)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.RecyclerView.C3266g.mo26600a(flyme.support.v7.widget.RecyclerView$n, flyme.support.v7.widget.RecyclerView$r, int, android.os.Bundle):boolean");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo26597a(View view, int i, Bundle bundle) {
            return mo26601a(this.f18048r.f17946B, this.f18048r.f17978ac, view, i, bundle);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo26634f(RecyclerView recyclerView) {
            mo26626d(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: L */
        public boolean mo26568L() {
            int x = mo26658x();
            for (int i = 0; i < x; i++) {
                ViewGroup.LayoutParams layoutParams = mo26641i(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$f */
    public static abstract class C3265f {

        /* renamed from: a */
        private HashSet<Integer> f18037a = new HashSet<>();

        /* renamed from: b */
        private HashSet<Integer> f18038b = new HashSet<>();

        @Deprecated
        /* renamed from: a */
        public void mo26547a(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        /* renamed from: b */
        public void mo26551b(Canvas canvas, RecyclerView recyclerView) {
        }

        /* renamed from: b */
        public void mo26552b(Canvas canvas, RecyclerView recyclerView, C3283r rVar) {
        }

        /* renamed from: d */
        public void mo26556d(Canvas canvas, RecyclerView recyclerView, C3283r rVar) {
        }

        /* renamed from: c */
        public void mo26554c(Canvas canvas, RecyclerView recyclerView, C3283r rVar) {
            mo26547a(canvas, recyclerView);
        }

        /* renamed from: a */
        public void mo26548a(Canvas canvas, RecyclerView recyclerView, C3283r rVar) {
            mo26551b(canvas, recyclerView);
        }

        @Deprecated
        /* renamed from: a */
        public void mo26549a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        /* renamed from: a */
        public void mo23920a(Rect rect, View view, RecyclerView recyclerView, C3283r rVar) {
            mo26549a(rect, ((C3270h) view.getLayoutParams()).mo26670f(), recyclerView);
        }

        /* renamed from: c */
        public HashSet<Integer> mo26553c() {
            return this.f18037a;
        }

        /* renamed from: a */
        public void mo26550a(HashSet<Integer> hashSet) {
            this.f18038b.addAll(hashSet);
        }

        /* renamed from: d */
        public void mo26555d() {
            this.f18038b.clear();
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$u */
    public static abstract class C3286u {

        /* renamed from: b */
        private static final List<Object> f18115b = Collections.EMPTY_LIST;
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f18116a;

        /* renamed from: c */
        private int f18117c = 0;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public C3277n f18118d = null;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public boolean f18119e = false;

        /* renamed from: f */
        private int f18120f = 0;

        /* renamed from: j */
        public final View f18121j;

        /* renamed from: k */
        WeakReference<RecyclerView> f18122k;

        /* renamed from: l */
        int f18123l = -1;

        /* renamed from: m */
        int f18124m = -1;

        /* renamed from: n */
        long f18125n = -1;

        /* renamed from: o */
        int f18126o = -1;

        /* renamed from: p */
        int f18127p = -1;

        /* renamed from: q */
        C3286u f18128q = null;

        /* renamed from: r */
        C3286u f18129r = null;

        /* renamed from: s */
        List<Object> f18130s = null;

        /* renamed from: t */
        List<Object> f18131t = null;
        @VisibleForTesting

        /* renamed from: u */
        int f18132u = -1;

        /* renamed from: v */
        RecyclerView f18133v;

        public C3286u(View view) {
            if (view != null) {
                this.f18121j = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26762a(int i, int i2, boolean z) {
            mo26767b(8);
            mo26763a(i2, z);
            this.f18123l = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26763a(int i, boolean z) {
            if (this.f18124m == -1) {
                this.f18124m = this.f18123l;
            }
            if (this.f18127p == -1) {
                this.f18127p = this.f18123l;
            }
            if (z) {
                this.f18127p += i;
            }
            this.f18123l += i;
            if (this.f18121j.getLayoutParams() != null && (this.f18121j.getLayoutParams() instanceof C3270h)) {
                ((C3270h) this.f18121j.getLayoutParams()).f18061e = true;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo26769c() {
            this.f18124m = -1;
            this.f18127p = -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo26770d() {
            if (this.f18124m == -1) {
                this.f18124m = this.f18123l;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public boolean mo26771e() {
            return (this.f18116a & 128) != 0;
        }

        /* renamed from: f */
        public final int mo26772f() {
            return this.f18127p == -1 ? this.f18123l : this.f18127p;
        }

        /* renamed from: g */
        public final int mo26773g() {
            if (this.f18133v == null) {
                return -1;
            }
            return this.f18133v.mo26389d(this);
        }

        /* renamed from: h */
        public final int mo26774h() {
            return this.f18124m;
        }

        /* renamed from: i */
        public final long mo26775i() {
            return this.f18125n;
        }

        /* renamed from: j */
        public final int mo26776j() {
            return this.f18126o;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean mo26777k() {
            return this.f18118d != null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l */
        public void mo26778l() {
            this.f18118d.mo26708c(this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public boolean mo26779m() {
            return (this.f18116a & 32) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public void mo26780n() {
            this.f18116a &= -33;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public void mo26781o() {
            this.f18116a &= -257;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26764a(C3277n nVar, boolean z) {
            this.f18118d = nVar;
            this.f18119e = z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: p */
        public boolean mo26782p() {
            return (this.f18116a & 4) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: q */
        public boolean mo26783q() {
            return (this.f18116a & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: r */
        public boolean mo26784r() {
            return (this.f18116a & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: s */
        public boolean mo26785s() {
            return (this.f18116a & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo26766a(int i) {
            return (i & this.f18116a) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public boolean mo26786t() {
            return (this.f18116a & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: u */
        public boolean mo26788u() {
            return (this.f18116a & 512) != 0 || mo26782p();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26761a(int i, int i2) {
            this.f18116a = (i & i2) | (this.f18116a & (~i2));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo26767b(int i) {
            this.f18116a = i | this.f18116a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26765a(Object obj) {
            if (obj == null) {
                mo26767b(1024);
            } else if ((1024 & this.f18116a) == 0) {
                mo20102a();
                this.f18130s.add(obj);
            }
        }

        /* renamed from: a */
        private void mo20102a() {
            if (this.f18130s == null) {
                this.f18130s = new ArrayList();
                this.f18131t = Collections.unmodifiableList(this.f18130s);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: v */
        public void mo26789v() {
            if (this.f18130s != null) {
                this.f18130s.clear();
            }
            this.f18116a &= -1025;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: w */
        public List<Object> mo26790w() {
            if ((this.f18116a & 1024) != 0) {
                return f18115b;
            }
            if (this.f18130s == null || this.f18130s.size() == 0) {
                return f18115b;
            }
            return this.f18131t;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: x */
        public void mo26791x() {
            this.f18116a = 0;
            this.f18123l = -1;
            this.f18124m = -1;
            this.f18125n = -1;
            this.f18127p = -1;
            this.f18117c = 0;
            this.f18128q = null;
            this.f18129r = null;
            mo26789v();
            this.f18120f = 0;
            this.f18132u = -1;
            RecyclerView.m19595c(this);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m20055a(RecyclerView recyclerView) {
            this.f18120f = ViewCompat.getImportantForAccessibility(this.f18121j);
            recyclerView.mo26380a(this, 4);
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m20059b(RecyclerView recyclerView) {
            recyclerView.mo26380a(this, this.f18120f);
            this.f18120f = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f18123l + " id=" + this.f18125n + ", oldPos=" + this.f18124m + ", pLpos:" + this.f18127p);
            if (mo26777k()) {
                sb.append(" scrap ");
                sb.append(this.f18119e ? "[changeScrap]" : "[attachedScrap]");
            }
            if (mo26782p()) {
                sb.append(" invalid");
            }
            if (!mo26784r()) {
                sb.append(" unbound");
            }
            if (mo26783q()) {
                sb.append(" update");
            }
            if (mo26785s()) {
                sb.append(" removed");
            }
            if (mo26771e()) {
                sb.append(" ignored");
            }
            if (mo26786t()) {
                sb.append(" tmpDetached");
            }
            if (!mo26792y()) {
                sb.append(" not recyclable(" + this.f18117c + ")");
            }
            if (mo26788u()) {
                sb.append(" undefined adapter position");
            }
            if (this.f18121j.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* renamed from: b */
        public final void mo26768b(boolean z) {
            this.f18117c = z ? this.f18117c - 1 : this.f18117c + 1;
            if (this.f18117c < 0) {
                this.f18117c = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && this.f18117c == 1) {
                this.f18116a |= 16;
            } else if (z && this.f18117c == 0) {
                this.f18116a &= -17;
            }
        }

        /* renamed from: y */
        public final boolean mo26792y() {
            return (this.f18116a & 16) == 0 && !ViewCompat.hasTransientState(this.f18121j);
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public boolean mo22255b() {
            return (this.f18116a & 16) != 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: A */
        public boolean m20051A() {
            return (this.f18116a & 16) == 0 && ViewCompat.hasTransientState(this.f18121j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: z */
        public boolean mo26793z() {
            return (this.f18116a & 2) != 0;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public boolean mo26380a(C3286u uVar, int i) {
        if (mo26486z()) {
            uVar.f18132u = i;
            this.f17983ah.add(uVar);
            return false;
        }
        ViewCompat.setImportantForAccessibility(uVar.f18121j, i);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public void mo26359I() {
        int i;
        for (int size = this.f17983ah.size() - 1; size >= 0; size--) {
            C3286u uVar = this.f17983ah.get(size);
            if (uVar.f18121j.getParent() == this && !uVar.mo26771e() && (i = uVar.f18132u) != -1) {
                ViewCompat.setImportantForAccessibility(uVar.f18121j, i);
                uVar.f18132u = -1;
            }
        }
        this.f17983ah.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo26389d(C3286u uVar) {
        if (uVar.mo26766a((int) MsgConstants.SLAM_GESTURE_INTERACTION) || !uVar.mo26784r()) {
            return -1;
        }
        return this.f17947C.mo27072c(uVar.f18123l);
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo26370a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null) {
            Resources resources = getContext().getResources();
            new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
            return;
        }
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + mo26434l());
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().startNestedScroll(i);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$h */
    public static class C3270h extends ViewGroup.MarginLayoutParams {

        /* renamed from: c */
        C3286u f18059c;

        /* renamed from: d */
        final Rect f18060d = new Rect();

        /* renamed from: e */
        boolean f18061e = true;

        /* renamed from: f */
        boolean f18062f = false;

        public C3270h(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C3270h(int i, int i2) {
            super(i, i2);
        }

        public C3270h(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C3270h(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C3270h(C3270h hVar) {
            super(hVar);
        }

        /* renamed from: c */
        public boolean mo26667c() {
            return this.f18059c.mo26782p();
        }

        /* renamed from: d */
        public boolean mo26668d() {
            return this.f18059c.mo26785s();
        }

        /* renamed from: e */
        public boolean mo26669e() {
            return this.f18059c.mo26793z();
        }

        /* renamed from: f */
        public int mo26670f() {
            return this.f18059c.mo26772f();
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$c */
    public static abstract class C3262c {
        /* renamed from: a */
        public void mo23939a() {
        }

        /* renamed from: a */
        public void mo23940a(int i, int i2) {
        }

        /* renamed from: a */
        public void mo23941a(int i, int i2, Object obj) {
            mo23940a(i, i2);
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$q */
    public static abstract class C3280q {

        /* renamed from: a */
        private int f18079a = -1;

        /* renamed from: b */
        private RecyclerView f18080b;

        /* renamed from: c */
        private C3266g f18081c;

        /* renamed from: d */
        private boolean f18082d;

        /* renamed from: e */
        private boolean f18083e;

        /* renamed from: f */
        private View f18084f;

        /* renamed from: g */
        private final C3281a f18085g = new C3281a(0, 0);

        /* renamed from: flyme.support.v7.widget.RecyclerView$q$b */
        public interface C3282b {
            /* renamed from: d */
            PointF mo26084d(int i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo26724a();

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo26725a(int i, int i2, C3283r rVar, C3281a aVar);

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo20069a(View view, C3283r rVar, C3281a aVar);

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract void mo26728b();

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26727a(RecyclerView recyclerView, C3266g gVar) {
            this.f18080b = recyclerView;
            this.f18081c = gVar;
            if (this.f18079a != -1) {
                int unused = this.f18080b.f17978ac.f18106n = this.f18079a;
                this.f18083e = true;
                this.f18082d = true;
                this.f18084f = mo26731e(mo26736i());
                mo26724a();
                this.f18080b.f17967W.mo26752a();
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* renamed from: d */
        public void mo26730d(int i) {
            this.f18079a = i;
        }

        @Nullable
        /* renamed from: e */
        public C3266g mo26732e() {
            return this.f18081c;
        }

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public final void mo26733f() {
            if (this.f18083e) {
                mo26728b();
                int unused = this.f18080b.f17978ac.f18106n = -1;
                this.f18084f = null;
                this.f18079a = -1;
                this.f18082d = false;
                this.f18083e = false;
                this.f18081c.m19792b(this);
                this.f18081c = null;
                this.f18080b = null;
            }
        }

        /* renamed from: g */
        public boolean mo26734g() {
            return this.f18082d;
        }

        /* renamed from: h */
        public boolean mo26735h() {
            return this.f18083e;
        }

        /* renamed from: i */
        public int mo26736i() {
            return this.f18079a;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m20005a(int i, int i2) {
            RecyclerView recyclerView = this.f18080b;
            if (!this.f18083e || this.f18079a == -1 || recyclerView == null) {
                mo26733f();
            }
            this.f18082d = false;
            if (this.f18084f != null) {
                if (mo26723a(this.f18084f) == this.f18079a) {
                    mo20069a(this.f18084f, recyclerView.f17978ac, this.f18085g);
                    this.f18085g.mo26740a(recyclerView);
                    mo26733f();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f18084f = null;
                }
            }
            if (this.f18083e) {
                mo26725a(i, i2, recyclerView.f17978ac, this.f18085g);
                boolean a = this.f18085g.mo26741a();
                this.f18085g.mo26740a(recyclerView);
                if (!a) {
                    return;
                }
                if (this.f18083e) {
                    this.f18082d = true;
                    recyclerView.f17967W.mo26752a();
                    return;
                }
                mo26733f();
            }
        }

        /* renamed from: a */
        public int mo26723a(View view) {
            return this.f18080b.mo26428j(view);
        }

        /* renamed from: j */
        public int mo26737j() {
            return this.f18080b.f17955K.mo26658x();
        }

        /* renamed from: e */
        public View mo26731e(int i) {
            return this.f18080b.f17955K.mo26080c(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo26729b(View view) {
            if (mo26723a(view) == mo26736i()) {
                this.f18084f = view;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo26726a(PointF pointF) {
            double sqrt = Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
            pointF.x = (float) (((double) pointF.x) / sqrt);
            pointF.y = (float) (((double) pointF.y) / sqrt);
        }

        /* renamed from: flyme.support.v7.widget.RecyclerView$q$a */
        public static class C3281a {

            /* renamed from: a */
            private int f18086a;

            /* renamed from: b */
            private int f18087b;

            /* renamed from: c */
            private int f18088c;

            /* renamed from: d */
            private int f18089d;

            /* renamed from: e */
            private Interpolator f18090e;

            /* renamed from: f */
            private boolean f18091f;

            /* renamed from: g */
            private int f18092g;

            public C3281a(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, (Interpolator) null);
            }

            public C3281a(int i, int i2, int i3, Interpolator interpolator) {
                this.f18089d = -1;
                this.f18091f = false;
                this.f18092g = 0;
                this.f18086a = i;
                this.f18087b = i2;
                this.f18088c = i3;
                this.f18090e = interpolator;
            }

            /* renamed from: a */
            public void mo26738a(int i) {
                this.f18089d = i;
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public boolean mo26741a() {
                return this.f18089d >= 0;
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo26740a(RecyclerView recyclerView) {
                if (this.f18089d >= 0) {
                    int i = this.f18089d;
                    this.f18089d = -1;
                    recyclerView.mo26399f(i);
                    this.f18091f = false;
                } else if (this.f18091f) {
                    m20023b();
                    if (this.f18090e != null) {
                        recyclerView.f17967W.mo26756a(this.f18086a, this.f18087b, this.f18088c, this.f18090e);
                    } else if (this.f18088c == Integer.MIN_VALUE) {
                        recyclerView.f17967W.mo26759b(this.f18086a, this.f18087b);
                    } else {
                        recyclerView.f17967W.mo26754a(this.f18086a, this.f18087b, this.f18088c);
                    }
                    this.f18092g++;
                    if (this.f18092g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f18091f = false;
                } else {
                    this.f18092g = 0;
                }
            }

            /* renamed from: b */
            private void m20023b() {
                if (this.f18090e != null && this.f18088c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f18088c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            /* renamed from: a */
            public void mo26739a(int i, int i2, int i3, Interpolator interpolator) {
                this.f18086a = i;
                this.f18087b = i2;
                this.f18088c = i3;
                this.f18090e = interpolator;
                this.f18091f = true;
            }
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$b */
    static class C3261b extends Observable<C3262c> {
        C3261b() {
        }

        /* renamed from: a */
        public void mo26543a() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C3262c) this.mObservers.get(size)).mo23939a();
            }
        }

        /* renamed from: a */
        public void mo26544a(int i, int i2) {
            mo26545a(i, i2, (Object) null);
        }

        /* renamed from: a */
        public void mo26545a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C3262c) this.mObservers.get(size)).mo23941a(i, i2, obj);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: flyme.support.v7.widget.RecyclerView$SavedState */
    public static class SavedState extends AbsSavedState {
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
        Parcelable f18033a;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f18033a = parcel.readParcelable(classLoader == null ? C3266g.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f18033a, 0);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26534a(SavedState savedState) {
            this.f18033a = savedState.f18033a;
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$r */
    public static class C3283r {

        /* renamed from: a */
        int f18093a = 0;

        /* renamed from: b */
        int f18094b = 0;

        /* renamed from: c */
        int f18095c = 1;

        /* renamed from: d */
        int f18096d = 0;

        /* renamed from: e */
        boolean f18097e = false;

        /* renamed from: f */
        boolean f18098f = false;

        /* renamed from: g */
        boolean f18099g = false;

        /* renamed from: h */
        boolean f18100h = false;

        /* renamed from: i */
        boolean f18101i = false;

        /* renamed from: j */
        boolean f18102j = false;

        /* renamed from: k */
        int f18103k;

        /* renamed from: l */
        long f18104l;

        /* renamed from: m */
        int f18105m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public int f18106n = -1;

        /* renamed from: o */
        private SparseArray<Object> f18107o;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26742a(int i) {
            if ((this.f18095c & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f18095c));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26743a(C3260a aVar) {
            this.f18095c = 1;
            this.f18096d = aVar.mo20093a();
            this.f18097e = false;
            this.f18098f = false;
            this.f18099g = false;
            this.f18100h = false;
        }

        /* renamed from: a */
        public boolean mo26744a() {
            return this.f18098f;
        }

        /* renamed from: b */
        public boolean mo26745b() {
            return this.f18102j;
        }

        /* renamed from: c */
        public int mo26746c() {
            return this.f18106n;
        }

        /* renamed from: d */
        public boolean mo26747d() {
            return this.f18106n != -1;
        }

        /* renamed from: e */
        public boolean mo26748e() {
            return this.f18097e;
        }

        /* renamed from: f */
        public int mo26749f() {
            return this.f18098f ? this.f18093a - this.f18094b : this.f18096d;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f18106n + ", mData=" + this.f18107o + ", mItemCount=" + this.f18096d + ", mPreviousLayoutItemCount=" + this.f18093a + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f18094b + ", mStructureChanged=" + this.f18097e + ", mInPreLayout=" + this.f18098f + ", mRunSimpleAnimations=" + this.f18101i + ", mRunPredictiveAnimations=" + this.f18102j + '}';
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$e */
    private class C3264e implements ItemAnimator.C3257b {
        C3264e() {
        }

        /* renamed from: a */
        public void mo26531a(C3286u uVar) {
            uVar.mo26768b(true);
            if (uVar.f18128q != null && uVar.f18129r == null) {
                uVar.f18128q = null;
            }
            uVar.f18129r = null;
            if (!uVar.mo22255b() && !RecyclerView.this.mo26390d(uVar.f18121j) && uVar.mo26786t()) {
                RecyclerView.this.removeDetachedView(uVar.f18121j, false);
            }
        }
    }

    /* renamed from: flyme.support.v7.widget.RecyclerView$ItemAnimator */
    public static abstract class ItemAnimator {

        /* renamed from: a */
        private C3257b f18023a = null;

        /* renamed from: b */
        private ArrayList<C3256a> f18024b = new ArrayList<>();

        /* renamed from: c */
        private long f18025c = 120;

        /* renamed from: d */
        private long f18026d = 120;

        /* renamed from: e */
        private long f18027e = 250;

        /* renamed from: f */
        private long f18028f = 250;

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: flyme.support.v7.widget.RecyclerView$ItemAnimator$AdapterChanges */
        public @interface AdapterChanges {
        }

        /* renamed from: flyme.support.v7.widget.RecyclerView$ItemAnimator$a */
        public interface C3256a {
            /* renamed from: a */
            void mo26530a();
        }

        /* renamed from: flyme.support.v7.widget.RecyclerView$ItemAnimator$b */
        interface C3257b {
            /* renamed from: a */
            void mo26531a(C3286u uVar);
        }

        /* renamed from: a */
        public abstract void mo26027a();

        /* renamed from: a */
        public abstract boolean mo26517a(@NonNull C3286u uVar, @NonNull C3258c cVar, @Nullable C3258c cVar2);

        /* renamed from: a */
        public abstract boolean mo26518a(@NonNull C3286u uVar, @NonNull C3286u uVar2, @NonNull C3258c cVar, @NonNull C3258c cVar2);

        /* renamed from: b */
        public abstract boolean mo26035b();

        /* renamed from: b */
        public abstract boolean mo26519b(@NonNull C3286u uVar, @Nullable C3258c cVar, @NonNull C3258c cVar2);

        /* renamed from: c */
        public abstract boolean mo26520c(@NonNull C3286u uVar, @NonNull C3258c cVar, @NonNull C3258c cVar2);

        /* renamed from: d */
        public abstract void mo26039d();

        /* renamed from: d */
        public abstract void mo26040d(C3286u uVar);

        /* renamed from: g */
        public void mo26525g(C3286u uVar) {
        }

        /* renamed from: h */
        public boolean mo26527h(@NonNull C3286u uVar) {
            return true;
        }

        /* renamed from: e */
        public long mo26521e() {
            return this.f18027e;
        }

        /* renamed from: f */
        public long mo26522f() {
            return this.f18025c;
        }

        /* renamed from: g */
        public long mo26524g() {
            return this.f18026d;
        }

        /* renamed from: h */
        public long mo26526h() {
            return this.f18028f;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26516a(C3257b bVar) {
            this.f18023a = bVar;
        }

        @NonNull
        /* renamed from: a */
        public C3258c mo26515a(@NonNull C3283r rVar, @NonNull C3286u uVar, int i, @NonNull List<Object> list) {
            return mo26529j().mo26532a(uVar);
        }

        @NonNull
        /* renamed from: a */
        public C3258c mo26514a(@NonNull C3283r rVar, @NonNull C3286u uVar) {
            return mo26529j().mo26532a(uVar);
        }

        /* renamed from: e */
        static int m19715e(C3286u uVar) {
            int d = uVar.f18116a & 14;
            if (uVar.mo26782p()) {
                return 4;
            }
            if ((d & 4) != 0) {
                return d;
            }
            int h = uVar.mo26774h();
            int g = uVar.mo26773g();
            return (h == -1 || g == -1 || h == g) ? d : d | 2048;
        }

        /* renamed from: f */
        public final void mo26523f(C3286u uVar) {
            mo26525g(uVar);
            if (this.f18023a != null) {
                this.f18023a.mo26531a(uVar);
            }
        }

        /* renamed from: a */
        public boolean mo26033a(@NonNull C3286u uVar, @NonNull List<Object> list) {
            return mo26527h(uVar);
        }

        /* renamed from: i */
        public final void mo26528i() {
            int size = this.f18024b.size();
            for (int i = 0; i < size; i++) {
                this.f18024b.get(i).mo26530a();
            }
            this.f18024b.clear();
        }

        /* renamed from: j */
        public C3258c mo26529j() {
            return new C3258c();
        }

        /* renamed from: flyme.support.v7.widget.RecyclerView$ItemAnimator$c */
        public static class C3258c {

            /* renamed from: a */
            public int f18029a;

            /* renamed from: b */
            public int f18030b;

            /* renamed from: c */
            public int f18031c;

            /* renamed from: d */
            public int f18032d;

            /* renamed from: a */
            public C3258c mo26532a(C3286u uVar) {
                return mo26533a(uVar, 0);
            }

            /* renamed from: a */
            public C3258c mo26533a(C3286u uVar, int i) {
                View view = uVar.f18121j;
                this.f18029a = view.getLeft();
                this.f18030b = view.getTop();
                this.f18031c = view.getRight();
                this.f18032d = view.getBottom();
                return this;
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f17998ax == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.f17998ax.mo26546a(i, i2);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.f18000az == null) {
            this.f18000az = new NestedScrollingChildHelper(this);
        }
        return this.f18000az;
    }

    public void setEdgetEffectPadding(int i, int i2) {
        if (i >= 0) {
            this.f17972aE = i;
        }
        if (i2 >= 0) {
            this.f17973aF = i2;
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x017d, code lost:
        if ((r2.mo26644k(r5) - r2.mo26640i(r0)) <= r4) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0198, code lost:
        if ((r2.mo26644k(r0) - r2.mo26640i(r5)) <= r4) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0075, code lost:
        if ((r0.mo26644k(r4) - r6) <= r2) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b1, code lost:
        if ((r6 - r0.mo26640i(r4)) <= r2) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0100, code lost:
        if ((r0.mo26642j(r4) - r6) <= r2) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x013f, code lost:
        if ((r6 - r0.mo26638h(r4)) <= r2) goto L_0x0104;
     */
    /* renamed from: J */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo26360J() {
        /*
            r9 = this;
            int r0 = r9.getChildCount()
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            flyme.support.v7.widget.RecyclerView$a r2 = r9.f17954J
            r3 = 0
            if (r2 == 0) goto L_0x0014
            flyme.support.v7.widget.RecyclerView$a r2 = r9.f17954J
            int r2 = r2.mo20093a()
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            if (r0 == r2) goto L_0x0018
            return r3
        L_0x0018:
            flyme.support.v7.widget.RecyclerView$g r2 = r9.f17955K
            boolean r2 = r2 instanceof flyme.support.p093v7.widget.StaggeredGridLayoutManager
            if (r2 == 0) goto L_0x0142
            flyme.support.v7.widget.RecyclerView$g r0 = r9.f17955K
            flyme.support.v7.widget.StaggeredGridLayoutManager r0 = (flyme.support.p093v7.widget.StaggeredGridLayoutManager) r0
            int r2 = r0.mo26866p()
            r4 = 0
            if (r2 != r1) goto L_0x00b4
            int r2 = r9.getHeight()
            int r5 = r9.getPaddingTop()
            int r2 = r2 - r5
            int r5 = r9.getPaddingBottom()
            int r2 = r2 - r5
            boolean r5 = r0.mo26860i()
            if (r5 == 0) goto L_0x0079
            int[] r4 = r0.mo26852a((int[]) r4)
            r5 = r4[r3]
            android.view.View r5 = r0.mo26080c((int) r5)
            if (r5 != 0) goto L_0x004a
            return r3
        L_0x004a:
            int r5 = r0.mo26640i((android.view.View) r5)
            r6 = r5
            r5 = 1
        L_0x0050:
            int r7 = r4.length
            if (r5 >= r7) goto L_0x0069
            r7 = r4[r5]
            android.view.View r7 = r0.mo26080c((int) r7)
            if (r7 != 0) goto L_0x005c
            return r3
        L_0x005c:
            int r8 = r0.mo26640i((android.view.View) r7)
            if (r6 <= r8) goto L_0x0066
            int r6 = r0.mo26640i((android.view.View) r7)
        L_0x0066:
            int r5 = r5 + 1
            goto L_0x0050
        L_0x0069:
            android.view.View r4 = r0.mo26858d((boolean) r3)
            if (r4 != 0) goto L_0x0070
            return r3
        L_0x0070:
            int r0 = r0.mo26644k((android.view.View) r4)
            int r0 = r0 - r6
            if (r0 > r2) goto L_0x0103
            goto L_0x0104
        L_0x0079:
            int[] r4 = r0.mo26852a((int[]) r4)
            r5 = r4[r3]
            android.view.View r5 = r0.mo26080c((int) r5)
            if (r5 != 0) goto L_0x0086
            return r3
        L_0x0086:
            int r5 = r0.mo26644k((android.view.View) r5)
            r6 = r5
            r5 = 1
        L_0x008c:
            int r7 = r4.length
            if (r5 >= r7) goto L_0x00a5
            r7 = r4[r5]
            android.view.View r7 = r0.mo26080c((int) r7)
            if (r7 != 0) goto L_0x0098
            return r3
        L_0x0098:
            int r8 = r0.mo26644k((android.view.View) r7)
            if (r6 >= r8) goto L_0x00a2
            int r6 = r0.mo26644k((android.view.View) r7)
        L_0x00a2:
            int r5 = r5 + 1
            goto L_0x008c
        L_0x00a5:
            android.view.View r4 = r0.mo26855c((boolean) r3)
            if (r4 != 0) goto L_0x00ac
            return r3
        L_0x00ac:
            int r0 = r0.mo26640i((android.view.View) r4)
            int r6 = r6 - r0
            if (r6 > r2) goto L_0x0103
            goto L_0x0104
        L_0x00b4:
            int r2 = r9.getWidth()
            int r5 = r9.getPaddingLeft()
            int r2 = r2 - r5
            int r5 = r9.getPaddingRight()
            int r2 = r2 - r5
            boolean r5 = r0.mo26860i()
            if (r5 == 0) goto L_0x0107
            int[] r4 = r0.mo26852a((int[]) r4)
            r5 = r4[r3]
            android.view.View r5 = r0.mo26080c((int) r5)
            if (r5 != 0) goto L_0x00d5
            return r3
        L_0x00d5:
            int r5 = r0.mo26638h((android.view.View) r5)
            r6 = r5
            r5 = 1
        L_0x00db:
            int r7 = r4.length
            if (r5 >= r7) goto L_0x00f4
            r7 = r4[r5]
            android.view.View r7 = r0.mo26080c((int) r7)
            if (r7 != 0) goto L_0x00e7
            return r3
        L_0x00e7:
            int r8 = r0.mo26638h((android.view.View) r7)
            if (r6 <= r8) goto L_0x00f1
            int r6 = r0.mo26638h((android.view.View) r7)
        L_0x00f1:
            int r5 = r5 + 1
            goto L_0x00db
        L_0x00f4:
            android.view.View r4 = r0.mo26858d((boolean) r3)
            if (r4 != 0) goto L_0x00fb
            return r3
        L_0x00fb:
            int r0 = r0.mo26642j((android.view.View) r4)
            int r0 = r0 - r6
            if (r0 > r2) goto L_0x0103
            goto L_0x0104
        L_0x0103:
            r1 = 0
        L_0x0104:
            r3 = r1
            goto L_0x01e8
        L_0x0107:
            int[] r4 = r0.mo26852a((int[]) r4)
            r5 = r4[r3]
            android.view.View r5 = r0.mo26080c((int) r5)
            if (r5 != 0) goto L_0x0114
            return r3
        L_0x0114:
            int r5 = r0.mo26642j((android.view.View) r5)
            r6 = r5
            r5 = 1
        L_0x011a:
            int r7 = r4.length
            if (r5 >= r7) goto L_0x0133
            r7 = r4[r5]
            android.view.View r7 = r0.mo26080c((int) r7)
            if (r7 != 0) goto L_0x0126
            return r3
        L_0x0126:
            int r8 = r0.mo26642j((android.view.View) r7)
            if (r6 >= r8) goto L_0x0130
            int r6 = r0.mo26642j((android.view.View) r7)
        L_0x0130:
            int r5 = r5 + 1
            goto L_0x011a
        L_0x0133:
            android.view.View r4 = r0.mo26855c((boolean) r3)
            if (r4 != 0) goto L_0x013a
            return r3
        L_0x013a:
            int r0 = r0.mo26638h((android.view.View) r4)
            int r6 = r6 - r0
            if (r6 > r2) goto L_0x0103
            goto L_0x0104
        L_0x0142:
            flyme.support.v7.widget.RecyclerView$g r2 = r9.f17955K
            boolean r2 = r2 instanceof flyme.support.p093v7.widget.LinearLayoutManager
            if (r2 == 0) goto L_0x01e8
            flyme.support.v7.widget.RecyclerView$g r2 = r9.f17955K
            flyme.support.v7.widget.LinearLayoutManager r2 = (flyme.support.p093v7.widget.LinearLayoutManager) r2
            int r4 = r2.mo26093h()
            if (r4 != r1) goto L_0x019d
            int r4 = r9.getHeight()
            int r5 = r9.getPaddingTop()
            int r4 = r4 - r5
            int r5 = r9.getPaddingBottom()
            int r4 = r4 - r5
            boolean r5 = r2.mo26095i()
            if (r5 == 0) goto L_0x0181
            int r0 = r0 - r1
            android.view.View r0 = r2.mo26080c((int) r0)
            android.view.View r5 = r2.mo26080c((int) r3)
            if (r0 == 0) goto L_0x0180
            if (r5 != 0) goto L_0x0174
            goto L_0x0180
        L_0x0174:
            int r5 = r2.mo26644k((android.view.View) r5)
            int r0 = r2.mo26640i((android.view.View) r0)
            int r5 = r5 - r0
            if (r5 > r4) goto L_0x0103
            goto L_0x0104
        L_0x0180:
            return r3
        L_0x0181:
            int r0 = r0 - r1
            android.view.View r0 = r2.mo26080c((int) r0)
            android.view.View r5 = r2.mo26080c((int) r3)
            if (r5 == 0) goto L_0x019c
            if (r0 != 0) goto L_0x018f
            goto L_0x019c
        L_0x018f:
            int r0 = r2.mo26644k((android.view.View) r0)
            int r2 = r2.mo26640i((android.view.View) r5)
            int r0 = r0 - r2
            if (r0 > r4) goto L_0x0103
            goto L_0x0104
        L_0x019c:
            return r3
        L_0x019d:
            int r4 = r9.getWidth()
            int r5 = r9.getPaddingLeft()
            int r4 = r4 - r5
            int r5 = r9.getPaddingRight()
            int r4 = r4 - r5
            boolean r5 = r2.mo26095i()
            if (r5 == 0) goto L_0x01cd
            int r0 = r0 - r1
            android.view.View r0 = r2.mo26080c((int) r0)
            android.view.View r5 = r2.mo26080c((int) r3)
            if (r0 == 0) goto L_0x01cc
            if (r5 != 0) goto L_0x01bf
            goto L_0x01cc
        L_0x01bf:
            int r5 = r2.mo26642j((android.view.View) r5)
            int r0 = r2.mo26638h((android.view.View) r0)
            int r5 = r5 - r0
            if (r5 > r4) goto L_0x01e8
        L_0x01ca:
            r3 = 1
            goto L_0x01e8
        L_0x01cc:
            return r3
        L_0x01cd:
            int r0 = r0 - r1
            android.view.View r0 = r2.mo26080c((int) r0)
            android.view.View r5 = r2.mo26080c((int) r3)
            if (r5 == 0) goto L_0x01e7
            if (r0 != 0) goto L_0x01db
            goto L_0x01e7
        L_0x01db:
            int r0 = r2.mo26642j((android.view.View) r0)
            int r2 = r2.mo26638h((android.view.View) r5)
            int r0 = r0 - r2
            if (r0 > r4) goto L_0x01e8
            goto L_0x01ca
        L_0x01e7:
            return r3
        L_0x01e8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.RecyclerView.mo26360J():boolean");
    }

    /* renamed from: K */
    public void mo26361K() {
        if (this.f18012r != null) {
            this.f18012r.finish();
        }
        if (this.f18013s != null) {
            this.f18013s.finish();
        }
        if (this.f18014t != null) {
            this.f18014t.finish();
        }
        if (this.f18015u != null) {
            this.f18015u.finish();
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* renamed from: L */
    public boolean mo26362L() {
        return this.f17975aH;
    }

    public void setSelectorCanDraw(boolean z) {
        this.f17975aH = z;
    }
}
