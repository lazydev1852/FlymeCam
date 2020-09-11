package com.meizu.media.camera.animation;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.DeviceHelper;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.animation.b */
public class FrontFlashManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f7627a;

    /* renamed from: b */
    private static final LogUtil.C2630a f7628b = new LogUtil.C2630a("FrontFlashManager");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Activity f7629c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f7630d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f7631e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f7632f;

    /* renamed from: g */
    private ObjectAnimator f7633g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f7634h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f7635i;

    /* renamed from: j */
    private Animator.AnimatorListener f7636j = new Animator.AnimatorListener() {

        /* renamed from: a */
        public static ChangeQuickRedirect f7637a;

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f7637a, false, 2348, new Class[]{Animator.class}, Void.TYPE).isSupported && FrontFlashManager.this.f7630d != null) {
                FrontFlashManager.this.f7631e.setBackgroundColor(FrontFlashManager.this.f7634h);
                if (DeviceHelper.f13944br && FrontFlashManager.this.f7632f.getVisibility() == 8) {
                    FrontFlashManager.this.f7632f.setVisibility(0);
                }
                FrontFlashManager.this.f7630d.setVisibility(0);
            }
        }

        public void onAnimationEnd(Animator animator) {
            if (!PatchProxy.proxy(new Object[]{animator}, this, f7637a, false, 2349, new Class[]{Animator.class}, Void.TYPE).isSupported && FrontFlashManager.this.f7630d != null) {
                FrontFlashManager.this.f7631e.setBackgroundColor(FrontFlashManager.this.f7635i);
                DeviceUtil.m16192a(FrontFlashManager.this.f7629c, 1.0f, 3);
            }
        }
    };

    public FrontFlashManager(Activity activity, View view) {
        this.f7629c = activity;
        this.f7630d = view;
        this.f7631e = this.f7630d.findViewById(R.id.mz_front_flash_view_bottom);
        this.f7632f = this.f7630d.findViewById(R.id.mz_front_flash_hole_cover_view);
    }

    /* renamed from: a */
    public void mo18870a(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f7627a, false, 2345, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f7634h = i;
            this.f7635i = i2;
            this.f7633g = ObjectAnimator.ofInt(this.f7631e, "backgroundColor", new int[]{this.f7634h, this.f7635i});
            this.f7633g.addListener(this.f7636j);
            this.f7633g.setEvaluator(new ArgbEvaluator());
        }
    }

    /* renamed from: a */
    public void mo18869a() {
        if (!PatchProxy.proxy(new Object[0], this, f7627a, false, 2346, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f7628b, "startFrontFlash");
            if (this.f7630d != null) {
                DeviceUtil.m16192a(this.f7629c, 1.0f, 3);
                if (DeviceHelper.f13944br && this.f7632f.getVisibility() == 8) {
                    this.f7632f.setVisibility(0);
                }
                this.f7630d.setVisibility(0);
                this.f7631e.setBackgroundColor(this.f7635i);
            }
        }
    }

    /* renamed from: b */
    public void mo18871b() {
        if (!PatchProxy.proxy(new Object[0], this, f7627a, false, 2347, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f7628b, "dismissFrontFlash");
            if (this.f7630d != null) {
                DeviceUtil.m16192a(this.f7629c, -1.0f, 3);
                this.f7630d.setVisibility(8);
            }
        }
    }
}
