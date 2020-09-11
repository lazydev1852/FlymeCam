package com.meizu.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.widget.ScrollTextView;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class CustomTimePicker extends FrameLayout {

    /* renamed from: A */
    private int f4881A;

    /* renamed from: B */
    private int f4882B;

    /* renamed from: C */
    private int f4883C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public int f4884D;

    /* renamed from: E */
    private int f4885E;

    /* renamed from: F */
    private int f4886F;

    /* renamed from: G */
    private int f4887G;

    /* renamed from: H */
    private int f4888H;

    /* renamed from: I */
    private FrameLayout f4889I;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f4890a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f4891b;

    /* renamed from: c */
    private Boolean f4892c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f4893d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1390a f4894e;

    /* renamed from: f */
    private C1391b f4895f;

    /* renamed from: g */
    private ScrollTextView f4896g;

    /* renamed from: h */
    private ScrollTextView f4897h;

    /* renamed from: i */
    private ScrollTextView f4898i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final String f4899j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final String f4900k;

    /* renamed from: l */
    private TextView f4901l;

    /* renamed from: m */
    private TextView f4902m;

    /* renamed from: n */
    private TextView f4903n;

    /* renamed from: o */
    private TextView f4904o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f4905p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f4906q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public Object f4907r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public volatile Locale f4908s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public String[] f4909t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f4910u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f4911v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f4912w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f4913x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public final Calendar f4914y;

    /* renamed from: z */
    private int f4915z;

    /* renamed from: com.meizu.common.widget.CustomTimePicker$c */
    private class C1392c implements ScrollTextView.C1497b {

        /* renamed from: a */
        int f4940a = 0;

        C1392c(int i) {
            this.f4940a = i;
        }

        /* renamed from: a */
        public void mo16383a(View view, int i, int i2) {
            int i3 = this.f4940a;
            boolean z = true;
            if (i3 != 5) {
                switch (i3) {
                    case 1:
                        int unused = CustomTimePicker.this.f4890a = i2;
                        return;
                    case 2:
                        int unused2 = CustomTimePicker.this.f4891b = i2;
                        return;
                    case 3:
                        CustomTimePicker customTimePicker = CustomTimePicker.this;
                        if (i2 != 0) {
                            z = false;
                        }
                        boolean unused3 = customTimePicker.f4893d = z;
                        return;
                    default:
                        return;
                }
            } else {
                int unused4 = CustomTimePicker.this.f4911v = i2 + 1;
            }
        }

        /* renamed from: c */
        public String mo16387c(int i) {
            int i2 = this.f4940a;
            if (i2 != 5) {
                switch (i2) {
                    case 1:
                        if (CustomTimePicker.this.mo16347a()) {
                            return String.valueOf(i);
                        }
                        if (i == 0) {
                            i = 12;
                        }
                        return String.valueOf(i);
                    case 2:
                        return String.valueOf(i);
                    case 3:
                        if (i == 0) {
                            return CustomTimePicker.this.f4899j;
                        }
                        if (i == 1) {
                            return CustomTimePicker.this.f4900k;
                        }
                        return null;
                    default:
                        return null;
                }
            } else if (CustomTimePicker.this.f4905p) {
                return CustomTimePicker.this.m5417b(i);
            } else {
                return String.valueOf(i + 1);
            }
        }
    }

    public CustomTimePicker(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4890a = 0;
        this.f4891b = 0;
        this.f4892c = false;
        this.f4893d = true;
        this.f4905p = false;
        this.f4906q = false;
        this.f4907r = new Object();
        this.f4910u = 5;
        this.f4914y = Calendar.getInstance();
        try {
            this.f4890a = this.f4914y.get(11);
            this.f4891b = this.f4914y.get(12);
            this.f4892c = Boolean.valueOf(DateFormat.is24HourFormat(context));
        } catch (Exception unused) {
            this.f4890a = 12;
            this.f4891b = 30;
            this.f4892c = true;
        }
        if (!this.f4892c.booleanValue() && this.f4890a >= 12) {
            this.f4890a -= 12;
            this.f4893d = false;
        }
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.f4899j = amPmStrings[0];
        this.f4900k = amPmStrings[1];
        this.f4881A = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_normal_word_size);
        this.f4915z = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_word_size);
        this.f4883C = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_normal_number_size);
        this.f4882B = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size);
        m5419b();
        setBackgroundColor(-1);
    }

    /* renamed from: b */
    private void m5419b() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        getResources().getDisplayMetrics();
        this.f4910u = 3;
        int i = R.layout.mc_custom_picker_24hour;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mc_custom_time_picker_select_h);
        inflate(getContext(), i, this);
        this.f4889I = (FrameLayout) findViewById(R.id.picker_holder);
        this.f4903n = (TextView) findViewById(R.id.mc_scroll_hour_text);
        if (this.f4903n != null) {
            this.f4903n.setText(R.string.mc_date_time_hour);
        }
        this.f4904o = (TextView) findViewById(R.id.mc_scroll_min_text);
        if (this.f4904o != null) {
            this.f4904o.setText(R.string.mc_date_time_min);
        }
        this.f4896g = (ScrollTextView) findViewById(R.id.mc_scroll_hour);
        this.f4896g.setData(new C1392c(1), -1.0f, this.f4890a, this.f4892c.booleanValue() ? 24 : 12, this.f4910u, 0, this.f4892c.booleanValue() ? 23 : 11, true);
        float f = (float) dimensionPixelOffset;
        this.f4896g.setSelectItemHeight(f);
        this.f4897h = (ScrollTextView) findViewById(R.id.mc_scroll_min);
        this.f4897h.setData(new C1392c(2), -1.0f, this.f4891b, 60, this.f4910u, 0, 59, true);
        this.f4897h.setSelectItemHeight(f);
        this.f4898i = (ScrollTextView) findViewById(R.id.mc_scroll_ampm);
        this.f4898i.setData(new C1392c(3), -1.0f, this.f4893d ^ true ? 1 : 0, 2, this.f4910u, 0, 1, false);
        this.f4898i.setTextSize(getContext().getResources().getDimension(R.dimen.mz_picker_selected_ampm_size), getContext().getResources().getDimension(R.dimen.mz_picker_unselected_ampm_size));
        this.f4898i.setSelectItemHeight(f);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mc_column_ampm);
        if (this.f4892c.booleanValue()) {
            frameLayout.setVisibility(8);
        } else {
            frameLayout.setVisibility(0);
        }
        this.f4901l = (TextView) findViewById(R.id.mc_scroll_month_text);
        if (this.f4901l != null) {
            this.f4901l.setText(R.string.mc_date_time_month);
        }
        this.f4902m = (TextView) findViewById(R.id.mc_scroll_day_text);
        if (this.f4902m != null) {
            this.f4902m.setText(R.string.mc_date_time_day);
        }
        Calendar instance = Calendar.getInstance();
        this.f4913x = instance.get(1);
        this.f4912w = instance.get(2);
        this.f4911v = instance.get(5);
        int actualMaximum = instance.getActualMaximum(5);
        this.f4894e = new C1390a((ScrollTextView) findViewById(R.id.mc_scroll_day));
        this.f4894e.mo16369a(new C1392c(5), -1, this.f4911v - 1, actualMaximum, this.f4910u, this.f4911v - 1, actualMaximum - 1, true);
        this.f4894e.mo16366a(dimensionPixelOffset);
        this.f4895f = new C1391b((ScrollTextView) findViewById(R.id.mc_scroll_month));
        this.f4895f.mo16384a((ScrollTextView.C1497b) null, -1.0f, m5407a(this.f4912w), 12, this.f4910u, 0, 11, false);
        this.f4895f.mo16380a(dimensionPixelOffset);
        m5426d();
    }

    /* renamed from: c */
    private void m5422c() {
        int i = this.f4905p ? this.f4887G : this.f4886F;
        m5412a(i, !this.f4905p, true);
        setTextColor(i, this.f4888H, i);
    }

    /* renamed from: d */
    private void m5426d() {
        this.f4886F = getResources().getColor(R.color.mc_custom_date_picker_selected_lunar_color);
        this.f4887G = getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color);
        this.f4888H = getResources().getColor(R.color.mc_custom_date_picker_unselected_color);
    }

    /* renamed from: a */
    private void m5412a(int i, boolean z, boolean z2) {
        getContext().getResources().getColor(R.color.mc_custom_date_picker_unselected_tab_color);
    }

    /* renamed from: a */
    public void mo16345a(int i, int i2, boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!z) {
            this.f4893d = true;
            if (this.f4890a != i) {
                this.f4890a = i;
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.f4890a >= 12) {
                this.f4890a -= 12;
                this.f4893d = false;
            }
        } else if (this.f4890a != i) {
            this.f4890a = i;
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f4891b != i2) {
            this.f4891b = i2;
            z3 = true;
        }
        if (z != this.f4892c.booleanValue()) {
            this.f4892c = Boolean.valueOf(z);
            m5419b();
        }
        if (z2) {
            this.f4896g.mo17194b(this.f4890a);
        }
        if (z3) {
            this.f4897h.mo17194b(this.f4891b);
        }
        if (this.f4898i != null) {
            this.f4898i.mo17194b(this.f4893d ^ true ? 1 : 0);
        }
    }

    /* renamed from: a */
    private int m5407a(int i) {
        int i2 = this.f4910u / 2;
        if (i < 0 || i > 11) {
            return i2;
        }
        int i3 = this.f4914y.get(2);
        return i >= i3 ? i2 + (i - i3) : i2 + (12 - i3) + i;
    }

    /* renamed from: a */
    public void mo16346a(int[] iArr) {
        if (this.f4905p) {
            int[] iArr2 = new int[3];
            int[] a = LunarCalendar.m5140a(this.f4913x, this.f4912w, this.f4911v, false);
            iArr[0] = a[0];
            iArr[1] = a[1];
            iArr[2] = a[2];
        } else {
            iArr[0] = this.f4913x;
            iArr[1] = this.f4912w;
            iArr[2] = this.f4911v;
        }
        iArr[3] = getCurrentHour();
        iArr[4] = getCurrentMinute().intValue();
        iArr[5] = this.f4905p;
    }

    public long getTimeMillis() {
        int[] iArr = new int[6];
        mo16346a(iArr);
        Calendar instance = Calendar.getInstance();
        instance.set(iArr[0], iArr[1] - 1, iArr[2], iArr[3], iArr[4], 0);
        return instance.getTimeInMillis();
    }

    private static class SavedState extends View.BaseSavedState {
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
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final int f4916a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final int f4917b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final int f4918c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final int f4919d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public final int f4920e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public final int f4921f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public final int f4922g;

        private SavedState(Parcelable parcelable, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            super(parcelable);
            this.f4916a = i;
            this.f4917b = i2;
            this.f4918c = i3;
            this.f4919d = i4;
            this.f4920e = i5;
            this.f4921f = z ? 1 : 0;
            this.f4922g = z2 ? 1 : 0;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f4916a = parcel.readInt();
            this.f4917b = parcel.readInt();
            this.f4918c = parcel.readInt();
            this.f4919d = parcel.readInt();
            this.f4920e = parcel.readInt();
            this.f4921f = parcel.readInt();
            this.f4922g = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4916a);
            parcel.writeInt(this.f4917b);
            parcel.writeInt(this.f4918c);
            parcel.writeInt(this.f4919d);
            parcel.writeInt(this.f4920e);
            parcel.writeInt(this.f4921f);
            parcel.writeInt(this.f4922g);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour(), this.f4891b, this.f4913x, this.f4912w, this.f4911v, this.f4905p, this.f4906q);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        mo16345a(savedState.f4916a, savedState.f4917b, this.f4892c.booleanValue());
        boolean z = true;
        mo16344a(savedState.f4918c, savedState.f4919d, savedState.f4920e, savedState.f4921f == 1, savedState.f4922g == 1, false);
        int i = savedState.f4921f == 1 ? this.f4886F : this.f4887G;
        if (savedState.f4921f != 1) {
            z = false;
        }
        m5412a(i, z, false);
    }

    public int getCurrentHour() {
        if (this.f4892c.booleanValue()) {
            return this.f4890a;
        }
        if (this.f4893d) {
            return this.f4890a;
        }
        return this.f4890a + 12;
    }

    /* renamed from: a */
    public boolean mo16347a() {
        return this.f4892c.booleanValue();
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.f4891b);
    }

    public void setCurrentHour(Integer num) {
        if (num != null && num.intValue() != getCurrentHour()) {
            mo16345a(num.intValue(), this.f4891b, this.f4892c.booleanValue());
        }
    }

    public void setCurrentMinute(Integer num) {
        mo16345a(getCurrentHour(), num.intValue(), this.f4892c.booleanValue());
    }

    public void onWindowFocusChanged(boolean z) {
        int i;
        super.onWindowFocusChanged(z);
        if (z) {
            boolean booleanValue = this.f4892c.booleanValue();
            try {
                booleanValue = DateFormat.is24HourFormat(getContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (booleanValue != this.f4892c.booleanValue()) {
                mo16345a(getCurrentHour(), this.f4891b, booleanValue);
            }
            if (this.f4905p) {
                this.f4895f.mo16386b(this.f4915z, this.f4881A);
                this.f4894e.mo16373b(this.f4915z, this.f4881A);
                this.f4902m.setAlpha(0.0f);
                i = this.f4886F;
                m5412a(i, this.f4905p, false);
            } else {
                this.f4895f.mo16386b(this.f4882B, this.f4883C);
                this.f4894e.mo16373b(this.f4882B, this.f4883C);
                this.f4902m.setAlpha(1.0f);
                i = this.f4887G;
            }
            this.f4895f.mo16388c(i, this.f4888H);
            this.f4894e.mo16367a(i, this.f4888H);
            this.f4896g.setTextColor(i, this.f4888H);
            this.f4897h.setTextColor(i, this.f4888H);
            this.f4898i.setTextColor(i, this.f4888H);
            this.f4901l.setTextColor(i);
            this.f4902m.setTextColor(i);
            this.f4903n.setTextColor(i);
            this.f4904o.setTextColor(i);
        }
    }

    public void setTextColor(int i, int i2, int i3) {
        this.f4895f.mo16388c(i, i2);
        this.f4894e.mo16367a(i, i2);
        this.f4896g.setTextColor(i, i2);
        this.f4897h.setTextColor(i, i2);
        if (this.f4898i != null) {
            this.f4898i.setTextColor(i, i2);
        }
        this.f4903n.setTextColor(i3);
        this.f4904o.setTextColor(i3);
        this.f4901l.setTextColor(i3);
        this.f4902m.setTextColor(i3);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m5415b(int i, int i2, boolean z) {
        if (z) {
            int a = LunarCalendar.m5136a(i);
            boolean z2 = false;
            if (a != 0 && a == i2) {
                z2 = true;
            }
            return LunarCalendar.m5138a(i, i2, z2);
        }
        Calendar instance = Calendar.getInstance();
        instance.set(5, 1);
        instance.set(1, i);
        instance.set(2, i2 - 1);
        return instance.getActualMaximum(5);
    }

    public void setLunar(boolean z) {
        int[] iArr;
        m5422c();
        int[] iArr2 = new int[2];
        int[] iArr3 = {this.f4913x, this.f4895f.mo16379a(iArr2), this.f4894e.mo16365a() + 1, 0};
        if (z) {
            iArr = LunarCalendar.m5139a(iArr3[0], iArr3[1], iArr3[2]);
        } else {
            iArr = LunarCalendar.m5140a(iArr3[0], iArr3[1], iArr3[2], iArr2[1] == 1);
        }
        mo16343a(iArr[0], iArr[1], iArr[2], z, iArr2[1] == 1);
    }

    /* renamed from: a */
    public void mo16344a(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.f4905p = z;
        this.f4913x = i;
        this.f4912w = i2;
        this.f4911v = i3;
        this.f4895f.mo16382a(this.f4913x, this.f4912w, this.f4911v, z2);
        if (this.f4885E != m5415b(this.f4913x, this.f4912w, z)) {
            this.f4885E = m5415b(this.f4913x, this.f4912w, z);
            this.f4894e.mo16372b(m5415b(this.f4913x, this.f4912w, z));
        }
        this.f4894e.mo16368a(this.f4911v - 1, z3);
        if (this.f4905p) {
            this.f4895f.mo16386b(this.f4915z, this.f4881A);
            this.f4894e.mo16373b(this.f4915z, this.f4881A);
            this.f4902m.setAlpha(0.0f);
            return;
        }
        this.f4895f.mo16386b(this.f4882B, this.f4883C);
        this.f4894e.mo16373b(this.f4882B, this.f4883C);
        this.f4902m.setAlpha(1.0f);
    }

    /* renamed from: a */
    public void mo16343a(int i, int i2, int i3, boolean z, boolean z2) {
        mo16344a(i, i2, i3, z, z2, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m5417b(int i) {
        String[] stringArray = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_day);
        if (i > stringArray.length - 1) {
            return null;
        }
        return stringArray[i];
    }

    /* renamed from: com.meizu.common.widget.CustomTimePicker$b */
    private class C1391b implements ScrollTextView.C1497b {

        /* renamed from: b */
        private ScrollTextView f4928b;

        /* renamed from: c */
        private String[] f4929c;

        /* renamed from: d */
        private int[] f4930d = new int[4];

        /* renamed from: e */
        private int[] f4931e = new int[4];

        /* renamed from: f */
        private int[] f4932f = new int[4];

        /* renamed from: g */
        private int[] f4933g = new int[4];

        /* renamed from: h */
        private int f4934h;

        /* renamed from: i */
        private int f4935i;

        /* renamed from: j */
        private int f4936j;

        /* renamed from: k */
        private int f4937k;

        /* renamed from: l */
        private int f4938l;

        /* renamed from: m */
        private int f4939m;

        public C1391b(ScrollTextView scrollTextView) {
            this.f4928b = scrollTextView;
            this.f4929c = m5467c();
            m5466b();
        }

        /* renamed from: a */
        public void mo16380a(int i) {
            this.f4928b.setSelectItemHeight((float) i);
        }

        /* renamed from: a */
        public int mo16379a(int[] iArr) {
            int a = mo16378a();
            if (CustomTimePicker.this.f4905p) {
                if (a >= this.f4936j) {
                    int i = a - (this.f4936j - 1);
                    if (iArr != null) {
                        iArr[0] = this.f4933g[0];
                    }
                    if (i != this.f4939m + 1 || iArr == null) {
                        iArr[1] = 0;
                    } else {
                        iArr[1] = 1;
                    }
                    if (this.f4939m == 0 || i <= this.f4939m) {
                        return i;
                    }
                    return i - 1;
                }
                int i2 = a + this.f4932f[1];
                if (iArr != null) {
                    iArr[0] = this.f4932f[0];
                }
                if (this.f4938l == 0) {
                    iArr[1] = 0;
                    return i2;
                } else if (this.f4932f[3] == 1 && i2 == this.f4938l) {
                    iArr[1] = 1;
                    return i2;
                } else if (this.f4936j <= (12 - this.f4938l) + 1 || i2 <= this.f4938l) {
                    iArr[1] = 0;
                    return i2;
                } else {
                    iArr[1] = 1;
                    return i2 - 1;
                }
            } else if (a > 12 - this.f4930d[1]) {
                int i3 = a - (12 - this.f4930d[1]);
                if (iArr == null) {
                    return i3;
                }
                iArr[0] = this.f4931e[0];
                iArr[1] = 0;
                return i3;
            } else {
                int i4 = a + this.f4930d[1];
                if (iArr == null) {
                    return i4;
                }
                iArr[0] = this.f4930d[0];
                iArr[1] = 0;
                return i4;
            }
        }

        /* renamed from: a */
        public void mo16382a(int i, int i2, int i3, boolean z) {
            if (i2 >= 0) {
                boolean unused = CustomTimePicker.this.f4906q = z;
                if (CustomTimePicker.this.f4905p) {
                    if (i == this.f4932f[0]) {
                        if (this.f4938l != 0 && this.f4932f[0] <= this.f4938l && this.f4932f[3] != 1 && (i2 > this.f4938l || (this.f4938l == i2 && z))) {
                            i2++;
                        }
                        mo16381a(CustomTimePicker.this.f4884D, i2 - this.f4932f[1]);
                    } else if (i == this.f4933g[0]) {
                        if (this.f4939m != 0 && (i2 > this.f4939m || (this.f4939m == i2 && z))) {
                            i2++;
                        }
                        mo16381a(CustomTimePicker.this.f4884D, (i2 + this.f4936j) - 1);
                    }
                } else if (i2 <= 12) {
                    if (i == this.f4930d[0] && i2 >= this.f4930d[1]) {
                        mo16381a(12, Math.min(11, i2 - this.f4930d[1]));
                    } else if (i == this.f4931e[0] && i2 <= this.f4931e[1]) {
                        mo16381a(12, 11 - (this.f4931e[1] - i2));
                    }
                }
                mo16385b(i3);
            }
        }

        /* renamed from: b */
        public void mo16385b(int i) {
            int a = CustomTimePicker.this.m5415b(CustomTimePicker.this.f4913x, CustomTimePicker.this.f4912w, CustomTimePicker.this.f4905p);
            if (CustomTimePicker.this.f4905p) {
                if (CustomTimePicker.this.f4913x == this.f4932f[0] && CustomTimePicker.this.f4912w == this.f4932f[1]) {
                    CustomTimePicker.this.f4894e.mo16377d(this.f4932f[2] - 1);
                } else {
                    CustomTimePicker.this.f4894e.mo16377d(0);
                }
                if (CustomTimePicker.this.f4913x == this.f4933g[0] && CustomTimePicker.this.f4912w == this.f4933g[1]) {
                    CustomTimePicker.this.f4894e.mo16376c(this.f4933g[2] - 1);
                } else {
                    CustomTimePicker.this.f4894e.mo16376c(a - 1);
                }
            } else {
                if (CustomTimePicker.this.f4913x == this.f4930d[0] && CustomTimePicker.this.f4912w == this.f4930d[1]) {
                    CustomTimePicker.this.f4894e.mo16377d(this.f4930d[2] - 1);
                } else {
                    CustomTimePicker.this.f4894e.mo16377d(0);
                }
                if (CustomTimePicker.this.f4913x == this.f4931e[0] && CustomTimePicker.this.f4912w == this.f4931e[1]) {
                    CustomTimePicker.this.f4894e.mo16376c(this.f4931e[2] - 1);
                } else {
                    CustomTimePicker.this.f4894e.mo16376c(a - 1);
                }
            }
            int unused = CustomTimePicker.this.f4911v = i;
            int unused2 = CustomTimePicker.this.f4911v = Math.min(CustomTimePicker.this.f4911v, a);
            int unused3 = CustomTimePicker.this.f4911v = Math.min(CustomTimePicker.this.f4911v, CustomTimePicker.this.f4894e.mo16371b() + 1);
            int unused4 = CustomTimePicker.this.f4911v = Math.max(CustomTimePicker.this.f4911v, CustomTimePicker.this.f4894e.mo16375c() + 1);
            CustomTimePicker.this.f4894e.mo16368a(CustomTimePicker.this.f4911v - 1, true);
        }

        /* renamed from: a */
        public int mo16378a() {
            return this.f4928b.getCurrentItem() - (CustomTimePicker.this.f4910u / 2);
        }

        /* renamed from: a */
        public void mo16381a(int i, int i2) {
            this.f4928b.mo17195b(i + ((CustomTimePicker.this.f4910u / 2) * 2), i2 + (CustomTimePicker.this.f4910u / 2));
        }

        /* renamed from: b */
        public void mo16386b(int i, int i2) {
            this.f4928b.setTextSize((float) i, (float) i2);
        }

        /* renamed from: c */
        public void mo16388c(int i, int i2) {
            this.f4928b.setTextColor(i, i2);
        }

        /* renamed from: a */
        public void mo16384a(ScrollTextView.C1497b bVar, float f, int i, int i2, int i3, int i4, int i5, boolean z) {
            this.f4934h = i4;
            int i6 = (i3 / 2) * 2;
            this.f4935i = i5 + i6 + 1;
            this.f4928b.setData(this, f, i, i2 + i6, i3, this.f4934h, this.f4935i, z);
        }

        /* renamed from: b */
        private void m5466b() {
            CustomTimePicker.this.f4914y.setTimeInMillis(System.currentTimeMillis());
            this.f4930d[0] = CustomTimePicker.this.f4914y.get(1);
            this.f4930d[1] = CustomTimePicker.this.f4914y.get(2) + 1;
            this.f4930d[2] = CustomTimePicker.this.f4914y.get(5);
            this.f4930d[3] = 0;
            this.f4931e[0] = this.f4930d[1] == 1 ? this.f4930d[0] : this.f4930d[0] + 1;
            this.f4931e[1] = this.f4930d[1] - 1 <= 0 ? 12 : this.f4930d[1] - 1;
            this.f4931e[2] = CustomTimePicker.this.m5415b(this.f4931e[0], this.f4931e[1], false);
            this.f4931e[3] = 0;
            this.f4932f = LunarCalendar.m5139a(this.f4930d[0], this.f4930d[1], this.f4930d[2]);
            this.f4933g = LunarCalendar.m5139a(this.f4931e[0], this.f4931e[1], this.f4931e[2]);
            if (this.f4932f[0] == this.f4933g[0]) {
                this.f4936j = (this.f4933g[1] - this.f4932f[1]) + 1;
                this.f4937k = 0;
                int unused = CustomTimePicker.this.f4884D = this.f4936j + this.f4937k;
                return;
            }
            this.f4936j = (12 - this.f4932f[1]) + 1;
            int a = LunarCalendar.m5136a(this.f4932f[0]);
            this.f4938l = a;
            if (a != 0 && (this.f4932f[1] < a || (a == this.f4932f[1] && this.f4932f[3] != 1))) {
                this.f4936j++;
            }
            this.f4937k = this.f4933g[1];
            int a2 = LunarCalendar.m5136a(this.f4933g[0]);
            this.f4939m = a2;
            if (a2 != 0 && (this.f4933g[1] > a2 || (this.f4933g[1] == a2 && this.f4933g[3] == 1))) {
                this.f4937k++;
            }
            int unused2 = CustomTimePicker.this.f4884D = this.f4936j + this.f4937k;
        }

        /* renamed from: c */
        public String mo16387c(int i) {
            int i2;
            int i3;
            if (CustomTimePicker.this.f4905p) {
                int i4 = i - (CustomTimePicker.this.f4910u / 2);
                if (i4 < 0 || i4 > CustomTimePicker.this.f4884D - 1) {
                    return "";
                }
                if (i4 >= this.f4936j) {
                    i2 = i4 - this.f4936j;
                    i3 = this.f4933g[0];
                } else {
                    i2 = i4 + (this.f4932f[1] - 1);
                    if (this.f4938l != 0 && (this.f4932f[1] > this.f4938l || this.f4932f[3] == 1 || (this.f4932f[1] < this.f4938l && i2 >= this.f4938l))) {
                        i2++;
                    }
                    i3 = this.f4932f[0];
                }
                return m5468d(i2, i3);
            } else if (i < CustomTimePicker.this.f4910u / 2 || i > (CustomTimePicker.this.f4910u / 2) + 11) {
                return "";
            } else {
                return this.f4929c[(((this.f4930d[1] - 1) + i) - (CustomTimePicker.this.f4910u / 2)) % 12];
            }
        }

        /* renamed from: a */
        public void mo16383a(View view, int i, int i2) {
            int i3;
            int a = CustomTimePicker.this.m5415b(CustomTimePicker.this.f4913x, CustomTimePicker.this.f4912w, CustomTimePicker.this.f4905p);
            int i4 = i2 - (CustomTimePicker.this.f4910u / 2);
            if (CustomTimePicker.this.f4905p) {
                if (i4 >= this.f4936j) {
                    int unused = CustomTimePicker.this.f4913x = this.f4933g[0];
                } else {
                    int unused2 = CustomTimePicker.this.f4913x = this.f4932f[0];
                }
            } else if (i4 > 12 - this.f4930d[1]) {
                int unused3 = CustomTimePicker.this.f4913x = this.f4931e[0];
            } else {
                int unused4 = CustomTimePicker.this.f4913x = this.f4930d[0];
            }
            if (!CustomTimePicker.this.f4905p) {
                i3 = i4 > 12 - this.f4930d[1] ? i4 - (12 - this.f4930d[1]) : i4 + this.f4930d[1];
            } else if (i4 >= this.f4936j) {
                i3 = i4 - (this.f4936j - 1);
                if (this.f4939m != 0 && i3 > this.f4939m) {
                    i3--;
                }
            } else {
                i3 = i4 + this.f4932f[1];
                if (this.f4938l != 0 && this.f4932f[1] <= this.f4938l && this.f4932f[3] != 1 && i3 > this.f4938l) {
                    i3--;
                }
            }
            int unused5 = CustomTimePicker.this.f4912w = i3;
            if (!(a == CustomTimePicker.this.m5415b(CustomTimePicker.this.f4913x, CustomTimePicker.this.f4912w, CustomTimePicker.this.f4905p) || CustomTimePicker.this.f4894e == null)) {
                CustomTimePicker.this.f4894e.mo16372b(CustomTimePicker.this.m5415b(CustomTimePicker.this.f4913x, CustomTimePicker.this.f4912w, CustomTimePicker.this.f4905p));
            }
            mo16385b(CustomTimePicker.this.f4894e.mo16365a() + 1);
        }

        /* renamed from: c */
        private String[] m5467c() {
            Locale locale = Locale.getDefault();
            if (locale.equals(CustomTimePicker.this.f4908s) && CustomTimePicker.this.f4909t != null) {
                return CustomTimePicker.this.f4909t;
            }
            synchronized (CustomTimePicker.this.f4907r) {
                if (!locale.equals(CustomTimePicker.this.f4908s)) {
                    String[] unused = CustomTimePicker.this.f4909t = new String[12];
                    int i = 0;
                    for (int i2 = 0; i2 < 12; i2++) {
                        CustomTimePicker.this.f4909t[i2] = DateUtils.getMonthString(i2 + 0, 20);
                    }
                    if (CustomTimePicker.this.f4909t[0].startsWith("1")) {
                        while (i < CustomTimePicker.this.f4909t.length) {
                            int i3 = i + 1;
                            CustomTimePicker.this.f4909t[i] = String.valueOf(i3);
                            i = i3;
                        }
                    }
                    Locale unused2 = CustomTimePicker.this.f4908s = locale;
                }
            }
            return CustomTimePicker.this.f4909t;
        }

        /* renamed from: d */
        private String m5468d(int i, int i2) {
            int i3 = i % 13;
            int a = LunarCalendar.m5136a(i2);
            if (a == 0) {
                if (i3 >= 12) {
                    return null;
                }
            } else if (i3 >= 13) {
                return null;
            }
            String[] stringArray = CustomTimePicker.this.getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
            String string = CustomTimePicker.this.getResources().getString(R.string.mc_time_picker_leap);
            if (a == 0 || i3 <= a - 1) {
                return stringArray[i3];
            }
            if (i3 != a) {
                return stringArray[i3 - 1];
            }
            return string + stringArray[i3 - 1];
        }
    }

    /* renamed from: com.meizu.common.widget.CustomTimePicker$a */
    private class C1390a implements ScrollTextView.C1500e {

        /* renamed from: b */
        private ScrollTextView f4924b;

        /* renamed from: c */
        private int f4925c;

        /* renamed from: d */
        private int f4926d;

        /* renamed from: a */
        public void mo16370a(ScrollTextView scrollTextView) {
        }

        public C1390a(ScrollTextView scrollTextView) {
            this.f4924b = scrollTextView;
        }

        /* renamed from: a */
        public void mo16366a(int i) {
            this.f4924b.setSelectItemHeight((float) i);
        }

        /* renamed from: a */
        public void mo16369a(C1392c cVar, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
            mo16376c(i6);
            mo16377d(i5);
            this.f4924b.setData(cVar, (float) i, i2, i3, i4, 0, i3 - 1, z);
            this.f4924b.mo17192a((ScrollTextView.C1500e) this);
        }

        /* renamed from: a */
        public int mo16365a() {
            return this.f4924b.getCurrentItem();
        }

        /* renamed from: a */
        public void mo16368a(int i, boolean z) {
            this.f4924b.setCurrentItem(i, z);
        }

        /* renamed from: b */
        public void mo16372b(int i) {
            this.f4924b.mo17188a(i);
        }

        /* renamed from: a */
        public void mo16367a(int i, int i2) {
            this.f4924b.setTextColor(i, i2);
        }

        /* renamed from: b */
        public void mo16373b(int i, int i2) {
            this.f4924b.setTextSize((float) i, (float) i2);
        }

        /* renamed from: b */
        public int mo16371b() {
            return this.f4925c;
        }

        /* renamed from: c */
        public int mo16375c() {
            return this.f4926d;
        }

        /* renamed from: c */
        public void mo16376c(int i) {
            this.f4925c = i;
        }

        /* renamed from: d */
        public void mo16377d(int i) {
            this.f4926d = i;
        }

        /* renamed from: b */
        public void mo16374b(ScrollTextView scrollTextView) {
            this.f4924b.setCurrentItem(Math.max(Math.min(this.f4924b.getCurrentItem(), mo16371b()), mo16375c()), true);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_padding);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_select_h);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_picker_height);
        this.f4895f.mo16380a(dimensionPixelSize2);
        this.f4894e.mo16366a(dimensionPixelSize2);
        float f = (float) dimensionPixelSize2;
        this.f4896g.setSelectItemHeight(f);
        this.f4897h.setSelectItemHeight(f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f4889I.getLayoutParams();
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize3;
        this.f4889I.setLayoutParams(layoutParams);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CustomTimePicker.class.getName());
    }
}
