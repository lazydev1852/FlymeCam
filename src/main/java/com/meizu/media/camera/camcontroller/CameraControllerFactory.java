package com.meizu.media.camera.camcontroller;

import android.content.Context;
import android.os.Build;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.camcontroller.a */
public class CameraControllerFactory {

    /* renamed from: a */
    public static ChangeQuickRedirect f8702a;

    /* renamed from: a */
    public static CameraController m9400a(CameraController.CameraApi cameraApi, Context context) {
        ChangeQuickRedirect changeQuickRedirect = f8702a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cameraApi, context}, (Object) null, changeQuickRedirect, true, 2760, new Class[]{CameraController.CameraApi.class, Context.class}, CameraController.class);
        if (proxy.isSupported) {
            return (CameraController) proxy.result;
        }
        CameraController cameraController = null;
        if (cameraApi == CameraController.CameraApi.API1) {
            cameraController = CameraControllerV1.m9425af();
        } else if (Build.VERSION.SDK_INT >= 23) {
            cameraController = CameraControllerV2.m9111af();
        }
        cameraController.mo19452a(context);
        CameraController.m8866a(cameraController);
        return cameraController;
    }
}
