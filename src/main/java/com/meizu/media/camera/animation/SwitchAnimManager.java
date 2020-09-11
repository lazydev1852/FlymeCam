package com.meizu.media.camera.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import com.meizu.camera.effectlib.effects.views.PreviewView;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.media.camera.views.MzImageView;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.animation.l */
public class SwitchAnimManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f7800a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f7801b = new LogUtil.C2630a("SwitchAnimManager");

    /* renamed from: c */
    private static final PathInterpolator f7802c = new PathInterpolator(0.5f, 0.0f, 0.87f, 1.0f);

    /* renamed from: d */
    private static final PathInterpolator f7803d = new PathInterpolator(0.13f, 0.0f, 0.05f, 1.0f);

    /* renamed from: e */
    private static final PathInterpolator f7804e = new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f);

    /* renamed from: f */
    private static final PathInterpolator f7805f = new PathInterpolator(0.3f, 0.0f, 0.66f, 1.0f);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static boolean f7806g = true;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static boolean f7807h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static boolean f7808i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static ObjectAnimator f7809j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static ObjectAnimator f7810k;

    /* renamed from: a */
    public static boolean m8192a(final View view, long j, final Animation.AnimationListener animationListener, final Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view, new Long(j), animationListener, bitmap}, (Object) null, f7800a, true, 2436, new Class[]{View.class, Long.TYPE, Animation.AnimationListener.class, Bitmap.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = f7801b;
        LogUtil.m15942a(aVar, "slidingIn animView visible:" + view.getVisibility() + ",mIsAnimShowing:" + f7807h + ",mAnimSwitch:" + f7806g);
        if (view == null || f7807h || !f7806g) {
            return false;
        }
        f7807h = true;
        if (view.getVisibility() == 0) {
            if (f7810k != null && f7810k.isRunning()) {
                f7810k.cancel();
            } else if (!f7808i) {
                return false;
            }
        }
        f7809j = ObjectAnimator.ofFloat(view, "Alpha", new float[]{view.getAlpha(), 1.0f});
        f7809j.setDuration(j);
        f7809j.setInterpolator(f7804e);
        f7809j.addListener(new Animator.AnimatorListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f7811a;

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                if (!PatchProxy.proxy(new Object[]{animator}, this, f7811a, false, 2443, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                    LogUtil.C2630a d = SwitchAnimManager.f7801b;
                    LogUtil.m15942a(d, "sliding in onAnimationStart start animView visible:" + view.getVisibility() + ",animView alpha:" + view.getAlpha() + ",bitmap :" + bitmap);
                    if (view.getVisibility() == 8) {
                        view.setAlpha(0.0f);
                        view.setVisibility(0);
                    }
                    ((MzImageView) view).setImageBitmap(bitmap);
                    if (animationListener != null) {
                        animationListener.onAnimationStart((Animation) null);
                    }
                    LogUtil.C2630a d2 = SwitchAnimManager.f7801b;
                    LogUtil.m15942a(d2, "sliding in onAnimationStart end anim view visible:" + view.getVisibility());
                }
            }

            public void onAnimationEnd(Animator animator) {
                if (!PatchProxy.proxy(new Object[]{animator}, this, f7811a, false, 2444, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                    LogUtil.m15942a(SwitchAnimManager.f7801b, "sliding in onAnimationEnd");
                    ObjectAnimator unused = SwitchAnimManager.f7809j = null;
                    if (animationListener != null) {
                        animationListener.onAnimationEnd((Animation) null);
                    }
                    boolean unused2 = SwitchAnimManager.f7807h = false;
                }
            }

            public void onAnimationCancel(Animator animator) {
                if (!PatchProxy.proxy(new Object[]{animator}, this, f7811a, false, 2445, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                    LogUtil.m15942a(SwitchAnimManager.f7801b, "sliding in onAnimationCancel");
                    ObjectAnimator unused = SwitchAnimManager.f7809j = null;
                    animationListener.onAnimationEnd((Animation) null);
                    boolean unused2 = SwitchAnimManager.f7807h = false;
                }
            }
        });
        f7809j.start();
        LogUtil.C2630a aVar2 = f7801b;
        LogUtil.m15942a(aVar2, "mSlidingInAnimator running:" + f7809j.isRunning());
        return true;
    }

    /* renamed from: a */
    public static boolean m8191a(View view) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{view}, (Object) null, f7800a, true, 2437, new Class[]{View.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        LogUtil.C2630a aVar = f7801b;
        LogUtil.m15942a(aVar, "canDoShowingAnim animView visible:" + view.getVisibility() + ",mIsAnimShowing:" + f7807h + ",mAnimSwitch:" + f7806g + ",mIsAnimhiding:" + f7808i);
        if (!f7806g || f7807h || (view.getVisibility() == 0 && !f7808i)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m8193a(View view, PreviewView cVar, View view2, ViewGroup viewGroup, float f, float f2, Animation.AnimationListener animationListener, Animation.AnimationListener animationListener2, Bitmap bitmap) {
        final View view3 = view;
        final Animation.AnimationListener animationListener3 = animationListener2;
        Bitmap bitmap2 = bitmap;
        Object[] objArr = {view3, cVar, view2, viewGroup, new Float(f), new Float(f2), animationListener, animationListener3, bitmap2};
        ChangeQuickRedirect changeQuickRedirect = f7800a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 2438, new Class[]{View.class, PreviewView.class, View.class, ViewGroup.class, Float.TYPE, Float.TYPE, Animation.AnimationListener.class, Animation.AnimationListener.class, Bitmap.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (view3 == null || !f7806g || f7807h) {
            return false;
        }
        f7807h = true;
        if (view.getVisibility() != 0) {
            ((MzImageView) view3).setImageBitmap(bitmap2);
        } else if (f7810k != null && f7810k.isRunning()) {
            f7810k.cancel();
        }
        final PreviewView cVar2 = cVar;
        final View view4 = view2;
        final ViewGroup viewGroup2 = viewGroup;
        final View view5 = view;
        final Animation.AnimationListener animationListener4 = animationListener;
        final float f3 = f;
        final float f4 = f2;
        final C18172 r8 = new Animation.AnimationListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f7815a;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f7815a, false, 2446, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                    LogUtil.m15942a(SwitchAnimManager.f7801b, "applySecondRotation onAnimationStart");
                    if (animationListener3 != null) {
                        animationListener3.onAnimationStart(animation);
                    }
                }
            }

            public void onAnimationEnd(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f7815a, false, 2447, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                    LogUtil.m15942a(SwitchAnimManager.f7801b, "applySecondRotation onAnimationEnd");
                    if (animationListener3 != null) {
                        animationListener3.onAnimationEnd(animation);
                    }
                    view3.setAlpha(1.0f);
                    boolean unused = SwitchAnimManager.f7807h = false;
                }
            }
        };
        C18183 r0 = new Animation.AnimationListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f7818a;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f7818a, false, 2448, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                    LogUtil.m15942a(SwitchAnimManager.f7801b, "applyRotation onAnimationStart");
                    cVar2.setViewAlpha(0.01f);
                    if (view4 != null) {
                        view4.setAlpha(0.01f);
                    }
                    if (viewGroup2 != null) {
                        viewGroup2.setAlpha(0.01f);
                    }
                    view5.setAlpha(1.0f);
                    view5.setVisibility(0);
                    if (animationListener4 != null) {
                        animationListener4.onAnimationStart(animation);
                    }
                }
            }

            public void onAnimationEnd(Animation animation) {
                if (!PatchProxy.proxy(new Object[]{animation}, this, f7818a, false, 2449, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                    LogUtil.m15942a(SwitchAnimManager.f7801b, "applyRotation onAnimationEnd");
                    if (animationListener4 != null) {
                        animationListener4.onAnimationEnd(animation);
                    }
                    if (SwitchAnimManager.f7806g) {
                        view5.setAlpha(0.8f);
                        view5.clearAnimation();
                        SwitchAnimManager.m8200c(view5, 90.0f, 0.0f, f3, f4, r8);
                        return;
                    }
                    boolean unused = SwitchAnimManager.f7807h = false;
                }
            }
        };
        view.clearAnimation();
        m8196b(view, 360.0f, 270.0f, f, f2, r0);
        return true;
    }

    /* renamed from: b */
    private static void m8196b(View view, float f, float f2, float f3, float f4, Animation.AnimationListener animationListener) {
        View view2 = view;
        Animation.AnimationListener animationListener2 = animationListener;
        Object[] objArr = {view2, new Float(f), new Float(f2), new Float(f3), new Float(f4), animationListener2};
        ChangeQuickRedirect changeQuickRedirect = f7800a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 2439, new Class[]{View.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Animation.AnimationListener.class}, Void.TYPE).isSupported) {
            if (f7806g) {
                ThreeDRotateAnimation mVar = new ThreeDRotateAnimation(f, f2, f3, f4, 857.0f, true, f7802c);
                mVar.setDuration(160);
                mVar.setInterpolator(f7802c);
                mVar.setAnimationListener(animationListener2);
                mVar.setFillAfter(true);
                view2.startAnimation(mVar);
                LogUtil.m15942a(f7801b, "applyRotation");
                return;
            }
            f7807h = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m8200c(View view, float f, float f2, float f3, float f4, Animation.AnimationListener animationListener) {
        View view2 = view;
        Animation.AnimationListener animationListener2 = animationListener;
        if (!PatchProxy.proxy(new Object[]{view2, new Float(f), new Float(f2), new Float(f3), new Float(f4), animationListener2}, (Object) null, f7800a, true, 2440, new Class[]{View.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Animation.AnimationListener.class}, Void.TYPE).isSupported) {
            if (f7806g) {
                ThreeDRotateAnimation mVar = new ThreeDRotateAnimation(f, f2, f3, f4, 857.0f, false, f7803d);
                mVar.setDuration(240);
                mVar.setInterpolator(f7803d);
                mVar.setAnimationListener(animationListener2);
                mVar.setFillAfter(false);
                view2.startAnimation(mVar);
                LogUtil.m15942a(f7801b, "applySecondRotation");
                return;
            }
            f7807h = false;
        }
    }

    /* renamed from: a */
    public static boolean m8194a(View view, PreviewView cVar, View view2, ViewGroup viewGroup, float f, long j, boolean z, boolean z2, Animation.AnimationListener animationListener) {
        final View view3 = view;
        PreviewView cVar2 = cVar;
        View view4 = view2;
        ViewGroup viewGroup2 = viewGroup;
        long j2 = j;
        boolean z3 = z;
        boolean z4 = z2;
        final Animation.AnimationListener animationListener2 = animationListener;
        Object[] objArr = {view3, cVar2, view4, viewGroup2, new Float(f), new Long(j2), new Byte(z3 ? (byte) 1 : 0), new Byte(z4 ? (byte) 1 : 0), animationListener2};
        ChangeQuickRedirect changeQuickRedirect = f7800a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 2441, new Class[]{View.class, PreviewView.class, View.class, ViewGroup.class, Float.TYPE, Long.TYPE, Boolean.TYPE, Boolean.TYPE, Animation.AnimationListener.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (view3 == null || !f7806g || f7807h || f7808i || view.getVisibility() != 0) {
            if (view4 != null && z3) {
                view4.setAlpha(1.0f);
            }
            return false;
        }
        f7808i = true;
        cVar2.setViewAlpha(1.0f);
        if (view4 != null && z3) {
            view4.setAlpha(1.0f);
        }
        if (viewGroup2 != null && z4) {
            viewGroup2.setAlpha(1.0f);
        }
        f7810k = ObjectAnimator.ofFloat(view3, "Alpha", new float[]{view.getAlpha(), 0.0f});
        f7810k.setDuration(j2);
        f7810k.setInterpolator(f7805f);
        f7810k.addListener(new Animator.AnimatorListener() {

            /* renamed from: a */
            public static ChangeQuickRedirect f7827a;

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                if (!PatchProxy.proxy(new Object[]{animator}, this, f7827a, false, 2450, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                    LogUtil.m15942a(SwitchAnimManager.f7801b, "sliding out onAnimationStart");
                    if (SwitchAnimManager.f7807h) {
                        boolean unused = SwitchAnimManager.f7808i = false;
                        ObjectAnimator unused2 = SwitchAnimManager.f7810k = null;
                    } else if (animationListener2 != null) {
                        animationListener2.onAnimationStart((Animation) null);
                    }
                }
            }

            public void onAnimationEnd(Animator animator) {
                if (!PatchProxy.proxy(new Object[]{animator}, this, f7827a, false, 2451, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                    LogUtil.m15942a(SwitchAnimManager.f7801b, "sliding out onAnimationEnd");
                    if (SwitchAnimManager.f7807h) {
                        boolean unused = SwitchAnimManager.f7808i = false;
                        ObjectAnimator unused2 = SwitchAnimManager.f7810k = null;
                        return;
                    }
                    if (animationListener2 != null) {
                        animationListener2.onAnimationEnd((Animation) null);
                    }
                    view3.setVisibility(8);
                    boolean unused3 = SwitchAnimManager.f7808i = false;
                    ObjectAnimator unused4 = SwitchAnimManager.f7810k = null;
                    LogUtil.m15942a(SwitchAnimManager.f7801b, "sliding out onAnimationEnd animView.setVisibility(View.GONE)");
                }
            }

            public void onAnimationCancel(Animator animator) {
                if (!PatchProxy.proxy(new Object[]{animator}, this, f7827a, false, 2452, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                    LogUtil.m15942a(SwitchAnimManager.f7801b, "sliding out onAnimationCancel");
                    if (animationListener2 != null) {
                        animationListener2.onAnimationEnd((Animation) null);
                    }
                    boolean unused = SwitchAnimManager.f7808i = false;
                    ObjectAnimator unused2 = SwitchAnimManager.f7810k = null;
                }
            }
        });
        f7810k.start();
        return true;
    }

    /* renamed from: a */
    public static boolean m8190a() {
        return f7808i;
    }

    /* renamed from: b */
    public static boolean m8197b() {
        return f7807h;
    }

    /* renamed from: a */
    public static void m8189a(boolean z) {
        f7806g = z;
    }

    /* renamed from: c */
    public static void m8199c() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, f7800a, true, 2442, new Class[0], Void.TYPE).isSupported) {
            if (f7809j != null) {
                f7807h = false;
                f7808i = false;
                f7809j.removeAllListeners();
            }
            if (f7810k != null) {
                f7807h = false;
                f7808i = false;
                f7810k.removeAllListeners();
            }
        }
    }
}
