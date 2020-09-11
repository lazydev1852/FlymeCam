package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.widget.ScrollTextView;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DatePicker extends FrameLayout {

    /* renamed from: A */
    private volatile Locale f4942A;

    /* renamed from: B */
    private String[] f4943B;

    /* renamed from: C */
    private int f4944C;

    /* renamed from: D */
    private int f4945D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f4946E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public int f4947F;

    /* renamed from: G */
    private float f4948G;

    /* renamed from: H */
    private float f4949H;

    /* renamed from: I */
    private int f4950I;

    /* renamed from: J */
    private List<Float> f4951J;

    /* renamed from: K */
    private int f4952K;

    /* renamed from: L */
    private List<Float> f4953L;

    /* renamed from: M */
    private LinearLayout f4954M;

    /* renamed from: N */
    private int f4955N;

    /* renamed from: O */
    private int f4956O;

    /* renamed from: P */
    private int f4957P;

    /* renamed from: Q */
    private Paint f4958Q;

    /* renamed from: R */
    private boolean f4959R;

    /* renamed from: S */
    private boolean f4960S;

    /* renamed from: T */
    private boolean f4961T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public int f4962U;

    /* renamed from: a */
    String f4963a;

    /* renamed from: b */
    String[] f4964b;

    /* renamed from: c */
    String[] f4965c;

    /* renamed from: d */
    String f4966d;

    /* renamed from: e */
    boolean f4967e;

    /* renamed from: f */
    String[] f4968f;

    /* renamed from: g */
    private TextView f4969g;

    /* renamed from: h */
    private TextView f4970h;

    /* renamed from: i */
    private TextView f4971i;

    /* renamed from: j */
    private TextView f4972j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ScrollTextView f4973k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ScrollTextView f4974l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ScrollTextView f4975m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f4976n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C1399b f4977o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f4978p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f4979q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f4980r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f4981s;

    /* renamed from: t */
    private int f4982t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public Calendar f4983u;

    /* renamed from: v */
    private Calendar f4984v;

    /* renamed from: w */
    private int f4985w;

    /* renamed from: x */
    private int f4986x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public String[] f4987y;

    /* renamed from: z */
    private Object f4988z;

    /* renamed from: com.meizu.common.widget.DatePicker$b */
    public interface C1399b {
        /* renamed from: a */
        void mo16423a(DatePicker datePicker, int i, int i2, int i3);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m5482a(int i, int i2, int i3) {
        if (i <= i2 || i2 != 0 || i3 < i) {
            if (i < i2 && i == 0 && i3 >= i2) {
                return 1;
            }
            if (i >= i2 || i == 0 || i > i3 || i2 <= i3) {
                return (i <= i2 || i2 == 0 || i <= i3 || i2 > i3) ? 0 : 1;
            }
        }
        return -1;
    }

    /* renamed from: com.meizu.common.widget.DatePicker$a */
    private class C1398a implements ScrollTextView.C1497b {

        /* renamed from: a */
        int f4996a = 0;

        C1398a(int i) {
            this.f4996a = i;
        }

        /* renamed from: c */
        public String mo16387c(int i) {
            switch (this.f4996a) {
                case 1:
                    return String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i + DatePicker.this.f4981s)});
                case 2:
                    if (DatePicker.this.f4976n) {
                        return DatePicker.this.m5492c(i);
                    }
                    if (DatePicker.this.f4983u != null && DatePicker.this.f4983u.get(1) == DatePicker.this.f4980r) {
                        i += DatePicker.this.f4983u.get(2);
                    }
                    if (i < DatePicker.this.f4987y.length) {
                        return DatePicker.this.f4987y[i];
                    }
                    return null;
                case 3:
                    if (DatePicker.this.f4976n) {
                        return DatePicker.this.mo16389a(i);
                    }
                    if (DatePicker.this.f4983u != null && DatePicker.this.f4983u.get(1) == DatePicker.this.f4980r && DatePicker.this.f4983u.get(2) == DatePicker.this.f4979q) {
                        return DatePicker.this.f4968f[i + DatePicker.this.f4983u.get(5)];
                    }
                    return DatePicker.this.f4968f[i + 1];
                default:
                    return null;
            }
        }

        /* renamed from: a */
        public void mo16383a(View view, int i, int i2) {
            int g = DatePicker.this.getMonthDays();
            int unused = DatePicker.this.getYearMonths();
            switch (this.f4996a) {
                case 1:
                    int d = DatePicker.this.f4980r;
                    int unused2 = DatePicker.this.f4980r = i2 + DatePicker.this.f4981s;
                    if (DatePicker.this.f4983u != null && DatePicker.this.f4983u.get(1) == DatePicker.this.f4980r && DatePicker.this.f4979q < DatePicker.this.f4983u.get(2)) {
                        int unused3 = DatePicker.this.f4979q = DatePicker.this.f4983u.get(2);
                    }
                    if (DatePicker.this.f4974l != null) {
                        int h = DatePicker.this.getYearMonths();
                        if (DatePicker.this.f4976n) {
                            int a = DatePicker.this.m5482a(LunarCalendar.m5136a(d), LunarCalendar.m5136a(DatePicker.this.f4980r), DatePicker.this.f4962U);
                            int unused4 = DatePicker.this.f4946E = h;
                            DatePicker.this.f4974l.mo17189a(h, a);
                            int unused5 = DatePicker.this.f4979q = DatePicker.this.f4974l.getCurrentItem();
                        } else {
                            int unused6 = DatePicker.this.f4946E = h;
                            DatePicker.this.f4974l.mo17188a(h);
                        }
                        int i3 = h - 1;
                        if (i3 < DatePicker.this.f4979q) {
                            int unused7 = DatePicker.this.f4978p = g;
                            int unused8 = DatePicker.this.f4979q = i3;
                            DatePicker.this.f4974l.setCurrentItem(DatePicker.this.f4979q, true);
                        }
                    }
                    if (!(g == DatePicker.this.getMonthDays() || DatePicker.this.f4973k == null)) {
                        int g2 = DatePicker.this.getMonthDays();
                        int unused9 = DatePicker.this.f4947F = g2;
                        DatePicker.this.f4973k.mo17188a(g2);
                        if (g2 < DatePicker.this.f4978p) {
                            int unused10 = DatePicker.this.f4978p = g2;
                            DatePicker.this.f4973k.setCurrentItem(DatePicker.this.f4978p - 1, true);
                            break;
                        }
                    }
                    break;
                case 2:
                    int unused11 = DatePicker.this.f4979q = i2;
                    if (DatePicker.this.f4983u != null && DatePicker.this.f4983u.get(1) == DatePicker.this.f4980r) {
                        int unused12 = DatePicker.this.f4979q = DatePicker.this.f4979q + DatePicker.this.f4983u.get(2);
                    }
                    if (!(g == DatePicker.this.getMonthDays() || DatePicker.this.f4973k == null)) {
                        int g3 = DatePicker.this.getMonthDays();
                        int unused13 = DatePicker.this.f4947F = g3;
                        DatePicker.this.f4973k.mo17188a(g3);
                        if (g3 < DatePicker.this.f4978p) {
                            int unused14 = DatePicker.this.f4978p = g3;
                            DatePicker.this.f4973k.setCurrentItem(DatePicker.this.f4978p - 1, true);
                            break;
                        }
                    }
                    break;
                case 3:
                    if (DatePicker.this.f4973k.getVisibility() != 8) {
                        int unused15 = DatePicker.this.f4978p = i2 + 1;
                        if (DatePicker.this.f4983u != null && DatePicker.this.f4983u.get(1) == DatePicker.this.f4980r && DatePicker.this.f4983u.get(2) == DatePicker.this.f4979q) {
                            int unused16 = DatePicker.this.f4978p = i2 + DatePicker.this.f4983u.get(5);
                            break;
                        }
                    }
                    break;
                default:
                    return;
            }
            DatePicker.this.setDayRange(DatePicker.this.f4979q);
            DatePicker.this.setMonthRange(DatePicker.this.f4980r);
            if (DatePicker.this.f4977o != null) {
                DatePicker.this.f4977o.mo16423a(DatePicker.this, DatePicker.this.f4980r, DatePicker.this.f4979q, DatePicker.this.f4978p);
            }
            if (this.f4996a == 1 || this.f4996a == 2) {
                DatePicker.this.setLeapUnitVisibility(DatePicker.this.f4979q);
            }
            if (DatePicker.this.f4974l != null) {
                int unused17 = DatePicker.this.f4962U = DatePicker.this.f4974l.getCurrentItem();
            }
            DatePicker.this.m5501e(this.f4996a);
        }
    }

    /* access modifiers changed from: private */
    public void setMonthRange(int i) {
        int i2;
        boolean z;
        int i3;
        if (this.f4983u != null && this.f4984v != null && this.f4985w != i) {
            this.f4985w = i;
            this.f4986x = -1;
            boolean z2 = true;
            if (this.f4983u.get(1) <= i && this.f4984v.get(1) >= i) {
                int i4 = this.f4979q - this.f4983u.get(2) < 0 ? 0 : this.f4979q - this.f4983u.get(2);
                int a = LunarCalendar.m5136a(i);
                if (this.f4983u.get(1) == i && this.f4984v.get(1) == i) {
                    i2 = (this.f4984v.get(2) - this.f4983u.get(2)) + 1;
                } else if (this.f4983u.get(1) == i) {
                    i2 = (this.f4983u.getActualMaximum(2) + 1) - this.f4983u.get(2);
                    if (this.f4976n && a > 0 && a < i2) {
                        i2++;
                    }
                } else if (this.f4984v.get(1) == i) {
                    i4 = this.f4984v.get(2) - this.f4979q < 0 ? 0 : this.f4979q;
                    int i5 = this.f4984v.get(2) + 1;
                    if (this.f4976n && a > 0 && a < i5) {
                        i5++;
                    }
                    i3 = i2 - 1;
                    z = false;
                    if ((this.f4976n || i2 != this.f4983u.getActualMaximum(2) + 1) && ((!this.f4976n || a <= 0 || i2 != this.f4983u.getActualMaximum(2) + 1 + 1) && !(this.f4976n && a == 0 && i2 == this.f4983u.getActualMaximum(2) + 1))) {
                        z2 = z;
                    }
                    this.f4974l.setCyclic(z2);
                    this.f4974l.mo17190a(i2, i4, 0, i3);
                } else if (!this.f4974l.mo17198c()) {
                    i4 = this.f4979q;
                    i2 = this.f4983u.getActualMaximum(2) + 1;
                    i3 = this.f4983u.getActualMaximum(2);
                    z = true;
                    z2 = z;
                    this.f4974l.setCyclic(z2);
                    this.f4974l.mo17190a(i2, i4, 0, i3);
                } else {
                    return;
                }
                i3 = i2;
                z = false;
                z2 = z;
                this.f4974l.setCyclic(z2);
                this.f4974l.mo17190a(i2, i4, 0, i3);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006f, code lost:
        if (r1 == r9.f4983u.getActualMaximum(5)) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b5, code lost:
        if (r1 == r9.f4984v.getActualMaximum(5)) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0119, code lost:
        if (r1 == r9.f4984v.getActualMaximum(5)) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014e, code lost:
        if (r1 == r9.f4983u.getActualMaximum(5)) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x017c, code lost:
        if (r1 == r9.f4984v.getActualMaximum(5)) goto L_0x017e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0189 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x018a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDayRange(int r10) {
        /*
            r9 = this;
            java.util.Calendar r0 = r9.f4983u
            if (r0 == 0) goto L_0x0196
            java.util.Calendar r0 = r9.f4984v
            if (r0 != 0) goto L_0x000a
            goto L_0x0196
        L_0x000a:
            int r0 = r9.f4985w
            int r1 = r9.f4980r
            if (r0 != r1) goto L_0x0015
            int r0 = r9.f4986x
            if (r0 != r10) goto L_0x0015
            return
        L_0x0015:
            r9.f4986x = r10
            java.util.Calendar r0 = r9.getCurrentCalendar()
            int r1 = r9.getMonthDays()
            int r2 = r9.f4978p
            r3 = 1
            int r2 = r2 - r3
            r4 = 5
            int r0 = r0.getActualMaximum(r4)
            java.util.Calendar r5 = r9.f4983u
            int r5 = r5.get(r3)
            int r6 = r9.f4980r
            r7 = 2
            r8 = 0
            if (r5 != r6) goto L_0x0077
            java.util.Calendar r5 = r9.f4984v
            int r5 = r5.get(r3)
            int r6 = r9.f4980r
            if (r5 == r6) goto L_0x0077
            java.util.Calendar r5 = r9.f4983u
            int r5 = r5.get(r7)
            if (r5 != r10) goto L_0x017e
            java.util.Calendar r10 = r9.f4983u
            int r10 = r10.get(r4)
            int r10 = r2 - r10
            if (r10 >= 0) goto L_0x0052
            r2 = 0
            goto L_0x005a
        L_0x0052:
            java.util.Calendar r10 = r9.f4983u
            int r10 = r10.get(r4)
            int r2 = r2 - r10
            int r2 = r2 + r3
        L_0x005a:
            java.util.Calendar r10 = r9.f4983u
            int r10 = r10.getActualMaximum(r4)
            java.util.Calendar r0 = r9.f4983u
            int r0 = r0.get(r4)
            int r10 = r10 - r0
            int r1 = r10 + 1
            java.util.Calendar r10 = r9.f4983u
            int r10 = r10.getActualMaximum(r4)
            if (r1 != r10) goto L_0x0073
        L_0x0071:
            r10 = 1
            goto L_0x0074
        L_0x0073:
            r10 = 0
        L_0x0074:
            r0 = r1
            goto L_0x017f
        L_0x0077:
            java.util.Calendar r5 = r9.f4983u
            int r5 = r5.get(r3)
            int r6 = r9.f4980r
            if (r5 == r6) goto L_0x00bc
            java.util.Calendar r5 = r9.f4984v
            int r5 = r5.get(r3)
            int r6 = r9.f4980r
            if (r5 != r6) goto L_0x00bc
            java.util.Calendar r5 = r9.f4984v
            int r5 = r5.get(r7)
            if (r5 != r10) goto L_0x017e
            java.util.Calendar r10 = r9.f4984v
            int r10 = r10.get(r4)
            if (r2 < r10) goto L_0x00a3
            java.util.Calendar r10 = r9.f4984v
            int r10 = r10.get(r4)
            int r2 = r10 + -1
        L_0x00a3:
            java.util.Calendar r10 = r9.f4984v
            int r1 = r10.get(r4)
            java.util.Calendar r10 = r9.f4984v
            int r0 = r10.get(r4)
            java.util.Calendar r10 = r9.f4984v
            int r10 = r10.getActualMaximum(r4)
            if (r1 != r10) goto L_0x00b9
            goto L_0x017e
        L_0x00b9:
            r10 = 0
            goto L_0x017f
        L_0x00bc:
            java.util.Calendar r5 = r9.f4983u
            int r5 = r5.get(r3)
            int r6 = r9.f4980r
            if (r5 != r6) goto L_0x017e
            java.util.Calendar r5 = r9.f4984v
            int r5 = r5.get(r3)
            int r6 = r9.f4980r
            if (r5 != r6) goto L_0x017e
            java.util.Calendar r5 = r9.f4983u
            int r5 = r5.get(r7)
            if (r5 > r10) goto L_0x017e
            java.util.Calendar r5 = r9.f4984v
            int r5 = r5.get(r7)
            if (r5 < r10) goto L_0x017e
            java.util.Calendar r5 = r9.f4983u
            int r5 = r5.get(r7)
            if (r5 != r10) goto L_0x011d
            java.util.Calendar r5 = r9.f4984v
            int r5 = r5.get(r7)
            if (r5 != r10) goto L_0x011d
            java.util.Calendar r10 = r9.f4983u
            int r10 = r10.get(r4)
            int r10 = r2 - r10
            if (r10 >= 0) goto L_0x00fc
            r2 = 0
            goto L_0x0104
        L_0x00fc:
            java.util.Calendar r10 = r9.f4983u
            int r10 = r10.get(r4)
            int r2 = r2 - r10
            int r2 = r2 + r3
        L_0x0104:
            java.util.Calendar r10 = r9.f4984v
            int r10 = r10.get(r4)
            java.util.Calendar r0 = r9.f4983u
            int r0 = r0.get(r4)
            int r10 = r10 - r0
            int r1 = r10 + 1
            java.util.Calendar r10 = r9.f4984v
            int r10 = r10.getActualMaximum(r4)
            if (r1 != r10) goto L_0x0073
            goto L_0x0071
        L_0x011d:
            java.util.Calendar r5 = r9.f4983u
            int r5 = r5.get(r7)
            if (r5 != r10) goto L_0x0152
            java.util.Calendar r10 = r9.f4983u
            int r10 = r10.get(r4)
            int r10 = r2 - r10
            if (r10 >= 0) goto L_0x0131
            r2 = 0
            goto L_0x0139
        L_0x0131:
            java.util.Calendar r10 = r9.f4983u
            int r10 = r10.get(r4)
            int r2 = r2 - r10
            int r2 = r2 + r3
        L_0x0139:
            java.util.Calendar r10 = r9.f4983u
            int r10 = r10.getActualMaximum(r4)
            java.util.Calendar r0 = r9.f4983u
            int r0 = r0.get(r4)
            int r10 = r10 - r0
            int r1 = r10 + 1
            java.util.Calendar r10 = r9.f4983u
            int r10 = r10.getActualMaximum(r4)
            if (r1 != r10) goto L_0x0073
            goto L_0x0071
        L_0x0152:
            java.util.Calendar r5 = r9.f4984v
            int r5 = r5.get(r7)
            if (r5 != r10) goto L_0x017e
            java.util.Calendar r10 = r9.f4984v
            int r10 = r10.get(r4)
            if (r2 < r10) goto L_0x016a
            java.util.Calendar r10 = r9.f4984v
            int r10 = r10.get(r4)
            int r2 = r10 + -1
        L_0x016a:
            java.util.Calendar r10 = r9.f4984v
            int r1 = r10.get(r4)
            java.util.Calendar r10 = r9.f4984v
            int r0 = r10.get(r4)
            java.util.Calendar r10 = r9.f4984v
            int r10 = r10.getActualMaximum(r4)
            if (r1 != r10) goto L_0x00b9
        L_0x017e:
            r10 = 1
        L_0x017f:
            if (r10 == 0) goto L_0x018a
            com.meizu.common.widget.ScrollTextView r4 = r9.f4973k
            boolean r4 = r4.mo17198c()
            if (r4 == 0) goto L_0x018a
            return
        L_0x018a:
            com.meizu.common.widget.ScrollTextView r4 = r9.f4973k
            r4.setCyclic(r10)
            com.meizu.common.widget.ScrollTextView r10 = r9.f4973k
            int r0 = r0 - r3
            r10.mo17190a(r1, r2, r8, r0)
            return
        L_0x0196:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.DatePicker.setDayRange(int):void");
    }

    public DatePicker(Context context) {
        this(context, (AttributeSet) null);
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Context context2 = context;
        this.f4976n = false;
        this.f4988z = new Object();
        this.f4944C = 5;
        this.f4945D = R.layout.mc_date_picker;
        this.f4960S = false;
        this.f4967e = false;
        this.f4961T = false;
        this.f4962U = 0;
        this.f4961T = context.getResources().getConfiguration().getLayoutDirection() == 1;
        this.f4951J = new ArrayList();
        this.f4951J.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_one)));
        this.f4951J.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_two)));
        this.f4950I = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_word_size);
        this.f4953L = new ArrayList();
        this.f4953L.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
        this.f4953L.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
        this.f4952K = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.DatePicker);
        this.f4981s = obtainStyledAttributes.getInt(R.styleable.DatePicker_mcStartYear, 1900);
        this.f4982t = obtainStyledAttributes.getInt(R.styleable.DatePicker_mcEndYear, 2099);
        this.f4945D = obtainStyledAttributes.getResourceId(R.styleable.DatePicker_mcInternalLayout, this.f4945D);
        this.f4944C = obtainStyledAttributes.getInt(R.styleable.DatePicker_mcVisibleRow, this.f4944C);
        this.f4949H = obtainStyledAttributes.getDimension(R.styleable.DatePicker_mcSelectItemHeight, this.f4949H);
        this.f4948G = obtainStyledAttributes.getDimension(R.styleable.DatePicker_mcNormalItemHeight, this.f4948G);
        obtainStyledAttributes.recycle();
        inflate(getContext(), this.f4945D, this);
        this.f4972j = (TextView) findViewById(R.id.mc_leap);
        this.f4970h = (TextView) findViewById(R.id.mc_scroll1_text);
        if (this.f4970h != null) {
            this.f4970h.setText(R.string.mc_date_time_month);
        }
        this.f4969g = (TextView) findViewById(R.id.mc_scroll2_text);
        if (this.f4969g != null) {
            this.f4969g.setText(R.string.mc_date_time_day);
        }
        this.f4971i = (TextView) findViewById(R.id.mc_scroll3_text);
        if (this.f4971i != null) {
            this.f4971i.setText(R.string.mc_date_time_year);
        }
        Calendar instance = Calendar.getInstance();
        this.f4980r = instance.get(1);
        this.f4979q = instance.get(2);
        this.f4978p = instance.get(5);
        this.f4977o = null;
        int actualMaximum = instance.getActualMaximum(5);
        this.f4954M = (LinearLayout) findViewById(R.id.mc_column_parent);
        this.f4973k = (ScrollTextView) findViewById(R.id.mc_scroll2);
        float f = 0.0f;
        if (!(this.f4949H == 0.0f || this.f4948G == 0.0f)) {
            this.f4973k.setItemHeight((float) ((int) this.f4949H), (float) ((int) this.f4948G));
        }
        this.f4973k.setData(new C1398a(3), -1.0f, this.f4978p - 1, actualMaximum, this.f4944C, 0, actualMaximum - 1, true);
        this.f4974l = (ScrollTextView) findViewById(R.id.mc_scroll1);
        if (!(this.f4949H == 0.0f || this.f4948G == 0.0f)) {
            this.f4974l.setItemHeight((float) ((int) this.f4949H), (float) ((int) this.f4948G));
        }
        this.f4987y = getShortMonths();
        this.f4974l.setData(new C1398a(2), -1.0f, this.f4979q, 12, this.f4944C, 0, 11, true);
        this.f4975m = (ScrollTextView) findViewById(R.id.mc_scroll3);
        if (!(this.f4949H == 0.0f || this.f4948G == 0.0f)) {
            this.f4975m.setItemHeight((float) ((int) this.f4949H), (float) ((int) this.f4948G));
        }
        m5507g();
        m5494c();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.f4983u = Calendar.getInstance();
            Calendar calendar = this.f4983u;
            calendar.setTime(simpleDateFormat.parse(this.f4981s + "-01-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            this.f4984v = Calendar.getInstance();
            Calendar calendar2 = this.f4984v;
            calendar2.setTime(simpleDateFormat.parse(this.f4982t + "-12-31"));
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        m5487a(this.f4987y);
        boolean f2 = m5505f();
        this.f4969g.setVisibility(f2 ? 0 : 8);
        this.f4970h.setVisibility(f2 ? 0 : 8);
        this.f4971i.setVisibility(f2 ? 0 : 8);
        m5498d();
        int paddingTop = this.f4971i.getPaddingTop();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        float f3 = displayMetrics.scaledDensity;
        float f4 = getResources().getDisplayMetrics().scaledDensity;
        float textSize = ((this.f4971i.getTextSize() / f4) * (f4 - f3)) / 1.3f;
        int i2 = (int) (((float) paddingTop) - textSize);
        this.f4971i.setPadding(this.f4971i.getPaddingLeft(), i2, this.f4971i.getPaddingRight(), this.f4971i.getPaddingBottom());
        this.f4970h.setPadding(this.f4970h.getPaddingLeft(), i2, this.f4970h.getPaddingRight(), this.f4970h.getPaddingBottom());
        this.f4972j.setPadding(this.f4972j.getPaddingLeft(), (int) (((float) this.f4972j.getPaddingTop()) - (textSize != 0.0f ? textSize + (f4 * 2.0f) : f)), this.f4972j.getPaddingRight(), this.f4972j.getPaddingBottom());
        this.f4969g.setPadding(this.f4969g.getPaddingLeft(), i2, this.f4969g.getPaddingRight(), this.f4969g.getPaddingBottom());
        if (!isEnabled()) {
            setEnabled(false);
        }
        this.f4955N = 0;
        this.f4956O = 0;
        this.f4957P = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        this.f4958Q = new Paint();
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(R.styleable.MZTheme);
        int i3 = obtainStyledAttributes2.getInt(R.styleable.MZTheme_mzThemeColor, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        obtainStyledAttributes2.recycle();
        this.f4958Q.setColor(i3);
        this.f4958Q.setAntiAlias(true);
        this.f4958Q.setStrokeWidth((float) context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.f4959R = false;
        setWillNotDraw(false);
        this.f4964b = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
        this.f4965c = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_day);
        String format = String.format(Locale.getDefault(), "%d", new Object[]{0});
        this.f4968f = new String[100];
        for (int i4 = 0; i4 < 100; i4++) {
            this.f4968f[i4] = String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i4)});
            if (i4 <= 9) {
                String[] strArr = this.f4968f;
                strArr[i4] = format + this.f4968f[i4];
            }
        }
        this.f4966d = getResources().getString(R.string.mc_time_picker_leap);
        this.f4972j.setText(this.f4966d);
        this.f4972j.setVisibility(8);
        if (Build.DEVICE.equals("mx4pro")) {
            this.f4975m.mo17192a((ScrollTextView.C1500e) new ScrollTextView.C1500e() {
                /* renamed from: a */
                public void mo16370a(ScrollTextView scrollTextView) {
                }

                /* renamed from: b */
                public void mo16374b(ScrollTextView scrollTextView) {
                    scrollTextView.setIsDrawFading(true);
                }
            });
            this.f4974l.mo17192a((ScrollTextView.C1500e) new ScrollTextView.C1500e() {
                /* renamed from: a */
                public void mo16370a(ScrollTextView scrollTextView) {
                }

                /* renamed from: b */
                public void mo16374b(ScrollTextView scrollTextView) {
                    scrollTextView.setIsDrawFading(true);
                }
            });
            this.f4973k.mo17192a((ScrollTextView.C1500e) new ScrollTextView.C1500e() {
                /* renamed from: a */
                public void mo16370a(ScrollTextView scrollTextView) {
                }

                /* renamed from: b */
                public void mo16374b(ScrollTextView scrollTextView) {
                    DatePicker.this.setIsDrawFading(true);
                }
            });
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.f4960S = accessibilityManager.isEnabled();
        }
    }

    /* access modifiers changed from: private */
    public void setLeapUnitVisibility(int i) {
        if (!mo16391b() || !m5489b(i)) {
            this.f4972j.setVisibility(8);
        } else {
            this.f4972j.setVisibility(0);
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f4973k.setEnabled(z);
        this.f4974l.setEnabled(z);
        this.f4975m.setEnabled(z);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DatePicker.class.getName());
    }

    /* renamed from: a */
    private void m5487a(String[] strArr) {
        DateFormat dateFormat;
        boolean z;
        if (strArr[0].startsWith("1")) {
            dateFormat = android.text.format.DateFormat.getDateFormat(getContext());
        } else {
            dateFormat = android.text.format.DateFormat.getMediumDateFormat(getContext());
        }
        if (dateFormat instanceof SimpleDateFormat) {
            this.f4963a = ((SimpleDateFormat) dateFormat).toPattern();
        } else {
            this.f4963a = new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mc_column1Layout);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.mc_column2Layout);
        FrameLayout frameLayout3 = (FrameLayout) findViewById(R.id.mc_column3Layout);
        ImageView imageView = (ImageView) findViewById(R.id.mc_divider_bar1);
        ImageView imageView2 = (ImageView) findViewById(R.id.mc_divider_bar2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mc_column_parent);
        linearLayout.removeAllViews();
        if (this.f4963a.contentEquals("dd‏/MM‏/y") || this.f4963a.contentEquals("d בMMM y")) {
            this.f4963a = "yy/M/d";
        }
        if (this.f4961T) {
            this.f4963a = "d/M/yy";
        }
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        for (int i = 0; i < this.f4963a.length(); i++) {
            char charAt = this.f4963a.charAt(i);
            if (charAt == '\'') {
                z3 = !z3;
            }
            if (!z3) {
                if (charAt == 'd' && !z4) {
                    linearLayout.addView(frameLayout2);
                    z = true;
                    z4 = true;
                } else if ((charAt == 'M' || charAt == 'L') && !z2) {
                    linearLayout.addView(frameLayout);
                    z = true;
                    z2 = true;
                } else if (charAt != 'y' || z5) {
                    z = false;
                } else {
                    linearLayout.addView(frameLayout3);
                    z = true;
                    z5 = true;
                }
                if (true == z) {
                    if (!z7) {
                        linearLayout.addView(imageView);
                        z7 = true;
                    } else if (!z6) {
                        linearLayout.addView(imageView2);
                        z6 = true;
                    }
                }
            }
        }
        if (!z2) {
            linearLayout.addView(frameLayout);
        }
        if (!z4) {
            linearLayout.addView(frameLayout2);
        }
        if (!z5) {
            linearLayout.addView(frameLayout3);
        }
        if (!m5505f()) {
            FrameLayout frameLayout4 = (FrameLayout) findViewById(R.id.mc_column2Layout);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout4.getLayoutParams();
            layoutParams.setMarginEnd(0);
            frameLayout4.setLayoutParams(layoutParams);
        }
        this.f4975m.post(new Runnable() {
            public void run() {
                DatePicker datePicker = DatePicker.this;
                boolean z = true;
                if (DatePicker.this.f4975m == null || Build.VERSION.SDK_INT < 17 || DatePicker.this.f4975m.getLayoutDirection() != 1) {
                    z = false;
                }
                datePicker.f4967e = z;
            }
        });
    }

    /* renamed from: a */
    private void m5486a(int i, int i2, int i3, boolean z, boolean z2) {
        this.f4980r = i < this.f4981s ? this.f4981s : i;
        if (i > this.f4982t) {
            i = this.f4982t;
        }
        this.f4980r = i;
        this.f4979q = i2;
        this.f4978p = i3;
        this.f4987y = null;
        this.f4987y = getShortMonths();
        this.f4975m.mo17199d();
        this.f4974l.mo17199d();
        this.f4973k.mo17199d();
        this.f4975m.setCurrentItem(this.f4980r - this.f4981s, z);
        if (this.f4946E != getYearMonths()) {
            this.f4946E = getYearMonths();
            this.f4974l.mo17188a(this.f4946E);
        }
        this.f4974l.setCurrentItem(this.f4979q, z);
        if (this.f4947F != getMonthDays()) {
            this.f4947F = getMonthDays();
            this.f4973k.mo17188a(getMonthDays());
        }
        this.f4973k.setCurrentItem(this.f4978p - 1, z);
        if (z2) {
            m5487a(this.f4987y);
        }
    }

    private String[] getShortMonths() {
        Locale locale = Locale.getDefault();
        int i = 0;
        if (!locale.equals(this.f4942A) || this.f4943B == null) {
            synchronized (this.f4988z) {
                if (!locale.equals(this.f4942A)) {
                    this.f4943B = new String[12];
                    for (int i2 = 0; i2 < 12; i2++) {
                        this.f4943B[i2] = DateUtils.getMonthString(i2 + 0, 20);
                    }
                    if (this.f4943B[0].startsWith("1")) {
                        int i3 = 0;
                        while (i3 < this.f4943B.length) {
                            int i4 = i3 + 1;
                            this.f4943B[i3] = String.valueOf(i4);
                            if (i3 < 9) {
                                String[] strArr = this.f4943B;
                                strArr[i3] = "0" + this.f4943B[i3];
                            }
                            i3 = i4;
                        }
                    }
                    this.f4942A = locale;
                }
            }
        }
        if (this.f4974l != null && this.f4974l.getWidth() > 0 && this.f4943B != null) {
            while (true) {
                if (i >= this.f4943B.length) {
                    break;
                } else if (this.f4974l.mo17186a(this.f4943B[i]) > this.f4974l.getWidth()) {
                    this.f4943B = new String[]{"01", "02", UxipConstants.EVENT_UPLOAD_MAJOR_VERSION, "04", "05", "06", "07", "08", "09", "10", "11", "12"};
                    break;
                } else {
                    i++;
                }
            }
        }
        return this.f4943B;
    }

    /* renamed from: b */
    private boolean m5489b(int i) {
        if (!m5505f()) {
            return false;
        }
        int a = LunarCalendar.m5136a(this.f4980r);
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

    /* access modifiers changed from: private */
    /* renamed from: c */
    public String m5492c(int i) {
        int a = LunarCalendar.m5136a(this.f4980r);
        if (a == 0) {
            if (i >= 12) {
                return null;
            }
        } else if (i >= 13) {
            return null;
        }
        if (a == 0 || i <= a - 1) {
            return this.f4964b[i];
        }
        if (i == a) {
            return this.f4964b[i - 1];
        }
        return this.f4964b[i - 1];
    }

    /* renamed from: a */
    public String mo16389a(int i) {
        if (i > this.f4965c.length - 1) {
            return null;
        }
        return this.f4965c[i];
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4959R) {
            int width = getWidth();
            int width2 = this.f4954M.getWidth() - (this.f4957P * 2);
            int i = (width - width2) / 2;
            Canvas canvas2 = canvas;
            float f = (float) i;
            float f2 = (float) (i + width2);
            canvas2.drawLine(f, (float) this.f4955N, f2, (float) this.f4955N, this.f4958Q);
            canvas2.drawLine(f, (float) this.f4956O, f2, (float) this.f4956O, this.f4958Q);
        }
    }

    public void setIsDrawLine(boolean z) {
        this.f4959R = z;
    }

    public void setLineHeight(int i, int i2) {
        this.f4955N = i;
        this.f4956O = i2;
    }

    public void setShowDayColumn(boolean z) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mc_column2Layout);
        if (frameLayout != null) {
            int i = 8;
            frameLayout.setVisibility(z ? 0 : 8);
            m5500e();
            ScrollTextView scrollTextView = this.f4973k;
            if (z) {
                i = 0;
            }
            scrollTextView.setVisibility(i);
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

        /* renamed from: a */
        private final int f4993a;

        /* renamed from: b */
        private final int f4994b;

        /* renamed from: c */
        private final int f4995c;

        private SavedState(Parcelable parcelable, int i, int i2, int i3) {
            super(parcelable);
            this.f4993a = i;
            this.f4994b = i2;
            this.f4995c = i3;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f4993a = parcel.readInt();
            this.f4994b = parcel.readInt();
            this.f4995c = parcel.readInt();
        }

        /* renamed from: a */
        public int mo16415a() {
            return this.f4993a;
        }

        /* renamed from: b */
        public int mo16416b() {
            return this.f4994b;
        }

        /* renamed from: c */
        public int mo16417c() {
            return this.f4995c;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4993a);
            parcel.writeInt(this.f4994b);
            parcel.writeInt(this.f4995c);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f4980r, this.f4979q, this.f4978p);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f4980r = savedState.mo16415a();
        this.f4979q = savedState.mo16416b();
        this.f4978p = savedState.mo16417c();
    }

    public int getYear() {
        return this.f4980r;
    }

    public int getMonth() {
        return this.f4979q;
    }

    public int getDayOfMonth() {
        return this.f4978p;
    }

    public void onWindowFocusChanged(boolean z) {
        DateFormat dateFormat;
        String str;
        super.onWindowFocusChanged(z);
        if (z) {
            String[] shortMonths = getShortMonths();
            if (shortMonths[0].startsWith("1")) {
                dateFormat = android.text.format.DateFormat.getDateFormat(getContext());
            } else {
                dateFormat = android.text.format.DateFormat.getMediumDateFormat(getContext());
            }
            if (dateFormat instanceof SimpleDateFormat) {
                str = ((SimpleDateFormat) dateFormat).toPattern();
            } else {
                str = new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
            }
            this.f4987y = shortMonths;
            if (!this.f4963a.equals(str)) {
                m5487a(this.f4987y);
            }
        }
    }

    /* renamed from: c */
    private void m5494c() {
        this.f4975m.setData(new C1398a(1), -1.0f, this.f4980r - this.f4981s, (this.f4982t - this.f4981s) + 1, this.f4944C, 0, this.f4982t - this.f4981s, false);
    }

    public void setMaxDate(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        this.f4984v = instance;
        this.f4982t = instance.get(1);
        mo16390a();
    }

    /* renamed from: a */
    public void mo16390a() {
        m5494c();
        this.f4985w = -1;
        setMonthRange(this.f4980r);
        this.f4986x = -1;
        setDayRange(this.f4979q);
    }

    public void setMinDate(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        this.f4983u = instance;
        this.f4981s = instance.get(1);
        mo16390a();
    }

    public void setLunar(boolean z, boolean z2) {
        int[] iArr;
        boolean z3;
        int i;
        if (this.f4976n != z) {
            this.f4976n = z;
            int[] iArr2 = {this.f4980r, this.f4979q + 1, this.f4978p, 0};
            int i2 = iArr2[0];
            int a = LunarCalendar.m5136a(iArr2[0]);
            int a2 = LunarCalendar.m5136a(iArr2[0] - 1);
            if (this.f4976n) {
                iArr = LunarCalendar.m5139a(iArr2[0], iArr2[1], iArr2[2]);
                if (!(i2 == iArr[0] || a2 == 0 || (iArr[3] != 1 && iArr[1] <= a2)) || (i2 == iArr[0] && a != 0 && (iArr[3] == 1 || iArr[1] > a))) {
                    iArr[1] = iArr[1] + 1;
                }
                this.f4969g.setAlpha(0.0f);
            } else {
                if (a == 0 || a >= iArr2[1]) {
                    i = iArr2[1];
                } else {
                    int i3 = a + 1;
                    if (i3 == iArr2[1]) {
                        i = iArr2[1] - 1;
                        z3 = true;
                        this.f4969g.setAlpha(1.0f);
                        iArr = LunarCalendar.m5140a(iArr2[0], i, iArr2[2], z3);
                    } else {
                        i = i3 < iArr2[1] ? iArr2[1] - 1 : 0;
                    }
                }
                z3 = false;
                this.f4969g.setAlpha(1.0f);
                iArr = LunarCalendar.m5140a(iArr2[0], i, iArr2[2], z3);
            }
            m5507g();
            m5486a(iArr[0], iArr[1] - 1 < 0 ? 12 : iArr[1] - 1, iArr[2], z2, false);
            setLeapUnitVisibility(this.f4979q);
        }
    }

    public void setLunar(boolean z) {
        setLunar(z, true);
    }

    /* renamed from: b */
    public boolean mo16391b() {
        return this.f4976n;
    }

    /* access modifiers changed from: private */
    public int getMonthDays() {
        if (this.f4976n) {
            int i = this.f4979q;
            int a = LunarCalendar.m5136a(this.f4980r);
            boolean z = false;
            if (a != 0 && a == i) {
                z = true;
            }
            if (a == 0 || (a != 0 && this.f4979q < a)) {
                i++;
            }
            return LunarCalendar.m5138a(this.f4980r, i, z);
        }
        Calendar instance = Calendar.getInstance();
        instance.set(5, 1);
        instance.set(1, this.f4980r);
        instance.set(2, this.f4979q);
        return instance.getActualMaximum(5);
    }

    private Calendar getCurrentCalendar() {
        Calendar instance = Calendar.getInstance();
        instance.set(5, 1);
        instance.set(1, this.f4980r);
        instance.set(2, this.f4979q);
        return instance;
    }

    /* access modifiers changed from: private */
    public int getYearMonths() {
        if (!this.f4976n || LunarCalendar.m5136a(this.f4980r) == 0) {
            return 12;
        }
        return 13;
    }

    /* renamed from: d */
    private void m5498d() {
        this.f4970h = (TextView) findViewById(R.id.mc_scroll1_text);
        if (this.f4970h != null) {
            this.f4970h.setText(R.string.mc_date_time_month);
        }
        this.f4969g = (TextView) findViewById(R.id.mc_scroll2_text);
        if (this.f4969g != null) {
            this.f4969g.setText(R.string.mc_date_time_day);
        }
        this.f4971i = (TextView) findViewById(R.id.mc_scroll3_text);
        if (this.f4971i != null) {
            this.f4971i.setText(R.string.mc_date_time_year);
        }
    }

    public void setTextColor(int i, int i2, int i3) {
        this.f4973k.setTextColor(i, i2);
        this.f4974l.setTextColor(i, i2);
        this.f4975m.setTextColor(i, i2);
        this.f4969g.setTextColor(i3);
        this.f4970h.setTextColor(i3);
        this.f4971i.setTextColor(i3);
    }

    public void setTextColor(int i, List<Integer> list, int i2) {
        this.f4973k.setTextColor(i, list);
        this.f4974l.setTextColor(i, list);
        this.f4975m.setTextColor(i, list);
        this.f4969g.setTextColor(i2);
        this.f4970h.setTextColor(i2);
        this.f4971i.setTextColor(i2);
    }

    public void setItemHeight(int i, int i2) {
        float f = (float) i;
        float f2 = (float) i2;
        this.f4973k.setItemHeight(f, f2);
        this.f4974l.setItemHeight(f, f2);
        this.f4975m.setItemHeight(f, f2);
    }

    public TextView getDayUnit() {
        return this.f4969g;
    }

    public void setIsDrawFading(boolean z) {
        this.f4975m.setIsDrawFading(z);
        this.f4974l.setIsDrawFading(z);
        this.f4973k.setIsDrawFading(z);
    }

    /* renamed from: d */
    private String m5497d(int i) {
        switch (i) {
            case 1:
                return String.valueOf(this.f4980r);
            case 2:
                int i2 = this.f4979q;
                if (this.f4976n) {
                    return m5492c(i2);
                }
                if (this.f4987y == null) {
                    this.f4987y = getShortMonths();
                }
                return i2 < this.f4987y.length ? this.f4987y[i2] : "";
            case 3:
                int i3 = this.f4978p - 1;
                if (this.f4976n) {
                    return mo16389a(i3);
                }
                return String.valueOf(i3 + 1);
            default:
                return "";
        }
    }

    /* renamed from: e */
    private void m5500e() {
        String str;
        if (this.f4960S) {
            View findViewById = findViewById(R.id.mc_column3Layout);
            View findViewById2 = findViewById(R.id.mc_column1Layout);
            View findViewById3 = findViewById(R.id.mc_column2Layout);
            if (findViewById3 == null || findViewById3.getVisibility() != 8) {
                str = (m5497d(1) + this.f4971i.getText() + m5497d(2) + this.f4970h.getText() + m5497d(3) + this.f4969g.getText()).replace(" ", "").replace("廿十", "二十").replace("廿", "二十");
            } else {
                str = (m5497d(1) + this.f4971i.getText() + m5497d(2) + this.f4970h.getText()).replace(" ", "").replace("廿十", "二十").replace("廿", "二十");
            }
            if (findViewById != null) {
                findViewById.setFocusable(true);
                findViewById.setContentDescription("上下滚动设置年，当前日期是" + str);
            }
            if (findViewById2 != null) {
                findViewById2.setFocusable(true);
                findViewById2.setContentDescription("上下滚动设置月，当前日期是" + str);
            }
            if (findViewById3 != null) {
                findViewById3.setFocusable(true);
                findViewById3.setContentDescription("上下滚动设置日，当前日期是" + str);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m5501e(int i) {
        View findViewById;
        if (this.f4960S) {
            m5500e();
            if (i == 1) {
                View findViewById2 = findViewById(R.id.mc_column3Layout);
                if (findViewById2 != null) {
                    findViewById2.sendAccessibilityEvent(4);
                }
            } else if (i == 2) {
                View findViewById3 = findViewById(R.id.mc_column1Layout);
                if (findViewById3 != null) {
                    findViewById3.sendAccessibilityEvent(4);
                }
            } else if (i == 3 && (findViewById = findViewById(R.id.mc_column2Layout)) != null) {
                findViewById.sendAccessibilityEvent(4);
            }
        }
    }

    /* renamed from: f */
    private boolean m5505f() {
        return getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    /* renamed from: g */
    private void m5507g() {
        if (!this.f4976n || !m5505f()) {
            this.f4974l.setTextSize((float) this.f4952K, this.f4953L);
            this.f4973k.setTextSize((float) this.f4952K, this.f4953L);
        } else {
            this.f4974l.setTextSize((float) this.f4950I, this.f4951J);
            this.f4973k.setTextSize((float) this.f4950I, this.f4951J);
        }
        this.f4975m.setTextSize((float) this.f4952K, this.f4953L);
    }
}
