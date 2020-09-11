package com.meizu.media.camera;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.net.Uri;
import android.view.Surface;
import com.mediatek.accessor.StereoInfoAccessor;
import com.meizu.media.camera.CamIntentTask;
import com.meizu.media.camera.MediaSaveService;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.camcontroller.CameraProxy;
import com.meizu.media.camera.camcontroller.CameraProxyV1;
import com.meizu.media.camera.crop.C2027g;
import com.meizu.media.camera.mode.CameraModeListener;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p064a.ParamData;
import com.meizu.media.camera.simplify.MzSimplifyImageCaptureHandler;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.s */
public class MzStereoHandler implements CamIntentTask.C1777c {

    /* renamed from: a */
    public static ChangeQuickRedirect f11412a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f11413b = new LogUtil.C2630a("MzStereoHandler");

    /* renamed from: k */
    private static Class<?> f11414k;

    /* renamed from: l */
    private static Method f11415l;

    /* renamed from: m */
    private static Method f11416m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public static Method f11417n;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CameraModeListener f11418c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MzUIController f11419d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MzCamController f11420e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f11421f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f11422g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public CameraActivity f11423h;

    /* renamed from: i */
    private StereoInfoAccessor f11424i;

    /* renamed from: j */
    private UUID f11425j = UUID.randomUUID();

    /* renamed from: a */
    public Bitmap mo17987a(Bitmap bitmap, Point[] pointArr) {
        return null;
    }

    /* renamed from: a */
    public List<Surface> mo17988a(boolean z) {
        return null;
    }

    /* renamed from: a */
    public void mo18006a(ParamData fVar) {
    }

    /* renamed from: e */
    public List<Surface> mo18229e() {
        return null;
    }

    /* renamed from: g */
    public boolean mo18237g() {
        return false;
    }

    /* renamed from: h */
    public int mo18238h() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo18240i() {
        return false;
    }

    /* renamed from: j */
    public void mo18241j() {
    }

    /* renamed from: k */
    public void mo18243k() {
    }

    /* renamed from: com.meizu.media.camera.s$a */
    /* compiled from: MzStereoHandler */
    private class C2257a implements MediaSaveService.C1639d {

        /* renamed from: a */
        public static ChangeQuickRedirect f11431a;

        /* renamed from: c */
        private int f11433c;

        /* renamed from: a */
        public void mo17846a(String str, int i, int i2, byte[] bArr) {
        }

        public C2257a(int i) {
            this.f11433c = i;
        }

        /* renamed from: a */
        public void mo17844a(Uri uri) {
            if (!PatchProxy.proxy(new Object[]{uri}, this, f11431a, false, 2050, new Class[]{Uri.class}, Void.TYPE).isSupported && MzStereoHandler.this.f11423h != null) {
                MzStereoHandler.this.f11423h.mo17673b(uri);
                MzStereoHandler.this.f11419d.mo21518a(uri);
                boolean unused = MzStereoHandler.this.f11422g = true;
                if (DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL_AND_GALLERY && MzStereoHandler.this.f11420e != null && MzStereoHandler.this.f11420e.mo17898aA()) {
                    Intent intent = new Intent("com.android.camera.IMAGE_OBSERVER", uri);
                    intent.setPackage("com.meizu.media.imageservice");
                    intent.addFlags(32);
                    MzStereoHandler.this.f11423h.sendBroadcast(intent);
                    LogUtil.C2630a m = MzStereoHandler.f11413b;
                    LogUtil.m15952c(m, "Intent: " + intent);
                    LogUtil.C2630a m2 = MzStereoHandler.f11413b;
                    LogUtil.m15952c(m2, "Image Path: " + C2027g.m9757a(MzStereoHandler.this.f11423h, uri));
                    if (MzStereoHandler.this.f11420e != null && MzStereoHandler.this.f11418c != null && MzStereoHandler.this.f11421f) {
                        if (!MzStereoHandler.this.f11420e.mo17958x() && !CameraOptTask.m7849p()) {
                            MzStereoHandler.this.f11419d.mo21581d(4, true);
                        }
                        MzStereoHandler.this.f11418c.mo18122c(true);
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo17845a(String str) {
            if (!PatchProxy.proxy(new Object[]{str}, this, f11431a, false, 2051, new Class[]{String.class}, Void.TYPE).isSupported && MzStereoHandler.this.f11423h != null) {
                MzStereoHandler.this.f11423h.mo17670a(str, false);
            }
        }

        /* renamed from: a */
        public void mo17847a(List<String> list) {
            if (!PatchProxy.proxy(new Object[]{list}, this, f11431a, false, 2052, new Class[]{List.class}, Void.TYPE).isSupported && MzStereoHandler.this.f11423h != null) {
                MzStereoHandler.this.f11423h.mo17671a(list, false);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r33v1, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo18014a(com.meizu.media.camera.util.Contants.CameraService.RequestCode r35, com.meizu.media.camera.util.Contants.CameraService.ResultCode r36, java.lang.Object... r37) {
        /*
            r34 = this;
            r7 = r34
            r8 = r36
            r9 = r37
            r10 = 3
            java.lang.Object[] r0 = new java.lang.Object[r10]
            r11 = 0
            r0[r11] = r35
            r13 = 1
            r0[r13] = r8
            r14 = 2
            r0[r14] = r9
            com.meizu.savior.ChangeQuickRedirect r2 = f11412a
            java.lang.Class[] r5 = new java.lang.Class[r10]
            java.lang.Class<com.meizu.media.camera.util.Contants$CameraService$RequestCode> r1 = com.meizu.media.camera.util.Contants.CameraService.RequestCode.class
            r5[r11] = r1
            java.lang.Class<com.meizu.media.camera.util.Contants$CameraService$ResultCode> r1 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.class
            r5[r13] = r1
            java.lang.Class<java.lang.Object[]> r1 = java.lang.Object[].class
            r5[r14] = r1
            java.lang.Class r6 = java.lang.Void.TYPE
            r3 = 0
            r4 = 2040(0x7f8, float:2.859E-42)
            r1 = r34
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0032
            return
        L_0x0032:
            com.meizu.media.camera.util.ac$a r0 = f11413b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r35.name()
            r1.append(r2)
            java.lang.String r2 = " done, resultCode:"
            r1.append(r2)
            r1.append(r8)
            java.lang.String r2 = ",mActivity:"
            r1.append(r2)
            com.meizu.media.camera.CameraActivity r2 = r7.f11423h
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            int[] r0 = com.meizu.media.camera.MzStereoHandler.C22563.f11430a
            int r1 = r35.ordinal()
            r0 = r0[r1]
            if (r0 == r13) goto L_0x0065
            goto L_0x05ad
        L_0x0065:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_FINISHED
            boolean r0 = r0.equals(r8)
            r1 = 4
            if (r0 != 0) goto L_0x0562
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_CAPTURE_CANCEL
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x0078
            goto L_0x0562
        L_0x0078:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_SHUTTER_CALLBACK
            boolean r0 = r0.equals(r8)
            r3 = 0
            r5 = 180(0xb4, float:2.52E-43)
            r6 = 6
            r12 = 90
            r15 = 5
            if (r0 == 0) goto L_0x02ac
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r8 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_GALLERY
            if (r0 == r8) goto L_0x016b
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r8 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_NORMAL_CAPTURE
            if (r0 == r8) goto L_0x016b
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r8 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_NORMAL_CAPTURE_FORSAMSUNG
            if (r0 != r8) goto L_0x009c
            goto L_0x016b
        L_0x009c:
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r2 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL_AND_GALLERY
            if (r0 != r2) goto L_0x05ad
            r0 = r9[r11]
            if (r0 == 0) goto L_0x00ae
            r0 = r9[r15]
            java.lang.Long r0 = (java.lang.Long) r0
            long r3 = r0.longValue()
        L_0x00ae:
            r0 = r9[r13]
            if (r0 == 0) goto L_0x00bb
            r0 = r9[r10]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x00bc
        L_0x00bb:
            r0 = 0
        L_0x00bc:
            r2 = r9[r14]
            if (r2 == 0) goto L_0x00c9
            r2 = r9[r1]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            goto L_0x00ca
        L_0x00c9:
            r2 = 0
        L_0x00ca:
            r6 = r9[r10]
            if (r6 == 0) goto L_0x00d7
            r6 = r9[r13]
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            goto L_0x00d8
        L_0x00d7:
            r6 = 0
        L_0x00d8:
            r8 = r9[r1]
            if (r8 == 0) goto L_0x00e5
            r8 = r9[r14]
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            goto L_0x00e6
        L_0x00e5:
            r8 = 0
        L_0x00e6:
            com.meizu.media.camera.mode.h r9 = r7.f11418c
            int r9 = r9.mo18194dR()
            int r10 = r6 + r9
            int r10 = r10 % r5
            if (r10 == 0) goto L_0x00f6
            r22 = r0
            r21 = r2
            goto L_0x00fa
        L_0x00f6:
            r21 = r0
            r22 = r2
        L_0x00fa:
            r7.f11422g = r11
            r7.f11421f = r11
            com.meizu.media.camera.mode.h r0 = r7.f11418c
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r2 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r5 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r2 != r5) goto L_0x010c
            r2 = 1
            goto L_0x010d
        L_0x010c:
            r2 = 0
        L_0x010d:
            r0.mo22067a((int) r12, (int) r14, (boolean) r2)
            com.meizu.media.camera.mode.h r0 = r7.f11418c
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            android.graphics.Bitmap r0 = r0.mo22132au()
            if (r0 == 0) goto L_0x015f
            com.meizu.media.camera.CameraActivity r2 = r7.f11423h
            com.meizu.media.camera.MediaSaveService r15 = r2.mo17689p()
            java.lang.String r17 = com.meizu.media.camera.util.CameraUtil.m15831a((long) r3)
            com.meizu.media.camera.mode.h r2 = r7.f11418c
            com.meizu.media.camera.app.e r2 = r2.mo18192dP()
            android.location.Location r20 = r2.mo19017a((long) r3)
            r24 = 0
            com.meizu.media.camera.s$a r2 = new com.meizu.media.camera.s$a
            r25 = r2
            r2.<init>(r6)
            com.meizu.media.camera.CameraActivity r2 = r7.f11423h
            android.content.ContentResolver r26 = r2.getContentResolver()
            r28 = 1
            r29 = 0
            r30 = 0
            java.lang.Object[] r2 = new java.lang.Object[r11]
            r31 = r2
            r16 = r0
            r18 = r3
            r23 = r9
            r27 = r8
            r15.mo17828a(r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            com.meizu.media.camera.u r2 = r7.f11419d
            com.meizu.media.camera.CameraActivity r3 = r7.f11423h
            boolean r3 = r3.mo17677n()
            r2.mo21516a((android.graphics.Bitmap) r0, (int) r9, (boolean) r8, (boolean) r3)
        L_0x015f:
            com.meizu.media.camera.u r0 = r7.f11419d
            r0.mo21581d((int) r1, (boolean) r13)
            com.meizu.media.camera.u r0 = r7.f11419d
            r0.mo21614m((boolean) r11)
            goto L_0x05ad
        L_0x016b:
            if (r9 == 0) goto L_0x05ad
            int r0 = r9.length
            r8 = 9
            if (r0 >= r8) goto L_0x0174
            goto L_0x05ad
        L_0x0174:
            r0 = r9[r11]
            if (r0 == 0) goto L_0x017f
            r0 = r9[r11]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            r0.booleanValue()
        L_0x017f:
            r0 = r9[r13]
            if (r0 == 0) goto L_0x018b
            r0 = r9[r13]
            java.lang.Long r0 = (java.lang.Long) r0
            long r3 = r0.longValue()
        L_0x018b:
            r0 = r9[r14]
            if (r0 == 0) goto L_0x0198
            r0 = r9[r14]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x0199
        L_0x0198:
            r0 = 0
        L_0x0199:
            r8 = r9[r10]
            if (r8 == 0) goto L_0x01a6
            r8 = r9[r10]
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            goto L_0x01a7
        L_0x01a6:
            r8 = 0
        L_0x01a7:
            r16 = r9[r1]
            if (r16 == 0) goto L_0x01b6
            r16 = r9[r1]
            java.lang.Integer r16 = (java.lang.Integer) r16
            int r16 = r16.intValue()
            r2 = r16
            goto L_0x01b7
        L_0x01b6:
            r2 = 0
        L_0x01b7:
            r16 = r9[r15]
            if (r16 == 0) goto L_0x01c4
            r15 = r9[r15]
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            goto L_0x01c5
        L_0x01c4:
            r15 = 0
        L_0x01c5:
            r16 = r9[r6]
            if (r16 == 0) goto L_0x01d2
            r6 = r9[r6]
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            goto L_0x01d3
        L_0x01d2:
            r6 = 0
        L_0x01d3:
            r16 = 7
            r17 = r9[r16]
            if (r17 == 0) goto L_0x01e4
            r16 = r9[r16]
            java.lang.Boolean r16 = (java.lang.Boolean) r16
            boolean r16 = r16.booleanValue()
            r17 = r16
            goto L_0x01e6
        L_0x01e4:
            r17 = 0
        L_0x01e6:
            r16 = 8
            r18 = r9[r16]
            if (r18 == 0) goto L_0x01f3
            r9 = r9[r16]
            java.lang.String r9 = (java.lang.String) r9
            r33 = r9
            goto L_0x01f5
        L_0x01f3:
            r33 = 0
        L_0x01f5:
            com.meizu.media.camera.mode.h r9 = r7.f11418c
            int r9 = r9.mo18194dR()
            int r10 = r2 + r9
            int r10 = r10 % r5
            r11 = 270(0x10e, float:3.78E-43)
            if (r10 == 0) goto L_0x020b
            if (r9 == r12) goto L_0x020b
            if (r9 == r11) goto L_0x020b
            r23 = r0
            r22 = r8
            goto L_0x020f
        L_0x020b:
            r22 = r0
            r23 = r8
        L_0x020f:
            com.meizu.media.camera.mode.h r0 = r7.f11418c
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r8 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r10 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r8 != r10) goto L_0x021d
            r8 = 1
            goto L_0x021e
        L_0x021d:
            r8 = 0
        L_0x021e:
            r0.mo22067a((int) r12, (int) r14, (boolean) r8)
            com.meizu.media.camera.mode.h r0 = r7.f11418c
            com.meizu.media.camera.ui.i r0 = r0.mo18267u()
            android.graphics.Bitmap r0 = r0.mo22132au()
            if (r0 == 0) goto L_0x0293
            if (r9 == r11) goto L_0x0236
            if (r9 == r12) goto L_0x0236
            if (r9 != r5) goto L_0x0234
            goto L_0x0236
        L_0x0234:
            r5 = r0
            goto L_0x023a
        L_0x0236:
            android.graphics.Bitmap r5 = com.meizu.media.camera.util.BitmapUtils.m16141a(r0, r9)
        L_0x023a:
            com.meizu.media.camera.CameraActivity r8 = r7.f11423h
            com.meizu.media.camera.MediaSaveService r16 = r8.mo17689p()
            java.lang.String r18 = com.meizu.media.camera.util.CameraUtil.m15831a((long) r3)
            com.meizu.media.camera.mode.h r8 = r7.f11418c
            com.meizu.media.camera.app.e r8 = r8.mo18192dP()
            android.location.Location r21 = r8.mo19017a((long) r3)
            r24 = 0
            r25 = 0
            com.meizu.media.camera.s$a r8 = new com.meizu.media.camera.s$a
            r26 = r8
            r8.<init>(r2)
            com.meizu.media.camera.CameraActivity r2 = r7.f11423h
            android.content.ContentResolver r27 = r2.getContentResolver()
            r29 = 1
            r30 = 0
            r31 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r32 = r2
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r13)
            r10 = 0
            r2[r10] = r8
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r2[r13] = r6
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r17)
            r2[r14] = r6
            r6 = 3
            r2[r6] = r33
            r17 = r5
            r19 = r3
            r28 = r15
            r16.mo17828a(r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            com.meizu.media.camera.u r2 = r7.f11419d
            com.meizu.media.camera.CameraActivity r3 = r7.f11423h
            boolean r3 = r3.mo17677n()
            r2.mo21516a((android.graphics.Bitmap) r0, (int) r9, (boolean) r15, (boolean) r3)
        L_0x0293:
            com.meizu.media.camera.u r0 = r7.f11419d
            r0.mo21581d((int) r1, (boolean) r13)
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r0 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r1 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r0 != r1) goto L_0x02a4
            com.meizu.media.camera.mode.h r0 = r7.f11418c
            r1 = 3
            r0.mo18275x(r1)
        L_0x02a4:
            com.meizu.media.camera.u r0 = r7.f11419d
            r2 = 0
            r0.mo21614m((boolean) r2)
            goto L_0x05ad
        L_0x02ac:
            r2 = 0
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_IMAGE_CAPTURE_INTENT_DONE
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x02e2
            if (r9 == 0) goto L_0x05ad
            int r0 = r9.length
            r1 = 3
            if (r0 >= r1) goto L_0x02bd
            goto L_0x05ad
        L_0x02bd:
            r0 = r9[r2]
            if (r0 == 0) goto L_0x02c5
            r0 = r9[r2]
            byte[] r0 = (byte[]) r0
        L_0x02c5:
            r0 = r9[r13]
            if (r0 == 0) goto L_0x02d0
            r0 = r9[r13]
            java.lang.Long r0 = (java.lang.Long) r0
            r0.longValue()
        L_0x02d0:
            r0 = r9[r14]
            if (r0 == 0) goto L_0x02db
            r0 = r9[r14]
            java.lang.Integer r0 = (java.lang.Integer) r0
            r0.intValue()
        L_0x02db:
            com.meizu.media.camera.u r0 = r7.f11419d
            r0.mo21611l((boolean) r13)
            goto L_0x05ad
        L_0x02e2:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_CREATE_PICTURE_THUMBNAIL
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x0366
            if (r9 == 0) goto L_0x05ad
            int r0 = r9.length
            if (r0 >= r6) goto L_0x02f1
            goto L_0x05ad
        L_0x02f1:
            r0 = 0
            r2 = r9[r0]
            if (r2 == 0) goto L_0x02fd
            r2 = r9[r0]
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            r17 = r2
            goto L_0x02ff
        L_0x02fd:
            r17 = 0
        L_0x02ff:
            r0 = r9[r13]
            if (r0 == 0) goto L_0x030b
            r0 = r9[r13]
            r2 = r0
            byte[] r2 = (byte[]) r2
            r18 = r2
            goto L_0x030d
        L_0x030b:
            r18 = 0
        L_0x030d:
            r0 = r9[r14]
            if (r0 == 0) goto L_0x031d
            r0 = r9[r14]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r11 = r0.intValue()
            r21 = r11
            r0 = 3
            goto L_0x0320
        L_0x031d:
            r0 = 3
            r21 = 0
        L_0x0320:
            r2 = r9[r0]
            if (r2 == 0) goto L_0x032f
            r0 = r9[r0]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r11 = r0.booleanValue()
            r22 = r11
            goto L_0x0331
        L_0x032f:
            r22 = 0
        L_0x0331:
            r0 = r9[r1]
            if (r0 == 0) goto L_0x0340
            r0 = r9[r1]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r11 = r0.intValue()
            r23 = r11
            goto L_0x0342
        L_0x0340:
            r23 = 0
        L_0x0342:
            r0 = r9[r15]
            if (r0 == 0) goto L_0x0351
            r0 = r9[r15]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r11 = r0.intValue()
            r24 = r11
            goto L_0x0353
        L_0x0351:
            r24 = 0
        L_0x0353:
            com.meizu.media.camera.u r0 = r7.f11419d
            r19 = 0
            r20 = 0
            com.meizu.media.camera.CameraActivity r1 = r7.f11423h
            boolean r25 = r1.mo17677n()
            r16 = r0
            r16.mo21517a(r17, r18, r19, r20, r21, r22, r23, r24, r25)
            goto L_0x05ad
        L_0x0366:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_MEMORY_QUEUE_CHANGED
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x038a
            if (r9 == 0) goto L_0x05ad
            int r0 = r9.length
            if (r0 >= r13) goto L_0x0375
            goto L_0x05ad
        L_0x0375:
            r0 = 0
            r1 = r9[r0]
            if (r1 == 0) goto L_0x05ad
            r0 = r9[r0]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.meizu.media.camera.u r1 = r7.f11419d
            r0 = r0 ^ r13
            r1.mo21611l((boolean) r0)
            goto L_0x05ad
        L_0x038a:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_PICTURE_TOKEN_CALLBACK
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x03c8
            com.meizu.media.camera.MzCamController r0 = r7.f11420e
            boolean r0 = r0.mo17958x()
            if (r0 == 0) goto L_0x05ad
            if (r9 == 0) goto L_0x05ad
            int r0 = r9.length
            r1 = 3
            if (r0 >= r1) goto L_0x03a2
            goto L_0x05ad
        L_0x03a2:
            r0 = 0
            r1 = r9[r0]
            if (r1 == 0) goto L_0x03ab
            r0 = r9[r0]
            byte[] r0 = (byte[]) r0
        L_0x03ab:
            r0 = r9[r13]
            if (r0 == 0) goto L_0x03b6
            r0 = r9[r13]
            java.lang.Long r0 = (java.lang.Long) r0
            r0.longValue()
        L_0x03b6:
            r0 = r9[r14]
            if (r0 == 0) goto L_0x03c1
            r0 = r9[r14]
            java.lang.Integer r0 = (java.lang.Integer) r0
            r0.intValue()
        L_0x03c1:
            com.meizu.media.camera.u r0 = r7.f11419d
            r0.mo21611l((boolean) r13)
            goto L_0x05ad
        L_0x03c8:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_FILE_SAVED
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x03eb
            if (r9 == 0) goto L_0x05ad
            int r0 = r9.length
            if (r0 >= r13) goto L_0x03d7
            goto L_0x05ad
        L_0x03d7:
            r0 = 0
            r1 = r9[r0]
            if (r1 == 0) goto L_0x05ad
            r0 = r9[r0]
            java.lang.String r0 = (java.lang.String) r0
            com.meizu.media.camera.mode.h r1 = r7.f11418c
            com.meizu.media.camera.MediaSaveService$d r1 = r1.mo18193dQ()
            r1.mo17845a((java.lang.String) r0)
            goto L_0x05ad
        L_0x03eb:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_ON_MEDIA_SAVED
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x042a
            if (r9 == 0) goto L_0x05ad
            int r0 = r9.length
            if (r0 >= r13) goto L_0x03fa
            goto L_0x05ad
        L_0x03fa:
            r0 = 0
            r1 = r9[r0]
            if (r1 == 0) goto L_0x05ad
            r0 = r9[r0]
            android.net.Uri r0 = (android.net.Uri) r0
            int r1 = r9.length
            if (r1 <= r13) goto L_0x041f
            r1 = r9[r13]
            if (r1 == 0) goto L_0x041f
            r1 = r9[r13]
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x05ad
            com.meizu.media.camera.mode.h r1 = r7.f11418c
            com.meizu.media.camera.MediaSaveService$d r1 = r1.mo18193dQ()
            r1.mo17844a((android.net.Uri) r0)
            goto L_0x05ad
        L_0x041f:
            com.meizu.media.camera.mode.h r1 = r7.f11418c
            com.meizu.media.camera.MediaSaveService$d r1 = r1.mo18193dQ()
            r1.mo17844a((android.net.Uri) r0)
            goto L_0x05ad
        L_0x042a:
            com.meizu.media.camera.util.Contants$CameraService$ResultCode r0 = com.meizu.media.camera.util.Contants.CameraService.ResultCode.RESULT_PICTURE_POSTVIEW_CALLBACK
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x05ad
            com.meizu.media.camera.MzCamController r0 = r7.f11420e
            boolean r0 = r0.mo17958x()
            if (r0 != 0) goto L_0x052b
            if (r9 == 0) goto L_0x05ad
            int r0 = r9.length
            if (r0 >= r6) goto L_0x0441
            goto L_0x05ad
        L_0x0441:
            r0 = 0
            r2 = r9[r0]
            if (r2 == 0) goto L_0x044a
            r2 = r9[r0]
            byte[] r2 = (byte[]) r2
        L_0x044a:
            r0 = r9[r13]
            if (r0 == 0) goto L_0x0457
            r0 = r9[r13]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r11 = r0.intValue()
            goto L_0x0458
        L_0x0457:
            r11 = 0
        L_0x0458:
            r0 = r9[r14]
            if (r0 == 0) goto L_0x0465
            r0 = r9[r14]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto L_0x0466
        L_0x0465:
            r0 = 0
        L_0x0466:
            r2 = 3
            r6 = r9[r2]
            if (r6 == 0) goto L_0x0474
            r2 = r9[r2]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            goto L_0x0475
        L_0x0474:
            r2 = 0
        L_0x0475:
            r6 = r9[r1]
            if (r6 == 0) goto L_0x0482
            r6 = r9[r1]
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            goto L_0x0483
        L_0x0482:
            r6 = 0
        L_0x0483:
            r8 = r9[r15]
            if (r8 == 0) goto L_0x048f
            r3 = r9[r15]
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
        L_0x048f:
            com.meizu.media.camera.mode.h r8 = r7.f11418c
            int r8 = r8.mo18194dR()
            com.meizu.media.camera.mode.h r9 = r7.f11418c
            com.meizu.media.camera.ui.i r9 = r9.mo18267u()
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r10 = com.meizu.media.camera.util.DeviceHelper.f13910bJ
            com.meizu.media.camera.camcontroller.CameraController$CameraApi r15 = com.meizu.media.camera.camcontroller.CameraController.CameraApi.API2
            if (r10 != r15) goto L_0x04a3
            r10 = 1
            goto L_0x04a4
        L_0x04a3:
            r10 = 0
        L_0x04a4:
            r9.mo22067a((int) r12, (int) r14, (boolean) r10)
            int r9 = r11 + r8
            int r9 = r9 % r5
            if (r9 == 0) goto L_0x04b1
            r23 = r2
            r22 = r6
            goto L_0x04b5
        L_0x04b1:
            r22 = r2
            r23 = r6
        L_0x04b5:
            com.meizu.media.camera.mode.h r2 = r7.f11418c
            com.meizu.media.camera.ui.i r2 = r2.mo18267u()
            android.graphics.Bitmap r2 = r2.mo22132au()
            r31 = 0
            if (r2 == 0) goto L_0x052b
            com.meizu.media.camera.util.ac$a r5 = f11413b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r9 = "thumbnailBitmap width = "
            r6.append(r9)
            int r9 = r2.getWidth()
            r6.append(r9)
            java.lang.String r9 = ", height = "
            r6.append(r9)
            int r9 = r2.getHeight()
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r5, (java.lang.String) r6)
            com.meizu.media.camera.CameraActivity r5 = r7.f11423h
            com.meizu.media.camera.MediaSaveService r16 = r5.mo17689p()
            java.lang.String r18 = com.meizu.media.camera.util.CameraUtil.m15831a((long) r3)
            com.meizu.media.camera.mode.h r5 = r7.f11418c
            com.meizu.media.camera.app.e r5 = r5.mo18192dP()
            android.location.Location r21 = r5.mo19017a((long) r3)
            r25 = 0
            com.meizu.media.camera.s$a r5 = new com.meizu.media.camera.s$a
            r26 = r5
            r5.<init>(r11)
            com.meizu.media.camera.CameraActivity r5 = r7.f11423h
            android.content.ContentResolver r27 = r5.getContentResolver()
            r29 = 1
            r30 = 0
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r32 = r5
            r17 = r2
            r19 = r3
            r24 = r8
            r28 = r0
            r16.mo17828a(r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            com.meizu.media.camera.u r3 = r7.f11419d
            com.meizu.media.camera.CameraActivity r4 = r7.f11423h
            boolean r4 = r4.mo17677n()
            r3.mo21516a((android.graphics.Bitmap) r2, (int) r8, (boolean) r0, (boolean) r4)
        L_0x052b:
            com.meizu.media.camera.u r0 = r7.f11419d
            com.meizu.media.camera.u r2 = r7.f11419d
            boolean[] r3 = new boolean[r14]
            r3 = {0, 0} // fill-array
            boolean r2 = r2.mo21535a((boolean[]) r3)
            r0.mo21614m((boolean) r2)
            com.meizu.media.camera.MzCamController r0 = r7.f11420e
            boolean r0 = r0.mo17958x()
            if (r0 != 0) goto L_0x0548
            com.meizu.media.camera.u r0 = r7.f11419d
            r0.mo21581d((int) r1, (boolean) r13)
        L_0x0548:
            com.meizu.media.camera.MzCamController r0 = r7.f11420e
            boolean r0 = r0.mo17958x()
            if (r0 != 0) goto L_0x05ad
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7846m()
            if (r0 != 0) goto L_0x05ad
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7844k()
            if (r0 != 0) goto L_0x05ad
            com.meizu.media.camera.u r0 = r7.f11419d
            r0.mo21581d((int) r14, (boolean) r13)
            goto L_0x05ad
        L_0x0562:
            r7.f11421f = r13
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r2 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL_AND_GALLERY
            if (r0 != r2) goto L_0x056f
            boolean r0 = r7.f11422g
            if (r0 != 0) goto L_0x056f
            return
        L_0x056f:
            com.meizu.media.camera.MzCamController r0 = r7.f11420e
            boolean r0 = r0.mo17958x()
            if (r0 != 0) goto L_0x059e
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7849p()
            if (r0 != 0) goto L_0x059e
            com.meizu.media.camera.u r0 = r7.f11419d
            r0.mo21581d((int) r1, (boolean) r13)
            boolean r0 = com.meizu.media.camera.CameraOptTask.m7847n()
            if (r0 != 0) goto L_0x059e
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r1 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL
            if (r0 == r1) goto L_0x059e
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r0 = com.meizu.media.camera.util.DeviceHelper.f13858aK
            com.meizu.media.camera.util.DeviceHelper$STEREO_TYPE r1 = com.meizu.media.camera.util.DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL_AND_GALLERY
            if (r0 == r1) goto L_0x059e
            com.meizu.media.camera.u r0 = r7.f11419d
            r0.mo21581d((int) r14, (boolean) r13)
            com.meizu.media.camera.u r0 = r7.f11419d
            r0.mo21628r()
        L_0x059e:
            com.meizu.media.camera.mode.h r0 = r7.f11418c
            boolean[] r1 = new boolean[r13]
            r2 = 0
            r1[r2] = r13
            r0.mo18122c(r1)
            com.meizu.media.camera.u r0 = r7.f11419d
            r0.mo21540ae()
        L_0x05ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.MzStereoHandler.mo18014a(com.meizu.media.camera.util.Contants$CameraService$RequestCode, com.meizu.media.camera.util.Contants$CameraService$ResultCode, java.lang.Object[]):void");
    }

    /* renamed from: com.meizu.media.camera.s$3 */
    /* compiled from: MzStereoHandler */
    static /* synthetic */ class C22563 {

        /* renamed from: a */
        static final /* synthetic */ int[] f11430a = new int[Contants.CameraService.RequestCode.values().length];

        static {
            try {
                f11430a[Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_STEREO_PICTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: b */
    public UUID mo18056b() {
        return this.f11425j;
    }

    /* renamed from: c */
    public SurfaceTexture mo18119c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11412a, false, 2041, new Class[0], SurfaceTexture.class);
        return proxy.isSupported ? (SurfaceTexture) proxy.result : this.f11418c.mo18119c();
    }

    /* renamed from: d */
    public boolean mo18176d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11412a, false, 2042, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f11418c.mo18176d();
    }

    /* renamed from: f */
    public SurfaceTexture mo18236f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f11412a, false, 2043, new Class[0], SurfaceTexture.class);
        return proxy.isSupported ? (SurfaceTexture) proxy.result : this.f11418c.mo18236f();
    }

    public MzStereoHandler(CameraActivity cameraActivity, CameraModeListener hVar) {
        this.f11418c = hVar;
        this.f11423h = cameraActivity;
        CameraOptTask.m7840a((CamIntentTask.C1777c) this);
        if (DeviceHelper.f13839S && DeviceHelper.f13856aI && CameraModeType.m10946a().equals(CameraModeType.ModeType.PORTRAIT)) {
            m12406o();
        }
    }

    /* renamed from: a */
    public void mo20817a() {
        if (!PatchProxy.proxy(new Object[0], this, f11412a, false, 2044, new Class[0], Void.TYPE).isSupported) {
            this.f11418c.mo18195dS().mo20330b(false);
            CameraController.m8868g().mo19518i().post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f11426a;

                public void run() {
                    CameraProxy k;
                    if (!PatchProxy.proxy(new Object[0], this, f11426a, false, 2048, new Class[0], Void.TYPE).isSupported && CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1) && (k = CameraController.m8868g().mo19522k()) != null) {
                        Camera.Parameters f = ((CameraProxyV1) k).mo19740f();
                        try {
                            MzStereoHandler.f11417n.invoke(f, new Object[]{0});
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e2) {
                            e2.printStackTrace();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo20819a(MzUIController uVar) {
        this.f11419d = uVar;
    }

    /* renamed from: a */
    public void mo20818a(MzCamController mzCamController) {
        this.f11420e = mzCamController;
    }

    /* renamed from: o */
    private void m12406o() {
        if (!PatchProxy.proxy(new Object[0], this, f11412a, false, 2045, new Class[0], Void.TYPE).isSupported) {
            if (this.f11424i == null) {
                this.f11424i = new StereoInfoAccessor();
            }
            try {
                if (f11414k == null) {
                    f11414k = Class.forName("android.hardware.Camera$StereoCameraWarningCallback");
                }
                if (f11415l == null) {
                    f11415l = f11414k.getMethod("onWarning", new Class[]{Integer.TYPE});
                }
                try {
                    if (f11416m == null) {
                        f11416m = Camera.class.getMethod("setProperty", new Class[]{String.class, String.class});
                    }
                    if (CameraController.m8868g().mo19516h().equals(CameraController.CameraApi.API1)) {
                        CameraController.m8868g().mo19518i().post(new Runnable() {

                            /* renamed from: a */
                            public static ChangeQuickRedirect f11428a;

                            public void run() {
                                CameraProxy k;
                                if (!PatchProxy.proxy(new Object[0], this, f11428a, false, 2049, new Class[0], Void.TYPE).isSupported && (k = CameraController.m8868g().mo19522k()) != null) {
                                    Camera.Parameters f = ((CameraProxyV1) k).mo19740f();
                                    try {
                                        if (MzStereoHandler.f11417n == null && MzStereoHandler.this.f11418c != null) {
                                            Method unused = MzStereoHandler.f11417n = f.getClass().getMethod("setCameraMode", new Class[]{Integer.TYPE});
                                        }
                                    } catch (Exception e) {
                                        LogUtil.m15942a(MzStereoHandler.f11413b, "Reflect setCameraMode error");
                                        LogUtil.m15942a(MzStereoHandler.f11413b, e.getMessage());
                                    }
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    LogUtil.m15942a(f11413b, "Reflect setProperty error");
                    LogUtil.m15942a(f11413b, e.getMessage());
                }
            } catch (Exception e2) {
                LogUtil.m15942a(f11413b, "Reflect stereo error");
                LogUtil.m15942a(f11413b, e2.getMessage());
            }
        }
    }

    /* renamed from: a */
    public boolean mo20820a(long j) {
        long j2 = j;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Long(j2)}, this, f11412a, false, 2046, new Class[]{Long.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = f11413b;
        LogUtil.m15952c(aVar, "start stereo capture(rotation = " + this.f11418c.mo18194dR() + ")");
        m12406o();
        int c = CameraUtil.m15882c(this.f11418c.mo18211di(), this.f11418c.mo18194dR());
        MzCamParamsManager dS = this.f11418c.mo18195dS();
        if (DeviceHelper.f13858aK == DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_HAL_AND_GALLERY) {
            dS.mo20319a(Storage.m7750a().mo18644c(CameraUtil.m15831a(j)));
        }
        CameraController.m8868g().mo19490b(c, new boolean[0]);
        CameraController.m8868g().mo19455a(this.f11418c.mo18192dP().mo19017a(j2), new boolean[0]);
        dS.mo20350o();
        dS.mo20318a(j2);
        dS.mo20346k();
        CameraController.m8868g().mo19480a(new boolean[0]);
        Point j3 = CameraController.m8868g().mo19520j();
        int c2 = CameraUtil.m15882c(this.f11418c.mo18211di(), this.f11418c.mo18194dR());
        boolean a = MzSimplifyImageCaptureHandler.m13133a(this.f11423h.getIntent().getAction());
        if (CameraController.m8868g().mo19522k() == null || j3 == null) {
            LogUtil.m15956e(f11413b, "device has been released!");
            return true;
        }
        boolean z = CameraController.m8868g().mo19522k().mo19733b() == 1;
        boolean l = dS.mo20347l();
        boolean n = dS.mo20349n();
        if (DeviceHelper.f13858aK != DeviceHelper.STEREO_TYPE.TYPE_PROCESS_IN_GALLERY) {
            Storage.m7750a().mo18652e(true);
        }
        CameraOptTask.m8349a((Context) this.f11423h, CameraOptTask.m8337a(this.f11423h.getApplicationContext(), this.f11418c.mo18192dP().mo19017a(j2), j3.x, j3.y, c2, j, a, z, l, n, mo18056b(), Contants.CameraService.RequestCode.REQUEST_CODE_TAKE_STEREO_PICTURE));
        return true;
    }

    /* renamed from: l */
    public void mo20821l() {
        if (!PatchProxy.proxy(new Object[0], this, f11412a, false, 2047, new Class[0], Void.TYPE).isSupported) {
            CameraOptTask.m7842b((CamIntentTask.C1777c) this);
            this.f11423h = null;
            this.f11418c = null;
            this.f11419d = null;
            this.f11420e = null;
        }
    }

    /* renamed from: a */
    public Point[] mo18021a(Bitmap bitmap) {
        return new Point[0];
    }
}
