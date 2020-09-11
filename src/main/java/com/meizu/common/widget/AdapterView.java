package com.meizu.common.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;

public abstract class AdapterView<T extends Adapter> extends ViewGroup {

    /* renamed from: A */
    int f4556A;

    /* renamed from: B */
    int f4557B = -1;

    /* renamed from: C */
    long f4558C = Long.MIN_VALUE;

    /* renamed from: D */
    boolean f4559D = false;

    /* renamed from: a */
    private int f4560a;

    /* renamed from: b */
    private View f4561b;

    /* renamed from: c */
    private boolean f4562c;

    /* renamed from: d */
    private boolean f4563d;

    /* renamed from: e */
    private AdapterView<T>.e f4564e;

    /* renamed from: f */
    private Context f4565f;
    @ViewDebug.ExportedProperty(category = "scrolling")

    /* renamed from: j */
    int f4566j = 0;

    /* renamed from: k */
    int f4567k;

    /* renamed from: l */
    int f4568l;

    /* renamed from: m */
    long f4569m = Long.MIN_VALUE;

    /* renamed from: n */
    long f4570n;

    /* renamed from: o */
    boolean f4571o = false;

    /* renamed from: p */
    int f4572p;

    /* renamed from: q */
    boolean f4573q = false;

    /* renamed from: r */
    C1352d f4574r;

    /* renamed from: s */
    C1350b f4575s;

    /* renamed from: t */
    C1351c f4576t;

    /* renamed from: u */
    boolean f4577u;
    @ViewDebug.ExportedProperty(category = "list")

    /* renamed from: v */
    int f4578v = -1;

    /* renamed from: w */
    long f4579w = Long.MIN_VALUE;
    @ViewDebug.ExportedProperty(category = "list")

    /* renamed from: x */
    int f4580x = -1;

    /* renamed from: y */
    long f4581y = Long.MIN_VALUE;
    @ViewDebug.ExportedProperty(category = "list")

    /* renamed from: z */
    int f4582z;

    /* renamed from: com.meizu.common.widget.AdapterView$b */
    public interface C1350b {
        /* renamed from: a */
        void mo16109a(AdapterView<?> adapterView, View view, int i, long j);
    }

    /* renamed from: com.meizu.common.widget.AdapterView$c */
    public interface C1351c {
        /* renamed from: a */
        boolean mo16110a(AdapterView<?> adapterView, View view, int i, long j);
    }

    /* renamed from: com.meizu.common.widget.AdapterView$d */
    public interface C1352d {
        /* renamed from: a */
        void mo16111a(AdapterView<?> adapterView);

        /* renamed from: a */
        void mo16112a(AdapterView<?> adapterView, View view, int i, long j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo16070c(int i, boolean z) {
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo16072c() {
        return false;
    }

    public abstract T getAdapter();

    public abstract View getSelectedView();

    public abstract void setAdapter(T t);

    public abstract void setSelection(int i);

    public AdapterView(Context context) {
        super(context);
        this.f4565f = context;
    }

    public AdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4565f = context;
    }

    public AdapterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4565f = context;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public void setOnItemClickListener(C1350b bVar) {
        this.f4575s = bVar;
    }

    public final C1350b getOnItemClickListener() {
        return this.f4575s;
    }

    /* renamed from: a */
    public boolean mo16065a(View view, int i, long j) {
        if (this.f4575s == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.f4575s.mo16109a(this, view, i, j);
        return true;
    }

    public void setOnItemLongClickListener(C1351c cVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.f4576t = cVar;
    }

    public final C1351c getOnItemLongClickListener() {
        return this.f4576t;
    }

    public void setOnItemSelectedListener(C1352d dVar) {
        this.f4574r = dVar;
    }

    public final C1352d getOnItemSelectedListener() {
        return this.f4574r;
    }

    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f4560a = getHeight();
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.f4578v;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.f4579w;
    }

    public Object getSelectedItem() {
        Adapter adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        if (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) {
            return null;
        }
        return adapter.getItem(selectedItemPosition);
    }

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        return this.f4582z;
    }

    /* renamed from: c */
    public int mo16071c(View view) {
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException unused) {
                return -1;
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view)) {
                return this.f4566j + i;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.f4566j;
    }

    public int getLastVisiblePosition() {
        return (this.f4566j + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.f4561b = view;
        boolean z = true;
        if (view != null && view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        Adapter adapter = getAdapter();
        if (adapter != null && !adapter.isEmpty()) {
            z = false;
        }
        m5199a(z);
    }

    public View getEmptyView() {
        return this.f4561b;
    }

    public void setFocusable(boolean z) {
        Adapter adapter = getAdapter();
        boolean z2 = true;
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.f4562c = z;
        if (!z) {
            this.f4563d = false;
        }
        if (!z || (z3 && !mo16072c())) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    public void setFocusableInTouchMode(boolean z) {
        Adapter adapter = getAdapter();
        boolean z2 = false;
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.f4563d = z;
        if (z) {
            this.f4562c = true;
        }
        if (z && (!z3 || mo16072c())) {
            z2 = true;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo16074d() {
        Adapter adapter = getAdapter();
        boolean z = false;
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || mo16072c();
        super.setFocusableInTouchMode(z2 && this.f4563d);
        super.setFocusable(z2 && this.f4562c);
        if (this.f4561b != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            m5199a(z);
        }
    }

    /* renamed from: a */
    private void m5199a(boolean z) {
        if (mo16072c()) {
            z = false;
        }
        if (z) {
            if (this.f4561b != null) {
                this.f4561b.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.f4577u) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (this.f4561b != null) {
            this.f4561b.setVisibility(8);
        }
        setVisibility(0);
    }

    /* renamed from: a */
    public long mo16064a(int i) {
        Adapter adapter = getAdapter();
        if (adapter == null || i < 0) {
            return Long.MIN_VALUE;
        }
        return adapter.getItemId(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* renamed from: com.meizu.common.widget.AdapterView$a */
    class C1349a extends DataSetObserver {

        /* renamed from: b */
        private Parcelable f4584b = null;

        C1349a() {
        }

        public void onChanged() {
            AdapterView.this.f4577u = true;
            AdapterView.this.f4556A = AdapterView.this.f4582z;
            AdapterView.this.f4582z = AdapterView.this.getAdapter().getCount();
            if (!AdapterView.this.getAdapter().hasStableIds() || this.f4584b == null || AdapterView.this.f4556A != 0 || AdapterView.this.f4582z <= 0) {
                AdapterView.this.mo16091i();
            } else {
                AdapterView.this.onRestoreInstanceState(this.f4584b);
                this.f4584b = null;
            }
            AdapterView.this.mo16074d();
            AdapterView.this.requestLayout();
        }

        public void onInvalidated() {
            AdapterView.this.f4577u = true;
            if (AdapterView.this.getAdapter().hasStableIds()) {
                this.f4584b = AdapterView.this.onSaveInstanceState();
            }
            AdapterView.this.f4556A = AdapterView.this.f4582z;
            AdapterView.this.f4582z = 0;
            AdapterView.this.f4580x = -1;
            AdapterView.this.f4581y = Long.MIN_VALUE;
            AdapterView.this.f4578v = -1;
            AdapterView.this.f4579w = Long.MIN_VALUE;
            AdapterView.this.f4571o = false;
            AdapterView.this.mo16074d();
            AdapterView.this.requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f4564e);
    }

    /* renamed from: com.meizu.common.widget.AdapterView$e */
    private class C1353e implements Runnable {
        private C1353e() {
        }

        public void run() {
            if (!AdapterView.this.f4577u) {
                AdapterView.this.mo16036a();
                AdapterView.this.mo16039b();
            } else if (AdapterView.this.getAdapter() != null) {
                AdapterView.this.post(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo16078e() {
        if (this.f4574r == null) {
            return;
        }
        if (this.f4573q || this.f4559D) {
            if (this.f4564e == null) {
                this.f4564e = new C1353e();
            }
            post(this.f4564e);
            return;
        }
        mo16036a();
        mo16039b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void mo16036a() {
        if (this.f4574r != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.f4574r.mo16112a(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.f4574r.mo16111a(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void mo16039b() {
        if (getSelectedItemPosition() >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        return selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        if (!super.onRequestSendAccessibilityEvent(view, accessibilityEvent)) {
            return false;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        onInitializeAccessibilityEvent(obtain);
        view.dispatchPopulateAccessibilityEvent(obtain);
        accessibilityEvent.appendRecord(obtain);
        return true;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AdapterView.class.getName());
        accessibilityNodeInfo.setScrollable(mo16509j());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AdapterView.class.getName());
        accessibilityEvent.setScrollable(mo16509j());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    /* renamed from: j */
    private boolean mo16509j() {
        int count;
        Adapter adapter = getAdapter();
        if (adapter == null || (count = adapter.getCount()) <= 0) {
            return false;
        }
        if (getFirstVisiblePosition() > 0 || getLastVisiblePosition() < count - 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean canAnimate() {
        return super.canAnimate() && this.f4582z > 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo16079f() {
        /*
            r5 = this;
            int r0 = r5.f4582z
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0041
            boolean r3 = r5.f4571o
            if (r3 == 0) goto L_0x001d
            r5.f4571o = r2
            int r3 = r5.mo16090h()
            if (r3 < 0) goto L_0x001d
            int r4 = r5.mo16070c(r3, r1)
            if (r4 != r3) goto L_0x001d
            r5.setNextSelectedPositionInt(r3)
            r3 = 1
            goto L_0x001e
        L_0x001d:
            r3 = 0
        L_0x001e:
            if (r3 != 0) goto L_0x003f
            int r4 = r5.getSelectedItemPosition()
            if (r4 < r0) goto L_0x0028
            int r0 = r0 - r1
            goto L_0x0029
        L_0x0028:
            r0 = r4
        L_0x0029:
            if (r0 >= 0) goto L_0x002c
            r0 = 0
        L_0x002c:
            int r4 = r5.mo16070c(r0, r1)
            if (r4 >= 0) goto L_0x0036
            int r4 = r5.mo16070c(r0, r2)
        L_0x0036:
            if (r4 < 0) goto L_0x003f
            r5.setNextSelectedPositionInt(r4)
            r5.mo16080g()
            goto L_0x0042
        L_0x003f:
            r1 = r3
            goto L_0x0042
        L_0x0041:
            r1 = 0
        L_0x0042:
            if (r1 != 0) goto L_0x0054
            r0 = -1
            r5.f4580x = r0
            r3 = -9223372036854775808
            r5.f4581y = r3
            r5.f4578v = r0
            r5.f4579w = r3
            r5.f4571o = r2
            r5.mo16080g()
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.AdapterView.mo16079f():void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo16080g() {
        if (this.f4580x != this.f4557B || this.f4581y != this.f4558C) {
            mo16078e();
            this.f4557B = this.f4580x;
            this.f4558C = this.f4581y;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public int mo16090h() {
        int i = this.f4582z;
        if (i == 0) {
            return -1;
        }
        long j = this.f4569m;
        int i2 = this.f4568l;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int i3 = i - 1;
        int min = Math.min(i3, Math.max(0, i2));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        Adapter adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i4 = min;
        int i5 = i4;
        loop0:
        while (true) {
            boolean z = false;
            while (SystemClock.uptimeMillis() <= uptimeMillis) {
                if (adapter.getItemId(min) != j) {
                    boolean z2 = i4 == i3;
                    boolean z3 = i5 == 0;
                    if (z2 && z3) {
                        break loop0;
                    } else if (z3 || (z && !z2)) {
                        i4++;
                        min = i4;
                    } else if (z2 || (!z && !z3)) {
                        i5--;
                        min = i5;
                        z = true;
                    }
                } else {
                    return min;
                }
            }
            break loop0;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void setSelectedPositionInt(int i) {
        this.f4580x = i;
        this.f4581y = mo16064a(i);
    }

    /* access modifiers changed from: package-private */
    public void setNextSelectedPositionInt(int i) {
        this.f4578v = i;
        this.f4579w = mo16064a(i);
        if (this.f4571o && this.f4572p == 0 && i >= 0) {
            this.f4568l = i;
            this.f4569m = this.f4579w;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo16091i() {
        if (getChildCount() > 0) {
            this.f4571o = true;
            this.f4570n = (long) this.f4560a;
            if (this.f4580x >= 0) {
                View childAt = getChildAt(this.f4580x - this.f4566j);
                this.f4569m = this.f4579w;
                this.f4568l = this.f4578v;
                if (childAt != null) {
                    this.f4567k = childAt.getTop();
                }
                this.f4572p = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            Adapter adapter = getAdapter();
            if (this.f4566j < 0 || this.f4566j >= adapter.getCount()) {
                this.f4569m = -1;
            } else {
                this.f4569m = adapter.getItemId(this.f4566j);
            }
            this.f4568l = this.f4566j;
            if (childAt2 != null) {
                this.f4567k = childAt2.getTop();
            }
            this.f4572p = 1;
        }
    }
}
