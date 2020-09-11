package com.meizu.media.camera.p077ui;

import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.p077ui.MzCommonUI;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.ui.q */
public class MzGifUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f13484a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MzUIController f13485b;

    /* renamed from: c */
    private MzCommonUI.C2403f f13486c = new MzCommonUI.C2403f() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13487a;

        /* renamed from: a */
        public void mo21344a() {
            if (!PatchProxy.proxy(new Object[0], this, f13487a, false, 7331, new Class[0], Void.TYPE).isSupported) {
                MzGifUI.this.f13485b.mo21605j(8);
            }
        }

        /* renamed from: b */
        public void mo21345b() {
            if (!PatchProxy.proxy(new Object[0], this, f13487a, false, 7332, new Class[0], Void.TYPE).isSupported) {
                MzGifUI.this.f13485b.mo21605j(9);
            }
        }
    };

    /* renamed from: a */
    public void mo22427a(MzUIController uVar) {
        this.f13485b = uVar;
    }

    /* renamed from: a */
    public void mo22426a() {
        if (!PatchProxy.proxy(new Object[0], this, f13484a, false, 7323, new Class[0], Void.TYPE).isSupported) {
            this.f13485b.mo21530a(true);
            this.f13485b.mo21605j(0);
            this.f13485b.mo21520a(this.f13486c);
        }
    }

    /* renamed from: b */
    public void mo22429b() {
        if (!PatchProxy.proxy(new Object[0], this, f13484a, false, 7324, new Class[0], Void.TYPE).isSupported) {
            this.f13485b.mo21520a((MzCommonUI.C2403f) null);
            this.f13485b.mo21530a(false);
            this.f13485b.mo21605j(3);
        }
    }

    /* renamed from: c */
    public void mo22430c() {
        if (!PatchProxy.proxy(new Object[0], this, f13484a, false, 7325, new Class[0], Void.TYPE).isSupported) {
            this.f13485b.mo21616n();
            this.f13485b.mo21581d(133, false);
            this.f13485b.mo21605j(1);
        }
    }

    /* renamed from: d */
    public void mo22431d() {
        if (!PatchProxy.proxy(new Object[0], this, f13484a, false, 7326, new Class[0], Void.TYPE).isSupported) {
            this.f13485b.mo21574c(16, false);
            this.f13485b.mo21581d(16, true);
            this.f13485b.mo21574c(8, false);
            this.f13485b.mo21581d(8, true);
            this.f13485b.mo21574c(1, true);
            this.f13485b.mo21581d(1, true);
            this.f13485b.mo21574c(4, true);
            this.f13485b.mo21581d(4, true);
            this.f13485b.mo21581d(32, true);
            this.f13485b.mo21574c(128, true);
            this.f13485b.mo21581d(128, true);
            this.f13485b.mo21605j(6);
        }
    }

    /* renamed from: e */
    public void mo22432e() {
        if (!PatchProxy.proxy(new Object[0], this, f13484a, false, 7327, new Class[0], Void.TYPE).isSupported) {
            this.f13485b.mo21581d(8, false);
            this.f13485b.mo21581d(16, false);
            this.f13485b.mo21581d(32, false);
            this.f13485b.mo21605j(2);
        }
    }

    /* renamed from: f */
    public void mo22433f() {
        if (!PatchProxy.proxy(new Object[0], this, f13484a, false, 7328, new Class[0], Void.TYPE).isSupported) {
            this.f13485b.mo21581d(8, false);
            this.f13485b.mo21581d(16, false);
            this.f13485b.mo21581d(32, false);
            this.f13485b.mo21605j(7);
        }
    }

    /* renamed from: a */
    public void mo22428a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13484a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7329, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!z) {
                this.f13485b.mo21619o();
            } else {
                this.f13485b.mo21581d(4, true);
            }
        }
    }

    /* renamed from: g */
    public boolean mo22434g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13484a, false, 7330, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : this.f13485b.mo21615m();
    }
}
