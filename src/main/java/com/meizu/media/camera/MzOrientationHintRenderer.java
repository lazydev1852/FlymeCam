package com.meizu.media.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import com.meizu.flyme.sdk.ContextBuilder;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.views.OverlayRenderer;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.p */
public class MzOrientationHintRenderer extends OverlayRenderer {

    /* renamed from: a */
    public static ChangeQuickRedirect f11386a;

    /* renamed from: A */
    private Paint f11387A;

    /* renamed from: B */
    private Paint f11388B;

    /* renamed from: b */
    private Context f11389b;

    /* renamed from: c */
    private Point f11390c;

    /* renamed from: d */
    private Point f11391d;

    /* renamed from: e */
    private Point f11392e;

    /* renamed from: f */
    private Point f11393f;

    /* renamed from: g */
    private Point f11394g;

    /* renamed from: h */
    private int f11395h;

    /* renamed from: i */
    private int f11396i;

    /* renamed from: j */
    private int f11397j;

    /* renamed from: k */
    private int f11398k;

    /* renamed from: l */
    private int f11399l;

    /* renamed from: m */
    private String f11400m;

    /* renamed from: n */
    private boolean f11401n = true;

    /* renamed from: o */
    private int f11402o;

    /* renamed from: p */
    private int f11403p;

    /* renamed from: q */
    private int f11404q;

    /* renamed from: r */
    private int f11405r;

    /* renamed from: s */
    private Paint f11406s;

    public MzOrientationHintRenderer(Context context) {
        this.f11389b = ContextBuilder.m6349a(context, true, true);
        this.f11398k = this.f11389b.getResources().getDimensionPixelOffset(R.dimen.mz_orientation_dir_length);
        this.f11406s = new Paint();
        this.f11406s.setStyle(Paint.Style.STROKE);
        this.f11406s.setStrokeWidth(4.0f);
        this.f11406s.setColor(872415231);
        this.f11387A = new Paint(this.f11406s);
        this.f11387A.setColor(context.getResources().getColor(R.color.doc_scanner_view_line_color));
        this.f11388B = new Paint(1);
        this.f11388B.setColor(-1);
        this.f11388B.setTextSize((float) this.f11389b.getResources().getDimensionPixelOffset(R.dimen.mz_font_size_14sp));
        this.f11388B.setShadowLayer(3.0f, 0.0f, 2.0f, this.f11389b.getResources().getColor(R.color.mz_screen_hint_shadow_color));
        this.f11388B.setTextAlign(Paint.Align.CENTER);
        this.f11395h = (int) (-this.f11388B.getFontMetrics().ascent);
        this.f11399l = this.f11395h + this.f11389b.getResources().getDimensionPixelSize(R.dimen.mz_orientation_hint_text_margin);
        this.f11400m = this.f11389b.getResources().getString(R.string.mz_orientation_hint);
    }

    /* renamed from: a */
    public void mo20787a(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f11386a, false, 1695, new Class[]{Canvas.class}, Void.TYPE).isSupported && this.f15557z) {
            canvas.drawLine((float) this.f11391d.x, (float) this.f11391d.y, (float) this.f11391d.x, (float) (this.f11391d.y + this.f11397j), this.f11406s);
            Canvas canvas2 = canvas;
            canvas2.drawLine((float) this.f11390c.x, (float) this.f11390c.y, (float) (this.f11390c.x + this.f11396i), (float) this.f11390c.y, this.f11406s);
            canvas2.drawLine((float) this.f11392e.x, (float) this.f11392e.y, (float) this.f11393f.x, (float) this.f11393f.y, this.f11387A);
            canvas.save();
            if (this.f11405r == 270) {
                int i = this.f11394g.x;
                int i2 = this.f11394g.y;
                canvas.translate((float) ((this.f11402o - this.f11399l) - i), (float) (this.f11404q - i2));
                canvas.rotate((float) (360 - this.f11405r), (float) i, (float) i2);
            } else if (this.f11405r == 90) {
                int i3 = this.f11394g.x;
                int i4 = this.f11394g.y;
                canvas.translate((float) (this.f11399l - i3), (float) (this.f11404q - i4));
                canvas.rotate((float) (360 - this.f11405r), (float) i3, (float) i4);
            }
            if (this.f11401n) {
                canvas.drawText(this.f11400m, (float) this.f11394g.x, (float) this.f11394g.y, this.f11388B);
            }
            canvas.restore();
        }
    }

    /* renamed from: a */
    public void mo20788a(RectF rectF) {
        if (!PatchProxy.proxy(new Object[]{rectF}, this, f11386a, false, 1696, new Class[]{RectF.class}, Void.TYPE).isSupported) {
            if (((float) this.f11402o) != rectF.width() || ((float) this.f11403p) != rectF.height()) {
                this.f11402o = (int) rectF.width();
                this.f11403p = (int) rectF.height();
                this.f11404q = (int) rectF.centerY();
                this.f11390c = new Point((this.f11402o - (this.f11398k * 2)) / 2, ((int) rectF.top) + (this.f11403p / 2));
                this.f11391d = new Point(this.f11402o / 2, ((int) rectF.top) + ((this.f11403p - (this.f11398k * 2)) / 2));
                int i = this.f11398k * 2;
                this.f11396i = i;
                this.f11397j = i;
                this.f11392e = new Point(this.f11391d.x, this.f11390c.y);
                this.f11393f = new Point(this.f11392e.x, this.f11392e.y - this.f11398k);
                this.f11405r = 0;
                m12392a();
            }
        }
    }

    /* renamed from: a */
    public void mo20786a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f11386a, false, 1697, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && this.f11405r != i) {
            this.f11405r = i;
            if (i == 0) {
                this.f11393f.x = this.f11392e.x;
                this.f11393f.y = this.f11392e.y - this.f11398k;
                m12392a();
            } else if (i == 90) {
                this.f11393f.x = this.f11392e.x - this.f11398k;
                this.f11393f.y = this.f11392e.y;
                m12392a();
            } else if (i == 180) {
                this.f11393f.x = this.f11392e.x;
                this.f11393f.y = this.f11392e.y + this.f11398k;
                this.f11394g.x = this.f11402o / 2;
                this.f11394g.y = (CameraUtil.m15865b() - CameraUtil.m15897f()) - (this.f11389b.getResources().getDimensionPixelSize(R.dimen.mz_orientation_hint_text_margin) * 5);
            } else if (i != 270) {
                mo23403f(false);
            } else {
                this.f11393f.x = this.f11392e.x + this.f11398k;
                this.f11393f.y = this.f11392e.y;
                m12392a();
            }
        }
    }

    /* renamed from: a */
    public void mo20789a(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f11386a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 1698, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f11401n = z;
            mo23407o();
        }
    }

    /* renamed from: a */
    private void m12392a() {
        if (!PatchProxy.proxy(new Object[0], this, f11386a, false, 1699, new Class[0], Void.TYPE).isSupported) {
            if (this.f11394g == null) {
                this.f11394g = new Point();
            }
            this.f11394g.x = this.f11402o / 2;
            this.f11394g.y = CameraUtil.m15901h() + this.f11399l;
        }
    }
}
