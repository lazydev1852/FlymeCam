package com.meizu.media.camera.animation;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.animation.d */
public class GifAnim {

    /* renamed from: a */
    public static ChangeQuickRedirect f7653a;

    /* renamed from: b */
    private boolean f7654b = false;

    /* renamed from: c */
    private boolean f7655c = false;

    /* renamed from: d */
    private boolean f7656d = false;

    /* renamed from: e */
    private Paint f7657e;

    /* renamed from: f */
    private Paint f7658f;

    /* renamed from: g */
    private float f7659g;

    /* renamed from: h */
    private float f7660h;

    /* renamed from: i */
    private float f7661i;

    /* renamed from: j */
    private float f7662j;

    /* renamed from: k */
    private float f7663k;

    /* renamed from: l */
    private float f7664l;

    /* renamed from: m */
    private String f7665m;

    /* renamed from: n */
    private long f7666n = -1;

    /* renamed from: o */
    private long f7667o = 0;

    /* renamed from: p */
    private IUpdateCallback f7668p;

    /* renamed from: q */
    private boolean f7669q = false;

    /* renamed from: r */
    private long f7670r;

    public GifAnim(Resources resources, IUpdateCallback eVar) {
        this.f7668p = eVar;
        m8105a(resources);
    }

    /* renamed from: a */
    private void m8105a(Resources resources) {
        if (!PatchProxy.proxy(new Object[]{resources}, this, f7653a, false, 2358, new Class[]{Resources.class}, Void.TYPE).isSupported) {
            this.f7657e = new Paint();
            this.f7657e.setColor(-1);
            this.f7657e.setTextSize(resources.getDimension(R.dimen.mz_font_size_16sp));
            this.f7657e.setTextAlign(Paint.Align.CENTER);
            this.f7657e.setAntiAlias(true);
            this.f7658f = new Paint(this.f7657e);
            this.f7658f.setTextSize(resources.getDimension(R.dimen.mz_font_size_27sp));
            this.f7665m = resources.getString(R.string.mz_gif_hint_handling);
            this.f7662j = (-this.f7658f.ascent()) - this.f7658f.descent();
            this.f7663k = (float) (CameraUtil.m15809a() / 2);
            this.f7664l = ((float) (CameraUtil.m15901h() + CameraUtil.m15809a())) + resources.getDimension(R.dimen.mz_gif_time_margin_top);
            this.f7659g = (-this.f7657e.ascent()) - this.f7657e.descent();
            this.f7660h = (float) (CameraUtil.m15809a() / 2);
            this.f7661i = this.f7664l + this.f7662j + resources.getDimension(R.dimen.mz_gif_hint_margin_top);
        }
    }

    /* renamed from: a */
    public void mo18882a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f7653a, false, 2359, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                this.f7654b = true;
                if (!this.f7669q) {
                    this.f7667o = 6000;
                }
            } else {
                this.f7654b = false;
            }
            this.f7668p.mo18841r();
        }
    }

    /* renamed from: a */
    public void mo18881a() {
        if (!PatchProxy.proxy(new Object[0], this, f7653a, false, 2360, new Class[0], Void.TYPE).isSupported) {
            this.f7655c = true;
            this.f7668p.mo18841r();
        }
    }

    /* renamed from: b */
    public void mo18884b() {
        if (!PatchProxy.proxy(new Object[0], this, f7653a, false, 2361, new Class[0], Void.TYPE).isSupported) {
            this.f7669q = true;
            this.f7670r = System.currentTimeMillis();
            this.f7668p.mo18841r();
        }
    }

    /* renamed from: c */
    public void mo18885c() {
        if (!PatchProxy.proxy(new Object[0], this, f7653a, false, 2362, new Class[0], Void.TYPE).isSupported) {
            this.f7669q = false;
            this.f7666n += System.currentTimeMillis() - this.f7670r;
            this.f7668p.mo18841r();
        }
    }

    /* renamed from: d */
    public void mo18886d() {
        if (!PatchProxy.proxy(new Object[0], this, f7653a, false, 2363, new Class[0], Void.TYPE).isSupported) {
            this.f7669q = false;
            this.f7655c = false;
            this.f7656d = false;
            this.f7666n = -1;
            this.f7667o = 6000;
            this.f7668p.mo18841r();
        }
    }

    /* renamed from: e */
    public void mo18887e() {
        this.f7656d = true;
    }

    /* renamed from: a */
    public boolean mo18883a(Canvas canvas) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{canvas}, this, f7653a, false, 2364, new Class[]{Canvas.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!this.f7654b) {
            return false;
        }
        if (this.f7655c && !this.f7669q) {
            m8104a(System.currentTimeMillis());
        }
        m8106b(canvas);
        m8107c(canvas);
        return true;
    }

    /* renamed from: b */
    private void m8106b(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f7653a, false, 2365, new Class[]{Canvas.class}, Void.TYPE).isSupported && this.f7656d) {
            canvas.drawText(this.f7665m, this.f7660h, this.f7661i + this.f7659g, this.f7657e);
        }
    }

    /* renamed from: c */
    private void m8107c(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f7653a, false, 2366, new Class[]{Canvas.class}, Void.TYPE).isSupported && !this.f7656d) {
            canvas.drawText(C1825q.m8253a(this.f7667o), this.f7663k, this.f7664l + this.f7662j, this.f7658f);
        }
    }

    /* renamed from: a */
    private void m8104a(long j) {
        Object[] objArr = {new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f7653a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2367, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f7666n == -1) {
                this.f7666n = j;
                this.f7667o = 6000;
            }
            this.f7667o = 6000 - (j - this.f7666n);
            if (((float) this.f7667o) < 0.0f) {
                this.f7667o = 0;
                this.f7656d = true;
            }
            this.f7668p.mo18841r();
        }
    }
}
