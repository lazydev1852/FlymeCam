package com.meizu.common.renderer.effect;

import com.meizu.common.renderer.effect.p063c.Texture;
import java.util.Vector;

/* renamed from: com.meizu.common.renderer.effect.l */
public class TexturePool extends Resource {

    /* renamed from: a */
    private Vector<Texture> f4480a;

    /* renamed from: b */
    private int f4481b;

    public void trimResources(int i, boolean z) {
        synchronized (this) {
            for (int i2 = 0; i2 < this.f4480a.size(); i2++) {
                this.f4480a.get(i2).trimResources(i, z);
            }
            this.f4480a.clear();
            this.f4481b = 0;
        }
    }
}
