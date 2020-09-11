package com.meizu.media.camera.p069f;

import com.meizu.media.camera.MzBurstHandler;
import com.meizu.media.camera.MzCamModule;
import com.meizu.media.camera.MzFacebeautyManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.p077ui.MzCamUI;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00020\u000e\"\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, mo27294d2 = {"Lcom/meizu/media/camera/impl/CamModuleBurstListenerImpl;", "Lcom/meizu/media/camera/MzBurstHandler$Listener;", "()V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "mCamModule", "Lcom/meizu/media/camera/MzCamModule;", "getMCamModule", "()Lcom/meizu/media/camera/MzCamModule;", "setMCamModule", "(Lcom/meizu/media/camera/MzCamModule;)V", "onBurstCaptureFinish", "", "needSetStateToIdle", "", "", "onBurstCaptureStart", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.f.b */
public final class CamModuleBurstListenerImpl implements MzBurstHandler.C2136c {

    /* renamed from: a */
    public static ChangeQuickRedirect f9931a;
    @NotNull

    /* renamed from: b */
    public MzCamModule f9932b;

    /* renamed from: c */
    private final LogUtil.C2630a f9933c = new LogUtil.C2630a("BurstLisImpl");

    /* renamed from: a */
    public final void mo20014a(@NotNull MzCamModule mzCamModule) {
        if (!PatchProxy.proxy(new Object[]{mzCamModule}, this, f9931a, false, 4192, new Class[]{MzCamModule.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(mzCamModule, "<set-?>");
            this.f9932b = mzCamModule;
        }
    }

    /* renamed from: a */
    public void mo18019a(@NotNull boolean... zArr) {
        if (!PatchProxy.proxy(new Object[]{zArr}, this, f9931a, false, 4193, new Class[]{boolean[].class}, Void.TYPE).isSupported) {
            C3443i.m21155b(zArr, "needSetStateToIdle");
            MzCamModule mzCamModule = this.f9932b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzFacebeautyManager aK = mzCamModule.mo18026aK();
            if (aK == null) {
                C3443i.m21151a();
            }
            aK.mo20775e();
            MzCamModule mzCamModule2 = this.f9932b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule2.mo18122c(Arrays.copyOf(zArr, zArr.length));
            if (DeviceHelper.f13910bJ == CameraController.CameraApi.API1) {
                MzCamModule mzCamModule3 = this.f9932b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzCamUI u = mzCamModule3.mo18267u();
                if (u == null) {
                    C3443i.m21151a();
                }
                u.mo22142b(true);
            }
            MzCamModule mzCamModule4 = this.f9932b;
            if (mzCamModule4 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU = mzCamModule4.mo18036aU();
            if (aU == null) {
                C3443i.m21151a();
            }
            if (!aU.mo21649z()) {
                MzCamModule mzCamModule5 = this.f9932b;
                if (mzCamModule5 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (mzCamModule5.mo17873V()) {
                    MzCamModule mzCamModule6 = this.f9932b;
                    if (mzCamModule6 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    MzCamUI u2 = mzCamModule6.mo18267u();
                    if (u2 == null) {
                        C3443i.m21151a();
                    }
                    u2.mo22086a(true, 1);
                }
            }
            MzCamModule mzCamModule7 = this.f9932b;
            if (mzCamModule7 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule7.mo18144cV();
        }
    }

    /* renamed from: v */
    public void mo18270v() {
        if (!PatchProxy.proxy(new Object[0], this, f9931a, false, 4194, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9932b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzFacebeautyManager aK = mzCamModule.mo18026aK();
            if (aK == null) {
                C3443i.m21151a();
            }
            aK.mo20773d();
            MzCamModule mzCamModule2 = this.f9932b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule2.mo18230ea();
            MzCamModule mzCamModule3 = this.f9932b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzUIController aU = mzCamModule3.mo18036aU();
            if (aU == null) {
                C3443i.m21151a();
            }
            aU.mo21498U();
            MzCamModule mzCamModule4 = this.f9932b;
            if (mzCamModule4 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule4.mo17872U()) {
                MzCamModule mzCamModule5 = this.f9932b;
                if (mzCamModule5 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzCamUI u = mzCamModule5.mo18267u();
                if (u == null) {
                    C3443i.m21151a();
                }
                u.mo22142b(false);
                MzCamModule mzCamModule6 = this.f9932b;
                if (mzCamModule6 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzCamUI u2 = mzCamModule6.mo18267u();
                if (u2 == null) {
                    C3443i.m21151a();
                }
                u2.mo22086a(false, 0);
                MzCamModule mzCamModule7 = this.f9932b;
                if (mzCamModule7 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzUIController aU2 = mzCamModule7.mo18036aU();
                if (aU2 == null) {
                    C3443i.m21151a();
                }
                aU2.mo21546ak();
            }
            MzCamModule mzCamModule8 = this.f9932b;
            if (mzCamModule8 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule8.mo17963C(true);
            MzCamModule mzCamModule9 = this.f9932b;
            if (mzCamModule9 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule9.mo18165cq();
        }
    }
}
