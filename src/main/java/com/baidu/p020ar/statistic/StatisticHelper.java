package com.baidu.p020ar.statistic;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.p020ar.bean.ARConfig;
import com.baidu.p020ar.bean.DuMixARConfig;
import com.baidu.p020ar.constants.ARConfigKey;
import com.baidu.p020ar.constants.HttpConstants;
import com.baidu.p020ar.task.HttpTaskUtility;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.ARSDKInfo;
import com.baidu.p020ar.util.DeviceUuidFactory;
import com.baidu.p020ar.util.HttpUtils;
import com.baidu.p020ar.util.UrlUtils;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.statistic.StatisticHelper */
public class StatisticHelper {

    /* renamed from: a */
    boolean f2264a;

    /* renamed from: b */
    private String f2265b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f2266c;

    /* renamed from: d */
    private boolean f2267d;

    /* renamed from: e */
    private boolean f2268e;

    /* renamed from: f */
    private boolean f2269f;

    /* renamed from: g */
    private C0900b f2270g;

    /* renamed from: h */
    private HandlerThread f2271h;

    /* renamed from: i */
    private int f2272i;

    /* renamed from: j */
    private long f2273j;

    /* renamed from: k */
    private int f2274k;

    /* renamed from: l */
    private long f2275l;

    /* renamed from: m */
    private int f2276m;

    /* renamed from: n */
    private long f2277n;

    /* renamed from: o */
    private long f2278o;

    /* renamed from: p */
    private int f2279p;

    /* renamed from: q */
    private long f2280q;

    /* renamed from: r */
    private long f2281r;

    /* renamed from: com.baidu.ar.statistic.StatisticHelper$a */
    private static class C0899a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final StatisticHelper f2282a = new StatisticHelper();
    }

    /* renamed from: com.baidu.ar.statistic.StatisticHelper$b */
    private static class C0900b extends Handler {

        /* renamed from: a */
        private StatisticHelper f2283a;

        public C0900b(Looper looper, StatisticHelper statisticHelper) {
            super(looper);
            this.f2283a = statisticHelper;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 100) {
                this.f2283a.m2635a(this.f2283a.f2266c, (Map) message.obj);
            }
        }
    }

    private StatisticHelper() {
        this.f2267d = false;
        this.f2268e = false;
        this.f2269f = true;
        this.f2272i = 300;
        this.f2264a = true;
        this.f2276m = 300;
    }

    /* renamed from: a */
    private void m2634a() {
        if (this.f2271h == null) {
            this.f2271h = new HandlerThread("statistic_helper_handler_thread");
            this.f2271h.start();
            this.f2270g = new C0900b(this.f2271h.getLooper(), this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2635a(Context context, Map<String, String> map) {
        if (!this.f2264a && context != null) {
            String statisticUrl = UrlUtils.getStatisticUrl();
            String uuid = new DeviceUuidFactory(context).getDeviceUuid().toString();
            JSONObject jSONObject = new JSONObject();
            try {
                HttpTaskUtility.addBasicInfo(context, jSONObject);
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
                if (!TextUtils.isEmpty(ARConfig.getARKey())) {
                    jSONObject.put("ar_key", ARConfig.getARKey());
                }
                jSONObject.put(ARConfigKey.AR_ID, ARConfig.getARId());
                jSONObject.put(ARConfigKey.AR_FROM, ARConfig.getArFrom());
                jSONObject.put(HttpConstants.AIP_APP_ID, DuMixARConfig.getAipAppId());
                jSONObject.put(HttpConstants.CUID, ARConfig.getCUID());
                HttpTaskUtility.addSystemInfo(context, jSONObject);
                jSONObject.put("os_type", "android");
                jSONObject.put("os_version", Build.MODEL);
                jSONObject.put("device_type", Build.BRAND);
                jSONObject.put("device_id", uuid);
                jSONObject.put("os_version", Build.VERSION.SDK_INT);
                jSONObject.put("app_version", ARSDKInfo.getVersionCode());
                jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, ARSDKInfo.getVersionCode());
                if (!TextUtils.isEmpty(ARSDKInfo.getAppId(context))) {
                    jSONObject.put("app_id", ARSDKInfo.getAppId(context));
                }
                jSONObject.put(HttpConstants.HTTP_SYSTEM_VERSION, Build.VERSION.SDK_INT);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ARLog.m2695d("statistic params = " + jSONObject.toString());
            String postRequest = HttpUtils.postRequest(statisticUrl, jSONObject.toString());
            ARLog.m2695d("result = " + postRequest);
        }
    }

    /* renamed from: a */
    private void m2637a(Map<String, String> map) {
        if (this.f2270g != null) {
            Message obtainMessage = this.f2270g.obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.obj = map;
            this.f2270g.sendMessage(obtainMessage);
        }
    }

    public static StatisticHelper getInstance() {
        return C0899a.f2282a;
    }

    public int getPaddleFrameCount() {
        return this.f2279p;
    }

    public int getPaddleMaxFrameCount() {
        return this.f2276m;
    }

    public void initStatistic(Context context) {
        String valueOf;
        this.f2266c = context;
        this.f2264a = !this.f2266c.getPackageName().equals("com.meizu.media.camera");
        if (ARConfig.getARKey() != null) {
            valueOf = ARConfig.getARKey() + Calendar.getInstance().getTimeInMillis();
        } else {
            valueOf = String.valueOf(Calendar.getInstance().getTimeInMillis());
        }
        this.f2265b = valueOf;
        m2634a();
        HashMap hashMap = new HashMap();
        hashMap.put("time", String.valueOf(Long.valueOf(System.currentTimeMillis())));
        hashMap.put(StatisticConstants.EVENT_ID, StatisticConstants.AR_ENTRANCE);
        hashMap.put(StatisticConstants.EVENT_PARAM, ARConfig.getArValue());
        m2637a((Map<String, String>) hashMap);
    }

    public void release() {
        if (this.f2271h != null) {
            this.f2271h = null;
        }
        if (this.f2270g != null) {
            this.f2270g = null;
        }
        this.f2265b = null;
        StatisticConstants.reset();
    }

    public void resetAllPaddleValue() {
        this.f2276m = 300;
        this.f2277n = 0;
        this.f2278o = 0;
        this.f2279p = 0;
        this.f2280q = 0;
        this.f2281r = 0;
    }

    public void setPaddleMaxFrameCount(int i) {
        this.f2276m = i;
    }

    public void statisticFrameRate(String str) {
        if (this.f2274k < this.f2272i) {
            if (this.f2274k == 0) {
                this.f2273j = Calendar.getInstance().getTimeInMillis();
            }
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            long j = timeInMillis - this.f2273j;
            this.f2273j = timeInMillis;
            this.f2275l += j;
            this.f2274k++;
            if (this.f2274k == this.f2272i) {
                getInstance().statisticInfo(str, String.valueOf((((float) this.f2275l) * 1.0f) / ((float) this.f2274k)));
            }
        }
    }

    public void statisticInfo(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("time", String.valueOf(Long.valueOf(System.currentTimeMillis())));
        hashMap.put(StatisticConstants.REQUEST_ID, this.f2265b);
        hashMap.put("ar_type", String.valueOf(ARConfig.getARType()));
        hashMap.put(StatisticConstants.EVENT_ID, str);
        m2637a((Map<String, String>) hashMap);
    }

    public void statisticInfo(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("time", String.valueOf(Long.valueOf(System.currentTimeMillis())));
        hashMap.put(StatisticConstants.REQUEST_ID, this.f2265b);
        hashMap.put("ar_type", String.valueOf(ARConfig.getARType()));
        hashMap.put(StatisticConstants.EVENT_ID, str);
        hashMap.put(StatisticConstants.EVENT_PARAM, str2);
        m2637a((Map<String, String>) hashMap);
    }

    public void statisticInfo(String str, Map map) {
        if (map == null) {
            map = new HashMap();
        }
        map.put("time", String.valueOf(Long.valueOf(System.currentTimeMillis())));
        map.put(StatisticConstants.REQUEST_ID, this.f2265b);
        map.put("ar_type", String.valueOf(ARConfig.getARType()));
        map.put(StatisticConstants.EVENT_ID, str);
        m2637a((Map<String, String>) map);
    }

    public void statisticPaddleFrameRate(String str) {
        if (this.f2279p < this.f2276m) {
            if (this.f2279p == 0) {
                this.f2277n = Calendar.getInstance().getTimeInMillis();
            }
            this.f2278o = Calendar.getInstance().getTimeInMillis();
            this.f2280q = this.f2278o - this.f2277n;
            this.f2277n = this.f2278o;
            this.f2281r += this.f2280q;
            this.f2279p++;
            if (this.f2279p == this.f2276m) {
                getInstance().statisticInfo(str, String.valueOf((((float) this.f2281r) * 1.0f) / ((float) this.f2279p)));
            }
        }
    }

    public void statisticTrackedStatus(boolean z) {
        if (this.f2269f) {
            if (z) {
                this.f2269f = false;
                this.f2268e = true;
            }
        } else if (this.f2267d) {
        } else {
            if (z) {
                if (!this.f2268e) {
                    this.f2268e = true;
                    this.f2267d = true;
                }
            } else if (this.f2268e) {
                this.f2268e = false;
                getInstance().statisticInfo(StatisticConstants.UNTRACKED);
            }
        }
    }
}
