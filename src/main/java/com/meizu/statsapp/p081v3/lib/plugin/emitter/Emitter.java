package com.meizu.statsapp.p081v3.lib.plugin.emitter;

import android.content.Context;
import android.content.SharedPreferences;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.Emitter */
public abstract class Emitter {
    protected EmitterConfig emitterConfig;
    protected Context mContext;
    private SharedPreferences mSP;

    public abstract void add(TrackerPayload trackerPayload);

    public abstract void addNeartime(TrackerPayload trackerPayload);

    public abstract void addRealtime(TrackerPayload trackerPayload);

    public abstract void flush();

    public abstract String getUMID();

    public abstract void init();

    public abstract void setEncrypt(boolean z);

    public abstract void updateEventSource(String str, String str2);

    public Emitter(Context context, String str) {
        this.mContext = context;
        this.mSP = context.getSharedPreferences(UxipConstants.PREFERENCES_EMITTER_CONFIG_NAME, 0);
        this.emitterConfig = new EmitterConfig(str);
        readConfigFromPreference();
    }

    public void updateConfig(boolean z, boolean z2, boolean z3, boolean z4, long j, int i, long j2, int i2) {
        SharedPreferences.Editor edit = this.mSP.edit();
        edit.putBoolean("active", z);
        edit.putBoolean("flushOnStart", z2);
        edit.putBoolean("flushOnReconnect", z3);
        edit.putBoolean("flushOnCharge", z4);
        edit.putLong("flushDelayInterval", j);
        edit.putLong("flushMobileTrafficLimit", j2);
        edit.putInt("flushCacheLimit", i);
        edit.putInt(UxipConstants.RESPONSE_KEY_UPLOADPOLICY_NEARTIME_INTERVAL, i2);
        edit.apply();
        readConfigFromPreference();
    }

    private void readConfigFromPreference() {
        this.emitterConfig.active = this.mSP.getBoolean("active", true);
        this.emitterConfig.flushOnStart = this.mSP.getBoolean("flushOnStart", true);
        this.emitterConfig.flushOnReconnect = this.mSP.getBoolean("flushOnReconnect", true);
        this.emitterConfig.flushOnCharge = this.mSP.getBoolean("flushOnCharge", true);
        this.emitterConfig.flushDelayInterval = this.mSP.getLong("flushDelayInterval", 1800000);
        this.emitterConfig.flushCacheLimit = this.mSP.getInt("flushCacheLimit", 50);
        this.emitterConfig.flushMobileTrafficLimit = this.mSP.getLong("flushMobileTrafficLimit", 2097152);
        this.emitterConfig.neartimeInterval = this.mSP.getInt(UxipConstants.RESPONSE_KEY_UPLOADPOLICY_NEARTIME_INTERVAL, 5);
    }
}
