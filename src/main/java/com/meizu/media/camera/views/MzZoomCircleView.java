package com.meizu.media.camera.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.Nullable;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.C2644av;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.util.ArrayList;
import java.util.List;

public class MzZoomCircleView extends View {

    /* renamed from: a */
    public static ChangeQuickRedirect f14884a;

    /* renamed from: b */
    private int f14885b;

    /* renamed from: c */
    private int f14886c;

    /* renamed from: d */
    private int f14887d;

    /* renamed from: e */
    private Paint f14888e;

    /* renamed from: f */
    private int f14889f;

    /* renamed from: g */
    private boolean f14890g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f14891h;

    /* renamed from: i */
    private int f14892i;

    /* renamed from: j */
    private float f14893j;

    /* renamed from: k */
    private float f14894k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public float f14895l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public float f14896m;

    /* renamed from: n */
    private ValueAnimator f14897n;

    /* renamed from: o */
    private ValueAnimator f14898o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f14899p;

    /* renamed from: q */
    private Rect f14900q;

    /* renamed from: r */
    private List<C2719a> f14901r;

    /* renamed from: s */
    private List<C2719a> f14902s;

    /* renamed from: com.meizu.media.camera.views.MzZoomCircleView$a */
    class C2719a {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public float f14913b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public float f14914c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public float f14915d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public int f14916e;

        C2719a() {
        }

        /* renamed from: a */
        public void mo23116a(float f) {
            this.f14914c = f;
        }

        /* renamed from: b */
        public void mo23118b(float f) {
            this.f14915d = f;
        }

        /* renamed from: a */
        public void mo23117a(int i) {
            this.f14916e = i;
        }
    }

    public MzZoomCircleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MzZoomCircleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MzZoomCircleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14893j = 8.0f;
        this.f14894k = Float.MIN_VALUE;
        this.f14895l = 1.0f;
        this.f14896m = 1.0f;
        this.f14899p = false;
        this.f14900q = new Rect();
        this.f14901r = new ArrayList();
        this.f14902s = new ArrayList();
        m16552b();
        m16554c();
    }

    /* renamed from: b */
    private void m16552b() {
        if (!PatchProxy.proxy(new Object[0], this, f14884a, false, 8725, new Class[0], Void.TYPE).isSupported) {
            this.f14885b = getResources().getDimensionPixelOffset(R.dimen.mz_zoom_slider_circle_radius);
            this.f14886c = getResources().getDimensionPixelOffset(R.dimen.mz_zoom_circle_start_padding);
            this.f14887d = getResources().getDimensionPixelOffset(R.dimen.mz_zoom_circle_padding);
            this.f14889f = getResources().getDimensionPixelOffset(R.dimen.mz_zoom_circle_indicator_radius);
        }
    }

    /* renamed from: c */
    private void m16554c() {
        if (!PatchProxy.proxy(new Object[0], this, f14884a, false, 8726, new Class[0], Void.TYPE).isSupported) {
            this.f14888e = new Paint(1);
            this.f14888e.setTypeface(Typeface.create("SFDIN-medium", 0));
            this.f14888e.setColor(-1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16548a(float f, boolean z) {
        Object[] objArr = {new Float(f), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14884a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8727, new Class[]{Float.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f14902s.clear();
            this.f14900q.set(getPaddingStart() - 10, getPaddingTop(), (this.f14891h - getPaddingEnd()) + 10, this.f14892i - getPaddingBottom());
            int i = (this.f14885b * 2) + this.f14887d;
            if ((this.f14901r.isEmpty() || !C2644av.m16103a(this.f14894k, this.f14893j)) && this.f14891h > 0) {
                this.f14901r.clear();
                for (int i2 = 0; ((float) i2) < (this.f14893j - 1.0f) / 0.1f; i2++) {
                    C2719a aVar = new C2719a();
                    aVar.mo23117a((i2 * i) + (this.f14891h / 2));
                    aVar.mo23116a((float) (this.f14892i / 2));
                    aVar.mo23118b(0.0f);
                    this.f14901r.add(aVar);
                }
                this.f14894k = this.f14893j;
            }
            for (int i3 = 0; i3 < this.f14901r.size(); i3++) {
                C2719a aVar2 = this.f14901r.get(i3);
                if (!z) {
                    float unused = aVar2.f14913b = (float) (aVar2.f14916e - (((int) (((f - 1.0f) / this.f14893j) * ((float) this.f14901r.size()))) * i));
                } else {
                    float unused2 = aVar2.f14913b = ((float) aVar2.f14916e) + f;
                }
                float unused3 = aVar2.f14914c = (float) (this.f14892i / 2);
                aVar2.mo23118b(0.0f);
                if (aVar2.f14913b > ((float) (this.f14891h / 2))) {
                    float unused4 = aVar2.f14913b = aVar2.f14913b + ((float) this.f14889f);
                } else if (aVar2.f14913b < ((float) (this.f14891h / 2))) {
                    float unused5 = aVar2.f14913b = aVar2.f14913b - ((float) this.f14889f);
                }
                if (aVar2.f14913b < ((float) ((this.f14891h / 2) - (this.f14889f + this.f14886c)))) {
                    float f2 = (float) (((this.f14891h / 2) - (i * 10)) - (this.f14889f + this.f14886c));
                    if (aVar2.f14913b > f2) {
                        aVar2.mo23118b(((aVar2.f14913b - f2) / (((float) (this.f14891h / 2)) - f2)) * 255.0f);
                    }
                } else if (aVar2.f14913b > ((float) ((this.f14891h / 2) + this.f14889f + this.f14886c))) {
                    float f3 = (float) ((this.f14891h / 2) + (i * 10) + this.f14889f + this.f14886c);
                    if (aVar2.f14913b < f3) {
                        aVar2.mo23118b((1.0f - ((aVar2.f14913b - ((float) (this.f14891h / 2))) / (f3 - ((float) (this.f14891h / 2))))) * 255.0f);
                    }
                }
                this.f14902s.add(aVar2);
            }
        }
    }

    /* renamed from: a */
    public void mo23101a(float f) {
        this.f14893j = f;
    }

    public void setVisible(final boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0)}, this, f14884a, false, 8728, new Class[]{Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f14890g = z;
            if (z) {
                m16548a(this.f14895l, false);
            }
            if (this.f14898o != null && this.f14898o.isRunning()) {
                this.f14898o.end();
            }
            if (z) {
                this.f14898o = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f, 1.0f});
                this.f14898o.setDuration(80);
            } else {
                this.f14898o = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f});
                this.f14898o.setDuration(100);
            }
            this.f14898o.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.66f, 1.0f));
            this.f14898o.addListener(new Animator.AnimatorListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14903a;

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f14903a, false, 8735, new Class[]{Animator.class}, Void.TYPE).isSupported && z) {
                        MzZoomCircleView.this.setVisibility(0);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f14903a, false, 8736, new Class[]{Animator.class}, Void.TYPE).isSupported && !z) {
                        MzZoomCircleView.this.setVisibility(4);
                    }
                }
            });
            this.f14898o.start();
        }
    }

    /* renamed from: a */
    public void mo23100a() {
        if (!PatchProxy.proxy(new Object[0], this, f14884a, false, 8729, new Class[0], Void.TYPE).isSupported) {
            setCurrentValue(1.0f, false);
        }
    }

    /* renamed from: a */
    public void mo23102a(boolean z, boolean z2) {
        Object[] objArr = {new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14884a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8730, new Class[]{Boolean.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            setVisible(z);
        }
    }

    public void onDraw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f14884a, false, 8731, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            super.onDraw(canvas);
            if (this.f14890g) {
                for (C2719a next : this.f14902s) {
                    this.f14888e.setAlpha((int) next.f14915d);
                    canvas.drawCircle(next.f14913b, next.f14914c, (float) this.f14885b, this.f14888e);
                }
            }
        }
    }

    public void onMeasure(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14884a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8732, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onMeasure(i, i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            this.f14891h = size;
            this.f14892i = size2;
        }
    }

    public synchronized void setCurrentValue(float f, boolean z) {
        if (!PatchProxy.proxy(new Object[]{new Float(f), new Byte(z ? (byte) 1 : 0)}, this, f14884a, false, 8733, new Class[]{Float.TYPE, Boolean.TYPE}, Void.TYPE).isSupported) {
            this.f14899p = z;
            if (f < 1.0f) {
                f = 1.0f;
            } else if (f > this.f14893j) {
                f = this.f14893j;
            }
            if (this.f14897n != null && this.f14897n.isRunning()) {
                this.f14897n.end();
            }
            if (!C2644av.m16103a(this.f14895l, f)) {
                this.f14896m = this.f14895l;
                this.f14895l = f;
                m16556d();
            }
        }
    }

    /* renamed from: d */
    private void m16556d() {
        if (!PatchProxy.proxy(new Object[0], this, f14884a, false, 8734, new Class[0], Void.TYPE).isSupported) {
            final int i = (this.f14885b * 2) + this.f14887d;
            if (this.f14897n != null) {
                this.f14897n.end();
                if (this.f14899p) {
                    this.f14897n.setDuration(240);
                } else {
                    this.f14897n.setDuration(150);
                }
                this.f14897n.start();
                return;
            }
            new ValueAnimator();
            this.f14897n = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f14897n.setInterpolator(new DecelerateInterpolator());
            this.f14897n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(1.0f) {

                /* renamed from: a */
                public static ChangeQuickRedirect f14906a;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float f;
                    if (!PatchProxy.proxy(new Object[]{valueAnimator}, this, f14906a, false, 8737, new Class[]{ValueAnimator.class}, Void.TYPE).isSupported) {
                        if (MzZoomCircleView.this.f14899p) {
                            float f2 = 2.0f;
                            if (MzZoomCircleView.this.f14895l > MzZoomCircleView.this.f14896m) {
                                f = 1.0f;
                            } else {
                                f = C2644av.m16103a(MzZoomCircleView.this.f14895l, MzZoomCircleView.this.f14896m) ? 2.0f : 1.0f;
                                f2 = 1.0f;
                            }
                            int round = Math.round((f - 1.0f) * 3.0f) * i;
                            MzZoomCircleView.this.m16548a((((float) round) + (((float) (round - (Math.round((f2 - 1.0f) * 3.0f) * i))) * Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue() / 1.0f))) - ((float) (MzZoomCircleView.this.f14891h / 2)), true);
                        } else {
                            int round2 = Math.round((MzZoomCircleView.this.f14895l - 1.0f) * 10.0f) * i;
                            int round3 = Math.round((MzZoomCircleView.this.f14896m - 1.0f) * 10.0f) * i;
                            MzZoomCircleView.this.m16548a((float) Math.round(-(((float) round3) + (((float) (round2 - round3)) * Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue() / 1.0f)))), true);
                        }
                        MzZoomCircleView.this.invalidate();
                    }
                }
            });
            this.f14897n.addListener(new Animator.AnimatorListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14910a;

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f14910a, false, 8738, new Class[]{Animator.class}, Void.TYPE).isSupported && MzZoomCircleView.this.f14899p) {
                        MzZoomCircleView.this.setVisible(true);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (!PatchProxy.proxy(new Object[]{animator}, this, f14910a, false, 8739, new Class[]{Animator.class}, Void.TYPE).isSupported && MzZoomCircleView.this.f14899p) {
                        MzZoomCircleView.this.mo23102a(false, true);
                    }
                }
            });
            m16556d();
        }
    }
}
