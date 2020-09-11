package com.baidu.p020ar.logo;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.p020ar.util.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.logo.IttRecognitionManager */
public class IttRecognitionManager {

    /* renamed from: a */
    private static final String f1832a = "IttRecognitionManager";

    /* renamed from: d */
    private static volatile IttRecognitionManager f1833d;

    /* renamed from: b */
    private List<LogoModel> f1834b = new ArrayList();

    /* renamed from: c */
    private List<String> f1835c = new ArrayList();

    /* renamed from: e */
    private Context f1836e;

    private IttRecognitionManager() {
    }

    public static IttRecognitionManager getInstance() {
        if (f1833d == null) {
            synchronized (IttRecognitionManager.class) {
                if (f1833d == null) {
                    f1833d = new IttRecognitionManager();
                }
            }
        }
        return f1833d;
    }

    public void init(Context context, IttRecognitionCallback ittRecognitionCallback) {
        this.f1836e = context;
        C0794d.m2086a().mo10256a(ittRecognitionCallback);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0018 A[LOOP:0: B:7:0x0018->B:23:0x0018, LOOP_END, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.p020ar.logo.LogoModel matchLogoKey(java.util.List<com.baidu.p020ar.logo.RecognitionRes> r6) {
        /*
            r5 = this;
            int r0 = r6.size()
            if (r0 <= 0) goto L_0x0059
            java.util.List<com.baidu.ar.logo.LogoModel> r0 = r5.f1834b
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0059
            int r0 = r6.size()
            if (r0 <= 0) goto L_0x0059
            java.util.Iterator r6 = r6.iterator()
        L_0x0018:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0059
            java.lang.Object r0 = r6.next()
            com.baidu.ar.logo.RecognitionRes r0 = (com.baidu.p020ar.logo.RecognitionRes) r0
            java.util.List<com.baidu.ar.logo.LogoModel> r1 = r5.f1834b
            java.util.Iterator r1 = r1.iterator()
        L_0x002a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0018
            java.lang.Object r2 = r1.next()
            com.baidu.ar.logo.LogoModel r2 = (com.baidu.p020ar.logo.LogoModel) r2
            java.lang.String r3 = r0.getName()
            java.lang.String r4 = r2.getMatchKeyName()
            boolean r4 = r3.startsWith(r4)
            if (r4 != 0) goto L_0x0058
            java.lang.String r4 = r2.getMatchKeyName()
            boolean r4 = r3.contains(r4)
            if (r4 != 0) goto L_0x0058
            java.lang.String r4 = r2.getMatchKeyName()
            boolean r3 = r3.endsWith(r4)
            if (r3 == 0) goto L_0x002a
        L_0x0058:
            return r2
        L_0x0059:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.logo.IttRecognitionManager.matchLogoKey(java.util.List):com.baidu.ar.logo.LogoModel");
    }

    public void parseRecognition(String str) {
        this.f1835c.clear();
        this.f1834b.clear();
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            try {
                JSONObject jSONObject = new JSONObject(FileUtils.readFileText(str));
                if (jSONObject.has("logo")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("logo");
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        try {
                            JSONArray jSONArray = new JSONArray(jSONObject2.getString(next));
                            for (int i = 0; i < jSONArray.length(); i++) {
                                String string = jSONArray.getString(i);
                                LogoModel logoModel = new LogoModel();
                                logoModel.setHeadName(next);
                                logoModel.setMatchKeyName(string);
                                this.f1834b.add(logoModel);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void releaseInstance() {
        f1833d = null;
        C0794d.m2086a().mo10258b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setYUVFile(byte[] r11, int r12, int r13) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x00bb, all -> 0x00b6 }
            r1.<init>(r11)     // Catch:{ Exception -> 0x00bb, all -> 0x00b6 }
            int r8 = r12 / 2
            int r9 = r13 / 2
            java.lang.Object r2 = r1.get()     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            byte[] r2 = (byte[]) r2     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            r3 = r8
            r4 = r9
            r5 = r11
            r6 = r12
            r7 = r13
            byte[] r11 = com.baidu.p020ar.util.C0919Utils.cropYuv(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            int r2 = r8 * r9
            int[] r2 = new int[r2]     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            java.lang.Object r2 = r3.get()     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            int[] r2 = (int[]) r2     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            com.baidu.p020ar.util.C0919Utils.decodeYUV420SP(r2, r11, r12, r13)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            java.lang.Object r11 = r3.get()     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            int[] r11 = (int[]) r11     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            android.graphics.Bitmap$Config r12 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            android.graphics.Bitmap r11 = android.graphics.Bitmap.createBitmap(r11, r8, r9, r12)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            java.lang.ref.WeakReference r12 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            r12.<init>(r11)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00a6 }
            r11.<init>()     // Catch:{ Exception -> 0x00a6 }
            java.lang.Object r13 = r12.get()     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            if (r13 == 0) goto L_0x0057
            java.lang.Object r13 = r12.get()     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            android.graphics.Bitmap r13 = (android.graphics.Bitmap) r13     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            r2 = 100
            r13.compress(r0, r2, r11)     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
        L_0x0057:
            byte[] r13 = r11.toByteArray()     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            r0.<init>()     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            java.lang.String r2 = "image"
            r4 = 1
            java.lang.String r4 = android.util.Base64.encodeToString(r13, r4)     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            java.lang.String r4 = android.net.Uri.encode(r4)     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            android.content.Context r2 = r10.f1836e     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            com.baidu.p020ar.task.HttpTaskUtility.addBasicInfo((android.content.Context) r2, (java.util.HashMap<java.lang.String, java.lang.String>) r0)     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            java.lang.String r2 = "cuid"
            java.lang.String r4 = com.baidu.p020ar.bean.ARConfig.getCUID()     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            com.baidu.ar.logo.d r2 = com.baidu.p020ar.logo.C0794d.m2086a()     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            java.lang.String r4 = com.baidu.p020ar.util.UrlUtils.getLogoUrl()     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            r2.mo10257a(r4, r0, r13)     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            com.baidu.p020ar.util.IoUtils.closeQuietly(r11)
            java.lang.Object r11 = r12.get()
            if (r11 == 0) goto L_0x009c
            java.lang.Object r11 = r12.get()
            android.graphics.Bitmap r11 = (android.graphics.Bitmap) r11
            r11.recycle()
            r12.clear()
        L_0x009c:
            r1.clear()
            goto L_0x00e0
        L_0x00a0:
            r13 = move-exception
            r0 = r11
            goto L_0x00e5
        L_0x00a3:
            r13 = move-exception
            r0 = r11
            goto L_0x00bf
        L_0x00a6:
            r13 = move-exception
            goto L_0x00bf
        L_0x00a8:
            r13 = move-exception
            r12 = r0
            goto L_0x00e5
        L_0x00ab:
            r13 = move-exception
            r12 = r0
            goto L_0x00bf
        L_0x00ae:
            r13 = move-exception
            r12 = r0
            r3 = r12
            goto L_0x00e5
        L_0x00b2:
            r13 = move-exception
            r12 = r0
            r3 = r12
            goto L_0x00bf
        L_0x00b6:
            r13 = move-exception
            r12 = r0
            r1 = r12
            r3 = r1
            goto L_0x00e5
        L_0x00bb:
            r13 = move-exception
            r12 = r0
            r1 = r12
            r3 = r1
        L_0x00bf:
            r13.printStackTrace()     // Catch:{ all -> 0x00e4 }
            com.baidu.p020ar.util.IoUtils.closeQuietly(r0)
            if (r12 == 0) goto L_0x00d9
            java.lang.Object r11 = r12.get()
            if (r11 == 0) goto L_0x00d9
            java.lang.Object r11 = r12.get()
            android.graphics.Bitmap r11 = (android.graphics.Bitmap) r11
            r11.recycle()
            r12.clear()
        L_0x00d9:
            if (r1 == 0) goto L_0x00de
            r1.clear()
        L_0x00de:
            if (r3 == 0) goto L_0x00e3
        L_0x00e0:
            r3.clear()
        L_0x00e3:
            return
        L_0x00e4:
            r13 = move-exception
        L_0x00e5:
            com.baidu.p020ar.util.IoUtils.closeQuietly(r0)
            if (r12 == 0) goto L_0x00fc
            java.lang.Object r11 = r12.get()
            if (r11 == 0) goto L_0x00fc
            java.lang.Object r11 = r12.get()
            android.graphics.Bitmap r11 = (android.graphics.Bitmap) r11
            r11.recycle()
            r12.clear()
        L_0x00fc:
            if (r1 == 0) goto L_0x0101
            r1.clear()
        L_0x0101:
            if (r3 == 0) goto L_0x0106
            r3.clear()
        L_0x0106:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.logo.IttRecognitionManager.setYUVFile(byte[], int, int):void");
    }
}
