package com.meizu.media.camera.p077ui;

import android.content.Context;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.p077ui.MzCommonUI;
import com.meizu.media.camera.views.MzPanoRenderer;
import com.meizu.media.camera.views.RenderOverlay;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.ui.v */
public class MzPanoUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f13623a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MzPanoRenderer f13624b;

    /* renamed from: c */
    private int f13625c;

    /* renamed from: d */
    private int f13626d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f13627e = false;

    /* renamed from: f */
    private Context f13628f;

    /* renamed from: g */
    private MzUIController f13629g;

    /* renamed from: h */
    private MzCommonUI.C2403f f13630h = new MzCommonUI.C2403f() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13631a;

        /* renamed from: a */
        public void mo21344a() {
            if (!PatchProxy.proxy(new Object[0], this, f13631a, false, 7506, new Class[0], Void.TYPE).isSupported) {
                boolean unused = MzPanoUI.this.f13627e = false;
                MzPanoUI.this.f13624b.mo23403f(false);
            }
        }

        /* renamed from: b */
        public void mo21345b() {
            if (!PatchProxy.proxy(new Object[0], this, f13631a, false, 7507, new Class[0], Void.TYPE).isSupported) {
                boolean unused = MzPanoUI.this.f13627e = true;
                MzPanoUI.this.f13624b.mo23403f(true);
            }
        }
    };

    public MzPanoUI(Context context, RenderOverlay renderOverlay) {
        this.f13628f = context;
        if (this.f13624b != null) {
            this.f13624b.mo23359d();
            this.f13624b = null;
        }
        this.f13624b = new MzPanoRenderer(this.f13628f);
        renderOverlay.mo23142a((RenderOverlay.C2723a) this.f13624b);
    }

    /* renamed from: a */
    public void mo22529a(int i, int i2) {
        this.f13625c = i;
        this.f13626d = i2;
    }

    /* renamed from: a */
    public void mo22530a(MzUIController uVar) {
        this.f13629g = uVar;
    }

    /* renamed from: a */
    public boolean mo22534a() {
        return this.f13627e;
    }

    /* renamed from: b */
    public void mo22535b() {
        if (!PatchProxy.proxy(new Object[0], this, f13623a, false, 7486, new Class[0], Void.TYPE).isSupported) {
            this.f13629g.mo21520a(this.f13630h);
            this.f13624b.mo23349a(this.f13626d, this.f13625c);
            this.f13627e = true;
            if (this.f13624b != null) {
                this.f13624b.mo23354b(0);
                this.f13624b.mo23347a();
            }
        }
    }

    /* renamed from: c */
    public void mo22538c() {
        if (!PatchProxy.proxy(new Object[0], this, f13623a, false, 7487, new Class[0], Void.TYPE).isSupported && !this.f13629g.mo21590f()) {
            this.f13624b.mo23403f(true);
        }
    }

    /* renamed from: d */
    public void mo22540d() {
        if (!PatchProxy.proxy(new Object[0], this, f13623a, false, 7488, new Class[0], Void.TYPE).isSupported && this.f13624b != null) {
            this.f13624b.mo23359d();
        }
    }

    /* renamed from: e */
    public void mo22541e() {
        if (!PatchProxy.proxy(new Object[0], this, f13623a, false, 7489, new Class[0], Void.TYPE).isSupported) {
            this.f13627e = false;
            this.f13629g.mo21520a((MzCommonUI.C2403f) null);
            this.f13629g.mo21580d(2, (int) R.drawable.mz_btn_shutter_default);
            if (this.f13624b != null) {
                this.f13624b.mo23403f(false);
                this.f13624b.mo23359d();
            }
        }
    }

    /* renamed from: a */
    public void mo22531a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13623a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7490, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f13624b != null) {
            this.f13624b.mo23403f(z);
        }
    }

    /* renamed from: f */
    public void mo22542f() {
        if (!PatchProxy.proxy(new Object[0], this, f13623a, false, 7491, new Class[0], Void.TYPE).isSupported) {
            this.f13624b.mo23348a(1);
            this.f13629g.mo21576c(true, false);
        }
    }

    /* renamed from: g */
    public void mo22543g() {
        if (!PatchProxy.proxy(new Object[0], this, f13623a, false, 7492, new Class[0], Void.TYPE).isSupported) {
            this.f13629g.mo21581d(2, false);
        }
    }

    /* renamed from: b */
    public void mo22537b(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13623a, false, 7493, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f13629g.mo21581d(2, false);
            if (z) {
                this.f13624b.mo23348a(3);
            }
            this.f13624b.mo23364i();
            this.f13624b.mo23360e();
            this.f13624b.mo23363h();
        }
    }

    /* renamed from: c */
    public void mo22539c(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13623a, false, 7494, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f13624b.mo23350a(z);
            this.f13624b.mo23348a(0);
            this.f13624b.mo23363h();
            this.f13627e = true;
            this.f13629g.mo21581d(2, true);
            this.f13629g.mo21576c(false, z);
        }
    }

    /* renamed from: a */
    public void mo22528a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f13623a, false, 7496, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f13627e = false;
            this.f13624b.mo23358c(i);
        }
    }

    /* renamed from: a */
    public void mo22533a(byte[] bArr, int i, int i2, int i3) {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2), new Integer(i3)}, this, f13623a, false, 7498, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f13624b.mo23352a(bArr, i, i2, i3);
        }
    }

    /* renamed from: h */
    public void mo22544h() {
        if (!PatchProxy.proxy(new Object[0], this, f13623a, false, 7499, new Class[0], Void.TYPE).isSupported) {
            this.f13624b.mo23363h();
        }
    }

    /* renamed from: i */
    public void mo22545i() {
        if (!PatchProxy.proxy(new Object[0], this, f13623a, false, 7500, new Class[0], Void.TYPE).isSupported) {
            this.f13624b.mo23360e();
        }
    }

    /* renamed from: j */
    public int mo22546j() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13623a, false, 7501, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f13624b.mo23353b();
    }

    /* renamed from: k */
    public int mo22547k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13623a, false, 7502, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f13624b.mo23361f();
    }

    /* renamed from: l */
    public int mo22548l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13623a, false, 7503, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f13624b.mo23357c();
    }

    /* renamed from: a */
    public void mo22532a(byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f13623a, false, 7504, new Class[]{byte[].class}, Void.TYPE).isSupported && this.f13624b != null) {
            this.f13624b.mo23351a(bArr);
        }
    }

    /* renamed from: b */
    public void mo22536b(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f13623a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7505, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && this.f13624b != null) {
            this.f13624b.mo23348a(i);
        }
    }
}
