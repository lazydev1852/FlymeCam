package com.meizu.camera.effectlib.effects.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.meizu.camera.effectlib.effects.p059b.BaseRender;
import com.meizu.common.renderer.functor.DrawGLFunctor;
import com.meizu.common.renderer.functor.InvokeFunctor;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

public class EffectPreviewRenderView extends View {

    /* renamed from: a */
    public static ChangeQuickRedirect f3767a;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final float[] f3768e = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final float[] f3769f = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: b */
    protected InvokeFunctor f3770b = new InvokeFunctor() {
        public static ChangeQuickRedirect changeQuickRedirect;

        public void onInvoke(int i) {
            if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, changeQuickRedirect, false, 267, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
                Log.i("glrenderer", "onInvoke  release");
                synchronized (this) {
                    Log.i("glrenderer", "EffectPreviewRenderView release");
                    if (EffectPreviewRenderView.this.f3772d != null && EffectRenderContext.m4369h().mo14197b(EffectPreviewRenderView.this.f3772d.mo14046c().mo14345d())) {
                        EffectRenderContext.m4369h().mo14182a(EffectPreviewRenderView.this.f3772d.mo14046c().mo14345d());
                        EffectPreviewRenderView.this.f3772d.mo14048d();
                        BaseRender unused = EffectPreviewRenderView.this.f3772d = null;
                    }
                }
            }
        }
    };

    /* renamed from: c */
    private C1173a f3771c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public BaseRender f3772d;

    public EffectPreviewRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public EffectPreviewRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EffectPreviewRenderView(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo14151a() {
        if (!PatchProxy.proxy(new Object[0], this, f3767a, false, 263, new Class[0], Void.TYPE).isSupported) {
            this.f3771c = new C1173a();
        }
    }

    public void setRender(BaseRender aVar) {
        this.f3772d = aVar;
    }

    public void setAlpha(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f3767a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 264, new Class[]{Float.TYPE}, Void.TYPE).isSupported && this.f3772d != null) {
            this.f3772d.mo14042a("alpha", (Object) Float.valueOf(f));
        }
    }

    /* renamed from: b */
    public void mo14152b() {
        if (!PatchProxy.proxy(new Object[0], this, f3767a, false, 265, new Class[0], Void.TYPE).isSupported) {
            Log.i("EffectPreviewRenderView", "release --> invoke");
            this.f3770b.invoke(true);
        }
    }

    public void onDraw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f3767a, false, 266, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            this.f3771c.draw(canvas);
        }
    }

    /* renamed from: com.meizu.camera.effectlib.effects.views.EffectPreviewRenderView$a */
    protected class C1173a extends DrawGLFunctor {

        /* renamed from: a */
        public static ChangeQuickRedirect f3773a;

        public C1173a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c3, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onDraw(com.meizu.common.renderer.functor.DrawGLFunctor.GLInfo r11) {
            /*
                r10 = this;
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r2 = 0
                r1[r2] = r11
                com.meizu.savior.ChangeQuickRedirect r3 = f3773a
                java.lang.Class[] r6 = new java.lang.Class[r0]
                java.lang.Class<com.meizu.common.renderer.functor.DrawGLFunctor$GLInfo> r0 = com.meizu.common.renderer.functor.DrawGLFunctor.GLInfo.class
                r6[r2] = r0
                java.lang.Class r7 = java.lang.Void.TYPE
                r4 = 0
                r5 = 268(0x10c, float:3.76E-43)
                r2 = r10
                com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
                boolean r0 = r0.isSupported
                if (r0 == 0) goto L_0x001d
                return
            L_0x001d:
                monitor-enter(r10)
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x00c4 }
                boolean r0 = r0.mo14233q()     // Catch:{ all -> 0x00c4 }
                if (r0 != 0) goto L_0x0034
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x00c4 }
                boolean r0 = r0.mo14235s()     // Catch:{ all -> 0x00c4 }
                if (r0 != 0) goto L_0x0034
                monitor-exit(r10)     // Catch:{ all -> 0x00c4 }
                return
            L_0x0034:
                int r0 = r11.clipLeft     // Catch:{ all -> 0x00c4 }
                int r1 = r11.clipTop     // Catch:{ all -> 0x00c4 }
                int r2 = r11.clipRight     // Catch:{ all -> 0x00c4 }
                android.graphics.Rect r3 = r10.mSourceBounds     // Catch:{ all -> 0x00c4 }
                int r8 = r3.width()     // Catch:{ all -> 0x00c4 }
                android.graphics.Rect r3 = r10.mSourceBounds     // Catch:{ all -> 0x00c4 }
                int r3 = r3.height()     // Catch:{ all -> 0x00c4 }
                if (r0 > 0) goto L_0x004a
                int r0 = r2 - r8
            L_0x004a:
                r6 = r0
                com.meizu.camera.effectlib.effects.views.EffectPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.EffectPreviewRenderView.this     // Catch:{ all -> 0x00c4 }
                com.meizu.camera.effectlib.effects.b.a r0 = r0.f3772d     // Catch:{ all -> 0x00c4 }
                if (r0 == 0) goto L_0x00c2
                com.meizu.camera.effectlib.effects.views.EffectRenderContext r0 = com.meizu.camera.effectlib.effects.views.EffectRenderContext.m4369h()     // Catch:{ all -> 0x00c4 }
                boolean r2 = r0.mo14167L()     // Catch:{ all -> 0x00c4 }
                if (r2 == 0) goto L_0x0063
                com.meizu.camera.effectlib.effects.a.c r2 = r0.mo14157B()     // Catch:{ all -> 0x00c4 }
            L_0x0061:
                r5 = r2
                goto L_0x0068
            L_0x0063:
                com.meizu.camera.effectlib.effects.a.c r2 = r0.mo14156A()     // Catch:{ all -> 0x00c4 }
                goto L_0x0061
            L_0x0068:
                if (r5 == 0) goto L_0x00c2
                int r2 = r0.mo14240x()     // Catch:{ all -> 0x00c4 }
                int r4 = r0.mo14239w()     // Catch:{ all -> 0x00c4 }
                float r4 = (float) r4     // Catch:{ all -> 0x00c4 }
                float r2 = (float) r2     // Catch:{ all -> 0x00c4 }
                float r4 = r4 / r2
                float[] r0 = r0.mo14158C()     // Catch:{ all -> 0x00c4 }
                int r2 = r11.viewportHeight     // Catch:{ all -> 0x00c4 }
                int r2 = r2 - r1
                int r2 = r2 - r3
                android.opengl.GLES20.glScissor(r6, r2, r8, r3)     // Catch:{ all -> 0x00c4 }
                r2 = 3042(0xbe2, float:4.263E-42)
                android.opengl.GLES20.glEnable(r2)     // Catch:{ all -> 0x00c4 }
                r2 = 770(0x302, float:1.079E-42)
                r3 = 771(0x303, float:1.08E-42)
                android.opengl.GLES20.glBlendFunc(r2, r3)     // Catch:{ all -> 0x00c4 }
                com.meizu.camera.effectlib.effects.views.EffectPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.EffectPreviewRenderView.this     // Catch:{ all -> 0x00c4 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3772d     // Catch:{ all -> 0x00c4 }
                float[] r3 = com.meizu.camera.effectlib.effects.views.EffectPreviewRenderView.f3768e     // Catch:{ all -> 0x00c4 }
                r2.mo14043a(r3)     // Catch:{ all -> 0x00c4 }
                com.meizu.camera.effectlib.effects.views.EffectPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.EffectPreviewRenderView.this     // Catch:{ all -> 0x00c4 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3772d     // Catch:{ all -> 0x00c4 }
                float[] r3 = com.meizu.camera.effectlib.effects.views.EffectPreviewRenderView.f3769f     // Catch:{ all -> 0x00c4 }
                r2.mo14045b(r3)     // Catch:{ all -> 0x00c4 }
                com.meizu.camera.effectlib.effects.views.EffectPreviewRenderView r2 = com.meizu.camera.effectlib.effects.views.EffectPreviewRenderView.this     // Catch:{ all -> 0x00c4 }
                com.meizu.camera.effectlib.effects.b.a r2 = r2.f3772d     // Catch:{ all -> 0x00c4 }
                r2.mo14049d(r0)     // Catch:{ all -> 0x00c4 }
                com.meizu.camera.effectlib.effects.views.EffectPreviewRenderView r0 = com.meizu.camera.effectlib.effects.views.EffectPreviewRenderView.this     // Catch:{ all -> 0x00c4 }
                com.meizu.camera.effectlib.effects.b.a r0 = r0.f3772d     // Catch:{ all -> 0x00c4 }
                int r11 = r11.viewportHeight     // Catch:{ all -> 0x00c4 }
                int r11 = r11 - r1
                float r1 = (float) r8     // Catch:{ all -> 0x00c4 }
                float r1 = r1 * r4
                int r9 = (int) r1     // Catch:{ all -> 0x00c4 }
                int r7 = r11 - r9
                r4 = r0
                r4.mo14040a(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00c4 }
            L_0x00c2:
                monitor-exit(r10)     // Catch:{ all -> 0x00c4 }
                return
            L_0x00c4:
                r11 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x00c4 }
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.camera.effectlib.effects.views.EffectPreviewRenderView.C1173a.onDraw(com.meizu.common.renderer.functor.DrawGLFunctor$GLInfo):void");
        }
    }
}
