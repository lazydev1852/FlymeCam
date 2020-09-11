package com.meizu.media.camera.p069f;

import android.os.Build;
import android.os.SystemClock;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.MzCamModule;
import com.meizu.media.camera.SoundClips;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.CameraSizeUtil;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J'\u0010\n\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\f\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo27294d2 = {"Lcom/meizu/media/camera/impl/CamOpenedTask;", "Lcom/meizu/media/camera/util/AsyncTaskEx;", "Ljava/lang/Void;", "mCamModule", "Lcom/meizu/media/camera/MzCamModule;", "mRequestCode", "Lcom/meizu/media/camera/util/Contants$CameraService$RequestCode;", "(Lcom/meizu/media/camera/MzCamModule;Lcom/meizu/media/camera/util/Contants$CameraService$RequestCode;)V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Void;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.f.h */
public final class CamOpenedTask extends AsyncTaskEx<Void, Void, Void> {

    /* renamed from: a */
    public static ChangeQuickRedirect f9976a;

    /* renamed from: b */
    private final LogUtil.C2630a f9977b = new LogUtil.C2630a("CamOpenedTask");

    /* renamed from: c */
    private final MzCamModule f9978c;

    /* renamed from: d */
    private final Contants.CameraService.RequestCode f9979d;

    public CamOpenedTask(@NotNull MzCamModule mzCamModule, @NotNull Contants.CameraService.RequestCode requestCode) {
        C3443i.m21155b(mzCamModule, "mCamModule");
        C3443i.m21155b(requestCode, "mRequestCode");
        this.f9978c = mzCamModule;
        this.f9979d = requestCode;
    }

    @Nullable
    /* renamed from: a */
    public Void mo17658a(@NotNull Void... voidArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f9976a, false, 4312, new Class[]{Void[].class}, Void.class);
        if (proxy.isSupported) {
            return (Void) proxy.result;
        }
        C3443i.m21155b(voidArr, "params");
        LogUtil.m15942a(this.f9977b, "CamOpenedTask doInBackground start");
        if (mo22615d()) {
            return null;
        }
        boolean z = (CameraModeType.m10946a() == null || CameraModeType.m10946a() == CameraModeType.ModeType.AUTO || !this.f9978c.mo17898aA()) ? false : true;
        if (mo22615d()) {
            return null;
        }
        LogUtil.C2630a aVar = this.f9977b;
        LogUtil.m15942a(aVar, " === isStereoOn " + z);
        CameraSizeUtil.m16177a(CameraModeType.m10983m(CameraModeType.ModeType.FUNNY_SNAP));
        this.f9978c.mo17984X(z);
        if (!mo22615d() && this.f9978c.mo18110br() != null) {
            CameraController g = CameraController.m8868g();
            C3443i.m21152a((Object) g, "CameraController.getInstance()");
            if (g.mo19522k() != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    if (this.f9978c.mo18076bJ() && this.f9978c.mo18176d()) {
                        CameraController g2 = CameraController.m8868g();
                        C3443i.m21152a((Object) g2, "CameraController.getInstance()");
                        if (g2.mo19522k() != null && DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                            this.f9978c.mo18126cD();
                        }
                    }
                    this.f9978c.mo18110br().sendEmptyMessage(25);
                } else {
                    if (this.f9978c.mo18076bJ() && this.f9978c.mo18119c() != null) {
                        CameraController g3 = CameraController.m8868g();
                        C3443i.m21152a((Object) g3, "CameraController.getInstance()");
                        if (g3.mo19522k() != null && DeviceHelper.f13910bJ == CameraController.CameraApi.API2) {
                            this.f9978c.mo18126cD();
                        }
                    }
                    this.f9978c.mo18110br().sendEmptyMessage(25);
                }
                LogUtil.m15942a(this.f9977b, "CamOpenedTask doInBackground start 2");
                if (mo22615d() || this.f9978c.mo18110br() == null) {
                    return null;
                }
                this.f9978c.mo18061b(SystemClock.uptimeMillis());
                if (mo22615d()) {
                    return null;
                }
                DeviceUtil.m16193a(this.f9978c.mo18040aY());
                if (this.f9978c.mo18030aO() != null && (!this.f9978c.mo18032aQ() || this.f9978c.mo18072bF())) {
                    if (this.f9978c.mo18071bE() == null) {
                        MzCamModule mzCamModule = this.f9978c;
                        CameraActivity aO = this.f9978c.mo18030aO();
                        if (aO == null) {
                            C3443i.m21151a();
                        }
                        mzCamModule.mo18007a(SoundClips.m7934a(aO.getApplicationContext()));
                    }
                    if (!DeviceUtil.m16200b()) {
                        CameraController g4 = CameraController.m8868g();
                        C3443i.m21152a((Object) g4, "CameraController.getInstance()");
                        if (g4.mo19522k() != null) {
                            CameraController.m8868g().mo19475a(false);
                        }
                    } else if (DeviceHelper.f13838R) {
                        CameraController g5 = CameraController.m8868g();
                        C3443i.m21152a((Object) g5, "CameraController.getInstance()");
                        if (g5.mo19522k() != null && !CameraModeType.m10955c()) {
                            CameraController.m8868g().mo19475a(true);
                        }
                    }
                }
                LogUtil.m15942a(this.f9977b, "CamOpenedTask doInBackground end");
                return null;
            }
        }
        return null;
    }
}
