package com.meizu.common.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SpinnerAdapter;
import com.meizu.common.widget.AdapterView;

public abstract class AbsSpinner extends AdapterView<SpinnerAdapter> {

    /* renamed from: E */
    private DataSetObserver f4541E;

    /* renamed from: F */
    private Rect f4542F;

    /* renamed from: a */
    SpinnerAdapter f4543a;

    /* renamed from: b */
    int f4544b;

    /* renamed from: c */
    int f4545c;

    /* renamed from: d */
    int f4546d;

    /* renamed from: e */
    int f4547e;

    /* renamed from: f */
    int f4548f;

    /* renamed from: g */
    int f4549g;

    /* renamed from: h */
    final Rect f4550h;

    /* renamed from: i */
    final C1347a f4551i;

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo16040b(int i, boolean z);

    public AbsSpinner(Context context) {
        super(context);
        this.f4546d = 0;
        this.f4547e = 0;
        this.f4548f = 0;
        this.f4549g = 0;
        this.f4550h = new Rect();
        this.f4551i = new C1347a();
        mo16509j();
    }

    public AbsSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4546d = 0;
        this.f4547e = 0;
        this.f4548f = 0;
        this.f4549g = 0;
        this.f4550h = new Rect();
        this.f4551i = new C1347a();
        mo16509j();
    }

    /* renamed from: j */
    private void mo16509j() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f4543a != null) {
            this.f4543a.unregisterDataSetObserver(this.f4541E);
            mo16036a();
        }
        this.f4543a = spinnerAdapter;
        int i = -1;
        this.f4557B = -1;
        this.f4558C = Long.MIN_VALUE;
        if (this.f4543a != null) {
            this.f4556A = this.f4582z;
            this.f4582z = this.f4543a.getCount();
            mo16074d();
            this.f4541E = new AdapterView.C1349a();
            this.f4543a.registerDataSetObserver(this.f4541E);
            if (this.f4582z > 0) {
                i = 0;
            }
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            if (this.f4582z == 0) {
                mo16080g();
            }
        } else {
            mo16074d();
            mo16036a();
            mo16080g();
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo16036a() {
        this.f4577u = false;
        this.f4571o = false;
        removeAllViewsInLayout();
        this.f4557B = -1;
        this.f4558C = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r7)
            android.graphics.Rect r1 = r6.f4550h
            int r2 = r6.getPaddingLeft()
            int r3 = r6.f4546d
            if (r2 <= r3) goto L_0x0013
            int r2 = r6.getPaddingLeft()
            goto L_0x0015
        L_0x0013:
            int r2 = r6.f4546d
        L_0x0015:
            r1.left = r2
            android.graphics.Rect r1 = r6.f4550h
            int r2 = r6.getPaddingTop()
            int r3 = r6.f4547e
            if (r2 <= r3) goto L_0x0026
            int r2 = r6.getPaddingTop()
            goto L_0x0028
        L_0x0026:
            int r2 = r6.f4547e
        L_0x0028:
            r1.top = r2
            android.graphics.Rect r1 = r6.f4550h
            int r2 = r6.getPaddingRight()
            int r3 = r6.f4548f
            if (r2 <= r3) goto L_0x0039
            int r2 = r6.getPaddingRight()
            goto L_0x003b
        L_0x0039:
            int r2 = r6.f4548f
        L_0x003b:
            r1.right = r2
            android.graphics.Rect r1 = r6.f4550h
            int r2 = r6.getPaddingBottom()
            int r3 = r6.f4549g
            if (r2 <= r3) goto L_0x004c
            int r2 = r6.getPaddingBottom()
            goto L_0x004e
        L_0x004c:
            int r2 = r6.f4549g
        L_0x004e:
            r1.bottom = r2
            boolean r1 = r6.f4577u
            if (r1 == 0) goto L_0x0057
            r6.mo16079f()
        L_0x0057:
            int r1 = r6.getSelectedItemPosition()
            r2 = 1
            r3 = 0
            if (r1 < 0) goto L_0x00bf
            android.widget.SpinnerAdapter r4 = r6.f4543a
            if (r4 == 0) goto L_0x00bf
            android.widget.SpinnerAdapter r4 = r6.f4543a
            int r4 = r4.getCount()
            if (r1 >= r4) goto L_0x00bf
            com.meizu.common.widget.AbsSpinner$a r4 = r6.f4551i
            android.view.View r4 = r4.mo16061a(r1)
            if (r4 != 0) goto L_0x0083
            android.widget.SpinnerAdapter r4 = r6.f4543a
            r5 = 0
            android.view.View r4 = r4.getView(r1, r5, r6)
            int r5 = r4.getImportantForAccessibility()
            if (r5 != 0) goto L_0x0083
            r4.setImportantForAccessibility(r2)
        L_0x0083:
            if (r4 == 0) goto L_0x008a
            com.meizu.common.widget.AbsSpinner$a r5 = r6.f4551i
            r5.mo16063a(r1, r4)
        L_0x008a:
            if (r4 == 0) goto L_0x00bf
            android.view.ViewGroup$LayoutParams r1 = r4.getLayoutParams()
            if (r1 != 0) goto L_0x009d
            r6.f4559D = r2
            android.view.ViewGroup$LayoutParams r1 = r6.generateDefaultLayoutParams()
            r4.setLayoutParams(r1)
            r6.f4559D = r3
        L_0x009d:
            r6.measureChild(r4, r7, r8)
            int r1 = r6.mo16035a(r4)
            android.graphics.Rect r2 = r6.f4550h
            int r2 = r2.top
            int r1 = r1 + r2
            android.graphics.Rect r2 = r6.f4550h
            int r2 = r2.bottom
            int r1 = r1 + r2
            int r2 = r6.mo16038b(r4)
            android.graphics.Rect r4 = r6.f4550h
            int r4 = r4.left
            int r2 = r2 + r4
            android.graphics.Rect r4 = r6.f4550h
            int r4 = r4.right
            int r2 = r2 + r4
            r4 = r2
            r2 = 0
            goto L_0x00c1
        L_0x00bf:
            r1 = 0
            r4 = 0
        L_0x00c1:
            if (r2 == 0) goto L_0x00d8
            android.graphics.Rect r1 = r6.f4550h
            int r1 = r1.top
            android.graphics.Rect r2 = r6.f4550h
            int r2 = r2.bottom
            int r1 = r1 + r2
            if (r0 != 0) goto L_0x00d8
            android.graphics.Rect r0 = r6.f4550h
            int r0 = r0.left
            android.graphics.Rect r2 = r6.f4550h
            int r2 = r2.right
            int r4 = r0 + r2
        L_0x00d8:
            int r0 = r6.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r1, r0)
            int r1 = r6.getSuggestedMinimumWidth()
            int r1 = java.lang.Math.max(r4, r1)
            int r0 = resolveSizeAndState(r0, r8, r3)
            int r1 = resolveSizeAndState(r1, r7, r3)
            r6.setMeasuredDimension(r1, r0)
            r6.f4544b = r8
            r6.f4545c = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.AbsSpinner.onMeasure(int, int):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo16035a(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo16038b(View view) {
        return view.getMeasuredWidth();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo16039b() {
        int childCount = getChildCount();
        C1347a aVar = this.f4551i;
        int i = this.f4566j;
        for (int i2 = 0; i2 < childCount; i2++) {
            aVar.mo16063a(i + i2, getChildAt(i2));
        }
    }

    public void setSelection(int i, boolean z) {
        boolean z2 = true;
        if (!z || this.f4566j > i || i > (this.f4566j + getChildCount()) - 1) {
            z2 = false;
        }
        mo16037a(i, z2);
    }

    public void setSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo16037a(int i, boolean z) {
        if (i != this.f4557B) {
            this.f4559D = true;
            setNextSelectedPositionInt(i);
            mo16040b(i - this.f4580x, z);
            this.f4559D = false;
        }
    }

    public View getSelectedView() {
        if (this.f4582z <= 0 || this.f4580x < 0) {
            return null;
        }
        return getChildAt(this.f4580x - this.f4566j);
    }

    public void requestLayout() {
        if (!this.f4559D) {
            super.requestLayout();
        }
    }

    public SpinnerAdapter getAdapter() {
        return this.f4543a;
    }

    public int getCount() {
        return this.f4582z;
    }

    /* renamed from: a */
    public int mo16034a(int i, int i2) {
        Rect rect = this.f4542F;
        if (rect == null) {
            this.f4542F = new Rect();
            rect = this.f4542F;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return this.f4566j + childCount;
                }
            }
        }
        return -1;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        long f4552a;

        /* renamed from: b */
        int f4553b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f4552a = parcel.readLong();
            this.f4553b = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f4552a);
            parcel.writeInt(this.f4553b);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.f4552a + " position=" + this.f4553b + "}";
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4552a = getSelectedItemId();
        if (savedState.f4552a >= 0) {
            savedState.f4553b = getSelectedItemPosition();
        } else {
            savedState.f4553b = -1;
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f4552a >= 0) {
            this.f4577u = true;
            this.f4571o = true;
            this.f4569m = savedState.f4552a;
            this.f4568l = savedState.f4553b;
            this.f4572p = 0;
            requestLayout();
        }
    }

    /* renamed from: com.meizu.common.widget.AbsSpinner$a */
    class C1347a {

        /* renamed from: b */
        private final SparseArray<View> f4555b = new SparseArray<>();

        C1347a() {
        }

        /* renamed from: a */
        public void mo16063a(int i, View view) {
            this.f4555b.put(i, view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public View mo16061a(int i) {
            View view = this.f4555b.get(i);
            if (view != null) {
                this.f4555b.delete(i);
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo16062a() {
            SparseArray<View> sparseArray = this.f4555b;
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                View valueAt = sparseArray.valueAt(i);
                if (valueAt != null) {
                    AbsSpinner.this.removeDetachedView(valueAt, true);
                }
            }
            sparseArray.clear();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AbsSpinner.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AbsSpinner.class.getName());
    }
}
