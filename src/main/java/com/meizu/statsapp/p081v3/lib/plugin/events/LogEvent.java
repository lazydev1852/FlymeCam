package com.meizu.statsapp.p081v3.lib.plugin.events;

import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.events.LogEvent */
public class LogEvent extends Event {
    public static final String LOG_PACKAGE = "com.meizu.uxip.log";
    private Map<String, String> properties;
    private long time;

    protected LogEvent(String str, String str2) {
        super(str, str2);
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    public TrackerPayload generatePayload() {
        TrackerPayload trackerPayload = new TrackerPayload();
        trackerPayload.add("name", this.eventName);
        trackerPayload.add(Parameters.NETWORK, this.network);
        trackerPayload.add("type", Event.EVENT_TYPE_LOG);
        trackerPayload.add("time", Long.valueOf(this.time));
        trackerPayload.add("value", this.properties);
        return trackerPayload;
    }
}
