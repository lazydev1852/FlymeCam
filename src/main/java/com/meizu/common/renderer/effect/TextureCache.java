package com.meizu.common.renderer.effect;

import android.util.LruCache;

/* renamed from: com.meizu.common.renderer.effect.k */
public class TextureCache extends Resource {

    /* renamed from: a */
    private LruCache<String, Object> f4479a;

    public void trimResources(int i, boolean z) {
        this.f4479a.trimToSize(0);
    }
}
