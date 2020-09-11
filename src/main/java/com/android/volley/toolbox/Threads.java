package com.android.volley.toolbox;

import android.os.Looper;

/* renamed from: com.android.volley.toolbox.o */
public final class Threads {
    /* renamed from: a */
    static void m722a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Must be invoked from the main thread.");
        }
    }
}
