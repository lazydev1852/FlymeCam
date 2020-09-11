package com.meizu.cloud.pushsdk.analytics.secure;

import org.json.JSONException;
import org.json.JSONObject;

public class NetResponse {
    private String responseBody;
    private int responseCode;

    public String getResponseBody() {
        return this.responseBody;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public NetResponse(int i, String str) {
        this.responseCode = i;
        this.responseBody = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.responseCode);
            jSONObject.put("body", this.responseBody);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
