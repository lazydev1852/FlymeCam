package com.baidu.p020ar.load.util;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.load.util.ResponseUtil */
public class ResponseUtil {
    public static String getActionResponseInfo(int i, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", i);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("httpResult", str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static JSONObject getHttpJsonResultFromResponse(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            return new JSONObject(new JSONObject(str).getString("httpResult"));
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public static String getHttpResultFromResponse(String str) {
        try {
            return new JSONObject(str).getString("httpResult");
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getIdFromResponse(String str) {
        try {
            return new JSONObject(str).getInt("id");
        } catch (JSONException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getMsgFromResponse(String str) {
        try {
            return new JSONObject(str).getString(NotificationCompat.CATEGORY_MESSAGE);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
