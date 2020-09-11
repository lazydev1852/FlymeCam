package com.baidu.p020ar.util;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.util.ArResourceUtils */
public class ArResourceUtils {
    /* renamed from: a */
    private static String m2700a(String str) {
        return FileUtils.readFileText(ARFileUtils.getDefaultJsonPath(str));
    }

    /* renamed from: b */
    private static String m2701b(String str) {
        return FileUtils.readFileText(ARFileUtils.getTargetJsonPath(str));
    }

    /* renamed from: c */
    private static String m2702c(String str) {
        return FileUtils.readFileText(ARFileUtils.getResConfigJsonPath(str));
    }

    public static String generateResult(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("unzip_path", str);
            jSONObject.put("default_json", m2700a(str));
            jSONObject.put("target_json", m2701b(str));
            jSONObject.put("res_config", m2702c(str));
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
