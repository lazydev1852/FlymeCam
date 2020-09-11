package com.meizu.media.camera.animation;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import androidx.core.view.ViewCompat;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.animation.k */
public class SquareAnimManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f7778a;

    /* renamed from: b */
    private View f7779b;

    /* renamed from: c */
    private View f7780c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f7781d;

    /* renamed from: e */
    private View f7782e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f7783f;

    /* renamed from: g */
    private int f7784g = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: h */
    private int f7785h = Integer.MIN_VALUE;

    public SquareAnimManager(View view, View view2, View view3, View view4) {
        this.f7779b = view;
        this.f7780c = view2;
        this.f7781d = view3;
        this.f7782e = view4;
    }

    /* renamed from: a */
    private void m8181a(boolean z, boolean z2) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)}, this, f7778a, false, 2422, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f7779b.startAnimation(m8180a(true, z, this.f7779b));
            this.f7780c.startAnimation(m8180a(false, z, this.f7780c));
            if (z2) {
                this.f7781d.postDelayed(new Runnable() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f7786a;

                    public void run() {
                        if (!PatchProxy.proxy(new Object[0], this, f7786a, false, 2431, new Class[0], Void.TYPE).isSupported) {
                            SquareAnimManager.this.f7781d.startAnimation(SquareAnimManager.this.m8178a(SquareAnimManager.this.f7781d));
                        }
                    }
                }, 50);
            }
            this.f7783f = true;
        }
    }

    /* renamed from: a */
    private void m8182a(boolean z, boolean z2, boolean z3) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), new Byte(z3 ? (byte) 1 : 0)}, this, f7778a, false, 2423, new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f7779b.startAnimation(m8184b(true, z, this.f7779b));
            this.f7780c.startAnimation(m8184b(false, z, this.f7780c));
            if (this.f7781d.getVisibility() != 0 || !z2) {
                this.f7781d.setVisibility(4);
            } else {
                this.f7781d.startAnimation(m8183b(this.f7781d));
            }
            this.f7783f = false;
        }
    }

    /* renamed from: a */
    public void mo18930a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), new Byte(z3 ? (byte) 1 : 0), new Byte(z4 ? (byte) 1 : 0)}, this, f7778a, false, 2424, new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                m8181a(z2, z3);
            } else {
                m8182a(z2, z3, z4);
            }
        }
    }

    /* renamed from: a */
    private AnimationSet m8180a(boolean z, boolean z2, View view) {
        boolean z3 = z;
        boolean z4 = z2;
        final View view2 = view;
        Object[] objArr = {new Byte(z3 ? (byte) 1 : 0), new Byte(z4 ? (byte) 1 : 0), view2};
        ChangeQuickRedirect changeQuickRedirect = f7778a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 2425, new Class[]{Boolean.TYPE, Boolean.TYPE, View.class}, AnimationSet.class);
        if (proxy.isSupported) {
            return (AnimationSet) proxy.result;
        }
        AnimationSet animationSet = new AnimationSet(true);
        if (z3) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
            animationSet.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.08f, 1.0f));
            animationSet.setDuration(384);
            animationSet.addAnimation(scaleAnimation);
            if (z4) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 1.0f);
                animationSet.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f));
                animationSet.setDuration(384);
                animationSet.addAnimation(alphaAnimation);
            }
        } else {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 0.0f, 1, 1.0f);
            animationSet.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.08f, 1.0f));
            animationSet.setDuration(384);
            animationSet.addAnimation(scaleAnimation2);
            if (z4) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.8f, 1.0f);
                animationSet.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f));
                animationSet.setDuration(384);
                animationSet.addAnimation(alphaAnimation2);
            }
        }
        animationSet.setAnimationListener(new Animation.AnimationListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f7788a;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f7788a, false, 2432, new Class[]{Animation.class}, Void.TYPE).isSupported && view2 != null) {
                    view2.setVisibility(0);
                }
            }
        });
        return animationSet;
    }

    /* renamed from: b */
    private AnimationSet m8184b(boolean z, boolean z2, View view) {
        boolean z3 = z;
        boolean z4 = z2;
        final View view2 = view;
        Object[] objArr = {new Byte(z3 ? (byte) 1 : 0), new Byte(z4 ? (byte) 1 : 0), view2};
        ChangeQuickRedirect changeQuickRedirect = f7778a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 2426, new Class[]{Boolean.TYPE, Boolean.TYPE, View.class}, AnimationSet.class);
        if (proxy.isSupported) {
            return (AnimationSet) proxy.result;
        }
        AnimationSet animationSet = new AnimationSet(true);
        if (z3) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
            animationSet.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.08f, 1.0f));
            animationSet.setDuration(384);
            animationSet.addAnimation(scaleAnimation);
            if (z4) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.8f);
                animationSet.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f));
                animationSet.setDuration(384);
                animationSet.addAnimation(alphaAnimation);
            }
        } else {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 0.0f, 1, 1.0f);
            animationSet.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.08f, 1.0f));
            animationSet.setDuration(384);
            animationSet.addAnimation(scaleAnimation2);
            if (z4) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.8f);
                animationSet.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f));
                animationSet.setDuration(384);
                animationSet.addAnimation(alphaAnimation2);
            }
        }
        animationSet.setAnimationListener(new Animation.AnimationListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f7791a;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f7791a, false, 2433, new Class[]{Animation.class}, Void.TYPE).isSupported && view2 != null) {
                    view2.setVisibility(4);
                }
            }
        });
        return animationSet;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public AlphaAnimation m8178a(final View view) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view}, this, f7778a, false, 2427, new Class[]{View.class}, AlphaAnimation.class);
        if (proxy.isSupported) {
            return (AlphaAnimation) proxy.result;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f));
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f7794a;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f7794a, false, 2434, new Class[]{Animation.class}, Void.TYPE).isSupported && view != null && SquareAnimManager.this.f7783f) {
                    view.setVisibility(0);
                }
            }
        });
        alphaAnimation.setDuration(336);
        return alphaAnimation;
    }

    /* renamed from: b */
    private AlphaAnimation m8183b(final View view) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view}, this, f7778a, false, 2428, new Class[]{View.class}, AlphaAnimation.class);
        if (proxy.isSupported) {
            return (AlphaAnimation) proxy.result;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new PathInterpolator(0.16f, 0.0f, 0.66f, 1.0f));
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f7797a;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f7797a, false, 2435, new Class[]{Animation.class}, Void.TYPE).isSupported && view != null && !SquareAnimManager.this.f7783f) {
                    view.setVisibility(4);
                }
            }
        });
        alphaAnimation.setDuration(90);
        return alphaAnimation;
    }
}
