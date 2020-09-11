package com.meizu.media.camera.util;

import android.view.MotionEvent;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.util.af */
public final class MotionEventHelper {

    /* renamed from: a */
    public static ChangeQuickRedirect f14086a;

    /* renamed from: b */
    private static final LogUtil.C2630a f14087b = new LogUtil.C2630a("MotionEvent");

    /* renamed from: c */
    private static long f14088c;

    /* renamed from: d */
    private static int f14089d;

    /* renamed from: a */
    public static boolean m15964a(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, (Object) null, f14086a, true, 8140, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (motionEvent.getActionIndex() >= 2) {
            LogUtil.m15942a(f14087b, "multitouch false");
            return false;
        }
        if (motionEvent.getActionMasked() == 0) {
            if (Math.abs(motionEvent.getEventTime() - f14088c) >= 300 || f14089d == 0) {
                f14088c = motionEvent.getEventTime();
            } else {
                LogUtil.m15942a(f14087b, "double click false");
                return false;
            }
        }
        f14089d = motionEvent.getActionMasked();
        return true;
    }
}
