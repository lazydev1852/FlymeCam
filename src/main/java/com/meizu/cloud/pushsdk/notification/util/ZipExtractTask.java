package com.meizu.cloud.pushsdk.notification.util;

import com.meizu.cloud.pushinternal.DebugLogger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ZipExtractTask {
    private static final String LOG_TAG = "ZipExtractTask";
    private String mEextractedDir = this.mOutput.getAbsolutePath();
    private final File mInput;
    private final File mOutput;

    public ZipExtractTask(String str, String str2) {
        this.mInput = new File(str);
        this.mOutput = new File(str2);
        DebugLogger.m4829i(LOG_TAG, "Extract mInput file = " + this.mInput.toString());
        DebugLogger.m4829i(LOG_TAG, "Extract mOutput file = " + this.mOutput.toString());
    }

    private void deleteZipFile() {
        if (this.mInput != null && this.mInput.exists()) {
            if (this.mInput.delete()) {
                DebugLogger.m4829i(LOG_TAG, "Delete file:" + this.mInput.toString() + " after extracted.");
                return;
            }
            DebugLogger.m4829i(LOG_TAG, "Can't delete file:" + this.mInput.toString() + " after extracted.");
        }
    }

    public boolean doUnzipSync() {
        return unzip() > 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.util.zip.ZipFile] */
    /* JADX WARNING: type inference failed for: r2v9, types: [java.util.zip.ZipFile] */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v30 */
    /* JADX WARNING: type inference failed for: r2v31 */
    /* JADX WARNING: type inference failed for: r2v32 */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005d, code lost:
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0112, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0144, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0145, code lost:
        r6 = LOG_TAG;
        r7 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0183, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0184, code lost:
        r6 = LOG_TAG;
        r7 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01da, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01db, code lost:
        com.meizu.cloud.pushinternal.DebugLogger.m4828e(LOG_TAG, "Extracted IOException:" + r1.toString());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0112 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0140 A[SYNTHETIC, Splitter:B:54:0x0140] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x017f A[SYNTHETIC, Splitter:B:65:0x017f] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01d6 A[SYNTHETIC, Splitter:B:75:0x01d6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long unzip() {
        /*
            r13 = this;
            long r0 = android.os.SystemClock.currentThreadTimeMillis()
            r2 = 0
            r3 = 0
            r4 = 0
            java.util.zip.ZipFile r6 = new java.util.zip.ZipFile     // Catch:{ ZipException -> 0x0160, IOException -> 0x0121 }
            java.io.File r7 = r13.mInput     // Catch:{ ZipException -> 0x0160, IOException -> 0x0121 }
            r6.<init>(r7)     // Catch:{ ZipException -> 0x0160, IOException -> 0x0121 }
            java.util.Enumeration r7 = r6.entries()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
        L_0x0013:
            boolean r8 = r7.hasMoreElements()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            if (r8 == 0) goto L_0x00cc
            java.lang.Object r8 = r7.nextElement()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.util.zip.ZipEntry r8 = (java.util.zip.ZipEntry) r8     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            boolean r9 = r8.isDirectory()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            if (r9 == 0) goto L_0x0026
            goto L_0x0013
        L_0x0026:
            java.lang.String r9 = r8.getName()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            if (r2 != 0) goto L_0x0060
            if (r9 == 0) goto L_0x0060
            java.lang.String r10 = "/"
            java.lang.String[] r10 = r9.split(r10)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            r10 = r10[r3]     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.lang.String r2 = "ZipExtractTask"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x005c, IOException -> 0x0058, all -> 0x0112 }
            r11.<init>()     // Catch:{ ZipException -> 0x005c, IOException -> 0x0058, all -> 0x0112 }
            java.lang.String r12 = "Extract temp directory="
            r11.append(r12)     // Catch:{ ZipException -> 0x005c, IOException -> 0x0058, all -> 0x0112 }
            java.io.File r12 = r13.mOutput     // Catch:{ ZipException -> 0x005c, IOException -> 0x0058, all -> 0x0112 }
            r11.append(r12)     // Catch:{ ZipException -> 0x005c, IOException -> 0x0058, all -> 0x0112 }
            java.lang.String r12 = "/"
            r11.append(r12)     // Catch:{ ZipException -> 0x005c, IOException -> 0x0058, all -> 0x0112 }
            r11.append(r10)     // Catch:{ ZipException -> 0x005c, IOException -> 0x0058, all -> 0x0112 }
            java.lang.String r11 = r11.toString()     // Catch:{ ZipException -> 0x005c, IOException -> 0x0058, all -> 0x0112 }
            com.meizu.cloud.pushinternal.DebugLogger.m4829i(r2, r11)     // Catch:{ ZipException -> 0x005c, IOException -> 0x0058, all -> 0x0112 }
            r2 = r10
            goto L_0x0060
        L_0x0058:
            r2 = move-exception
            r7 = r2
            goto L_0x0117
        L_0x005c:
            r2 = move-exception
            r7 = r2
            goto L_0x011b
        L_0x0060:
            java.io.File r10 = new java.io.File     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.io.File r11 = r13.mOutput     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            r10.<init>(r11, r9)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.io.File r9 = r10.getParentFile()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            boolean r9 = r9.exists()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            if (r9 != 0) goto L_0x00b8
            java.io.File r9 = r10.getParentFile()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            boolean r9 = r9.mkdirs()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            if (r9 == 0) goto L_0x009a
            java.lang.String r9 = "ZipExtractTask"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            r11.<init>()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.lang.String r12 = "Make Destination directory="
            r11.append(r12)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.io.File r12 = r10.getParentFile()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.lang.String r12 = r12.getAbsolutePath()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            r11.append(r12)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.lang.String r11 = r11.toString()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            com.meizu.cloud.pushinternal.DebugLogger.m4829i(r9, r11)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            goto L_0x00b8
        L_0x009a:
            java.lang.String r9 = "ZipExtractTask"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            r11.<init>()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.lang.String r12 = "Can't make destination directory="
            r11.append(r12)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.io.File r12 = r10.getParentFile()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.lang.String r12 = r12.getAbsolutePath()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            r11.append(r12)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.lang.String r11 = r11.toString()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            com.meizu.cloud.pushinternal.DebugLogger.m4829i(r9, r11)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
        L_0x00b8:
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            r9.<init>(r10)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.io.InputStream r8 = r6.getInputStream(r8)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            int r8 = r13.copy(r8, r9)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            long r10 = (long) r8     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            long r4 = r4 + r10
            r9.close()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            goto L_0x0013
        L_0x00cc:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            r7.<init>()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.io.File r8 = r13.mOutput     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            r7.append(r8)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.lang.String r8 = "/"
            r7.append(r8)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            r7.append(r2)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.lang.String r7 = r7.toString()     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            java.lang.String r8 = r13.mEextractedDir     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            boolean r8 = r8.equals(r7)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            if (r8 != 0) goto L_0x00f0
            java.lang.String r8 = r13.mEextractedDir     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            com.meizu.cloud.pushsdk.notification.util.FileUtil.copyFolder(r7, r8)     // Catch:{ ZipException -> 0x0119, IOException -> 0x0115, all -> 0x0112 }
            r3 = 1
        L_0x00f0:
            r6.close()     // Catch:{ IOException -> 0x00f4 }
            goto L_0x010f
        L_0x00f4:
            r6 = move-exception
            java.lang.String r7 = "ZipExtractTask"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Extracted IOException:"
            r8.append(r9)
            java.lang.String r6 = r6.toString()
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r7, r6)
        L_0x010f:
            r10 = r2
            goto L_0x018c
        L_0x0112:
            r0 = move-exception
            goto L_0x01d4
        L_0x0115:
            r7 = move-exception
            r10 = r2
        L_0x0117:
            r2 = r6
            goto L_0x0124
        L_0x0119:
            r7 = move-exception
            r10 = r2
        L_0x011b:
            r2 = r6
            goto L_0x0163
        L_0x011d:
            r0 = move-exception
            r6 = r2
            goto L_0x01d4
        L_0x0121:
            r6 = move-exception
            r10 = r2
            r7 = r6
        L_0x0124:
            java.lang.String r6 = "ZipExtractTask"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
            r8.<init>()     // Catch:{ all -> 0x011d }
            java.lang.String r9 = "Extracted IOException:"
            r8.append(r9)     // Catch:{ all -> 0x011d }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x011d }
            r8.append(r7)     // Catch:{ all -> 0x011d }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x011d }
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r6, r7)     // Catch:{ all -> 0x011d }
            if (r2 == 0) goto L_0x018c
            r2.close()     // Catch:{ IOException -> 0x0144 }
            goto L_0x018c
        L_0x0144:
            r2 = move-exception
            java.lang.String r6 = "ZipExtractTask"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
        L_0x014c:
            java.lang.String r8 = "Extracted IOException:"
            r7.append(r8)
            java.lang.String r2 = r2.toString()
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r6, r2)
            goto L_0x018c
        L_0x0160:
            r6 = move-exception
            r10 = r2
            r7 = r6
        L_0x0163:
            java.lang.String r6 = "ZipExtractTask"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
            r8.<init>()     // Catch:{ all -> 0x011d }
            java.lang.String r9 = "ZipException :"
            r8.append(r9)     // Catch:{ all -> 0x011d }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x011d }
            r8.append(r7)     // Catch:{ all -> 0x011d }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x011d }
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r6, r7)     // Catch:{ all -> 0x011d }
            if (r2 == 0) goto L_0x018c
            r2.close()     // Catch:{ IOException -> 0x0183 }
            goto L_0x018c
        L_0x0183:
            r2 = move-exception
            java.lang.String r6 = "ZipExtractTask"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            goto L_0x014c
        L_0x018c:
            long r6 = android.os.SystemClock.currentThreadTimeMillis()
            java.lang.String r2 = "ZipExtractTask"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Extract file "
            r8.append(r9)
            java.io.File r9 = r13.mInput
            r8.append(r9)
            java.lang.String r9 = ", UseTime ="
            r8.append(r9)
            long r6 = r6 - r0
            java.lang.String r0 = java.lang.String.valueOf(r6)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            com.meizu.cloud.pushinternal.DebugLogger.m4829i(r2, r0)
            if (r3 == 0) goto L_0x01d0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r1 = r13.mOutput
            r0.append(r1)
            java.lang.String r1 = "/"
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            com.meizu.cloud.pushsdk.notification.util.FileUtil.deleteDirectory(r0)
        L_0x01d0:
            r13.deleteZipFile()
            return r4
        L_0x01d4:
            if (r6 == 0) goto L_0x01f5
            r6.close()     // Catch:{ IOException -> 0x01da }
            goto L_0x01f5
        L_0x01da:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Extracted IOException:"
            r2.append(r3)
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "ZipExtractTask"
            com.meizu.cloud.pushinternal.DebugLogger.m4828e(r2, r1)
        L_0x01f5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.notification.util.ZipExtractTask.unzip():long");
    }

    private int copy(InputStream inputStream, OutputStream outputStream) {
        String str;
        StringBuilder sb;
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 8192);
        int i = 0;
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr, 0, 8192);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
            } catch (IOException e) {
                DebugLogger.m4828e(LOG_TAG, "Extracted IOException:" + e.toString());
                try {
                    bufferedOutputStream.close();
                } catch (IOException e2) {
                    DebugLogger.m4828e(LOG_TAG, "out.close() IOException e=" + e2.toString());
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e3) {
                    e = e3;
                    str = LOG_TAG;
                    sb = new StringBuilder();
                }
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e4) {
                    DebugLogger.m4828e(LOG_TAG, "out.close() IOException e=" + e4.toString());
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e5) {
                    DebugLogger.m4828e(LOG_TAG, "in.close() IOException e=" + e5.toString());
                }
                throw th;
            }
        }
        bufferedOutputStream.flush();
        try {
            bufferedOutputStream.close();
        } catch (IOException e6) {
            DebugLogger.m4828e(LOG_TAG, "out.close() IOException e=" + e6.toString());
        }
        try {
            bufferedInputStream.close();
        } catch (IOException e7) {
            e = e7;
            str = LOG_TAG;
            sb = new StringBuilder();
        }
        return i;
        sb.append("in.close() IOException e=");
        sb.append(e.toString());
        DebugLogger.m4828e(str, sb.toString());
        return i;
    }
}
