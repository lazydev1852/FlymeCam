package com.meizu.media.camera.simplify;

import com.meizu.media.camera.simplify.MzSimplifyCommonUI;
import com.meizu.media.camera.util.CameraUtil;
import kotlin.Metadata;

@Metadata(mo27292bv = {1, 0, 3}, mo27295k = 3, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.simplify.e */
public final /* synthetic */ class C2328e {

    /* renamed from: a */
    public static final /* synthetic */ int[] f11924a = new int[MzSimplifyCommonUI.SmbButton.values().length];

    /* renamed from: b */
    public static final /* synthetic */ int[] f11925b = new int[CameraUtil.ScreeAspectRatio.values().length];

    static {
        f11924a[MzSimplifyCommonUI.SmbButton.SMB_CURRENT.ordinal()] = 1;
        f11924a[MzSimplifyCommonUI.SmbButton.SMB_FLASH.ordinal()] = 2;
        f11924a[MzSimplifyCommonUI.SmbButton.SMB_HDR.ordinal()] = 3;
        f11924a[MzSimplifyCommonUI.SmbButton.SMB_FILTER.ordinal()] = 4;
        f11924a[MzSimplifyCommonUI.SmbButton.SMB_FB.ordinal()] = 5;
        f11925b[CameraUtil.ScreeAspectRatio.Ratio_18X_9_FullScreen.ordinal()] = 1;
        f11925b[CameraUtil.ScreeAspectRatio.Ratio_18_9.ordinal()] = 2;
        f11925b[CameraUtil.ScreeAspectRatio.Ratio_16_9.ordinal()] = 3;
        f11925b[CameraUtil.ScreeAspectRatio.Ratio_4_3.ordinal()] = 4;
        f11925b[CameraUtil.ScreeAspectRatio.Ratio_3_2.ordinal()] = 5;
        f11925b[CameraUtil.ScreeAspectRatio.Ratio_Unknow.ordinal()] = 6;
    }
}
