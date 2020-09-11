package com.meizu.media.camera.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.meizu.media.camera.PreviewGestures;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class RenderOverlay extends FrameLayout {

    /* renamed from: a */
    public static ChangeQuickRedirect f14980a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f14981b = new LogUtil.C2630a("RenderOverlay");

    /* renamed from: c */
    private RenderView f14982c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<C2723a> f14983d;

    /* renamed from: e */
    private PreviewGestures f14984e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<C2723a> f14985f;

    /* renamed from: g */
    private int[] f14986g = new int[2];

    /* renamed from: h */
    private View f14987h;

    /* renamed from: com.meizu.media.camera.views.RenderOverlay$a */
    public interface C2723a {
        /* renamed from: a */
        void mo23153a(int i, int i2, int i3, int i4);

        /* renamed from: a */
        void mo23154a(RenderOverlay renderOverlay);

        /* renamed from: b */
        void mo23155b(Canvas canvas);

        /* renamed from: c */
        boolean mo23156c(MotionEvent motionEvent);

        /* renamed from: l */
        boolean mo23157l();
    }

    public RenderOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14982c = new RenderView(context);
        addView(this.f14982c, new FrameLayout.LayoutParams(-1, -1));
        this.f14983d = new ArrayList(10);
        this.f14985f = new ArrayList(10);
        setWillNotDraw(false);
    }

    public void setGestures(PreviewGestures yVar) {
        this.f14984e = yVar;
    }

    /* renamed from: a */
    public void mo23142a(C2723a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f14980a, false, 8785, new Class[]{C2723a.class}, Void.TYPE).isSupported) {
            this.f14983d.add(aVar);
            aVar.mo23154a(this);
            if (aVar.mo23157l()) {
                this.f14985f.add(0, aVar);
            }
            aVar.mo23153a(getLeft(), getTop(), getRight(), getBottom());
        }
    }

    /* renamed from: a */
    public void mo23140a(int i, C2723a aVar) {
        Object[] objArr = {new Integer(i), aVar};
        ChangeQuickRedirect changeQuickRedirect = f14980a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8786, new Class[]{Integer.TYPE, C2723a.class}, Void.TYPE).isSupported) {
            this.f14983d.add(i, aVar);
            aVar.mo23154a(this);
            aVar.mo23153a(getLeft(), getTop(), getRight(), getBottom());
        }
    }

    /* renamed from: b */
    public void mo23143b(C2723a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f14980a, false, 8787, new Class[]{C2723a.class}, Void.TYPE).isSupported) {
            this.f14983d.remove(aVar);
            aVar.mo23154a((RenderOverlay) null);
        }
    }

    /* renamed from: a */
    public void mo23141a(View view) {
        this.f14987h = view;
    }

    public int getClientSize() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14980a, false, 8788, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : this.f14983d.size();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14980a, false, 8789, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f14984e != null) {
            if (!this.f14984e.mo22779b()) {
                this.f14984e.mo22780c();
                return false;
            }
            this.f14984e.mo22777a(motionEvent);
        }
        if (this.f14987h != null) {
            this.f14987h.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16587c() {
        if (!PatchProxy.proxy(new Object[0], this, f14980a, false, 8791, new Class[0], Void.TYPE).isSupported) {
            getLocationInWindow(this.f14986g);
        }
    }

    public int getWindowPositionX() {
        return this.f14986g[0];
    }

    public int getWindowPositionY() {
        return this.f14986g[1];
    }

    /* renamed from: a */
    public void mo23139a() {
        if (!PatchProxy.proxy(new Object[0], this, f14980a, false, 8792, new Class[0], Void.TYPE).isSupported) {
            this.f14982c.invalidate();
        }
    }

    private class RenderView extends View {

        /* renamed from: a */
        public static ChangeQuickRedirect f14988a;

        /* renamed from: c */
        private C2723a f14990c;

        public RenderView(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        public void setTouchTarget(C2723a aVar) {
            this.f14990c = aVar;
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            boolean z = false;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14988a, false, 8793, new Class[]{MotionEvent.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            if (this.f14990c != null) {
                return this.f14990c.mo23156c(motionEvent);
            }
            if (RenderOverlay.this.f14985f == null) {
                return false;
            }
            for (C2723a c : RenderOverlay.this.f14985f) {
                z |= c.mo23156c(motionEvent);
            }
            return z;
        }

        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)};
            ChangeQuickRedirect changeQuickRedirect = f14988a;
            if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8794, new Class[]{Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
                RenderOverlay.this.m16587c();
                super.onLayout(z, i, i2, i3, i4);
                if (RenderOverlay.this.f14983d != null) {
                    for (C2723a a : RenderOverlay.this.f14983d) {
                        a.mo23153a(i, i2, i3, i4);
                    }
                }
            }
        }

        public void draw(Canvas canvas) {
            if (!PatchProxy.proxy(new Object[]{canvas}, this, f14988a, false, 8795, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
                super.draw(canvas);
                if (RenderOverlay.this.f14983d != null) {
                    try {
                        for (C2723a b : RenderOverlay.this.f14983d) {
                            b.mo23155b(canvas);
                        }
                    } catch (ConcurrentModificationException unused) {
                        LogUtil.m15952c(RenderOverlay.f14981b, "addRenderer() or move() caused ConcurrentModificationException.Catch!");
                    }
                }
            }
        }
    }
}
