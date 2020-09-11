package com.meizu.media.camera.p069f;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.AudioManager;
import android.os.Handler;
import android.view.Surface;
import com.meizu.media.camera.ActivityBase;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MediaSaveService;
import com.meizu.media.camera.MzBurstHandler;
import com.meizu.media.camera.MzCamController;
import com.meizu.media.camera.MzCamModule;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzStereoHandler;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.SoundClips;
import com.meizu.media.camera.app.LocationManager;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxy;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.mode.BackTraceMode;
import com.meizu.media.camera.mode.CameraMode;
import com.meizu.media.camera.mode.CameraModeListener;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzCamUI;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0010H\u0016J\n\u0010*\u001a\u0004\u0018\u00010+H\u0016J\n\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u0016H\u0016J\b\u0010/\u001a\u00020\u0019H\u0016J\n\u00100\u001a\u0004\u0018\u000101H\u0016J\n\u00102\u001a\u0004\u0018\u000101H\u0016J\b\u00103\u001a\u00020\u0016H\u0016J\b\u00104\u001a\u00020\u0010H\u0016J\b\u00105\u001a\u00020\u0016H\u0016J\n\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020\u0010H\u0016J\b\u0010:\u001a\u00020\u0016H\u0016J\b\u0010;\u001a\u00020\u0016H\u0016J\b\u0010<\u001a\u00020\u0016H\u0016J\b\u0010=\u001a\u00020\u0016H\u0016J\b\u0010>\u001a\u00020\u0016H\u0016J\b\u0010?\u001a\u00020\u0016H\u0016J\b\u0010@\u001a\u00020\fH\u0016J\u0014\u0010A\u001a\u00020\f2\n\u0010B\u001a\u00020C\"\u00020\u0016H\u0016J\b\u0010D\u001a\u00020\fH\u0016J\u0012\u0010E\u001a\u00020\f2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0010\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\u0010H\u0016J\u0010\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\u0016H\u0016J\u0010\u0010L\u001a\u00020\f2\u0006\u0010M\u001a\u00020\u0016H\u0016J\u0010\u0010N\u001a\u00020\f2\u0006\u0010O\u001a\u00020\u0016H\u0016J\u0012\u0010P\u001a\u00020\f2\b\u0010Q\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010R\u001a\u00020\f2\u0006\u0010S\u001a\u00020\u0016H\u0016J\"\u0010T\u001a\u00020\f2\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010W\u001a\u00020\u00102\u0006\u0010X\u001a\u00020\u0010H\u0016J*\u0010Y\u001a\u00020\f2\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010W\u001a\u00020\u00102\u0006\u0010X\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020\u0010H\u0016J\u0010\u0010]\u001a\u00020\f2\u0006\u0010^\u001a\u00020\u0019H\u0016J\u0010\u0010_\u001a\u00020\f2\u0006\u0010`\u001a\u00020\u0016H\u0016J\u0010\u0010a\u001a\u00020\f2\u0006\u0010b\u001a\u00020\u0016H\u0016J\b\u0010c\u001a\u00020\fH\u0016J\b\u0010d\u001a\u00020\fH\u0016J\u0010\u0010e\u001a\u00020\f2\u0006\u0010f\u001a\u00020\u0010H\u0016J\b\u0010g\u001a\u00020\fH\u0016J\b\u0010h\u001a\u00020\fH\u0016J\b\u0010i\u001a\u00020\fH\u0016J\b\u0010j\u001a\u00020\fH\u0016J\b\u0010k\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006l"}, mo27294d2 = {"Lcom/meizu/media/camera/impl/CamModuleModeListenerImpl;", "Lcom/meizu/media/camera/mode/CameraModeListener;", "()V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "mCamModule", "Lcom/meizu/media/camera/MzCamModule;", "getMCamModule", "()Lcom/meizu/media/camera/MzCamModule;", "setMCamModule", "(Lcom/meizu/media/camera/MzCamModule;)V", "closeCamera", "", "closeStereoMode", "finishVideoRecord", "code", "", "intent", "Landroid/content/Intent;", "getAudioManager", "Landroid/media/AudioManager;", "getBokehStatus", "", "getCameraId", "getCaptureTime", "", "getContentResolver", "Landroid/content/ContentResolver;", "getCurrentFBState", "getFocusManager", "Lcom/meizu/media/camera/FocusOverlayManager;", "getHandler", "Landroid/os/Handler;", "getHdrMode", "Lcom/meizu/media/camera/camcontroller/CameraController$HdrMode;", "getIsHdrOn", "getIsMeterSeparateOn", "getLocationManager", "Lcom/meizu/media/camera/app/LocationManager;", "getMediaSaveListener", "Lcom/meizu/media/camera/MediaSaveService$OnMediaSavedListener;", "getOrientation", "getParamsManager", "Lcom/meizu/media/camera/MzCamParamsManager;", "getPreferences", "Lcom/meizu/media/camera/ComboPreferences;", "getShowBitmapStatus", "getStorageSpaceBytes", "getSubCamSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "getSurfaceTextureWrapper", "getTofRotation", "getTofStatus", "getUI", "Lcom/meizu/media/camera/ui/MzCamUI;", "handleWideAngleStatus", "cameraId", "hasFilterEffect", "isActivityPaused", "isBarcodeAutoEnable", "isFBOn", "isSDCardPriority", "isZoomIndicatorSupported", "needSetFlashParams", "onCaptureFinish", "needSetStateToIdle", "", "onCaptureStart", "onMediaSufacePrepared", "surface", "Landroid/view/Surface;", "playSound", "type", "restartPreview", "needSetPreviewTexture", "setBokehStatus", "isBokehOn", "setFaceDetectionStarted", "enable", "setHdrMode", "hdrMode", "setPauseFling", "pauseFling", "setPreviewBitmap", "bitmap", "Landroid/graphics/Bitmap;", "width", "height", "setPreviewData", "data", "", "rowstride", "setSecureCameraCaptureTime", "secureTime", "setShowBitmapStatus", "showBitmap", "setTofStatus", "isTofOn", "setupPreview", "startFaceDetection", "startRecord", "orientation", "stopFaceDetection", "stopPreview", "stopRecord", "updateStorageSpace", "updateStorageSpaceAndHint", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.f.f */
public final class CamModuleModeListenerImpl implements CameraModeListener {

    /* renamed from: a */
    public static ChangeQuickRedirect f9961a;
    @NotNull

    /* renamed from: b */
    public MzCamModule f9962b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final LogUtil.C2630a f9963c = new LogUtil.C2630a("ModeLisImpl");

    @NotNull
    /* renamed from: a */
    public final MzCamModule mo20024a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4222, new Class[0], MzCamModule.class);
        if (proxy.isSupported) {
            return (MzCamModule) proxy.result;
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule;
    }

    /* renamed from: a */
    public final void mo20025a(@NotNull MzCamModule mzCamModule) {
        if (!PatchProxy.proxy(new Object[]{mzCamModule}, this, f9961a, false, 4223, new Class[]{MzCamModule.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(mzCamModule, "<set-?>");
            this.f9962b = mzCamModule;
        }
    }

    /* renamed from: ee */
    public void mo18234ee() {
        if (!PatchProxy.proxy(new Object[0], this, f9961a, false, 4224, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraActivity aO = mzCamModule.mo18030aO();
            if (aO == null) {
                C3443i.m21151a();
            }
            aO.mo17642h();
        }
    }

    @NotNull
    /* renamed from: dP */
    public LocationManager mo18192dP() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4226, new Class[0], LocationManager.class);
        if (proxy.isSupported) {
            return (LocationManager) proxy.result;
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraActivity aO = mzCamModule.mo18030aO();
        if (aO == null) {
            C3443i.m21151a();
        }
        LocationManager y = aO.mo17698y();
        C3443i.m21152a((Object) y, "mCamModule.mActivity!!.locationManager");
        return y;
    }

    /* renamed from: a */
    public void mo17997a(@Nullable Bitmap bitmap, int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{bitmap, new Integer(i), new Integer(i2)}, this, f9961a, false, 4227, new Class[]{Bitmap.class, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamUI u = mzCamModule.mo18267u();
            if (u != null) {
                u.mo22072a(bitmap, i, i2);
            }
        }
    }

    @NotNull
    /* renamed from: dL */
    public Handler mo18188dL() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4228, new Class[0], Handler.class);
        if (proxy.isSupported) {
            return (Handler) proxy.result;
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18110br();
    }

    /* renamed from: ak */
    public void mo18052ak(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9961a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4229, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18267u() != null) {
                MzCamModule mzCamModule2 = this.f9962b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzCamUI u = mzCamModule2.mo18267u();
                if (u == null) {
                    C3443i.m21151a();
                }
                u.mo22190s(z);
                MzCamModule mzCamModule3 = this.f9962b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule3.mo17976P(z);
            }
        }
    }

    /* renamed from: ag */
    public boolean mo17910ag() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4231, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17910ag();
    }

    /* renamed from: di */
    public int mo18211di() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4232, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18211di();
    }

    /* renamed from: ed */
    public void mo18233ed() {
        if (!PatchProxy.proxy(new Object[0], this, f9961a, false, 4233, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraActivity aO = mzCamModule.mo18030aO();
            if (aO == null) {
                C3443i.m21151a();
            }
            aO.mo17635a((ActivityBase.C1573a) null);
        }
    }

    /* renamed from: p */
    public void mo18256p() {
        if (!PatchProxy.proxy(new Object[0], this, f9961a, false, 4234, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = this.f9963c;
            StringBuilder sb = new StringBuilder();
            sb.append("stopFaceDetection mFaceDetectionStarted=");
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            sb.append(mzCamModule.mo18118bz());
            sb.append(" mCameraDevice=");
            CameraController g = CameraController.m8868g();
            C3443i.m21152a((Object) g, "CameraController.getInstance()");
            sb.append(g.mo19522k());
            LogUtil.m15952c(aVar, sb.toString());
            MzCamModule mzCamModule2 = this.f9962b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule2.mo18118bz()) {
                CameraController g2 = CameraController.m8868g();
                C3443i.m21152a((Object) g2, "CameraController.getInstance()");
                if (g2.mo19522k() != null) {
                    CameraController g3 = CameraController.m8868g();
                    C3443i.m21152a((Object) g3, "CameraController.getInstance()");
                    if (g3.mo19536s() > 0) {
                        MzCamModule mzCamModule3 = this.f9962b;
                        if (mzCamModule3 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        CameraActivity aO = mzCamModule3.mo18030aO();
                        if (aO == null) {
                            C3443i.m21151a();
                        }
                        Context applicationContext = aO.getApplicationContext();
                        MzCamModule mzCamModule4 = this.f9962b;
                        if (mzCamModule4 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        Intent e = CameraOptTask.m8399e(applicationContext, mzCamModule4.mo18056b(), Contants.CameraService.RequestCode.REQUEST_CODE_STOP_FACE_DETECTION);
                        MzCamModule mzCamModule5 = this.f9962b;
                        if (mzCamModule5 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        CameraOptTask.m8349a((Context) mzCamModule5.mo18030aO(), e);
                    }
                }
            }
        }
    }

    /* renamed from: o */
    public void mo18251o() {
        UUID uuid;
        if (!PatchProxy.proxy(new Object[0], this, f9961a, false, 4235, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = this.f9963c;
            StringBuilder sb = new StringBuilder();
            sb.append("startFaceDetection  mMirror:");
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            sb.append(mzCamModule.mo18116bx());
            sb.append("  mFaceDetectionStarted:");
            MzCamModule mzCamModule2 = this.f9962b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            sb.append(mzCamModule2.mo18118bz());
            sb.append("  mCameraDevice:");
            CameraController g = CameraController.m8868g();
            C3443i.m21152a((Object) g, "CameraController.getInstance()");
            sb.append(g.mo19522k());
            LogUtil.m15942a(aVar, sb.toString());
            MzCamModule mzCamModule3 = this.f9962b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (CameraModeType.m10958c(mzCamModule3.mo18116bx())) {
                MzCamModule mzCamModule4 = this.f9962b;
                if (mzCamModule4 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (!mzCamModule4.mo18118bz()) {
                    CameraController g2 = CameraController.m8868g();
                    C3443i.m21152a((Object) g2, "CameraController.getInstance()");
                    if (g2.mo19522k() != null) {
                        MzCamModule mzCamModule5 = this.f9962b;
                        if (mzCamModule5 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        if (mzCamModule5.mo18030aO() != null) {
                            CameraController g3 = CameraController.m8868g();
                            C3443i.m21152a((Object) g3, "CameraController.getInstance()");
                            if (g3.mo19536s() > 0) {
                                MzCamModule mzCamModule6 = this.f9962b;
                                if (mzCamModule6 == null) {
                                    C3443i.m21156b("mCamModule");
                                }
                                if (mzCamModule6.mo18075bI()) {
                                    MzCamModule mzCamModule7 = this.f9962b;
                                    if (mzCamModule7 == null) {
                                        C3443i.m21156b("mCamModule");
                                    }
                                    if (mzCamModule7.mo18267u() != null) {
                                        MzCamModule mzCamModule8 = this.f9962b;
                                        if (mzCamModule8 == null) {
                                            C3443i.m21156b("mCamModule");
                                        }
                                        MzCamUI u = mzCamModule8.mo18267u();
                                        if (u == null) {
                                            C3443i.m21151a();
                                        }
                                        MzCamModule mzCamModule9 = this.f9962b;
                                        if (mzCamModule9 == null) {
                                            C3443i.m21156b("mCamModule");
                                        }
                                        int bp = mzCamModule9.mo18108bp();
                                        MzCamModule mzCamModule10 = this.f9962b;
                                        if (mzCamModule10 == null) {
                                            C3443i.m21156b("mCamModule");
                                        }
                                        u.mo22139b(bp, mzCamModule10.mo18116bx());
                                        CameraController g4 = CameraController.m8868g();
                                        MzCamModule mzCamModule11 = this.f9962b;
                                        if (mzCamModule11 == null) {
                                            C3443i.m21156b("mCamModule");
                                        }
                                        Handler br = mzCamModule11.mo18110br();
                                        MzCamModule mzCamModule12 = this.f9962b;
                                        if (mzCamModule12 == null) {
                                            C3443i.m21156b("mCamModule");
                                        }
                                        g4.mo19457a(br, (CameraController.C1877d) mzCamModule12.mo18267u());
                                    }
                                    UUID uuid2 = null;
                                    if (CameraModeType.m10946a() == CameraModeType.ModeType.BACK_TRACE) {
                                        MzCamModule mzCamModule13 = this.f9962b;
                                        if (mzCamModule13 == null) {
                                            C3443i.m21156b("mCamModule");
                                        }
                                        CameraMode aN = mzCamModule13.mo18029aN();
                                        if (aN != null) {
                                            uuid = ((BackTraceMode) aN).mo18056b();
                                        } else {
                                            throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.mode.BackTraceMode");
                                        }
                                    } else {
                                        MzCamModule mzCamModule14 = this.f9962b;
                                        if (mzCamModule14 == null) {
                                            C3443i.m21156b("mCamModule");
                                        }
                                        if (mzCamModule14.mo18225dw()) {
                                            MzCamModule mzCamModule15 = this.f9962b;
                                            if (mzCamModule15 == null) {
                                                C3443i.m21156b("mCamModule");
                                            }
                                            MzBurstHandler aL = mzCamModule15.mo18027aL();
                                            if (aL == null) {
                                                C3443i.m21151a();
                                            }
                                            uuid = aL.mo18056b();
                                        } else {
                                            MzCamModule mzCamModule16 = this.f9962b;
                                            if (mzCamModule16 == null) {
                                                C3443i.m21156b("mCamModule");
                                            }
                                            uuid = mzCamModule16.mo18056b();
                                        }
                                    }
                                    MzCamModule mzCamModule17 = this.f9962b;
                                    if (mzCamModule17 == null) {
                                        C3443i.m21156b("mCamModule");
                                    }
                                    CameraActivity aO = mzCamModule17.mo18030aO();
                                    if (aO == null) {
                                        C3443i.m21151a();
                                    }
                                    Intent d = CameraOptTask.m8395d(aO.getApplicationContext(), uuid, Contants.CameraService.RequestCode.REQUEST_CODE_START_FACE_DETECTION);
                                    MzCamModule mzCamModule18 = this.f9962b;
                                    if (mzCamModule18 == null) {
                                        C3443i.m21156b("mCamModule");
                                    }
                                    CameraOptTask.m8349a((Context) mzCamModule18.mo18030aO(), d);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: dJ */
    public long mo18186dJ() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4236, new Class[0], Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18117by();
    }

    /* renamed from: dY */
    public boolean mo18201dY() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4237, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        ComboPreferences aE = mzCamModule.mo17902aE();
        if (aE == null) {
            C3443i.m21151a();
        }
        boolean a = C3443i.m21154a((Object) "sdcard", (Object) aE.getString("mz_pref_storage_key", "sdcard"));
        UsageStatsHelper.m16049b(a);
        return a;
    }

    /* renamed from: d */
    public void mo17936d(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9961a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4238, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo17936d(i);
        }
    }

    @Nullable
    /* renamed from: dS */
    public MzCamParamsManager mo18195dS() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4239, new Class[0], MzCamParamsManager.class);
        if (proxy.isSupported) {
            return (MzCamParamsManager) proxy.result;
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18038aW();
    }

    /* renamed from: an */
    public void mo18055an(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9961a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4240, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18267u() != null) {
                MzCamModule mzCamModule2 = this.f9962b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzCamUI u = mzCamModule2.mo18267u();
                if (u == null) {
                    C3443i.m21151a();
                }
                u.mo22194t(z);
                MzCamModule mzCamModule3 = this.f9962b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule3.mo17977Q(z);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01cb, code lost:
        if (com.meizu.media.camera.mode.CameraModeType.m10972h(r1.mo20543V()) == false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x01f6, code lost:
        if (com.meizu.media.camera.mode.CameraModeType.m10973h(r1.mo20403g_()) == false) goto L_0x01f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x020b, code lost:
        if (r1.mo18166cr() == false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0222, code lost:
        if (r1.mo18098bf() == false) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x023a, code lost:
        if (com.meizu.media.camera.mode.CameraModeType.m10983m(com.meizu.media.camera.mode.CameraModeType.ModeType.BACK_LIGHTING) == false) goto L_0x0251;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x018e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x018f  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo18122c(@org.jetbrains.annotations.NotNull boolean... r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = f9961a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<boolean[]> r2 = boolean[].class
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 4241(0x1091, float:5.943E-42)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x001d
            return
        L_0x001d:
            java.lang.String r1 = "needSetStateToIdle"
            kotlin.jvm.p108b.C3443i.m21155b(r10, r1)
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x002b
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x002b:
            com.meizu.media.camera.ui.i r1 = r1.mo18267u()
            if (r1 == 0) goto L_0x0046
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x003a
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x003a:
            com.meizu.media.camera.ui.i r1 = r1.mo18267u()
            if (r1 != 0) goto L_0x0043
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0043:
            r1.mo22200w((boolean) r8)
        L_0x0046:
            boolean r1 = r9.mo17910ag()
            r2 = -1
            if (r1 == 0) goto L_0x007f
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x0056
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0056:
            com.meizu.media.camera.w r1 = r1.mo18162cn()
            if (r1 == 0) goto L_0x007f
            boolean r1 = r9.mo17859H()
            if (r1 != 0) goto L_0x007f
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r3 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r1 != r3) goto L_0x007f
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x0071
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0071:
            com.meizu.media.camera.w r1 = r1.mo18162cn()
            if (r1 != 0) goto L_0x007a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x007a:
            java.lang.String r3 = "com.meizu.media.camera_cameraFBStart"
            r1.mo22767b(r3, r2)
        L_0x007f:
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x0088
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0088:
            com.meizu.media.camera.CameraActivity r1 = r1.mo18030aO()
            if (r1 != 0) goto L_0x008f
            return
        L_0x008f:
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x0098
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0098:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 == 0) goto L_0x00f4
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x00a7
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x00a7:
            boolean r1 = r1.mo18228dz()
            if (r1 == 0) goto L_0x00f4
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r3)
            com.meizu.media.camera.util.Contants$AsdSceneType r1 = r1.mo19485ac()
            com.meizu.media.camera.MzCamModule r3 = r9.f9962b
            if (r3 != 0) goto L_0x00c3
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x00c3:
            com.meizu.media.camera.u r3 = r3.mo18036aU()
            if (r3 != 0) goto L_0x00cc
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x00cc:
            com.meizu.media.camera.util.Contants$AsdSceneType r3 = r3.mo21504a()
            if (r1 == r3) goto L_0x00f4
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x00db
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x00db:
            com.meizu.media.camera.f.i r1 = r1.mo18106bn()
            com.meizu.media.camera.camcontroller.CameraController r3 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            com.meizu.media.camera.util.Contants$AsdSceneType r3 = r3.mo19485ac()
            java.lang.String r4 = "CameraController.getInstance().lastAsdSceneType"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            r1.mo18557a((com.meizu.media.camera.util.Contants.AsdSceneType) r3)
        L_0x00f4:
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x00fd
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x00fd:
            com.meizu.media.camera.MzCamModule r3 = r9.f9962b
            if (r3 != 0) goto L_0x0106
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0106:
            com.meizu.media.camera.j r3 = r3.mo18027aL()
            if (r3 == 0) goto L_0x0123
            com.meizu.media.camera.MzCamModule r3 = r9.f9962b
            if (r3 != 0) goto L_0x0115
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0115:
            com.meizu.media.camera.j r3 = r3.mo18027aL()
            if (r3 != 0) goto L_0x011e
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x011e:
            boolean r3 = r3.mo20294m()
            goto L_0x0124
        L_0x0123:
            r3 = 0
        L_0x0124:
            r1.mo17963C(r3)
            int r1 = r10.length
            if (r1 == 0) goto L_0x012e
            boolean r1 = r10[r8]
            if (r1 == 0) goto L_0x0174
        L_0x012e:
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x0137
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0137:
            boolean r1 = r1.mo18032aQ()
            if (r1 != 0) goto L_0x0174
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x0146
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0146:
            int r1 = r1.mo18114bv()
            if (r1 == r2) goto L_0x0174
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x0155
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0155:
            com.meizu.media.camera.MzCamController$ModuleState r1 = r1.mo18115bw()
            com.meizu.media.camera.MzCamController$ModuleState r2 = com.meizu.media.camera.MzCamController.ModuleState.IDLE
            if (r1 != r2) goto L_0x0174
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x0166
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0166:
            boolean r1 = r1.mo18070bD()
            if (r1 != 0) goto L_0x0174
            boolean r1 = com.meizu.media.camera.CameraOptTask.m7844k()
            if (r1 != 0) goto L_0x0174
            r1 = 1
            goto L_0x0175
        L_0x0174:
            r1 = 0
        L_0x0175:
            int r2 = r10.length
            r3 = 3
            r4 = 2
            if (r2 != r3) goto L_0x017f
            boolean r2 = r10[r4]
            if (r2 == 0) goto L_0x017f
            r8 = 1
        L_0x017f:
            com.meizu.media.camera.MzCamModule r2 = r9.f9962b
            if (r2 != 0) goto L_0x0188
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0188:
            com.meizu.media.camera.CameraActivity r2 = r2.mo18030aO()
            if (r2 != 0) goto L_0x018f
            return
        L_0x018f:
            com.meizu.media.camera.MzCamModule r2 = r9.f9962b
            if (r2 != 0) goto L_0x0198
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0198:
            com.meizu.media.camera.CameraActivity r2 = r2.mo18030aO()
            if (r2 != 0) goto L_0x01a1
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01a1:
            com.meizu.media.camera.f.f$a r3 = new com.meizu.media.camera.f.f$a
            r3.<init>(r9, r1, r8, r10)
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r2.runOnUiThread(r3)
            boolean r1 = r9.mo18190dN()
            if (r1 == 0) goto L_0x01cd
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x01ba
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x01ba:
            com.meizu.media.camera.mode.f r1 = r1.mo18029aN()
            if (r1 != 0) goto L_0x01c3
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01c3:
            int r1 = r1.mo20543V()
            boolean r1 = com.meizu.media.camera.mode.CameraModeType.m10972h((int) r1)
            if (r1 != 0) goto L_0x023c
        L_0x01cd:
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x01d6
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x01d6:
            boolean r1 = r1.mo17898aA()
            if (r1 == 0) goto L_0x01f8
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x01e5
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x01e5:
            com.meizu.media.camera.mode.f r1 = r1.mo18029aN()
            if (r1 != 0) goto L_0x01ee
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01ee:
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = r1.mo20403g_()
            boolean r1 = com.meizu.media.camera.mode.CameraModeType.m10973h((com.meizu.media.camera.mode.CameraModeType.ModeType) r1)
            if (r1 != 0) goto L_0x023c
        L_0x01f8:
            boolean r1 = r9.mo17910ag()
            if (r1 == 0) goto L_0x020d
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x0207
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0207:
            boolean r1 = r1.mo18166cr()
            if (r1 != 0) goto L_0x023c
        L_0x020d:
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.SQUARE
            boolean r1 = com.meizu.media.camera.mode.CameraModeType.m10983m((com.meizu.media.camera.mode.CameraModeType.ModeType) r1)
            if (r1 == 0) goto L_0x0224
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x021e
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x021e:
            boolean r1 = r1.mo18098bf()
            if (r1 != 0) goto L_0x023c
        L_0x0224:
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.DOCUMENT
            boolean r1 = com.meizu.media.camera.mode.CameraModeType.m10983m((com.meizu.media.camera.mode.CameraModeType.ModeType) r1)
            if (r1 != 0) goto L_0x023c
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.SUPER_NIGHT
            boolean r1 = com.meizu.media.camera.mode.CameraModeType.m10983m((com.meizu.media.camera.mode.CameraModeType.ModeType) r1)
            if (r1 != 0) goto L_0x023c
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.BACK_LIGHTING
            boolean r1 = com.meizu.media.camera.mode.CameraModeType.m10983m((com.meizu.media.camera.mode.CameraModeType.ModeType) r1)
            if (r1 == 0) goto L_0x0251
        L_0x023c:
            com.meizu.media.camera.MzCamModule r1 = r9.f9962b
            if (r1 != 0) goto L_0x0245
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0245:
            com.meizu.media.camera.mode.f r1 = r1.mo18029aN()
            if (r1 != 0) goto L_0x024e
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x024e:
            r1.mo20380D()
        L_0x0251:
            int r1 = r10.length
            if (r1 != r4) goto L_0x025b
            boolean r10 = r10[r0]
            if (r10 == 0) goto L_0x025b
            r9.mo18251o()
        L_0x025b:
            com.meizu.media.camera.MzCamModule r10 = r9.f9962b
            if (r10 != 0) goto L_0x0264
            java.lang.String r0 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r0)
        L_0x0264:
            com.meizu.media.camera.CameraActivity r10 = r10.mo18030aO()
            if (r10 != 0) goto L_0x026d
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x026d:
            r10.mo17642h()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p069f.CamModuleModeListenerImpl.mo18122c(boolean[]):void");
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.f$a */
    /* compiled from: CamModuleModeListenerImpl.kt */
    static final class C2050a implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f9964a;

        /* renamed from: b */
        final /* synthetic */ CamModuleModeListenerImpl f9965b;

        /* renamed from: c */
        final /* synthetic */ boolean f9966c;

        /* renamed from: d */
        final /* synthetic */ boolean f9967d;

        /* renamed from: e */
        final /* synthetic */ boolean[] f9968e;

        C2050a(CamModuleModeListenerImpl fVar, boolean z, boolean z2, boolean[] zArr) {
            this.f9965b = fVar;
            this.f9966c = z;
            this.f9967d = z2;
            this.f9968e = zArr;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f9964a, false, 4281, new Class[0], Void.TYPE).isSupported) {
                LogUtil.C2630a a = this.f9965b.f9963c;
                StringBuilder sb = new StringBuilder();
                sb.append("onCaptureFinish needSetIdle:");
                sb.append(this.f9966c);
                sb.append(", CaptureTask:");
                sb.append(!CameraOptTask.m7846m());
                sb.append(", currentHandleTaskCupture:");
                sb.append(CameraOptTask.m7844k());
                sb.append(", forceSetIdle: ");
                sb.append(this.f9967d);
                LogUtil.m15952c(a, sb.toString());
                if (!CameraOptTask.m7846m() || this.f9967d) {
                    if (this.f9966c) {
                        this.f9965b.mo20024a().mo18262s(1);
                        this.f9965b.mo20024a().mo18005a(MzCamController.ModuleState.IDLE);
                    }
                    if (this.f9965b.mo20024a().mo18036aU() != null) {
                        if ((DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL_AND_GALLERY || DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL) && this.f9965b.mo20024a().mo18022aG() == 0 && this.f9965b.mo20024a().mo17898aA()) {
                            this.f9965b.mo20024a().mo18110br().removeMessages(30);
                            this.f9965b.mo20024a().mo18110br().sendEmptyMessage(30);
                        } else {
                            MzUIController aU = this.f9965b.mo20024a().mo18036aU();
                            if (aU == null) {
                                C3443i.m21151a();
                            }
                            aU.mo21628r();
                            if (!CameraOptTask.m7844k()) {
                                MzUIController aU2 = this.f9965b.mo20024a().mo18036aU();
                                if (aU2 == null) {
                                    C3443i.m21151a();
                                }
                                aU2.mo21611l(true);
                            }
                        }
                    }
                    if (this.f9965b.mo20024a().mo18041aZ() || (this.f9968e.length == 2 && this.f9968e[1])) {
                        this.f9965b.mo20024a().mo17941f(false);
                    }
                }
            }
        }
    }

    /* renamed from: dR */
    public int mo18194dR() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4242, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraActivity aO = mzCamModule.mo18030aO();
        if (aO == null) {
            C3443i.m21151a();
        }
        if (aO.mo17695v()) {
            MzCamModule mzCamModule2 = this.f9962b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            return (360 - mzCamModule2.mo18107bo()) % 360;
        }
        MzCamModule mzCamModule3 = this.f9962b;
        if (mzCamModule3 == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule3.mo18068bB() == -1) {
            MzCamModule mzCamModule4 = this.f9962b;
            if (mzCamModule4 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule4.mo18248m(0);
        }
        MzCamModule mzCamModule5 = this.f9962b;
        if (mzCamModule5 == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule5.mo18068bB();
    }

    @NotNull
    /* renamed from: dH */
    public AudioManager mo18184dH() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4243, new Class[0], AudioManager.class);
        if (proxy.isSupported) {
            return (AudioManager) proxy.result;
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraActivity aO = mzCamModule.mo18030aO();
        if (aO == null) {
            C3443i.m21151a();
        }
        AudioManager x = aO.mo17697x();
        C3443i.m21152a((Object) x, "mCamModule.mActivity!!.audioManager");
        return x;
    }

    /* renamed from: aj */
    public void mo18051aj(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9961a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4244, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            mo18256p();
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraActivity aO = mzCamModule.mo18030aO();
            if (aO == null) {
                C3443i.m21151a();
            }
            Context applicationContext = aO.getApplicationContext();
            MzCamModule mzCamModule2 = this.f9962b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraMode aN = mzCamModule2.mo18029aN();
            if (aN == null) {
                C3443i.m21151a();
            }
            CameraModeType.ModeType g_ = aN.mo20403g_();
            MzCamModule mzCamModule3 = this.f9962b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            Intent a = CameraOptTask.m8345a(applicationContext, z, g_, mzCamModule3.mo18056b(), Contants.CameraService.RequestCode.REQUEST_CODE_RESTART_PREVIEW);
            MzCamModule mzCamModule4 = this.f9962b;
            if (mzCamModule4 == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraOptTask.m8349a((Context) mzCamModule4.mo18030aO(), a);
        }
    }

    @Nullable
    /* renamed from: ak */
    public FocusOverlayManager mo17914ak() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4245, new Class[0], FocusOverlayManager.class);
        if (proxy.isSupported) {
            return (FocusOverlayManager) proxy.result;
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17914ak();
    }

    /* renamed from: x */
    public void mo18275x(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9961a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4246, new Class[]{Integer.TYPE}, Void.TYPE).isSupported || !DeviceUtil.m16200b()) {
            return;
        }
        if (!mo18200dX() || CameraModeType.m10955c()) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18071bE() == null) {
                MzCamModule mzCamModule2 = this.f9962b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzCamModule mzCamModule3 = this.f9962b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraActivity aO = mzCamModule3.mo18030aO();
                if (aO == null) {
                    C3443i.m21151a();
                }
                mzCamModule2.mo18007a(SoundClips.m7934a(aO.getApplicationContext()));
            }
            MzCamModule mzCamModule4 = this.f9962b;
            if (mzCamModule4 == null) {
                C3443i.m21156b("mCamModule");
            }
            SoundClips.C1785a bE = mzCamModule4.mo18071bE();
            if (bE == null) {
                C3443i.m21151a();
            }
            bE.mo18761a(i);
        }
    }

    @NotNull
    /* renamed from: dQ */
    public MediaSaveService.C1639d mo18193dQ() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4247, new Class[0], MediaSaveService.C1639d.class);
        if (proxy.isSupported) {
            return (MediaSaveService.C1639d) proxy.result;
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18208df();
    }

    /* renamed from: al */
    public void mo18053al(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9961a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4248, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo17961A(z);
        }
    }

    @Nullable
    /* renamed from: dK */
    public ContentResolver mo18187dK() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4249, new Class[0], ContentResolver.class);
        if (proxy.isSupported) {
            return (ContentResolver) proxy.result;
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18040aY();
    }

    /* renamed from: ec */
    public void mo18232ec() {
        if (!PatchProxy.proxy(new Object[0], this, f9961a, false, 4250, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamUI u = mzCamModule.mo18267u();
            if (u != null) {
                u.mo22099aF();
            }
        }
    }

    /* renamed from: d */
    public void mo18175d(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f9961a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4251, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18074bH() == -1) {
                MzCamModule mzCamModule2 = this.f9962b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                long j2 = (long) 1000;
                mzCamModule2.mo18120c((j / j2) * j2);
            }
        }
    }

    /* renamed from: d */
    public boolean mo18176d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4252, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18176d();
    }

    @Nullable
    /* renamed from: c */
    public SurfaceTexture mo18119c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4253, new Class[0], SurfaceTexture.class);
        if (proxy.isSupported) {
            return (SurfaceTexture) proxy.result;
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18119c();
    }

    @Nullable
    /* renamed from: aE */
    public synchronized ComboPreferences mo17902aE() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4254, new Class[0], ComboPreferences.class);
        if (proxy.isSupported) {
            return (ComboPreferences) proxy.result;
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17902aE();
    }

    /* renamed from: a */
    public void mo18017a(@Nullable byte[] bArr, int i, int i2, int i3) {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2), new Integer(i3)}, this, f9961a, false, 4255, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18267u() != null) {
                MzCamModule mzCamModule2 = this.f9962b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzCamUI u = mzCamModule2.mo18267u();
                if (u == null) {
                    C3443i.m21151a();
                }
                u.mo22090a(bArr, i, i2, i3);
            }
        }
    }

    /* renamed from: dI */
    public boolean mo18185dI() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4256, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18156ch();
    }

    /* renamed from: dT */
    public boolean mo18196dT() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4257, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18158cj();
    }

    /* renamed from: ea */
    public void mo18230ea() {
        if (!PatchProxy.proxy(new Object[0], this, f9961a, false, 4258, new Class[0], Void.TYPE).isSupported) {
            CameraController g = CameraController.m8868g();
            C3443i.m21152a((Object) g, "CameraController.getInstance()");
            if (g.mo19522k() != null) {
                MzCamModule mzCamModule = this.f9962b;
                if (mzCamModule == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (mzCamModule.mo18114bv() != 3) {
                    MzCamModule mzCamModule2 = this.f9962b;
                    if (mzCamModule2 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    if (mzCamModule2.mo18114bv() != 4) {
                        MzCamModule mzCamModule3 = this.f9962b;
                        if (mzCamModule3 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        CameraActivity aO = mzCamModule3.mo18030aO();
                        if (aO == null) {
                            C3443i.m21151a();
                        }
                        aO.runOnUiThread(new C2051b(this));
                        MzCamModule mzCamModule4 = this.f9962b;
                        if (mzCamModule4 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        mzCamModule4.mo18262s(3);
                    }
                }
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.f$b */
    /* compiled from: CamModuleModeListenerImpl.kt */
    static final class C2051b implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f9969a;

        /* renamed from: b */
        final /* synthetic */ CamModuleModeListenerImpl f9970b;

        C2051b(CamModuleModeListenerImpl fVar) {
            this.f9970b = fVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f9969a, false, 4282, new Class[0], Void.TYPE).isSupported) {
                if (this.f9970b.mo20024a().mo18029aN() != CameraModeType.ModeType.GIF && (this.f9970b.mo20024a().mo18029aN() != CameraModeType.ModeType.AUTO || !this.f9970b.mo20024a().mo17898aA())) {
                    this.f9970b.mo20024a().mo17941f(true);
                }
                if (this.f9970b.mo20024a().mo18097be() != null) {
                    FocusOverlayManager be = this.f9970b.mo20024a().mo18097be();
                    if (be == null) {
                        C3443i.m21151a();
                    }
                    be.mo20226h(false);
                    FocusOverlayManager be2 = this.f9970b.mo20024a().mo18097be();
                    if (be2 == null) {
                        C3443i.m21151a();
                    }
                    be2.mo20236o();
                }
            }
        }
    }

    /* renamed from: dU */
    public long mo18197dU() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4259, new Class[0], Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraActivity aO = mzCamModule.mo18030aO();
        if (aO == null) {
            C3443i.m21151a();
        }
        return aO.mo17641g();
    }

    /* renamed from: H */
    public boolean mo17859H() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4260, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17859H();
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.f$c */
    /* compiled from: CamModuleModeListenerImpl.kt */
    static final class C2052c implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f9971a;

        /* renamed from: b */
        final /* synthetic */ CamModuleModeListenerImpl f9972b;

        C2052c(CamModuleModeListenerImpl fVar) {
            this.f9972b = fVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f9971a, false, 4283, new Class[0], Void.TYPE).isSupported && this.f9972b.mo20024a().mo18097be() != null) {
                FocusOverlayManager be = this.f9972b.mo20024a().mo18097be();
                if (be == null) {
                    C3443i.m21151a();
                }
                if (!be.mo20244w()) {
                    FocusOverlayManager be2 = this.f9972b.mo20024a().mo18097be();
                    if (be2 == null) {
                        C3443i.m21151a();
                    }
                    be2.mo20233l();
                }
            }
        }
    }

    /* renamed from: eb */
    public void mo18231eb() {
        if (!PatchProxy.proxy(new Object[0], this, f9961a, false, 4261, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraActivity aO = mzCamModule.mo18030aO();
            if (aO != null) {
                aO.runOnUiThread(new C2052c(this));
            }
            MzCamModule mzCamModule2 = this.f9962b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule2.mo18127cE();
        }
    }

    /* renamed from: dj */
    public int mo18212dj() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4262, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18212dj();
    }

    /* renamed from: am */
    public void mo18054am(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9961a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4263, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18267u() != null) {
                MzCamModule mzCamModule2 = this.f9962b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzCamUI u = mzCamModule2.mo18267u();
                if (u == null) {
                    C3443i.m21151a();
                }
                u.mo22195u(z);
                MzCamModule mzCamModule3 = this.f9962b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule3.mo17978R(z);
            }
        }
    }

    /* renamed from: V */
    public boolean mo17873V() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4264, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17873V();
    }

    @Nullable
    /* renamed from: u */
    public MzCamUI mo18267u() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4265, new Class[0], MzCamUI.class);
        if (proxy.isSupported) {
            return (MzCamUI) proxy.result;
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18037aV();
    }

    /* renamed from: dN */
    public boolean mo18190dN() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4266, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18116bx()) {
            return false;
        }
        MzCamModule mzCamModule2 = this.f9962b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule2.mo18036aU() == null) {
            return false;
        }
        MzCamModule mzCamModule3 = this.f9962b;
        if (mzCamModule3 == null) {
            C3443i.m21156b("mCamModule");
        }
        MzUIController aU = mzCamModule3.mo18036aU();
        if (aU == null) {
            C3443i.m21151a();
        }
        return aU.mo21602i();
    }

    @NotNull
    /* renamed from: dM */
    public CameraController.HdrMode mo18189dM() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4267, new Class[0], CameraController.HdrMode.class);
        if (proxy.isSupported) {
            return (CameraController.HdrMode) proxy.result;
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18116bx() && !DeviceHelper.f13890aq) {
            return CameraController.HdrMode.OFF;
        }
        MzCamModule mzCamModule2 = this.f9962b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule2.mo18036aU() == null) {
            return CameraController.HdrMode.OFF;
        }
        MzCamModule mzCamModule3 = this.f9962b;
        if (mzCamModule3 == null) {
            C3443i.m21156b("mCamModule");
        }
        MzUIController aU = mzCamModule3.mo18036aU();
        if (aU == null) {
            C3443i.m21151a();
        }
        CameraController.HdrMode j = aU.mo21604j();
        C3443i.m21152a((Object) j, "mCamModule.mCommonUI!!.hdrMode");
        return j;
    }

    /* renamed from: b */
    public void mo18060b(int i, @Nullable Intent intent) {
        Object[] objArr = {new Integer(i), intent};
        ChangeQuickRedirect changeQuickRedirect = f9961a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4268, new Class[]{Integer.TYPE, Intent.class}, Void.TYPE).isSupported) {
            if (intent == null) {
                MzCamModule mzCamModule = this.f9962b;
                if (mzCamModule == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraActivity aO = mzCamModule.mo18030aO();
                if (aO == null) {
                    C3443i.m21151a();
                }
                aO.mo17666a(i);
            } else {
                MzCamModule mzCamModule2 = this.f9962b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraActivity aO2 = mzCamModule2.mo18030aO();
                if (aO2 == null) {
                    C3443i.m21151a();
                }
                aO2.mo17667a(i, intent);
            }
            MzCamModule mzCamModule3 = this.f9962b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraActivity aO3 = mzCamModule3.mo18030aO();
            if (aO3 == null) {
                C3443i.m21151a();
            }
            aO3.finish();
        }
    }

    /* renamed from: y */
    public void mo18277y(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f9961a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4269, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamUI u = mzCamModule.mo18267u();
            if (u != null) {
                u.mo22164h(i);
            }
        }
    }

    /* renamed from: dW */
    public boolean mo18199dW() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4270, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18157ci();
    }

    /* renamed from: aw */
    public boolean mo17926aw() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4271, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17926aw();
    }

    /* renamed from: dO */
    public boolean mo18191dO() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4272, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        MzUIController aU = mzCamModule.mo18036aU();
        if (aU == null) {
            C3443i.m21151a();
        }
        return aU.mo21647y();
    }

    @Nullable
    /* renamed from: f */
    public SurfaceTexture mo18236f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4273, new Class[0], SurfaceTexture.class);
        if (proxy.isSupported) {
            return (SurfaceTexture) proxy.result;
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18236f();
    }

    /* renamed from: dF */
    public void mo18182dF() {
        boolean z;
        boolean z2;
        if (!PatchProxy.proxy(new Object[0], this, f9961a, false, 4274, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = this.f9963c;
            StringBuilder sb = new StringBuilder();
            sb.append("-----------closeCamera mCameraDevice:");
            CameraController g = CameraController.m8868g();
            C3443i.m21152a((Object) g, "CameraController.getInstance()");
            sb.append(g.mo19522k());
            LogUtil.m15952c(aVar, sb.toString());
            CameraController g2 = CameraController.m8868g();
            C3443i.m21152a((Object) g2, "CameraController.getInstance()");
            if (g2.mo19516h() == CameraController.CameraApi.API1) {
                CameraController g3 = CameraController.m8868g();
                C3443i.m21152a((Object) g3, "CameraController.getInstance()");
                CameraProxy k = g3.mo19522k();
                if (k != null) {
                    CameraProxyV1 eVar = (CameraProxyV1) k;
                    MzCamModule mzCamModule = this.f9962b;
                    if (mzCamModule == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    if (mzCamModule.mo18118bz() && eVar != null) {
                        Camera.Parameters f = eVar.mo19740f();
                        C3443i.m21152a((Object) f, "cameraProxyV1.parameters");
                        if (f.getMaxNumDetectedFaces() > 0) {
                            z2 = true;
                            z = z2;
                        }
                    }
                    z2 = false;
                    z = z2;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.meizu.media.camera.camcontroller.CameraProxyV1");
                }
            } else {
                z = false;
            }
            MzCamModule mzCamModule2 = this.f9962b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraActivity aO = mzCamModule2.mo18030aO();
            if (aO == null) {
                C3443i.m21151a();
            }
            Context applicationContext = aO.getApplicationContext();
            MzCamModule mzCamModule3 = this.f9962b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraActivity aO2 = mzCamModule3.mo18030aO();
            if (aO2 == null) {
                C3443i.m21151a();
            }
            Intent intent = aO2.getIntent();
            C3443i.m21152a((Object) intent, "mCamModule.mActivity!!.intent");
            String action = intent.getAction();
            MzCamModule mzCamModule4 = this.f9962b;
            if (mzCamModule4 == null) {
                C3443i.m21156b("mCamModule");
            }
            Intent a = CameraOptTask.m8341a(applicationContext, action, z, false, mzCamModule4.mo18056b(), Contants.CameraService.RequestCode.REQUEST_CODE_CLOSE_CAMERA);
            MzCamModule mzCamModule5 = this.f9962b;
            if (mzCamModule5 == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraOptTask.m8349a((Context) mzCamModule5.mo18030aO(), a);
            MzCamModule mzCamModule6 = this.f9962b;
            if (mzCamModule6 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule6.mo17966F(false);
        }
    }

    /* renamed from: dG */
    public void mo18183dG() {
        if (!PatchProxy.proxy(new Object[0], this, f9961a, false, 4275, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzStereoHandler aM = mzCamModule.mo18028aM();
            if (aM == null) {
                C3443i.m21151a();
            }
            aM.mo20817a();
        }
    }

    /* renamed from: dV */
    public int mo18198dV() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4276, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return CameraUtil.m15882c(mzCamModule.mo18031aP(), mo18194dR());
    }

    /* renamed from: dX */
    public boolean mo18200dX() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9961a, false, 4277, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9962b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18032aQ();
    }

    /* renamed from: dZ */
    public void mo18202dZ() {
        if (!PatchProxy.proxy(new Object[0], this, f9961a, false, 4278, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18163co()) {
                MzCamModule mzCamModule2 = this.f9962b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzCamParamsManager aW = mzCamModule2.mo18038aW();
                if (aW == null) {
                    C3443i.m21151a();
                }
                MzCamModule mzCamModule3 = this.f9962b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (aW.mo20327a(mzCamModule3.mo18164cp().mo18313a())) {
                    MzCamModule mzCamModule4 = this.f9962b;
                    if (mzCamModule4 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    mzCamModule4.mo18271v(4);
                }
                MzCamModule mzCamModule5 = this.f9962b;
                if (mzCamModule5 == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule5.mo17981U(false);
            }
        }
    }

    /* renamed from: dk */
    public void mo18213dk() {
        if (!PatchProxy.proxy(new Object[0], this, f9961a, false, 4279, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo18213dk();
        }
    }

    /* renamed from: b */
    public void mo18064b(@Nullable Surface surface) {
        if (!PatchProxy.proxy(new Object[]{surface}, this, f9961a, false, 4280, new Class[]{Surface.class}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9962b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamUI u = mzCamModule.mo18267u();
            if (u != null) {
                u.mo22075a(surface);
            }
        }
    }
}
