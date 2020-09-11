package com.meizu.common.datetimepicker.date;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.meizu.common.R;
import com.meizu.common.datetimepicker.C1299a;
import com.meizu.common.widget.DatePickerNativeDialog;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public abstract class MonthView extends View {

    /* renamed from: a */
    protected static int f4140a = 32;

    /* renamed from: b */
    protected static int f4141b = 1;

    /* renamed from: c */
    protected static int f4142c;

    /* renamed from: d */
    protected static int f4143d;

    /* renamed from: A */
    protected RectF f4144A;

    /* renamed from: B */
    protected final Calendar f4145B;

    /* renamed from: C */
    protected int f4146C;

    /* renamed from: D */
    protected C1300a f4147D;

    /* renamed from: E */
    protected int f4148E;

    /* renamed from: F */
    protected int f4149F;

    /* renamed from: G */
    protected int f4150G;

    /* renamed from: H */
    protected int f4151H;

    /* renamed from: I */
    protected int f4152I;

    /* renamed from: J */
    protected int f4153J;

    /* renamed from: K */
    protected int f4154K;

    /* renamed from: L */
    protected int f4155L;

    /* renamed from: M */
    protected int f4156M;

    /* renamed from: N */
    protected int f4157N;

    /* renamed from: O */
    protected float f4158O;

    /* renamed from: P */
    protected float f4159P;

    /* renamed from: Q */
    protected int f4160Q;

    /* renamed from: R */
    protected int f4161R;

    /* renamed from: S */
    protected int f4162S;

    /* renamed from: T */
    protected int f4163T;

    /* renamed from: U */
    protected boolean f4164U;

    /* renamed from: V */
    DatePickerNativeDialog.C1404a f4165V;

    /* renamed from: W */
    private String f4166W;

    /* renamed from: aa */
    private String f4167aa;

    /* renamed from: ab */
    private final Formatter f4168ab;

    /* renamed from: ac */
    private final StringBuilder f4169ac;

    /* renamed from: ad */
    private final Calendar f4170ad;

    /* renamed from: ae */
    private final MonthViewTouchHelper f4171ae;

    /* renamed from: af */
    private boolean f4172af;

    /* renamed from: ag */
    private int f4173ag;

    /* renamed from: ah */
    private int f4174ah;

    /* renamed from: e */
    protected DatePickerController f4175e;

    /* renamed from: f */
    protected int f4176f;

    /* renamed from: g */
    protected Paint f4177g;

    /* renamed from: h */
    protected Paint f4178h;

    /* renamed from: i */
    protected Paint f4179i;

    /* renamed from: j */
    protected Paint f4180j;

    /* renamed from: k */
    protected Paint.FontMetricsInt f4181k;

    /* renamed from: l */
    protected Paint.FontMetricsInt f4182l;

    /* renamed from: m */
    protected int f4183m;

    /* renamed from: n */
    protected int f4184n;

    /* renamed from: o */
    protected int f4185o;

    /* renamed from: p */
    protected int f4186p;

    /* renamed from: q */
    protected int f4187q;

    /* renamed from: r */
    protected int f4188r;

    /* renamed from: s */
    protected int f4189s;

    /* renamed from: t */
    protected boolean f4190t;

    /* renamed from: u */
    protected int f4191u;

    /* renamed from: v */
    protected int f4192v;

    /* renamed from: w */
    protected int f4193w;

    /* renamed from: x */
    protected int f4194x;

    /* renamed from: y */
    protected int f4195y;

    /* renamed from: z */
    protected ArrayList<Integer> f4196z;

    /* renamed from: com.meizu.common.datetimepicker.date.MonthView$a */
    public interface C1300a {
        /* renamed from: a */
        void mo15729a(MonthView monthView, CalendarDay aVar);
    }

    /* renamed from: a */
    public abstract void mo15706a(Canvas canvas, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5, float f6);

    /* access modifiers changed from: protected */
    public int getMonthHeaderSize() {
        return 0;
    }

    public MonthView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MonthView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = false;
        this.f4176f = 0;
        this.f4185o = -1;
        this.f4187q = f4140a;
        this.f4190t = false;
        this.f4191u = -1;
        this.f4192v = -1;
        this.f4193w = 1;
        this.f4194x = 7;
        this.f4195y = this.f4194x;
        this.f4144A = new RectF();
        this.f4146C = 6;
        this.f4162S = 89;
        this.f4163T = 255;
        this.f4164U = false;
        this.f4173ag = 0;
        Resources resources = context.getResources();
        this.f4145B = Calendar.getInstance();
        this.f4170ad = Calendar.getInstance();
        this.f4166W = resources.getString(R.string.default_sans_serif);
        this.f4167aa = resources.getString(R.string.flyme_sans_serif_normal);
        this.f4148E = resources.getColor(R.color.mc_custom_date_picker_gregorian_text_normal);
        this.f4149F = resources.getColor(R.color.mc_native_date_picker_select_date_color);
        this.f4150G = resources.getColor(R.color.mc_custom_date_picker_gregorian_text_disabled);
        this.f4151H = resources.getColor(R.color.mc_native_date_picker_select_date_color);
        this.f4152I = resources.getColor(R.color.mc_custom_date_picker_lunar_color);
        this.f4153J = resources.getColor(R.color.mc_custom_date_picker_select_date_bg);
        this.f4154K = resources.getColor(R.color.mc_custom_date_picker_event_remind_color);
        this.f4169ac = new StringBuilder(50);
        this.f4168ab = new Formatter(this.f4169ac, Locale.getDefault());
        f4142c = resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_month_gregorian_text_size);
        f4143d = resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_month_lunar_text_size);
        this.f4187q = resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_date_month_list_item_height);
        this.f4156M = resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_date_text_padding_offset);
        this.f4158O = (float) resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_date_event_dot_Radios);
        this.f4159P = (float) resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_date_event_dot_width);
        this.f4155L = resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_date_gregorian_text_margin_top);
        this.f4157N = resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_date_event_dot_margin_top);
        this.f4160Q = resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_date_bg_margin_top);
        this.f4161R = resources.getDimensionPixelSize(R.dimen.mc_native_date_picker_date_bg_padding_left_right);
        this.f4186p = this.f4187q * this.f4146C;
        this.f4171ae = getMonthViewTouchHelper();
        ViewCompat.setAccessibilityDelegate(this, this.f4171ae);
        ViewCompat.setImportantForAccessibility(this, 1);
        this.f4172af = true;
        mo15704a();
        this.f4164U = context.getResources().getConfiguration().getLayoutDirection() == 1 ? true : z;
    }

    public void setDatePickerController(DatePickerController bVar) {
        this.f4175e = bVar;
    }

    /* access modifiers changed from: protected */
    public MonthViewTouchHelper getMonthViewTouchHelper() {
        return new MonthViewTouchHelper(this);
    }

    public void setAccessibilityDelegate(View.AccessibilityDelegate accessibilityDelegate) {
        if (!this.f4172af) {
            super.setAccessibilityDelegate(accessibilityDelegate);
        }
    }

    public void setOnDayClickListener(C1300a aVar) {
        this.f4147D = aVar;
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f4171ae.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a;
        if (motionEvent.getAction() == 1 && (a = mo15703a(motionEvent.getX(), motionEvent.getY())) >= 0) {
            this.f4191u = a;
            invalidate();
            m4865b(a);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15704a() {
        this.f4178h = new Paint();
        this.f4178h.setFakeBoldText(true);
        this.f4178h.setAntiAlias(true);
        this.f4178h.setColor(this.f4153J);
        this.f4178h.setTextAlign(Paint.Align.CENTER);
        this.f4178h.setStyle(Paint.Style.FILL);
        this.f4179i = new Paint();
        this.f4179i.setFakeBoldText(true);
        this.f4179i.setAntiAlias(true);
        this.f4179i.setColor(this.f4152I);
        this.f4179i.setTextAlign(Paint.Align.CENTER);
        this.f4179i.setStyle(Paint.Style.FILL);
        this.f4179i.setTextSize((float) f4143d);
        this.f4182l = this.f4179i.getFontMetricsInt();
        this.f4177g = new Paint();
        this.f4177g.setAntiAlias(true);
        this.f4177g.setTextSize((float) f4142c);
        this.f4177g.setStyle(Paint.Style.FILL);
        this.f4177g.setTextAlign(Paint.Align.CENTER);
        this.f4177g.setFakeBoldText(false);
        this.f4181k = this.f4177g.getFontMetricsInt();
        this.f4180j = new Paint();
        this.f4180j.setFakeBoldText(true);
        this.f4180j.setAntiAlias(true);
        this.f4180j.setColor(this.f4154K);
        this.f4180j.setTextAlign(Paint.Align.CENTER);
        this.f4180j.setStyle(Paint.Style.FILL);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        mo15705a(canvas);
    }

    public void setMonthParams(HashMap<String, Object> hashMap) {
        if (hashMap.containsKey("month") || hashMap.containsKey("year")) {
            setTag(hashMap);
            if (hashMap.containsKey("height")) {
                this.f4186p = ((Integer) hashMap.get("height")).intValue();
                if (this.f4186p < 300) {
                    this.f4186p = 300;
                }
            }
            if (hashMap.containsKey("selected_day")) {
                this.f4191u = ((Integer) hashMap.get("selected_day")).intValue();
            }
            if (hashMap.containsKey("width")) {
                this.f4185o = ((Integer) hashMap.get("width")).intValue();
            }
            this.f4183m = ((Integer) hashMap.get("month")).intValue();
            this.f4184n = ((Integer) hashMap.get("year")).intValue();
            Time time = new Time(Time.getCurrentTimezone());
            time.setToNow();
            int i = 0;
            this.f4190t = false;
            this.f4192v = -1;
            this.f4170ad.set(2, this.f4183m);
            this.f4170ad.set(1, this.f4184n);
            this.f4170ad.set(5, 1);
            this.f4173ag = this.f4170ad.get(7);
            if (hashMap.containsKey("week_start")) {
                this.f4193w = ((Integer) hashMap.get("week_start")).intValue();
            } else {
                this.f4193w = this.f4170ad.getFirstDayOfWeek();
            }
            this.f4195y = C1299a.m4861a(this.f4183m, this.f4184n);
            while (i < this.f4195y) {
                i++;
                if (m4864a(i, time)) {
                    this.f4190t = true;
                    this.f4192v = i;
                }
            }
            if (hashMap.containsKey("event_remind")) {
                this.f4196z = (ArrayList) hashMap.get("event_remind");
            } else {
                this.f4196z = null;
            }
            if (hashMap.containsKey("paint_alpha")) {
                float floatValue = ((Float) hashMap.get("paint_alpha")).floatValue();
                this.f4162S = (int) (89.0f * floatValue);
                this.f4163T = (int) (floatValue * 255.0f);
            }
            this.f4146C = m4867c();
            if (this.f4165V != null) {
                this.f4165V.mo16432a(this.f4174ah, this.f4187q * this.f4146C);
            }
            this.f4171ae.invalidateRoot();
            return;
        }
        throw new InvalidParameterException("You must specify month and year for this view");
    }

    public void setSelectedDay(int i) {
        this.f4191u = i;
        invalidate();
    }

    /* renamed from: c */
    private int m4867c() {
        int b = mo15709b();
        return ((this.f4195y + b) / this.f4194x) + ((b + this.f4195y) % this.f4194x > 0 ? 1 : 0);
    }

    /* renamed from: a */
    private boolean m4864a(int i, Time time) {
        return this.f4184n == time.year && this.f4183m == time.month && i == time.monthDay;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo15707a(int i) {
        return this.f4196z != null && this.f4196z.contains(Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f4185o == -1 ? View.MeasureSpec.getSize(i) : this.f4185o, this.f4186p);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f4185o = i;
        this.f4188r = (i - (this.f4176f * 2)) / this.f4194x;
        this.f4189s = ((i - (this.f4176f * 2)) - (this.f4188r * this.f4194x)) / 2;
        this.f4171ae.invalidateRoot();
    }

    public int getMonth() {
        return this.f4183m;
    }

    public int getYear() {
        return this.f4184n;
    }

    private String getMonthAndYearString() {
        this.f4169ac.setLength(0);
        long timeInMillis = this.f4170ad.getTimeInMillis();
        return DateUtils.formatDateRange(getContext(), this.f4168ab, timeInMillis, timeInMillis, 56, TimeZone.getDefault().getID()).toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15705a(Canvas canvas) {
        int monthHeaderSize = (((this.f4187q + f4142c) / 2) - f4141b) + getMonthHeaderSize();
        float f = ((float) (this.f4185o - (this.f4176f * 2))) / (((float) this.f4194x) * 2.0f);
        int i = monthHeaderSize;
        int b = mo15709b();
        for (int i2 = 1; i2 <= this.f4195y; i2++) {
            int i3 = ((this.f4187q + f4142c) / 2) - f4141b;
            float f2 = (float) ((int) ((((float) ((b * 2) + 1)) * f) + ((float) this.f4176f)));
            int i4 = i - i3;
            float f3 = (float) i;
            float f4 = (float) ((int) (f2 - f));
            float f5 = (float) ((int) (f2 + f));
            float f6 = (float) i4;
            int i5 = i;
            mo15706a(canvas, this.f4184n, this.f4183m, i2, f2, f3, f4, f5, f6, (float) (this.f4187q + i4));
            b++;
            if (b == this.f4194x) {
                i = i5 + this.f4187q;
                b = 0;
            } else {
                i = i5;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo15709b() {
        return (this.f4173ag < this.f4193w ? this.f4173ag + this.f4194x : this.f4173ag) - this.f4193w;
    }

    /* renamed from: a */
    public int mo15703a(float f, float f2) {
        int b = mo15710b(f, f2);
        if (b < 1 || b > this.f4195y) {
            return -1;
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo15710b(float f, float f2) {
        int i;
        int i2 = this.f4176f;
        float f3 = (float) i2;
        if (f < f3 || f > ((float) (this.f4185o - this.f4176f))) {
            return -1;
        }
        int monthHeaderSize = ((int) (f2 - ((float) getMonthHeaderSize()))) / this.f4187q;
        int i3 = (int) (((f - f3) * ((float) this.f4194x)) / ((float) ((this.f4185o - i2) - this.f4176f)));
        if (this.f4164U) {
            i = (((this.f4194x - i3) - 1) - mo15709b()) + 1;
        } else {
            i = (i3 - mo15709b()) + 1;
        }
        return i + (monthHeaderSize * this.f4194x);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4865b(int i) {
        if (!mo15708a(this.f4184n, this.f4183m, i)) {
            if (this.f4147D != null) {
                this.f4147D.mo15729a(this, new CalendarDay(this.f4184n, this.f4183m, i));
            }
            this.f4171ae.sendEventForVirtualView(i, 1);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo15708a(int i, int i2, int i3) {
        if (m4866b(i, i2, i3)) {
            return true;
        }
        return m4868c(i, i2, i3);
    }

    /* renamed from: b */
    private boolean m4866b(int i, int i2, int i3) {
        Calendar a;
        if (this.f4175e == null || (a = this.f4175e.mo15735a()) == null) {
            return false;
        }
        if (i < a.get(1)) {
            return true;
        }
        if (i > a.get(1)) {
            return false;
        }
        if (i2 < a.get(2)) {
            return true;
        }
        if (i2 <= a.get(2) && i3 < a.get(5)) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private boolean m4868c(int i, int i2, int i3) {
        Calendar b;
        if (this.f4175e == null || (b = this.f4175e.mo15736b()) == null) {
            return false;
        }
        if (i > b.get(1)) {
            return true;
        }
        if (i < b.get(1)) {
            return false;
        }
        if (i2 > b.get(2)) {
            return true;
        }
        if (i2 >= b.get(2) && i3 > b.get(5)) {
            return true;
        }
        return false;
    }

    public CalendarDay getAccessibilityFocus() {
        int focusedVirtualView = this.f4171ae.getFocusedVirtualView();
        if (focusedVirtualView >= 0) {
            return new CalendarDay(this.f4184n, this.f4183m, focusedVirtualView);
        }
        return null;
    }

    public void setHeightRecordCallBack(int i, DatePickerNativeDialog.C1404a aVar) {
        this.f4174ah = i;
        this.f4165V = aVar;
    }

    protected class MonthViewTouchHelper extends ExploreByTouchHelper {

        /* renamed from: b */
        private final Rect f4198b = new Rect();

        /* renamed from: c */
        private final Calendar f4199c = Calendar.getInstance();

        public MonthViewTouchHelper(View view) {
            super(view);
        }

        /* access modifiers changed from: protected */
        public int getVirtualViewAt(float f, float f2) {
            int a = MonthView.this.mo15703a(f, f2);
            if (a >= 0) {
                return a;
            }
            return Integer.MIN_VALUE;
        }

        /* access modifiers changed from: protected */
        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i = 1; i <= MonthView.this.f4195y; i++) {
                list.add(Integer.valueOf(i));
            }
        }

        /* access modifiers changed from: protected */
        public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(mo15727a(i));
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            mo15728a(i, this.f4198b);
            accessibilityNodeInfoCompat.setContentDescription(mo15727a(i));
            accessibilityNodeInfoCompat.setBoundsInParent(this.f4198b);
            accessibilityNodeInfoCompat.addAction(16);
            if (i == MonthView.this.f4191u) {
                accessibilityNodeInfoCompat.setSelected(true);
            }
        }

        /* access modifiers changed from: protected */
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            MonthView.this.m4865b(i);
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo15728a(int i, Rect rect) {
            int i2 = MonthView.this.f4176f;
            int monthHeaderSize = MonthView.this.getMonthHeaderSize();
            int i3 = MonthView.this.f4187q;
            int i4 = (MonthView.this.f4185o - (MonthView.this.f4176f * 2)) / MonthView.this.f4194x;
            int b = (i - 1) + MonthView.this.mo15709b();
            int i5 = b / MonthView.this.f4194x;
            int i6 = i2 + ((b % MonthView.this.f4194x) * i4);
            int i7 = monthHeaderSize + (i5 * i3);
            rect.set(i6, i7, i4 + i6, i3 + i7);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public CharSequence mo15727a(int i) {
            this.f4199c.set(MonthView.this.f4184n, MonthView.this.f4183m, i);
            CharSequence format = DateFormat.format("dd MMMM yyyy", this.f4199c.getTimeInMillis());
            if (i != MonthView.this.f4191u) {
                return format;
            }
            return MonthView.this.getContext().getString(R.string.item_is_selected, new Object[]{format});
        }
    }
}
