package com.meizu.statsapp.p081v3.lib.plugin.emitter;

import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.EmittableEvent */
public class EmittableEvent {
    private long eventId;
    private TrackerPayload eventPayload = null;
    private String packageName = null;

    public EmittableEvent(String str, long j, TrackerPayload trackerPayload) {
        this.packageName = str;
        this.eventId = j;
        this.eventPayload = trackerPayload;
    }

    public long getId() {
        return this.eventId;
    }

    public TrackerPayload getPayload() {
        return this.eventPayload;
    }
}
