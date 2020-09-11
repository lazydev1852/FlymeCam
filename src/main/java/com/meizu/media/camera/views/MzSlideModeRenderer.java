package com.meizu.media.camera.views;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.core.content.ContextCompat;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.R;
import com.meizu.media.camera.animation.CaptureAnimView;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.meizu.media.camera.views.j */
public class MzSlideModeRenderer extends OverlayRenderer {

    /* renamed from: a */
    public static ChangeQuickRedirect f15433a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f15434b = new LogUtil.C2630a("MzSlideModeRend");
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f15435A = false;

    /* renamed from: B */
    private RectF f15436B;

    /* renamed from: C */
    private PathInterpolator f15437C;

    /* renamed from: D */
    private PathInterpolator f15438D;

    /* renamed from: E */
    private Paint f15439E;

    /* renamed from: F */
    private int f15440F = 255;

    /* renamed from: G */
    private int f15441G = 76;

    /* renamed from: H */
    private float f15442H;

    /* renamed from: I */
    private float f15443I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public boolean f15444J = false;

    /* renamed from: K */
    private boolean f15445K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public boolean f15446L;

    /* renamed from: M */
    private int f15447M;

    /* renamed from: N */
    private int f15448N;

    /* renamed from: O */
    private int f15449O;

    /* renamed from: P */
    private int f15450P;

    /* renamed from: Q */
    private int f15451Q;

    /* renamed from: R */
    private int f15452R;

    /* renamed from: S */
    private ArgbEvaluator f15453S = new ArgbEvaluator();

    /* renamed from: T */
    private Paint f15454T;

    /* renamed from: U */
    private RectF f15455U;

    /* renamed from: V */
    private boolean f15456V = true;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public C2751a f15457W;

    /* renamed from: X */
    private boolean f15458X = true;

    /* renamed from: Y */
    private boolean f15459Y = true;

    /* renamed from: Z */
    private boolean f15460Z = false;
    /* access modifiers changed from: private */

    /* renamed from: aa */
    public boolean f15461aa = true;

    /* renamed from: ab */
    private Handler f15462ab = new Handler() {

        /* renamed from: a */
        public static ChangeQuickRedirect f15481a;

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f15481a, false, 8694, new Class[]{Message.class}, Void.TYPE).isSupported && message.what == 1 && MzSlideModeRenderer.this.f15468g >= 0 && MzSlideModeRenderer.this.f15468g <= MzSlideModeRenderer.this.f15466e.size() - 1) {
                int e = CameraModeType.m10962e((CameraModeType.ModeType) MzSlideModeRenderer.this.f15466e.get(MzSlideModeRenderer.this.f15468g));
                MzSlideModeRenderer jVar = MzSlideModeRenderer.this;
                if (e == -1) {
                    e = MzSlideModeRenderer.this.f15472k;
                }
                int unused = jVar.f15472k = e;
                LogUtil.C2630a d = MzSlideModeRenderer.f15434b;
                LogUtil.m15942a(d, "MSG_CHANGE_MODE mModeIndex:" + MzSlideModeRenderer.this.f15472k);
                MzSlideModeRenderer.this.f15457W.mo21919a(MzSlideModeRenderer.this.f15472k);
                LogUtil.m15942a(MzSlideModeRenderer.f15434b, "MSG_CHANGE_MODE end");
                boolean unused2 = MzSlideModeRenderer.this.f15446L = false;
                MzSlideModeRenderer.this.mo23407o();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: ac */
    public long f15463ac = -1;

    /* renamed from: c */
    private Context f15464c;

    /* renamed from: d */
    private View f15465d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ArrayList<CameraModeType.ModeType> f15466e = new ArrayList<>();

    /* renamed from: f */
    private boolean f15467f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f15468g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f15469h;

    /* renamed from: i */
    private int f15470i;

    /* renamed from: j */
    private int f15471j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f15472k;

    /* renamed from: l */
    private ArrayList<String> f15473l;

    /* renamed from: m */
    private float[] f15474m;

    /* renamed from: n */
    private String f15475n;

    /* renamed from: o */
    private float f15476o;

    /* renamed from: p */
    private int f15477p;

    /* renamed from: q */
    private float f15478q;

    /* renamed from: r */
    private float f15479r;

    /* renamed from: s */
    private float f15480s;

    /* renamed from: com.meizu.media.camera.views.j$a */
    /* compiled from: MzSlideModeRenderer */
    public interface C2751a {
        /* renamed from: a */
        void mo21918a();

        /* renamed from: a */
        void mo21919a(int i);

        /* renamed from: b */
        void mo21920b();

        /* renamed from: c */
        void mo21921c();

        /* renamed from: d */
        boolean mo21922d();

        /* renamed from: e */
        boolean mo21923e();
    }

    /* renamed from: a */
    public void mo23372a(boolean z) {
        this.f15461aa = z;
    }

    public MzSlideModeRenderer(Context context, C2751a aVar, View view) {
        this.f15457W = aVar;
        this.f15465d = view;
        m16799a(context);
        mo23403f(true);
    }

    /* renamed from: a */
    public void mo23370a(C2751a aVar) {
        this.f15457W = aVar;
    }

    /* renamed from: a */
    private void m16799a(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f15433a, false, 8669, new Class[]{Context.class}, Void.TYPE).isSupported) {
            this.f15464c = ContextBuilder.m6349a(context, true, true);
            Resources resources = this.f15464c.getResources();
            this.f15477p = CameraUtil.m15809a();
            this.f15439E = new Paint();
            this.f15439E.setAntiAlias(true);
            this.f15439E.setTextSize(resources.getDimension(R.dimen.mz_font_size_13sp));
            this.f15439E.setTextAlign(Paint.Align.LEFT);
            this.f15439E.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.f15439E.setShadowLayer(2.0f, 0.0f, 1.0f, resources.getColor(R.color.mz_mode_name_shadow_color));
            this.f15454T = new Paint();
            this.f15454T.setAntiAlias(true);
            this.f15480s = (-this.f15439E.ascent()) - this.f15439E.descent();
            if (!NavigationBarUtils.m15972a()) {
                this.f15478q = resources.getDimension(R.dimen.mz_mode_text_margin_top);
            } else if (DeviceHelper.f13874aa) {
                this.f15478q = ((float) CameraUtil.m15901h()) + (((float) CameraUtil.m15809a()) * 1.3333334f) + resources.getDimension(R.dimen.mz_mode_text_margin__top_18_9_control_bar);
            } else {
                this.f15478q = resources.getDimension(R.dimen.mz_mode_text_margin_top_navigation_bar);
            }
            this.f15478q += this.f15480s;
            this.f15479r = resources.getDimension(R.dimen.mz_mode_text_spaceing);
            this.f15473l = new ArrayList<>();
            this.f15437C = new PathInterpolator(0.2f, 0.0f, 0.2f, 1.0f);
            this.f15438D = new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);
            this.f15447M = ContextCompat.getColor(context, R.color.mz_shutter_bg);
            this.f15448N = ContextCompat.getColor(context, R.color.mz_record_bg);
            this.f15449O = ContextCompat.getColor(context, R.color.slide_mode_selected_color);
            this.f15450P = ContextCompat.getColor(context, R.color.slide_mode_unselected_color);
            this.f15451Q = this.f15449O;
            this.f15452R = this.f15450P;
            this.f15455U = new RectF(CaptureAnimView.f7585b - CaptureAnimView.f7587d, CaptureAnimView.f7586c - CaptureAnimView.f7587d, CaptureAnimView.f7585b + CaptureAnimView.f7587d, CaptureAnimView.f7586c + CaptureAnimView.f7587d);
        }
    }

    /* renamed from: b */
    public void mo23375b(boolean z) {
        this.f15458X = z;
    }

    /* renamed from: c */
    public void mo23378c(boolean z) {
        this.f15459Y = z;
    }

    /* renamed from: a */
    public void mo23369a(int i) {
        this.f15472k = i;
    }

    /* renamed from: a */
    public void mo23371a(ArrayList<CameraModeType.ModeType> arrayList, CameraModeType.ModeType modeType) {
        Class[] clsArr = {ArrayList.class, CameraModeType.ModeType.class};
        if (PatchProxy.proxy(new Object[]{arrayList, modeType}, this, f15433a, false, 8670, clsArr, Void.TYPE).isSupported || arrayList == null) {
            return;
        }
        if (modeType == null || arrayList.indexOf(modeType) != -1) {
            this.f15466e.clear();
            this.f15466e.addAll(arrayList);
            Resources resources = this.f15464c.getResources();
            this.f15473l.clear();
            Iterator<CameraModeType.ModeType> it = this.f15466e.iterator();
            while (it.hasNext()) {
                this.f15473l.add(resources.getString(it.next().getTxtId()));
            }
            if (this.f15458X) {
                this.f15473l.add(this.f15464c.getString(R.string.more));
            }
            if (modeType != null) {
                this.f15468g = this.f15466e.indexOf(modeType);
                this.f15472k = CameraModeType.m10962e(modeType);
            } else {
                this.f15468g = this.f15466e.size();
            }
            LogUtil.C2630a aVar = f15434b;
            LogUtil.m15942a(aVar, "setModeTypesInSlideBar mSelectedPosition:" + this.f15468g);
            this.f15469h = this.f15468g;
            this.f15470i = this.f15468g;
            this.f15471j = this.f15473l.size();
            m16821g();
            m16823h();
            mo23407o();
        }
    }

    /* renamed from: a */
    public void mo23368a(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f15433a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8671, new Class[]{Float.TYPE}, Void.TYPE).isSupported && this.f15468g != -1) {
            LogUtil.C2630a aVar = f15434b;
            LogUtil.m15942a(aVar, "onScroll distanceX:" + f);
            if (f > 0.0f) {
                m16817e();
            } else if (f < 0.0f) {
                m16819f();
            }
        }
    }

    /* renamed from: e */
    private void m16817e() {
        if (!PatchProxy.proxy(new Object[0], this, f15433a, false, 8672, new Class[0], Void.TYPE).isSupported && this.f15468g > 0) {
            this.f15460Z = true;
            m16806b(this.f15468g - 1);
        }
    }

    /* renamed from: f */
    private void m16819f() {
        if (!PatchProxy.proxy(new Object[0], this, f15433a, false, 8673, new Class[0], Void.TYPE).isSupported && this.f15468g < this.f15471j - 1) {
            this.f15460Z = true;
            m16806b(this.f15468g + 1);
        }
    }

    /* renamed from: b */
    private void m16806b(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15433a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8674, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && i >= 0 && i < this.f15471j) {
            LogUtil.C2630a aVar = f15434b;
            LogUtil.m15942a(aVar, "setSelectedTab:" + i + ",mFling: " + this.f15435A + ",mIsAnimRunning:" + this.f15444J);
            if (!this.f15435A && !this.f15444J) {
                m16802a("slide");
                m16811c(i);
            }
        }
    }

    /* renamed from: c */
    private void m16811c(final int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15433a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8675, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && i >= 0 && i <= this.f15471j - 1 && this.f15470i != i) {
            LogUtil.C2630a aVar = f15434b;
            LogUtil.m15942a(aVar, "animToTabPostion:" + i + ",mSelectedPosition:" + i);
            if (this.f15458X && i != this.f15471j - 1) {
                int e = CameraModeType.m10962e(this.f15466e.get(i));
                LogUtil.C2630a aVar2 = f15434b;
                LogUtil.m15942a(aVar2, "coming position mode index:" + e + ",current mode index:" + this.f15472k);
                if (this.f15472k != e || (CameraModeType.m10946a() == CameraModeType.ModeType.TOF && this.f15457W.mo21923e())) {
                    LogUtil.m15942a(f15434b, "on mode change start");
                    this.f15457W.mo21918a();
                    this.f15462ab.removeMessages(1);
                    this.f15462ab.sendEmptyMessage(1);
                }
            }
            if (this.f15470i == this.f15471j - 1 && this.f15458X) {
                this.f15462ab.post(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f15483a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f15483a, false, 8695, new Class[0], Void.TYPE).isSupported) {
                            MzSlideModeRenderer.this.f15457W.mo21921c();
                        }
                    }
                });
            }
            if (i != this.f15471j - 1 || !this.f15458X) {
                this.f15468g = i;
                this.f15469h = i;
                this.f15435A = true;
                this.f15463ac = System.currentTimeMillis();
                if (!this.f15444J) {
                    m16825j();
                }
                mo23407o();
                return;
            }
            this.f15462ab.post(new Runnable() {

                /* renamed from: a */
                public static ChangeQuickRedirect f15485a;

                public void run() {
                    if (!PatchProxy.proxy(new Object[0], this, f15485a, false, 8696, new Class[0], Void.TYPE).isSupported && MzSlideModeRenderer.this.f15461aa) {
                        MzSlideModeRenderer.this.f15457W.mo21920b();
                        int unused = MzSlideModeRenderer.this.f15468g = i;
                        int unused2 = MzSlideModeRenderer.this.f15469h = i;
                        boolean unused3 = MzSlideModeRenderer.this.f15435A = true;
                        long unused4 = MzSlideModeRenderer.this.f15463ac = System.currentTimeMillis();
                        if (!MzSlideModeRenderer.this.f15444J) {
                            MzSlideModeRenderer.this.m16825j();
                        }
                        MzSlideModeRenderer.this.mo23407o();
                    }
                }
            });
        }
    }

    /* renamed from: g */
    private void m16821g() {
        if (!PatchProxy.proxy(new Object[0], this, f15433a, false, 8676, new Class[0], Void.TYPE).isSupported) {
            int size = this.f15473l.size();
            this.f15474m = new float[size];
            for (int i = 0; i < size; i++) {
                this.f15474m[i] = this.f15439E.measureText(this.f15473l.get(i));
            }
        }
    }

    /* renamed from: h */
    private void m16823h() {
        if (!PatchProxy.proxy(new Object[0], this, f15433a, false, 8677, new Class[0], Void.TYPE).isSupported) {
            float f = this.f15474m[this.f15468g] / 2.0f;
            this.f15436B = new RectF((((float) this.f15477p) / 2.0f) - (m16813d(this.f15468g - 1) + f), this.f15478q - (this.f15480s * 2.0f), (((float) this.f15477p) / 2.0f) + m16816e(this.f15468g + 1) + f, this.f15478q + this.f15480s);
        }
    }

    /* renamed from: d */
    private float m16813d(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15433a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 8678, new Class[]{Integer.TYPE}, Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        if (i == -1) {
            return 0.0f;
        }
        return this.f15479r + this.f15474m[i] + m16813d(i - 1);
    }

    /* renamed from: e */
    private float m16816e(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15433a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 8679, new Class[]{Integer.TYPE}, Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        if (i > this.f15473l.size() - 1) {
            return 0.0f;
        }
        return this.f15479r + this.f15474m[i] + m16816e(i + 1);
    }

    /* renamed from: a */
    public void mo20787a(Canvas canvas) {
        if (PatchProxy.proxy(new Object[]{canvas}, this, f15433a, false, 8680, new Class[]{Canvas.class}, Void.TYPE).isSupported || !this.f15459Y) {
            return;
        }
        if (this.f15468g == -1) {
            m16812c(canvas);
            return;
        }
        if (m16824i()) {
            m16798a(System.currentTimeMillis());
        }
        m16800a(canvas, this.f15443I);
    }

    /* renamed from: c */
    private void m16812c(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15433a, false, 8682, new Class[]{Canvas.class}, Void.TYPE).isSupported && this.f15475n != null) {
            float f = (((float) this.f15477p) / 2.0f) - (this.f15476o / 2.0f);
            this.f15439E.setColor(this.f15450P);
            canvas.drawText(this.f15475n, f, this.f15478q, this.f15439E);
        }
    }

    /* renamed from: a */
    private void m16800a(Canvas canvas, float f) {
        if (!PatchProxy.proxy(new Object[]{canvas, new Float(f)}, this, f15433a, false, 8683, new Class[]{Canvas.class, Float.TYPE}, Void.TYPE).isSupported && this.f15470i >= 0 && this.f15470i <= this.f15474m.length - 1) {
            float f2 = ((((float) this.f15477p) / 2.0f) - (this.f15474m[this.f15470i] / 2.0f)) - f;
            this.f15439E.setColor(this.f15451Q);
            canvas.drawText(this.f15473l.get(this.f15470i), f2, this.f15478q, this.f15439E);
            if (!this.f15467f) {
                m16801a(canvas, this.f15470i, f2);
                m16807b(canvas, this.f15470i, f2);
            }
        }
    }

    /* renamed from: i */
    private boolean m16824i() {
        if (!this.f15435A && !this.f15444J) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private void m16801a(Canvas canvas, int i, float f) {
        int i2;
        if (!PatchProxy.proxy(new Object[]{canvas, new Integer(i), new Float(f)}, this, f15433a, false, 8684, new Class[]{Canvas.class, Integer.TYPE, Float.TYPE}, Void.TYPE).isSupported && (i2 = i - 1) >= 0) {
            float f2 = this.f15474m[i2];
            float f3 = (f - this.f15479r) - f2;
            this.f15439E.setColor(i2 == this.f15469h ? this.f15452R : this.f15450P);
            canvas.drawText(this.f15473l.get(i2), f3, this.f15478q, this.f15439E);
            if (f2 + f3 >= 0.0f) {
                m16801a(canvas, i2, f3);
            }
        }
    }

    /* renamed from: b */
    private void m16807b(Canvas canvas, int i, float f) {
        int i2;
        if (!PatchProxy.proxy(new Object[]{canvas, new Integer(i), new Float(f)}, this, f15433a, false, 8685, new Class[]{Canvas.class, Integer.TYPE, Float.TYPE}, Void.TYPE).isSupported && (i2 = i + 1) <= this.f15473l.size() - 1) {
            float f2 = f + this.f15474m[i] + this.f15479r;
            this.f15439E.setColor(i2 == this.f15469h ? this.f15452R : this.f15450P);
            canvas.drawText(this.f15473l.get(i2), f2, this.f15478q, this.f15439E);
            if (f2 <= ((float) this.f15477p)) {
                m16807b(canvas, i2, f2);
            }
        }
    }

    /* renamed from: a */
    private void m16798a(long j) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f15433a, false, 8686, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f15463ac == -1) {
                this.f15463ac = j;
            }
            float f = ((float) (j - this.f15463ac)) / 250.0f;
            if (f < 1.0f) {
                z = false;
            }
            int i = this.f15445K ? this.f15447M : this.f15448N;
            int i2 = this.f15445K ? this.f15448N : this.f15447M;
            if (f >= 0.0f && f <= 1.0f) {
                if (!this.f15444J) {
                    m16825j();
                }
                float interpolation = this.f15437C.getInterpolation(f);
                this.f15443I = this.f15442H * interpolation;
                this.f15451Q = ((Integer) this.f15453S.evaluate(f, Integer.valueOf(this.f15449O), Integer.valueOf(this.f15450P))).intValue();
                this.f15452R = ((Integer) this.f15453S.evaluate(f, Integer.valueOf(this.f15450P), Integer.valueOf(this.f15449O))).intValue();
                if (this.f15446L) {
                    this.f15454T.setColor(((Integer) this.f15453S.evaluate(interpolation, Integer.valueOf(i), Integer.valueOf(i2))).intValue());
                }
            }
            if (z && this.f15444J) {
                m16826p();
                this.f15451Q = this.f15449O;
                this.f15452R = this.f15450P;
                this.f15454T.setColor(i2);
            }
            mo23407o();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m16825j() {
        if (!PatchProxy.proxy(new Object[0], this, f15433a, false, 8687, new Class[0], Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f15434b;
            LogUtil.m15942a(aVar, "fireAnimationStart mComingPosition:" + this.f15469h + " ,mCurrentPosition:" + this.f15470i);
            int i = this.f15469h < this.f15470i ? this.f15469h : this.f15470i;
            int i2 = i == this.f15469h ? this.f15470i : this.f15469h;
            if (i >= 0 && i2 < this.f15474m.length) {
                float f = 0.0f;
                for (int i3 = i; i3 <= i2; i3++) {
                    f += this.f15474m[i3] + this.f15479r;
                }
                float f2 = ((f - (this.f15474m[i] / 2.0f)) - (this.f15474m[i2] / 2.0f)) - this.f15479r;
                LogUtil.C2630a aVar2 = f15434b;
                LogUtil.m15942a(aVar2, "fireAnimationStart before set mAnimDistance mComingPosition:" + this.f15469h + " ,mCurrentPosition:" + this.f15470i + ",mAnimDistance:" + this.f15442H);
                if (this.f15469h < this.f15470i) {
                    f2 = -f2;
                }
                this.f15442H = f2;
                LogUtil.C2630a aVar3 = f15434b;
                LogUtil.m15942a(aVar3, "fireAnimationStart after mAnimDistance:" + this.f15442H);
                this.f15444J = true;
                if (this.f15469h == this.f15471j - 1 || this.f15470i == this.f15471j - 1) {
                    this.f15446L = false;
                    return;
                }
                CameraModeType.ModeType modeType = this.f15466e.get(this.f15470i);
                if (this.f15466e.get(this.f15469h).equals(CameraModeType.ModeType.VIDEO)) {
                    this.f15445K = true;
                    this.f15446L = true;
                    this.f15456V = true;
                } else if (modeType.equals(CameraModeType.ModeType.VIDEO)) {
                    this.f15445K = false;
                    this.f15446L = true;
                    this.f15456V = true;
                } else {
                    this.f15446L = false;
                }
            }
        }
    }

    /* renamed from: p */
    private void m16826p() {
        if (!PatchProxy.proxy(new Object[0], this, f15433a, false, 8688, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f15434b, "fireAnimationEnd start");
            this.f15470i = this.f15469h;
            LogUtil.C2630a aVar = f15434b;
            LogUtil.m15942a(aVar, "fireAnimationEnd mCurrentPosition:" + this.f15470i);
            this.f15443I = 0.0f;
            this.f15463ac = -1;
            this.f15446L = false;
            this.f15436B.offset(-this.f15442H, 0.0f);
            this.f15444J = false;
            if (this.f15470i == this.f15468g) {
                this.f15435A = false;
            } else if (this.f15470i < this.f15468g) {
                m16811c(this.f15470i + 1);
            } else if (this.f15470i > this.f15468g) {
                m16811c(this.f15470i - 1);
            }
            if (this.f15460Z) {
                DeviceUtil.m16194a(this.f15465d, 22509);
            }
            LogUtil.C2630a aVar2 = f15434b;
            LogUtil.m15942a(aVar2, "fireAnimationEnd end mTouchableRect left:" + this.f15436B.left + ",right:" + this.f15436B.right);
        }
    }

    /* renamed from: a */
    public boolean mo23373a(int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f15433a, false, 8689, new Class[]{Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = f15434b;
        LogUtil.m15942a(aVar, "tapToSlideMode mSelectedPosition:" + this.f15468g);
        LogUtil.C2630a aVar2 = f15434b;
        LogUtil.m15942a(aVar2, "tapToSlideMode mCurrentPosition:" + this.f15470i);
        LogUtil.C2630a aVar3 = f15434b;
        LogUtil.m15942a(aVar3, "tapToSlideMode isModeMoveShowing " + this.f15457W.mo21922d());
        if (this.f15468g == -1 || !this.f15459Y || this.f15457W.mo21922d() || this.f15444J || !this.f15436B.contains((float) i, (float) i2)) {
            return false;
        }
        int a = m16794a(i, this.f15436B.left);
        LogUtil.C2630a aVar4 = f15434b;
        LogUtil.m15942a(aVar4, "tapToSlideMode tapedMode:" + a);
        if (a == -1 || a == this.f15468g) {
            return false;
        }
        this.f15468g = a;
        LogUtil.C2630a aVar5 = f15434b;
        LogUtil.m15942a(aVar5, "tapToSlideMode mSelectedPosition:" + this.f15468g);
        if (this.f15468g != this.f15470i) {
            m16802a("click");
            this.f15460Z = false;
            m16811c(this.f15468g);
        }
        return true;
    }

    /* renamed from: a */
    private int m16794a(int i, float f) {
        float f2 = f - (this.f15479r / 2.0f);
        int i2 = 0;
        while (i2 < this.f15474m.length) {
            float f3 = this.f15474m[i2] + f2 + this.f15479r;
            float f4 = (float) i;
            if (f4 >= f2 && f4 <= f3) {
                return i2;
            }
            i2++;
            f2 = f3;
        }
        return -1;
    }

    /* renamed from: a */
    public boolean mo23374a(int i, boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Byte(z ? (byte) 1 : 0)}, this, f15433a, false, 8690, new Class[]{Integer.TYPE, Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = f15434b;
        LogUtil.m15942a(aVar, "setCamMode:" + i + ",mFling:" + this.f15435A + ",mIsAnimRunning:" + this.f15444J);
        if (this.f15435A || this.f15444J) {
            return false;
        }
        CameraModeType.ModeType modeType = CameraModeType.f10557b[i];
        this.f15468g = this.f15466e.indexOf(modeType);
        LogUtil.C2630a aVar2 = f15434b;
        LogUtil.m15942a(aVar2, "setCamMode mSelectedPosition:" + this.f15468g);
        if (this.f15468g == -1) {
            this.f15472k = i;
            this.f15475n = this.f15464c.getResources().getString(modeType.getTxtId());
            this.f15476o = this.f15439E.measureText(this.f15475n);
        } else if (z) {
            this.f15460Z = false;
            m16806b(this.f15468g);
        } else {
            this.f15472k = i;
            this.f15470i = this.f15468g;
            m16823h();
        }
        mo23407o();
        return true;
    }

    /* renamed from: a */
    public int mo23367a() {
        return this.f15472k;
    }

    /* renamed from: b */
    public boolean mo23376b() {
        return this.f15468g == -1 || this.f15468g >= this.f15471j;
    }

    /* renamed from: d */
    public void mo23379d(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15433a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8691, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f15467f = z;
            mo23407o();
        }
    }

    /* renamed from: a */
    private void m16802a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f15433a, false, 8692, new Class[]{String.class}, Void.TYPE).isSupported) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", str);
            UsageStatsHelper.m16042a(this.f15464c.getApplicationContext()).mo22693a("mode_change_type", (Map<String, String>) hashMap);
        }
    }

    /* renamed from: c */
    public void mo23377c() {
        if (!PatchProxy.proxy(new Object[0], this, f15433a, false, 8693, new Class[0], Void.TYPE).isSupported) {
            this.f15455U = new RectF(CaptureAnimView.f7585b - CaptureAnimView.f7587d, CaptureAnimView.f7586c - CaptureAnimView.f7587d, CaptureAnimView.f7585b + CaptureAnimView.f7587d, CaptureAnimView.f7586c + CaptureAnimView.f7587d);
        }
    }
}
