package com.meizu.media.camera;

import com.meizu.media.camera.MzCamController;
import kotlin.Metadata;

@Metadata(mo27292bv = {1, 0, 3}, mo27295k = 3, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.k */
public final /* synthetic */ class C2137k {

    /* renamed from: a */
    public static final /* synthetic */ int[] f10475a = new int[MzCamController.ModuleState.values().length];

    static {
        f10475a[MzCamController.ModuleState.IDLE.ordinal()] = 1;
        f10475a[MzCamController.ModuleState.SWITCHING_MODE.ordinal()] = 2;
        f10475a[MzCamController.ModuleState.SWITCHING_CAMERA.ordinal()] = 3;
    }
}
