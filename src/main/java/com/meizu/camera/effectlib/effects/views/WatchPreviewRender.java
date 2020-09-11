package com.meizu.camera.effectlib.effects.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.meizu.camera.effectlib.effects.p059b.BaseRender;
import com.meizu.common.renderer.functor.DrawGLFunctor;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class WatchPreviewRender extends View {

    /* renamed from: a */
    public static ChangeQuickRedirect f4011a;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final float[] f4012e = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final float[] f4013f = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: b */
    protected final float[] f4014b = new float[16];

    /* renamed from: c */
    private C1186a f4015c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public BaseRender f4016d;

    public WatchPreviewRender(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public WatchPreviewRender(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WatchPreviewRender(Context context) {
        super(context);
    }

    public void setRender(BaseRender aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f4011a, false, 467, new Class[]{BaseRender.class}, Void.TYPE).isSupported) {
            this.f4016d = aVar;
            if (this.f4016d == null) {
                return;
            }
            if (this.f4016d.mo14046c().mo14345d().equals("Mzfacebeauty")) {
                EffectRenderContext.m4369h().mo14210e(false);
            } else {
                EffectRenderContext.m4369h().mo14210e(true);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f4011a, false, 468, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            this.f4015c.draw(canvas);
            invalidate();
        }
    }

    /* renamed from: com.meizu.camera.effectlib.effects.views.WatchPreviewRender$a */
    protected class C1186a extends DrawGLFunctor {

        /* renamed from: a */
        public static ChangeQuickRedirect f4017a;

        /* renamed from: b */
        final /* synthetic */ WatchPreviewRender f4018b;

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0106, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onDraw(com.meizu.common.renderer.functor.DrawGLFunctor.GLInfo r10) {
            /*
                r9 = this;
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r8 = 0
                r1[r8] = r10
                com.meizu.savior.ChangeQuickRedirect r3 = f4017a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class<com.meizu.common.renderer.functor.DrawGLFunctor$GLInfo> r0 = com.meizu.common.renderer.functor.DrawGLFunctor.GLInfo.class
                r6[r8] = r0
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 469(0x1d5, float:6.57E-43)
                r2 = r9
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r0 = r0.isSupported
                if (r0 == 0) goto L_0x001d
                return
            L_0x001d:
                monitor-enter(r9)
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0107 }
                boolean r0 = r0.mo14234r()     // Catch:{ all -> 0x0107 }
                if (r0 != 0) goto L_0x002a
                monitor-exit(r9)     // Catch:{ all -> 0x0107 }
                return
            L_0x002a:
                int r2 = r10.clipLeft     // Catch:{ all -> 0x0107 }
                int r10 = r10.clipTop     // Catch:{ all -> 0x0107 }
                android.graphics.Rect r10 = r9.mSourceBounds     // Catch:{ all -> 0x0107 }
                int r4 = r10.width()     // Catch:{ all -> 0x0107 }
                android.graphics.Rect r10 = r9.mSourceBounds     // Catch:{ all -> 0x0107 }
                int r10 = r10.height()     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.views.WatchPreviewRender r0 = r9.f4018b     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.b.a r0 = r0.f4016d     // Catch:{ all -> 0x0107 }
                if (r0 == 0) goto L_0x0105
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0107 }
                int r1 = r0.mo14240x()     // Catch:{ all -> 0x0107 }
                int r3 = r0.mo14239w()     // Catch:{ all -> 0x0107 }
                float r3 = (float) r3     // Catch:{ all -> 0x0107 }
                float r1 = (float) r1     // Catch:{ all -> 0x0107 }
                float r3 = r3 / r1
                float[] r1 = r0.mo14158C()     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.views.WatchPreviewRender r5 = r9.f4018b     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.b.a r5 = r5.f4016d     // Catch:{ all -> 0x0107 }
                float[] r6 = com.meizu.camera.effectlib.effects.views.WatchPreviewRender.f4012e     // Catch:{ all -> 0x0107 }
                r5.mo14043a(r6)     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.views.WatchPreviewRender r5 = r9.f4018b     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.b.a r5 = r5.f4016d     // Catch:{ all -> 0x0107 }
                float[] r6 = com.meizu.camera.effectlib.effects.views.WatchPreviewRender.f4013f     // Catch:{ all -> 0x0107 }
                r5.mo14045b(r6)     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.views.WatchPreviewRender r5 = r9.f4018b     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.b.a r5 = r5.f4016d     // Catch:{ all -> 0x0107 }
                r5.mo14049d(r1)     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.a.c r1 = r0.mo14156A()     // Catch:{ all -> 0x0107 }
                if (r1 == 0) goto L_0x0105
                boolean r0 = r0.mo14221i()     // Catch:{ all -> 0x0107 }
                if (r0 == 0) goto L_0x00b2
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0107 }
                r0.mo14214g((int) r8)     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0107 }
                r0.mo14217h((int) r8)     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.views.WatchPreviewRender r0 = r9.f4018b     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.b.a r0 = r0.f4016d     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.views.WatchPreviewRender r5 = r9.f4018b     // Catch:{ all -> 0x0107 }
                float[] r5 = r5.f4014b     // Catch:{ all -> 0x0107 }
                r0.mo14047c(r5)     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.views.WatchPreviewRender r0 = r9.f4018b     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.b.a r0 = r0.f4016d     // Catch:{ all -> 0x0107 }
                int r10 = r10 + r4
                int r10 = r10 / 2
                float r5 = (float) r4     // Catch:{ all -> 0x0107 }
                float r5 = r5 * r3
                int r5 = (int) r5     // Catch:{ all -> 0x0107 }
                int r3 = r10 - r5
                r0.mo14040a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0107 }
                goto L_0x0105
            L_0x00b2:
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0107 }
                boolean r0 = r0.mo14236t()     // Catch:{ all -> 0x0107 }
                if (r0 == 0) goto L_0x00e8
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0107 }
                r0.mo14214g((int) r8)     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x0107 }
                r0.mo14217h((int) r8)     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.views.WatchPreviewRender r0 = r9.f4018b     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.b.a r0 = r0.f4016d     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.views.WatchPreviewRender r5 = r9.f4018b     // Catch:{ all -> 0x0107 }
                float[] r5 = r5.f4014b     // Catch:{ all -> 0x0107 }
                r0.mo14047c(r5)     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.views.WatchPreviewRender r0 = r9.f4018b     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.b.a r0 = r0.f4016d     // Catch:{ all -> 0x0107 }
                float r5 = (float) r4     // Catch:{ all -> 0x0107 }
                float r5 = r5 * r3
                int r5 = (int) r5     // Catch:{ all -> 0x0107 }
                int r10 = r10 - r5
                int r3 = r10 / 2
                r0.mo14040a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0107 }
                goto L_0x0105
            L_0x00e8:
                com.meizu.camera.effectlib.effects.views.WatchPreviewRender r0 = r9.f4018b     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.b.a r0 = r0.f4016d     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.views.WatchPreviewRender r5 = r9.f4018b     // Catch:{ all -> 0x0107 }
                float[] r5 = r5.f4014b     // Catch:{ all -> 0x0107 }
                r0.mo14047c(r5)     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.views.WatchPreviewRender r0 = r9.f4018b     // Catch:{ all -> 0x0107 }
                com.meizu.camera.effectlib.effects.b.a r0 = r0.f4016d     // Catch:{ all -> 0x0107 }
                float r5 = (float) r4     // Catch:{ all -> 0x0107 }
                float r5 = r5 * r3
                int r5 = (int) r5     // Catch:{ all -> 0x0107 }
                int r10 = r10 - r5
                int r3 = r10 / 2
                r0.mo14040a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0107 }
            L_0x0105:
                monitor-exit(r9)     // Catch:{ all -> 0x0107 }
                return
            L_0x0107:
                r10 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0107 }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.WatchPreviewRender.C1186a.onDraw(com.meizu.common.renderer.functor.DrawGLFunctor$GLInfo):void");
        }
    }
}
