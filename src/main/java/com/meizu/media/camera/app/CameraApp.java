package com.meizu.media.camera.app;

import android.app.Application;
import android.content.Context;
import com.meizu.camera.effectlib.effects.views.EffectRenderFactory;
import com.meizu.common.renderer.effect.GLRenderer;
import com.meizu.media.camera.Reflection;
import com.meizu.media.camera.camcontroller.CameraControllerFactory;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class CameraApp extends Application {

    /* renamed from: a */
    public static ChangeQuickRedirect f7899a;

    /* renamed from: b */
    private static final LogUtil.C2630a f7900b = new LogUtil.C2630a("CameraApp");

    public int mzNightModeUseOf() {
        return -1;
    }

    public void onCreate() {
        if (!PatchProxy.proxy(new Object[0], this, f7899a, false, 2514, new Class[0], Void.TYPE).isSupported) {
            super.onCreate();
            AndroidContext.m8285a(this);
            DeviceHelper.m15928b();
            CameraControllerFactory.m9400a(DeviceHelper.f13910bJ, this);
            m8254a(this);
            CameraUtil.m15843a((Context) this);
            Reflection.f14431b.mo22796a((Context) this);
            GLRenderer.m5029a((Context) this);
        }
    }

    public void onTrimMemory(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f7899a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2515, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            super.onTrimMemory(i);
            GLRenderer.m5034c();
            LogUtil.C2630a aVar = f7900b;
            LogUtil.m15954d(aVar, "onTrimMemory level = " + i);
        }
    }

    /* renamed from: a */
    private void m8254a(Context context) {
        int i;
        if (!PatchProxy.proxy(new Object[]{context}, this, f7899a, false, 2516, new Class[]{Context.class}, Void.TYPE).isSupported) {
            if (DeviceHelper.f13840T) {
                i = 3;
            } else {
                i = DeviceHelper.f13841U ? 2 : 1;
            }
            EffectRenderFactory.m4740a(context, DeviceHelper.f14008dB, i, DeviceHelper.f13904bD, DeviceHelper.f13905bE, DeviceHelper.f13886am);
        }
    }
}
