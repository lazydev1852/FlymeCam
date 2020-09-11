package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.widget.ScrollTextView;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TimePicker extends FrameLayout {

    /* renamed from: a */
    String[] f6291a;

    /* renamed from: b */
    String[] f6292b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f6293c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f6294d;

    /* renamed from: e */
    private Boolean f6295e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f6296f;

    /* renamed from: g */
    private ScrollTextView f6297g;

    /* renamed from: h */
    private ScrollTextView f6298h;

    /* renamed from: i */
    private ScrollTextView f6299i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f6300j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public String f6301k;

    /* renamed from: l */
    private TextView f6302l;

    /* renamed from: m */
    private TextView f6303m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C1544a f6304n;

    /* renamed from: o */
    private LinearLayout f6305o;

    /* renamed from: p */
    private int f6306p;

    /* renamed from: q */
    private int f6307q;

    /* renamed from: r */
    private int f6308r;

    /* renamed from: s */
    private Paint f6309s;

    /* renamed from: t */
    private boolean f6310t;

    /* renamed from: u */
    private boolean f6311u;

    /* renamed from: v */
    private int f6312v;

    /* renamed from: com.meizu.common.widget.TimePicker$a */
    public interface C1544a {
        /* renamed from: a */
        void mo17525a(TimePicker timePicker, int i, int i2);
    }

    /* renamed from: com.meizu.common.widget.TimePicker$b */
    private class C1545b implements ScrollTextView.C1497b {

        /* renamed from: a */
        int f6315a = 0;

        C1545b(int i) {
            this.f6315a = i;
        }

        /* renamed from: a */
        public void mo16383a(View view, int i, int i2) {
            switch (this.f6315a) {
                case 1:
                    int unused = TimePicker.this.f6293c = i2;
                    break;
                case 2:
                    int unused2 = TimePicker.this.f6294d = i2;
                    break;
                case 3:
                    boolean unused3 = TimePicker.this.f6296f = i2 == 0;
                    break;
                default:
                    return;
            }
            if (TimePicker.this.f6304n != null) {
                TimePicker.this.f6304n.mo17525a(TimePicker.this, TimePicker.this.getCurrentHour(), TimePicker.this.getCurrentMinute().intValue());
            }
            TimePicker.this.m6215a(this.f6315a);
        }

        /* renamed from: c */
        public String mo16387c(int i) {
            switch (this.f6315a) {
                case 1:
                    if (TimePicker.this.mo17503a()) {
                        return TimePicker.this.f6291a[i];
                    }
                    if (i == 0) {
                        i = 12;
                    }
                    return TimePicker.this.f6291a[i];
                case 2:
                    return TimePicker.this.f6292b[i];
                case 3:
                    if (i == 0) {
                        return TimePicker.this.f6300j;
                    }
                    if (i == 1) {
                        return TimePicker.this.f6301k;
                    }
                    return null;
                default:
                    return null;
            }
        }
    }

    public TimePicker(Context context) {
        this(context, (AttributeSet) null);
    }

    public TimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6293c = 0;
        this.f6294d = 0;
        this.f6295e = false;
        this.f6296f = true;
        this.f6311u = false;
        this.f6312v = 5;
        String format = String.format(Locale.getDefault(), "%d", new Object[]{0});
        this.f6291a = new String[100];
        for (int i2 = 0; i2 < 100; i2++) {
            this.f6291a[i2] = String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i2)});
            if (i2 <= 9) {
                this.f6291a[i2] = format + this.f6291a[i2];
            }
        }
        this.f6292b = new String[100];
        for (int i3 = 0; i3 < 100; i3++) {
            this.f6292b[i3] = String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i3)});
            if (i3 <= 9) {
                this.f6292b[i3] = format + this.f6292b[i3];
            }
        }
        Calendar instance = Calendar.getInstance();
        try {
            this.f6293c = instance.get(11);
            this.f6294d = instance.get(12);
            this.f6295e = Boolean.valueOf(DateFormat.is24HourFormat(context));
        } catch (Exception unused) {
            this.f6293c = 12;
            this.f6294d = 30;
            this.f6295e = true;
        }
        if (!this.f6295e.booleanValue() && this.f6293c >= 12) {
            this.f6293c -= 12;
            this.f6296f = false;
        }
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.f6300j = amPmStrings[0];
        this.f6301k = amPmStrings[1];
        m6220b();
        this.f6306p = 0;
        this.f6307q = 0;
        this.f6308r = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        this.f6309s = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.MZTheme);
        int i4 = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColor, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        obtainStyledAttributes.recycle();
        this.f6309s.setColor(i4);
        this.f6309s.setAntiAlias(true);
        this.f6309s.setStrokeWidth((float) context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.f6310t = false;
        setWillNotDraw(false);
        this.f6305o = (LinearLayout) findViewById(R.id.mc_column_parent);
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.f6311u = accessibilityManager.isEnabled();
        }
        m6225e();
    }

    /* renamed from: b */
    private void m6220b() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        if (this.f6295e.booleanValue()) {
            m6222c();
        } else {
            m6224d();
        }
        int color = getContext().getResources().getColor(R.color.mc_picker_selected_color);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(getContext().getResources().getColor(R.color.mc_picker_unselected_color_one)));
        arrayList.add(Integer.valueOf(getContext().getResources().getColor(R.color.mc_picker_unselected_color_two)));
        int color2 = getContext().getResources().getColor(R.color.mc_picker_unselected_color);
        this.f6297g.setTextColor(color, (List<Integer>) arrayList);
        this.f6298h.setTextColor(color, (List<Integer>) arrayList);
        if (this.f6299i != null) {
            this.f6299i.setTextColor(color, color2);
        }
        this.f6302l.setTextColor(color);
        this.f6303m.setTextColor(color);
        int paddingTop = this.f6302l.getPaddingTop();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        float f = displayMetrics.scaledDensity;
        float f2 = getResources().getDisplayMetrics().scaledDensity;
        int textSize = (int) (((float) paddingTop) - (((this.f6302l.getTextSize() / f2) * (f2 - f)) / 1.3f));
        this.f6302l.setPadding(this.f6302l.getPaddingLeft(), textSize, this.f6302l.getPaddingRight(), this.f6302l.getPaddingBottom());
        this.f6303m.setPadding(this.f6303m.getPaddingLeft(), textSize, this.f6303m.getPaddingRight(), this.f6303m.getPaddingBottom());
        if (!isEnabled()) {
            setEnabled(false);
        }
    }

    /* renamed from: c */
    private void m6222c() {
        if (this.f6295e.booleanValue()) {
            inflate(getContext(), R.layout.mc_time_picker_column_24, this);
            this.f6302l = (TextView) findViewById(R.id.mc_scroll1_text);
            if (this.f6302l != null) {
                this.f6302l.setText(R.string.mc_date_time_hour);
            }
            this.f6303m = (TextView) findViewById(R.id.mc_scroll2_text);
            if (this.f6303m != null) {
                this.f6303m.setText(R.string.mc_date_time_min);
            }
            this.f6297g = (ScrollTextView) findViewById(R.id.mc_scroll1);
            this.f6297g.setData(new C1545b(1), -1.0f, this.f6293c, 24, this.f6312v, 0, 23, true);
            this.f6298h = (ScrollTextView) findViewById(R.id.mc_scroll2);
            this.f6298h.setData(new C1545b(2), -1.0f, this.f6294d, 60, this.f6312v, 0, 59, true);
            this.f6299i = null;
            ArrayList arrayList = new ArrayList();
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
            this.f6297g.setTextSize(getContext().getResources().getDimension(R.dimen.mc_picker_selected_number_size), (List<Float>) arrayList);
            this.f6298h.setTextSize(getContext().getResources().getDimension(R.dimen.mc_picker_selected_number_size), (List<Float>) arrayList);
        }
    }

    /* renamed from: d */
    private void m6224d() {
        if (!this.f6295e.booleanValue()) {
            inflate(getContext(), R.layout.mc_time_picker_column_12, this);
            this.f6302l = (TextView) findViewById(R.id.mc_scroll1_text);
            if (this.f6302l != null) {
                this.f6302l.setText(R.string.mc_date_time_hour);
            }
            this.f6303m = (TextView) findViewById(R.id.mc_scroll2_text);
            if (this.f6303m != null) {
                this.f6303m.setText(R.string.mc_date_time_min);
            }
            this.f6297g = (ScrollTextView) findViewById(R.id.mc_scroll1);
            this.f6297g.setData(new C1545b(1), -1.0f, this.f6293c, 12, this.f6312v, 0, 11, true);
            this.f6298h = (ScrollTextView) findViewById(R.id.mc_scroll2);
            this.f6298h.setData(new C1545b(2), -1.0f, this.f6294d, 60, this.f6312v, 0, 59, true);
            this.f6299i = (ScrollTextView) findViewById(R.id.mc_scroll3);
            this.f6299i.setData(new C1545b(3), -1.0f, this.f6296f ^ true ? 1 : 0, 2, this.f6312v, 0, 1, false);
            ArrayList arrayList = new ArrayList();
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
            this.f6297g.setTextSize(getContext().getResources().getDimension(R.dimen.mc_picker_selected_number_size), (List<Float>) arrayList);
            this.f6298h.setTextSize(getContext().getResources().getDimension(R.dimen.mc_picker_selected_number_size), (List<Float>) arrayList);
            this.f6299i.setTextSize(getContext().getResources().getDimension(R.dimen.mc_picker_selected_word_size), getContext().getResources().getDimension(R.dimen.mc_picker_normal_word_size_two));
        }
    }

    /* renamed from: a */
    public void mo17502a(int i, int i2, boolean z) {
        boolean z2;
        boolean z3 = false;
        if (!z) {
            this.f6296f = true;
            if (this.f6293c != i) {
                this.f6293c = i;
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.f6293c >= 12) {
                this.f6293c -= 12;
                this.f6296f = false;
            }
        } else if (this.f6293c != i) {
            this.f6293c = i;
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f6294d != i2) {
            this.f6294d = i2;
            z3 = true;
        }
        if (z != this.f6295e.booleanValue()) {
            this.f6295e = Boolean.valueOf(z);
            m6220b();
        }
        if (z2) {
            this.f6297g.mo17194b(this.f6293c);
        }
        if (z3) {
            this.f6298h.mo17194b(this.f6294d);
        }
        if (this.f6299i != null) {
            this.f6299i.mo17194b(this.f6296f ^ true ? 1 : 0);
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f6298h.setEnabled(z);
        this.f6297g.setEnabled(z);
        if (this.f6299i != null) {
            this.f6299i.setEnabled(z);
        }
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
        public final int f6313a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final int f6314b;

        private SavedState(Parcelable parcelable, int i, int i2) {
            super(parcelable);
            this.f6313a = i;
            this.f6314b = i2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f6313a = parcel.readInt();
            this.f6314b = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f6313a);
            parcel.writeInt(this.f6314b);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour(), this.f6294d);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        mo17502a(savedState.f6313a, savedState.f6314b, this.f6295e.booleanValue());
    }

    public void setOnTimeChangedListener(C1544a aVar) {
        this.f6304n = aVar;
    }

    public int getCurrentHour() {
        if (this.f6295e.booleanValue()) {
            return this.f6293c;
        }
        if (this.f6296f) {
            return this.f6293c;
        }
        return this.f6293c + 12;
    }

    /* renamed from: a */
    public boolean mo17503a() {
        return this.f6295e.booleanValue();
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.f6294d);
    }

    public void setCurrentHour(Integer num) {
        if (num != null && num.intValue() != getCurrentHour()) {
            mo17502a(num.intValue(), this.f6294d, this.f6295e.booleanValue());
        }
    }

    public void setIs24HourView(Boolean bool) {
        mo17502a(getCurrentHour(), this.f6294d, bool.booleanValue());
    }

    public void setCurrentMinute(Integer num) {
        mo17502a(getCurrentHour(), num.intValue(), this.f6295e.booleanValue());
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (this.f6299i != null && this.f6299i.mo17186a(this.f6300j) > this.f6299i.getWidth()) {
                this.f6300j = "AM";
            }
            if (this.f6299i != null && this.f6299i.mo17186a(this.f6301k) > this.f6299i.getWidth()) {
                this.f6301k = "PM";
            }
        }
    }

    public void setTextColor(int i, int i2, int i3) {
        this.f6297g.setTextColor(i, i2);
        this.f6298h.setTextColor(i, i2);
        if (this.f6299i != null) {
            this.f6299i.setTextColor(i, i2);
        }
        this.f6302l.setTextColor(i3);
        this.f6303m.setTextColor(i3);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f6310t) {
            int width = getWidth();
            int width2 = this.f6305o.getWidth() - (this.f6308r * 2);
            int i = (width - width2) / 2;
            Canvas canvas2 = canvas;
            float f = (float) i;
            float f2 = (float) (i + width2);
            canvas2.drawLine(f, (float) this.f6306p, f2, (float) this.f6306p, this.f6309s);
            canvas2.drawLine(f, (float) this.f6307q, f2, (float) this.f6307q, this.f6309s);
        }
    }

    public void setIsDrawLine(boolean z) {
        this.f6310t = z;
    }

    public void setLineHeight(int i, int i2) {
        this.f6306p = i;
        this.f6307q = i2;
    }

    /* renamed from: e */
    private void m6225e() {
        if (this.f6311u) {
            View findViewById = findViewById(R.id.mc_column3Layout);
            View findViewById2 = findViewById(R.id.mc_column2Layout);
            View findViewById3 = findViewById(R.id.mc_column1Layout);
            String str = "";
            if (!this.f6295e.booleanValue()) {
                str = str + m6218b(3);
            }
            String str2 = str + m6218b(1) + this.f6302l.getText() + m6218b(2) + this.f6303m.getText();
            if (findViewById != null) {
                findViewById.setFocusable(true);
                findViewById.setContentDescription("上下滚动设置上下午，当前时间是" + str2);
            }
            if (findViewById3 != null) {
                findViewById3.setFocusable(true);
                findViewById3.setContentDescription("上下滚动设置时，当前时间是" + str2);
            }
            if (findViewById2 != null) {
                findViewById2.setFocusable(true);
                findViewById2.setContentDescription("上下滚动设置分，当前时间是" + str2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6215a(int i) {
        View findViewById;
        if (this.f6311u) {
            m6225e();
            if (i == 3) {
                View findViewById2 = findViewById(R.id.mc_column3Layout);
                if (findViewById2 != null) {
                    findViewById2.sendAccessibilityEvent(4);
                }
            } else if (i == 1) {
                View findViewById3 = findViewById(R.id.mc_column1Layout);
                if (findViewById3 != null) {
                    findViewById3.sendAccessibilityEvent(4);
                }
            } else if (i == 2 && (findViewById = findViewById(R.id.mc_column2Layout)) != null) {
                findViewById.sendAccessibilityEvent(4);
            }
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!this.f6311u || accessibilityEvent.getEventType() != 32) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        String str = "";
        if (!this.f6295e.booleanValue()) {
            str = str + m6218b(3);
        }
        accessibilityEvent.getText().add(str + m6218b(1) + this.f6302l.getText() + m6218b(2) + this.f6303m.getText());
        return false;
    }

    /* renamed from: b */
    private String m6218b(int i) {
        switch (i) {
            case 1:
                int i2 = this.f6293c;
                if (mo17503a()) {
                    return String.valueOf(i2);
                }
                if (i2 == 0) {
                    i2 = 12;
                }
                return String.valueOf(i2);
            case 2:
                return String.valueOf(this.f6294d);
            case 3:
                boolean z = !this.f6296f;
                if (!z) {
                    return this.f6300j;
                }
                if (z) {
                    return this.f6301k;
                }
                return "";
            default:
                return "";
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TimePicker.class.getName());
    }
}
