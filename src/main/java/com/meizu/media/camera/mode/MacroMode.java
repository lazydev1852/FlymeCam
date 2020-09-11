package com.meizu.media.camera.mode;

import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.MzCamParamsManager;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u000eH\u0016J\b\u0010$\u001a\u00020\u000eH\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\b\u0010&\u001a\u00020\u0010H\u0016J\b\u0010'\u001a\u00020\u0010H\u0016J\b\u0010(\u001a\u00020\u000eH\u0002¨\u0006)"}, mo27294d2 = {"Lcom/meizu/media/camera/mode/MacroMode;", "Lcom/meizu/media/camera/mode/CameraMode;", "activity", "Lcom/meizu/media/camera/CameraActivity;", "paramsManager", "Lcom/meizu/media/camera/MzCamParamsManager;", "uicontroller", "Lcom/meizu/media/camera/MzUIController;", "listener", "Lcom/meizu/media/camera/mode/CameraModeListener;", "type", "Lcom/meizu/media/camera/mode/CameraModeType$ModeType;", "(Lcom/meizu/media/camera/CameraActivity;Lcom/meizu/media/camera/MzCamParamsManager;Lcom/meizu/media/camera/MzUIController;Lcom/meizu/media/camera/mode/CameraModeListener;Lcom/meizu/media/camera/mode/CameraModeType$ModeType;)V", "afterCameraResume", "", "canBurst", "", "capture", "uuid", "Ljava/util/UUID;", "getFocusMode", "Lcom/meizu/media/camera/camcontroller/CameraController$FocusMode;", "getModeType", "getPictureSize", "", "isFlashTorchMode", "needZsd", "", "onBackPressed", "onModeMenuVisibilityChanged", "isVisible", "onModeChange", "onModeOutAnimStart", "onShutterButtonClick", "pause", "recordCaptureUsages", "release", "resume", "supportCountDown", "supportSquare", "updateUIController", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.mode.k */
public final class MacroMode extends CameraMode {

    /* renamed from: a */
    public static ChangeQuickRedirect f10860a;

    /* renamed from: A */
    public int mo20377A() {
        return 1;
    }

    /* renamed from: a */
    public boolean mo20394a(@NotNull UUID uuid) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uuid}, this, f10860a, false, 4861, new Class[]{UUID.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C3443i.m21155b(uuid, "uuid");
        return false;
    }

    /* renamed from: i_ */
    public void mo20405i_() {
    }

    /* renamed from: j_ */
    public void mo20406j_() {
    }

    /* renamed from: n */
    public boolean mo20411n() {
        return false;
    }

    /* renamed from: t */
    public boolean mo20417t() {
        return false;
    }

    /* renamed from: u */
    public boolean mo20418u() {
        return true;
    }

    /* renamed from: v */
    public boolean mo20419v() {
        return true;
    }

    /* renamed from: w */
    public boolean mo20420w() {
        return false;
    }

    /* renamed from: x */
    public boolean mo20421x() {
        return false;
    }

    @Nullable
    /* renamed from: y */
    public String mo20422y() {
        return null;
    }

    public MacroMode(@Nullable CameraActivity cameraActivity, @Nullable MzCamParamsManager lVar, @Nullable MzUIController uVar, @Nullable CameraModeListener hVar, @Nullable CameraModeType.ModeType modeType) {
        super(cameraActivity, lVar, uVar, hVar, modeType);
    }

    @NotNull
    /* renamed from: g_ */
    public CameraModeType.ModeType mo20403g_() {
        return CameraModeType.ModeType.MACRO;
    }

    /* renamed from: h_ */
    public void mo20404h_() {
        if (!PatchProxy.proxy(new Object[0], this, f10860a, false, 4860, new Class[0], Void.TYPE).isSupported) {
            mo20541T().mo20328a(CameraController.HdrMode.OFF);
        }
    }

    @NotNull
    /* renamed from: z */
    public CameraController.FocusMode mo20423z() {
        return CameraController.FocusMode.MACRO;
    }

    /* renamed from: l */
    public void mo20408l() {
        if (!PatchProxy.proxy(new Object[0], this, f10860a, false, 4862, new Class[0], Void.TYPE).isSupported) {
            m11566c();
        }
    }

    /* renamed from: c */
    private final void m11566c() {
        if (!PatchProxy.proxy(new Object[0], this, f10860a, false, 4863, new Class[0], Void.TYPE).isSupported) {
            mo20542U().mo21592g(MzUIController.f12300v);
            mo20542U().mo21506a(MzUIController.f12281c);
            CameraModeListener R = mo20539R();
            C3443i.m21152a((Object) R, "listener");
            if (R.mo17914ak() != null) {
                CameraModeListener R2 = mo20539R();
                C3443i.m21152a((Object) R2, "listener");
                R2.mo17914ak().mo20230j(true);
            }
        }
    }

    /* renamed from: a */
    public void mo20393a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f10860a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 4864, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported || z || this.f10788j == null) {
            return;
        }
        if (!CameraModeType.m10957c(this.f10789k) || (CameraModeType.m10957c(this.f10789k) && !z2)) {
            mo20542U().mo21506a(MzUIController.f12281c);
        }
    }

    /* renamed from: f_ */
    public void mo20402f_() {
        if (!PatchProxy.proxy(new Object[0], this, f10860a, false, 4865, new Class[0], Void.TYPE).isSupported) {
            m11566c();
            MzUIController U = mo20542U();
            CameraActivity cameraActivity = this.f10787i;
            C3443i.m21152a((Object) cameraActivity, "mActivity");
            U.mo21529a(cameraActivity.getResources().getString(R.string.mz_macro_focus_distance_hint), true, 5000);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x01b0, code lost:
        if (r2.mo18211di() == 1) goto L_0x01b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01c3, code lost:
        if (r2.mo18211di() == 1) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01c5, code lost:
        r3 = com.meizu.media.camera.util.UsageStatsHelper.m16051e();
        kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, "UsageStatsHelper.getDeviceMarkEnable()");
        r0.put("device_mark", r3);
     */
    /* renamed from: I */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo20384I() {
        /*
            r15 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            com.meizu.savior.ChangeQuickRedirect r3 = f10860a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 4866(0x1302, float:6.819E-42)
            r2 = r15
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0016
            return
        L_0x0016:
            java.lang.String r1 = "mode"
            java.lang.String r2 = "is_back_camera"
            java.lang.String r3 = "hdr"
            java.lang.String r4 = "count_down"
            java.lang.String r5 = "location"
            java.lang.String r6 = "filter_value"
            java.lang.String r7 = "voice"
            java.lang.String r8 = "meshline"
            java.lang.String r9 = "level"
            java.lang.String r10 = "time_mark"
            java.lang.String r11 = "capture_type"
            java.lang.String r12 = "night_scene"
            java.lang.String r13 = "watch_projection"
            java.lang.String r14 = "sd_card"
            java.lang.String[] r0 = new java.lang.String[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14}
            com.meizu.media.camera.CameraActivity r1 = r15.mo20540S()
            java.lang.String r2 = "activity"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r1, (java.lang.String) r2)
            android.content.Context r1 = r1.getApplicationContext()
            com.meizu.media.camera.util.at r1 = com.meizu.media.camera.util.UsageStatsHelper.m16042a((android.content.Context) r1)
            java.util.Map r0 = r1.mo22688a((java.lang.String[]) r0)
            java.lang.String r2 = "usageStatsHelper.getCust…StatsMap(customUsageItem)"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.String r2 = "capture_time"
            com.meizu.media.camera.mode.h r3 = r15.mo20539R()
            java.lang.String r4 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            long r3 = r3.mo18186dJ()
            java.lang.String r3 = java.lang.Long.toString(r3)
            java.lang.String r4 = "java.lang.Long.toString(listener.captureTime)"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            r0.put(r2, r3)
            java.lang.String r2 = "exposure"
            com.meizu.media.camera.mode.h r3 = r15.mo20539R()
            java.lang.String r4 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            com.meizu.media.camera.e r3 = r3.mo17902aE()
            java.lang.String r3 = com.meizu.media.camera.CameraSettings.m9787d((com.meizu.media.camera.ComboPreferences) r3)
            java.lang.String r4 = "CameraSettings.readFloat…ure(listener.preferences)"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            r0.put(r2, r3)
            java.lang.String r2 = "zoom"
            com.meizu.media.camera.mode.h r3 = r15.mo20539R()
            java.lang.String r4 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            com.meizu.media.camera.ui.i r3 = r3.mo18267u()
            int r3 = r3.mo22199w()
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r4 = "Integer.toString(listene…ui.getCurrentZoomValue())"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            r0.put(r2, r3)
            java.lang.String r2 = "flash"
            com.meizu.media.camera.camcontroller.CameraController r3 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r4 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            com.meizu.media.camera.camcontroller.CameraController$FlashMode r3 = r3.mo19534q()
            java.lang.String r3 = r3.key
            java.lang.String r4 = "CameraController.getInstance().flashMode.key"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            r0.put(r2, r3)
            com.meizu.media.camera.camcontroller.CameraController r2 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)
            android.graphics.Point r2 = r2.mo19520j()
            java.lang.String r3 = "picture_ratio"
            if (r2 != 0) goto L_0x00d2
            java.lang.String r2 = "error size"
            goto L_0x00f2
        L_0x00d2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r5 = r2.x
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r4.append(r5)
            java.lang.String r5 = "x"
            r4.append(r5)
            int r2 = r2.y
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r2 = com.meizu.media.camera.util.DeviceSizeTable.m16186a(r2)
        L_0x00f2:
            java.lang.String r4 = "if (size == null) \"error…oString() + \"x\" + size.y)"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r4)
            r0.put(r3, r2)
            java.lang.String r2 = "error mode"
            com.meizu.media.camera.mode.h r3 = r15.mo20539R()
            java.lang.String r4 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            com.meizu.media.camera.h r3 = r3.mo17914ak()
            if (r3 == 0) goto L_0x0129
            com.meizu.media.camera.mode.h r3 = r15.mo20539R()
            java.lang.String r4 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            com.meizu.media.camera.h r3 = r3.mo17914ak()
            if (r3 == 0) goto L_0x0129
            com.meizu.media.camera.camcontroller.CameraController$FocusMode r3 = r3.mo20225h()
            if (r3 == 0) goto L_0x0129
            java.lang.String r2 = r3.getKey()
            java.lang.String r3 = "focus.key"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)
        L_0x0129:
            java.lang.String r3 = "focus_mode"
            r0.put(r3, r2)
            boolean r2 = com.meizu.media.camera.util.DeviceHelper.f13877ad
            if (r2 == 0) goto L_0x017d
            com.meizu.media.camera.u r2 = r15.f10788j
            if (r2 == 0) goto L_0x017d
            com.meizu.media.camera.camcontroller.CameraController r2 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            java.lang.String r3 = "CameraController.getInstance()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)
            boolean r2 = r2.mo19484ab()
            if (r2 == 0) goto L_0x017d
            com.meizu.media.camera.u r2 = r15.f10788j
            java.lang.String r3 = "mUIController"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)
            boolean r2 = r2.mo21500W()
            if (r2 != 0) goto L_0x017d
            com.meizu.media.camera.u r2 = r15.f10788j
            java.lang.String r3 = "mUIController"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r3)
            com.meizu.media.camera.util.Contants$AsdSceneType r2 = r2.mo21504a()
            if (r2 == 0) goto L_0x017d
            java.lang.String r2 = "asd"
            com.meizu.media.camera.u r3 = r15.f10788j
            java.lang.String r4 = "mUIController"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            com.meizu.media.camera.util.Contants$AsdSceneType r3 = r3.mo21504a()
            java.lang.String r4 = "mUIController.asdSceneType"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r3 = r3.getTitle()
            java.lang.String r4 = "mUIController.asdSceneType.title"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            r0.put(r2, r3)
        L_0x017d:
            boolean r2 = com.meizu.media.camera.util.DeviceHelper.f13877ad
            r3 = 1
            if (r2 == 0) goto L_0x019f
            com.meizu.media.camera.mode.h r2 = r15.mo20539R()
            java.lang.String r4 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r4)
            int r2 = r2.mo18211di()
            if (r2 == r3) goto L_0x019f
            java.lang.String r2 = "asd_enable"
            java.lang.String r4 = com.meizu.media.camera.util.UsageStatsHelper.m16052f()
            java.lang.String r5 = "UsageStatsHelper.getAsdEnable()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r4, (java.lang.String) r5)
            r0.put(r2, r4)
        L_0x019f:
            boolean r2 = com.meizu.media.camera.util.DeviceHelper.f13879af
            if (r2 == 0) goto L_0x01b2
            com.meizu.media.camera.mode.h r2 = r15.mo20539R()
            java.lang.String r4 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r4)
            int r2 = r2.mo18211di()
            if (r2 != r3) goto L_0x01c5
        L_0x01b2:
            boolean r2 = com.meizu.media.camera.util.DeviceHelper.f13882ai
            if (r2 == 0) goto L_0x01d3
            com.meizu.media.camera.mode.h r2 = r15.mo20539R()
            java.lang.String r4 = "listener"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r2, (java.lang.String) r4)
            int r2 = r2.mo18211di()
            if (r2 != r3) goto L_0x01d3
        L_0x01c5:
            java.lang.String r2 = "device_mark"
            java.lang.String r3 = com.meizu.media.camera.util.UsageStatsHelper.m16051e()
            java.lang.String r4 = "UsageStatsHelper.getDeviceMarkEnable()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r3, (java.lang.String) r4)
            r0.put(r2, r3)
        L_0x01d3:
            java.lang.String r2 = "capture_info"
            r1.mo22693a((java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.String>) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.mode.MacroMode.mo20384I():void");
    }
}
