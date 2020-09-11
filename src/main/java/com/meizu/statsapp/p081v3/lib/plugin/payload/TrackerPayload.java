package com.meizu.statsapp.p081v3.lib.plugin.payload;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.statsapp.p081v3.lib.plugin.utils.C2943Utils;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.payload.TrackerPayload */
public class TrackerPayload implements Parcelable {
    public static final Parcelable.Creator<TrackerPayload> CREATOR = new Parcelable.Creator<TrackerPayload>() {
        public TrackerPayload createFromParcel(Parcel parcel) {
            return new TrackerPayload(parcel);
        }

        public TrackerPayload[] newArray(int i) {
            return new TrackerPayload[i];
        }
    };
    private static final String TAG = "TrackerPayload";
    private HashMap<String, Object> payloadMap;

    public int describeContents() {
        return 0;
    }

    public TrackerPayload() {
        this.payloadMap = new HashMap<>();
    }

    public void add(String str, Object obj) {
        if (obj == null) {
            Logger.m17381v(TAG, "The keys value is empty, returning without add");
        } else {
            this.payloadMap.put(str, obj);
        }
    }

    public void remove(String str) {
        String str2 = TAG;
        Logger.m17381v(str2, "Removing key: " + str);
        this.payloadMap.remove(str);
    }

    public void addMap(Map<String, Object> map) {
        if (map == null) {
            Logger.m17381v(TAG, "Map passed in is null, returning without adding map.");
        } else {
            this.payloadMap.putAll(map);
        }
    }

    public Map getMap() {
        return this.payloadMap;
    }

    public String toString() {
        try {
            return C2943Utils.mapToJSONObject(this.payloadMap).toString(2);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static TrackerPayload fromString(String str) {
        try {
            TrackerPayload trackerPayload = new TrackerPayload();
            trackerPayload.addMap(C2943Utils.jsonObjectToMap(new JSONObject(str)));
            return trackerPayload;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public TrackerPayload(Parcel parcel) {
        this.payloadMap = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.payloadMap);
    }
}
