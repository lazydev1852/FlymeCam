package com.meizu.media.camera;

import com.mediatek.accessor.packer.PackUtils;
import com.meizu.media.camera.p067d.ExifInterface;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.IOException;

/* renamed from: com.meizu.media.camera.f */
public class Exif {

    /* renamed from: a */
    public static ChangeQuickRedirect f9926a;

    /* renamed from: b */
    private static final LogUtil.C2630a f9927b = new LogUtil.C2630a(PackUtils.EXIF_HEADER);

    /* renamed from: a */
    public static ExifInterface m10044a(byte[] bArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr}, (Object) null, f9926a, true, 990, new Class[]{byte[].class}, ExifInterface.class);
        if (proxy.isSupported) {
            return (ExifInterface) proxy.result;
        }
        ExifInterface cVar = new ExifInterface();
        try {
            cVar.mo19854a(bArr);
        } catch (IOException e) {
            LogUtil.m15955d(f9927b, "Failed to read EXIF data", e);
        }
        return cVar;
    }

    /* renamed from: a */
    public static int m10043a(ExifInterface cVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cVar}, (Object) null, f9926a, true, 991, new Class[]{ExifInterface.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        Integer g = cVar.mo19879g(ExifInterface.f9398k);
        if (g == null) {
            return 0;
        }
        return ExifInterface.m9825b(g.shortValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a6 A[Catch:{ g -> 0x01c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01ab A[Catch:{ g -> 0x01c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01ae A[Catch:{ g -> 0x01c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ea  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m10045a(byte[] r19, int r20, android.location.Location r21, long r22, android.hardware.camera2.TotalCaptureResult r24, boolean r25, boolean r26) {
        /*
            r1 = r19
            r0 = r20
            r3 = r22
            r5 = r24
            r6 = r25
            r7 = r26
            r8 = 7
            java.lang.Object[] r9 = new java.lang.Object[r8]
            r15 = 0
            r9[r15] = r1
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r0)
            r14 = 1
            r9[r14] = r10
            r16 = 2
            r9[r16] = r21
            java.lang.Long r10 = new java.lang.Long
            r10.<init>(r3)
            r13 = 3
            r9[r13] = r10
            r10 = 4
            r9[r10] = r5
            java.lang.Byte r11 = new java.lang.Byte
            r11.<init>(r6)
            r12 = 5
            r9[r12] = r11
            java.lang.Byte r11 = new java.lang.Byte
            r11.<init>(r7)
            r17 = 6
            r9[r17] = r11
            com.meizu.savior.ChangeQuickRedirect r11 = f9926a
            java.lang.Class[] r8 = new java.lang.Class[r8]
            java.lang.Class<byte[]> r18 = byte[].class
            r8[r15] = r18
            java.lang.Class r18 = java.lang.Integer.TYPE
            r8[r14] = r18
            java.lang.Class<android.location.Location> r18 = android.location.Location.class
            r8[r16] = r18
            java.lang.Class r18 = java.lang.Long.TYPE
            r8[r13] = r18
            java.lang.Class<android.hardware.camera2.TotalCaptureResult> r18 = android.hardware.camera2.TotalCaptureResult.class
            r8[r10] = r18
            java.lang.Class r10 = java.lang.Boolean.TYPE
            r8[r12] = r10
            java.lang.Class r10 = java.lang.Boolean.TYPE
            r8[r17] = r10
            java.lang.Class<byte[]> r17 = byte[].class
            r10 = 0
            r12 = 1
            r18 = 993(0x3e1, float:1.391E-42)
            r13 = r18
            r14 = r8
            r8 = 0
            r15 = r17
            com.meizu.savior.PatchProxyResult r9 = com.meizu.savior.PatchProxy.proxy(r9, r10, r11, r12, r13, r14, r15)
            boolean r10 = r9.isSupported
            if (r10 == 0) goto L_0x0073
            java.lang.Object r0 = r9.result
            byte[] r0 = (byte[]) r0
            return r0
        L_0x0073:
            com.meizu.media.camera.d.c r9 = new com.meizu.media.camera.d.c
            r9.<init>()
            r9.mo19876e()
            r9.mo19883o(r0)
            if (r21 == 0) goto L_0x008e
            double r10 = r21.getLatitude()
            double r12 = r21.getLongitude()
            r9.mo19857a((double) r10, (double) r12)
            r9.mo19859a((long) r3)
        L_0x008e:
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            java.util.TimeZone r0 = r0.getTimeZone()
            int r2 = com.meizu.media.camera.p067d.ExifInterface.f9408u
            r9.mo19858a((int) r2, (long) r3, (java.util.TimeZone) r0)
            if (r5 == 0) goto L_0x01f3
            com.meizu.media.camera.camcontroller.CameraController r0 = com.meizu.media.camera.camcontroller.CameraController.m8868g()
            r2 = r0
            com.meizu.media.camera.camcontroller.CameraControllerV2 r2 = (com.meizu.media.camera.camcontroller.CameraControllerV2) r2
            if (r7 == 0) goto L_0x00ac
            r0 = 1
            r9.mo19853a((boolean) r0)
        L_0x00aa:
            r4 = 3
            goto L_0x00ca
        L_0x00ac:
            r0 = 1
            android.hardware.camera2.CaptureResult$Key r3 = android.hardware.camera2.CaptureResult.FLASH_STATE
            java.lang.Object r3 = r5.get(r3)
            if (r3 == 0) goto L_0x00aa
            android.hardware.camera2.CaptureResult$Key r3 = android.hardware.camera2.CaptureResult.FLASH_STATE
            java.lang.Object r3 = r5.get(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r4 = 3
            if (r4 != r3) goto L_0x00c6
            r3 = 1
            goto L_0x00c7
        L_0x00c6:
            r3 = 0
        L_0x00c7:
            r9.mo19853a((boolean) r3)
        L_0x00ca:
            android.hardware.camera2.CaptureResult$Key r3 = android.hardware.camera2.CaptureResult.LENS_FOCAL_LENGTH
            java.lang.Object r3 = r5.get(r3)
            r10 = 100
            r12 = 1120403456(0x42c80000, float:100.0)
            r13 = 23
            if (r3 == 0) goto L_0x0104
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r13) goto L_0x00eb
            com.meizu.media.camera.camcontroller.f r3 = r2.mo19522k()
            if (r3 == 0) goto L_0x00eb
            com.meizu.media.camera.camcontroller.f r3 = r2.mo19522k()
            float r3 = r3.mo19751e()
            goto L_0x00ec
        L_0x00eb:
            r3 = 0
        L_0x00ec:
            com.meizu.media.camera.d.l r14 = new com.meizu.media.camera.d.l
            android.hardware.camera2.CaptureResult$Key r15 = android.hardware.camera2.CaptureResult.LENS_FOCAL_LENGTH
            java.lang.Object r15 = r5.get(r15)
            java.lang.Float r15 = (java.lang.Float) r15
            float r15 = r15.floatValue()
            float r15 = r15 * r12
            int r15 = (int) r15
            long r7 = (long) r15
            r14.<init>(r7, r10)
            r9.mo19850a((com.meizu.media.camera.p067d.Rational) r14, (float) r3)
        L_0x0104:
            android.hardware.camera2.CaptureResult$Key r3 = android.hardware.camera2.CaptureResult.CONTROL_AWB_MODE
            java.lang.Object r3 = r5.get(r3)
            if (r3 == 0) goto L_0x011b
            android.hardware.camera2.CaptureResult$Key r3 = android.hardware.camera2.CaptureResult.CONTROL_AWB_MODE
            java.lang.Object r3 = r5.get(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r9.mo19870c((int) r3)
        L_0x011b:
            android.hardware.camera2.CaptureResult$Key r3 = android.hardware.camera2.CaptureResult.LENS_APERTURE
            java.lang.Object r3 = r5.get(r3)
            java.lang.Float r3 = (java.lang.Float) r3
            if (r3 == 0) goto L_0x0135
            com.meizu.media.camera.d.l r7 = new com.meizu.media.camera.d.l
            float r3 = r3.floatValue()
            float r3 = r3 * r12
            int r3 = (int) r3
            long r14 = (long) r3
            r7.<init>(r14, r10)
            r9.mo19863b((com.meizu.media.camera.p067d.Rational) r7)
        L_0x0135:
            android.hardware.camera2.CaptureResult$Key r3 = android.hardware.camera2.CaptureResult.SENSOR_EXPOSURE_TIME
            java.lang.Object r3 = r5.get(r3)
            java.lang.Long r3 = (java.lang.Long) r3
            if (r3 == 0) goto L_0x016c
            long r7 = r3.longValue()
            r14 = 3000000000(0xb2d05e00, double:1.4821969375E-314)
            int r7 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            r14 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            if (r7 <= 0) goto L_0x0160
            com.meizu.media.camera.d.l r7 = new com.meizu.media.camera.d.l
            long r17 = r3.longValue()
            long r14 = r17 / r14
            r10 = 1
            r7.<init>(r14, r10)
            r9.mo19849a((com.meizu.media.camera.p067d.Rational) r7)
            goto L_0x016c
        L_0x0160:
            com.meizu.media.camera.d.l r7 = new com.meizu.media.camera.d.l
            long r10 = r3.longValue()
            r7.<init>(r10, r14)
            r9.mo19849a((com.meizu.media.camera.p067d.Rational) r7)
        L_0x016c:
            int r3 = android.os.Build.VERSION.SDK_INT
            r7 = 0
            if (r3 < r13) goto L_0x017c
            com.meizu.media.camera.util.Contants$CameraV2Key r3 = com.meizu.media.camera.util.Contants.CameraV2Key.EXPOSURE_METERING_MODE
            android.hardware.camera2.CaptureResult$Key r3 = r2.mo19562a((com.meizu.media.camera.util.Contants.CameraV2Key) r3)
            java.lang.Object r3 = r5.get(r3)
            goto L_0x017d
        L_0x017c:
            r3 = r7
        L_0x017d:
            if (r3 == 0) goto L_0x0190
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            switch(r3) {
                case 0: goto L_0x018c;
                case 1: goto L_0x018a;
                case 2: goto L_0x018d;
                default: goto L_0x0188;
            }
        L_0x0188:
            r4 = 0
            goto L_0x018d
        L_0x018a:
            r4 = 2
            goto L_0x018d
        L_0x018c:
            r4 = 1
        L_0x018d:
            r9.mo19875e(r4)
        L_0x0190:
            if (r6 == 0) goto L_0x0196
            r9.mo19878f(r0)
            goto L_0x019a
        L_0x0196:
            r0 = 0
            r9.mo19878f(r0)
        L_0x019a:
            android.hardware.camera2.CaptureResult$Key r0 = android.hardware.camera2.CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION
            java.lang.Object r0 = r5.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ g -> 0x01c3 }
            if (r3 < r13) goto L_0x01ab
            float r3 = r2.mo19504d()     // Catch:{ g -> 0x01c3 }
            goto L_0x01ac
        L_0x01ab:
            r3 = 0
        L_0x01ac:
            if (r0 == 0) goto L_0x01da
            com.meizu.media.camera.d.l r4 = new com.meizu.media.camera.d.l     // Catch:{ g -> 0x01c3 }
            int r0 = r0.intValue()     // Catch:{ g -> 0x01c3 }
            float r0 = (float) r0     // Catch:{ g -> 0x01c3 }
            float r0 = r0 * r3
            float r0 = r0 * r12
            long r10 = (long) r0     // Catch:{ g -> 0x01c3 }
            r14 = 100
            r4.<init>(r10, r14)     // Catch:{ g -> 0x01c3 }
            r9.mo19871c((com.meizu.media.camera.p067d.Rational) r4)     // Catch:{ g -> 0x01c3 }
            goto L_0x01da
        L_0x01c3:
            r0 = move-exception
            com.meizu.media.camera.util.ac$a r3 = f9927b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "camera is null!!! "
            r4.append(r6)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r3, (java.lang.String) r0)
        L_0x01da:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r13) goto L_0x01e8
            com.meizu.media.camera.util.Contants$CameraV2Key r0 = com.meizu.media.camera.util.Contants.CameraV2Key.AE_ISO
            android.hardware.camera2.CaptureResult$Key r0 = r2.mo19562a((com.meizu.media.camera.util.Contants.CameraV2Key) r0)
            java.lang.Object r7 = r5.get(r0)
        L_0x01e8:
            if (r7 == 0) goto L_0x01f3
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r0 = r7.intValue()
            r9.mo19873d(r0)
        L_0x01f3:
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            r9.mo19855a((byte[]) r1, (java.io.OutputStream) r2)     // Catch:{ IOException -> 0x01fc }
            goto L_0x0205
        L_0x01fc:
            r0 = move-exception
            r1 = r0
            com.meizu.media.camera.util.ac$a r0 = f9927b
            java.lang.String r3 = "Could not write EXIF"
            com.meizu.media.camera.util.LogUtil.m15950b(r0, r3, r1)
        L_0x0205:
            byte[] r0 = r2.toByteArray()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.Exif.m10045a(byte[], int, android.location.Location, long, android.hardware.camera2.TotalCaptureResult, boolean, boolean):byte[]");
    }
}
