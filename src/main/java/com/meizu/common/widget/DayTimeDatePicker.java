package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.widget.ScrollTextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DayTimeDatePicker extends FrameLayout {

    /* renamed from: A */
    private float f5043A;

    /* renamed from: B */
    private int f5044B;

    /* renamed from: C */
    private List<Float> f5045C;

    /* renamed from: D */
    private int f5046D;

    /* renamed from: E */
    private List<Float> f5047E;

    /* renamed from: F */
    private LinearLayout f5048F;

    /* renamed from: G */
    private int f5049G;

    /* renamed from: H */
    private int f5050H;

    /* renamed from: I */
    private int f5051I;

    /* renamed from: J */
    private Paint f5052J;

    /* renamed from: K */
    private boolean f5053K;

    /* renamed from: L */
    private boolean f5054L;

    /* renamed from: M */
    private Typeface f5055M;

    /* renamed from: N */
    private Typeface f5056N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public C1411b f5057O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public String f5058P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public String f5059Q;

    /* renamed from: a */
    String[] f5060a;

    /* renamed from: b */
    String[] f5061b;

    /* renamed from: c */
    String[] f5062c;

    /* renamed from: d */
    String[] f5063d;

    /* renamed from: e */
    String f5064e;

    /* renamed from: f */
    boolean f5065f;

    /* renamed from: g */
    String[] f5066g;

    /* renamed from: h */
    private TextView f5067h;

    /* renamed from: i */
    private TextView f5068i;

    /* renamed from: j */
    private TextView f5069j;

    /* renamed from: k */
    private ScrollTextView f5070k;

    /* renamed from: l */
    private ScrollTextView f5071l;

    /* renamed from: m */
    private ScrollTextView f5072m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f5073n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f5074o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f5075p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f5076q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f5077r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f5078s;

    /* renamed from: t */
    private int f5079t;

    /* renamed from: u */
    private int f5080u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Calendar f5081v;

    /* renamed from: w */
    private Calendar f5082w;

    /* renamed from: x */
    private int f5083x;

    /* renamed from: y */
    private int f5084y;

    /* renamed from: z */
    private float f5085z;

    /* renamed from: com.meizu.common.widget.DayTimeDatePicker$b */
    public interface C1411b {
        /* renamed from: a */
        void mo16469a(int i, int i2, int i3, int i4, int i5);
    }

    private void setDayRange(int i) {
    }

    private void setMonthRange(int i) {
    }

    /* renamed from: com.meizu.common.widget.DayTimeDatePicker$a */
    private class C1410a implements ScrollTextView.C1497b {

        /* renamed from: a */
        int f5092a = 0;

        C1410a(int i) {
            this.f5092a = i;
        }

        /* renamed from: c */
        public String mo16387c(int i) {
            switch (this.f5092a) {
                case 4:
                    return DayTimeDatePicker.this.f5060a[i];
                case 5:
                    return DayTimeDatePicker.this.f5061b[i];
                case 6:
                    if (DayTimeDatePicker.this.f5073n) {
                        int b = DayTimeDatePicker.this.f5076q;
                        int a = DayTimeDatePicker.this.m5585b(i);
                        if (a > DayTimeDatePicker.this.m5597e(b) - 1) {
                            a -= DayTimeDatePicker.this.m5597e(b);
                            b++;
                        } else if (a < 0) {
                            a += DayTimeDatePicker.this.m5597e(b - 1);
                            b--;
                        }
                        String a2 = DayTimeDatePicker.this.m5581a(b, a + 1, DayTimeDatePicker.this.f5062c);
                        int c = DayTimeDatePicker.this.m5589c(i);
                        StringBuilder sb = new StringBuilder();
                        sb.append(a2);
                        sb.append(DayTimeDatePicker.this.m5600e() ? DayTimeDatePicker.this.f5058P : " ");
                        sb.append(DayTimeDatePicker.this.mo16434a(c - 1));
                        return sb.toString();
                    }
                    int a3 = DayTimeDatePicker.this.m5585b(i);
                    if (a3 > DayTimeDatePicker.this.m5597e(DayTimeDatePicker.this.f5076q) - 1) {
                        a3 -= DayTimeDatePicker.this.m5597e(DayTimeDatePicker.this.f5076q);
                    } else if (a3 < 0) {
                        a3 += DayTimeDatePicker.this.m5597e(DayTimeDatePicker.this.f5076q);
                    }
                    if (DayTimeDatePicker.this.m5600e()) {
                        int i2 = a3 + 1;
                        if (DayTimeDatePicker.this.f5081v != null && DayTimeDatePicker.this.f5081v.get(1) == DayTimeDatePicker.this.f5076q && DayTimeDatePicker.this.f5081v.get(2) == DayTimeDatePicker.this.f5075p) {
                            return i2 + DayTimeDatePicker.this.f5058P + DayTimeDatePicker.this.f5066g[(DayTimeDatePicker.this.m5589c(i) - 1) + DayTimeDatePicker.this.f5081v.get(5)] + DayTimeDatePicker.this.f5059Q;
                        }
                        return i2 + DayTimeDatePicker.this.f5058P + DayTimeDatePicker.this.f5066g[DayTimeDatePicker.this.m5589c(i)] + DayTimeDatePicker.this.f5059Q;
                    }
                    return DayTimeDatePicker.this.f5062c[a3] + " " + DayTimeDatePicker.this.f5066g[DayTimeDatePicker.this.m5589c(i)];
                default:
                    return null;
            }
        }

        /* renamed from: a */
        public void mo16383a(View view, int i, int i2) {
            switch (this.f5092a) {
                case 4:
                    int unused = DayTimeDatePicker.this.f5077r = i2;
                    break;
                case 5:
                    int unused2 = DayTimeDatePicker.this.f5078s = i2;
                    break;
                case 6:
                    if (DayTimeDatePicker.this.f5081v != null && DayTimeDatePicker.this.f5081v.get(1) == DayTimeDatePicker.this.f5076q && DayTimeDatePicker.this.f5081v.get(2) == DayTimeDatePicker.this.f5075p) {
                        int unused3 = DayTimeDatePicker.this.f5074o = DayTimeDatePicker.this.f5081v.get(5) + i2;
                    }
                    int a = DayTimeDatePicker.this.m5585b(i2);
                    int unused4 = DayTimeDatePicker.this.f5074o = DayTimeDatePicker.this.m5589c(i2);
                    int unused5 = DayTimeDatePicker.this.f5075p = a;
                    if (DayTimeDatePicker.this.f5075p > DayTimeDatePicker.this.m5597e(DayTimeDatePicker.this.f5076q) - 1) {
                        int unused6 = DayTimeDatePicker.this.f5075p = DayTimeDatePicker.this.f5075p - DayTimeDatePicker.this.m5597e(DayTimeDatePicker.this.f5076q);
                        int unused7 = DayTimeDatePicker.this.f5076q = DayTimeDatePicker.this.f5076q + 1;
                    } else if (DayTimeDatePicker.this.f5075p < 0) {
                        int unused8 = DayTimeDatePicker.this.f5075p = DayTimeDatePicker.this.f5075p + DayTimeDatePicker.this.m5597e(DayTimeDatePicker.this.f5076q - 1);
                        int unused9 = DayTimeDatePicker.this.f5076q = DayTimeDatePicker.this.f5076q - 1;
                    }
                    DayTimeDatePicker.this.m5588b();
                    break;
                default:
                    return;
            }
            if (DayTimeDatePicker.this.f5057O != null) {
                DayTimeDatePicker.this.f5057O.mo16469a(DayTimeDatePicker.this.f5076q, DayTimeDatePicker.this.f5075p, DayTimeDatePicker.this.f5074o, DayTimeDatePicker.this.f5077r, DayTimeDatePicker.this.f5078s);
            }
            DayTimeDatePicker.this.m5607g(this.f5092a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5588b() {
        int monthDaysCount = getMonthDaysCount();
        int daysPosition = getDaysPosition();
        ScrollTextView scrollTextView = this.f5072m;
        scrollTextView.setData(new C1410a(6), -1.0f, daysPosition - 1, monthDaysCount, this.f5083x, 0, monthDaysCount - 1, false);
    }

    private int getOneMonthBeforeMonthDays() {
        if (this.f5075p >= 1) {
            return m5579a(this.f5076q, this.f5075p - 1);
        }
        return m5579a(this.f5076q - 1, (this.f5075p - 1) + m5597e(this.f5076q - 1));
    }

    private int getTwoMonthBeforeMonthDays() {
        if (this.f5075p >= 2) {
            return m5579a(this.f5076q, this.f5075p - 2);
        }
        return m5579a(this.f5076q - 1, (this.f5075p - 2) + m5597e(this.f5076q - 1));
    }

    private int getOneMonthAfterMonthDays() {
        if (this.f5075p <= m5597e(this.f5076q) - 2) {
            return m5579a(this.f5076q, this.f5075p + 1);
        }
        return m5579a(this.f5076q + 1, (this.f5075p + 1) - m5597e(this.f5076q));
    }

    private int getTwoMonthAfterMonthDays() {
        if (this.f5075p <= m5597e(this.f5076q) - 3) {
            return m5579a(this.f5076q, this.f5075p + 2);
        }
        return m5579a(this.f5076q + 1, (this.f5075p + 2) - m5597e(this.f5076q));
    }

    private int getMonthDaysCount() {
        return getTwoMonthBeforeMonthDays() + getOneMonthBeforeMonthDays() + m5579a(this.f5076q, this.f5075p) + getOneMonthAfterMonthDays() + getTwoMonthAfterMonthDays();
    }

    private int getDaysPosition() {
        return getTwoMonthBeforeMonthDays() + getOneMonthBeforeMonthDays() + this.f5074o;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m5585b(int i) {
        int twoMonthBeforeMonthDays = getTwoMonthBeforeMonthDays();
        int oneMonthBeforeMonthDays = getOneMonthBeforeMonthDays() + twoMonthBeforeMonthDays;
        int a = m5579a(this.f5076q, this.f5075p) + oneMonthBeforeMonthDays;
        int oneMonthAfterMonthDays = getOneMonthAfterMonthDays() + a;
        int twoMonthAfterMonthDays = getTwoMonthAfterMonthDays() + oneMonthAfterMonthDays;
        if (i < twoMonthBeforeMonthDays) {
            return this.f5075p - 2;
        }
        if (i >= twoMonthBeforeMonthDays && i < oneMonthBeforeMonthDays) {
            return this.f5075p - 1;
        }
        if (i >= oneMonthBeforeMonthDays && i < a) {
            return this.f5075p;
        }
        if (i >= a && i < oneMonthAfterMonthDays) {
            return this.f5075p + 1;
        }
        if (i < oneMonthAfterMonthDays || i >= twoMonthAfterMonthDays) {
            return 0;
        }
        return this.f5075p + 2;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m5589c(int i) {
        int twoMonthBeforeMonthDays = getTwoMonthBeforeMonthDays();
        int oneMonthBeforeMonthDays = getOneMonthBeforeMonthDays() + twoMonthBeforeMonthDays;
        int a = m5579a(this.f5076q, this.f5075p) + oneMonthBeforeMonthDays;
        int oneMonthAfterMonthDays = getOneMonthAfterMonthDays() + a;
        int twoMonthAfterMonthDays = getTwoMonthAfterMonthDays() + oneMonthAfterMonthDays;
        if (i < twoMonthBeforeMonthDays) {
            return 1 + i;
        }
        if (i >= twoMonthBeforeMonthDays && i < oneMonthBeforeMonthDays) {
            return 1 + (i - twoMonthBeforeMonthDays);
        }
        if (i >= oneMonthBeforeMonthDays && i < a) {
            return 1 + (i - oneMonthBeforeMonthDays);
        }
        if (i >= a && i < oneMonthAfterMonthDays) {
            return 1 + (i - a);
        }
        if (i < oneMonthAfterMonthDays || i >= twoMonthAfterMonthDays) {
            return 1;
        }
        return 1 + (i - oneMonthAfterMonthDays);
    }

    public DayTimeDatePicker(Context context) {
        this(context, (AttributeSet) null);
    }

    public DayTimeDatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DayTimeDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Context context2 = context;
        this.f5073n = false;
        this.f5083x = 5;
        this.f5054L = false;
        this.f5065f = false;
        this.f5055M = Typeface.create("sans-serif-medium", 0);
        this.f5056N = Typeface.create("DINPro-medium", 0);
        this.f5045C = new ArrayList();
        this.f5045C.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_one)));
        this.f5045C.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_two)));
        this.f5044B = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_word_size);
        this.f5047E = new ArrayList();
        this.f5047E.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
        this.f5047E.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
        this.f5046D = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size);
        this.f5079t = 1900;
        this.f5080u = 2099;
        this.f5060a = new String[100];
        for (int i2 = 0; i2 < 100; i2++) {
            this.f5060a[i2] = String.valueOf(i2);
            if (i2 <= 9) {
                String[] strArr = this.f5060a;
                strArr[i2] = "0" + this.f5060a[i2];
            }
        }
        this.f5064e = getResources().getString(R.string.mc_time_picker_leap);
        this.f5058P = getResources().getString(R.string.mc_date_time_month);
        this.f5059Q = getResources().getString(R.string.mc_date_time_day);
        this.f5061b = new String[100];
        for (int i3 = 0; i3 < 100; i3++) {
            this.f5061b[i3] = String.valueOf(i3);
            if (i3 <= 9) {
                String[] strArr2 = this.f5061b;
                strArr2[i3] = "0" + this.f5061b[i3];
            }
        }
        inflate(getContext(), R.layout.mc_date_picker_day_time_layout, this);
        this.f5069j = (TextView) findViewById(R.id.mc_scroll_month_leap);
        if (this.f5069j != null) {
            this.f5069j.setText(this.f5064e);
            this.f5069j.setVisibility(8);
        }
        this.f5068i = (TextView) findViewById(R.id.mc_scroll_hour_text);
        if (this.f5068i != null) {
            this.f5068i.setText(R.string.mc_date_time_hour);
        }
        this.f5067h = (TextView) findViewById(R.id.mc_scroll_min_text);
        if (this.f5067h != null) {
            this.f5067h.setText(R.string.mc_date_time_min);
        }
        Calendar instance = Calendar.getInstance();
        this.f5076q = instance.get(1);
        this.f5075p = instance.get(2);
        this.f5074o = instance.get(5);
        this.f5057O = null;
        this.f5048F = (LinearLayout) findViewById(R.id.mc_column_parent);
        this.f5072m = (ScrollTextView) findViewById(R.id.mc_scroll_day);
        this.f5072m.setTypeface(this.f5055M);
        if (!(this.f5043A == 0.0f || this.f5085z == 0.0f)) {
            this.f5072m.setItemHeight((float) ((int) this.f5043A), (float) ((int) this.f5085z));
        }
        m5588b();
        this.f5070k = (ScrollTextView) findViewById(R.id.mc_scroll_hour);
        this.f5070k.setTypeface(this.f5056N);
        if (!(this.f5043A == 0.0f || this.f5085z == 0.0f)) {
            this.f5070k.setItemHeight((float) ((int) this.f5043A), (float) ((int) this.f5085z));
        }
        this.f5070k.setData(new C1410a(4), -1.0f, this.f5077r, 24, this.f5083x, 0, 23, true);
        this.f5071l = (ScrollTextView) findViewById(R.id.mc_scroll_min);
        if (!(this.f5043A == 0.0f || this.f5085z == 0.0f)) {
            this.f5071l.setItemHeight((float) ((int) this.f5043A), (float) ((int) this.f5085z));
        }
        this.f5071l.setData(new C1410a(5), -1.0f, this.f5078s, 60, this.f5083x, 0, 59, true);
        m5604f();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.f5081v = Calendar.getInstance();
            Calendar calendar = this.f5081v;
            calendar.setTime(simpleDateFormat.parse(this.f5079t + "-01-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            this.f5082w = Calendar.getInstance();
            Calendar calendar2 = this.f5082w;
            calendar2.setTime(simpleDateFormat.parse(this.f5080u + "-12-31"));
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        m5591c();
        int paddingTop = this.f5068i.getPaddingTop();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        float f = displayMetrics.scaledDensity;
        float f2 = getResources().getDisplayMetrics().scaledDensity;
        int textSize = (int) (((float) paddingTop) - (((this.f5068i.getTextSize() / f2) * (f2 - f)) / 1.3f));
        this.f5068i.setPadding(this.f5068i.getPaddingLeft(), textSize, this.f5068i.getPaddingRight(), this.f5068i.getPaddingBottom());
        this.f5067h.setPadding(this.f5067h.getPaddingLeft(), textSize, this.f5067h.getPaddingRight(), this.f5067h.getPaddingBottom());
        if (!isEnabled()) {
            setEnabled(false);
        }
        this.f5049G = 0;
        this.f5050H = 0;
        this.f5051I = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        this.f5052J = new Paint();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(R.styleable.MZTheme);
        int i4 = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColor, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        obtainStyledAttributes.recycle();
        this.f5052J.setColor(i4);
        this.f5052J.setAntiAlias(true);
        this.f5052J.setStrokeWidth((float) context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.f5053K = false;
        setWillNotDraw(false);
        this.f5062c = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
        this.f5063d = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_day);
        this.f5066g = new String[100];
        for (int i5 = 0; i5 < 100; i5++) {
            this.f5066g[i5] = String.valueOf(i5);
            if (m5600e()) {
                this.f5066g[i5] = String.valueOf(i5);
            }
            if (i5 <= 9) {
                String[] strArr3 = this.f5066g;
                strArr3[i5] = "0" + this.f5066g[i5];
            }
        }
        if (Build.DEVICE.equals("mx4pro")) {
            this.f5071l.mo17192a((ScrollTextView.C1500e) new ScrollTextView.C1500e() {
                /* renamed from: a */
                public void mo16370a(ScrollTextView scrollTextView) {
                }

                /* renamed from: b */
                public void mo16374b(ScrollTextView scrollTextView) {
                    scrollTextView.setIsDrawFading(true);
                }
            });
            this.f5070k.mo17192a((ScrollTextView.C1500e) new ScrollTextView.C1500e() {
                /* renamed from: a */
                public void mo16370a(ScrollTextView scrollTextView) {
                }

                /* renamed from: b */
                public void mo16374b(ScrollTextView scrollTextView) {
                    scrollTextView.setIsDrawFading(true);
                }
            });
            this.f5072m.mo17192a((ScrollTextView.C1500e) new ScrollTextView.C1500e() {
                /* renamed from: a */
                public void mo16370a(ScrollTextView scrollTextView) {
                }

                /* renamed from: b */
                public void mo16374b(ScrollTextView scrollTextView) {
                    DayTimeDatePicker.this.setIsDrawFading(true);
                }
            });
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.f5054L = accessibilityManager.isEnabled();
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f5072m.setEnabled(z);
        this.f5070k.setEnabled(z);
        this.f5071l.setEnabled(z);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DatePicker.class.getName());
    }

    /* renamed from: a */
    public void mo16435a(int i, int i2, int i3, int i4, int i5) {
        m5583a(i, i2, i3, i4, i5, false);
    }

    /* renamed from: a */
    private void m5583a(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.f5076q = i < this.f5079t ? this.f5079t : i;
        if (i > this.f5080u) {
            i = this.f5080u;
        }
        this.f5076q = i;
        int i6 = 11;
        if (i2 <= 11) {
            i6 = i2;
        }
        this.f5075p = i6;
        this.f5074o = i3;
        this.f5077r = i4;
        this.f5078s = i5;
        this.f5070k.setCurrentItem(this.f5077r, z);
        this.f5071l.setCurrentItem(this.f5078s, z);
        if (this.f5084y != getMonthDaysCount()) {
            this.f5084y = getMonthDaysCount();
            this.f5072m.mo17188a(this.f5084y);
        }
        this.f5072m.setCurrentItem(getDaysPosition() - 1, z);
    }

    /* renamed from: d */
    private boolean m5596d(int i) {
        if (!m5600e()) {
            return false;
        }
        int a = LunarCalendar.m5136a(this.f5076q);
        if (a == 0) {
            if (i >= 12) {
                return false;
            }
        } else if (i >= 13) {
            return false;
        }
        if (a == 0 || i <= a - 1 || i != a) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public String mo16434a(int i) {
        if (i > this.f5063d.length - 1) {
            return null;
        }
        return this.f5063d[i];
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public int m5597e(int i) {
        if (!this.f5073n || LunarCalendar.m5136a(i) == 0) {
            return 12;
        }
        return 13;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f5053K) {
            int width = getWidth();
            int width2 = this.f5048F.getWidth() - (this.f5051I * 2);
            int i = (width - width2) / 2;
            Canvas canvas2 = canvas;
            float f = (float) i;
            float f2 = (float) (i + width2);
            canvas2.drawLine(f, (float) this.f5049G, f2, (float) this.f5049G, this.f5052J);
            canvas2.drawLine(f, (float) this.f5050H, f2, (float) this.f5050H, this.f5052J);
        }
    }

    public void setOnTimeChangedListener(C1411b bVar) {
        this.f5057O = bVar;
    }

    public void setIsDrawLine(boolean z) {
        this.f5053K = z;
    }

    public void setLineHeight(int i, int i2) {
        this.f5049G = i;
        this.f5050H = i2;
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

        /* renamed from: a */
        private final int f5089a;

        /* renamed from: b */
        private final int f5090b;

        /* renamed from: c */
        private final int f5091c;

        private SavedState(Parcelable parcelable, int i, int i2, int i3) {
            super(parcelable);
            this.f5089a = i;
            this.f5090b = i2;
            this.f5091c = i3;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f5089a = parcel.readInt();
            this.f5090b = parcel.readInt();
            this.f5091c = parcel.readInt();
        }

        /* renamed from: a */
        public int mo16461a() {
            return this.f5089a;
        }

        /* renamed from: b */
        public int mo16462b() {
            return this.f5090b;
        }

        /* renamed from: c */
        public int mo16463c() {
            return this.f5091c;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5089a);
            parcel.writeInt(this.f5090b);
            parcel.writeInt(this.f5091c);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f5076q, this.f5075p, this.f5074o);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f5076q = savedState.mo16461a();
        this.f5075p = savedState.mo16462b();
        this.f5074o = savedState.mo16463c();
    }

    public int getYear() {
        return this.f5076q;
    }

    public int getMonth() {
        return this.f5075p;
    }

    public int getDayOfMonth() {
        return this.f5074o;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
        }
    }

    public void setLunar(boolean z, boolean z2) {
        int[] iArr;
        boolean z3;
        int i;
        this.f5073n = z;
        int[] iArr2 = {this.f5076q, this.f5075p + 1, this.f5074o, 0};
        int i2 = iArr2[0];
        int a = LunarCalendar.m5136a(iArr2[0]);
        int a2 = LunarCalendar.m5136a(iArr2[0] - 1);
        if (this.f5073n) {
            iArr = LunarCalendar.m5139a(iArr2[0], iArr2[1], iArr2[2]);
            if (!(i2 == iArr[0] || a2 == 0 || (iArr[3] != 1 && iArr[1] <= a2)) || (i2 == iArr[0] && a != 0 && (iArr[3] == 1 || iArr[1] > a))) {
                iArr[1] = iArr[1] + 1;
            }
        } else {
            if (a == 0 || a >= iArr2[1]) {
                i = iArr2[1];
            } else {
                int i3 = a + 1;
                if (i3 == iArr2[1]) {
                    i = iArr2[1] - 1;
                    z3 = true;
                    iArr = LunarCalendar.m5140a(iArr2[0], i, iArr2[2], z3);
                } else {
                    i = i3 < iArr2[1] ? iArr2[1] - 1 : 0;
                }
            }
            z3 = false;
            iArr = LunarCalendar.m5140a(iArr2[0], i, iArr2[2], z3);
        }
        m5604f();
        m5583a(iArr[0], iArr[1] - 1 < 0 ? 12 : iArr[1] - 1, iArr[2], this.f5077r, this.f5078s, z2);
        setLeapUnitVisibility(this.f5075p);
    }

    public void setLunar(boolean z) {
        setLunar(z, true);
    }

    /* renamed from: a */
    public boolean mo16436a() {
        return this.f5073n;
    }

    private int getMonthDays() {
        if (this.f5073n) {
            int i = this.f5075p;
            int a = LunarCalendar.m5136a(this.f5076q);
            boolean z = false;
            if (a != 0 && a == i) {
                z = true;
            }
            if (a == 0 || (a != 0 && this.f5075p < a)) {
                i++;
            }
            return LunarCalendar.m5138a(this.f5076q, i, z);
        }
        Calendar instance = Calendar.getInstance();
        instance.set(5, 1);
        instance.set(1, this.f5076q);
        instance.set(2, this.f5075p);
        return instance.getActualMaximum(5);
    }

    /* renamed from: a */
    private int m5579a(int i, int i2) {
        boolean z = false;
        if (this.f5081v != null && this.f5082w != null && ((this.f5081v.get(1) == i && this.f5081v.get(2) > i2) || this.f5081v.get(1) > i || ((this.f5082w.get(1) == i && this.f5082w.get(2) < i2) || this.f5082w.get(1) < i))) {
            return 0;
        }
        if (this.f5081v != null && this.f5081v.get(1) == i && this.f5081v.get(2) == i2) {
            return this.f5081v.getActualMaximum(5) - this.f5081v.get(5);
        }
        if (this.f5082w != null && this.f5082w.get(1) == i && this.f5082w.get(2) == i2) {
            if (!this.f5073n) {
                return this.f5082w.get(5);
            }
            if (this.f5082w.get(5) > 30) {
                return 30;
            }
            return this.f5082w.get(5);
        } else if (this.f5073n) {
            int a = LunarCalendar.m5136a(i);
            if (a != 0 && a == i2) {
                z = true;
            }
            if (a == 0 || (a != 0 && i2 < a)) {
                i2++;
            }
            return LunarCalendar.m5138a(i, i2, z);
        } else {
            Calendar instance = Calendar.getInstance();
            instance.set(5, 1);
            instance.set(1, i);
            instance.set(2, i2);
            return instance.getActualMaximum(5);
        }
    }

    private Calendar getCurrentCalendar() {
        Calendar instance = Calendar.getInstance();
        instance.set(5, 1);
        instance.set(1, this.f5076q);
        instance.set(2, this.f5075p);
        return instance;
    }

    /* renamed from: c */
    private void m5591c() {
        this.f5068i = (TextView) findViewById(R.id.mc_scroll_hour_text);
        if (this.f5068i != null) {
            this.f5068i.setText(R.string.mc_date_time_hour);
        }
        this.f5067h = (TextView) findViewById(R.id.mc_scroll_min_text);
        if (this.f5067h != null) {
            this.f5067h.setText(R.string.mc_date_time_min);
        }
    }

    public void setTextColor(int i, int i2, int i3) {
        this.f5072m.setTextColor(i, i2);
        this.f5070k.setTextColor(i, i2);
        this.f5071l.setTextColor(i, i2);
        this.f5067h.setTextColor(i3);
        this.f5068i.setTextColor(i3);
    }

    public void setTextColor(int i, List<Integer> list, int i2) {
        this.f5072m.setTextColor(i, list);
        this.f5070k.setTextColor(i, list);
        this.f5071l.setTextColor(i, list);
        this.f5067h.setTextColor(i2);
        this.f5068i.setTextColor(i2);
    }

    public void setItemHeight(int i, int i2) {
        float f = (float) i;
        float f2 = (float) i2;
        this.f5072m.setItemHeight(f, f2);
        this.f5070k.setItemHeight(f, f2);
        this.f5071l.setItemHeight(f, f2);
    }

    public TextView getMinUnit() {
        return this.f5067h;
    }

    public void setIsDrawFading(boolean z) {
        this.f5071l.setIsDrawFading(z);
        this.f5070k.setIsDrawFading(z);
        this.f5072m.setIsDrawFading(z);
    }

    /* renamed from: f */
    private String m5603f(int i) {
        switch (i) {
            case 4:
                return String.valueOf(this.f5077r);
            case 5:
                return String.valueOf(this.f5078s);
            default:
                return "";
        }
    }

    /* renamed from: d */
    private void m5595d() {
        if (this.f5054L) {
            View findViewById = findViewById(R.id.mc_column_min_Layout);
            View findViewById2 = findViewById(R.id.mc_column_day_Layout);
            View findViewById3 = findViewById(R.id.mc_column_hour_Layout);
            String replace = (m5603f(6) + m5603f(4) + this.f5068i.getText() + m5603f(5) + this.f5067h.getText()).replace(" ", "").replace("廿十", "二十").replace("廿", "二十");
            if (findViewById != null) {
                findViewById.setFocusable(true);
                findViewById.setContentDescription("上下滚动设置分，当前日期是" + replace);
            }
            if (findViewById2 != null) {
                findViewById2.setFocusable(true);
                findViewById2.setContentDescription("上下滚动设置日，当前日期是" + replace);
            }
            if (findViewById3 != null) {
                findViewById3.setFocusable(true);
                findViewById3.setContentDescription("上下滚动设置时，当前日期是" + replace);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m5607g(int i) {
        View findViewById;
        if (this.f5054L) {
            m5595d();
            if (i == 5) {
                View findViewById2 = findViewById(R.id.mc_column_min_Layout);
                if (findViewById2 != null) {
                    findViewById2.sendAccessibilityEvent(4);
                }
            } else if (i == 4) {
                View findViewById3 = findViewById(R.id.mc_column_hour_Layout);
                if (findViewById3 != null) {
                    findViewById3.sendAccessibilityEvent(4);
                }
            } else if (i == 6 && (findViewById = findViewById(R.id.mc_column_day_Layout)) != null) {
                findViewById.sendAccessibilityEvent(4);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m5600e() {
        return getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    /* renamed from: f */
    private void m5604f() {
        if (!this.f5073n || !m5600e()) {
            this.f5072m.setTextSize((float) this.f5046D, this.f5047E);
            this.f5072m.setTypeface(this.f5056N);
        } else {
            this.f5072m.setTextSize((float) this.f5044B, this.f5045C);
            this.f5072m.setTypeface(this.f5055M);
        }
        this.f5070k.setTextSize((float) this.f5046D, this.f5047E);
        this.f5070k.setTypeface(this.f5056N);
        this.f5071l.setTextSize((float) this.f5046D, this.f5047E);
        this.f5071l.setTypeface(this.f5056N);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m5581a(int i, int i2, String[] strArr) {
        int a = LunarCalendar.m5136a(i);
        if (a != 0 && i2 > a) {
            return strArr[(i2 - 1) - 1];
        }
        if (i2 - 1 >= strArr.length) {
            i2 = strArr.length - 1;
        }
        return strArr[i2 - 1];
    }

    private void setLeapUnitVisibility(int i) {
        if (!mo16436a() || !m5596d(i)) {
            this.f5069j.setVisibility(8);
        } else {
            this.f5069j.setVisibility(0);
        }
    }

    public void setCurrentHour(Integer num) {
        if (num != null && num.intValue() != getCurrentHour()) {
            mo16435a(this.f5076q, this.f5075p, this.f5074o, num.intValue(), this.f5078s);
        }
    }

    public void setCurrentMinute(Integer num) {
        mo16435a(this.f5076q, this.f5075p, this.f5074o, getCurrentHour(), num.intValue());
    }

    public int getCurrentHour() {
        return this.f5077r;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.f5078s);
    }
}
