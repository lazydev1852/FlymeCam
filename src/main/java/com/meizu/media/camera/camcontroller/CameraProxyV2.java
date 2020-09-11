package com.meizu.media.camera.camcontroller;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import com.meizu.media.camera.app.AndroidContext;
import com.meizu.media.camera.util.DeviceHelper;

/* renamed from: com.meizu.media.camera.camcontroller.f */
public class CameraProxyV2 extends CameraProxy<CameraDevice> {
    static {
        try {
            f9121e = ((CameraManager) AndroidContext.m8284a().mo19002b().getSystemService("camera")).getCameraIdList().length;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public CameraProxyV2(int i, CameraDevice cameraDevice) {
        super(i, cameraDevice);
    }

    /* renamed from: e */
    public float mo19751e() {
        int i = this.f9122a;
        if (i > 2) {
            i = 0;
        }
        return DeviceHelper.f14020dl[i];
    }
}
