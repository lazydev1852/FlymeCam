package com.meizu.media.camera.p066c;

import android.graphics.drawable.Drawable;
import com.meizu.media.camera.p064a.AsyncResource;
import com.meizu.media.camera.p064a.DataAdapter;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.c.c */
public abstract class MeasuredAsyncDrawable extends AsyncDrawable {

    /* renamed from: d */
    public static ChangeQuickRedirect f8251d;

    /* renamed from: e */
    protected final int f8252e;

    /* renamed from: f */
    protected final int f8253f;

    /* renamed from: g */
    protected int f8254g;

    /* renamed from: h */
    protected int f8255h;

    public MeasuredAsyncDrawable(int i, int i2, int i3, int i4, AsyncResource.C1783a<Drawable> aVar, Drawable drawable, int i5, DataAdapter.C1784a aVar2) {
        super(aVar, drawable, i5, aVar2);
        this.f8252e = i3;
        this.f8253f = i4;
        this.f8254g = i;
        this.f8255h = i2;
    }

    /* renamed from: e */
    public int mo19411e() {
        return this.f8254g;
    }

    /* renamed from: f */
    public int mo19412f() {
        return this.f8255h;
    }

    public int getIntrinsicWidth() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8251d, false, 3776, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        return this.f8254g == 0 ? super.getIntrinsicWidth() : this.f8254g;
    }

    public int getIntrinsicHeight() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8251d, false, 3777, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        return this.f8255h == 0 ? super.getIntrinsicHeight() : this.f8255h;
    }
}
