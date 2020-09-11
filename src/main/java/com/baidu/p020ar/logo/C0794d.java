package com.baidu.p020ar.logo;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.p020ar.util.HttpUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.logo.d */
public class C0794d implements C0791a {

    /* renamed from: a */
    private static volatile C0794d f1850a;

    /* renamed from: b */
    private HandlerThread f1851b;

    /* renamed from: c */
    private Handler f1852c;

    /* renamed from: d */
    private IttRecognitionCallback f1853d;

    /* renamed from: com.baidu.ar.logo.d$a */
    private static class C0795a extends Handler {

        /* renamed from: a */
        private C0791a f1854a;

        public C0795a(Looper looper, C0791a aVar) {
            super(looper);
            this.f1854a = aVar;
        }

        public void handleMessage(Message message) {
            this.f1854a.mo10249a(message);
        }
    }

    /* renamed from: com.baidu.ar.logo.d$b */
    private class C0796b {

        /* renamed from: a */
        String f1855a;

        /* renamed from: b */
        HashMap<String, String> f1856b;

        /* renamed from: c */
        byte[] f1857c;

        public C0796b(String str, HashMap<String, String> hashMap, byte[] bArr) {
            this.f1855a = str;
            this.f1856b = hashMap;
            this.f1857c = bArr;
        }
    }

    private C0794d() {
        m2088d();
    }

    /* renamed from: a */
    public static C0794d m2086a() {
        if (f1850a == null) {
            synchronized (C0794d.class) {
                if (f1850a == null) {
                    f1850a = new C0794d();
                }
            }
        }
        return f1850a;
    }

    /* renamed from: b */
    private void m2087b(String str, HashMap<String, String> hashMap, byte[] bArr) {
        IttRecognitionCallback ittRecognitionCallback;
        StringBuilder sb = new StringBuilder();
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                sb.append(next.getKey());
                sb.append("=");
                sb.append(next.getValue());
                sb.append("&");
            }
            sb.deleteCharAt(sb.lastIndexOf("&"));
        }
        String post = HttpUtils.post(str, sb.toString());
        C0793c cVar = new C0793c();
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(post);
            cVar.mo10255a(jSONObject.getInt("errorNum") == 0);
            cVar.mo10254a(jSONObject.getString("errorMsg"));
            if (jSONObject.has("data") && !TextUtils.isEmpty(jSONObject.get("data").toString())) {
                RecognitionRes recognitionRes = new RecognitionRes();
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    recognitionRes.setName(jSONObject2.getString("name"));
                    recognitionRes.setCode(jSONObject2.getString("code"));
                    recognitionRes.setType(jSONObject2.getInt("type"));
                    recognitionRes.setProbability(jSONObject2.getDouble("probability"));
                    if (jSONObject2.has("location")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("location");
                        C0792b bVar = new C0792b();
                        bVar.mo10253d(jSONObject3.getInt("height"));
                        bVar.mo10251b(jSONObject3.getInt("top"));
                        bVar.mo10250a(jSONObject3.getInt("left"));
                        bVar.mo10252c(jSONObject3.getInt("width"));
                        recognitionRes.setImageLocation(bVar);
                    }
                    arrayList.add(recognitionRes);
                }
                if (this.f1853d != null) {
                    ittRecognitionCallback = this.f1853d;
                } else {
                    return;
                }
            } else if (this.f1853d != null) {
                ittRecognitionCallback = this.f1853d;
            } else {
                return;
            }
            ittRecognitionCallback.recognition(arrayList);
        } catch (JSONException e) {
            e.printStackTrace();
            if (this.f1853d != null) {
                this.f1853d.recognition(arrayList);
            }
        }
    }

    /* renamed from: d */
    private void m2088d() {
        if (!mo10259c()) {
            this.f1851b = new HandlerThread("CloudSearchThread");
            this.f1851b.start();
            this.f1852c = new C0795a(this.f1851b.getLooper(), this);
        }
    }

    /* renamed from: a */
    public void mo10249a(Message message) {
        if (message.what == 1001) {
            C0796b bVar = (C0796b) message.obj;
            m2087b(bVar.f1855a, bVar.f1856b, bVar.f1857c);
        }
    }

    /* renamed from: a */
    public void mo10256a(IttRecognitionCallback ittRecognitionCallback) {
        this.f1853d = ittRecognitionCallback;
    }

    /* renamed from: a */
    public void mo10257a(String str, HashMap<String, String> hashMap, byte[] bArr) {
        if (this.f1852c != null) {
            this.f1852c.removeMessages(1007);
            this.f1852c.sendMessage(this.f1852c.obtainMessage(1001, new C0796b(str, hashMap, bArr)));
        }
    }

    /* renamed from: b */
    public void mo10258b() {
        f1850a = null;
        this.f1853d = null;
    }

    /* renamed from: c */
    public boolean mo10259c() {
        return this.f1851b != null && this.f1851b.isAlive();
    }
}
