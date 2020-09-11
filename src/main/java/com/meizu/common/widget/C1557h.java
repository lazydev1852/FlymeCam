package com.meizu.common.widget;

import android.graphics.drawable.GradientDrawable;

/* renamed from: com.meizu.common.widget.h */
/* compiled from: Switch */
public class C1557h {

    /* renamed from: a */
    private GradientDrawable f6431a;

    /* renamed from: b */
    private float f6432b;

    /* renamed from: c */
    private int f6433c;

    /* renamed from: d */
    private int f6434d;

    /* renamed from: e */
    private int f6435e;

    /* renamed from: f */
    private int f6436f;

    /* renamed from: g */
    private int f6437g;

    /* renamed from: h */
    private int f6438h;

    public C1557h(GradientDrawable gradientDrawable) {
        this.f6431a = gradientDrawable;
    }

    /* renamed from: a */
    public void mo17590a(float f) {
        this.f6432b = f;
        this.f6431a.setCornerRadius(f);
    }

    /* renamed from: a */
    public void mo17591a(int i) {
        this.f6433c = i;
        this.f6431a.setColor(i);
    }

    /* renamed from: a */
    public int mo17589a() {
        return this.f6433c;
    }

    /* renamed from: b */
    public int mo17592b() {
        return this.f6434d;
    }

    /* renamed from: b */
    public void mo17593b(int i) {
        this.f6434d = i;
        this.f6431a.setSize(this.f6435e, i);
    }

    /* renamed from: c */
    public int mo17594c() {
        return this.f6435e;
    }

    /* renamed from: c */
    public void mo17595c(int i) {
        this.f6435e = i;
        this.f6431a.setSize(i, this.f6434d);
    }

    /* renamed from: d */
    public GradientDrawable mo17596d() {
        return this.f6431a;
    }

    /* renamed from: e */
    public int mo17598e() {
        return this.f6436f;
    }

    /* renamed from: d */
    public void mo17597d(int i) {
        this.f6436f = i;
    }

    /* renamed from: f */
    public int mo17600f() {
        return this.f6437g;
    }

    /* renamed from: e */
    public void mo17599e(int i) {
        this.f6437g = i;
    }

    /* renamed from: f */
    public void mo17601f(int i) {
        if (this.f6438h != i) {
            this.f6438h = i;
            this.f6431a.setAlpha(i);
        }
    }
}
