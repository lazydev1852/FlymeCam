package com.meizu.statsapp.p081v3.lib.plugin.tracker;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.tracker.EventFilter */
public class EventFilter {
    private boolean active;
    private String name;
    private boolean neartime;
    private boolean realtime;

    public EventFilter(String str, boolean z, boolean z2, boolean z3) {
        this.name = str;
        this.active = z;
        this.realtime = z2;
        this.neartime = z3;
    }

    public String getName() {
        return this.name;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean isRealtime() {
        return this.realtime;
    }

    public boolean isNeartime() {
        return this.neartime;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("e_name", this.name);
            jSONObject.put("e_active", this.active);
            jSONObject.put("e_realtime", this.realtime);
            jSONObject.put("e_neartime", this.neartime);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static EventFilter fromString(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new EventFilter(jSONObject.getString("e_name"), jSONObject.getBoolean("e_active"), jSONObject.getBoolean("e_realtime"), jSONObject.getBoolean("e_neartime"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
