package com.meizu.media.camera.p069f;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.CameraSettings;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.media.camera.FocusOverlayManager;
import com.meizu.media.camera.MzBurstHandler;
import com.meizu.media.camera.MzCamModule;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.R;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxy;
import com.meizu.media.camera.mode.CameraMode;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0016J\u0018\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\fH\u0016J\b\u0010)\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020\fH\u0016J\b\u0010+\u001a\u00020\fH\u0016J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020.H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006/"}, mo27294d2 = {"Lcom/meizu/media/camera/impl/CamModuleParamsListenerImpl;", "Lcom/meizu/media/camera/MzCamParamsManager$ParamsManagerListener;", "()V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "mCamModule", "Lcom/meizu/media/camera/MzCamModule;", "getMCamModule", "()Lcom/meizu/media/camera/MzCamModule;", "setMCamModule", "(Lcom/meizu/media/camera/MzCamModule;)V", "canModeAdjustParams", "", "getAndUpdatePreferences", "Lcom/meizu/media/camera/ComboPreferences;", "getCameraId", "", "getFocusManager", "Lcom/meizu/media/camera/FocusOverlayManager;", "getPictureSize", "", "getPreferences", "getZoomValue", "hasFilterEffect", "isCameraIdle", "isFBHighPictureSizeOn", "isFrontBokehOn", "isInBrustCapture", "isPortraitMode", "isRecordPortraitOn", "isSupportAiAsd", "isTofMode", "isVideoCaptureIntent", "isVideoMode", "needZsd", "onPreviewSizeChanged", "isNeedRestartPreview", "needSetPreviewTexture", "onUpdateAutoFocusMoveCallback", "", "isFocusModeContinousPicture", "sendSetParamsWhenIdleMessage", "supportDeviceMark", "supportTimeMark", "updatePreviewAspectRatio", "aspectRatio", "", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.f.g */
public final class CamModuleParamsListenerImpl implements MzCamParamsManager.C2138a {

    /* renamed from: a */
    public static ChangeQuickRedirect f9973a;
    @NotNull

    /* renamed from: b */
    public MzCamModule f9974b;

    /* renamed from: c */
    private final LogUtil.C2630a f9975c = new LogUtil.C2630a("ParamsLisImpl");

    /* renamed from: a */
    public final void mo20029a(@NotNull MzCamModule mzCamModule) {
        if (!PatchProxy.proxy(new Object[]{mzCamModule}, this, f9973a, false, 4285, new Class[]{MzCamModule.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(mzCamModule, "<set-?>");
            this.f9974b = mzCamModule;
        }
    }

    /* renamed from: b */
    public void mo18057b(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f9973a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4286, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9974b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo17989a(f);
            MzCamModule mzCamModule2 = this.f9974b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule2.mo18110br().sendEmptyMessage(14);
        }
    }

    /* renamed from: dC */
    public void mo18179dC() {
        if (!PatchProxy.proxy(new Object[0], this, f9973a, false, 4287, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9974b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (!mzCamModule.mo18110br().hasMessages(4)) {
                MzCamModule mzCamModule2 = this.f9974b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule2.mo18110br().sendEmptyMessageDelayed(4, 1000);
            }
        }
    }

    /* renamed from: dx */
    public boolean mo18226dx() {
        CameraModeType.ModeType modeType;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4288, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18029aN() != null) {
            MzCamModule mzCamModule2 = this.f9974b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraMode aN = mzCamModule2.mo18029aN();
            if (aN == null) {
                C3443i.m21151a();
            }
            modeType = aN.mo20403g_();
            C3443i.m21152a((Object) modeType, "mCamModule.mCameraMode!!.modeType");
        } else {
            modeType = CameraModeType.m10946a();
            C3443i.m21152a((Object) modeType, "CameraModeType.getCurrentCameraModeType()");
        }
        if (modeType == CameraModeType.ModeType.PORTRAIT) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: aE */
    public ComboPreferences mo17902aE() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4289, new Class[0], ComboPreferences.class);
        if (proxy.isSupported) {
            return (ComboPreferences) proxy.result;
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17902aE();
    }

    /* renamed from: y */
    public boolean mo17959y() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4290, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17959y();
    }

    /* renamed from: ai */
    public void mo18050ai(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9973a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4291, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            CameraController g = CameraController.m8868g();
            C3443i.m21152a((Object) g, "CameraController.getInstance()");
            if (g.mo19522k() != null) {
                MzCamModule mzCamModule = this.f9974b;
                if (mzCamModule == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (!mzCamModule.mo18032aQ()) {
                    if (z) {
                        CameraController g2 = CameraController.m8868g();
                        MzCamModule mzCamModule2 = this.f9974b;
                        if (mzCamModule2 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        Handler br = mzCamModule2.mo18110br();
                        MzCamModule mzCamModule3 = this.f9974b;
                        if (mzCamModule3 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        g2.mo19456a(br, (CameraController.C1874a) mzCamModule3.mo18101bi());
                    } else {
                        CameraController.m8868g().mo19456a((Handler) null, (CameraController.C1874a) null);
                    }
                    LogUtil.m15952c(this.f9975c, "setAutoFocusMoveCallback");
                }
            }
        }
    }

    /* renamed from: dB */
    public int mo18178dB() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4292, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (CameraModeType.m10983m(CameraModeType.ModeType.PANORAMA)) {
            return 0;
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18073bG() != -1) {
            MzCamModule mzCamModule2 = this.f9974b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule2.mo18073bG() != CameraModeType.m10962e(CameraModeType.ModeType.AUTO)) {
                MzCamModule mzCamModule3 = this.f9974b;
                if (mzCamModule3 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (mzCamModule3.mo18073bG() != CameraModeType.m10962e(CameraModeType.ModeType.PORTRAIT)) {
                    MzCamModule mzCamModule4 = this.f9974b;
                    if (mzCamModule4 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    if (mzCamModule4.mo18073bG() != CameraModeType.m10962e(CameraModeType.ModeType.TOF)) {
                        MzCamModule mzCamModule5 = this.f9974b;
                        if (mzCamModule5 == null) {
                            C3443i.m21156b("mCamModule");
                        }
                        if (mzCamModule5.mo18073bG() != CameraModeType.m10962e(CameraModeType.ModeType.NightVision)) {
                            return 0;
                        }
                    }
                }
            }
        }
        MzCamModule mzCamModule6 = this.f9974b;
        if (mzCamModule6 == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule6.mo18029aN() == null) {
            return 1;
        }
        MzCamModule mzCamModule7 = this.f9974b;
        if (mzCamModule7 == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraMode aN = mzCamModule7.mo18029aN();
        if (aN == null) {
            C3443i.m21151a();
        }
        return aN.mo20377A();
    }

    /* renamed from: du */
    public boolean mo18223du() {
        boolean z = false;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4294, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18031aP() == 1) {
            z = true;
        }
        if (!z) {
            return true;
        }
        MzCamModule mzCamModule2 = this.f9974b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraActivity aO = mzCamModule2.mo18030aO();
        if (aO == null) {
            C3443i.m21151a();
        }
        String string = aO.getString(R.string.setting_on_value);
        ComboPreferences aE = mo17902aE();
        if (aE == null) {
            C3443i.m21151a();
        }
        MzCamModule mzCamModule3 = this.f9974b;
        if (mzCamModule3 == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraActivity aO2 = mzCamModule3.mo18030aO();
        if (aO2 == null) {
            C3443i.m21151a();
        }
        return C3443i.m21154a((Object) string, (Object) aE.getString("mz_pref_fb_high_picturesize_key", aO2.getString(R.string.setting_off_value)));
    }

    /* renamed from: dq */
    public boolean mo18219dq() {
        CameraModeType.ModeType modeType;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4295, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18029aN() != null) {
            MzCamModule mzCamModule2 = this.f9974b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraMode aN = mzCamModule2.mo18029aN();
            if (aN == null) {
                C3443i.m21151a();
            }
            modeType = aN.mo20403g_();
            C3443i.m21152a((Object) modeType, "mCamModule.mCameraMode!!.modeType");
        } else {
            modeType = CameraModeType.m10946a();
            C3443i.m21152a((Object) modeType, "CameraModeType.getCurrentCameraModeType()");
        }
        if (modeType == CameraModeType.ModeType.MANUAL) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: ds */
    public String mo18221ds() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4296, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18029aN() == null) {
            return null;
        }
        MzCamModule mzCamModule2 = this.f9974b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraMode aN = mzCamModule2.mo18029aN();
        if (aN == null) {
            C3443i.m21151a();
        }
        return aN.mo20422y();
    }

    /* renamed from: dE */
    public boolean mo18181dE() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4297, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!CameraModeType.m10975i(CameraModeType.m10946a()) || mo18225dw()) {
            return false;
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18098bf()) {
            return false;
        }
        CameraModeType.ModeType a = CameraModeType.m10946a();
        CameraModeType.ModeType modeType = CameraModeType.ModeType.AUTO;
        return true;
    }

    /* renamed from: dv */
    public boolean mo18224dv() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4298, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!DeviceHelper.f13855aH) {
            return false;
        }
        if (CameraModeType.m10946a() != CameraModeType.ModeType.PORTRAIT && CameraModeType.m10946a() != CameraModeType.ModeType.TOF) {
            return false;
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18031aP() == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: di */
    public int mo18211di() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4299, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18211di();
    }

    @Nullable
    /* renamed from: dr */
    public ComboPreferences mo18220dr() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4300, new Class[0], ComboPreferences.class);
        if (proxy.isSupported) {
            return (ComboPreferences) proxy.result;
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18039aX() == null) {
            MzCamModule mzCamModule2 = this.f9974b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamModule mzCamModule3 = this.f9974b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraActivity aO = mzCamModule3.mo18030aO();
            if (aO == null) {
                C3443i.m21151a();
            }
            mzCamModule2.mo18009a(ComboPreferences.m10003a(aO.getApplicationContext()));
            MzCamModule mzCamModule4 = this.f9974b;
            if (mzCamModule4 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule4.mo18039aX() == null) {
                MzCamModule mzCamModule5 = this.f9974b;
                if (mzCamModule5 == null) {
                    C3443i.m21156b("mCamModule");
                }
                MzCamModule mzCamModule6 = this.f9974b;
                if (mzCamModule6 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraActivity aO2 = mzCamModule6.mo18030aO();
                if (aO2 == null) {
                    C3443i.m21151a();
                }
                mzCamModule5.mo18009a(new ComboPreferences(aO2.getApplicationContext()));
            }
        }
        MzCamModule mzCamModule7 = this.f9974b;
        if (mzCamModule7 == null) {
            C3443i.m21156b("mCamModule");
        }
        ComboPreferences aX = mzCamModule7.mo18039aX();
        if (aX == null) {
            C3443i.m21151a();
        }
        MzCamModule mzCamModule8 = this.f9974b;
        if (mzCamModule8 == null) {
            C3443i.m21156b("mCamModule");
        }
        Context aO3 = mzCamModule8.mo18030aO();
        MzCamModule mzCamModule9 = this.f9974b;
        if (mzCamModule9 == null) {
            C3443i.m21156b("mCamModule");
        }
        aX.mo19977a(aO3, mzCamModule9.mo18031aP());
        MzCamModule mzCamModule10 = this.f9974b;
        if (mzCamModule10 == null) {
            C3443i.m21156b("mCamModule");
        }
        ComboPreferences aX2 = mzCamModule10.mo18039aX();
        if (aX2 == null) {
            C3443i.m21151a();
        }
        CameraSettings.m9778a(aX2.mo19976a());
        MzCamModule mzCamModule11 = this.f9974b;
        if (mzCamModule11 == null) {
            C3443i.m21156b("mCamModule");
        }
        ComboPreferences aX3 = mzCamModule11.mo18039aX();
        if (aX3 == null) {
            C3443i.m21151a();
        }
        SharedPreferences b = aX3.mo19978b();
        MzCamModule mzCamModule12 = this.f9974b;
        if (mzCamModule12 == null) {
            C3443i.m21156b("mCamModule");
        }
        ComboPreferences aX4 = mzCamModule12.mo18039aX();
        if (aX4 == null) {
            C3443i.m21151a();
        }
        CameraSettings.m9780a(b, aX4.mo19976a());
        MzCamModule mzCamModule13 = this.f9974b;
        if (mzCamModule13 == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule13.mo18039aX();
    }

    /* renamed from: dD */
    public boolean mo18180dD() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4301, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18031aP() != 1 && !DeviceHelper.f13879af) {
            return false;
        }
        MzCamModule mzCamModule2 = this.f9974b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        if ((mzCamModule2.mo18031aP() != 1 || DeviceHelper.f13882ai) && CameraModeType.m10977j(CameraModeType.m10946a())) {
            return !mo18225dw();
        }
        return false;
    }

    /* renamed from: M */
    public boolean mo17864M() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4302, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17864M();
    }

    /* renamed from: dz */
    public boolean mo18228dz() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4303, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!DeviceHelper.f13877ad) {
            return false;
        }
        CameraController g = CameraController.m8868g();
        C3443i.m21152a((Object) g, "CameraController.getInstance()");
        if (g.mo19522k() == null) {
            return false;
        }
        CameraController g2 = CameraController.m8868g();
        C3443i.m21152a((Object) g2, "CameraController.getInstance()");
        CameraProxy k = g2.mo19522k();
        C3443i.m21152a((Object) k, "CameraController.getInstance().deviceProxy");
        if (k.mo19733b() == 1) {
            return false;
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18029aN() == null) {
            return false;
        }
        MzCamModule mzCamModule2 = this.f9974b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraMode aN = mzCamModule2.mo18029aN();
        if (aN == null) {
            C3443i.m21151a();
        }
        if (aN.mo20403g_() == CameraModeType.ModeType.AUTO) {
            return true;
        }
        return false;
    }

    /* renamed from: ah */
    public boolean mo18049ah(boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f9973a, false, 4304, new Class[]{Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = this.f9975c;
        LogUtil.m15942a(aVar, "onPreviewSizeChangedOnUIThread isNeedRestartPreview:" + z);
        if (z) {
            MzCamModule mzCamModule = this.f9974b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule.mo17964D(false);
            MzCamModule mzCamModule2 = this.f9974b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule2.mo18051aj(false);
        } else {
            MzCamModule mzCamModule3 = this.f9974b;
            if (mzCamModule3 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule3.mo17970J(true);
        }
        return false;
    }

    /* renamed from: dw */
    public boolean mo18225dw() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4306, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18027aL() == null) {
            return false;
        }
        MzCamModule mzCamModule2 = this.f9974b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        MzBurstHandler aL = mzCamModule2.mo18027aL();
        if (aL == null) {
            C3443i.m21151a();
        }
        return aL.mo20294m();
    }

    /* renamed from: dA */
    public boolean mo18177dA() {
        CameraModeType.ModeType modeType;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4307, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        if (mzCamModule.mo18029aN() != null) {
            MzCamModule mzCamModule2 = this.f9974b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraMode aN = mzCamModule2.mo18029aN();
            if (aN == null) {
                C3443i.m21151a();
            }
            modeType = aN.mo20403g_();
            C3443i.m21152a((Object) modeType, "mCamModule.mCameraMode!!.modeType");
        } else {
            modeType = CameraModeType.m10946a();
            C3443i.m21152a((Object) modeType, "CameraModeType.getCurrentCameraModeType()");
        }
        if (modeType == CameraModeType.ModeType.TOF || modeType == CameraModeType.ModeType.NightVision) {
            return true;
        }
        return false;
    }

    /* renamed from: t */
    public boolean mo18266t() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4308, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18266t();
    }

    /* renamed from: dy */
    public boolean mo18227dy() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4309, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18159ck();
    }

    /* renamed from: dt */
    public int mo18222dt() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4310, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18099bg();
    }

    @Nullable
    /* renamed from: ak */
    public FocusOverlayManager mo17914ak() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9973a, false, 4311, new Class[0], FocusOverlayManager.class);
        if (proxy.isSupported) {
            return (FocusOverlayManager) proxy.result;
        }
        MzCamModule mzCamModule = this.f9974b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo17914ak();
    }
}
