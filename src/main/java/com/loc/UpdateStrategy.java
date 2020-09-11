package com.loc;

import androidx.appcompat.widget.ActivityChooserView;

/* renamed from: com.loc.bk */
public abstract class UpdateStrategy {

    /* renamed from: a */
    UpdateStrategy f2648a;

    public UpdateStrategy() {
    }

    public UpdateStrategy(UpdateStrategy bkVar) {
        this.f2648a = bkVar;
    }

    /* renamed from: a */
    public void mo13043a(int i) {
        if (this.f2648a != null) {
            this.f2648a.mo13043a(i);
        }
    }

    /* renamed from: a */
    public void mo13045a(boolean z) {
        if (this.f2648a != null) {
            this.f2648a.mo13045a(z);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo13042a();

    /* renamed from: b */
    public int mo13044b() {
        return Math.min(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, this.f2648a != null ? this.f2648a.mo13044b() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    /* renamed from: c */
    public final boolean mo13046c() {
        if (!(this.f2648a != null ? this.f2648a.mo13046c() : true)) {
            return false;
        }
        return mo13042a();
    }
}
