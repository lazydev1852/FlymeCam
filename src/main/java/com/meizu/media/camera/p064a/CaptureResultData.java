package com.meizu.media.camera.p064a;

import android.hardware.camera2.TotalCaptureResult;
import java.io.Serializable;

/* renamed from: com.meizu.media.camera.a.b */
public class CaptureResultData implements Serializable {

    /* renamed from: a */
    private TotalCaptureResult f7455a;

    public CaptureResultData(TotalCaptureResult totalCaptureResult) {
        this.f7455a = totalCaptureResult;
    }

    /* renamed from: a */
    public TotalCaptureResult mo18718a() {
        return this.f7455a;
    }
}
