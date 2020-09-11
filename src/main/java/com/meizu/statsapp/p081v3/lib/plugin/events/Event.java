package com.meizu.statsapp.p081v3.lib.plugin.events;

import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import com.meizu.statsapp.p081v3.lib.plugin.utils.Preconditions;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.events.Event */
public abstract class Event {
    public static final String EVENT_TYPE_ACTION_X = "action_x";
    public static final String EVENT_TYPE_LOG = "log";
    public static final String EVENT_TYPE_PAGE = "page";
    protected final String eventName;
    protected final String network;

    public abstract TrackerPayload generatePayload();

    protected Event(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        this.eventName = str;
        this.network = str2;
    }

    public String getEventName() {
        return this.eventName;
    }

    public String getNetwork() {
        return this.network;
    }
}
