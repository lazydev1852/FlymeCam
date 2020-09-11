package com.meizu.media.camera.p077ui;

import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzCommonUI;
import com.meizu.media.camera.util.CameraUtil;
import kotlin.Metadata;

@Metadata(mo27292bv = {1, 0, 3}, mo27295k = 3, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.ui.k */
public final /* synthetic */ class C2529k {

    /* renamed from: a */
    public static final /* synthetic */ int[] f13271a = new int[MzCommonUI.SmbButton.values().length];

    /* renamed from: b */
    public static final /* synthetic */ int[] f13272b = new int[CameraUtil.ScreeAspectRatio.values().length];

    /* renamed from: c */
    public static final /* synthetic */ int[] f13273c = new int[LensSwitchIcon.values().length];

    /* renamed from: d */
    public static final /* synthetic */ int[] f13274d = new int[CameraModeType.ModeType.values().length];

    /* renamed from: e */
    public static final /* synthetic */ int[] f13275e = new int[CameraModeType.ModeType.values().length];

    static {
        f13271a[MzCommonUI.SmbButton.SMB_CURRENT.ordinal()] = 1;
        f13271a[MzCommonUI.SmbButton.SMB_FLASH.ordinal()] = 2;
        f13271a[MzCommonUI.SmbButton.SMB_HDR.ordinal()] = 3;
        f13271a[MzCommonUI.SmbButton.SMB_FILTER.ordinal()] = 4;
        f13271a[MzCommonUI.SmbButton.SMB_FB.ordinal()] = 5;
        f13272b[CameraUtil.ScreeAspectRatio.Ratio_18X_9_FullScreen.ordinal()] = 1;
        f13272b[CameraUtil.ScreeAspectRatio.Ratio_18_9.ordinal()] = 2;
        f13272b[CameraUtil.ScreeAspectRatio.Ratio_16_9.ordinal()] = 3;
        f13272b[CameraUtil.ScreeAspectRatio.Ratio_4_3.ordinal()] = 4;
        f13272b[CameraUtil.ScreeAspectRatio.Ratio_3_2.ordinal()] = 5;
        f13272b[CameraUtil.ScreeAspectRatio.Ratio_Unknow.ordinal()] = 6;
        f13273c[LensSwitchIcon.ICON_SUPER_WIDE_ANGLE.ordinal()] = 1;
        f13273c[LensSwitchIcon.ICON_WIDE_ANGLE.ordinal()] = 2;
        f13273c[LensSwitchIcon.ICON_TELEPHOTO.ordinal()] = 3;
        f13274d[CameraModeType.ModeType.TIMELAPSE.ordinal()] = 1;
        f13274d[CameraModeType.ModeType.BACK_TRACE.ordinal()] = 2;
        f13275e[CameraModeType.ModeType.TIMELAPSE.ordinal()] = 1;
        f13275e[CameraModeType.ModeType.BACK_TRACE.ordinal()] = 2;
    }
}
