package com.meizu.common.datetimepicker.date;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.meizu.common.R;
import com.meizu.common.util.LunarCalendar;
import com.meizu.common.util.ScreenUtil;
import java.util.HashMap;
import java.util.Locale;

public class SimpleMonthView extends MonthView {

    /* renamed from: W */
    private boolean f4200W = false;

    /* renamed from: aa */
    private String[] f4201aa = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_day);

    /* renamed from: ab */
    private String[] f4202ab;

    /* renamed from: ac */
    private String f4203ac;

    /* renamed from: ad */
    private String f4204ad;

    /* renamed from: ae */
    private HashMap<Integer, int[]> f4205ae = new HashMap<>();

    /* renamed from: af */
    private float f4206af;

    public SimpleMonthView(Context context) {
        super(context);
        this.f4203ac = context.getResources().getString(R.string.mc_time_picker_leap);
        this.f4202ab = context.getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
        this.f4204ad = context.getResources().getString(R.string.mc_date_time_month);
        this.f4206af = (float) ScreenUtil.m5167a(context, 4.0d);
    }

    /* renamed from: b */
    private String m4880b(int i) {
        if (i > this.f4201aa.length - 1) {
            return null;
        }
        return this.f4201aa[i];
    }

    /* renamed from: a */
    public void mo15706a(Canvas canvas, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8;
        float f9;
        int[] iArr;
        String str;
        if (mo15708a(i, i2, i3)) {
            this.f4177g.setColor(this.f4150G);
            this.f4179i.setColor(this.f4150G);
            this.f4180j.setColor(this.f4150G);
        } else if (this.f4191u == i3) {
            this.f4177g.setColor(this.f4151H);
            this.f4179i.setColor(this.f4151H);
            this.f4179i.setAlpha(this.f4163T);
            this.f4180j.setColor(this.f4151H);
        } else if (!this.f4190t || this.f4192v != i3) {
            this.f4177g.setColor(this.f4148E);
            this.f4179i.setColor(this.f4152I);
            this.f4179i.setAlpha(this.f4162S);
            this.f4180j.setColor(this.f4154K);
        } else {
            this.f4177g.setColor(this.f4149F);
            this.f4179i.setColor(this.f4149F);
            this.f4179i.setAlpha(this.f4163T);
            this.f4180j.setColor(this.f4154K);
        }
        boolean a = mo15707a(i3);
        float f10 = f2 + ((float) this.f4155L);
        if (this.f4200W) {
            f8 = (((((float) this.f4181k.descent) + f10) + ((float) this.f4156M)) - ((float) this.f4182l.top)) - ((float) this.f4182l.descent);
            if (a) {
                f7 = ((float) this.f4157N) + f8 + this.f4158O + ((float) this.f4182l.descent);
                f9 = ((float) this.f4182l.descent) + f8 + ((float) this.f4157N) + this.f4158O;
            } else {
                f7 = ((float) this.f4182l.descent) + f8;
                f9 = ((float) this.f4182l.descent) + f8;
            }
        } else {
            f7 = a ? ((float) this.f4181k.descent) + f10 + ((float) this.f4157N) + this.f4158O : f10;
            f8 = f10;
            f9 = f7;
        }
        if (this.f4191u == i3) {
            RectF rectF = new RectF();
            rectF.top = f5;
            rectF.bottom = f9 + ((float) this.f4160Q);
            if (a) {
                rectF.bottom += this.f4158O;
            }
            rectF.left = f - ((float) this.f4161R);
            rectF.right = ((float) this.f4161R) + f;
            canvas.drawRoundRect(rectF, this.f4206af, this.f4206af, this.f4178h);
        }
        canvas.drawText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i3)}), f, f10, this.f4177g);
        if (this.f4200W) {
            int[] iArr2 = {i, i2 + 1, i3, 0};
            if (this.f4205ae.containsKey(Integer.valueOf(i3))) {
                iArr = this.f4205ae.get(Integer.valueOf(i3));
            } else {
                int[] a2 = LunarCalendar.m5139a(iArr2[0], iArr2[1], iArr2[2]);
                this.f4205ae.put(Integer.valueOf(i3), a2);
                iArr = a2;
            }
            if (iArr[2] == 1) {
                if (iArr[1] == LunarCalendar.m5136a(i) && iArr[3] == 1) {
                    str = this.f4203ac + this.f4202ab[iArr[1] - 1] + this.f4204ad;
                } else {
                    str = this.f4202ab[iArr[1] - 1] + this.f4204ad;
                }
            } else {
                str = m4880b(iArr[2] - 1);
            }
            canvas.drawText(String.format(Locale.getDefault(), "%s", new Object[]{str}), f, f8, this.f4179i);
        }
        if (a) {
            RectF rectF2 = new RectF();
            rectF2.top = f7 - (this.f4158O / 2.0f);
            rectF2.bottom = f7 + (this.f4158O / 2.0f);
            rectF2.left = f - (this.f4159P / 2.0f);
            rectF2.right = f + (this.f4159P / 2.0f);
            canvas.drawRoundRect(rectF2, this.f4158O, this.f4158O, this.f4180j);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15705a(Canvas canvas) {
        int monthHeaderSize = getMonthHeaderSize();
        int b = mo15709b();
        for (int i = 1; i <= this.f4195y; i++) {
            if (this.f4164U) {
                this.f4144A.left = (float) ((((this.f4194x - b) - 1) * this.f4188r) + this.f4176f + this.f4189s);
                this.f4144A.right = this.f4144A.left + ((float) this.f4188r);
            } else {
                this.f4144A.left = (float) ((this.f4188r * b) + this.f4176f + this.f4189s);
                this.f4144A.right = this.f4144A.left + ((float) this.f4188r);
            }
            this.f4144A.top = (float) monthHeaderSize;
            this.f4144A.bottom = (float) (this.f4187q + monthHeaderSize);
            float f = (this.f4144A.top - ((float) this.f4181k.top)) - ((float) this.f4181k.descent);
            mo15706a(canvas, this.f4184n, this.f4183m, i, this.f4144A.centerX(), f, this.f4144A.left, this.f4144A.right, this.f4144A.top, this.f4144A.bottom);
            b++;
            if (b == this.f4194x) {
                monthHeaderSize += this.f4187q;
                b = 0;
            }
        }
    }

    public void setShowLunar(boolean z) {
        this.f4200W = z;
    }
}
