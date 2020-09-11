package com.meizu.common.renderer.effect;

import java.util.Vector;

/* renamed from: com.meizu.common.renderer.effect.c */
public class FrameBufferPool extends Resource {

    /* renamed from: a */
    private Vector<FrameBuffer> f4457a;

    /* renamed from: b */
    private int f4458b;

    public void trimResources(int i, boolean z) {
        synchronized (this) {
            for (int i2 = 0; i2 < this.f4457a.size(); i2++) {
                this.f4457a.get(i2).trimResources(i, z);
            }
            this.f4457a.clear();
            this.f4458b = 0;
        }
    }
}
