package com.meizu.media.camera.p077ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.views.MzBurstRenderer;
import com.meizu.media.camera.views.RenderOverlay;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.ui.h */
public class MzBurstUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f12965a;

    /* renamed from: b */
    private MzBurstRenderer f12966b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MzUIController f12967c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f12968d;

    /* renamed from: e */
    private Handler f12969e = new Handler(new Handler.Callback() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12970a;

        public boolean handleMessage(Message message) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{message}, this, f12970a, false, 6461, new Class[]{Message.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            MzBurstUI.this.mo22032a();
            MzBurstUI.this.f12967c.mo21606j(MzBurstUI.this.f12968d);
            return true;
        }
    });

    public MzBurstUI(RenderOverlay renderOverlay, Context context) {
        if (this.f12966b == null) {
            this.f12966b = new MzBurstRenderer(context);
            renderOverlay.mo23142a((RenderOverlay.C2723a) this.f12966b);
        }
    }

    /* renamed from: a */
    public void mo22035a(MzUIController uVar) {
        this.f12967c = uVar;
    }

    /* renamed from: a */
    public void mo22032a() {
        if (!PatchProxy.proxy(new Object[0], this, f12965a, false, 6456, new Class[0], Void.TYPE).isSupported) {
            if (!this.f12967c.mo21543ah()) {
                this.f12967c.mo21510a(-1, true);
                this.f12967c.mo21581d(5, true);
            }
            this.f12966b.mo23320a();
        }
    }

    /* renamed from: a */
    public void mo22034a(long j, boolean z) {
        Object[] objArr = {new Long(j), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f12965a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6458, new Class[]{Long.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f12968d = z;
            this.f12969e.sendEmptyMessageDelayed(0, j);
        }
    }

    /* renamed from: a */
    public void mo22033a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f12965a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 6459, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (i == 1) {
                this.f12966b.mo23403f(true);
            }
            if (this.f12966b.mo23404k()) {
                this.f12966b.mo23322a(this.f12967c.mo21649z());
                this.f12966b.mo23321a(i);
                this.f12966b.mo23323b();
            }
        }
    }

    /* renamed from: b */
    public void mo22036b(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f12965a, false, 6460, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f12966b.mo23324b(i);
            this.f12967c.mo21581d(5, false);
            this.f12967c.mo21510a(-1, false);
        }
    }
}
