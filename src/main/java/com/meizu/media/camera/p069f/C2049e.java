package com.meizu.media.camera.p069f;

import com.meizu.media.camera.MzCamController;
import com.meizu.media.camera.util.Contants;
import kotlin.Metadata;

@Metadata(mo27292bv = {1, 0, 3}, mo27295k = 3, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.f.e */
public final /* synthetic */ class C2049e {

    /* renamed from: a */
    public static final /* synthetic */ int[] f9952a = new int[MzCamController.ModuleState.values().length];

    /* renamed from: b */
    public static final /* synthetic */ int[] f9953b = new int[Contants.CameraService.RequestCode.values().length];

    /* renamed from: c */
    public static final /* synthetic */ int[] f9954c = new int[Contants.CameraService.ResultCode.values().length];

    /* renamed from: d */
    public static final /* synthetic */ int[] f9955d = new int[Contants.CameraService.ResultCode.values().length];

    /* renamed from: e */
    public static final /* synthetic */ int[] f9956e = new int[Contants.CameraService.ResultCode.values().length];

    /* renamed from: f */
    public static final /* synthetic */ int[] f9957f = new int[Contants.CameraService.ResultCode.values().length];

    /* renamed from: g */
    public static final /* synthetic */ int[] f9958g = new int[Contants.CameraService.ResultCode.values().length];

    /* renamed from: h */
    public static final /* synthetic */ int[] f9959h = new int[Contants.CameraService.ResultCode.values().length];

    /* renamed from: i */
    public static final /* synthetic */ int[] f9960i = new int[Contants.CameraService.RequestCode.values().length];

    static {
        f9952a[MzCamController.ModuleState.SWITCHING_MODE.ordinal()] = 1;
        f9952a[MzCamController.ModuleState.SWITCHING_CAMERA.ordinal()] = 2;
        f9953b[Contants.CameraService.RequestCode.REQUEST_CODE_RESUME_CAMERA.ordinal()] = 1;
        f9953b[Contants.CameraService.RequestCode.REQUEST_CODE_SWITCH_CAMERA.ordinal()] = 2;
        f9954c[Contants.CameraService.ResultCode.RESULT_CAMERA_CLOSED.ordinal()] = 1;
        f9954c[Contants.CameraService.ResultCode.RESULT_CAMERA_OPENED.ordinal()] = 2;
        f9954c[Contants.CameraService.ResultCode.RESULT_START_PREVIEW_DONE.ordinal()] = 3;
        f9954c[Contants.CameraService.ResultCode.RESULT_NULL_CAMERA.ordinal()] = 4;
        f9954c[Contants.CameraService.ResultCode.RESULT_CANCEL.ordinal()] = 5;
        f9954c[Contants.CameraService.ResultCode.RESULT_CANCEL_START_PREVIEW.ordinal()] = 6;
        f9954c[Contants.CameraService.ResultCode.RESULT_KILL_SELF.ordinal()] = 7;
        f9954c[Contants.CameraService.ResultCode.RESULT_OPEN_CAMERA_FAILURE.ordinal()] = 8;
        f9954c[Contants.CameraService.ResultCode.RESULT_CAMERA_CLOSE_START.ordinal()] = 9;
        f9954c[Contants.CameraService.ResultCode.RESULT_FACE_DETECTION_STOPED.ordinal()] = 10;
        f9955d[Contants.CameraService.ResultCode.RESULT_NULL_CAMERA.ordinal()] = 1;
        f9955d[Contants.CameraService.ResultCode.RESULT_CANCEL.ordinal()] = 2;
        f9955d[Contants.CameraService.ResultCode.RESULT_STOP_PREVIEW_DONE.ordinal()] = 3;
        f9955d[Contants.CameraService.ResultCode.RESULT_START_PREVIEW_DONE.ordinal()] = 4;
        f9956e[Contants.CameraService.ResultCode.RESULT_CAMERA_CLOSED.ordinal()] = 1;
        f9956e[Contants.CameraService.ResultCode.RESULT_FACE_DETECTION_STOPED.ordinal()] = 2;
        f9956e[Contants.CameraService.ResultCode.RESULT_CAMERA_CLOSE_START.ordinal()] = 3;
        f9957f[Contants.CameraService.ResultCode.RESULT_SHUTTER_CALLBACK.ordinal()] = 1;
        f9957f[Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_CANCEL.ordinal()] = 2;
        f9957f[Contants.CameraService.ResultCode.RESULT_PICTURE_POSTVIEW_CALLBACK.ordinal()] = 3;
        f9957f[Contants.CameraService.ResultCode.RESULT_ON_PICTURE_TOKEN_CALLBACK.ordinal()] = 4;
        f9957f[Contants.CameraService.ResultCode.RESULT_CREATE_PICTURE_THUMBNAIL.ordinal()] = 5;
        f9957f[Contants.CameraService.ResultCode.RESULT_ON_GET_THUMBNAIL.ordinal()] = 6;
        f9957f[Contants.CameraService.ResultCode.RESULT_ON_FILE_SAVED.ordinal()] = 7;
        f9957f[Contants.CameraService.ResultCode.RESULT_ON_MEDIA_SAVED.ordinal()] = 8;
        f9957f[Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED.ordinal()] = 9;
        f9957f[Contants.CameraService.ResultCode.REQUEST_CODE_TAKE_PICTURE_START.ordinal()] = 10;
        f9958g[Contants.CameraService.ResultCode.RESULT_SHUTTER_CALLBACK.ordinal()] = 1;
        f9958g[Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_CANCEL.ordinal()] = 2;
        f9958g[Contants.CameraService.ResultCode.RESULT_ON_PICTURE_TOKEN_CALLBACK.ordinal()] = 3;
        f9958g[Contants.CameraService.ResultCode.RESULT_CREATE_PICTURE_THUMBNAIL.ordinal()] = 4;
        f9958g[Contants.CameraService.ResultCode.RESULT_ON_GET_THUMBNAIL.ordinal()] = 5;
        f9958g[Contants.CameraService.ResultCode.RESULT_ON_FILE_SAVED.ordinal()] = 6;
        f9958g[Contants.CameraService.ResultCode.RESULT_ON_MEDIA_SAVED.ordinal()] = 7;
        f9958g[Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED.ordinal()] = 8;
        f9958g[Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED.ordinal()] = 9;
        f9958g[Contants.CameraService.ResultCode.RESULT_UPDATE_WATCH_THUMBNAIL.ordinal()] = 10;
        f9958g[Contants.CameraService.ResultCode.REQUEST_CODE_TAKE_PICTURE_START.ordinal()] = 11;
        f9959h[Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED.ordinal()] = 1;
        f9959h[Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_CANCEL.ordinal()] = 2;
        f9959h[Contants.CameraService.ResultCode.RESULT_SHUTTER_CALLBACK.ordinal()] = 3;
        f9959h[Contants.CameraService.ResultCode.RESULT_CREATE_PICTURE_THUMBNAIL.ordinal()] = 4;
        f9959h[Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED.ordinal()] = 5;
        f9959h[Contants.CameraService.ResultCode.RESULT_ON_PICTURE_TOKEN_CALLBACK.ordinal()] = 6;
        f9959h[Contants.CameraService.ResultCode.RESULT_ON_FILE_SAVED.ordinal()] = 7;
        f9959h[Contants.CameraService.ResultCode.RESULT_ON_MEDIA_SAVED.ordinal()] = 8;
        f9959h[Contants.CameraService.ResultCode.RESULT_PICTURE_POSTVIEW_CALLBACK.ordinal()] = 9;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_SWITCH_CAMERA.ordinal()] = 1;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_RESUME_CAMERA.ordinal()] = 2;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_SET_PREVIEW_TEXTURE.ordinal()] = 3;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_RESTART_PREVIEW.ordinal()] = 4;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_START_PREVIEW.ordinal()] = 5;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_STOP_PREVIEW.ordinal()] = 6;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_RESTART_PREVIEW_FOR_MODE_CHANGE.ordinal()] = 7;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_CLOSE_CAMERA.ordinal()] = 8;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_START_FACE_DETECTION.ordinal()] = 9;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_STOP_FACE_DETECTION.ordinal()] = 10;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_MFLL_PICTURE.ordinal()] = 11;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_HDR_AND_MFLL_PICTURE.ordinal()] = 12;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_HDR_PICTURE.ordinal()] = 13;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_SUPER_NIGHT_PICTURE.ordinal()] = 14;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_PICTURE.ordinal()] = 15;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_AUTO_FOCUS.ordinal()] = 16;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_CANCEL_AUTO_FOCUS.ordinal()] = 17;
        f9960i[Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_TOF_PICTURE.ordinal()] = 18;
    }
}
