package com.loc;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserView;

/* renamed from: com.loc.bh */
public final class MobileUpdateStrategy extends UpdateStrategy {

    /* renamed from: b */
    private Context f2639b;

    /* renamed from: c */
    private boolean f2640c;

    /* renamed from: d */
    private int f2641d;

    /* renamed from: e */
    private int f2642e;

    public MobileUpdateStrategy(Context context, boolean z, int i, int i2) {
        this.f2639b = context;
        this.f2640c = z;
        this.f2641d = i;
        this.f2642e = i2;
    }

    /* renamed from: a */
    public final void mo13043a(int i) {
        if (DeviceInfo.m3729r(this.f2639b) != 1) {
            String a = C1107dj.m3806a(System.currentTimeMillis(), "yyyyMMdd");
            String a2 = C1108h.m3849a(this.f2639b, "iKey");
            if (!TextUtils.isEmpty(a2)) {
                String[] split = a2.split("\\|");
                if (split == null || split.length < 2) {
                    C1108h.m3854b(this.f2639b, "iKey");
                } else if (a.equals(split[0])) {
                    i += Integer.parseInt(split[1]);
                }
            }
            Context context = this.f2639b;
            C1108h.m3851a(context, "iKey", a + "|" + i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo13042a() {
        if (DeviceInfo.m3729r(this.f2639b) == 1) {
            return true;
        }
        if (!this.f2640c) {
            return false;
        }
        String a = C1108h.m3849a(this.f2639b, "iKey");
        if (TextUtils.isEmpty(a)) {
            return true;
        }
        String[] split = a.split("\\|");
        if (split == null || split.length < 2) {
            C1108h.m3854b(this.f2639b, "iKey");
            return true;
        }
        return !C1107dj.m3806a(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f2642e;
    }

    /* renamed from: b */
    public final int mo13044b() {
        int i = (DeviceInfo.m3729r(this.f2639b) == 1 || this.f2641d <= 0) ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.f2641d;
        return this.f2648a != null ? Math.max(i, this.f2648a.mo13044b()) : i;
    }
}
