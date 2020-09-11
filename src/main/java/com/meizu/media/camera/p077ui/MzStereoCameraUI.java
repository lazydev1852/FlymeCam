package com.meizu.media.camera.p077ui;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.databinding.DelayInflateTwoBinding;
import com.meizu.media.camera.databinding.MzStereoCameraControlBinding;
import com.meizu.media.camera.p077ui.MzCommonUI;
import com.meizu.media.camera.p077ui.NullStereoCameraUI;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.util.UsageStatsHelper;
import com.meizu.media.camera.views.HorizontalPickerView;
import com.meizu.media.camera.views.MzEnhanceSeekBar;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;

/* renamed from: com.meizu.media.camera.ui.z */
public class MzStereoCameraUI extends NullStereoCameraUI implements View.OnClickListener, HorizontalPickerView.C2702a {

    /* renamed from: a */
    public static ChangeQuickRedirect f13713a;

    /* renamed from: f */
    private static final LogUtil.C2630a f13714f = new LogUtil.C2630a("MzStereoCameraUI");
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f13715g;

    /* renamed from: h */
    private MzCamUI f13716h;

    /* renamed from: i */
    private View f13717i;

    /* renamed from: j */
    private TextView f13718j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public HorizontalPickerView f13719k;

    /* renamed from: l */
    private boolean f13720l;

    /* renamed from: m */
    private MzEnhanceSeekBar.OnInterceptTouchEventListener f13721m = new MzEnhanceSeekBar.OnInterceptTouchEventListener() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13724a;

        public boolean isInterceptTouchEvent() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13724a, false, 7599, new Class[0], Boolean.TYPE);
            if (proxy.isSupported) {
                return ((Boolean) proxy.result).booleanValue();
            }
            return (MzStereoCameraUI.this.f13715g == 2 || MzStereoCameraUI.this.f13715g == 1) ? false : true;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Runnable f13722n = new Runnable() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13726a;

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f13726a, false, 7600, new Class[0], Void.TYPE).isSupported && MzStereoCameraUI.this.mo21870a()) {
                MzStereoCameraUI.this.mo21869a(false, true);
            }
        }
    };

    /* renamed from: o */
    private MzCommonUI.C2403f f13723o = new MzCommonUI.C2403f() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13728a;

        /* renamed from: a */
        public void mo21344a() {
            if (!PatchProxy.proxy(new Object[0], this, f13728a, false, 7601, new Class[0], Void.TYPE).isSupported) {
                if (MzStereoCameraUI.this.f13715g != 3 && MzStereoCameraUI.this.mo21870a()) {
                    MzStereoCameraUI.this.mo21869a(false, false);
                }
                MzStereoCameraUI.this.m15763c(false);
                MzStereoCameraUI.this.f13719k.removeCallbacks(MzStereoCameraUI.this.f13722n);
            }
        }

        /* renamed from: b */
        public void mo21345b() {
            if (!PatchProxy.proxy(new Object[0], this, f13728a, false, 7602, new Class[0], Void.TYPE).isSupported && DeviceHelper.f13852aE) {
                MzStereoCameraUI.this.m15763c(true);
                MzStereoCameraUI.this.f13719k.postDelayed(MzStereoCameraUI.this.f13722n, 5000);
            }
        }
    };

    /* renamed from: a */
    public void mo21868a(boolean z) {
        boolean z2 = true;
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13713a, false, 7580, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && DeviceHelper.f13852aE) {
            if (this.f13717i == null || this.f13717i.getVisibility() != 0) {
                z2 = false;
            }
            if (z != z2) {
                m15763c(z);
                if (z) {
                    if (this.f13720l) {
                        switch (this.f13719k.getSelectedIndex()) {
                            case 0:
                                mo21875c(8);
                                break;
                            case 1:
                                mo21875c(10);
                                break;
                            case 2:
                                mo21875c(15);
                                break;
                        }
                    } else {
                        m15771f();
                    }
                    m15767e();
                }
            }
        }
    }

    public MzStereoCameraUI(Context context, DelayInflateTwoBinding delayInflateTwoBinding, MzCamUI iVar) {
        super(context);
        MzStereoCameraControlBinding mzStereoCameraControlBinding;
        this.f13716h = iVar;
        if (delayInflateTwoBinding.f9590u.getViewStub() != null) {
            mzStereoCameraControlBinding = (MzStereoCameraControlBinding) DataBindingUtil.bind(delayInflateTwoBinding.f9590u.getViewStub().inflate());
        } else {
            mzStereoCameraControlBinding = (MzStereoCameraControlBinding) delayInflateTwoBinding.f9590u.getBinding();
        }
        this.f13717i = mzStereoCameraControlBinding.f9829a;
        ((FrameLayout.LayoutParams) this.f13717i.getLayoutParams()).bottomMargin = CameraUtil.m15897f();
        this.f13718j = mzStereoCameraControlBinding.f9830b;
        this.f13718j.setOnClickListener(this);
        this.f13719k = mzStereoCameraControlBinding.f9831c;
        this.f13719k.setOnValueChangeListener(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.f12731d.getResources().getString(R.string.mz_manual_item_low));
        arrayList2.add(this.f12731d.getResources().getString(R.string.mz_manual_item_middle));
        arrayList2.add(this.f12731d.getResources().getString(R.string.mz_manual_item_high));
        this.f13719k.setValue(arrayList, arrayList2);
        this.f13719k.setVisibility(8);
        this.f13720l = false;
        this.f13719k.invalidate();
        this.f13720l = false;
    }

    /* renamed from: b */
    public void mo21873b(boolean z) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13713a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7581, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            m15763c(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m15763c(boolean z) {
        if (PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13713a, false, 7582, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported || this.f13717i == null) {
            return;
        }
        if (!z || this.f12732e == null || this.f12732e.mo21590f()) {
            this.f13717i.setVisibility(8);
        } else {
            this.f13717i.setVisibility(0);
        }
    }

    /* renamed from: a */
    public void mo21867a(NullStereoCameraUI.C2435a aVar) {
        if (!PatchProxy.proxy(new Object[]{aVar}, this, f13713a, false, 7583, new Class[]{NullStereoCameraUI.C2435a.class}, Void.TYPE).isSupported) {
            super.mo21867a(aVar);
            if (this.f13719k != null) {
                this.f13719k.setSelectorValue(m15770f(mo21874c()));
                m15767e();
            }
        }
    }

    /* renamed from: d */
    private void m15766d() {
        if (!PatchProxy.proxy(new Object[0], this, f13713a, false, 7584, new Class[0], Void.TYPE).isSupported && this.f13719k != null) {
            this.f13719k.removeCallbacks(this.f13722n);
            this.f13719k.postDelayed(this.f13722n, 5000);
        }
    }

    /* renamed from: a */
    public void mo21866a(MzUIController uVar) {
        if (!PatchProxy.proxy(new Object[]{uVar}, this, f13713a, false, 7585, new Class[]{MzUIController.class}, Void.TYPE).isSupported) {
            super.mo21866a(uVar);
            if (this.f12732e != null) {
                this.f12732e.mo21520a(this.f13723o);
            }
        }
    }

    /* renamed from: e */
    private void m15767e() {
        if (!PatchProxy.proxy(new Object[0], this, f13713a, false, 7586, new Class[0], Void.TYPE).isSupported) {
            String string = this.f12731d.getResources().getString(R.string.mz_hint_xuhua);
            String d = m15765d(mo21874c());
            this.f13718j.setText(String.format("%s%s", new Object[]{string, d}));
        }
    }

    @NonNull
    /* renamed from: d */
    private String m15765d(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f13713a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 7587, new Class[]{Integer.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (i == 8) {
            return this.f12731d.getResources().getString(R.string.mz_manual_item_low);
        }
        if (i == 10) {
            return this.f12731d.getResources().getString(R.string.mz_manual_item_middle);
        }
        if (i == 15) {
            return this.f12731d.getResources().getString(R.string.mz_manual_item_high);
        }
        return "";
    }

    /* renamed from: a */
    public void mo21869a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f13713a;
        if (PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7589, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported || this.f13717i == null) {
            return;
        }
        if (this.f13717i.getVisibility() == 0 || z) {
            if (z) {
                this.f13719k.setVisibility(0);
                m15772g();
                m15766d();
            }
            this.f13720l = z;
            if (z2) {
                m15767e();
                m15771f();
                this.f13719k.startAnimation(m15764d(z));
                return;
            }
            m15769e(z);
        }
    }

    /* renamed from: d */
    private Animation m15764d(final boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13713a, false, 7590, new Class[]{Boolean.TYPE}, Animation.class);
        if (proxy.isSupported) {
            return (Animation) proxy.result;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f12731d, z ? R.anim.mz_stereo_translate_show : R.anim.mz_stereo_translate_hide);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f13730a;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f13730a, false, 7603, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                    MzStereoCameraUI.this.m15769e(z);
                }
            }
        });
        return loadAnimation;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m15769e(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13713a, false, 7591, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported && this.f13719k != null) {
            this.f13719k.setVisibility(z ? 0 : 8);
            this.f13720l = z;
            if (z) {
                this.f13719k.setSelectorValue(m15770f(mo21874c()));
                this.f13716h.mo22138b(this.f13719k.getMeasuredHeight());
                return;
            }
            this.f13716h.mo22138b(0);
        }
    }

    /* renamed from: f */
    private void m15771f() {
        if (!PatchProxy.proxy(new Object[0], this, f13713a, false, 7592, new Class[0], Void.TYPE).isSupported) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(240);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
            alphaAnimation.setStartOffset(112);
            this.f13718j.startAnimation(alphaAnimation);
        }
    }

    /* renamed from: g */
    private void m15772g() {
        if (!PatchProxy.proxy(new Object[0], this, f13713a, false, 7593, new Class[0], Void.TYPE).isSupported) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(112);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
            this.f13718j.startAnimation(alphaAnimation);
        }
    }

    public void onClick(View view) {
        if (!PatchProxy.proxy(new Object[]{view}, this, f13713a, false, 7594, new Class[]{View.class}, Void.TYPE).isSupported) {
            if ((this.f13715g == 1 || this.f13715g == 2) && this.f13719k != null) {
                this.f13719k.setVisibility(0);
                this.f13720l = true;
                this.f13719k.startAnimation(m15764d(true));
                m15772g();
                m15766d();
                UsageStatsHelper.m16042a(this.f12731d.getApplicationContext()).mo22695b("open_bokeh_slider");
            }
        }
    }

    /* renamed from: a */
    public boolean mo21870a() {
        return this.f13720l;
    }

    /* renamed from: b */
    public void mo21872b(int i) {
        this.f13715g = i;
    }

    /* renamed from: a */
    public void mo22515a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f13713a, false, 7595, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            m15766d();
            switch (i) {
                case 0:
                    if (mo21874c() != 8) {
                        mo21875c(8);
                        m15768e(0);
                        return;
                    }
                    return;
                case 1:
                    if (mo21874c() != 10) {
                        mo21875c(10);
                        m15768e(1);
                        return;
                    }
                    return;
                case 2:
                    if (mo21874c() != 15) {
                        mo21875c(15);
                        m15768e(2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: e */
    private void m15768e(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f13713a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 7596, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && this.f12731d != null) {
            UsageStatsHelper.m16042a(this.f12731d.getApplicationContext()).mo22691a("select_bokeh_level", "value", String.valueOf(i));
        }
    }

    /* renamed from: f */
    private String m15770f(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f13713a, false, 7597, new Class[]{Integer.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        if (i == 8) {
            return this.f12731d.getResources().getString(R.string.mz_manual_item_low);
        }
        if (i != 10) {
            return i != 15 ? "" : this.f12731d.getResources().getString(R.string.mz_manual_item_high);
        }
        return this.f12731d.getResources().getString(R.string.mz_manual_item_middle);
    }

    /* renamed from: b */
    public void mo21871b() {
        if (!PatchProxy.proxy(new Object[0], this, f13713a, false, 7598, new Class[0], Void.TYPE).isSupported) {
            this.f12731d = null;
            if (this.f12732e != null) {
                this.f12732e.mo21520a((MzCommonUI.C2403f) null);
            }
            if (this.f13716h != null) {
                this.f13716h.mo22061X();
            }
            this.f13718j = null;
            this.f13719k = null;
            this.f13717i = null;
            this.f12732e = null;
            this.f13716h = null;
        }
    }
}
