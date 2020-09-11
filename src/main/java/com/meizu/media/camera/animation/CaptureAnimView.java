package com.meizu.media.camera.animation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.p020ar.base.MsgField;
import com.meizu.media.camera.R;
import com.meizu.media.camera.animation.RefocusAnim;
import com.meizu.media.camera.animation.ShutterAnim;
import com.meizu.media.camera.animation.ThumbnailAnim;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.NavigationBarUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class CaptureAnimView extends View implements IUpdateCallback, RefocusAnim.C1803a, ShutterAnim.C1809a, ThumbnailAnim.C1820a {

    /* renamed from: a */
    public static ChangeQuickRedirect f7584a;

    /* renamed from: b */
    public static final float f7585b = ((float) (CameraUtil.m15809a() / 2));

    /* renamed from: c */
    public static float f7586c = 0.0f;

    /* renamed from: d */
    public static float f7587d;

    /* renamed from: e */
    public static float f7588e;

    /* renamed from: f */
    protected static float f7589f;

    /* renamed from: g */
    private ShutterAnim f7590g;

    /* renamed from: h */
    private LevelAnim f7591h;

    /* renamed from: i */
    private RefocusAnim f7592i;

    /* renamed from: j */
    private TimeLoadingAnim f7593j;

    /* renamed from: k */
    private FunnyRecordAnim f7594k;

    /* renamed from: l */
    private ThumbnailAnim f7595l;

    /* renamed from: m */
    private GifAnim f7596m;

    /* renamed from: n */
    private long f7597n = 0;

    /* renamed from: o */
    private C1796a f7598o;

    /* renamed from: com.meizu.media.camera.animation.CaptureAnimView$a */
    public interface C1796a {
        /* renamed from: a */
        void mo18849a();

        /* renamed from: a */
        void mo18850a(boolean z, boolean z2);

        /* renamed from: b */
        void mo18851b();

        /* renamed from: c */
        void mo18852c();

        /* renamed from: d */
        void mo18853d();
    }

    public CaptureAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = context.getResources();
        this.f7590g = new ShutterAnim(resources, this, this);
        this.f7591h = new LevelAnim(resources, this);
        this.f7592i = new RefocusAnim(resources, this, this);
        this.f7593j = new TimeLoadingAnim(resources, this);
        this.f7594k = new FunnyRecordAnim(resources, this);
        this.f7595l = new ThumbnailAnim(this, this);
        this.f7596m = new GifAnim(resources, this);
        m8030a(resources, NavigationBarUtils.m15973a(context.getResources()));
        f7587d = resources.getDimension(R.dimen.mz_shutter_radius);
        f7588e = resources.getDimension(R.dimen.mz_shutter_background_radius);
        f7589f = resources.getDimension(R.dimen.mz_shutter_radius_appear);
        this.f7591h.mo18889a(resources);
        this.f7592i.mo18893a(resources);
        this.f7594k.mo18877a(resources);
        this.f7593j.mo18979a(resources);
    }

    /* renamed from: a */
    public boolean mo18817a() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7584a, false, 2298, new Class[0], Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : this.f7590g.mo18920a();
    }

    /* renamed from: a */
    public void mo18813a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f7584a, false, MsgField.MSG_NO_NETWORK_FOR_START_QUERY_RES, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f7593j.mo18978a(i, false);
        }
    }

    /* renamed from: a */
    public void mo18815a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f7584a, false, 2300, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f7593j.mo18980a(z);
            this.f7590g.mo18919a(false, false);
        }
    }

    /* renamed from: b */
    public void mo18819b(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7584a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2301, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f7590g.mo18919a(z, true);
        }
    }

    public void setListener(C1796a aVar) {
        this.f7598o = aVar;
    }

    /* renamed from: a */
    public void mo18812a(float f) {
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f7584a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, MsgField.MSG_ON_DOWNLOAD_SO, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f7595l.mo18961a(f, f7586c);
        }
    }

    /* renamed from: a */
    public void mo18814a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f7584a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, MsgField.MSG_ON_DOWNLOAD_SO_ERROR, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f7591h.mo18888a(i, i2);
            this.f7595l.mo18962a(i2);
        }
    }

    /* renamed from: b */
    public void mo18818b() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, MsgField.MSG_ON_DOWNLOAD_RES_SUCCESS, new Class[0], Void.TYPE).isSupported) {
            this.f7590g.mo18921b();
            if (CameraModeType.m10983m(CameraModeType.ModeType.MANUAL) && this.f7597n > 1000) {
                postDelayed(new Runnable() {
                    public final void run() {
                        CaptureAnimView.this.m8031x();
                    }
                }, 160);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void m8031x() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2335, new Class[0], Void.TYPE).isSupported) {
            this.f7593j.mo18977a(((int) this.f7597n) - 160);
            this.f7597n = 0;
        }
    }

    /* renamed from: c */
    public void mo18820c() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, MsgField.MSG_ON_DOWNLOAD_RES_ERROR, new Class[0], Void.TYPE).isSupported) {
            this.f7590g.mo18922c();
        }
    }

    /* renamed from: d */
    public void mo18822d() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2306, new Class[0], Void.TYPE).isSupported) {
            this.f7590g.mo18923d();
        }
    }

    /* renamed from: e */
    public void mo18824e() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2307, new Class[0], Void.TYPE).isSupported) {
            this.f7590g.mo18924e();
        }
    }

    /* renamed from: f */
    public void mo18826f() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2309, new Class[0], Void.TYPE).isSupported) {
            this.f7592i.mo18892a();
        }
    }

    /* renamed from: g */
    public void mo18828g() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2310, new Class[0], Void.TYPE).isSupported) {
            this.f7593j.mo18976a();
        }
    }

    /* renamed from: h */
    public void mo18830h() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2311, new Class[0], Void.TYPE).isSupported) {
            this.f7593j.mo18982b();
        }
    }

    /* renamed from: i */
    public void mo18831i() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2312, new Class[0], Void.TYPE).isSupported) {
            this.f7594k.mo18876a();
        }
    }

    /* renamed from: j */
    public void mo18832j() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2313, new Class[0], Void.TYPE).isSupported) {
            this.f7594k.mo18878a(true);
        }
    }

    /* renamed from: c */
    public void mo18821c(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7584a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2314, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f7592i.mo18894a(z);
        }
    }

    /* renamed from: k */
    public void mo18833k() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2315, new Class[0], Void.TYPE).isSupported) {
            this.f7592i.mo18896b();
        }
    }

    /* renamed from: d */
    public void mo18823d(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7584a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2316, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f7596m.mo18882a(z);
        }
    }

    /* renamed from: l */
    public void mo18834l() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2317, new Class[0], Void.TYPE).isSupported) {
            this.f7596m.mo18881a();
        }
    }

    /* renamed from: m */
    public void mo18835m() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2318, new Class[0], Void.TYPE).isSupported) {
            this.f7596m.mo18887e();
        }
    }

    /* renamed from: n */
    public void mo18836n() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2319, new Class[0], Void.TYPE).isSupported) {
            this.f7596m.mo18886d();
        }
    }

    /* renamed from: o */
    public void mo18837o() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2320, new Class[0], Void.TYPE).isSupported) {
            this.f7596m.mo18884b();
        }
    }

    /* renamed from: p */
    public void mo18839p() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2321, new Class[0], Void.TYPE).isSupported) {
            this.f7596m.mo18885c();
        }
    }

    /* renamed from: e */
    public void mo18825e(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7584a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2322, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f7591h.mo18891a(z);
        }
    }

    public void setCaptureTime(long j, boolean z) {
        Object[] objArr = {new Long(j), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7584a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2323, new Class[]{Long.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f7597n = j;
            this.f7590g.mo18917a(j, z);
        }
    }

    /* renamed from: q */
    public void mo18840q() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2324, new Class[0], Void.TYPE).isSupported) {
            this.f7590g.mo18925f();
        }
    }

    public void onDraw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f7584a, false, 2325, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            if (this.f7595l != null) {
                this.f7595l.mo18963a(canvas);
            }
            if (!this.f7592i.mo18895a(canvas) && !this.f7594k.mo18879a(canvas) && !this.f7596m.mo18883a(canvas)) {
                this.f7590g.mo18918a(canvas);
                if (!this.f7593j.mo18981a(canvas)) {
                    this.f7591h.mo18890a(canvas);
                }
            }
        }
    }

    /* renamed from: r */
    public void mo18841r() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2326, new Class[0], Void.TYPE).isSupported) {
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo18816a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7584a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2327, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f7598o.mo18850a(z, z2);
        }
    }

    /* renamed from: s */
    public void mo18842s() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2328, new Class[0], Void.TYPE).isSupported) {
            this.f7598o.mo18849a();
        }
    }

    /* renamed from: t */
    public void mo18845t() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2329, new Class[0], Void.TYPE).isSupported) {
            this.f7598o.mo18851b();
        }
    }

    /* renamed from: u */
    public void mo18846u() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2330, new Class[0], Void.TYPE).isSupported) {
            this.f7598o.mo18852c();
        }
    }

    /* renamed from: v */
    public void mo18847v() {
        if (!PatchProxy.proxy(new Object[0], this, f7584a, false, 2331, new Class[0], Void.TYPE).isSupported) {
            this.f7598o.mo18853d();
        }
    }

    /* renamed from: f */
    public void mo18827f(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f7584a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2332, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            m8030a(getResources(), z);
            this.f7591h.mo18889a(getResources());
            this.f7592i.mo18893a(getResources());
            this.f7594k.mo18877a(getResources());
            this.f7593j.mo18979a(getResources());
            this.f7595l.mo18960a(f7586c);
        }
    }

    /* renamed from: a */
    private void m8030a(Resources resources, boolean z) {
        if (!PatchProxy.proxy(new Object[]{resources, new Byte(z ? (byte) 1 : 0)}, this, f7584a, false, 2333, new Class[]{Resources.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            float dimension = resources.getDimension(DeviceHelper.f13874aa ? R.dimen.mz_control_bar_margin_bottom_18_9 : R.dimen.mz_control_bar_margin_bottom);
            if (!z && DeviceHelper.f13874aa) {
                dimension -= (float) resources.getDimensionPixelSize(R.dimen.mz_control_bar_margin_bottom_18_9_offset_navbar_not_show);
            }
            f7586c = (((float) CameraUtil.m15865b()) - (resources.getDimension(R.dimen.mz_control_bar_height) / 2.0f)) - dimension;
            if (z && !DeviceHelper.f13874aa) {
                f7586c -= (float) CameraUtil.m15912r();
            }
        }
    }

    /* renamed from: w */
    public boolean mo18848w() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f7584a, false, 2334, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if ((this.f7593j == null || !this.f7593j.mo18983c()) && (this.f7592i == null || !this.f7592i.mo18897c())) {
            return false;
        }
        return true;
    }

    public long getCaptureTime() {
        return this.f7597n;
    }
}
