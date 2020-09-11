package com.p006a.p007a.p008a;

import com.p006a.p007a.XMPDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.a.a.a.l */
public class XMPDateTimeImpl implements XMPDateTime {

    /* renamed from: a */
    private int f62a = 0;

    /* renamed from: b */
    private int f63b = 0;

    /* renamed from: c */
    private int f64c = 0;

    /* renamed from: d */
    private int f65d = 0;

    /* renamed from: e */
    private int f66e = 0;

    /* renamed from: f */
    private int f67f = 0;

    /* renamed from: g */
    private TimeZone f68g = TimeZone.getTimeZone("UTC");

    /* renamed from: h */
    private int f69h;

    public XMPDateTimeImpl() {
    }

    public XMPDateTimeImpl(Calendar calendar) {
        Date time = calendar.getTime();
        TimeZone timeZone = calendar.getTimeZone();
        GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance(Locale.US);
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        gregorianCalendar.setTimeZone(timeZone);
        gregorianCalendar.setTime(time);
        this.f62a = gregorianCalendar.get(1);
        this.f63b = gregorianCalendar.get(2) + 1;
        this.f64c = gregorianCalendar.get(5);
        this.f65d = gregorianCalendar.get(11);
        this.f66e = gregorianCalendar.get(12);
        this.f67f = gregorianCalendar.get(13);
        this.f69h = gregorianCalendar.get(14) * 1000000;
        this.f68g = gregorianCalendar.getTimeZone();
    }

    /* renamed from: a */
    public int mo7469a() {
        return this.f62a;
    }

    /* renamed from: a */
    public void mo7470a(int i) {
        this.f62a = Math.min(Math.abs(i), 9999);
    }

    /* renamed from: b */
    public int mo7472b() {
        return this.f63b;
    }

    /* renamed from: b */
    public void mo7473b(int i) {
        if (i < 1) {
            this.f63b = 1;
        } else if (i > 12) {
            this.f63b = 12;
        } else {
            this.f63b = i;
        }
    }

    /* renamed from: c */
    public int mo7474c() {
        return this.f64c;
    }

    /* renamed from: c */
    public void mo7475c(int i) {
        if (i < 1) {
            this.f64c = 1;
        } else if (i > 31) {
            this.f64c = 31;
        } else {
            this.f64c = i;
        }
    }

    /* renamed from: d */
    public int mo7476d() {
        return this.f65d;
    }

    /* renamed from: d */
    public void mo7477d(int i) {
        this.f65d = Math.min(Math.abs(i), 23);
    }

    /* renamed from: e */
    public int mo7478e() {
        return this.f66e;
    }

    /* renamed from: e */
    public void mo7479e(int i) {
        this.f66e = Math.min(Math.abs(i), 59);
    }

    /* renamed from: f */
    public int mo7480f() {
        return this.f67f;
    }

    /* renamed from: f */
    public void mo7481f(int i) {
        this.f67f = Math.min(Math.abs(i), 59);
    }

    /* renamed from: g */
    public int mo7482g() {
        return this.f69h;
    }

    /* renamed from: g */
    public void mo7483g(int i) {
        this.f69h = i;
    }

    public int compareTo(Object obj) {
        XMPDateTime aVar = (XMPDateTime) obj;
        long timeInMillis = mo7485i().getTimeInMillis() - aVar.mo7485i().getTimeInMillis();
        if (timeInMillis != 0) {
            return (int) (timeInMillis % 2);
        }
        return (int) (((long) (this.f69h - aVar.mo7482g())) % 2);
    }

    /* renamed from: h */
    public TimeZone mo7484h() {
        return this.f68g;
    }

    /* renamed from: a */
    public void mo7471a(TimeZone timeZone) {
        this.f68g = timeZone;
    }

    /* renamed from: i */
    public Calendar mo7485i() {
        GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance(Locale.US);
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        gregorianCalendar.setTimeZone(this.f68g);
        gregorianCalendar.set(1, this.f62a);
        gregorianCalendar.set(2, this.f63b - 1);
        gregorianCalendar.set(5, this.f64c);
        gregorianCalendar.set(11, this.f65d);
        gregorianCalendar.set(12, this.f66e);
        gregorianCalendar.set(13, this.f67f);
        gregorianCalendar.set(14, this.f69h / 1000000);
        return gregorianCalendar;
    }

    /* renamed from: j */
    public String mo7521j() {
        return ISO8601Converter.m61a((XMPDateTime) this);
    }

    public String toString() {
        return mo7521j();
    }
}
