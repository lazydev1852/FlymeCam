package com.meizu.common.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.meizu.common.R;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import java.util.Calendar;

public class WeekdayPicker extends LinearLayout {

    /* renamed from: a */
    private Context f6324a;

    /* renamed from: b */
    private ImageView[] f6325b;

    /* renamed from: c */
    private TextView[] f6326c;

    /* renamed from: d */
    private C1551b f6327d = null;

    /* renamed from: e */
    private C1550a f6328e;

    /* renamed from: f */
    private int f6329f = -1;

    /* renamed from: g */
    private int f6330g = -1;

    /* renamed from: h */
    private boolean f6331h = false;

    /* renamed from: i */
    private String f6332i = "-1";

    /* renamed from: j */
    private int f6333j = 0;

    /* renamed from: k */
    private int f6334k = -1;

    /* renamed from: l */
    private int f6335l = -1;

    /* renamed from: com.meizu.common.widget.WeekdayPicker$b */
    public interface C1551b {
        /* renamed from: a */
        void mo17550a(int i);
    }

    public WeekdayPicker(Context context) {
        super(context);
        this.f6324a = context;
        m6248b();
    }

    public WeekdayPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6324a = context;
        m6248b();
    }

    public WeekdayPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6324a = context;
        m6248b();
    }

    /* renamed from: b */
    private void m6248b() {
        this.f6334k = this.f6324a.getResources().getDimensionPixelSize(R.dimen.mc_chooser_item_width);
        this.f6335l = this.f6334k / 2;
        this.f6325b = new ImageView[7];
        this.f6326c = new TextView[7];
        String[] strArr = {getResources().getString(R.string.mc_monday), getResources().getString(R.string.mc_tuesday), getResources().getString(R.string.mc_wednesday), getResources().getString(R.string.mc_thursday), getResources().getString(R.string.mc_friday), getResources().getString(R.string.mc_saturday), getResources().getString(R.string.mc_sunday)};
        if ("-2".equals(this.f6332i)) {
            this.f6332i = String.valueOf(Calendar.getInstance().getFirstDayOfWeek());
        } else if ("-1".equals(this.f6332i)) {
            this.f6332i = String.valueOf(Calendar.getInstance().getFirstDayOfWeek());
        }
        if ("1".equals(this.f6332i)) {
            this.f6333j = 1;
        } else if ("2".equals(this.f6332i)) {
            this.f6333j = 0;
        } else if (ExifInterface.GPS_MEASUREMENT_3D.equals(this.f6332i)) {
            this.f6333j = 6;
        } else if (UxipConstants.EVENT_UPLOAD_MIN_VERSION.equals(this.f6332i)) {
            this.f6333j = 5;
        } else if ("5".equals(this.f6332i)) {
            this.f6333j = 4;
        } else if ("6".equals(this.f6332i)) {
            this.f6333j = 3;
        } else if ("7".equals(this.f6332i)) {
            this.f6333j = 2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        if (this.f6328e == null) {
            this.f6328e = new C1550a(0);
        }
        boolean[] b = this.f6328e.mo17549b();
        int i = 0;
        for (int i2 = 0; i2 < 7; i2++) {
            View inflate = LayoutInflater.from(this.f6324a).inflate(R.layout.mc_weekday_picker_item, (ViewGroup) null);
            inflate.setLayoutParams(layoutParams);
            TextView textView = (TextView) inflate.findViewById(R.id.mc_chooser_text);
            textView.setText(strArr[i2]);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.mc_background_img);
            if (b == null) {
                imageView.setTag("unselected");
                imageView.setBackgroundResource(R.drawable.mc_bg_week_switch_off);
                textView.setTextColor(this.f6324a.getResources().getColor(R.color.mc_chooser_text_color_unselected));
            } else if (b[i2]) {
                imageView.setTag("selected");
                if (isEnabled()) {
                    imageView.setBackgroundResource(R.drawable.mc_bg_week_switch_on);
                } else {
                    imageView.setBackgroundResource(R.drawable.mc_bg_week_switch_on_disable);
                }
                textView.setTextColor(this.f6324a.getResources().getColor(R.color.mc_chooser_text_color_selected));
            } else {
                imageView.setTag("unselected");
                if (isEnabled()) {
                    imageView.setBackgroundResource(R.drawable.mc_bg_week_switch_off);
                    textView.setTextColor(this.f6324a.getResources().getColor(R.color.mc_chooser_text_color_unselected));
                } else {
                    imageView.setBackgroundResource(R.drawable.mc_bg_week_switch_off_disable);
                    textView.setTextColor(this.f6324a.getResources().getColor(R.color.mc_chooser_text_color_unselected_disable));
                }
            }
            this.f6325b[i2] = imageView;
            this.f6326c[i2] = textView;
            if (this.f6333j + i2 >= 7) {
                addView(inflate, i);
                i++;
            } else {
                addView(inflate);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            ViewParent parent = getParent();
            switch (action) {
                case 0:
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    this.f6331h = false;
                    int a = m6246a(x);
                    if (a >= 0 && a < 7) {
                        m6247a(a, false);
                        break;
                    }
                case 1:
                case 3:
                    this.f6331h = false;
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(false);
                    }
                    this.f6329f = -1;
                    this.f6330g = -1;
                    if (this.f6327d != null) {
                        this.f6327d.mo17550a(this.f6328e.mo17546a());
                        break;
                    }
                    break;
                case 2:
                    if (!this.f6331h) {
                        if (x >= ((float) (-this.f6335l)) && x <= ((float) (getWidth() + this.f6335l)) && y >= ((float) (-this.f6335l)) && y <= ((float) (getHeight() + this.f6335l))) {
                            int a2 = m6246a(x);
                            if (a2 >= 0 && a2 < 7 && a2 != this.f6329f) {
                                m6247a(a2, true);
                                break;
                            }
                        } else {
                            this.f6329f = -1;
                            this.f6330g = -1;
                            if (this.f6327d != null) {
                                this.f6327d.mo17550a(this.f6328e.mo17546a());
                            }
                            this.f6331h = true;
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(false);
                            }
                            return true;
                        }
                    } else {
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(false);
                        }
                        return true;
                    }
                    break;
            }
            return true;
        } else if (isClickable() || isLongClickable()) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    private int m6246a(float f) {
        int width = getWidth();
        float f2 = (float) (width / 7);
        float f3 = (f2 - ((float) this.f6334k)) / 2.0f;
        if (Build.VERSION.SDK_INT > 16 && getLayoutDirection() == 1) {
            f = ((float) width) - f;
        }
        int i = (int) (f / f2);
        if (i >= 7) {
            return -1;
        }
        int i2 = i - this.f6333j;
        if (i2 < 0) {
            i2 += 7;
        }
        float f4 = f % f2;
        if (f4 < f3 || f4 - f3 > ((float) this.f6334k)) {
            return -1;
        }
        return i2;
    }

    /* renamed from: a */
    private void m6247a(int i, boolean z) {
        if (this.f6325b != null && i >= 0 && i < this.f6325b.length && this.f6325b[i] != null && this.f6328e != null) {
            if (z && this.f6330g == i && this.f6330g >= 0 && this.f6330g < this.f6325b.length && this.f6325b[this.f6329f] != null) {
                if ("selected".equals(this.f6325b[this.f6329f].getTag())) {
                    this.f6325b[this.f6329f].setTag("unselected");
                    this.f6325b[this.f6329f].setBackgroundResource(R.drawable.mc_bg_week_switch_off);
                    this.f6326c[this.f6329f].setTextColor(this.f6324a.getResources().getColor(R.color.mc_chooser_text_color_unselected));
                    this.f6328e.mo17548a(this.f6329f, false);
                } else {
                    this.f6325b[this.f6329f].setTag("selected");
                    this.f6325b[this.f6329f].setBackgroundResource(R.drawable.mc_bg_week_switch_on);
                    this.f6326c[this.f6329f].setTextColor(this.f6324a.getResources().getColor(R.color.mc_chooser_text_color_selected));
                    this.f6328e.mo17548a(this.f6329f, true);
                }
            }
            this.f6330g = this.f6329f;
            this.f6329f = i;
            if ("selected".equals(this.f6325b[i].getTag())) {
                this.f6325b[i].setTag("unselected");
                this.f6325b[i].setBackgroundResource(R.drawable.mc_bg_week_switch_off);
                this.f6326c[i].setTextColor(this.f6324a.getResources().getColor(R.color.mc_chooser_text_color_unselected));
                this.f6328e.mo17548a(i, false);
                return;
            }
            this.f6325b[i].setTag("selected");
            this.f6325b[i].setBackgroundResource(R.drawable.mc_bg_week_switch_on);
            this.f6326c[i].setTextColor(this.f6324a.getResources().getColor(R.color.mc_chooser_text_color_selected));
            this.f6328e.mo17548a(i, true);
        }
    }

    /* renamed from: a */
    public void mo17537a() {
        removeAllViews();
        m6248b();
    }

    public void setOnSelectChangedListener(C1551b bVar) {
        this.f6327d = bVar;
    }

    public void setFirstDayOfWeek(int i) {
        if (i < 1 || i > 7) {
            i = 1;
        }
        this.f6332i = String.valueOf(i);
        mo17537a();
    }

    public void setSelectedDays(int i) {
        this.f6328e.mo17547a(i);
        m6249c();
    }

    public int getSelectedDays() {
        return this.f6328e.mo17546a();
    }

    public boolean[] getSelectedArray() {
        return this.f6328e.mo17549b();
    }

    /* renamed from: c */
    private void m6249c() {
        if (this.f6328e != null && this.f6325b != null) {
            boolean[] b = this.f6328e.mo17549b();
            for (int i = 0; i < 7; i++) {
                if (b[i]) {
                    this.f6325b[i].setTag("selected");
                    this.f6325b[i].setBackgroundResource(R.drawable.mc_bg_week_switch_on);
                    this.f6326c[i].setTextColor(this.f6324a.getResources().getColor(R.color.mc_chooser_text_color_selected));
                } else {
                    this.f6325b[i].setTag("unselected");
                    this.f6325b[i].setBackgroundResource(R.drawable.mc_bg_week_switch_off);
                    this.f6326c[i].setTextColor(this.f6324a.getResources().getColor(R.color.mc_chooser_text_color_unselected));
                }
            }
        }
    }

    /* renamed from: com.meizu.common.widget.WeekdayPicker$a */
    private static final class C1550a {

        /* renamed from: a */
        private static int[] f6336a = {2, 3, 4, 5, 6, 7, 1};

        /* renamed from: b */
        private int f6337b;

        public C1550a(int i) {
            this.f6337b = i;
        }

        /* renamed from: a */
        public void mo17547a(int i) {
            this.f6337b = i;
        }

        /* renamed from: b */
        private boolean m6251b(int i) {
            return ((1 << i) & this.f6337b) > 0;
        }

        /* renamed from: a */
        public void mo17548a(int i, boolean z) {
            if (z) {
                this.f6337b = (1 << i) | this.f6337b;
                return;
            }
            this.f6337b = (~(1 << i)) & this.f6337b;
        }

        /* renamed from: a */
        public int mo17546a() {
            return this.f6337b;
        }

        /* renamed from: b */
        public boolean[] mo17549b() {
            boolean[] zArr = new boolean[7];
            for (int i = 0; i < 7; i++) {
                zArr[i] = m6251b(i);
            }
            return zArr;
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        removeAllViews();
        m6248b();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(WeekdayPicker.class.getName());
    }
}
