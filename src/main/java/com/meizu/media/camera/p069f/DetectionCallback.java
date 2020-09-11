package com.meizu.media.camera.p069f;

import com.meizu.camera.effectlib.effects.filters.EffectRenderEngine;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.MzCamModule;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraMode;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzCamUI;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo27294d2 = {"Lcom/meizu/media/camera/impl/DetectionCallback;", "Lcom/meizu/media/camera/camcontroller/CameraController$CameraDetectionCallback;", "mCamModule", "Lcom/meizu/media/camera/MzCamModule;", "(Lcom/meizu/media/camera/MzCamModule;)V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "isManualHighPicSizeOn", "", "onAsdDetection", "", "type", "Lcom/meizu/media/camera/util/Contants$AsdSceneType;", "onAutoFlashDetection", "fire", "onHdrDetection", "tips", "", "onISODetection", "value", "resetHdr", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.f.i */
public final class DetectionCallback implements CameraController.C1876c {

    /* renamed from: a */
    public static ChangeQuickRedirect f9980a;

    /* renamed from: b */
    private final LogUtil.C2630a f9981b = new LogUtil.C2630a("DetectionCallback");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final MzCamModule f9982c;

    public DetectionCallback(@NotNull MzCamModule mzCamModule) {
        C3443i.m21155b(mzCamModule, "mCamModule");
        this.f9982c = mzCamModule;
    }

    /* renamed from: a */
    public void mo18556a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9980a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4313, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = this.f9981b;
            LogUtil.m15942a(aVar, "onHdrDetection: tips = " + i);
            CameraActivity aO = this.f9982c.mo18030aO();
            if (aO != null) {
                aO.runOnUiThread(new C2055c(this, i));
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo27294d2 = {"<anonymous>", "", "run", "com/meizu/media/camera/impl/DetectionCallback$onHdrDetection$1$1"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.i$c */
    /* compiled from: DetectionCallback.kt */
    static final class C2055c implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f9989a;

        /* renamed from: b */
        final /* synthetic */ DetectionCallback f9990b;

        /* renamed from: c */
        final /* synthetic */ int f9991c;

        C2055c(DetectionCallback iVar, int i) {
            this.f9990b = iVar;
            this.f9991c = i;
        }

        public final void run() {
            MzUIController aU;
            if (!PatchProxy.proxy(new Object[0], this, f9989a, false, 4321, new Class[0], Void.TYPE).isSupported && (aU = this.f9990b.f9982c.mo18036aU()) != null) {
                aU.mo21579d(this.f9991c);
            }
        }
    }

    /* renamed from: a */
    public void mo18557a(@NotNull Contants.AsdSceneType asdSceneType) {
        if (!PatchProxy.proxy(new Object[]{asdSceneType}, this, f9980a, false, 4314, new Class[]{Contants.AsdSceneType.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(asdSceneType, "type");
            if (this.f9982c.mo18036aU() != null) {
                MzUIController aU = this.f9982c.mo18036aU();
                if (aU == null) {
                    C3443i.m21151a();
                }
                if (aU.mo21504a() == asdSceneType) {
                    return;
                }
            }
            if (this.f9982c.mo18114bv() != 3 || this.f9982c.mo18070bD()) {
                LogUtil.C2630a aVar = this.f9981b;
                LogUtil.m15942a(aVar, "onAsdDetection: type = " + asdSceneType);
                if (this.f9982c.mo18030aO() != null) {
                    CameraActivity aO = this.f9982c.mo18030aO();
                    if (aO == null) {
                        C3443i.m21151a();
                    }
                    aO.runOnUiThread(new C2053a(this, asdSceneType));
                    return;
                }
                return;
            }
            LogUtil.C2630a aVar2 = this.f9981b;
            LogUtil.m15942a(aVar2, "Not update in SNAPSHOT_IN_PROGRESS, " + asdSceneType);
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.i$a */
    /* compiled from: DetectionCallback.kt */
    static final class C2053a implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f9983a;

        /* renamed from: b */
        final /* synthetic */ DetectionCallback f9984b;

        /* renamed from: c */
        final /* synthetic */ Contants.AsdSceneType f9985c;

        C2053a(DetectionCallback iVar, Contants.AsdSceneType asdSceneType) {
            this.f9984b = iVar;
            this.f9985c = asdSceneType;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f9983a, false, 4319, new Class[0], Void.TYPE).isSupported) {
                MzUIController aU = this.f9984b.f9982c.mo18036aU();
                if (aU != null) {
                    aU.mo21522a(this.f9985c);
                }
                MzCamUI u = this.f9984b.f9982c.mo18267u();
                if (u == null) {
                    return;
                }
                if (this.f9985c != Contants.AsdSceneType.AUTO) {
                    u.mo22084a(this.f9985c.getAsdEffect().f13819e);
                    EffectRenderEngine ce = this.f9984b.f9982c.mo18153ce();
                    if (ce == null) {
                        C3443i.m21151a();
                    }
                    ce.mo14071a(this.f9985c.getAsdEffect().f13819e);
                } else if (!this.f9984b.f9982c.mo17910ag() && !this.f9984b.f9982c.mo17859H()) {
                    u.mo22084a("Mznone");
                    EffectRenderEngine ce2 = this.f9984b.f9982c.mo18153ce();
                    if (ce2 == null) {
                        C3443i.m21151a();
                    }
                    ce2.mo14071a("Mznone");
                }
            }
        }
    }

    /* renamed from: a */
    public void mo18558a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9980a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4315, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = this.f9981b;
            LogUtil.m15942a(aVar, "onAutoFlashDetection: fire = " + z);
            CameraActivity aO = this.f9982c.mo18030aO();
            if (aO != null) {
                aO.runOnUiThread(new C2054b(this, z));
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.i$b */
    /* compiled from: DetectionCallback.kt */
    static final class C2054b implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f9986a;

        /* renamed from: b */
        final /* synthetic */ DetectionCallback f9987b;

        /* renamed from: c */
        final /* synthetic */ boolean f9988c;

        C2054b(DetectionCallback iVar, boolean z) {
            this.f9987b = iVar;
            this.f9988c = z;
        }

        public final void run() {
            MzUIController aU;
            if (!PatchProxy.proxy(new Object[0], this, f9986a, false, 4320, new Class[0], Void.TYPE).isSupported && (aU = this.f9987b.f9982c.mo18036aU()) != null) {
                aU.mo21476A(this.f9988c);
            }
        }
    }

    /* renamed from: b */
    public void mo18560b() {
        if (!PatchProxy.proxy(new Object[0], this, f9980a, false, 4316, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(this.f9981b, "resetHdr");
            CameraActivity aO = this.f9982c.mo18030aO();
            if (aO != null) {
                aO.runOnUiThread(new C2058f(this));
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.i$f */
    /* compiled from: DetectionCallback.kt */
    static final class C2058f implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f9997a;

        /* renamed from: b */
        final /* synthetic */ DetectionCallback f9998b;

        C2058f(DetectionCallback iVar) {
            this.f9998b = iVar;
        }

        public final void run() {
            MzUIController aU;
            if (!PatchProxy.proxy(new Object[0], this, f9997a, false, 4324, new Class[0], Void.TYPE).isSupported && (aU = this.f9998b.f9982c.mo18036aU()) != null) {
                aU.mo21579d(0);
            }
        }
    }

    /* renamed from: b */
    public void mo18561b(int i) {
        CameraActivity aO;
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f9980a, false, 4317, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (CameraModeType.ModeType.BARCODE == CameraModeType.m10946a()) {
                CameraMode aN = this.f9982c.mo18029aN();
                if (aN == null) {
                    C3443i.m21151a();
                }
                aN.mo20519c(i);
            } else if (mo18559a() && (DeviceHelper.f13895av || DeviceHelper.f13896aw)) {
                CameraActivity aO2 = this.f9982c.mo18030aO();
                if (aO2 != null) {
                    aO2.runOnUiThread(new C2056d(this, i));
                }
            } else if (CameraModeType.m10960d() && this.f9982c.mo18116bx()) {
                MzCamModule mzCamModule = this.f9982c;
                if (i < 2500) {
                    z = false;
                }
                mzCamModule.mo17975O(z);
                if (DeviceHelper.f13888ao) {
                    CameraController.FlashMode flashMode = CameraController.FlashMode.FLASH_MODE_AUTO;
                    MzCamParamsManager aW = this.f9982c.mo18038aW();
                    if (aW == null) {
                        C3443i.m21151a();
                    }
                    if (flashMode == aW.mo20342g() && (aO = this.f9982c.mo18030aO()) != null) {
                        aO.runOnUiThread(new C2057e(this));
                    }
                }
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.i$d */
    /* compiled from: DetectionCallback.kt */
    static final class C2056d implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f9992a;

        /* renamed from: b */
        final /* synthetic */ DetectionCallback f9993b;

        /* renamed from: c */
        final /* synthetic */ int f9994c;

        C2056d(DetectionCallback iVar, int i) {
            this.f9993b = iVar;
            this.f9994c = i;
        }

        public final void run() {
            MzUIController aU;
            if (!PatchProxy.proxy(new Object[0], this, f9992a, false, 4322, new Class[0], Void.TYPE).isSupported && (aU = this.f9993b.f9982c.mo18036aU()) != null) {
                aU.mo21584e(this.f9994c);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.i$e */
    /* compiled from: DetectionCallback.kt */
    static final class C2057e implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f9995a;

        /* renamed from: b */
        final /* synthetic */ DetectionCallback f9996b;

        C2057e(DetectionCallback iVar) {
            this.f9996b = iVar;
        }

        public final void run() {
            MzUIController aU;
            if (!PatchProxy.proxy(new Object[0], this, f9995a, false, 4323, new Class[0], Void.TYPE).isSupported && (aU = this.f9996b.f9982c.mo18036aU()) != null) {
                aU.mo21476A(this.f9996b.f9982c.mo18152cd());
            }
        }
    }

    /* renamed from: a */
    public boolean mo18559a() {
        MzUIController aU;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9980a, false, 4318, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (CameraModeType.m10946a() != CameraModeType.ModeType.MANUAL || (aU = this.f9982c.mo18036aU()) == null) {
            return false;
        }
        return aU.mo21608k();
    }
}
