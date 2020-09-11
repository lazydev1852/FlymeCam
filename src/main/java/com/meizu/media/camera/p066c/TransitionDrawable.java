package com.meizu.media.camera.p066c;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.meizu.media.camera.p066c.LayerDrawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.c.d */
public class TransitionDrawable extends LayerDrawable implements Drawable.Callback {

    /* renamed from: i */
    public static ChangeQuickRedirect f8256i;

    /* renamed from: a */
    private int f8257a;

    /* renamed from: d */
    private boolean f8258d;

    /* renamed from: e */
    private long f8259e;

    /* renamed from: f */
    private int f8260f;

    /* renamed from: g */
    private int f8261g;

    /* renamed from: h */
    private int f8262h;

    /* renamed from: j */
    private int f8263j;

    /* renamed from: k */
    private int f8264k;

    /* renamed from: l */
    private boolean f8265l;

    /* renamed from: m */
    private boolean f8266m;

    public TransitionDrawable(Drawable[] drawableArr) {
        this(new C1873a((C1873a) null, (TransitionDrawable) null, (Resources) null), drawableArr);
    }

    TransitionDrawable() {
        this(new C1873a((C1873a) null, (TransitionDrawable) null, (Resources) null), (Resources) null);
    }

    private TransitionDrawable(C1873a aVar, Resources resources) {
        this.f8257a = 2;
        this.f8264k = 0;
        this.f8265l = true;
        this.f8266m = true;
        LayerDrawable.C1871b a = m8848a(aVar, resources);
        this.f8227c = a;
        if (a.f8241b > 0) {
            mo19385d();
        }
    }

    private TransitionDrawable(C1873a aVar, Drawable[] drawableArr) {
        super(drawableArr, (LayerDrawable.C1871b) aVar);
        this.f8257a = 2;
        this.f8264k = 0;
        this.f8265l = true;
        this.f8266m = true;
    }

    /* renamed from: a */
    private LayerDrawable.C1871b m8848a(LayerDrawable.C1871b bVar, Resources resources) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bVar, resources}, this, f8256i, false, 3778, new Class[]{LayerDrawable.C1871b.class, Resources.class}, LayerDrawable.C1871b.class);
        return proxy.isSupported ? (LayerDrawable.C1871b) proxy.result : new C1873a((C1873a) bVar, this, resources);
    }

    /* renamed from: b */
    public void mo19413b(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f8256i, false, 3779, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f8260f = 0;
            this.f8261g = 255;
            this.f8264k = 0;
            this.f8263j = i;
            this.f8262h = i;
            this.f8258d = false;
            this.f8257a = 0;
            invalidateSelf();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r10) {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = f8256i
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.graphics.Canvas> r2 = android.graphics.Canvas.class
            r6[r8] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r4 = 0
            r5 = 3783(0xec7, float:5.301E-42)
            r2 = r9
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r1.isSupported
            if (r1 == 0) goto L_0x001d
            return
        L_0x001d:
            int r1 = r9.f8257a
            switch(r1) {
                case 0: goto L_0x0054;
                case 1: goto L_0x0023;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x005e
        L_0x0023:
            long r1 = r9.f8259e
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x005e
            long r1 = android.os.SystemClock.uptimeMillis()
            long r3 = r9.f8259e
            long r1 = r1 - r3
            float r1 = (float) r1
            int r2 = r9.f8262h
            float r2 = (float) r2
            float r1 = r1 / r2
            r2 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 < 0) goto L_0x003f
            r3 = 1
            goto L_0x0040
        L_0x003f:
            r3 = 0
        L_0x0040:
            float r1 = java.lang.Math.min(r1, r2)
            int r2 = r9.f8260f
            float r2 = (float) r2
            int r4 = r9.f8261g
            int r5 = r9.f8260f
            int r4 = r4 - r5
            float r4 = (float) r4
            float r4 = r4 * r1
            float r2 = r2 + r4
            int r1 = (int) r2
            r9.f8264k = r1
            goto L_0x005f
        L_0x0054:
            long r1 = android.os.SystemClock.uptimeMillis()
            r9.f8259e = r1
            r9.f8257a = r0
            r3 = 0
            goto L_0x005f
        L_0x005e:
            r3 = 1
        L_0x005f:
            int r1 = r9.f8264k
            boolean r2 = r9.f8265l
            com.meizu.media.camera.c.b$b r4 = r9.f8227c
            com.meizu.media.camera.c.b$a[] r4 = r4.f8242c
            r5 = 255(0xff, float:3.57E-43)
            if (r3 == 0) goto L_0x0088
            int r3 = r9.f8257a
            if (r3 != r0) goto L_0x0073
            boolean r3 = r9.f8266m
            if (r3 != 0) goto L_0x007e
        L_0x0073:
            if (r2 == 0) goto L_0x0077
            if (r1 != 0) goto L_0x007e
        L_0x0077:
            r2 = r4[r8]
            android.graphics.drawable.Drawable r2 = r2.f8234a
            r2.draw(r10)
        L_0x007e:
            if (r1 != r5) goto L_0x0087
            r0 = r4[r0]
            android.graphics.drawable.Drawable r0 = r0.f8234a
            r0.draw(r10)
        L_0x0087:
            return
        L_0x0088:
            r6 = r4[r8]
            android.graphics.drawable.Drawable r6 = r6.f8234a
            r7 = r4[r0]
            android.graphics.drawable.Drawable r7 = r7.f8234a
            if (r6 != r7) goto L_0x009a
            r0 = r4[r8]
            android.graphics.drawable.Drawable r0 = r0.f8234a
            r0.draw(r10)
            goto L_0x00c0
        L_0x009a:
            r6 = r4[r8]
            android.graphics.drawable.Drawable r6 = r6.f8234a
            if (r2 == 0) goto L_0x00ae
            int r2 = 255 - r1
            if (r2 <= 0) goto L_0x00b1
            r6.setAlpha(r2)
            r6.draw(r10)
            r6.setAlpha(r5)
            goto L_0x00b1
        L_0x00ae:
            r6.draw(r10)
        L_0x00b1:
            if (r1 <= 0) goto L_0x00c0
            r0 = r4[r0]
            android.graphics.drawable.Drawable r0 = r0.f8234a
            r0.setAlpha(r1)
            r0.draw(r10)
            r0.setAlpha(r5)
        L_0x00c0:
            if (r3 != 0) goto L_0x00c5
            r9.invalidateSelf()
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.p066c.TransitionDrawable.draw(android.graphics.Canvas):void");
    }

    /* renamed from: com.meizu.media.camera.c.d$a */
    /* compiled from: TransitionDrawable */
    static class C1873a extends LayerDrawable.C1871b {

        /* renamed from: f */
        public static ChangeQuickRedirect f8267f;

        C1873a(C1873a aVar, TransitionDrawable dVar, Resources resources) {
            super(aVar, dVar, resources);
        }

        public Drawable newDrawable() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f8267f, false, 3784, new Class[0], Drawable.class);
            return proxy.isSupported ? (Drawable) proxy.result : new TransitionDrawable(this, (Resources) null);
        }

        public Drawable newDrawable(Resources resources) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{resources}, this, f8267f, false, 3785, new Class[]{Resources.class}, Drawable.class);
            return proxy.isSupported ? (Drawable) proxy.result : new TransitionDrawable(this, resources);
        }

        public int getChangingConfigurations() {
            return this.f8243d;
        }
    }
}
