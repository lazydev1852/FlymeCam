package com.meizu.media.camera.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.animation.o */
public class ThumbnailAnimManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f7858a;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final LogUtil.C2630a f7859j = new LogUtil.C2630a("ThumbnailAnim");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f7860b;

    /* renamed from: c */
    private View f7861c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f7862d;

    /* renamed from: e */
    private boolean f7863e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f7864f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f7865g;

    /* renamed from: h */
    private AnimatorSet f7866h;

    /* renamed from: i */
    private AnimatorSet f7867i;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C1823b f7868k;

    /* renamed from: l */
    private C1822a f7869l;

    /* renamed from: com.meizu.media.camera.animation.o$a */
    /* compiled from: ThumbnailAnimManager */
    public interface C1822a {
        /* renamed from: a */
        void mo18973a();
    }

    /* renamed from: com.meizu.media.camera.animation.o$b */
    /* compiled from: ThumbnailAnimManager */
    public interface C1823b {
        /* renamed from: a */
        void mo18974a();

        /* renamed from: a */
        void mo18975a(boolean z);
    }

    public ThumbnailAnimManager(View view, View view2) {
        this.f7860b = view;
        this.f7861c = view2;
    }

    /* renamed from: a */
    public void mo18966a(C1823b bVar) {
        this.f7868k = bVar;
    }

    /* renamed from: a */
    public void mo18965a(C1822a aVar) {
        this.f7869l = aVar;
    }

    /* renamed from: a */
    public void mo18964a() {
        if (!PatchProxy.proxy(new Object[0], this, f7858a, false, 2460, new Class[0], Void.TYPE).isSupported) {
            this.f7865g = true;
            this.f7864f = false;
            if (!this.f7862d) {
                mo18969c();
            }
        }
    }

    /* renamed from: a */
    public void mo18967a(boolean z) {
        this.f7865g = false;
        this.f7864f = z;
    }

    /* renamed from: b */
    public boolean mo18968b() {
        return this.f7865g;
    }

    /* renamed from: c */
    public void mo18969c() {
        if (!PatchProxy.proxy(new Object[0], this, f7858a, false, 2461, new Class[0], Void.TYPE).isSupported) {
            if (this.f7860b.getVisibility() != 0) {
                LogUtil.m15942a(f7859j, "thumbnail is GONE");
                return;
            }
            this.f7863e = false;
            this.f7862d = false;
            LogUtil.m15942a(f7859j, "startDisappearAnim: ");
            if (this.f7866h != null) {
                this.f7866h.removeAllListeners();
                this.f7866h.end();
            }
            if (this.f7867i != null) {
                this.f7867i.removeAllListeners();
                this.f7867i.end();
            }
            m8214a(this.f7860b);
            m8214a(this.f7861c);
        }
    }

    /* renamed from: d */
    public void mo18970d() {
        if (!PatchProxy.proxy(new Object[0], this, f7858a, false, 2462, new Class[0], Void.TYPE).isSupported) {
            this.f7863e = true;
            LogUtil.C2630a aVar = f7859j;
            LogUtil.m15942a(aVar, "startShowAnim:  mIsShowAnimStart = " + this.f7862d);
            if (!this.f7862d) {
                if (this.f7866h != null) {
                    this.f7866h.removeAllListeners();
                    this.f7866h.end();
                }
                if (this.f7867i != null) {
                    this.f7867i.removeAllListeners();
                    this.f7867i.end();
                }
                this.f7866h = m8216b(this.f7860b);
                this.f7867i = m8216b(this.f7861c);
                this.f7866h.start();
                this.f7867i.start();
            }
        }
    }

    /* renamed from: a */
    private void m8214a(View view) {
        if (!PatchProxy.proxy(new Object[]{view}, this, f7858a, false, 2463, new Class[]{View.class}, Void.TYPE).isSupported) {
            if (this.f7869l != null) {
                this.f7869l.mo18973a();
            }
            if (view != null) {
                view.setVisibility(8);
            }
            if (view == this.f7860b) {
                LogUtil.m15942a(f7859j, "DisappearAnimEnd: ");
                if (this.f7863e && !this.f7862d) {
                    mo18970d();
                }
            }
        }
    }

    /* renamed from: b */
    private AnimatorSet m8216b(final View view) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view}, this, f7858a, false, 2464, new Class[]{View.class}, AnimatorSet.class);
        if (proxy.isSupported) {
            return (AnimatorSet) proxy.result;
        }
        view.setAlpha(0.0f);
        view.setScaleX(0.7f);
        view.setScaleY(0.7f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", new float[]{0.7f, 1.0f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{0.7f, 1.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f));
        animatorSet.setDuration(200);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.addListener(new AnimatorListenerAdapter() {

            /* renamed from: a */
            public static ChangeQuickRedirect f7870a;

            public void onAnimationStart(Animator animator) {
                if (!PatchProxy.proxy(new Object[]{animator}, this, f7870a, false, 2465, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                    super.onAnimationStart(animator);
                    if (view == ThumbnailAnimManager.this.f7860b) {
                        LogUtil.m15942a(ThumbnailAnimManager.f7859j, "ShowAnimationStart: ");
                        boolean unused = ThumbnailAnimManager.this.f7862d = true;
                        ThumbnailAnimManager.this.f7868k.mo18975a(ThumbnailAnimManager.this.f7864f);
                    }
                }
            }

            public void onAnimationEnd(Animator animator) {
                if (!PatchProxy.proxy(new Object[]{animator}, this, f7870a, false, 2466, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                    super.onAnimationEnd(animator);
                    if (view == ThumbnailAnimManager.this.f7860b) {
                        LogUtil.m15942a(ThumbnailAnimManager.f7859j, "ShowAnimationEnd: ");
                        boolean unused = ThumbnailAnimManager.this.f7862d = false;
                        boolean unused2 = ThumbnailAnimManager.this.f7864f = false;
                        ThumbnailAnimManager.this.f7868k.mo18974a();
                        if (ThumbnailAnimManager.this.f7865g) {
                            ThumbnailAnimManager.this.mo18969c();
                        }
                    }
                }
            }
        });
        return animatorSet;
    }
}
