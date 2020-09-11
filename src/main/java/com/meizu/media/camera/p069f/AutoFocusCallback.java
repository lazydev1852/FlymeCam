package com.meizu.media.camera.p069f;

import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MzCamController;
import com.meizu.media.camera.MzCamModule;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.camcontroller.CameraProxy;
import com.meizu.media.camera.mode.CameraMode;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.mode.ManualMode;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo27294d2 = {"Lcom/meizu/media/camera/impl/AutoFocusCallback;", "Lcom/meizu/media/camera/camcontroller/CameraController$CameraAFCallback;", "mCamModule", "Lcom/meizu/media/camera/MzCamModule;", "(Lcom/meizu/media/camera/MzCamModule;)V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "onAutoFocus", "", "focused", "", "camera", "Lcom/meizu/media/camera/camcontroller/CameraProxy;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.f.a */
public final class AutoFocusCallback {

    /* renamed from: a */
    public static ChangeQuickRedirect f9928a;

    /* renamed from: b */
    private final LogUtil.C2630a f9929b = new LogUtil.C2630a("AutoFocusCallback");

    /* renamed from: c */
    private final MzCamModule f9930c;

    public AutoFocusCallback(@NotNull MzCamModule mzCamModule) {
        C3443i.m21155b(mzCamModule, "mCamModule");
        this.f9930c = mzCamModule;
    }

    /* renamed from: a */
    public void mo20013a(boolean z, @Nullable CameraProxy<?> dVar) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), dVar}, this, f9928a, false, 4190, new Class[]{Boolean.TYPE, CameraProxy.class}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = this.f9929b;
            LogUtil.m15952c(aVar, "AutoFocusCallback onAutoFocus" + z + " mPaused=" + this.f9930c.mo18032aQ() + " mFocusManager=" + this.f9930c.mo18097be() + " mIsPreviewStarted=" + this.f9930c.mo18075bI());
            if (!this.f9930c.mo18032aQ()) {
                MzUIController aU = this.f9930c.mo18036aU();
                if (aU == null) {
                    C3443i.m21151a();
                }
                if (!aU.mo21590f()) {
                    if (this.f9930c.mo18075bI() && this.f9930c.mo18115bw() == MzCamController.ModuleState.IDLE && !CameraOptTask.m7846m()) {
                        this.f9930c.mo18005a(MzCamController.ModuleState.IDLE);
                    }
                    if (!(this.f9930c.mo18114bv() == -1 || this.f9930c.mo18114bv() == 3 || this.f9930c.mo18114bv() == 4 || this.f9930c.mo18114bv() == 5 || CameraOptTask.m7846m())) {
                        this.f9930c.mo18262s(1);
                    }
                    if (this.f9930c.mo18163co()) {
                        this.f9930c.mo18164cp().sendEmptyMessage(0);
                        this.f9930c.mo17981U(false);
                    }
                    FocusOverlayManager be = this.f9930c.mo18097be();
                    if (be != null) {
                        MzUIController aU2 = this.f9930c.mo18036aU();
                        if (aU2 == null) {
                            C3443i.m21151a();
                        }
                        be.mo20211a(z, aU2.mo21482E());
                    }
                    CameraMode aN = this.f9930c.mo18029aN();
                    if (aN == null) {
                        C3443i.m21151a();
                    }
                    if (aN.mo20547a(CameraModeType.ModeType.MANUAL)) {
                        CameraMode aN2 = this.f9930c.mo18029aN();
                        if (aN2 != null) {
                            ((ManualMode) aN2).mo20583r();
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.mode.ManualMode");
                        }
                    }
                    if (this.f9930c.mo18109bq()) {
                        UsageStatsHelper.m16044a(4);
                        this.f9930c.mo17971K(true);
                        this.f9930c.mo18048ag(true);
                        this.f9930c.mo18274w(false);
                    }
                }
            }
        }
    }
}
