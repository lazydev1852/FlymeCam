package com.meizu.common.widget;

import android.content.ClipData;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Checkable;
import android.widget.SpinnerAdapter;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.meizu.common.R;

public class EnhanceGallery extends AbsSpinner implements GestureDetector.OnGestureListener {

    /* renamed from: E */
    C1423g f5111E;

    /* renamed from: F */
    LongSparseArray<Integer> f5112F;

    /* renamed from: G */
    int f5113G;

    /* renamed from: H */
    int f5114H;

    /* renamed from: I */
    protected int f5115I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public int f5116J;

    /* renamed from: K */
    private int f5117K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public int f5118L;

    /* renamed from: M */
    private int f5119M;

    /* renamed from: N */
    private GestureDetector f5120N;

    /* renamed from: O */
    private int f5121O;

    /* renamed from: P */
    private View f5122P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public C1419c f5123Q;

    /* renamed from: R */
    private Runnable f5124R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public boolean f5125S;

    /* renamed from: T */
    private View f5126T;

    /* renamed from: U */
    private boolean f5127U;

    /* renamed from: V */
    private boolean f5128V;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public boolean f5129W;

    /* renamed from: aA */
    private C1426j f5130aA;

    /* renamed from: aB */
    private boolean f5131aB;

    /* renamed from: aC */
    private C1424h f5132aC;
    /* access modifiers changed from: private */

    /* renamed from: aD */
    public int f5133aD;

    /* renamed from: aa */
    private boolean f5134aa;

    /* renamed from: ab */
    private C1417a f5135ab;

    /* renamed from: ac */
    private boolean f5136ac;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public boolean f5137ad;
    /* access modifiers changed from: private */

    /* renamed from: ae */
    public int f5138ae;

    /* renamed from: af */
    private int f5139af;

    /* renamed from: ag */
    private int f5140ag;

    /* renamed from: ah */
    private int f5141ah;

    /* renamed from: ai */
    private int f5142ai;

    /* renamed from: aj */
    private int f5143aj;

    /* renamed from: ak */
    private boolean f5144ak;

    /* renamed from: al */
    private int f5145al;
    /* access modifiers changed from: private */

    /* renamed from: am */
    public int f5146am;

    /* renamed from: an */
    private int f5147an;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public ActionMode f5148ao;

    /* renamed from: ap */
    private SparseBooleanArray f5149ap;

    /* renamed from: aq */
    private C1421e f5150aq;
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public boolean f5151ar;
    /* access modifiers changed from: private */

    /* renamed from: as */
    public int f5152as;
    /* access modifiers changed from: private */

    /* renamed from: at */
    public int f5153at;
    /* access modifiers changed from: private */

    /* renamed from: au */
    public int f5154au;
    /* access modifiers changed from: private */

    /* renamed from: av */
    public int f5155av;
    /* access modifiers changed from: private */

    /* renamed from: aw */
    public int f5156aw;
    /* access modifiers changed from: private */

    /* renamed from: ax */
    public int f5157ax;

    /* renamed from: ay */
    private Rect f5158ay;

    /* renamed from: az */
    private C1425i f5159az;

    /* renamed from: com.meizu.common.widget.EnhanceGallery$b */
    public interface C1418b {
        /* renamed from: a */
        View mo16542a();

        /* renamed from: b */
        boolean mo16543b();

        /* renamed from: c */
        Point mo16544c();
    }

    /* renamed from: com.meizu.common.widget.EnhanceGallery$f */
    public interface C1422f extends ActionMode.Callback {
        /* renamed from: a */
        void mo16551a(ActionMode actionMode, int i, long j, boolean z);
    }

    /* renamed from: com.meizu.common.widget.EnhanceGallery$h */
    public interface C1424h {
        /* renamed from: a */
        void mo16558a(EnhanceGallery enhanceGallery, int i);

        /* renamed from: a */
        void mo16559a(EnhanceGallery enhanceGallery, int i, int i2, int i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo16490a(ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        return false;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollExtent() {
        return 1;
    }

    public void dispatchSetSelected(boolean z) {
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public EnhanceGallery(Context context) {
        this(context, (AttributeSet) null);
    }

    public EnhanceGallery(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_EnhanceGalleryStyle);
    }

    public EnhanceGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5116J = -1;
        this.f5117K = 0;
        this.f5118L = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.f5123Q = new C1419c();
        this.f5124R = new Runnable() {
            public void run() {
                boolean unused = EnhanceGallery.this.f5129W = false;
                EnhanceGallery.this.mo16078e();
            }
        };
        this.f5127U = true;
        this.f5128V = true;
        this.f5134aa = false;
        this.f5137ad = false;
        this.f5144ak = false;
        this.f5146am = 0;
        this.f5151ar = false;
        this.f5152as = R.drawable.mz_list_selector_background_long_pressed;
        this.f5153at = R.drawable.mz_list_selector_background_filter;
        this.f5154au = R.drawable.mz_list_selector_background_delete;
        this.f5155av = 0;
        this.f5115I = -1;
        this.f5156aw = 0;
        this.f5157ax = 0;
        this.f5131aB = false;
        this.f5133aD = 0;
        this.f5120N = new GestureDetector(context, this);
        this.f5120N.setIsLongpressEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EnhanceGallery, i, 0);
        setSpacing(obtainStyledAttributes.getDimensionPixelSize(R.styleable.EnhanceGallery_mcSpacing, 10));
        this.f5140ag = getResources().getDimensionPixelSize(R.dimen.mc_enhancegallery_max_overscroll_distance);
        this.f5139af = obtainStyledAttributes.getDimensionPixelSize(R.styleable.EnhanceGallery_mcMaxOverScrollDistance, this.f5140ag);
        this.f5144ak = obtainStyledAttributes.getBoolean(R.styleable.EnhanceGallery_mcScrollEnableWhenLessContent, false);
        obtainStyledAttributes.recycle();
    }

    public void setCallbackDuringFling(boolean z) {
        this.f5127U = z;
    }

    public void setMaxOverScrollDistance(int i) {
        if (i < 0) {
            this.f5139af = this.f5140ag;
        } else {
            this.f5139af = i;
        }
    }

    public void setCallbackOnUnselectedItemClick(boolean z) {
        this.f5128V = z;
    }

    public void setDragEnable(boolean z) {
        this.f5134aa = z;
    }

    public void setAnimationDuration(int i) {
        this.f5118L = i;
    }

    public void setSpacing(int i) {
        this.f5117K = i;
    }

    public void setScrollEnableWhenLessContent(boolean z) {
        this.f5144ak = z;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollOffset() {
        return this.f4580x;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollRange() {
        return this.f4582z;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C1420d;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C1420d(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C1420d(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C1420d(-2, -2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f4573q = true;
        mo16040b(0, false);
        this.f4573q = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo16035a(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo16491b(int i) {
        boolean z;
        boolean z2;
        int childCount = getChildCount();
        if (childCount == 0 || i == 0) {
            return false;
        }
        boolean z3 = true;
        boolean z4 = i < 0;
        if (this.f5137ad) {
            z = this.f4566j == 0 && getChildAt(0).getRight() >= (getWidth() - getPaddingRight()) - this.f5117K && i <= 0;
            z2 = this.f4566j + childCount == this.f4582z && getChildAt(childCount - 1).getLeft() >= getPaddingLeft() && i >= 0;
        } else {
            boolean z5 = this.f4566j == 0 && getChildAt(0).getLeft() >= getPaddingLeft() + this.f5117K && i >= 0;
            z = this.f4566j + childCount == this.f4582z && getChildAt(childCount - 1).getRight() <= getWidth() - getPaddingRight() && i <= 0;
            z2 = z5;
        }
        boolean z6 = z2 || z;
        m5651e(i);
        if (!z6) {
            m5641a(z4);
            if (z4) {
                m5674w();
            } else {
                m5671t();
            }
            this.f4551i.mo16062a();
            m5668r();
        }
        this.f5138ae = 0;
        int childCount2 = getChildCount();
        if (this.f5137ad) {
            int right = getChildAt(0).getRight();
            int left = getChildAt(childCount2 - 1).getLeft();
            int width = (getWidth() - getPaddingRight()) - this.f5117K;
            if (this.f4566j == 0 && right < width) {
                this.f5138ae = width - right;
                mo16511l();
                onScrollChanged(0, 0, 0, 0);
                invalidate();
                return z3;
            } else if (this.f4566j + childCount2 == this.f4582z && left > getPaddingLeft()) {
                this.f5138ae = (getPaddingLeft() + this.f5117K) - left;
                mo16511l();
                onScrollChanged(0, 0, 0, 0);
                invalidate();
                return z3;
            }
        } else {
            int left2 = getChildAt(0).getLeft();
            int right2 = getChildAt(childCount2 - 1).getRight();
            int paddingLeft = getPaddingLeft() + this.f5117K;
            int width2 = getWidth() - getPaddingRight();
            if (this.f4566j == 0 && left2 > paddingLeft) {
                this.f5138ae = paddingLeft - left2;
                mo16511l();
                onScrollChanged(0, 0, 0, 0);
                invalidate();
                return z3;
            } else if (this.f4566j + childCount2 == this.f4582z && right2 < width2) {
                this.f5138ae = (width2 - right2) - this.f5117K;
                mo16511l();
                onScrollChanged(0, 0, 0, 0);
                invalidate();
                return z3;
            }
        }
        z3 = false;
        mo16511l();
        onScrollChanged(0, 0, 0, 0);
        invalidate();
        return z3;
    }

    /* renamed from: e */
    private void m5651e(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount).offsetLeftAndRight(i);
        }
    }

    private int getCenterOfEnhanceGallery() {
        return (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
    }

    /* renamed from: d */
    private static int m5648d(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        if (r11.f5137ad == false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a3, code lost:
        if (r11.f5137ad != false) goto L_0x00a7;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5641a(boolean r12) {
        /*
            r11 = this;
            int r0 = r11.getChildCount()
            int r1 = r11.f4566j
            r2 = 0
            r3 = 1
            if (r12 == 0) goto L_0x0053
            boolean r4 = r11.f5137ad
            if (r4 == 0) goto L_0x0013
            int r4 = r11.getPaddingLeft()
            goto L_0x001a
        L_0x0013:
            int r4 = r11.getPaddingLeft()
            int r5 = r11.f5117K
            int r4 = r4 + r5
        L_0x001a:
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x001d:
            int r8 = r0 + -1
            if (r5 >= r8) goto L_0x004e
            boolean r9 = r11.f5137ad
            if (r9 == 0) goto L_0x0027
            int r8 = r8 - r5
            goto L_0x0028
        L_0x0027:
            r8 = r5
        L_0x0028:
            boolean r9 = r11.f5137ad
            if (r9 == 0) goto L_0x0033
            int r9 = r8 + -1
        L_0x002e:
            android.view.View r9 = r11.getChildAt(r9)
            goto L_0x0036
        L_0x0033:
            int r9 = r8 + 1
            goto L_0x002e
        L_0x0036:
            int r9 = r9.getLeft()
            if (r9 <= r4) goto L_0x003d
            goto L_0x004e
        L_0x003d:
            int r7 = r7 + 1
            android.view.View r6 = r11.getChildAt(r8)
            com.meizu.common.widget.AbsSpinner$a r9 = r11.f4551i
            int r10 = r1 + r8
            r9.mo16063a(r10, r6)
            int r5 = r5 + 1
            r6 = r8
            goto L_0x001d
        L_0x004e:
            boolean r0 = r11.f5137ad
            if (r0 != 0) goto L_0x00a6
            goto L_0x00a7
        L_0x0053:
            boolean r4 = r11.f5137ad
            if (r4 == 0) goto L_0x0064
            int r4 = r11.getWidth()
            int r5 = r11.getPaddingRight()
            int r4 = r4 - r5
            int r5 = r11.f5117K
            int r4 = r4 - r5
            goto L_0x006d
        L_0x0064:
            int r4 = r11.getWidth()
            int r5 = r11.getPaddingRight()
            int r4 = r4 - r5
        L_0x006d:
            int r0 = r0 - r3
            r5 = r0
            r6 = 0
            r7 = 0
        L_0x0071:
            if (r5 < r3) goto L_0x00a1
            boolean r8 = r11.f5137ad
            if (r8 == 0) goto L_0x007a
            int r8 = r0 - r5
            goto L_0x007b
        L_0x007a:
            r8 = r5
        L_0x007b:
            boolean r9 = r11.f5137ad
            if (r9 == 0) goto L_0x0086
            int r9 = r8 + 1
        L_0x0081:
            android.view.View r9 = r11.getChildAt(r9)
            goto L_0x0089
        L_0x0086:
            int r9 = r8 + -1
            goto L_0x0081
        L_0x0089:
            int r9 = r9.getRight()
            if (r9 >= r4) goto L_0x0090
            goto L_0x00a1
        L_0x0090:
            int r7 = r7 + 1
            android.view.View r6 = r11.getChildAt(r8)
            com.meizu.common.widget.AbsSpinner$a r9 = r11.f4551i
            int r10 = r1 + r8
            r9.mo16063a(r10, r6)
            int r5 = r5 + -1
            r6 = r8
            goto L_0x0071
        L_0x00a1:
            boolean r0 = r11.f5137ad
            if (r0 == 0) goto L_0x00a6
            goto L_0x00a7
        L_0x00a6:
            r2 = r6
        L_0x00a7:
            r11.detachViewsFromParent(r2, r7)
            boolean r0 = r11.f5137ad
            if (r12 == r0) goto L_0x00b3
            int r12 = r11.f4566j
            int r12 = r12 + r7
            r11.f4566j = r12
        L_0x00b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.EnhanceGallery.m5641a(boolean):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e3  */
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m5664p() {
        /*
            r10 = this;
            int r0 = r10.getChildCount()
            r1 = 0
            if (r0 == 0) goto L_0x00f1
            android.view.View r2 = r10.f5126T
            if (r2 != 0) goto L_0x000d
            goto L_0x00f1
        L_0x000d:
            android.view.View r2 = r10.getChildAt(r1)
            int r3 = r0 + -1
            android.view.View r3 = r10.getChildAt(r3)
            boolean r4 = r10.f5137ad
            r5 = 1
            r6 = 2
            if (r4 == 0) goto L_0x0077
            int r4 = r10.getWidth()
            int r7 = r10.getPaddingRight()
            int r4 = r4 - r7
            int r7 = r10.f5117K
            int r4 = r4 - r7
            int r7 = r10.getPaddingLeft()
            int r8 = r10.f5116J
            if (r8 != r6) goto L_0x0043
            int r8 = r10.f4566j
            int r8 = r8 + r0
            int r9 = r10.f4582z
            if (r8 != r9) goto L_0x0043
            int r0 = r10.f5117K
            int r7 = r7 + r0
            int r0 = r3.getLeft()
            int r0 = r7 - r0
            goto L_0x00d4
        L_0x0043:
            int r8 = r2.getRight()
            if (r8 == r4) goto L_0x00d3
            int r8 = m5648d((android.view.View) r2)
            if (r8 < r4) goto L_0x0059
            android.view.View r2 = r10.getChildAt(r5)
            int r2 = r2.getRight()
            int r4 = r4 - r2
            goto L_0x005e
        L_0x0059:
            int r2 = r2.getRight()
            int r4 = r4 - r2
        L_0x005e:
            int r2 = r10.f4566j
            int r2 = r2 + r0
            int r0 = r10.f4582z
            if (r2 != r0) goto L_0x0075
            int r0 = r3.getLeft()
            int r0 = r0 + r4
            if (r0 <= r7) goto L_0x0075
            int r0 = r3.getLeft()
            int r7 = r7 - r0
            int r0 = r10.f5117K
            int r0 = r0 + r7
            goto L_0x00d4
        L_0x0075:
            r0 = r4
            goto L_0x00d4
        L_0x0077:
            int r4 = r10.getPaddingLeft()
            int r7 = r10.f5117K
            int r4 = r4 + r7
            int r7 = r10.getWidth()
            int r8 = r10.getPaddingRight()
            int r7 = r7 - r8
            int r8 = r10.f5116J
            if (r8 != r6) goto L_0x009c
            int r8 = r10.f4566j
            int r8 = r8 + r0
            int r9 = r10.f4582z
            if (r8 != r9) goto L_0x009c
            int r0 = r3.getRight()
            int r7 = r7 - r0
            int r0 = r10.f5117K
            int r0 = r7 - r0
            goto L_0x00d4
        L_0x009c:
            int r8 = r2.getLeft()
            if (r8 == r4) goto L_0x00d3
            int r8 = m5648d((android.view.View) r2)
            if (r8 >= r4) goto L_0x00b2
            android.view.View r2 = r10.getChildAt(r5)
            int r2 = r2.getLeft()
            int r4 = r4 - r2
            goto L_0x00b7
        L_0x00b2:
            int r2 = r2.getLeft()
            int r4 = r4 - r2
        L_0x00b7:
            int r2 = r10.f4566j
            int r2 = r2 + r0
            int r0 = r10.f4582z
            if (r2 != r0) goto L_0x0075
            int r0 = r3.getRight()
            int r0 = r0 + r4
            int r2 = r10.f5117K
            int r2 = r7 - r2
            if (r0 == r2) goto L_0x0075
            int r0 = r3.getRight()
            int r7 = r7 - r0
            int r0 = r10.f5117K
            int r0 = r7 - r0
            goto L_0x00d4
        L_0x00d3:
            r0 = 0
        L_0x00d4:
            if (r0 == 0) goto L_0x00e3
            int r1 = r10.f5133aD
            if (r1 == r6) goto L_0x00dd
            r10.mo16494c((int) r6)
        L_0x00dd:
            com.meizu.common.widget.EnhanceGallery$c r1 = r10.f5123Q
            r1.mo16546a((int) r0)
            goto L_0x00f0
        L_0x00e3:
            int r0 = r10.f5133aD
            if (r0 == 0) goto L_0x00ea
            r10.mo16494c((int) r1)
        L_0x00ea:
            r10.m5666q()
            r0 = -1
            r10.f5116J = r0
        L_0x00f0:
            return
        L_0x00f1:
            int r0 = r10.f5133aD
            if (r0 == 0) goto L_0x00f8
            r10.mo16494c((int) r1)
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.EnhanceGallery.m5664p():void");
    }

    /* renamed from: q */
    private void m5666q() {
        if (this.f5129W) {
            this.f5129W = false;
            super.mo16078e();
        }
        invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo16078e() {
        if (!this.f5129W) {
            super.mo16078e();
        }
    }

    /* renamed from: r */
    private void m5668r() {
        int i;
        if (this.f5126T != null && (i = this.f4566j) != this.f4580x) {
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            mo16080g();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        postDelayed(new Runnable() {
            public void run() {
                int i;
                View childAt = EnhanceGallery.this.getChildAt(EnhanceGallery.this.getChildCount() - 1);
                if (EnhanceGallery.this.f5137ad) {
                    if (childAt != null && childAt.getLeft() > EnhanceGallery.this.getPaddingLeft()) {
                        i = EnhanceGallery.this.getPaddingLeft() - childAt.getLeft();
                        int unused = EnhanceGallery.this.f5116J = -1;
                        if (!(EnhanceGallery.this.f5133aD == 2 || i == 0)) {
                            EnhanceGallery.this.mo16494c(2);
                        }
                        EnhanceGallery.this.f5123Q.mo16546a(i);
                    }
                } else if (childAt != null && childAt.getRight() < EnhanceGallery.this.getWidth() - EnhanceGallery.this.getPaddingRight()) {
                    i = (EnhanceGallery.this.getWidth() - EnhanceGallery.this.getPaddingRight()) - childAt.getRight();
                    int unused2 = EnhanceGallery.this.f5116J = -1;
                    EnhanceGallery.this.mo16494c(2);
                    EnhanceGallery.this.f5123Q.mo16546a(i);
                }
                i = 0;
                int unused3 = EnhanceGallery.this.f5116J = -1;
                EnhanceGallery.this.mo16494c(2);
                EnhanceGallery.this.f5123Q.mo16546a(i);
            }
        }, 200);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo16040b(int i, boolean z) {
        int i2;
        if (Build.VERSION.SDK_INT >= 17) {
            this.f5137ad = getLayoutDirection() == 1;
        }
        if (this.f4577u) {
            mo16079f();
        }
        if (this.f4577u && this.f5146am == 2 && this.f4543a != null && this.f4543a.hasStableIds()) {
            mo16514o();
        }
        if (this.f4582z == 0) {
            mo16511l();
            mo16036a();
            return;
        }
        if (this.f4578v >= 0) {
            setSelectedPositionInt(this.f4578v);
        }
        mo16039b();
        detachAllViewsFromParent();
        this.f4566j = this.f4580x;
        m5670s();
        this.f4551i.mo16062a();
        invalidate();
        mo16080g();
        this.f4577u = false;
        this.f4571o = false;
        setNextSelectedPositionInt(this.f4580x);
        m5634A();
        this.f5145al = 0;
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.f5141ah = childAt.getWidth();
            this.f5145al = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.f4582z * (this.f5141ah + this.f5117K));
            if (this.f5145al <= 0 || this.f5144ak) {
                if (this.f5145al <= 0) {
                    int childCount = getChildCount();
                    if (this.f5137ad) {
                        int paddingLeft = getPaddingLeft() + this.f5117K;
                        if (this.f4566j + childCount == this.f4582z) {
                            int i3 = childCount - 1;
                            if (!(getChildAt(i3).getLeft() == paddingLeft || this.f4578v == 0)) {
                                mo16491b(paddingLeft - getChildAt(i3).getLeft());
                                m5664p();
                            }
                        }
                    } else {
                        int width = (getWidth() - getPaddingRight()) - this.f5117K;
                        if (this.f4566j + childCount == this.f4582z) {
                            int i4 = childCount - 1;
                            if (!(getChildAt(i4).getRight() == width || this.f4578v == 0)) {
                                mo16491b(width - getChildAt(i4).getRight());
                                m5664p();
                            }
                        }
                    }
                }
            } else if (this.f4566j != 0 && this.f4580x < this.f4582z) {
                if (this.f5137ad) {
                    i2 = (-this.f4580x) * (this.f5141ah + this.f5117K);
                } else {
                    i2 = this.f4580x * (this.f5141ah + this.f5117K);
                }
                mo16491b(i2);
                m5664p();
            }
        }
        mo16511l();
    }

    /* renamed from: s */
    private void m5670s() {
        int i = this.f5117K;
        int paddingLeft = getPaddingLeft();
        int right = (getRight() - getLeft()) - getPaddingRight();
        int i2 = this.f4582z;
        if (this.f5137ad) {
            int i3 = this.f4566j;
            int i4 = right - this.f5117K;
            while (i4 > paddingLeft && i3 < i2) {
                i4 = m5639a(i3, i3 - this.f4580x, i4, false).getLeft() - i;
                i3++;
            }
            return;
        }
        int i5 = this.f4566j;
        int i6 = paddingLeft + i;
        while (i6 < right && i5 < i2) {
            i6 = m5639a(i5, i5 - this.f4580x, i6, true).getRight() + i;
            i5++;
        }
    }

    /* renamed from: t */
    private void m5671t() {
        if (this.f5137ad) {
            m5672u();
        } else {
            m5673v();
        }
    }

    /* renamed from: u */
    private void m5672u() {
        int i;
        int i2;
        int i3 = this.f5117K;
        int paddingLeft = getPaddingLeft();
        int childCount = getChildCount();
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i = this.f4566j + childCount;
            i2 = childAt.getLeft() - i3;
        } else {
            i = this.f4582z - 1;
            this.f4566j = i;
            i2 = (getRight() - getLeft()) - getPaddingRight();
            this.f5125S = true;
        }
        while (i2 > paddingLeft && i < this.f4582z) {
            i2 = m5639a(i, i - this.f4580x, i2, false).getLeft() - i3;
            i++;
        }
    }

    /* renamed from: v */
    private void m5673v() {
        int i;
        int i2;
        int i3 = this.f5117K;
        int paddingLeft = getPaddingLeft();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.f4566j - 1;
            i2 = childAt.getLeft() - i3;
        } else {
            i2 = (getRight() - getLeft()) - getPaddingRight();
            this.f5125S = true;
            i = 0;
        }
        while (i2 > paddingLeft && i >= 0) {
            View a = m5639a(i, i - this.f4580x, i2, false);
            this.f4566j = i;
            i2 = a.getLeft() - i3;
            i--;
        }
    }

    /* renamed from: w */
    private void m5674w() {
        if (this.f5137ad) {
            m5675x();
        } else {
            m5676y();
        }
    }

    /* renamed from: x */
    private void m5675x() {
        int i;
        int i2 = this.f5117K;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt != null) {
            i3 = this.f4566j - 1;
            i = childAt.getRight() + i2;
        } else {
            i = getPaddingLeft();
            this.f5125S = true;
        }
        while (i < right && i3 >= 0) {
            View a = m5639a(i3, i3 - this.f4580x, i, true);
            this.f4566j = i3;
            i = a.getRight() + i2;
            i3--;
        }
    }

    /* renamed from: y */
    private void m5676y() {
        int i;
        int i2;
        int i3 = this.f5117K;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i4 = this.f4582z;
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i = this.f4566j + childCount;
            i2 = childAt.getRight() + i3;
        } else {
            i = this.f4582z - 1;
            this.f4566j = i;
            i2 = getPaddingLeft();
            this.f5125S = true;
        }
        while (i2 < right && i < i4) {
            i2 = m5639a(i, i - this.f4580x, i2, true).getRight() + i3;
            i++;
        }
    }

    /* renamed from: a */
    private View m5639a(int i, int i2, int i3, boolean z) {
        View a;
        if (this.f4577u || (a = this.f4551i.mo16061a(i)) == null) {
            View view = this.f4543a.getView(i, (View) null, this);
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
                if (this.f5130aA == null) {
                    this.f5130aA = new C1426j();
                }
                if (view.getAccessibilityNodeProvider() == null) {
                    view.setAccessibilityDelegate(this.f5130aA);
                }
            }
            m5640a(view, i, i2, i3, z);
            return view;
        }
        if (!this.f5131aB) {
            if (a.getImportantForAccessibility() == 0) {
                a.setImportantForAccessibility(1);
            }
            if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
                if (this.f5130aA == null) {
                    this.f5130aA = new C1426j();
                }
                if (a.getAccessibilityNodeProvider() == null) {
                    a.setAccessibilityDelegate(this.f5130aA);
                }
            }
            this.f5131aB = true;
        }
        m5640a(a, i, i2, i3, z);
        return a;
    }

    /* renamed from: a */
    private void m5640a(View view, int i, int i2, int i3, boolean z) {
        C1420d dVar;
        int i4;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            dVar = (C1420d) generateDefaultLayoutParams();
        } else if (layoutParams instanceof C1420d) {
            dVar = (C1420d) layoutParams;
        } else {
            dVar = (C1420d) generateLayoutParams(layoutParams);
        }
        boolean z2 = false;
        addViewInLayout(view, z != this.f5137ad ? -1 : 0, dVar);
        if (this.f5146am == 1) {
            if (i2 == 0) {
                z2 = true;
            }
            view.setSelected(z2);
        }
        view.measure(ViewGroup.getChildMeasureSpec(this.f4545c, this.f4550h.left + this.f4550h.right, dVar.width), ViewGroup.getChildMeasureSpec(this.f4544b, this.f4550h.top + this.f4550h.bottom, dVar.height));
        int a = m5636a(view, true);
        int measuredHeight = view.getMeasuredHeight() + a;
        int measuredWidth = view.getMeasuredWidth();
        if (z) {
            i4 = i3 + measuredWidth;
        } else {
            i4 = i3;
            i3 -= measuredWidth;
        }
        view.layout(i3, a, i4, measuredHeight);
        if (!(this.f5146am == 0 || this.f5149ap == null)) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(this.f5149ap.get(i));
            } else if (getContext().getApplicationInfo().targetSdkVersion >= 11) {
                view.setActivated(this.f5149ap.get(i));
            }
        }
        if (this.f5146am == 2 && this.f5134aa) {
            view.setOnDragListener(new View.OnDragListener() {
                public boolean onDrag(View view, DragEvent dragEvent) {
                    if (EnhanceGallery.this.f5115I == -1) {
                        return false;
                    }
                    int action = dragEvent.getAction();
                    if (action != 100) {
                        switch (action) {
                            case 1:
                                return true;
                            case 2:
                                return true;
                            case 3:
                                return false;
                            case 4:
                                View childAt = EnhanceGallery.this.getChildAt(EnhanceGallery.this.f5115I - EnhanceGallery.this.f4566j);
                                if (childAt != null) {
                                    if (childAt instanceof C1418b) {
                                        View a = ((C1418b) childAt).mo16542a();
                                        if (a != null) {
                                            a.setAlpha(1.0f);
                                        }
                                        if (EnhanceGallery.this.f5151ar) {
                                            childAt.setAlpha(1.0f);
                                        }
                                    } else {
                                        childAt.setAlpha(1.0f);
                                    }
                                }
                                if (!dragEvent.getResult()) {
                                    EnhanceGallery.this.setItemChecked(EnhanceGallery.this.f5115I, true);
                                } else if (childAt != null) {
                                    View findViewById = childAt.findViewById(16908289);
                                    if (findViewById != null && (findViewById instanceof Checkable)) {
                                        ((Checkable) findViewById).setChecked(false);
                                    }
                                    EnhanceGallery.this.mo16513n();
                                }
                                EnhanceGallery.this.f5115I = -1;
                                if (EnhanceGallery.this.getCheckedItemCount() <= 0 && EnhanceGallery.this.f5148ao != null) {
                                    EnhanceGallery.this.f5148ao.finish();
                                    break;
                                }
                            case 5:
                                return true;
                            case 6:
                                return true;
                        }
                    } else {
                        View childAt2 = EnhanceGallery.this.getChildAt(EnhanceGallery.this.f5115I - EnhanceGallery.this.f4566j);
                        if (childAt2 != null) {
                            if (childAt2 instanceof C1418b) {
                                View a2 = ((C1418b) childAt2).mo16542a();
                                if (a2 != null) {
                                    a2.setAlpha(1.0f);
                                }
                                if (EnhanceGallery.this.f5151ar) {
                                    childAt2.setAlpha(1.0f);
                                }
                            } else {
                                childAt2.setAlpha(1.0f);
                            }
                            View findViewById2 = childAt2.findViewById(16908289);
                            if (findViewById2 != null && (findViewById2 instanceof Checkable)) {
                                ((Checkable) findViewById2).setChecked(false);
                            }
                        }
                        EnhanceGallery.this.requestLayout();
                        if (EnhanceGallery.this.getCheckedItemCount() <= 0 && EnhanceGallery.this.f5148ao != null) {
                            EnhanceGallery.this.f5148ao.finish();
                        }
                        EnhanceGallery.this.f5115I = -1;
                    }
                    return true;
                }
            });
        }
    }

    /* renamed from: a */
    private int m5636a(View view, boolean z) {
        int measuredHeight = z ? getMeasuredHeight() : getHeight();
        int measuredHeight2 = z ? view.getMeasuredHeight() : view.getHeight();
        int i = this.f5119M;
        if (i == 16) {
            return this.f4550h.top + ((((measuredHeight - this.f4550h.bottom) - this.f4550h.top) - measuredHeight2) / 2);
        } else if (i == 48) {
            return this.f4550h.top;
        } else {
            if (i != 80) {
                return 0;
            }
            return (measuredHeight - this.f4550h.bottom) - measuredHeight2;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f5120N.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            mo16509j();
        } else if (action == 3) {
            mo16510k();
        }
        return onTouchEvent;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.f5121O < 0 || this.f5146am == 0) {
            if (this.f5128V || this.f5121O == this.f4580x) {
                mo16065a(this.f5122P, this.f5121O, this.f4543a.getItemId(this.f5121O));
            }
            return true;
        }
        if (this.f5159az == null) {
            this.f5159az = new C1425i();
        }
        C1425i iVar = this.f5159az;
        iVar.f5183a = this.f5121O;
        iVar.mo16563a();
        post(iVar);
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        int i2;
        if (this.f5145al > 0 && !this.f5144ak) {
            return false;
        }
        if (!this.f5127U) {
            removeCallbacks(this.f5124R);
            if (!this.f5129W) {
                this.f5129W = true;
            }
        }
        int childCount = getChildCount();
        int i3 = this.f5116J;
        if (i3 != 1) {
            if (i3 == 3) {
                this.f5116J = 4;
            }
        } else if (Math.abs(f) < 1500.0f) {
            return false;
        } else {
            this.f5116J = 2;
            int floor = ((int) Math.floor((double) (((getWidth() - getPaddingLeft()) - getPaddingRight()) / (this.f5141ah + this.f5117K)))) * (this.f5141ah + this.f5117K);
            if (f > 0.0f) {
                if (this.f5137ad) {
                    View childAt = getChildAt(this.f5143aj - this.f4566j);
                    int width = (getWidth() - getPaddingRight()) - this.f5117K;
                    if (childAt != null) {
                        i = width - childAt.getRight();
                    } else {
                        i = width - getChildAt(getChildCount() - 1).getRight();
                    }
                } else {
                    View childAt2 = getChildAt(this.f5142ai - this.f4566j);
                    if (childAt2 != null) {
                        i = floor - ((childAt2.getLeft() - getPaddingLeft()) - this.f5117K);
                    } else {
                        i = ((getPaddingLeft() + this.f5117K) - getChildAt(0).getLeft()) + floor;
                    }
                }
            } else if (this.f5137ad) {
                View childAt3 = getChildAt(this.f5142ai - this.f4566j);
                int width2 = (getWidth() - getPaddingRight()) - this.f5117K;
                if (childAt3 != null) {
                    i2 = -(floor - (width2 - childAt3.getRight()));
                } else {
                    i2 = -(floor - (width2 - getChildAt(0).getRight()));
                }
                i = i2;
            } else {
                View childAt4 = getChildAt(this.f5143aj - this.f4566j);
                if (childAt4 != null) {
                    i = (getPaddingLeft() + this.f5117K) - childAt4.getLeft();
                } else {
                    i = (getPaddingLeft() + this.f5117K) - getChildAt(childCount - 1).getLeft();
                }
            }
            mo16494c(2);
            this.f5123Q.mo16546a(i);
        }
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f5145al > 0 && !this.f5144ak) {
            return false;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        if (!this.f5127U) {
            if (this.f5136ac) {
                if (!this.f5129W) {
                    this.f5129W = true;
                }
                postDelayed(this.f5124R, 250);
            }
        } else if (this.f5129W) {
            this.f5129W = false;
        }
        if (this.f5136ac) {
            mo16494c(1);
        }
        this.f5116J = 1;
        getChildCount();
        int i = (int) f;
        if (this.f5139af > getWidth()) {
            this.f5139af = this.f5140ag;
        }
        if (!(this.f5138ae == 0 || this.f5139af == 0)) {
            this.f5116J = 3;
            if (Math.abs(this.f5138ae) >= this.f5139af) {
                i = 0;
            } else {
                i = (int) (((float) i) * (1.0f - ((((float) Math.abs(this.f5138ae)) * 1.0f) / ((float) this.f5139af))));
            }
        }
        if (i != 0) {
            mo16491b(i * -1);
        }
        this.f5136ac = false;
        return true;
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (this.f5116J == 2 || this.f5116J == 4) {
            this.f5116J = 1;
            mo16494c(1);
        } else {
            this.f5116J = 0;
        }
        this.f5123Q.mo16547a(false);
        this.f5121O = mo16034a((int) motionEvent.getX(), (int) motionEvent.getY());
        if (this.f5121O >= 0) {
            this.f5122P = getChildAt(this.f5121O - this.f4566j);
            this.f5122P.setPressed(true);
        }
        this.f5113G = (int) motionEvent.getX();
        this.f5114H = (int) motionEvent.getY();
        this.f5142ai = this.f4566j;
        this.f5143aj = (this.f4566j + getChildCount()) - 1;
        this.f5136ac = true;
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo16509j() {
        switch (this.f5116J) {
            case 0:
                m5664p();
                break;
            case 1:
                m5664p();
                break;
            case 3:
            case 4:
                if (this.f5138ae != 0) {
                    if (this.f5133aD != 2) {
                        mo16494c(2);
                    }
                    this.f5123Q.mo16545a();
                    break;
                }
                break;
        }
        m5677z();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo16510k() {
        mo16509j();
    }

    public void onLongPress(MotionEvent motionEvent) {
        View childAt;
        if (this.f5121O >= 0) {
            if (this.f5146am == 2 && (childAt = getChildAt(this.f5121O - this.f4566j)) != null) {
                if (!this.f4577u ? mo16492b(childAt, this.f5121O, this.f4543a.getItemId(this.f5121O)) : false) {
                    this.f5116J = -1;
                    setPressed(false);
                    childAt.setPressed(false);
                }
            }
            performHapticFeedback(0);
            m5652e(this.f5122P, this.f5121O, mo16064a(this.f5121O));
        }
    }

    /* renamed from: z */
    private void m5677z() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount >= 0) {
                getChildAt(childCount).setPressed(false);
            } else {
                setPressed(false);
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z) {
        if (this.f5126T != null) {
            this.f5126T.setPressed(z);
        }
    }

    /* access modifiers changed from: protected */
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.f5135ab;
    }

    public boolean showContextMenuForChild(View view) {
        int c = mo16071c(view);
        if (c < 0) {
            return false;
        }
        return m5652e(view, c, this.f4543a.getItemId(c));
    }

    public boolean showContextMenu() {
        if (!isPressed() || this.f4580x < 0) {
            return false;
        }
        return m5652e(getChildAt(this.f4580x - this.f4566j), this.f4580x, this.f4581y);
    }

    /* renamed from: e */
    private boolean m5652e(View view, int i, long j) {
        boolean z;
        if (this.f4576t != null) {
            z = this.f4576t.mo16110a(this, this.f5122P, this.f5121O, j);
        } else {
            z = false;
        }
        if (!z) {
            this.f5135ab = new C1417a(view, i, j);
            z = super.showContextMenuForChild(this);
        }
        if (z) {
            performHapticFeedback(0);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void setSelectedPositionInt(int i) {
        super.setSelectedPositionInt(i);
        m5634A();
    }

    /* renamed from: A */
    private void m5634A() {
        View view = this.f5126T;
        View childAt = getChildAt(this.f4580x - this.f4566j);
        this.f5126T = childAt;
        if (childAt != null && this.f5146am == 1) {
            childAt.setSelected(true);
            childAt.setFocusable(true);
            if (hasFocus()) {
                childAt.requestFocus();
            }
            if (view != null && view != childAt) {
                view.setSelected(false);
                view.setFocusable(false);
            }
        }
    }

    public void setGravity(int i) {
        if (this.f5119M != i) {
            this.f5119M = i;
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z && this.f5126T != null && this.f5146am == 1) {
            this.f5126T.requestFocus(i);
            this.f5126T.setSelected(true);
        }
    }

    /* renamed from: com.meizu.common.widget.EnhanceGallery$c */
    private class C1419c implements Runnable {

        /* renamed from: b */
        private OverScroller f5167b;

        /* renamed from: c */
        private int f5168c;

        /* renamed from: d */
        private int f5169d = 0;

        /* renamed from: e */
        private int f5170e;

        public C1419c() {
            this.f5167b = new OverScroller(EnhanceGallery.this.getContext());
            this.f5167b.mo17563a(true, true);
        }

        /* renamed from: b */
        private void m5698b() {
            EnhanceGallery.this.removeCallbacks(this);
        }

        /* renamed from: a */
        public void mo16546a(int i) {
            if (i != 0) {
                int unused = EnhanceGallery.this.f5116J = 2;
                m5698b();
                this.f5168c = 0;
                this.f5167b.mo17561a((Interpolator) new DecelerateInterpolator());
                this.f5167b.mo17560a(0, 0, -i, 0, EnhanceGallery.this.f5118L);
                EnhanceGallery.this.postOnAnimation(this);
            }
        }

        /* renamed from: a */
        public void mo16545a() {
            if (this.f5167b.mo17565a(EnhanceGallery.this.f5138ae, 0, 0, 0, 0, 0)) {
                int unused = EnhanceGallery.this.f5116J = 4;
                this.f5169d = EnhanceGallery.this.f5138ae;
                EnhanceGallery.this.invalidate();
                EnhanceGallery.this.postOnAnimation(this);
                return;
            }
            int unused2 = EnhanceGallery.this.f5116J = -1;
        }

        /* renamed from: a */
        public void mo16547a(boolean z) {
            EnhanceGallery.this.removeCallbacks(this);
            m5699b(z);
        }

        /* renamed from: b */
        private void m5699b(boolean z) {
            this.f5167b.mo17562a(true);
            if (z) {
                EnhanceGallery.this.m5664p();
            } else {
                EnhanceGallery.this.mo16494c(0);
            }
        }

        public void run() {
            if (EnhanceGallery.this.f4582z == 0) {
                m5699b(true);
                return;
            }
            OverScroller eVar = this.f5167b;
            switch (EnhanceGallery.this.f5116J) {
                case 1:
                case 2:
                    boolean unused = EnhanceGallery.this.f5125S = false;
                    boolean c = eVar.mo17567c();
                    int b = eVar.mo17566b();
                    int i = this.f5168c - b;
                    boolean b2 = EnhanceGallery.this.mo16491b(i);
                    if (c && !EnhanceGallery.this.f5125S && !b2) {
                        this.f5168c = b;
                        this.f5170e = i;
                        EnhanceGallery.this.post(this);
                        return;
                    } else if (!c || EnhanceGallery.this.f5125S || !b2) {
                        m5699b(true);
                        return;
                    } else {
                        m5699b(false);
                        if (EnhanceGallery.this.f5116J == 2) {
                            int unused2 = EnhanceGallery.this.f5116J = 4;
                        } else {
                            int unused3 = EnhanceGallery.this.f5116J = 3;
                        }
                        if (EnhanceGallery.this.f5133aD != 2) {
                            EnhanceGallery.this.mo16494c(2);
                        }
                        mo16545a();
                        return;
                    }
                case 3:
                case 4:
                    if (eVar.mo17567c()) {
                        int b3 = eVar.mo17566b();
                        int i2 = b3 - this.f5169d;
                        this.f5169d = b3;
                        if (i2 != 0) {
                            EnhanceGallery.this.mo16491b(-i2);
                        }
                        EnhanceGallery.this.invalidate();
                        EnhanceGallery.this.postOnAnimation(this);
                        return;
                    }
                    m5699b(false);
                    int unused4 = EnhanceGallery.this.f5116J = -1;
                    return;
                default:
                    int unused5 = EnhanceGallery.this.f5116J = -1;
                    if (EnhanceGallery.this.f5133aD != 0) {
                        EnhanceGallery.this.mo16494c(0);
                        return;
                    }
                    return;
            }
        }
    }

    /* renamed from: com.meizu.common.widget.EnhanceGallery$d */
    public static class C1420d extends ViewGroup.LayoutParams {
        public C1420d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C1420d(int i, int i2) {
            super(i, i2);
        }

        public C1420d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public void setOnScrollListener(C1424h hVar) {
        this.f5132aC = hVar;
        mo16511l();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo16511l() {
        if (this.f5132aC != null) {
            this.f5132aC.mo16559a(this, this.f4566j, getChildCount(), this.f4582z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo16494c(int i) {
        if (i != this.f5133aD) {
            this.f5133aD = i;
            if (this.f5132aC != null) {
                this.f5132aC.mo16558a(this, i);
            }
        }
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        super.setAdapter(spinnerAdapter);
        if (spinnerAdapter != null && this.f5146am != 0) {
            if (this.f5149ap == null) {
                this.f5149ap = new SparseBooleanArray();
            }
            if (spinnerAdapter.hasStableIds() && this.f5112F == null) {
                this.f5112F = new LongSparseArray<>();
            }
            mo16512m();
        }
    }

    public void setChoiceMode(int i) {
        this.f5146am = i;
        if (this.f5148ao != null) {
            this.f5148ao.finish();
            this.f5148ao = null;
        }
        if (this.f5146am != 0) {
            if (this.f5149ap == null) {
                this.f5149ap = new SparseBooleanArray();
            }
            if (this.f5112F == null && this.f4543a != null && this.f4543a.hasStableIds()) {
                this.f5112F = new LongSparseArray<>();
            }
            if (this.f5146am == 2) {
                mo16512m();
                setLongClickable(true);
            }
        }
    }

    /* renamed from: m */
    public void mo16512m() {
        if (this.f5149ap != null) {
            this.f5149ap.clear();
        }
        if (this.f5112F != null) {
            this.f5112F.clear();
        }
        this.f5147an = 0;
    }

    public void setMultiChoiceModeListener(C1422f fVar) {
        if (this.f5111E == null) {
            this.f5111E = new C1423g();
        }
        this.f5111E.mo16552a(fVar);
    }

    /* renamed from: com.meizu.common.widget.EnhanceGallery$g */
    class C1423g implements C1422f {

        /* renamed from: b */
        private C1422f f5182b;

        C1423g() {
        }

        /* renamed from: a */
        public void mo16552a(C1422f fVar) {
            this.f5182b = fVar;
        }

        /* renamed from: a */
        public boolean mo16553a() {
            return this.f5182b != null;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (!this.f5182b.onCreateActionMode(actionMode, menu)) {
                return false;
            }
            if (EnhanceGallery.this.f5146am == 2) {
                EnhanceGallery.this.setLongClickable(true);
            } else {
                EnhanceGallery.this.setLongClickable(false);
            }
            return true;
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f5182b.onPrepareActionMode(actionMode, menu);
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f5182b.onActionItemClicked(actionMode, menuItem);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f5182b.onDestroyActionMode(actionMode);
            ActionMode unused = EnhanceGallery.this.f5148ao = null;
            EnhanceGallery.this.mo16512m();
            EnhanceGallery.this.mo16513n();
            EnhanceGallery.this.setLongClickable(true);
        }

        /* renamed from: a */
        public void mo16551a(ActionMode actionMode, int i, long j, boolean z) {
            this.f5182b.mo16551a(actionMode, i, j, z);
            if (EnhanceGallery.this.getCheckedItemCount() == 0) {
                actionMode.finish();
            }
        }
    }

    /* renamed from: n */
    public void mo16513n() {
        this.f4577u = true;
        this.f4582z = this.f4543a.getCount();
        requestLayout();
        invalidate();
    }

    public int getCheckedItemCount() {
        return this.f5147an;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.f5146am != 0) {
            return this.f5149ap;
        }
        return null;
    }

    /* renamed from: d */
    public boolean mo16499d(int i) {
        if (this.f5146am == 0 || this.f5149ap == null) {
            return false;
        }
        return this.f5149ap.get(i);
    }

    public long[] getCheckedItemIds() {
        if (this.f5146am == 0 || this.f5112F == null || this.f4543a == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.f5112F;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = longSparseArray.keyAt(i);
        }
        return jArr;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r11 != null) goto L_0x0019;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo16492b(android.view.View r9, int r10, long r11) {
        /*
            r8 = this;
            int r0 = r8.f5146am
            r1 = 0
            r2 = 2
            if (r0 != r2) goto L_0x00d6
            android.view.ActionMode r11 = r8.f5148ao
            r12 = 1
            if (r11 != 0) goto L_0x0019
            android.view.ActionMode r11 = r8.f5148ao
            if (r11 != 0) goto L_0x00d5
            com.meizu.common.widget.EnhanceGallery$g r11 = r8.f5111E
            android.view.ActionMode r11 = r8.startActionMode(r11)
            r8.f5148ao = r11
            if (r11 == 0) goto L_0x00d5
        L_0x0019:
            r8.f5115I = r10
            r11 = 16908289(0x1020001, float:2.3877232E-38)
            android.view.View r11 = r9.findViewById(r11)
            if (r11 == 0) goto L_0x002e
            boolean r0 = r11 instanceof android.widget.Checkable
            if (r0 == 0) goto L_0x002e
            r0 = r11
            android.widget.Checkable r0 = (android.widget.Checkable) r0
            r0.setChecked(r12)
        L_0x002e:
            android.graphics.Rect r0 = r8.f5158ay
            if (r0 != 0) goto L_0x003b
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r8.f5158ay = r0
            android.graphics.Rect r0 = r8.f5158ay
        L_0x003b:
            r9.getHitRect(r0)
            int r2 = r8.f5113G
            int r3 = r0.left
            int r2 = r2 - r3
            int r2 = java.lang.Math.max(r1, r2)
            r8.f5156aw = r2
            int r2 = r8.f5114H
            int r0 = r0.top
            int r2 = r2 - r0
            int r0 = java.lang.Math.max(r1, r2)
            r8.f5157ax = r0
            r9.setActivated(r1)
            r9.jumpDrawablesToCurrentState()
            boolean r0 = r8.f5134aa
            if (r0 == 0) goto L_0x00d0
            boolean r0 = r9 instanceof com.meizu.common.widget.EnhanceGallery.C1418b
            if (r0 == 0) goto L_0x0079
            r2 = r9
            com.meizu.common.widget.EnhanceGallery$b r2 = (com.meizu.common.widget.EnhanceGallery.C1418b) r2
            com.meizu.common.widget.EnhanceGallery$e r3 = new com.meizu.common.widget.EnhanceGallery$e
            android.view.View r4 = r2.mo16542a()
            boolean r5 = r2.mo16543b()
            android.graphics.Point r2 = r2.mo16544c()
            r3.<init>(r4, r5, r2)
            r8.f5150aq = r3
            goto L_0x0080
        L_0x0079:
            com.meizu.common.widget.EnhanceGallery$e r2 = new com.meizu.common.widget.EnhanceGallery$e
            r2.<init>(r8, r9)
            r8.f5150aq = r2
        L_0x0080:
            com.meizu.common.widget.EnhanceGallery$e r2 = r8.f5150aq
            r3 = 0
            boolean r2 = r8.mo16490a((android.content.ClipData) r3, (android.view.View.DragShadowBuilder) r2, (java.lang.Object) r8, (int) r1)
            if (r2 != 0) goto L_0x00b2
            if (r11 == 0) goto L_0x0094
            boolean r9 = r11 instanceof android.widget.Checkable
            if (r9 == 0) goto L_0x0094
            android.widget.Checkable r11 = (android.widget.Checkable) r11
            r11.setChecked(r1)
        L_0x0094:
            android.view.ActionMode r9 = r8.f5148ao
            r9.finish()
            r9 = -1
            r8.f5115I = r9
            com.meizu.common.widget.EnhanceGallery$i r9 = r8.f5159az
            if (r9 != 0) goto L_0x00a7
            com.meizu.common.widget.EnhanceGallery$i r9 = new com.meizu.common.widget.EnhanceGallery$i
            r9.<init>()
            r8.f5159az = r9
        L_0x00a7:
            com.meizu.common.widget.EnhanceGallery$i r9 = r8.f5159az
            r9.f5183a = r10
            r9.mo16563a()
            r8.post(r9)
            return r12
        L_0x00b2:
            r8.performHapticFeedback(r1)
            r10 = 0
            if (r0 == 0) goto L_0x00cc
            r11 = r9
            com.meizu.common.widget.EnhanceGallery$b r11 = (com.meizu.common.widget.EnhanceGallery.C1418b) r11
            android.view.View r11 = r11.mo16542a()
            if (r11 == 0) goto L_0x00c4
            r11.setAlpha(r10)
        L_0x00c4:
            boolean r11 = r8.f5151ar
            if (r11 == 0) goto L_0x00d5
            r9.setAlpha(r10)
            goto L_0x00d5
        L_0x00cc:
            r9.setAlpha(r10)
            goto L_0x00d5
        L_0x00d0:
            int r9 = r8.f5115I
            r8.setItemChecked(r9, r12)
        L_0x00d5:
            return r12
        L_0x00d6:
            com.meizu.common.widget.AdapterView$c r0 = r8.f4576t
            if (r0 == 0) goto L_0x00e5
            com.meizu.common.widget.AdapterView$c r2 = r8.f4576t
            r3 = r8
            r4 = r9
            r5 = r10
            r6 = r11
            boolean r0 = r2.mo16110a(r3, r4, r5, r6)
            goto L_0x00e6
        L_0x00e5:
            r0 = 0
        L_0x00e6:
            if (r0 != 0) goto L_0x00f4
            android.view.ContextMenu$ContextMenuInfo r9 = r8.mo16493c(r9, r10, r11)
            com.meizu.common.widget.EnhanceGallery$a r9 = (com.meizu.common.widget.EnhanceGallery.C1417a) r9
            r8.f5135ab = r9
            boolean r0 = super.showContextMenuForChild(r8)
        L_0x00f4:
            if (r0 == 0) goto L_0x00f9
            r8.performHapticFeedback(r1)
        L_0x00f9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.EnhanceGallery.mo16492b(android.view.View, int, long):boolean");
    }

    public void setDragItemBackgroundResources(int[] iArr) {
        if (iArr != null) {
            if (iArr.length > 0) {
                this.f5152as = iArr[0];
            }
            if (iArr.length > 1) {
                this.f5153at = iArr[1];
            }
            if (iArr.length > 2) {
                this.f5154au = iArr[2];
            }
        }
    }

    /* renamed from: com.meizu.common.widget.EnhanceGallery$e */
    class C1421e extends View.DragShadowBuilder {

        /* renamed from: b */
        private Drawable f5172b;

        /* renamed from: c */
        private Rect f5173c;

        /* renamed from: d */
        private int f5174d;

        /* renamed from: e */
        private int f5175e;

        /* renamed from: f */
        private boolean f5176f;

        /* renamed from: g */
        private Point f5177g;

        /* renamed from: h */
        private Drawable f5178h;

        /* renamed from: i */
        private Drawable f5179i;

        /* renamed from: j */
        private int f5180j;

        public C1421e(EnhanceGallery enhanceGallery, View view) {
            this(view, true, (Point) null);
        }

        public C1421e(View view, boolean z, Point point) {
            super(view);
            this.f5176f = true;
            this.f5177g = null;
            this.f5180j = -1;
            this.f5176f = z;
            this.f5177g = point;
            if (view != null) {
                if (z) {
                    this.f5172b = EnhanceGallery.this.getResources().getDrawable(EnhanceGallery.this.f5152as);
                    this.f5173c = new Rect();
                    this.f5172b.getPadding(this.f5173c);
                    Rect rect = this.f5173c;
                    int width = view.getWidth();
                    int height = view.getHeight();
                    this.f5174d = width + rect.left + rect.right;
                    this.f5175e = height + rect.top + rect.bottom;
                    this.f5172b.setBounds(0, 0, this.f5174d, this.f5175e);
                    this.f5178h = EnhanceGallery.this.getResources().getDrawable(EnhanceGallery.this.f5153at);
                    this.f5178h.setBounds(0, 0, this.f5174d, this.f5175e);
                    this.f5179i = EnhanceGallery.this.getResources().getDrawable(EnhanceGallery.this.f5154au);
                    this.f5179i.setBounds(0, 0, this.f5174d, this.f5175e);
                } else {
                    this.f5174d = view.getWidth();
                    this.f5175e = view.getHeight();
                }
                int unused = EnhanceGallery.this.f5155av = 0;
                if (this.f5175e > EnhanceGallery.this.getHeight()) {
                    int[] iArr = new int[2];
                    EnhanceGallery.this.getLocationOnScreen(iArr);
                    int[] iArr2 = new int[2];
                    view.getLocationOnScreen(iArr2);
                    if (iArr2[1] < iArr[1]) {
                        int unused2 = EnhanceGallery.this.f5155av = iArr[1] - iArr2[1];
                        int unused3 = EnhanceGallery.this.f5155av = Math.min(this.f5175e - EnhanceGallery.this.getHeight(), EnhanceGallery.this.f5155av);
                    }
                    this.f5175e = EnhanceGallery.this.getHeight();
                }
            }
        }

        public void onProvideShadowMetrics(Point point, Point point2) {
            super.onProvideShadowMetrics(point, point2);
            point.set(this.f5174d, this.f5175e);
            if (this.f5176f) {
                point2.set(EnhanceGallery.this.f5156aw + this.f5173c.left, (EnhanceGallery.this.f5157ax + this.f5173c.top) - EnhanceGallery.this.f5155av);
            } else {
                point2.set(EnhanceGallery.this.f5156aw, EnhanceGallery.this.f5157ax - EnhanceGallery.this.f5155av);
            }
        }

        public void onDrawShadow(Canvas canvas) {
            if (this.f5176f) {
                if (this.f5180j == 0) {
                    this.f5178h.draw(canvas);
                } else if (this.f5180j == 1) {
                    this.f5179i.draw(canvas);
                } else {
                    this.f5172b.draw(canvas);
                }
                canvas.save();
                canvas.translate((float) this.f5173c.left, (float) (this.f5173c.top - EnhanceGallery.this.f5155av));
                super.onDrawShadow(canvas);
                canvas.restore();
            } else if (EnhanceGallery.this.f5155av != 0) {
                canvas.save();
                canvas.translate(0.0f, (float) (-EnhanceGallery.this.f5155av));
                super.onDrawShadow(canvas);
                canvas.restore();
            } else {
                super.onDrawShadow(canvas);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public ContextMenu.ContextMenuInfo mo16493c(View view, int i, long j) {
        return new C1417a(view, i, j);
    }

    /* renamed from: com.meizu.common.widget.EnhanceGallery$a */
    public static class C1417a implements ContextMenu.ContextMenuInfo {

        /* renamed from: a */
        public View f5163a;

        /* renamed from: b */
        public int f5164b;

        /* renamed from: c */
        public long f5165c;

        public C1417a(View view, int i, long j) {
            this.f5163a = view;
            this.f5164b = i;
            this.f5165c = j;
        }
    }

    /* renamed from: com.meizu.common.widget.EnhanceGallery$k */
    private class C1427k {

        /* renamed from: a */
        private int f5186a;

        private C1427k() {
        }

        /* renamed from: a */
        public void mo16563a() {
            this.f5186a = EnhanceGallery.this.getWindowAttachCount();
        }

        /* renamed from: b */
        public boolean mo16564b() {
            return EnhanceGallery.this.hasWindowFocus() && EnhanceGallery.this.getWindowAttachCount() == this.f5186a;
        }
    }

    /* renamed from: com.meizu.common.widget.EnhanceGallery$i */
    private class C1425i extends C1427k implements Runnable {

        /* renamed from: a */
        int f5183a;

        private C1425i() {
            super();
        }

        public void run() {
            View childAt;
            if (!EnhanceGallery.this.f4577u) {
                SpinnerAdapter adapter = EnhanceGallery.this.getAdapter();
                int i = this.f5183a;
                if (adapter != null && EnhanceGallery.this.f4582z > 0 && i != -1 && i < adapter.getCount() && mo16564b() && (childAt = EnhanceGallery.this.getChildAt(i - EnhanceGallery.this.f4566j)) != null) {
                    EnhanceGallery.this.mo16500d(childAt, i, adapter.getItemId(i));
                }
            }
        }
    }

    /* renamed from: d */
    public boolean mo16500d(View view, int i, long j) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.f5146am != 0) {
            if (this.f5146am != 2 || this.f5148ao == null) {
                if (this.f5146am == 1) {
                    if (!this.f5149ap.get(i, false)) {
                        this.f5149ap.clear();
                        this.f5149ap.put(i, true);
                        if (this.f5112F != null && this.f4543a.hasStableIds()) {
                            this.f5112F.clear();
                            this.f5112F.put(this.f4543a.getItemId(i), Integer.valueOf(i));
                        }
                        this.f5147an = 1;
                    } else if (this.f5149ap.size() == 0 || !this.f5149ap.valueAt(0)) {
                        this.f5147an = 0;
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = true;
            } else {
                boolean z4 = !this.f5149ap.get(i, false);
                this.f5149ap.put(i, z4);
                if (this.f5112F != null && this.f4543a.hasStableIds()) {
                    if (z4) {
                        this.f5112F.put(this.f4543a.getItemId(i), Integer.valueOf(i));
                    } else {
                        this.f5112F.delete(this.f4543a.getItemId(i));
                    }
                }
                if (z4) {
                    this.f5147an++;
                } else {
                    this.f5147an--;
                }
                if (this.f5148ao == null || this.f5111E == null) {
                    z3 = true;
                } else {
                    this.f5111E.mo16551a(this.f5148ao, i, j, z4);
                    z3 = false;
                }
                z = z3;
                z2 = true;
            }
            if (z2) {
                m5635B();
            }
        } else {
            z = true;
        }
        if (!z || this.f4575s == null) {
            return false;
        }
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.f4575s.mo16109a(this, view, i, j);
        return true;
    }

    public void setItemChecked(int i, boolean z) {
        if (this.f5146am != 0) {
            if (z && this.f5148ao == null && this.f5146am == 2) {
                if (this.f5111E == null || !this.f5111E.mo16553a()) {
                    throw new IllegalStateException("StaggeredGridView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.f5148ao = startActionMode(this.f5111E);
            }
            if (this.f5146am == 2) {
                boolean z2 = this.f5149ap.get(i);
                this.f5149ap.put(i, z);
                if (this.f5112F != null && this.f4543a.hasStableIds()) {
                    if (z) {
                        this.f5112F.put(this.f4543a.getItemId(i), Integer.valueOf(i));
                    } else {
                        this.f5112F.delete(this.f4543a.getItemId(i));
                    }
                }
                if (z2 != z) {
                    if (z) {
                        this.f5147an++;
                    } else {
                        this.f5147an--;
                    }
                }
                if (this.f5148ao != null) {
                    this.f5111E.mo16551a(this.f5148ao, i, this.f4543a.getItemId(i), z);
                }
            } else {
                boolean z3 = this.f5112F != null && this.f4543a.hasStableIds();
                if (z || mo16499d(i)) {
                    this.f5149ap.clear();
                    if (z3) {
                        this.f5112F.clear();
                    }
                }
                if (z) {
                    this.f5149ap.put(i, true);
                    if (z3) {
                        this.f5112F.put(this.f4543a.getItemId(i), Integer.valueOf(i));
                    }
                    this.f5147an = 1;
                } else if (this.f5149ap.size() == 0 || !this.f5149ap.valueAt(0)) {
                    this.f5147an = 0;
                }
            }
            if (!this.f4573q) {
                mo16513n();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo16514o() {
        boolean z;
        this.f5149ap.clear();
        int i = 0;
        boolean z2 = false;
        while (i < this.f5112F.size()) {
            long keyAt = this.f5112F.keyAt(i);
            int intValue = this.f5112F.valueAt(i).intValue();
            long j = -1;
            if (intValue < this.f4582z) {
                j = this.f4543a.getItemId(intValue);
            }
            if (intValue >= this.f4582z || keyAt != j) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.f4582z);
                while (true) {
                    if (max >= min) {
                        z = false;
                        break;
                    } else if (keyAt == this.f4543a.getItemId(max)) {
                        this.f5149ap.put(max, true);
                        this.f5112F.setValueAt(i, Integer.valueOf(max));
                        z = true;
                        break;
                    } else {
                        max++;
                    }
                }
                if (!z) {
                    this.f5112F.delete(keyAt);
                    i--;
                    this.f5147an--;
                    if (!(this.f5148ao == null || this.f5111E == null)) {
                        this.f5111E.mo16551a(this.f5148ao, intValue, keyAt, false);
                    }
                    z2 = true;
                }
            } else {
                this.f5149ap.put(intValue, true);
            }
            i++;
        }
        if (z2 && this.f5148ao != null) {
            this.f5148ao.invalidate();
        }
    }

    /* renamed from: B */
    private void m5635B() {
        int i = this.f4566j;
        int childCount = getChildCount();
        boolean z = getContext().getApplicationInfo().targetSdkVersion >= 11;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int i3 = i + i2;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.f5149ap.get(i3));
            } else if (z) {
                childAt.setActivated(this.f5149ap.get(i3));
            }
        }
    }

    /* renamed from: com.meizu.common.widget.EnhanceGallery$j */
    class C1426j extends View.AccessibilityDelegate {
        C1426j() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EnhanceGallery.this.mo16489a(view, EnhanceGallery.this.mo16071c(view), accessibilityNodeInfo);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return super.performAccessibilityAction(view, i, bundle);
        }
    }

    /* renamed from: a */
    public void mo16489a(View view, int i, AccessibilityNodeInfo accessibilityNodeInfo) {
        SpinnerAdapter adapter = getAdapter();
        if (i != -1 && adapter != null) {
            if (i == getSelectedItemPosition()) {
                accessibilityNodeInfo.setSelected(true);
                accessibilityNodeInfo.addAction(8);
            } else {
                accessibilityNodeInfo.addAction(4);
            }
            if (isFocusable()) {
                accessibilityNodeInfo.addAction(1);
                accessibilityNodeInfo.setFocusable(true);
            }
            if (isClickable()) {
                accessibilityNodeInfo.addAction(16);
                accessibilityNodeInfo.setClickable(true);
            }
            if (isLongClickable()) {
                accessibilityNodeInfo.addAction(32);
                accessibilityNodeInfo.setLongClickable(true);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getCount(), false, 1));
        accessibilityNodeInfo.setClassName(EnhanceGallery.class.getName());
    }
}
