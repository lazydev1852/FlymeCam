package com.meizu.media.camera.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.animation.PathInterpolator;
import androidx.core.view.ViewCompat;
import com.meizu.media.camera.R;
import com.meizu.media.camera.animation.CaptureAnimView;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: com.meizu.media.camera.views.l */
public class MzTimeLapseRender extends OverlayRenderer {

    /* renamed from: M */
    private static final ArrayList<Float> f15496M = new ArrayList<>(Arrays.asList(new Float[]{Float.valueOf(180.0f), Float.valueOf(90.0f), Float.valueOf(45.0f), Float.valueOf(22.5f), Float.valueOf(11.25f)}));

    /* renamed from: a */
    public static ChangeQuickRedirect f15497a;

    /* renamed from: r */
    private static final ArrayList<String> f15498r = new ArrayList<>(Arrays.asList(new String[]{"0.5 s", "1 s", "2 s", "4 s", "8 s"}));

    /* renamed from: A */
    private ArrayList<Integer> f15499A = new ArrayList<>();

    /* renamed from: B */
    private ArrayList<Integer> f15500B = new ArrayList<>();

    /* renamed from: C */
    private long f15501C = -1;

    /* renamed from: D */
    private boolean f15502D = false;

    /* renamed from: E */
    private int f15503E;

    /* renamed from: F */
    private int f15504F;

    /* renamed from: G */
    private int f15505G;

    /* renamed from: H */
    private int f15506H;

    /* renamed from: I */
    private PathInterpolator f15507I;

    /* renamed from: J */
    private Bitmap f15508J;

    /* renamed from: K */
    private Path f15509K;

    /* renamed from: L */
    private RectF f15510L;

    /* renamed from: N */
    private boolean f15511N = false;

    /* renamed from: O */
    private long f15512O = -1;

    /* renamed from: P */
    private boolean f15513P = false;

    /* renamed from: Q */
    private float f15514Q;

    /* renamed from: R */
    private C2752a f15515R;

    /* renamed from: b */
    private Context f15516b;

    /* renamed from: c */
    private boolean f15517c = false;

    /* renamed from: d */
    private int f15518d;

    /* renamed from: e */
    private int f15519e;

    /* renamed from: f */
    private int f15520f;

    /* renamed from: g */
    private int f15521g;

    /* renamed from: h */
    private int f15522h;

    /* renamed from: i */
    private int f15523i;

    /* renamed from: j */
    private int f15524j;

    /* renamed from: k */
    private RectF f15525k;

    /* renamed from: l */
    private RectF f15526l;

    /* renamed from: m */
    private RectF f15527m;

    /* renamed from: n */
    private RectF f15528n;

    /* renamed from: o */
    private Paint f15529o;

    /* renamed from: p */
    private Paint f15530p;

    /* renamed from: q */
    private int f15531q;

    /* renamed from: s */
    private int f15532s = 0;

    /* renamed from: com.meizu.media.camera.views.l$a */
    /* compiled from: MzTimeLapseRender */
    public interface C2752a {
        /* renamed from: d */
        void mo20669d(int i);
    }

    public MzTimeLapseRender(Context context) {
        this.f15516b = context;
    }

    /* renamed from: a */
    public void mo23392a(C2752a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f15497a, false, 8708, new Class[]{C2752a.class}, Void.TYPE).isSupported) {
            this.f15515R = aVar;
            m16851a(this.f15516b);
            m16852b(this.f15516b);
            this.f15507I = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
            this.f15509K = new Path();
            this.f15508J = BitmapFactory.decodeResource(this.f15516b.getResources(), R.drawable.mz_btn_shutter_bg_timelapse_capturing);
            mo23394b();
        }
    }

    /* renamed from: a */
    public void mo23390a() {
        if (!PatchProxy.proxy(new Object[0], this, f15497a, false, 8709, new Class[0], Void.TYPE).isSupported) {
            this.f15502D = false;
            this.f15501C = -1;
            this.f15500B.clear();
            this.f15499A.clear();
            this.f15525k = null;
            this.f15526l = null;
            this.f15527m = null;
            this.f15528n = null;
            this.f15532s = 0;
            this.f15507I = null;
            this.f15503E = 0;
            this.f15504F = 0;
            this.f15505G = 0;
            this.f15506H = 0;
            this.f15531q = 0;
            this.f15517c = false;
            if (this.f15515R != null) {
                this.f15515R.mo20669d(0);
            }
            this.f15513P = false;
            this.f15511N = false;
            this.f15514Q = 0.0f;
            this.f15512O = -1;
            this.f15510L = null;
            this.f15508J = null;
            this.f15509K = null;
        }
    }

    /* renamed from: a */
    private void m16851a(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f15497a, false, 8710, new Class[]{Context.class}, Void.TYPE).isSupported) {
            this.f15529o = new Paint();
            this.f15529o.setStyle(Paint.Style.STROKE);
            this.f15529o.setColor(-1);
            this.f15529o.setTextSize(context.getResources().getDimension(R.dimen.mz_font_size_12sp));
            this.f15529o.setTextAlign(Paint.Align.LEFT);
            this.f15529o.setAntiAlias(true);
            this.f15529o.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.f15530p = new Paint();
            this.f15530p.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.f15530p.setAlpha(127);
            this.f15530p.setAntiAlias(true);
            Iterator<String> it = f15498r.iterator();
            while (it.hasNext()) {
                this.f15499A.add(Integer.valueOf((int) this.f15529o.measureText(it.next())));
            }
        }
    }

    /* renamed from: b */
    private void m16852b(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f15497a, false, 8711, new Class[]{Context.class}, Void.TYPE).isSupported) {
            Resources resources = context.getResources();
            this.f15522h = CameraUtil.m15809a();
            this.f15521g = (int) ((-this.f15529o.ascent()) - this.f15529o.descent());
            this.f15519e = resources.getDimensionPixelOffset(R.dimen.time_lapse_menu_margin_bottom);
            if (NavigationBarUtils.m15972a()) {
                if (DeviceHelper.f13874aa) {
                    this.f15519e = context.getResources().getDimensionPixelOffset(R.dimen.time_lapse_menu_margin_bottom_18_9);
                } else {
                    this.f15519e += CameraUtil.m15912r();
                }
            }
            this.f15524j = resources.getDimensionPixelOffset(R.dimen.time_lapse_menu_item_padding);
            this.f15523i = resources.getDimensionPixelOffset(R.dimen.time_lapse_menu_radius);
            this.f15518d = CameraUtil.m15865b() - (((this.f15523i * 2) + this.f15519e) + CameraUtil.m15897f());
            this.f15520f = this.f15518d + this.f15523i + (this.f15521g / 2);
            this.f15525k = new RectF((float) ((this.f15522h / 2) - this.f15523i), (float) this.f15518d, (float) ((this.f15522h / 2) + this.f15523i), (float) (this.f15518d + (this.f15523i * 2)));
            this.f15527m = new RectF(this.f15525k);
            this.f15528n = new RectF(this.f15525k);
            int size = this.f15524j * 2 * f15498r.size();
            Iterator<Integer> it = this.f15499A.iterator();
            while (it.hasNext()) {
                size += it.next().intValue();
            }
            int i = size / 2;
            this.f15526l = new RectF((float) ((this.f15522h / 2) - i), (float) this.f15518d, (float) ((this.f15522h / 2) + i), (float) (this.f15518d + (this.f15523i * 2)));
            int i2 = (int) this.f15526l.left;
            Iterator<Integer> it2 = this.f15499A.iterator();
            while (it2.hasNext()) {
                int intValue = it2.next().intValue();
                this.f15500B.add(Integer.valueOf(i2));
                i2 += (this.f15524j * 2) + intValue;
            }
            this.f15503E = (int) (this.f15525k.left - this.f15526l.left);
        }
    }

    /* renamed from: a */
    public void mo23391a(int i) {
        this.f15532s = i;
    }

    /* renamed from: a */
    public void mo20787a(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15497a, false, 8715, new Class[]{Canvas.class}, Void.TYPE).isSupported && this.f15513P) {
            m16850a(System.currentTimeMillis());
            m16853c(canvas);
        }
    }

    /* renamed from: c */
    private void m16853c(Canvas canvas) {
        Canvas canvas2 = canvas;
        Class[] clsArr = {Canvas.class};
        if (!PatchProxy.proxy(new Object[]{canvas2}, this, f15497a, false, 8720, clsArr, Void.TYPE).isSupported) {
            float f = 268.0f;
            float f2 = this.f15514Q;
            if (this.f15511N) {
                f = 268.0f + f2;
                f2 = 360.0f - f2;
            }
            canvas.save();
            this.f15509K.reset();
            float centerX = this.f15510L.centerX();
            float centerY = this.f15510L.centerY();
            this.f15509K.moveTo(centerX, centerY);
            double d = (double) centerX;
            double width = (double) (this.f15510L.width() / 2.0f);
            double d2 = (((double) f) * 3.141592653589793d) / 180.0d;
            double d3 = (double) centerY;
            this.f15509K.lineTo((float) (d + (Math.cos(d2) * width)), (float) ((Math.sin(d2) * width) + d3));
            double d4 = (((double) ((f + f2) % 360.0f)) * 3.141592653589793d) / 180.0d;
            this.f15509K.lineTo((float) (d + (Math.cos(d4) * width)), (float) (d3 + (width * Math.sin(d4))));
            this.f15509K.close();
            this.f15509K.addArc(this.f15510L, f, f2);
            canvas2.clipPath(this.f15509K);
            canvas2.drawBitmap(this.f15508J, this.f15510L.left, this.f15510L.top, (Paint) null);
            canvas.restore();
        }
    }

    /* renamed from: a */
    public void mo23393a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f15497a, false, 8722, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f15513P = z;
            mo23407o();
            if (!this.f15513P) {
                this.f15512O = -1;
                this.f15514Q = 0.0f;
                this.f15511N = false;
                return;
            }
            this.f15517c = false;
        }
    }

    /* renamed from: a */
    private void m16850a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f15497a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8723, new Class[]{Long.TYPE}, Void.TYPE).isSupported && this.f15513P) {
            if (this.f15512O == -1) {
                this.f15512O = j;
            }
            float floatValue = f15496M.get(this.f15532s).floatValue();
            float f = this.f15514Q;
            this.f15514Q = ((((float) (j - this.f15512O)) * floatValue) / 1000.0f) % 360.0f;
            if (Math.abs(f - this.f15514Q) > 100.0f) {
                this.f15511N = !this.f15511N;
            }
            mo23407o();
        }
    }

    /* renamed from: b */
    public void mo23394b() {
        if (!PatchProxy.proxy(new Object[0], this, f15497a, false, 8724, new Class[0], Void.TYPE).isSupported) {
            this.f15510L = new RectF(CaptureAnimView.f7585b - CaptureAnimView.f7588e, CaptureAnimView.f7586c - CaptureAnimView.f7588e, CaptureAnimView.f7585b + CaptureAnimView.f7588e, CaptureAnimView.f7586c + CaptureAnimView.f7588e);
        }
    }
}
