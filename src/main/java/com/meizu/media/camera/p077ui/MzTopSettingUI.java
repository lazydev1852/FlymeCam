package com.meizu.media.camera.p077ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.ActivityBase;
import com.meizu.media.camera.R;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.databinding.CameraBinding;
import com.meizu.media.camera.databinding.CameraSimplifyBinding;
import com.meizu.media.camera.databinding.DelayInflateTwoBinding;
import com.meizu.media.camera.databinding.MzTopSettingControlBinding;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.views.TopSettingView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.meizu.media.camera.ui.ab */
public class MzTopSettingUI extends SettingController implements TopSettingView.C2732a {

    /* renamed from: a */
    public static ChangeQuickRedirect f12656a;

    /* renamed from: w */
    private static final LogUtil.C2630a f12657w = new LogUtil.C2630a("MzTopSettingUI");

    /* renamed from: d */
    private ActivityBase f12658d;

    /* renamed from: e */
    private ViewDataBinding f12659e;

    /* renamed from: f */
    private DelayInflateTwoBinding f12660f;

    /* renamed from: g */
    private MzTopSettingControlBinding f12661g;

    /* renamed from: h */
    private TopSettingView f12662h;

    /* renamed from: i */
    private C2430b f12663i;

    /* renamed from: j */
    private boolean f12664j = false;

    /* renamed from: k */
    private int f12665k = 0;

    /* renamed from: l */
    private List<C2429a> f12666l = new ArrayList();

    /* renamed from: m */
    private List<C2429a> f12667m = new ArrayList();

    /* renamed from: n */
    private List<C2429a> f12668n = new ArrayList();

    /* renamed from: o */
    private List<C2429a> f12669o = new ArrayList();

    /* renamed from: p */
    private List<C2429a> f12670p = new ArrayList();

    /* renamed from: q */
    private List<C2429a> f12671q = new ArrayList();

    /* renamed from: r */
    private List<C2429a> f12672r = new ArrayList();

    /* renamed from: s */
    private List<C2429a> f12673s = new ArrayList();

    /* renamed from: t */
    private List<C2429a> f12674t = new ArrayList();

    /* renamed from: u */
    private boolean f12675u = true;

    /* renamed from: v */
    private boolean f12676v = false;

    /* renamed from: x */
    private Animation f12677x;

    /* renamed from: y */
    private Animation f12678y;

    /* renamed from: com.meizu.media.camera.ui.ab$b */
    /* compiled from: MzTopSettingUI */
    public interface C2430b {
        /* renamed from: a */
        void mo21764a(int i, int i2, int i3);
    }

    public MzTopSettingUI(ActivityBase activityBase, ViewDataBinding viewDataBinding) {
        super(activityBase, R.xml.mz_setting_choose_preferences);
        this.f12658d = activityBase;
        this.f12659e = viewDataBinding;
        m14288m();
        m14290o();
        m14291p();
        m14292q();
        m14293r();
        m14289n();
        this.f12677x = AnimationUtils.loadAnimation(activityBase.getApplicationContext(), R.anim.mz_smart_bar_button_hide);
        this.f12678y = AnimationUtils.loadAnimation(activityBase.getApplicationContext(), R.anim.mz_smart_bar_button_show);
    }

    /* renamed from: a */
    public void mo21796a() {
        if (!PatchProxy.proxy(new Object[0], this, f12656a, false, 7614, new Class[0], Void.TYPE).isSupported && !this.f12664j) {
            if (this.f12659e instanceof CameraBinding) {
                this.f12660f = (DelayInflateTwoBinding) ((CameraBinding) this.f12659e).f9509h.getBinding();
            } else if (this.f12659e instanceof CameraSimplifyBinding) {
                this.f12660f = (DelayInflateTwoBinding) ((CameraSimplifyBinding) this.f12659e).f9533f.getBinding();
            }
            if (this.f12660f != null) {
                if (this.f12660f.f9591v.getViewStub() != null) {
                    this.f12661g = (MzTopSettingControlBinding) DataBindingUtil.bind(this.f12660f.f9591v.getViewStub().inflate());
                } else {
                    this.f12661g = (MzTopSettingControlBinding) this.f12660f.f9591v.getBinding();
                }
                this.f12662h = this.f12661g.f9842g;
                if (DeviceHelper.f13874aa) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f12661g.getRoot().getLayoutParams();
                    layoutParams.height = CameraUtil.m15901h();
                    this.f12661g.getRoot().setLayoutParams(layoutParams);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f12662h.getLayoutParams();
                    layoutParams2.height = CameraUtil.m15901h();
                    this.f12662h.setLayoutParams(layoutParams2);
                }
                this.f12662h.setHapticFeedbackEnabled(false);
                this.f12662h.setOnItemChooseListener(this);
                this.f12662h.setSoundEffectsEnabled(this.f12675u);
                this.f12664j = true;
            }
        }
    }

    /* renamed from: a */
    public void mo21800a(boolean z) {
        this.f12676v = z;
    }

    /* renamed from: m */
    private void m14288m() {
        if (!PatchProxy.proxy(new Object[0], this, f12656a, false, 7615, new Class[0], Void.TYPE).isSupported) {
            CharSequence[] e = mo21884e("pref_camera_flashmode_key");
            int[] f = mo21885f("pref_camera_flashmode_key");
            int[] g = mo21886g("pref_camera_flashmode_key");
            for (int i = 0; i < e.length; i++) {
                C2429a aVar = new C2429a();
                aVar.f12679a = "pref_camera_flashmode_key";
                aVar.f12680b = f[i];
                aVar.f12681c = g[i];
                aVar.f12683e = e[i].toString();
                this.f12666l.add(aVar);
            }
        }
    }

    /* renamed from: n */
    private void m14289n() {
        if (!PatchProxy.proxy(new Object[0], this, f12656a, false, 7616, new Class[0], Void.TYPE).isSupported) {
            CharSequence[] e = mo21884e("pref_camera_timelapse_key");
            int[] f = mo21885f("pref_camera_timelapse_key");
            int[] g = mo21886g("pref_camera_timelapse_key");
            for (int i = 0; i < e.length; i++) {
                C2429a aVar = new C2429a();
                aVar.f12679a = "pref_camera_timelapse_key";
                aVar.f12680b = f[i];
                aVar.f12681c = g[i];
                aVar.f12683e = e[i].toString();
                this.f12667m.add(aVar);
            }
        }
    }

    /* renamed from: o */
    private void m14290o() {
        if (!PatchProxy.proxy(new Object[0], this, f12656a, false, 7617, new Class[0], Void.TYPE).isSupported) {
            CharSequence[] e = mo21884e("pref_video_flashmode_key");
            int[] f = mo21885f("pref_video_flashmode_key");
            int[] g = mo21886g("pref_video_flashmode_key");
            for (int i = 0; i < e.length; i++) {
                C2429a aVar = new C2429a();
                aVar.f12679a = "pref_video_flashmode_key";
                aVar.f12680b = f[i];
                aVar.f12681c = g[i];
                aVar.f12683e = e[i].toString();
                this.f12668n.add(aVar);
            }
        }
    }

    /* renamed from: p */
    private void m14291p() {
        if (!PatchProxy.proxy(new Object[0], this, f12656a, false, 7618, new Class[0], Void.TYPE).isSupported) {
            CharSequence[] e = mo21884e("pref_camera_timer_key");
            int[] f = mo21885f("pref_camera_timer_key");
            int[] g = mo21886g("pref_camera_timer_key");
            int[] h = mo21887h("pref_camera_timer_key");
            for (int i = 0; i < e.length; i++) {
                C2429a aVar = new C2429a();
                aVar.f12679a = "pref_camera_timer_key";
                aVar.f12680b = f[i];
                aVar.f12681c = g[i];
                aVar.f12683e = e[i].toString();
                if (h != null) {
                    aVar.f12682d = h[i];
                }
                this.f12670p.add(aVar);
            }
        }
    }

    /* renamed from: q */
    private void m14292q() {
        if (!PatchProxy.proxy(new Object[0], this, f12656a, false, 7619, new Class[0], Void.TYPE).isSupported) {
            CharSequence[] e = mo21884e("mz_pref_hdr_key");
            int[] f = mo21885f("mz_pref_hdr_key");
            int[] g = mo21886g("mz_pref_hdr_key");
            int[] h = mo21887h("mz_pref_hdr_key");
            for (int i = 0; i < e.length; i++) {
                C2429a aVar = new C2429a();
                aVar.f12679a = "mz_pref_hdr_key";
                aVar.f12680b = f[i];
                aVar.f12681c = g[i];
                aVar.f12683e = e[i].toString();
                if (h != null) {
                    aVar.f12682d = h[i];
                }
                this.f12671q.add(aVar);
            }
        }
    }

    /* renamed from: r */
    private void m14293r() {
        if (!PatchProxy.proxy(new Object[0], this, f12656a, false, 7620, new Class[0], Void.TYPE).isSupported) {
            CharSequence[] e = mo21884e("mz_pref_fb_key");
            int[] f = mo21885f("mz_pref_fb_key");
            int[] g = mo21886g("mz_pref_fb_key");
            int[] h = mo21887h("mz_pref_fb_key");
            for (int i = 0; i < e.length; i++) {
                C2429a aVar = new C2429a();
                aVar.f12683e = e[i].toString();
                aVar.f12679a = "mz_pref_fb_key";
                aVar.f12680b = f[i];
                aVar.f12681c = g[i];
                if (h != null) {
                    aVar.f12682d = h[i];
                }
                this.f12673s.add(aVar);
            }
        }
    }

    /* renamed from: b */
    public void mo21803b() {
        if (!PatchProxy.proxy(new Object[0], this, f12656a, false, 7621, new Class[0], Void.TYPE).isSupported) {
            this.f12674t.clear();
            if (2 == this.f12665k) {
                this.f12674t.addAll(this.f12670p);
            } else if (1 == this.f12665k) {
                this.f12674t.addAll(this.f12668n);
            } else if (6 == this.f12665k) {
                this.f12674t.addAll(this.f12669o);
            } else if (3 == this.f12665k) {
                this.f12674t.addAll(this.f12671q);
            } else if (5 == this.f12665k) {
                this.f12674t.addAll(this.f12672r);
            } else if (4 == this.f12665k) {
                this.f12674t.addAll(this.f12673s);
            } else if (7 == this.f12665k) {
                this.f12674t.addAll(this.f12667m);
            } else {
                this.f12674t.addAll(this.f12666l);
            }
        }
    }

    /* renamed from: a */
    public void mo21799a(String str, View view, int i) {
        int i2;
        if (!PatchProxy.proxy(new Object[]{str, view, new Integer(i)}, this, f12656a, false, 7622, new Class[]{String.class, View.class, Integer.TYPE}, Void.TYPE).isSupported) {
            int[] iArr = new int[2];
            view.findViewById(R.id.left_icon).getLocationOnScreen(iArr);
            int i3 = iArr[0];
            mo21878a(str, i, true);
            if (i != 0) {
                this.f12662h.getChildAt(0).findViewById(R.id.left_icon).getLocationOnScreen(iArr);
                i2 = iArr[0];
            } else {
                i2 = i3;
            }
            if (this.f12663i != null) {
                this.f12663i.mo21764a(i, i3, i2);
            }
            if (mo21808c()) {
                mo21810d();
            }
        }
    }

    /* renamed from: b */
    public void mo21805b(String str, View view, int i) {
        int i2;
        if (!PatchProxy.proxy(new Object[]{str, view, new Integer(i)}, this, f12656a, false, 7623, new Class[]{String.class, View.class, Integer.TYPE}, Void.TYPE).isSupported) {
            int[] iArr = new int[2];
            view.findViewById(R.id.left_icon).getLocationOnScreen(iArr);
            int i3 = iArr[0];
            mo21878a(str, i, true);
            if (i != 0) {
                this.f12662h.getChildAt(0).findViewById(R.id.left_icon).getLocationOnScreen(iArr);
                i2 = iArr[0];
            } else {
                i2 = i3;
            }
            if (this.f12663i != null) {
                this.f12663i.mo21764a(i, i3, i2);
            }
            if (mo21808c()) {
                mo21810d();
            }
        }
    }

    /* renamed from: a */
    public void mo21797a(int i) {
        int i2;
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f12656a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7624, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f12665k = i;
            if (2 == this.f12665k) {
                i2 = mo21888i("pref_camera_timer_key");
            } else if (1 == this.f12665k) {
                i2 = mo21888i("pref_video_flashmode_key");
            } else if (3 == this.f12665k) {
                i2 = mo21888i("mz_pref_hdr_key");
            } else if (4 == this.f12665k) {
                i2 = mo21888i("mz_pref_fb_key");
            } else if (7 == this.f12665k) {
                i2 = mo21888i("pref_camera_timelapse_key");
            } else {
                i2 = mo21888i("pref_camera_flashmode_key");
            }
            mo21803b();
            this.f12662h.setAdapter(this.f12674t);
            this.f12662h.setItemChecked(i2, true);
        }
    }

    /* renamed from: b */
    public void mo21806b(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f12656a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7625, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f12675u = z;
            if (this.f12662h != null) {
                this.f12662h.setSoundEffectsEnabled(z);
            }
        }
    }

    /* renamed from: c */
    public void mo21807c(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12656a, false, 7626, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            for (C2429a aVar : this.f12674t) {
                mo21891l(aVar.f12679a);
            }
        }
    }

    /* renamed from: c */
    public boolean mo21808c() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12656a, false, 7627, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f12661g == null || this.f12661g.getRoot() == null || this.f12661g.getRoot().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public void mo21810d() {
        if (!PatchProxy.proxy(new Object[0], this, f12656a, false, 7628, new Class[0], Void.TYPE).isSupported) {
            this.f12661g.getRoot().setVisibility(8);
        }
    }

    /* renamed from: b */
    public void mo21804b(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f12656a, false, 7629, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f12661g.getRoot().setVisibility(0);
            int[] iArr = new int[2];
            View childAt = this.f12662h.getChildAt(i);
            childAt.findViewById(R.id.left_icon).getLocationOnScreen(iArr);
            int i2 = iArr[0];
            this.f12662h.getChildAt(0).findViewById(R.id.left_icon).getLocationOnScreen(iArr);
            TranslateAnimation translateAnimation = new TranslateAnimation((float) (-(i2 - iArr[0])), 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(300);
            childAt.setVisibility(0);
            translateAnimation.setInterpolator(this.f12661g.getRoot().getContext(), R.anim.mz_smart_bar_button_interpolator);
            childAt.startAnimation(translateAnimation);
            int size = this.f12674t.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 != i) {
                    this.f12662h.getChildAt(i3).startAnimation(this.f12678y);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo21802a(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f12656a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 7630, new Class[]{Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (this.f12662h == null) {
            return false;
        }
        return CameraUtil.m15856a((float) i, (float) i2, (View) this.f12662h);
    }

    /* renamed from: a */
    public int mo21795a(boolean z, boolean z2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f12656a, false, 7631, new Class[]{Boolean.TYPE, Boolean.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (z) {
            if (z2) {
                return mo21890k("pref_video_flashmode_key");
            }
            return mo21889j("pref_video_flashmode_key");
        } else if (z2) {
            return mo21890k(this.f12676v ? "pref_camera_flashmode_key_v1" : "pref_camera_flashmode_key");
        } else {
            return mo21889j(this.f12676v ? "pref_camera_flashmode_key_v1" : "pref_camera_flashmode_key");
        }
    }

    /* renamed from: d */
    public int mo21809d(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f12656a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 7632, new Class[]{Boolean.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (!z) {
            return mo21889j("pref_camera_timer_key");
        }
        return mo21890k("pref_camera_timer_key");
    }

    /* renamed from: e */
    public int mo21811e() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12656a, false, 7633, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : mo21889j("mz_pref_hdr_key");
    }

    /* renamed from: f */
    public int mo21813f() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12656a, false, 7634, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : mo21889j("mz_pref_20m_key");
    }

    /* renamed from: g */
    public int mo21815g() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12656a, false, 7635, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : mo21889j("mz_pref_48m_key");
    }

    /* renamed from: h */
    public int mo21817h() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12656a, false, 7636, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : mo21889j("mz_pref_64m_key");
    }

    /* renamed from: i */
    public int mo21818i() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12656a, false, 7637, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : mo21889j("mz_pref_fb_key");
    }

    /* renamed from: j */
    public int mo21819j() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12656a, false, 7638, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : mo21889j("pref_camera_timelapse_key");
    }

    /* renamed from: k */
    public int mo21820k() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12656a, false, 7639, new Class[0], Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : mo21888i("mz_pref_hdr_key");
    }

    /* renamed from: l */
    public boolean mo21821l() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12656a, false, 7640, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return mo21888i("mz_pref_fb_key") > 0;
    }

    /* renamed from: a */
    public void mo21798a(C2430b bVar) {
        this.f12663i = bVar;
    }

    /* renamed from: e */
    public CameraController.FlashMode mo21812e(boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12656a, false, 7641, new Class[]{Boolean.TYPE}, CameraController.FlashMode.class);
        if (proxy.isSupported) {
            return (CameraController.FlashMode) proxy.result;
        }
        return CameraController.FlashMode.convertFlashMode(mo21880c(z ? "pref_video_flashmode_key" : (!DeviceHelper.f13888ao || !this.f12676v) ? "pref_camera_flashmode_key" : "pref_camera_flashmode_key_v1"));
    }

    /* renamed from: a */
    public void mo21801a(boolean z, int i, boolean z2) {
        String str;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Integer(i), new Byte(z2 ? (byte) 1 : 0)}, this, f12656a, false, 7642, new Class[]{Boolean.TYPE, Integer.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = f12657w;
            LogUtil.m15942a(aVar, "setFlashVauleIndex index: " + i + " isNotSupportAuto: " + z + " shouldRecord: " + z2);
            if (z) {
                str = "pref_video_flashmode_key";
            } else {
                str = (!DeviceHelper.f13888ao || !this.f12676v) ? "pref_camera_flashmode_key" : "pref_camera_flashmode_key_v1";
            }
            mo21878a(str, i, z2);
        }
    }

    /* renamed from: f */
    public int mo21814f(boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12656a, false, 7643, new Class[]{Boolean.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int i = mo21888i(z ? "pref_video_flashmode_key" : (!DeviceHelper.f13888ao || !this.f12676v) ? "pref_camera_flashmode_key" : "pref_camera_flashmode_key_v1");
        LogUtil.C2630a aVar = f12657w;
        LogUtil.m15942a(aVar, "getFlashValueIndex: " + i + " isNotSupportAuto: " + z);
        return i;
    }

    /* renamed from: g */
    public void mo21816g(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12656a, false, 7646, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            mo21878a(z ? "pref_video_flashmode_key" : "pref_camera_flashmode_key", 0, false);
        }
    }

    /* renamed from: com.meizu.media.camera.ui.ab$a */
    /* compiled from: MzTopSettingUI */
    public class C2429a {

        /* renamed from: a */
        public String f12679a;

        /* renamed from: b */
        public int f12680b;

        /* renamed from: c */
        public int f12681c;

        /* renamed from: d */
        public int f12682d = 0;

        /* renamed from: e */
        public String f12683e;

        public C2429a() {
        }
    }
}
