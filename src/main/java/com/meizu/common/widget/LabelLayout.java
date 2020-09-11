package com.meizu.common.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.core.view.GravityCompat;
import com.meizu.common.R;
import java.util.ArrayList;
import java.util.List;

@TargetApi(14)
public class LabelLayout extends ViewGroup {

    /* renamed from: a */
    private int f5526a;

    /* renamed from: b */
    private final List<List<View>> f5527b;

    /* renamed from: c */
    private final List<Integer> f5528c;

    /* renamed from: d */
    private final List<Integer> f5529d;

    /* renamed from: e */
    private int f5530e;

    /* renamed from: f */
    private Context f5531f;

    /* renamed from: g */
    private Typeface f5532g;

    /* renamed from: h */
    private C1451b f5533h;

    /* renamed from: i */
    private C1451b f5534i;

    /* renamed from: j */
    private C1451b f5535j;

    /* renamed from: k */
    private int f5536k;

    /* renamed from: l */
    private int f5537l;

    /* renamed from: m */
    private int f5538m;

    /* renamed from: n */
    private int f5539n;

    /* renamed from: o */
    private int f5540o;

    /* renamed from: p */
    private int f5541p;

    /* renamed from: q */
    private float f5542q;

    /* renamed from: r */
    private float f5543r;

    /* renamed from: s */
    private float f5544s;

    /* renamed from: t */
    private int f5545t;

    /* renamed from: u */
    private int f5546u;

    /* renamed from: v */
    private int f5547v;

    /* renamed from: w */
    private int f5548w;

    /* renamed from: com.meizu.common.widget.LabelLayout$a */
    public interface C1450a {
    }

    public enum LabelColor {
        NONE(-1509949440, -657931, -1710619),
        RED(-1623492, -5393, -342069),
        TOMATO(-164564, -3099, -9280),
        CORAL(-278266, -1823, -70219),
        LIME_GREEN(-14042030, -1640471, -4133941),
        SEA_GREEN(-16726847, -2296587, -5182741),
        BLUE(-14712837, -1969665, -4465922),
        PURPLE(-9092370, -1055236, -2636551);
        
        /* access modifiers changed from: private */
        @ColorInt
        public int mBgNormalColor;
        /* access modifiers changed from: private */
        @ColorInt
        public int mBgPressColor;
        /* access modifiers changed from: private */
        @ColorInt
        public int mTextColor;

        private LabelColor(int i, int i2, @ColorInt int i3) {
            this.mTextColor = i;
            this.mBgNormalColor = i2;
            this.mBgPressColor = i3;
        }

        public int getTextColor() {
            return this.mTextColor;
        }

        public int getBgNormalColor() {
            return this.mBgNormalColor;
        }

        public int getBgPressColor() {
            return this.mBgPressColor;
        }
    }

    public enum MiniLabelColor {
        NONE(855638016, -657931, -1710619),
        RED(-1, -1623492, -2674382),
        TOMATO(-1, -164564, -691422),
        CORAL(-1, -278266, -412155),
        LIME_GREEN(-1, -14042030, -14438326),
        SEA_GREEN(-1, -16726847, -16729675),
        BLUE(-1, -14712837, -14780688),
        PURPLE(-1, -9092370, -9748764);
        
        /* access modifiers changed from: private */
        @ColorInt
        public int mBgNormalColor;
        /* access modifiers changed from: private */
        @ColorInt
        public int mBgPressColor;
        /* access modifiers changed from: private */
        @ColorInt
        public int mTextColor;

        private MiniLabelColor(int i, int i2, @ColorInt int i3) {
            this.mTextColor = i;
            this.mBgNormalColor = i2;
            this.mBgPressColor = i3;
        }

        public int getTextColor() {
            return this.mTextColor;
        }

        public int getBgNormalColor() {
            return this.mBgNormalColor;
        }

        public int getBgPressColor() {
            return this.mBgPressColor;
        }
    }

    public LabelLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public LabelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LabelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5526a = (m5847b() ? GravityCompat.START : 3) | 48;
        this.f5527b = new ArrayList();
        this.f5528c = new ArrayList();
        this.f5529d = new ArrayList();
        this.f5530e = 100;
        this.f5531f = context;
        this.f5532g = Typeface.create("sans-serif-medium", 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LabelLayout, i, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelLayout_labelHeight, getResources().getDimensionPixelOffset(R.dimen.label_layout_label_height_default));
        this.f5538m = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelLayout_lineMargin, getResources().getDimensionPixelOffset(R.dimen.label_layout_line_margin_default));
        this.f5539n = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelLayout_itemMargin, getResources().getDimensionPixelOffset(R.dimen.label_layout_item_margin_default));
        this.f5536k = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelLayout_labelRadiusCorner, getResources().getDimensionPixelOffset(R.dimen.label_layout_label_radius_corner_default));
        this.f5537l = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.LabelLayout_hotWordsHeight, getResources().getDimensionPixelOffset(R.dimen.label_layout_hot_words_height_default));
        obtainStyledAttributes.recycle();
        this.f5540o = getResources().getDimensionPixelSize(R.dimen.label_layout_label_inner_space_default);
        this.f5542q = ((float) getResources().getDimensionPixelSize(R.dimen.label_layout_label_text_size_default)) / getResources().getDisplayMetrics().density;
        this.f5544s = ((float) getResources().getDimensionPixelSize(R.dimen.label_layout_hot_words_text_size_default)) / getResources().getDisplayMetrics().density;
        this.f5545t = getResources().getDimensionPixelSize(R.dimen.label_layout_icon_margin_left_right);
        this.f5546u = getResources().getDimensionPixelSize(R.dimen.label_layout_icon_margin_bottom);
        this.f5547v = getResources().getDimensionPixelSize(R.dimen.label_layout_icon_max_width);
        this.f5548w = getResources().getDimensionPixelSize(R.dimen.label_layout_icon_max_height);
        this.f5534i = m5846a(-2, getResources().getDimensionPixelOffset(R.dimen.label_layout_mini_label_height_default), getResources().getDimensionPixelOffset(R.dimen.label_layout_mini_line_margin_default), getResources().getDimensionPixelOffset(R.dimen.label_layout_mini_item_margin_default));
        this.f5541p = getResources().getDimensionPixelSize(R.dimen.label_layout_mini_label_inner_space_default);
        this.f5543r = ((float) getResources().getDimensionPixelSize(R.dimen.label_layout_mini_label_text_size_default)) / getResources().getDisplayMetrics().density;
        this.f5533h = m5846a(-2, dimensionPixelOffset, this.f5538m, this.f5539n);
        this.f5535j = m5846a(-2, this.f5537l, this.f5538m, this.f5539n);
    }

    /* renamed from: a */
    private C1451b m5846a(int i, int i2, int i3, int i4) {
        C1451b bVar = new C1451b(i, i2);
        bVar.setMargins(0, 0, 0, i3);
        bVar.setMarginEnd(i4);
        bVar.f5549a = 80;
        return bVar;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r20, int r21) {
        /*
            r19 = this;
            r6 = r19
            super.onMeasure(r20, r21)
            int r7 = android.view.View.MeasureSpec.getSize(r20)
            int r8 = android.view.View.MeasureSpec.getSize(r21)
            int r9 = android.view.View.MeasureSpec.getMode(r20)
            int r10 = android.view.View.MeasureSpec.getMode(r21)
            int r0 = r19.getPaddingTop()
            int r1 = r19.getPaddingBottom()
            int r0 = r0 + r1
            int r11 = r19.getChildCount()
            r16 = r0
            r5 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0028:
            r4 = 1073741824(0x40000000, float:2.0)
            if (r13 >= r11) goto L_0x00f2
            android.view.View r3 = r6.getChildAt(r13)
            int r0 = r11 + -1
            if (r13 != r0) goto L_0x0038
            r0 = 1
            r17 = 1
            goto L_0x003a
        L_0x0038:
            r17 = 0
        L_0x003a:
            int r0 = r3.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x004d
            if (r17 == 0) goto L_0x00ee
            int r0 = java.lang.Math.max(r14, r15)
            int r16 = r16 + r5
            r14 = r0
            goto L_0x00ee
        L_0x004d:
            r0 = r19
            r1 = r3
            r2 = r20
            r18 = r3
            r3 = r15
            r12 = 1073741824(0x40000000, float:2.0)
            r4 = r21
            r12 = r5
            r5 = r16
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
            android.view.ViewGroup$LayoutParams r0 = r18.getLayoutParams()
            com.meizu.common.widget.LabelLayout$b r0 = (com.meizu.common.widget.LabelLayout.C1451b) r0
            int r1 = r19.getPaddingLeft()
            int r1 = r7 - r1
            int r2 = r19.getPaddingRight()
            int r1 = r1 - r2
            int r2 = r0.width
            r3 = -1
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 != r3) goto L_0x0081
            int r2 = r0.leftMargin
            int r3 = r0.rightMargin
            int r2 = r2 + r3
            int r1 = r1 - r2
        L_0x007d:
            r2 = r1
            r1 = 1073741824(0x40000000, float:2.0)
            goto L_0x008b
        L_0x0081:
            int r2 = r0.width
            if (r2 < 0) goto L_0x0088
            int r1 = r0.width
            goto L_0x007d
        L_0x0088:
            r2 = r1
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x008b:
            int r3 = r0.height
            if (r3 < 0) goto L_0x0094
            int r3 = r0.height
            r4 = 1073741824(0x40000000, float:2.0)
            goto L_0x009a
        L_0x0094:
            if (r10 != 0) goto L_0x0099
            r3 = 0
            r4 = 0
            goto L_0x009a
        L_0x0099:
            r3 = r8
        L_0x009a:
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r4)
            r3 = r18
            r3.measure(r1, r2)
            int r1 = r3.getMeasuredWidth()
            int r2 = r0.leftMargin
            int r1 = r1 + r2
            int r2 = r0.rightMargin
            int r1 = r1 + r2
            int r2 = r15 + r1
            int r4 = r19.getPaddingLeft()
            int r4 = r7 - r4
            int r5 = r19.getPaddingRight()
            int r4 = r4 - r5
            if (r2 <= r4) goto L_0x00d3
            int r14 = java.lang.Math.max(r14, r15)
            int r16 = r16 + r12
            int r2 = r3.getMeasuredHeight()
            int r3 = r0.topMargin
            int r2 = r2 + r3
            int r0 = r0.bottomMargin
            int r2 = r2 + r0
            r15 = r1
            r0 = r2
            goto L_0x00e2
        L_0x00d3:
            int r1 = r3.getMeasuredHeight()
            int r3 = r0.topMargin
            int r1 = r1 + r3
            int r0 = r0.bottomMargin
            int r1 = r1 + r0
            int r0 = java.lang.Math.max(r12, r1)
            r15 = r2
        L_0x00e2:
            if (r17 == 0) goto L_0x00ed
            int r1 = java.lang.Math.max(r14, r15)
            int r16 = r16 + r0
            r5 = r0
            r14 = r1
            goto L_0x00ee
        L_0x00ed:
            r5 = r0
        L_0x00ee:
            int r13 = r13 + 1
            goto L_0x0028
        L_0x00f2:
            int r0 = r19.getPaddingLeft()
            int r1 = r19.getPaddingRight()
            int r0 = r0 + r1
            int r0 = r0 + r14
            r1 = 1073741824(0x40000000, float:2.0)
            if (r9 != r1) goto L_0x0101
            r0 = r7
        L_0x0101:
            if (r10 != r1) goto L_0x0104
            goto L_0x0106
        L_0x0104:
            r8 = r16
        L_0x0106:
            r6.setMeasuredDimension(r0, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.LabelLayout.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r24, int r25, int r26, int r27, int r28) {
        /*
            r23 = this;
            r0 = r23
            java.util.List<java.util.List<android.view.View>> r1 = r0.f5527b
            r1.clear()
            java.util.List<java.lang.Integer> r1 = r0.f5528c
            r1.clear()
            java.util.List<java.lang.Integer> r1 = r0.f5529d
            r1.clear()
            int r1 = r23.getWidth()
            int r2 = r23.getPaddingLeft()
            int r1 = r1 - r2
            int r2 = r23.getPaddingRight()
            int r1 = r1 - r2
            int r2 = r23.getHeight()
            int r3 = r23.getPaddingTop()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            int r5 = r0.f5526a
            r5 = r5 & 7
            r6 = 1
            if (r5 == r6) goto L_0x003b
            r7 = 5
            if (r5 == r7) goto L_0x0038
            r5 = 0
            goto L_0x003d
        L_0x0038:
            r5 = 1065353216(0x3f800000, float:1.0)
            goto L_0x003d
        L_0x003b:
            r5 = 1056964608(0x3f000000, float:0.5)
        L_0x003d:
            r10 = r3
            r8 = r4
            r3 = 0
            r4 = 0
            r9 = 0
        L_0x0042:
            int r11 = r23.getChildCount()
            r12 = 8
            if (r3 >= r11) goto L_0x00a8
            android.view.View r11 = r0.getChildAt(r3)
            int r13 = r11.getVisibility()
            if (r13 != r12) goto L_0x0055
            goto L_0x00a5
        L_0x0055:
            android.view.ViewGroup$LayoutParams r12 = r11.getLayoutParams()
            com.meizu.common.widget.LabelLayout$b r12 = (com.meizu.common.widget.LabelLayout.C1451b) r12
            int r13 = r11.getMeasuredWidth()
            int r14 = r12.leftMargin
            int r13 = r13 + r14
            int r14 = r12.rightMargin
            int r13 = r13 + r14
            int r14 = r11.getMeasuredHeight()
            int r15 = r12.bottomMargin
            int r14 = r14 + r15
            int r12 = r12.topMargin
            int r14 = r14 + r12
            int r12 = r9 + r13
            if (r12 <= r1) goto L_0x009d
            java.util.List<java.lang.Integer> r12 = r0.f5528c
            java.lang.Integer r15 = java.lang.Integer.valueOf(r4)
            r12.add(r15)
            java.util.List<java.util.List<android.view.View>> r12 = r0.f5527b
            r12.add(r8)
            java.util.List<java.lang.Integer> r8 = r0.f5529d
            int r9 = r1 - r9
            float r9 = (float) r9
            float r9 = r9 * r5
            int r9 = (int) r9
            int r12 = r23.getPaddingLeft()
            int r9 = r9 + r12
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r8.add(r9)
            int r10 = r10 + r4
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r4 = 0
            r9 = 0
        L_0x009d:
            int r9 = r9 + r13
            int r4 = java.lang.Math.max(r4, r14)
            r8.add(r11)
        L_0x00a5:
            int r3 = r3 + 1
            goto L_0x0042
        L_0x00a8:
            java.util.List<java.lang.Integer> r3 = r0.f5528c
            java.lang.Integer r11 = java.lang.Integer.valueOf(r4)
            r3.add(r11)
            java.util.List<java.util.List<android.view.View>> r3 = r0.f5527b
            r3.add(r8)
            java.util.List<java.lang.Integer> r3 = r0.f5529d
            int r1 = r1 - r9
            float r1 = (float) r1
            float r1 = r1 * r5
            int r1 = (int) r1
            int r5 = r23.getPaddingLeft()
            int r1 = r1 + r5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.add(r1)
            int r10 = r10 + r4
            int r1 = r0.f5526a
            r1 = r1 & 112(0x70, float:1.57E-43)
            r3 = 16
            r4 = 80
            if (r1 == r3) goto L_0x00db
            if (r1 == r4) goto L_0x00d8
            r1 = 0
            goto L_0x00de
        L_0x00d8:
            int r1 = r2 - r10
            goto L_0x00de
        L_0x00db:
            int r2 = r2 - r10
            int r1 = r2 / 2
        L_0x00de:
            java.util.List<java.util.List<android.view.View>> r2 = r0.f5527b
            int r2 = r2.size()
            int r3 = r23.getPaddingTop()
            int r5 = androidx.core.view.ViewCompat.getLayoutDirection(r23)
            if (r5 != r6) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r6 = 0
        L_0x00f0:
            r5 = r3
            r3 = 0
        L_0x00f2:
            if (r3 >= r2) goto L_0x022e
            java.util.List<java.lang.Integer> r8 = r0.f5528c
            java.lang.Object r8 = r8.get(r3)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.util.List<java.util.List<android.view.View>> r10 = r0.f5527b
            java.lang.Object r10 = r10.get(r3)
            java.util.List r10 = (java.util.List) r10
            java.util.List<java.lang.Integer> r11 = r0.f5529d
            java.lang.Object r11 = r11.get(r3)
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r6 == 0) goto L_0x011b
            int r13 = r23.getWidth()
            goto L_0x011c
        L_0x011b:
            r13 = 0
        L_0x011c:
            int r14 = r10.size()
            r15 = r13
            r13 = r11
            r11 = 0
        L_0x0123:
            if (r11 >= r14) goto L_0x0212
            java.lang.Object r16 = r10.get(r11)
            r7 = r16
            android.view.View r7 = (android.view.View) r7
            int r4 = r0.f5530e
            if (r3 < r4) goto L_0x0135
            r0.removeView(r7)
            goto L_0x013b
        L_0x0135:
            int r4 = r7.getVisibility()
            if (r4 != r12) goto L_0x0149
        L_0x013b:
            r17 = r2
            r20 = r6
            r22 = r8
            r18 = r9
            r19 = r10
            r21 = r14
            goto L_0x01fe
        L_0x0149:
            android.view.ViewGroup$LayoutParams r4 = r7.getLayoutParams()
            com.meizu.common.widget.LabelLayout$b r4 = (com.meizu.common.widget.LabelLayout.C1451b) r4
            int r12 = r4.height
            r17 = r2
            r2 = -1
            if (r12 != r2) goto L_0x0183
            int r12 = r4.width
            r18 = r9
            r9 = 1073741824(0x40000000, float:2.0)
            if (r12 != r2) goto L_0x0163
            r2 = r18
        L_0x0160:
            r12 = 1073741824(0x40000000, float:2.0)
            goto L_0x016e
        L_0x0163:
            int r2 = r4.width
            if (r2 < 0) goto L_0x016a
            int r2 = r4.width
            goto L_0x0160
        L_0x016a:
            r2 = r18
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x016e:
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r12)
            int r12 = r4.topMargin
            int r12 = r8 - r12
            r19 = r10
            int r10 = r4.bottomMargin
            int r12 = r12 - r10
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r9)
            r7.measure(r2, r9)
            goto L_0x0187
        L_0x0183:
            r18 = r9
            r19 = r10
        L_0x0187:
            int r2 = r7.getMeasuredWidth()
            int r9 = r7.getMeasuredHeight()
            int r10 = r4.f5549a
            boolean r10 = android.view.Gravity.isVertical(r10)
            if (r10 == 0) goto L_0x01b5
            int r10 = r4.f5549a
            r12 = 80
            if (r10 == r12) goto L_0x01ac
            switch(r10) {
                case 16: goto L_0x01a1;
                case 17: goto L_0x01a1;
                default: goto L_0x01a0;
            }
        L_0x01a0:
            goto L_0x01b5
        L_0x01a1:
            int r10 = r8 - r9
            int r12 = r4.topMargin
            int r10 = r10 - r12
            int r12 = r4.bottomMargin
            int r10 = r10 - r12
            int r10 = r10 / 2
            goto L_0x01b6
        L_0x01ac:
            int r10 = r8 - r9
            int r12 = r4.topMargin
            int r10 = r10 - r12
            int r12 = r4.bottomMargin
            int r10 = r10 - r12
            goto L_0x01b6
        L_0x01b5:
            r10 = 0
        L_0x01b6:
            if (r6 != 0) goto L_0x01dd
            int r12 = r4.leftMargin
            int r12 = r12 + r13
            r20 = r6
            int r6 = r4.topMargin
            int r6 = r6 + r5
            int r6 = r6 + r10
            int r6 = r6 + r1
            int r16 = r13 + r2
            r21 = r14
            int r14 = r4.leftMargin
            int r14 = r16 + r14
            int r9 = r9 + r5
            r22 = r8
            int r8 = r4.topMargin
            int r9 = r9 + r8
            int r9 = r9 + r10
            int r9 = r9 + r1
            r7.layout(r12, r6, r14, r9)
            int r6 = r4.leftMargin
            int r2 = r2 + r6
            int r4 = r4.rightMargin
            int r2 = r2 + r4
            int r13 = r13 + r2
            goto L_0x01fe
        L_0x01dd:
            r20 = r6
            r22 = r8
            r21 = r14
            int r6 = r15 - r2
            int r8 = r4.topMargin
            int r8 = r8 + r5
            int r8 = r8 + r10
            int r8 = r8 + r1
            int r9 = r9 + r5
            int r12 = r4.topMargin
            int r9 = r9 + r12
            int r9 = r9 + r10
            int r9 = r9 + r1
            r7.layout(r6, r8, r15, r9)
            int r6 = r4.getMarginEnd()
            int r2 = r2 + r6
            int r4 = r4.getMarginStart()
            int r2 = r2 + r4
            int r15 = r15 - r2
        L_0x01fe:
            int r11 = r11 + 1
            r2 = r17
            r9 = r18
            r10 = r19
            r6 = r20
            r14 = r21
            r8 = r22
            r4 = 80
            r12 = 8
            goto L_0x0123
        L_0x0212:
            r17 = r2
            r20 = r6
            r22 = r8
            r18 = r9
            int r2 = r0.f5530e
            if (r3 >= r2) goto L_0x0220
            int r5 = r5 + r22
        L_0x0220:
            int r3 = r3 + 1
            r2 = r17
            r9 = r18
            r6 = r20
            r4 = 80
            r12 = 8
            goto L_0x00f2
        L_0x022e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.LabelLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1451b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C1451b(layoutParams);
    }

    /* renamed from: a */
    public C1451b generateLayoutParams(AttributeSet attributeSet) {
        return new C1451b(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1451b generateDefaultLayoutParams() {
        return new C1451b(-1, -1);
    }

    @TargetApi(14)
    public void setGravity(int i) {
        if (this.f5526a != i) {
            if ((8388615 & i) == 0) {
                i |= m5847b() ? GravityCompat.START : 3;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f5526a = i;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.f5526a;
    }

    public void setMaxLine(int i) {
        this.f5530e = i;
    }

    /* renamed from: b */
    private static boolean m5847b() {
        return Build.VERSION.SDK_INT >= 14;
    }

    /* renamed from: com.meizu.common.widget.LabelLayout$b */
    public static class C1451b extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f5549a = -1;

        public C1451b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C1451b(int i, int i2) {
            super(i, i2);
        }

        public C1451b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
