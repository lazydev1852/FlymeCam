package com.baidu.p020ar.recorder.p044b;

import android.opengl.EGLContext;
import com.baidu.p020ar.recorder.filter.FilterManager;
import com.baidu.p020ar.recorder.p045c.C0848a;
import com.baidu.p020ar.recorder.p047e.C0856a;

/* renamed from: com.baidu.ar.recorder.b.a */
public class C0842a implements Cloneable, Comparable<C0842a> {

    /* renamed from: a */
    private EGLContext f2043a;

    /* renamed from: b */
    private int f2044b = -1;

    /* renamed from: c */
    private C0856a f2045c;

    /* renamed from: d */
    private int f2046d;

    /* renamed from: e */
    private boolean f2047e;

    /* renamed from: f */
    private boolean f2048f;

    /* renamed from: g */
    private C0845d f2049g;

    /* renamed from: h */
    private FilterManager.FilterType f2050h;

    /* renamed from: i */
    private int f2051i;

    /* renamed from: j */
    private int f2052j;

    /* renamed from: k */
    private boolean f2053k;

    public C0842a(EGLContext eGLContext, int i, boolean z, boolean z2) {
        this.f2043a = eGLContext;
        this.f2046d = i;
        this.f2047e = z;
        this.f2048f = z2;
        this.f2045c = new C0848a();
        this.f2050h = FilterManager.FilterType.Normal;
        this.f2051i = 0;
        this.f2052j = 0;
        this.f2053k = false;
    }

    /* renamed from: a */
    public int compareTo(C0842a aVar) {
        return this.f2046d < aVar.mo10435d() ? -1 : 1;
    }

    /* renamed from: a */
    public EGLContext mo10424a() {
        return this.f2043a;
    }

    /* renamed from: a */
    public void mo10425a(int i) {
        this.f2044b = i;
    }

    /* renamed from: a */
    public void mo10426a(EGLContext eGLContext) {
        this.f2043a = eGLContext;
    }

    /* renamed from: a */
    public void mo10427a(C0845d dVar) {
        this.f2049g = dVar;
    }

    /* renamed from: a */
    public void mo10428a(FilterManager.FilterType filterType) {
        this.f2050h = filterType;
    }

    /* renamed from: a */
    public void mo10429a(boolean z) {
        this.f2053k = z;
    }

    /* renamed from: b */
    public int mo10430b() {
        return this.f2044b;
    }

    /* renamed from: b */
    public void mo10431b(int i) {
        this.f2052j = i;
    }

    /* renamed from: c */
    public C0856a mo10432c() {
        return this.f2045c;
    }

    public Object clone() {
        C0842a aVar;
        try {
            aVar = (C0842a) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            aVar = null;
        }
        aVar.mo10427a((C0845d) this.f2049g.clone());
        aVar.mo10429a(true);
        return aVar;
    }

    /* renamed from: d */
    public int mo10435d() {
        return this.f2046d;
    }

    /* renamed from: e */
    public boolean mo10436e() {
        return this.f2047e;
    }

    /* renamed from: f */
    public boolean mo10437f() {
        return this.f2048f;
    }

    /* renamed from: g */
    public C0845d mo10438g() {
        return this.f2049g;
    }

    /* renamed from: h */
    public FilterManager.FilterType mo10439h() {
        return this.f2050h;
    }

    /* renamed from: i */
    public int mo10440i() {
        return this.f2051i;
    }

    /* renamed from: j */
    public int mo10441j() {
        return this.f2052j;
    }

    /* renamed from: k */
    public boolean mo10442k() {
        return this.f2053k;
    }
}
