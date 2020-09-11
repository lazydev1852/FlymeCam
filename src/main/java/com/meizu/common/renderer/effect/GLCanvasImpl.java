package com.meizu.common.renderer.effect;

import android.util.Log;
import com.meizu.common.renderer.effect.p062b.FishEyeRender;
import com.meizu.common.renderer.effect.p062b.FogRender;
import com.meizu.common.renderer.effect.p062b.GrayRender;
import com.meizu.common.renderer.effect.p062b.MosaicRender;
import com.meizu.common.renderer.effect.p062b.NoneRender;
import com.meizu.common.renderer.effect.p062b.Render;
import com.meizu.common.renderer.effect.p062b.RenderGroup;
import com.meizu.common.renderer.effect.p062b.SeventyRender;
import com.meizu.common.renderer.effect.p062b.SketchEffectRender;
import com.meizu.common.renderer.effect.p062b.StaticBlurRender;
import com.meizu.common.renderer.effect.p062b.VividRender;
import com.meizu.common.renderer.effect.p062b.WaterRender;
import com.meizu.common.renderer.effect.p062b.YesteryearRender;

/* renamed from: com.meizu.common.renderer.effect.e */
public class GLCanvasImpl extends Resource implements GLCanvas {

    /* renamed from: a */
    private StateMachine f4467a;

    /* renamed from: b */
    private RenderGroup f4468b;

    /* renamed from: a */
    public Render mo15955a(String str) {
        Render a = this.f4468b.mo15948a(str);
        if (a != null) {
            return a;
        }
        Render b = m5083b(str);
        if (b != null) {
            this.f4468b.mo15949a(b);
        }
        return b;
    }

    /* renamed from: a */
    public void mo15957a(Render jVar) {
        if (jVar == null) {
            return;
        }
        if (jVar.mo15947c().equals("__none")) {
            Log.e("glrenderer", "Add render fail ,key = " + jVar.mo15947c());
            return;
        }
        this.f4468b.mo15949a(jVar);
    }

    public void trimResources(int i, boolean z) {
        if (i >= 20) {
            this.f4467a.mo15968a();
        }
        if (i > 60) {
            this.f4468b.trimResources(i, z);
        }
    }

    /* renamed from: a */
    public void mo15956a(int i, boolean z) {
        GLRenderer.m5035d().mo15961a(i, z);
    }

    /* renamed from: b */
    public void mo15958b(int i, boolean z) {
        GLRenderer.m5035d().mo15964c(i, z);
    }

    /* renamed from: c */
    public void mo15959c(int i, boolean z) {
        GLRenderer.m5035d().mo15963b(i, z);
    }

    /* renamed from: d */
    public void mo15960d(int i, boolean z) {
        GLRenderer.m5035d().mo15965d(i, z);
    }

    /* renamed from: b */
    private Render m5083b(String str) {
        if ("__none".equals(str)) {
            return new NoneRender(this);
        }
        if ("__static_blur".equals(str)) {
            return new StaticBlurRender(this);
        }
        if ("__gray".equals(str)) {
            return new GrayRender(this);
        }
        if ("__fog".equals(str)) {
            return new FogRender(this);
        }
        if ("__water".equals(str)) {
            return new WaterRender(this);
        }
        if ("__yesterday".equals(str)) {
            return new YesteryearRender(this);
        }
        if ("__vivid".equals(str)) {
            return new VividRender(this);
        }
        if ("__seventy".equals(str)) {
            return new SeventyRender(this);
        }
        if ("__fisheye".equals(str)) {
            return new FishEyeRender(this);
        }
        if ("__mosaic".equals(str)) {
            return new MosaicRender(this);
        }
        if ("__sketch".equals(str)) {
            return new SketchEffectRender(this);
        }
        return null;
    }
}
