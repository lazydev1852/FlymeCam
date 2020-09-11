package com.baidu.p020ar.arplay.p032a;

import android.content.Context;
import android.os.Vibrator;

/* renamed from: com.baidu.ar.arplay.a.d */
public class C0536d {

    /* renamed from: b */
    private static C0536d f701b;

    /* renamed from: a */
    long[] f702a = {800, 60, 400, 60};

    /* renamed from: c */
    private Vibrator f703c;

    private C0536d(Context context) {
        this.f703c = (Vibrator) context.getSystemService("vibrator");
    }

    /* renamed from: a */
    public static synchronized C0536d m1010a(Context context) {
        C0536d dVar;
        synchronized (C0536d.class) {
            if (f701b == null) {
                f701b = new C0536d(context);
            }
            dVar = f701b;
        }
        return dVar;
    }

    /* renamed from: a */
    public void mo9055a(long j) {
        this.f703c.vibrate(j);
    }

    /* renamed from: a */
    public void mo9056a(long[] jArr) {
        this.f703c.vibrate(jArr, -1);
    }
}
