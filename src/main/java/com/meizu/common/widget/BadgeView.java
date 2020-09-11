package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TabWidget;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.meizu.common.R;

public class BadgeView extends TextView {

    /* renamed from: a */
    private boolean f4702a = true;

    /* renamed from: b */
    private int f4703b;

    /* renamed from: c */
    private int f4704c;

    /* renamed from: d */
    private int f4705d;

    /* renamed from: e */
    private int f4706e;

    /* renamed from: f */
    private int f4707f;

    /* renamed from: g */
    private Paint f4708g;

    /* renamed from: h */
    private Drawable f4709h;

    /* renamed from: i */
    private Stage f4710i;

    /* renamed from: j */
    private int f4711j;

    /* renamed from: k */
    private final int f4712k = 28;

    /* renamed from: l */
    private final int f4713l = 50;

    /* renamed from: m */
    private final float f4714m = 4.5f;

    /* renamed from: n */
    private int f4715n;

    /* renamed from: o */
    private int f4716o;

    /* renamed from: p */
    private int f4717p;

    /* renamed from: q */
    private FrameLayout f4718q;

    /* renamed from: r */
    private ViewGroup f4719r;

    public enum Stage {
        SHOWNUM,
        HIDENUM
    }

    public BadgeView(Context context) {
        super(context);
        m5266a(context, (AttributeSet) null);
    }

    public BadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5266a(context, attributeSet);
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5266a(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f4709h != null) {
            if (this.f4710i == Stage.SHOWNUM) {
                this.f4711j = m5265a((Paint) getPaint(), (String) getText());
                int min = Math.min(getWidth(), Math.max(this.f4709h.getIntrinsicWidth(), this.f4711j + ((int) (getResources().getDimension(R.dimen.mc_badge_view_space) * 2.0f))));
                this.f4709h.setBounds((getWidth() - min) / 2, (getHeight() / 2) - (this.f4709h.getIntrinsicHeight() / 2), getWidth() - ((getWidth() - min) / 2), (getHeight() / 2) + (this.f4709h.getIntrinsicHeight() / 2));
                this.f4709h.draw(canvas);
            } else {
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.f4707f, this.f4708g);
            }
        }
        super.onDraw(canvas);
    }

    /* renamed from: a */
    private void m5266a(Context context, AttributeSet attributeSet) {
        this.f4710i = Stage.SHOWNUM;
        this.f4709h = getResources().getDrawable(R.drawable.mc_badge_view);
        m5268b(context, attributeSet);
        m5269c();
        setGravity(17);
        setTextColor(this.f4703b);
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize((float) this.f4704c);
        setHide(true);
        setBadgeNum(0);
        m5267b();
    }

    /* renamed from: b */
    private void m5267b() {
        this.f4715n = (int) getResources().getDimension(R.dimen.mc_badge_view_layout_params_width);
        this.f4716o = (int) getResources().getDimension(R.dimen.mc_badge_view_layout_params_height);
        this.f4717p = (int) getResources().getDimension(R.dimen.mc_badge_view_two_num_width);
        if (!(getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            setLayoutParams(new FrameLayout.LayoutParams(this.f4715n, this.f4716o, 53));
        }
    }

    /* renamed from: c */
    private void m5269c() {
        this.f4708g = new Paint();
        this.f4708g.setColor(this.f4705d);
        this.f4708g.setAntiAlias(true);
        this.f4708g.setTypeface(Typeface.create("SFPRO-medium", 0));
    }

    /* renamed from: a */
    private int m5265a(Paint paint, String str) {
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, this).toString();
        }
        return (int) paint.measureText(str);
    }

    /* renamed from: b */
    private void m5268b(Context context, AttributeSet attributeSet) {
        TypedArray a = mo16173a(context, attributeSet, R.styleable.BadgeView);
        if (a != null) {
            this.f4703b = a.getColor(R.styleable.BadgeView_mcBadgeTextColor, -1);
            this.f4704c = a.getDimensionPixelSize(R.styleable.BadgeView_mcBadgeTextSize, 10);
            this.f4706e = (int) a.getDimension(R.styleable.BadgeView_mcBadgeRadius, getResources().getDimension(R.dimen.mc_badge_view_radius_show_count));
            this.f4707f = (int) a.getDimension(R.styleable.BadgeView_mcBadgeRadius, getResources().getDimension(R.dimen.mc_badge_view_radius));
            this.f4705d = a.getResourceId(R.styleable.BadgeView_mcBadgeColor, SupportMenu.CATEGORY_MASK);
            a.recycle();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public TypedArray mo16173a(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void setTargetView(View view) {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (view != null) {
            if (view.getParent() instanceof FrameLayout) {
                ((FrameLayout) view.getParent()).addView(this);
            } else if (view.getParent() instanceof ViewGroup) {
                this.f4719r = (ViewGroup) view.getParent();
                int indexOfChild = this.f4719r.indexOfChild(view);
                this.f4719r.removeView(view);
                this.f4718q = new FrameLayout(getContext());
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                this.f4718q.setLayoutParams(layoutParams);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f4719r.addView(this.f4718q, indexOfChild, layoutParams);
                this.f4718q.addView(view);
                this.f4718q.addView(this);
            } else if (view.getParent() == null) {
                Log.e(getClass().getSimpleName(), "ParentView cannot be empty");
            }
        }
    }

    public void setState(Stage stage) {
        this.f4710i = stage;
    }

    public Stage getState() {
        return this.f4710i;
    }

    public void setTargetView(TabWidget tabWidget, int i) {
        setTargetView(tabWidget.getChildTabViewAt(i));
    }

    public void setHide(boolean z) {
        this.f4702a = z;
        if (this.f4710i == Stage.SHOWNUM) {
            setText(getText());
        } else {
            setText((CharSequence) null);
        }
    }

    /* renamed from: a */
    public boolean mo16174a() {
        return this.f4702a;
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (!mo16174a() || (charSequence != null && !charSequence.toString().equalsIgnoreCase("0"))) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
        super.setText(charSequence, bufferType);
    }

    public void setBadgeNum(int i) {
        if (this.f4710i == Stage.SHOWNUM) {
            if (i >= 999) {
                i = 999;
            }
            setText(String.valueOf(i));
            return;
        }
        setText((CharSequence) null);
    }

    public Integer getBadgeNum() {
        if (getText() == null) {
            return 0;
        }
        try {
            return Integer.valueOf(Integer.parseInt(getText().toString()));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public void setBackgroundColor(int i) {
        this.f4708g.setColor(i);
    }

    public void setBackgroundResource(int i) {
        this.f4709h = getResources().getDrawable(i);
    }

    public void setBackground(Drawable drawable) {
        this.f4709h = drawable;
    }

    public void setBadgeGravity(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.gravity = i;
        setLayoutParams(layoutParams);
    }

    public int getBadgeGravity() {
        return ((FrameLayout.LayoutParams) getLayoutParams()).gravity;
    }

    public void setBadgeMargin(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = (int) m5264a((float) i);
        layoutParams.topMargin = (int) m5264a((float) i2);
        layoutParams.rightMargin = (int) m5264a((float) i3);
        layoutParams.bottomMargin = (int) m5264a((float) i4);
        setLayoutParams(layoutParams);
    }

    public int[] getBadgeMargin() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        return new int[]{layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin};
    }

    /* renamed from: a */
    private float m5264a(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public void setBadgeRadius(int i) {
        int a = (int) m5264a((float) i);
        if (this.f4710i == Stage.SHOWNUM) {
            this.f4706e = a;
        } else if (this.f4710i == Stage.HIDENUM) {
            this.f4707f = a;
        }
    }
}
