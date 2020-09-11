package com.meizu.statsapp.p081v3.lib.plugin.emitter;

import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import com.meizu.statsapp.p081v3.lib.plugin.secure.SimpleCryptoAES;
import com.meizu.statsapp.p081v3.utils.log.Logger;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.EventBean */
public class EventBean {
    private static String TAG = "EventBean";
    private static final String masterPassword = "76!t5#x04&^to3ek";
    String dateCreated;
    int encrypt;
    String eventData;
    String eventSource;

    /* renamed from: id */
    long f15987id;
    String sessionId;

    public long getId() {
        return this.f15987id;
    }

    public void setId(long j) {
        this.f15987id = j;
    }

    public int getEncrypt() {
        return this.encrypt;
    }

    public void setEncrypt(int i) {
        this.encrypt = i;
    }

    public String getEventSource() {
        return this.eventSource;
    }

    public void setEventSource(String str) {
        this.eventSource = str;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String getEventData() {
        return this.eventData;
    }

    public void setEventData(String str) {
        this.eventData = str;
    }

    public String getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(String str) {
        this.dateCreated = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0081 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload toPayload(com.meizu.statsapp.p081v3.lib.plugin.emitter.EventBean r7) {
        /*
            int r0 = r7.getEncrypt()
            r1 = 0
            if (r0 == 0) goto L_0x0064
            com.meizu.statsapp.v3.lib.plugin.secure.SimpleCryptoAES r2 = com.meizu.statsapp.p081v3.lib.plugin.secure.SimpleCryptoAES.get()     // Catch:{ Exception -> 0x0033 }
            java.lang.String r3 = "76!t5#x04&^to3ek"
            java.lang.String r4 = r7.getEventData()     // Catch:{ Exception -> 0x0033 }
            java.lang.String r2 = r2.decrypt(r3, r4, r0)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r3 = TAG     // Catch:{ Exception -> 0x0031 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0031 }
            r4.<init>()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r5 = "SimpleCryptoAES decrypt["
            r4.append(r5)     // Catch:{ Exception -> 0x0031 }
            r4.append(r0)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r5 = "] done"
            r4.append(r5)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0031 }
            com.meizu.statsapp.p081v3.utils.log.Logger.m17378d(r3, r4)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0068
        L_0x0031:
            r3 = move-exception
            goto L_0x0035
        L_0x0033:
            r3 = move-exception
            r2 = r1
        L_0x0035:
            java.lang.String r4 = TAG
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "SimpleCryptoAES decrypt["
            r5.append(r6)
            r5.append(r0)
            java.lang.String r0 = "], Exception: "
            r5.append(r0)
            java.lang.String r0 = r3.toString()
            r5.append(r0)
            java.lang.String r0 = " - Cause: "
            r5.append(r0)
            java.lang.Throwable r0 = r3.getCause()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            com.meizu.statsapp.p081v3.utils.log.Logger.m17382w(r4, r0)
            goto L_0x0068
        L_0x0064:
            java.lang.String r2 = r7.getEventData()
        L_0x0068:
            com.meizu.statsapp.v3.lib.plugin.payload.TrackerPayload r0 = com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload.fromString(r2)
            if (r0 == 0) goto L_0x0081
            java.lang.String r1 = "sid"
            java.lang.String r2 = r7.getSessionId()
            r0.add(r1, r2)
            java.lang.String r1 = "source"
            java.lang.String r7 = r7.getEventSource()
            r0.add(r1, r7)
            return r0
        L_0x0081:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.statsapp.p081v3.lib.plugin.emitter.EventBean.toPayload(com.meizu.statsapp.v3.lib.plugin.emitter.EventBean):com.meizu.statsapp.v3.lib.plugin.payload.TrackerPayload");
    }

    public static EventBean fromPayload(int i, TrackerPayload trackerPayload) {
        String str;
        Exception e;
        EventBean eventBean = new EventBean();
        eventBean.setEncrypt(i);
        String str2 = (String) trackerPayload.getMap().get(Parameters.SESSION_ID);
        String str3 = (String) trackerPayload.getMap().get(Parameters.SOURCE);
        eventBean.setSessionId(str2);
        eventBean.setEventSource(str3);
        trackerPayload.getMap().remove(Parameters.SESSION_ID);
        trackerPayload.getMap().remove(Parameters.SOURCE);
        int encrypt2 = eventBean.getEncrypt();
        if (encrypt2 != 0) {
            try {
                str = SimpleCryptoAES.get().encrypt(masterPassword, trackerPayload.toString(), encrypt2);
                try {
                    Logger.m17378d(TAG, "SimpleCryptoAES encrypt[" + encrypt2 + "] done");
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                Exception exc = e3;
                str = null;
                e = exc;
                Logger.m17382w(TAG, "SimpleCryptoAES encrypt[" + encrypt2 + "], Exception: " + e.toString() + " - Cause: " + e.getCause());
                eventBean.setEventData(str);
                trackerPayload.add(Parameters.SESSION_ID, str2);
                trackerPayload.add(Parameters.SOURCE, str3);
                return eventBean;
            }
        } else {
            str = trackerPayload.toString();
        }
        eventBean.setEventData(str);
        trackerPayload.add(Parameters.SESSION_ID, str2);
        trackerPayload.add(Parameters.SOURCE, str3);
        return eventBean;
    }
}
