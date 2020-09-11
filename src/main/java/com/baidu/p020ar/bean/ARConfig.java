package com.baidu.p020ar.bean;

import com.baidu.p020ar.util.MD5Utils;

/* renamed from: com.baidu.ar.bean.ARConfig */
public class ARConfig {
    public static final int LAUNCH_AR_TAB = 2;
    public static final int LAUNCH_AR_TAB_CASE = 3;
    public static final int LAUNCH_MODE_H5 = 1;
    public static final int LAUNCH_MODE_TAKE_PICTURE = 0;
    public static final int TYPE_CLOUD_IR = 7;
    public static final int TYPE_GAME = 2;
    public static final int TYPE_IMU = 8;
    public static final int TYPE_LBS = 1;
    public static final int TYPE_NPC = 4;
    public static final int TYPE_ON_DEVICE_IR = 6;
    public static final int TYPE_SLAM = 5;
    public static final int TYPE_TRACK = 0;
    public static final int TYPE_UDT = 3;

    /* renamed from: a */
    private static String f1052a = null;

    /* renamed from: b */
    private static String f1053b = null;

    /* renamed from: c */
    private static String f1054c = null;

    /* renamed from: d */
    private static int f1055d = -1;

    /* renamed from: e */
    private static int f1056e = -1;

    /* renamed from: f */
    private static int f1057f = 0;

    /* renamed from: g */
    private static String f1058g = null;

    /* renamed from: h */
    private static String f1059h = null;

    /* renamed from: i */
    private static boolean f1060i = false;

    /* renamed from: j */
    private static String f1061j = "";

    /* renamed from: k */
    private static String f1062k = "";

    public static String getARExtraInfo() {
        return f1061j;
    }

    public static String getARId() {
        return f1058g;
    }

    public static int getARInitialType() {
        return f1056e;
    }

    public static String getARKey() {
        return f1053b;
    }

    public static int getARLaunchMode() {
        return f1057f;
    }

    public static String getARPath() {
        return f1054c;
    }

    public static int getARType() {
        return f1055d;
    }

    public static String getArFrom() {
        return f1059h;
    }

    public static String getArValue() {
        return f1052a;
    }

    public static String getCUID() {
        return f1062k;
    }

    public static String getSignature(long j) {
        StringBuilder sb;
        String aPIKey;
        if (isOpen()) {
            sb = new StringBuilder();
            aPIKey = DuMixARConfig.getAipAppId();
        } else {
            sb = new StringBuilder();
            sb.append(DuMixARConfig.getAipAppId());
            aPIKey = DuMixARConfig.getAPIKey();
        }
        sb.append(aPIKey);
        sb.append("777078ec21930de508131ba36035de6b");
        sb.append(j);
        return MD5Utils.md5(sb.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035 A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041 A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048 A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075 A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083 A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0087 A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0096 A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c6 A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d7 A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e8 A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void initARConfig(java.lang.String r4) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f2 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x00f2 }
            f1052a = r4     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r4 = "ar_key"
            boolean r4 = r0.has(r4)     // Catch:{ Exception -> 0x00f2 }
            r1 = 0
            if (r4 == 0) goto L_0x0017
            java.lang.String r4 = "ar_key"
        L_0x0012:
            java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x00f2 }
            goto L_0x0023
        L_0x0017:
            java.lang.String r4 = "arKey"
            boolean r4 = r0.has(r4)     // Catch:{ Exception -> 0x00f2 }
            if (r4 == 0) goto L_0x0022
            java.lang.String r4 = "arKey"
            goto L_0x0012
        L_0x0022:
            r4 = r1
        L_0x0023:
            setARKey(r4)     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r4 = "ar_path"
            boolean r4 = r0.has(r4)     // Catch:{ Exception -> 0x00f2 }
            if (r4 == 0) goto L_0x0035
            java.lang.String r4 = "ar_path"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x00f2 }
            goto L_0x0036
        L_0x0035:
            r4 = r1
        L_0x0036:
            setARPath(r4)     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r4 = "ar_type"
            boolean r4 = r0.has(r4)     // Catch:{ Exception -> 0x00f2 }
            if (r4 == 0) goto L_0x0048
            java.lang.String r4 = "ar_type"
        L_0x0043:
            java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x00f2 }
            goto L_0x0054
        L_0x0048:
            java.lang.String r4 = "arType"
            boolean r4 = r0.has(r4)     // Catch:{ Exception -> 0x00f2 }
            if (r4 == 0) goto L_0x0053
            java.lang.String r4 = "arType"
            goto L_0x0043
        L_0x0053:
            r4 = r1
        L_0x0054:
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00f2 }
            r3 = 0
            if (r2 == 0) goto L_0x005f
            setARType(r3)     // Catch:{ Exception -> 0x00f2 }
            goto L_0x006d
        L_0x005f:
            int r2 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x00f2 }
            setARType(r2)     // Catch:{ Exception -> 0x00f2 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x00f2 }
            setARInitialType(r4)     // Catch:{ Exception -> 0x00f2 }
        L_0x006d:
            java.lang.String r4 = "ar_launch_mode"
            boolean r4 = r0.has(r4)     // Catch:{ Exception -> 0x00f2 }
            if (r4 == 0) goto L_0x007c
            java.lang.String r4 = "ar_launch_mode"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x00f2 }
            goto L_0x007d
        L_0x007c:
            r4 = r1
        L_0x007d:
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00f2 }
            if (r2 == 0) goto L_0x0087
            setARLaunchMode(r3)     // Catch:{ Exception -> 0x00f2 }
            goto L_0x008e
        L_0x0087:
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x00f2 }
            setARLaunchMode(r4)     // Catch:{ Exception -> 0x00f2 }
        L_0x008e:
            java.lang.String r4 = "ar_id"
            boolean r4 = r0.has(r4)     // Catch:{ Exception -> 0x00f2 }
            if (r4 == 0) goto L_0x009c
            java.lang.String r4 = "ar_id"
            java.lang.String r1 = r0.getString(r4)     // Catch:{ Exception -> 0x00f2 }
        L_0x009c:
            setARId(r1)     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r4 = getARKey()     // Catch:{ Exception -> 0x00f2 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00f2 }
            if (r4 == 0) goto L_0x00be
            if (r1 == 0) goto L_0x00be
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00ba }
            r4.<init>(r1)     // Catch:{ JSONException -> 0x00ba }
            java.lang.String r1 = "content_id"
            java.lang.String r4 = r4.optString(r1)     // Catch:{ JSONException -> 0x00ba }
            setARKey(r4)     // Catch:{ JSONException -> 0x00ba }
            goto L_0x00be
        L_0x00ba:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ Exception -> 0x00f2 }
        L_0x00be:
            java.lang.String r4 = "ar_from"
            boolean r4 = r0.has(r4)     // Catch:{ Exception -> 0x00f2 }
            if (r4 == 0) goto L_0x00cf
            java.lang.String r4 = "ar_from"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x00f2 }
            setArFrom(r4)     // Catch:{ Exception -> 0x00f2 }
        L_0x00cf:
            java.lang.String r4 = "ar_last_preview"
            boolean r4 = r0.has(r4)     // Catch:{ Exception -> 0x00f2 }
            if (r4 == 0) goto L_0x00e0
            java.lang.String r4 = "ar_last_preview"
            boolean r4 = r0.getBoolean(r4)     // Catch:{ Exception -> 0x00f2 }
            setIsNeedLastPreview(r4)     // Catch:{ Exception -> 0x00f2 }
        L_0x00e0:
            java.lang.String r4 = "extra_info"
            boolean r4 = r0.has(r4)     // Catch:{ Exception -> 0x00f2 }
            if (r4 == 0) goto L_0x00f6
            java.lang.String r4 = "extra_info"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x00f2 }
            setARExtraInfo(r4)     // Catch:{ Exception -> 0x00f2 }
            goto L_0x00f6
        L_0x00f2:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.bean.ARConfig.initARConfig(java.lang.String):void");
    }

    public static boolean isBox() {
        return "2".equals(DuMixARConfig.getAipAppId()) && !"com.baidu.ardemo".equals(DuMixARConfig.getPackageName());
    }

    public static boolean isNeedLastPreview() {
        return f1060i;
    }

    public static boolean isOpen() {
        try {
            return Long.parseLong(DuMixARConfig.getAipAppId()) > 10000;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void setARExtraInfo(String str) {
        f1061j = str;
    }

    public static void setARId(String str) {
        f1058g = str;
    }

    public static void setARInitialType(int i) {
        f1056e = i;
    }

    public static void setARKey(String str) {
        f1053b = str;
    }

    public static void setARLaunchMode(int i) {
        f1057f = i;
    }

    public static void setARPath(String str) {
        f1054c = str;
    }

    public static void setARType(int i) {
        f1055d = i;
    }

    public static void setArFrom(String str) {
        f1059h = str;
    }

    public static void setCUID(String str) {
        f1062k = str;
    }

    public static void setIsNeedLastPreview(boolean z) {
        f1060i = z;
    }
}
