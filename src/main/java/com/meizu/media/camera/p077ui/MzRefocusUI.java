package com.meizu.media.camera.p077ui;

import android.os.Handler;
import android.os.Message;
import com.meizu.media.camera.MzUIController;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.ui.w */
public class MzRefocusUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f13633a;

    /* renamed from: b */
    private MzUIController f13634b;

    /* renamed from: c */
    private boolean f13635c = false;

    /* renamed from: d */
    private Handler f13636d = new Handler(new Handler.Callback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13637a;

        public boolean handleMessage(Message message) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{message}, this, f13637a, false, 7513, new Class[]{Message.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            MzRefocusUI.this.mo22553c();
            return true;
        }
    });

    /* renamed from: b */
    public void mo22552b() {
    }

    /* renamed from: a */
    public void mo22549a() {
        if (!PatchProxy.proxy(new Object[0], this, f13633a, false, 7508, new Class[0], Void.TYPE).isSupported) {
            this.f13634b.mo21592g(0);
            this.f13634b.mo21506a(0);
        }
    }

    /* renamed from: a */
    public void mo22550a(MzUIController uVar) {
        this.f13634b = uVar;
    }

    /* renamed from: a */
    public void mo22551a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13633a, false, 7509, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f13635c = z;
            this.f13636d.sendEmptyMessage(0);
        }
    }

    /* renamed from: c */
    public void mo22553c() {
        if (!PatchProxy.proxy(new Object[0], this, f13633a, false, 7510, new Class[0], Void.TYPE).isSupported) {
            this.f13634b.mo21597h(this.f13635c ? 3 : 2);
            this.f13634b.mo21581d(135, true);
        }
    }

    /* renamed from: d */
    public void mo22554d() {
        if (!PatchProxy.proxy(new Object[0], this, f13633a, false, 7511, new Class[0], Void.TYPE).isSupported) {
            this.f13636d.removeCallbacksAndMessages((Object) null);
            this.f13634b.mo21597h(0);
            this.f13634b.mo21581d(133, false);
        }
    }

    /* renamed from: e */
    public void mo22555e() {
        if (!PatchProxy.proxy(new Object[0], this, f13633a, false, 7512, new Class[0], Void.TYPE).isSupported) {
            this.f13634b.mo21597h(1);
        }
    }
}
