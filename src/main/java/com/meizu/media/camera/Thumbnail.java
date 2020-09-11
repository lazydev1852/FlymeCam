package com.meizu.media.camera;

import android.graphics.Bitmap;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.FileDescriptor;

/* renamed from: com.meizu.media.camera.ab */
public class Thumbnail {

    /* renamed from: a */
    public static ChangeQuickRedirect f7505a;

    /* renamed from: a */
    public static Bitmap m7940a(FileDescriptor fileDescriptor, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{fileDescriptor, new Integer(i)}, (Object) null, f7505a, true, 2226, new Class[]{FileDescriptor.class, Integer.TYPE}, Bitmap.class);
        return proxy.isSupported ? (Bitmap) proxy.result : m7942a((String) null, fileDescriptor, i, new long[0]);
    }

    /* renamed from: a */
    public static Bitmap m7941a(String str, int i, long... jArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str, new Integer(i), jArr}, (Object) null, f7505a, true, 2227, new Class[]{String.class, Integer.TYPE, long[].class}, Bitmap.class);
        return proxy.isSupported ? (Bitmap) proxy.result : m7942a(str, (FileDescriptor) null, i, jArr);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0078 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap m7942a(java.lang.String r10, java.io.FileDescriptor r11, int r12, long... r13) {
        /*
            r0 = 4
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            r9 = 1
            r1[r9] = r11
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r12)
            r3 = 2
            r1[r3] = r2
            r2 = 3
            r1[r2] = r13
            com.meizu.savior.ChangeQuickRedirect r4 = f7505a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r8] = r0
            java.lang.Class<java.io.FileDescriptor> r0 = java.io.FileDescriptor.class
            r6[r9] = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            r6[r3] = r0
            java.lang.Class<long[]> r0 = long[].class
            r6[r2] = r0
            java.lang.Class<android.graphics.Bitmap> r7 = android.graphics.Bitmap.class
            r2 = 0
            r0 = 1
            r5 = 2228(0x8b4, float:3.122E-42)
            r3 = r4
            r4 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x003d
            java.lang.Object r10 = r0.result
            android.graphics.Bitmap r10 = (android.graphics.Bitmap) r10
            return r10
        L_0x003d:
            r0 = -1
            if (r13 == 0) goto L_0x0046
            int r2 = r13.length
            if (r2 <= 0) goto L_0x0046
            r0 = r13[r8]
        L_0x0046:
            android.media.MediaMetadataRetriever r13 = new android.media.MediaMetadataRetriever
            r13.<init>()
            r2 = 0
            if (r10 == 0) goto L_0x0069
            java.io.File r11 = new java.io.File     // Catch:{ IllegalArgumentException | RuntimeException -> 0x0078, all -> 0x0067 }
            r11.<init>(r10)     // Catch:{ IllegalArgumentException | RuntimeException -> 0x0078, all -> 0x0067 }
            boolean r11 = r11.exists()     // Catch:{ IllegalArgumentException | RuntimeException -> 0x0078, all -> 0x0067 }
            if (r11 != 0) goto L_0x0063
            java.lang.String r11 = "."
            int r11 = r10.lastIndexOf(r11)     // Catch:{ IllegalArgumentException | RuntimeException -> 0x0078, all -> 0x0067 }
            java.lang.String r10 = r10.substring(r8, r11)     // Catch:{ IllegalArgumentException | RuntimeException -> 0x0078, all -> 0x0067 }
        L_0x0063:
            r13.setDataSource(r10)     // Catch:{ IllegalArgumentException | RuntimeException -> 0x0078, all -> 0x0067 }
            goto L_0x006c
        L_0x0067:
            r10 = move-exception
            goto L_0x0074
        L_0x0069:
            r13.setDataSource(r11)     // Catch:{ IllegalArgumentException | RuntimeException -> 0x0078, all -> 0x0067 }
        L_0x006c:
            android.graphics.Bitmap r10 = r13.getFrameAtTime(r0)     // Catch:{ IllegalArgumentException | RuntimeException -> 0x0078, all -> 0x0067 }
            r13.release()     // Catch:{ RuntimeException -> 0x007c }
            goto L_0x007c
        L_0x0074:
            r13.release()     // Catch:{ RuntimeException -> 0x0077 }
        L_0x0077:
            throw r10
        L_0x0078:
            r13.release()     // Catch:{ RuntimeException -> 0x007b }
        L_0x007b:
            r10 = r2
        L_0x007c:
            if (r10 != 0) goto L_0x007f
            return r2
        L_0x007f:
            int r11 = r10.getWidth()
            int r13 = r10.getHeight()
            if (r11 <= r12) goto L_0x009d
            float r12 = (float) r12
            float r11 = (float) r11
            float r12 = r12 / r11
            float r11 = r11 * r12
            int r11 = java.lang.Math.round(r11)
            float r13 = (float) r13
            float r12 = r12 * r13
            int r12 = java.lang.Math.round(r12)
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createScaledBitmap(r10, r11, r12, r9)
        L_0x009d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.Thumbnail.m7942a(java.lang.String, java.io.FileDescriptor, int, long[]):android.graphics.Bitmap");
    }
}
