package com.meizu.media.camera.mode;

import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.mode.g */
public final class CameraModeFactory {

    /* renamed from: a */
    public static ChangeQuickRedirect f10790a;

    /* renamed from: a */
    public static CameraMode m11401a(CameraModeType.ModeType modeType, CameraActivity cameraActivity, MzCamParamsManager lVar, MzUIController uVar, CameraModeListener hVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{modeType, cameraActivity, lVar, uVar, hVar}, (Object) null, f10790a, true, 4695, new Class[]{CameraModeType.ModeType.class, CameraActivity.class, MzCamParamsManager.class, MzUIController.class, CameraModeListener.class}, CameraMode.class);
        if (proxy.isSupported) {
            return (CameraMode) proxy.result;
        }
        switch (modeType) {
            case AUTO:
                return new AutoMode(cameraActivity, lVar, uVar, hVar, modeType);
            case MANUAL:
                return new ManualMode(cameraActivity, lVar, uVar, hVar, modeType);
            case MACRO:
                return new MacroMode(cameraActivity, lVar, uVar, hVar, modeType);
            case BARCODE:
                return new BarCodeMode(cameraActivity, lVar, uVar, hVar, modeType);
            case PANORAMA:
                return new PanoramaMode(cameraActivity, lVar, uVar, hVar, modeType);
            case REFOCUS:
                return new RefocusMode(cameraActivity, lVar, uVar, hVar, modeType);
            case SLOWMOTION:
                return new VideoMode(cameraActivity, lVar, uVar, hVar, modeType, true, false);
            case VIDEO:
                return new VideoMode(cameraActivity, lVar, uVar, hVar, modeType, false, false);
            case TIMELAPSE:
                return new VideoMode(cameraActivity, lVar, uVar, hVar, modeType, false, true);
            case GIF:
                return new GifMode(cameraActivity, lVar, uVar, hVar, modeType);
            case MAKEUP:
                return new MakeupMode(cameraActivity, lVar, uVar, hVar, modeType);
            case SQUARE:
                return new SquareMode(cameraActivity, lVar, uVar, hVar, modeType);
            case BLACK_WHITE:
                return new BlackWhiteMode(cameraActivity, lVar, uVar, hVar, modeType);
            case PORTRAIT:
                return new PortraitMode(cameraActivity, lVar, uVar, hVar, modeType);
            case FUNNY_SNAP:
                return new FunnySnapMode(cameraActivity, lVar, uVar, hVar, modeType);
            case BACK_TRACE:
                return new BackTraceMode(cameraActivity, lVar, uVar, hVar, modeType);
            case SUPER_NIGHT:
                return new SuperNightMode(cameraActivity, lVar, uVar, hVar, modeType);
            case AR:
                return new ARMode(cameraActivity, lVar, uVar, hVar, modeType);
            case DOCUMENT:
                return new DocumentMode(cameraActivity, lVar, uVar, hVar, modeType);
            case BACK_LIGHTING:
                return new BackLightingMode(cameraActivity, lVar, uVar, hVar, modeType);
            case TOF:
                return new TofMode(cameraActivity, lVar, uVar, hVar, modeType);
            case NightVision:
                return new NightVisionMode(cameraActivity, lVar, uVar, hVar, modeType);
            default:
                return new AutoMode(cameraActivity, lVar, uVar, hVar, modeType);
        }
    }
}
