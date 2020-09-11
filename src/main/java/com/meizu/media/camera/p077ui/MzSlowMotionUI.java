package com.meizu.media.camera.p077ui;

import android.content.Context;
import android.view.View;
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
import com.meizu.media.camera.p077ui.MzCommonUI;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.views.GlowImageView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.ui.y */
public class MzSlowMotionUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f13703a;

    /* renamed from: b */
    private MzUIController f13704b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LinearLayout f13705c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f13706d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GlowImageView f13707e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f13708f;

    /* renamed from: g */
    private C2607a f13709g;

    /* renamed from: h */
    private MzCommonUI.C2403f f13710h = new MzCommonUI.C2403f() {

        /* renamed from: a */
        public static ChangeQuickRedirect f13711a;

        /* renamed from: a */
        public void mo21344a() {
            if (!PatchProxy.proxy(new Object[0], this, f13711a, false, 7578, new Class[0], Void.TYPE).isSupported) {
                MzSlowMotionUI.this.f13705c.setVisibility(8);
                MzSlowMotionUI.this.f13706d.setVisibility(8);
                MzSlowMotionUI.this.f13707e.setVisibility(8);
            }
        }

        /* renamed from: b */
        public void mo21345b() {
            if (!PatchProxy.proxy(new Object[0], this, f13711a, false, 7579, new Class[0], Void.TYPE).isSupported) {
                MzSlowMotionUI.this.f13705c.setVisibility(0);
                if (MzSlowMotionUI.this.f13708f) {
                    MzSlowMotionUI.this.f13707e.setVisibility(0);
                }
            }
        }
    };

    /* renamed from: com.meizu.media.camera.ui.y$a */
    /* compiled from: MzSlowMotionUI */
    public interface C2607a {
        /* renamed from: a */
        void mo20676a();
    }

    /* renamed from: b */
    public void mo22601b(int i) {
    }

    public MzSlowMotionUI(CameraBinding cameraBinding, Context context) {
        MzVideoControlBinding mzVideoControlBinding;
        DelayInflateTwoBinding delayInflateTwoBinding = (DelayInflateTwoBinding) cameraBinding.f9509h.getBinding();
        if (delayInflateTwoBinding.f9589t.getViewStub() != null) {
            mzVideoControlBinding = (MzVideoControlBinding) DataBindingUtil.bind(delayInflateTwoBinding.f9589t.getViewStub().inflate());
        } else {
            mzVideoControlBinding = (MzVideoControlBinding) delayInflateTwoBinding.f9589t.getBinding();
        }
        this.f13705c = mzVideoControlBinding.f9852a;
        this.f13708f = CameraController.m8868g().mo19443G() != null;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13705c.getLayoutParams();
        layoutParams.height = CameraUtil.m15901h();
        layoutParams.gravity = 49;
        this.f13705c.setLayoutParams(layoutParams);
        this.f13706d = mzVideoControlBinding.f9853b;
        this.f13707e = cameraBinding.f9522u.f9690d;
        if (this.f13708f) {
            this.f13707e.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MzSlowMotionUI.this.m15742a(view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15742a(View view) {
        if (!PatchProxy.proxy(new Object[]{view}, this, f13703a, false, 7577, new Class[]{View.class}, Void.TYPE).isSupported) {
            this.f13704b.mo21542ag();
            this.f13709g.mo20676a();
        }
    }

    /* renamed from: a */
    public void mo22597a(MzUIController uVar) {
        this.f13704b = uVar;
    }

    /* renamed from: a */
    public void mo22598a(C2607a aVar) {
        this.f13709g = aVar;
    }

    /* renamed from: a */
    public void mo22599a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f13703a, false, 7570, new Class[]{String.class}, Void.TYPE).isSupported) {
            if (!"60.00".equals(str) || !this.f13708f) {
                this.f13706d.setVisibility(0);
                this.f13707e.setVisibility(8);
            } else {
                this.f13706d.setVisibility(8);
                this.f13707e.setVisibility(0);
            }
            if (m15744b()) {
                this.f13706d.setText(str);
            }
        }
    }

    /* renamed from: a */
    public void mo22596a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f13703a, false, 7572, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f13704b.mo21520a(this.f13710h);
            if (!this.f13704b.mo21590f()) {
                this.f13705c.setVisibility(0);
                if (this.f13708f) {
                    mo22602c(i);
                    this.f13707e.setVisibility(0);
                }
                mo22599a("60.00");
            }
        }
    }

    /* renamed from: a */
    public void mo22595a() {
        if (!PatchProxy.proxy(new Object[0], this, f13703a, false, 7573, new Class[0], Void.TYPE).isSupported) {
            this.f13706d.setText((CharSequence) null);
            this.f13705c.setVisibility(8);
            this.f13706d.setVisibility(8);
            if (this.f13708f) {
                this.f13707e.setVisibility(8);
            }
            this.f13704b.mo21520a((MzCommonUI.C2403f) null);
        }
    }

    /* renamed from: b */
    private boolean m15744b() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f13703a, false, 7574, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f13706d != null && this.f13706d.getVisibility() == 0;
    }

    /* renamed from: c */
    public void mo22602c(int i) {
        int i2 = 0;
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f13703a, false, 7575, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && this.f13708f && this.f13707e != null) {
            if (Integer.valueOf(DeviceHelper.f14038h.getValue()).intValue() == i) {
                i2 = R.drawable.mz_ic_tab_sm_120fps_selected;
            } else if (240 == i) {
                i2 = R.drawable.mz_ic_tab_sm_240fps_selected;
            } else if (480 == i) {
                i2 = R.drawable.mz_ic_tab_sm_480fps_selected;
            }
            this.f13707e.setImageResource(i2);
        }
    }

    /* renamed from: a */
    public void mo22600a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f13703a, false, 7576, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            int i = 8;
            if (this.f13706d != null) {
                this.f13706d.setVisibility((!z || this.f13708f) ? 8 : 0);
            }
            if (this.f13708f && this.f13707e != null) {
                GlowImageView glowImageView = this.f13707e;
                if (z) {
                    i = 0;
                }
                glowImageView.setVisibility(i);
            }
        }
    }
}
