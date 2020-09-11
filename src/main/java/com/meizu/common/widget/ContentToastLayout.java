package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.meizu.common.R;

public class ContentToastLayout extends FrameLayout {

    /* renamed from: a */
    private Drawable f4863a;

    /* renamed from: b */
    private Drawable f4864b;

    /* renamed from: c */
    private String f4865c;

    /* renamed from: d */
    private Drawable f4866d;

    /* renamed from: e */
    private Drawable f4867e;

    /* renamed from: f */
    private Drawable f4868f;

    /* renamed from: g */
    private TextView f4869g;

    /* renamed from: h */
    private ImageView f4870h;

    /* renamed from: i */
    private ImageView f4871i;

    /* renamed from: j */
    private TextView f4872j;

    /* renamed from: k */
    private LinearLayout f4873k;

    /* renamed from: l */
    private LinearLayout f4874l;

    /* renamed from: m */
    private View f4875m;

    /* renamed from: n */
    private LinearLayout f4876n;

    /* renamed from: o */
    private int f4877o;

    /* renamed from: p */
    private int f4878p;

    /* renamed from: q */
    private int f4879q;

    /* renamed from: r */
    private int f4880r;

    public ContentToastLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ContentToastLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzContentToastLayoutStyle);
    }

    public ContentToastLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4880r = 2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.mzContentToastLayout, i, 0);
        this.f4877o = obtainStyledAttributes.getResourceId(R.styleable.mzContentToastLayout_mzActionTextAppearance, 0);
        this.f4878p = obtainStyledAttributes.getResourceId(R.styleable.mzContentToastLayout_mzTitleTextAppearance, 0);
        this.f4864b = obtainStyledAttributes.getDrawable(R.styleable.mzContentToastLayout_mzContentToastBackground);
        this.f4868f = obtainStyledAttributes.getDrawable(R.styleable.mzContentToastLayout_mzActionIcon);
        this.f4863a = obtainStyledAttributes.getDrawable(R.styleable.mzContentToastLayout_mzActionViewBackground);
        obtainStyledAttributes.recycle();
        this.f4879q = (int) ((getResources().getDisplayMetrics().density * 32.0f) + 0.5f);
        LayoutInflater.from(context).inflate(R.layout.mc_content_toast_layout, this);
        this.f4874l = (LinearLayout) findViewById(R.id.mc_content_toast_parent);
        this.f4874l.setBackgroundDrawable(this.f4864b);
        this.f4873k = (LinearLayout) findViewById(16908312);
        this.f4869g = (TextView) findViewById(16908310);
        this.f4869g.setTextAppearance(context, this.f4878p);
        this.f4870h = (ImageView) findViewById(16908294);
        this.f4875m = findViewById(R.id.mc_toast_separator);
        this.f4876n = (LinearLayout) findViewById(R.id.mc_content_toast_container);
        this.f4872j = (TextView) findViewById(R.id.mz_action_text);
        this.f4871i = (ImageView) findViewById(R.id.mz_action_icon);
    }

    public String getText() {
        return this.f4865c;
    }

    public void setText(String str) {
        this.f4865c = str;
        this.f4869g.setText(str);
    }

    public void setTitleTextMaxLine(int i) {
        this.f4869g.setMaxLines(i);
    }

    public void setWarningIcon(Drawable drawable) {
        this.f4866d = drawable;
        this.f4870h.setImageDrawable(this.f4866d);
    }

    public void setActionIcon(Drawable drawable) {
        m5406a();
        this.f4868f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f4879q) {
                float f = ((float) this.f4879q) / ((float) intrinsicWidth);
                intrinsicWidth = this.f4879q;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f4879q) {
                float f2 = ((float) this.f4879q) / ((float) intrinsicHeight);
                intrinsicHeight = this.f4879q;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f2);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        this.f4871i.setImageDrawable(drawable);
    }

    public void setActionClickListener(View.OnClickListener onClickListener) {
        m5406a();
        this.f4873k.setOnClickListener(onClickListener);
    }

    public void setActionText(CharSequence charSequence) {
        m5406a();
        this.f4872j.setText(charSequence);
    }

    /* renamed from: a */
    private void m5406a() {
        switch (this.f4880r) {
            case 0:
            case 1:
                this.f4871i.setVisibility(0);
                this.f4872j.setVisibility(8);
                return;
            case 2:
                this.f4872j.setVisibility(0);
                this.f4871i.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ContentToastLayout.class.getName());
    }

    public void setBackground(Drawable drawable) {
        this.f4874l.setBackgroundDrawable(drawable);
    }

    public void setTextColor(int i) {
        this.f4869g.setTextColor(i);
    }

    public void setIsShowSeparator(boolean z) {
        if (z) {
            this.f4875m.setVisibility(0);
        } else {
            this.f4875m.setVisibility(8);
        }
    }

    public void setContainerLayoutPadding(int i) {
        this.f4876n.setPadding(i, 0, i, 0);
    }

    public void setParentLayoutPadding(int i) {
        this.f4874l.setPadding(i, 0, i, 0);
    }

    public void setToastType(int i) {
        this.f4880r = i;
        switch (i) {
            case 0:
                setWarningIcon((Drawable) null);
                setActionIcon(this.f4868f);
                return;
            case 1:
                this.f4867e = getResources().getDrawable(R.drawable.mz_ic_content_toast_warning);
                setWarningIcon(this.f4867e);
                setActionIcon(getResources().getDrawable(R.drawable.mz_arrow_next_right_warning));
                this.f4869g.setTextColor(getResources().getColor(R.color.mc_content_toast_text_color_error));
                this.f4874l.setBackgroundDrawable(getResources().getDrawable(R.drawable.mc_content_toast_bg_error));
                this.f4870h.setVisibility(0);
                return;
            case 2:
                break;
            default:
                this.f4869g.setTextAppearance(getContext(), this.f4878p);
                this.f4874l.setBackgroundDrawable(this.f4864b);
                this.f4870h.setVisibility(8);
                break;
        }
        setActionIcon((Drawable) null);
        setWarningIcon((Drawable) null);
    }

    public void setTitleGravity(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4869g.getLayoutParams();
        int i2 = i & 112;
        if (i2 == 16) {
            layoutParams.addRule(15);
        } else if (i2 == 48) {
            layoutParams.addRule(10);
        } else if (i2 == 80) {
            layoutParams.addRule(12);
        }
        int i3 = i & 7;
        if (i3 == 1) {
            layoutParams.addRule(14);
        } else if (i3 == 3) {
            layoutParams.addRule(9);
        } else if (i3 == 5) {
            layoutParams.addRule(11);
        }
        layoutParams.addRule(14);
        this.f4869g.setLayoutParams(layoutParams);
    }

    public void setLayoutBackground(Drawable drawable) {
        this.f4864b = drawable;
        this.f4874l.setBackgroundDrawable(this.f4864b);
    }
}
