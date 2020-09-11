package com.meizu.common.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
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
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.meizu.common.R;

public class PraiseView extends View implements View.OnTouchListener {

    /* renamed from: a */
    private Context f5880a;

    /* renamed from: b */
    private int f5881b;

    /* renamed from: c */
    private int f5882c;

    /* renamed from: d */
    private int f5883d;

    /* renamed from: e */
    private int f5884e;

    /* renamed from: f */
    private Drawable f5885f;

    /* renamed from: g */
    private Drawable f5886g;

    /* renamed from: h */
    private Drawable f5887h;

    /* renamed from: i */
    private boolean f5888i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public PopupWindow f5889j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ViewGroup f5890k;

    /* renamed from: l */
    private ImageView f5891l;

    /* renamed from: m */
    private Animation f5892m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C1488a f5893n;

    /* renamed from: o */
    private boolean f5894o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f5895p;

    /* renamed from: q */
    private Stage f5896q;

    /* renamed from: r */
    private float f5897r;

    /* renamed from: s */
    private Animation.AnimationListener f5898s;

    public enum Stage {
        PRAISED,
        CANCEL
    }

    /* renamed from: com.meizu.common.widget.PraiseView$a */
    public interface C1488a {
        @Deprecated
        /* renamed from: a */
        void mo17094a();

        /* renamed from: b */
        void mo17095b();

        /* renamed from: c */
        void mo17096c();
    }

    /* renamed from: a */
    private int m5961a(int i, int i2, int i3) {
        return (i2 == Integer.MIN_VALUE || i2 != 1073741824) ? i3 : i;
    }

    public PraiseView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PraiseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5898s = new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                boolean unused = PraiseView.this.f5895p = true;
            }

            public void onAnimationEnd(Animation animation) {
                if (PraiseView.this.f5890k.getChildCount() >= 1) {
                    PraiseView.this.f5890k.removeViewAt(0);
                }
                PraiseView.this.post(new Runnable() {
                    public void run() {
                        PraiseView.this.f5889j.dismiss();
                    }
                });
                if (PraiseView.this.f5893n != null) {
                    PraiseView.this.f5893n.mo17095b();
                }
                boolean unused = PraiseView.this.f5895p = false;
            }
        };
        this.f5880a = context;
        m5966a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m5966a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PraiseView, i, R.style.Widget_MeizuCommon_PraiseView_Default);
        this.f5885f = obtainStyledAttributes.getDrawable(R.styleable.PraiseView_praiseBackDrawable);
        this.f5887h = obtainStyledAttributes.getDrawable(R.styleable.PraiseView_unPraiseBackDrawable);
        this.f5886g = this.f5885f.getConstantState().newDrawable();
        obtainStyledAttributes.recycle();
        setBackground(this.f5887h);
        this.f5896q = Stage.CANCEL;
        this.f5894o = true;
        this.f5895p = false;
        this.f5888i = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int intrinsicWidth = this.f5885f.getIntrinsicWidth();
        int intrinsicHeight = this.f5885f.getIntrinsicHeight();
        this.f5881b = m5961a(size, mode, intrinsicWidth);
        this.f5882c = m5961a(size2, mode2, intrinsicHeight);
        setMeasuredDimension(this.f5881b, this.f5882c);
        m5965a(this.f5881b, this.f5882c);
    }

    /* renamed from: a */
    private void m5965a(int i, int i2) {
        this.f5884e = i * 2;
        this.f5897r = this.f5880a.getResources().getDisplayMetrics().density * 66.666664f;
        this.f5883d = (int) (((double) this.f5897r) + (((double) i2) * 1.6d));
    }

    public Stage getState() {
        return this.f5896q;
    }

    public void setState(Stage stage) {
        if (stage == Stage.PRAISED) {
            if (this.f5896q != stage) {
                this.f5896q = Stage.PRAISED;
                setBackground(this.f5885f);
                if (this.f5894o) {
                    m5964a();
                }
            }
        } else if (this.f5896q != stage) {
            this.f5896q = Stage.CANCEL;
            if (this.f5889j != null) {
                this.f5889j.dismiss();
            }
            setBackground(this.f5887h);
            if (this.f5893n != null) {
                this.f5893n.mo17096c();
            }
        }
    }

    /* renamed from: a */
    private void m5964a() {
        if (this.f5889j == null || this.f5888i) {
            m5969b();
        } else {
            m5971c();
        }
        if (this.f5892m == null || this.f5888i) {
            this.f5892m = m5972d();
        }
        this.f5888i = false;
        this.f5889j.showAsDropDown(this, -(this.f5881b / 2), -this.f5883d);
        this.f5891l.startAnimation(this.f5892m);
    }

    /* renamed from: b */
    private void m5969b() {
        this.f5890k = new FrameLayout(this.f5880a);
        m5971c();
        this.f5889j = new PopupWindow(this.f5890k, this.f5884e, this.f5883d);
        this.f5889j.setAnimationStyle(0);
        this.f5889j.setTouchable(false);
        this.f5889j.setOutsideTouchable(true);
        this.f5889j.setTouchInterceptor(this);
    }

    /* renamed from: c */
    private void m5971c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f5881b, this.f5882c);
        layoutParams.gravity = 81;
        this.f5891l = new ImageView(this.f5880a);
        this.f5891l.setImageDrawable(this.f5886g);
        this.f5891l.setLayoutParams(layoutParams);
        this.f5890k.addView(this.f5891l);
    }

    /* renamed from: d */
    private Animation m5972d() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.6f, 1.0f, 1.6f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(m5962a(0.3f, 0.0f, 0.1f, 1.0f));
        scaleAnimation.setDuration(700);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -(this.f5897r / ((float) this.f5883d)));
        translateAnimation.setInterpolator(m5962a(0.3f, 0.0f, 0.1f, 1.0f));
        translateAnimation.setDuration(700);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 25.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(100);
        rotateAnimation.setInterpolator(m5962a(0.3f, 0.0f, 0.7f, 1.0f));
        RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, -25.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation2.setDuration(120);
        rotateAnimation2.setStartOffset(100);
        rotateAnimation2.setInterpolator(m5962a(0.3f, 0.0f, 0.7f, 1.0f));
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(m5962a(0.3f, 0.0f, 0.7f, 1.0f));
        alphaAnimation.setDuration(300);
        alphaAnimation.setStartOffset(700);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(rotateAnimation2);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (PraiseView.this.f5893n != null) {
                    PraiseView.this.f5893n.mo17094a();
                }
            }
        });
        animationSet.setAnimationListener(this.f5898s);
        return animationSet;
    }

    public void setAnimationPerform(boolean z) {
        this.f5894o = z;
    }

    public void setBackgroundResId(int i, int i2) {
        this.f5887h = getResources().getDrawable(i2);
        this.f5885f = getResources().getDrawable(i);
        this.f5886g = this.f5885f.getConstantState().newDrawable();
        if (this.f5896q == Stage.CANCEL) {
            setBackground(this.f5887h);
        } else {
            setBackground(this.f5885f);
        }
        this.f5888i = true;
    }

    public void setBackgroundDrawable(Drawable drawable, Drawable drawable2) {
        this.f5887h = drawable2;
        this.f5885f = drawable;
        this.f5886g = drawable.getConstantState().newDrawable();
        if (this.f5896q == Stage.CANCEL) {
            setBackground(drawable2);
        } else {
            setBackground(drawable);
        }
        this.f5888i = true;
    }

    @TargetApi(21)
    /* renamed from: a */
    private Interpolator m5962a(float f, float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(f, f2, f3, f4);
        }
        return new LinearInterpolator();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 4 && motionEvent.getAction() != 4) {
            return false;
        }
        if (this.f5892m == null || this.f5898s == null) {
            return true;
        }
        this.f5898s.onAnimationEnd(this.f5892m);
        return true;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(PraiseView.class.getName());
    }

    public C1488a getPraiseCallBack() {
        return this.f5893n;
    }

    public void setPraiseCallBack(C1488a aVar) {
        this.f5893n = aVar;
    }
}
