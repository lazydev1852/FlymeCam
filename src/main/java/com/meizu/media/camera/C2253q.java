package com.meizu.media.camera;

import com.meizu.media.camera.simplify.MzSimplifyCamController;
import com.meizu.media.camera.util.Contants;
import kotlin.Metadata;

@Metadata(mo27292bv = {1, 0, 3}, mo27295k = 3, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.q */
public final /* synthetic */ class C2253q {

    /* renamed from: a */
    public static final /* synthetic */ int[] f11410a = new int[Contants.CameraService.RequestCode.values().length];

    /* renamed from: b */
    public static final /* synthetic */ int[] f11411b = new int[MzSimplifyCamController.ModuleState.values().length];

    static {
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_SWITCH_CAMERA.ordinal()] = 1;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_RESUME_CAMERA.ordinal()] = 2;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_SET_PREVIEW_TEXTURE.ordinal()] = 3;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_RESTART_PREVIEW.ordinal()] = 4;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_START_PREVIEW.ordinal()] = 5;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_STOP_PREVIEW.ordinal()] = 6;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_RESTART_PREVIEW_FOR_MODE_CHANGE.ordinal()] = 7;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_CLOSE_CAMERA.ordinal()] = 8;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_START_FACE_DETECTION.ordinal()] = 9;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_STOP_FACE_DETECTION.ordinal()] = 10;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_MFLL_PICTURE.ordinal()] = 11;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_HDR_AND_MFLL_PICTURE.ordinal()] = 12;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_HDR_PICTURE.ordinal()] = 13;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_SUPER_NIGHT_PICTURE.ordinal()] = 14;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_PICTURE.ordinal()] = 15;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_AUTO_FOCUS.ordinal()] = 16;
        f11410a[Contants.CameraService.RequestCode.REQUEST_CODE_CANCEL_AUTO_FOCUS.ordinal()] = 17;
        f11411b[MzSimplifyCamController.ModuleState.IDLE.ordinal()] = 1;
        f11411b[MzSimplifyCamController.ModuleState.SWITCHING_MODE.ordinal()] = 2;
        f11411b[MzSimplifyCamController.ModuleState.SWITCHING_CAMERA.ordinal()] = 3;
    }
}
