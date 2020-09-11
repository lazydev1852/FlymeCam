package com.meizu.media.camera.p077ui;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.R;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.databinding.CameraBinding;
import com.meizu.media.camera.databinding.DelayInflateTwoBinding;
import com.meizu.media.camera.databinding.MzVideoControlBinding;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.p077ui.MzCommonUI;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.views.GlowImageView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.ui.ad */
public class MzVideoUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f12693a;

    /* renamed from: b */
    private MzUIController f12694b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LinearLayout f12695c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f12696d;

    /* renamed from: e */
    private Animation f12697e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f12698f = false;

    /* renamed from: g */
    private boolean f12699g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public GlowImageView f12700h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public GlowImageView f12701i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GlowImageView f12702j;

    /* renamed from: k */
    private MzCommonUI.C2403f f12703k = new MzCommonUI.C2403f() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12704a;

        /* renamed from: a */
        public void mo21344a() {
            if (!PatchProxy.proxy(new Object[0], this, f12704a, false, 7665, new Class[0], Void.TYPE).isSupported) {
                MzVideoUI.this.f12695c.setVisibility(8);
                MzVideoUI.this.f12696d.setVisibility(8);
            }
        }

        /* renamed from: b */
        public void mo21345b() {
            if (!PatchProxy.proxy(new Object[0], this, f12704a, false, 7666, new Class[0], Void.TYPE).isSupported) {
                if (!(MzVideoUI.this.f12700h.getVisibility() == 0 || MzVideoUI.this.f12701i.getVisibility() == 0 || MzVideoUI.this.f12702j.getVisibility() == 0)) {
                    MzVideoUI.this.f12695c.setVisibility(0);
                    MzVideoUI.this.f12696d.setVisibility(0);
                }
                MzVideoUI.this.mo21834a(MzVideoUI.this.f12698f ? "10:00" : "00:00:00", new boolean[0]);
            }
        }
    };

    /* renamed from: a */
    public void mo21832a(int i) {
    }

    public MzVideoUI(CameraBinding cameraBinding, Context context) {
        MzVideoControlBinding mzVideoControlBinding;
        DelayInflateTwoBinding delayInflateTwoBinding = (DelayInflateTwoBinding) cameraBinding.f9509h.getBinding();
        if (delayInflateTwoBinding.f9592w.getViewStub() != null) {
            mzVideoControlBinding = (MzVideoControlBinding) DataBindingUtil.bind(delayInflateTwoBinding.f9592w.getViewStub().inflate());
        } else {
            mzVideoControlBinding = (MzVideoControlBinding) delayInflateTwoBinding.f9592w.getBinding();
        }
        this.f12695c = mzVideoControlBinding.f9852a;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f12695c.getLayoutParams();
        layoutParams.height = CameraUtil.m15901h();
        layoutParams.gravity = 49;
        this.f12695c.setLayoutParams(layoutParams);
        this.f12696d = mzVideoControlBinding.f9853b;
        this.f12697e = AnimationUtils.loadAnimation(context, R.anim.mz_smart_bar_button_show);
        this.f12700h = cameraBinding.f9522u.f9698l;
        this.f12701i = cameraBinding.f9522u.f9704r;
        this.f12702j = cameraBinding.f9522u.f9688b;
    }

    /* renamed from: a */
    public void mo21833a(MzUIController uVar, boolean... zArr) {
        boolean z = false;
        if (!PatchProxy.proxy(new Object[]{uVar, zArr}, this, f12693a, false, 7657, new Class[]{MzUIController.class, boolean[].class}, Void.TYPE).isSupported) {
            if (zArr != null && zArr.length > 0 && zArr[0]) {
                z = true;
            }
            this.f12694b = uVar;
            if (!z) {
                this.f12694b.mo21520a(this.f12703k);
            }
        }
    }

    /* renamed from: a */
    public void mo21834a(String str, boolean... zArr) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{str, zArr}, this, f12693a, false, 7658, new Class[]{String.class, boolean[].class}, Void.TYPE).isSupported) {
            boolean z2 = zArr != null && zArr.length > 0 && zArr[0];
            if (CameraController.m8868g().mo19522k() == null || CameraController.m8868g().mo19522k().mo19733b() != 1) {
                z = false;
            }
            this.f12696d.setText(str);
            if (this.f12699g) {
                this.f12702j.setVisibility(8);
            }
            if (z2) {
                this.f12695c.setVisibility(0);
                this.f12696d.setVisibility(0);
                this.f12700h.setVisibility(8);
                this.f12701i.setVisibility(8);
                this.f12702j.setVisibility(8);
            } else if (z) {
                if (CameraModeType.m10968g()) {
                    this.f12695c.setVisibility(8);
                    this.f12696d.setVisibility(8);
                } else {
                    this.f12695c.setVisibility(0);
                    this.f12696d.setVisibility(0);
                }
                this.f12700h.setVisibility(8);
            } else if (CameraModeType.m10985n(CameraModeType.ModeType.TOF)) {
                this.f12700h.setVisibility(0);
                this.f12695c.setVisibility(8);
                this.f12696d.setVisibility(8);
            } else if (DeviceHelper.f13863aP) {
                this.f12701i.setVisibility(0);
                this.f12695c.setVisibility(8);
                this.f12696d.setVisibility(8);
            } else if (CameraModeType.m10968g()) {
                this.f12695c.setVisibility(8);
                this.f12696d.setVisibility(8);
            }
        }
    }

    /* renamed from: a */
    public void mo21831a() {
        if (!PatchProxy.proxy(new Object[0], this, f12693a, false, 7659, new Class[0], Void.TYPE).isSupported) {
            this.f12696d.setText("00:00:00");
        }
    }

    /* renamed from: a */
    public void mo21835a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12693a, false, 7660, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            mo21831a();
        }
    }

    /* renamed from: a */
    public void mo21836a(boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f12693a, false, 7661, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (!this.f12694b.mo21590f()) {
                if (!(this.f12700h.getVisibility() == 0 || this.f12701i.getVisibility() == 0 || this.f12702j.getVisibility() == 0)) {
                    this.f12695c.setVisibility(0);
                    if (this.f12696d.getVisibility() != 0) {
                        this.f12696d.setVisibility(0);
                        this.f12696d.startAnimation(this.f12697e);
                    }
                }
                this.f12698f = z;
                this.f12699g = z2;
                mo21834a(z ? "10:00" : "00:00:00", new boolean[0]);
            }
            if (this.f12699g) {
                this.f12702j.setVisibility(8);
            }
        }
    }

    /* renamed from: b */
    public void mo21837b() {
        if (!PatchProxy.proxy(new Object[0], this, f12693a, false, 7662, new Class[0], Void.TYPE).isSupported) {
            this.f12696d.setText((CharSequence) null);
            this.f12695c.setVisibility(8);
            this.f12696d.setVisibility(8);
            this.f12694b.mo21520a((MzCommonUI.C2403f) null);
            this.f12698f = false;
        }
    }

    /* renamed from: b */
    public void mo21838b(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12693a, false, 7663, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = LogUtil.f14072b;
            LogUtil.m15942a(aVar, "onModeMenuVisibilityChanged visibility:" + z);
            if (z) {
                this.f12695c.setVisibility(8);
                this.f12696d.setVisibility(8);
                return;
            }
            if (!(this.f12700h.getVisibility() == 0 || this.f12701i.getVisibility() == 0 || this.f12702j.getVisibility() == 0)) {
                this.f12695c.setVisibility(0);
                this.f12696d.setVisibility(0);
            }
            mo21834a(this.f12698f ? "10:00" : "00:00:00", new boolean[0]);
        }
    }
}
