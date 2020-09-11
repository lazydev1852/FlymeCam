package com.meizu.media.camera.p066c;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.meizu.media.camera.p064a.AsyncResource;
import com.meizu.media.camera.p064a.DataAdapter;
import com.meizu.media.camera.util.BitmapDrawableJob;
import com.meizu.media.camera.util.BitmapPool;
import com.meizu.media.camera.util.ThreadPool;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.c.e */
public class UriAsyncDrawable extends MeasuredAsyncDrawable {

    /* renamed from: j */
    public static ChangeQuickRedirect f8268j;

    /* renamed from: k */
    protected Context f8269k;

    /* renamed from: l */
    protected String f8270l;

    /* renamed from: m */
    protected String f8271m;

    /* renamed from: n */
    protected int f8272n = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UriAsyncDrawable(Context context, String str, int i, int i2, int i3, int i4, AsyncResource.C1783a<Drawable> aVar, Drawable drawable, int i5, DataAdapter.C1784a aVar2, String str2, int i6) {
        super(i, i2, i3, i4, aVar, drawable, i5, aVar2);
        this.f8269k = context;
        this.f8270l = str;
        this.f8271m = str2;
        this.f8272n = i6;
    }

    /* renamed from: b */
    public ThreadPool.C2637b<Drawable> mo19377b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8268j, false, 3786, new Class[0], ThreadPool.C2637b.class);
        return proxy.isSupported ? (ThreadPool.C2637b) proxy.result : new BitmapDrawableJob(this.f8269k, this.f8270l, this.f8254g, this.f8255h, this.f8252e, this.f8253f, this.f8271m, this.f8272n);
    }

    /* renamed from: a */
    public void mo19375a(Drawable drawable) {
        if (!PatchProxy.proxy(new Object[]{drawable}, this, f8268j, false, 3787, new Class[]{Drawable.class}, Void.TYPE).isSupported && this.f8253f != 0) {
            BitmapPool.m16137a(this.f8253f).mo22727a(((BitmapDrawable) drawable).getBitmap());
        }
    }
}
