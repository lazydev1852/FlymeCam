package com.meizu.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;

public class PinnedHeaderListView extends AutoScrollListView implements AbsListView.OnScrollListener, AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    private C1484b f5854a;

    /* renamed from: b */
    private int f5855b;

    /* renamed from: c */
    private C1483a[] f5856c;

    /* renamed from: d */
    private RectF f5857d;

    /* renamed from: e */
    private Rect f5858e;

    /* renamed from: f */
    private AbsListView.OnScrollListener f5859f;

    /* renamed from: g */
    private AdapterView.OnItemSelectedListener f5860g;

    /* renamed from: h */
    private int f5861h;

    /* renamed from: i */
    private int f5862i;

    /* renamed from: j */
    private boolean f5863j;

    /* renamed from: k */
    private long f5864k;

    /* renamed from: l */
    private int f5865l;

    /* renamed from: m */
    private int f5866m;

    /* renamed from: n */
    private int f5867n;

    /* renamed from: o */
    private Drawable f5868o;

    /* renamed from: com.meizu.common.widget.PinnedHeaderListView$b */
    public interface C1484b {
        /* renamed from: a */
        View mo17045a(int i, View view, ViewGroup viewGroup);

        /* renamed from: a */
        void mo17046a(PinnedHeaderListView pinnedHeaderListView);

        /* renamed from: f */
        int mo17048f();
    }

    /* renamed from: com.meizu.common.widget.PinnedHeaderListView$a */
    private static final class C1483a {

        /* renamed from: a */
        View f5869a;

        /* renamed from: b */
        boolean f5870b;

        /* renamed from: c */
        int f5871c;

        /* renamed from: d */
        int f5872d;

        /* renamed from: e */
        int f5873e;

        /* renamed from: f */
        int f5874f;

        /* renamed from: g */
        boolean f5875g;

        /* renamed from: h */
        boolean f5876h;

        /* renamed from: i */
        int f5877i;

        /* renamed from: j */
        int f5878j;

        /* renamed from: k */
        long f5879k;

        private C1483a() {
        }
    }

    public PinnedHeaderListView(Context context) {
        this(context, (AttributeSet) null, 16842868);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5857d = new RectF();
        this.f5858e = new Rect();
        this.f5862i = 20;
        this.f5868o = null;
        super.setOnScrollListener(this);
        super.setOnItemSelectedListener(this);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f5865l = 0;
        this.f5866m = i3 - i;
    }

    public void setPinnedHeaderAnimationDuration(int i) {
        this.f5862i = i;
    }

    public void setAdapter(ListAdapter listAdapter) {
        this.f5854a = (C1484b) listAdapter;
        super.setAdapter(listAdapter);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f5859f = onScrollListener;
        super.setOnScrollListener(this);
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f5860g = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f5854a != null) {
            int f = this.f5854a.mo17048f();
            if (f != this.f5855b) {
                this.f5855b = f;
                if (this.f5856c == null) {
                    this.f5856c = new C1483a[this.f5855b];
                } else if (this.f5856c.length < this.f5855b) {
                    C1483a[] aVarArr = this.f5856c;
                    this.f5856c = new C1483a[this.f5855b];
                    System.arraycopy(aVarArr, 0, this.f5856c, 0, aVarArr.length);
                }
            }
            for (int i4 = 0; i4 < this.f5855b; i4++) {
                if (this.f5856c[i4] == null) {
                    this.f5856c[i4] = new C1483a();
                }
                this.f5856c[i4].f5869a = this.f5854a.mo17045a(i4, this.f5856c[i4].f5869a, this);
                if (!(this.f5868o == null || this.f5856c[i4].f5869a == null)) {
                    this.f5856c[i4].f5869a.setBackground(this.f5868o);
                }
            }
            this.f5864k = System.currentTimeMillis() + ((long) this.f5862i);
            this.f5854a.mo17046a(this);
            m5953a();
        }
        if (this.f5859f != null) {
            this.f5859f.onScroll(this, i, i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (this.f5855b > 0) {
            return 0.0f;
        }
        return super.getTopFadingEdgeStrength();
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f5861h = i;
        if (this.f5859f != null) {
            this.f5859f.onScrollStateChanged(this, i);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        int height = getHeight();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= this.f5855b) {
                break;
            }
            C1483a aVar = this.f5856c[i2];
            if (aVar.f5870b) {
                if (aVar.f5874f == 0) {
                    i3 = aVar.f5871c + aVar.f5872d;
                } else if (aVar.f5874f == 1) {
                    height = aVar.f5871c;
                    break;
                }
            }
            i2++;
        }
        View selectedView = getSelectedView();
        if (selectedView != null) {
            if (selectedView.getTop() < i3) {
                setSelectionFromTop(i, i3);
            } else if (selectedView.getBottom() > height) {
                setSelectionFromTop(i, height - selectedView.getHeight());
            }
        }
        if (this.f5860g != null) {
            this.f5860g.onItemSelected(adapterView, view, i, j);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        if (this.f5860g != null) {
            this.f5860g.onNothingSelected(adapterView);
        }
    }

    /* renamed from: a */
    public int mo17051a(int i) {
        m5955c(i);
        if (this.f5856c[i].f5869a == null) {
            return 0;
        }
        return this.f5856c[i].f5869a.getHeight();
    }

    public void setHeaderPinnedAtTop(int i, int i2, boolean z) {
        m5955c(i);
        C1483a aVar = this.f5856c[i];
        aVar.f5870b = true;
        aVar.f5871c = i2;
        aVar.f5874f = 0;
        aVar.f5875g = false;
    }

    public void setHeaderPinnedAtBottom(int i, int i2, boolean z) {
        m5955c(i);
        C1483a aVar = this.f5856c[i];
        aVar.f5874f = 1;
        if (aVar.f5875g) {
            aVar.f5879k = this.f5864k;
            aVar.f5877i = aVar.f5871c;
            aVar.f5878j = i2;
        } else if (!z || (aVar.f5871c == i2 && aVar.f5870b)) {
            aVar.f5870b = true;
            aVar.f5871c = i2;
        } else {
            if (aVar.f5870b) {
                aVar.f5877i = aVar.f5871c;
            } else {
                aVar.f5870b = true;
                aVar.f5877i = aVar.f5872d + i2;
            }
            aVar.f5875g = true;
            aVar.f5876h = true;
            aVar.f5879k = this.f5864k;
            aVar.f5878j = i2;
        }
    }

    public void setFadingHeader(int i, int i2, boolean z) {
        m5955c(i);
        if (getChildAt(i2 - getFirstVisiblePosition()) != null) {
            C1483a aVar = this.f5856c[i];
            aVar.f5870b = true;
            aVar.f5874f = 2;
            aVar.f5873e = 255;
            aVar.f5875g = false;
            aVar.f5871c = getTotalTopPinnedHeaderHeight();
        }
    }

    public void setTranslateHeader(int i, int i2) {
        m5955c(i);
        C1483a aVar = this.f5856c[i];
        aVar.f5870b = true;
        aVar.f5874f = 2;
        aVar.f5873e = 255;
        aVar.f5875g = false;
        aVar.f5871c = getTotalTopPinnedHeaderHeight() + i2;
    }

    public void setHeaderInvisible(int i, boolean z) {
        C1483a aVar = this.f5856c[i];
        if (!aVar.f5870b || ((!z && !aVar.f5875g) || aVar.f5874f != 1)) {
            aVar.f5870b = false;
            return;
        }
        aVar.f5877i = aVar.f5871c;
        if (!aVar.f5875g) {
            aVar.f5870b = true;
            aVar.f5878j = getBottom() + aVar.f5872d;
        }
        aVar.f5875g = true;
        aVar.f5879k = this.f5864k;
        aVar.f5876h = false;
    }

    /* renamed from: c */
    private void m5955c(int i) {
        int i2;
        View view = this.f5856c[i].f5869a;
        if (view != null && view.isLayoutRequested()) {
            if (this.f5866m == 0) {
                this.f5866m = getRight() - getLeft();
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f5866m, 1073741824);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height <= 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            } else {
                i2 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            view.measure(makeMeasureSpec, i2);
            int measuredHeight = view.getMeasuredHeight();
            this.f5856c[i].f5872d = measuredHeight;
            view.layout(0, 0, this.f5866m, measuredHeight);
        }
    }

    public int getTotalTopPinnedHeaderHeight() {
        int i = this.f5855b;
        while (true) {
            i--;
            if (i < 0) {
                return 0;
            }
            C1483a aVar = this.f5856c[i];
            if (aVar.f5870b && aVar.f5874f == 0) {
                return aVar.f5871c + aVar.f5872d;
            }
        }
    }

    /* renamed from: b */
    public int mo17052b(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (isStackFromBottom()) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    if (i >= getChildAt(i2).getTop()) {
                        return getFirstVisiblePosition() + i2;
                    }
                }
            } else {
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (i <= getChildAt(i3).getBottom()) {
                        return getFirstVisiblePosition() + i3;
                    }
                }
            }
        }
        return 0;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private void m5953a() {
        this.f5863j = false;
        for (int i = 0; i < this.f5855b; i++) {
            if (this.f5856c[i].f5875g) {
                this.f5863j = true;
                invalidate();
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int i;
        long currentTimeMillis = this.f5863j ? System.currentTimeMillis() : 0;
        int bottom = getBottom();
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f5855b; i3++) {
            C1483a aVar = this.f5856c[i3];
            if (aVar.f5870b) {
                if (aVar.f5874f == 1 && aVar.f5871c < bottom) {
                    bottom = aVar.f5871c;
                } else if ((aVar.f5874f == 0 || aVar.f5874f == 2) && (i = aVar.f5871c + aVar.f5872d) > i2) {
                    i2 = i;
                }
                z = true;
            }
        }
        if (z) {
            canvas.save();
            this.f5858e.set(0, 0, getWidth(), bottom);
            canvas.clipRect(this.f5858e);
        }
        super.dispatchDraw(canvas);
        if (z) {
            canvas.restore();
            int i4 = this.f5855b;
            while (true) {
                i4--;
                if (i4 < 0) {
                    break;
                }
                C1483a aVar2 = this.f5856c[i4];
                if (aVar2.f5870b && (aVar2.f5874f == 0 || aVar2.f5874f == 2)) {
                    m5954a(canvas, aVar2, currentTimeMillis);
                }
            }
            for (int i5 = 0; i5 < this.f5855b; i5++) {
                C1483a aVar3 = this.f5856c[i5];
                if (aVar3.f5870b && aVar3.f5874f == 1) {
                    m5954a(canvas, aVar3, currentTimeMillis);
                }
            }
        }
        m5953a();
    }

    /* renamed from: a */
    private void m5954a(Canvas canvas, C1483a aVar, long j) {
        if (aVar.f5875g) {
            int i = (int) (aVar.f5879k - j);
            if (i <= 0) {
                aVar.f5871c = aVar.f5878j;
                aVar.f5870b = aVar.f5876h;
                aVar.f5875g = false;
            } else {
                aVar.f5871c = aVar.f5878j + (((aVar.f5877i - aVar.f5878j) * i) / this.f5862i);
            }
        }
        if (aVar.f5870b) {
            View view = aVar.f5869a;
            int save = canvas.save();
            if (aVar.f5874f == 0 || aVar.f5874f == 2) {
                canvas.translate((float) this.f5865l, (float) (aVar.f5871c + this.f5867n));
            } else {
                canvas.translate((float) this.f5865l, (float) aVar.f5871c);
            }
            if (aVar.f5874f == 2) {
                this.f5857d.set(0.0f, 0.0f, (float) this.f5866m, (float) view.getHeight());
                canvas.saveLayerAlpha(this.f5857d, aVar.f5873e, 31);
            }
            view.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public void setSelection(int i) {
        if (this.f5854a instanceof PinnedHeaderIndexerListAdapter) {
            PinnedHeaderIndexerListAdapter fVar = (PinnedHeaderIndexerListAdapter) this.f5854a;
            if (!fVar.mo17584j(i - getHeaderViewsCount()).f6401a && fVar.mo17579e() && this.f5855b > 0) {
                if (fVar.mo17049g()) {
                    super.setSelectionFromTop(i, mo17051a(1));
                    return;
                } else {
                    super.setSelectionFromTop(i, 0);
                    return;
                }
            }
        }
        super.setSelection(i);
    }

    public int getCurrentOverScrollDistance() {
        if (getFirstVisiblePosition() != 0 || getChildCount() <= 0) {
            return 0;
        }
        return getPaddingTop() - getChildAt(0).getTop();
    }

    public void setHeaderPaddingTop(int i) {
        if (i >= 0) {
            this.f5867n = i;
        }
    }

    public int getHeaderPaddingTop() {
        return this.f5867n;
    }

    public void setHeaderBackground(Drawable drawable) {
        if (drawable != null && drawable != this.f5868o) {
            if (this.f5868o != null) {
                this.f5868o.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.f5868o);
            }
            this.f5868o = drawable;
            this.f5868o.setCallback(this);
            requestLayout();
            invalidate();
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(PinnedHeaderListView.class.getName());
    }
}
