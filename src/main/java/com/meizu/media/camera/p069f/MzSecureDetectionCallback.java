package com.meizu.media.camera.p069f;

import com.meizu.camera.MeizuCamera;
import com.meizu.media.camera.MzCamModule;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo27294d2 = {"Lcom/meizu/media/camera/impl/MzSecureDetectionCallback;", "Lcom/meizu/camera/MeizuCamera$MeizuSecureDetectionCallback;", "mCamModule", "Lcom/meizu/media/camera/MzCamModule;", "(Lcom/meizu/media/camera/MzCamModule;)V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "onSecureDetection", "", "msgType", "", "temperature", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.f.n */
public final class MzSecureDetectionCallback implements MeizuCamera.MeizuSecureDetectionCallback {

    /* renamed from: a */
    public static ChangeQuickRedirect f10024a;

    /* renamed from: b */
    private final LogUtil.C2630a f10025b = new LogUtil.C2630a("SecureCallback");

    /* renamed from: c */
    private final MzCamModule f10026c;

    public MzSecureDetectionCallback(@NotNull MzCamModule mzCamModule) {
        C3443i.m21155b(mzCamModule, "mCamModule");
        this.f10026c = mzCamModule;
    }

    public void onSecureDetection(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f10024a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4462, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported && !this.f10026c.mo18032aQ()) {
            LogUtil.C2630a aVar = this.f10025b;
            LogUtil.m15952c(aVar, "MzCamera secure callback. msgType=" + i + " status=" + i2);
            MzUIController aU = this.f10026c.mo18036aU();
            if (aU != null) {
                aU.mo21565b(i, i2);
            }
        }
    }
}
