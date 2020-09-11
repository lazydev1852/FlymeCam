package com.meizu.statsapp.p081v3.lib.plugin.emitter;

import android.content.Context;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.emitter.EmitterWorker */
public abstract class EmitterWorker {
    private static final String TAG = "EmitterWorker";
    protected Context context;

    public EmitterWorker(Context context2) {
        this.context = context2;
    }
}
