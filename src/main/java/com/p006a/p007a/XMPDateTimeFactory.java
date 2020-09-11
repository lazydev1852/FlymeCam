package com.p006a.p007a;

import com.p006a.p007a.p008a.XMPDateTimeImpl;
import java.util.Calendar;
import java.util.TimeZone;

/* renamed from: com.a.a.b */
public final class XMPDateTimeFactory {

    /* renamed from: a */
    private static final TimeZone f109a = TimeZone.getTimeZone("UTC");

    /* renamed from: a */
    public static XMPDateTime m281a(Calendar calendar) {
        return new XMPDateTimeImpl(calendar);
    }
}
