package com.android.p012ex.camera2.portability;

import com.android.p012ex.camera2.portability.p014a.Log;
import com.android.p012ex.camera2.portability.p015b.SystemProperties;

/* renamed from: com.android.ex.camera2.portability.CameraAgentFactory */
public class CameraAgentFactory {

    /* renamed from: a */
    private static final Log.C0440a f255a = new Log.C0440a("CamAgntFact");

    /* renamed from: b */
    private static final String f256b = SystemProperties.m562a("camera2.portability.force_api", "0");

    /* renamed from: com.android.ex.camera2.portability.CameraAgentFactory$CameraApi */
    public enum CameraApi {
        AUTO,
        API_1,
        API_2
    }
}
