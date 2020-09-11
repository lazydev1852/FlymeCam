package com.meizu.media.camera.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.meizu.imageproc.PanoramaStitcher;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.media.camera.views.i */
public class MzPanoRenderer extends OverlayRenderer {

    /* renamed from: a */
    public static ChangeQuickRedirect f15359a;

    /* renamed from: an */
    private static int f15360an = 0;

    /* renamed from: ao */
    private static boolean f15361ao = false;

    /* renamed from: ap */
    private static int f15362ap = 0;

    /* renamed from: c */
    private static final LogUtil.C2630a f15363c = new LogUtil.C2630a("MzPanoRenderer");

    /* renamed from: A */
    private int f15364A;

    /* renamed from: B */
    private int f15365B;

    /* renamed from: C */
    private int f15366C;

    /* renamed from: D */
    private int f15367D;

    /* renamed from: E */
    private Paint f15368E = new Paint();

    /* renamed from: F */
    private Rect f15369F;

    /* renamed from: G */
    private RectF f15370G;

    /* renamed from: H */
    private int f15371H;

    /* renamed from: I */
    private int f15372I;

    /* renamed from: J */
    private int f15373J;

    /* renamed from: K */
    private int f15374K;

    /* renamed from: L */
    private int f15375L;

    /* renamed from: M */
    private int f15376M;

    /* renamed from: N */
    private int f15377N;

    /* renamed from: O */
    private Rect f15378O;

    /* renamed from: P */
    private Bitmap f15379P;

    /* renamed from: Q */
    private float f15380Q;

    /* renamed from: R */
    private Paint f15381R = new Paint();

    /* renamed from: S */
    private TextPaint f15382S = new TextPaint();

    /* renamed from: T */
    private int f15383T;

    /* renamed from: U */
    private int f15384U;

    /* renamed from: V */
    private String f15385V;

    /* renamed from: W */
    private String f15386W;

    /* renamed from: X */
    private String f15387X;

    /* renamed from: Y */
    private String f15388Y;

    /* renamed from: Z */
    private String f15389Z;

    /* renamed from: aa */
    private Bitmap f15390aa;

    /* renamed from: ab */
    private Bitmap f15391ab;

    /* renamed from: ac */
    private Bitmap f15392ac;

    /* renamed from: ad */
    private NinePatch f15393ad;

    /* renamed from: ae */
    private Bitmap f15394ae;

    /* renamed from: af */
    private int f15395af;

    /* renamed from: ag */
    private boolean f15396ag = false;
    /* access modifiers changed from: private */

    /* renamed from: ah */
    public int f15397ah = 0;

    /* renamed from: ai */
    private Handler f15398ai = new Handler();

    /* renamed from: aj */
    private Object f15399aj = new Object();

    /* renamed from: ak */
    private List<C2747a> f15400ak = new ArrayList();

    /* renamed from: al */
    private int f15401al = 0;

    /* renamed from: am */
    private int f15402am = 0;

    /* renamed from: aq */
    private int f15403aq = 0;

    /* renamed from: ar */
    private long f15404ar = 0;

    /* renamed from: as */
    private String f15405as = "";

    /* renamed from: at */
    private boolean f15406at = false;

    /* renamed from: au */
    private Runnable f15407au = new Runnable() {

        /* renamed from: a */
        public static ChangeQuickRedirect f15425a;

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f15425a, false, 8659, new Class[0], Void.TYPE).isSupported) {
                int unused = MzPanoRenderer.this.f15397ah = 2;
            }
        }
    };

    /* renamed from: b */
    private Context f15408b;

    /* renamed from: d */
    private int f15409d;

    /* renamed from: e */
    private int f15410e;

    /* renamed from: f */
    private int f15411f;

    /* renamed from: g */
    private int f15412g;

    /* renamed from: h */
    private Bitmap f15413h;

    /* renamed from: i */
    private int f15414i;

    /* renamed from: j */
    private int f15415j;

    /* renamed from: k */
    private int f15416k;

    /* renamed from: l */
    private int f15417l = 0;

    /* renamed from: m */
    private int f15418m;

    /* renamed from: n */
    private int f15419n;

    /* renamed from: o */
    private int f15420o;

    /* renamed from: p */
    private int f15421p;

    /* renamed from: q */
    private int f15422q;

    /* renamed from: r */
    private int f15423r;

    /* renamed from: s */
    private int f15424s;

    public MzPanoRenderer(Context context) {
        this.f15408b = context;
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f15396ag = true;
        } else {
            this.f15396ag = false;
        }
        this.f15369F = new Rect(0, 0, 0, 0);
        this.f15370G = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        m16768a(context.getResources());
        m16767a(context);
        f15360an = 0;
    }

    /* renamed from: com.meizu.media.camera.views.i$a */
    /* compiled from: MzPanoRenderer */
    private class C2747a {

        /* renamed from: a */
        byte[] f15427a;

        /* renamed from: b */
        int f15428b;

        /* renamed from: c */
        int f15429c;

        /* renamed from: d */
        int f15430d;

        /* renamed from: e */
        boolean f15431e;

        private C2747a() {
        }

        /* renamed from: a */
        public void mo23366a(int i, int i2) {
            this.f15428b = i;
            this.f15429c = i2;
        }
    }

    /* renamed from: a */
    private void m16768a(Resources resources) {
        if (!PatchProxy.proxy(new Object[]{resources}, this, f15359a, false, 8638, new Class[]{Resources.class}, Void.TYPE).isSupported) {
            this.f15385V = resources.getString(R.string.mz_pano_hint);
            this.f15386W = resources.getString(R.string.mz_pano_hint_start_panning);
            this.f15387X = resources.getString(R.string.mz_pano_hint_too_fast);
            this.f15388Y = resources.getString(R.string.mz_pano_hint_off_center);
            this.f15389Z = resources.getString(R.string.mz_pano_hint_saving);
            this.f15364A = resources.getDimensionPixelOffset(R.dimen.mz_pano_big_preview_margin);
            this.f15371H = resources.getDimensionPixelOffset(R.dimen.mz_pano_arrow_margin);
            this.f15384U = resources.getDimensionPixelOffset(R.dimen.mz_pano_hint_margin_top);
            this.f15376M = resources.getDimensionPixelOffset(R.dimen.mz_pano_indicator_margin);
            this.f15375L = resources.getDimensionPixelOffset(R.dimen.mz_pano_small_preview_margin);
            this.f15366C = resources.getDimensionPixelOffset(R.dimen.mz_pano_line_height);
            this.f15367D = resources.getColor(R.color.mz_mode_name_shadow_color);
            this.f15377N = resources.getDimensionPixelOffset(R.dimen.mz_pano_indicator_bitmap_margin);
        }
    }

    /* renamed from: a */
    private void m16767a(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f15359a, false, 8639, new Class[]{Context.class}, Void.TYPE).isSupported) {
            this.f15418m = CameraUtil.m15809a();
            this.f15419n = CameraUtil.m15881c();
            this.f15380Q = context.getResources().getDimension(R.dimen.mz_font_size_14sp);
        }
    }

    /* renamed from: j */
    private void m16773j() {
        if (!PatchProxy.proxy(new Object[0], this, f15359a, false, 8640, new Class[0], Void.TYPE).isSupported) {
            this.f15420o = (this.f15418m - (this.f15364A * 2)) - (this.f15375L * 2);
            this.f15412g = this.f15420o * this.f15411f;
            this.f15421p = this.f15409d / this.f15411f;
            this.f15422q = this.f15410e / this.f15411f;
            this.f15365B = (CameraUtil.m15901h() + ((this.f15419n - this.f15422q) / 2)) - this.f15375L;
            this.f15369F = new Rect(this.f15364A, this.f15365B, this.f15418m, this.f15365B + this.f15422q + (this.f15375L * 2));
            this.f15370G = new RectF((float) (this.f15364A + ((this.f15420o - this.f15421p) / 2) + this.f15375L), (float) (this.f15369F.top + this.f15375L), (float) (this.f15364A + ((this.f15420o - this.f15421p) / 2) + this.f15421p + this.f15375L), (float) (this.f15369F.bottom - this.f15375L));
            this.f15378O = new Rect(0, 0, 0, 0);
            this.f15368E.setStrokeWidth(4.0f);
            this.f15368E.setStyle(Paint.Style.STROKE);
            this.f15368E.setColor(-1);
            this.f15381R.setARGB(255, 255, 255, 255);
            this.f15381R.setTextSize(this.f15380Q);
            this.f15381R.setTextAlign(Paint.Align.LEFT);
            this.f15381R.setAntiAlias(true);
            this.f15381R.setShadowLayer(2.0f, 0.0f, 1.0f, this.f15367D);
            this.f15382S.setARGB(255, 255, 255, 255);
            this.f15382S.setTextSize(this.f15380Q);
            this.f15382S.setTextAlign(Paint.Align.LEFT);
            this.f15382S.setAntiAlias(true);
            this.f15382S.setShadowLayer(2.0f, 0.0f, 1.0f, this.f15367D);
            this.f15383T = (int) ((-this.f15381R.ascent()) - this.f15381R.descent());
            this.f15414i = this.f15412g / this.f15411f;
            this.f15415j = this.f15410e / this.f15411f;
        }
    }

    /* renamed from: a */
    public void mo23347a() {
        if (!PatchProxy.proxy(new Object[0], this, f15359a, false, 8641, new Class[0], Void.TYPE).isSupported) {
            this.f15390aa = BitmapFactory.decodeResource(this.f15408b.getResources(), R.drawable.mz_pano_dir_left);
            this.f15391ab = BitmapFactory.decodeResource(this.f15408b.getResources(), R.drawable.mz_pano_dir_right);
            this.f15392ac = BitmapFactory.decodeResource(this.f15408b.getResources(), R.drawable.mz_pano_bg);
            this.f15393ad = new NinePatch(this.f15392ac, this.f15392ac.getNinePatchChunk(), (String) null);
            if (this.f15414i > 0 && this.f15415j > 0) {
                this.f15413h = Bitmap.createBitmap(this.f15414i, this.f15415j, Bitmap.Config.ARGB_8888);
            }
            int width = this.f15390aa.getWidth();
            int height = this.f15390aa.getHeight();
            this.f15372I = (((this.f15364A + ((this.f15420o - this.f15421p) / 2)) + this.f15375L) - this.f15371H) - width;
            this.f15373J = this.f15364A + ((this.f15420o - this.f15421p) / 2) + this.f15421p + this.f15375L + this.f15371H;
            this.f15374K = this.f15365B + this.f15375L + ((this.f15422q - height) / 2);
        }
    }

    /* renamed from: a */
    public void mo23349a(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f15359a, false, 8642, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f15409d = i;
            this.f15410e = i2;
            this.f15411f = this.f15409d / (this.f15418m / 7);
            if (this.f15411f % 2 != 0) {
                this.f15411f--;
            }
            if (this.f15411f != 0) {
                m16773j();
            }
        }
    }

    /* renamed from: a */
    public void mo23351a(byte[] bArr) {
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f15359a, false, 8643, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            int i = this.f15421p;
            int i2 = this.f15422q;
            int[] iArr = new int[(i * i2)];
            PanoramaStitcher.nativeYuv2Rgba(bArr, this.f15410e, this.f15409d, 0, iArr, i, this.f15411f, 90);
            if (this.f15379P == null) {
                this.f15379P = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            }
            if (this.f15379P.isMutable()) {
                this.f15379P.setPixels(iArr, 0, i, 0, 0, i, i2);
            }
            mo23407o();
        }
    }

    /* renamed from: b */
    public int mo23353b() {
        return this.f15421p;
    }

    /* renamed from: c */
    public int mo23357c() {
        return this.f15411f;
    }

    /* renamed from: a */
    public void mo23350a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f15359a, false, 8644, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (this.f15413h != null && !this.f15413h.isRecycled()) {
                this.f15413h.recycle();
                this.f15413h = null;
            }
            if (!z) {
                this.f15413h = Bitmap.createBitmap(this.f15414i, this.f15415j, Bitmap.Config.ARGB_8888);
            }
            this.f15416k = 0;
            f15362ap = 0;
            this.f15417l = 0;
            f15361ao = false;
            this.f15403aq = 0;
            this.f15423r = 0;
            this.f15424s = 0;
        }
    }

    /* renamed from: d */
    public void mo23359d() {
        if (!PatchProxy.proxy(new Object[0], this, f15359a, false, 8645, new Class[0], Void.TYPE).isSupported) {
            if (this.f15413h != null && !this.f15413h.isRecycled()) {
                this.f15413h.recycle();
                this.f15413h = null;
            }
            if (this.f15390aa != null && !this.f15390aa.isRecycled()) {
                this.f15390aa.recycle();
                this.f15390aa = null;
            }
            if (this.f15391ab != null && !this.f15391ab.isRecycled()) {
                this.f15391ab.recycle();
                this.f15391ab = null;
            }
            if (this.f15392ac != null && !this.f15392ac.isRecycled()) {
                this.f15392ac.recycle();
                this.f15392ac = null;
            }
            if (this.f15379P != null && !this.f15379P.isRecycled()) {
                this.f15379P.recycle();
                this.f15379P = null;
            }
            this.f15393ad = null;
        }
    }

    /* renamed from: e */
    public void mo23360e() {
        if (!PatchProxy.proxy(new Object[0], this, f15359a, false, 8646, new Class[0], Void.TYPE).isSupported) {
            if (this.f15400ak != null && !this.f15400ak.isEmpty()) {
                this.f15400ak.clear();
                this.f15400ak = null;
            }
            f15360an = 0;
        }
    }

    /* renamed from: f */
    public int mo23361f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f15359a, false, 8647, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (this.f15412g == 0) {
            LogUtil.m15949b(f15363c, "getPanoramaWidth() error, not initialized");
        }
        return this.f15412g;
    }

    /* renamed from: b */
    public void mo23355b(int i, int i2) {
        this.f15423r = i / this.f15411f;
        this.f15424s = i2 / this.f15411f;
    }

    /* renamed from: a */
    public void mo23348a(int i) {
        this.f15397ah = i;
    }

    /* renamed from: a */
    public void mo23352a(byte[] bArr, int i, int i2, int i3) {
        if (!PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2), new Integer(i3)}, this, f15359a, false, 8648, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (f15360an == 0) {
                if (this.f15400ak == null) {
                    this.f15400ak = new ArrayList();
                }
                if (!this.f15400ak.isEmpty()) {
                    this.f15400ak.clear();
                }
                for (int i4 = 0; i4 < 10; i4++) {
                    C2747a aVar = new C2747a();
                    aVar.mo23366a(i, i2);
                    aVar.f15431e = true;
                    this.f15400ak.add(i4, aVar);
                }
                f15360an = 1;
                this.f15402am = 0;
            }
            synchronized (this.f15399aj) {
                if (this.f15400ak != null) {
                    this.f15400ak.get(this.f15402am).f15428b = i;
                    this.f15400ak.get(this.f15402am).f15429c = i2;
                    this.f15400ak.get(this.f15402am).f15427a = bArr;
                    this.f15400ak.get(this.f15402am).f15430d = i3;
                    this.f15400ak.get(this.f15402am).f15431e = false;
                    this.f15402am = (this.f15402am + 1) % 10;
                    this.f15416k++;
                } else {
                    LogUtil.m15949b(f15363c, " mPanoramaRenderInfo is null ");
                }
            }
        }
    }

    /* renamed from: b */
    public void mo23356b(byte[] bArr) {
        int i;
        int i2;
        if (!PatchProxy.proxy(new Object[]{bArr}, this, f15359a, false, 8649, new Class[]{byte[].class}, Void.TYPE).isSupported) {
            int i3 = this.f15421p;
            int i4 = this.f15422q;
            int[] iArr = new int[(i3 * i4)];
            PanoramaStitcher.nativeYuv2Rgba(bArr, this.f15410e, this.f15409d, 0, iArr, i3, this.f15411f, 90);
            if (this.f15413h == null) {
                this.f15413h = Bitmap.createBitmap(this.f15414i, this.f15415j, Bitmap.Config.ARGB_8888);
            }
            int i5 = (this.f15417l * (this.f15421p - i3)) + this.f15423r;
            if (-1 == this.f15417l) {
                i5 += this.f15413h.getWidth() - i3;
            }
            if (Math.abs(i5 - this.f15403aq) > i3 && f15361ao) {
                if (-1 == this.f15417l) {
                    i5 = this.f15403aq - i3;
                } else {
                    i5 = this.f15403aq + i3;
                }
            }
            f15361ao = true;
            if (this.f15424s >= 0) {
                i = this.f15424s;
                i2 = 0;
            } else {
                i2 = -this.f15424s;
                i = 0;
            }
            int width = Math.abs(i5) + i3 > this.f15413h.getWidth() ? this.f15413h.getWidth() - Math.abs(i5) : i3;
            if (i5 < 0) {
                i5 = 0;
            }
            if (this.f15413h.isMutable() && width >= 0) {
                this.f15413h.setPixels(iArr, i3 * i2, i3, i5, i, width, i4 - Math.abs(this.f15424s));
            }
            this.f15403aq = i5;
        }
    }

    /* renamed from: b */
    public void mo23354b(int i) {
        this.f15395af = i;
    }

    /* renamed from: c */
    public void mo23358c(int i) {
        this.f15417l = i;
    }

    /* renamed from: c */
    private void m16770c(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15359a, false, 8650, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            long currentTimeMillis = System.currentTimeMillis() - this.f15404ar;
            int i = this.f15397ah;
            if (i != -105) {
                if (i != -103) {
                    if (i != 101) {
                        switch (i) {
                            case 0:
                                if (!this.f15406at) {
                                    this.f15405as = this.f15385V;
                                    this.f15404ar = System.currentTimeMillis();
                                    break;
                                }
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                this.f15405as = this.f15389Z;
                                this.f15404ar = System.currentTimeMillis();
                                if (this.f15406at) {
                                    this.f15406at = false;
                                    break;
                                }
                                break;
                            default:
                                if (!this.f15406at) {
                                    this.f15405as = this.f15385V;
                                    this.f15404ar = System.currentTimeMillis();
                                    break;
                                }
                                break;
                        }
                    }
                    if ((this.f15404ar != 0 && currentTimeMillis > 3000) || this.f15405as.equals(this.f15388Y) || this.f15405as.equals(this.f15387X)) {
                        this.f15405as = "";
                        this.f15404ar = System.currentTimeMillis();
                    } else if (!this.f15406at) {
                        this.f15405as = this.f15386W;
                        this.f15404ar = System.currentTimeMillis();
                        this.f15406at = true;
                    }
                } else if (!this.f15405as.equals(this.f15387X) && currentTimeMillis >= 1000) {
                    this.f15405as = this.f15387X;
                    this.f15404ar = System.currentTimeMillis();
                }
            } else if (!this.f15405as.equals(this.f15388Y) && currentTimeMillis >= 1000) {
                this.f15405as = this.f15388Y;
                this.f15404ar = System.currentTimeMillis();
            }
            int measureText = (int) this.f15381R.measureText(this.f15405as);
            if (this.f15396ag) {
                if (this.f15395af == 90 || this.f15395af == 270) {
                    int height = (this.f15419n / 2) + (this.f15369F.height() / 2) + this.f15384U + (measureText / 2);
                    int i2 = this.f15418m / 2;
                    canvas.translate((float) (((((this.f15419n / 2) + (this.f15369F.height() / 2)) + this.f15384U) + (this.f15383T / 2)) - height), (float) ((this.f15418m / 2) - i2));
                    canvas.rotate(270.0f, (float) height, (float) i2);
                }
                if (this.f15395af == 180) {
                    canvas.rotate(180.0f, (float) ((this.f15419n / 2) + (this.f15369F.height() / 2) + this.f15384U + (measureText / 2)), (float) (this.f15418m / 2));
                }
                canvas.drawText(this.f15405as, (float) ((this.f15419n / 2) + (this.f15369F.height() / 2) + this.f15384U), (float) ((this.f15418m / 2) + (this.f15383T / 2)), this.f15381R);
                return;
            }
            if (this.f15395af == 90) {
                int i3 = this.f15418m / 2;
                int height2 = (this.f15419n / 2) + (this.f15369F.height() / 2) + this.f15384U + (this.f15383T / 2);
                canvas.translate((float) ((this.f15418m / 2) - i3), (float) (((((this.f15419n / 2) + (this.f15369F.height() / 2)) + this.f15384U) + (measureText / 2)) - height2));
                canvas.rotate(270.0f, (float) i3, (float) height2);
            } else if (this.f15395af == 270) {
                int i4 = this.f15418m / 2;
                int height3 = (this.f15419n / 2) + (this.f15369F.height() / 2) + this.f15384U + (this.f15383T / 2);
                canvas.translate((float) ((this.f15418m / 2) - i4), (float) (((((this.f15419n / 2) + (this.f15369F.height() / 2)) + this.f15384U) + (measureText / 2)) - height3));
                canvas.rotate(90.0f, (float) i4, (float) height3);
            }
            m16769a(this.f15405as, canvas);
        }
    }

    /* renamed from: d */
    private void m16771d(Canvas canvas) {
        int i;
        int i2;
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15359a, false, 8651, new Class[]{Canvas.class}, Void.TYPE).isSupported && this.f15397ah != 3) {
            int i3 = this.f15364A;
            if (1 == this.f15417l) {
                i = i3 + this.f15423r + this.f15375L;
                this.f15394ae = BitmapFactory.decodeResource(this.f15408b.getResources(), R.drawable.mz_pano_dir_right);
            } else {
                i = (((i3 + this.f15420o) + this.f15423r) - this.f15421p) + this.f15375L;
                this.f15394ae = BitmapFactory.decodeResource(this.f15408b.getResources(), R.drawable.mz_pano_dir_left);
            }
            int height = ((this.f15365B + ((this.f15422q + (this.f15375L * 2)) / 2)) - (this.f15394ae.getHeight() / 2)) + this.f15424s;
            if (this.f15417l == 1) {
                i2 = i + this.f15377N + this.f15421p;
            } else {
                i2 = (i - this.f15377N) - this.f15394ae.getWidth();
            }
            canvas.drawBitmap(this.f15394ae, (float) i2, (float) height, (Paint) null);
        }
    }

    /* renamed from: g */
    public void mo23362g() {
        if (!PatchProxy.proxy(new Object[0], this, f15359a, false, 8652, new Class[0], Void.TYPE).isSupported && this.f15416k >= 1) {
            if (f15362ap == 0) {
                this.f15401al = ((this.f15402am - 1) + 10) % 10;
            }
            if (this.f15401al != -1 && this.f15400ak != null) {
                C2747a aVar = this.f15400ak.get(this.f15401al);
                int i = this.f15416k - f15362ap;
                if (i >= 2) {
                    int i2 = aVar.f15429c;
                    int i3 = aVar.f15428b;
                    C2747a aVar2 = this.f15400ak.get((this.f15401al + 1) % 10);
                    C2747a aVar3 = aVar;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= i - 1 || (i2 = i2 + aVar2.f15429c) >= this.f15422q) {
                            break;
                        } else if (Math.abs(aVar2.f15428b - i3) >= 50) {
                            LogUtil.m15942a(f15363c, "can not remove this frame cause X change >= 50");
                            break;
                        } else {
                            aVar3.f15431e = true;
                            f15362ap++;
                            this.f15401al = (this.f15401al + 1) % 10;
                            C2747a aVar4 = this.f15400ak.get(this.f15401al);
                            aVar4.f15431e = false;
                            i4++;
                            C2747a aVar5 = aVar4;
                            aVar3 = aVar2;
                            aVar2 = aVar5;
                        }
                    }
                    aVar = aVar3;
                }
                if (aVar.f15427a != null && !aVar.f15431e && Math.abs(aVar.f15428b / this.f15411f) >= Math.abs(this.f15423r)) {
                    if (f15362ap % 4 == 0) {
                        mo23348a(aVar.f15430d);
                    }
                    this.f15401al = (this.f15401al + 1) % 10;
                    mo23355b(aVar.f15428b, aVar.f15429c);
                    mo23356b(aVar.f15427a);
                    aVar.f15431e = true;
                    f15362ap++;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo20787a(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15359a, false, 8653, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            int save = canvas.save();
            if (this.f15396ag) {
                int i = this.f15369F.left + ((this.f15369F.right - this.f15369F.left) / 2);
                int i2 = this.f15369F.top + ((this.f15369F.bottom - this.f15369F.top) / 2);
                canvas.translate((float) (i2 - i), (float) (i - i2));
                canvas.rotate(270.0f, (float) i, (float) i2);
            }
            if (this.f15393ad != null) {
                this.f15393ad.draw(canvas, this.f15369F);
            }
            if (this.f15397ah != 3) {
                synchronized (this.f15399aj) {
                    mo23362g();
                }
            }
            m16772e(canvas);
            if (this.f15417l == 0) {
                if (this.f15390aa != null) {
                    canvas.drawBitmap(this.f15390aa, (float) this.f15372I, (float) this.f15374K, (Paint) null);
                }
                if (this.f15391ab != null) {
                    canvas.drawBitmap(this.f15391ab, (float) this.f15373J, (float) this.f15374K, (Paint) null);
                }
                this.f15368E.setColor(-1);
                if (this.f15379P != null) {
                    canvas.drawBitmap(this.f15379P, (float) (this.f15364A + ((this.f15420o - this.f15421p) / 2) + this.f15375L), (float) (this.f15369F.top + this.f15375L), (Paint) null);
                }
            } else {
                if (this.f15413h != null) {
                    canvas.drawBitmap(this.f15413h, (float) (this.f15364A + this.f15375L), (float) (this.f15365B + this.f15375L), (Paint) null);
                }
                m16771d(canvas);
            }
            canvas.restoreToCount(save);
            m16770c(canvas);
        }
    }

    /* renamed from: h */
    public void mo23363h() {
        if (!PatchProxy.proxy(new Object[0], this, f15359a, false, 8654, new Class[0], Void.TYPE).isSupported) {
            mo23407o();
        }
    }

    /* renamed from: i */
    public void mo23364i() {
        if (!PatchProxy.proxy(new Object[0], this, f15359a, false, 8655, new Class[0], Void.TYPE).isSupported) {
            synchronized (this.f15399aj) {
                if (this.f15400ak != null) {
                    for (int i = 0; i < this.f15400ak.size(); i++) {
                        this.f15400ak.get(i).f15431e = true;
                    }
                    this.f15402am = 0;
                }
            }
        }
    }

    /* renamed from: a */
    private void m16769a(String str, Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{str, canvas}, this, f15359a, false, 8656, new Class[]{String.class, Canvas.class}, Void.TYPE).isSupported) {
            if (((int) this.f15381R.measureText(str, 0, str.length())) > this.f15418m) {
                StaticLayout staticLayout = new StaticLayout(str, this.f15382S, this.f15418m, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
                canvas.save();
                canvas.translate(0.0f, (float) (this.f15369F.bottom + this.f15384U + this.f15383T));
                staticLayout.draw(canvas);
                canvas.restore();
                return;
            }
            canvas.drawText(str, (float) ((this.f15418m - ((int) this.f15381R.measureText(str))) / 2), (float) (this.f15369F.bottom + this.f15384U + this.f15383T), this.f15381R);
        }
    }

    /* renamed from: e */
    private void m16772e(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15359a, false, 8657, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            Paint paint = new Paint();
            paint.setColor(this.f15408b.getResources().getColor(R.color.pano_line));
            paint.setStrokeWidth((float) this.f15366C);
            canvas.drawLine(0.0f, (float) (this.f15365B + ((this.f15422q + (this.f15375L * 2)) / 2) + (this.f15366C / 2)), (float) this.f15418m, (float) (this.f15365B + ((this.f15422q + (this.f15375L * 2)) / 2) + (this.f15366C / 2)), paint);
        }
    }
}
