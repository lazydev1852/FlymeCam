package com.meizu.common.renderer.effect.p062b;

import com.meizu.common.renderer.effect.GLCanvas;
import java.util.ArrayList;

/* renamed from: com.meizu.common.renderer.effect.b.k */
public class RenderGroup extends Render {

    /* renamed from: a */
    protected ArrayList<Render> f4442a = new ArrayList<>();

    public RenderGroup(GLCanvas dVar) {
        super(dVar);
    }

    /* renamed from: a */
    public void mo15949a(Render jVar) {
        int i = 0;
        while (i < this.f4442a.size()) {
            if (!jVar.mo15947c().equals(this.f4442a.get(i).mo15947c())) {
                i++;
            } else {
                return;
            }
        }
        this.f4442a.add(jVar);
    }

    /* renamed from: a */
    public Render mo15948a(String str) {
        for (int i = 0; i < this.f4442a.size(); i++) {
            if (str.equals(this.f4442a.get(i).mo15947c())) {
                return this.f4442a.get(i);
            }
        }
        return null;
    }

    public void trimResources(int i, boolean z) {
        super.trimResources(i, z);
        for (int i2 = 0; i2 < this.f4442a.size(); i2++) {
            this.f4442a.get(i2).trimResources(i, z);
        }
        this.f4442a.clear();
    }
}
