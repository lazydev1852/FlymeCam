package com.meizu.statsapp.p081v3.lib.plugin.utils;

import android.content.Context;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.utils.MzOpenIdHelper */
public class MzOpenIdHelper {
    private static final String TAG = "MzOpenIdHelper";
    private static final String TYPE_UDID = "10001";
    private static final String TYPE_VERSION = "10000";

    public static String queryVersion(Context context) {
        return query(context, TYPE_VERSION);
    }

    public static String queryUDID(Context context) {
        return query(context, TYPE_UDID);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
        r7 = r2;
        r2 = r1;
        r1 = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String query(android.content.Context r8, java.lang.String r9) {
        /*
            android.content.Context r8 = r8.getApplicationContext()
            r0 = 1
            java.lang.String[] r5 = new java.lang.String[r0]
            r0 = 0
            r5[r0] = r9
            java.lang.String r9 = "content://com.meizu.flyme.mzopenid/"
            android.net.Uri r9 = android.net.Uri.parse(r9)
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x0058 }
            r3 = 0
            r4 = 0
            r6 = 0
            r2 = r9
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0058 }
            if (r8 == 0) goto L_0x0052
            int r1 = r8.getCount()     // Catch:{ Throwable -> 0x003b, all -> 0x0038 }
            if (r1 <= 0) goto L_0x0052
            r8.moveToFirst()     // Catch:{ Throwable -> 0x003b, all -> 0x0038 }
            java.lang.String r1 = "value"
            int r1 = r8.getColumnIndex(r1)     // Catch:{ Throwable -> 0x003b, all -> 0x0038 }
            java.lang.String r1 = r8.getString(r1)     // Catch:{ Throwable -> 0x003b, all -> 0x0038 }
            if (r8 == 0) goto L_0x0037
            r8.close()     // Catch:{ Exception -> 0x0058 }
        L_0x0037:
            return r1
        L_0x0038:
            r1 = move-exception
            r2 = r0
            goto L_0x0041
        L_0x003b:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x003d }
        L_0x003d:
            r2 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
        L_0x0041:
            if (r8 == 0) goto L_0x0051
            if (r2 == 0) goto L_0x004e
            r8.close()     // Catch:{ Throwable -> 0x0049 }
            goto L_0x0051
        L_0x0049:
            r8 = move-exception
            r2.addSuppressed(r8)     // Catch:{ Exception -> 0x0058 }
            goto L_0x0051
        L_0x004e:
            r8.close()     // Catch:{ Exception -> 0x0058 }
        L_0x0051:
            throw r1     // Catch:{ Exception -> 0x0058 }
        L_0x0052:
            if (r8 == 0) goto L_0x007f
            r8.close()     // Catch:{ Exception -> 0x0058 }
            goto L_0x007f
        L_0x0058:
            r8 = move-exception
            java.lang.String r1 = "MzOpenIdHelper"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "query fail;"
            r2.append(r3)
            java.lang.String r9 = r9.toString()
            r2.append(r9)
            java.lang.String r9 = ";"
            r2.append(r9)
            java.lang.String r8 = r8.getMessage()
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            android.util.Log.e(r1, r8)
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.utils.MzOpenIdHelper.query(android.content.Context, java.lang.String):java.lang.String");
    }
}
