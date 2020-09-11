package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;
import com.meizu.common.R;
import com.meizu.common.util.ResourceUtils;

public class NewMessageView extends View {

    /* renamed from: a */
    private boolean f5760a = true;

    /* renamed from: b */
    private int f5761b;

    /* renamed from: c */
    private float f5762c;

    /* renamed from: d */
    private int f5763d;

    /* renamed from: e */
    private boolean f5764e = false;

    /* renamed from: f */
    private int f5765f;

    /* renamed from: g */
    private int f5766g;

    /* renamed from: h */
    private int f5767h;

    /* renamed from: i */
    private Paint f5768i;

    /* renamed from: j */
    private Paint f5769j;

    /* renamed from: k */
    private TextPaint f5770k;

    /* renamed from: l */
    private int f5771l;

    /* renamed from: m */
    private int f5772m;

    /* renamed from: n */
    private int f5773n;

    /* renamed from: o */
    private int f5774o;

    /* renamed from: p */
    private int f5775p;

    /* renamed from: q */
    private int f5776q;

    /* renamed from: r */
    private int f5777r;

    /* renamed from: s */
    private RectF f5778s;

    /* renamed from: t */
    private Rect f5779t;

    /* renamed from: u */
    private int f5780u = 0;

    /* renamed from: v */
    private String f5781v;

    /* renamed from: a */
    private int m5910a(int i, int i2, int i3, int i4) {
        return (i4 == Integer.MIN_VALUE || i4 != 1073741824 || i < i2) ? i2 : i > i3 ? i3 : i;
    }

    public NewMessageView(Context context) {
        super(context);
        m5912a(context, (AttributeSet) null);
    }

    public NewMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5912a(context, attributeSet);
    }

    public NewMessageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5912a(context, attributeSet);
    }

    /* renamed from: a */
    private void m5912a(Context context, AttributeSet attributeSet) {
        this.f5775p = (int) getResources().getDimension(R.dimen.mc_new_message_view_layout_max_width);
        this.f5776q = (int) getResources().getDimension(R.dimen.mc_new_message_view_layout_max_height);
        m5914b(context, attributeSet);
        m5916d();
        m5915c();
        m5913b();
    }

    /* renamed from: b */
    private void m5913b() {
        this.f5778s = new RectF();
    }

    /* renamed from: a */
    private void m5911a(float f, float f2, float f3, float f4) {
        this.f5778s.left = f;
        this.f5778s.top = f2;
        this.f5778s.right = f3;
        this.f5778s.bottom = f4;
    }

    /* renamed from: c */
    private void m5915c() {
        this.f5770k = new TextPaint();
        this.f5770k.setAntiAlias(true);
        this.f5770k.setStyle(Paint.Style.FILL);
        this.f5770k.setTextAlign(Paint.Align.CENTER);
        this.f5770k.setTypeface(Typeface.create("SFPRO-bold", 0));
        this.f5779t = new Rect();
    }

    /* renamed from: d */
    private void m5916d() {
        this.f5768i = new Paint();
        this.f5768i.setAntiAlias(true);
        this.f5768i.setColor(this.f5763d);
        this.f5768i.setStyle(Paint.Style.FILL);
        this.f5769j = new Paint();
        this.f5769j.setAntiAlias(true);
        this.f5769j.setColor(this.f5765f);
        this.f5769j.setStyle(Paint.Style.STROKE);
    }

    /* renamed from: b */
    private void m5914b(Context context, AttributeSet attributeSet) {
        TypedArray a = mo16972a(context, attributeSet, R.styleable.NewMessageView);
        if (a != null) {
            this.f5761b = a.getColor(R.styleable.NewMessageView_mcNewMessageTextColor, -1);
            this.f5762c = a.getDimension(R.styleable.NewMessageView_mcNewMessageTextSize, 10.0f);
            this.f5767h = (int) a.getDimension(R.styleable.NewMessageView_mcNewMessageRadius, getResources().getDimension(R.dimen.mc_new_message_view_radius));
            this.f5763d = a.getResourceId(R.styleable.NewMessageView_mcNewMessageColor, SupportMenu.CATEGORY_MASK);
            this.f5765f = a.getResourceId(R.styleable.NewMessageView_mcNewMessageBorderColor, -1);
            this.f5766g = (int) a.getDimension(R.styleable.NewMessageView_mcNewMessageBorderWidth, getResources().getDimension(R.dimen.mc_new_message_view_border_width));
            a.recycle();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public TypedArray mo16972a(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.f5780u != 1 || this.f5781v == null) {
            if (this.f5764e) {
                i4 = (this.f5767h + this.f5766g) * 2;
            } else {
                i4 = this.f5767h * 2;
            }
            i3 = i4;
        } else {
            this.f5770k.setTextSize(ResourceUtils.m5164b(this.f5762c, getContext()));
            this.f5770k.setColor(this.f5761b);
            this.f5770k.getTextBounds(this.f5781v, 0, this.f5781v.length(), this.f5779t);
            this.f5773n = this.f5779t.width() + (this.f5777r == 0 ? (int) (getResources().getDimension(R.dimen.mc_new_message_view_space_large) * 2.0f) : this.f5777r * 2);
            this.f5774o = (int) ResourceUtils.m5160a((float) (((double) this.f5762c) * 1.5d), getContext());
            if (this.f5773n < this.f5774o) {
                this.f5773n = this.f5774o;
            }
            if (this.f5764e) {
                i4 = this.f5773n + (this.f5766g * 2);
                i3 = this.f5774o + (this.f5766g * 2);
            } else {
                i4 = this.f5773n;
                i3 = this.f5774o;
            }
        }
        this.f5771l = m5910a(size, i4, this.f5775p, mode);
        this.f5772m = m5910a(size2, i3, this.f5776q, mode2);
        setMeasuredDimension(this.f5771l, this.f5772m);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f5764e && this.f5766g > 0) {
            this.f5769j.setStrokeWidth((float) this.f5766g);
            if (this.f5780u == 1) {
                float f = (float) (((double) this.f5771l) - (((double) ((this.f5771l - this.f5773n) - this.f5766g)) * 0.5d));
                float f2 = (float) (((double) (this.f5772m + this.f5774o + this.f5766g)) * 0.5d);
                float f3 = (float) ((this.f5774o / 2) + this.f5766g);
                m5911a((float) (((double) ((this.f5771l - this.f5773n) - this.f5766g)) * 0.5d), (float) (((double) ((this.f5772m - this.f5774o) - this.f5766g)) * 0.5d), f, f2);
                canvas.drawRoundRect(this.f5778s, f3, f3, this.f5769j);
            } else {
                canvas.drawCircle((float) (this.f5771l / 2), (float) (this.f5772m / 2), (float) (this.f5767h + (this.f5766g / 2)), this.f5769j);
            }
        }
        if (this.f5780u == 1) {
            m5911a((float) ((this.f5771l - this.f5773n) / 2), (float) ((this.f5772m / 2) - (this.f5774o / 2)), (float) (this.f5771l - ((this.f5771l - this.f5773n) / 2)), (float) ((this.f5772m / 2) + (this.f5774o / 2)));
            canvas.save();
            canvas.drawRoundRect(this.f5778s, (float) (this.f5774o / 2), (float) (this.f5774o / 2), this.f5768i);
            canvas.restore();
        } else {
            canvas.drawCircle((float) (this.f5771l / 2), (float) (this.f5772m / 2), (float) this.f5767h, this.f5768i);
        }
        if (this.f5781v != null) {
            canvas.save();
            if (this.f5764e) {
                canvas.drawText(this.f5781v, (float) (this.f5771l / 2), (float) (((this.f5772m - this.f5766g) - ((this.f5774o - this.f5779t.height()) / 2)) - 1), this.f5770k);
            } else {
                canvas.drawText(this.f5781v, (float) (this.f5771l / 2), (float) ((this.f5772m - ((this.f5774o - this.f5779t.height()) / 2)) - 1), this.f5770k);
            }
            canvas.restore();
        }
    }

    public int getState() {
        return this.f5780u;
    }

    public void setHide(boolean z) {
        this.f5760a = z;
        if (this.f5780u == 1) {
            setText(this.f5781v);
        } else {
            setText((String) null);
        }
    }

    /* renamed from: a */
    public boolean mo16973a() {
        return this.f5760a;
    }

    public void setText(String str) {
        if (!mo16973a() || (str != null && !str.equalsIgnoreCase("0"))) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
        this.f5781v = str;
    }

    public void setNewMessageNum(int i) {
        this.f5780u = 1;
        if (i >= 999) {
            i = 999;
        } else if (i <= 0) {
            i = 0;
        }
        setText(String.valueOf(i));
        requestLayout();
    }

    public Integer getNewMessageNum() {
        if (this.f5781v == null) {
            return 0;
        }
        try {
            return Integer.valueOf(Integer.parseInt(this.f5781v));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public void setNewMessageSpace(int i) {
        this.f5777r = i;
    }

    public void setTextSize(float f) {
        this.f5762c = f;
    }

    public void setViewMaxSize(int i, int i2) {
        this.f5775p = i;
        this.f5776q = i2;
    }

    public int getViewMaxWidth() {
        return this.f5775p;
    }

    public int getViewMaxHeight() {
        return this.f5776q;
    }

    public void setBackgroundColor(int i) {
        this.f5768i.setColor(i);
    }

    public void setNewMessageGravity(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.gravity = i;
        setLayoutParams(layoutParams);
    }

    public int getNewMessageGravity() {
        return ((FrameLayout.LayoutParams) getLayoutParams()).gravity;
    }

    public void setShowBorder(boolean z) {
        this.f5764e = z;
    }

    public void setBorderWidth(int i) {
        this.f5766g = i;
    }

    public int getBorderWidth() {
        return this.f5766g;
    }

    public void setBorderColor(int i) {
        this.f5769j.setColor(i);
    }

    public void setNewMessageMargin(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = (int) ResourceUtils.m5160a((float) i, getContext());
        layoutParams.topMargin = (int) ResourceUtils.m5160a((float) i2, getContext());
        layoutParams.rightMargin = (int) ResourceUtils.m5160a((float) i3, getContext());
        layoutParams.bottomMargin = (int) ResourceUtils.m5160a((float) i4, getContext());
        setLayoutParams(layoutParams);
    }

    public int[] getNewMessageMargin() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        return new int[]{layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin};
    }
}
