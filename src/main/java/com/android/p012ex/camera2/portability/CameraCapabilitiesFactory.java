package com.android.p012ex.camera2.portability;

import android.hardware.camera2.CameraCharacteristics;
import com.android.p012ex.camera2.portability.p014a.Log;

/* renamed from: com.android.ex.camera2.portability.b */
public class CameraCapabilitiesFactory {

    /* renamed from: a */
    private static Log.C0440a f282a = new Log.C0440a("CamCapabsFact");

    /* renamed from: a */
    public static CameraCapabilities m561a(CameraCharacteristics cameraCharacteristics) {
        if (cameraCharacteristics != null) {
            return new AndroidCamera2Capabilities(cameraCharacteristics);
        }
        Log.m559b(f282a, "Null characteristics passed in.");
        return null;
    }
}
