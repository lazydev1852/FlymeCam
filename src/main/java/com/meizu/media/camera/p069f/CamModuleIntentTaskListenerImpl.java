package com.meizu.media.camera.p069f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.TotalCaptureResult;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import com.baidu.p020ar.base.MsgField;
import com.baidu.p020ar.msghandler.ComponentMessageType;
import com.meizu.camera.effectlib.effects.filters.EffectRenderEngine;
import com.meizu.imageproc.SurfaceTextureWrapper;
import com.meizu.media.camera.CamIntentTask;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.media.camera.MzCamModule;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraMode;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p064a.ParamData;
import com.meizu.media.camera.p064a.XmpMetaData;
import com.meizu.media.camera.p077ui.MzCamUI;
import com.meizu.media.camera.util.AsyncTaskEx;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016J9\u0010'\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0\u000f\"\u0004\u0018\u00010-H\u0016¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u0013H\u0016J\b\u00100\u001a\u00020\u0013H\u0016J\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u00102\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u00103R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u00064"}, mo27294d2 = {"Lcom/meizu/media/camera/impl/CamModuleIntentTaskListenerImpl;", "Lcom/meizu/media/camera/CamIntentTask$Listener;", "()V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "mCamModule", "Lcom/meizu/media/camera/MzCamModule;", "getMCamModule", "()Lcom/meizu/media/camera/MzCamModule;", "setMCamModule", "(Lcom/meizu/media/camera/MzCamModule;)V", "cropDocumentBitmap", "Landroid/graphics/Bitmap;", "originBitmap", "points", "", "Landroid/graphics/Point;", "(Landroid/graphics/Bitmap;[Landroid/graphics/Point;)Landroid/graphics/Bitmap;", "doEffect", "", "paramData", "Lcom/meizu/media/camera/data/ParamData;", "getIsCancelTaskDone", "", "getPreviewSurfaces", "", "Landroid/view/Surface;", "isSecond", "getSubCamSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "getSurfaceTextureWrapper", "getTofData", "", "getUUID", "Ljava/util/UUID;", "getVideoQuality", "", "needFbFastThumbnail", "onActionDone", "requestCode", "Lcom/meizu/media/camera/util/Contants$CameraService$RequestCode;", "resultCode", "Lcom/meizu/media/camera/util/Contants$CameraService$ResultCode;", "objects", "", "(Lcom/meizu/media/camera/util/Contants$CameraService$RequestCode;Lcom/meizu/media/camera/util/Contants$CameraService$ResultCode;[Ljava/lang/Object;)V", "onTofDeviceDamage", "onTofDeviceEnable", "scanDocument", "bitmap", "(Landroid/graphics/Bitmap;)[Landroid/graphics/Point;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.f.d */
public final class CamModuleIntentTaskListenerImpl implements CamIntentTask.C1777c {

    /* renamed from: a */
    public static ChangeQuickRedirect f9937a;
    @NotNull

    /* renamed from: b */
    public MzCamModule f9938b;

    /* renamed from: c */
    private final LogUtil.C2630a f9939c = new LogUtil.C2630a("IntentTaskLisImpl");

    /* renamed from: g */
    public boolean mo18237g() {
        return false;
    }

    @NotNull
    /* renamed from: a */
    public final MzCamModule mo20016a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9937a, false, 4199, new Class[0], MzCamModule.class);
        if (proxy.isSupported) {
            return (MzCamModule) proxy.result;
        }
        MzCamModule mzCamModule = this.f9938b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule;
    }

    /* renamed from: a */
    public final void mo20017a(@NotNull MzCamModule mzCamModule) {
        if (!PatchProxy.proxy(new Object[]{mzCamModule}, this, f9937a, false, ComponentMessageType.MSG_TYPE_SLAM_START, new Class[]{MzCamModule.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(mzCamModule, "<set-?>");
            this.f9938b = mzCamModule;
        }
    }

    /* renamed from: a */
    public void mo18006a(@Nullable ParamData fVar) {
        ParamData fVar2 = fVar;
        Class[] clsArr = {ParamData.class};
        if (!PatchProxy.proxy(new Object[]{fVar2}, this, f9937a, false, 4201, clsArr, Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9938b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            EffectRenderEngine ce = mzCamModule.mo18153ce();
            if (ce != null) {
                MzCamModule mzCamModule2 = this.f9938b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                Map cf = mzCamModule2.mo18154cf();
                if (fVar2 == null) {
                    C3443i.m21151a();
                }
                String str = fVar2.f7465b;
                C3443i.m21152a((Object) str, "paramData!!.mTitle");
                Contants.CameraService.RequestCode requestCode = fVar2.f7471h;
                C3443i.m21152a((Object) requestCode, "paramData.mRequestCode");
                cf.put(str, requestCode);
                if (fVar2.f7464a != null) {
                    UUID uuid = fVar2.f7464a;
                    byte[] bArr = fVar2.f7469f;
                    String str2 = fVar2.f7465b;
                    long j = fVar2.f7466c;
                    int i = fVar2.f7467d;
                    Location location = fVar2.f7468e;
                    int i2 = fVar2.f7472i;
                    int i3 = fVar2.f7473j;
                    boolean z = fVar2.f7474k;
                    int i4 = fVar2.f7477n;
                    boolean z2 = fVar2.f7481r;
                    int i5 = fVar2.f7478o;
                    Rect rect = fVar2.f7479p;
                    TotalCaptureResult totalCaptureResult = fVar2.f7480q;
                    XmpMetaData gVar = fVar2.f7484u;
                    C3443i.m21152a((Object) gVar, "paramData.mXmpMetaData");
                    String a = gVar.mo18752a();
                    XmpMetaData gVar2 = fVar2.f7484u;
                    C3443i.m21152a((Object) gVar2, "paramData.mXmpMetaData");
                    boolean b = gVar2.mo18757b();
                    XmpMetaData gVar3 = fVar2.f7484u;
                    C3443i.m21152a((Object) gVar3, "paramData.mXmpMetaData");
                    boolean c = gVar3.mo18758c();
                    XmpMetaData gVar4 = fVar2.f7484u;
                    C3443i.m21152a((Object) gVar4, "paramData.mXmpMetaData");
                    ce.mo14072a(uuid, bArr, str2, j, i, location, i2, i3, z, i4, z2, i5, rect, totalCaptureResult, a, b, c, gVar4.mo18759d(), fVar2.f7483t, fVar2.f7461C, fVar2.f7462D);
                }
            }
        }
    }

    /* renamed from: d */
    public boolean mo18176d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9937a, false, MsgField.MSG_ON_PARSE_RESOURCE_UNZIP_ERROR, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9938b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18176d();
    }

    @Nullable
    /* renamed from: c */
    public SurfaceTexture mo18119c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9937a, false, MsgField.MSG_ON_PARSE_RESOURCE_JSON_ERROR, new Class[0], SurfaceTexture.class);
        if (proxy.isSupported) {
            return (SurfaceTexture) proxy.result;
        }
        MzCamModule mzCamModule = this.f9938b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18119c();
    }

    @Nullable
    /* renamed from: f */
    public SurfaceTexture mo18236f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9937a, false, 4204, new Class[0], SurfaceTexture.class);
        if (proxy.isSupported) {
            return (SurfaceTexture) proxy.result;
        }
        MzCamModule mzCamModule = this.f9938b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18236f();
    }

    @Nullable
    /* renamed from: a */
    public Bitmap mo17987a(@Nullable Bitmap bitmap, @Nullable Point[] pointArr) {
        ChangeQuickRedirect changeQuickRedirect = f9937a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap, pointArr}, this, changeQuickRedirect, false, 4205, new Class[]{Bitmap.class, Point[].class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        MzCamModule mzCamModule = this.f9938b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraMode aN = mzCamModule.mo18029aN();
        if (aN == null) {
            C3443i.m21151a();
        }
        if (aN.mo20403g_() != CameraModeType.ModeType.DOCUMENT) {
            return null;
        }
        MzCamModule mzCamModule2 = this.f9938b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraMode aN2 = mzCamModule2.mo18029aN();
        if (aN2 == null) {
            C3443i.m21151a();
        }
        return aN2.mo17987a(bitmap, pointArr);
    }

    /* renamed from: i */
    public boolean mo18240i() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9937a, false, 4206, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        MzCamModule mzCamModule = this.f9938b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        boolean z = mzCamModule.mo18031aP() == 1;
        if (!DeviceHelper.f13908bH) {
            return false;
        }
        if (z && DeviceHelper.f13884ak) {
            MzCamModule mzCamModule2 = this.f9938b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule2.mo18223du()) {
                return false;
            }
        }
        if (!CameraOptTask.m7850q()) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public void mo18241j() {
        if (!PatchProxy.proxy(new Object[0], this, f9937a, false, 4208, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9938b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            Handler br = mzCamModule.mo18110br();
            if (br != null) {
                br.sendEmptyMessage(32);
            }
        }
    }

    /* renamed from: k */
    public void mo18243k() {
        if (!PatchProxy.proxy(new Object[0], this, f9937a, false, 4209, new Class[0], Void.TYPE).isSupported) {
            MzCamModule mzCamModule = this.f9938b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            Handler br = mzCamModule.mo18110br();
            if (br != null) {
                br.sendEmptyMessage(33);
            }
        }
    }

    /* renamed from: h */
    public int mo18238h() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9937a, false, 4210, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (!CameraModeType.m10983m(CameraModeType.ModeType.VIDEO)) {
            return 0;
        }
        MzCamModule mzCamModule = this.f9938b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        ComboPreferences aE = mzCamModule.mo17902aE();
        if (aE == null) {
            C3443i.m21151a();
        }
        String string = aE.getString("pref_video_quality_key", (String) null);
        if (string == null) {
            string = "0";
        }
        Integer valueOf = Integer.valueOf(string);
        C3443i.m21152a((Object) valueOf, "Integer.valueOf(videoQuality ?: \"0\")");
        return valueOf.intValue();
    }

    @NotNull
    /* renamed from: b */
    public UUID mo18056b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9937a, false, 4211, new Class[0], UUID.class);
        if (proxy.isSupported) {
            return (UUID) proxy.result;
        }
        MzCamModule mzCamModule = this.f9938b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        return mzCamModule.mo18089bW();
    }

    @NotNull
    /* renamed from: e */
    public List<Surface> mo18229e() {
        List<Surface> e;
        List<Surface> e2;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f9937a, false, 4212, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            MzCamModule mzCamModule = this.f9938b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            synchronized (mzCamModule.mo18088bV()) {
                MzCamModule mzCamModule2 = this.f9938b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                if (mzCamModule2.mo18155cg() != null) {
                    LogUtil.m15942a(this.f9939c, "releaseSurface");
                    MzCamModule mzCamModule3 = this.f9938b;
                    if (mzCamModule3 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    Surface cg = mzCamModule3.mo18155cg();
                    if (cg == null) {
                        C3443i.m21151a();
                    }
                    cg.release();
                    MzCamModule mzCamModule4 = this.f9938b;
                    if (mzCamModule4 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    mzCamModule4.mo18001a((Surface) null);
                }
                CameraController g = CameraController.m8868g();
                C3443i.m21152a((Object) g, "CameraController.getInstance()");
                Point l = g.mo19524l();
                LogUtil.C2630a aVar = this.f9939c;
                LogUtil.m15942a(aVar, "getPreviewSurfaces preview size is " + l);
                if (CameraModeType.ModeType.FUNNY_SNAP == CameraModeType.m10946a()) {
                    MzCamModule mzCamModule5 = this.f9938b;
                    if (mzCamModule5 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    MzCamModule mzCamModule6 = this.f9938b;
                    if (mzCamModule6 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    mzCamModule5.mo18001a(new Surface(mzCamModule6.mo18086bT()));
                    MzCamModule mzCamModule7 = this.f9938b;
                    if (mzCamModule7 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    SurfaceTexture bT = mzCamModule7.mo18086bT();
                    if (bT == null) {
                        C3443i.m21151a();
                    }
                    bT.setDefaultBufferSize(l.x, l.y);
                } else if (CameraModeType.m10987o(CameraModeType.m10946a())) {
                    MzCamModule mzCamModule8 = this.f9938b;
                    if (mzCamModule8 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    MzCamModule mzCamModule9 = this.f9938b;
                    if (mzCamModule9 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    SurfaceTextureWrapper bU = mzCamModule9.mo18087bU();
                    if (bU == null) {
                        C3443i.m21151a();
                    }
                    mzCamModule8.mo18001a(bU.createSurface());
                    MzCamModule mzCamModule10 = this.f9938b;
                    if (mzCamModule10 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    SurfaceTextureWrapper bU2 = mzCamModule10.mo18087bU();
                    if (bU2 == null) {
                        C3443i.m21151a();
                    }
                    bU2.setDefaultBufferSize(l.x, l.y);
                } else {
                    LogUtil.m15942a(this.f9939c, "createSurface");
                    MzCamModule mzCamModule11 = this.f9938b;
                    if (mzCamModule11 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    MzCamModule mzCamModule12 = this.f9938b;
                    if (mzCamModule12 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    SurfaceTextureWrapper bU3 = mzCamModule12.mo18087bU();
                    if (bU3 == null) {
                        C3443i.m21151a();
                    }
                    mzCamModule11.mo18001a(bU3.createSurface());
                    MzCamModule mzCamModule13 = this.f9938b;
                    if (mzCamModule13 == null) {
                        C3443i.m21156b("mCamModule");
                    }
                    SurfaceTextureWrapper bU4 = mzCamModule13.mo18087bU();
                    if (bU4 == null) {
                        C3443i.m21151a();
                    }
                    bU4.setDefaultBufferSize(l.x, l.y);
                }
                MzCamModule mzCamModule14 = this.f9938b;
                if (mzCamModule14 == null) {
                    C3443i.m21156b("mCamModule");
                }
                CameraMode aN = mzCamModule14.mo18029aN();
                if (aN == null) {
                    C3443i.m21151a();
                }
                e2 = aN.mo20401e();
                if (e2 == null) {
                    e2 = new ArrayList<>();
                }
                MzCamModule mzCamModule15 = this.f9938b;
                if (mzCamModule15 == null) {
                    C3443i.m21156b("mCamModule");
                }
                e2.add(mzCamModule15.mo18155cg());
            }
            return e2;
        }
        MzCamModule mzCamModule16 = this.f9938b;
        if (mzCamModule16 == null) {
            C3443i.m21156b("mCamModule");
        }
        synchronized (mzCamModule16.mo18088bV()) {
            MzCamModule mzCamModule17 = this.f9938b;
            if (mzCamModule17 == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule17.mo18155cg() != null) {
                MzCamModule mzCamModule18 = this.f9938b;
                if (mzCamModule18 == null) {
                    C3443i.m21156b("mCamModule");
                }
                Surface cg2 = mzCamModule18.mo18155cg();
                if (cg2 == null) {
                    C3443i.m21151a();
                }
                cg2.release();
                MzCamModule mzCamModule19 = this.f9938b;
                if (mzCamModule19 == null) {
                    C3443i.m21156b("mCamModule");
                }
                mzCamModule19.mo18001a((Surface) null);
            }
            MzCamModule mzCamModule20 = this.f9938b;
            if (mzCamModule20 == null) {
                C3443i.m21156b("mCamModule");
            }
            MzCamModule mzCamModule21 = this.f9938b;
            if (mzCamModule21 == null) {
                C3443i.m21156b("mCamModule");
            }
            mzCamModule20.mo18001a(new Surface(mzCamModule21.mo18086bT()));
            MzCamModule mzCamModule22 = this.f9938b;
            if (mzCamModule22 == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraMode aN2 = mzCamModule22.mo18029aN();
            if (aN2 == null) {
                C3443i.m21151a();
            }
            e = aN2.mo20401e();
            if (e == null) {
                e = new ArrayList<>();
            }
            CameraController g2 = CameraController.m8868g();
            C3443i.m21152a((Object) g2, "CameraController.getInstance()");
            Point l2 = g2.mo19524l();
            LogUtil.C2630a aVar2 = this.f9939c;
            LogUtil.m15942a(aVar2, "getPreviewSurfaces preview size is " + l2);
            MzCamModule mzCamModule23 = this.f9938b;
            if (mzCamModule23 == null) {
                C3443i.m21156b("mCamModule");
            }
            SurfaceTexture bT2 = mzCamModule23.mo18086bT();
            if (bT2 == null) {
                C3443i.m21151a();
            }
            bT2.setDefaultBufferSize(l2.x, l2.y);
            if (e == null) {
                C3443i.m21151a();
            }
            MzCamModule mzCamModule24 = this.f9938b;
            if (mzCamModule24 == null) {
                C3443i.m21156b("mCamModule");
            }
            e.add(mzCamModule24.mo18155cg());
        }
        return e;
    }

    @NotNull
    /* renamed from: a */
    public List<Surface> mo17988a(boolean z) {
        List<Surface> ai;
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9937a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 4213, new Class[]{Boolean.TYPE}, List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        if (!z) {
            return mo18229e();
        }
        MzCamModule mzCamModule = this.f9938b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        synchronized (mzCamModule.mo18088bV()) {
            MzCamModule mzCamModule2 = this.f9938b;
            if (mzCamModule2 == null) {
                C3443i.m21156b("mCamModule");
            }
            CameraMode aN = mzCamModule2.mo18029aN();
            if (aN == null) {
                C3443i.m21151a();
            }
            ai = aN.mo20554ai();
            if (ai == null) {
                ai = new ArrayList<>();
            }
            CameraController g = CameraController.m8868g();
            C3443i.m21152a((Object) g, "CameraController.getInstance()");
            Point l = g.mo19524l();
            LogUtil.C2630a aVar = this.f9939c;
            LogUtil.m15942a(aVar, "getPreviewSurfaces2 preview size is " + l);
        }
        return ai;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v104, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v106, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v201, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v154, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v202, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v203, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v160, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v161, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v222, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v226, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v194, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v231, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v169, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v266, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v267, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v268, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v91, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v295, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v299, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v303, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v181, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v307, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v282, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v309, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v315, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v187, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v301, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v303, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v193, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v195, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v199, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v331, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v96, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v337, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v99, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v344, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v345, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v346, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v205, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v355, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v359, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v363, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v367, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v210, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v372, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v373, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v211, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v376, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v380, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v333, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v383, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v337, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v341, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v342, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v391, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v392, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v364, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v421, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v380, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v422, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v423, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v232, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v233, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v33, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v107, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v34, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v470, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v474, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v422, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v479, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v72, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v587, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v589, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v38, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v248, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v592, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v594, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v254, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v256, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v260, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v41, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v44, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v76, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v37, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v609, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v515, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v516, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v517, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v610, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v621, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v539, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v544, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v549, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v627, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v628, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v270, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v271, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v274, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v632, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v557, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v560, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v561, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v565, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v566, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v643, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v644, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v571, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v572, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v667, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v605, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v606, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v625, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v626, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v629, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v640, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v641, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v708, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v709, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v78, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v38, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v41, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v292, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v124, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v43, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v84, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v729, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v733, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v748, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v740, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v741, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v742, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v749, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v744, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v748, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v751, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v756, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v761, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v766, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v769, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v770, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v778, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v779, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v780, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v783, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v786, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v789, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v792, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v793, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v797, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v798, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v770, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v771, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v819, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v820, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v786, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v301, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v127, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v46, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v49, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v140, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v316, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v792, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v832, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v836, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r2v164 */
    /* JADX WARNING: type inference failed for: r4v22 */
    /* JADX WARNING: type inference failed for: r2v202 */
    /* JADX WARNING: type inference failed for: r2v203 */
    /* JADX WARNING: type inference failed for: r1v366 */
    /* JADX WARNING: type inference failed for: r2v213 */
    /* JADX WARNING: type inference failed for: r2v236 */
    /* JADX WARNING: type inference failed for: r2v263 */
    /* JADX WARNING: type inference failed for: r2v264 */
    /* JADX WARNING: type inference failed for: r2v265 */
    /* JADX WARNING: type inference failed for: r0v548 */
    /* JADX WARNING: type inference failed for: r2v273 */
    /* JADX WARNING: type inference failed for: r0v765 */
    /* JADX WARNING: Code restructure failed: missing block: B:2705:0x2536, code lost:
        r0 = r8.f9938b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2706:0x2538, code lost:
        if (r0 != null) goto L_0x253f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2707:0x253a, code lost:
        kotlin.jvm.p108b.C3443i.m21156b("mCamModule");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2708:0x253f, code lost:
        r0.mo18110br().post(new com.meizu.media.camera.p069f.CamModuleIntentTaskListenerImpl.C2046d(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3297:?, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:1564:0x1567  */
    /* JADX WARNING: Removed duplicated region for block: B:1567:0x1572  */
    /* JADX WARNING: Removed duplicated region for block: B:1568:0x1574  */
    /* JADX WARNING: Removed duplicated region for block: B:1575:0x1583  */
    /* JADX WARNING: Removed duplicated region for block: B:1610:0x15f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1626:0x1622 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:1632:0x1634  */
    /* JADX WARNING: Removed duplicated region for block: B:1635:0x163f  */
    /* JADX WARNING: Removed duplicated region for block: B:1638:0x164e  */
    /* JADX WARNING: Removed duplicated region for block: B:1641:0x1665  */
    /* JADX WARNING: Removed duplicated region for block: B:1644:0x1672  */
    /* JADX WARNING: Removed duplicated region for block: B:1647:0x167d  */
    /* JADX WARNING: Removed duplicated region for block: B:1650:0x1696  */
    /* JADX WARNING: Removed duplicated region for block: B:1653:0x16a1  */
    /* JADX WARNING: Removed duplicated region for block: B:1656:0x16a8  */
    /* JADX WARNING: Removed duplicated region for block: B:1659:0x16b5  */
    /* JADX WARNING: Removed duplicated region for block: B:1662:0x16c2  */
    /* JADX WARNING: Removed duplicated region for block: B:1665:0x16d0  */
    /* JADX WARNING: Removed duplicated region for block: B:1994:0x1b81  */
    /* JADX WARNING: Removed duplicated region for block: B:1998:0x1b9e  */
    /* JADX WARNING: Removed duplicated region for block: B:2004:0x1bb0  */
    /* JADX WARNING: Removed duplicated region for block: B:2007:0x1bbd  */
    /* JADX WARNING: Removed duplicated region for block: B:2010:0x1bc8  */
    /* JADX WARNING: Removed duplicated region for block: B:2221:0x1e8b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:2222:0x1e8c  */
    /* JADX WARNING: Removed duplicated region for block: B:2545:0x22da  */
    /* JADX WARNING: Removed duplicated region for block: B:3252:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:3272:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:3287:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo18014a(@org.jetbrains.annotations.Nullable com.meizu.media.camera.util.Contants.CameraService.RequestCode r52, @org.jetbrains.annotations.Nullable com.meizu.media.camera.util.Contants.CameraService.ResultCode r53, @org.jetbrains.annotations.NotNull java.lang.Object... r54) {
        /*
            r51 = this;
            r8 = r51
            r0 = r52
            r9 = r53
            r10 = r54
            r11 = 3
            java.lang.Object[] r1 = new java.lang.Object[r11]
            r12 = 0
            r1[r12] = r0
            r13 = 1
            r1[r13] = r9
            r14 = 2
            r1[r14] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = f9937a
            java.lang.Class[] r6 = new java.lang.Class[r11]
            java.lang.Class<com.meizu.media.camera.util.Contants$CameraService$RequestCode> r2 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.class
            r6[r12] = r2
            java.lang.Class<com.meizu.media.camera.util.Contants$CameraService$ResultCode> r2 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.class
            r6[r13] = r2
            java.lang.Class<java.lang.Object[]> r2 = java.lang.Object[].class
            r6[r14] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 4214(0x1076, float:5.905E-42)
            r2 = r51
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0034
            return
        L_0x0034:
            java.lang.String r1 = "objects"
            kotlin.jvm.p108b.C3443i.m21155b(r10, r1)
            com.meizu.media.camera.util.ac$a r1 = r8.f9939c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            if (r0 != 0) goto L_0x0045
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0045:
            java.lang.String r3 = r52.name()
            r2.append(r3)
            java.lang.String r3 = " done, resultCode:"
            r2.append(r3)
            r2.append(r9)
            java.lang.String r3 = ",mActivity:"
            r2.append(r3)
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x0062
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0062:
            com.meizu.media.camera.CameraActivity r3 = r3.mo18030aO()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            int[] r1 = com.meizu.media.camera.p069f.C2049e.f9960i
            int r2 = r52.ordinal()
            r1 = r1[r2]
            r4 = 180(0xb4, float:2.52E-43)
            r7 = 90
            r15 = 8
            r2 = 7
            r3 = 6
            r5 = 5
            r19 = 0
            r6 = 4
            switch(r1) {
                case 1: goto L_0x27c0;
                case 2: goto L_0x27c0;
                case 3: goto L_0x2710;
                case 4: goto L_0x26ac;
                case 5: goto L_0x26ac;
                case 6: goto L_0x2668;
                case 7: goto L_0x2552;
                case 8: goto L_0x23f4;
                case 9: goto L_0x23e2;
                case 10: goto L_0x23b6;
                case 11: goto L_0x172a;
                case 12: goto L_0x08ea;
                case 13: goto L_0x08ea;
                case 14: goto L_0x08ea;
                case 15: goto L_0x08ea;
                case 16: goto L_0x08ad;
                case 17: goto L_0x07f8;
                case 18: goto L_0x0089;
                default: goto L_0x0087;
            }
        L_0x0087:
            goto L_0x2ddb
        L_0x0089:
            if (r9 != 0) goto L_0x008d
            goto L_0x2ddb
        L_0x008d:
            int[] r0 = com.meizu.media.camera.p069f.C2049e.f9959h
            int r1 = r53.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x06ad;
                case 2: goto L_0x06ad;
                case 3: goto L_0x0489;
                case 4: goto L_0x03ca;
                case 5: goto L_0x0398;
                case 6: goto L_0x0338;
                case 7: goto L_0x0310;
                case 8: goto L_0x02bb;
                case 9: goto L_0x009a;
                default: goto L_0x0098;
            }
        L_0x0098:
            goto L_0x2ddb
        L_0x009a:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x00a3
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x00a3:
            boolean r0 = r0.mo17958x()
            if (r0 != 0) goto L_0x0236
            int r0 = r10.length
            if (r0 >= r3) goto L_0x00ad
            return
        L_0x00ad:
            byte[] r19 = (byte[]) r19
            r0 = r10[r12]
            if (r0 == 0) goto L_0x00b7
            r0 = r10[r12]
            byte[] r0 = (byte[]) r0
        L_0x00b7:
            r0 = r10[r13]
            if (r0 == 0) goto L_0x00ce
            r0 = r10[r13]
            if (r0 == 0) goto L_0x00c6
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x00cf
        L_0x00c6:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x00ce:
            r0 = 0
        L_0x00cf:
            r1 = r10[r14]
            if (r1 == 0) goto L_0x00e6
            r1 = r10[r14]
            if (r1 == 0) goto L_0x00de
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            goto L_0x00e7
        L_0x00de:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x00e6:
            r1 = 0
        L_0x00e7:
            r2 = r10[r11]
            if (r2 == 0) goto L_0x00fe
            r2 = r10[r11]
            if (r2 == 0) goto L_0x00f6
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            goto L_0x00ff
        L_0x00f6:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x00fe:
            r2 = 0
        L_0x00ff:
            r3 = r10[r6]
            if (r3 == 0) goto L_0x0116
            r3 = r10[r6]
            if (r3 == 0) goto L_0x010e
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L_0x0117
        L_0x010e:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x0116:
            r3 = 0
        L_0x0117:
            r9 = r10[r5]
            if (r9 == 0) goto L_0x012e
            r5 = r10[r5]
            if (r5 == 0) goto L_0x0126
            java.lang.Long r5 = (java.lang.Long) r5
            long r9 = r5.longValue()
            goto L_0x0130
        L_0x0126:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Long"
            r0.<init>(r1)
            throw r0
        L_0x012e:
            r9 = 0
        L_0x0130:
            com.meizu.media.camera.MzCamModule r5 = r8.f9938b
            if (r5 != 0) goto L_0x0139
            java.lang.String r11 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r11)
        L_0x0139:
            int r5 = r5.mo18194dR()
            com.meizu.media.camera.MzCamModule r11 = r8.f9938b
            if (r11 != 0) goto L_0x0146
            java.lang.String r15 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r15)
        L_0x0146:
            com.meizu.media.camera.ui.i r11 = r11.mo18267u()
            if (r11 != 0) goto L_0x014f
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x014f:
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r15 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r6 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r15 != r6) goto L_0x0157
            r6 = 1
            goto L_0x0158
        L_0x0157:
            r6 = 0
        L_0x0158:
            r11.mo22067a((int) r7, (int) r14, (boolean) r6)
            int r0 = r0 + r5
            int r0 = r0 % r4
            if (r0 == 0) goto L_0x0164
            r22 = r2
            r21 = r3
            goto L_0x0168
        L_0x0164:
            r21 = r2
            r22 = r3
        L_0x0168:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0171
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0171:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 != 0) goto L_0x017a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x017a:
            android.graphics.Bitmap r0 = r0.mo22132au()
            r30 = 0
            if (r0 == 0) goto L_0x0236
            com.meizu.media.camera.util.ac$a r2 = r8.f9939c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "thumbnailBitmap width = "
            r3.append(r4)
            int r4 = r0.getWidth()
            r3.append(r4)
            java.lang.String r4 = ", height = "
            r3.append(r4)
            int r4 = r0.getHeight()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x01b1
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x01b1:
            com.meizu.media.camera.CameraActivity r2 = r2.mo18030aO()
            if (r2 != 0) goto L_0x01ba
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01ba:
            com.meizu.media.camera.MediaSaveService r15 = r2.mo17689p()
            java.lang.String r17 = com.meizu.media.camera.util.CameraUtil.m15831a((long) r9)
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x01cb
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x01cb:
            com.meizu.media.camera.app.e r2 = r2.mo18192dP()
            android.location.Location r20 = r2.mo19017a((long) r9)
            r24 = 0
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x01de
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x01de:
            com.meizu.media.camera.MediaSaveService$d r25 = r2.mo18208df()
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x01eb
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x01eb:
            com.meizu.media.camera.CameraActivity r2 = r2.mo18030aO()
            if (r2 != 0) goto L_0x01f4
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01f4:
            android.content.ContentResolver r26 = r2.getContentResolver()
            r28 = 1
            r29 = 0
            java.lang.Object[] r2 = new java.lang.Object[r12]
            r31 = r2
            r16 = r0
            r18 = r9
            r23 = r5
            r27 = r1
            r15.mo17828a(r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x0214
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0214:
            com.meizu.media.camera.u r2 = r2.mo18036aU()
            if (r2 != 0) goto L_0x021d
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x021d:
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x0226
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0226:
            com.meizu.media.camera.CameraActivity r3 = r3.mo18030aO()
            if (r3 != 0) goto L_0x022f
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x022f:
            boolean r3 = r3.mo17677n()
            r2.mo21516a((android.graphics.Bitmap) r0, (int) r5, (boolean) r1, (boolean) r3)
        L_0x0236:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x023f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x023f:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x0248
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0248:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0251
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0251:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x025a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x025a:
            boolean[] r2 = new boolean[r14]
            r2 = {0, 0} // fill-array
            boolean r1 = r1.mo21535a((boolean[]) r2)
            r0.mo21614m((boolean) r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x026f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x026f:
            boolean r0 = r0.mo17958x()
            if (r0 != 0) goto L_0x028a
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x027e
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x027e:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 == 0) goto L_0x028a
            r1 = 4
            r0.mo21581d((int) r1, (boolean) r13)
            kotlin.t r0 = kotlin.Unit.f18749a
        L_0x028a:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0293
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0293:
            boolean r0 = r0.mo17958x()
            if (r0 != 0) goto L_0x2ddb
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7846m()
            if (r0 != 0) goto L_0x2ddb
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7844k()
            if (r0 != 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x02ae
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x02ae:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 == 0) goto L_0x2ddb
            r0.mo21581d((int) r14, (boolean) r13)
            kotlin.t r0 = kotlin.Unit.f18749a
            goto L_0x2ddb
        L_0x02bb:
            int r0 = r10.length
            if (r0 >= r13) goto L_0x02bf
            return
        L_0x02bf:
            r0 = r10[r12]
            if (r0 == 0) goto L_0x2ddb
            r0 = r10[r12]
            if (r0 == 0) goto L_0x0308
            android.net.Uri r0 = (android.net.Uri) r0
            int r1 = r10.length
            if (r1 <= r13) goto L_0x02f6
            r1 = r10[r13]
            if (r1 == 0) goto L_0x02f6
            r1 = r10[r13]
            if (r1 == 0) goto L_0x02ee
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x02e5
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x02e5:
            com.meizu.media.camera.MediaSaveService$d r1 = r1.mo18193dQ()
            r1.mo17844a((android.net.Uri) r0)
            goto L_0x2ddb
        L_0x02ee:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x02f6:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x02ff
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x02ff:
            com.meizu.media.camera.MediaSaveService$d r1 = r1.mo18193dQ()
            r1.mo17844a((android.net.Uri) r0)
            goto L_0x2ddb
        L_0x0308:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type android.net.Uri"
            r0.<init>(r1)
            throw r0
        L_0x0310:
            int r0 = r10.length
            if (r0 >= r13) goto L_0x0314
            return
        L_0x0314:
            r0 = r10[r12]
            if (r0 == 0) goto L_0x2ddb
            r0 = r10[r12]
            if (r0 == 0) goto L_0x0330
            java.lang.String r0 = (java.lang.String) r0
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0327
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0327:
            com.meizu.media.camera.MediaSaveService$d r1 = r1.mo18193dQ()
            r1.mo17845a((java.lang.String) r0)
            goto L_0x2ddb
        L_0x0330:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
            r0.<init>(r1)
            throw r0
        L_0x0338:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0341
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0341:
            boolean r0 = r0.mo17958x()
            if (r0 == 0) goto L_0x2ddb
            int r0 = r10.length
            if (r0 >= r11) goto L_0x034b
            return
        L_0x034b:
            byte[] r19 = (byte[]) r19
            r0 = r10[r12]
            if (r0 == 0) goto L_0x0355
            r0 = r10[r12]
            byte[] r0 = (byte[]) r0
        L_0x0355:
            r0 = r10[r13]
            if (r0 == 0) goto L_0x036b
            r0 = r10[r13]
            if (r0 == 0) goto L_0x0363
            java.lang.Long r0 = (java.lang.Long) r0
            r0.longValue()
            goto L_0x036b
        L_0x0363:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Long"
            r0.<init>(r1)
            throw r0
        L_0x036b:
            r0 = r10[r14]
            if (r0 == 0) goto L_0x0381
            r0 = r10[r14]
            if (r0 == 0) goto L_0x0379
            java.lang.Integer r0 = (java.lang.Integer) r0
            r0.intValue()
            goto L_0x0381
        L_0x0379:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x0381:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x038a
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x038a:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x0393
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0393:
            r0.mo21611l((boolean) r13)
            goto L_0x2ddb
        L_0x0398:
            int r0 = r10.length
            if (r0 >= r13) goto L_0x039c
            return
        L_0x039c:
            r0 = r10[r12]
            if (r0 == 0) goto L_0x2ddb
            r0 = r10[r12]
            if (r0 == 0) goto L_0x03c2
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x03b3
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x03b3:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x03bc
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x03bc:
            r0 = r0 ^ r13
            r1.mo21611l((boolean) r0)
            goto L_0x2ddb
        L_0x03c2:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x03ca:
            int r0 = r10.length
            if (r0 >= r3) goto L_0x03ce
            return
        L_0x03ce:
            r0 = r19
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            byte[] r19 = (byte[]) r19
            r1 = r10[r12]
            if (r1 == 0) goto L_0x03dc
            r0 = r10[r12]
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
        L_0x03dc:
            r21 = r0
            r0 = r10[r13]
            if (r0 == 0) goto L_0x03e8
            r0 = r10[r13]
            r19 = r0
            byte[] r19 = (byte[]) r19
        L_0x03e8:
            r22 = r19
            r0 = r10[r14]
            if (r0 == 0) goto L_0x0403
            r0 = r10[r14]
            if (r0 == 0) goto L_0x03fb
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r25 = r0
            goto L_0x0405
        L_0x03fb:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x0403:
            r25 = 0
        L_0x0405:
            r0 = r10[r11]
            if (r0 == 0) goto L_0x041f
            r0 = r10[r11]
            if (r0 == 0) goto L_0x0417
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r26 = r0
            r0 = 4
            goto L_0x0422
        L_0x0417:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x041f:
            r0 = 4
            r26 = 0
        L_0x0422:
            r1 = r10[r0]
            if (r1 == 0) goto L_0x043b
            r0 = r10[r0]
            if (r0 == 0) goto L_0x0433
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r27 = r0
            goto L_0x043d
        L_0x0433:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x043b:
            r27 = 0
        L_0x043d:
            r0 = r10[r5]
            if (r0 == 0) goto L_0x0456
            r0 = r10[r5]
            if (r0 == 0) goto L_0x044e
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r12 = r0.intValue()
            r28 = r12
            goto L_0x0458
        L_0x044e:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x0456:
            r28 = 0
        L_0x0458:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0461
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0461:
            com.meizu.media.camera.u r20 = r0.mo18036aU()
            if (r20 != 0) goto L_0x046a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x046a:
            r23 = 0
            r24 = 0
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0477
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0477:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()
            if (r0 != 0) goto L_0x0480
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0480:
            boolean r29 = r0.mo17677n()
            r20.mo21517a(r21, r22, r23, r24, r25, r26, r27, r28, r29)
            goto L_0x2ddb
        L_0x0489:
            int r0 = r10.length
            r1 = 9
            if (r0 >= r1) goto L_0x048f
            return
        L_0x048f:
            java.lang.String r19 = (java.lang.String) r19
            r0 = r10[r12]
            if (r0 == 0) goto L_0x04a7
            r0 = r10[r12]
            if (r0 == 0) goto L_0x049f
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            r0.booleanValue()
            goto L_0x04a7
        L_0x049f:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x04a7:
            r0 = r10[r13]
            if (r0 == 0) goto L_0x04be
            r0 = r10[r13]
            if (r0 == 0) goto L_0x04b6
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            goto L_0x04c0
        L_0x04b6:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Long"
            r0.<init>(r1)
            throw r0
        L_0x04be:
            r0 = 0
        L_0x04c0:
            r6 = r10[r14]
            if (r6 == 0) goto L_0x04d7
            r6 = r10[r14]
            if (r6 == 0) goto L_0x04cf
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            goto L_0x04d8
        L_0x04cf:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x04d7:
            r6 = 0
        L_0x04d8:
            r9 = r10[r11]
            if (r9 == 0) goto L_0x04ef
            r9 = r10[r11]
            if (r9 == 0) goto L_0x04e7
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            goto L_0x04f0
        L_0x04e7:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x04ef:
            r9 = 0
        L_0x04f0:
            r16 = 4
            r17 = r10[r16]
            if (r17 == 0) goto L_0x0509
            r17 = r10[r16]
            if (r17 == 0) goto L_0x0501
            java.lang.Integer r17 = (java.lang.Integer) r17
            int r16 = r17.intValue()
            goto L_0x050b
        L_0x0501:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x0509:
            r16 = 0
        L_0x050b:
            r17 = r10[r5]
            if (r17 == 0) goto L_0x0524
            r17 = r10[r5]
            if (r17 == 0) goto L_0x051c
            java.lang.Boolean r17 = (java.lang.Boolean) r17
            boolean r17 = r17.booleanValue()
            r32 = r17
            goto L_0x0526
        L_0x051c:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x0524:
            r32 = 0
        L_0x0526:
            r17 = r10[r3]
            if (r17 == 0) goto L_0x053d
            r3 = r10[r3]
            if (r3 == 0) goto L_0x0535
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            goto L_0x053e
        L_0x0535:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x053d:
            r3 = 0
        L_0x053e:
            r17 = r10[r2]
            if (r17 == 0) goto L_0x0555
            r2 = r10[r2]
            if (r2 == 0) goto L_0x054d
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            goto L_0x0556
        L_0x054d:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x0555:
            r2 = 0
        L_0x0556:
            r17 = r10[r15]
            if (r17 == 0) goto L_0x0560
            r10 = r10[r15]
            r19 = r10
            java.lang.String r19 = (java.lang.String) r19
        L_0x0560:
            com.meizu.media.camera.MzCamModule r10 = r8.f9938b
            if (r10 != 0) goto L_0x0569
            java.lang.String r15 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r15)
        L_0x0569:
            int r10 = r10.mo18194dR()
            int r15 = r16 + r10
            int r15 = r15 % r4
            if (r15 == 0) goto L_0x057d
            if (r10 == r7) goto L_0x057d
            r15 = 270(0x10e, float:3.78E-43)
            if (r10 == r15) goto L_0x057d
            r22 = r6
            r21 = r9
            goto L_0x0581
        L_0x057d:
            r21 = r6
            r22 = r9
        L_0x0581:
            com.meizu.media.camera.MzCamModule r6 = r8.f9938b
            if (r6 != 0) goto L_0x058a
            java.lang.String r9 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r9)
        L_0x058a:
            com.meizu.media.camera.ui.i r6 = r6.mo18267u()
            if (r6 != 0) goto L_0x0593
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0593:
            android.graphics.Bitmap r6 = r6.mo22132au()
            if (r6 == 0) goto L_0x0656
            r9 = 270(0x10e, float:3.78E-43)
            if (r10 == r9) goto L_0x05a5
            if (r10 == r7) goto L_0x05a5
            if (r10 != r4) goto L_0x05a2
            goto L_0x05a5
        L_0x05a2:
            r16 = r6
            goto L_0x05ab
        L_0x05a5:
            android.graphics.Bitmap r4 = com.meizu.media.camera.util.BitmapUtils.m16141a(r6, r10)
            r16 = r4
        L_0x05ab:
            com.meizu.media.camera.MzCamModule r4 = r8.f9938b
            if (r4 != 0) goto L_0x05b4
            java.lang.String r7 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r7)
        L_0x05b4:
            com.meizu.media.camera.CameraActivity r4 = r4.mo18030aO()
            if (r4 != 0) goto L_0x05bd
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x05bd:
            com.meizu.media.camera.MediaSaveService r15 = r4.mo17689p()
            java.lang.String r17 = com.meizu.media.camera.util.CameraUtil.m15831a((long) r0)
            com.meizu.media.camera.MzCamModule r4 = r8.f9938b
            if (r4 != 0) goto L_0x05ce
            java.lang.String r7 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r7)
        L_0x05ce:
            com.meizu.media.camera.app.e r4 = r4.mo18192dP()
            android.location.Location r20 = r4.mo19017a((long) r0)
            r23 = 0
            r24 = 0
            com.meizu.media.camera.MzCamModule r4 = r8.f9938b
            if (r4 != 0) goto L_0x05e3
            java.lang.String r7 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r7)
        L_0x05e3:
            com.meizu.media.camera.MediaSaveService$d r25 = r4.mo18208df()
            com.meizu.media.camera.MzCamModule r4 = r8.f9938b
            if (r4 != 0) goto L_0x05f0
            java.lang.String r7 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r7)
        L_0x05f0:
            com.meizu.media.camera.CameraActivity r4 = r4.mo18030aO()
            if (r4 != 0) goto L_0x05f9
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x05f9:
            android.content.ContentResolver r26 = r4.getContentResolver()
            r28 = 1
            r29 = 0
            r30 = 0
            java.lang.Object[] r4 = new java.lang.Object[r5]
            r31 = r4
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r13)
            r4[r12] = r5
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r4[r13] = r3
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r4[r14] = r2
            r4[r11] = r19
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r13)
            r3 = 4
            r4[r3] = r2
            r18 = r0
            r27 = r32
            r15.mo17828a(r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0632
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0632:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x063b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x063b:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0644
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0644:
            com.meizu.media.camera.CameraActivity r1 = r1.mo18030aO()
            if (r1 != 0) goto L_0x064d
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x064d:
            boolean r1 = r1.mo17677n()
            r2 = r32
            r0.mo21516a((android.graphics.Bitmap) r6, (int) r10, (boolean) r2, (boolean) r1)
        L_0x0656:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x065f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x065f:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x0668
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0668:
            r1 = 4
            r0.mo21581d((int) r1, (boolean) r13)
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r0 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r0 != r1) goto L_0x0696
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x067b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x067b:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x0684
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0684:
            boolean r0 = r0.mo20549ac()
            if (r0 == 0) goto L_0x0696
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0693
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0693:
            r0.mo18275x((int) r11)
        L_0x0696:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x069f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x069f:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x06a8
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x06a8:
            r0.mo21614m((boolean) r12)
            goto L_0x2ddb
        L_0x06ad:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x06b6
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x06b6:
            boolean r0 = r0.mo17958x()
            if (r0 != 0) goto L_0x0718
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7846m()
            if (r0 != 0) goto L_0x0718
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x06cb
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x06cb:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 == 0) goto L_0x06e6
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x06da
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x06da:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x06e3
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x06e3:
            r0.mo21581d((int) r3, (boolean) r13)
        L_0x06e6:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x06ef
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x06ef:
            boolean r0 = r0.mo17872U()
            if (r0 == 0) goto L_0x0718
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x06fe
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x06fe:
            boolean r0 = r0.mo18070bD()
            if (r0 != 0) goto L_0x0718
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x070d
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x070d:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 == 0) goto L_0x0718
            r0.mo22142b((boolean) r13)
            kotlin.t r0 = kotlin.Unit.f18749a
        L_0x0718:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0721
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0721:
            boolean[] r1 = new boolean[r13]
            r1[r12] = r13
            r0.mo18122c((boolean[]) r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0731
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0731:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x073a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x073a:
            r0.mo20381E()
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0746
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0746:
            boolean r0 = r0.mo17958x()
            if (r0 != 0) goto L_0x07c2
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7849p()
            if (r0 != 0) goto L_0x07c2
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x075b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x075b:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 == 0) goto L_0x0777
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x076a
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x076a:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x0773
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0773:
            r1 = 4
            r0.mo21581d((int) r1, (boolean) r13)
        L_0x0777:
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7847n()
            if (r0 != 0) goto L_0x07c2
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r1 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL
            if (r0 == r1) goto L_0x07c2
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r1 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL_AND_GALLERY
            if (r0 == r1) goto L_0x07c2
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0792
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0792:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 == 0) goto L_0x07c2
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x07a1
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x07a1:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x07aa
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x07aa:
            r0.mo21581d((int) r14, (boolean) r13)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x07b6
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x07b6:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x07bf
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x07bf:
            r0.mo21628r()
        L_0x07c2:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x07cb
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x07cb:
            boolean[] r1 = new boolean[r13]
            r1[r12] = r13
            r0.mo18122c((boolean[]) r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x07db
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x07db:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x07ea
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x07ea:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x07f3
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x07f3:
            r0.mo21540ae()
            goto L_0x2ddb
        L_0x07f8:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_OK
            if (r0 != r9) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0805
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0805:
            boolean r0 = r0.mo18077bK()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.camcontroller.CameraController r0 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r1 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r1)
            com.meizu.media.camera.camcontroller.d r0 = r0.mo19522k()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0823
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0823:
            int r0 = r0.mo18114bv()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0832
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0832:
            int r0 = r0.mo18114bv()
            r1 = 4
            if (r0 == r1) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0842
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0842:
            int r0 = r0.mo18114bv()
            r1 = -1
            if (r0 == r1) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0852
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0852:
            int r0 = r0.mo18114bv()
            if (r0 == r11) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0861
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0861:
            com.meizu.media.camera.l r0 = r0.mo18038aW()
            if (r0 != 0) goto L_0x086a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x086a:
            boolean[] r1 = new boolean[r12]
            r2 = 4
            r0.mo20317a((int) r2, (boolean[]) r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0879
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0879:
            int r0 = r0.mo18114bv()
            if (r0 == r11) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0888
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0888:
            com.meizu.media.camera.MzCamController$ModuleState r0 = r0.mo18115bw()
            com.meizu.media.camera.MzCamController$ModuleState r1 = com.meizu.media.camera.MzCamController.ModuleState.IDLE
            if (r0 != r1) goto L_0x2ddb
            com.meizu.media.camera.camcontroller.CameraController r0 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r1 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r1)
            boolean r0 = r0.mo19535r()
            if (r0 != 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x08a8
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x08a8:
            r0.mo18262s((int) r13)
            goto L_0x2ddb
        L_0x08ad:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_AUTO_FOCUS_CALLBACK
            if (r0 != r9) goto L_0x2ddb
            int r0 = r10.length
            if (r0 >= r13) goto L_0x08b5
            return
        L_0x08b5:
            r0 = r10[r12]
            if (r0 == 0) goto L_0x2ddb
            r0 = r10[r12]
            if (r0 == 0) goto L_0x08e2
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x08cc
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x08cc:
            com.meizu.media.camera.f.a r1 = r1.mo18100bh()
            com.meizu.media.camera.camcontroller.CameraController r2 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)
            com.meizu.media.camera.camcontroller.d r2 = r2.mo19522k()
            r1.mo20013a(r0, r2)
            goto L_0x2ddb
        L_0x08e2:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x08ea:
            if (r9 != 0) goto L_0x08ee
            goto L_0x2ddb
        L_0x08ee:
            int[] r1 = com.meizu.media.camera.p069f.C2049e.f9958g
            int r6 = r53.ordinal()
            r1 = r1[r6]
            switch(r1) {
                case 1: goto L_0x1234;
                case 2: goto L_0x0fe4;
                case 3: goto L_0x0d5e;
                case 4: goto L_0x0c19;
                case 5: goto L_0x0bb9;
                case 6: goto L_0x0b91;
                case 7: goto L_0x0b3f;
                case 8: goto L_0x0ad8;
                case 9: goto L_0x0963;
                case 10: goto L_0x093a;
                case 11: goto L_0x08fb;
                default: goto L_0x08f9;
            }
        L_0x08f9:
            goto L_0x2ddb
        L_0x08fb:
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7846m()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x090a
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x090a:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0919
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0919:
            r0.mo18262s((int) r11)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0925
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0925:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()
            if (r0 != 0) goto L_0x092e
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x092e:
            com.meizu.media.camera.f.d$b r1 = new com.meizu.media.camera.f.d$b
            r1.<init>(r8)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r0.runOnUiThread(r1)
            goto L_0x2ddb
        L_0x093a:
            int r0 = r10.length
            if (r0 >= r14) goto L_0x093e
            return
        L_0x093e:
            r0 = r10[r12]
            if (r0 == 0) goto L_0x2ddb
            r0 = r10[r12]
            if (r0 == 0) goto L_0x095b
            android.net.Uri r0 = (android.net.Uri) r0
            r0 = r10[r13]
            if (r0 == 0) goto L_0x0953
            java.lang.Integer r0 = (java.lang.Integer) r0
            r0.intValue()
            goto L_0x2ddb
        L_0x0953:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x095b:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type android.net.Uri"
            r0.<init>(r1)
            throw r0
        L_0x0963:
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7846m()
            if (r0 != 0) goto L_0x09f4
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0972
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0972:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x097b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x097b:
            r0.mo21611l((boolean) r13)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0987
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0987:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 == 0) goto L_0x09c0
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0996
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0996:
            boolean r0 = r0.mo17872U()
            if (r0 == 0) goto L_0x09c0
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x09a5
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x09a5:
            boolean r0 = r0.mo18070bD()
            if (r0 != 0) goto L_0x09c0
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x09b4
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x09b4:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 != 0) goto L_0x09bd
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x09bd:
            r0.mo22142b((boolean) r13)
        L_0x09c0:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x09c9
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x09c9:
            boolean r0 = r0.mo18266t()
            if (r0 != 0) goto L_0x09e4
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x09d8
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x09d8:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x09e1
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x09e1:
            r0.mo21628r()
        L_0x09e4:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x09ed
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x09ed:
            boolean[] r1 = new boolean[r13]
            r1[r12] = r12
            r0.mo18122c((boolean[]) r1)
        L_0x09f4:
            int r0 = r10.length
            int r1 = r10.length
            if (r1 <= 0) goto L_0x0a23
            r1 = r10[r12]
            if (r1 == 0) goto L_0x0a1b
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r0 < r14) goto L_0x0a24
            r0 = r10[r13]
            if (r0 == 0) goto L_0x0a24
            r0 = r10[r13]
            if (r0 == 0) goto L_0x0a13
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r12 = r0.booleanValue()
            goto L_0x0a24
        L_0x0a13:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x0a1b:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x0a23:
            r1 = 0
        L_0x0a24:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0a2d
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0a2d:
            boolean r0 = r0.mo17910ag()
            if (r0 != 0) goto L_0x0a35
            if (r1 == 0) goto L_0x0a80
        L_0x0a35:
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r0 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            if (r0 != r1) goto L_0x0a80
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0a44
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0a44:
            boolean r0 = r0.mo17958x()
            if (r0 != 0) goto L_0x0a80
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7849p()
            if (r0 != 0) goto L_0x0a80
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7850q()
            if (r0 != 0) goto L_0x0a80
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0a5f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0a5f:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x0a68
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0a68:
            r0.mo21581d((int) r2, (boolean) r13)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0a74
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0a74:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x0a7d
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0a7d:
            r0.mo21628r()
        L_0x0a80:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0a89
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0a89:
            boolean r0 = r0.mo18224dv()
            if (r0 != 0) goto L_0x0a91
            if (r12 == 0) goto L_0x2ddb
        L_0x0a91:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0a9a
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0a9a:
            boolean r0 = r0.mo17958x()
            if (r0 != 0) goto L_0x2ddb
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7849p()
            if (r0 != 0) goto L_0x2ddb
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7851r()
            if (r0 != 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0ab5
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0ab5:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x0abe
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0abe:
            r0.mo21581d((int) r14, (boolean) r13)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0aca
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0aca:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x0ad3
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0ad3:
            r0.mo21628r()
            goto L_0x2ddb
        L_0x0ad8:
            int r0 = r10.length
            if (r0 >= r13) goto L_0x0adc
            return
        L_0x0adc:
            r0 = r10[r12]
            if (r0 == 0) goto L_0x2ddb
            r0 = r10[r12]
            if (r0 == 0) goto L_0x0b37
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0af3
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0af3:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x0afc
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0afc:
            r2 = r0 ^ 1
            r1.mo21611l((boolean) r2)
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0b0a
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0b0a:
            boolean r1 = r1.mo17872U()
            if (r1 == 0) goto L_0x2ddb
            if (r0 != 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0b1b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0b1b:
            boolean r0 = r0.mo18070bD()
            if (r0 != 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0b2a
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0b2a:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 == 0) goto L_0x2ddb
            r0.mo22142b((boolean) r13)
            kotlin.t r0 = kotlin.Unit.f18749a
            goto L_0x2ddb
        L_0x0b37:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x0b3f:
            int r0 = r10.length
            if (r0 >= r13) goto L_0x0b43
            return
        L_0x0b43:
            r0 = r10[r12]
            if (r0 == 0) goto L_0x2ddb
            r0 = r10[r12]
            if (r0 == 0) goto L_0x0b89
            android.net.Uri r0 = (android.net.Uri) r0
            int r1 = r10.length
            if (r1 <= r13) goto L_0x0b77
            r1 = r10[r13]
            if (r1 == 0) goto L_0x0b77
            r1 = r10[r13]
            if (r1 == 0) goto L_0x0b6f
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            r1.booleanValue()
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0b66
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0b66:
            com.meizu.media.camera.MediaSaveService$d r1 = r1.mo18208df()
            r1.mo17844a((android.net.Uri) r0)
            goto L_0x2ddb
        L_0x0b6f:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x0b77:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0b80
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0b80:
            com.meizu.media.camera.MediaSaveService$d r1 = r1.mo18208df()
            r1.mo17844a((android.net.Uri) r0)
            goto L_0x2ddb
        L_0x0b89:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type android.net.Uri"
            r0.<init>(r1)
            throw r0
        L_0x0b91:
            int r0 = r10.length
            if (r0 >= r13) goto L_0x0b95
            return
        L_0x0b95:
            r0 = r10[r12]
            if (r0 == 0) goto L_0x2ddb
            r0 = r10[r12]
            if (r0 == 0) goto L_0x0bb1
            java.lang.String r0 = (java.lang.String) r0
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0ba8
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0ba8:
            com.meizu.media.camera.MediaSaveService$d r1 = r1.mo18208df()
            r1.mo17845a((java.lang.String) r0)
            goto L_0x2ddb
        L_0x0bb1:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
            r0.<init>(r1)
            throw r0
        L_0x0bb9:
            int r0 = r10.length
            r1 = 4
            if (r0 >= r1) goto L_0x0bbe
            return
        L_0x0bbe:
            r0 = r19
            java.lang.String r0 = (java.lang.String) r0
            byte[] r19 = (byte[]) r19
            r1 = r10[r12]
            if (r1 == 0) goto L_0x0bcc
            r0 = r10[r12]
            java.lang.String r0 = (java.lang.String) r0
        L_0x0bcc:
            r1 = r10[r13]
            if (r1 == 0) goto L_0x0be3
            r1 = r10[r13]
            if (r1 == 0) goto L_0x0bdb
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x0be4
        L_0x0bdb:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x0be3:
            r1 = 0
        L_0x0be4:
            r2 = r10[r14]
            if (r2 == 0) goto L_0x0bfb
            r2 = r10[r14]
            if (r2 == 0) goto L_0x0bf3
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r12 = r2.intValue()
            goto L_0x0bfb
        L_0x0bf3:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x0bfb:
            r2 = r10[r11]
            if (r2 == 0) goto L_0x0c05
            r2 = r10[r11]
            r19 = r2
            byte[] r19 = (byte[]) r19
        L_0x0c05:
            r2 = r19
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x0c10
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0c10:
            com.meizu.media.camera.MediaSaveService$d r3 = r3.mo18208df()
            r3.mo17846a(r0, r1, r12, r2)
            goto L_0x2ddb
        L_0x0c19:
            int r0 = r10.length
            if (r0 >= r5) goto L_0x0c1d
            return
        L_0x0c1d:
            r0 = r19
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            byte[] r19 = (byte[]) r19
            r1 = r10[r12]
            if (r1 == 0) goto L_0x0c2b
            r0 = r10[r12]
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
        L_0x0c2b:
            r21 = r0
            r0 = r10[r13]
            if (r0 == 0) goto L_0x0c37
            r0 = r10[r13]
            r19 = r0
            byte[] r19 = (byte[]) r19
        L_0x0c37:
            r22 = r19
            r0 = r10[r14]
            if (r0 == 0) goto L_0x0c52
            r0 = r10[r14]
            if (r0 == 0) goto L_0x0c4a
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r25 = r0
            goto L_0x0c54
        L_0x0c4a:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x0c52:
            r25 = 0
        L_0x0c54:
            r0 = r10[r11]
            if (r0 == 0) goto L_0x0c6e
            r0 = r10[r11]
            if (r0 == 0) goto L_0x0c66
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r26 = r0
            r0 = 4
            goto L_0x0c71
        L_0x0c66:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x0c6e:
            r0 = 4
            r26 = 0
        L_0x0c71:
            r1 = r10[r0]
            if (r1 == 0) goto L_0x0c88
            r1 = r10[r0]
            if (r1 == 0) goto L_0x0c80
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r0 = r1.booleanValue()
            goto L_0x0c89
        L_0x0c80:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x0c88:
            r0 = 0
        L_0x0c89:
            com.meizu.media.camera.util.ac$a r1 = r8.f9939c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "RESULT_CREATE_PICTURE_THUMBNAIL mIsFastNailInTakePicture:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = ", needGetThumbnailFromData:"
            r2.append(r3)
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x0ca6
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0ca6:
            com.meizu.media.camera.u r3 = r3.mo18036aU()
            if (r3 != 0) goto L_0x0caf
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0caf:
            boolean r3 = r3.mo21503Z()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            if (r0 == 0) goto L_0x0cd7
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0cc8
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0cc8:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x0cd1
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0cd1:
            boolean r0 = r0.mo21503Z()
            if (r0 == 0) goto L_0x2ddb
        L_0x0cd7:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0ce0
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0ce0:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x0ce9
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0ce9:
            r0.mo21627q((boolean) r12)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0cf5
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0cf5:
            boolean r0 = r0.mo18041aZ()
            if (r0 != 0) goto L_0x2ddb
            com.meizu.media.camera.camcontroller.CameraController r0 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r1 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r1)
            android.graphics.Point r0 = r0.mo19520j()
            if (r0 == 0) goto L_0x0d38
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0d13
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0d13:
            com.meizu.media.camera.u r20 = r1.mo18036aU()
            if (r20 != 0) goto L_0x0d1c
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0d1c:
            r23 = 0
            r24 = 0
            int r1 = r0.x
            int r0 = r0.y
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x0d2d
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x0d2d:
            boolean r29 = r2.mo18032aQ()
            r27 = r1
            r28 = r0
            r20.mo21517a(r21, r22, r23, r24, r25, r26, r27, r28, r29)
        L_0x0d38:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0d41
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0d41:
            boolean r0 = r0.mo18190dN()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0d50
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0d50:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 == 0) goto L_0x2ddb
            r1 = 4
            r0.mo21581d((int) r1, (boolean) r13)
            kotlin.t r0 = kotlin.Unit.f18749a
            goto L_0x2ddb
        L_0x0d5e:
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r1 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_SUPER_NIGHT_PICTURE
            if (r1 != r0) goto L_0x0d7d
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r4 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            if (r1 != r4) goto L_0x0d7d
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0d71
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x0d71:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x0d7a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0d7a:
            r1.mo21563b()
        L_0x0d7d:
            int r1 = r10.length
            r4 = r19
            byte[] r4 = (byte[]) r4
            r6 = r10[r12]
            if (r6 == 0) goto L_0x0d95
            r4 = r10[r12]
            if (r4 == 0) goto L_0x0d8d
            byte[] r4 = (byte[]) r4
            goto L_0x0d95
        L_0x0d8d:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.ByteArray"
            r0.<init>(r1)
            throw r0
        L_0x0d95:
            r6 = r19
            android.location.Location r6 = (android.location.Location) r6
            r7 = r10[r13]
            if (r7 == 0) goto L_0x0dac
            r6 = r10[r13]
            if (r6 == 0) goto L_0x0da4
            android.location.Location r6 = (android.location.Location) r6
            goto L_0x0dac
        L_0x0da4:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type android.location.Location"
            r0.<init>(r1)
            throw r0
        L_0x0dac:
            r7 = r10[r14]
            if (r7 == 0) goto L_0x0dc3
            r7 = r10[r14]
            if (r7 == 0) goto L_0x0dbb
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            goto L_0x0dc4
        L_0x0dbb:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x0dc3:
            r7 = 0
        L_0x0dc4:
            r9 = r19
            android.graphics.Rect r9 = (android.graphics.Rect) r9
            r14 = r19
            android.hardware.camera2.TotalCaptureResult r14 = (android.hardware.camera2.TotalCaptureResult) r14
            com.meizu.media.camera.a.g r19 = (com.meizu.media.camera.p064a.XmpMetaData) r19
            r18 = r10[r11]
            if (r18 == 0) goto L_0x0de5
            r11 = r10[r11]
            if (r11 == 0) goto L_0x0ddd
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            goto L_0x0de6
        L_0x0ddd:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x0de5:
            r11 = 0
        L_0x0de6:
            r18 = 4
            r20 = r10[r18]
            if (r20 == 0) goto L_0x0dff
            r18 = r10[r18]
            if (r18 == 0) goto L_0x0df7
            java.lang.Integer r18 = (java.lang.Integer) r18
            int r18 = r18.intValue()
            goto L_0x0e01
        L_0x0df7:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x0dff:
            r18 = 0
        L_0x0e01:
            if (r1 <= r2) goto L_0x0ed5
            r20 = r10[r5]
            if (r20 == 0) goto L_0x0e1a
            r5 = r10[r5]
            if (r5 == 0) goto L_0x0e12
            java.lang.Long r5 = (java.lang.Long) r5
            long r16 = r5.longValue()
            goto L_0x0e1c
        L_0x0e12:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Long"
            r0.<init>(r1)
            throw r0
        L_0x0e1a:
            r16 = 0
        L_0x0e1c:
            r5 = r10[r3]
            if (r5 == 0) goto L_0x0e33
            r5 = r10[r3]
            if (r5 == 0) goto L_0x0e2b
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            goto L_0x0e34
        L_0x0e2b:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x0e33:
            r5 = 0
        L_0x0e34:
            r20 = r10[r2]
            if (r20 == 0) goto L_0x0e3d
            r2 = r10[r2]
            r9 = r2
            android.graphics.Rect r9 = (android.graphics.Rect) r9
        L_0x0e3d:
            r2 = r10[r15]
            if (r2 == 0) goto L_0x0e46
            r2 = r10[r15]
            r14 = r2
            android.hardware.camera2.TotalCaptureResult r14 = (android.hardware.camera2.TotalCaptureResult) r14
        L_0x0e46:
            int r2 = r10.length
            r15 = 10
            if (r2 < r15) goto L_0x0e5b
            r2 = 9
            r2 = r10[r2]
            boolean r2 = r2 instanceof com.meizu.media.camera.p064a.XmpMetaData
            if (r2 == 0) goto L_0x0e5b
            r2 = 9
            r2 = r10[r2]
            r19 = r2
            com.meizu.media.camera.a.g r19 = (com.meizu.media.camera.p064a.XmpMetaData) r19
        L_0x0e5b:
            r2 = 11
            if (r1 < r2) goto L_0x0e7a
            r2 = 10
            r2 = r10[r2]
            if (r2 == 0) goto L_0x0e7a
            r2 = 10
            r2 = r10[r2]
            if (r2 == 0) goto L_0x0e72
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            goto L_0x0e7b
        L_0x0e72:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x0e7a:
            r2 = 0
        L_0x0e7b:
            r15 = 12
            if (r1 < r15) goto L_0x0e9a
            r15 = 11
            r15 = r10[r15]
            if (r15 == 0) goto L_0x0e9a
            r15 = 11
            r15 = r10[r15]
            if (r15 == 0) goto L_0x0e92
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            goto L_0x0e9b
        L_0x0e92:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x0e9a:
            r15 = 0
        L_0x0e9b:
            r12 = 13
            if (r1 < r12) goto L_0x0ec6
            r1 = 12
            r1 = r10[r1]
            if (r1 == 0) goto L_0x0ec6
            r1 = 12
            r1 = r10[r1]
            if (r1 == 0) goto L_0x0ebe
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r12 = r1.booleanValue()
            r25 = r2
            r21 = r5
            r22 = r9
            r26 = r12
            r23 = r14
            r24 = r19
            goto L_0x0ed2
        L_0x0ebe:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x0ec6:
            r25 = r2
            r21 = r5
            r22 = r9
            r23 = r14
            r24 = r19
            r26 = 0
        L_0x0ed2:
            r19 = r16
            goto L_0x0ef8
        L_0x0ed5:
            int r1 = r10.length
            if (r1 < r3) goto L_0x0ee9
            r1 = r10[r5]
            boolean r1 = r1 instanceof com.meizu.media.camera.p064a.XmpMetaData
            if (r1 == 0) goto L_0x0ee9
            r1 = r10[r5]
            com.meizu.media.camera.a.g r1 = (com.meizu.media.camera.p064a.XmpMetaData) r1
            r24 = r1
            r22 = r9
            r23 = r14
            goto L_0x0eef
        L_0x0ee9:
            r22 = r9
            r23 = r14
            r24 = r19
        L_0x0eef:
            r15 = 0
            r19 = 0
            r21 = 0
            r25 = 0
            r26 = 0
        L_0x0ef8:
            if (r7 == 0) goto L_0x0f14
            boolean r1 = r51.mo18240i()
            if (r1 == 0) goto L_0x0f14
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0f09
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0f09:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 == 0) goto L_0x0f14
            r1.mo21581d((int) r3, (boolean) r13)
            kotlin.t r1 = kotlin.Unit.f18749a
        L_0x0f14:
            if (r15 == 0) goto L_0x0f30
            boolean r1 = com.meizu.media.camera.CameraOptTask.m7851r()
            if (r1 != 0) goto L_0x0f30
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0f25
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0f25:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 == 0) goto L_0x0f30
            r1.mo21581d((int) r3, (boolean) r13)
            kotlin.t r1 = kotlin.Unit.f18749a
        L_0x0f30:
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            if (r1 != r2) goto L_0x0f56
            com.meizu.media.camera.MzCamModule r14 = r8.f9938b
            if (r14 != 0) goto L_0x0f3f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0f3f:
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r15 = r4
            r16 = r6
            r17 = r11
            r14.mo18018a(r15, r16, r17, r18, r19, r21, r22, r23, r24, r25, r26)
            goto L_0x0f67
        L_0x0f56:
            com.meizu.media.camera.MzCamModule r14 = r8.f9938b
            if (r14 != 0) goto L_0x0f5f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0f5f:
            r15 = r4
            r16 = r6
            r17 = r11
            r14.mo18018a(r15, r16, r17, r18, r19, r21, r22, r23, r24, r25, r26)
        L_0x0f67:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0f70
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0f70:
            r2 = 0
            r1.mo17993a((int) r2, (boolean) r13)
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0f7d
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0f7d:
            boolean r1 = r1.mo17958x()
            if (r1 == 0) goto L_0x0fb6
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0f8c
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0f8c:
            com.meizu.media.camera.ui.i r1 = r1.mo18267u()
            if (r1 == 0) goto L_0x0fb6
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0f9b
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0f9b:
            boolean r1 = r1.mo17872U()
            if (r1 == 0) goto L_0x0fb6
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x0faa
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x0faa:
            com.meizu.media.camera.ui.i r1 = r1.mo18267u()
            if (r1 != 0) goto L_0x0fb3
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0fb3:
            r1.mo22142b((boolean) r13)
        L_0x0fb6:
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r1 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_SUPER_NIGHT_PICTURE
            if (r1 != r0) goto L_0x2ddb
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f13928bb
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0fc7
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0fc7:
            int r0 = r0.mo18211di()
            if (r0 == r13) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0fd6
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0fd6:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 != 0) goto L_0x0fdf
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0fdf:
            r0.mo22086a((boolean) r13, (int) r13)
            goto L_0x2ddb
        L_0x0fe4:
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r1 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_SUPER_NIGHT_PICTURE
            if (r1 != r0) goto L_0x112b
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r0 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            if (r0 != r1) goto L_0x1019
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x0ff7
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x0ff7:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x1000
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1000:
            r0.mo21628r()
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x100c
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x100c:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x1015
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1015:
            r0.mo21563b()
            goto L_0x102f
        L_0x1019:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1022
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1022:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x102b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x102b:
            r1 = 4
            r0.mo21597h((int) r1)
        L_0x102f:
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f14025dq
            if (r0 == 0) goto L_0x103c
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = com.meizu.media.camera.mode.CameraModeType.ModeType.BACK_LIGHTING
            boolean r0 = com.meizu.media.camera.mode.CameraModeType.m10983m((com.meizu.media.camera.mode.CameraModeType.ModeType) r0)
            if (r0 != 0) goto L_0x103c
            goto L_0x103e
        L_0x103c:
            r5 = 132(0x84, float:1.85E-43)
        L_0x103e:
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = com.meizu.media.camera.mode.CameraModeType.ModeType.BACK_LIGHTING
            boolean r0 = com.meizu.media.camera.mode.CameraModeType.m10983m((com.meizu.media.camera.mode.CameraModeType.ModeType) r0)
            if (r0 == 0) goto L_0x105e
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x104f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x104f:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x1058
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1058:
            r1 = 44
            r0.mo21506a((int) r1)
            goto L_0x10c9
        L_0x105e:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1067
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1067:
            int r0 = r0.mo18031aP()
            if (r0 != r13) goto L_0x1085
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1076
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1076:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x107f
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x107f:
            int r1 = com.meizu.media.camera.MzUIController.f12290l
            r0.mo21506a((int) r1)
            goto L_0x10c9
        L_0x1085:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x108e
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x108e:
            int r0 = r0.mo18031aP()
            int r1 = com.meizu.media.camera.util.DeviceHelper.f14029du
            if (r0 != r1) goto L_0x10b2
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f14033dy
            if (r0 != 0) goto L_0x10b2
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x10a3
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x10a3:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x10ac
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x10ac:
            int r1 = com.meizu.media.camera.MzUIController.f12291m
            r0.mo21506a((int) r1)
            goto L_0x10c9
        L_0x10b2:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x10bb
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x10bb:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x10c4
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x10c4:
            int r1 = com.meizu.media.camera.MzUIController.f12289k
            r0.mo21506a((int) r1)
        L_0x10c9:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x10d2
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x10d2:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x10db
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x10db:
            r0.mo21581d((int) r5, (boolean) r13)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x10e7
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x10e7:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x10f0
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x10f0:
            r0.mo21574c((int) r5, (boolean) r13)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x10fc
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x10fc:
            int r0 = r0.mo18211di()
            int r1 = com.meizu.media.camera.util.DeviceHelper.f14029du
            if (r0 != r1) goto L_0x1108
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f13928bb
            if (r0 == 0) goto L_0x112b
        L_0x1108:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1111
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1111:
            int r0 = r0.mo18211di()
            if (r0 == r13) goto L_0x112b
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1120
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1120:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 == 0) goto L_0x112b
            r0.mo22086a((boolean) r13, (int) r13)
            kotlin.t r0 = kotlin.Unit.f18749a
        L_0x112b:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1134
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1134:
            boolean r0 = r0.mo17958x()
            if (r0 != 0) goto L_0x11e9
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7846m()
            if (r0 != 0) goto L_0x11e9
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1149
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1149:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 == 0) goto L_0x11a7
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1158
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1158:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x1161
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1161:
            r0.mo21581d((int) r3, (boolean) r13)
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f13888ao
            if (r0 == 0) goto L_0x11a7
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1171
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1171:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x117a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x117a:
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.AUTO
            boolean r0 = r0.mo20547a((com.meizu.media.camera.mode.CameraModeType.ModeType) r1)
            if (r0 == 0) goto L_0x11a7
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x118b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x118b:
            boolean r0 = r0.mo18116bx()
            if (r0 == 0) goto L_0x11a7
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x119a
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x119a:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x11a3
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x11a3:
            r1 = 0
            r0.mo21478B(r1)
        L_0x11a7:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x11b0
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x11b0:
            com.meizu.media.camera.ui.i r0 = r0.mo18037aV()
            if (r0 == 0) goto L_0x11e9
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x11bf
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x11bf:
            boolean r0 = r0.mo17872U()
            if (r0 == 0) goto L_0x11e9
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x11ce
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x11ce:
            boolean r0 = r0.mo18070bD()
            if (r0 != 0) goto L_0x11e9
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x11dd
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x11dd:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 != 0) goto L_0x11e6
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x11e6:
            r0.mo22142b((boolean) r13)
        L_0x11e9:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x11f2
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x11f2:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 == 0) goto L_0x11ff
            r1 = 0
            r0.mo21577c(r1, r13, r13)
            kotlin.t r0 = kotlin.Unit.f18749a
            goto L_0x1200
        L_0x11ff:
            r1 = 0
        L_0x1200:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1209
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x1209:
            boolean[] r2 = new boolean[r13]
            r2[r1] = r13
            r0.mo18122c((boolean[]) r2)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1219
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1219:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x1222
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1222:
            r0.mo20381E()
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x122e
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x122e:
            r1 = 0
            r0.mo17993a((int) r1, (boolean) r13)
            goto L_0x2ddb
        L_0x1234:
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r1 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_SUPER_NIGHT_PICTURE
            if (r1 != r0) goto L_0x137f
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r6 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            if (r1 != r6) goto L_0x126c
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x1247
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x1247:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x1250
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1250:
            r1.mo21628r()
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x125c
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x125c:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x1265
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1265:
            r6 = 2131755571(0x7f100233, float:1.9142025E38)
            r1.mo21588f((int) r6)
            goto L_0x1282
        L_0x126c:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x1275
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x1275:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x127e
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x127e:
            r6 = 4
            r1.mo21597h((int) r6)
        L_0x1282:
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.BACK_LIGHTING
            boolean r1 = com.meizu.media.camera.mode.CameraModeType.m10983m((com.meizu.media.camera.mode.CameraModeType.ModeType) r1)
            if (r1 == 0) goto L_0x12a2
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x1293
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x1293:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x129c
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x129c:
            r6 = 44
            r1.mo21506a((int) r6)
            goto L_0x130d
        L_0x12a2:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x12ab
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x12ab:
            int r1 = r1.mo18031aP()
            if (r1 != r13) goto L_0x12c9
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x12ba
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x12ba:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x12c3
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x12c3:
            int r6 = com.meizu.media.camera.MzUIController.f12290l
            r1.mo21506a((int) r6)
            goto L_0x130d
        L_0x12c9:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x12d2
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x12d2:
            int r1 = r1.mo18031aP()
            int r6 = com.meizu.media.camera.util.DeviceHelper.f14029du
            if (r1 != r6) goto L_0x12f6
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f14033dy
            if (r1 != 0) goto L_0x12f6
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x12e7
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x12e7:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x12f0
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x12f0:
            int r6 = com.meizu.media.camera.MzUIController.f12291m
            r1.mo21506a((int) r6)
            goto L_0x130d
        L_0x12f6:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x12ff
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x12ff:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x1308
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1308:
            int r6 = com.meizu.media.camera.MzUIController.f12289k
            r1.mo21506a((int) r6)
        L_0x130d:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f14025dq
            if (r1 == 0) goto L_0x131b
            com.meizu.media.camera.mode.CameraModeType$ModeType r1 = com.meizu.media.camera.mode.CameraModeType.ModeType.BACK_LIGHTING
            boolean r1 = com.meizu.media.camera.mode.CameraModeType.m10983m((com.meizu.media.camera.mode.CameraModeType.ModeType) r1)
            if (r1 != 0) goto L_0x131b
            r1 = 5
            goto L_0x131d
        L_0x131b:
            r1 = 132(0x84, float:1.85E-43)
        L_0x131d:
            com.meizu.media.camera.MzCamModule r6 = r8.f9938b
            if (r6 != 0) goto L_0x1326
            java.lang.String r9 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r9)
        L_0x1326:
            com.meizu.media.camera.u r6 = r6.mo18036aU()
            if (r6 != 0) goto L_0x132f
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x132f:
            r6.mo21581d((int) r1, (boolean) r13)
            com.meizu.media.camera.MzCamModule r6 = r8.f9938b
            if (r6 != 0) goto L_0x133b
            java.lang.String r9 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r9)
        L_0x133b:
            com.meizu.media.camera.u r6 = r6.mo18036aU()
            if (r6 != 0) goto L_0x1344
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1344:
            r6.mo21574c((int) r1, (boolean) r13)
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13928bb
            if (r1 != 0) goto L_0x137f
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x1354
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x1354:
            int r1 = r1.mo18211di()
            int r6 = com.meizu.media.camera.util.DeviceHelper.f14029du
            if (r1 == r6) goto L_0x137f
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x1365
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x1365:
            int r1 = r1.mo18211di()
            if (r1 == r13) goto L_0x137f
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x1374
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x1374:
            com.meizu.media.camera.ui.i r1 = r1.mo18267u()
            if (r1 == 0) goto L_0x137f
            r1.mo22086a((boolean) r13, (int) r13)
            kotlin.t r1 = kotlin.Unit.f18749a
        L_0x137f:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x1388
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x1388:
            com.meizu.media.camera.MzCamModule r6 = r8.f9938b
            if (r6 != 0) goto L_0x1391
            java.lang.String r9 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r9)
        L_0x1391:
            com.meizu.media.camera.u r6 = r6.mo18036aU()
            if (r6 != 0) goto L_0x139a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x139a:
            boolean[] r9 = new boolean[r14]
            r12 = 0
            r9[r12] = r12
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r12 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_HDR_PICTURE
            if (r12 == r0) goto L_0x13aa
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r12 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_HDR_AND_MFLL_PICTURE
            if (r12 != r0) goto L_0x13a8
            goto L_0x13aa
        L_0x13a8:
            r0 = 0
            goto L_0x13ab
        L_0x13aa:
            r0 = 1
        L_0x13ab:
            r9[r13] = r0
            boolean r0 = r6.mo21535a((boolean[]) r9)
            r1.mo17985Y(r0)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x13bd
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x13bd:
            boolean r0 = r0.mo18041aZ()
            if (r0 != 0) goto L_0x2ddb
            int r0 = r10.length
            if (r0 >= r3) goto L_0x13c7
            return
        L_0x13c7:
            java.lang.String r19 = (java.lang.String) r19
            r0 = 0
            r1 = r10[r0]
            if (r1 == 0) goto L_0x13e1
            r1 = r10[r0]
            if (r1 == 0) goto L_0x13d9
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r12 = r1.booleanValue()
            goto L_0x13e2
        L_0x13d9:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x13e1:
            r12 = 0
        L_0x13e2:
            r0 = r10[r13]
            if (r0 == 0) goto L_0x13f9
            r0 = r10[r13]
            if (r0 == 0) goto L_0x13f1
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x13fa
        L_0x13f1:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x13f9:
            r0 = 0
        L_0x13fa:
            r1 = r10[r14]
            if (r1 == 0) goto L_0x1413
            r1 = r10[r14]
            if (r1 == 0) goto L_0x140b
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r27 = r1
            goto L_0x1415
        L_0x140b:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x1413:
            r27 = 0
        L_0x1415:
            r1 = r10[r11]
            if (r1 == 0) goto L_0x142c
            r1 = r10[r11]
            if (r1 == 0) goto L_0x1424
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x142d
        L_0x1424:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x142c:
            r1 = 0
        L_0x142d:
            r6 = 4
            r9 = r10[r6]
            if (r9 == 0) goto L_0x1445
            r9 = r10[r6]
            if (r9 == 0) goto L_0x143d
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r6 = r9.intValue()
            goto L_0x1446
        L_0x143d:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x1445:
            r6 = 0
        L_0x1446:
            r9 = r10[r5]
            if (r9 == 0) goto L_0x145f
            r5 = r10[r5]
            if (r5 == 0) goto L_0x1457
            java.lang.Long r5 = (java.lang.Long) r5
            long r16 = r5.longValue()
            r33 = r16
            goto L_0x1461
        L_0x1457:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Long"
            r0.<init>(r1)
            throw r0
        L_0x145f:
            r33 = 0
        L_0x1461:
            r5 = r10[r3]
            if (r5 == 0) goto L_0x1478
            r3 = r10[r3]
            if (r3 == 0) goto L_0x1470
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            goto L_0x1479
        L_0x1470:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x1478:
            r3 = 0
        L_0x1479:
            int r5 = r10.length
            if (r5 <= r2) goto L_0x1486
            r5 = r10[r2]
            if (r5 == 0) goto L_0x1486
            r2 = r10[r2]
            r19 = r2
            java.lang.String r19 = (java.lang.String) r19
        L_0x1486:
            r29 = r19
            int r2 = r10.length
            if (r2 <= r15) goto L_0x14a2
            r2 = r10[r15]
            if (r2 == 0) goto L_0x14a2
            r2 = r10[r15]
            if (r2 == 0) goto L_0x149a
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            goto L_0x14a3
        L_0x149a:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x14a2:
            r2 = 0
        L_0x14a3:
            com.meizu.media.camera.MzCamModule r5 = r8.f9938b
            if (r5 != 0) goto L_0x14ac
            java.lang.String r9 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r9)
        L_0x14ac:
            int r5 = r5.mo18194dR()
            int r9 = r0 + r5
            int r9 = r9 % r4
            if (r9 == 0) goto L_0x14c0
            if (r5 == r7) goto L_0x14c0
            r9 = 270(0x10e, float:3.78E-43)
            if (r5 == r9) goto L_0x14c0
            r50 = r6
            r6 = r1
            r1 = r50
        L_0x14c0:
            com.meizu.media.camera.MzCamModule r9 = r8.f9938b
            if (r9 != 0) goto L_0x14c9
            java.lang.String r10 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r10)
        L_0x14c9:
            com.meizu.media.camera.ui.i r9 = r9.mo18267u()
            if (r9 != 0) goto L_0x14d2
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x14d2:
            android.graphics.Bitmap r9 = r9.mo22132au()
            if (r9 != 0) goto L_0x14f5
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.String r1 = "bitmap null"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x14e8
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x14e8:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x14f1
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x14f1:
            r0.mo21627q((boolean) r13)
            return
        L_0x14f5:
            boolean r10 = r9.isRecycled()
            if (r10 == 0) goto L_0x1518
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.String r1 = "bitmap isRecycled"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x150b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x150b:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x1514
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1514:
            r0.mo21627q((boolean) r13)
            return
        L_0x1518:
            com.meizu.media.camera.util.ac$a r10 = r8.f9939c
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r15 = "RESULT_SHUTTER_CALLBACK needFastThumbail:"
            r11.append(r15)
            r11.append(r12)
            java.lang.String r15 = " isFBOn:"
            r11.append(r15)
            r11.append(r3)
            java.lang.String r11 = r11.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r10, r11)
            com.meizu.media.camera.mode.CameraModeType$ModeType r10 = com.meizu.media.camera.mode.CameraModeType.ModeType.SQUARE
            boolean r10 = com.meizu.media.camera.mode.CameraModeType.m10985n((com.meizu.media.camera.mode.CameraModeType.ModeType) r10)
            if (r10 == 0) goto L_0x155b
            com.meizu.media.camera.MzCamModule r10 = r8.f9938b
            if (r10 != 0) goto L_0x1547
            java.lang.String r11 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r11)
        L_0x1547:
            boolean r10 = r10.mo18098bf()
            if (r10 == 0) goto L_0x155b
            int r1 = java.lang.Math.min(r1, r6)
            r6 = 0
            android.graphics.Bitmap r9 = com.meizu.media.camera.util.CameraUtil.m15822a((android.graphics.Bitmap) r9, (boolean) r6, (int) r5)
            r21 = r1
            r22 = r21
            goto L_0x1563
        L_0x155b:
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r9)
            r21 = r1
            r22 = r6
        L_0x1563:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x156c
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x156c:
            int r1 = r1.mo18031aP()
            if (r1 != r13) goto L_0x1574
            r1 = 1
            goto L_0x1575
        L_0x1574:
            r1 = 0
        L_0x1575:
            if (r12 != 0) goto L_0x157f
            if (r3 == 0) goto L_0x2ddb
            boolean r6 = r51.mo18240i()
            if (r6 == 0) goto L_0x2ddb
        L_0x157f:
            com.meizu.media.camera.MzCamModule r6 = r8.f9938b
            if (r6 != 0) goto L_0x1588
            java.lang.String r10 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r10)
        L_0x1588:
            boolean r6 = r6.mo17859H()
            if (r6 != 0) goto L_0x1590
            if (r2 == 0) goto L_0x1596
        L_0x1590:
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r6 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r2 == r6) goto L_0x15f3
        L_0x1596:
            if (r1 == 0) goto L_0x15bc
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x15a1
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x15a1:
            com.meizu.media.camera.u r2 = r2.mo18036aU()
            if (r2 != 0) goto L_0x15aa
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x15aa:
            boolean r2 = r2.mo21615m()
            if (r2 == 0) goto L_0x15bc
            android.graphics.Bitmap r9 = com.meizu.media.camera.util.BitmapUtils.m16147c(r9)
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.String r1 = "verticalConvert"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            goto L_0x15f0
        L_0x15bc:
            if (r1 == 0) goto L_0x15f0
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x15c7
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x15c7:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x15d0
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x15d0:
            boolean r1 = r1.mo21615m()
            if (r1 != 0) goto L_0x15f0
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13904bD
            if (r1 != 0) goto L_0x15dc
            if (r3 != 0) goto L_0x15de
        L_0x15dc:
            if (r3 != 0) goto L_0x15f0
        L_0x15de:
            if (r0 == r7) goto L_0x15e4
            r1 = 270(0x10e, float:3.78E-43)
            if (r0 != r1) goto L_0x15f0
        L_0x15e4:
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.String r1 = "mirrorConvert"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            android.graphics.Bitmap r0 = com.meizu.media.camera.util.BitmapUtils.m16140a(r9)
            r9 = r0
        L_0x15f0:
            r1 = 270(0x10e, float:3.78E-43)
            goto L_0x1620
        L_0x15f3:
            if (r1 == 0) goto L_0x15f0
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x15fe
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x15fe:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x1607
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1607:
            boolean r1 = r1.mo21615m()
            if (r1 != 0) goto L_0x15f0
            if (r0 == r7) goto L_0x1619
            r1 = 270(0x10e, float:3.78E-43)
            if (r0 != r1) goto L_0x1614
            goto L_0x161b
        L_0x1614:
            android.graphics.Bitmap r0 = com.meizu.media.camera.util.BitmapUtils.m16147c(r9)
            goto L_0x161f
        L_0x1619:
            r1 = 270(0x10e, float:3.78E-43)
        L_0x161b:
            android.graphics.Bitmap r0 = com.meizu.media.camera.util.BitmapUtils.m16140a(r9)
        L_0x161f:
            r9 = r0
        L_0x1620:
            if (r5 == r1) goto L_0x162a
            if (r5 == r7) goto L_0x162a
            if (r5 != r4) goto L_0x1627
            goto L_0x162a
        L_0x1627:
            r16 = r9
            goto L_0x1630
        L_0x162a:
            android.graphics.Bitmap r0 = com.meizu.media.camera.util.BitmapUtils.m16141a(r9, r5)
            r16 = r0
        L_0x1630:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1639
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1639:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()
            if (r0 != 0) goto L_0x1642
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1642:
            com.meizu.media.camera.MediaSaveService r15 = r0.mo17689p()
            java.lang.String r17 = com.meizu.media.camera.util.CameraUtil.m15831a((long) r33)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1653
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1653:
            com.meizu.media.camera.app.e r0 = r0.mo18192dP()
            r1 = r33
            android.location.Location r20 = r0.mo19017a((long) r1)
            r23 = 0
            r24 = 0
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x166a
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x166a:
            com.meizu.media.camera.MediaSaveService$d r25 = r0.mo18208df()
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1677
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x1677:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()
            if (r0 != 0) goto L_0x1680
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1680:
            android.content.ContentResolver r26 = r0.getContentResolver()
            r28 = 1
            r30 = 0
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r31 = r0
            r18 = r1
            r15.mo17828a(r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x169b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x169b:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x16a4
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x16a4:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x16ad
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x16ad:
            int r1 = r1.mo18068bB()
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x16ba
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x16ba:
            boolean r2 = r2.mo18116bx()
            com.meizu.media.camera.MzCamModule r4 = r8.f9938b
            if (r4 != 0) goto L_0x16c7
            java.lang.String r5 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r5)
        L_0x16c7:
            boolean r4 = r4.mo18032aQ()
            r0.mo21516a((android.graphics.Bitmap) r9, (int) r1, (boolean) r2, (boolean) r4)
            if (r3 != 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x16d9
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x16d9:
            boolean r0 = r0.mo18098bf()
            if (r0 == 0) goto L_0x16f7
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x16e8
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x16e8:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x16f1
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x16f1:
            r1 = 4
            r0.mo21581d((int) r1, (boolean) r13)
            goto L_0x2ddb
        L_0x16f7:
            if (r12 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1702
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1702:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x170b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x170b:
            r1 = 4
            r0.mo21581d((int) r1, (boolean) r13)
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f13878ae
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x171c
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x171c:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x1725
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1725:
            r0.mo21581d((int) r14, (boolean) r13)
            goto L_0x2ddb
        L_0x172a:
            if (r9 != 0) goto L_0x172e
            goto L_0x2ddb
        L_0x172e:
            int[] r0 = com.meizu.media.camera.p069f.C2049e.f9957f
            int r1 = r53.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x208f;
                case 2: goto L_0x1fcb;
                case 3: goto L_0x1c05;
                case 4: goto L_0x1a24;
                case 5: goto L_0x1917;
                case 6: goto L_0x18b5;
                case 7: goto L_0x188c;
                case 8: goto L_0x1839;
                case 9: goto L_0x177a;
                case 10: goto L_0x173b;
                default: goto L_0x1739;
            }
        L_0x1739:
            goto L_0x2ddb
        L_0x173b:
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7846m()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x174a
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x174a:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1759
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1759:
            r0.mo18262s((int) r11)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1765
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1765:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()
            if (r0 != 0) goto L_0x176e
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x176e:
            com.meizu.media.camera.f.d$a r1 = new com.meizu.media.camera.f.d$a
            r1.<init>(r8)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r0.runOnUiThread(r1)
            goto L_0x2ddb
        L_0x177a:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1783
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1783:
            boolean r0 = r0.mo17859H()
            int r1 = r10.length
            if (r1 != r13) goto L_0x179e
            r1 = 0
            r0 = r10[r1]
            if (r0 == 0) goto L_0x1796
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto L_0x179e
        L_0x1796:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x179e:
            boolean r1 = com.meizu.media.camera.CameraOptTask.m7846m()
            if (r1 == 0) goto L_0x17b5
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x17ad
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x17ad:
            boolean r1 = r1.mo17859H()
            if (r1 != 0) goto L_0x17b5
            if (r0 == 0) goto L_0x2ddb
        L_0x17b5:
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7844k()
            if (r0 != 0) goto L_0x1802
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x17c4
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x17c4:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x17cd
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x17cd:
            r0.mo21611l((boolean) r13)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x17d9
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x17d9:
            boolean r0 = r0.mo17872U()
            if (r0 == 0) goto L_0x1802
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x17e8
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x17e8:
            boolean r0 = r0.mo18070bD()
            if (r0 != 0) goto L_0x1802
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x17f7
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x17f7:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 == 0) goto L_0x1802
            r0.mo22142b((boolean) r13)
            kotlin.t r0 = kotlin.Unit.f18749a
        L_0x1802:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x180b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x180b:
            boolean r0 = r0.mo18266t()
            if (r0 != 0) goto L_0x1826
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x181a
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x181a:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x1823
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1823:
            r0.mo21628r()
        L_0x1826:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x182f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x182f:
            boolean[] r1 = new boolean[r13]
            r2 = 0
            r1[r2] = r2
            r0.mo18122c((boolean[]) r1)
            goto L_0x2ddb
        L_0x1839:
            r2 = 0
            int r0 = r10.length
            if (r0 >= r13) goto L_0x183e
            return
        L_0x183e:
            r0 = r10[r2]
            if (r0 == 0) goto L_0x2ddb
            r0 = r10[r2]
            if (r0 == 0) goto L_0x1884
            android.net.Uri r0 = (android.net.Uri) r0
            int r1 = r10.length
            if (r1 <= r13) goto L_0x1872
            r1 = r10[r13]
            if (r1 == 0) goto L_0x1872
            r1 = r10[r13]
            if (r1 == 0) goto L_0x186a
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            r1.booleanValue()
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x1861
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x1861:
            com.meizu.media.camera.MediaSaveService$d r1 = r1.mo18208df()
            r1.mo17844a((android.net.Uri) r0)
            goto L_0x2ddb
        L_0x186a:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x1872:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x187b
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x187b:
            com.meizu.media.camera.MediaSaveService$d r1 = r1.mo18208df()
            r1.mo17844a((android.net.Uri) r0)
            goto L_0x2ddb
        L_0x1884:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type android.net.Uri"
            r0.<init>(r1)
            throw r0
        L_0x188c:
            int r0 = r10.length
            if (r0 >= r13) goto L_0x1890
            return
        L_0x1890:
            r0 = 0
            r1 = r10[r0]
            if (r1 == 0) goto L_0x2ddb
            r0 = r10[r0]
            if (r0 == 0) goto L_0x18ad
            java.lang.String r0 = (java.lang.String) r0
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x18a4
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x18a4:
            com.meizu.media.camera.MediaSaveService$d r1 = r1.mo18208df()
            r1.mo17845a((java.lang.String) r0)
            goto L_0x2ddb
        L_0x18ad:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
            r0.<init>(r1)
            throw r0
        L_0x18b5:
            int r0 = r10.length
            r1 = 4
            if (r0 >= r1) goto L_0x18ba
            return
        L_0x18ba:
            r0 = r19
            java.lang.String r0 = (java.lang.String) r0
            byte[] r19 = (byte[]) r19
            r1 = 0
            r2 = r10[r1]
            if (r2 == 0) goto L_0x18c9
            r0 = r10[r1]
            java.lang.String r0 = (java.lang.String) r0
        L_0x18c9:
            r1 = r10[r13]
            if (r1 == 0) goto L_0x18e0
            r1 = r10[r13]
            if (r1 == 0) goto L_0x18d8
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r12 = r1.intValue()
            goto L_0x18e1
        L_0x18d8:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x18e0:
            r12 = 0
        L_0x18e1:
            r1 = r10[r14]
            if (r1 == 0) goto L_0x18f8
            r1 = r10[r14]
            if (r1 == 0) goto L_0x18f0
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x18f9
        L_0x18f0:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x18f8:
            r1 = 0
        L_0x18f9:
            r2 = r10[r11]
            if (r2 == 0) goto L_0x1903
            r2 = r10[r11]
            r19 = r2
            byte[] r19 = (byte[]) r19
        L_0x1903:
            r2 = r19
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x190e
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x190e:
            com.meizu.media.camera.MediaSaveService$d r3 = r3.mo18208df()
            r3.mo17846a(r0, r12, r1, r2)
            goto L_0x2ddb
        L_0x1917:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1920
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1920:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x1929
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1929:
            boolean r0 = r0.mo21503Z()
            int r1 = r10.length
            if (r1 >= r5) goto L_0x1931
            return
        L_0x1931:
            r1 = r19
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            byte[] r19 = (byte[]) r19
            r2 = 0
            r3 = r10[r2]
            if (r3 == 0) goto L_0x1940
            r1 = r10[r2]
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
        L_0x1940:
            r21 = r1
            r1 = r10[r13]
            if (r1 == 0) goto L_0x194c
            r1 = r10[r13]
            r19 = r1
            byte[] r19 = (byte[]) r19
        L_0x194c:
            r22 = r19
            r1 = r10[r14]
            if (r1 == 0) goto L_0x1967
            r1 = r10[r14]
            if (r1 == 0) goto L_0x195f
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r12 = r1.intValue()
            r25 = r12
            goto L_0x1969
        L_0x195f:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x1967:
            r25 = 0
        L_0x1969:
            r1 = r10[r11]
            if (r1 == 0) goto L_0x1983
            r1 = r10[r11]
            if (r1 == 0) goto L_0x197b
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r12 = r1.booleanValue()
            r26 = r12
            r1 = 4
            goto L_0x1986
        L_0x197b:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x1983:
            r1 = 4
            r26 = 0
        L_0x1986:
            r2 = r10[r1]
            if (r2 == 0) goto L_0x199d
            r1 = r10[r1]
            if (r1 == 0) goto L_0x1995
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r12 = r1.booleanValue()
            goto L_0x199e
        L_0x1995:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x199d:
            r12 = 0
        L_0x199e:
            com.meizu.media.camera.util.ac$a r1 = r8.f9939c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "RESULT_CREATE_PICTURE_THUMBNAIL isFastThumbnail:"
            r2.append(r3)
            r2.append(r12)
            java.lang.String r3 = ", needGetThumbnailFromData:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            if (r12 == 0) goto L_0x19c0
            if (r0 == 0) goto L_0x2ddb
        L_0x19c0:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x19c9
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x19c9:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x19d2
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x19d2:
            r1 = 0
            r0.mo21627q((boolean) r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x19df
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x19df:
            boolean r0 = r0.mo18041aZ()
            if (r0 != 0) goto L_0x2ddb
            com.meizu.media.camera.camcontroller.CameraController r0 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r1 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r1)
            android.graphics.Point r0 = r0.mo19520j()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x19fd
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x19fd:
            com.meizu.media.camera.u r20 = r1.mo18036aU()
            if (r20 != 0) goto L_0x1a06
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1a06:
            r23 = 0
            r24 = 0
            int r1 = r0.x
            int r0 = r0.y
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x1a17
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x1a17:
            boolean r29 = r2.mo18032aQ()
            r27 = r1
            r28 = r0
            r20.mo21517a(r21, r22, r23, r24, r25, r26, r27, r28, r29)
            goto L_0x2ddb
        L_0x1a24:
            int r0 = r10.length
            r1 = 0
            r4 = r10[r1]
            if (r4 == 0) goto L_0x1bfd
            r34 = r4
            byte[] r34 = (byte[]) r34
            r1 = r10[r13]
            if (r1 == 0) goto L_0x1a43
            r1 = r10[r13]
            if (r1 == 0) goto L_0x1a3b
            android.location.Location r1 = (android.location.Location) r1
            r35 = r1
            goto L_0x1a45
        L_0x1a3b:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type android.location.Location"
            r0.<init>(r1)
            throw r0
        L_0x1a43:
            r35 = r19
        L_0x1a45:
            r1 = r19
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            r4 = r19
            android.hardware.camera2.TotalCaptureResult r4 = (android.hardware.camera2.TotalCaptureResult) r4
            com.meizu.media.camera.a.g r19 = (com.meizu.media.camera.p064a.XmpMetaData) r19
            r6 = 4
            if (r0 <= r6) goto L_0x1b69
            r6 = r10[r11]
            if (r6 == 0) goto L_0x1a6b
            r6 = r10[r11]
            if (r6 == 0) goto L_0x1a63
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r12 = r6
            r6 = 4
            goto L_0x1a6d
        L_0x1a63:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x1a6b:
            r6 = 4
            r12 = 0
        L_0x1a6d:
            r7 = r10[r6]
            if (r7 == 0) goto L_0x1a84
            r6 = r10[r6]
            if (r6 == 0) goto L_0x1a7c
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            goto L_0x1a85
        L_0x1a7c:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x1a84:
            r6 = 0
        L_0x1a85:
            if (r0 <= r2) goto L_0x1b5e
            r7 = r10[r5]
            if (r7 == 0) goto L_0x1a9e
            r5 = r10[r5]
            if (r5 == 0) goto L_0x1a96
            java.lang.Long r5 = (java.lang.Long) r5
            long r16 = r5.longValue()
            goto L_0x1aa0
        L_0x1a96:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Long"
            r0.<init>(r1)
            throw r0
        L_0x1a9e:
            r16 = 0
        L_0x1aa0:
            r5 = r10[r3]
            if (r5 == 0) goto L_0x1ab7
            r3 = r10[r3]
            if (r3 == 0) goto L_0x1aaf
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L_0x1ab8
        L_0x1aaf:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x1ab7:
            r3 = 0
        L_0x1ab8:
            r5 = r10[r2]
            if (r5 == 0) goto L_0x1ac0
            r1 = r10[r2]
            android.graphics.Rect r1 = (android.graphics.Rect) r1
        L_0x1ac0:
            r2 = r10[r15]
            if (r2 == 0) goto L_0x1ac9
            r2 = r10[r15]
            r4 = r2
            android.hardware.camera2.TotalCaptureResult r4 = (android.hardware.camera2.TotalCaptureResult) r4
        L_0x1ac9:
            int r2 = r10.length
            r5 = 10
            if (r2 < r5) goto L_0x1ade
            r2 = 9
            r2 = r10[r2]
            boolean r2 = r2 instanceof com.meizu.media.camera.p064a.XmpMetaData
            if (r2 == 0) goto L_0x1ade
            r2 = 9
            r2 = r10[r2]
            r19 = r2
            com.meizu.media.camera.a.g r19 = (com.meizu.media.camera.p064a.XmpMetaData) r19
        L_0x1ade:
            r2 = 11
            if (r0 < r2) goto L_0x1afd
            r2 = 10
            r2 = r10[r2]
            if (r2 == 0) goto L_0x1afd
            r2 = 10
            r2 = r10[r2]
            if (r2 == 0) goto L_0x1af5
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            goto L_0x1afe
        L_0x1af5:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x1afd:
            r2 = 0
        L_0x1afe:
            r5 = 12
            if (r0 < r5) goto L_0x1b1c
            r5 = 11
            r5 = r10[r5]
            if (r5 == 0) goto L_0x1b1c
            r5 = 11
            r5 = r10[r5]
            if (r5 == 0) goto L_0x1b14
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            r5.booleanValue()
            goto L_0x1b1c
        L_0x1b14:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x1b1c:
            r5 = 13
            if (r0 < r5) goto L_0x1b4d
            r0 = 12
            r0 = r10[r0]
            if (r0 == 0) goto L_0x1b4d
            r0 = 12
            r0 = r10[r0]
            if (r0 == 0) goto L_0x1b45
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r45 = r0
            r41 = r1
            r44 = r2
            r40 = r3
            r42 = r4
            r37 = r6
            r36 = r12
            r38 = r16
            r43 = r19
            goto L_0x1b7b
        L_0x1b45:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x1b4d:
            r41 = r1
            r44 = r2
            r40 = r3
            r42 = r4
            r37 = r6
            r36 = r12
            r38 = r16
            r43 = r19
            goto L_0x1b79
        L_0x1b5e:
            r41 = r1
            r42 = r4
            r37 = r6
            r36 = r12
            r43 = r19
            goto L_0x1b73
        L_0x1b69:
            r41 = r1
            r42 = r4
            r43 = r19
            r36 = 0
            r37 = 0
        L_0x1b73:
            r38 = 0
            r40 = 0
            r44 = 0
        L_0x1b79:
            r45 = 0
        L_0x1b7b:
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r0 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            if (r0 != r1) goto L_0x1b9e
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1b8a
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1b8a:
            r38 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r33 = r0
            r33.mo18018a(r34, r35, r36, r37, r38, r40, r41, r42, r43, r44, r45)
            goto L_0x1bac
        L_0x1b9e:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1ba7
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1ba7:
            r33 = r0
            r33.mo18018a(r34, r35, r36, r37, r38, r40, r41, r42, r43, r44, r45)
        L_0x1bac:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1bb5
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1bb5:
            r1 = 0
            r0.mo17993a((int) r1, (boolean) r13)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1bc2
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1bc2:
            boolean r0 = r0.mo17958x()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1bd1
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1bd1:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1be0
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1be0:
            boolean r0 = r0.mo17872U()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1bef
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1bef:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 != 0) goto L_0x1bf8
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1bf8:
            r0.mo22142b((boolean) r13)
            goto L_0x2ddb
        L_0x1bfd:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.ByteArray"
            r0.<init>(r1)
            throw r0
        L_0x1c05:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1c0e
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1c0e:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x1c17
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x1c17:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x1c20
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1c20:
            boolean[] r6 = new boolean[r14]
            r6 = {1, 0} // fill-array
            boolean r1 = r1.mo21535a((boolean[]) r6)
            r0.mo17985Y(r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1c35
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1c35:
            boolean r0 = r0.mo17859H()
            r1 = r19
            java.lang.String r1 = (java.lang.String) r1
            int r6 = r10.length
            if (r6 >= r3) goto L_0x1c41
            return
        L_0x1c41:
            int r6 = r10.length
            if (r6 <= r2) goto L_0x1c4c
            r6 = r10[r2]
            if (r6 == 0) goto L_0x1c4c
            r1 = r10[r2]
            java.lang.String r1 = (java.lang.String) r1
        L_0x1c4c:
            r47 = r1
            int r1 = r10.length
            if (r1 <= r15) goto L_0x1c68
            r1 = r10[r15]
            if (r1 == 0) goto L_0x1c68
            r0 = r10[r15]
            if (r0 == 0) goto L_0x1c60
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto L_0x1c68
        L_0x1c60:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x1c68:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x1c71
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x1c71:
            boolean r1 = r1.mo18041aZ()
            if (r1 != 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x1c80
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x1c80:
            boolean r1 = r1.mo17859H()
            if (r1 != 0) goto L_0x1c88
            if (r0 == 0) goto L_0x1c8e
        L_0x1c88:
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API1
            if (r1 == r2) goto L_0x2ddb
        L_0x1c8e:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x1c97
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x1c97:
            boolean r1 = r1.mo18070bD()
            if (r1 != 0) goto L_0x2ddb
            byte[] r19 = (byte[]) r19
            r1 = 0
            r2 = r10[r1]
            if (r2 == 0) goto L_0x1ca8
            r2 = r10[r1]
            byte[] r2 = (byte[]) r2
        L_0x1ca8:
            r1 = r10[r13]
            if (r1 == 0) goto L_0x1cbf
            r1 = r10[r13]
            if (r1 == 0) goto L_0x1cb7
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r12 = r1.intValue()
            goto L_0x1cc0
        L_0x1cb7:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x1cbf:
            r12 = 0
        L_0x1cc0:
            r1 = r10[r14]
            if (r1 == 0) goto L_0x1cd9
            r1 = r10[r14]
            if (r1 == 0) goto L_0x1cd1
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r45 = r1
            goto L_0x1cdb
        L_0x1cd1:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x1cd9:
            r45 = 0
        L_0x1cdb:
            r1 = r10[r11]
            if (r1 == 0) goto L_0x1cf2
            r1 = r10[r11]
            if (r1 == 0) goto L_0x1cea
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x1cf3
        L_0x1cea:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x1cf2:
            r1 = 0
        L_0x1cf3:
            r2 = 4
            r6 = r10[r2]
            if (r6 == 0) goto L_0x1d0b
            r6 = r10[r2]
            if (r6 == 0) goto L_0x1d03
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r2 = r6.intValue()
            goto L_0x1d0c
        L_0x1d03:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x1d0b:
            r2 = 0
        L_0x1d0c:
            r6 = r10[r5]
            if (r6 == 0) goto L_0x1d23
            r5 = r10[r5]
            if (r5 == 0) goto L_0x1d1b
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            goto L_0x1d25
        L_0x1d1b:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Long"
            r0.<init>(r1)
            throw r0
        L_0x1d23:
            r5 = 0
        L_0x1d25:
            int r9 = r10.length
            if (r9 < r3) goto L_0x1d3f
            r9 = r10[r3]
            if (r9 == 0) goto L_0x1d3f
            r3 = r10[r3]
            if (r3 == 0) goto L_0x1d37
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            goto L_0x1d40
        L_0x1d37:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x1d3f:
            r3 = 0
        L_0x1d40:
            com.meizu.media.camera.MzCamModule r9 = r8.f9938b
            if (r9 != 0) goto L_0x1d49
            java.lang.String r10 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r10)
        L_0x1d49:
            int r9 = r9.mo18194dR()
            com.meizu.media.camera.util.ac$a r10 = r8.f9939c
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r15 = "RESULT_PICTURE_POSTVIEW_CALLBACK needFastThumbail:"
            r11.append(r15)
            r11.append(r3)
            java.lang.String r11 = r11.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r10, r11)
            if (r3 == 0) goto L_0x1f6e
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x1d6e
            java.lang.String r10 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r10)
        L_0x1d6e:
            int r3 = r3.mo18031aP()
            if (r3 != r13) goto L_0x1d76
            r3 = 1
            goto L_0x1d77
        L_0x1d76:
            r3 = 0
        L_0x1d77:
            int r10 = r12 + r9
            int r10 = r10 % r4
            if (r10 == 0) goto L_0x1d87
            if (r9 == r7) goto L_0x1d87
            r10 = 270(0x10e, float:3.78E-43)
            if (r9 == r10) goto L_0x1d87
            r50 = r2
            r2 = r1
            r1 = r50
        L_0x1d87:
            com.meizu.media.camera.MzCamModule r10 = r8.f9938b
            if (r10 != 0) goto L_0x1d90
            java.lang.String r11 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r11)
        L_0x1d90:
            com.meizu.media.camera.ui.i r10 = r10.mo18267u()
            if (r10 != 0) goto L_0x1d99
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1d99:
            android.graphics.Bitmap r10 = r10.mo22132au()
            if (r10 == 0) goto L_0x1f51
            boolean r11 = r10.isRecycled()
            if (r11 == 0) goto L_0x1da7
            goto L_0x1f51
        L_0x1da7:
            com.meizu.media.camera.MzCamModule r11 = r8.f9938b
            if (r11 != 0) goto L_0x1db0
            java.lang.String r15 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r15)
        L_0x1db0:
            boolean r11 = r11.mo17859H()
            if (r11 != 0) goto L_0x1db8
            if (r0 == 0) goto L_0x1dbe
        L_0x1db8:
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r0 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r11 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r0 == r11) goto L_0x1e34
        L_0x1dbe:
            if (r3 == 0) goto L_0x1de5
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1dc9
            java.lang.String r11 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r11)
        L_0x1dc9:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x1dd2
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1dd2:
            boolean r0 = r0.mo21615m()
            if (r0 == 0) goto L_0x1de5
            android.graphics.Bitmap r10 = com.meizu.media.camera.util.BitmapUtils.m16147c(r10)
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.String r3 = "verticalConvert"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r3)
            goto L_0x1e85
        L_0x1de5:
            if (r3 == 0) goto L_0x1e12
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1df0
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x1df0:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x1df9
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1df9:
            boolean r0 = r0.mo21615m()
            if (r0 != 0) goto L_0x1e12
            if (r12 == r7) goto L_0x1e05
            r0 = 270(0x10e, float:3.78E-43)
            if (r12 != r0) goto L_0x1e12
        L_0x1e05:
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.String r3 = "mirrorConvert"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r3)
            android.graphics.Bitmap r10 = com.meizu.media.camera.util.BitmapUtils.m16140a(r10)
            goto L_0x1e85
        L_0x1e12:
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = com.meizu.media.camera.mode.CameraModeType.ModeType.SQUARE
            boolean r0 = com.meizu.media.camera.mode.CameraModeType.m10985n((com.meizu.media.camera.mode.CameraModeType.ModeType) r0)
            if (r0 == 0) goto L_0x1e85
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1e23
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x1e23:
            boolean r0 = r0.mo18098bf()
            if (r0 == 0) goto L_0x1e85
            int r1 = java.lang.Math.min(r1, r2)
            r0 = 0
            android.graphics.Bitmap r10 = com.meizu.media.camera.util.CameraUtil.m15822a((android.graphics.Bitmap) r10, (boolean) r0, (int) r9)
            r2 = r1
            goto L_0x1e85
        L_0x1e34:
            if (r3 == 0) goto L_0x1e60
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1e3f
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x1e3f:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x1e48
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1e48:
            boolean r0 = r0.mo21615m()
            if (r0 != 0) goto L_0x1e60
            if (r12 == r7) goto L_0x1e5a
            r0 = 270(0x10e, float:3.78E-43)
            if (r12 != r0) goto L_0x1e55
            goto L_0x1e5a
        L_0x1e55:
            android.graphics.Bitmap r0 = com.meizu.media.camera.util.BitmapUtils.m16147c(r10)
            goto L_0x1e5e
        L_0x1e5a:
            android.graphics.Bitmap r0 = com.meizu.media.camera.util.BitmapUtils.m16140a(r10)
        L_0x1e5e:
            r10 = r0
            goto L_0x1e85
        L_0x1e60:
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = com.meizu.media.camera.mode.CameraModeType.ModeType.SQUARE
            boolean r0 = com.meizu.media.camera.mode.CameraModeType.m10985n((com.meizu.media.camera.mode.CameraModeType.ModeType) r0)
            if (r0 == 0) goto L_0x1e85
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1e71
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x1e71:
            boolean r0 = r0.mo18098bf()
            if (r0 == 0) goto L_0x1e85
            int r0 = java.lang.Math.min(r1, r2)
            r1 = 0
            android.graphics.Bitmap r10 = com.meizu.media.camera.util.CameraUtil.m15822a((android.graphics.Bitmap) r10, (boolean) r1, (int) r9)
            r39 = r0
            r40 = r39
            goto L_0x1e89
        L_0x1e85:
            r39 = r1
            r40 = r2
        L_0x1e89:
            if (r10 != 0) goto L_0x1e8c
            return
        L_0x1e8c:
            r0 = 270(0x10e, float:3.78E-43)
            if (r9 == r0) goto L_0x1e98
            if (r9 == r7) goto L_0x1e98
            if (r9 != r4) goto L_0x1e95
            goto L_0x1e98
        L_0x1e95:
            r34 = r10
            goto L_0x1e9e
        L_0x1e98:
            android.graphics.Bitmap r0 = com.meizu.media.camera.util.BitmapUtils.m16141a(r10, r9)
            r34 = r0
        L_0x1e9e:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1ea7
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1ea7:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()
            if (r0 != 0) goto L_0x1eb0
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1eb0:
            com.meizu.media.camera.MediaSaveService r33 = r0.mo17689p()
            java.lang.String r35 = com.meizu.media.camera.util.CameraUtil.m15831a((long) r5)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1ec1
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1ec1:
            com.meizu.media.camera.app.e r0 = r0.mo18192dP()
            android.location.Location r38 = r0.mo19017a((long) r5)
            r41 = 0
            r42 = 0
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1ed6
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1ed6:
            com.meizu.media.camera.MediaSaveService$d r43 = r0.mo18208df()
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1ee3
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1ee3:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()
            if (r0 != 0) goto L_0x1eec
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1eec:
            android.content.ContentResolver r44 = r0.getContentResolver()
            r46 = 1
            r48 = 0
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r49 = r0
            r36 = r5
            r33.mo17828a(r34, r35, r36, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1f07
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1f07:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x1f10
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1f10:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x1f19
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x1f19:
            int r1 = r1.mo18068bB()
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x1f26
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x1f26:
            boolean r2 = r2.mo18116bx()
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x1f33
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x1f33:
            boolean r3 = r3.mo18032aQ()
            r0.mo21516a((android.graphics.Bitmap) r10, (int) r1, (boolean) r2, (boolean) r3)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1f43
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1f43:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x1f4c
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1f4c:
            r1 = 4
            r0.mo21581d((int) r1, (boolean) r13)
            goto L_0x1f6e
        L_0x1f51:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1f5a
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1f5a:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x1f63
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1f63:
            r0.mo21627q((boolean) r13)
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.String r1 = "MFLL RESULT_PICTURE_POSTVIEW_CALLBACK recycled"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            return
        L_0x1f6e:
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f13878ae
            if (r0 == 0) goto L_0x1f87
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1f7b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1f7b:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x1f84
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1f84:
            r0.mo21581d((int) r14, (boolean) r13)
        L_0x1f87:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1f90
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1f90:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1f9f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1f9f:
            boolean r0 = r0.mo17872U()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1fae
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1fae:
            boolean r0 = r0.mo18070bD()
            if (r0 != 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1fbd
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1fbd:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 != 0) goto L_0x1fc6
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x1fc6:
            r0.mo22142b((boolean) r13)
            goto L_0x2ddb
        L_0x1fcb:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1fd4
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1fd4:
            boolean r0 = r0.mo17958x()
            if (r0 != 0) goto L_0x2067
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7846m()
            if (r0 != 0) goto L_0x2067
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x1fe9
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x1fe9:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 == 0) goto L_0x2025
            r0.mo21581d((int) r3, (boolean) r13)
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13888ao
            if (r1 == 0) goto L_0x2023
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x1fff
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x1fff:
            com.meizu.media.camera.mode.f r1 = r1.mo18029aN()
            if (r1 != 0) goto L_0x2008
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x2008:
            com.meizu.media.camera.mode.CameraModeType$ModeType r2 = com.meizu.media.camera.mode.CameraModeType.ModeType.AUTO
            boolean r1 = r1.mo20547a((com.meizu.media.camera.mode.CameraModeType.ModeType) r2)
            if (r1 == 0) goto L_0x2023
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2019
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2019:
            boolean r1 = r1.mo18116bx()
            if (r1 == 0) goto L_0x2023
            r1 = 0
            r0.mo21478B(r1)
        L_0x2023:
            kotlin.t r0 = kotlin.Unit.f18749a
        L_0x2025:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x202e
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x202e:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 == 0) goto L_0x2067
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x203d
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x203d:
            boolean r0 = r0.mo17872U()
            if (r0 == 0) goto L_0x2067
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x204c
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x204c:
            boolean r0 = r0.mo18070bD()
            if (r0 != 0) goto L_0x2067
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x205b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x205b:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 != 0) goto L_0x2064
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x2064:
            r0.mo22142b((boolean) r13)
        L_0x2067:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2070
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2070:
            boolean[] r1 = new boolean[r13]
            r2 = 0
            r1[r2] = r13
            r0.mo18122c((boolean[]) r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2081
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2081:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x208a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x208a:
            r0.mo20381E()
            goto L_0x2ddb
        L_0x208f:
            boolean r0 = com.meizu.media.camera.util.DeviceHelper.f13840T
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x209c
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x209c:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x20a5
            java.lang.String r6 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r6)
        L_0x20a5:
            com.meizu.media.camera.u r1 = r1.mo18036aU()
            if (r1 != 0) goto L_0x20ae
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x20ae:
            boolean[] r6 = new boolean[r14]
            r6 = {1, 0} // fill-array
            boolean r1 = r1.mo21535a((boolean[]) r6)
            r0.mo17985Y(r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x20c3
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x20c3:
            boolean r0 = r0.mo18041aZ()
            if (r0 != 0) goto L_0x2ddb
            int r0 = r10.length
            if (r0 >= r3) goto L_0x20cd
            return
        L_0x20cd:
            java.lang.String r19 = (java.lang.String) r19
            r0 = 0
            r1 = r10[r0]
            if (r1 == 0) goto L_0x20e7
            r1 = r10[r0]
            if (r1 == 0) goto L_0x20df
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r12 = r1.booleanValue()
            goto L_0x20e8
        L_0x20df:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x20e7:
            r12 = 0
        L_0x20e8:
            r0 = r10[r13]
            if (r0 == 0) goto L_0x20ff
            r0 = r10[r13]
            if (r0 == 0) goto L_0x20f7
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x2100
        L_0x20f7:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x20ff:
            r0 = 0
        L_0x2100:
            r1 = r10[r14]
            if (r1 == 0) goto L_0x2119
            r1 = r10[r14]
            if (r1 == 0) goto L_0x2111
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r26 = r1
            goto L_0x211b
        L_0x2111:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x2119:
            r26 = 0
        L_0x211b:
            r1 = r10[r11]
            if (r1 == 0) goto L_0x2132
            r1 = r10[r11]
            if (r1 == 0) goto L_0x212a
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x2133
        L_0x212a:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x2132:
            r1 = 0
        L_0x2133:
            r3 = 4
            r6 = r10[r3]
            if (r6 == 0) goto L_0x214b
            r6 = r10[r3]
            if (r6 == 0) goto L_0x2143
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r3 = r6.intValue()
            goto L_0x214c
        L_0x2143:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x214b:
            r3 = 0
        L_0x214c:
            r6 = r10[r5]
            if (r6 == 0) goto L_0x2163
            r5 = r10[r5]
            if (r5 == 0) goto L_0x215b
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            goto L_0x2165
        L_0x215b:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Long"
            r0.<init>(r1)
            throw r0
        L_0x2163:
            r5 = 0
        L_0x2165:
            int r9 = r10.length
            if (r9 <= r2) goto L_0x2172
            r9 = r10[r2]
            if (r9 == 0) goto L_0x2172
            r2 = r10[r2]
            r19 = r2
            java.lang.String r19 = (java.lang.String) r19
        L_0x2172:
            r28 = r19
            int r2 = r10.length
            if (r2 <= r15) goto L_0x218e
            r2 = r10[r15]
            if (r2 == 0) goto L_0x218e
            r2 = r10[r15]
            if (r2 == 0) goto L_0x2186
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            goto L_0x218f
        L_0x2186:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x218e:
            r2 = 0
        L_0x218f:
            com.meizu.media.camera.util.ac$a r9 = r8.f9939c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "RESULT_SHUTTER_CALLBACK needFastThumbail:"
            r10.append(r11)
            r10.append(r12)
            java.lang.String r10 = r10.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r9, r10)
            if (r12 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r9 = r8.f9938b
            if (r9 != 0) goto L_0x21b0
            java.lang.String r10 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r10)
        L_0x21b0:
            int r9 = r9.mo18194dR()
            com.meizu.media.camera.MzCamModule r10 = r8.f9938b
            if (r10 != 0) goto L_0x21bd
            java.lang.String r11 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r11)
        L_0x21bd:
            int r10 = r10.mo18031aP()
            if (r10 != r13) goto L_0x21c5
            r10 = 1
            goto L_0x21c6
        L_0x21c5:
            r10 = 0
        L_0x21c6:
            int r11 = r0 + r9
            int r11 = r11 % r4
            if (r11 == 0) goto L_0x21d6
            if (r9 == r7) goto L_0x21d6
            r11 = 270(0x10e, float:3.78E-43)
            if (r9 == r11) goto L_0x21d6
            r50 = r3
            r3 = r1
            r1 = r50
        L_0x21d6:
            com.meizu.media.camera.MzCamModule r11 = r8.f9938b
            if (r11 != 0) goto L_0x21df
            java.lang.String r12 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r12)
        L_0x21df:
            com.meizu.media.camera.ui.i r11 = r11.mo18267u()
            if (r11 != 0) goto L_0x21e8
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x21e8:
            android.graphics.Bitmap r11 = r11.mo22132au()
            if (r11 == 0) goto L_0x23a0
            boolean r12 = r11.isRecycled()
            if (r12 == 0) goto L_0x21f6
            goto L_0x23a0
        L_0x21f6:
            com.meizu.media.camera.MzCamModule r12 = r8.f9938b
            if (r12 != 0) goto L_0x21ff
            java.lang.String r14 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r14)
        L_0x21ff:
            boolean r12 = r12.mo17859H()
            if (r12 != 0) goto L_0x2207
            if (r2 == 0) goto L_0x220d
        L_0x2207:
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r12 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r2 == r12) goto L_0x2286
        L_0x220d:
            if (r10 == 0) goto L_0x2237
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2218
            java.lang.String r12 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r12)
        L_0x2218:
            com.meizu.media.camera.u r2 = r2.mo18036aU()
            if (r2 != 0) goto L_0x2221
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x2221:
            boolean r2 = r2.mo21615m()
            if (r2 == 0) goto L_0x2237
            android.graphics.Bitmap r11 = com.meizu.media.camera.util.BitmapUtils.m16147c(r11)
            if (r11 != 0) goto L_0x222e
            return
        L_0x222e:
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.String r2 = "verticalConvert"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r2)
            goto L_0x22d6
        L_0x2237:
            if (r10 == 0) goto L_0x2264
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2242
            java.lang.String r10 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r10)
        L_0x2242:
            com.meizu.media.camera.u r2 = r2.mo18036aU()
            if (r2 != 0) goto L_0x224b
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x224b:
            boolean r2 = r2.mo21615m()
            if (r2 != 0) goto L_0x2264
            if (r0 == r7) goto L_0x2257
            r2 = 270(0x10e, float:3.78E-43)
            if (r0 != r2) goto L_0x2264
        L_0x2257:
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.String r2 = "mirrorConvert"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r2)
            android.graphics.Bitmap r11 = com.meizu.media.camera.util.BitmapUtils.m16140a(r11)
            goto L_0x22d6
        L_0x2264:
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = com.meizu.media.camera.mode.CameraModeType.ModeType.SQUARE
            boolean r0 = com.meizu.media.camera.mode.CameraModeType.m10985n((com.meizu.media.camera.mode.CameraModeType.ModeType) r0)
            if (r0 == 0) goto L_0x22d6
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2275
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2275:
            boolean r0 = r0.mo18098bf()
            if (r0 == 0) goto L_0x22d6
            int r1 = java.lang.Math.min(r1, r3)
            r0 = 0
            android.graphics.Bitmap r11 = com.meizu.media.camera.util.CameraUtil.m15822a((android.graphics.Bitmap) r11, (boolean) r0, (int) r9)
            r3 = r1
            goto L_0x22d6
        L_0x2286:
            if (r10 == 0) goto L_0x22b2
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2291
            java.lang.String r10 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r10)
        L_0x2291:
            com.meizu.media.camera.u r2 = r2.mo18036aU()
            if (r2 != 0) goto L_0x229a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x229a:
            boolean r2 = r2.mo21615m()
            if (r2 != 0) goto L_0x22b2
            if (r0 == r7) goto L_0x22ac
            r2 = 270(0x10e, float:3.78E-43)
            if (r0 != r2) goto L_0x22a7
            goto L_0x22ac
        L_0x22a7:
            android.graphics.Bitmap r0 = com.meizu.media.camera.util.BitmapUtils.m16147c(r11)
            goto L_0x22b0
        L_0x22ac:
            android.graphics.Bitmap r0 = com.meizu.media.camera.util.BitmapUtils.m16140a(r11)
        L_0x22b0:
            r11 = r0
            goto L_0x22d6
        L_0x22b2:
            com.meizu.media.camera.mode.CameraModeType$ModeType r0 = com.meizu.media.camera.mode.CameraModeType.ModeType.SQUARE
            boolean r0 = com.meizu.media.camera.mode.CameraModeType.m10985n((com.meizu.media.camera.mode.CameraModeType.ModeType) r0)
            if (r0 == 0) goto L_0x22d6
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x22c3
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x22c3:
            boolean r0 = r0.mo18098bf()
            if (r0 == 0) goto L_0x22d6
            int r0 = java.lang.Math.min(r1, r3)
            r1 = 0
            android.graphics.Bitmap r11 = com.meizu.media.camera.util.CameraUtil.m15822a((android.graphics.Bitmap) r11, (boolean) r1, (int) r9)
            r1 = r0
            r21 = r1
            goto L_0x22d8
        L_0x22d6:
            r21 = r3
        L_0x22d8:
            if (r11 == 0) goto L_0x2ddb
            r0 = 270(0x10e, float:3.78E-43)
            if (r9 == r0) goto L_0x22e5
            if (r9 == r7) goto L_0x22e5
            if (r9 != r4) goto L_0x22e3
            goto L_0x22e5
        L_0x22e3:
            r15 = r11
            goto L_0x22ea
        L_0x22e5:
            android.graphics.Bitmap r0 = com.meizu.media.camera.util.BitmapUtils.m16141a(r11, r9)
            r15 = r0
        L_0x22ea:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x22f3
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x22f3:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()
            if (r0 != 0) goto L_0x22fc
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x22fc:
            com.meizu.media.camera.MediaSaveService r14 = r0.mo17689p()
            java.lang.String r16 = com.meizu.media.camera.util.CameraUtil.m15831a((long) r5)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x230d
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x230d:
            com.meizu.media.camera.app.e r0 = r0.mo18192dP()
            android.location.Location r19 = r0.mo19017a((long) r5)
            r22 = 0
            r23 = 0
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2322
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2322:
            com.meizu.media.camera.MediaSaveService$d r24 = r0.mo18208df()
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x232f
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x232f:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()
            if (r0 != 0) goto L_0x2338
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x2338:
            android.content.ContentResolver r25 = r0.getContentResolver()
            r27 = 1
            r29 = 0
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r30 = r0
            r17 = r5
            r20 = r1
            r14.mo17828a(r15, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2355
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2355:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x235e
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x235e:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2367
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2367:
            int r1 = r1.mo18068bB()
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2374
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x2374:
            boolean r2 = r2.mo18116bx()
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x2381
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x2381:
            boolean r3 = r3.mo18032aQ()
            r0.mo21516a((android.graphics.Bitmap) r11, (int) r1, (boolean) r2, (boolean) r3)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2391
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2391:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x239a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x239a:
            r1 = 4
            r0.mo21581d((int) r1, (boolean) r13)
            goto L_0x2ddb
        L_0x23a0:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x23a9
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x23a9:
            com.meizu.media.camera.u r0 = r0.mo18036aU()
            if (r0 != 0) goto L_0x23b2
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x23b2:
            r0.mo21627q((boolean) r13)
            return
        L_0x23b6:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_OK
            if (r0 == r9) goto L_0x23be
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_NULL_CAMERA
            if (r0 != r9) goto L_0x2ddb
        L_0x23be:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x23c7
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x23c7:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 != 0) goto L_0x23d0
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x23d0:
            r0.mo22162g((boolean) r13)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x23dc
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x23dc:
            r1 = 0
            r0.mo17961A(r1)
            goto L_0x2ddb
        L_0x23e2:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_OK
            if (r0 != r9) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x23ef
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x23ef:
            r0.mo17961A(r13)
            goto L_0x2ddb
        L_0x23f4:
            if (r9 != 0) goto L_0x23f8
            goto L_0x2ddb
        L_0x23f8:
            int[] r0 = com.meizu.media.camera.p069f.C2049e.f9956e
            int r1 = r53.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x247d;
                case 2: goto L_0x2452;
                case 3: goto L_0x2405;
                default: goto L_0x2403;
            }
        L_0x2403:
            goto L_0x2ddb
        L_0x2405:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x240e
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x240e:
            r1 = -1
            r0.mo18262s((int) r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x241b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x241b:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()
            if (r0 != 0) goto L_0x2424
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x2424:
            boolean r0 = r0.mo17699z()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2433
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2433:
            android.os.Handler r0 = r0.mo18110br()
            if (r0 == 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2442
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2442:
            android.os.Handler r0 = r0.mo18110br()
            com.meizu.media.camera.f.d$f r1 = new com.meizu.media.camera.f.d$f
            r1.<init>(r8)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r0.post(r1)
            goto L_0x2ddb
        L_0x2452:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x245b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x245b:
            r1 = 0
            r0.mo17961A(r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2468
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2468:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()
            if (r0 != 0) goto L_0x2471
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x2471:
            com.meizu.media.camera.f.d$e r1 = new com.meizu.media.camera.f.d$e
            r1.<init>(r8)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r0.runOnUiThread(r1)
            goto L_0x2ddb
        L_0x247d:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2486
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2486:
            boolean r0 = r0.mo18035aT()
            if (r0 == 0) goto L_0x24a1
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2495
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2495:
            r1 = -1
            r0.mo18246l((int) r1)
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.String r1 = "camera has been closed,return!"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            return
        L_0x24a1:
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.String r1 = " receive REQUEST_CODE_CLOSE_CAMERA"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x24b1
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x24b1:
            boolean r0 = r0.mo18077bK()
            if (r0 != 0) goto L_0x24e1
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x24c0
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x24c0:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 != 0) goto L_0x24c9
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x24c9:
            r0.mo22203z()
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x24d5
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x24d5:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 != 0) goto L_0x24de
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x24de:
            r0.mo22039B()
        L_0x24e1:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x24ea
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x24ea:
            android.os.Handler r0 = r0.mo18110br()
            r1 = 25
            r0.removeMessages(r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x24fc
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x24fc:
            android.os.Handler r0 = r0.mo18110br()
            r1 = 28
            r0.sendEmptyMessage(r1)
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x250e
            java.lang.String r0 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r0)
        L_0x250e:
            monitor-enter(r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b     // Catch:{ all -> 0x254f }
            if (r0 != 0) goto L_0x2518
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)     // Catch:{ all -> 0x254f }
        L_0x2518:
            r0.mo18269u((boolean) r13)     // Catch:{ all -> 0x254f }
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b     // Catch:{ all -> 0x254f }
            if (r0 != 0) goto L_0x2524
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)     // Catch:{ all -> 0x254f }
        L_0x2524:
            boolean r0 = r0.mo18033aR()     // Catch:{ all -> 0x254f }
            if (r0 != 0) goto L_0x2533
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c     // Catch:{ all -> 0x254f }
            java.lang.String r2 = "onDestroy() has not been called,return"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r2)     // Catch:{ all -> 0x254f }
            monitor-exit(r1)
            return
        L_0x2533:
            kotlin.t r0 = kotlin.Unit.f18749a     // Catch:{ all -> 0x254f }
            monitor-exit(r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x253f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x253f:
            android.os.Handler r0 = r0.mo18110br()
            com.meizu.media.camera.f.d$d r1 = new com.meizu.media.camera.f.d$d
            r1.<init>(r8)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r0.post(r1)
            goto L_0x2ddb
        L_0x254f:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x2552:
            if (r9 != 0) goto L_0x2556
            goto L_0x2ddb
        L_0x2556:
            int[] r0 = com.meizu.media.camera.p069f.C2049e.f9955d
            int r1 = r53.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x2645;
                case 2: goto L_0x2645;
                case 3: goto L_0x25c3;
                case 4: goto L_0x2563;
                default: goto L_0x2561;
            }
        L_0x2561:
            goto L_0x2ddb
        L_0x2563:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x256c
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x256c:
            com.meizu.media.camera.MzCamController$ModuleState r0 = r0.mo18115bw()
            com.meizu.media.camera.MzCamController$ModuleState r1 = com.meizu.media.camera.MzCamController.ModuleState.SWITCHING_MODE
            if (r0 == r1) goto L_0x259a
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x257d
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x257d:
            com.meizu.media.camera.MzCamController$ModuleState r0 = r0.mo18115bw()
            com.meizu.media.camera.MzCamController$ModuleState r1 = com.meizu.media.camera.MzCamController.ModuleState.SWITCHING_CAMERA
            if (r0 != r1) goto L_0x2586
            goto L_0x259a
        L_0x2586:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x258f
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x258f:
            android.os.Handler r0 = r0.mo18110br()
            r1 = 17
            r0.sendEmptyMessage(r1)
            goto L_0x2ddb
        L_0x259a:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x25a3
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x25a3:
            int r0 = r0.mo18081bO()
            if (r0 > 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x25b2
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x25b2:
            r0.mo17964D(r13)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x25be
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x25be:
            r0.mo17970J(r13)
            goto L_0x2ddb
        L_0x25c3:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x25cc
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x25cc:
            r1 = 0
            r0.mo17964D(r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x25d9
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x25d9:
            r0.mo18262s((int) r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x25e5
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x25e5:
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            if (r0 != 0) goto L_0x25ee
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x25ee:
            r0.mo22101aH()
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x25fa
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x25fa:
            int r0 = r0.mo18081bO()
            if (r0 <= 0) goto L_0x2612
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2609
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2609:
            int r1 = r0.mo18081bO()
            r2 = -1
            int r1 = r1 + r2
            r0.mo18249n((int) r1)
        L_0x2612:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x261b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x261b:
            int r0 = r0.mo18081bO()
            if (r0 != 0) goto L_0x2630
            com.meizu.media.camera.f.d$c r0 = new com.meizu.media.camera.f.d$c
            r0.<init>(r8)
            java.util.concurrent.Executor r1 = com.meizu.media.camera.util.AsyncTaskEx.f13741o
            r2 = 0
            java.lang.Void[] r2 = new java.lang.Void[r2]
            r0.mo22610a((java.util.concurrent.Executor) r1, (Params[]) r2)
            goto L_0x2ddb
        L_0x2630:
            r2 = 0
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x263a
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x263a:
            int r0 = r0.mo18081bO()
            if (r0 <= 0) goto L_0x2ddb
            com.meizu.media.camera.CameraOptTask.m8370a((boolean) r2, (boolean) r13)
            goto L_0x2ddb
        L_0x2645:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x264e
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x264e:
            int r0 = r0.mo18081bO()
            if (r0 <= 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x265d
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x265d:
            int r1 = r0.mo18081bO()
            r2 = -1
            int r1 = r1 + r2
            r0.mo18249n((int) r1)
            goto L_0x2ddb
        L_0x2668:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_OK
            if (r0 != r9) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2675
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2675:
            r1 = 0
            r0.mo17964D(r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2682
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2682:
            com.meizu.media.camera.h r0 = r0.mo18097be()
            if (r0 == 0) goto L_0x269d
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2691
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2691:
            com.meizu.media.camera.h r0 = r0.mo18097be()
            if (r0 != 0) goto L_0x269a
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x269a:
            r0.mo20217d()
        L_0x269d:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x26a6
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x26a6:
            r1 = 0
            r0.mo18262s((int) r1)
            goto L_0x2ddb
        L_0x26ac:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_START_PREVIEW_DONE
            if (r0 != r9) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x26b9
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x26b9:
            com.meizu.media.camera.MzCamController$ModuleState r0 = r0.mo18115bw()
            com.meizu.media.camera.MzCamController$ModuleState r1 = com.meizu.media.camera.MzCamController.ModuleState.SWITCHING_MODE
            if (r0 == r1) goto L_0x26e7
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x26ca
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x26ca:
            com.meizu.media.camera.MzCamController$ModuleState r0 = r0.mo18115bw()
            com.meizu.media.camera.MzCamController$ModuleState r1 = com.meizu.media.camera.MzCamController.ModuleState.SWITCHING_CAMERA
            if (r0 != r1) goto L_0x26d3
            goto L_0x26e7
        L_0x26d3:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x26dc
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x26dc:
            android.os.Handler r0 = r0.mo18110br()
            r1 = 17
            r0.sendEmptyMessage(r1)
            goto L_0x2ddb
        L_0x26e7:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x26f0
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x26f0:
            int r0 = r0.mo18081bO()
            if (r0 > 0) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x26ff
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x26ff:
            r0.mo17964D(r13)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x270b
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x270b:
            r0.mo17970J(r13)
            goto L_0x2ddb
        L_0x2710:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2719
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2719:
            java.lang.Object r1 = r0.mo18088bV()
            monitor-enter(r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b     // Catch:{ all -> 0x27bd }
            if (r0 != 0) goto L_0x2727
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)     // Catch:{ all -> 0x27bd }
        L_0x2727:
            android.graphics.SurfaceTexture r0 = r0.mo18086bT()     // Catch:{ all -> 0x27bd }
            if (r0 != 0) goto L_0x2736
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c     // Catch:{ all -> 0x27bd }
            java.lang.String r2 = "onPreviewUIReady: surfaceTexture is not ready."
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r2)     // Catch:{ all -> 0x27bd }
            monitor-exit(r1)
            return
        L_0x2736:
            com.meizu.media.camera.camcontroller.CameraController r0 = com.meizu.media.camera.camcontroller.CameraController.m8868g()     // Catch:{ all -> 0x27bd }
            java.lang.String r2 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ all -> 0x27bd }
            com.meizu.media.camera.camcontroller.d r0 = r0.mo19522k()     // Catch:{ all -> 0x27bd }
            if (r0 != 0) goto L_0x274e
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c     // Catch:{ all -> 0x27bd }
            java.lang.String r2 = "onPreviewUIReady: camera device is not ready."
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r2)     // Catch:{ all -> 0x27bd }
            monitor-exit(r1)
            return
        L_0x274e:
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c     // Catch:{ all -> 0x27bd }
            java.lang.String r2 = "before setPreviewTexture"
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r2)     // Catch:{ all -> 0x27bd }
            com.meizu.media.camera.camcontroller.CameraController r0 = com.meizu.media.camera.camcontroller.CameraController.m8868g()     // Catch:{ all -> 0x27bd }
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b     // Catch:{ all -> 0x27bd }
            if (r2 != 0) goto L_0x2762
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)     // Catch:{ all -> 0x27bd }
        L_0x2762:
            android.graphics.SurfaceTexture r2 = r2.mo18086bT()     // Catch:{ all -> 0x27bd }
            r0.mo19454a((android.graphics.SurfaceTexture) r2)     // Catch:{ all -> 0x27bd }
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c     // Catch:{ all -> 0x27bd }
            java.lang.String r2 = "after setPreviewTexture"
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r2)     // Catch:{ all -> 0x27bd }
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b     // Catch:{ all -> 0x27bd }
            if (r0 != 0) goto L_0x2779
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)     // Catch:{ all -> 0x27bd }
        L_0x2779:
            com.meizu.media.camera.CameraActivity r0 = r0.mo18030aO()     // Catch:{ all -> 0x27bd }
            if (r0 != 0) goto L_0x2782
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x27bd }
        L_0x2782:
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x27bd }
            java.util.UUID r2 = r51.mo18056b()     // Catch:{ all -> 0x27bd }
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b     // Catch:{ all -> 0x27bd }
            if (r3 != 0) goto L_0x2793
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)     // Catch:{ all -> 0x27bd }
        L_0x2793:
            com.meizu.media.camera.mode.f r3 = r3.mo18029aN()     // Catch:{ all -> 0x27bd }
            if (r3 != 0) goto L_0x279c
            kotlin.jvm.p108b.C3443i.m21151a()     // Catch:{ all -> 0x27bd }
        L_0x279c:
            com.meizu.media.camera.mode.CameraModeType$ModeType r3 = r3.mo20403g_()     // Catch:{ all -> 0x27bd }
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r4 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_START_PREVIEW     // Catch:{ all -> 0x27bd }
            android.content.Intent r0 = com.meizu.media.camera.CameraOptTask.m8342a(r0, r2, r3, r4)     // Catch:{ all -> 0x27bd }
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b     // Catch:{ all -> 0x27bd }
            if (r2 != 0) goto L_0x27af
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)     // Catch:{ all -> 0x27bd }
        L_0x27af:
            com.meizu.media.camera.CameraActivity r2 = r2.mo18030aO()     // Catch:{ all -> 0x27bd }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ all -> 0x27bd }
            com.meizu.media.camera.CameraOptTask.m8349a((android.content.Context) r2, (android.content.Intent) r0)     // Catch:{ all -> 0x27bd }
            kotlin.t r0 = kotlin.Unit.f18749a     // Catch:{ all -> 0x27bd }
            monitor-exit(r1)
            goto L_0x2ddb
        L_0x27bd:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x27c0:
            if (r9 != 0) goto L_0x27c4
            goto L_0x2ddb
        L_0x27c4:
            int[] r1 = com.meizu.media.camera.p069f.C2049e.f9954c
            int r2 = r53.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L_0x2da0;
                case 2: goto L_0x2b49;
                case 3: goto L_0x2a34;
                case 4: goto L_0x29a4;
                case 5: goto L_0x290a;
                case 6: goto L_0x28db;
                case 7: goto L_0x28cb;
                case 8: goto L_0x27ef;
                case 9: goto L_0x27e0;
                case 10: goto L_0x27d1;
                default: goto L_0x27cf;
            }
        L_0x27cf:
            goto L_0x2ddb
        L_0x27d1:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x27da
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x27da:
            r1 = 0
            r0.mo17961A(r1)
            goto L_0x2ddb
        L_0x27e0:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x27e9
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x27e9:
            r1 = -1
            r0.mo18262s((int) r1)
            goto L_0x2ddb
        L_0x27ef:
            int r1 = r10.length
            if (r1 <= r13) goto L_0x2851
            r1 = 0
            r2 = r10[r1]
            if (r2 == 0) goto L_0x2849
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r1 = r2.intValue()
            r2 = r10[r13]
            if (r2 == 0) goto L_0x2841
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            com.meizu.media.camera.util.ac$a r3 = r8.f9939c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "RESULT_OPEN_CAMERA_FAILURE cameraId:"
            r4.append(r5)
            r4.append(r1)
            java.lang.String r5 = ", isNextCloseCamera:"
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r3, r4)
            if (r2 != 0) goto L_0x2851
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2830
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x2830:
            com.meizu.media.camera.CameraActivity r2 = r2.mo18030aO()
            if (r2 != 0) goto L_0x2839
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x2839:
            com.meizu.media.camera.camcontroller.e$a r2 = r2.mo17696w()
            r2.mo17710a(r1)
            goto L_0x2851
        L_0x2841:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            r0.<init>(r1)
            throw r0
        L_0x2849:
            kotlin.q r0 = new kotlin.q
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r1)
            throw r0
        L_0x2851:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x285a
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x285a:
            r2 = 0
            r1.mo17966F(r2)
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r1 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_SWITCH_CAMERA
            if (r0 != r1) goto L_0x2ddb
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "RESULT_OPEN_CAMERA_FAILURE mSwitchingModeNum:"
            r1.append(r2)
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2877
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x2877:
            int r2 = r2.mo18081bO()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x288e
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x288e:
            int r0 = r0.mo18081bO()
            if (r0 <= 0) goto L_0x28a6
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x289d
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x289d:
            int r1 = r0.mo18081bO()
            r2 = -1
            int r1 = r1 + r2
            r0.mo18249n((int) r1)
        L_0x28a6:
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "RESULT_OPEN_CAMERA_FAILURE -1 mSwitchingModeNum:"
            r1.append(r2)
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x28bb
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x28bb:
            int r2 = r2.mo18081bO()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            goto L_0x2ddb
        L_0x28cb:
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.String r1 = "kill self"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            int r0 = android.os.Process.myPid()
            android.os.Process.killProcess(r0)
            goto L_0x2ddb
        L_0x28db:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x28e4
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x28e4:
            com.meizu.media.camera.f.h r1 = r1.mo18085bS()
            if (r1 == 0) goto L_0x28f7
            com.meizu.media.camera.util.AsyncTaskEx$Status r2 = r1.mo22613c()
            com.meizu.media.camera.util.AsyncTaskEx$Status r3 = com.meizu.media.camera.util.AsyncTaskEx.Status.FINISHED
            if (r2 == r3) goto L_0x28f5
            r1.mo22612b((boolean) r13)
        L_0x28f5:
            kotlin.t r1 = kotlin.Unit.f18749a
        L_0x28f7:
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r1 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_RESUME_CAMERA
            if (r0 != r1) goto L_0x2ddb
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2904
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2904:
            r1 = 0
            r0.mo18262s((int) r1)
            goto L_0x2ddb
        L_0x290a:
            r1 = 0
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r2 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_RESUME_CAMERA
            if (r0 != r2) goto L_0x291b
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2918
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x2918:
            r2.mo18269u((boolean) r1)
        L_0x291b:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2924
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2924:
            com.meizu.media.camera.f.h r1 = r1.mo18085bS()
            if (r1 == 0) goto L_0x2937
            com.meizu.media.camera.util.AsyncTaskEx$Status r2 = r1.mo22613c()
            com.meizu.media.camera.util.AsyncTaskEx$Status r3 = com.meizu.media.camera.util.AsyncTaskEx.Status.FINISHED
            if (r2 == r3) goto L_0x2935
            r1.mo22612b((boolean) r13)
        L_0x2935:
            kotlin.t r1 = kotlin.Unit.f18749a
        L_0x2937:
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r1 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_SWITCH_CAMERA
            if (r0 != r1) goto L_0x2ddb
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "RESULT_CANCEL mSwitchingModeNum:"
            r1.append(r2)
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2950
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x2950:
            int r2 = r2.mo18081bO()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2967
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2967:
            int r0 = r0.mo18081bO()
            if (r0 <= 0) goto L_0x297f
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2976
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2976:
            int r1 = r0.mo18081bO()
            r2 = -1
            int r1 = r1 + r2
            r0.mo18249n((int) r1)
        L_0x297f:
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "RESULT_CANCEL -1 mSwitchingModeNum:"
            r1.append(r2)
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2994
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x2994:
            int r2 = r2.mo18081bO()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            goto L_0x2ddb
        L_0x29a4:
            com.meizu.media.camera.util.ac$a r1 = r8.f9939c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to open camera:"
            r2.append(r3)
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x29b9
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x29b9:
            int r3 = r3.mo18031aP()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r1 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_SWITCH_CAMERA
            if (r0 != r1) goto L_0x2ddb
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "RESULT_NULL_CAMERA mSwitchingModeNum:"
            r1.append(r2)
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x29e0
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x29e0:
            int r2 = r2.mo18081bO()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x29f7
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x29f7:
            int r0 = r0.mo18081bO()
            if (r0 <= 0) goto L_0x2a0f
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2a06
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2a06:
            int r1 = r0.mo18081bO()
            r2 = -1
            int r1 = r1 + r2
            r0.mo18249n((int) r1)
        L_0x2a0f:
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "RESULT_NULL_CAMERA -1 mSwitchingModeNum:"
            r1.append(r2)
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2a24
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x2a24:
            int r2 = r2.mo18081bO()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r1)
            goto L_0x2ddb
        L_0x2a34:
            com.meizu.media.camera.util.ac$a r1 = r8.f9939c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "RESULT_START_PREVIEW_DONE mModuleState:"
            r2.append(r3)
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x2a49
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x2a49:
            com.meizu.media.camera.MzCamController$ModuleState r3 = r3.mo18115bw()
            r2.append(r3)
            java.lang.String r3 = ""
            r2.append(r3)
            java.lang.String r3 = ",mSwitchingModeNum:"
            r2.append(r3)
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x2a63
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x2a63:
            int r3 = r3.mo18081bO()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2a7a
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2a7a:
            com.meizu.media.camera.MzCamController$ModuleState r1 = r1.mo18115bw()
            if (r1 != 0) goto L_0x2a81
            goto L_0x2ab5
        L_0x2a81:
            int[] r2 = com.meizu.media.camera.p069f.C2049e.f9952a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            switch(r1) {
                case 1: goto L_0x2a8d;
                case 2: goto L_0x2a8d;
                default: goto L_0x2a8c;
            }
        L_0x2a8c:
            goto L_0x2ab5
        L_0x2a8d:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2a96
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2a96:
            int r1 = r1.mo18081bO()
            if (r1 > 0) goto L_0x2aef
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2aa5
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2aa5:
            r1.mo17964D(r13)
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2ab1
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2ab1:
            r1.mo17970J(r13)
            goto L_0x2aef
        L_0x2ab5:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2abe
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2abe:
            boolean r1 = r1.mo18072bF()
            if (r1 == 0) goto L_0x2add
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r1 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_RESUME_CAMERA
            if (r1 != r0) goto L_0x2aef
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2ad1
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2ad1:
            android.os.Handler r1 = r1.mo18110br()
            r2 = 17
            r3 = 150(0x96, double:7.4E-322)
            r1.sendEmptyMessageDelayed(r2, r3)
            goto L_0x2aef
        L_0x2add:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2ae6
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2ae6:
            android.os.Handler r1 = r1.mo18110br()
            r2 = 17
            r1.sendEmptyMessage(r2)
        L_0x2aef:
            int[] r1 = com.meizu.media.camera.p069f.C2049e.f9953b
            int r0 = r52.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L_0x2b10;
                case 2: goto L_0x2afc;
                default: goto L_0x2afa;
            }
        L_0x2afa:
            goto L_0x2ddb
        L_0x2afc:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2b05
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2b05:
            android.os.Handler r0 = r0.mo18110br()
            r1 = 26
            r0.sendEmptyMessage(r1)
            goto L_0x2ddb
        L_0x2b10:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2b19
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2b19:
            boolean r0 = r0.mo18072bF()
            if (r0 == 0) goto L_0x2b35
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2b28
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2b28:
            android.os.Handler r0 = r0.mo18110br()
            r1 = 15
            r2 = 200(0xc8, double:9.9E-322)
            r0.sendEmptyMessageDelayed(r1, r2)
            goto L_0x2ddb
        L_0x2b35:
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2b3e
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2b3e:
            android.os.Handler r0 = r0.mo18110br()
            r1 = 15
            r0.sendEmptyMessage(r1)
            goto L_0x2ddb
        L_0x2b49:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2b52
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2b52:
            r2 = 0
            r1.mo18269u((boolean) r2)
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2b5f
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2b5f:
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2b68
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x2b68:
            int r2 = r2.mo18211di()
            if (r2 != r13) goto L_0x2b70
            r2 = 1
            goto L_0x2b71
        L_0x2b70:
            r2 = 0
        L_0x2b71:
            r1.mo18279z(r2)
            com.meizu.media.camera.util.ac$a r1 = r8.f9939c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "RESULT_CAMERA_OPENED mSwitchingModeNum:"
            r2.append(r3)
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x2b89
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x2b89:
            int r3 = r3.mo18081bO()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2ba0
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2ba0:
            int r1 = r1.mo18081bO()
            if (r1 <= 0) goto L_0x2bbc
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r1 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.REQUEST_CODE_SWITCH_CAMERA
            if (r0 != r1) goto L_0x2bbc
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2bb3
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2bb3:
            int r2 = r1.mo18081bO()
            r3 = -1
            int r2 = r2 + r3
            r1.mo18249n((int) r2)
        L_0x2bbc:
            com.meizu.media.camera.util.ac$a r1 = r8.f9939c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "RESULT_CAMERA_OPENED -1 mSwitchingModeNum:"
            r2.append(r3)
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x2bd1
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x2bd1:
            int r3 = r3.mo18081bO()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r2 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r2)
            com.meizu.media.camera.camcontroller.d r1 = r1.mo19522k()
            if (r1 != 0) goto L_0x2bef
            return
        L_0x2bef:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2bf8
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2bf8:
            int r1 = r1.mo18081bO()
            if (r1 <= 0) goto L_0x2c03
            r1 = 0
            com.meizu.media.camera.CameraOptTask.m8370a((boolean) r1, (boolean) r13)
            return
        L_0x2c03:
            com.meizu.media.camera.util.ac$a r1 = r8.f9939c
            kotlin.jvm.b.q r2 = kotlin.jvm.p108b.PrimitiveCompanionObjects.f18738a
            java.lang.String r2 = "CameraDeviceClient %d: Opened"
            java.lang.Object[] r3 = new java.lang.Object[r13]
            com.meizu.media.camera.MzCamModule r4 = r8.f9938b
            if (r4 != 0) goto L_0x2c14
            java.lang.String r5 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r5)
        L_0x2c14:
            int r4 = r4.mo18031aP()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            int r4 = r3.length
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r4)
            java.lang.String r2 = java.lang.String.format(r2, r3)
            java.lang.String r3 = "java.lang.String.format(format, *args)"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            com.meizu.media.camera.util.ac$a r1 = r8.f9939c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Camera opened cameraId:"
            r2.append(r3)
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x2c45
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x2c45:
            int r3 = r3.mo18031aP()
            r2.append(r3)
            java.lang.String r3 = ",mActivity:"
            r2.append(r3)
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x2c5a
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x2c5a:
            com.meizu.media.camera.CameraActivity r3 = r3.mo18030aO()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.util.LogUtil.f14072b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Camera opened cameraId:"
            r2.append(r3)
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x2c7d
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x2c7d:
            int r3 = r3.mo18031aP()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            com.meizu.media.camera.util.ac$a r1 = com.meizu.media.camera.util.LogUtil.f14072b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Camera opened, is from other app? "
            r2.append(r3)
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x2ca0
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x2ca0:
            boolean r3 = r3.mo18041aZ()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r1, r2)
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2cb7
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2cb7:
            int r1 = r1.mo18081bO()
            if (r1 == 0) goto L_0x2ce1
            com.meizu.media.camera.util.ac$a r0 = r8.f9939c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Return! Camera opened but switch mode coming: "
            r1.append(r2)
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2cd2
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x2cd2:
            int r2 = r2.mo18081bO()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15956e(r0, r1)
            return
        L_0x2ce1:
            boolean r1 = com.meizu.media.camera.util.ApiHelper.f14210k
            if (r1 != 0) goto L_0x2d6b
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13838R
            if (r1 == 0) goto L_0x2d6b
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2cf6
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x2cf6:
            com.meizu.media.camera.f.n r2 = r2.mo18102bj()
            com.meizu.camera.MeizuCamera$MeizuSecureDetectionCallback r2 = (com.meizu.camera.MeizuCamera.MeizuSecureDetectionCallback) r2
            r1.mo19462a((com.meizu.camera.MeizuCamera.MeizuSecureDetectionCallback) r2)
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13854aG
            if (r1 == 0) goto L_0x2d19
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2d10
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x2d10:
            com.meizu.media.camera.f.m r2 = r2.mo18103bk()
            com.meizu.camera.MeizuCamera$MeizuSceneModeDetectionCallback r2 = (com.meizu.camera.MeizuCamera.MeizuSceneModeDetectionCallback) r2
            r1.mo19461a((com.meizu.camera.MeizuCamera.MeizuSceneModeDetectionCallback) r2)
        L_0x2d19:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13856aI
            if (r1 == 0) goto L_0x2d37
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13857aJ
            if (r1 == 0) goto L_0x2d37
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2d2e
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x2d2e:
            com.meizu.media.camera.f.l r2 = r2.mo18104bl()
            com.meizu.camera.MeizuCamera$MeizuModuleCoveredDetectionCallback r2 = (com.meizu.camera.MeizuCamera.MeizuModuleCoveredDetectionCallback) r2
            r1.mo19460a((com.meizu.camera.MeizuCamera.MeizuModuleCoveredDetectionCallback) r2)
        L_0x2d37:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13850aC
            if (r1 == 0) goto L_0x2d51
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2d48
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x2d48:
            com.meizu.media.camera.f.k r2 = r2.mo18105bm()
            com.meizu.camera.MeizuCamera$MeizuMetaDataCallback r2 = (com.meizu.camera.MeizuCamera.MeizuMetaDataCallback) r2
            r1.mo19459a((com.meizu.camera.MeizuCamera.MeizuMetaDataCallback) r2)
        L_0x2d51:
            boolean r1 = com.meizu.media.camera.util.DeviceHelper.f13875ab
            if (r1 == 0) goto L_0x2d6b
            com.meizu.media.camera.camcontroller.CameraController r1 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            com.meizu.media.camera.MzCamModule r2 = r8.f9938b
            if (r2 != 0) goto L_0x2d62
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x2d62:
            com.meizu.media.camera.f.i r2 = r2.mo18106bn()
            com.meizu.media.camera.camcontroller.CameraController$c r2 = (com.meizu.media.camera.camcontroller.CameraController.C1876c) r2
            r1.mo19469a((com.meizu.media.camera.camcontroller.CameraController.C1876c) r2)
        L_0x2d6b:
            com.meizu.media.camera.MzCamModule r1 = r8.f9938b
            if (r1 != 0) goto L_0x2d74
            java.lang.String r2 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r2)
        L_0x2d74:
            com.meizu.media.camera.f.h r2 = new com.meizu.media.camera.f.h
            com.meizu.media.camera.MzCamModule r3 = r8.f9938b
            if (r3 != 0) goto L_0x2d7f
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x2d7f:
            r2.<init>(r3, r0)
            r1.mo18010a((com.meizu.media.camera.p069f.CamOpenedTask) r2)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2d8e
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2d8e:
            com.meizu.media.camera.f.h r0 = r0.mo18085bS()
            if (r0 != 0) goto L_0x2d97
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x2d97:
            java.util.concurrent.Executor r1 = com.meizu.media.camera.util.AsyncTaskEx.f13741o
            r2 = 0
            java.lang.Void[] r2 = new java.lang.Void[r2]
            r0.mo22610a((java.util.concurrent.Executor) r1, (Params[]) r2)
            goto L_0x2ddb
        L_0x2da0:
            r2 = 0
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2daa
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2daa:
            r0.mo17961A(r2)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2db6
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2db6:
            r0.mo17964D(r2)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2dc2
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2dc2:
            r1 = -1
            r0.mo18262s((int) r1)
            com.meizu.media.camera.MzCamModule r0 = r8.f9938b
            if (r0 != 0) goto L_0x2dcf
            java.lang.String r1 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r1)
        L_0x2dcf:
            com.meizu.media.camera.mode.f r0 = r0.mo18029aN()
            if (r0 != 0) goto L_0x2dd8
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x2dd8:
            r0.mo20383H()
        L_0x2ddb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p069f.CamModuleIntentTaskListenerImpl.mo18014a(com.meizu.media.camera.util.Contants$CameraService$RequestCode, com.meizu.media.camera.util.Contants$CameraService$ResultCode, java.lang.Object[]):void");
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J'\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, mo27294d2 = {"com/meizu/media/camera/impl/CamModuleIntentTaskListenerImpl$onActionDone$4", "Lcom/meizu/media/camera/util/AsyncTaskEx;", "Ljava/lang/Void;", "doInBackground", "voids", "", "([Ljava/lang/Void;)Ljava/lang/Void;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.d$c */
    /* compiled from: CamModuleIntentTaskListenerImpl.kt */
    public static final class C2045c extends AsyncTaskEx<Void, Void, Void> {

        /* renamed from: a */
        public static ChangeQuickRedirect f9944a;

        /* renamed from: b */
        final /* synthetic */ CamModuleIntentTaskListenerImpl f9945b;

        C2045c(CamModuleIntentTaskListenerImpl dVar) {
            this.f9945b = dVar;
        }

        @Nullable
        /* renamed from: a */
        public Void mo17658a(@NotNull Void... voidArr) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f9944a, false, 4218, new Class[]{Void[].class}, Void.class);
            if (proxy.isSupported) {
                return (Void) proxy.result;
            }
            C3443i.m21155b(voidArr, "voids");
            this.f9945b.mo20016a().mo18170cv();
            this.f9945b.mo20016a().mo17984X(this.f9945b.mo20016a().mo17898aA());
            CameraOptTask.m8370a(false, true);
            return null;
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.d$d */
    /* compiled from: CamModuleIntentTaskListenerImpl.kt */
    static final class C2046d implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f9946a;

        /* renamed from: b */
        final /* synthetic */ CamModuleIntentTaskListenerImpl f9947b;

        C2046d(CamModuleIntentTaskListenerImpl dVar) {
            this.f9947b = dVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f9946a, false, 4219, new Class[0], Void.TYPE).isSupported) {
                this.f9947b.mo20016a().mo18171cw();
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.d$e */
    /* compiled from: CamModuleIntentTaskListenerImpl.kt */
    static final class C2047e implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f9948a;

        /* renamed from: b */
        final /* synthetic */ CamModuleIntentTaskListenerImpl f9949b;

        C2047e(CamModuleIntentTaskListenerImpl dVar) {
            this.f9949b = dVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f9948a, false, 4220, new Class[0], Void.TYPE).isSupported && !this.f9949b.mo20016a().mo18118bz()) {
                MzCamUI u = this.f9949b.mo20016a().mo18267u();
                if (u == null) {
                    C3443i.m21151a();
                }
                u.mo22162g(true);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.d$f */
    /* compiled from: CamModuleIntentTaskListenerImpl.kt */
    static final class C2048f implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f9950a;

        /* renamed from: b */
        final /* synthetic */ CamModuleIntentTaskListenerImpl f9951b;

        C2048f(CamModuleIntentTaskListenerImpl dVar) {
            this.f9951b = dVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f9950a, false, 4221, new Class[0], Void.TYPE).isSupported && !this.f9951b.mo20016a().mo18084bR()) {
                this.f9951b.mo20016a().mo17881a(DeviceHelper.f13910bJ == CameraController.CameraApi.API1 ? 80 : (long) 150);
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.d$a */
    /* compiled from: CamModuleIntentTaskListenerImpl.kt */
    static final class C2043a implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f9940a;

        /* renamed from: b */
        final /* synthetic */ CamModuleIntentTaskListenerImpl f9941b;

        C2043a(CamModuleIntentTaskListenerImpl dVar) {
            this.f9941b = dVar;
        }

        public final void run() {
            MzCamUI u;
            if (!PatchProxy.proxy(new Object[0], this, f9940a, false, 4216, new Class[0], Void.TYPE).isSupported) {
                MzUIController aU = this.f9941b.mo20016a().mo18036aU();
                if (aU == null) {
                    C3443i.m21151a();
                }
                aU.mo21611l(false);
                if (this.f9941b.mo20016a().mo17872U() && !this.f9941b.mo20016a().mo18070bD() && (u = this.f9941b.mo20016a().mo18267u()) != null) {
                    u.mo22142b(false);
                }
            }
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "", "run"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.f.d$b */
    /* compiled from: CamModuleIntentTaskListenerImpl.kt */
    static final class C2044b implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f9942a;

        /* renamed from: b */
        final /* synthetic */ CamModuleIntentTaskListenerImpl f9943b;

        C2044b(CamModuleIntentTaskListenerImpl dVar) {
            this.f9943b = dVar;
        }

        public final void run() {
            if (!PatchProxy.proxy(new Object[0], this, f9942a, false, 4217, new Class[0], Void.TYPE).isSupported) {
                MzUIController aU = this.f9943b.mo20016a().mo18036aU();
                if (aU == null) {
                    C3443i.m21151a();
                }
                aU.mo21611l(false);
                if (this.f9943b.mo20016a().mo18267u() != null && this.f9943b.mo20016a().mo17872U() && !this.f9943b.mo20016a().mo18070bD()) {
                    MzCamUI u = this.f9943b.mo20016a().mo18267u();
                    if (u == null) {
                        C3443i.m21151a();
                    }
                    u.mo22142b(false);
                }
            }
        }
    }

    @NotNull
    /* renamed from: a */
    public Point[] mo18021a(@Nullable Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, this, f9937a, false, 4215, new Class[]{Bitmap.class}, Point[].class);
        if (proxy.isSupported) {
            return (Point[]) proxy.result;
        }
        MzCamModule mzCamModule = this.f9938b;
        if (mzCamModule == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraMode aN = mzCamModule.mo18029aN();
        if (aN == null) {
            C3443i.m21151a();
        }
        if (aN.mo20403g_() != CameraModeType.ModeType.DOCUMENT) {
            return new Point[0];
        }
        MzCamModule mzCamModule2 = this.f9938b;
        if (mzCamModule2 == null) {
            C3443i.m21156b("mCamModule");
        }
        CameraMode aN2 = mzCamModule2.mo18029aN();
        if (aN2 == null) {
            C3443i.m21151a();
        }
        Point[] a = aN2.mo18021a(bitmap);
        C3443i.m21152a((Object) a, "mCamModule.mCameraMode!!.scanDocument(bitmap)");
        return a;
    }
}
