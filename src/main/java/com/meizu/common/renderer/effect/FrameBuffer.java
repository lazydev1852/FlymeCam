package com.meizu.common.renderer.effect;

import com.meizu.common.renderer.effect.p063c.Texture;

/* renamed from: com.meizu.common.renderer.effect.b */
public class FrameBuffer extends Resource {

    /* renamed from: a */
    protected int[] f4411a = new int[1];

    /* renamed from: b */
    protected int[] f4412b = new int[1];

    /* renamed from: c */
    protected Texture f4413c;

    /* renamed from: d */
    protected GLCanvas f4414d;

    /* renamed from: e */
    protected boolean f4415e;

    protected FrameBuffer() {
    }

    /* renamed from: a */
    public int mo15942a() {
        return this.f4411a[0];
    }

    public void trimResources(int i, boolean z) {
        if (this.f4414d != null) {
            this.f4413c.trimResources(i, z);
            this.f4414d.mo15958b(mo15942a(), z);
            if (this.f4415e && this.f4412b[0] != 0) {
                this.f4414d.mo15959c(this.f4412b[0], z);
                this.f4412b[0] = 0;
            }
            this.f4411a[0] = 0;
            this.f4414d = null;
        }
    }
}
