package com.meizu.media.camera.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import com.meizu.media.camera.FloatWindowManager;
import com.meizu.media.camera.R;
import com.meizu.media.camera.app.AndroidServices;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class FloatThumbnailView extends LinearLayout {

    /* renamed from: a */
    public static ChangeQuickRedirect f14564a;

    /* renamed from: b */
    private static final LogUtil.C2630a f14565b = new LogUtil.C2630a("FloatThumbnailView");

    /* renamed from: c */
    private int f14566c;

    /* renamed from: d */
    private WindowManager f14567d = AndroidServices.m8287a().mo19008g();

    /* renamed from: e */
    private WindowManager.LayoutParams f14568e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FloatWindowManager.C2076b f14569f;

    /* renamed from: g */
    private float f14570g;

    /* renamed from: h */
    private float f14571h;

    /* renamed from: i */
    private float f14572i;

    /* renamed from: j */
    private float f14573j;

    /* renamed from: k */
    private float f14574k;

    /* renamed from: l */
    private float f14575l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f14576m;

    /* renamed from: n */
    private ObjectAnimator f14577n;

    public FloatThumbnailView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.mz_float_thumbnail, this);
        this.f14566c = context.getResources().getDimensionPixelSize(R.dimen.status_bar_height);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14564a, false, 8360, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f14574k = motionEvent.getX();
                this.f14575l = motionEvent.getY();
                this.f14572i = motionEvent.getRawX();
                this.f14573j = motionEvent.getRawY() - ((float) this.f14566c);
                this.f14570g = motionEvent.getRawX();
                this.f14571h = motionEvent.getRawY() - ((float) this.f14566c);
                break;
            case 1:
                if (!this.f14576m && this.f14572i == this.f14570g && this.f14573j == this.f14571h && this.f14569f != null) {
                    this.f14569f.mo17800a();
                    break;
                }
            case 2:
                this.f14570g = motionEvent.getRawX();
                this.f14571h = motionEvent.getRawY() - ((float) this.f14566c);
                if (!this.f14576m && this.f14572i <= ((float) this.f14568e.width) && this.f14573j >= ((float) ((CameraUtil.m15865b() - this.f14566c) - this.f14568e.height)) && this.f14571h - this.f14573j > 100.0f) {
                    m16429b(this.f14568e.height);
                    break;
                }
        }
        return true;
    }

    public void setParams(WindowManager.LayoutParams layoutParams) {
        this.f14568e = layoutParams;
    }

    /* renamed from: a */
    public void mo22867a() {
        if (!PatchProxy.proxy(new Object[0], this, f14564a, false, 8362, new Class[0], Void.TYPE).isSupported && this.f14568e != null) {
            m16429b(this.f14568e.height);
        }
    }

    /* renamed from: b */
    private void m16429b(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f14564a, false, 8363, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15952c(f14565b, "doDismissAnim");
            if (this.f14577n != null) {
                this.f14577n.cancel();
            }
            final View findViewById = findViewById(R.id.thumbnail_window_layout);
            this.f14577n = ObjectAnimator.ofInt(findViewById, "translationY", new int[]{0, i}).setDuration(336);
            this.f14577n.setInterpolator(new PathInterpolator(0.54f, 0.08f, 0.62f, 1.0f));
            this.f14577n.addListener(new Animator.AnimatorListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14578a;

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f14578a, false, 8366, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                        boolean unused = FloatThumbnailView.this.f14576m = true;
                        if (FloatThumbnailView.this.f14569f != null) {
                            FloatThumbnailView.this.f14569f.mo17803d();
                        }
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f14578a, false, 8367, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                        boolean unused = FloatThumbnailView.this.f14576m = false;
                        if (FloatThumbnailView.this.f14569f != null) {
                            FloatThumbnailView.this.f14569f.mo17804e();
                        }
                    }
                }
            });
            this.f14577n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14580a;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!PatchProxy.proxy(new Object[]{valueAnimator}, this, f14580a, false, 8368, new Class[]{ValueAnimator.class}, Void.TYPE).isSupported) {
                        findViewById.setTranslationY((float) ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            });
            this.f14577n.start();
        }
    }

    /* renamed from: a */
    public void mo22868a(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f14564a, false, 8364, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            LogUtil.m15952c(f14565b, "doShowAnim");
            if (this.f14577n != null) {
                this.f14577n.cancel();
            }
            final View findViewById = findViewById(R.id.thumbnail_window_layout);
            this.f14577n = ObjectAnimator.ofInt(findViewById, "translationY", new int[]{i, 0}).setDuration(336);
            this.f14577n.setInterpolator(new PathInterpolator(0.08f, 0.19f, 0.2f, 0.98f));
            this.f14577n.addListener(new Animator.AnimatorListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14583a;

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f14583a, false, 8369, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                        boolean unused = FloatThumbnailView.this.f14576m = true;
                        if (FloatThumbnailView.this.f14569f != null) {
                            FloatThumbnailView.this.f14569f.mo17801b();
                        }
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f14583a, false, 8370, new Class[]{Animator.class}, Void.TYPE).isSupported) {
                        boolean unused = FloatThumbnailView.this.f14576m = false;
                        if (FloatThumbnailView.this.f14569f != null) {
                            FloatThumbnailView.this.f14569f.mo17802c();
                        }
                    }
                }
            });
            this.f14577n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14585a;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!PatchProxy.proxy(new Object[]{valueAnimator}, this, f14585a, false, 8371, new Class[]{ValueAnimator.class}, Void.TYPE).isSupported) {
                        findViewById.setTranslationY((float) ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            });
            this.f14577n.start();
        }
    }

    public void setListener(FloatWindowManager.C2076b bVar) {
        this.f14569f = bVar;
    }

    /* renamed from: b */
    public void mo22869b() {
        if (!PatchProxy.proxy(new Object[0], this, f14564a, false, 8365, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15952c(f14565b, "cancelAnim");
            if (this.f14577n != null) {
                this.f14577n.cancel();
            }
            findViewById(R.id.thumbnail_window_layout).setTranslationY(0.0f);
        }
    }
}
