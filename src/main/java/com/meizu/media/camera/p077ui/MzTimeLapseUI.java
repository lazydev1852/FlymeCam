package com.meizu.media.camera.p077ui;

import android.content.Context;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.p077ui.MzCommonUI;
import com.meizu.media.camera.views.MzTimeLapseRender;
import com.meizu.media.camera.views.RenderOverlay;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.ui.aa */
public class MzTimeLapseUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f12650a;

    /* renamed from: b */
    private MzUIController f12651b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MzTimeLapseRender f12652c;

    /* renamed from: d */
    private MzCommonUI.C2403f f12653d = new MzCommonUI.C2403f() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12654a;

        /* renamed from: a */
        public void mo21344a() {
            if (!PatchProxy.proxy(new Object[0], this, f12654a, false, 7612, new Class[0], Void.TYPE).isSupported) {
                MzTimeLapseUI.this.f12652c.mo23403f(false);
            }
        }

        /* renamed from: b */
        public void mo21345b() {
            if (!PatchProxy.proxy(new Object[0], this, f12654a, false, 7613, new Class[0], Void.TYPE).isSupported) {
                MzTimeLapseUI.this.f12652c.mo23403f(true);
            }
        }
    };

    public MzTimeLapseUI(RenderOverlay renderOverlay, Context context) {
        if (this.f12652c == null) {
            this.f12652c = new MzTimeLapseRender(context);
            renderOverlay.mo23142a((RenderOverlay.C2723a) this.f12652c);
        }
    }

    /* renamed from: a */
    public void mo21790a(MzTimeLapseRender.C2752a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f12650a, false, 7604, new Class[]{MzTimeLapseRender.C2752a.class}, Void.TYPE).isSupported) {
            if (!this.f12651b.mo21590f()) {
                this.f12651b.mo21580d(64, (int) R.drawable.mz_btn_shutter_bg_timelapse);
            }
            this.f12651b.mo21520a(this.f12653d);
            this.f12652c.mo23392a(aVar);
            this.f12652c.mo23403f(true);
        }
    }

    /* renamed from: a */
    public void mo21787a() {
        if (!PatchProxy.proxy(new Object[0], this, f12650a, false, 7605, new Class[0], Void.TYPE).isSupported) {
            this.f12651b.mo21580d(64, (int) R.drawable.mz_btn_shutter_bg);
            this.f12652c.mo23390a();
            this.f12652c.mo23403f(false);
            this.f12651b.mo21520a((MzCommonUI.C2403f) null);
        }
    }

    /* renamed from: a */
    public void mo21789a(MzUIController uVar) {
        this.f12651b = uVar;
    }

    /* renamed from: b */
    public void mo21792b() {
        if (!PatchProxy.proxy(new Object[0], this, f12650a, false, 7606, new Class[0], Void.TYPE).isSupported) {
            this.f12652c.mo23393a(true);
        }
    }

    /* renamed from: c */
    public void mo21793c() {
        if (!PatchProxy.proxy(new Object[0], this, f12650a, false, 7607, new Class[0], Void.TYPE).isSupported) {
            this.f12652c.mo23393a(false);
        }
    }

    /* renamed from: a */
    public void mo21788a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f12650a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7609, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && this.f12652c != null) {
            this.f12652c.mo23391a(i);
        }
    }

    /* renamed from: d */
    public void mo21794d() {
        if (!PatchProxy.proxy(new Object[0], this, f12650a, false, 7610, new Class[0], Void.TYPE).isSupported) {
            this.f12652c.mo23394b();
        }
    }

    /* renamed from: a */
    public void mo21791a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12650a, false, 7611, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f12651b != null) {
            this.f12651b.mo21580d(64, z ? R.drawable.mz_btn_shutter_bg_timelapse : R.drawable.mz_btn_shutter_bg);
        }
    }
}
