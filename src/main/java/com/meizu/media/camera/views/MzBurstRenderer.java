package com.meizu.media.camera.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.content.ContextCompat;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.views.f */
public class MzBurstRenderer extends OverlayRenderer {

    /* renamed from: a */
    public static ChangeQuickRedirect f15274a;

    /* renamed from: A */
    private String f15275A;

    /* renamed from: B */
    private float f15276B;

    /* renamed from: b */
    private boolean f15277b = false;

    /* renamed from: c */
    private int f15278c;

    /* renamed from: d */
    private int f15279d = 0;

    /* renamed from: e */
    private int f15280e = 0;

    /* renamed from: f */
    private int f15281f;

    /* renamed from: g */
    private Paint f15282g = new Paint();

    /* renamed from: h */
    private Paint f15283h = new Paint();

    /* renamed from: i */
    private Paint f15284i = new Paint();

    /* renamed from: j */
    private int f15285j;

    /* renamed from: k */
    private int f15286k;

    /* renamed from: l */
    private int f15287l;

    /* renamed from: m */
    private float f15288m;

    /* renamed from: n */
    private int f15289n;

    /* renamed from: o */
    private int f15290o;

    /* renamed from: p */
    private int f15291p;

    /* renamed from: q */
    private int f15292q;

    /* renamed from: r */
    private float f15293r;

    /* renamed from: s */
    private boolean f15294s = false;

    public MzBurstRenderer(Context context) {
        m16717a(context);
        m16718b(context);
    }

    /* renamed from: a */
    private void m16717a(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f15274a, false, 8512, new Class[]{Context.class}, Void.TYPE).isSupported) {
            this.f15282g.setColor(-1);
            this.f15293r = context.getResources().getDimension(R.dimen.mz_font_size_10sp);
            this.f15282g.setTextSize(this.f15293r);
            this.f15282g.setTextAlign(Paint.Align.LEFT);
            this.f15282g.setAntiAlias(true);
            this.f15285j = (int) ((-this.f15282g.ascent()) - this.f15282g.descent());
            this.f15275A = context.getResources().getString(R.string.mz_burst_process);
            this.f15283h.setStyle(Paint.Style.STROKE);
            this.f15283h.setStrokeWidth((float) context.getResources().getDimensionPixelOffset(R.dimen.mz_burst_circle_stroke));
            this.f15283h.setColor(-1);
            this.f15283h.setAntiAlias(true);
            this.f15284i.setColor(ContextCompat.getColor(context, R.color.mz_zoom_indicator_bg));
            this.f15284i.setAntiAlias(true);
        }
    }

    /* renamed from: b */
    private void m16718b(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f15274a, false, 8513, new Class[]{Context.class}, Void.TYPE).isSupported) {
            Resources resources = context.getResources();
            this.f15286k = CameraUtil.m15809a();
            this.f15287l = CameraUtil.m15881c();
            this.f15289n = context.getResources().getDimensionPixelOffset(R.dimen.mz_burst_circle_radius);
            this.f15290o = this.f15289n - context.getResources().getDimensionPixelOffset(R.dimen.mz_burst_circle_stroke);
            if (resources.getConfiguration().orientation == 2) {
                this.f15277b = true;
            } else {
                this.f15277b = false;
            }
            this.f15291p = context.getResources().getDimensionPixelOffset(R.dimen.mz_burst_circle_margin_bottom);
            this.f15276B = (((float) this.f15286k) - this.f15282g.measureText(this.f15275A)) / 2.0f;
            this.f15292q = context.getResources().getDimensionPixelOffset(R.dimen.mz_filter_height);
        }
    }

    /* renamed from: a */
    public void mo23321a(int i) {
        this.f15279d = i;
        if (i == 1) {
            this.f15280e = 0;
        }
    }

    /* renamed from: b */
    public void mo23324b(int i) {
        this.f15281f = i;
    }

    /* renamed from: a */
    public void mo23322a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f15274a, false, 8514, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                this.f15288m = (float) ((CameraUtil.m15865b() - ((this.f15289n + this.f15291p) + CameraUtil.m15897f())) - (NavigationBarUtils.m15972a() ? this.f15292q : CameraUtil.m15901h()));
            } else {
                this.f15288m = (float) (CameraUtil.m15865b() - ((this.f15289n + this.f15291p) + CameraUtil.m15897f()));
            }
        }
    }

    /* renamed from: a */
    public void mo23320a() {
        if (!PatchProxy.proxy(new Object[0], this, f15274a, false, 8515, new Class[0], Void.TYPE).isSupported) {
            this.f15294s = false;
            mo23403f(false);
        }
    }

    /* renamed from: b */
    public void mo23323b() {
        if (!PatchProxy.proxy(new Object[0], this, f15274a, false, 8517, new Class[0], Void.TYPE).isSupported) {
            mo23407o();
        }
    }

    /* renamed from: a */
    public void mo20787a(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f15274a, false, 8518, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            if (this.f15280e < this.f15279d) {
                this.f15280e++;
            }
            int measureText = (int) this.f15282g.measureText(String.valueOf(this.f15280e));
            if (this.f15277b) {
                if (this.f15278c == 180) {
                    canvas.rotate(180.0f, (float) (this.f15287l / 2), (float) (this.f15286k / 2));
                } else if (this.f15278c == 90 || this.f15278c == 270) {
                    int i = this.f15287l / 2;
                    int i2 = (this.f15285j / 2) + 80;
                    canvas.translate((float) (((this.f15285j / 2) + 80) - i), (float) ((this.f15286k / 2) - i2));
                    canvas.rotate(270.0f, (float) i, (float) i2);
                }
                canvas.drawCircle(((float) CameraUtil.m15865b()) / 2.0f, 80.0f, (float) this.f15289n, this.f15283h);
                canvas.drawText(String.valueOf(this.f15280e), (float) ((this.f15287l - measureText) / 2), 80.0f, this.f15282g);
            } else {
                if (this.f15278c == 270) {
                    int i3 = this.f15286k / 2;
                    int i4 = (this.f15285j / 2) + 80;
                    canvas.translate((float) ((this.f15286k - ((this.f15285j / 2) + 80)) - i3), (float) ((this.f15287l / 2) - i4));
                    canvas.rotate((float) (360 - this.f15278c), (float) i3, (float) i4);
                } else if (this.f15278c == 90) {
                    int i5 = this.f15286k / 2;
                    int i6 = (this.f15285j / 2) + 80;
                    canvas.translate((float) (((this.f15285j / 2) + 80) - i5), (float) ((this.f15287l / 2) - i6));
                    canvas.rotate((float) (360 - this.f15278c), (float) i5, (float) i6);
                }
                canvas.drawCircle(((float) CameraUtil.m15809a()) / 2.0f, this.f15288m, (float) this.f15289n, this.f15283h);
                canvas.drawCircle(((float) CameraUtil.m15809a()) / 2.0f, this.f15288m, (float) this.f15290o, this.f15284i);
                canvas.drawText(String.valueOf(this.f15280e), ((float) (this.f15286k - measureText)) / 2.0f, this.f15288m + ((float) (this.f15285j / 2)), this.f15282g);
            }
            if (this.f15280e < this.f15279d) {
                mo23407o();
            }
        }
    }
}
