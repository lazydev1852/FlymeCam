package com.meizu.statsrpk.service;

import android.content.Context;
import android.net.Uri;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.EmitterWorker;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import com.meizu.statsapp.p081v3.lib.plugin.receiver.EnvironmentReceiver;
import com.meizu.statsapp.p081v3.lib.plugin.utils.C2943Utils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.NetInfoUtils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.NetRequestUtil;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import com.meizu.statsrpk.p082a.RpkEventStore;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.meizu.statsrpk.service.a */
public class RpkEmitterWorker extends EmitterWorker implements EnvironmentReceiver.IEnvListener {

    /* renamed from: a */
    private static final String f16035a = "a";

    /* renamed from: b */
    private RpkEventStore f16036b;

    /* renamed from: c */
    private ScheduledExecutorService f16037c;

    public RpkEmitterWorker(Context context, int i) {
        super(context);
        this.f16037c = Executors.newScheduledThreadPool(i);
        this.f16036b = new RpkEventStore(context);
        EnvironmentReceiver.getInstance(context).addEnvListener(this);
        this.f16037c.schedule(new Runnable() {
            public void run() {
                RpkEmitterWorker.this.m17409a();
            }
        }, 1800000, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public void mo24603a(final String str, final String str2, final TrackerPayload trackerPayload) {
        this.f16037c.execute(new Runnable() {
            public void run() {
                RpkEmitterWorker.this.m17416b(str, str2, trackerPayload);
            }
        });
    }

    public void environmentChanged(final String str) {
        this.f16037c.execute(new Runnable() {
            public void run() {
                RpkEmitterWorker.this.m17413a(str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17413a(String str) {
        String str2 = f16035a;
        Logger.m17378d(str2, "environmentChanged. changeName: " + str);
        List<String> b = this.f16036b.mo24594b();
        if (EnvironmentReceiver.CHANGE_NAME_NETWORKCONNECT.equals(str)) {
            for (String b2 : b) {
                m17415b(b2);
            }
        } else if (EnvironmentReceiver.CHANGE_NAME_POWER.equals(str)) {
            for (String b3 : b) {
                m17415b(b3);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17416b(String str, String str2, TrackerPayload trackerPayload) {
        if (str != null && trackerPayload != null) {
            String str3 = f16035a;
            Logger.m17378d(str3, "Queuing event for sending later, appKey:" + str + ", payload:" + trackerPayload);
            this.f16036b.mo24591a();
            if (this.f16036b.mo24590a(str, str2, trackerPayload) > 0 && m17417c(str)) {
                m17414a(str, this.f16036b.mo24593b(str));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0190  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m17414a(java.lang.String r11, java.util.ArrayList<com.meizu.statsapp.p081v3.lib.plugin.emitter.EmittableEvent> r12) {
        /*
            r10 = this;
            if (r12 == 0) goto L_0x01b1
            int r0 = r12.size()
            if (r0 == 0) goto L_0x01b1
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 == 0) goto L_0x0010
            goto L_0x01b1
        L_0x0010:
            android.content.Context r0 = r10.context
            com.meizu.statsapp.v3.lib.plugin.sdk.UmidFetcher r0 = com.meizu.statsapp.p081v3.lib.plugin.sdk.UmidFetcher.getInstance(r0)
            java.lang.String r0 = r0.fetchOrRequestUMID()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0028
            java.lang.String r11 = f16035a
            java.lang.String r12 = "Not flushing data to Server because no umid"
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r11, r12)
            return
        L_0x0028:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 0
            r4 = 0
        L_0x0034:
            int r5 = r12.size()
            if (r4 >= r5) goto L_0x006f
            java.lang.Object r5 = r12.get(r4)
            com.meizu.statsapp.v3.lib.plugin.emitter.EmittableEvent r5 = (com.meizu.statsapp.p081v3.lib.plugin.emitter.EmittableEvent) r5
            long r6 = r5.getId()
            com.meizu.statsapp.v3.lib.plugin.payload.TrackerPayload r8 = r5.getPayload()
            java.lang.String r9 = "cseq"
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r8.add(r9, r6)
            com.meizu.statsapp.v3.lib.plugin.payload.TrackerPayload r6 = r5.getPayload()
            java.lang.String r7 = "umid"
            r6.add(r7, r0)
            long r6 = r5.getId()
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r1.add(r6)
            com.meizu.statsapp.v3.lib.plugin.payload.TrackerPayload r5 = r5.getPayload()
            r2.add(r5)
            int r4 = r4 + 1
            goto L_0x0034
        L_0x006f:
            java.lang.String r12 = f16035a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "sendBatch eventIds: "
            r0.append(r4)
            java.lang.Object[] r4 = r1.toArray()
            java.lang.String r4 = java.util.Arrays.toString(r4)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r12, r0)
            java.lang.String r12 = com.meizu.statsapp.p081v3.lib.plugin.emitter.EmitterMessageBuilder.buildEvents(r2)
            byte[] r12 = r12.getBytes()
            byte[] r12 = com.meizu.statsapp.p081v3.lib.plugin.utils.C2943Utils.compress(r12)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants.UPLOAD_URL
            r0.append(r2)
            r0.append(r11)
            java.lang.String r2 = "/batch"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r10.m17408a((java.lang.String) r0, (byte[]) r12)
            java.lang.String r2 = f16035a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "sendDataBatch buildUri "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r2, r4)
            android.content.Context r2 = r10.context
            com.meizu.statsapp.v3.lib.plugin.net.HttpSecureRequester r2 = com.meizu.statsapp.p081v3.lib.plugin.net.HttpSecureRequester.getInstance(r2)
            r4 = 0
            com.meizu.statsapp.v3.lib.plugin.net.NetResponse r12 = r2.postMultipart(r0, r4, r12)
            if (r12 == 0) goto L_0x016d
            java.lang.String r0 = r12.getResponseBody()
            if (r0 == 0) goto L_0x016d
            r0 = 1
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r4 = r12.getResponseBody()     // Catch:{ JSONException -> 0x0146 }
            r2.<init>(r4)     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r4 = "code"
            int r2 = r2.getInt(r4)     // Catch:{ JSONException -> 0x0146 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 != r4) goto L_0x012a
            java.lang.String r2 = f16035a     // Catch:{ JSONException -> 0x0127 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0127 }
            r3.<init>()     // Catch:{ JSONException -> 0x0127 }
            java.lang.String r4 = "Successfully posted to "
            r3.append(r4)     // Catch:{ JSONException -> 0x0127 }
            java.lang.String r4 = com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants.UPLOAD_URL     // Catch:{ JSONException -> 0x0127 }
            r3.append(r4)     // Catch:{ JSONException -> 0x0127 }
            r3.append(r11)     // Catch:{ JSONException -> 0x0127 }
            java.lang.String r4 = "/batch"
            r3.append(r4)     // Catch:{ JSONException -> 0x0127 }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0127 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r2, r3)     // Catch:{ JSONException -> 0x0127 }
            java.lang.String r2 = f16035a     // Catch:{ JSONException -> 0x0127 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0127 }
            r3.<init>()     // Catch:{ JSONException -> 0x0127 }
            java.lang.String r4 = "Response is: "
            r3.append(r4)     // Catch:{ JSONException -> 0x0127 }
            r3.append(r12)     // Catch:{ JSONException -> 0x0127 }
            java.lang.String r12 = r3.toString()     // Catch:{ JSONException -> 0x0127 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r2, r12)     // Catch:{ JSONException -> 0x0127 }
            goto L_0x0144
        L_0x0127:
            r12 = move-exception
            r3 = 1
            goto L_0x0147
        L_0x012a:
            r4 = 415(0x19f, float:5.82E-43)
            if (r2 != r4) goto L_0x016d
            java.lang.String r2 = f16035a     // Catch:{ JSONException -> 0x0127 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0127 }
            r3.<init>()     // Catch:{ JSONException -> 0x0127 }
            java.lang.String r4 = "415 data error "
            r3.append(r4)     // Catch:{ JSONException -> 0x0127 }
            r3.append(r12)     // Catch:{ JSONException -> 0x0127 }
            java.lang.String r12 = r3.toString()     // Catch:{ JSONException -> 0x0127 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r2, r12)     // Catch:{ JSONException -> 0x0127 }
        L_0x0144:
            r3 = 1
            goto L_0x016d
        L_0x0146:
            r12 = move-exception
        L_0x0147:
            java.lang.String r0 = f16035a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Exception: "
            r2.append(r4)
            java.lang.String r4 = r12.toString()
            r2.append(r4)
            java.lang.String r4 = " - Cause: "
            r2.append(r4)
            java.lang.Throwable r12 = r12.getCause()
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17382w(r0, r12)
        L_0x016d:
            if (r3 == 0) goto L_0x0190
            java.lang.String r12 = f16035a
            java.lang.String r0 = "deleting sent events from DB."
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r12, r0)
            java.util.Iterator r12 = r1.iterator()
        L_0x017a:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x01b0
            java.lang.Object r0 = r12.next()
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            com.meizu.statsrpk.a.a r2 = r10.f16036b
            r2.mo24592a((java.lang.String) r11, (long) r0)
            goto L_0x017a
        L_0x0190:
            java.lang.String r12 = f16035a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Response is null or failed, unexpected failure posting to "
            r0.append(r1)
            java.lang.String r1 = com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants.UPLOAD_URL
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = "/batch"
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r12, r11)
        L_0x01b0:
            return
        L_0x01b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsrpk.service.RpkEmitterWorker.m17414a(java.lang.String, java.util.ArrayList):void");
    }

    /* renamed from: a */
    private String m17408a(String str, byte[] bArr) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        HashMap hashMap = new HashMap();
        String md5 = C2943Utils.getMD5(bArr);
        buildUpon.appendQueryParameter("md5", md5);
        hashMap.put("md5", md5);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String valueOf = String.valueOf(currentTimeMillis);
        buildUpon.appendQueryParameter("ts", valueOf);
        String valueOf2 = String.valueOf(currentTimeMillis + ((long) new Random().nextInt()));
        buildUpon.appendQueryParameter(Parameters.UXIP_REQUEST_PARAM_NONCE, valueOf2);
        hashMap.put("ts", valueOf);
        hashMap.put(Parameters.UXIP_REQUEST_PARAM_NONCE, valueOf2);
        buildUpon.appendQueryParameter("sign", NetRequestUtil.sign("POST", str, hashMap, (Map<String, String>) null));
        return buildUpon.toString();
    }

    /* renamed from: b */
    private void m17415b(String str) {
        String str2 = f16035a;
        Logger.m17378d(str2, "flushQueueInternalWhenEnvChanged, appKey: " + str);
        this.f16036b.mo24591a();
        m17414a(str, this.f16036b.mo24593b(str));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17409a() {
        Logger.m17378d(f16035a, "flushQueueInternalByTimer");
        for (String next : this.f16036b.mo24594b()) {
            this.f16036b.mo24591a();
            m17414a(next, this.f16036b.mo24593b(next));
        }
        this.f16037c.schedule(new Runnable() {
            public void run() {
                RpkEmitterWorker.this.m17409a();
            }
        }, 1800000, TimeUnit.MILLISECONDS);
    }

    /* renamed from: c */
    private boolean m17417c(String str) {
        long a = this.f16036b.mo24589a(str);
        boolean isOnline = NetInfoUtils.isOnline(this.context);
        String str2 = f16035a;
        Logger.m17378d(str2, "cacheCheck appKey:" + str + " ------------------ eventSize:" + a + ", flushCacheLimit:" + 5 + ", networkAvailable:" + isOnline);
        return a >= ((long) 5) && isOnline;
    }
}
