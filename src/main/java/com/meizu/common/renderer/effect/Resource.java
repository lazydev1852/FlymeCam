package com.meizu.common.renderer.effect;

import android.util.Log;

/* renamed from: com.meizu.common.renderer.effect.g */
public abstract class Resource {
    public abstract void trimResources(int i, boolean z);

    public Resource() {
        if (GLRenderer.f4380c) {
            Log.e("glrenderer", "Create Resource:" + this);
        }
    }

    public void releaseResources(boolean z) {
        trimResources(80, z);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            trimResources(80, false);
        } finally {
            super.finalize();
        }
    }
}
