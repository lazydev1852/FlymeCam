package com.meizu.statsapp.p081v3.lib.plugin.tracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.Emitter;
import com.meizu.statsapp.p081v3.lib.plugin.events.Event;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import com.meizu.statsapp.p081v3.lib.plugin.sdk.IDIdentifierController;
import com.meizu.statsapp.p081v3.lib.plugin.sdk.SDKInstanceImpl;
import com.meizu.statsapp.p081v3.lib.plugin.session.SessionController;
import com.meizu.statsapp.p081v3.lib.plugin.tracker.subject.Subject;
import com.meizu.statsapp.p081v3.lib.plugin.utils.C2943Utils;
import com.meizu.statsapp.p081v3.lib.plugin.utils.FlymeOSUtils;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.tracker.Tracker */
public class Tracker {
    private static final String TAG = "Tracker";
    private Context context;
    private boolean debug;
    private Emitter emitter;
    private Map<String, EventFilter> eventFilterMap = new HashMap();
    private SDKInstanceImpl sdkInstance;

    /* renamed from: sp */
    private SharedPreferences f16000sp;
    private Subject subject;

    public void init(SDKInstanceImpl sDKInstanceImpl) {
        this.sdkInstance = sDKInstanceImpl;
    }

    /* renamed from: com.meizu.statsapp.v3.lib.plugin.tracker.Tracker$TrackerBuilder */
    public static class TrackerBuilder {
        /* access modifiers changed from: private */
        public final Context context;
        /* access modifiers changed from: private */
        public boolean debug;
        /* access modifiers changed from: private */
        public final Emitter emitter;
        /* access modifiers changed from: private */
        public Subject subject = null;

        public TrackerBuilder(Emitter emitter2, Context context2) {
            this.emitter = emitter2;
            this.context = context2;
        }

        public TrackerBuilder subject(Subject subject2) {
            this.subject = subject2;
            return this;
        }

        public TrackerBuilder debug(boolean z) {
            this.debug = z;
            return this;
        }

        public Tracker build() {
            return new Tracker(this);
        }
    }

    public Tracker(TrackerBuilder trackerBuilder) {
        this.emitter = trackerBuilder.emitter;
        this.subject = trackerBuilder.subject;
        this.context = trackerBuilder.context;
        this.debug = trackerBuilder.debug;
        this.subject.setDebug(trackerBuilder.debug);
        this.f16000sp = trackerBuilder.context.getSharedPreferences("com.meizu.statsapp.v3.event_filter", 0);
        for (Map.Entry<String, ?> value : this.f16000sp.getAll().entrySet()) {
            EventFilter fromString = EventFilter.fromString(value.getValue().toString());
            if (fromString != null) {
                this.eventFilterMap.put(fromString.getName(), fromString);
            }
        }
        Logger.m17381v(TAG, "Tracker created successfully.");
    }

    private void addCommon(TrackerPayload trackerPayload) {
        IDIdentifierController iDIdentifierController;
        SessionController sessionController = this.sdkInstance.getSessionController();
        if (sessionController != null) {
            trackerPayload.add(Parameters.SESSION_ID, sessionController.getOrGenerateSessionId());
            trackerPayload.add(Parameters.SOURCE, sessionController.getSource());
        }
        if (this.subject != null) {
            trackerPayload.addMap(this.subject.getDeviceInfo());
            trackerPayload.addMap(this.subject.getAppInfo());
            trackerPayload.addMap(this.subject.getSettingProperty());
            trackerPayload.addMap(this.subject.getVolatileProperty(this.context));
            trackerPayload.add(Parameters.EVENT_ATTRIB, this.subject.getEventAttributePairs());
        }
        if (FlymeOSUtils.kaiJiXiangDao(this.context) && (((FlymeOSUtils.isBrandMeizu() && !FlymeOSUtils.isPreFlyme8()) || C2943Utils.isAndroidQ()) && (iDIdentifierController = this.sdkInstance.getIDIdentifierController()) != null)) {
            trackerPayload.add(Parameters.OAID, iDIdentifierController.getOAID());
            trackerPayload.add(Parameters.VAID, iDIdentifierController.getVAID());
            trackerPayload.add(Parameters.AAID, iDIdentifierController.getAAID());
            if (FlymeOSUtils.isBrandMeizu()) {
                trackerPayload.add(Parameters.UDID, iDIdentifierController.getUDID());
            }
        }
        LocationFetcher locationFetcher = this.sdkInstance.getLocationFetcher();
        if (locationFetcher != null) {
            Location location = locationFetcher.getLocation();
            if (location != null) {
                trackerPayload.add(Parameters.LONGITUDE, Double.valueOf(location.getLongitude()));
                trackerPayload.add(Parameters.LATITUDE, Double.valueOf(location.getLatitude()));
                trackerPayload.add(Parameters.LOC_TIME, Long.valueOf(location.getTime()));
                return;
            }
            trackerPayload.add(Parameters.LONGITUDE, 0);
            trackerPayload.add(Parameters.LATITUDE, 0);
            trackerPayload.add(Parameters.LOC_TIME, 0);
        }
    }

    public void setEventFilterMap(Map<String, EventFilter> map) {
        this.eventFilterMap = map;
        SharedPreferences.Editor edit = this.f16000sp.edit();
        edit.clear();
        for (Map.Entry next : this.eventFilterMap.entrySet()) {
            edit.putString((String) next.getKey(), ((EventFilter) next.getValue()).toString());
        }
        edit.commit();
    }

    public Subject getSubject() {
        return this.subject;
    }

    public Emitter getEmitter() {
        return this.emitter;
    }

    public void track(Event event) {
        track(event, 1);
    }

    public void track(Event event, int i) {
        TrackerPayload generatePayload = event.generatePayload();
        addCommon(generatePayload);
        send(generatePayload, i);
    }

    public void trackX(Event event, int i, Map<String, Object> map) {
        TrackerPayload generatePayload = event.generatePayload();
        addCommon(generatePayload);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                generatePayload.add((String) next.getKey(), next.getValue());
            }
        }
        send(generatePayload, i);
    }

    private void send(TrackerPayload trackerPayload, int i) {
        int filterEvent = filterEvent(trackerPayload);
        if (filterEvent != -1) {
            if (i <= filterEvent) {
                i = filterEvent;
            }
            if (this.debug) {
                i = 2;
            }
            if (i == 2) {
                this.emitter.addRealtime(trackerPayload);
            } else if (i == 3) {
                this.emitter.addNeartime(trackerPayload);
            } else {
                this.emitter.add(trackerPayload);
            }
        }
    }

    private int filterEvent(TrackerPayload trackerPayload) {
        EventFilter eventFilter;
        if (this.eventFilterMap == null || (eventFilter = this.eventFilterMap.get(trackerPayload.getMap().get("name"))) == null) {
            return 1;
        }
        if (!eventFilter.isActive()) {
            Logger.m17380i(TAG, "eventFilterMap, Not Tracking for false active");
            return -1;
        } else if (eventFilter.isRealtime()) {
            return 2;
        } else {
            return eventFilter.isNeartime() ? 3 : 1;
        }
    }

    public void updateSessionSource(String str, String str2) {
        this.emitter.updateEventSource(str, str2);
    }
}
