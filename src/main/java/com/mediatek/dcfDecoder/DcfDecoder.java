package com.mediatek.dcfdecoder;

import android.os.SystemProperties;
import android.util.Log;
import java.io.FileDescriptor;

public class DcfDecoder {
    private static final int ACTION_DECODE_FULL_IMAGE = 0;
    private static final int ACTION_JUST_DECODE_BOUND = 1;
    private static final int ACTION_JUST_DECODE_THUMBNAIL = 2;
    private static final int DECODE_THUMBNAIL_FLAG = 256;
    private static final int HEADER_BUFFER_SIZE = 128;
    private static final String TAG = "DRM/DcfDecoder";
    private static final int THUMBNAIL_TARGET_SIZE = 96;
    private static boolean sIsOmaDrmEnabled = SystemProperties.getBoolean("ro.mtk_oma_drm_support", false);

    private static native byte[] nativeDecryptDcfFile(FileDescriptor fileDescriptor, int i, int i2);

    private native byte[] nativeForceDecryptFile(String str, boolean z);

    static {
        if (sIsOmaDrmEnabled) {
            System.loadLibrary("dcfdecoderjni");
        }
    }

    public byte[] forceDecryptFile(String str, boolean z) {
        if (str != null) {
            return nativeForceDecryptFile(str, z);
        }
        Log.e(TAG, "forceDecryptFile: find null file name!");
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap decodeDrmImageIfNeeded(byte[] r7, java.io.InputStream r8, android.graphics.BitmapFactory.Options r9) {
        /*
            boolean r0 = sIsOmaDrmEnabled
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            if (r9 == 0) goto L_0x0015
            boolean r0 = r9.inJustDecodeBounds
            if (r0 == 0) goto L_0x0015
            int r0 = r9.outWidth
            if (r0 <= 0) goto L_0x0015
            int r0 = r9.outHeight
            if (r0 <= 0) goto L_0x0015
            return r1
        L_0x0015:
            java.lang.String r0 = "DRM/DcfDecoder"
            java.lang.String r2 = "decodeDrmImageIfNeeded with stream"
            android.util.Log.d(r0, r2)
            if (r7 != 0) goto L_0x001f
            return r1
        L_0x001f:
            r0 = 0
            byte r2 = r7[r0]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 1
            byte r4 = r7[r3]
            int r4 = r4 << 8
            r5 = 65280(0xff00, float:9.1477E-41)
            r4 = r4 & r5
            r2 = r2 | r4
            java.lang.String r4 = "DRM/DcfDecoder"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "decodeDrmImageIfNeeded: ["
            r5.append(r6)
            byte r6 = r7[r0]
            r5.append(r6)
            java.lang.String r6 = "]["
            r5.append(r6)
            byte r3 = r7[r3]
            r5.append(r3)
            java.lang.String r3 = "]["
            r5.append(r3)
            r3 = 2
            byte r6 = r7[r3]
            r5.append(r6)
            java.lang.String r6 = "]["
            r5.append(r6)
            r6 = 3
            byte r6 = r7[r6]
            r5.append(r6)
            java.lang.String r6 = "]["
            r5.append(r6)
            r6 = 4
            byte r6 = r7[r6]
            r5.append(r6)
            java.lang.String r6 = "]"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r4, r5)
            java.lang.String r4 = "DRM/DcfDecoder"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "decodeDrmImageIfNeeded: headerSize = "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r4, r5)
            r4 = 128(0x80, float:1.794E-43)
            if (r2 >= r4) goto L_0x00a5
            byte[] r5 = new byte[r4]
            java.lang.System.arraycopy(r7, r3, r5, r0, r2)
            int r7 = 128 - r2
            r8.read(r5, r2, r7)     // Catch:{ IOException -> 0x009c }
            r7 = r5
            goto L_0x00a5
        L_0x009c:
            r7 = move-exception
            java.lang.String r8 = "DRM/DcfDecoder"
            java.lang.String r9 = "decodeDrmImageIfNeeded read header with "
            android.util.Log.e(r8, r9, r7)
            return r1
        L_0x00a5:
            boolean r2 = isDrmFile(r7)
            if (r2 != 0) goto L_0x00ac
            return r1
        L_0x00ac:
            boolean r2 = r8 instanceof java.io.FileInputStream     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            if (r2 == 0) goto L_0x00bb
            java.io.FileInputStream r8 = (java.io.FileInputStream) r8     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            java.io.FileDescriptor r7 = r8.getFD()     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            android.graphics.Bitmap r7 = decodeDrmImage(r7, r0, r9)     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            goto L_0x00e0
        L_0x00bb:
            int r2 = r8.available()     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            android.os.MemoryFile r3 = new android.os.MemoryFile     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            java.lang.String r5 = "drm_image"
            int r6 = r2 + 128
            r3.<init>(r5, r6)     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            r3.writeBytes(r7, r0, r0, r4)     // Catch:{ IOException -> 0x00e6 }
            byte[] r7 = new byte[r2]     // Catch:{ IOException -> 0x00e6 }
            r8.read(r7)     // Catch:{ IOException -> 0x00e6 }
            r3.writeBytes(r7, r0, r4, r2)     // Catch:{ IOException -> 0x00e6 }
            java.io.FileDescriptor r7 = r3.getFileDescriptor()     // Catch:{ IOException -> 0x00e6 }
            int r8 = r3.length()     // Catch:{ IOException -> 0x00e6 }
            android.graphics.Bitmap r7 = decodeDrmImage(r7, r8, r9)     // Catch:{ IOException -> 0x00e6 }
            r1 = r3
        L_0x00e0:
            if (r1 == 0) goto L_0x00fa
            r1.close()
            goto L_0x00fa
        L_0x00e6:
            r7 = move-exception
            goto L_0x00ed
        L_0x00e8:
            r7 = move-exception
            r3 = r1
            goto L_0x00fc
        L_0x00eb:
            r7 = move-exception
            r3 = r1
        L_0x00ed:
            java.lang.String r8 = "DRM/DcfDecoder"
            java.lang.String r9 = "decodeDrmImageIfNeeded with "
            android.util.Log.e(r8, r9, r7)     // Catch:{ all -> 0x00fb }
            if (r3 == 0) goto L_0x00f9
            r3.close()
        L_0x00f9:
            r7 = r1
        L_0x00fa:
            return r7
        L_0x00fb:
            r7 = move-exception
        L_0x00fc:
            if (r3 == 0) goto L_0x0101
            r3.close()
        L_0x0101:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mediatek.dcfdecoder.DcfDecoder.decodeDrmImageIfNeeded(byte[], java.io.InputStream, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0071 A[SYNTHETIC, Splitter:B:42:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0084 A[SYNTHETIC, Splitter:B:51:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0098 A[SYNTHETIC, Splitter:B:59:0x0098] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap decodeDrmImageIfNeeded(java.io.FileDescriptor r9, android.graphics.BitmapFactory.Options r10) {
        /*
            boolean r0 = sIsOmaDrmEnabled
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            if (r10 == 0) goto L_0x0015
            boolean r0 = r10.inJustDecodeBounds
            if (r0 == 0) goto L_0x0015
            int r0 = r10.outWidth
            if (r0 <= 0) goto L_0x0015
            int r0 = r10.outHeight
            if (r0 <= 0) goto L_0x0015
            return r1
        L_0x0015:
            java.lang.String r0 = "DRM/DcfDecoder"
            java.lang.String r2 = "decodeDrmImageIfNeeded with fd"
            android.util.Log.d(r0, r2)
            r2 = -1
            int r0 = android.system.OsConstants.SEEK_CUR     // Catch:{ ErrnoException -> 0x0077, IOException -> 0x0064, all -> 0x0061 }
            r4 = 0
            long r6 = android.system.Os.lseek(r9, r4, r0)     // Catch:{ ErrnoException -> 0x0077, IOException -> 0x0064, all -> 0x0061 }
            int r0 = android.system.OsConstants.SEEK_SET     // Catch:{ ErrnoException -> 0x005f, IOException -> 0x005d }
            android.system.Os.lseek(r9, r4, r0)     // Catch:{ ErrnoException -> 0x005f, IOException -> 0x005d }
            r0 = 128(0x80, float:1.794E-43)
            byte[] r4 = new byte[r0]     // Catch:{ ErrnoException -> 0x005f, IOException -> 0x005d }
            r5 = 0
            int r8 = libcore.io.IoBridge.read(r9, r4, r5, r0)     // Catch:{ ErrnoException -> 0x005f, IOException -> 0x005d }
            if (r8 != r0) goto L_0x0053
            boolean r0 = isDrmFile(r4)     // Catch:{ ErrnoException -> 0x005f, IOException -> 0x005d }
            if (r0 == 0) goto L_0x0053
            android.graphics.Bitmap r10 = decodeDrmImage(r9, r5, r10)     // Catch:{ ErrnoException -> 0x005f, IOException -> 0x005d }
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0052
            int r0 = android.system.OsConstants.SEEK_SET     // Catch:{ ErrnoException -> 0x004a }
            android.system.Os.lseek(r9, r6, r0)     // Catch:{ ErrnoException -> 0x004a }
            goto L_0x0052
        L_0x004a:
            r9 = move-exception
            java.lang.String r0 = "DRM/DcfDecoder"
            java.lang.String r1 = "decodeDrmImageIfNeeded seek fd to initial offset with "
            android.util.Log.e(r0, r1, r9)
        L_0x0052:
            return r10
        L_0x0053:
            int r10 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r10 == 0) goto L_0x0092
            int r10 = android.system.OsConstants.SEEK_SET     // Catch:{ ErrnoException -> 0x008a }
            android.system.Os.lseek(r9, r6, r10)     // Catch:{ ErrnoException -> 0x008a }
            goto L_0x0092
        L_0x005d:
            r10 = move-exception
            goto L_0x0066
        L_0x005f:
            r10 = move-exception
            goto L_0x0079
        L_0x0061:
            r10 = move-exception
            r6 = r2
            goto L_0x0094
        L_0x0064:
            r10 = move-exception
            r6 = r2
        L_0x0066:
            java.lang.String r0 = "DRM/DcfDecoder"
            java.lang.String r4 = "decodeDrmImageIfNeeded get header with "
            android.util.Log.e(r0, r4, r10)     // Catch:{ all -> 0x0093 }
            int r10 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r10 == 0) goto L_0x0092
            int r10 = android.system.OsConstants.SEEK_SET     // Catch:{ ErrnoException -> 0x008a }
            android.system.Os.lseek(r9, r6, r10)     // Catch:{ ErrnoException -> 0x008a }
            goto L_0x0092
        L_0x0077:
            r10 = move-exception
            r6 = r2
        L_0x0079:
            java.lang.String r0 = "DRM/DcfDecoder"
            java.lang.String r4 = "decodeDrmImageIfNeeded seek fd to beginning with "
            android.util.Log.e(r0, r4, r10)     // Catch:{ all -> 0x0093 }
            int r10 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r10 == 0) goto L_0x0092
            int r10 = android.system.OsConstants.SEEK_SET     // Catch:{ ErrnoException -> 0x008a }
            android.system.Os.lseek(r9, r6, r10)     // Catch:{ ErrnoException -> 0x008a }
            goto L_0x0092
        L_0x008a:
            r9 = move-exception
            java.lang.String r10 = "DRM/DcfDecoder"
            java.lang.String r0 = "decodeDrmImageIfNeeded seek fd to initial offset with "
            android.util.Log.e(r10, r0, r9)
        L_0x0092:
            return r1
        L_0x0093:
            r10 = move-exception
        L_0x0094:
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00a6
            int r0 = android.system.OsConstants.SEEK_SET     // Catch:{ ErrnoException -> 0x009e }
            android.system.Os.lseek(r9, r6, r0)     // Catch:{ ErrnoException -> 0x009e }
            goto L_0x00a6
        L_0x009e:
            r9 = move-exception
            java.lang.String r0 = "DRM/DcfDecoder"
            java.lang.String r1 = "decodeDrmImageIfNeeded seek fd to initial offset with "
            android.util.Log.e(r0, r1, r9)
        L_0x00a6:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mediatek.dcfdecoder.DcfDecoder.decodeDrmImageIfNeeded(java.io.FileDescriptor, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap decodeDrmImageIfNeeded(byte[] r4, android.graphics.BitmapFactory.Options r5) {
        /*
            boolean r0 = sIsOmaDrmEnabled
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            if (r5 == 0) goto L_0x0015
            boolean r0 = r5.inJustDecodeBounds
            if (r0 == 0) goto L_0x0015
            int r0 = r5.outWidth
            if (r0 <= 0) goto L_0x0015
            int r0 = r5.outHeight
            if (r0 <= 0) goto L_0x0015
            return r1
        L_0x0015:
            java.lang.String r0 = "DRM/DcfDecoder"
            java.lang.String r2 = "decodeDrmImageIfNeeded with data"
            android.util.Log.d(r0, r2)
            boolean r0 = isDrmFile(r4)
            if (r0 != 0) goto L_0x0023
            return r1
        L_0x0023:
            android.os.MemoryFile r0 = new android.os.MemoryFile     // Catch:{ IOException -> 0x0045, all -> 0x0042 }
            java.lang.String r2 = "drm_image"
            int r3 = r4.length     // Catch:{ IOException -> 0x0045, all -> 0x0042 }
            r0.<init>(r2, r3)     // Catch:{ IOException -> 0x0045, all -> 0x0042 }
            int r2 = r4.length     // Catch:{ IOException -> 0x0040 }
            r3 = 0
            r0.writeBytes(r4, r3, r3, r2)     // Catch:{ IOException -> 0x0040 }
            java.io.FileDescriptor r4 = r0.getFileDescriptor()     // Catch:{ IOException -> 0x0040 }
            int r2 = r0.length()     // Catch:{ IOException -> 0x0040 }
            android.graphics.Bitmap r4 = decodeDrmImage(r4, r2, r5)     // Catch:{ IOException -> 0x0040 }
            r0.close()
            goto L_0x0054
        L_0x0040:
            r4 = move-exception
            goto L_0x0047
        L_0x0042:
            r4 = move-exception
            r0 = r1
            goto L_0x0056
        L_0x0045:
            r4 = move-exception
            r0 = r1
        L_0x0047:
            java.lang.String r5 = "DRM/DcfDecoder"
            java.lang.String r2 = "decodeDrmImageIfNeeded with "
            android.util.Log.e(r5, r2, r4)     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0053
            r0.close()
        L_0x0053:
            r4 = r1
        L_0x0054:
            return r4
        L_0x0055:
            r4 = move-exception
        L_0x0056:
            if (r0 == 0) goto L_0x005b
            r0.close()
        L_0x005b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mediatek.dcfdecoder.DcfDecoder.decodeDrmImageIfNeeded(byte[], android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap decodeDrmImage(java.io.FileDescriptor r4, int r5, android.graphics.BitmapFactory.Options r6) {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            if (r6 == 0) goto L_0x0013
            boolean r3 = r6.inJustDecodeBounds
            if (r3 == 0) goto L_0x000b
            r3 = 1
            goto L_0x0014
        L_0x000b:
            int r3 = r6.inSampleSize
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 <= 0) goto L_0x0013
            r3 = 2
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            byte[] r4 = nativeDecryptDcfFile(r4, r5, r3)
            if (r4 != 0) goto L_0x001c
            r4 = 0
            return r4
        L_0x001c:
            if (r3 != r0) goto L_0x0037
            android.graphics.BitmapFactory$Options r5 = new android.graphics.BitmapFactory$Options
            r5.<init>()
            r5.inJustDecodeBounds = r1
            int r0 = r4.length
            android.graphics.BitmapFactory.decodeByteArray(r4, r2, r0, r5)
            int r0 = r5.outHeight
            int r5 = r5.outWidth
            int r5 = r5 / 96
            int r0 = r0 / 96
            int r5 = java.lang.Math.min(r5, r0)
            r6.inSampleSize = r5
        L_0x0037:
            int r5 = r4.length
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeByteArray(r4, r2, r5, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mediatek.dcfdecoder.DcfDecoder.decodeDrmImage(java.io.FileDescriptor, int, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    private static boolean isDrmFile(byte[] bArr) {
        if (bArr == null || bArr.length < 128) {
            return false;
        }
        String str = new String(bArr, 0, 8);
        if (str.startsWith("CTA5")) {
            Log.d(TAG, "isDrmFile: this is a cta5 file: " + str);
            return true;
        } else if (bArr[0] != 1) {
            Log.d(TAG, "isDrmFile: version is not dcf version 1, no oma drm file");
            return false;
        } else {
            byte b = bArr[1];
            byte b2 = bArr[2];
            if (b <= 0 || b + 3 > 128 || b2 <= 0 || b2 > 128) {
                Log.d(TAG, "isDrmFile: content type or uri len invalid, not oma drm file, contentType[" + b + "] contentUri[" + b2 + "]");
                return false;
            }
            String str2 = new String(bArr, 3, b);
            if (!str2.contains("/")) {
                Log.d(TAG, "isDrmFile: content type not right, not oma drm file");
                return false;
            }
            Log.d(TAG, "this is a oma drm file: " + str2);
            return true;
        }
    }
}
