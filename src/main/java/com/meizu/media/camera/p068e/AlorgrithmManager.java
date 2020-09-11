package com.meizu.media.camera.p068e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import androidx.core.view.MotionEventCompat;
import com.meizu.camera.MeizuCamera;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.util.C2634am;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.cameraAlgorithm.fbmodecomponent.AlorgrithmUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.reflect.Method;

/* renamed from: com.meizu.media.camera.e.a */
public class AlorgrithmManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f9901a;

    /* renamed from: b */
    public static final LogUtil.C2630a f9902b = new LogUtil.C2630a("AlorgrithmManager");

    /* renamed from: c */
    public static final String f9903c = Environment.getExternalStorageDirectory().toString();

    static {
        if (!DeviceHelper.f13910bJ.equals(CameraController.CameraApi.API2)) {
            if (Build.VERSION.SDK_INT < 29) {
                LogUtil.m15942a(f9902b, "loadLibrary FlymeFixLinker");
                try {
                    System.loadLibrary("FlymeFixLinker");
                } catch (UnsatisfiedLinkError unused) {
                }
            }
            if (DeviceHelper.f13905bE) {
                System.loadLibrary("fbalgorithmsdk4");
            } else {
                System.loadLibrary("fbalgorithmsdk");
            }
        } else if (DeviceHelper.f14025dq) {
            System.loadLibrary("fbalgorithmsdk4");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0092 A[SYNTHETIC, Splitter:B:20:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ac A[SYNTHETIC, Splitter:B:27:0x00ac] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m10022a(java.lang.String r16, byte[] r17, int r18, int r19) {
        /*
            r0 = r16
            r1 = 4
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r9 = 0
            r2[r9] = r0
            r3 = 1
            r2[r3] = r17
            java.lang.Integer r4 = new java.lang.Integer
            r13 = r18
            r4.<init>(r13)
            r5 = 2
            r2[r5] = r4
            java.lang.Integer r4 = new java.lang.Integer
            r14 = r19
            r4.<init>(r14)
            r6 = 3
            r2[r6] = r4
            com.meizu.savior.ChangeQuickRedirect r4 = f9901a
            java.lang.Class[] r7 = new java.lang.Class[r1]
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            r7[r9] = r1
            java.lang.Class<byte[]> r1 = byte[].class
            r7[r3] = r1
            java.lang.Class r1 = java.lang.Integer.TYPE
            r7[r5] = r1
            java.lang.Class r1 = java.lang.Integer.TYPE
            r7[r6] = r1
            java.lang.Class r8 = java.lang.Void.TYPE
            r3 = 0
            r5 = 1
            r6 = 4014(0xfae, float:5.625E-42)
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r2, r3, r4, r5, r6, r7, r8)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x0042
            return
        L_0x0042:
            com.meizu.media.camera.util.ac$a r1 = f9902b
            java.lang.String r2 = "SaveNV21Jpeg"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r1, (java.lang.String) r2)
            r1 = 0
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0085 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0085 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0085 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0085 }
            android.graphics.YuvImage r0 = new android.graphics.YuvImage     // Catch:{ IOException -> 0x007e, all -> 0x007c }
            r12 = 17
            r15 = 0
            r10 = r0
            r11 = r17
            r13 = r18
            r14 = r19
            r10.<init>(r11, r12, r13, r14, r15)     // Catch:{ IOException -> 0x007e, all -> 0x007c }
            android.graphics.Rect r1 = new android.graphics.Rect     // Catch:{ IOException -> 0x007e, all -> 0x007c }
            int r3 = r0.getWidth()     // Catch:{ IOException -> 0x007e, all -> 0x007c }
            int r4 = r0.getHeight()     // Catch:{ IOException -> 0x007e, all -> 0x007c }
            r1.<init>(r9, r9, r3, r4)     // Catch:{ IOException -> 0x007e, all -> 0x007c }
            r3 = 97
            r0.compressToJpeg(r1, r3, r2)     // Catch:{ IOException -> 0x007e, all -> 0x007c }
            r2.flush()     // Catch:{ IOException -> 0x007e, all -> 0x007c }
            r2.close()     // Catch:{ IOException -> 0x0096 }
            goto L_0x00a2
        L_0x007c:
            r0 = move-exception
            goto L_0x0083
        L_0x007e:
            r0 = move-exception
            r1 = r2
            goto L_0x0086
        L_0x0081:
            r0 = move-exception
            r2 = r1
        L_0x0083:
            r1 = r0
            goto L_0x00aa
        L_0x0085:
            r0 = move-exception
        L_0x0086:
            com.meizu.media.camera.util.ac$a r2 = f9902b     // Catch:{ all -> 0x0081 }
            java.lang.String r3 = "FileOutputStream fail to call the write() method"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0081 }
            r0.printStackTrace()     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x00a2
            r1.close()     // Catch:{ IOException -> 0x0096 }
            goto L_0x00a2
        L_0x0096:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
            com.meizu.media.camera.util.ac$a r0 = f9902b
            java.lang.String r1 = "fail to close fops"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
        L_0x00a2:
            com.meizu.media.camera.util.ac$a r0 = f9902b
            java.lang.String r1 = "saveNV21Jpeg end"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            return
        L_0x00aa:
            if (r2 == 0) goto L_0x00bc
            r2.close()     // Catch:{ IOException -> 0x00b0 }
            goto L_0x00bc
        L_0x00b0:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
            com.meizu.media.camera.util.ac$a r0 = f9902b
            java.lang.String r2 = "fail to close fops"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r2)
        L_0x00bc:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p068e.AlorgrithmManager.m10022a(java.lang.String, byte[], int, int):void");
    }

    /* renamed from: a */
    private static byte[] m10024a(int i, int i2, Bitmap bitmap) {
        Object[] objArr = {new Integer(i), new Integer(i2), bitmap};
        ChangeQuickRedirect changeQuickRedirect = f9901a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 4017, new Class[]{Integer.TYPE, Integer.TYPE, Bitmap.class}, byte[].class);
        if (proxy.isSupported) {
            return (byte[]) proxy.result;
        }
        LogUtil.m15942a(f9902b, "getNV21Data start");
        byte[] bArr = new byte[(((i * i2) * 3) / 2)];
        byte[] changeARGBToNV21 = AlorgrithmUtil.changeARGBToNV21(bitmap);
        LogUtil.m15942a(f9902b, "ARGBToNV21 end");
        bitmap.recycle();
        LogUtil.m15942a(f9902b, "getNV21Data end");
        return changeARGBToNV21;
    }

    /* renamed from: a */
    public static Bitmap m10017a(byte[] bArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr}, (Object) null, f9901a, true, 4019, new Class[]{byte[].class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        LogUtil.m15942a(f9902b, "readBitmapFromByteArray");
        if (bArr == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = 1;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        LogUtil.m15942a(f9902b, "readBitmapFromByteArray end");
        return decodeByteArray;
    }

    /* renamed from: a */
    public static void m10020a(String str, Bitmap bitmap) {
        Class[] clsArr = {String.class, Bitmap.class};
        if (!PatchProxy.proxy(new Object[]{str, bitmap}, (Object) null, f9901a, true, 4021, clsArr, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f9902b;
            LogUtil.m15942a(aVar, "process with NV21data start:" + str);
            if (bitmap != null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                LogUtil.C2630a aVar2 = f9902b;
                LogUtil.m15942a(aVar2, "imagesize witdh:" + width + " height:" + height);
                byte[] a = m10024a(width, height, bitmap);
                AlorgrithmUtil.processNV21Data(a, a.length, width, height, DeviceHelper.f13905bE);
                m10022a(str, a, width, height);
            }
            LogUtil.m15942a(f9902b, "process with NV21data end");
        }
    }

    /* renamed from: a */
    public static void m10023a(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2), new Integer(i3), new Byte(z ? (byte) 1 : 0)}, (Object) null, f9901a, true, 4022, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            AlorgrithmUtil.processNV21Data(bArr, i, i2, i3, z);
        }
    }

    /* renamed from: b */
    public static int m10026b(String str, byte[] bArr, int i, int i2) {
        Object[] objArr = {str, bArr, new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f9901a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 4023, new Class[]{String.class, byte[].class, Integer.TYPE, Integer.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        LogUtil.C2630a aVar = f9902b;
        LogUtil.m15942a(aVar, "processNV21withJpeg start:filename:" + str);
        LogUtil.C2630a aVar2 = f9902b;
        LogUtil.m15942a(aVar2, "imagesize witdh:" + i + " height:" + i2);
        if (str == null || bArr == null) {
            return 0;
        }
        int[] iArr = {0, 0};
        byte[] nativeDecodeNv21 = AlorgrithmUtil.nativeDecodeNv21(bArr, bArr.length, i, i2, iArr);
        if (nativeDecodeNv21 == null) {
            return -1;
        }
        m10018a();
        AlorgrithmUtil.processNV21Data(nativeDecodeNv21, nativeDecodeNv21.length, iArr[0], iArr[1], DeviceHelper.f13905bE);
        m10022a(str, nativeDecodeNv21, iArr[0], iArr[1]);
        LogUtil.m15942a(f9902b, "processNV21withJpeg end");
        return 0;
    }

    /* renamed from: a */
    public static int[] m10025a(byte[] bArr, int i, int i2, boolean z) {
        boolean z2;
        boolean z3;
        int i3 = i;
        int i4 = i2;
        boolean z4 = z;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr, new Integer(i3), new Integer(i4), new Byte(z4 ? (byte) 1 : 0)}, (Object) null, f9901a, true, 4026, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, int[].class);
        if (proxy.isSupported) {
            return (int[]) proxy.result;
        }
        if (z4) {
            LogUtil.m15942a(f9902b, "converI420toARGB");
        }
        if (i4 < 0) {
            i4 = -i4;
            z2 = true;
        } else {
            z2 = false;
        }
        if (i3 < 0) {
            i3 = -i3;
            z3 = true;
        } else {
            z3 = false;
        }
        int i5 = i3 * i4;
        int[] iArr = new int[i5];
        int i6 = 0;
        while (i6 < i5) {
            int i7 = i6 / i3;
            int i8 = i6 % i3;
            int i9 = ((i7 / 2) * (i3 / 2)) + (i8 / 2);
            double d = (double) (bArr[i6] & 255);
            double d2 = (double) ((bArr[i5 + i9] & 255) - 128);
            int i10 = i5;
            int[] iArr2 = iArr;
            int i11 = (int) (d + (1.8556d * d2));
            int i12 = i6;
            double d3 = (double) ((bArr[(i5 + (i5 / 4)) + i9] & 255) - 128);
            int i13 = (int) (d - ((0.4681d * d3) + (d2 * 0.1872d)));
            int i14 = (int) (d + (d3 * 1.5748d));
            if (i11 > 255) {
                i11 = 255;
            } else if (i11 < 0) {
                i11 = 0;
            }
            if (i13 > 255) {
                i13 = 255;
            } else if (i13 < 0) {
                i13 = 0;
            }
            if (i14 > 255) {
                i14 = 255;
            } else if (i14 < 0) {
                i14 = 0;
            }
            int i15 = z2 ? (((i4 - 1) - i7) * i3) + i8 : i12;
            if (z3) {
                i15 = (((i15 / i3) * i3) + (i3 - 1)) - (i15 % i3);
            }
            iArr2[i15] = (i11 & 255) | -16777216 | (16711680 & (i14 << 16)) | ((i13 << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
            i6 = i12 + 1;
            i5 = i10;
            iArr = iArr2;
        }
        return iArr;
    }

    /* renamed from: a */
    public static void m10019a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f9901a, true, 4027, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f9902b;
            LogUtil.m15942a(aVar, "setFBParmswithLevel:" + i);
            AlorgrithmUtil.cleanFeatureValue();
            if (i == 1) {
                if (!DeviceHelper.f13905bE) {
                    AlorgrithmUtil.setFeatureValue(201, DeviceHelper.f13958cE[0]);
                    AlorgrithmUtil.setFeatureValue(202, DeviceHelper.f13958cE[1]);
                    AlorgrithmUtil.setFeatureValue(MeizuCamera.TEMPERATURE_CLOSE_CAMERA_NOTIFY, DeviceHelper.f13958cE[2]);
                    AlorgrithmUtil.setFeatureValue(MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, DeviceHelper.f13958cE[3]);
                    AlorgrithmUtil.setFeatureValue(213, DeviceHelper.f13958cE[4]);
                    AlorgrithmUtil.setFeatureValue(217, DeviceHelper.f13958cE[5]);
                    AlorgrithmUtil.setFeatureValue(216, DeviceHelper.f13958cE[6]);
                    AlorgrithmUtil.setFeatureValue(218, DeviceHelper.f13958cE[7]);
                    return;
                }
                AlorgrithmUtil.setFeatureValue(201, DeviceHelper.f13963cJ[0]);
                if (DeviceHelper.f13963cJ[1] != -1) {
                    AlorgrithmUtil.setFeatureValue(202, DeviceHelper.f13963cJ[1]);
                }
                AlorgrithmUtil.setFeatureValue(MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, DeviceHelper.f13963cJ[2]);
                AlorgrithmUtil.setFeatureValue(MeizuCamera.TEMPERATURE_CLOSE_CAMERA_NOTIFY, DeviceHelper.f13963cJ[3]);
                AlorgrithmUtil.setFeatureValue(210, DeviceHelper.f13963cJ[4]);
                AlorgrithmUtil.setFeatureValue(213, DeviceHelper.f13963cJ[5]);
                AlorgrithmUtil.setFeatureValue(214, DeviceHelper.f13963cJ[6]);
                AlorgrithmUtil.setFeatureValue(215, DeviceHelper.f13963cJ[7]);
                AlorgrithmUtil.setFeatureValue(216, DeviceHelper.f13963cJ[8]);
                AlorgrithmUtil.setFeatureValue(217, DeviceHelper.f13963cJ[9]);
                AlorgrithmUtil.setFeatureValue(218, DeviceHelper.f13963cJ[10]);
                AlorgrithmUtil.setFeatureValue(228, DeviceHelper.f13963cJ[11]);
                AlorgrithmUtil.setFeatureValue(231, DeviceHelper.f13963cJ[12]);
                AlorgrithmUtil.setFeatureValue(234, DeviceHelper.f13963cJ[13]);
            } else if (i != 5) {
            } else {
                if (!DeviceHelper.f13905bE) {
                    AlorgrithmUtil.setFeatureValue(201, DeviceHelper.f13962cI[0]);
                    AlorgrithmUtil.setFeatureValue(202, DeviceHelper.f13962cI[1]);
                    AlorgrithmUtil.setFeatureValue(MeizuCamera.TEMPERATURE_CLOSE_CAMERA_NOTIFY, DeviceHelper.f13962cI[2]);
                    AlorgrithmUtil.setFeatureValue(MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, DeviceHelper.f13962cI[3]);
                    AlorgrithmUtil.setFeatureValue(213, DeviceHelper.f13962cI[4]);
                    AlorgrithmUtil.setFeatureValue(217, DeviceHelper.f13962cI[5]);
                    AlorgrithmUtil.setFeatureValue(216, DeviceHelper.f13962cI[6]);
                    AlorgrithmUtil.setFeatureValue(218, DeviceHelper.f13962cI[7]);
                    return;
                }
                AlorgrithmUtil.setFeatureValue(201, DeviceHelper.f13964cK[0]);
                if (DeviceHelper.f13964cK[1] != -1) {
                    AlorgrithmUtil.setFeatureValue(202, DeviceHelper.f13964cK[1]);
                }
                AlorgrithmUtil.setFeatureValue(MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, DeviceHelper.f13964cK[2]);
                AlorgrithmUtil.setFeatureValue(MeizuCamera.TEMPERATURE_CLOSE_CAMERA_NOTIFY, DeviceHelper.f13964cK[3]);
                AlorgrithmUtil.setFeatureValue(210, DeviceHelper.f13964cK[4]);
                AlorgrithmUtil.setFeatureValue(213, DeviceHelper.f13964cK[5]);
                AlorgrithmUtil.setFeatureValue(214, DeviceHelper.f13964cK[6]);
                AlorgrithmUtil.setFeatureValue(215, DeviceHelper.f13964cK[7]);
                AlorgrithmUtil.setFeatureValue(216, DeviceHelper.f13964cK[8]);
                AlorgrithmUtil.setFeatureValue(217, DeviceHelper.f13964cK[9]);
                AlorgrithmUtil.setFeatureValue(218, DeviceHelper.f13964cK[10]);
                AlorgrithmUtil.setFeatureValue(228, DeviceHelper.f13964cK[11]);
                AlorgrithmUtil.setFeatureValue(231, DeviceHelper.f13964cK[12]);
                AlorgrithmUtil.setFeatureValue(234, DeviceHelper.f13964cK[13]);
            }
        }
    }

    /* renamed from: b */
    public static void m10027b(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, (Object) null, f9901a, true, 4028, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f9902b;
            LogUtil.m15942a(aVar, "setFBParamwithLevelForgender:" + i);
            AlorgrithmUtil.cleanFeatureValue();
            if (i == 0) {
                AlorgrithmUtil.setFeatureValue(201, DeviceHelper.f13963cJ[0]);
                if (DeviceHelper.f13963cJ[1] != -1) {
                    AlorgrithmUtil.setFeatureValue(202, DeviceHelper.f13963cJ[1]);
                }
                AlorgrithmUtil.setFeatureValue(MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, DeviceHelper.f13963cJ[2]);
                AlorgrithmUtil.setFeatureValue(MeizuCamera.TEMPERATURE_CLOSE_CAMERA_NOTIFY, DeviceHelper.f13963cJ[3]);
                AlorgrithmUtil.setFeatureValue(210, DeviceHelper.f13963cJ[4]);
                AlorgrithmUtil.setFeatureValue(213, DeviceHelper.f13963cJ[5]);
                AlorgrithmUtil.setFeatureValue(214, DeviceHelper.f13963cJ[6]);
                AlorgrithmUtil.setFeatureValue(215, DeviceHelper.f13963cJ[7]);
                AlorgrithmUtil.setFeatureValue(216, DeviceHelper.f13963cJ[8]);
                AlorgrithmUtil.setFeatureValue(217, DeviceHelper.f13963cJ[9]);
                AlorgrithmUtil.setFeatureValue(218, DeviceHelper.f13963cJ[10]);
                AlorgrithmUtil.setFeatureValue(228, DeviceHelper.f13963cJ[11]);
                AlorgrithmUtil.setFeatureValue(231, DeviceHelper.f13963cJ[12]);
                AlorgrithmUtil.setFeatureValue(234, DeviceHelper.f13963cJ[13]);
                return;
            }
            AlorgrithmUtil.setFeatureValue(201, DeviceHelper.f13965cL[0]);
            if (DeviceHelper.f13963cJ[1] != -1) {
                AlorgrithmUtil.setFeatureValue(202, DeviceHelper.f13965cL[1]);
            }
            AlorgrithmUtil.setFeatureValue(MeizuCamera.TEMPERATURE_CLOSE_RECORD_NOTIFY, DeviceHelper.f13965cL[2]);
            AlorgrithmUtil.setFeatureValue(MeizuCamera.TEMPERATURE_CLOSE_CAMERA_NOTIFY, DeviceHelper.f13965cL[3]);
            AlorgrithmUtil.setFeatureValue(210, DeviceHelper.f13965cL[4]);
            AlorgrithmUtil.setFeatureValue(213, DeviceHelper.f13965cL[5]);
            AlorgrithmUtil.setFeatureValue(214, DeviceHelper.f13965cL[6]);
            AlorgrithmUtil.setFeatureValue(215, DeviceHelper.f13965cL[7]);
            AlorgrithmUtil.setFeatureValue(216, DeviceHelper.f13965cL[8]);
            AlorgrithmUtil.setFeatureValue(217, DeviceHelper.f13965cL[9]);
            AlorgrithmUtil.setFeatureValue(218, DeviceHelper.f13965cL[10]);
            AlorgrithmUtil.setFeatureValue(228, DeviceHelper.f13965cL[11]);
            AlorgrithmUtil.setFeatureValue(231, DeviceHelper.f13965cL[12]);
            AlorgrithmUtil.setFeatureValue(234, DeviceHelper.f13965cL[13]);
        }
    }

    /* renamed from: a */
    public static void m10018a() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, f9901a, true, 4029, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f9902b, "fixedCpu");
            try {
                Object a = C2634am.m15996a("android.perf.IntelligentEngineManager", "getInstance", (Object[]) null);
                if (a != null) {
                    LogUtil.m15942a(f9902b, "boostPerformance");
                    Method method = Class.forName("android.perf.IntelligentEngineManager").getMethod("boostPerformance", new Class[]{String.class});
                    LogUtil.m15942a(f9902b, "CameraFBStart");
                    method.invoke(a, new Object[]{"CameraFBStart"});
                }
            } catch (Exception e) {
                LogUtil.m15942a(f9902b, "IntelligentEngineManager Object can not found");
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092 A[SYNTHETIC, Splitter:B:34:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a3 A[SYNTHETIC, Splitter:B:40:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c8 A[SYNTHETIC, Splitter:B:52:0x00c8] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0086=Splitter:B:31:0x0086, B:37:0x0097=Splitter:B:37:0x0097} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m10021a(java.lang.String r11, com.meizu.media.camera.p067d.ExifInterface r12) {
        /*
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r11
            r9 = 1
            r1[r9] = r12
            com.meizu.savior.ChangeQuickRedirect r3 = f9901a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r8] = r0
            java.lang.Class<com.meizu.media.camera.d.c> r0 = com.meizu.media.camera.p067d.ExifInterface.class
            r6[r9] = r0
            java.lang.Class r7 = java.lang.Void.TYPE
            r2 = 0
            r4 = 1
            r5 = 4030(0xfbe, float:5.647E-42)
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0024
            return
        L_0x0024:
            com.meizu.media.camera.util.ac$a r0 = f9902b
            java.lang.String r1 = "writefinalExif"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x004f }
            r1.<init>(r11)     // Catch:{ Exception -> 0x004f }
            long r1 = r1.length()     // Catch:{ Exception -> 0x004f }
            int r1 = (int) r1
            com.meizu.media.camera.util.ac$a r2 = f9902b     // Catch:{ Exception -> 0x004d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004d }
            r3.<init>()     // Catch:{ Exception -> 0x004d }
            java.lang.String r4 = "filesize:"
            r3.append(r4)     // Catch:{ Exception -> 0x004d }
            r3.append(r1)     // Catch:{ Exception -> 0x004d }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x004d }
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x004d }
            goto L_0x005b
        L_0x004d:
            r2 = move-exception
            goto L_0x0051
        L_0x004f:
            r2 = move-exception
            r1 = 0
        L_0x0051:
            com.meizu.media.camera.util.ac$a r3 = f9902b
            java.lang.String r4 = "file not exist"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r3, (java.lang.String) r4)
            r2.printStackTrace()
        L_0x005b:
            byte[] r1 = new byte[r1]
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0085 }
            r2.<init>(r11)     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0085 }
            r2.read(r1)     // Catch:{ FileNotFoundException -> 0x007e, IOException -> 0x0079, all -> 0x0076 }
            r2.close()     // Catch:{ IOException -> 0x006a }
            r8 = 1
            goto L_0x00a6
        L_0x006a:
            r0 = move-exception
            com.meizu.media.camera.util.ac$a r2 = f9902b
            java.lang.String r3 = "file close fail"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r2, (java.lang.String) r3)
            r0.printStackTrace()
            goto L_0x00a6
        L_0x0076:
            r11 = move-exception
            r0 = r2
            goto L_0x00c6
        L_0x0079:
            r0 = move-exception
            r10 = r2
            r2 = r0
            r0 = r10
            goto L_0x0086
        L_0x007e:
            r0 = move-exception
            r10 = r2
            r2 = r0
            r0 = r10
            goto L_0x0097
        L_0x0083:
            r11 = move-exception
            goto L_0x00c6
        L_0x0085:
            r2 = move-exception
        L_0x0086:
            com.meizu.media.camera.util.ac$a r3 = f9902b     // Catch:{ all -> 0x0083 }
            java.lang.String r4 = "file read fail"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0083 }
            r2.printStackTrace()     // Catch:{ all -> 0x0083 }
            if (r0 == 0) goto L_0x00a6
            r0.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x00a6
        L_0x0096:
            r2 = move-exception
        L_0x0097:
            com.meizu.media.camera.util.ac$a r3 = f9902b     // Catch:{ all -> 0x0083 }
            java.lang.String r4 = "file not exist"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0083 }
            r2.printStackTrace()     // Catch:{ all -> 0x0083 }
            if (r0 == 0) goto L_0x00a6
            r0.close()     // Catch:{ IOException -> 0x006a }
        L_0x00a6:
            if (r12 == 0) goto L_0x00b7
            if (r8 != r9) goto L_0x00be
            r12.mo19856a((byte[]) r1, (java.lang.String) r11)     // Catch:{ Exception -> 0x00ae }
            goto L_0x00be
        L_0x00ae:
            r11 = move-exception
            com.meizu.media.camera.util.ac$a r12 = f9902b
            java.lang.String r0 = "Failed to write data"
            com.meizu.media.camera.util.LogUtil.m15950b(r12, r0, r11)
            goto L_0x00be
        L_0x00b7:
            com.meizu.media.camera.util.ac$a r11 = f9902b
            java.lang.String r12 = "exif not found"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r11, (java.lang.String) r12)
        L_0x00be:
            com.meizu.media.camera.util.ac$a r11 = f9902b
            java.lang.String r12 = "writefinalExif end"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r11, (java.lang.String) r12)
            return
        L_0x00c6:
            if (r0 == 0) goto L_0x00d7
            r0.close()     // Catch:{ IOException -> 0x00cc }
            goto L_0x00d7
        L_0x00cc:
            r12 = move-exception
            com.meizu.media.camera.util.ac$a r0 = f9902b
            java.lang.String r1 = "file close fail"
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r1)
            r12.printStackTrace()
        L_0x00d7:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p068e.AlorgrithmManager.m10021a(java.lang.String, com.meizu.media.camera.d.c):void");
    }
}
