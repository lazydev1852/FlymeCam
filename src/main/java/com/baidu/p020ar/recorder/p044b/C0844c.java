package com.baidu.p020ar.recorder.p044b;

import android.content.Context;
import com.baidu.p020ar.recorder.filter.C0869c;
import com.baidu.p020ar.recorder.filter.FilterManager;
import com.baidu.p020ar.recorder.p047e.C0857b;

/* renamed from: com.baidu.ar.recorder.b.c */
public class C0844c {

    /* renamed from: a */
    private C0857b f2059a;

    /* renamed from: b */
    private C0843b f2060b;

    /* renamed from: c */
    private C0842a f2061c;

    public C0844c(C0842a aVar) {
        this.f2061c = aVar;
        this.f2059a = new C0857b(aVar.mo10424a(), 1);
    }

    /* renamed from: a */
    private C0869c m2357a(Context context, C0842a aVar) {
        return aVar.mo10437f() ? FilterManager.m2502a(context, aVar.mo10439h()) : FilterManager.m2503b(context, aVar.mo10439h());
    }

    /* renamed from: a */
    public C0857b mo10447a() {
        return this.f2059a;
    }

    /* renamed from: a */
    public void mo10448a(Context context) {
        this.f2060b = new C0843b(this.f2061c.mo10432c(), this.f2061c.mo10438g(), m2357a(context, this.f2061c));
        this.f2060b.mo10443a();
    }

    /* renamed from: a */
    public void mo10449a(Context context, FilterManager.FilterType filterType) {
        this.f2061c.mo10428a(filterType);
        this.f2060b.mo10445a(m2357a(context, this.f2061c));
    }

    /* renamed from: a */
    public void mo10450a(float[] fArr) {
        this.f2060b.mo10444a(this.f2061c.mo10430b(), fArr, false, false);
    }

    /* renamed from: b */
    public void mo10451b() {
        if (this.f2059a != null) {
            this.f2059a.mo10516a();
            this.f2059a = null;
        }
        if (this.f2060b != null) {
            this.f2060b.mo10446a(true);
            this.f2060b = null;
        }
    }
}
