package com.meizu.statsapp.p081v3.lib.plugin.emitter.remote;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.Emitter;
import com.meizu.statsapp.p081v3.lib.plugin.events.Event;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONStringer;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.remote.V2ProviderEmitter */
public class V2ProviderEmitter extends Emitter {
    private static final String AUTHORITY = "com.meizu.usagestats";
    private static final String CONTENT_AUTHORITY_SLASH = "content://com.meizu.usagestats/";
    private static final String EVENT_CHANNEL = "channel";
    private static final String EVENT_CONTENT_URI = "content://com.meizu.usagestats/event";
    private static final String EVENT_FLYME_VERSION = "flyme_version";
    private static final String EVENT_NAME = "name";
    private static final String EVENT_NETWORK = "network";
    private static final String EVENT_PACKAGE = "package";
    private static final String EVENT_PACKAGE_VERSION = "package_version";
    private static final String EVENT_PAGE = "page";
    private static final String EVENT_PROPERTIES = "properties";
    private static final String EVENT_SESSIONID = "sessionid";
    private static final String EVENT_SOURCE = "event_source";
    private static final String EVENT_TIME = "time";
    private static final String EVENT_TYPE = "type";
    private static final String TABLE_EVENT = "event";
    private static final String TAG = "V2ProviderEmitter";

    public void flush() {
    }

    public String getUMID() {
        return "";
    }

    public void init() {
    }

    public void setEncrypt(boolean z) {
    }

    public void updateEventSource(String str, String str2) {
    }

    public V2ProviderEmitter(Context context, String str) {
        super(context, str);
    }

    public void add(TrackerPayload trackerPayload) {
        String str = TAG;
        Logger.m17378d(str, "add payload:" + trackerPayload.toString());
        if (this.emitterConfig.isActive()) {
            try {
                ContentValues createEventValues = createEventValues(trackerPayload);
                Uri parse = Uri.parse(EVENT_CONTENT_URI);
                Uri insert = this.mContext.getContentResolver().insert(parse, createEventValues);
                if (insert == null) {
                    insert = this.mContext.getContentResolver().insert(parse, createOldEventValues(trackerPayload));
                }
                String str2 = TAG;
                Logger.m17378d(str2, "insert to experienceDataSync, retUrl: " + insert);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addRealtime(TrackerPayload trackerPayload) {
        String str = TAG;
        Logger.m17378d(str, "addRealtime payload:" + trackerPayload.toString());
        if (this.emitterConfig.isActive()) {
            add(trackerPayload);
        }
    }

    public void addNeartime(TrackerPayload trackerPayload) {
        String str = TAG;
        Logger.m17378d(str, "addNeartime payload:" + trackerPayload.toString());
        if (this.emitterConfig.isActive()) {
            addRealtime(trackerPayload);
        }
    }

    public ContentValues createEventValues(TrackerPayload trackerPayload) {
        ContentValues createOldEventValues = createOldEventValues(trackerPayload);
        Object obj = trackerPayload.getMap().get(Parameters.SOURCE);
        if (obj != null && (obj instanceof String)) {
            createOldEventValues.put(EVENT_SOURCE, (String) obj);
        }
        return createOldEventValues;
    }

    public ContentValues createOldEventValues(TrackerPayload trackerPayload) {
        if (trackerPayload == null || trackerPayload.getMap() == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        Object obj = trackerPayload.getMap().get("name");
        if (obj != null && (obj instanceof String)) {
            contentValues.put("name", (String) obj);
        }
        Object obj2 = trackerPayload.getMap().get(Parameters.PKG_NAME);
        if (obj2 != null && (obj2 instanceof String)) {
            contentValues.put(EVENT_PACKAGE, (String) obj2);
        }
        Object obj3 = trackerPayload.getMap().get(Parameters.PKG_VER);
        if (obj3 != null && (obj3 instanceof String)) {
            contentValues.put(EVENT_PACKAGE_VERSION, (String) obj3);
        }
        Object obj4 = trackerPayload.getMap().get("type");
        if (obj4 != null && (obj4 instanceof String)) {
            if (obj4.equals(Event.EVENT_TYPE_ACTION_X)) {
                contentValues.put("type", 1);
            } else if (obj4.equals("page")) {
                contentValues.put("type", 2);
            } else if (obj4.equals(Event.EVENT_TYPE_LOG)) {
                contentValues.put("type", 3);
            }
        }
        Object obj5 = trackerPayload.getMap().get(Parameters.SESSION_ID);
        if (obj5 != null && (obj5 instanceof String)) {
            contentValues.put(EVENT_SESSIONID, (String) obj5);
        }
        Object obj6 = trackerPayload.getMap().get("time");
        if (obj6 != null && (obj6 instanceof Long)) {
            contentValues.put("time", (Long) obj6);
        }
        Object obj7 = trackerPayload.getMap().get("page");
        if (obj7 != null && (obj7 instanceof String)) {
            contentValues.put("page", (String) obj7);
        }
        Object obj8 = trackerPayload.getMap().get("value");
        if (obj8 != null && (obj8 instanceof Map)) {
            String propertiesToJSONString = getPropertiesToJSONString((Map) obj8);
            if (!TextUtils.isEmpty(propertiesToJSONString)) {
                contentValues.put(EVENT_PROPERTIES, propertiesToJSONString);
            }
        }
        Object obj9 = trackerPayload.getMap().get("network");
        if (obj9 != null && (obj9 instanceof String)) {
            contentValues.put("network", (String) obj9);
        }
        Object obj10 = trackerPayload.getMap().get(Parameters.CHANNEL_ID);
        if (obj10 != null && (obj10 instanceof String)) {
            contentValues.put("channel", (String) obj10);
        }
        Object obj11 = trackerPayload.getMap().get(Parameters.FLYME_VER);
        if (obj11 != null && (obj11 instanceof String)) {
            contentValues.put(EVENT_FLYME_VERSION, (String) obj11);
        }
        return contentValues;
    }

    private String getPropertiesToJSONString(Map map) {
        String str;
        try {
            if (!(map instanceof Map) || map.size() <= 0) {
                str = map.toString();
            } else {
                JSONStringer jSONStringer = new JSONStringer();
                jSONStringer.object();
                for (Map.Entry entry : map.entrySet()) {
                    jSONStringer.key((String) entry.getKey()).value(entry.getValue());
                }
                jSONStringer.endObject();
                str = jSONStringer.toString();
            }
            return str;
        } catch (Exception | JSONException unused) {
            return "";
        }
    }
}
