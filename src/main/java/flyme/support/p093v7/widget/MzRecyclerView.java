package flyme.support.p093v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.StateSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import android.widget.Checkable;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.collection.LongSparseArray;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import flyme.support.p093v7.R;
import flyme.support.p093v7.widget.RecyclerView;
import flyme.support.p093v7.widget.RecyclerViewGestureDetector;
import flyme.support.p093v7.widget.p096a.RecyclerPinnedHeaderDecoration;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: flyme.support.v7.widget.MzRecyclerView */
public class MzRecyclerView extends RecyclerView {
    /* access modifiers changed from: private */

    /* renamed from: aR */
    public static float f17696aR = Float.MAX_VALUE;
    /* access modifiers changed from: private */

    /* renamed from: aU */
    public static Field f17697aU;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f17698a;
    /* access modifiers changed from: private */

    /* renamed from: aA */
    public int f17699aA;
    /* access modifiers changed from: private */

    /* renamed from: aB */
    public int f17700aB;

    /* renamed from: aC */
    private int f17701aC;

    /* renamed from: aD */
    private C3234o f17702aD;

    /* renamed from: aE */
    private boolean f17703aE;
    /* access modifiers changed from: private */

    /* renamed from: aF */
    public C3218b f17704aF;

    /* renamed from: aG */
    private boolean f17705aG;

    /* renamed from: aH */
    private Method f17706aH;
    /* access modifiers changed from: private */

    /* renamed from: aI */
    public C3219c f17707aI;

    /* renamed from: aJ */
    private StateListDrawable f17708aJ;
    /* access modifiers changed from: private */

    /* renamed from: aK */
    public boolean f17709aK;
    /* access modifiers changed from: private */

    /* renamed from: aL */
    public boolean f17710aL;

    /* renamed from: aM */
    private boolean f17711aM;

    /* renamed from: aN */
    private float f17712aN;

    /* renamed from: aO */
    private float f17713aO;

    /* renamed from: aP */
    private C3231n f17714aP;
    /* access modifiers changed from: private */

    /* renamed from: aQ */
    public C3229l f17715aQ;

    /* renamed from: aS */
    private float f17716aS;

    /* renamed from: aT */
    private HashSet<RecyclerView.C3286u> f17717aT;
    /* access modifiers changed from: private */

    /* renamed from: aV */
    public boolean f17718aV;

    /* renamed from: aW */
    private ArrayList<C3217a> f17719aW;

    /* renamed from: aX */
    private ArrayList<C3217a> f17720aX;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public boolean f17721aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public C3227j f17722ak;
    /* access modifiers changed from: private */

    /* renamed from: al */
    public C3228k f17723al;

    /* renamed from: am */
    private RecyclerViewGestureDetector f17724am;

    /* renamed from: an */
    private RecyclerPinnedHeaderDecoration f17725an;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public C3220d f17726ao;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public Runnable f17727ap;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public boolean f17728aq;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public boolean f17729ar;

    /* renamed from: as */
    private C3226i f17730as;
    /* access modifiers changed from: private */

    /* renamed from: at */
    public boolean f17731at;

    /* renamed from: au */
    private int f17732au;

    /* renamed from: av */
    private int f17733av;

    /* renamed from: aw */
    private int f17734aw;
    /* access modifiers changed from: private */

    /* renamed from: ax */
    public int f17735ax;

    /* renamed from: ay */
    private boolean f17736ay;

    /* renamed from: az */
    private int f17737az;

    /* renamed from: b */
    int f17738b;

    /* renamed from: c */
    int f17739c;

    /* renamed from: d */
    ActionMode f17740d;

    /* renamed from: e */
    MultiChoiceModeWrapper f17741e;

    /* renamed from: f */
    C3224g f17742f;

    /* renamed from: g */
    int f17743g;

    /* renamed from: h */
    SparseBooleanArray f17744h;

    /* renamed from: i */
    LongSparseArray<Integer> f17745i;

    /* renamed from: j */
    protected Rect f17746j;

    /* renamed from: k */
    protected int f17747k;

    /* renamed from: l */
    protected int f17748l;

    /* renamed from: m */
    protected int f17749m;

    /* renamed from: n */
    protected int f17750n;

    /* renamed from: o */
    boolean f17751o;

    /* renamed from: p */
    Drawable f17752p;

    /* renamed from: q */
    Rect f17753q;

    /* renamed from: r */
    int f17754r;

    /* renamed from: s */
    int f17755s;

    /* renamed from: t */
    int f17756t;

    /* renamed from: u */
    int f17757u;

    /* renamed from: v */
    int f17758v;

    /* renamed from: w */
    boolean f17759w;

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$a */
    public class C3217a {

        /* renamed from: a */
        public RecyclerView.C3286u f17769a;

        /* renamed from: b */
        public boolean f17770b;
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$d */
    public interface C3220d {
        /* renamed from: a */
        boolean mo26237a(int i);
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$g */
    public interface C3224g {
        /* renamed from: a */
        void mo26249a();

        /* renamed from: a */
        void mo26250a(int i, long j, boolean z);

        /* renamed from: b */
        void mo26251b();
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$h */
    public interface C3225h extends ActionMode.Callback {
        /* renamed from: a */
        void mo26228a(ActionMode actionMode, int i, long j, boolean z);
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$i */
    public interface C3226i {
        /* renamed from: a */
        boolean mo26252a(View view, int i, long j);
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$j */
    public interface C3227j {
        void onItemClick(RecyclerView recyclerView, View view, int i, long j);
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$k */
    public interface C3228k {
        /* renamed from: a */
        boolean mo26253a(RecyclerView recyclerView, View view, int i, long j);
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$l */
    public interface C3229l {
        /* renamed from: a */
        void mo26254a(int i, int i2, int i3, HashSet hashSet);

        /* renamed from: a */
        void mo26255a(int i, HashSet hashSet);
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$p */
    public interface C3235p {
        /* renamed from: a */
        void mo26282a(Rect rect);
    }

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z) {
    }

    public void setDelayTopOverScrollEnabled(boolean z) {
    }

    public void setDelayTopOverScrollOffset(int i) {
    }

    public MzRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MzRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MzRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17698a = false;
        this.f17721aj = false;
        this.f17738b = -1;
        this.f17739c = 0;
        this.f17726ao = null;
        this.f17727ap = null;
        boolean z = true;
        this.f17705aG = true;
        this.f17751o = false;
        this.f17753q = new Rect();
        this.f17754r = -1;
        this.f17755s = 0;
        this.f17756t = 0;
        this.f17757u = 0;
        this.f17758v = 0;
        this.f17759w = false;
        this.f17706aH = null;
        this.f17709aK = false;
        this.f17710aL = false;
        this.f17711aM = false;
        this.f17716aS = f17696aR;
        this.f17718aV = false;
        this.f17719aW = new ArrayList<>();
        this.f17720aX = new ArrayList<>();
        m19362Q();
        this.f17724am = new C3221e(context, new C3222f());
        this.f17759w = Build.VERSION.SDK_INT < 21 ? false : z;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MzRecyclerView, i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.MzRecyclerView_listSelectors);
        if (drawable != null) {
            setSelector(drawable);
        }
        obtainStyledAttributes.recycle();
    }

    public void setAdapter(RecyclerView.C3260a aVar) {
        if (aVar != null && (this.f17719aW.size() > 0 || this.f17720aX.size() > 0)) {
            if (!(aVar instanceof HeaderAndFooterWrapperAdapter)) {
                aVar = new HeaderAndFooterWrapperAdapter(aVar);
            }
            HeaderAndFooterWrapperAdapter lVar = (HeaderAndFooterWrapperAdapter) aVar;
            Iterator<C3217a> it = this.f17719aW.iterator();
            while (it.hasNext()) {
                lVar.mo27189a(it.next());
            }
            Iterator<C3217a> it2 = this.f17720aX.iterator();
            while (it2.hasNext()) {
                lVar.mo27191b(it2.next());
            }
        }
        super.setAdapter(aVar);
        if (aVar != null) {
            boolean d = getAdapter().mo23933d();
            if (this.f17739c != 0 && d && this.f17745i == null) {
                this.f17745i = new LongSparseArray<>();
            }
        }
        mo26161c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26148a() {
        super.mo26148a();
        m19361P();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo26156b() {
        if (this.f17978ac.mo26748e()) {
            mo26163d();
            m19365T();
            setPressed(false);
            if (this.f17752p != null) {
                this.f17752p.jumpToCurrentState();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26151a(View view, int i) {
        setViewChecked(view, i);
        setHoldViewBackground(view);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.f17751o;
        if (!z && mo26362L()) {
            mo26150a(canvas);
        }
        super.dispatchDraw(canvas);
        if (z && mo26362L()) {
            mo26150a(canvas);
        }
        m19359N();
        int size = this.f17957M.size();
        for (int i = 0; i < size; i++) {
            ((RecyclerView.C3265f) this.f17957M.get(i)).mo26556d(canvas, this, this.f17978ac);
        }
        m19380b(canvas);
    }

    /* renamed from: N */
    private void m19359N() {
        int size = this.f17957M.size();
        for (int i = 0; i < size; i++) {
            ((RecyclerView.C3265f) this.f17957M.get(i)).mo26555d();
        }
        for (int i2 = 0; i2 < size; i2++) {
            HashSet<Integer> c = ((RecyclerView.C3265f) this.f17957M.get(i2)).mo26553c();
            for (int i3 = 0; i3 < size; i3++) {
                if (i2 != i3) {
                    ((RecyclerView.C3265f) this.f17957M.get(i3)).mo26550a(c);
                }
            }
        }
    }

    /* renamed from: b */
    private void m19380b(Canvas canvas) {
        int size = this.f17957M.size();
        for (int i = 0; i < size; i++) {
            ((RecyclerView.C3265f) this.f17957M.get(i)).mo26552b(canvas, this, this.f17978ac);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f17725an != null && -1 != this.f17725an.mo27056a((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        m19372a(motionEvent);
        boolean a = this.f17724am.mo26238a(motionEvent);
        if (!a && !this.f17731at) {
            return super.onTouchEvent(motionEvent);
        }
        if (a && (motionEvent.getAction() & 255) == 0) {
            boolean a2 = this.f17955K.mo22258a();
            boolean g = this.f17955K.mo26092g();
            int i = 0;
            if (a2) {
                i = 1;
            }
            if (g) {
                i |= 2;
            }
            startNestedScroll(i);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        mo26152a(true);
    }

    public void setOnItemClickListener(C3227j jVar) {
        this.f17722ak = jVar;
    }

    public final C3227j getOnItemClickListener() {
        return this.f17722ak;
    }

    public void setOnItemLongClickListener(C3228k kVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.f17723al = kVar;
    }

    public final C3228k getOnItemLongClickListener() {
        return this.f17723al;
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$e */
    private class C3221e extends RecyclerViewGestureDetector {

        /* renamed from: b */
        private C3222f f17779b;

        /* renamed from: c */
        private int f17780c;

        /* renamed from: d */
        private int f17781d;

        /* renamed from: e */
        private int f17782e;

        /* renamed from: f */
        private int f17783f = -1;

        /* renamed from: g */
        private VelocityTracker f17784g;

        public C3221e(Context context, C3222f fVar) {
            super(context, fVar);
            this.f17779b = fVar;
            this.f17782e = ViewConfiguration.get(context).getScaledTouchSlop();
        }

        /* renamed from: a */
        public boolean mo26238a(MotionEvent motionEvent) {
            if (this.f17784g == null) {
                this.f17784g = VelocityTracker.obtain();
            }
            this.f17784g.addMovement(motionEvent);
            boolean a = super.mo26238a(motionEvent);
            RecyclerView.C3266g layoutManager = MzRecyclerView.this.getLayoutManager();
            boolean z = false;
            if (layoutManager == null) {
                return false;
            }
            boolean a2 = layoutManager.mo22258a();
            boolean g = layoutManager.mo26092g();
            switch (motionEvent.getAction()) {
                case 0:
                    this.f17780c = (int) (motionEvent.getX() + 0.5f);
                    this.f17781d = (int) (motionEvent.getY() + 0.5f);
                    this.f17783f = MotionEventCompat.getPointerId(motionEvent, 0);
                    break;
                case 1:
                    this.f17784g.computeCurrentVelocity(1000, (float) MzRecyclerView.this.getMaxFlingVelocity());
                    float f = 0.0f;
                    float f2 = a2 ? -VelocityTrackerCompat.getXVelocity(this.f17784g, this.f17783f) : 0.0f;
                    if (g) {
                        f = -VelocityTrackerCompat.getYVelocity(this.f17784g, this.f17783f);
                    }
                    if (Math.abs(f) >= ((float) MzRecyclerView.this.getMinFlingVelocity()) || Math.abs(f2) >= ((float) MzRecyclerView.this.getMinFlingVelocity())) {
                        z = true;
                    }
                    if (z && MzRecyclerView.this.f17738b == 3) {
                        MzRecyclerView.this.f17738b = 4;
                    }
                    this.f17779b.mo26243b();
                    if (this.f17784g != null) {
                        this.f17784g.clear();
                        break;
                    }
                    break;
                case 2:
                    int x = (int) (motionEvent.getX() + 0.5f);
                    int y = (int) (motionEvent.getY() + 0.5f);
                    int i = this.f17780c - x;
                    int i2 = this.f17781d - y;
                    if (a2 && Math.abs(i) > this.f17782e) {
                        z = true;
                    }
                    if (g && Math.abs(i2) > this.f17782e) {
                        z = true;
                    }
                    if (MzRecyclerView.this.f17738b == 2 && z) {
                        this.f17779b.mo26239a();
                    }
                    if (z) {
                        this.f17780c = x;
                        this.f17781d = y;
                        break;
                    }
                    break;
                case 3:
                    this.f17779b.mo26245c();
                    if (this.f17784g != null) {
                        this.f17784g.clear();
                        break;
                    }
                    break;
            }
            return a;
        }
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$f */
    private class C3222f implements RecyclerViewGestureDetector.C3345b {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public View f17786b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f17787c;

        private C3222f() {
            this.f17787c = false;
        }

        /* renamed from: a */
        public boolean mo26240a(MotionEvent motionEvent) {
            if (MzRecyclerView.this.f17738b == 4 && MzRecyclerView.this.getScrollState() == 1) {
                MzRecyclerView.this.f17738b = 3;
            } else {
                MzRecyclerView.this.f17738b = 0;
                int y = (int) motionEvent.getY();
                int x = (int) motionEvent.getX();
                Rect rect = MzRecyclerView.this.f17746j;
                if ((MzRecyclerView.this.f17740d != null || MzRecyclerView.this.f17718aV) && MzRecyclerView.this.f17729ar && !MzRecyclerView.this.f17731at && MzRecyclerView.this.getScrollState() == 0 && x >= rect.left && x <= rect.right && MzRecyclerView.this.m19401n(y)) {
                    int unused = MzRecyclerView.this.f17735ax = y;
                }
                this.f17787c = true;
                this.f17786b = MzRecyclerView.this.mo26364a((float) x, (float) y);
            }
            boolean unused2 = MzRecyclerView.this.f17710aL = false;
            if (this.f17786b != null) {
                return true;
            }
            return false;
        }

        /* renamed from: b */
        public void mo26242b(MotionEvent motionEvent) {
            int a;
            if (MzRecyclerView.this.f17738b != 3) {
                if (this.f17786b != null && !MzRecyclerView.this.f17728aq && (a = MzRecyclerView.this.m19405q(this.f17786b)) >= 0 && MzRecyclerView.this.getAdapter().mo23936f(a)) {
                    MzRecyclerView.this.setPressed(true);
                    this.f17786b.setPressed(true);
                    MzRecyclerView.this.mo26149a(MzRecyclerView.this.mo26428j(this.f17786b), this.f17786b);
                    if (MzRecyclerView.this.f17752p != null && MzRecyclerView.this.f17759w) {
                        MzRecyclerView.this.f17752p.setHotspot(motionEvent.getX(), motionEvent.getY());
                    }
                }
                this.f17787c = false;
                MzRecyclerView.this.f17738b = 0;
                boolean unused = MzRecyclerView.this.f17710aL = true;
            }
        }

        /* renamed from: a */
        public boolean mo26241a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.f17787c = false;
            if (MzRecyclerView.this.f17738b == 3) {
                MzRecyclerView.this.f17738b = 4;
            }
            MzRecyclerView.this.f17753q.setEmpty();
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0074  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo26246c(android.view.MotionEvent r7) {
            /*
                r6 = this;
                r7 = 0
                r6.f17787c = r7
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.p093v7.widget.MzRecyclerView.this
                int r0 = r0.f17738b
                r1 = 3
                if (r0 != r1) goto L_0x000b
                return
            L_0x000b:
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.p093v7.widget.MzRecyclerView.this
                boolean r0 = r0.isLongClickable()
                r1 = 2
                if (r0 == 0) goto L_0x0093
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.p093v7.widget.MzRecyclerView.this
                int r0 = r0.f17738b
                if (r0 == 0) goto L_0x001c
                goto L_0x0093
            L_0x001c:
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.p093v7.widget.MzRecyclerView.this
                r0.f17738b = r1
                android.view.View r0 = r6.f17786b
                if (r0 == 0) goto L_0x0071
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.p093v7.widget.MzRecyclerView.this
                android.view.View r2 = r6.f17786b
                int r0 = r0.m19405q((android.view.View) r2)
                if (r0 < 0) goto L_0x0071
                flyme.support.v7.widget.MzRecyclerView r2 = flyme.support.p093v7.widget.MzRecyclerView.this
                flyme.support.v7.widget.MzRecyclerView$d r2 = r2.f17726ao
                if (r2 == 0) goto L_0x0042
                flyme.support.v7.widget.MzRecyclerView r2 = flyme.support.p093v7.widget.MzRecyclerView.this
                flyme.support.v7.widget.MzRecyclerView$d r2 = r2.f17726ao
                boolean r2 = r2.mo26237a(r0)
                if (r2 == 0) goto L_0x0071
            L_0x0042:
                flyme.support.v7.widget.MzRecyclerView r2 = flyme.support.p093v7.widget.MzRecyclerView.this
                flyme.support.v7.widget.RecyclerView$a r2 = r2.getAdapter()
                long r2 = r2.mo20100c((int) r0)
                java.lang.Long r2 = java.lang.Long.valueOf(r2)
                flyme.support.v7.widget.MzRecyclerView r3 = flyme.support.p093v7.widget.MzRecyclerView.this
                flyme.support.v7.widget.RecyclerView$a r3 = r3.getAdapter()
                boolean r3 = r3.mo23936f(r0)
                if (r3 == 0) goto L_0x0071
                flyme.support.v7.widget.MzRecyclerView r3 = flyme.support.p093v7.widget.MzRecyclerView.this
                flyme.support.v7.widget.RecyclerView$r r3 = r3.f17978ac
                boolean r3 = r3.mo26748e()
                if (r3 != 0) goto L_0x0071
                flyme.support.v7.widget.MzRecyclerView r3 = flyme.support.p093v7.widget.MzRecyclerView.this
                long r4 = r2.longValue()
                boolean r0 = r6.m19446a(r3, r0, r4)
                goto L_0x0072
            L_0x0071:
                r0 = 0
            L_0x0072:
                if (r0 == 0) goto L_0x008e
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.p093v7.widget.MzRecyclerView.this
                r0.setPressed(r7)
                android.view.View r0 = r6.f17786b
                r0.setPressed(r7)
                r7 = 0
                r6.f17786b = r7
                flyme.support.v7.widget.MzRecyclerView r7 = flyme.support.p093v7.widget.MzRecyclerView.this
                android.graphics.Rect r7 = r7.f17753q
                r7.setEmpty()
                flyme.support.v7.widget.MzRecyclerView r7 = flyme.support.p093v7.widget.MzRecyclerView.this
                r0 = -1
                r7.f17738b = r0
                goto L_0x0092
            L_0x008e:
                flyme.support.v7.widget.MzRecyclerView r7 = flyme.support.p093v7.widget.MzRecyclerView.this
                r7.f17738b = r1
            L_0x0092:
                return
            L_0x0093:
                flyme.support.v7.widget.MzRecyclerView r7 = flyme.support.p093v7.widget.MzRecyclerView.this
                r7.f17738b = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.MzRecyclerView.C3222f.mo26246c(android.view.MotionEvent):void");
        }

        /* renamed from: b */
        public boolean mo26244b(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.f17787c = false;
            mo26239a();
            return MzRecyclerView.this.m19381b(motionEvent2);
        }

        /* renamed from: a */
        public void mo26239a() {
            MzRecyclerView.this.setPressed(false);
            if (this.f17786b != null) {
                this.f17786b.setPressed(false);
            }
            if (MzRecyclerView.this.f17752p != null) {
                MzRecyclerView.this.f17752p.jumpToCurrentState();
            }
            MzRecyclerView.this.f17753q.setEmpty();
            MzRecyclerView.this.f17738b = 3;
        }

        /* renamed from: d */
        public boolean mo26247d(MotionEvent motionEvent) {
            boolean z = false;
            if (this.f17786b != null && !MzRecyclerView.this.f17978ac.mo26748e() && MzRecyclerView.this.f17738b == 0 && MzRecyclerView.this.getAdapter().mo23936f(MzRecyclerView.this.mo26428j(this.f17786b))) {
                int pressedStateDuration = this.f17787c ? ViewConfiguration.getPressedStateDuration() : 0;
                if (this.f17787c) {
                    MzRecyclerView.this.setPressed(true);
                    this.f17786b.setPressed(true);
                    MzRecyclerView.this.mo26149a(MzRecyclerView.this.mo26428j(this.f17786b), this.f17786b);
                    if (MzRecyclerView.this.f17752p != null && MzRecyclerView.this.f17759w) {
                        MzRecyclerView.this.f17752p.setHotspot(motionEvent.getX(), motionEvent.getY());
                    }
                }
                if (MzRecyclerView.this.f17722ak != null) {
                    z = true;
                }
                MzRecyclerView.this.postDelayed(new Runnable() {
                    public void run() {
                        if (C3222f.this.f17786b != null) {
                            MzRecyclerView.this.setPressed(false);
                            C3222f.this.f17786b.setPressed(false);
                            int a = MzRecyclerView.this.m19405q(C3222f.this.f17786b);
                            if (a >= 0 && !MzRecyclerView.this.f17978ac.mo26748e() && MzRecyclerView.this.isAttachedToWindow()) {
                                boolean unused = C3222f.this.m19447a((RecyclerView) MzRecyclerView.this, C3222f.this.f17786b, a, Long.valueOf(MzRecyclerView.this.getAdapter().mo20100c(a)).longValue());
                            }
                            View unused2 = C3222f.this.f17786b = null;
                            boolean unused3 = C3222f.this.f17787c = false;
                        }
                    }
                }, (long) pressedStateDuration);
                MzRecyclerView.this.f17738b = -1;
            }
            return z;
        }

        /* renamed from: b */
        public boolean mo26243b() {
            int a;
            if (this.f17786b != null && !this.f17787c) {
                MzRecyclerView.this.setPressed(false);
                this.f17786b.setPressed(false);
            }
            if (MzRecyclerView.this.f17738b == 2 && (a = MzRecyclerView.this.m19405q(this.f17786b)) >= 0 && !MzRecyclerView.this.f17978ac.mo26748e() && MzRecyclerView.this.isAttachedToWindow() && MzRecyclerView.this.getAdapter().mo23936f(a)) {
                m19447a((RecyclerView) MzRecyclerView.this, this.f17786b, a, Long.valueOf(MzRecyclerView.this.getAdapter().mo20100c(a)).longValue());
            }
            if (MzRecyclerView.this.f17731at && MzRecyclerView.this.f17700aB != -1) {
                MzRecyclerView.this.mo26157b(-1, MzRecyclerView.this.f17700aB);
            }
            MzRecyclerView.this.m19363R();
            if (MzRecyclerView.this.f17704aF == null) {
                C3218b unused = MzRecyclerView.this.f17704aF = new C3218b();
            }
            if (MzRecyclerView.this.f17738b == 3 || MzRecyclerView.this.f17738b == 0 || MzRecyclerView.this.f17738b == 2) {
                MzRecyclerView.this.f17738b = -1;
            }
            return false;
        }

        /* renamed from: c */
        public void mo26245c() {
            MzRecyclerView.this.m19363R();
            MzRecyclerView.this.f17738b = -1;
            MzRecyclerView.this.setScrollState(0);
            if (this.f17786b != null) {
                this.f17786b.setPressed(false);
            }
            MzRecyclerView.this.setPressed(false);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean m19447a(RecyclerView recyclerView, View view, int i, long j) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            if (MzRecyclerView.this.mo26165d(i)) {
                return true;
            }
            if (MzRecyclerView.this.f17739c != 0) {
                RecyclerView.C3260a adapter = recyclerView.getAdapter();
                if ((MzRecyclerView.this.f17739c == 4 || MzRecyclerView.this.f17739c == 5) && ((MzRecyclerView.this.f17740d != null || MzRecyclerView.this.f17718aV) && adapter.mo23937g(i))) {
                    boolean z5 = !MzRecyclerView.this.f17744h.get(i, false);
                    MzRecyclerView.this.f17744h.put(i, z5);
                    if (MzRecyclerView.this.f17745i != null && adapter.mo23933d()) {
                        if (z5) {
                            MzRecyclerView.this.f17745i.put(adapter.mo20100c(i), Integer.valueOf(i));
                        } else {
                            MzRecyclerView.this.f17745i.delete(adapter.mo20100c(i));
                        }
                    }
                    if (z5) {
                        MzRecyclerView.this.f17743g++;
                    } else {
                        MzRecyclerView.this.f17743g--;
                    }
                    if (MzRecyclerView.this.f17740d != null) {
                        MzRecyclerView.this.f17741e.mo26228a(MzRecyclerView.this.f17740d, i, j, z5);
                    } else if (!MzRecyclerView.this.f17718aV || MzRecyclerView.this.f17742f == null) {
                        z4 = true;
                        z = z4;
                        z3 = true;
                    } else {
                        MzRecyclerView.this.f17742f.mo26250a(i, j, z5);
                    }
                    z4 = false;
                    z = z4;
                    z3 = true;
                } else {
                    z3 = false;
                    z = true;
                }
                if (z3) {
                    MzRecyclerView.this.m19360O();
                }
                z2 = true;
            } else {
                z2 = false;
                z = true;
            }
            if (z && MzRecyclerView.this.f17722ak != null) {
                recyclerView.playSoundEffect(0);
                MzRecyclerView.this.f17722ak.onItemClick(recyclerView, view, i, j);
                view.sendAccessibilityEvent(1);
                z2 = true;
            }
            if (z && MzRecyclerView.this.f17709aK) {
                if (!MzRecyclerView.this.f17710aL) {
                    view.setHovered(true);
                }
                if (MzRecyclerView.this.f17707aI == null) {
                    C3219c unused = MzRecyclerView.this.f17707aI = new C3219c(view, i, j);
                } else {
                    MzRecyclerView.this.f17707aI.f17774a = view;
                    MzRecyclerView.this.f17707aI.f17775b = i;
                    MzRecyclerView.this.f17707aI.f17776c = j;
                }
            }
            return z2;
        }

        /* renamed from: a */
        private boolean m19446a(RecyclerView recyclerView, int i, long j) {
            boolean z;
            if (MzRecyclerView.this.mo26165d(i)) {
                return true;
            }
            if ((MzRecyclerView.this.f17739c == 4 || MzRecyclerView.this.f17739c == 5) && recyclerView.getAdapter().mo23937g(i)) {
                if (MzRecyclerView.this.f17741e != null) {
                    if (MzRecyclerView.this.f17740d == null) {
                        MzRecyclerView mzRecyclerView = MzRecyclerView.this;
                        ActionMode startActionMode = recyclerView.startActionMode(MzRecyclerView.this.f17741e);
                        mzRecyclerView.f17740d = startActionMode;
                        if (startActionMode != null) {
                            MzRecyclerView.this.setItemChecked(i, true);
                            if (m19448d()) {
                                recyclerView.performHapticFeedback(30900);
                            } else {
                                recyclerView.performHapticFeedback(0);
                            }
                            MzRecyclerView.this.m19360O();
                        }
                    }
                } else if (MzRecyclerView.this.f17742f != null) {
                    MzRecyclerView.this.f17742f.mo26249a();
                    boolean unused = MzRecyclerView.this.f17718aV = true;
                    MzRecyclerView.this.setItemChecked(i, true);
                    if (m19448d()) {
                        recyclerView.performHapticFeedback(30900);
                    } else {
                        recyclerView.performHapticFeedback(0);
                    }
                    MzRecyclerView.this.m19360O();
                }
                return true;
            }
            if (MzRecyclerView.this.f17723al != null) {
                z = MzRecyclerView.this.f17723al.mo26253a(recyclerView, this.f17786b, i, j);
            } else {
                z = false;
            }
            if (z) {
                if (m19448d()) {
                    recyclerView.performHapticFeedback(30900);
                } else {
                    recyclerView.performHapticFeedback(0);
                }
            }
            if (MzRecyclerView.this.f17729ar) {
                int unused2 = MzRecyclerView.this.f17699aA = i;
            }
            return z;
        }

        /* renamed from: d */
        private boolean m19448d() {
            try {
                if (MzRecyclerView.f17697aU == null) {
                    Field unused = MzRecyclerView.f17697aU = Class.forName("flyme.config.FlymeFeature").getDeclaredField("SHELL_HAPTICFEEDBACK_MOTOR");
                }
                return MzRecyclerView.f17697aU.getBoolean((Object) null);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
                return false;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return false;
            }
        }
    }

    public int getCheckedItemCount() {
        return this.f17743g;
    }

    /* renamed from: a */
    public boolean mo26153a(int i) {
        if (this.f17739c == 0 || this.f17744h == null) {
            return false;
        }
        return this.f17744h.get(i);
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.f17739c != 0) {
            return this.f17744h;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.f17739c == 0 || this.f17745i == null || getAdapter() == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.f17745i;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = longSparseArray.keyAt(i);
        }
        return jArr;
    }

    /* renamed from: c */
    public void mo26161c() {
        if (this.f17744h != null) {
            this.f17744h.clear();
        }
        if (this.f17745i != null) {
            this.f17745i.clear();
        }
        this.f17743g = 0;
    }

    public void setItemChecked(int i, boolean z) {
        if (this.f17739c != 0) {
            RecyclerView.C3260a adapter = getAdapter();
            if (z && this.f17739c == 4 && this.f17740d == null) {
                if (this.f17742f != null) {
                    this.f17742f.mo26249a();
                    this.f17718aV = true;
                } else if (this.f17741e == null || !this.f17741e.mo26230a()) {
                    throw new IllegalStateException("RecyclerView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                } else {
                    this.f17740d = startActionMode(this.f17741e);
                }
            }
            if (this.f17739c == 4 || this.f17739c == 5) {
                boolean z2 = this.f17744h.get(i);
                this.f17744h.put(i, z);
                if (this.f17745i != null && adapter.mo23933d()) {
                    if (z) {
                        this.f17745i.put(adapter.mo20100c(i), Integer.valueOf(i));
                    } else {
                        this.f17745i.delete(adapter.mo20100c(i));
                    }
                }
                if (z2 != z) {
                    if (z) {
                        this.f17743g++;
                    } else {
                        this.f17743g--;
                    }
                }
                if (this.f17740d != null) {
                    this.f17741e.mo26228a(this.f17740d, i, adapter.mo20100c(i), z);
                } else if (this.f17718aV && this.f17742f != null) {
                    this.f17742f.mo26250a(i, adapter.mo20100c(i), z);
                }
            } else {
                boolean z3 = this.f17745i != null && adapter.mo23933d();
                if (z || mo26153a(i)) {
                    this.f17744h.clear();
                    if (z3) {
                        this.f17745i.clear();
                    }
                }
                if (z) {
                    this.f17744h.put(i, true);
                    if (z3) {
                        this.f17745i.put(adapter.mo20100c(i), Integer.valueOf(i));
                    }
                    this.f17743g = 1;
                } else if (this.f17744h.size() == 0 || !this.f17744h.valueAt(0)) {
                    this.f17743g = 0;
                }
            }
            m19360O();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O */
    public void m19360O() {
        int childCountExt = getChildCountExt();
        for (int i = 0; i < childCountExt; i++) {
            View c = mo26160c(i);
            setViewChecked(c, m19405q(c));
        }
    }

    public void setViewChecked(View view, int i) {
        View findViewById;
        if (view != null && this.f17739c != 0 && this.f17744h != null) {
            boolean z = this.f17744h.get(i);
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(z);
            } else if (getContext().getApplicationInfo().targetSdkVersion >= 11) {
                if ((this.f17739c == 4 || this.f17739c == 5) && (findViewById = view.findViewById(16908289)) != null && (findViewById instanceof Checkable)) {
                    ((Checkable) findViewById).setChecked(this.f17740d != null || this.f17718aV);
                }
                if (this.f17698a) {
                    Log.i("MzRecyclerView", "setViewChecked position = " + i + " checked = " + z);
                }
                view.setActivated(z);
            }
        }
    }

    public int getChoiceMode() {
        return this.f17739c;
    }

    public void setChoiceMode(int i) {
        this.f17739c = i;
        if (this.f17740d != null) {
            this.f17740d.finish();
            this.f17740d = null;
        } else if (this.f17718aV) {
            this.f17742f.mo26251b();
            this.f17718aV = false;
            mo26161c();
            m19360O();
            setLongClickable(true);
            this.f17946B.mo26688a();
            getRecycledViewPool().mo26676a();
        }
        if (this.f17739c != 0) {
            if (this.f17744h == null) {
                this.f17744h = new SparseBooleanArray(0);
            }
            RecyclerView.C3260a adapter = getAdapter();
            if (this.f17745i == null && adapter != null && adapter.mo23933d()) {
                this.f17745i = new LongSparseArray<>(0);
            }
            if (this.f17739c == 4) {
                mo26161c();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceListener(C3224g gVar) {
        this.f17742f = gVar;
    }

    public void setMultiChoiceModeListener(C3225h hVar) {
        if (this.f17741e == null) {
            this.f17741e = new MultiChoiceModeWrapper();
        }
        this.f17741e.mo26229a(hVar);
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$MultiChoiceModeWrapper */
    class MultiChoiceModeWrapper implements C3225h {

        /* renamed from: b */
        private C3225h f17768b;

        MultiChoiceModeWrapper() {
        }

        /* renamed from: a */
        public void mo26229a(C3225h hVar) {
            this.f17768b = hVar;
        }

        /* renamed from: a */
        public boolean mo26230a() {
            return this.f17768b != null;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (!this.f17768b.onCreateActionMode(actionMode, menu)) {
                return false;
            }
            if (MzRecyclerView.this.f17739c == 4 || MzRecyclerView.this.f17739c == 5) {
                MzRecyclerView.this.setLongClickable(true);
            } else {
                MzRecyclerView.this.setLongClickable(false);
            }
            return true;
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f17768b.onPrepareActionMode(actionMode, menu);
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f17768b.onActionItemClicked(actionMode, menuItem);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f17768b.onDestroyActionMode(actionMode);
            MzRecyclerView.this.f17740d = null;
            MzRecyclerView.this.mo26161c();
            MzRecyclerView.this.m19360O();
            MzRecyclerView.this.setLongClickable(true);
            MzRecyclerView.this.f17946B.mo26688a();
            MzRecyclerView.this.getRecycledViewPool().mo26676a();
        }

        /* renamed from: a */
        public void mo26228a(ActionMode actionMode, int i, long j, boolean z) {
            this.f17768b.mo26228a(actionMode, i, j, z);
            if (MzRecyclerView.this.getCheckedItemCount() == 0 && MzRecyclerView.this.f17739c != 5) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo26163d() {
        boolean z;
        RecyclerView.C3260a adapter = getAdapter();
        if (this.f17739c != 0 && adapter != null && adapter.mo23933d()) {
            int itemCount = getItemCount();
            this.f17744h.clear();
            int i = 0;
            boolean z2 = false;
            while (i < this.f17745i.size()) {
                long keyAt = this.f17745i.keyAt(i);
                int intValue = this.f17745i.valueAt(i).intValue();
                if (keyAt != adapter.mo20100c(intValue)) {
                    int max = Math.max(0, intValue - 20);
                    int min = Math.min(intValue + 20, itemCount);
                    while (true) {
                        if (max >= min) {
                            z = false;
                            break;
                        } else if (keyAt == adapter.mo20100c(max)) {
                            this.f17744h.put(max, true);
                            this.f17745i.setValueAt(i, Integer.valueOf(max));
                            z = true;
                            break;
                        } else {
                            max++;
                        }
                    }
                    if (!z) {
                        this.f17745i.delete(keyAt);
                        i--;
                        this.f17743g--;
                        if (this.f17740d != null && this.f17741e != null) {
                            this.f17741e.mo26228a(this.f17740d, intValue, keyAt, false);
                        } else if (this.f17718aV && this.f17742f != null) {
                            this.f17742f.mo26250a(intValue, keyAt, false);
                        }
                        z2 = true;
                    }
                } else {
                    this.f17744h.put(intValue, true);
                }
                i++;
            }
            if (z2 && this.f17740d != null) {
                this.f17740d.invalidate();
            }
        }
    }

    /* renamed from: e */
    public boolean mo26170e() {
        if (this.f17739c == 5 || this.f17739c == 4) {
            if (this.f17740d == null && this.f17742f == null) {
                this.f17740d = startActionMode(this.f17741e);
                if (this.f17740d == null) {
                    return false;
                }
                post(new Runnable() {
                    public void run() {
                        MzRecyclerView.this.requestLayout();
                    }
                });
                return true;
            } else if (this.f17742f != null) {
                this.f17742f.mo26249a();
                this.f17718aV = true;
                post(new Runnable() {
                    public void run() {
                        MzRecyclerView.this.requestLayout();
                    }
                });
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public Boolean mo26171f() {
        return Boolean.valueOf(this.f17740d != null || this.f17718aV);
    }

    /* renamed from: P */
    private void m19361P() {
        if (this.f17739c != 5) {
            return;
        }
        if ((this.f17740d == null || !this.f17718aV) && this.f17727ap == null) {
            this.f17727ap = new Runnable() {
                public void run() {
                    MzRecyclerView.this.mo26170e();
                    Runnable unused = MzRecyclerView.this.f17727ap = null;
                }
            };
            post(this.f17727ap);
        }
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$MZSavedState */
    static class MZSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<MZSavedState> CREATOR = new Parcelable.Creator<MZSavedState>() {
            /* renamed from: a */
            public MZSavedState createFromParcel(Parcel parcel) {
                return new MZSavedState(parcel);
            }

            /* renamed from: a */
            public MZSavedState[] newArray(int i) {
                return new MZSavedState[i];
            }
        };

        /* renamed from: a */
        boolean f17763a;

        /* renamed from: b */
        int f17764b;

        /* renamed from: c */
        SparseBooleanArray f17765c;

        /* renamed from: d */
        LongSparseArray<Integer> f17766d;

        private MZSavedState(Parcel parcel) {
            super(parcel);
            this.f17763a = parcel.readByte() != 0;
            this.f17764b = parcel.readInt();
            this.f17765c = parcel.readSparseBooleanArray();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                this.f17766d = new LongSparseArray<>();
                for (int i = 0; i < readInt; i++) {
                    this.f17766d.put(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                }
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f17763a ? (byte) 1 : 0);
            parcel.writeInt(this.f17764b);
            parcel.writeSparseBooleanArray(this.f17765c);
            int size = this.f17766d != null ? this.f17766d.size() : 0;
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeLong(this.f17766d.keyAt(i2));
                parcel.writeInt(this.f17766d.valueAt(i2).intValue());
            }
        }

        public String toString() {
            return "MzRecyclerView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " checkState=" + this.f17765c + "}";
        }
    }

    /* renamed from: Q */
    private void m19362Q() {
        Resources resources = getResources();
        this.f17728aq = false;
        this.f17747k = resources.getDimensionPixelSize(R.dimen.mz_list_check_width);
        this.f17750n = resources.getDimensionPixelSize(R.dimen.mz_list_item_height);
        this.f17730as = null;
        this.f17731at = false;
        this.f17732au = 0;
        this.f17733av = 0;
        this.f17734aw = -1;
        this.f17735ax = -1;
        this.f17737az = 0;
        this.f17702aD = null;
        this.f17703aE = false;
        this.f17699aA = -1;
        this.f17748l = -1;
        this.f17749m = -1;
        this.f17701aC = getResources().getDimensionPixelSize(R.dimen.mz_recyclerview_scrollbar_padding);
    }

    /* renamed from: a */
    private void m19372a(MotionEvent motionEvent) {
        RecyclerView.C3266g layoutManager = getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager) || ((LinearLayoutManager) layoutManager).mo26093h() != 1) {
            this.f17728aq = false;
            this.f17729ar = false;
            this.f17730as = null;
            return;
        }
        if (getScrollY() != 0) {
            mo26152a(true);
        } else {
            mo26152a(false);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 2) {
            m19397l((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (actionMasked == 3) {
            this.f17728aq = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26152a(boolean z) {
        if (this.f17746j == null) {
            this.f17746j = new Rect();
            this.f17746j.setEmpty();
        }
        if (this.f17739c != 4 && this.f17739c != 5) {
            this.f17746j.setEmpty();
        } else if (!this.f17746j.isEmpty() && !z) {
        } else {
            if (getLayoutDirection() == 1) {
                this.f17746j.left = getPaddingLeft();
                this.f17746j.right = this.f17746j.left + this.f17747k;
                this.f17746j.top = getPaddingTop();
                this.f17746j.bottom = getHeight() - getPaddingBottom();
                return;
            }
            this.f17746j.right = getWidth() - getPaddingRight();
            this.f17746j.left = this.f17746j.right - this.f17747k;
            this.f17746j.top = getPaddingTop();
            this.f17746j.bottom = getHeight() - getPaddingBottom();
        }
    }

    /* renamed from: l */
    private void m19397l(int i, int i2) {
        this.f17728aq = this.f17746j != null && this.f17746j.contains(i, i2);
    }

    public void setEnableDragSelection(boolean z) {
        this.f17729ar = z;
    }

    public void setEnableDragSelection(C3226i iVar) {
        setEnableDragSelection(true);
        this.f17730as = iVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m19381b(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Rect rect = this.f17746j;
        if (this.f17698a || this.f17721aj) {
            Log.i("MzRecyclerView", "onScroll 1 mEnableDragSelection = " + this.f17729ar + " mIsBeginDragSelect = " + this.f17731at + " mIsOutOfListContent = " + this.f17703aE + " ");
        }
        boolean z = false;
        if (this.f17740d == null && !this.f17718aV) {
            return false;
        }
        if (this.f17729ar && !this.f17731at && this.f17735ax >= 0) {
            this.f17700aB = this.f17734aw;
            this.f17735ax = y;
            this.f17737az = this.f17735ax;
            this.f17731at = true;
            boolean unused = super.onTouchEvent(MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0));
            this.f17738b = 3;
            return true;
        } else if (this.f17736ay) {
            return true;
        } else {
            if (!this.f17731at || (x >= rect.left && x <= rect.right)) {
                if (this.f17731at) {
                    this.f17737az = this.f17735ax;
                    this.f17735ax = y;
                }
                if (this.f17698a || this.f17721aj) {
                    Log.i("MzRecyclerView", "onScroll 2 mEnableDragSelection = " + this.f17729ar + " mIsBeginDragSelect = " + this.f17731at + " mIsOutOfListContent = " + this.f17703aE + " ");
                }
                if (!this.f17731at) {
                    return false;
                }
                if (this.f17703aE) {
                    if (m19401n(y)) {
                        if (this.f17737az < 0) {
                            mo26157b(-1, this.f17734aw);
                        } else {
                            mo26162c(-1, this.f17734aw);
                        }
                        this.f17703aE = false;
                    }
                    return true;
                } else if (!mo26158b(y) || mo26360J()) {
                    if (this.f17702aD != null && this.f17702aD.mo26279a()) {
                        this.f17702aD.mo26280b();
                    }
                    if (y < this.f17732au) {
                        if (this.f17698a || this.f17721aj) {
                            Log.i("MzRecyclerView", " up mDragDownPosition = " + this.f17700aB + " mLastUpSelectPosition = " + this.f17748l + " mLastDownSelectPosition = " + this.f17749m + " mDragMotionPosition = " + this.f17734aw);
                        }
                        if (this.f17700aB != -1) {
                            mo26162c(-1, this.f17700aB);
                            this.f17700aB = -1;
                        }
                        if (this.f17749m != -1) {
                            mo26162c(-1, this.f17749m);
                        }
                        if (!m19401n(y)) {
                            int firstPosition = getFirstPosition();
                            if (this.f17748l != firstPosition) {
                                mo26162c(this.f17748l, firstPosition);
                            }
                            this.f17749m = -1;
                            this.f17748l = -1;
                            this.f17703aE = true;
                            return true;
                        }
                        mo26162c(this.f17748l, this.f17734aw);
                    } else if (y > this.f17733av) {
                        if (this.f17698a || this.f17721aj) {
                            Log.i("MzRecyclerView", " down mDragDownPosition = " + this.f17700aB + " mLastUpSelectPosition = " + this.f17748l + " mLastDownSelectPosition = " + this.f17749m + " mDragMotionPosition = " + this.f17734aw);
                        }
                        if (this.f17700aB != -1) {
                            mo26157b(-1, this.f17700aB);
                            this.f17700aB = -1;
                        }
                        if (this.f17748l != -1) {
                            mo26157b(-1, this.f17748l);
                        }
                        if (!m19401n(y)) {
                            int lastPosition = getLastPosition();
                            if (this.f17749m != lastPosition) {
                                mo26157b(this.f17749m, lastPosition);
                            }
                            this.f17749m = -1;
                            this.f17748l = -1;
                            this.f17703aE = true;
                            return true;
                        }
                        mo26157b(this.f17749m, this.f17734aw);
                    }
                    return true;
                } else {
                    if (this.f17702aD == null) {
                        this.f17702aD = new C3234o();
                    }
                    if (!this.f17702aD.mo26279a()) {
                        if (y < getPaddingTop() + this.f17750n) {
                            z = true;
                        }
                        this.f17702aD.mo26278a(z);
                    }
                    return true;
                }
            } else {
                this.f17736ay = true;
                if (this.f17702aD != null) {
                    this.f17702aD.mo26280b();
                }
                return true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean m19401n(int i) {
        View o = m19402o(i);
        if (this.f17698a || this.f17721aj) {
            Log.i("MzRecyclerView", " onDragMotionChanged dragMotionView = " + o + " motionY = " + i);
        }
        if (o == null) {
            return false;
        }
        this.f17734aw = m19405q(o);
        this.f17732au = mo26154b(o);
        this.f17733av = mo26147a(o);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo26157b(int i, int i2) {
        RecyclerView.C3260a adapter = getAdapter();
        int firstPosition = getFirstPosition();
        for (int i3 = i == -1 ? i2 : i + 1; i3 <= i2; i3++) {
            if (adapter.mo23937g(i3)) {
                if (i3 != this.f17699aA) {
                    if (adapter == null || adapter.mo23936f(i3)) {
                        View c = mo26160c(i3 - firstPosition);
                        long c2 = adapter.mo20100c(i3);
                        if (this.f17730as != null) {
                            this.f17730as.mo26252a(c, i3, c2);
                        } else {
                            setItemChecked(i3, !mo26153a(i3));
                            performHapticFeedback(31016);
                        }
                        this.f17749m = i3;
                        this.f17748l = -1;
                    }
                } else {
                    return;
                }
            }
            this.f17699aA = -1;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo26162c(int i, int i2) {
        RecyclerView.C3260a adapter = getAdapter();
        int firstPosition = getFirstPosition();
        for (int i3 = i == -1 ? i2 : i - 1; i3 >= i2; i3--) {
            if (adapter.mo23937g(i3)) {
                if (i3 != this.f17699aA) {
                    if (adapter == null || adapter.mo23936f(i3)) {
                        View c = mo26160c(i3 - firstPosition);
                        long c2 = adapter.mo20100c(i3);
                        if (this.f17730as != null) {
                            this.f17730as.mo26252a(c, i3, c2);
                        } else {
                            setItemChecked(i3, !mo26153a(i3));
                            performHapticFeedback(31016);
                        }
                        this.f17748l = i3;
                        this.f17749m = -1;
                    }
                } else {
                    return;
                }
            }
            this.f17699aA = -1;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo26155b(boolean z) {
        int childCountExt = getChildCountExt();
        int firstPosition = getFirstPosition();
        if (z) {
            for (int i = 0; i < childCountExt; i++) {
                View c = mo26160c(i);
                if (mo26147a(c) - (mo26159c(c) / 2) > getPaddingTop()) {
                    return firstPosition + i;
                }
            }
            return -1;
        }
        for (int i2 = childCountExt - 1; i2 >= 0; i2--) {
            View c2 = mo26160c(i2);
            if (mo26154b(c2) + (mo26159c(c2) / 2) < getHeight() - getPaddingBottom()) {
                return firstPosition + i2;
            }
        }
        return -1;
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$o */
    final class C3234o implements Runnable {

        /* renamed from: b */
        private boolean f17812b = true;

        /* renamed from: c */
        private boolean f17813c = false;

        C3234o() {
        }

        /* renamed from: a */
        public void mo26278a(boolean z) {
            this.f17812b = z;
            this.f17813c = true;
            MzRecyclerView.this.post(this);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x008e, code lost:
            if (r7.f17811a.getFirstPosition() == 0) goto L_0x00cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00cb, code lost:
            if ((r7.f17811a.getFirstPosition() + flyme.support.p093v7.widget.MzRecyclerView.m19406q(r7.f17811a)) == flyme.support.p093v7.widget.MzRecyclerView.m19407r(r7.f17811a)) goto L_0x00cf;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.p093v7.widget.MzRecyclerView.this
                boolean r0 = r0.f17698a
                r1 = 0
                r2 = -10
                if (r0 != 0) goto L_0x0013
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.p093v7.widget.MzRecyclerView.this
                boolean r0 = r0.f17721aj
                if (r0 == 0) goto L_0x005c
            L_0x0013:
                java.lang.String r0 = "MzRecyclerView"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "startScroll 1 run mUpSelect = "
                r3.append(r4)
                boolean r4 = r7.f17812b
                r3.append(r4)
                java.lang.String r4 = " atEnd = "
                r3.append(r4)
                r3.append(r1)
                java.lang.String r4 = " speed = "
                r3.append(r4)
                r3.append(r2)
                java.lang.String r4 = " firstposition = "
                r3.append(r4)
                flyme.support.v7.widget.MzRecyclerView r4 = flyme.support.p093v7.widget.MzRecyclerView.this
                int r4 = r4.getFirstPosition()
                r3.append(r4)
                java.lang.String r4 = " mIsBeginDragSelect = "
                r3.append(r4)
                flyme.support.v7.widget.MzRecyclerView r4 = flyme.support.p093v7.widget.MzRecyclerView.this
                boolean r4 = r4.f17731at
                r3.append(r4)
                java.lang.String r4 = " ***********"
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                android.util.Log.i(r0, r3)
            L_0x005c:
                boolean r0 = r7.f17812b
                r3 = -1
                r4 = 0
                r5 = 1
                if (r0 == 0) goto L_0x0091
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.p093v7.widget.MzRecyclerView.this
                boolean r0 = r0.mo26378a((int) r1, (int) r2, (android.view.MotionEvent) r4)
                flyme.support.v7.widget.MzRecyclerView r4 = flyme.support.p093v7.widget.MzRecyclerView.this
                r4.m19379b((int) r2, (boolean) r1)
                flyme.support.v7.widget.MzRecyclerView r4 = flyme.support.p093v7.widget.MzRecyclerView.this
                int r4 = r4.mo26155b((boolean) r5)
                if (r4 != r3) goto L_0x0077
                r1 = 1
            L_0x0077:
                flyme.support.v7.widget.MzRecyclerView r3 = flyme.support.p093v7.widget.MzRecyclerView.this
                int r3 = r3.f17748l
                if (r3 == r4) goto L_0x0086
                flyme.support.v7.widget.MzRecyclerView r3 = flyme.support.p093v7.widget.MzRecyclerView.this
                flyme.support.v7.widget.MzRecyclerView r6 = flyme.support.p093v7.widget.MzRecyclerView.this
                int r6 = r6.f17748l
                r3.mo26162c((int) r6, (int) r4)
            L_0x0086:
                if (r0 != 0) goto L_0x00ce
                flyme.support.v7.widget.MzRecyclerView r3 = flyme.support.p093v7.widget.MzRecyclerView.this
                int r3 = r3.getFirstPosition()
                if (r3 != 0) goto L_0x00ce
                goto L_0x00cf
            L_0x0091:
                r2 = 10
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.p093v7.widget.MzRecyclerView.this
                boolean r0 = r0.mo26378a((int) r1, (int) r2, (android.view.MotionEvent) r4)
                flyme.support.v7.widget.MzRecyclerView r4 = flyme.support.p093v7.widget.MzRecyclerView.this
                r4.m19379b((int) r2, (boolean) r1)
                flyme.support.v7.widget.MzRecyclerView r4 = flyme.support.p093v7.widget.MzRecyclerView.this
                int r4 = r4.mo26155b((boolean) r1)
                if (r4 != r3) goto L_0x00a7
                r1 = 1
            L_0x00a7:
                flyme.support.v7.widget.MzRecyclerView r3 = flyme.support.p093v7.widget.MzRecyclerView.this
                int r3 = r3.f17749m
                if (r3 == r4) goto L_0x00b6
                flyme.support.v7.widget.MzRecyclerView r3 = flyme.support.p093v7.widget.MzRecyclerView.this
                flyme.support.v7.widget.MzRecyclerView r6 = flyme.support.p093v7.widget.MzRecyclerView.this
                int r6 = r6.f17749m
                r3.mo26157b((int) r6, (int) r4)
            L_0x00b6:
                if (r0 != 0) goto L_0x00ce
                flyme.support.v7.widget.MzRecyclerView r3 = flyme.support.p093v7.widget.MzRecyclerView.this
                int r3 = r3.getFirstPosition()
                flyme.support.v7.widget.MzRecyclerView r4 = flyme.support.p093v7.widget.MzRecyclerView.this
                int r4 = r4.getChildCountExt()
                int r3 = r3 + r4
                flyme.support.v7.widget.MzRecyclerView r4 = flyme.support.p093v7.widget.MzRecyclerView.this
                int r4 = r4.getItemCount()
                if (r3 != r4) goto L_0x00ce
                goto L_0x00cf
            L_0x00ce:
                r5 = r1
            L_0x00cf:
                flyme.support.v7.widget.MzRecyclerView r1 = flyme.support.p093v7.widget.MzRecyclerView.this
                boolean r1 = r1.f17698a
                if (r1 != 0) goto L_0x00df
                flyme.support.v7.widget.MzRecyclerView r1 = flyme.support.p093v7.widget.MzRecyclerView.this
                boolean r1 = r1.f17721aj
                if (r1 == 0) goto L_0x0122
            L_0x00df:
                java.lang.String r1 = "MzRecyclerView"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "startScroll 2 run mUpSelect = "
                r3.append(r4)
                boolean r4 = r7.f17812b
                r3.append(r4)
                java.lang.String r4 = " moved = "
                r3.append(r4)
                r3.append(r0)
                java.lang.String r0 = " atEnd = "
                r3.append(r0)
                r3.append(r5)
                java.lang.String r0 = " speed = "
                r3.append(r0)
                r3.append(r2)
                java.lang.String r0 = " firstposition = "
                r3.append(r0)
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.p093v7.widget.MzRecyclerView.this
                int r0 = r0.getFirstPosition()
                r3.append(r0)
                java.lang.String r0 = " &&&&&&&&&&&&"
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                android.util.Log.i(r1, r0)
            L_0x0122:
                if (r5 != 0) goto L_0x012b
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.p093v7.widget.MzRecyclerView.this
                r1 = 10
                r0.postDelayed(r7, r1)
            L_0x012b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.MzRecyclerView.C3234o.run():void");
        }

        /* renamed from: a */
        public boolean mo26279a() {
            return this.f17813c;
        }

        /* renamed from: b */
        public void mo26280b() {
            this.f17813c = false;
            MzRecyclerView.this.removeCallbacks(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public void m19363R() {
        this.f17735ax = -1;
        this.f17737az = -1;
        this.f17731at = false;
        this.f17736ay = false;
        this.f17700aB = -1;
        this.f17749m = -1;
        this.f17748l = -1;
        this.f17734aw = -1;
        this.f17703aE = false;
        if (this.f17702aD != null) {
            this.f17702aD.mo26280b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo26158b(int i) {
        int childCountExt = getChildCountExt();
        if (childCountExt <= 0) {
            return false;
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        View c = mo26160c(0);
        int q = m19405q(c);
        boolean z = q == 0 && c.getTop() >= getPaddingTop();
        boolean z2 = i < paddingTop + this.f17750n;
        if (z && z2) {
            return false;
        }
        boolean z3 = q + childCountExt == getItemCount() && mo26160c(childCountExt - 1).getBottom() <= getHeight() - getPaddingBottom();
        boolean z4 = i > height - this.f17750n;
        if (z3 && z4) {
            return false;
        }
        if (z2 || z4) {
            return true;
        }
        return false;
    }

    public int getFirstPosition() {
        View c = mo26160c(0);
        if (c == null) {
            return -1;
        }
        return m19405q(c);
    }

    public int getLastPosition() {
        View c = mo26160c(getChildCountExt() - 1);
        if (c == null) {
            return -1;
        }
        return m19405q(c);
    }

    /* access modifiers changed from: private */
    public int getChildCountExt() {
        if (this.f17948D != null) {
            return this.f17948D.mo27087b();
        }
        return 0;
    }

    /* renamed from: c */
    public View mo26160c(int i) {
        if (this.f17948D != null) {
            return this.f17948D.mo27089b(i);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public int m19405q(View view) {
        if (view == null) {
            return -1;
        }
        return mo26428j(view);
    }

    public int getCount() {
        return getAdapter().mo20093a();
    }

    /* access modifiers changed from: private */
    public int getItemCount() {
        RecyclerView.C3260a adapter = getAdapter();
        if (adapter != null) {
            return adapter.mo20093a();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m19379b(int i, boolean z) {
        if (getChildCountExt() != 0) {
            if (z) {
                mo26429j(i);
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
        }
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$b */
    private class C3218b implements Runnable {

        /* renamed from: b */
        private OverScroller f17772b;

        /* renamed from: c */
        private int f17773c = 0;

        C3218b() {
            this.f17772b = new OverScroller(MzRecyclerView.this.getContext());
        }

        public void run() {
            OverScroller overScroller = this.f17772b;
            if (overScroller.computeScrollOffset()) {
                int currY = overScroller.getCurrY();
                int currY2 = overScroller.getCurrY() - this.f17773c;
                this.f17773c = currY;
                if (currY2 != 0) {
                    MzRecyclerView.this.m19379b(-currY2, true);
                }
                MzRecyclerView.this.invalidate();
                MzRecyclerView.this.postOnAnimation(this);
                return;
            }
            mo26235a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo26235a() {
            MzRecyclerView.this.f17738b = -1;
            MzRecyclerView.this.removeCallbacks(this);
            MzRecyclerView.this.setScrollState(0);
            this.f17772b.abortAnimation();
        }
    }

    /* renamed from: o */
    private View m19402o(int i) {
        for (int b = this.f17948D.mo27087b() - 1; b >= 0; b--) {
            View b2 = this.f17948D.mo27089b(b);
            float translationY = b2.getTranslationY();
            float f = (float) i;
            if (f >= ((float) mo26154b(b2)) + translationY && f <= ((float) mo26147a(b2)) + translationY) {
                return b2;
            }
        }
        return null;
    }

    /* renamed from: a */
    public int mo26147a(View view) {
        return getLayoutManager().mo26644k(view) + ((RecyclerView.C3270h) view.getLayoutParams()).bottomMargin;
    }

    /* renamed from: b */
    public int mo26154b(View view) {
        return getLayoutManager().mo26640i(view) - ((RecyclerView.C3270h) view.getLayoutParams()).topMargin;
    }

    /* renamed from: c */
    public int mo26159c(View view) {
        RecyclerView.C3266g layoutManager = getLayoutManager();
        RecyclerView.C3270h hVar = (RecyclerView.C3270h) view.getLayoutParams();
        return layoutManager.mo26635g(view) + hVar.topMargin + hVar.bottomMargin;
    }

    public void setCheckBoxIsAnimation(boolean z) {
        if (this.f17705aG != z) {
            this.f17705aG = z;
        }
    }

    public void setItenFilter(C3220d dVar) {
        this.f17726ao = dVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f17752p == null) {
            m19364S();
        }
        super.onMeasure(i, i2);
    }

    /* renamed from: S */
    private void m19364S() {
        setSelector(getResources().getDrawable(R.drawable.mz_recyclerview_selector));
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.f17751o = z;
    }

    public void setSelector(int i) {
        setSelector(getResources().getDrawable(i));
    }

    public void setSelector(Drawable drawable) {
        if (this.f17752p != null) {
            this.f17752p.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f17752p);
        }
        this.f17752p = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.f17755s = rect.left;
        this.f17756t = rect.top;
        this.f17757u = rect.right;
        this.f17758v = rect.bottom;
        drawable.setCallback(this);
        mo26172g();
        if (this.f17709aK) {
            m19371a(this.f17752p);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo26172g() {
        if (this.f17752p == null) {
            return;
        }
        if (mo26185h()) {
            this.f17752p.setState(getDrawableState());
        } else {
            this.f17752p.setState(StateSet.NOTHING);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        mo26172g();
    }

    public boolean verifyDrawable(Drawable drawable) {
        return this.f17752p == drawable || super.verifyDrawable(drawable);
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f17752p != null) {
            this.f17752p.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo26185h() {
        return (isFocused() && !isInTouchMode()) || isPressed();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo26150a(Canvas canvas) {
        if (!this.f17753q.isEmpty()) {
            Drawable drawable = this.f17752p;
            drawable.setBounds(this.f17753q);
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo26149a(int i, View view) {
        boolean z = i != this.f17754r;
        if (i != -1) {
            this.f17754r = i;
        }
        Rect rect = this.f17753q;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof C3235p) {
            ((C3235p) view).mo26282a(rect);
        }
        rect.left -= this.f17755s;
        rect.top -= this.f17756t;
        rect.right += this.f17757u;
        rect.bottom += this.f17758v;
        Drawable drawable = this.f17752p;
        if (drawable != null) {
            if (z) {
                drawable.setVisible(false, false);
                drawable.setState(StateSet.NOTHING);
            }
            drawable.setBounds(rect);
            if (z) {
                if (getVisibility() == 0) {
                    drawable.setVisible(true, false);
                }
                mo26172g();
            }
        }
        refreshDrawableState();
    }

    public boolean dispatchStatusBarTap() {
        return mo26186i();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public boolean mo26186i() {
        View childAt;
        if (getItemCount() == 0) {
            return false;
        }
        int firstPosition = getFirstPosition();
        if ((firstPosition == 0 && (childAt = getChildAt(0)) != null && childAt.getTop() >= getPaddingTop()) || getItemCount() == Integer.MAX_VALUE) {
            return false;
        }
        if (this.f17704aF != null) {
            this.f17704aF.mo26235a();
            this.f17704aF = null;
        }
        if (firstPosition > getChildCount() * 2) {
            mo26396e(getChildCount() * 2);
        }
        mo26403g(0);
        return true;
    }

    public void setPinnedHeaderDecoration(RecyclerPinnedHeaderDecoration cVar) {
        this.f17725an = cVar;
    }

    public void setEnableHoldPress(boolean z) {
        this.f17709aK = z;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f17709aK && Build.VERSION.SDK_INT < 24) {
            setDrawDuringWindowsAnimating(this, true);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.f17709aK && this.f17707aI != null && this.f17707aI.f17774a != null) {
            if (this.f17710aL) {
                this.f17707aI.f17774a.setHovered(true);
                this.f17710aL = false;
            }
            this.f17707aI.f17774a.setHovered(false);
            this.f17707aI.f17774a = null;
            this.f17707aI.f17776c = -1;
            this.f17707aI.f17775b = -1;
        }
    }

    public void setDrawDuringWindowsAnimating(View view, boolean z) {
        try {
            Object invoke = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]).invoke(view, new Object[0]);
            Method declaredMethod = invoke.getClass().getDeclaredMethod("setDrawDuringWindowsAnimating", new Class[]{Boolean.TYPE});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(invoke, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m19371a(Drawable drawable) {
        this.f17708aJ = null;
        if ((drawable == null || !(drawable instanceof StateListDrawable)) && drawable != null && (drawable instanceof RippleDrawable)) {
            this.f17708aJ = new StateListDrawable();
            this.f17708aJ.addState(new int[]{16843623}, new ColorDrawable(167772160));
            this.f17708aJ.addState(new int[0], new ColorDrawable(0));
            this.f17708aJ.setExitFadeDuration(400);
        }
    }

    private void setHoldViewBackground(View view) {
        if (view.getBackground() == null && this.f17708aJ != null) {
            view.setBackground(this.f17708aJ.getConstantState().newDrawable());
        }
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$c */
    class C3219c {

        /* renamed from: a */
        View f17774a;

        /* renamed from: b */
        int f17775b;

        /* renamed from: c */
        long f17776c;

        public C3219c(View view, int i, long j) {
            this.f17774a = view;
            this.f17775b = i;
            this.f17776c = j;
        }
    }

    /* renamed from: T */
    private void m19365T() {
        RecyclerView.C3260a adapter = getAdapter();
        if (adapter.mo23933d() && this.f17707aI != null && this.f17707aI.f17775b != -1) {
            long j = this.f17707aI.f17776c;
            int i = this.f17707aI.f17775b;
            if (j != adapter.mo20100c(i)) {
                if (this.f17707aI.f17774a != null) {
                    this.f17707aI.f17774a.setHovered(false);
                    m19408r(this.f17707aI.f17774a);
                }
                this.f17707aI.f17774a = null;
                this.f17707aI.f17775b = -1;
                int min = Math.min(i + 20, adapter.mo20093a());
                for (int max = Math.max(0, i - 20); max < min; max++) {
                    if (j == adapter.mo20100c(max)) {
                        RecyclerView.C3286u a = mo26366a(j);
                        if (a != null) {
                            this.f17707aI.f17775b = max;
                            this.f17707aI.f17774a = a.f18121j;
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: r */
    private void m19408r(View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            background.jumpToCurrentState();
        }
    }

    public void setEnableParallax(boolean z) {
        if (z) {
            if (this.f17714aP == null) {
                this.f17714aP = new C3231n();
            }
            if (this.f17717aT == null) {
                this.f17717aT = new HashSet<>();
            }
        }
        this.f17711aM = z;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f17711aM) {
            this.f17712aN = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.f17713aO = this.f17712aN;
                    this.f17716aS = 0.0f;
                    this.f17714aP.mo26274c();
                    if (this.f17714aP.mo26273b()) {
                        this.f17714aP.mo26271a(false);
                        if (this.f17715aQ != null) {
                            this.f17715aQ.mo26255a(1, getViewHoldSet());
                            break;
                        }
                    }
                    break;
                case 1:
                case 3:
                    if (this.f17716aS != f17696aR) {
                        this.f17714aP.mo26267a();
                        break;
                    }
                    break;
                case 2:
                    if (this.f17716aS != f17696aR) {
                        if (canScrollVertically(1) && this.f17713aO - this.f17712aN > 15.0f) {
                            this.f17716aS += this.f17713aO - this.f17712aN;
                        } else if (canScrollVertically(-1) && this.f17713aO - this.f17712aN < -15.0f) {
                            this.f17716aS += this.f17713aO - this.f17712aN;
                        }
                        this.f17714aP.mo26268a(this.f17716aS);
                        break;
                    }
                    break;
            }
            this.f17713aO = this.f17712aN;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: d */
    public void mo26164d(int i, int i2) {
        if (this.f17711aM && !this.f17714aP.mo26273b() && this.f17715aQ != null) {
            this.f17715aQ.mo26254a(2, i, i2, getViewHoldSet());
        }
        super.mo26164d(i, i2);
    }

    public HashSet getViewHoldSet() {
        return this.f17717aT;
    }

    public void setSmoothBackInterpolator(TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null && this.f17714aP != null) {
            this.f17714aP.mo26270a(timeInterpolator);
        }
    }

    public void setBaseDuration(int i) {
        if (this.f17714aP != null) {
            this.f17714aP.mo26272b(i);
        }
    }

    public void setScrollSensitivity(int i) {
        if (this.f17714aP != null) {
            this.f17714aP.mo26269a(i);
        }
    }

    public void setParallaxAnimationListener(C3229l lVar) {
        this.f17715aQ = lVar;
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$n */
    class C3231n {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public HashMap<View, C3230m> f17799b = new HashMap<>();

        /* renamed from: c */
        private ArrayList<C3230m> f17800c = new ArrayList<>();

        /* renamed from: d */
        private TimeInterpolator f17801d = new LinearInterpolator();

        /* renamed from: e */
        private int f17802e = 500;

        /* renamed from: f */
        private ValueAnimator f17803f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public int f17804g = 3;

        /* renamed from: h */
        private float f17805h = 0.0f;

        /* renamed from: i */
        private int f17806i = 5;

        /* renamed from: j */
        private int f17807j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public boolean f17808k = true;

        C3231n() {
        }

        /* renamed from: a */
        public void mo26268a(float f) {
            if (f != 0.0f || this.f17804g != 3) {
                this.f17804g = 3;
                this.f17805h = 0.0f;
                for (C3230m next : this.f17799b.values()) {
                    float a = m19477a(next, f);
                    if (a > 0.0f) {
                        this.f17804g = 1;
                        this.f17805h = Math.abs(a / next.mo26260c());
                    } else if (a < 0.0f) {
                        this.f17804g = 2;
                        this.f17805h = Math.abs(a / next.mo26262d());
                    }
                    next.mo26257a(a);
                }
            }
        }

        /* renamed from: a */
        private float m19477a(C3230m mVar, float f) {
            float c;
            float a;
            float f2 = 0.0f;
            int i = (mVar.mo26266g() > 0.0f ? 1 : (mVar.mo26266g() == 0.0f ? 0 : -1));
            if (i == 0) {
                if (f > 0.0f) {
                    if (mVar.mo26260c() == 0.0f) {
                        return 0.0f;
                    }
                    float f3 = mVar.mo26265f();
                    if (f3 < 0.0f) {
                        f3 *= Math.abs(mVar.mo26260c() / mVar.mo26262d());
                    }
                    a = f3 + (mVar.mo26258b() * (f / ((float) this.f17806i)));
                    if (a > mVar.mo26260c()) {
                        c = mVar.mo26260c();
                    }
                } else if (mVar.mo26262d() == 0.0f) {
                    return 0.0f;
                } else {
                    float f4 = mVar.mo26265f();
                    if (f4 > 0.0f) {
                        f4 *= Math.abs(mVar.mo26262d() / mVar.mo26260c());
                    }
                    a = f4 + (mVar.mo26256a() * (f / ((float) this.f17806i)));
                    if (a < mVar.mo26262d()) {
                        c = mVar.mo26262d();
                    }
                }
                return a;
            } else if (i > 0) {
                if (mVar.mo26260c() == 0.0f) {
                    return 0.0f;
                }
                float f5 = mVar.mo26265f();
                if (f5 < 0.0f) {
                    f5 *= Math.abs(mVar.mo26260c() / mVar.mo26262d());
                }
                float b = f5 + (mVar.mo26258b() * (f / ((float) this.f17806i)));
                if (b < 0.0f) {
                    b = 0.0f;
                }
                if (b <= mVar.mo26260c()) {
                    return b;
                }
                c = mVar.mo26260c();
            } else if (mVar.mo26262d() == 0.0f) {
                return 0.0f;
            } else {
                float f6 = mVar.mo26265f();
                if (f6 > 0.0f) {
                    f6 *= Math.abs(mVar.mo26262d() / mVar.mo26260c());
                }
                float a2 = f6 + (mVar.mo26256a() * (f / ((float) this.f17806i)));
                if (a2 <= 0.0f) {
                    f2 = a2;
                }
                return f2 < mVar.mo26262d() ? mVar.mo26262d() : f2;
            }
            return c;
        }

        /* renamed from: a */
        public void mo26267a() {
            if (this.f17804g == 3) {
                mo26275d();
                this.f17808k = true;
                if (MzRecyclerView.this.f17715aQ != null) {
                    MzRecyclerView.this.f17715aQ.mo26255a(3, MzRecyclerView.this.getViewHoldSet());
                    return;
                }
                return;
            }
            this.f17807j = (int) (((float) this.f17802e) * this.f17805h);
            for (C3230m next : this.f17799b.values()) {
                next.mo26259b(next.mo26266g());
            }
            this.f17803f = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            this.f17803f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    for (C3230m mVar : C3231n.this.f17799b.values()) {
                        mVar.mo26257a(((Float) valueAnimator.getAnimatedValue()).floatValue() * mVar.mo26264e());
                    }
                }
            });
            this.f17803f.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = C3231n.this.f17808k = true;
                    for (C3230m mVar : C3231n.this.f17799b.values()) {
                        mVar.mo26261c(mVar.mo26266g());
                        if (mVar.mo26266g() != 0.0f) {
                            boolean unused2 = C3231n.this.f17808k = false;
                        } else {
                            mVar.mo26263d(MzRecyclerView.f17696aR);
                        }
                    }
                    if (C3231n.this.f17808k) {
                        int unused3 = C3231n.this.f17804g = 3;
                    }
                    if (C3231n.this.f17808k && MzRecyclerView.this.f17715aQ != null) {
                        MzRecyclerView.this.f17715aQ.mo26255a(3, MzRecyclerView.this.getViewHoldSet());
                    }
                }
            });
            this.f17803f.setDuration((long) this.f17807j);
            this.f17803f.setInterpolator(this.f17801d);
            this.f17803f.start();
        }

        /* renamed from: b */
        public boolean mo26273b() {
            return this.f17808k;
        }

        /* renamed from: a */
        public void mo26271a(boolean z) {
            this.f17808k = z;
        }

        /* renamed from: c */
        public void mo26274c() {
            if (this.f17803f != null && this.f17803f.isRunning()) {
                this.f17803f.cancel();
            }
        }

        /* renamed from: a */
        public void mo26269a(int i) {
            this.f17806i = i;
        }

        /* renamed from: a */
        public void mo26270a(TimeInterpolator timeInterpolator) {
            this.f17801d = timeInterpolator;
        }

        /* renamed from: b */
        public void mo26272b(int i) {
            this.f17802e = i;
        }

        /* renamed from: d */
        public void mo26275d() {
            for (C3230m d : this.f17799b.values()) {
                d.mo26263d(MzRecyclerView.f17696aR);
            }
        }
    }

    /* renamed from: flyme.support.v7.widget.MzRecyclerView$m */
    class C3230m {

        /* renamed from: a */
        private View f17789a;

        /* renamed from: b */
        private float f17790b;

        /* renamed from: c */
        private float f17791c;

        /* renamed from: d */
        private float f17792d;

        /* renamed from: e */
        private float f17793e;

        /* renamed from: f */
        private float f17794f;

        /* renamed from: g */
        private float f17795g;

        /* renamed from: h */
        private float f17796h;

        /* renamed from: i */
        private float f17797i;

        /* renamed from: a */
        public float mo26256a() {
            return this.f17790b;
        }

        /* renamed from: b */
        public float mo26258b() {
            return this.f17791c;
        }

        /* renamed from: a */
        public void mo26257a(float f) {
            if (this.f17789a != null) {
                if (this.f17797i == MzRecyclerView.f17696aR) {
                    this.f17797i = this.f17789a.getTranslationY();
                }
                this.f17796h = f;
                if (this.f17789a instanceof ScrollView) {
                    this.f17789a.scrollBy(0, (int) f);
                } else {
                    this.f17789a.setTranslationY(this.f17797i + f);
                }
            }
        }

        /* renamed from: c */
        public float mo26260c() {
            return this.f17792d;
        }

        /* renamed from: d */
        public float mo26262d() {
            return this.f17793e;
        }

        /* renamed from: b */
        public void mo26259b(float f) {
            this.f17794f = f;
        }

        /* renamed from: c */
        public void mo26261c(float f) {
            this.f17795g = f;
        }

        /* renamed from: e */
        public float mo26264e() {
            return this.f17794f;
        }

        /* renamed from: f */
        public float mo26265f() {
            return this.f17795g;
        }

        /* renamed from: g */
        public float mo26266g() {
            return this.f17796h;
        }

        /* renamed from: d */
        public void mo26263d(float f) {
            this.f17797i = f;
        }
    }

    public int getHeaderViewsCount() {
        if (this.f17954J == null || !(this.f17954J instanceof HeaderAndFooterWrapperAdapter)) {
            return 0;
        }
        return ((HeaderAndFooterWrapperAdapter) this.f17954J).mo27190b();
    }

    public int getFooterViewsCount() {
        if (this.f17954J == null || !(this.f17954J instanceof HeaderAndFooterWrapperAdapter)) {
            return 0;
        }
        return ((HeaderAndFooterWrapperAdapter) this.f17954J).mo27193c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo26165d(int i) {
        return i >= 0 && (i < getHeaderViewsCount() || i >= getItemCount() - getFooterViewsCount());
    }
}
