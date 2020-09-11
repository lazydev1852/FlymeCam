package flyme.support.p093v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.LinearLayoutCompat;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.view.ActionBarPolicy;
import flyme.support.p093v7.view.menu.ActionMenuItemView;
import flyme.support.p093v7.view.menu.MenuBuilder;
import flyme.support.p093v7.view.menu.MenuItemImpl;
import flyme.support.p093v7.view.menu.MenuPresenter;
import flyme.support.p093v7.view.menu.MenuView;

/* renamed from: flyme.support.v7.widget.ActionMenuView */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.C3160b, MenuView {

    /* renamed from: a */
    private MenuBuilder f17524a;

    /* renamed from: b */
    private Context f17525b;

    /* renamed from: c */
    private int f17526c;

    /* renamed from: d */
    private boolean f17527d;

    /* renamed from: e */
    private ActionMenuPresenter f17528e;

    /* renamed from: f */
    private MenuPresenter.C3167a f17529f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MenuBuilder.C3159a f17530g;

    /* renamed from: h */
    private boolean f17531h;

    /* renamed from: i */
    private int f17532i;

    /* renamed from: j */
    private int f17533j;

    /* renamed from: k */
    private int f17534k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C3193d f17535l;

    /* renamed from: m */
    private boolean f17536m;

    /* renamed from: flyme.support.v7.widget.ActionMenuView$a */
    public interface C3190a {
        /* renamed from: c */
        boolean mo25500c();

        /* renamed from: d */
        boolean mo25501d();
    }

    /* renamed from: flyme.support.v7.widget.ActionMenuView$d */
    public interface C3193d {
        /* renamed from: a */
        boolean mo26002a(MenuItem menuItem);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f17533j = (int) (56.0f * f);
        this.f17534k = (int) (f * 4.0f);
        this.f17525b = context;
        this.f17526c = 0;
        setMotionEventSplittingEnabled(false);
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.f17526c != i) {
            this.f17526c = i;
            if (i == 0) {
                this.f17525b = getContext();
            } else {
                this.f17525b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f17526c;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f17528e = actionMenuPresenter;
        this.f17528e.mo25943a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.f17528e != null) {
            this.f17528e.mo25734a(false);
            if (this.f17528e.mo25954h()) {
                this.f17528e.mo25951e();
                this.f17528e.mo25950d();
            }
        }
    }

    public void setOnMenuItemClickListener(C3193d dVar) {
        this.f17535l = dVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z = this.f17531h;
        this.f17531h = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f17531h) {
            this.f17532i = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (!(!this.f17531h || this.f17524a == null || size == this.f17532i)) {
            this.f17532i = size;
            this.f17524a.mo25567b(true);
        }
        int childCount = getChildCount();
        if (!this.f17531h || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
                m19192a(layoutParams, i3, childCount);
            }
            super.onMeasure(i, i2);
            return;
        }
        m19191a(i, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x0269 A[LOOP:5: B:140:0x0269->B:145:0x028c, LOOP_START, PHI: r3 r29 
  PHI: (r3v5 int) = (r3v4 int), (r3v6 int) binds: [B:139:0x0267, B:145:0x028c] A[DONT_GENERATE, DONT_INLINE]
  PHI: (r29v1 int) = (r29v0 int), (r29v2 int) binds: [B:139:0x0267, B:145:0x028c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0298  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m19191a(int r32, int r33) {
        /*
            r31 = this;
            r0 = r31
            flyme.support.v7.widget.ActionMenuPresenter r1 = r0.f17528e
            boolean r1 = r1.mo25956j()
            if (r1 == 0) goto L_0x000e
            r31.m19194b(r32, r33)
            return
        L_0x000e:
            int r1 = android.view.View.MeasureSpec.getMode(r33)
            int r2 = android.view.View.MeasureSpec.getSize(r32)
            int r3 = android.view.View.MeasureSpec.getSize(r33)
            int r4 = r31.getPaddingLeft()
            int r5 = r31.getPaddingRight()
            int r4 = r4 + r5
            int r5 = r31.getPaddingTop()
            int r6 = r31.getPaddingBottom()
            int r5 = r5 + r6
            r6 = -2
            r7 = r33
            int r6 = getChildMeasureSpec(r7, r5, r6)
            int r2 = r2 - r4
            int r4 = r0.f17533j
            int r4 = r2 / r4
            int r7 = r0.f17533j
            int r7 = r2 % r7
            r8 = 0
            if (r4 != 0) goto L_0x0043
            r0.setMeasuredDimension(r2, r8)
            return
        L_0x0043:
            int r9 = r0.f17533j
            int r7 = r7 / r4
            int r9 = r9 + r7
            int r7 = r31.getChildCount()
            r14 = r4
            r4 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r19 = 0
        L_0x0055:
            if (r4 >= r7) goto L_0x00e2
            android.view.View r11 = r0.getChildAt(r4)
            int r8 = r11.getVisibility()
            r21 = r3
            r3 = 8
            if (r8 != r3) goto L_0x0069
            r23 = r2
            goto L_0x00d9
        L_0x0069:
            boolean r3 = r11 instanceof flyme.support.p093v7.view.menu.ActionMenuItemView
            int r13 = r13 + 1
            if (r3 == 0) goto L_0x007c
            int r8 = r0.f17534k
            r22 = r13
            int r13 = r0.f17534k
            r23 = r2
            r2 = 0
            r11.setPadding(r8, r2, r13, r2)
            goto L_0x0081
        L_0x007c:
            r23 = r2
            r22 = r13
            r2 = 0
        L_0x0081:
            android.view.ViewGroup$LayoutParams r8 = r11.getLayoutParams()
            flyme.support.v7.widget.ActionMenuView$LayoutParams r8 = (flyme.support.p093v7.widget.ActionMenuView.LayoutParams) r8
            r8.f17542f = r2
            r8.f17539c = r2
            r8.f17538b = r2
            r8.f17540d = r2
            r8.leftMargin = r2
            r8.rightMargin = r2
            if (r3 == 0) goto L_0x00a0
            r2 = r11
            flyme.support.v7.view.menu.ActionMenuItemView r2 = (flyme.support.p093v7.view.menu.ActionMenuItemView) r2
            boolean r2 = r2.mo25499b()
            if (r2 == 0) goto L_0x00a0
            r2 = 1
            goto L_0x00a1
        L_0x00a0:
            r2 = 0
        L_0x00a1:
            r8.f17541e = r2
            boolean r2 = r8.f17537a
            if (r2 == 0) goto L_0x00a9
            r2 = 1
            goto L_0x00aa
        L_0x00a9:
            r2 = r14
        L_0x00aa:
            int r2 = m19189a(r11, r9, r2, r6, r5)
            int r3 = java.lang.Math.max(r15, r2)
            boolean r13 = r8.f17540d
            if (r13 == 0) goto L_0x00b8
            int r16 = r16 + 1
        L_0x00b8:
            boolean r8 = r8.f17537a
            if (r8 == 0) goto L_0x00bd
            r12 = 1
        L_0x00bd:
            int r14 = r14 - r2
            int r8 = r11.getMeasuredHeight()
            int r10 = java.lang.Math.max(r10, r8)
            r8 = 1
            if (r2 != r8) goto L_0x00d3
            int r2 = r8 << r4
            r24 = r3
            long r2 = (long) r2
            long r2 = r19 | r2
            r19 = r2
            goto L_0x00d5
        L_0x00d3:
            r24 = r3
        L_0x00d5:
            r13 = r22
            r15 = r24
        L_0x00d9:
            int r4 = r4 + 1
            r3 = r21
            r2 = r23
            r8 = 0
            goto L_0x0055
        L_0x00e2:
            r23 = r2
            r21 = r3
            r2 = 2
            if (r12 == 0) goto L_0x00ed
            if (r13 != r2) goto L_0x00ed
            r3 = 1
            goto L_0x00ee
        L_0x00ed:
            r3 = 0
        L_0x00ee:
            r4 = 0
        L_0x00ef:
            if (r16 <= 0) goto L_0x019a
            if (r14 <= 0) goto L_0x019a
            r5 = 2147483647(0x7fffffff, float:NaN)
            r5 = 0
            r8 = 0
            r11 = 2147483647(0x7fffffff, float:NaN)
            r24 = 0
        L_0x00fd:
            if (r5 >= r7) goto L_0x013b
            android.view.View r22 = r0.getChildAt(r5)
            android.view.ViewGroup$LayoutParams r22 = r22.getLayoutParams()
            r2 = r22
            flyme.support.v7.widget.ActionMenuView$LayoutParams r2 = (flyme.support.p093v7.widget.ActionMenuView.LayoutParams) r2
            r26 = r4
            boolean r4 = r2.f17540d
            if (r4 != 0) goto L_0x0114
            r27 = r5
            goto L_0x0135
        L_0x0114:
            int r4 = r2.f17538b
            if (r4 >= r11) goto L_0x0125
            int r2 = r2.f17538b
            r4 = 1
            int r8 = r4 << r5
            r27 = r5
            long r4 = (long) r8
            r11 = r2
            r24 = r4
            r8 = 1
            goto L_0x0135
        L_0x0125:
            r27 = r5
            int r2 = r2.f17538b
            if (r2 != r11) goto L_0x0135
            r2 = 1
            int r4 = r2 << r27
            long r4 = (long) r4
            long r4 = r24 | r4
            int r8 = r8 + 1
            r24 = r4
        L_0x0135:
            int r5 = r27 + 1
            r4 = r26
            r2 = 2
            goto L_0x00fd
        L_0x013b:
            r26 = r4
            long r19 = r19 | r24
            if (r8 <= r14) goto L_0x0148
        L_0x0141:
            r29 = r6
            r30 = r7
            r28 = r10
            goto L_0x019d
        L_0x0148:
            int r11 = r11 + 1
            r2 = 0
        L_0x014b:
            if (r2 >= r7) goto L_0x0196
            android.view.View r4 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            flyme.support.v7.widget.ActionMenuView$LayoutParams r5 = (flyme.support.p093v7.widget.ActionMenuView.LayoutParams) r5
            r28 = r10
            r8 = 1
            int r10 = r8 << r2
            r29 = r6
            r30 = r7
            long r6 = (long) r10
            long r26 = r24 & r6
            r17 = 0
            int r8 = (r26 > r17 ? 1 : (r26 == r17 ? 0 : -1))
            if (r8 != 0) goto L_0x0170
            int r4 = r5.f17538b
            if (r4 != r11) goto L_0x018d
            long r19 = r19 | r6
            goto L_0x018d
        L_0x0170:
            if (r3 == 0) goto L_0x0183
            boolean r6 = r5.f17541e
            if (r6 == 0) goto L_0x0183
            r6 = 1
            if (r14 != r6) goto L_0x0184
            int r7 = r0.f17534k
            int r7 = r7 + r9
            int r8 = r0.f17534k
            r10 = 0
            r4.setPadding(r7, r10, r8, r10)
            goto L_0x0184
        L_0x0183:
            r6 = 1
        L_0x0184:
            int r4 = r5.f17538b
            int r4 = r4 + r6
            r5.f17538b = r4
            r5.f17542f = r6
            int r14 = r14 + -1
        L_0x018d:
            int r2 = r2 + 1
            r10 = r28
            r6 = r29
            r7 = r30
            goto L_0x014b
        L_0x0196:
            r2 = 2
            r4 = 1
            goto L_0x00ef
        L_0x019a:
            r26 = r4
            goto L_0x0141
        L_0x019d:
            if (r12 != 0) goto L_0x01a4
            r2 = 1
            if (r13 != r2) goto L_0x01a5
            r3 = 1
            goto L_0x01a6
        L_0x01a4:
            r2 = 1
        L_0x01a5:
            r3 = 0
        L_0x01a6:
            if (r14 <= 0) goto L_0x0262
            r4 = 0
            int r6 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0262
            int r13 = r13 - r2
            if (r14 < r13) goto L_0x01b5
            if (r3 != 0) goto L_0x01b5
            if (r15 <= r2) goto L_0x0262
        L_0x01b5:
            int r2 = java.lang.Long.bitCount(r19)
            float r2 = (float) r2
            if (r3 != 0) goto L_0x01f8
            r3 = 1
            long r3 = r19 & r3
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r4 = 1056964608(0x3f000000, float:0.5)
            if (r3 == 0) goto L_0x01d9
            r3 = 0
            android.view.View r5 = r0.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            flyme.support.v7.widget.ActionMenuView$LayoutParams r5 = (flyme.support.p093v7.widget.ActionMenuView.LayoutParams) r5
            boolean r5 = r5.f17541e
            if (r5 != 0) goto L_0x01da
            float r2 = r2 - r4
            goto L_0x01da
        L_0x01d9:
            r3 = 0
        L_0x01da:
            int r7 = r30 + -1
            r5 = 1
            int r6 = r5 << r7
            long r5 = (long) r6
            long r5 = r19 & r5
            r10 = 0
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x01f9
            android.view.View r5 = r0.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            flyme.support.v7.widget.ActionMenuView$LayoutParams r5 = (flyme.support.p093v7.widget.ActionMenuView.LayoutParams) r5
            boolean r5 = r5.f17541e
            if (r5 != 0) goto L_0x01f9
            float r2 = r2 - r4
            goto L_0x01f9
        L_0x01f8:
            r3 = 0
        L_0x01f9:
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0204
            int r14 = r14 * r9
            float r4 = (float) r14
            float r4 = r4 / r2
            int r8 = (int) r4
            goto L_0x0205
        L_0x0204:
            r8 = 0
        L_0x0205:
            r11 = r26
            r2 = r30
            r4 = 0
        L_0x020a:
            if (r4 >= r2) goto L_0x025f
            r5 = 1
            int r6 = r5 << r4
            long r5 = (long) r6
            long r5 = r19 & r5
            r12 = 0
            int r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r5 != 0) goto L_0x021b
            r5 = 1
            r7 = 2
            goto L_0x025c
        L_0x021b:
            android.view.View r5 = r0.getChildAt(r4)
            android.view.ViewGroup$LayoutParams r6 = r5.getLayoutParams()
            flyme.support.v7.widget.ActionMenuView$LayoutParams r6 = (flyme.support.p093v7.widget.ActionMenuView.LayoutParams) r6
            boolean r5 = r5 instanceof flyme.support.p093v7.view.menu.ActionMenuItemView
            if (r5 == 0) goto L_0x023e
            r6.f17539c = r8
            r5 = 1
            r6.f17542f = r5
            if (r4 != 0) goto L_0x023a
            boolean r5 = r6.f17541e
            if (r5 != 0) goto L_0x023a
            int r5 = -r8
            r7 = 2
            int r5 = r5 / r7
            r6.leftMargin = r5
            goto L_0x023b
        L_0x023a:
            r7 = 2
        L_0x023b:
            r5 = 1
        L_0x023c:
            r11 = 1
            goto L_0x025c
        L_0x023e:
            r7 = 2
            boolean r5 = r6.f17537a
            if (r5 == 0) goto L_0x024d
            r6.f17539c = r8
            r5 = 1
            r6.f17542f = r5
            int r10 = -r8
            int r10 = r10 / r7
            r6.rightMargin = r10
            goto L_0x023c
        L_0x024d:
            r5 = 1
            if (r4 == 0) goto L_0x0254
            int r10 = r8 / 2
            r6.leftMargin = r10
        L_0x0254:
            int r10 = r2 + -1
            if (r4 == r10) goto L_0x025c
            int r10 = r8 / 2
            r6.rightMargin = r10
        L_0x025c:
            int r4 = r4 + 1
            goto L_0x020a
        L_0x025f:
            r26 = r11
            goto L_0x0265
        L_0x0262:
            r2 = r30
            r3 = 0
        L_0x0265:
            r4 = 1073741824(0x40000000, float:2.0)
            if (r26 == 0) goto L_0x0291
        L_0x0269:
            if (r3 >= r2) goto L_0x0291
            android.view.View r5 = r0.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r6 = r5.getLayoutParams()
            flyme.support.v7.widget.ActionMenuView$LayoutParams r6 = (flyme.support.p093v7.widget.ActionMenuView.LayoutParams) r6
            boolean r7 = r6.f17542f
            if (r7 != 0) goto L_0x027c
            r7 = r29
            goto L_0x028c
        L_0x027c:
            int r7 = r6.f17538b
            int r7 = r7 * r9
            int r6 = r6.f17539c
            int r7 = r7 + r6
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r4)
            r7 = r29
            r5.measure(r6, r7)
        L_0x028c:
            int r3 = r3 + 1
            r29 = r7
            goto L_0x0269
        L_0x0291:
            if (r1 == r4) goto L_0x0298
            r2 = r23
            r1 = r28
            goto L_0x029c
        L_0x0298:
            r1 = r21
            r2 = r23
        L_0x029c:
            r0.setMeasuredDimension(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.p093v7.widget.ActionMenuView.m19191a(int, int):void");
    }

    /* renamed from: a */
    static int m19189a(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.mo25499b();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (layoutParams.f17537a || !z2) {
            z = false;
        }
        layoutParams.f17540d = z;
        layoutParams.f17538b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        if (!this.f17531h) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.f17528e.mo25956j()) {
            mo25973a(i9, i10, i11, i12);
        } else {
            int childCount = getChildCount();
            int i13 = (i12 - i10) / 2;
            int dividerWidth = getDividerWidth();
            int i14 = i11 - i9;
            int paddingRight = (i14 - getPaddingRight()) - getPaddingLeft();
            boolean a = C3352x.m20913a((View) this);
            int i15 = paddingRight;
            int i16 = 0;
            int i17 = 0;
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt = getChildAt(i18);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.f17537a) {
                        int measuredWidth = childAt.getMeasuredWidth();
                        if (mo25975a(i18)) {
                            measuredWidth += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            i7 = getPaddingLeft() + layoutParams.leftMargin;
                            i8 = i7 + measuredWidth;
                        } else {
                            i8 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                            i7 = i8 - measuredWidth;
                        }
                        int i19 = i13 - (measuredHeight / 2);
                        childAt.layout(i7, i19, i8, measuredHeight + i19);
                        i15 -= measuredWidth;
                        i16 = 1;
                    } else {
                        i15 -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                        boolean a2 = mo25975a(i18);
                        i17++;
                    }
                }
            }
            if (childCount == 1 && i16 == 0) {
                View childAt2 = getChildAt(0);
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                int i20 = (i14 / 2) - (measuredWidth2 / 2);
                int i21 = i13 - (measuredHeight2 / 2);
                childAt2.layout(i20, i21, measuredWidth2 + i20, measuredHeight2 + i21);
                return;
            }
            int i22 = i17 - (i16 ^ 1);
            if (i22 > 0) {
                i5 = i15 / i22;
                i6 = 0;
            } else {
                i6 = 0;
                i5 = 0;
            }
            int max = Math.max(i6, i5);
            if (a) {
                int width = getWidth() - getPaddingRight();
                while (i6 < childCount) {
                    View childAt3 = getChildAt(i6);
                    LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() != 8 && !layoutParams2.f17537a) {
                        int i23 = width - layoutParams2.rightMargin;
                        int measuredWidth3 = childAt3.getMeasuredWidth();
                        int measuredHeight3 = childAt3.getMeasuredHeight();
                        int i24 = i13 - (measuredHeight3 / 2);
                        childAt3.layout(i23 - measuredWidth3, i24, i23, measuredHeight3 + i24);
                        width = i23 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                    }
                    i6++;
                }
                return;
            }
            int paddingLeft = getPaddingLeft();
            while (i6 < childCount) {
                View childAt4 = getChildAt(i6);
                LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
                if (childAt4.getVisibility() != 8 && !layoutParams3.f17537a) {
                    int i25 = paddingLeft + layoutParams3.leftMargin;
                    int measuredWidth4 = childAt4.getMeasuredWidth();
                    int measuredHeight4 = childAt4.getMeasuredHeight();
                    int i26 = i13 - (measuredHeight4 / 2);
                    childAt4.layout(i25, i26, i25 + measuredWidth4, measuredHeight4 + i26);
                    paddingLeft = i25 + measuredWidth4 + layoutParams3.rightMargin + max;
                }
                i6++;
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo25988i();
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        this.f17528e.mo25942a(drawable);
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.f17528e.mo25946c();
    }

    /* renamed from: a */
    public boolean mo25974a() {
        return this.f17527d;
    }

    public void setOverflowReserved(boolean z) {
        this.f17527d = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    /* renamed from: c */
    public LayoutParams mo25977c() {
        LayoutParams b = generateDefaultLayoutParams();
        b.f17537a = true;
        return b;
    }

    /* renamed from: a */
    public boolean mo25523a(MenuItemImpl menuItemImpl) {
        return this.f17524a.mo25551a((MenuItem) menuItemImpl, 0);
    }

    /* renamed from: a */
    public void mo25522a(MenuBuilder menuBuilder) {
        this.f17524a = menuBuilder;
    }

    public Menu getMenu() {
        if (this.f17524a == null) {
            Context context = getContext();
            this.f17524a = new MenuBuilder(context);
            this.f17524a.mo25545a((MenuBuilder.C3159a) new C3192c());
            this.f17528e = new ActionMenuPresenter(context);
            this.f17528e.mo25945b(true);
            this.f17528e.mo25733a(this.f17529f != null ? this.f17529f : new C3191b());
            this.f17524a.mo25548a((MenuPresenter) this.f17528e, this.f17525b);
            this.f17528e.mo25943a(this);
        }
        return this.f17524a;
    }

    public void setMenuCallbacks(MenuPresenter.C3167a aVar, MenuBuilder.C3159a aVar2) {
        this.f17529f = aVar;
        this.f17530g = aVar2;
    }

    /* renamed from: d */
    public MenuBuilder mo25978d() {
        return this.f17524a;
    }

    /* renamed from: e */
    public boolean mo25980e() {
        return this.f17528e != null && this.f17528e.mo25950d();
    }

    /* renamed from: f */
    public boolean mo25981f() {
        return this.f17528e != null && this.f17528e.mo25951e();
    }

    /* renamed from: g */
    public boolean mo25982g() {
        return this.f17528e != null && this.f17528e.mo25954h();
    }

    /* renamed from: h */
    public boolean mo25987h() {
        return this.f17528e != null && this.f17528e.mo25955i();
    }

    /* renamed from: i */
    public void mo25988i() {
        if (this.f17528e != null) {
            this.f17528e.mo25952f();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo25975a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C3190a)) {
            z = false | ((C3190a) childAt).mo25501d();
        }
        return (i <= 0 || !(childAt2 instanceof C3190a)) ? z : z | ((C3190a) childAt2).mo25500c();
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f17528e.mo25948c(z);
    }

    /* renamed from: flyme.support.v7.widget.ActionMenuView$c */
    private class C3192c implements MenuBuilder.C3159a {
        private C3192c() {
        }

        /* renamed from: a */
        public boolean mo25220a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return ActionMenuView.this.f17535l != null && ActionMenuView.this.f17535l.mo26002a(menuItem);
        }

        /* renamed from: a */
        public void mo25219a(MenuBuilder menuBuilder) {
            if (ActionMenuView.this.f17530g != null) {
                ActionMenuView.this.f17530g.mo25219a(menuBuilder);
            }
        }
    }

    /* renamed from: flyme.support.v7.widget.ActionMenuView$b */
    private class C3191b implements MenuPresenter.C3167a {
        /* renamed from: a */
        public void mo25242a(MenuBuilder menuBuilder, boolean z) {
        }

        /* renamed from: a_ */
        public boolean mo25243a_(MenuBuilder menuBuilder) {
            return false;
        }

        private C3191b() {
        }
    }

    /* renamed from: flyme.support.v7.widget.ActionMenuView$LayoutParams */
    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty

        /* renamed from: a */
        public boolean f17537a;
        @ViewDebug.ExportedProperty

        /* renamed from: b */
        public int f17538b;
        @ViewDebug.ExportedProperty

        /* renamed from: c */
        public int f17539c;
        @ViewDebug.ExportedProperty

        /* renamed from: d */
        public boolean f17540d;
        @ViewDebug.ExportedProperty

        /* renamed from: e */
        public boolean f17541e;

        /* renamed from: f */
        boolean f17542f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f17537a = layoutParams.f17537a;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f17537a = false;
        }
    }

    /* renamed from: a */
    static int m19188a(View view, int i, int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2) - i3, View.MeasureSpec.getMode(i2));
        ((LayoutParams) view.getLayoutParams()).f17538b = 1;
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), makeMeasureSpec);
        return 1;
    }

    private int getExtraPadding() {
        boolean z;
        int i = 0;
        while (true) {
            if (i < getChildCount()) {
                if ((getChildAt(i) instanceof ActionMenuItemView) && ((ActionMenuItemView) getChildAt(i)).getItemData().getIcon() != null) {
                    z = false;
                    break;
                }
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            return 0;
        }
        return ActionBarPolicy.m18758a(getContext()).mo25420i();
    }

    /* renamed from: b */
    private void m19194b(int i, int i2) {
        int extraPadding = getExtraPadding();
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight() + (extraPadding * 2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int childCount = getChildCount();
        if (childCount == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        int i4 = i3 / childCount;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                boolean z = childAt instanceof ActionMenuItemView;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f17542f = false;
                layoutParams.f17539c = 0;
                layoutParams.f17538b = 0;
                layoutParams.f17540d = false;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.f17541e = z && ((ActionMenuItemView) childAt).mo25499b();
                i6 = Math.max(i6, m19188a(childAt, i4, childMeasureSpec, paddingTop));
                i5 = Math.max(i5, childAt.getMeasuredHeight());
            }
        }
        if (mode != 1073741824) {
            size2 = i5;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size2);
    }

    public void setBottonBarStyleDivider() {
        setButtonBarStyleDivider();
    }

    public void setButtonBarStyleDivider() {
        setShowDividers(2);
        setDividerDrawable(getResources().getDrawable(R.drawable.mz_button_bar_style_divider));
        setDividerPadding(getResources().getDimensionPixelSize(R.dimen.mz_button_bar_style_divider_padding));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25973a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int width;
        int i7;
        int extraPadding = getExtraPadding();
        int childCount = getChildCount();
        int i8 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i3 - i;
        int paddingRight = ((i9 - getPaddingRight()) - getPaddingLeft()) - (extraPadding * 2);
        boolean a = C3352x.m20913a((View) this);
        int i10 = paddingRight;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f17537a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (mo25975a(i13)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a) {
                        i7 = extraPadding + getPaddingLeft() + layoutParams.leftMargin;
                        width = i7 + measuredWidth;
                    } else {
                        width = ((getWidth() - extraPadding) - getPaddingRight()) - layoutParams.rightMargin;
                        i7 = width - measuredWidth;
                    }
                    int i14 = width;
                    int i15 = i8 - (measuredHeight / 2);
                    childAt.layout(i7, i15, i14, measuredHeight + i15);
                    i10 -= measuredWidth;
                    i11 = 1;
                } else {
                    i10 -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    boolean a2 = mo25975a(i13);
                    i12++;
                }
            }
        }
        if (childCount == 1 && i11 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i16 = (i9 / 2) - (measuredWidth2 / 2);
            int i17 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i16, i17, measuredWidth2 + i16, measuredHeight2 + i17);
            return;
        }
        int i18 = i12 - (1 ^ i11);
        if (i18 > 0) {
            i5 = i10 / i18;
            i6 = 0;
        } else {
            i6 = 0;
            i5 = 0;
        }
        int max = Math.max(i6, i5);
        if (a) {
            int width2 = (getWidth() - getPaddingRight()) - extraPadding;
            while (i6 < childCount) {
                View childAt3 = getChildAt(i6);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f17537a) {
                    int i19 = width2 - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i20 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i19 - measuredWidth3, i20, i19, measuredHeight3 + i20);
                    width2 = i19 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
                i6++;
            }
            return;
        }
        int paddingLeft = getPaddingLeft() + extraPadding;
        while (i6 < childCount) {
            View childAt4 = getChildAt(i6);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f17537a) {
                int i21 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i22 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i21, i22, i21 + measuredWidth4, measuredHeight4 + i22);
                paddingLeft = i21 + measuredWidth4 + layoutParams3.rightMargin + max;
            }
            i6++;
        }
    }

    /* renamed from: a */
    private void m19192a(LayoutParams layoutParams, int i, int i2) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mz_action_overflow_btn_margin_right);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mz_action_menu_item_last_margin_right);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.mz_action_menu_item_next_overflow_margin_right);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.mz_action_menu_item_margin_right);
        if (Build.VERSION.SDK_INT < 21 && i == 0) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.mz_action_menu_item_margin_left_lower_version);
        }
        if (!layoutParams.f17537a) {
            if (this.f17536m && i == i2 - 2) {
                dimensionPixelSize2 = dimensionPixelSize3;
            } else if (this.f17536m || i != i2 - 1) {
                dimensionPixelSize2 = dimensionPixelSize4;
            }
            layoutParams.setMarginEnd(dimensionPixelSize2);
            layoutParams.resolveLayoutDirection(getLayoutDirection());
        } else if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginEnd(dimensionPixelSize);
            layoutParams.resolveLayoutDirection(getLayoutDirection());
        } else {
            layoutParams.rightMargin = dimensionPixelSize;
        }
    }

    public void setHasOverflow(boolean z) {
        this.f17536m = z;
    }

    public void setOverflowDrawable(Drawable drawable) {
        if (this.f17528e != null) {
            this.f17528e.mo25944b(drawable);
        }
    }
}
