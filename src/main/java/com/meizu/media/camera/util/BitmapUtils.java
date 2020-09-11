package com.meizu.media.camera.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.meizu.media.camera.util.ThreadPool;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;

/* renamed from: com.meizu.media.camera.util.g */
public class BitmapUtils {

    /* renamed from: a */
    public static ChangeQuickRedirect f14236a;

    /* renamed from: b */
    private static final Matrix.ScaleToFit[] f14237b = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};

    /* renamed from: c */
    private static final String[] f14238c = {ExifInterface.TAG_DATETIME, ExifInterface.TAG_MAKE, "Model", ExifInterface.TAG_FLASH, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_WHITE_BALANCE, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_GPS_PROCESSING_METHOD};

    /* renamed from: a */
    public static Bitmap m16140a(Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, (Object) null, f14236a, true, 7779, new Class[]{Bitmap.class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        Canvas canvas = new Canvas();
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(createBitmap);
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate((float) bitmap.getWidth(), 0.0f);
        canvas.drawBitmap(bitmap, matrix, (Paint) null);
        return createBitmap;
    }

    /* renamed from: a */
    public static Bitmap m16141a(Bitmap bitmap, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap, new Integer(i)}, (Object) null, f14236a, true, 7780, new Class[]{Bitmap.class, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (i != 0) {
            Matrix matrix = new Matrix();
            matrix.setRotate((float) i, ((float) bitmap.getWidth()) * 0.5f, ((float) bitmap.getHeight()) * 0.5f);
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Throwable th) {
                Log.d("BitmapUtils", th.getMessage());
            }
        }
        return bitmap;
    }

    /* renamed from: b */
    public static byte[] m16146b(Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, (Object) null, f14236a, true, 7782, new Class[]{Bitmap.class}, byte[].class);
        if (proxy.isSupported) {
            return (byte[]) proxy.result;
        }
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static Bitmap m16143a(ThreadPool.C2638c cVar, FileDescriptor fileDescriptor, int i, int i2, int i3, int i4, int i5) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{cVar, fileDescriptor, new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4), new Integer(i5)}, (Object) null, f14236a, true, 7783, new Class[]{ThreadPool.C2638c.class, FileDescriptor.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Bitmap.class);
        return proxy.isSupported ? (Bitmap) proxy.result : m16144a(cVar, fileDescriptor, (byte[]) null, i, i2, i3, i4, i5);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00b3, code lost:
        r12 = r10 * r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00b7, code lost:
        r13 = r4 * r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01b4, code lost:
        if (r0.getHeight() != r5) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01b8, code lost:
        if (r7 > 0) goto L_0x01ba;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01dc A[SYNTHETIC, Splitter:B:102:0x01dc] */
    /* JADX WARNING: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0119 A[Catch:{ IllegalArgumentException -> 0x014e, Exception -> 0x0144 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0120 A[Catch:{ IllegalArgumentException -> 0x014e, Exception -> 0x0144 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x012c A[SYNTHETIC, Splitter:B:48:0x012c] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0154 A[Catch:{ all -> 0x0140 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x017f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a4  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap m16144a(com.meizu.media.camera.util.ThreadPool.C2638c r25, java.io.FileDescriptor r26, byte[] r27, int r28, int r29, int r30, int r31, int r32) {
        /*
            r1 = r25
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r29
            r6 = r30
            r7 = r32
            r0 = 8
            java.lang.Object[] r8 = new java.lang.Object[r0]
            r15 = 0
            r8[r15] = r1
            r14 = 1
            r8[r14] = r2
            r13 = 2
            r8[r13] = r3
            java.lang.Integer r9 = new java.lang.Integer
            r9.<init>(r4)
            r10 = 3
            r8[r10] = r9
            java.lang.Integer r9 = new java.lang.Integer
            r9.<init>(r5)
            r16 = 4
            r8[r16] = r9
            java.lang.Integer r9 = new java.lang.Integer
            r9.<init>(r6)
            r12 = 5
            r8[r12] = r9
            java.lang.Integer r9 = new java.lang.Integer
            r11 = r31
            r9.<init>(r11)
            r11 = 6
            r8[r11] = r9
            java.lang.Integer r9 = new java.lang.Integer
            r9.<init>(r7)
            r17 = 7
            r8[r17] = r9
            com.meizu.savior.ChangeQuickRedirect r18 = f14236a
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class<com.meizu.media.camera.util.aq$c> r9 = com.meizu.media.camera.util.ThreadPool.C2638c.class
            r0[r15] = r9
            java.lang.Class<java.io.FileDescriptor> r9 = java.io.FileDescriptor.class
            r0[r14] = r9
            java.lang.Class<byte[]> r9 = byte[].class
            r0[r13] = r9
            java.lang.Class r9 = java.lang.Integer.TYPE
            r0[r10] = r9
            java.lang.Class r9 = java.lang.Integer.TYPE
            r0[r16] = r9
            java.lang.Class r9 = java.lang.Integer.TYPE
            r0[r12] = r9
            java.lang.Class r9 = java.lang.Integer.TYPE
            r0[r11] = r9
            java.lang.Class r9 = java.lang.Integer.TYPE
            r0[r17] = r9
            java.lang.Class<android.graphics.Bitmap> r17 = android.graphics.Bitmap.class
            r9 = 0
            r19 = 1
            r20 = 7784(0x1e68, float:1.0908E-41)
            r10 = r18
            r11 = r19
            r12 = r20
            r13 = r0
            r0 = 1
            r14 = r17
            com.meizu.savior.PatchProxyResult r8 = com.meizu.savior.PatchProxy.proxy(r8, r9, r10, r11, r12, r13, r14)
            boolean r9 = r8.isSupported
            if (r9 == 0) goto L_0x0089
            java.lang.Object r0 = r8.result
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            return r0
        L_0x0089:
            android.graphics.BitmapFactory$Options r8 = new android.graphics.BitmapFactory$Options
            r8.<init>()
            com.meizu.media.camera.util.g$a r9 = new com.meizu.media.camera.util.g$a
            r9.<init>(r8)
            r1.mo22680a((com.meizu.media.camera.util.ThreadPool.C2636a) r9)
            r8.inJustDecodeBounds = r0
            r9 = 0
            if (r2 == 0) goto L_0x009f
            android.graphics.BitmapFactory.decodeFileDescriptor(r2, r9, r8)
            goto L_0x00a5
        L_0x009f:
            if (r3 == 0) goto L_0x00a5
            int r10 = r3.length
            android.graphics.BitmapFactory.decodeByteArray(r3, r15, r10, r8)
        L_0x00a5:
            boolean r10 = r25.mo22682b()
            if (r10 == 0) goto L_0x00ac
            return r9
        L_0x00ac:
            int r10 = r8.outWidth
            int r11 = r8.outHeight
            r14 = 6
            if (r6 != r14) goto L_0x00c3
            int r12 = r10 * r11
            if (r12 <= 0) goto L_0x00c3
            int r13 = r4 * r5
            if (r12 <= r13) goto L_0x00c3
            double r14 = (double) r13
            double r12 = (double) r12
            double r14 = r14 / r12
            double r12 = java.lang.Math.sqrt(r14)
            goto L_0x00c5
        L_0x00c3:
            r12 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        L_0x00c5:
            r8.inSampleSize = r0
            if (r4 <= 0) goto L_0x00fd
            if (r5 <= 0) goto L_0x00fd
            if (r6 != 0) goto L_0x00e8
            r14 = r4
            r15 = r5
        L_0x00cf:
            if (r10 > r14) goto L_0x00d7
            if (r11 <= r15) goto L_0x00d4
            goto L_0x00d7
        L_0x00d4:
            r9 = 0
            r14 = 2
            goto L_0x00ff
        L_0x00d7:
            int r14 = r14 * 2
            int r15 = r15 * 2
            int r9 = r8.inSampleSize
            r24 = r14
            r14 = 2
            int r9 = r9 * 2
            r8.inSampleSize = r9
            r14 = r24
            r9 = 0
            goto L_0x00cf
        L_0x00e8:
            r14 = 2
            int r9 = r4 * 2
            int r15 = r5 * 2
        L_0x00ed:
            if (r10 >= r9) goto L_0x00f1
            if (r11 < r15) goto L_0x00fe
        L_0x00f1:
            int r9 = r9 * 2
            int r15 = r15 * 2
            int r0 = r8.inSampleSize
            int r0 = r0 * 2
            r8.inSampleSize = r0
            r0 = 1
            goto L_0x00ed
        L_0x00fd:
            r14 = 2
        L_0x00fe:
            r9 = 0
        L_0x00ff:
            r8.inJustDecodeBounds = r9
            r0 = 1
            r8.inMutable = r0
            int r9 = r8.inSampleSize
            if (r9 != r0) goto L_0x0113
            com.meizu.media.camera.util.f r9 = com.meizu.media.camera.util.BitmapPool.m16137a((int) r31)
            android.graphics.Bitmap r15 = r9.mo22726a(r10, r11)
            r8.inBitmap = r15
            goto L_0x0114
        L_0x0113:
            r9 = 0
        L_0x0114:
            r1.mo22681a((int) r0)     // Catch:{ IllegalArgumentException -> 0x014e, Exception -> 0x0144 }
            if (r2 == 0) goto L_0x0120
            r15 = 0
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFileDescriptor(r2, r15, r8)     // Catch:{ IllegalArgumentException -> 0x014e, Exception -> 0x0144 }
        L_0x011e:
            r15 = r0
            goto L_0x012a
        L_0x0120:
            if (r3 == 0) goto L_0x0129
            int r0 = r3.length     // Catch:{ IllegalArgumentException -> 0x014e, Exception -> 0x0144 }
            r15 = 0
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r3, r15, r0, r8)     // Catch:{ IllegalArgumentException -> 0x014e, Exception -> 0x0144 }
            goto L_0x011e
        L_0x0129:
            r15 = 0
        L_0x012a:
            if (r9 == 0) goto L_0x013c
            android.graphics.Bitmap r0 = r8.inBitmap     // Catch:{ IllegalArgumentException -> 0x013e, Exception -> 0x013c }
            if (r0 == 0) goto L_0x013c
            android.graphics.Bitmap r0 = r8.inBitmap     // Catch:{ IllegalArgumentException -> 0x013e, Exception -> 0x013c }
            if (r0 == r15) goto L_0x013c
            android.graphics.Bitmap r0 = r8.inBitmap     // Catch:{ IllegalArgumentException -> 0x013e, Exception -> 0x013c }
            r9.mo22727a((android.graphics.Bitmap) r0)     // Catch:{ IllegalArgumentException -> 0x013e, Exception -> 0x013c }
            r14 = 0
            r8.inBitmap = r14     // Catch:{ IllegalArgumentException -> 0x013e, Exception -> 0x013c }
        L_0x013c:
            r2 = 0
            goto L_0x0146
        L_0x013e:
            r0 = move-exception
            goto L_0x0150
        L_0x0140:
            r0 = move-exception
            r2 = 0
            goto L_0x01dd
        L_0x0144:
            r2 = 0
            r15 = 0
        L_0x0146:
            r1.mo22681a((int) r2)
            r17 = r15
            r1 = 6
            r9 = 0
            goto L_0x017d
        L_0x014e:
            r0 = move-exception
            r15 = 0
        L_0x0150:
            android.graphics.Bitmap r14 = r8.inBitmap     // Catch:{ all -> 0x0140 }
            if (r14 == 0) goto L_0x01dc
            java.lang.String r0 = "Utils"
            java.lang.String r14 = "decode fail with a given bitmap, try decode to a new bitmap"
            android.util.Log.w(r0, r14)     // Catch:{ all -> 0x0140 }
            android.graphics.Bitmap r0 = r8.inBitmap     // Catch:{ all -> 0x0140 }
            r9.mo22727a((android.graphics.Bitmap) r0)     // Catch:{ all -> 0x0140 }
            r9 = 0
            r8.inBitmap = r9     // Catch:{ all -> 0x0140 }
            if (r2 == 0) goto L_0x016a
            android.graphics.Bitmap r15 = android.graphics.BitmapFactory.decodeFileDescriptor(r2, r9, r8)     // Catch:{ all -> 0x0140 }
            goto L_0x0176
        L_0x016a:
            if (r3 == 0) goto L_0x0176
            int r0 = r3.length     // Catch:{ all -> 0x0140 }
            r2 = 0
            android.graphics.Bitmap r15 = android.graphics.BitmapFactory.decodeByteArray(r3, r2, r0, r8)     // Catch:{ all -> 0x0173 }
            goto L_0x0177
        L_0x0173:
            r0 = move-exception
            goto L_0x01dd
        L_0x0176:
            r2 = 0
        L_0x0177:
            r1.mo22681a((int) r2)
            r17 = r15
            r1 = 6
        L_0x017d:
            if (r6 != r1) goto L_0x01a0
            if (r17 == 0) goto L_0x01a0
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x01a0
            double r0 = (double) r10
            double r0 = r0 * r12
            int r0 = (int) r0
            double r1 = (double) r11
            double r1 = r1 * r12
            int r1 = (int) r1
            r20 = 0
            android.graphics.Matrix$ScaleToFit r21 = android.graphics.Matrix.ScaleToFit.FILL
            r23 = 1
            r18 = r0
            r19 = r1
            r22 = r31
            android.graphics.Bitmap r0 = m16142a((android.graphics.Bitmap) r17, (int) r18, (int) r19, (int) r20, (android.graphics.Matrix.ScaleToFit) r21, (int) r22, (boolean) r23)
            goto L_0x01a2
        L_0x01a0:
            r0 = r17
        L_0x01a2:
            if (r0 == 0) goto L_0x01d8
            r1 = 2
            if (r6 < r1) goto L_0x01b7
            r1 = 5
            if (r6 > r1) goto L_0x01b8
            int r2 = r0.getWidth()
            if (r2 != r4) goto L_0x01ba
            int r2 = r0.getHeight()
            if (r2 != r5) goto L_0x01ba
            goto L_0x01b8
        L_0x01b7:
            r1 = 5
        L_0x01b8:
            if (r7 <= 0) goto L_0x01d8
        L_0x01ba:
            r2 = 2
            if (r6 < r2) goto L_0x01c2
            if (r6 <= r1) goto L_0x01c0
            goto L_0x01c2
        L_0x01c0:
            r16 = r6
        L_0x01c2:
            android.graphics.Matrix$ScaleToFit[] r1 = f14237b
            int r16 = r16 + -2
            r6 = r1[r16]
            r8 = 1
            r1 = r0
            r2 = r28
            r3 = r29
            r4 = r32
            r5 = r6
            r6 = r31
            r7 = r8
            android.graphics.Bitmap r9 = m16142a((android.graphics.Bitmap) r1, (int) r2, (int) r3, (int) r4, (android.graphics.Matrix.ScaleToFit) r5, (int) r6, (boolean) r7)
        L_0x01d8:
            if (r9 != 0) goto L_0x01db
            r9 = r0
        L_0x01db:
            return r9
        L_0x01dc:
            throw r0     // Catch:{ all -> 0x0140 }
        L_0x01dd:
            r1.mo22681a((int) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.BitmapUtils.m16144a(com.meizu.media.camera.util.aq$c, java.io.FileDescriptor, byte[], int, int, int, int, int):android.graphics.Bitmap");
    }

    /* renamed from: a */
    public static Bitmap m16142a(Bitmap bitmap, int i, int i2, int i3, Matrix.ScaleToFit scaleToFit, int i4, boolean z) {
        Bitmap bitmap2 = bitmap;
        int i5 = i;
        int i6 = i2;
        boolean z2 = z;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap2, new Integer(i5), new Integer(i6), new Integer(i3), scaleToFit, new Integer(i4), new Byte(z2 ? (byte) 1 : 0)}, (Object) null, f14236a, true, 7786, new Class[]{Bitmap.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Matrix.ScaleToFit.class, Integer.TYPE, Boolean.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        Bitmap.Config config = null;
        if (bitmap2 == null) {
            return null;
        }
        Bitmap a = BitmapPool.m16137a(i4).mo22726a(i5, i6);
        if (a != null) {
            config = a.getConfig();
        }
        if (config == null || config != Bitmap.Config.ARGB_8888) {
            a = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        }
        Bitmap bitmap3 = a;
        if (bitmap3 != null) {
            m16145a(new Canvas(bitmap3), 0, 0, i, i2, bitmap, i3, scaleToFit);
        }
        if (z2) {
            BitmapPool.m16137a(i4).mo22727a(bitmap2);
        }
        return bitmap3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00db  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m16145a(android.graphics.Canvas r20, int r21, int r22, int r23, int r24, android.graphics.Bitmap r25, int r26, android.graphics.Matrix.ScaleToFit r27) {
        /*
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = 8
            java.lang.Object[] r9 = new java.lang.Object[r8]
            r15 = 0
            r9[r15] = r0
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r1)
            r14 = 1
            r9[r14] = r10
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r2)
            r16 = 2
            r9[r16] = r10
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r3)
            r11 = 3
            r9[r11] = r10
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r4)
            r12 = 4
            r9[r12] = r10
            r10 = 5
            r9[r10] = r5
            java.lang.Integer r13 = new java.lang.Integer
            r13.<init>(r6)
            r17 = 6
            r9[r17] = r13
            r13 = 7
            r9[r13] = r7
            com.meizu.savior.ChangeQuickRedirect r18 = f14236a
            java.lang.Class[] r8 = new java.lang.Class[r8]
            java.lang.Class<android.graphics.Canvas> r19 = android.graphics.Canvas.class
            r8[r15] = r19
            java.lang.Class r19 = java.lang.Integer.TYPE
            r8[r14] = r19
            java.lang.Class r19 = java.lang.Integer.TYPE
            r8[r16] = r19
            java.lang.Class r19 = java.lang.Integer.TYPE
            r8[r11] = r19
            java.lang.Class r11 = java.lang.Integer.TYPE
            r8[r12] = r11
            java.lang.Class<android.graphics.Bitmap> r11 = android.graphics.Bitmap.class
            r8[r10] = r11
            java.lang.Class r10 = java.lang.Integer.TYPE
            r8[r17] = r10
            java.lang.Class<android.graphics.Matrix$ScaleToFit> r10 = android.graphics.Matrix.ScaleToFit.class
            r8[r13] = r10
            java.lang.Class r17 = java.lang.Void.TYPE
            r10 = 0
            r12 = 1
            r13 = 7787(0x1e6b, float:1.0912E-41)
            r11 = r18
            r14 = r8
            r8 = 0
            r15 = r17
            com.meizu.savior.PatchProxyResult r9 = com.meizu.savior.PatchProxy.proxy(r9, r10, r11, r12, r13, r14, r15)
            boolean r9 = r9.isSupported
            if (r9 == 0) goto L_0x0080
            return
        L_0x0080:
            android.graphics.Paint r9 = new android.graphics.Paint
            r9.<init>()
            r10 = 1
            r9.setAntiAlias(r10)
            r9.setFilterBitmap(r10)
            int r10 = r25.getWidth()
            int r11 = r25.getHeight()
            android.graphics.Matrix$ScaleToFit r12 = android.graphics.Matrix.ScaleToFit.FILL
            if (r7 == r12) goto L_0x00c9
            int r12 = r10 * r4
            int r13 = r3 * r11
            if (r12 <= r13) goto L_0x00ac
            float r7 = (float) r13
            float r12 = (float) r4
            float r7 = r7 / r12
            int r7 = java.lang.Math.round(r7)
            int r10 = r10 - r7
            int r15 = r10 / 2
            int r10 = r15 + r7
            r7 = 0
            goto L_0x00cb
        L_0x00ac:
            if (r12 >= r13) goto L_0x00c9
            float r12 = (float) r12
            float r13 = (float) r3
            float r12 = r12 / r13
            int r12 = java.lang.Math.round(r12)
            android.graphics.Matrix$ScaleToFit r13 = android.graphics.Matrix.ScaleToFit.START
            if (r7 != r13) goto L_0x00bb
            r11 = r12
            goto L_0x00c9
        L_0x00bb:
            android.graphics.Matrix$ScaleToFit r13 = android.graphics.Matrix.ScaleToFit.CENTER
            if (r7 != r13) goto L_0x00c6
            int r11 = r11 - r12
            int r15 = r11 / 2
            int r11 = r15 + r12
        L_0x00c4:
            r7 = r15
            goto L_0x00ca
        L_0x00c6:
            int r15 = r11 - r12
            goto L_0x00c4
        L_0x00c9:
            r7 = 0
        L_0x00ca:
            r15 = 0
        L_0x00cb:
            android.graphics.Rect r12 = new android.graphics.Rect
            r12.<init>(r15, r7, r10, r11)
            android.graphics.RectF r7 = new android.graphics.RectF
            float r1 = (float) r1
            float r2 = (float) r2
            float r3 = (float) r3
            float r4 = (float) r4
            r7.<init>(r1, r2, r3, r4)
            if (r6 <= 0) goto L_0x00f6
            r1 = -12434878(0xffffffffff424242, float:-2.5821426E38)
            r9.setColor(r1)
            r0.drawARGB(r8, r8, r8, r8)
            r1 = 0
            r9.setXfermode(r1)
            float r1 = (float) r6
            r0.drawRoundRect(r7, r1, r1, r9)
            android.graphics.PorterDuffXfermode r1 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            r1.<init>(r2)
            r9.setXfermode(r1)
        L_0x00f6:
            r0.drawBitmap(r5, r12, r7, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.util.BitmapUtils.m16145a(android.graphics.Canvas, int, int, int, int, android.graphics.Bitmap, int, android.graphics.Matrix$ScaleToFit):void");
    }

    /* renamed from: com.meizu.media.camera.util.g$a */
    /* compiled from: BitmapUtils */
    private static class C2648a implements ThreadPool.C2636a {

        /* renamed from: a */
        public static ChangeQuickRedirect f14239a;

        /* renamed from: b */
        BitmapFactory.Options f14240b;

        public C2648a(BitmapFactory.Options options) {
            this.f14240b = options;
        }

        /* renamed from: a */
        public void mo22679a() {
            if (!PatchProxy.proxy(new Object[0], this, f14239a, false, 7789, new Class[0], Void.TYPE).isSupported) {
                this.f14240b.requestCancelDecode();
            }
        }
    }

    /* renamed from: c */
    public static Bitmap m16147c(Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, (Object) null, f14236a, true, 7788, new Class[]{Bitmap.class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        Canvas canvas = new Canvas();
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(createBitmap);
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.postRotate(180.0f, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate((float) bitmap.getWidth(), 0.0f);
        canvas.drawBitmap(bitmap, matrix, (Paint) null);
        return createBitmap;
    }
}
