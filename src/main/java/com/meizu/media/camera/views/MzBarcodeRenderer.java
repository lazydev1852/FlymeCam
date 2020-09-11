package com.meizu.media.camera.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.views.e */
public class MzBarcodeRenderer extends OverlayRenderer {

    /* renamed from: a */
    public static ChangeQuickRedirect f15242a;

    /* renamed from: b */
    private static final int f15243b = CameraUtil.m15809a();

    /* renamed from: c */
    private static int f15244c;

    /* renamed from: d */
    private static int f15245d;

    /* renamed from: e */
    private static int f15246e;

    /* renamed from: A */
    private float f15247A;

    /* renamed from: B */
    private float f15248B;

    /* renamed from: C */
    private int f15249C;

    /* renamed from: D */
    private Bitmap f15250D;

    /* renamed from: E */
    private Rect f15251E;

    /* renamed from: F */
    private boolean f15252F = false;

    /* renamed from: G */
    private boolean f15253G;

    /* renamed from: H */
    private long f15254H = -1;

    /* renamed from: I */
    private int f15255I = 1000;

    /* renamed from: J */
    private float f15256J = 2.0f;

    /* renamed from: K */
    private Matrix f15257K = new Matrix();

    /* renamed from: L */
    private boolean f15258L = false;

    /* renamed from: M */
    private int f15259M = 0;

    /* renamed from: f */
    private Rect f15260f;

    /* renamed from: g */
    private Bitmap f15261g;

    /* renamed from: h */
    private Bitmap f15262h;

    /* renamed from: i */
    private Rect f15263i;

    /* renamed from: j */
    private Rect f15264j;

    /* renamed from: k */
    private Rect f15265k;

    /* renamed from: l */
    private Rect f15266l;

    /* renamed from: m */
    private Paint f15267m;

    /* renamed from: n */
    private Paint f15268n;

    /* renamed from: o */
    private TextPaint f15269o;

    /* renamed from: p */
    private String f15270p;

    /* renamed from: q */
    private float f15271q;

    /* renamed from: r */
    private float f15272r;

    /* renamed from: s */
    private String f15273s;

    public MzBarcodeRenderer(Context context) {
        m16706a(context);
    }

    /* renamed from: a */
    private void m16706a(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f15242a, false, 8502, new Class[]{Context.class}, Void.TYPE).isSupported) {
            Resources resources = context.getResources();
            f15245d = CameraUtil.m15901h();
            f15246e = CameraUtil.m15897f();
            f15244c = CameraUtil.m15865b();
            this.f15249C = resources.getDimensionPixelOffset(R.dimen.mz_barcode_scan_hint_length);
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mz_barcode_scan_length);
            int i = (f15243b - dimensionPixelOffset) / 2;
            int i2 = ((((f15244c - f15245d) - f15246e) - dimensionPixelOffset) / 2) + f15245d;
            this.f15260f = new Rect(i, i2, i + dimensionPixelOffset, dimensionPixelOffset + i2);
            this.f15267m = new Paint();
            this.f15267m.setColor(resources.getColor(R.color.mz_barcode_scan_bg));
            this.f15263i = new Rect(0, 0, f15243b, this.f15260f.top);
            this.f15264j = new Rect(0, this.f15260f.bottom, f15243b, f15244c);
            this.f15265k = new Rect(0, this.f15260f.top, this.f15260f.left, this.f15260f.bottom);
            this.f15266l = new Rect(this.f15260f.right, this.f15260f.top, f15243b, this.f15260f.bottom);
            this.f15261g = BitmapFactory.decodeResource(resources, R.drawable.mz_barcode_scope);
            this.f15250D = m16704a(resources, (int) R.drawable.mz_barcode_light);
            this.f15262h = BitmapFactory.decodeResource(resources, R.drawable.mz_barcode_scope_success);
            int width = this.f15250D.getWidth();
            int i3 = (f15243b - width) / 2;
            int i4 = ((((f15244c - f15245d) - width) - f15246e) / 2) + f15245d;
            this.f15251E = new Rect(i3, i4, i3 + width, width + i4);
            this.f15268n = new Paint();
            float dimensionPixelOffset2 = (float) resources.getDimensionPixelOffset(R.dimen.mz_font_size_13sp);
            this.f15268n.setTextSize(dimensionPixelOffset2);
            this.f15268n.setColor(resources.getColor(R.color.mz_barcode_hint_text_color));
            this.f15268n.setTextAlign(Paint.Align.LEFT);
            this.f15268n.setAntiAlias(true);
            this.f15269o = new TextPaint();
            this.f15269o.setTextSize(dimensionPixelOffset2);
            this.f15269o.setColor(resources.getColor(R.color.mz_barcode_hint_text_color));
            this.f15269o.setTextAlign(Paint.Align.LEFT);
            this.f15269o.setAntiAlias(true);
            this.f15270p = resources.getString(R.string.mz_bar_code_hint);
            int dimensionPixelOffset3 = resources.getDimensionPixelOffset(R.dimen.mz_barcode_scan_hint_margin);
            this.f15271q = (((float) f15243b) - this.f15268n.measureText(this.f15270p)) / 2.0f;
            this.f15272r = (float) (this.f15260f.bottom + dimensionPixelOffset3);
            this.f15273s = resources.getString(R.string.mz_bar_code_hint_success);
            this.f15247A = (((float) f15243b) - this.f15268n.measureText(this.f15273s)) / 2.0f;
            this.f15248B = this.f15272r;
        }
    }

    /* renamed from: a */
    public void mo23317a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15242a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8503, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f15252F = z;
            m16708c();
        }
    }

    /* renamed from: a */
    public Rect mo23316a() {
        return this.f15260f;
    }

    /* renamed from: a */
    public void mo20787a(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15242a, false, 8504, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            canvas.drawRect(this.f15263i, this.f15267m);
            canvas.drawRect(this.f15265k, this.f15267m);
            canvas.drawRect(this.f15266l, this.f15267m);
            canvas.drawRect(this.f15264j, this.f15267m);
            if (this.f15252F) {
                canvas.drawText(this.f15273s, this.f15247A, this.f15248B, this.f15268n);
                canvas.drawBitmap(this.f15262h, (Rect) null, this.f15260f, (Paint) null);
            } else {
                if (!this.f15253G) {
                    m16709c(canvas);
                }
                canvas.drawBitmap(this.f15261g, (Rect) null, this.f15260f, (Paint) null);
                m16710d(canvas);
            }
            mo23407o();
        }
    }

    /* renamed from: c */
    private void m16709c(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15242a, false, 8505, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            canvas.save();
            canvas.rotate((float) this.f15259M, this.f15251E.exactCenterX(), this.f15251E.exactCenterY());
            if (!this.f15258L) {
                m16707b(SystemClock.uptimeMillis());
            } else {
                m16705a(SystemClock.uptimeMillis());
            }
            this.f15257K.reset();
            this.f15257K.preTranslate((float) this.f15251E.left, (float) this.f15251E.top);
            this.f15257K.postScale(1.0f, this.f15256J, (float) this.f15251E.left, (float) this.f15251E.top);
            if (this.f15258L) {
                this.f15257K.postTranslate(0.0f, ((float) this.f15251E.height()) - (((float) ((this.f15251E.height() / 2) + 1)) * this.f15256J));
            }
            canvas.drawBitmap(this.f15250D, this.f15257K, (Paint) null);
            canvas.restore();
        }
    }

    /* renamed from: a */
    private void m16705a(long j) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f15242a, false, 8506, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f15254H == -1) {
                this.f15254H = j;
            }
            float f = ((float) (j - this.f15254H)) / ((float) this.f15255I);
            if (f < 1.0f) {
                z = false;
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.f15256J = 2.0f - (mo23315a(f, 1.0f) * 2.0f);
            }
            if (z) {
                this.f15256J = 0.0f;
                this.f15254H = -1;
                this.f15259M = (this.f15259M + 180) % 360;
                this.f15258L = false;
            }
        }
    }

    /* renamed from: b */
    private void m16707b(long j) {
        boolean z = false;
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f15242a, false, 8507, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f15254H == -1) {
                this.f15254H = j;
            }
            float f = ((float) (j - this.f15254H)) / ((float) this.f15255I);
            if (f >= 1.0f) {
                z = true;
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.f15256J = (mo23315a(f, 0.5f) * 2.0f) + 0.0f;
            }
            if (z) {
                this.f15256J = 2.0f;
                this.f15254H = -1;
                this.f15258L = true;
            }
        }
    }

    /* renamed from: a */
    public float mo23315a(float f, float f2) {
        Object[] objArr = {new Float(f), new Float(f2)};
        ChangeQuickRedirect changeQuickRedirect = f15242a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 8508, new Class[]{Float.TYPE, Float.TYPE}, Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        if (f2 != 1.0f) {
            return (float) (1.0d - Math.pow((double) (1.0f - f), (double) (f2 * 2.0f)));
        }
        float f3 = 1.0f - f;
        return 1.0f - (f3 * f3);
    }

    /* renamed from: d */
    private void m16710d(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15242a, false, 8509, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            if (((int) this.f15268n.measureText(this.f15270p, 0, this.f15270p.length())) > this.f15249C) {
                StaticLayout staticLayout = new StaticLayout(this.f15270p, this.f15269o, this.f15249C, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
                canvas.save();
                canvas.translate((float) ((CameraUtil.m15809a() - this.f15249C) / 2), this.f15272r);
                staticLayout.draw(canvas);
                canvas.restore();
                return;
            }
            canvas.drawText(this.f15270p, this.f15271q, this.f15272r, this.f15268n);
        }
    }

    /* renamed from: a */
    private Bitmap m16704a(Resources resources, int i) {
        Object[] objArr = {resources, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f15242a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 8510, new Class[]{Resources.class, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        Drawable drawable = resources.getDrawable(i);
        Canvas canvas = new Canvas();
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: b */
    public void mo23318b(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f15242a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8511, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f15253G = z;
            if (this.f15253G) {
                m16708c();
            }
        }
    }

    /* renamed from: c */
    private void m16708c() {
        this.f15254H = -1;
        this.f15256J = 2.0f;
        this.f15258L = false;
        this.f15259M = 0;
    }

    /* renamed from: b */
    public boolean mo23319b() {
        return this.f15252F;
    }
}
