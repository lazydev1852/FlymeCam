package com.baidu.p020ar.cloud;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

/* renamed from: com.baidu.ar.cloud.c */
public class C0759c implements C0763d {

    /* renamed from: a */
    private HandlerThread f1668a;

    /* renamed from: b */
    private Handler f1669b;

    /* renamed from: c */
    private C0760a f1670c;

    /* renamed from: com.baidu.ar.cloud.c$a */
    public interface C0760a {
        void onResourceRequest(C0758b bVar);
    }

    /* renamed from: com.baidu.ar.cloud.c$b */
    private static class C0761b extends Handler {

        /* renamed from: a */
        private C0763d f1671a;

        public C0761b(Looper looper, C0763d dVar) {
            super(looper);
            this.f1671a = dVar;
        }

        public void handleMessage(Message message) {
            this.f1671a.mo10102a(message);
        }
    }

    /* renamed from: com.baidu.ar.cloud.c$c */
    private class C0762c {

        /* renamed from: a */
        String f1672a;

        /* renamed from: b */
        HashMap<String, String> f1673b;

        /* renamed from: c */
        byte[] f1674c;

        public C0762c(String str, HashMap<String, String> hashMap, byte[] bArr) {
            this.f1672a = str;
            this.f1673b = hashMap;
            this.f1674c = bArr;
        }
    }

    public C0759c() {
        m1978c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c A[Catch:{ JSONException -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056 A[Catch:{ JSONException -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0090 A[Catch:{ JSONException -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a1 A[Catch:{ JSONException -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b2 A[Catch:{ JSONException -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1977b(java.lang.String r6, java.util.HashMap<java.lang.String, java.lang.String> r7, byte[] r8) {
        /*
            r5 = this;
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r6 = com.baidu.p020ar.util.HttpUtils.uploadFile(r6, r7, r8)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L_0x0019
            com.baidu.ar.cloud.c$a r6 = r5.f1670c
            if (r6 == 0) goto L_0x0018
            com.baidu.ar.cloud.c$a r6 = r5.f1670c
            r7 = 0
            r6.onResourceRequest(r7)
        L_0x0018:
            return
        L_0x0019:
            com.baidu.ar.cloud.b r7 = new com.baidu.ar.cloud.b
            r7.<init>()
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e0 }
            r8.<init>(r6)     // Catch:{ JSONException -> 0x00e0 }
            java.lang.String r6 = "errorNum"
            boolean r6 = r8.has(r6)     // Catch:{ JSONException -> 0x00e0 }
            if (r6 == 0) goto L_0x0035
            java.lang.String r6 = "errorNum"
            int r6 = r8.getInt(r6)     // Catch:{ JSONException -> 0x00e0 }
        L_0x0031:
            r7.mo10096a((int) r6)     // Catch:{ JSONException -> 0x00e0 }
            goto L_0x0044
        L_0x0035:
            java.lang.String r6 = "err_code"
            boolean r6 = r8.has(r6)     // Catch:{ JSONException -> 0x00e0 }
            if (r6 == 0) goto L_0x0044
            java.lang.String r6 = "err_code"
            int r6 = r8.getInt(r6)     // Catch:{ JSONException -> 0x00e0 }
            goto L_0x0031
        L_0x0044:
            java.lang.String r6 = "errorMsg"
            boolean r6 = r8.has(r6)     // Catch:{ JSONException -> 0x00e0 }
            if (r6 == 0) goto L_0x0056
            java.lang.String r6 = "errorMsg"
            java.lang.String r6 = r8.getString(r6)     // Catch:{ JSONException -> 0x00e0 }
        L_0x0052:
            r7.mo10098a((java.lang.String) r6)     // Catch:{ JSONException -> 0x00e0 }
            goto L_0x0065
        L_0x0056:
            java.lang.String r6 = "err_msg"
            boolean r6 = r8.has(r6)     // Catch:{ JSONException -> 0x00e0 }
            if (r6 == 0) goto L_0x0065
            java.lang.String r6 = "err_msg"
            java.lang.String r6 = r8.getString(r6)     // Catch:{ JSONException -> 0x00e0 }
            goto L_0x0052
        L_0x0065:
            java.lang.String r6 = "data"
            boolean r6 = r8.has(r6)     // Catch:{ JSONException -> 0x00e0 }
            if (r6 == 0) goto L_0x00e4
            java.lang.String r6 = "data"
            java.lang.Object r6 = r8.get(r6)     // Catch:{ JSONException -> 0x00e0 }
            java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x00e0 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x00e0 }
            if (r6 != 0) goto L_0x00e4
            java.lang.String r6 = "data"
            org.json.JSONObject r6 = r8.getJSONObject(r6)     // Catch:{ JSONException -> 0x00e0 }
            com.baidu.ar.cloud.e r8 = new com.baidu.ar.cloud.e     // Catch:{ JSONException -> 0x00e0 }
            r8.<init>()     // Catch:{ JSONException -> 0x00e0 }
            java.lang.String r2 = "ar_key"
            boolean r2 = r6.has(r2)     // Catch:{ JSONException -> 0x00e0 }
            if (r2 == 0) goto L_0x0099
            java.lang.String r2 = "ar_key"
            java.lang.String r2 = r6.getString(r2)     // Catch:{ JSONException -> 0x00e0 }
            r8.mo10108a(r2)     // Catch:{ JSONException -> 0x00e0 }
        L_0x0099:
            java.lang.String r2 = "ar_type"
            boolean r2 = r6.has(r2)     // Catch:{ JSONException -> 0x00e0 }
            if (r2 == 0) goto L_0x00aa
            java.lang.String r2 = "ar_type"
            java.lang.String r2 = r6.getString(r2)     // Catch:{ JSONException -> 0x00e0 }
            r8.mo10110b(r2)     // Catch:{ JSONException -> 0x00e0 }
        L_0x00aa:
            java.lang.String r2 = "image_md5"
            boolean r2 = r6.has(r2)     // Catch:{ JSONException -> 0x00e0 }
            if (r2 == 0) goto L_0x00bb
            java.lang.String r2 = "image_md5"
            java.lang.String r6 = r6.getString(r2)     // Catch:{ JSONException -> 0x00e0 }
            r8.mo10111c(r6)     // Catch:{ JSONException -> 0x00e0 }
        L_0x00bb:
            r7.mo10097a((com.baidu.p020ar.cloud.C0764e) r8)     // Catch:{ JSONException -> 0x00e0 }
            java.lang.String r6 = "qatest"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00e0 }
            r8.<init>()     // Catch:{ JSONException -> 0x00e0 }
            java.lang.String r2 = "云端识图: "
            r8.append(r2)     // Catch:{ JSONException -> 0x00e0 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x00e0 }
            r4 = 0
            long r2 = r2 - r0
            r8.append(r2)     // Catch:{ JSONException -> 0x00e0 }
            java.lang.String r0 = " ms"
            r8.append(r0)     // Catch:{ JSONException -> 0x00e0 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x00e0 }
            android.util.Log.e(r6, r8)     // Catch:{ JSONException -> 0x00e0 }
            goto L_0x00e4
        L_0x00e0:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00e4:
            com.baidu.ar.cloud.c$a r6 = r5.f1670c
            if (r6 == 0) goto L_0x00ed
            com.baidu.ar.cloud.c$a r6 = r5.f1670c
            r6.onResourceRequest(r7)
        L_0x00ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.cloud.C0759c.m1977b(java.lang.String, java.util.HashMap, byte[]):void");
    }

    /* renamed from: c */
    private void m1978c() {
        if (!mo10105b()) {
            this.f1668a = new HandlerThread("CloudSearchThread");
            this.f1668a.start();
            this.f1669b = new C0761b(this.f1668a.getLooper(), this);
        }
    }

    /* renamed from: a */
    public void mo10101a() {
        if (this.f1668a != null) {
            this.f1668a.getLooper().quit();
        }
        this.f1670c = null;
        this.f1668a = null;
        this.f1669b = null;
    }

    /* renamed from: a */
    public void mo10102a(Message message) {
        if (message.what == 1001) {
            C0762c cVar = (C0762c) message.obj;
            m1977b(cVar.f1672a, cVar.f1673b, cVar.f1674c);
        }
    }

    /* renamed from: a */
    public void mo10103a(C0760a aVar) {
        this.f1670c = aVar;
    }

    /* renamed from: a */
    public void mo10104a(String str, HashMap<String, String> hashMap, byte[] bArr) {
        if (this.f1669b != null) {
            this.f1669b.removeMessages(1007);
            this.f1669b.sendMessage(this.f1669b.obtainMessage(1001, new C0762c(str, hashMap, bArr)));
        }
    }

    /* renamed from: b */
    public boolean mo10105b() {
        return this.f1668a != null && this.f1668a.isAlive();
    }
}
