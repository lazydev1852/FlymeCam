package com.meizu.statsapp.p081v3.lib.plugin.events;

import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.events.ActionXEvent */
public class ActionXEvent extends Event {
    private Map<String, String> event_attrib;
    private String page;
    private Map<String, String> properties;
    private long time;

    protected ActionXEvent(String str, String str2) {
        super(str, str2);
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setPage(String str) {
        this.page = str;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    public void setEvent_attrib(Map<String, String> map) {
        this.event_attrib = map;
    }

    public TrackerPayload generatePayload() {
        TrackerPayload trackerPayload = new TrackerPayload();
        trackerPayload.add("name", this.eventName);
        trackerPayload.add(Parameters.NETWORK, this.network);
        trackerPayload.add("type", Event.EVENT_TYPE_ACTION_X);
        trackerPayload.add("time", Long.valueOf(this.time));
        trackerPayload.add("page", this.page);
        trackerPayload.add("value", this.properties);
        trackerPayload.add(Parameters.EVENT_ATTRIB, this.event_attrib);
        return trackerPayload;
    }
}
