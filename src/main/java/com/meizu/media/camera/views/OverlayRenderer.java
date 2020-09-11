package com.meizu.media.camera.views;

import android.graphics.Canvas;
import android.view.MotionEvent;
import com.meizu.media.camera.views.RenderOverlay;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.views.n */
public abstract class OverlayRenderer implements RenderOverlay.C2723a {

    /* renamed from: a_ */
    public static ChangeQuickRedirect f15551a_;

    /* renamed from: u */
    protected RenderOverlay f15552u;

    /* renamed from: v */
    protected int f15553v;

    /* renamed from: w */
    protected int f15554w;

    /* renamed from: x */
    protected int f15555x;

    /* renamed from: y */
    protected int f15556y;

    /* renamed from: z */
    protected boolean f15557z;

    /* renamed from: a */
    public abstract void mo20787a(Canvas canvas);

    /* renamed from: c */
    public boolean mo23156c(MotionEvent motionEvent) {
        return false;
    }

    /* renamed from: l */
    public boolean mo23157l() {
        return false;
    }

    /* renamed from: f */
    public void mo23403f(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15551a_;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8769, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f15557z = z;
            mo23407o();
        }
    }

    /* renamed from: k */
    public boolean mo23404k() {
        return this.f15557z;
    }

    /* renamed from: b */
    public void mo23155b(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15551a_, false, 8770, new Class[]{Canvas.class}, Void.TYPE).isSupported && this.f15557z) {
            mo20787a(canvas);
        }
    }

    /* renamed from: a */
    public void mo23154a(RenderOverlay renderOverlay) {
        this.f15552u = renderOverlay;
    }

    /* renamed from: a */
    public void mo23153a(int i, int i2, int i3, int i4) {
        this.f15553v = i;
        this.f15555x = i3;
        this.f15554w = i2;
        this.f15556y = i4;
    }

    /* renamed from: m */
    public int mo23405m() {
        return this.f15555x - this.f15553v;
    }

    /* renamed from: n */
    public int mo23406n() {
        return this.f15556y - this.f15554w;
    }

    /* renamed from: o */
    public void mo23407o() {
        if (!PatchProxy.proxy(new Object[0], this, f15551a_, false, 8772, new Class[0], Void.TYPE).isSupported && this.f15552u != null) {
            this.f15552u.mo23139a();
        }
    }
}
