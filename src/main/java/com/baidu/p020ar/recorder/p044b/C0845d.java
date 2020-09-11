package com.baidu.p020ar.recorder.p044b;

import android.graphics.Rect;

/* renamed from: com.baidu.ar.recorder.b.d */
public class C0845d implements Cloneable {

    /* renamed from: a */
    private int f2062a = 720;

    /* renamed from: b */
    private int f2063b = 1280;

    /* renamed from: c */
    private int f2064c = 720;

    /* renamed from: d */
    private int f2065d = 1280;

    /* renamed from: e */
    private Rect f2066e = new Rect(0, 0, this.f2064c, this.f2065d);

    /* renamed from: f */
    private int f2067f = 2;

    /* renamed from: g */
    private int f2068g = 0;

    /* renamed from: h */
    private boolean f2069h = false;

    /* renamed from: i */
    private float f2070i = 1.0f;

    /* renamed from: j */
    private float f2071j = 1.0f;

    /* renamed from: k */
    private int f2072k = 0;

    /* renamed from: a */
    public int mo10452a() {
        return this.f2064c;
    }

    /* renamed from: a */
    public void mo10453a(int i) {
        this.f2064c = i;
    }

    /* renamed from: a */
    public void mo10454a(Rect rect) {
        this.f2066e = rect;
    }

    /* renamed from: b */
    public int mo10455b() {
        return this.f2065d;
    }

    /* renamed from: b */
    public void mo10456b(int i) {
        this.f2065d = i;
    }

    /* renamed from: c */
    public int mo10457c() {
        return this.f2068g;
    }

    /* renamed from: c */
    public void mo10458c(int i) {
        this.f2068g = i;
    }

    public Object clone() {
        C0845d dVar;
        try {
            dVar = (C0845d) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            dVar = null;
        }
        dVar.mo10454a(new Rect(this.f2066e));
        return dVar;
    }

    /* renamed from: d */
    public float mo10460d() {
        return this.f2070i;
    }

    /* renamed from: e */
    public float mo10461e() {
        return this.f2071j;
    }

    /* renamed from: f */
    public int mo10462f() {
        return this.f2072k;
    }
}
