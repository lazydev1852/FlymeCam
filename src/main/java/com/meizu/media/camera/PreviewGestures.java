package com.meizu.media.camera;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.meizu.media.camera.app.AndroidContext;
import com.meizu.media.camera.util.C2634am;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.views.MzFocusRenderer;
import com.meizu.media.camera.views.RenderOverlay;
import com.meizu.media.camera.views.ZoomRenderer;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.y */
public class PreviewGestures implements ScaleGestureDetector.OnScaleGestureListener {

    /* renamed from: a */
    public static ChangeQuickRedirect f14401a;

    /* renamed from: b */
    private static final LogUtil.C2630a f14402b = new LogUtil.C2630a("PreviewGestures");

    /* renamed from: A */
    private GestureDetector.SimpleOnGestureListener f14403A = new GestureDetector.SimpleOnGestureListener() {

        /* renamed from: a */
        public static ChangeQuickRedirect f14428a;

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (!PatchProxy.proxy(new Object[]{motionEvent}, this, f14428a, false, 2091, new Class[]{MotionEvent.class}, Void.TYPE).isSupported) {
                LogUtil.m15952c(LogUtil.f14072b, "Long press preview capture!");
                PreviewGestures.this.f14405d.mo21179b((View) null, (int) motionEvent.getX(), (int) motionEvent.getY(), true);
            }
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14428a, false, 2092, new Class[]{MotionEvent.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            PreviewGestures.this.f14405d.mo21179b((View) null, (int) motionEvent.getX(), (int) motionEvent.getY(), false);
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14428a, false, 2093, new Class[]{MotionEvent.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            PreviewGestures.this.f14405d.mo21165a((View) null, (int) motionEvent.getX(), (int) motionEvent.getY(), false);
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14428a, false, 2094, new Class[]{MotionEvent.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            PreviewGestures.this.f14406e.mo21163a(motionEvent);
            return super.onDoubleTapEvent(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            MotionEvent motionEvent3 = motionEvent;
            MotionEvent motionEvent4 = motionEvent2;
            float f3 = f;
            float f4 = f2;
            Object[] objArr = {motionEvent3, motionEvent4, new Float(f3), new Float(f4)};
            ChangeQuickRedirect changeQuickRedirect = f14428a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 2095, new Class[]{MotionEvent.class, MotionEvent.class, Float.TYPE, Float.TYPE}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            if (motionEvent3 == null) {
                return false;
            }
            PreviewGestures.this.f14407f.mo21039a();
            float abs = Math.abs(motionEvent2.getX() - motionEvent.getX());
            float abs2 = Math.abs(motionEvent2.getY() - motionEvent.getY());
            if (PreviewGestures.this.f14419r || PreviewGestures.this.f14416o == 2 || PreviewGestures.this.f14416o == 4) {
                return false;
            }
            if (PreviewGestures.this.f14419r || PreviewGestures.this.f14420s || (motionEvent3 != null && PreviewGestures.this.f14422u.bottom - motionEvent.getY() < ((float) PreviewGestures.this.f14424w) && PreviewGestures.this.f14422u.bottom - motionEvent.getY() >= 0.0f)) {
                return true;
            }
            if ((motionEvent.getX() < PreviewGestures.this.f14422u.left && motionEvent2.getX() < PreviewGestures.this.f14422u.left) || (motionEvent.getX() > PreviewGestures.this.f14422u.right && motionEvent2.getX() > PreviewGestures.this.f14422u.right)) {
                return true;
            }
            if (PreviewGestures.this.f14412k == null || !PreviewGestures.this.f14412k.mo23339f() || ((abs >= abs2 || !(PreviewGestures.this.f14412k.mo23340g() == 0 || PreviewGestures.this.f14412k.mo23340g() == 180)) && (abs < abs2 || !(PreviewGestures.this.f14412k.mo23340g() == 90 || PreviewGestures.this.f14412k.mo23340g() == 270)))) {
                if (PreviewGestures.this.f14404c == 0 && PreviewGestures.this.f14416o != 5) {
                    int unused = PreviewGestures.this.f14404c = (int) (AndroidContext.m8284a().mo19002b().getResources().getDisplayMetrics().density * 25.0f);
                }
                if (PreviewGestures.this.f14407f == null || ((abs <= ((float) PreviewGestures.this.f14404c) && abs2 <= ((float) PreviewGestures.this.f14404c)) || PreviewGestures.this.f14416o == 5)) {
                    return true;
                }
                PreviewGestures.this.f14407f.mo21040a(motionEvent3, motionEvent4, f3, f4);
                return true;
            }
            int unused2 = PreviewGestures.this.f14416o = 5;
            return true;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14428a, false, 2096, new Class[]{MotionEvent.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            PreviewGestures.this.f14406e.mo21164a((View) null, (int) motionEvent.getX(), (int) motionEvent.getY());
            return true;
        }

        public boolean onDown(MotionEvent motionEvent) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14428a, false, 2097, new Class[]{MotionEvent.class}, Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            PreviewGestures.this.f14405d.mo21178b((View) null, (int) motionEvent.getX(), (int) motionEvent.getY());
            PreviewGestures.this.f14407f.mo21041a((View) null, (int) motionEvent.getX(), (int) motionEvent.getY());
            return super.onDown(motionEvent);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f14404c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C2673e f14405d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C2670b f14406e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C2671c f14407f;

    /* renamed from: g */
    private C2669a f14408g;

    /* renamed from: h */
    private C2672d f14409h;

    /* renamed from: i */
    private RenderOverlay f14410i;

    /* renamed from: j */
    private ZoomRenderer f14411j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public MzFocusRenderer f14412k;

    /* renamed from: l */
    private MotionEvent f14413l;

    /* renamed from: m */
    private MotionEvent f14414m;

    /* renamed from: n */
    private ScaleGestureDetector f14415n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f14416o;

    /* renamed from: p */
    private boolean f14417p;

    /* renamed from: q */
    private boolean f14418q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f14419r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f14420s;

    /* renamed from: t */
    private GestureDetector f14421t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public RectF f14422u = new RectF();

    /* renamed from: v */
    private RectF f14423v = new RectF();
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f14424w = 0;

    /* renamed from: x */
    private PointF f14425x;

    /* renamed from: y */
    private PointF f14426y;

    /* renamed from: z */
    private double f14427z;

    /* renamed from: com.meizu.media.camera.y$a */
    /* compiled from: PreviewGestures */
    public interface C2669a {
        void onTouch(MotionEvent motionEvent);
    }

    /* renamed from: com.meizu.media.camera.y$b */
    /* compiled from: PreviewGestures */
    public interface C2670b {
        /* renamed from: a */
        void mo21163a(MotionEvent motionEvent);

        /* renamed from: a */
        void mo21164a(View view, int i, int i2);
    }

    /* renamed from: com.meizu.media.camera.y$c */
    /* compiled from: PreviewGestures */
    public interface C2671c {
        /* renamed from: a */
        void mo21039a();

        /* renamed from: a */
        void mo21040a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        /* renamed from: a */
        void mo21041a(View view, int i, int i2);
    }

    /* renamed from: com.meizu.media.camera.y$d */
    /* compiled from: PreviewGestures */
    public interface C2672d {
        /* renamed from: a */
        void mo22795a(MotionEvent motionEvent);
    }

    /* renamed from: com.meizu.media.camera.y$e */
    /* compiled from: PreviewGestures */
    public interface C2673e {
        /* renamed from: a */
        void mo21165a(View view, int i, int i2, boolean z);

        /* renamed from: b */
        void mo21178b(View view, int i, int i2);

        /* renamed from: b */
        void mo21179b(View view, int i, int i2, boolean z);
    }

    public PreviewGestures(ActivityBase activityBase, C2673e eVar, C2670b bVar, ZoomRenderer rVar, MzFocusRenderer gVar) {
        this.f14405d = eVar;
        this.f14406e = bVar;
        this.f14411j = rVar;
        this.f14412k = gVar;
        this.f14416o = 0;
        this.f14415n = new ScaleGestureDetector(activityBase.getApplicationContext(), this);
        this.f14418q = true;
        this.f14421t = new GestureDetector(this.f14403A);
        C2634am.m15999a((Object) this.f14415n, "mMinSpan", (Object) Integer.valueOf(activityBase.mo17639f().getResources().getDimensionPixelSize(R.dimen.mz_config_minScalingSpan)));
    }

    /* renamed from: a */
    public void mo22775a(C2671c cVar) {
        this.f14407f = cVar;
    }

    /* renamed from: a */
    public void mo22774a(C2669a aVar) {
        this.f14408g = aVar;
    }

    /* renamed from: a */
    public int mo22770a() {
        return this.f14404c;
    }

    /* renamed from: a */
    public void mo22773a(RenderOverlay renderOverlay) {
        this.f14410i = renderOverlay;
    }

    /* renamed from: a */
    public void mo22776a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14401a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2083, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f14402b;
            LogUtil.m15942a(aVar, "setEnabled:" + z);
            this.f14418q = z;
        }
    }

    /* renamed from: b */
    public void mo22778b(boolean z) {
        this.f14417p = z;
    }

    /* renamed from: c */
    public void mo22781c(boolean z) {
        this.f14419r = z;
    }

    /* renamed from: a */
    public void mo22771a(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14401a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2084, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f14402b;
            LogUtil.m15952c(aVar, "setDisableFlingBottom: " + i);
            this.f14424w = i;
        }
    }

    /* renamed from: d */
    public void mo22783d(boolean z) {
        this.f14420s = z;
    }

    /* renamed from: b */
    public boolean mo22779b() {
        return this.f14418q;
    }

    /* renamed from: a */
    public void mo22772a(RectF rectF, int i) {
        this.f14422u.left = rectF.left;
        this.f14422u.top = rectF.top;
        this.f14422u.right = rectF.right;
        this.f14422u.bottom = rectF.bottom;
        float f = (float) i;
        this.f14423v.left = this.f14422u.left - f;
        this.f14423v.top = this.f14422u.top;
        this.f14423v.right = this.f14422u.right + f;
        this.f14423v.bottom = this.f14422u.bottom;
    }

    /* renamed from: c */
    public void mo22780c() {
        if (!PatchProxy.proxy(new Object[0], this, f14401a, false, 2085, new Class[0], Void.TYPE).isSupported && this.f14416o == 2) {
            onScaleEnd(this.f14415n);
        }
    }

    /* renamed from: a */
    public boolean mo22777a(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14401a, false, 2086, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!this.f14418q) {
            return false;
        }
        this.f14414m = motionEvent;
        if (motionEvent.getActionMasked() == 0) {
            this.f14416o = 0;
            this.f14413l = MotionEvent.obtain(motionEvent);
        }
        switch (this.f14414m.getAction()) {
            case 0:
                this.f14425x = new PointF(this.f14414m.getX(), this.f14414m.getY());
                break;
            case 1:
                this.f14426y = new PointF(this.f14414m.getX(), this.f14414m.getY());
                if (this.f14425x != null) {
                    this.f14427z += Math.sqrt(Math.pow((double) (this.f14426y.x - this.f14425x.x), 2.0d) + Math.pow((double) (this.f14426y.y - this.f14425x.y), 2.0d));
                }
                if (this.f14427z < 60.0d && this.f14427z > 0.0d) {
                    this.f14405d.mo21179b((View) null, (int) this.f14414m.getX(), (int) this.f14414m.getY(), false);
                }
                this.f14427z = 0.0d;
                break;
            case 2:
                this.f14426y = new PointF(this.f14414m.getX(), this.f14414m.getY());
                if (this.f14425x != null) {
                    this.f14427z += Math.sqrt(Math.pow((double) (this.f14426y.x - this.f14425x.x), 2.0d) + Math.pow((double) (this.f14426y.y - this.f14425x.y), 2.0d));
                }
                this.f14425x = this.f14426y;
                break;
        }
        this.f14421t.onTouchEvent(motionEvent);
        if (this.f14420s) {
            return true;
        }
        if (!(this.f14412k == null || !this.f14412k.mo23339f() || this.f14416o == 2)) {
            this.f14412k.mo23332b(motionEvent);
        }
        if (this.f14408g != null) {
            this.f14408g.onTouch(motionEvent);
        }
        if (this.f14409h != null) {
            this.f14409h.mo22795a(motionEvent);
        }
        if (this.f14411j == null || !this.f14417p) {
            if (!this.f14423v.contains(motionEvent.getX(), motionEvent.getY())) {
                this.f14416o = 0;
            } else if (this.f14416o == 0 && 5 == motionEvent.getActionMasked()) {
                this.f14416o = 4;
            } else if (this.f14416o == 4 && 1 == motionEvent.getActionMasked()) {
                this.f14416o = 0;
            }
            return true;
        }
        if (!this.f14423v.contains(motionEvent.getX(), motionEvent.getY())) {
            this.f14416o = 0;
            this.f14411j.onScaleEnd(this.f14415n);
        } else if (this.f14416o == 2) {
            this.f14415n.onTouchEvent(motionEvent);
            if (!this.f14415n.isInProgress() && 1 == motionEvent.getActionMasked()) {
                this.f14416o = 0;
                onScaleEnd(this.f14415n);
            }
            return true;
        } else if (this.f14413l == null) {
            return true;
        } else {
            if (5 == motionEvent.getActionMasked()) {
                if (this.f14411j != null) {
                    this.f14415n.onTouchEvent(motionEvent);
                    onScaleBegin(this.f14415n);
                }
            } else if (this.f14416o == 2 && !this.f14415n.isInProgress() && 6 == motionEvent.getActionMasked()) {
                this.f14415n.onTouchEvent(motionEvent);
                onScaleEnd(this.f14415n);
            }
            if (this.f14411j != null) {
                boolean onTouchEvent = this.f14415n.onTouchEvent(motionEvent);
                if (this.f14415n.isInProgress()) {
                    this.f14416o = 0;
                    this.f14421t.onTouchEvent(m16325b(this.f14414m));
                    return onTouchEvent;
                }
            }
        }
        return true;
    }

    /* renamed from: b */
    private MotionEvent m16325b(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14401a, false, 2087, new Class[]{MotionEvent.class}, MotionEvent.class);
        if (proxy.isSupported) {
            return (MotionEvent) proxy.result;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        return obtain;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{scaleGestureDetector}, this, f14401a, false, 2088, new Class[]{ScaleGestureDetector.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f14416o != 2) {
            return false;
        }
        return this.f14411j.onScale(scaleGestureDetector);
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{scaleGestureDetector}, this, f14401a, false, 2089, new Class[]{ScaleGestureDetector.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f14416o != 2) {
            this.f14416o = 2;
            this.f14412k.mo22844b();
            this.f14421t.onTouchEvent(m16325b(this.f14414m));
        }
        return this.f14411j.onScaleBegin(scaleGestureDetector);
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        if (!PatchProxy.proxy(new Object[]{scaleGestureDetector}, this, f14401a, false, 2090, new Class[]{ScaleGestureDetector.class}, Void.TYPE).isSupported) {
            this.f14411j.onScaleEnd(scaleGestureDetector);
        }
    }

    /* renamed from: d */
    public GestureDetector mo22782d() {
        return this.f14421t;
    }
}
