package com.meizu.media.camera.util;

import android.graphics.drawable.Drawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.util.c */
public final class AsyncDrawableJobExecutor extends SimpleJobExecutor<Drawable> {

    /* renamed from: a */
    public static ChangeQuickRedirect f14211a;

    /* renamed from: c */
    private static AsyncDrawableJobExecutor f14212c;

    private AsyncDrawableJobExecutor() {
        super(4);
    }

    /* renamed from: a */
    public static synchronized AsyncDrawableJobExecutor m16126a() {
        synchronized (AsyncDrawableJobExecutor.class) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f14211a, true, 7726, new Class[0], AsyncDrawableJobExecutor.class);
            if (proxy.isSupported) {
                AsyncDrawableJobExecutor cVar = (AsyncDrawableJobExecutor) proxy.result;
                return cVar;
            }
            if (f14212c == null) {
                f14212c = new AsyncDrawableJobExecutor();
            }
            AsyncDrawableJobExecutor cVar2 = f14212c;
            return cVar2;
        }
    }
}
