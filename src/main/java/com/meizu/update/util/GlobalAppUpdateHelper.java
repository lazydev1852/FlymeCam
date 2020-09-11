package com.meizu.update.util;

import android.os.Environment;
import android.text.TextUtils;
import java.util.List;

/* renamed from: com.meizu.update.util.c */
public class GlobalAppUpdateHelper {

    /* renamed from: a */
    private String f16356a = (Environment.getExternalStorageDirectory() + "/appupgrade/tmp/apps_upgrade_list");

    /* renamed from: a */
    public final boolean mo24872a(String str) {
        List<String> a;
        if (TextUtils.isEmpty(str) || (a = m17934a()) == null || a.size() == 0) {
            return false;
        }
        return a.contains(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x006b A[SYNTHETIC, Splitter:B:39:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0076 A[SYNTHETIC, Splitter:B:46:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0081 A[SYNTHETIC, Splitter:B:53:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x008c A[SYNTHETIC, Splitter:B:60:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0098 A[SYNTHETIC, Splitter:B:67:0x0098] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:43:0x0071=Splitter:B:43:0x0071, B:36:0x0066=Splitter:B:36:0x0066, B:57:0x0087=Splitter:B:57:0x0087, B:50:0x007c=Splitter:B:50:0x007c} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> m17934a() {
        /*
            r7 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0085, UnsupportedEncodingException -> 0x007a, IOException -> 0x006f, Exception -> 0x0064, all -> 0x0060 }
            java.lang.String r2 = r7.f16356a     // Catch:{ FileNotFoundException -> 0x0085, UnsupportedEncodingException -> 0x007a, IOException -> 0x006f, Exception -> 0x0064, all -> 0x0060 }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0085, UnsupportedEncodingException -> 0x007a, IOException -> 0x006f, Exception -> 0x0064, all -> 0x0060 }
            boolean r2 = r1.exists()     // Catch:{ FileNotFoundException -> 0x0085, UnsupportedEncodingException -> 0x007a, IOException -> 0x006f, Exception -> 0x0064, all -> 0x0060 }
            if (r2 == 0) goto L_0x0059
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0085, UnsupportedEncodingException -> 0x007a, IOException -> 0x006f, Exception -> 0x0064, all -> 0x0060 }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0085, UnsupportedEncodingException -> 0x007a, IOException -> 0x006f, Exception -> 0x0064, all -> 0x0060 }
            int r1 = r2.available()     // Catch:{ FileNotFoundException -> 0x0057, UnsupportedEncodingException -> 0x0055, IOException -> 0x0053, Exception -> 0x0051 }
            if (r1 <= 0) goto L_0x005a
            byte[] r1 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x0057, UnsupportedEncodingException -> 0x0055, IOException -> 0x0053, Exception -> 0x0051 }
            r2.read(r1)     // Catch:{ FileNotFoundException -> 0x0057, UnsupportedEncodingException -> 0x0055, IOException -> 0x0053, Exception -> 0x0051 }
            r2.close()     // Catch:{ FileNotFoundException -> 0x0057, UnsupportedEncodingException -> 0x0055, IOException -> 0x0053, Exception -> 0x0051 }
            java.lang.String r3 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0057, UnsupportedEncodingException -> 0x0055, IOException -> 0x0053, Exception -> 0x0051 }
            r3.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0057, UnsupportedEncodingException -> 0x0055, IOException -> 0x0053, Exception -> 0x0051 }
            java.lang.String r1 = ","
            java.lang.String[] r1 = r3.split(r1)     // Catch:{ FileNotFoundException -> 0x0057, UnsupportedEncodingException -> 0x0055, IOException -> 0x0053, Exception -> 0x0051 }
            if (r1 == 0) goto L_0x005a
            int r3 = r1.length     // Catch:{ FileNotFoundException -> 0x0057, UnsupportedEncodingException -> 0x0055, IOException -> 0x0053, Exception -> 0x0051 }
            if (r3 <= 0) goto L_0x005a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ FileNotFoundException -> 0x0057, UnsupportedEncodingException -> 0x0055, IOException -> 0x0053, Exception -> 0x0051 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0057, UnsupportedEncodingException -> 0x0055, IOException -> 0x0053, Exception -> 0x0051 }
            r4 = 0
        L_0x0037:
            int r5 = r1.length     // Catch:{ FileNotFoundException -> 0x0057, UnsupportedEncodingException -> 0x0055, IOException -> 0x0053, Exception -> 0x0051 }
            if (r4 >= r5) goto L_0x0048
            r5 = r1[r4]     // Catch:{ FileNotFoundException -> 0x0057, UnsupportedEncodingException -> 0x0055, IOException -> 0x0053, Exception -> 0x0051 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ FileNotFoundException -> 0x0057, UnsupportedEncodingException -> 0x0055, IOException -> 0x0053, Exception -> 0x0051 }
            if (r6 != 0) goto L_0x0045
            r3.add(r5)     // Catch:{ FileNotFoundException -> 0x0057, UnsupportedEncodingException -> 0x0055, IOException -> 0x0053, Exception -> 0x0051 }
        L_0x0045:
            int r4 = r4 + 1
            goto L_0x0037
        L_0x0048:
            r2.close()     // Catch:{ IOException -> 0x004c }
            goto L_0x0050
        L_0x004c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0050:
            return r3
        L_0x0051:
            r1 = move-exception
            goto L_0x0066
        L_0x0053:
            r1 = move-exception
            goto L_0x0071
        L_0x0055:
            r1 = move-exception
            goto L_0x007c
        L_0x0057:
            r1 = move-exception
            goto L_0x0087
        L_0x0059:
            r2 = r0
        L_0x005a:
            if (r2 == 0) goto L_0x0094
            r2.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x0094
        L_0x0060:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x0096
        L_0x0064:
            r1 = move-exception
            r2 = r0
        L_0x0066:
            r1.printStackTrace()     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x0094
            r2.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x0094
        L_0x006f:
            r1 = move-exception
            r2 = r0
        L_0x0071:
            r1.printStackTrace()     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x0094
            r2.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x0094
        L_0x007a:
            r1 = move-exception
            r2 = r0
        L_0x007c:
            r1.printStackTrace()     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x0094
            r2.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x0094
        L_0x0085:
            r1 = move-exception
            r2 = r0
        L_0x0087:
            r1.printStackTrace()     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x0094
            r2.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x0094
        L_0x0090:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0094:
            return r0
        L_0x0095:
            r0 = move-exception
        L_0x0096:
            if (r2 == 0) goto L_0x00a0
            r2.close()     // Catch:{ IOException -> 0x009c }
            goto L_0x00a0
        L_0x009c:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00a0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.update.util.GlobalAppUpdateHelper.m17934a():java.util.List");
    }
}
