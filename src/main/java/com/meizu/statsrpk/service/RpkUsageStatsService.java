package com.meizu.statsrpk.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.mediatek.util.MtkPatterns;
import com.meizu.statsapp.p081v3.UsageStatsProxy3;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.events.Event;
import com.meizu.statsapp.p081v3.lib.plugin.events.EventUtil;
import com.meizu.statsapp.p081v3.lib.plugin.events.PageEvent;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import com.meizu.statsapp.p081v3.lib.plugin.tracker.LocationFetcher;
import com.meizu.statsapp.p081v3.lib.plugin.tracker.subject.Subject;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import com.meizu.statsrpk.IRpkStatsInterface;
import com.meizu.statsrpk.RpkEvent;
import com.meizu.statsrpk.RpkInfo;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class RpkUsageStatsService extends Service {

    /* renamed from: a */
    private String f16022a = RpkUsageStatsService.class.getSimpleName();

    /* renamed from: b */
    private IInterface f16023b;

    public IBinder onBind(Intent intent) {
        String str = this.f16022a;
        Logger.m17378d(str, "onBind intent: " + intent);
        synchronized (RpkUsageStatsService.class) {
            if (this.f16023b == null) {
                this.f16023b = new C2948a(this);
            }
        }
        IBinder asBinder = this.f16023b.asBinder();
        String str2 = this.f16022a;
        Logger.m17378d(str2, "onBind return binder: " + asBinder);
        return asBinder;
    }

    public void onCreate() {
        super.onCreate();
        Logger.m17378d(this.f16022a, "onCreate");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        String str = this.f16022a;
        Logger.m17378d(str, "onStartCommand intent: " + intent);
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        super.onDestroy();
        Logger.m17378d(this.f16022a, "onDestroy");
    }

    /* renamed from: com.meizu.statsrpk.service.RpkUsageStatsService$a */
    class C2948a extends IRpkStatsInterface.C2947a {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public RpkEmitterWorker f16025b;

        /* renamed from: c */
        private ScheduledExecutorService f16026c = Executors.newScheduledThreadPool(1);
        /* access modifiers changed from: private */

        /* renamed from: d */
        public Subject f16027d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public final Context f16028e;

        C2948a(final Context context) {
            this.f16028e = context;
            this.f16026c.execute(new Runnable(RpkUsageStatsService.this) {
                public void run() {
                    Subject.SubjectBuilder subjectBuilder = new Subject.SubjectBuilder();
                    subjectBuilder.context(context);
                    Subject unused = C2948a.this.f16027d = subjectBuilder.build();
                    RpkEmitterWorker unused2 = C2948a.this.f16025b = new RpkEmitterWorker(C2948a.this.f16028e, 1);
                }
            });
        }

        /* renamed from: a */
        public void mo24586a(final RpkEvent rpkEvent, final RpkInfo rpkInfo) throws RemoteException {
            this.f16026c.execute(new Runnable() {
                public void run() {
                    LocationFetcher locationFetcher;
                    if (C2948a.this.f16025b != null) {
                        TrackerPayload trackerPayload = null;
                        if (rpkEvent.f16003a.equals(Event.EVENT_TYPE_ACTION_X)) {
                            trackerPayload = EventUtil.buildActionXEvent(C2948a.this.f16028e, rpkEvent.f16004b, rpkEvent.f16005c, rpkEvent.f16006d).generatePayload();
                            trackerPayload.add(Parameters.SESSION_ID, rpkEvent.f16007e);
                        } else if (rpkEvent.f16003a.equals("page")) {
                            PageEvent buildPageEvent = EventUtil.buildPageEvent(C2948a.this.f16028e, rpkEvent.f16004b, (String) rpkEvent.f16006d.get(MtkPatterns.KEY_URLDATA_START), (String) rpkEvent.f16006d.get(MtkPatterns.KEY_URLDATA_END));
                            HashMap hashMap = new HashMap();
                            hashMap.put("duration2", String.valueOf((String) rpkEvent.f16006d.get("duration2")));
                            buildPageEvent.setProperties(hashMap);
                            trackerPayload = buildPageEvent.generatePayload();
                            trackerPayload.add(Parameters.SESSION_ID, rpkEvent.f16007e);
                        }
                        if (trackerPayload != null) {
                            if (C2948a.this.f16027d != null) {
                                trackerPayload.addMap(C2948a.this.f16027d.getDeviceInfo());
                                trackerPayload.addMap(C2948a.this.f16027d.getAppInfo());
                                trackerPayload.addMap(C2948a.this.f16027d.getSettingProperty());
                                trackerPayload.addMap(C2948a.this.f16027d.getVolatileProperty(C2948a.this.f16028e));
                            }
                            if (!(UsageStatsProxy3.getInstance() == null || UsageStatsProxy3.getInstance().getLocationFetcher() == null || (locationFetcher = UsageStatsProxy3.getInstance().getLocationFetcher()) == null)) {
                                Location location = locationFetcher.getLocation();
                                if (location != null) {
                                    trackerPayload.add(Parameters.LONGITUDE, Double.valueOf(location.getLongitude()));
                                    trackerPayload.add(Parameters.LATITUDE, Double.valueOf(location.getLatitude()));
                                    trackerPayload.add(Parameters.LOC_TIME, Long.valueOf(location.getTime()));
                                } else {
                                    trackerPayload.add(Parameters.LONGITUDE, 0);
                                    trackerPayload.add(Parameters.LATITUDE, 0);
                                    trackerPayload.add(Parameters.LOC_TIME, 0);
                                }
                            }
                            C2948a.this.m17403a(trackerPayload, rpkInfo);
                            C2948a.this.f16025b.mo24603a(rpkInfo.f16012e, rpkInfo.f16008a, trackerPayload);
                        }
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m17403a(TrackerPayload trackerPayload, RpkInfo rpkInfo) {
            trackerPayload.add(Parameters.PKG_NAME, rpkInfo.f16011d);
            trackerPayload.add(Parameters.PKG_VER, rpkInfo.f16009b);
            trackerPayload.add(Parameters.PKG_VER_CODE, Integer.valueOf(rpkInfo.f16010c));
            trackerPayload.add(Parameters.CHANNEL_ID, "102027");
            HashMap hashMap = new HashMap();
            hashMap.put("rpkPkgName", rpkInfo.f16008a);
            trackerPayload.add(Parameters.EVENT_ATTRIB, hashMap);
        }
    }
}
