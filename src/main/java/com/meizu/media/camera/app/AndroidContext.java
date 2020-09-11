package com.meizu.media.camera.app;

import android.content.Context;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.app.b */
public final class AndroidContext {

    /* renamed from: a */
    public static ChangeQuickRedirect f7920a;

    /* renamed from: b */
    private static AndroidContext f7921b;

    /* renamed from: c */
    private final Context f7922c;

    /* renamed from: a */
    public static void m8285a(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, (Object) null, f7920a, true, 2498, new Class[]{Context.class}, Void.TYPE).isSupported && f7921b == null) {
            f7921b = new AndroidContext(context);
        }
    }

    /* renamed from: a */
    public static AndroidContext m8284a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, f7920a, true, 2499, new Class[0], AndroidContext.class);
        if (proxy.isSupported) {
            return (AndroidContext) proxy.result;
        }
        if (f7921b != null) {
            return f7921b;
        }
        throw new IllegalStateException("Android context was not initialized.");
    }

    private AndroidContext(Context context) {
        this.f7922c = context;
    }

    /* renamed from: b */
    public Context mo19002b() {
        return this.f7922c;
    }
}
