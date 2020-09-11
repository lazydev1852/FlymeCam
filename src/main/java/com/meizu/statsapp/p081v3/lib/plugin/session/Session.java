package com.meizu.statsapp.p081v3.lib.plugin.session;

import android.content.Context;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.session.Session */
public class Session {
    private static String TAG = "Session";

    /* renamed from: id */
    private String f15998id;
    private long startTime;

    public Session(Context context) {
        this.f15998id = null;
        this.f15998id = UUID.randomUUID().toString();
        this.startTime = System.currentTimeMillis();
        String str = TAG;
        Logger.m17378d(str, "Tracker Session Object created, id:" + this.f15998id + ", startTime:" + this.startTime);
    }

    public Map getProperties() {
        Logger.m17381v(TAG, "Getting Session properties ...");
        HashMap hashMap = new HashMap();
        hashMap.put(Parameters.SESSION_ID, this.f15998id);
        return hashMap;
    }

    public String getId() {
        return this.f15998id;
    }

    public long getStartTime() {
        return this.startTime;
    }
}
