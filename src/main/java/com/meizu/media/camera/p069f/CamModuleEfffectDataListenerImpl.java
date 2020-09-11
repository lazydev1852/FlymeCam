package com.meizu.media.camera.p069f;

import android.graphics.Rect;
import android.hardware.camera2.TotalCaptureResult;
import android.location.Location;
import com.meizu.camera.effectlib.effects.filters.EffectRenderEngine;
import com.meizu.media.camera.MzCamModule;
import com.meizu.media.camera.PerfSdkManager;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import kotlin.Metadata;
import kotlin.jvm.p108b.C3443i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JÈ\u0001\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u00132\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001dH\u0016J\b\u0010,\u001a\u00020\fH\u0016J\u0001\u0010-\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u00132\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u001dH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006."}, mo27294d2 = {"Lcom/meizu/media/camera/impl/CamModuleEfffectDataListenerImpl;", "Lcom/meizu/camera/effectlib/effects/filters/EffectRenderEngine$EfffectDataListener;", "()V", "TAG", "Lcom/meizu/media/camera/util/LogUtil$Tag;", "mCamModule", "Lcom/meizu/media/camera/MzCamModule;", "getMCamModule", "()Lcom/meizu/media/camera/MzCamModule;", "setMCamModule", "(Lcom/meizu/media/camera/MzCamModule;)V", "onDataAvailable", "", "uuid", "Ljava/util/UUID;", "data", "", "buffer", "title", "", "date", "", "currentHeading", "", "loc", "Landroid/location/Location;", "width", "height", "mirror", "", "jpgRotation", "isSquareMode", "rowstrite", "croprect", "Landroid/graphics/Rect;", "result", "Landroid/hardware/camera2/TotalCaptureResult;", "captureMode", "isHDRActive", "isLensFacingFront", "sceneType", "needUpdate", "isFront", "isFrontFlashOn", "onEffectDoing", "onThirdDataAvailable", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.f.c */
public final class CamModuleEfffectDataListenerImpl implements EffectRenderEngine.C1161b {

    /* renamed from: a */
    public static ChangeQuickRedirect f9934a;
    @NotNull

    /* renamed from: b */
    public MzCamModule f9935b;

    /* renamed from: c */
    private final LogUtil.C2630a f9936c = new LogUtil.C2630a("EfffectDataLisImpl");

    /* renamed from: a */
    public void mo14082a(@Nullable byte[] bArr, @Nullable byte[] bArr2, long j, @Nullable Location location, int i, int i2, boolean z, int i3, boolean z2, int i4, @Nullable Rect rect, @Nullable TotalCaptureResult totalCaptureResult, @Nullable String str, boolean z3, boolean z4, int i5, boolean z5) {
    }

    /* renamed from: a */
    public final void mo20015a(@NotNull MzCamModule mzCamModule) {
        if (!PatchProxy.proxy(new Object[]{mzCamModule}, this, f9934a, false, 4196, new Class[]{MzCamModule.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(mzCamModule, "<set-?>");
            this.f9935b = mzCamModule;
        }
    }

    /* renamed from: a */
    public void mo14080a() {
        if (!PatchProxy.proxy(new Object[0], this, f9934a, false, 4197, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(this.f9936c, "onEffectDoing");
            Thread currentThread = Thread.currentThread();
            C3443i.m21152a((Object) currentThread, "Thread.currentThread()");
            int id = (int) currentThread.getId();
            LogUtil.C2630a aVar = this.f9936c;
            LogUtil.m15952c(aVar, "requestBoostAffinity currentThread:" + id);
            MzCamModule mzCamModule = this.f9935b;
            if (mzCamModule == null) {
                C3443i.m21156b("mCamModule");
            }
            if (mzCamModule.mo18162cn() != null) {
                MzCamModule mzCamModule2 = this.f9935b;
                if (mzCamModule2 == null) {
                    C3443i.m21156b("mCamModule");
                }
                PerfSdkManager cn = mzCamModule2.mo18162cn();
                if (cn == null) {
                    C3443i.m21151a();
                }
                cn.mo22765a("com.meizu.media.camera_cameraEffectStart", id);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x03fd  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0417  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0424  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0290  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo14081a(@org.jetbrains.annotations.Nullable java.util.UUID r48, @org.jetbrains.annotations.Nullable byte[] r49, @org.jetbrains.annotations.Nullable byte[] r50, @org.jetbrains.annotations.Nullable java.lang.String r51, long r52, int r54, @org.jetbrains.annotations.Nullable android.location.Location r55, int r56, int r57, boolean r58, int r59, boolean r60, int r61, @org.jetbrains.annotations.Nullable android.graphics.Rect r62, @org.jetbrains.annotations.Nullable android.hardware.camera2.TotalCaptureResult r63, @org.jetbrains.annotations.Nullable java.lang.String r64, boolean r65, boolean r66, int r67, boolean r68, boolean r69, boolean r70) {
        /*
            r47 = this;
            r7 = r47
            r8 = r49
            r9 = r50
            r11 = r51
            r10 = r56
            r12 = r57
            r13 = r58
            r14 = r59
            r15 = r61
            r6 = r64
            r5 = r65
            r4 = r66
            r3 = r67
            r2 = r68
            r1 = r70
            r0 = 22
            java.lang.Object[] r7 = new java.lang.Object[r0]
            r0 = 0
            r7[r0] = r48
            r0 = 1
            r7[r0] = r8
            r17 = 2
            r7[r17] = r9
            r18 = 3
            r7[r18] = r11
            java.lang.Long r0 = new java.lang.Long
            r8 = r52
            r0.<init>(r8)
            r8 = 4
            r7[r8] = r0
            java.lang.Integer r0 = new java.lang.Integer
            r9 = r54
            r0.<init>(r9)
            r19 = 5
            r7[r19] = r0
            r0 = 6
            r7[r0] = r55
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r10)
            r21 = 7
            r7[r21] = r0
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r12)
            r25 = 8
            r7[r25] = r0
            java.lang.Byte r0 = new java.lang.Byte
            r0.<init>(r13)
            r26 = 9
            r7[r26] = r0
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r14)
            r27 = 10
            r7[r27] = r0
            java.lang.Byte r0 = new java.lang.Byte
            r8 = r60
            r0.<init>(r8)
            r28 = 11
            r7[r28] = r0
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r15)
            r29 = 12
            r7[r29] = r0
            r0 = 13
            r7[r0] = r62
            r31 = 14
            r7[r31] = r63
            r31 = 15
            r7[r31] = r6
            java.lang.Byte r0 = new java.lang.Byte
            r0.<init>(r5)
            r31 = 16
            r7[r31] = r0
            java.lang.Byte r0 = new java.lang.Byte
            r0.<init>(r4)
            r31 = 17
            r7[r31] = r0
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r3)
            r31 = 18
            r7[r31] = r0
            java.lang.Byte r0 = new java.lang.Byte
            r0.<init>(r2)
            r31 = 19
            r7[r31] = r0
            java.lang.Byte r0 = new java.lang.Byte
            r4 = r69
            r0.<init>(r4)
            r31 = 20
            r7[r31] = r0
            java.lang.Byte r0 = new java.lang.Byte
            r0.<init>(r1)
            r31 = 21
            r7[r31] = r0
            com.meizu.savior.ChangeQuickRedirect r31 = f9934a
            r0 = 22
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class<java.util.UUID> r22 = java.util.UUID.class
            r23 = 0
            r0[r23] = r22
            java.lang.Class<byte[]> r22 = byte[].class
            r24 = 1
            r0[r24] = r22
            java.lang.Class<byte[]> r22 = byte[].class
            r0[r17] = r22
            java.lang.Class<java.lang.String> r17 = java.lang.String.class
            r0[r18] = r17
            java.lang.Class r17 = java.lang.Long.TYPE
            r18 = 4
            r0[r18] = r17
            java.lang.Class r17 = java.lang.Integer.TYPE
            r0[r19] = r17
            java.lang.Class<android.location.Location> r17 = android.location.Location.class
            r18 = 6
            r0[r18] = r17
            java.lang.Class r17 = java.lang.Integer.TYPE
            r0[r21] = r17
            java.lang.Class r17 = java.lang.Integer.TYPE
            r0[r25] = r17
            java.lang.Class r17 = java.lang.Boolean.TYPE
            r0[r26] = r17
            java.lang.Class r17 = java.lang.Integer.TYPE
            r0[r27] = r17
            java.lang.Class r17 = java.lang.Boolean.TYPE
            r0[r28] = r17
            java.lang.Class r17 = java.lang.Integer.TYPE
            r0[r29] = r17
            java.lang.Class<android.graphics.Rect> r17 = android.graphics.Rect.class
            r18 = 13
            r0[r18] = r17
            java.lang.Class<android.hardware.camera2.TotalCaptureResult> r17 = android.hardware.camera2.TotalCaptureResult.class
            r18 = 14
            r0[r18] = r17
            java.lang.Class<java.lang.String> r17 = java.lang.String.class
            r18 = 15
            r0[r18] = r17
            java.lang.Class r17 = java.lang.Boolean.TYPE
            r18 = 16
            r0[r18] = r17
            java.lang.Class r17 = java.lang.Boolean.TYPE
            r18 = 17
            r0[r18] = r17
            java.lang.Class r17 = java.lang.Integer.TYPE
            r18 = 18
            r0[r18] = r17
            java.lang.Class r17 = java.lang.Boolean.TYPE
            r18 = 19
            r0[r18] = r17
            java.lang.Class r17 = java.lang.Boolean.TYPE
            r18 = 20
            r0[r18] = r17
            java.lang.Class r17 = java.lang.Boolean.TYPE
            r18 = 21
            r0[r18] = r17
            java.lang.Class r17 = java.lang.Void.TYPE
            r18 = 0
            r19 = 4198(0x1066, float:5.883E-42)
            r21 = r0
            r0 = r7
            r7 = r1
            r1 = r47
            r22 = r2
            r2 = r31
            r8 = r3
            r3 = r18
            r4 = r19
            r5 = r21
            r9 = r6
            r6 = r17
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x015f
            return
        L_0x015f:
            r0 = r49
            if (r0 == 0) goto L_0x0192
            r1 = r47
            com.meizu.media.camera.util.ac$a r2 = r1.f9936c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "onDataAvailable title: "
            r3.append(r4)
            r3.append(r11)
            java.lang.String r4 = " size:"
            r3.append(r4)
            r3.append(r15)
            java.lang.String r4 = "x"
            r3.append(r4)
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)
            r2 = r50
            r3 = 4
            com.meizu.media.cameraAlgorithm.yuv.YuvUtil.convertYuvToNv21(r0, r2, r10, r12, r3)
            goto L_0x019d
        L_0x0192:
            r1 = r47
            r2 = r50
            com.meizu.media.camera.util.ac$a r0 = r1.f9936c
            java.lang.String r3 = "not effect Render"
            com.meizu.media.camera.util.LogUtil.m15952c(r0, r3)
        L_0x019d:
            byte[] r0 = com.meizu.media.cameraAlgorithm.yuv.YuvUtil.rotateNV21Data(r2, r10, r12, r14, r13)
            r2 = 90
            if (r14 == r2) goto L_0x01ad
            r2 = 270(0x10e, float:3.78E-43)
            if (r14 != r2) goto L_0x01aa
            goto L_0x01ad
        L_0x01aa:
            r2 = r10
            r3 = r12
            goto L_0x01af
        L_0x01ad:
            r3 = r10
            r2 = r12
        L_0x01af:
            com.meizu.media.camera.MzCamModule r4 = r1.f9935b
            if (r4 != 0) goto L_0x01b8
            java.lang.String r5 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r5)
        L_0x01b8:
            com.meizu.media.camera.l r4 = r4.mo18195dS()
            if (r4 == 0) goto L_0x03b8
            com.meizu.media.camera.MzCamModule r4 = r1.f9935b
            if (r4 != 0) goto L_0x01c7
            java.lang.String r5 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r5)
        L_0x01c7:
            com.meizu.media.camera.l r4 = r4.mo18195dS()
            if (r4 != 0) goto L_0x01d0
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01d0:
            boolean r4 = r4.mo20347l()
            if (r4 != 0) goto L_0x01f3
            com.meizu.media.camera.MzCamModule r4 = r1.f9935b
            if (r4 != 0) goto L_0x01df
            java.lang.String r5 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r5)
        L_0x01df:
            com.meizu.media.camera.l r4 = r4.mo18195dS()
            if (r4 != 0) goto L_0x01e8
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x01e8:
            boolean r4 = r4.mo20349n()
            if (r4 == 0) goto L_0x01ef
            goto L_0x01f3
        L_0x01ef:
            r4 = 1
            r6 = 0
            goto L_0x03ba
        L_0x01f3:
            r4 = 0
            java.nio.ByteBuffer r4 = (java.nio.ByteBuffer) r4
            if (r0 == 0) goto L_0x0221
            int r4 = r2 * r3
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.allocateDirect(r4)
            r5.clear()
            r6 = 0
            r5.position(r6)
            java.nio.ByteBuffer r10 = r5.put(r0, r6, r4)
            r10.position(r6)
            int r10 = r4 / 2
            java.nio.ByteBuffer r12 = java.nio.ByteBuffer.allocateDirect(r10)
            r12.clear()
            r12.position(r6)
            java.nio.ByteBuffer r4 = r12.put(r0, r4, r10)
            r4.position(r6)
            r4 = r5
            goto L_0x0223
        L_0x0221:
            r6 = 0
            r12 = r4
        L_0x0223:
            com.meizu.media.camera.MzCamModule r5 = r1.f9935b
            if (r5 != 0) goto L_0x022c
            java.lang.String r10 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r10)
        L_0x022c:
            com.meizu.media.camera.l r5 = r5.mo18195dS()
            if (r5 != 0) goto L_0x0235
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0235:
            boolean r5 = r5.mo20347l()
            if (r5 == 0) goto L_0x0300
            boolean r5 = com.meizu.media.camera.util.DeviceHelper.f13881ah
            if (r5 == 0) goto L_0x0271
            com.meizu.media.camera.MzCamModule r5 = r1.f9935b
            if (r5 != 0) goto L_0x0248
            java.lang.String r10 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r10)
        L_0x0248:
            com.meizu.media.camera.l r5 = r5.mo18195dS()
            if (r5 != 0) goto L_0x0251
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0251:
            java.lang.String r5 = r5.mo20348m()
            if (r5 == 0) goto L_0x0271
            com.meizu.media.camera.MzCamModule r5 = r1.f9935b
            if (r5 != 0) goto L_0x0260
            java.lang.String r10 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r10)
        L_0x0260:
            com.meizu.media.camera.l r5 = r5.mo18195dS()
            if (r5 != 0) goto L_0x0269
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0269:
            java.lang.String r5 = r5.mo20348m()
            com.meizu.media.photoalgorithm.WaterMark.setCustomSign(r5)
            goto L_0x0275
        L_0x0271:
            r5 = 0
            com.meizu.media.photoalgorithm.WaterMark.setCustomSign(r5)
        L_0x0275:
            com.meizu.media.camera.MzCamModule r5 = r1.f9935b
            if (r5 != 0) goto L_0x027e
            java.lang.String r10 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r10)
        L_0x027e:
            com.meizu.media.camera.CameraActivity r5 = r5.mo18030aO()
            android.content.Context r5 = (android.content.Context) r5
            java.lang.String r10 = com.meizu.media.camera.util.DeviceHelper.f14008dB
            boolean r13 = com.meizu.media.camera.util.DeviceUtil.m16196a()
            android.graphics.Bitmap r5 = com.meizu.media.photoalgorithm.WaterMark.getDevicemarkBitmap(r5, r10, r13)
            if (r5 == 0) goto L_0x0300
            com.meizu.media.camera.util.DeviceHelper$CUSTOM_DEVICE_MARK r10 = com.meizu.media.camera.util.DeviceHelper.f14036f
            com.meizu.media.camera.util.DeviceHelper$CUSTOM_DEVICE_MARK r13 = com.meizu.media.camera.util.DeviceHelper.CUSTOM_DEVICE_MARK.PROCESS_AFTER_DEVICE_NAME
            if (r10 != r13) goto L_0x0298
            r10 = 1
            goto L_0x0299
        L_0x0298:
            r10 = 0
        L_0x0299:
            com.meizu.media.photoalgorithm.WaterMark.updateScaleRatioUsedStatus(r10)
            float r10 = com.meizu.media.photoalgorithm.WaterMark.getDevicemarkScaledRaio(r2, r3, r5, r6)
            android.graphics.Matrix r13 = new android.graphics.Matrix
            r13.<init>()
            r13.postScale(r10, r10)
            r10 = 360(0x168, float:5.04E-43)
            float r10 = (float) r10
            float r14 = (float) r6
            float r10 = r10 - r14
            r13.postRotate(r10)
            r24 = 0
            r25 = 0
            int r26 = r5.getWidth()
            int r27 = r5.getHeight()
            r29 = 1
            r23 = r5
            r28 = r13
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r23, r24, r25, r26, r27, r28, r29)
            java.lang.String r13 = "resizedBitmap"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r10, (java.lang.String) r13)
            int r13 = r10.getWidth()
            int r14 = r10.getHeight()
            android.graphics.Rect r46 = com.meizu.media.photoalgorithm.WaterMark.getDevicemarkRect(r2, r3, r13, r14, r6)
            r45 = 0
            r36 = r4
            r37 = r12
            r38 = r12
            r39 = r2
            r40 = r2
            r41 = r2
            r42 = r2
            r43 = r3
            r44 = r10
            com.meizu.media.photoalgorithm.WaterMark.nativePhotoWaterMarkYUV(r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46)
            boolean r13 = r10.isRecycled()
            if (r13 != 0) goto L_0x02f7
            r10.recycle()
        L_0x02f7:
            boolean r10 = r5.isRecycled()
            if (r10 != 0) goto L_0x0300
            r5.recycle()
        L_0x0300:
            com.meizu.media.camera.MzCamModule r5 = r1.f9935b
            if (r5 != 0) goto L_0x0309
            java.lang.String r10 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r10)
        L_0x0309:
            com.meizu.media.camera.l r5 = r5.mo18195dS()
            if (r5 != 0) goto L_0x0312
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x0312:
            boolean r5 = r5.mo20349n()
            if (r5 == 0) goto L_0x039b
            java.text.SimpleDateFormat r5 = com.meizu.media.camera.util.DeviceHelper.f13979cZ
            java.lang.Long r10 = java.lang.Long.valueOf(r52)
            java.lang.String r5 = r5.format(r10)
            com.meizu.media.camera.MzCamModule r10 = r1.f9935b
            if (r10 != 0) goto L_0x032b
            java.lang.String r13 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r13)
        L_0x032b:
            com.meizu.media.camera.CameraActivity r10 = r10.mo18030aO()
            android.content.Context r10 = (android.content.Context) r10
            android.graphics.Bitmap r5 = com.meizu.media.photoalgorithm.WaterMark.getTimemarkBitmap(r10, r5)
            if (r5 == 0) goto L_0x039b
            float r10 = com.meizu.media.photoalgorithm.WaterMark.getTimemarkScaledRaio(r2, r3, r5, r6)
            android.graphics.Matrix r13 = new android.graphics.Matrix
            r13.<init>()
            r13.postScale(r10, r10)
            r10 = 360(0x168, float:5.04E-43)
            float r10 = (float) r10
            float r14 = (float) r6
            float r10 = r10 - r14
            r13.postRotate(r10)
            r24 = 0
            r25 = 0
            int r26 = r5.getWidth()
            int r27 = r5.getHeight()
            r29 = 1
            r23 = r5
            r28 = r13
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r23, r24, r25, r26, r27, r28, r29)
            java.lang.String r13 = "resizedBitmap"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r10, (java.lang.String) r13)
            int r13 = r10.getWidth()
            int r14 = r10.getHeight()
            android.graphics.Rect r46 = com.meizu.media.photoalgorithm.WaterMark.getTimemarkRect(r2, r3, r13, r14, r6)
            r45 = 0
            r36 = r4
            r37 = r12
            r38 = r12
            r39 = r2
            r40 = r2
            r41 = r2
            r42 = r2
            r43 = r3
            r44 = r10
            com.meizu.media.photoalgorithm.WaterMark.nativePhotoWaterMarkYUV(r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46)
            boolean r13 = r10.isRecycled()
            if (r13 != 0) goto L_0x0392
            r10.recycle()
        L_0x0392:
            boolean r10 = r5.isRecycled()
            if (r10 != 0) goto L_0x039b
            r5.recycle()
        L_0x039b:
            if (r4 == 0) goto L_0x03b9
            if (r12 == 0) goto L_0x03b9
            if (r0 == 0) goto L_0x03b9
            int r5 = r4.remaining()
            r4.get(r0, r6, r5)
            int r5 = r2 * r3
            int r10 = r12.remaining()
            r12.get(r0, r5, r10)
            r12.clear()
            r4.clear()
            goto L_0x03b9
        L_0x03b8:
            r6 = 0
        L_0x03b9:
            r4 = 1
        L_0x03ba:
            boolean[] r4 = new boolean[r4]
            r4[r6] = r7
            r5 = 0
            r25 = r0
            r26 = r2
            r27 = r3
            r28 = r2
            r29 = r62
            r30 = r5
            r31 = r55
            r32 = r52
            r34 = r63
            r35 = r4
            byte[] r10 = com.meizu.media.camera.util.FormatUtil.m16272a(r25, r26, r27, r28, r29, r30, r31, r32, r34, r35)
            com.meizu.media.camera.util.ac$a r0 = r1.f9936c
            java.lang.String r4 = "nv21ToJpeg end"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r4)
            com.meizu.media.camera.MzCamModule r0 = r1.f9935b
            if (r0 != 0) goto L_0x03e7
            java.lang.String r4 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r4)
        L_0x03e7:
            java.util.HashMap r0 = r0.mo18154cf()
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r0 = r0.get(r11)
            com.meizu.media.camera.util.Contants$CameraService$RequestCode r0 = (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r0
            if (r0 != 0) goto L_0x03fd
            com.meizu.media.camera.util.ac$a r4 = r1.f9936c
            java.lang.String r5 = "getRequesetCode fail"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r4, (java.lang.String) r5)
            goto L_0x0413
        L_0x03fd:
            com.meizu.media.camera.util.ac$a r4 = r1.f9936c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "getRequesetCode:"
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r4, (java.lang.String) r5)
        L_0x0413:
            com.meizu.media.camera.MzCamModule r4 = r1.f9935b
            if (r4 != 0) goto L_0x041c
            java.lang.String r5 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r5)
        L_0x041c:
            java.util.HashMap r4 = r4.mo18154cf()
            java.util.Map r4 = (java.util.Map) r4
            if (r4 == 0) goto L_0x04b0
            java.util.Map r4 = kotlin.jvm.p108b.TypeIntrinsics.m21184c(r4)
            r4.remove(r11)
            if (r22 == 0) goto L_0x0451
            com.meizu.media.camera.a.g r4 = new com.meizu.media.camera.a.g
            r5 = r65
            r6 = r66
            r4.<init>(r9, r5, r6, r8)
            r19 = 0
            r8 = r48
            r9 = r0
            r11 = r51
            r12 = r52
            r14 = r54
            r15 = r55
            r16 = r2
            r17 = r3
            r18 = r69
            r20 = r60
            r21 = r4
            com.meizu.media.camera.CameraOptTask.m8381b((java.util.UUID) r8, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r9, (byte[]) r10, (java.lang.String) r11, (long) r12, (int) r14, (android.location.Location) r15, (int) r16, (int) r17, (boolean) r18, (int) r19, (boolean) r20, (com.meizu.media.camera.p064a.XmpMetaData) r21)
            goto L_0x0474
        L_0x0451:
            r5 = r65
            r6 = r66
            com.meizu.media.camera.a.g r4 = new com.meizu.media.camera.a.g
            r4.<init>(r9, r5, r6, r8)
            r19 = 0
            r8 = r48
            r9 = r0
            r11 = r51
            r12 = r52
            r14 = r54
            r15 = r55
            r16 = r2
            r17 = r3
            r18 = r69
            r20 = r60
            r21 = r4
            com.meizu.media.camera.CameraOptTask.m8363a((java.util.UUID) r8, (com.meizu.media.camera.util.Contants.CameraService.RequestCode) r9, (byte[]) r10, (java.lang.String) r11, (long) r12, (int) r14, (android.location.Location) r15, (int) r16, (int) r17, (boolean) r18, (int) r19, (boolean) r20, (com.meizu.media.camera.p064a.XmpMetaData) r21)
        L_0x0474:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r2 = "Thread.currentThread()"
            kotlin.jvm.p108b.C3443i.m21152a((java.lang.Object) r0, (java.lang.String) r2)
            long r2 = r0.getId()
            int r0 = (int) r2
            com.meizu.media.camera.util.ac$a r2 = r1.f9936c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "cancelBoostAffinity currentThread:"
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.meizu.media.camera.util.LogUtil.m15952c(r2, r3)
            com.meizu.media.camera.MzCamModule r2 = r1.f9935b
            if (r2 != 0) goto L_0x04a1
            java.lang.String r3 = "mCamModule"
            kotlin.jvm.p108b.C3443i.m21156b(r3)
        L_0x04a1:
            com.meizu.media.camera.w r2 = r2.mo18162cn()
            if (r2 != 0) goto L_0x04aa
            kotlin.jvm.p108b.C3443i.m21151a()
        L_0x04aa:
            java.lang.String r3 = "com.meizu.media.camera_cameraEffectStart"
            r2.mo22767b(r3, r0)
            return
        L_0x04b0:
            kotlin.q r0 = new kotlin.q
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p069f.CamModuleEfffectDataListenerImpl.mo14081a(java.util.UUID, byte[], byte[], java.lang.String, long, int, android.location.Location, int, int, boolean, int, boolean, int, android.graphics.Rect, android.hardware.camera2.TotalCaptureResult, java.lang.String, boolean, boolean, int, boolean, boolean, boolean):void");
    }
}
