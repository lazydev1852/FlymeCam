package com.meizu.statsapp.p081v3.lib.plugin.emitter.local;

import android.content.Context;
import com.meizu.statsapp.p081v3.lib.plugin.emitter.Emitter;
import com.meizu.statsapp.p081v3.lib.plugin.payload.TrackerPayload;
import com.meizu.statsapp.p081v3.lib.plugin.sdk.UmidFetcher;
import com.meizu.statsapp.p081v3.utils.log.Logger;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.local.LocalEmitter */
public class LocalEmitter extends Emitter {
    private static final String TAG = "LocalEmitter";
    private LocalEmitterWorker emitterWorker;

    public LocalEmitter(Context context, String str) {
        super(context, str);
        this.emitterWorker = new LocalEmitterWorker(context, this.emitterConfig);
    }

    public void init() {
        Logger.m17378d(TAG, "init");
        this.emitterWorker.init();
    }

    public void updateConfig(boolean z, boolean z2, boolean z3, boolean z4, long j, int i, long j2, int i2) {
        super.updateConfig(z, z2, z3, z4, j, i, j2, i2);
        this.emitterWorker.updateConfig(this.emitterConfig);
    }

    public void add(TrackerPayload trackerPayload) {
        Logger.m17378d(TAG, "add payload: " + trackerPayload.toString());
        if (this.emitterConfig.isActive()) {
            this.emitterWorker.add(trackerPayload);
        }
    }

    public void addRealtime(TrackerPayload trackerPayload) {
        Logger.m17378d(TAG, "addRealtime payload: " + trackerPayload.toString());
        if (this.emitterConfig.isActive()) {
            this.emitterWorker.addRealtime(trackerPayload);
        }
    }

    public void addNeartime(TrackerPayload trackerPayload) {
        Logger.m17378d(TAG, "addNeartime payload: " + trackerPayload.toString());
        if (this.emitterConfig.isActive()) {
            this.emitterWorker.addNeartime(trackerPayload);
        }
    }

    public void flush() {
        Logger.m17378d(TAG, "flush");
        this.emitterWorker.flush();
    }

    public void updateEventSource(String str, String str2) {
        this.emitterWorker.updateEventSource(str, str2);
    }

    public void setEncrypt(boolean z) {
        this.emitterWorker.setEncrypt(z);
    }

    public String getUMID() {
        return UmidFetcher.getInstance(this.mContext).readUmidFromLocal();
    }
}
