package com.meizu.media.camera.animation;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.animation.h */
public class SettingAnimManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f7713a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Animation f7714b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Animation f7715c;

    /* renamed from: d */
    private Animation f7716d;

    /* renamed from: e */
    private Animation f7717e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final View f7718f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final View f7719g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f7720h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C1808a f7721i;

    /* renamed from: com.meizu.media.camera.animation.h$a */
    /* compiled from: SettingAnimManager */
    public interface C1808a {
        /* renamed from: a */
        void mo18915a();

        /* renamed from: b */
        void mo18916b();
    }

    public SettingAnimManager(Context context, View view, View view2) {
        this.f7714b = AnimationUtils.loadAnimation(context, R.anim.mz_setting_enter);
        this.f7715c = AnimationUtils.loadAnimation(context, R.anim.mz_setting_exit);
        this.f7716d = AnimationUtils.loadAnimation(context, R.anim.mz_setting_bg_exit);
        this.f7717e = AnimationUtils.loadAnimation(context, R.anim.mz_setting_bg_enter);
        this.f7718f = view;
        this.f7719g = view2;
        this.f7714b.setAnimationListener(new Animation.AnimationListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f7722a;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f7722a, false, 2387, new Class[]{Animation.class}, Void.TYPE).isSupported && SettingAnimManager.this.f7719g != null) {
                    SettingAnimManager.this.f7719g.setVisibility(0);
                }
            }
        });
        this.f7715c.setAnimationListener(new Animation.AnimationListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f7724a;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f7724a, false, 2388, new Class[]{Animation.class}, Void.TYPE).isSupported && SettingAnimManager.this.f7721i != null) {
                    SettingAnimManager.this.f7721i.mo18915a();
                }
            }

            public void onAnimationEnd(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f7724a, false, 2389, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                    if (SettingAnimManager.this.f7719g != null) {
                        SettingAnimManager.this.f7719g.setVisibility(4);
                    }
                    if (SettingAnimManager.this.f7721i != null) {
                        SettingAnimManager.this.f7721i.mo18916b();
                    }
                }
            }
        });
        this.f7716d.setAnimationListener(new Animation.AnimationListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f7726a;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f7726a, false, 2390, new Class[]{Animation.class}, Void.TYPE).isSupported && SettingAnimManager.this.f7719g != null) {
                    SettingAnimManager.this.f7719g.startAnimation(SettingAnimManager.this.f7715c);
                    boolean unused = SettingAnimManager.this.f7720h = true;
                }
            }

            public void onAnimationEnd(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f7726a, false, 2391, new Class[]{Animation.class}, Void.TYPE).isSupported && SettingAnimManager.this.f7718f != null) {
                    SettingAnimManager.this.f7718f.setVisibility(4);
                    boolean unused = SettingAnimManager.this.f7720h = false;
                }
            }
        });
        this.f7717e.setAnimationListener(new Animation.AnimationListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f7728a;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f7728a, false, 2392, new Class[]{Animation.class}, Void.TYPE).isSupported && SettingAnimManager.this.f7719g != null) {
                    SettingAnimManager.this.f7719g.startAnimation(SettingAnimManager.this.f7714b);
                    boolean unused = SettingAnimManager.this.f7720h = true;
                }
            }

            public void onAnimationEnd(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f7728a, false, 2393, new Class[]{Animation.class}, Void.TYPE).isSupported && SettingAnimManager.this.f7718f != null) {
                    SettingAnimManager.this.f7718f.setVisibility(0);
                    boolean unused = SettingAnimManager.this.f7720h = false;
                }
            }
        });
    }

    /* renamed from: a */
    public void mo18899a() {
        if (!PatchProxy.proxy(new Object[0], this, f7713a, false, 2385, new Class[0], Void.TYPE).isSupported && this.f7718f != null && !this.f7720h) {
            this.f7718f.startAnimation(this.f7717e);
        }
    }

    /* renamed from: b */
    public void mo18901b() {
        if (!PatchProxy.proxy(new Object[0], this, f7713a, false, 2386, new Class[0], Void.TYPE).isSupported && this.f7718f != null && !this.f7720h) {
            this.f7718f.startAnimation(this.f7716d);
        }
    }

    /* renamed from: c */
    public boolean mo18902c() {
        return this.f7720h;
    }

    /* renamed from: a */
    public void mo18900a(C1808a aVar) {
        this.f7721i = aVar;
    }
}
