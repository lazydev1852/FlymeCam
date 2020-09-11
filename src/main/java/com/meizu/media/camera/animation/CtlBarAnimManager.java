package com.meizu.media.camera.animation;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;

/* renamed from: com.meizu.media.camera.animation.a */
public class CtlBarAnimManager {

    /* renamed from: a */
    public static ChangeQuickRedirect f7602a;

    /* renamed from: b */
    LogUtil.C2630a f7603b = new LogUtil.C2630a("CtlBarAnimManager");

    /* renamed from: c */
    private Context f7604c;

    /* renamed from: d */
    private Animation f7605d;

    /* renamed from: e */
    private Animation f7606e;

    /* renamed from: f */
    private C1799b f7607f;

    /* renamed from: g */
    private C1799b f7608g;

    /* renamed from: h */
    private long f7609h;

    /* renamed from: i */
    private long f7610i;

    /* renamed from: j */
    private AnimationDrawable f7611j;

    /* renamed from: k */
    private int f7612k;

    /* renamed from: l */
    private int f7613l;

    /* renamed from: m */
    private int f7614m;

    /* renamed from: n */
    private int f7615n;

    /* renamed from: o */
    private int f7616o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public C1798a f7617p = null;

    /* renamed from: com.meizu.media.camera.animation.a$a */
    /* compiled from: CtlBarAnimManager */
    public interface C1798a {
        /* renamed from: a */
        void mo18863a(Animation animation);

        /* renamed from: b */
        void mo18864b(Animation animation);
    }

    public CtlBarAnimManager(Context context) {
        this.f7604c = context;
        m8074a(context);
        m8073a();
    }

    /* renamed from: a */
    private void m8074a(Context context) {
        if (!PatchProxy.proxy(new Object[]{context}, this, f7602a, false, 2336, new Class[]{Context.class}, Void.TYPE).isSupported) {
            this.f7605d = AnimationUtils.loadAnimation(context, R.anim.mz_ctrl_bar_button_show);
            this.f7606e = AnimationUtils.loadAnimation(context, R.anim.mz_ctrl_bar_button_disappear);
            this.f7607f = new C1799b(true);
            this.f7608g = new C1799b(false);
            this.f7605d.setAnimationListener(this.f7607f);
            this.f7606e.setAnimationListener(this.f7608g);
            this.f7609h = this.f7605d.getDuration();
            this.f7610i = this.f7606e.getDuration();
        }
    }

    /* renamed from: a */
    private void m8073a() {
        this.f7612k = R.drawable.mz_record_start;
        this.f7613l = R.drawable.mz_record_stop;
        this.f7615n = R.drawable.mz_pano_start;
        this.f7616o = R.drawable.mz_pano_stop;
        this.f7614m = R.drawable.mz_btn_record_start_default;
    }

    /* renamed from: a */
    public void mo18861a(View[] viewArr, View[] viewArr2, boolean z) {
        if (!PatchProxy.proxy(new Object[]{viewArr, viewArr2, new Byte(z ? (byte) 1 : 0)}, this, f7602a, false, 2337, new Class[]{View[].class, View[].class, Boolean.TYPE}, Void.TYPE).isSupported) {
            LogUtil.C2630a aVar = this.f7603b;
            LogUtil.m15942a(aVar, "doAnim useAnim:" + z);
            if (z) {
                this.f7606e.setDuration(this.f7610i);
                this.f7605d.setDuration(this.f7609h);
                m8076a(viewArr2, this.f7606e, this.f7608g);
                m8076a(viewArr, this.f7605d, this.f7607f);
                return;
            }
            m8075a(viewArr2, 4);
            m8075a(viewArr, 0);
        }
    }

    /* renamed from: a */
    public void mo18860a(View[] viewArr, View[] viewArr2, long j) {
        Object[] objArr = {viewArr, viewArr2, new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f7602a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 2338, new Class[]{View[].class, View[].class, Long.TYPE}, Void.TYPE).isSupported) {
            this.f7606e.setDuration(j);
            this.f7605d.setDuration(j);
            m8076a(viewArr2, this.f7606e, this.f7608g);
            m8076a(viewArr, this.f7605d, this.f7607f);
        }
    }

    /* renamed from: a */
    public void mo18858a(final ImageView imageView, final boolean z, final boolean z2, boolean z3) {
        if (!PatchProxy.proxy(new Object[]{imageView, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), new Byte(z3 ? (byte) 1 : 0)}, this, f7602a, false, 2339, new Class[]{ImageView.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            if (z) {
                imageView.setImageResource(z2 ? this.f7615n : this.f7612k);
            } else {
                imageView.setImageResource(z2 ? this.f7616o : z3 ? this.f7613l : this.f7614m);
            }
            if (z3) {
                Drawable drawable = imageView.getDrawable();
                if (drawable instanceof AnimationDrawable) {
                    this.f7611j = (AnimationDrawable) drawable;
                    this.f7611j.start();
                    int i = 0;
                    for (int i2 = 0; i2 < this.f7611j.getNumberOfFrames(); i2++) {
                        i += this.f7611j.getDuration(i2);
                    }
                    Handler handler = imageView.getHandler();
                    if (handler != null) {
                        handler.postDelayed(new Runnable() {

                            /* renamed from: a */
                            public static ChangeQuickRedirect f7618a;

                            public void run() {
                                if (!PatchProxy.proxy(new Object[0], this, f7618a, false, 2342, new Class[0], Void.TYPE).isSupported) {
                                    if (z) {
                                        imageView.setImageResource(z2 ? R.drawable.mz_pano_stop : R.drawable.mz_record_stop);
                                    } else {
                                        imageView.setImageResource(z2 ? R.drawable.mz_pano_start : R.drawable.mz_record_start);
                                    }
                                }
                            }
                        }, (long) i);
                    } else if (z) {
                        imageView.setImageResource(z2 ? R.drawable.mz_pano_stop : R.drawable.mz_record_stop);
                    } else {
                        imageView.setImageResource(z2 ? R.drawable.mz_pano_start : R.drawable.mz_record_start);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo18859a(C1798a aVar) {
        this.f7617p = aVar;
    }

    /* renamed from: com.meizu.media.camera.animation.a$b */
    /* compiled from: CtlBarAnimManager */
    private class C1799b implements Animation.AnimationListener {

        /* renamed from: a */
        public static ChangeQuickRedirect f7623a;

        /* renamed from: c */
        private boolean f7625c;

        /* renamed from: d */
        private View[] f7626d;

        public void onAnimationRepeat(Animation animation) {
        }

        public C1799b(boolean z) {
            this.f7625c = z;
        }

        /* renamed from: a */
        public void mo18865a(View[] viewArr) {
            this.f7626d = viewArr;
        }

        public void onAnimationStart(Animation animation) {
            if (!PatchProxy.proxy(new Object[]{animation}, this, f7623a, false, 2343, new Class[]{Animation.class}, Void.TYPE).isSupported) {
                LogUtil.m15942a(CtlBarAnimManager.this.f7603b, "onAnimationStart ");
                for (View view : this.f7626d) {
                    view.setVisibility(this.f7625c ? 0 : 4);
                    view.setEnabled(false);
                    LogUtil.m15942a(CtlBarAnimManager.this.f7603b, "view:" + view + ",visible:" + view.getVisibility());
                }
                if (CtlBarAnimManager.this.f7617p != null) {
                    CtlBarAnimManager.this.f7617p.mo18863a(animation);
                }
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (!PatchProxy.proxy(new Object[]{animation}, this, f7623a, false, 2344, new Class[]{Animation.class}, Void.TYPE).isSupported && this.f7626d != null) {
                LogUtil.m15942a(CtlBarAnimManager.this.f7603b, "onAnimationEnd ");
                for (View view : this.f7626d) {
                    if (view.getVisibility() == 0) {
                        view.setEnabled(true);
                    }
                }
                if (CtlBarAnimManager.this.f7617p != null) {
                    CtlBarAnimManager.this.f7617p.mo18864b(animation);
                }
            }
        }
    }

    /* renamed from: a */
    private void m8075a(View[] viewArr, int i) {
        if (!PatchProxy.proxy(new Object[]{viewArr, new Integer(i)}, this, f7602a, false, 2340, new Class[]{View[].class, Integer.TYPE}, Void.TYPE).isSupported && viewArr != null) {
            for (View view : viewArr) {
                view.setVisibility(i);
                view.setEnabled(i == 0);
            }
        }
    }

    /* renamed from: a */
    private void m8076a(View[] viewArr, Animation animation, C1799b bVar) {
        if (!PatchProxy.proxy(new Object[]{viewArr, animation, bVar}, this, f7602a, false, 2341, new Class[]{View[].class, Animation.class, C1799b.class}, Void.TYPE).isSupported && viewArr != null) {
            for (View enabled : viewArr) {
                enabled.setEnabled(false);
            }
            bVar.mo18865a(viewArr);
            animation.setAnimationListener(bVar);
            for (View startAnimation : viewArr) {
                startAnimation.startAnimation(animation);
            }
        }
    }
}
