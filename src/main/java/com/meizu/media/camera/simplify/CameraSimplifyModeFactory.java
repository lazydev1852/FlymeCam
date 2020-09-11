package com.meizu.media.camera.simplify;

import com.meizu.media.camera.CameraSimplifyActivity;
import com.meizu.media.camera.MzSimplifyCamModule;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.simplify.a */
public final class CameraSimplifyModeFactory {

    /* renamed from: a */
    public static ChangeQuickRedirect f11722a;

    /* renamed from: a */
    public static SimplifyCameraMode m12783a(CameraModeType.ModeType modeType, CameraSimplifyActivity cameraSimplifyActivity, MzSimplifyCamParamsManager cVar, MzSimplifyUIController jVar, MzSimplifyCamModule mzSimplifyCamModule) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType, cameraSimplifyActivity, cVar, jVar, mzSimplifyCamModule}, (Object) null, f11722a, true, 5410, new Class[]{CameraModeType.ModeType.class, CameraSimplifyActivity.class, MzSimplifyCamParamsManager.class, MzSimplifyUIController.class, MzSimplifyCamModule.class}, SimplifyCameraMode.class);
        if (proxy.isSupported) {
            return (SimplifyCameraMode) proxy.result;
        }
        switch (modeType) {
            case AUTO:
                return new SimplifyAutoMode(cameraSimplifyActivity, cVar, jVar, mzSimplifyCamModule, modeType);
            case VIDEO:
                return new SimplifyVideoMode(cameraSimplifyActivity, cVar, jVar, mzSimplifyCamModule, modeType, false, false);
            default:
                return new SimplifyAutoMode(cameraSimplifyActivity, cVar, jVar, mzSimplifyCamModule, modeType);
        }
    }
}
