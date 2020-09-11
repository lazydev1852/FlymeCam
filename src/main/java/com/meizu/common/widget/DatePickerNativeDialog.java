package com.meizu.common.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.meizu.common.R;
import com.meizu.common.datetimepicker.date.CalendarDay;
import com.meizu.common.datetimepicker.date.MonthView;
import com.meizu.common.datetimepicker.date.SimpleMonthView;
import com.meizu.common.util.InternalResUtils;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.util.ResourceUtils;
import com.meizu.common.util.ScreenUtil;
import com.meizu.common.widget.DatePicker;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class DatePickerNativeDialog extends AlertDialog implements DialogInterface.OnClickListener, DatePicker.C1399b {

    /* renamed from: F */
    private static Method f4998F;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public float f4999A;

    /* renamed from: B */
    private ObjectAnimator f5000B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public int f5001C;

    /* renamed from: D */
    private int f5002D;

    /* renamed from: E */
    private int f5003E;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f5004G;

    /* renamed from: H */
    private View f5005H;

    /* renamed from: I */
    private float f5006I;

    /* renamed from: a */
    C1404a f5007a;

    /* renamed from: b */
    private final C1405b f5008b;

    /* renamed from: c */
    private RectClipView f5009c;

    /* renamed from: d */
    private TextView f5010d;

    /* renamed from: e */
    private TextView f5011e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ViewPager f5012f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MonthAdapter f5013g;

    /* renamed from: h */
    private ArrayList<Calendar> f5014h;

    /* renamed from: i */
    private boolean f5015i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f5016j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f5017k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f5018l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f5019m;

    /* renamed from: n */
    private int f5020n;

    /* renamed from: o */
    private String f5021o;

    /* renamed from: p */
    private String f5022p;

    /* renamed from: q */
    private String f5023q;

    /* renamed from: r */
    private String f5024r;

    /* renamed from: s */
    private String f5025s;

    /* renamed from: t */
    private String f5026t;

    /* renamed from: u */
    private String[] f5027u;

    /* renamed from: v */
    private String[] f5028v;

    /* renamed from: w */
    private boolean f5029w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int[] f5030x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public int f5031y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f5032z;

    /* renamed from: com.meizu.common.widget.DatePickerNativeDialog$b */
    public interface C1405b {
        /* renamed from: a */
        void mo16433a(int i, int i2, int i3);
    }

    /* renamed from: a */
    public void mo16423a(DatePicker datePicker, int i, int i2, int i3) {
    }

    /* renamed from: a */
    private void m5540a() {
        if (this.f5005H == null) {
            this.f5005H = findViewById(InternalResUtils.m5123a(0, "buttonPanel"));
            this.f5005H.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.mz_dialog_background_material_bottom));
            getWindow().setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.mz_dialog_background_transparent));
            this.f5006I = m5550b().getTranslationY();
            m5558c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public View m5550b() {
        return this.f5004G ? this.f5009c : this.f5005H;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m5558c() {
        if (m5550b() == null) {
            Log.d("DatePickerNativeDialog", "mButtonPanel == null, initButtonLocationY failed");
        } else if (this.f5030x[this.f5016j] == this.f5003E) {
            m5541a(0);
        } else if (this.f5030x[this.f5016j] == this.f5002D) {
            m5541a(1);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            m5540a();
        }
    }

    /* renamed from: com.meizu.common.widget.DatePickerNativeDialog$4 */
    class C14014 implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        final /* synthetic */ DatePickerNativeDialog f5034a;

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
            int i3;
            if (i != 0 && i != this.f5034a.f5013g.getCount() - 1) {
                int i4 = i + 1;
                if (this.f5034a.f5030x[i] != this.f5034a.f5030x[i4] && (i3 = ((int) ((((float) this.f5034a.f5030x[i]) * (1.0f - f)) + (((float) this.f5034a.f5030x[i4]) * f))) - this.f5034a.f5030x[this.f5034a.f5016j]) != 0) {
                    if (i3 > 0) {
                        i3 -= this.f5034a.f5001C;
                    }
                    if (this.f5034a.f5004G) {
                        i3 = -i3;
                    }
                    if (this.f5034a.m5550b() != null) {
                        this.f5034a.m5543a(this.f5034a.m5550b(), (float) i3, (long) this.f5034a.f5031y, false);
                    }
                }
            }
        }

        public void onPageSelected(int i) {
            int unused = this.f5034a.f5016j = i;
            this.f5034a.f5012f.postDelayed(new Runnable() {
                public void run() {
                    C14014.this.f5034a.m5558c();
                    C14014.this.f5034a.m5562e();
                }
            }, (long) this.f5034a.f5032z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5543a(View view, float f, long j, boolean z) {
        this.f4999A = f;
        view.setTranslationY(this.f4999A);
        m5561d();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m5561d() {
        this.f5009c.setClipRect(0, 0, this.f5009c.getWidth(), (int) (((float) this.f5009c.getHeight()) + this.f4999A + 50.0f));
    }

    /* renamed from: a */
    private void m5541a(int i) {
        if (this.f5000B != null && this.f5000B.isRunning()) {
            this.f5000B.cancel();
        }
        float f = 0.0f;
        float translationY = m5550b().getTranslationY();
        if (this.f5004G) {
            if (i == 0) {
                f = ((float) this.f5001C) + this.f5006I;
            } else if (i == 1) {
                f = this.f5006I;
            }
        } else if (i == 0) {
            f = this.f5006I - ((float) this.f5001C);
        } else if (i == 1) {
            f = this.f5006I;
        }
        this.f5000B = ObjectAnimator.ofFloat(m5550b(), "translationY", new float[]{translationY, f});
        this.f5000B.setDuration((long) this.f5031y);
        this.f5000B.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = DatePickerNativeDialog.this.f4999A = ((Float) valueAnimator.getAnimatedValue("translationY")).floatValue();
                DatePickerNativeDialog.this.m5561d();
            }
        });
        this.f5000B.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m5562e() {
        this.f5017k = (this.f5016j / 12) + this.f5020n;
        this.f5018l = this.f5016j % 12;
        this.f5019m = 1;
        this.f5013g.notifyDataSetChanged();
        m5542a(this.f5017k, this.f5018l, this.f5019m);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5004G = findViewById(ResourceUtils.m5162a(getContext().getResources(), "dialogSpace1", "id", "flyme")) != null;
        if (this.f5004G) {
            findViewById(ResourceUtils.m5162a(getContext().getResources(), "dialogSpace2", "id", "flyme")).getLayoutParams().height = 0;
            findViewById(ResourceUtils.m5162a(getContext().getResources(), "dialogSpace3", "id", "flyme")).getLayoutParams().height = 0;
            findViewById(ResourceUtils.m5162a(getContext().getResources(), "dialogSpace4", "id", "flyme")).getLayoutParams().height = 0;
            View findViewById = findViewById(InternalResUtils.m5123a(0, "buttonPanel"));
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), ScreenUtil.m5167a(getContext(), 10.0d));
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f5009c.measure(makeMeasureSpec, makeMeasureSpec);
        this.f5009c.setClipRect(0, 0, this.f5009c.getWidth(), this.f5009c.getHeight());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5542a(int i, int i2, int i3) {
        String str;
        int i4 = i2 + 1;
        if (!this.f5029w) {
            Calendar instance = Calendar.getInstance();
            instance.set(i, i4 - 1, i3);
            str = SimpleDateFormat.getDateInstance().format(instance.getTime());
        } else if (this.f5015i) {
            str = String.format(Locale.getDefault(), "%d %s%s", new Object[]{Integer.valueOf(i), getContext().getResources().getString(R.string.mc_date_time_year), m5551b(i, i4 - 1, i3)});
        } else {
            str = String.format(Locale.getDefault(), "%d %s %d %s %d %s", new Object[]{Integer.valueOf(i), getContext().getResources().getString(R.string.mc_date_time_year), Integer.valueOf(i4), getContext().getResources().getString(R.string.mc_date_time_month), Integer.valueOf(i3), getContext().getResources().getString(R.string.mc_date_time_day)});
        }
        this.f5010d.setText(str);
        m5552b(m5554c(i, i4 - 1, i3));
    }

    /* renamed from: b */
    private void m5552b(int i) {
        String str;
        switch (i) {
            case -1:
                str = this.f5025s;
                break;
            case 0:
                str = this.f5024r;
                break;
            case 1:
                str = this.f5026t;
                break;
            default:
                str = getContext().getResources().getString(i > 0 ? R.string.mc_custom_date_time_days_after : R.string.mc_custom_date_time_days_before, new Object[]{Integer.valueOf(Math.abs(i))});
                break;
        }
        this.f5011e.setText(str);
    }

    /* renamed from: b */
    private String m5551b(int i, int i2, int i3) {
        String str;
        int i4 = i2 + 1;
        int a = LunarCalendar.m5136a(i);
        int[] a2 = LunarCalendar.m5139a(i, i4, i3);
        if (a2[1] == a && a2[3] == 1) {
            str = this.f5022p + this.f5027u[a2[1] - 1];
        } else {
            str = this.f5027u[a2[1] - 1];
        }
        if (this.f5029w) {
            return str + this.f5023q + m5557c(a2[2] - 1);
        } else if (i4 <= 0 || i4 > this.f5027u.length) {
            return "";
        } else {
            return this.f5021o + str + " " + m5557c(a2[2] - 1);
        }
    }

    /* renamed from: c */
    private String m5557c(int i) {
        if (i > this.f5028v.length - 1) {
            return null;
        }
        return this.f5028v[i];
    }

    /* renamed from: c */
    private int m5554c(int i, int i2, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance();
        instance.set(1, i);
        instance.set(2, i2);
        instance.set(5, i3);
        return (int) ((instance.getTimeInMillis() - currentTimeMillis) / 86400000);
    }

    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putInt("year", this.f5017k);
        onSaveInstanceState.putInt("month", this.f5018l);
        onSaveInstanceState.putInt("day", this.f5019m);
        return onSaveInstanceState;
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f5017k = bundle.getInt("year");
        this.f5018l = bundle.getInt("month");
        this.f5019m = bundle.getInt("day");
        m5542a(this.f5017k, this.f5018l, this.f5019m);
        if (this.f5012f != null) {
            this.f5016j = ((this.f5017k - this.f5020n) * 12) + this.f5018l;
            this.f5012f.setCurrentItem(this.f5016j);
        }
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f5008b != null) {
            this.f5008b.mo16433a(this.f5017k, this.f5018l, this.f5019m);
        }
    }

    private class MonthAdapter extends PagerAdapter {

        /* renamed from: a */
        final /* synthetic */ DatePickerNativeDialog f5036a;

        /* renamed from: b */
        private int f5037b;

        /* renamed from: c */
        private int f5038c;

        /* renamed from: d */
        private float f5039d;

        /* renamed from: e */
        private boolean f5040e;

        public int getItemPosition(Object obj) {
            return -2;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public int getCount() {
            return ((this.f5038c - this.f5037b) + 1) * 12;
        }

        /* renamed from: a */
        public View instantiateItem(ViewGroup viewGroup, int i) {
            Context context = viewGroup.getContext();
            int i2 = (i / 12) + this.f5037b;
            SimpleMonthView simpleMonthView = new SimpleMonthView(context);
            HashMap hashMap = new HashMap();
            hashMap.put("year", Integer.valueOf(i2));
            int i3 = i % 12;
            hashMap.put("month", Integer.valueOf(i3));
            hashMap.put("week_start", 2);
            hashMap.put("paint_alpha", Float.valueOf(this.f5039d));
            if (i2 == this.f5036a.f5017k && i3 == this.f5036a.f5018l) {
                hashMap.put("selected_day", Integer.valueOf(this.f5036a.f5019m));
            }
            this.f5036a.m5547a((HashMap<String, Object>) hashMap, i2, i3);
            simpleMonthView.setHeightRecordCallBack(i, this.f5036a.f5007a);
            simpleMonthView.setMonthParams(hashMap);
            simpleMonthView.setShowLunar(this.f5040e);
            simpleMonthView.setOnDayClickListener(new MonthView.C1300a() {
                /* renamed from: a */
                public void mo15729a(MonthView monthView, CalendarDay aVar) {
                    int unused = MonthAdapter.this.f5036a.f5017k = aVar.mo15731a();
                    int unused2 = MonthAdapter.this.f5036a.f5018l = aVar.mo15733b();
                    int unused3 = MonthAdapter.this.f5036a.f5019m = aVar.mo15734c();
                    MonthAdapter.this.f5036a.m5542a(MonthAdapter.this.f5036a.f5017k, MonthAdapter.this.f5036a.f5018l, MonthAdapter.this.f5036a.f5019m);
                    MonthAdapter.this.f5036a.f5013g.notifyDataSetChanged();
                }
            });
            viewGroup.addView(simpleMonthView);
            return simpleMonthView;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5547a(HashMap<String, Object> hashMap, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (this.f5014h != null && i3 < this.f5014h.size()) {
            Calendar calendar = this.f5014h.get(i3);
            if (i == calendar.get(1) && i2 == calendar.get(2)) {
                arrayList.add(Integer.valueOf(calendar.get(5)));
            }
            i3++;
        }
        if (arrayList.size() > 0) {
            hashMap.put("event_remind", arrayList);
        }
    }

    /* renamed from: com.meizu.common.widget.DatePickerNativeDialog$a */
    public class C1404a {

        /* renamed from: a */
        final /* synthetic */ DatePickerNativeDialog f5042a;

        /* renamed from: a */
        public void mo16432a(int i, int i2) {
            if (this.f5042a.f5030x == null) {
                int[] unused = this.f5042a.f5030x = new int[this.f5042a.f5013g.getCount()];
            }
            this.f5042a.f5030x[i] = i2;
        }
    }
}
