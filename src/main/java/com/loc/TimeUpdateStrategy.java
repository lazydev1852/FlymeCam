package com.loc;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.loc.bj */
public final class TimeUpdateStrategy extends UpdateStrategy {

    /* renamed from: b */
    private int f2644b;

    /* renamed from: c */
    private long f2645c;

    /* renamed from: d */
    private String f2646d;

    /* renamed from: e */
    private Context f2647e;

    public TimeUpdateStrategy(Context context, int i, String str, UpdateStrategy bkVar) {
        super(bkVar);
        this.f2644b = i;
        this.f2646d = str;
        this.f2647e = context;
    }

    /* renamed from: a */
    public final void mo13045a(boolean z) {
        super.mo13045a(z);
        if (z) {
            String str = this.f2646d;
            long currentTimeMillis = System.currentTimeMillis();
            this.f2645c = currentTimeMillis;
            C1108h.m3851a(this.f2647e, str, String.valueOf(currentTimeMillis));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo13042a() {
        long j = 0;
        if (this.f2645c == 0) {
            String a = C1108h.m3849a(this.f2647e, this.f2646d);
            if (!TextUtils.isEmpty(a)) {
                j = Long.parseLong(a);
            }
            this.f2645c = j;
        }
        return System.currentTimeMillis() - this.f2645c >= ((long) this.f2644b);
    }
}
