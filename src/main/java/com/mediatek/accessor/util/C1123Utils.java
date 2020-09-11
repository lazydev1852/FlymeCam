package com.mediatek.accessor.util;

import android.os.Environment;
import java.io.File;

/* renamed from: com.mediatek.accessor.util.Utils */
public class C1123Utils {
    public static final String DUMP_FILE_FOLDER = (Environment.getExternalStorageDirectory().toString() + "/dumpJps");
    public static boolean ENABLE_BUFFER_DUMP;
    public static boolean REGEN_DEPTH;
    private static final String REGEN_DEPTH_CFG = (Environment.getExternalStorageDirectory().toString() + "/regen");
    private static final String TAG = Log.Tag(C1123Utils.class.getSimpleName());
    public static boolean XMP_DEBUG_LOG;
    private static final String XMP_LOG_CFG = (Environment.getExternalStorageDirectory().toString() + "/xmplog");

    static {
        ENABLE_BUFFER_DUMP = false;
        REGEN_DEPTH = false;
        XMP_DEBUG_LOG = false;
        if (new File(DUMP_FILE_FOLDER).exists()) {
            ENABLE_BUFFER_DUMP = true;
            String str = TAG;
            Log.m3997i(str, "ENABLE_BUFFER_DUMP: " + ENABLE_BUFFER_DUMP);
        }
        if (new File(REGEN_DEPTH_CFG).exists()) {
            REGEN_DEPTH = true;
            String str2 = TAG;
            Log.m3997i(str2, "REGEN_DEPTH: " + REGEN_DEPTH);
        }
        if (new File(XMP_LOG_CFG).exists()) {
            XMP_DEBUG_LOG = true;
            String str3 = TAG;
            Log.m3997i(str3, "XMP_DEBUG_LOG: " + XMP_DEBUG_LOG);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064 A[SYNTHETIC, Splitter:B:21:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074 A[SYNTHETIC, Splitter:B:28:0x0074] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFileToBuffer(java.lang.String r4) {
        /*
            java.lang.String r0 = ">>>>Utils-readFileToBuffer"
            com.mediatek.accessor.util.TraceHelper.beginSection(r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r1 = r0.exists()
            r2 = 0
            if (r1 != 0) goto L_0x0030
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "<readFileToBuffer> "
            r1.append(r3)
            r1.append(r4)
            java.lang.String r4 = " not exists!!!"
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            com.mediatek.accessor.util.Log.m3993d(r0, r4)
            com.mediatek.accessor.util.TraceHelper.endSection()
            return r2
        L_0x0030:
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0056, all -> 0x0053 }
            java.lang.String r1 = "r"
            r4.<init>(r0, r1)     // Catch:{ IOException -> 0x0056, all -> 0x0053 }
            long r0 = r0.length()     // Catch:{ IOException -> 0x0051 }
            int r0 = (int) r0     // Catch:{ IOException -> 0x0051 }
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x0051 }
            r4.read(r0)     // Catch:{ IOException -> 0x0051 }
            com.mediatek.accessor.util.TraceHelper.endSection()     // Catch:{ IOException -> 0x0051 }
            r4.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x0050
        L_0x0048:
            r4 = move-exception
            java.lang.String r1 = TAG
            java.lang.String r2 = "<readFileToBuffer> close IOException "
            com.mediatek.accessor.util.Log.m3996e(r1, r2, r4)
        L_0x0050:
            return r0
        L_0x0051:
            r0 = move-exception
            goto L_0x0058
        L_0x0053:
            r0 = move-exception
            r4 = r2
            goto L_0x0072
        L_0x0056:
            r0 = move-exception
            r4 = r2
        L_0x0058:
            java.lang.String r1 = TAG     // Catch:{ all -> 0x0071 }
            java.lang.String r3 = "<readFileToBuffer> Exception "
            com.mediatek.accessor.util.Log.m3996e(r1, r3, r0)     // Catch:{ all -> 0x0071 }
            com.mediatek.accessor.util.TraceHelper.endSection()     // Catch:{ all -> 0x0071 }
            if (r4 == 0) goto L_0x0070
            r4.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x0070
        L_0x0068:
            r4 = move-exception
            java.lang.String r0 = TAG
            java.lang.String r1 = "<readFileToBuffer> close IOException "
            com.mediatek.accessor.util.Log.m3996e(r0, r1, r4)
        L_0x0070:
            return r2
        L_0x0071:
            r0 = move-exception
        L_0x0072:
            if (r4 == 0) goto L_0x0080
            r4.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x0080
        L_0x0078:
            r4 = move-exception
            java.lang.String r1 = TAG
            java.lang.String r2 = "<readFileToBuffer> close IOException "
            com.mediatek.accessor.util.Log.m3996e(r1, r2, r4)
        L_0x0080:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mediatek.accessor.util.C1123Utils.readFileToBuffer(java.lang.String):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x007c A[SYNTHETIC, Splitter:B:36:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008b A[SYNTHETIC, Splitter:B:42:0x008b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean writeBufferToFile(java.lang.String r3, byte[] r4) {
        /*
            java.lang.String r0 = ">>>>Utils-writeBufferToFile"
            com.mediatek.accessor.util.TraceHelper.beginSection(r0)
            r0 = 0
            if (r3 != 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.String r1 = "/"
            int r1 = r3.lastIndexOf(r1)
            java.lang.String r1 = r3.substring(r0, r1)
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r1 = r2.exists()
            if (r1 != 0) goto L_0x0021
            r2.mkdir()
        L_0x0021:
            if (r4 != 0) goto L_0x002e
            java.lang.String r3 = TAG
            java.lang.String r4 = "<writeBufferToFile> buffer is null"
            com.mediatek.accessor.util.Log.m3993d(r3, r4)
            com.mediatek.accessor.util.TraceHelper.endSection()
            return r0
        L_0x002e:
            java.io.File r1 = new java.io.File
            r1.<init>(r3)
            boolean r3 = r1.exists()
            if (r3 == 0) goto L_0x003c
            r1.delete()
        L_0x003c:
            r3 = 0
            boolean r2 = r1.createNewFile()     // Catch:{ IOException -> 0x006f }
            if (r2 != 0) goto L_0x004e
            java.lang.String r4 = TAG     // Catch:{ IOException -> 0x006f }
            java.lang.String r1 = "<writeBufferToFile> createNewFile error"
            com.mediatek.accessor.util.Log.m3993d(r4, r1)     // Catch:{ IOException -> 0x006f }
            com.mediatek.accessor.util.TraceHelper.endSection()     // Catch:{ IOException -> 0x006f }
            return r0
        L_0x004e:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x006f }
            r2.<init>(r1)     // Catch:{ IOException -> 0x006f }
            r2.write(r4)     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            com.mediatek.accessor.util.TraceHelper.endSection()     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            r3 = 1
            r2.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0066
        L_0x005e:
            r4 = move-exception
            java.lang.String r0 = TAG
            java.lang.String r1 = "<writeBufferToFile> close, IOException"
            com.mediatek.accessor.util.Log.m3996e(r0, r1, r4)
        L_0x0066:
            return r3
        L_0x0067:
            r4 = move-exception
            r3 = r2
            goto L_0x0089
        L_0x006a:
            r4 = move-exception
            r3 = r2
            goto L_0x0070
        L_0x006d:
            r4 = move-exception
            goto L_0x0089
        L_0x006f:
            r4 = move-exception
        L_0x0070:
            java.lang.String r1 = TAG     // Catch:{ all -> 0x006d }
            java.lang.String r2 = "<writeBufferToFile> IOException"
            com.mediatek.accessor.util.Log.m3996e(r1, r2, r4)     // Catch:{ all -> 0x006d }
            com.mediatek.accessor.util.TraceHelper.endSection()     // Catch:{ all -> 0x006d }
            if (r3 == 0) goto L_0x0088
            r3.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0088
        L_0x0080:
            r3 = move-exception
            java.lang.String r4 = TAG
            java.lang.String r1 = "<writeBufferToFile> close, IOException"
            com.mediatek.accessor.util.Log.m3996e(r4, r1, r3)
        L_0x0088:
            return r0
        L_0x0089:
            if (r3 == 0) goto L_0x0097
            r3.close()     // Catch:{ IOException -> 0x008f }
            goto L_0x0097
        L_0x008f:
            r3 = move-exception
            java.lang.String r0 = TAG
            java.lang.String r1 = "<writeBufferToFile> close, IOException"
            com.mediatek.accessor.util.Log.m3996e(r0, r1, r3)
        L_0x0097:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mediatek.accessor.util.C1123Utils.writeBufferToFile(java.lang.String, byte[]):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeStringToFile(java.lang.String r2, java.lang.String r3) {
        /*
            if (r3 != 0) goto L_0x000a
            java.lang.String r2 = TAG
            java.lang.String r3 = "<writeStringToFile> input string is null, return!!!"
            com.mediatek.accessor.util.Log.m3993d(r2, r3)
            return
        L_0x000a:
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            r2 = 0
            boolean r1 = r0.exists()     // Catch:{ IOException -> 0x003e }
            if (r1 == 0) goto L_0x0019
            r0.delete()     // Catch:{ IOException -> 0x003e }
        L_0x0019:
            boolean r1 = r0.createNewFile()     // Catch:{ IOException -> 0x003e }
            if (r1 != 0) goto L_0x0027
            java.lang.String r3 = TAG     // Catch:{ IOException -> 0x003e }
            java.lang.String r0 = "<writeStringToFile> createNewFile error"
            com.mediatek.accessor.util.Log.m3993d(r3, r0)     // Catch:{ IOException -> 0x003e }
            return
        L_0x0027:
            java.io.PrintStream r1 = new java.io.PrintStream     // Catch:{ IOException -> 0x003e }
            r1.<init>(r0)     // Catch:{ IOException -> 0x003e }
            r1.println(r3)     // Catch:{ IOException -> 0x0039, all -> 0x0036 }
            r1.flush()     // Catch:{ IOException -> 0x0039, all -> 0x0036 }
            r1.close()
            goto L_0x004b
        L_0x0036:
            r3 = move-exception
            r2 = r1
            goto L_0x004c
        L_0x0039:
            r3 = move-exception
            r2 = r1
            goto L_0x003f
        L_0x003c:
            r3 = move-exception
            goto L_0x004c
        L_0x003e:
            r3 = move-exception
        L_0x003f:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x003c }
            java.lang.String r1 = "<writeStringToFile> Exception "
            com.mediatek.accessor.util.Log.m3996e(r0, r1, r3)     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x004b
            r2.close()
        L_0x004b:
            return
        L_0x004c:
            if (r2 == 0) goto L_0x0051
            r2.close()
        L_0x0051:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mediatek.accessor.util.C1123Utils.writeStringToFile(java.lang.String, java.lang.String):void");
    }

    public static String getFileNameFromPath(String str) {
        TraceHelper.beginSection(">>>>Utils-getFileNameFromPath");
        if (str == null) {
            TraceHelper.endSection();
            return null;
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf < 0 || lastIndexOf > str.length()) {
            TraceHelper.endSection();
            return str;
        }
        String substring = str.substring(lastIndexOf);
        TraceHelper.endSection();
        return substring;
    }

    public static void logD(String str, String str2) {
        if (XMP_DEBUG_LOG) {
            Log.m3993d(str, str2);
        }
    }
}
