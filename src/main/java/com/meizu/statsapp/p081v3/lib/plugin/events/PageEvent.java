package com.meizu.statsapp.p081v3.lib.plugin.events;

import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.events.PageEvent */
public class PageEvent extends Event {
    private String launch;
    private Map<String, String> properties;
    private String terminate;

    protected PageEvent(String str, String str2) {
        super(str, str2);
    }

    public void setLaunch(String str) {
        this.launch = str;
    }

    public void setTerminate(String str) {
        this.terminate = str;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    public TrackerPayload generatePayload() {
        TrackerPayload trackerPayload = new TrackerPayload();
        trackerPayload.add("name", this.eventName);
        trackerPayload.add(Parameters.NETWORK, this.network);
        trackerPayload.add("type", "page");
        trackerPayload.add(Parameters.LAUNCH, this.launch);
        trackerPayload.add(Parameters.TERMINATE, this.terminate);
        if (this.properties != null && this.properties.size() > 0) {
            trackerPayload.add("value", this.properties);
        }
        return trackerPayload;
    }
}
