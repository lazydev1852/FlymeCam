package com.meizu.media.camera.p077ui;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.meizu.media.camera.MzUIController;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;

/* renamed from: com.meizu.media.camera.ui.ag */
public class NullStereoCameraUI {

    /* renamed from: b */
    public static ChangeQuickRedirect f12728b;

    /* renamed from: a */
    private C2435a f12729a;

    /* renamed from: c */
    protected final CharSequence[] f12730c = {"0", "1", "2", ExifInterface.GPS_MEASUREMENT_3D, UxipConstants.EVENT_UPLOAD_MIN_VERSION, "5"};

    /* renamed from: d */
    protected Context f12731d;

    /* renamed from: e */
    protected MzUIController f12732e;

    /* renamed from: com.meizu.media.camera.ui.ag$a */
    /* compiled from: NullStereoCameraUI */
    public interface C2435a {
        /* renamed from: c */
        void mo20630c();

        /* renamed from: d */
        void mo20631d(int i);

        /* renamed from: q */
        int mo20632q();
    }

    /* renamed from: a */
    public void mo21868a(boolean z) {
    }

    /* renamed from: a */
    public void mo21869a(boolean z, boolean z2) {
    }

    /* renamed from: a */
    public boolean mo21870a() {
        return false;
    }

    /* renamed from: b */
    public void mo21871b() {
    }

    /* renamed from: b */
    public void mo21872b(int i) {
    }

    /* renamed from: b */
    public void mo21873b(boolean z) {
    }

    public NullStereoCameraUI(Context context) {
        this.f12731d = context;
    }

    /* renamed from: a */
    public void mo21867a(C2435a aVar) {
        this.f12729a = aVar;
    }

    /* renamed from: c */
    public void mo21875c(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f12728b;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7701, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && this.f12729a != null) {
            this.f12729a.mo20631d(i);
            this.f12729a.mo20630c();
        }
    }

    /* renamed from: c */
    public int mo21874c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12728b, false, 7702, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f12729a != null) {
            return this.f12729a.mo20632q();
        }
        return -1;
    }

    /* renamed from: a */
    public void mo21866a(MzUIController uVar) {
        this.f12732e = uVar;
    }
}
