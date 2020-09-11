package com.meizu.camera.effectlib.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint({"SimpleDateFormat", "SdCardPath"})
/* renamed from: com.meizu.camera.effectlib.utils.Utils */
public class C1198Utils {

    /* renamed from: a */
    public static ChangeQuickRedirect f4101a = null;

    /* renamed from: b */
    private static String f4102b = "/sdcard/pano_tests";

    /* renamed from: c */
    private static Date f4103c = new Date();

    /* renamed from: d */
    private static String f4104d = "";

    /* renamed from: e */
    private static String f4105e = "";

    /* renamed from: f */
    private static final SimpleDateFormat f4106f = new SimpleDateFormat("yyyyMMdd_HHmmss");

    public static native String getFunnySecretKey(Context context);

    public static native byte[] getLutSecretKey();

    static {
        try {
            System.loadLibrary("secretkey");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    /* renamed from: a */
    public static boolean m4822a(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f4101a, true, 519, new Class[]{String.class}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : str.contains(PushConstants.CONTENT);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x008f A[Catch:{ Exception -> 0x00d5, all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0099 A[Catch:{ Exception -> 0x00d5, all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00be A[SYNTHETIC, Splitter:B:27:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c8 A[SYNTHETIC, Splitter:B:32:0x00c8] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0102 A[SYNTHETIC, Splitter:B:48:0x0102] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010c A[SYNTHETIC, Splitter:B:53:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0118 A[SYNTHETIC, Splitter:B:59:0x0118] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0122 A[SYNTHETIC, Splitter:B:64:0x0122] */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap m4821a(java.lang.String r10, boolean r11, android.content.Context r12) {
        /*
            r0 = 3
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r11)
            r3 = 1
            r1[r3] = r2
            r2 = 2
            r1[r2] = r12
            com.meizu.savior.ChangeQuickRedirect r4 = f4101a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r8] = r0
            java.lang.Class r0 = java.lang.Boolean.TYPE
            r6[r3] = r0
            java.lang.Class<android.content.Context> r0 = android.content.Context.class
            r6[r2] = r0
            java.lang.Class<android.graphics.Bitmap> r7 = android.graphics.Bitmap.class
            r2 = 0
            r0 = 1
            r5 = 520(0x208, float:7.29E-43)
            r3 = r4
            r4 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x0036
            java.lang.Object r10 = r0.result
            android.graphics.Bitmap r10 = (android.graphics.Bitmap) r10
            return r10
        L_0x0036:
            java.lang.String r0 = "EffectUtils"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "createBitmapFromFile: "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r0, r1)
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r0.inScaled = r8
            r0 = 0
            if (r11 == 0) goto L_0x0069
            android.content.res.AssetManager r11 = r12.getAssets()     // Catch:{ Exception -> 0x0064, all -> 0x0060 }
            java.io.InputStream r11 = r11.open(r10)     // Catch:{ Exception -> 0x0064, all -> 0x0060 }
        L_0x005e:
            r12 = r0
            goto L_0x0089
        L_0x0060:
            r10 = move-exception
            r11 = r0
            goto L_0x0116
        L_0x0064:
            r10 = move-exception
            r11 = r0
            r12 = r11
            goto L_0x00e3
        L_0x0069:
            boolean r11 = m4822a(r10)     // Catch:{ Exception -> 0x0064, all -> 0x0060 }
            if (r11 == 0) goto L_0x007c
            android.net.Uri r11 = android.net.Uri.parse(r10)     // Catch:{ Exception -> 0x0064, all -> 0x0060 }
            android.content.ContentResolver r12 = r12.getContentResolver()     // Catch:{ Exception -> 0x0064, all -> 0x0060 }
            java.io.InputStream r11 = r12.openInputStream(r11)     // Catch:{ Exception -> 0x0064, all -> 0x0060 }
            goto L_0x005e
        L_0x007c:
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0064, all -> 0x0060 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x0064, all -> 0x0060 }
            java.io.BufferedInputStream r12 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00df, all -> 0x00da }
            r12.<init>(r11)     // Catch:{ Exception -> 0x00df, all -> 0x00da }
            r9 = r12
            r12 = r11
            r11 = r9
        L_0x0089:
            boolean r1 = m4822a(r10)     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
            if (r1 == 0) goto L_0x0099
            com.meizu.camera.effectlib.utils.Utils$a r1 = new com.meizu.camera.effectlib.utils.Utils$a     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
            r1.<init>(r11)     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
            goto L_0x009d
        L_0x0099:
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r11)     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
        L_0x009d:
            r0 = r1
            java.lang.String r1 = "EffectUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
            r2.<init>()     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
            java.lang.String r3 = "createBitmapFromFile : "
            r2.append(r3)     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
            r2.append(r10)     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
            java.lang.String r10 = " Bitmap"
            r2.append(r10)     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
            r2.append(r0)     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
            java.lang.String r10 = r2.toString()     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
            android.util.Log.i(r1, r10)     // Catch:{ Exception -> 0x00d5, all -> 0x00d2 }
            if (r12 == 0) goto L_0x00c6
            r12.close()     // Catch:{ IOException -> 0x00c2 }
            goto L_0x00c6
        L_0x00c2:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00c6:
            if (r11 == 0) goto L_0x00d0
            r11.close()     // Catch:{ IOException -> 0x00cc }
            goto L_0x00d0
        L_0x00cc:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00d0:
            r12 = r0
            goto L_0x0114
        L_0x00d2:
            r10 = move-exception
            r0 = r12
            goto L_0x0116
        L_0x00d5:
            r10 = move-exception
            r9 = r0
            r0 = r12
            r12 = r9
            goto L_0x00e3
        L_0x00da:
            r10 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
            goto L_0x0116
        L_0x00df:
            r10 = move-exception
            r12 = r0
            r0 = r11
            r11 = r12
        L_0x00e3:
            r10.printStackTrace()     // Catch:{ all -> 0x0115 }
            java.lang.String r1 = "EffectUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            r2.<init>()     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = "createBitmapFromFile fail "
            r2.append(r3)     // Catch:{ all -> 0x0115 }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x0115 }
            r2.append(r10)     // Catch:{ all -> 0x0115 }
            java.lang.String r10 = r2.toString()     // Catch:{ all -> 0x0115 }
            android.util.Log.i(r1, r10)     // Catch:{ all -> 0x0115 }
            if (r0 == 0) goto L_0x010a
            r0.close()     // Catch:{ IOException -> 0x0106 }
            goto L_0x010a
        L_0x0106:
            r10 = move-exception
            r10.printStackTrace()
        L_0x010a:
            if (r11 == 0) goto L_0x0114
            r11.close()     // Catch:{ IOException -> 0x0110 }
            goto L_0x0114
        L_0x0110:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0114:
            return r12
        L_0x0115:
            r10 = move-exception
        L_0x0116:
            if (r0 == 0) goto L_0x0120
            r0.close()     // Catch:{ IOException -> 0x011c }
            goto L_0x0120
        L_0x011c:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0120:
            if (r11 == 0) goto L_0x012a
            r11.close()     // Catch:{ IOException -> 0x0126 }
            goto L_0x012a
        L_0x0126:
            r11 = move-exception
            r11.printStackTrace()
        L_0x012a:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.utils.C1198Utils.m4821a(java.lang.String, boolean, android.content.Context):android.graphics.Bitmap");
    }

    /* renamed from: com.meizu.camera.effectlib.utils.Utils$a */
    public static class C1199a extends FilterInputStream {

        /* renamed from: a */
        public static ChangeQuickRedirect f4107a;

        /* renamed from: b */
        private byte[] f4108b = C1198Utils.getLutSecretKey();

        /* renamed from: c */
        private int f4109c = 0;

        public C1199a(InputStream inputStream) {
            super(inputStream);
        }

        public int read() throws IOException {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f4107a, false, 521, new Class[0], Integer.TYPE);
            if (proxy.isSupported) {
                return ((Integer) proxy.result).intValue();
            }
            int read = super.read();
            if (this.f4109c >= this.f4108b.length) {
                return read;
            }
            byte[] bArr = this.f4108b;
            int i = this.f4109c;
            this.f4109c = i + 1;
            return ((byte) read) ^ bArr[i];
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            Object[] objArr = {bArr, new Integer(i), new Integer(i2)};
            ChangeQuickRedirect changeQuickRedirect = f4107a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 522, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE}, Integer.TYPE);
            if (proxy.isSupported) {
                return ((Integer) proxy.result).intValue();
            }
            int read = super.read(bArr, i, i2);
            if (this.f4109c < this.f4108b.length) {
                for (int i3 = 0; i3 < read && this.f4109c < this.f4108b.length; i3++) {
                    int i4 = i3 + i;
                    byte b = bArr[i4];
                    byte[] bArr2 = this.f4108b;
                    int i5 = this.f4109c;
                    this.f4109c = i5 + 1;
                    bArr[i4] = (byte) (b ^ bArr2[i5]);
                }
            }
            return read;
        }
    }
}
