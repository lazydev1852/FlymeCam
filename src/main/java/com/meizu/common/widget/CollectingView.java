package com.meizu.common.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.meizu.common.R;

public class CollectingView extends View implements View.OnTouchListener {

    /* renamed from: a */
    private Context f4842a;

    /* renamed from: b */
    private int f4843b;

    /* renamed from: c */
    private int f4844c;

    /* renamed from: d */
    private int f4845d;

    /* renamed from: e */
    private int f4846e;

    /* renamed from: f */
    private Drawable f4847f;

    /* renamed from: g */
    private Drawable f4848g;

    /* renamed from: h */
    private Drawable f4849h;

    /* renamed from: i */
    private boolean f4850i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public PopupWindow f4851j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ViewGroup f4852k;

    /* renamed from: l */
    private ImageView f4853l;

    /* renamed from: m */
    private Animation f4854m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C1387a f4855n;

    /* renamed from: o */
    private boolean f4856o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f4857p;

    /* renamed from: q */
    private Stage f4858q;

    /* renamed from: r */
    private float f4859r;

    /* renamed from: s */
    private Animation.AnimationListener f4860s;

    public enum Stage {
        COLLECTED,
        CANCEL
    }

    /* renamed from: com.meizu.common.widget.CollectingView$a */
    public interface C1387a {
        /* renamed from: a */
        void mo16323a();

        /* renamed from: b */
        void mo16324b();

        /* renamed from: c */
        void mo16325c();

        /* renamed from: d */
        void mo16326d();
    }

    /* renamed from: a */
    private int m5390a(int i, int i2, int i3) {
        return (i2 == Integer.MIN_VALUE || i2 != 1073741824) ? i3 : i;
    }

    public CollectingView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CollectingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollectingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4860s = new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                if (CollectingView.this.f4855n != null) {
                    CollectingView.this.f4855n.mo16323a();
                }
                boolean unused = CollectingView.this.f4857p = true;
            }

            public void onAnimationEnd(Animation animation) {
                if (CollectingView.this.f4852k.getChildCount() >= 1) {
                    CollectingView.this.f4852k.removeViewAt(0);
                }
                CollectingView.this.post(new Runnable() {
                    public void run() {
                        if (CollectingView.this.f4851j != null) {
                            CollectingView.this.f4851j.dismiss();
                        }
                    }
                });
                if (CollectingView.this.f4855n != null) {
                    CollectingView.this.f4855n.mo16325c();
                }
                boolean unused = CollectingView.this.f4857p = false;
            }
        };
        this.f4842a = context;
        m5395a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m5395a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollectingView, i, R.style.Widget_MeizuCommon_CollectingView_Default);
        this.f4847f = obtainStyledAttributes.getDrawable(R.styleable.CollectingView_collectBackDrawable);
        this.f4848g = this.f4847f.getConstantState().newDrawable();
        this.f4849h = obtainStyledAttributes.getDrawable(R.styleable.CollectingView_unCollectBackDrawable);
        obtainStyledAttributes.recycle();
        setBackground(this.f4849h);
        this.f4858q = Stage.CANCEL;
        this.f4856o = true;
        this.f4857p = false;
        this.f4850i = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int intrinsicWidth = this.f4847f.getIntrinsicWidth();
        int intrinsicHeight = this.f4847f.getIntrinsicHeight();
        this.f4843b = m5390a(size, mode, intrinsicWidth);
        this.f4844c = m5390a(size2, mode2, intrinsicHeight);
        setMeasuredDimension(this.f4843b, this.f4844c);
        m5394a(this.f4843b, this.f4844c);
    }

    /* renamed from: a */
    private void m5394a(int i, int i2) {
        this.f4846e = i * 2;
        this.f4859r = this.f4842a.getResources().getDisplayMetrics().density * 66.666664f;
        this.f4845d = (int) (((double) this.f4859r) + (((double) i2) * 1.6d));
    }

    public Stage getState() {
        return this.f4858q;
    }

    public void setState(Stage stage) {
        if (stage == Stage.COLLECTED) {
            if (this.f4858q != stage) {
                this.f4858q = Stage.COLLECTED;
                setBackground(this.f4847f);
                if (this.f4856o) {
                    m5393a();
                }
            }
        } else if (this.f4858q != stage) {
            this.f4858q = Stage.CANCEL;
            if (this.f4851j != null) {
                this.f4851j.dismiss();
            }
            setBackground(this.f4849h);
            if (this.f4857p && this.f4855n != null) {
                this.f4855n.mo16324b();
            }
            if (this.f4855n != null) {
                this.f4855n.mo16326d();
            }
        }
    }

    /* renamed from: a */
    private void m5393a() {
        int i;
        if (this.f4851j == null || this.f4850i) {
            m5398b();
        } else {
            m5400c();
        }
        if (this.f4854m == null || this.f4850i) {
            this.f4854m = m5401d();
        }
        this.f4850i = false;
        if (1 == getLayoutDirection()) {
            i = Math.abs((this.f4846e - this.f4843b) / 2);
        } else {
            i = -Math.abs((this.f4846e - this.f4843b) / 2);
        }
        this.f4851j.showAsDropDown(this, i, -this.f4845d);
        this.f4853l.startAnimation(this.f4854m);
    }

    /* renamed from: b */
    private void m5398b() {
        this.f4852k = new FrameLayout(this.f4842a);
        m5400c();
        this.f4851j = new PopupWindow(this.f4852k, this.f4846e, this.f4845d);
        this.f4851j.setAnimationStyle(0);
        this.f4851j.setTouchable(true);
        this.f4851j.setOutsideTouchable(true);
        this.f4851j.setBackgroundDrawable(new BitmapDrawable());
        this.f4851j.setTouchInterceptor(this);
    }

    /* renamed from: c */
    private void m5400c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f4843b, this.f4844c);
        layoutParams.gravity = 81;
        this.f4853l = new ImageView(this.f4842a);
        this.f4853l.setImageDrawable(this.f4848g);
        this.f4853l.setLayoutParams(layoutParams);
        this.f4852k.addView(this.f4853l);
    }

    /* renamed from: d */
    private Animation m5401d() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.6f, 1.0f, 1.6f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(m5391a(0.3f, 0.0f, 0.1f, 1.0f));
        scaleAnimation.setDuration(700);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -(this.f4859r / ((float) this.f4845d)));
        translateAnimation.setInterpolator(m5391a(0.3f, 0.0f, 0.1f, 1.0f));
        translateAnimation.setDuration(700);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(m5391a(0.3f, 0.0f, 0.7f, 1.0f));
        alphaAnimation.setDuration(300);
        alphaAnimation.setStartOffset(700);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(this.f4860s);
        return animationSet;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 4) {
            return false;
        }
        if (this.f4854m == null || this.f4860s == null) {
            return true;
        }
        this.f4860s.onAnimationEnd(this.f4854m);
        return true;
    }

    public void setAnimationPerform(boolean z) {
        this.f4856o = z;
    }

    public void setBackgroundResId(int i, int i2) {
        this.f4849h = getResources().getDrawable(i2);
        this.f4847f = getResources().getDrawable(i);
        this.f4848g = this.f4847f.getConstantState().newDrawable();
        if (this.f4858q == Stage.CANCEL) {
            setBackground(this.f4849h);
        } else {
            setBackground(this.f4847f);
        }
        this.f4850i = true;
    }

    public void setBackgroundDrawable(Drawable drawable, Drawable drawable2) {
        this.f4849h = drawable2;
        this.f4847f = drawable;
        this.f4848g = this.f4847f.getConstantState().newDrawable();
        if (this.f4858q == Stage.CANCEL) {
            setBackground(this.f4849h);
        } else {
            setBackground(this.f4847f);
        }
        this.f4850i = true;
    }

    @TargetApi(21)
    /* renamed from: a */
    private Interpolator m5391a(float f, float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(f, f2, f3, f4);
        }
        return new LinearInterpolator();
    }

    public C1387a getCollectCallBack() {
        return this.f4855n;
    }

    public void setCollectCallBack(C1387a aVar) {
        this.f4855n = aVar;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CollectingView.class.getName());
    }
}
