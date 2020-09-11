package com.baidu.p020ar.parser;

import android.text.TextUtils;
import com.baidu.p020ar.bean.C0625c;
import com.baidu.p020ar.util.ARFileUtils;
import com.meizu.cloud.pushsdk.pushtracer.constant.Parameters;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.parser.a */
public final class C0819a {

    /* renamed from: a */
    private static final String f1956a = "a";

    private C0819a() {
    }

    /* renamed from: a */
    private static C0625c.C0626a m2167a(JSONObject jSONObject) {
        C0625c.C0626a aVar = new C0625c.C0626a();
        try {
            if (jSONObject.has("resPath")) {
                aVar.mo9704a(jSONObject.getString("resPath"));
            }
            if (jSONObject.has("resId")) {
                aVar.mo9706b(jSONObject.getString("resId"));
            }
            if (jSONObject.has("encoding")) {
                aVar.mo9708c(jSONObject.getString("encoding"));
            }
            if (jSONObject.has("md5")) {
                aVar.mo9709d(jSONObject.getString("md5"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aVar;
    }

    /* renamed from: a */
    public static C0625c m2168a(String str, String str2) {
        String resConfigJsonPath = ARFileUtils.getResConfigJsonPath(str);
        try {
            if (!new File(resConfigJsonPath).exists() || TextUtils.isEmpty(str2)) {
                return null;
            }
            return m2169b(str2, resConfigJsonPath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private static C0625c m2169b(String str, String str2) {
        C0625c cVar = new C0625c();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(Parameters.RESOLUTION)) {
                JSONArray jSONArray = jSONObject.getJSONArray(Parameters.RESOLUTION);
                HashMap hashMap = new HashMap();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        C0625c.C0626a a = m2167a((JSONObject) jSONArray.get(i));
                        if (a != null && !TextUtils.isEmpty(a.mo9703a())) {
                            hashMap.put(a.mo9703a(), a);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                cVar.mo9702a((Map<String, C0625c.C0626a>) hashMap);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return cVar;
    }
}
