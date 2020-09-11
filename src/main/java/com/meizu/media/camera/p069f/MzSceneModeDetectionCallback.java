package com.meizu.media.camera.p069f;

import android.os.Build;
import com.meizu.camera.MeizuCamera;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.MzCamModule;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo27294d2 = {"Lcom/meizu/media/camera/impl/MzSceneModeDetectionCallback;", "Lcom/meizu/camera/MeizuCamera$MeizuSceneModeDetectionCallback;", "mCamModule", "Lcom/meizu/media/camera/MzCamModule;", "(Lcom/meizu/media/camera/MzCamModule;)V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "onSceneModeDetection", "", "msgType", "", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.f.m */
public final class MzSceneModeDetectionCallback implements MeizuCamera.MeizuSceneModeDetectionCallback {

    /* renamed from: a */
    public static ChangeQuickRedirect f10021a;

    /* renamed from: b */
    private final LogUtil.C2630a f10022b = new LogUtil.C2630a("SceneModeCallback");

    /* renamed from: c */
    private final MzCamModule f10023c;

    public MzSceneModeDetectionCallback(@NotNull MzCamModule mzCamModule) {
        C3443i.m21155b(mzCamModule, "mCamModule");
        this.f10023c = mzCamModule;
    }

    public void onSceneModeDetection(int i) {
        MzUIController aU;
        boolean z = false;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f10021a, false, 4461, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = this.f10022b;
            LogUtil.m15942a(aVar, "MzCamera SceneMode callback. msgType=" + i);
            if (DeviceHelper.f13854aG && this.f10023c.mo18036aU() != null && (aU = this.f10023c.mo18036aU()) != null) {
                aU.mo21564b(i);
                aU.mo21637u();
                if (DeviceHelper.f14041k) {
                    if (DeviceHelper.f13910bJ != CameraController.CameraApi.API1 ? !(Build.VERSION.SDK_INT < 23 || i < 1) : i == 302) {
                        z = true;
                    }
                    CameraOptTask.m8384b(z);
                }
            }
        }
    }
}
