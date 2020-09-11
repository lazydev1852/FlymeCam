package com.meizu.cloud.pushsdk.pushtracer.event;

import com.meizu.cloud.pushsdk.pushtracer.dataload.SelfDescribingJson;
import com.meizu.cloud.pushsdk.pushtracer.dataload.TrackerDataload;
import com.meizu.cloud.pushsdk.pushtracer.utils.Preconditions;
import com.meizu.cloud.pushsdk.pushtracer.utils.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Event {
    protected final String eventId;
    protected final List<SelfDescribingJson> selfDescribingJsonList;
    protected final long timestamp;

    public static abstract class Builder<T extends Builder<T>> {
        /* access modifiers changed from: private */
        public String eventId = Util.getEventId();
        /* access modifiers changed from: private */
        public List<SelfDescribingJson> selfDescribingJsonList = new LinkedList();
        /* access modifiers changed from: private */
        public long timestamp = System.currentTimeMillis();

        /* access modifiers changed from: protected */
        public abstract T self();

        public T customContext(List<SelfDescribingJson> list) {
            this.selfDescribingJsonList = list;
            return self();
        }

        public T timestamp(long j) {
            this.timestamp = j;
            return self();
        }

        public T eventId(String str) {
            this.eventId = str;
            return self();
        }

        public Event build() {
            return new Event(this);
        }
    }

    private static class Builder2 extends Builder<Builder2> {
        /* access modifiers changed from: protected */
        public Builder2 self() {
            return this;
        }

        private Builder2() {
        }
    }

    public static Builder<?> builder() {
        return new Builder2();
    }

    protected Event(Builder<?> builder) {
        Preconditions.checkNotNull(builder.selfDescribingJsonList);
        Preconditions.checkNotNull(builder.eventId);
        Preconditions.checkArgument(!builder.eventId.isEmpty(), "eventId cannot be empty");
        this.selfDescribingJsonList = builder.selfDescribingJsonList;
        this.timestamp = builder.timestamp;
        this.eventId = builder.eventId;
    }

    public List<SelfDescribingJson> getSelfDescribingJson() {
        return new ArrayList(this.selfDescribingJsonList);
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getEventId() {
        return this.eventId;
    }

    /* access modifiers changed from: protected */
    public TrackerDataload putDefaultParams(TrackerDataload trackerDataload) {
        trackerDataload.add("ei", getEventId());
        trackerDataload.add("ts", Long.toString(getTimestamp()));
        return trackerDataload;
    }
}
