package com.meizu.media.camera.simplify;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.media.camera.R;
import com.meizu.media.camera.p077ui.MzCommonUI;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.simplify.k */
public class MzSimplifyVideoUI {

    /* renamed from: a */
    public static ChangeQuickRedirect f12089a;

    /* renamed from: b */
    private MzSimplifyUIController f12090b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LinearLayout f12091c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f12092d;

    /* renamed from: e */
    private Animation f12093e;

    /* renamed from: f */
    private MzCommonUI.C2403f f12094f = new MzCommonUI.C2403f() {

        /* renamed from: a */
        public static ChangeQuickRedirect f12095a;

        /* renamed from: a */
        public void mo21344a() {
            if (!PatchProxy.proxy(new Object[0], this, f12095a, false, 6104, new Class[0], Void.TYPE).isSupported) {
                MzSimplifyVideoUI.this.f12091c.setVisibility(8);
                MzSimplifyVideoUI.this.f12092d.setVisibility(8);
            }
        }

        /* renamed from: b */
        public void mo21345b() {
            if (!PatchProxy.proxy(new Object[0], this, f12095a, false, 6105, new Class[0], Void.TYPE).isSupported) {
                MzSimplifyVideoUI.this.f12091c.setVisibility(0);
                MzSimplifyVideoUI.this.f12092d.setVisibility(0);
                MzSimplifyVideoUI.this.mo21340a("00:00:00");
            }
        }
    };

    /* renamed from: a */
    public void mo21338a(int i) {
    }

    public MzSimplifyVideoUI(View view, Context context) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.mz_video_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.f12091c = (LinearLayout) view.findViewById(R.id.mz_video_control_layout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f12091c.getLayoutParams();
        layoutParams.height = CameraUtil.m15901h();
        layoutParams.gravity = 49;
        this.f12091c.setLayoutParams(layoutParams);
        this.f12092d = (TextView) this.f12091c.findViewById(R.id.video_record_timer);
        this.f12093e = AnimationUtils.loadAnimation(context, R.anim.mz_smart_bar_button_show);
    }

    /* renamed from: a */
    public void mo21339a(MzSimplifyUIController jVar) {
        if (!PatchProxy.proxy(new Object[]{jVar}, this, f12089a, false, 6096, new Class[]{MzSimplifyUIController.class}, Void.TYPE).isSupported) {
            this.f12090b = jVar;
            this.f12090b.mo20865a(this.f12094f);
        }
    }

    /* renamed from: a */
    public void mo21340a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, this, f12089a, false, 6097, new Class[]{String.class}, Void.TYPE).isSupported && m13359d()) {
            this.f12092d.setText(str);
        }
    }

    /* renamed from: a */
    public void mo21337a() {
        if (!PatchProxy.proxy(new Object[0], this, f12089a, false, 6098, new Class[0], Void.TYPE).isSupported) {
            this.f12092d.setText("00:00:00");
        }
    }

    /* renamed from: a */
    public void mo21341a(boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f12089a, false, 6099, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            mo21337a();
        }
    }

    /* renamed from: b */
    public void mo21342b() {
        if (!PatchProxy.proxy(new Object[0], this, f12089a, false, 6100, new Class[0], Void.TYPE).isSupported && !this.f12090b.mo20884af()) {
            this.f12091c.setVisibility(0);
            if (this.f12092d.getVisibility() != 0) {
                this.f12092d.setVisibility(0);
                this.f12092d.startAnimation(this.f12093e);
            }
            mo21340a("00:00:00");
        }
    }

    /* renamed from: c */
    public void mo21343c() {
        if (!PatchProxy.proxy(new Object[0], this, f12089a, false, 6101, new Class[0], Void.TYPE).isSupported) {
            this.f12092d.setText((CharSequence) null);
            this.f12091c.setVisibility(8);
            this.f12092d.setVisibility(8);
            this.f12090b.mo20865a((MzCommonUI.C2403f) null);
        }
    }

    /* renamed from: d */
    private boolean m13359d() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12089a, false, 6103, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f12092d != null && this.f12092d.getVisibility() == 0;
    }
}
