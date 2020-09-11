package com.meizu.media.camera.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.List;

/* renamed from: com.meizu.media.camera.views.r */
public class ZoomRenderer extends OverlayRenderer implements ScaleGestureDetector.OnScaleGestureListener {

    /* renamed from: a */
    public static ChangeQuickRedirect f15562a;

    /* renamed from: A */
    private List<Integer> f15563A;

    /* renamed from: B */
    private int f15564B = 100;

    /* renamed from: C */
    private int f15565C = 800;

    /* renamed from: D */
    private float f15566D = 0.0f;

    /* renamed from: E */
    private float f15567E;

    /* renamed from: F */
    private int f15568F;

    /* renamed from: G */
    private Runnable f15569G = new Runnable() {

        /* renamed from: a */
        public static ChangeQuickRedirect f15588a;

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f15588a, false, 8963, new Class[0], Void.TYPE).isSupported) {
                ZoomRenderer.this.mo23403f(false);
            }
        }
    };

    /* renamed from: b */
    private View f15570b;

    /* renamed from: c */
    private int f15571c;

    /* renamed from: d */
    private int f15572d;

    /* renamed from: e */
    private C2756a f15573e;

    /* renamed from: f */
    private ScaleGestureDetector f15574f;

    /* renamed from: g */
    private Paint f15575g;

    /* renamed from: h */
    private int f15576h;

    /* renamed from: i */
    private int f15577i;

    /* renamed from: j */
    private int f15578j;

    /* renamed from: k */
    private float f15579k;

    /* renamed from: l */
    private float f15580l;

    /* renamed from: m */
    private int f15581m;

    /* renamed from: n */
    private int f15582n;

    /* renamed from: o */
    private Rect f15583o;

    /* renamed from: p */
    private float f15584p;

    /* renamed from: q */
    private Handler f15585q = new Handler();

    /* renamed from: r */
    private boolean f15586r = true;

    /* renamed from: s */
    private int f15587s = 0;

    /* renamed from: com.meizu.media.camera.views.r$a */
    /* compiled from: ZoomRenderer */
    public interface C2756a {
        /* renamed from: a */
        void mo22244a();

        /* renamed from: a */
        void mo22245a(float f, float f2);

        /* renamed from: a */
        void mo22246a(int i, boolean z, boolean z2);

        /* renamed from: b */
        void mo22247b();

        /* renamed from: b */
        void mo22248b(float f, float f2);

        /* renamed from: c */
        boolean mo22249c();

        /* renamed from: d */
        boolean mo22250d();

        /* renamed from: e */
        boolean mo22251e();
    }

    public ZoomRenderer(Context context, View view) {
        this.f15570b = view;
        Resources resources = context.getResources();
        this.f15575g = new Paint();
        this.f15575g.setAntiAlias(true);
        this.f15575g.setColor(-1);
        this.f15575g.setStyle(Paint.Style.FILL);
        this.f15575g.setTextSize((float) resources.getDimensionPixelSize(R.dimen.mz_font_size_18sp));
        this.f15575g.setTextAlign(Paint.Align.LEFT);
        this.f15575g.setShadowLayer(3.0f, 0.0f, 2.0f, resources.getColor(R.color.mz_screen_hint_shadow_color));
        this.f15574f = new ScaleGestureDetector(context, this);
        this.f15580l = (float) resources.getDimensionPixelSize(R.dimen.zoom_ring_min);
        this.f15583o = new Rect();
        mo23403f(false);
        this.f15584p = ((-this.f15575g.ascent()) - this.f15575g.descent()) + resources.getDimension(R.dimen.mz_zoom_hint_margin_top) + ((float) CameraUtil.m15901h());
    }

    /* renamed from: a */
    public void mo23412a(int i) {
        this.f15571c = i;
        this.f15572d = 0;
        this.f15587s = 0;
    }

    /* renamed from: b */
    public void mo23417b(int i) {
        this.f15565C = i;
    }

    /* renamed from: a */
    public void mo23415a(List<Integer> list) {
        this.f15563A = list;
    }

    /* renamed from: c */
    public void mo23418c(int i) {
        this.f15576h = (int) (this.f15580l + ((((float) i) * (this.f15579k - this.f15580l)) / ((float) (this.f15571c - this.f15572d))));
    }

    /* renamed from: a */
    public int mo23411a() {
        return this.f15587s;
    }

    /* renamed from: d */
    public void mo23419d(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15562a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8955, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            int i2 = i / 10;
            this.f15581m = i2 / 10;
            this.f15582n = i2 % 10;
            mo23407o();
        }
    }

    /* renamed from: a */
    public void mo23414a(C2756a aVar) {
        this.f15573e = aVar;
    }

    /* renamed from: a */
    public void mo23153a(int i, int i2, int i3, int i4) {
        Object[] objArr = {new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)};
        ChangeQuickRedirect changeQuickRedirect = f15562a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8956, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.mo23153a(i, i2, i3, i4);
            this.f15577i = (i3 - i) / 2;
            this.f15578j = (i4 - i2) / 2;
            this.f15579k = (float) Math.min(mo23405m(), mo23406n());
            this.f15579k = (this.f15579k - this.f15580l) / 2.0f;
            this.f15566D = (float) Math.sqrt(Math.pow((double) mo23405m(), 2.0d) + Math.pow((double) mo23406n(), 2.0d));
        }
    }

    /* renamed from: a */
    public void mo23413a(int i, boolean z, boolean z2) {
        Object[] objArr = {new Integer(i), new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15562a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8958, new Class[]{Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported && this.f15573e != null) {
            this.f15587s = i;
            this.f15573e.mo22246a(i, z, z2);
        }
    }

    /* renamed from: a */
    public void mo23416a(boolean z) {
        this.f15586r = z;
    }

    /* renamed from: a */
    public void mo20787a(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15562a, false, 8959, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            String str = this.f15581m + "." + this.f15582n + "x";
            this.f15575g.getTextBounds(str, 0, str.length(), this.f15583o);
            canvas.drawText(str, (float) (this.f15577i - this.f15583o.centerX()), this.f15584p, this.f15575g);
        }
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float f;
        float f2;
        int i;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{scaleGestureDetector}, this, f15562a, false, 8960, new Class[]{ScaleGestureDetector.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (DeviceHelper.f13928bb && this.f15573e != null) {
            if (this.f15573e.mo22249c()) {
                this.f15573e.mo22245a(scaleGestureDetector.getCurrentSpanX(), scaleGestureDetector.getCurrentSpanY());
                return true;
            } else if (this.f15573e.mo22250d()) {
                return true;
            }
        }
        float currentSpan = scaleGestureDetector.getCurrentSpan() - this.f15567E;
        if (this.f15565C > 400) {
            f = this.f15566D;
            f2 = 2.0f;
        } else {
            f = this.f15566D;
            f2 = 3.0f;
        }
        float f3 = ((float) this.f15568F) + ((currentSpan / (f / f2)) * (this.f15579k - this.f15580l));
        int i2 = (int) ((this.f15579k - this.f15580l) / ((float) (this.f15571c - this.f15572d)));
        if (i2 == 0) {
            i2 = 1;
        }
        float min = Math.min((this.f15579k + ((float) i2)) - 1.0f, Math.max(this.f15580l, f3));
        if (!(this.f15573e == null || (i = (int) min) == this.f15576h)) {
            this.f15573e.mo22247b();
            this.f15576h = i;
            int i3 = this.f15572d + ((int) (((((float) this.f15576h) - this.f15580l) * ((float) (this.f15571c - this.f15572d))) / (this.f15579k - this.f15580l)));
            if (Math.abs(this.f15563A.get(i3).intValue() - this.f15564B) >= 10) {
                this.f15564B = this.f15563A.get(i3).intValue();
                if (!this.f15573e.mo22251e()) {
                    DeviceUtil.m16194a(this.f15570b, 22500);
                }
            }
            this.f15587s = i3;
            this.f15573e.mo22246a(i3, false, true);
        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{scaleGestureDetector}, this, f15562a, false, 8961, new Class[]{ScaleGestureDetector.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        this.f15567E = scaleGestureDetector.getCurrentSpan();
        this.f15568F = this.f15576h;
        this.f15585q.removeCallbacks(this.f15569G);
        if (this.f15573e != null) {
            this.f15573e.mo22248b(scaleGestureDetector.getCurrentSpanX(), scaleGestureDetector.getCurrentSpanY());
        }
        if (!this.f15586r) {
            if (!DeviceHelper.f13928bb || this.f15573e == null || !this.f15573e.mo22250d()) {
                mo23403f(true);
            } else {
                mo23403f(false);
            }
        }
        mo23407o();
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        if (!PatchProxy.proxy(new Object[]{scaleGestureDetector}, this, f15562a, false, 8962, new Class[]{ScaleGestureDetector.class}, Void.TYPE).isSupported) {
            this.f15585q.postDelayed(this.f15569G, 200);
            if (this.f15573e != null) {
                this.f15573e.mo22244a();
            }
        }
    }
}
