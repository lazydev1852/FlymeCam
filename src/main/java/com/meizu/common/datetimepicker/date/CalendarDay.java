package com.meizu.common.datetimepicker.date;

import java.util.Calendar;

/* renamed from: com.meizu.common.datetimepicker.date.a */
public class CalendarDay {

    /* renamed from: a */
    int f4207a;

    /* renamed from: b */
    int f4208b;

    /* renamed from: c */
    int f4209c;

    /* renamed from: d */
    private Calendar f4210d;

    public CalendarDay() {
        m4883a(System.currentTimeMillis());
    }

    public CalendarDay(int i, int i2, int i3) {
        mo15732a(i, i2, i3);
    }

    /* renamed from: a */
    public void mo15732a(int i, int i2, int i3) {
        this.f4207a = i;
        this.f4208b = i2;
        this.f4209c = i3;
    }

    /* renamed from: a */
    private void m4883a(long j) {
        if (this.f4210d == null) {
            this.f4210d = Calendar.getInstance();
        }
        this.f4210d.setTimeInMillis(j);
        this.f4208b = this.f4210d.get(2);
        this.f4207a = this.f4210d.get(1);
        this.f4209c = this.f4210d.get(5);
    }

    /* renamed from: a */
    public int mo15731a() {
        return this.f4207a;
    }

    /* renamed from: b */
    public int mo15733b() {
        return this.f4208b;
    }

    /* renamed from: c */
    public int mo15734c() {
        return this.f4209c;
    }
}
