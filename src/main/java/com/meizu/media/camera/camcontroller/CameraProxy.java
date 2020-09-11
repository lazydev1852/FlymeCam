package com.meizu.media.camera.camcontroller;

/* renamed from: com.meizu.media.camera.camcontroller.d */
public abstract class CameraProxy<T> {

    /* renamed from: e */
    public static int f9121e;

    /* renamed from: a */
    protected int f9122a;

    /* renamed from: b */
    protected boolean f9123b;

    /* renamed from: c */
    protected T f9124c;

    /* renamed from: d */
    protected T f9125d;

    public CameraProxy(int i, T t) {
        this.f9122a = i;
        this.f9124c = t;
    }

    /* renamed from: a */
    public T mo19730a() {
        return this.f9124c;
    }

    /* renamed from: b */
    public int mo19733b() {
        return this.f9122a;
    }

    /* renamed from: a */
    public void mo19731a(T t) {
        this.f9125d = t;
    }

    /* renamed from: c */
    public T mo19734c() {
        return this.f9125d;
    }

    /* renamed from: d */
    public boolean mo19735d() {
        return this.f9123b;
    }

    /* renamed from: a */
    public void mo19732a(boolean z) {
        this.f9123b = z;
    }
}
