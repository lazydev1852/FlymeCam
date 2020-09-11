package com.meizu.media.camera.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.meizu.common.widget.Scroller;
import com.meizu.media.camera.R;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.List;

public class MzZoomSlideBar extends View {

    /* renamed from: a */
    public static ChangeQuickRedirect f14917a;

    /* renamed from: A */
    private Paint f14918A;

    /* renamed from: B */
    private Paint f14919B;

    /* renamed from: C */
    private Paint f14920C;

    /* renamed from: D */
    private int f14921D;

    /* renamed from: E */
    private int f14922E;

    /* renamed from: F */
    private float f14923F;

    /* renamed from: G */
    private float f14924G;

    /* renamed from: H */
    private C2721a f14925H;

    /* renamed from: I */
    private boolean f14926I;

    /* renamed from: J */
    private float f14927J;

    /* renamed from: K */
    private ValueAnimator f14928K;

    /* renamed from: b */
    protected VelocityTracker f14929b;

    /* renamed from: c */
    private Context f14930c;

    /* renamed from: d */
    private List<String> f14931d;

    /* renamed from: e */
    private int f14932e;

    /* renamed from: f */
    private int f14933f;

    /* renamed from: g */
    private int f14934g;

    /* renamed from: h */
    private int f14935h;

    /* renamed from: i */
    private int f14936i;

    /* renamed from: j */
    private int f14937j;

    /* renamed from: k */
    private float f14938k;

    /* renamed from: l */
    private float f14939l;

    /* renamed from: m */
    private float f14940m;

    /* renamed from: n */
    private int f14941n;

    /* renamed from: o */
    private int f14942o;

    /* renamed from: p */
    private int f14943p;

    /* renamed from: q */
    private int f14944q;

    /* renamed from: r */
    private boolean f14945r;

    /* renamed from: s */
    private float f14946s;

    /* renamed from: t */
    private Scroller f14947t;

    /* renamed from: u */
    private int f14948u;

    /* renamed from: v */
    private float f14949v;

    /* renamed from: w */
    private float f14950w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public float f14951x;

    /* renamed from: y */
    private float f14952y;

    /* renamed from: z */
    private Paint f14953z;

    /* renamed from: com.meizu.media.camera.views.MzZoomSlideBar$a */
    public interface C2721a {
        /* renamed from: a */
        void mo22277a(float f);
    }

    public void setValueChangeListener(C2721a aVar) {
        this.f14925H = aVar;
    }

    public MzZoomSlideBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public MzZoomSlideBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MzZoomSlideBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14931d = new ArrayList();
        this.f14934g = 9;
        this.f14935h = 19;
        this.f14943p = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
        this.f14944q = 300;
        this.f14945r = false;
        this.f14951x = 0.0f;
        this.f14926I = false;
        this.f14930c = context;
        this.f14947t = new Scroller(this.f14930c);
        this.f14948u = ViewConfiguration.get(this.f14930c).getScaledMinimumFlingVelocity();
        m16572b();
        m16574c();
    }

    /* renamed from: b */
    private void m16572b() {
        if (!PatchProxy.proxy(new Object[0], this, f14917a, false, 8740, new Class[0], Void.TYPE).isSupported) {
            this.f14921D = getResources().getColor(R.color.slide_mode_selected_color);
            this.f14922E = getResources().getColor(R.color.mc_smartbar_divider);
            this.f14923F = (float) getResources().getDimensionPixelSize(R.dimen.mz_zoom_slider_indicator_width);
            this.f14924G = (float) getResources().getDimensionPixelSize(R.dimen.mz_zoom_slider_indicator_height);
            this.f14937j = getResources().getDimensionPixelSize(R.dimen.mz_zoom_slider_circle_radius);
            this.f14933f = getResources().getDimensionPixelOffset(R.dimen.mz_zoom_slider_text_padding);
            this.f14936i = getResources().getDimensionPixelOffset(R.dimen.mz_zoom_slider_circle_padding);
        }
    }

    /* renamed from: c */
    private void m16574c() {
        if (!PatchProxy.proxy(new Object[0], this, f14917a, false, 8741, new Class[0], Void.TYPE).isSupported) {
            this.f14953z = new Paint(1);
            this.f14953z.setColor(this.f14922E);
            this.f14918A = new Paint(1);
            this.f14918A.setColor(this.f14921D);
            this.f14918A.setStrokeWidth(this.f14923F);
            this.f14919B = new Paint(1);
            this.f14919B.setTypeface(Typeface.create("SFDIN-medium", 0));
            this.f14919B.setColor(-1);
            this.f14919B.setTextSize(getResources().getDimension(R.dimen.mz_zoom_slider_font_size));
            this.f14919B.setShadowLayer(2.0f, 0.0f, 1.0f, getResources().getColor(R.color.mz_mode_name_shadow_color));
            this.f14920C = new Paint(this.f14919B);
            this.f14920C.setColor(this.f14921D);
            this.f14920C.setTextSize(getResources().getDimension(R.dimen.mz_zoom_slider_font_size));
        }
    }

    public void onDraw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f14917a, false, 8742, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            super.onDraw(canvas);
            m16570a(canvas);
        }
    }

    public void onMeasure(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14917a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8743, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            super.onMeasure(i, i2);
            this.f14949v = (float) getMeasuredWidth();
            this.f14950w = (float) getMeasuredHeight();
        }
    }

    /* renamed from: a */
    private void m16570a(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f14917a, false, 8746, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            if (this.f14951x > 0.0f) {
                this.f14951x = 0.0f;
            } else if (this.f14951x < (-this.f14940m)) {
                this.f14951x = -this.f14940m;
            }
            if (this.f14945r) {
                if (0.0f - this.f14951x < this.f14938k) {
                    this.f14946s = (((0.0f - this.f14951x) / this.f14938k) * ((float) (this.f14943p - this.f14941n))) + ((float) this.f14941n);
                } else if (0.0f - this.f14951x < this.f14939l) {
                    this.f14946s = ((((0.0f - this.f14951x) - this.f14938k) / (this.f14939l - this.f14938k)) * ((float) (this.f14944q - this.f14943p))) + ((float) this.f14943p);
                } else {
                    this.f14946s = ((((0.0f - this.f14951x) - this.f14939l) / (this.f14940m - this.f14939l)) * ((float) (this.f14942o - this.f14944q))) + ((float) this.f14944q);
                }
            } else if (0.0f - this.f14951x < this.f14938k) {
                this.f14946s = (((0.0f - this.f14951x) / this.f14938k) * ((float) (this.f14943p - this.f14941n))) + ((float) this.f14941n);
            } else {
                this.f14946s = ((((0.0f - this.f14951x) - this.f14938k) / (this.f14940m - this.f14938k)) * ((float) (this.f14942o - this.f14943p))) + ((float) this.f14943p);
            }
            this.f14925H.mo22277a(this.f14946s);
            int i = 0;
            while (i < this.f14932e) {
                float measureText = this.f14919B.measureText(this.f14931d.get(i));
                float f = (((this.f14949v / 2.0f) + ((float) ((this.f14933f * 2) * i))) - (measureText / 2.0f)) + (((float) i) * measureText) + this.f14951x;
                if (i == 1 || (i == 2 && this.f14945r)) {
                    f += (float) (((this.f14936i * 2) + (this.f14937j * 2)) * this.f14934g * i);
                } else if (i == this.f14932e - 1) {
                    f += (float) (((this.f14936i * 2) + (this.f14937j * 2)) * ((this.f14934g * (this.f14945r ? 2 : 1)) + this.f14935h));
                }
                float descent = (this.f14950w / 2.0f) + ((float) (((int) ((-this.f14919B.ascent()) - this.f14919B.descent())) / 2));
                if ((this.f14949v / 2.0f) - f > measureText || (this.f14949v / 2.0f) - f < 0.0f) {
                    canvas.drawText(this.f14931d.get(i), f, descent, this.f14919B);
                } else {
                    canvas.drawText(this.f14931d.get(i), f, descent, this.f14920C);
                }
                if (i != this.f14932e - 1) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= (i == this.f14932e - 2 ? this.f14935h : this.f14934g)) {
                            break;
                        }
                        float f2 = f + measureText + ((float) this.f14933f) + ((float) (((this.f14937j * 2) + (this.f14936i * 2)) * i2)) + ((float) (this.f14936i + this.f14937j));
                        if (Math.abs(f2 - ((this.f14949v / 2.0f) - (this.f14923F / 2.0f))) < ((float) this.f14936i)) {
                            canvas.drawCircle(f2, (this.f14950w / 2.0f) + ((float) this.f14937j), (float) this.f14937j, this.f14920C);
                        } else {
                            canvas.drawCircle(f2, (this.f14950w / 2.0f) + ((float) this.f14937j), (float) this.f14937j, this.f14919B);
                        }
                        i2++;
                    }
                }
                i++;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14917a, false, 8747, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        if (this.f14929b == null) {
            this.f14929b = VelocityTracker.obtain();
        }
        this.f14929b.addMovement(motionEvent);
        switch (action) {
            case 0:
                this.f14926I = false;
                this.f14952y = x;
                this.f14947t.mo17587a(true);
                if (this.f14928K != null) {
                    this.f14928K.cancel();
                    break;
                }
                break;
            case 1:
            case 3:
                this.f14926I = true;
                m16571a(motionEvent);
                if (this.f14952y - x != 0.0f) {
                    return true;
                }
                m16573b(x);
                postInvalidate();
                return false;
            case 2:
                this.f14926I = true;
                float f = x - this.f14927J;
                if ((this.f14951x > (-this.f14940m) || f >= 0.0f) && (this.f14951x < 0.0f || f <= 0.0f)) {
                    this.f14951x += f;
                    postInvalidate();
                    break;
                }
        }
        this.f14927J = x;
        return true;
    }

    /* renamed from: b */
    private void m16573b(float f) {
        if (!PatchProxy.proxy(new Object[]{new Float(f)}, this, f14917a, false, 8748, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            float f2 = this.f14951x - (f - (this.f14949v / 2.0f));
            new ValueAnimator();
            this.f14928K = ValueAnimator.ofFloat(new float[]{this.f14951x, f2});
            this.f14928K.setDuration(300);
            this.f14928K.setInterpolator(new DecelerateInterpolator());
            this.f14928K.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                /* renamed from: a */
                public static ChangeQuickRedirect f14954a;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (!PatchProxy.proxy(new Object[]{valueAnimator}, this, f14954a, false, 8755, new Class[]{ValueAnimator.class}, Void.TYPE).isSupported) {
                        float unused = MzZoomSlideBar.this.f14951x = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        MzZoomSlideBar.this.postInvalidate();
                    }
                }
            });
            this.f14928K.start();
        }
    }

    public void computeScroll() {
        if (!PatchProxy.proxy(new Object[0], this, f14917a, false, 8749, new Class[0], Void.TYPE).isSupported) {
            super.computeScroll();
        }
    }

    /* renamed from: a */
    private void m16571a(MotionEvent motionEvent) {
        if (!PatchProxy.proxy(new Object[]{motionEvent}, this, f14917a, false, 8750, new Class[]{MotionEvent.class}, Void.TYPE).isSupported) {
            this.f14929b.computeCurrentVelocity(1000, 3000.0f);
            float xVelocity = this.f14929b.getXVelocity();
            if (Math.abs(xVelocity) > ((float) this.f14948u)) {
                this.f14947t.mo17586a(0, 0, (int) xVelocity, 0, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, 0);
            }
        }
    }

    public void setValues(List<Integer> list, int i) {
        if (!PatchProxy.proxy(new Object[]{list, new Integer(i)}, this, f14917a, false, 8751, new Class[]{List.class, Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14931d.clear();
            this.f14941n = list.get(0).intValue();
            this.f14942o = list.get(list.size() - 1).intValue();
            this.f14931d.add("1x");
            this.f14931d.add("2x");
            if (i != 0 && i < list.size()) {
                this.f14945r = true;
                this.f14944q = list.get(i).intValue();
                this.f14931d.add("3x");
            }
            List<String> list2 = this.f14931d;
            list2.add((this.f14942o / 100) + "x");
            if (this.f14942o > 400) {
                this.f14935h = 29;
            }
            this.f14932e = this.f14931d.size();
            m16575d();
            invalidate();
        }
    }

    /* renamed from: d */
    private void m16575d() {
        if (!PatchProxy.proxy(new Object[0], this, f14917a, false, 8752, new Class[0], Void.TYPE).isSupported) {
            float measureText = (this.f14919B.measureText(this.f14931d.get(0)) / 2.0f) + 0.0f + (this.f14919B.measureText(this.f14931d.get(1)) / 2.0f) + ((float) ((this.f14933f * 2) + (this.f14934g * 2 * (this.f14936i + this.f14937j))));
            this.f14938k = measureText;
            if (this.f14945r) {
                measureText = measureText + (this.f14919B.measureText(this.f14931d.get(1)) / 2.0f) + (this.f14919B.measureText(this.f14931d.get(2)) / 2.0f) + ((float) ((this.f14933f * 2) + (this.f14934g * 2 * (this.f14936i + this.f14937j))));
                this.f14939l = measureText;
            }
            for (int i = this.f14932e - 2; i < this.f14932e; i++) {
                measureText += this.f14919B.measureText(this.f14931d.get(i)) / 2.0f;
            }
            this.f14940m = measureText + ((float) (this.f14933f * 2)) + ((float) (this.f14935h * 2 * (this.f14936i + this.f14937j)));
        }
    }

    public void setStartValue(int i) {
        this.f14941n = i;
    }

    public void setEndValue(int i) {
        this.f14942o = i;
    }

    public void setCurrentValue(int i) {
        this.f14946s = (float) i;
    }

    /* renamed from: a */
    public void mo23119a() {
        if (!PatchProxy.proxy(new Object[0], this, f14917a, false, 8753, new Class[0], Void.TYPE).isSupported) {
            if (this.f14946s < ((float) this.f14941n)) {
                this.f14946s = (float) this.f14941n;
            } else if (this.f14946s > ((float) this.f14942o)) {
                this.f14946s = (float) this.f14942o;
            }
            if (this.f14945r) {
                if (this.f14946s > ((float) this.f14944q)) {
                    this.f14951x = (((this.f14946s - ((float) this.f14944q)) * (this.f14940m - this.f14939l)) / ((float) (this.f14944q - this.f14942o))) - this.f14939l;
                } else if (this.f14946s > ((float) this.f14943p)) {
                    this.f14951x = (((this.f14946s - ((float) this.f14943p)) * (this.f14939l - this.f14938k)) / ((float) (this.f14943p - this.f14944q))) - this.f14938k;
                } else {
                    this.f14951x = ((this.f14946s - ((float) this.f14941n)) * this.f14938k) / ((float) (this.f14941n - this.f14943p));
                }
            } else if (this.f14946s > ((float) this.f14943p)) {
                this.f14951x = (((this.f14946s - ((float) this.f14943p)) * (this.f14940m - this.f14938k)) / ((float) (this.f14943p - this.f14942o))) - this.f14938k;
            } else {
                this.f14951x = ((this.f14946s - ((float) this.f14941n)) * this.f14938k) / ((float) (this.f14941n - this.f14943p));
            }
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo23120a(float f) {
        if (!PatchProxy.proxy(new Object[]{new Float(f)}, this, f14917a, false, 8754, new Class[]{Float.TYPE}, Void.TYPE).isSupported) {
            this.f14951x += f;
            invalidate();
        }
    }
}
