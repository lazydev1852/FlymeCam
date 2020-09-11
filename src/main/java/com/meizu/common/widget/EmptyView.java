package com.meizu.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.meizu.common.R;
import com.meizu.common.util.ResourceUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class EmptyView extends FrameLayout {

    /* renamed from: a */
    private ImageView f5094a;

    /* renamed from: b */
    private LimitedWHLinearLayout f5095b;

    /* renamed from: c */
    private TextView f5096c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f5097d;

    /* renamed from: e */
    private LinearLayout f5098e;

    /* renamed from: f */
    private View f5099f;

    /* renamed from: g */
    private Context f5100g;

    /* renamed from: h */
    private int f5101h;

    /* renamed from: i */
    private boolean f5102i;

    /* renamed from: j */
    private boolean f5103j;

    /* renamed from: k */
    private RelativeLayout f5104k;

    /* renamed from: l */
    private int f5105l;

    /* renamed from: m */
    private ArrayList<String> f5106m;

    /* renamed from: n */
    private CharSequence f5107n;

    /* renamed from: o */
    private CharSequence f5108o;

    public EmptyView(Context context) {
        this(context, (AttributeSet) null);
    }

    public EmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5100g = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.mc_empty_view, (ViewGroup) null);
        this.f5094a = (ImageView) inflate.findViewById(R.id.empty_image);
        this.f5096c = (TextView) inflate.findViewById(R.id.empty_title);
        this.f5097d = (TextView) inflate.findViewById(R.id.empty_summary);
        this.f5098e = (LinearLayout) inflate.findViewById(R.id.empty_tips_panel);
        this.f5099f = inflate.findViewById(R.id.titleDivider);
        this.f5095b = (LimitedWHLinearLayout) inflate.findViewById(R.id.content_panel);
        this.f5104k = (RelativeLayout) inflate.findViewById(R.id.layout);
        addView(inflate);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EmptyView, R.attr.MeizuCommon_EmptyViewStyle, 0);
        ((RelativeLayout.LayoutParams) this.f5094a.getLayoutParams()).topMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.EmptyView_mcTopMarginOfImage, 0);
        ((RelativeLayout.LayoutParams) this.f5095b.getLayoutParams()).topMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.EmptyView_mcTopMarginOfTips, 0);
        this.f5095b.setMaxWidth(this.f5100g.getResources().getDimensionPixelSize(R.dimen.mc_empty_content_panel_max_width));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.EmptyView_mcSrcOfImage);
        if (drawable != null) {
            this.f5094a.setImageDrawable(drawable);
        }
        this.f5107n = obtainStyledAttributes.getString(R.styleable.EmptyView_mcTitle);
        this.f5108o = obtainStyledAttributes.getString(R.styleable.EmptyView_mcSummary);
        String string = obtainStyledAttributes.getString(R.styleable.EmptyView_mcTextOfTips);
        this.f5106m = ResourceUtils.m5163a(getContext(), obtainStyledAttributes, R.styleable.EmptyView_mcTips);
        this.f5103j = obtainStyledAttributes.getBoolean(R.styleable.EmptyView_mcIsShowDot, true);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = this.f5100g.obtainStyledAttributes(R.styleable.MZTheme);
        this.f5101h = obtainStyledAttributes2.getInt(R.styleable.MZTheme_mzThemeColor, ViewCompat.MEASURED_STATE_MASK);
        obtainStyledAttributes2.recycle();
        TypedArray obtainStyledAttributes3 = this.f5100g.obtainStyledAttributes(R.styleable.EmptyView);
        this.f5097d.setTextAppearance(getContext(), obtainStyledAttributes3.getResourceId(R.styleable.EmptyView_mcSummaryTextAppearance, R.style.TextAppearance_Small_EmptyView_Summary));
        this.f5096c.setTextAppearance(getContext(), obtainStyledAttributes3.getResourceId(R.styleable.EmptyView_mcTitleTextAppearance, R.style.TextAppearance_Small_EmptyView_Title));
        setTitle(this.f5107n);
        setSummary(this.f5108o);
        if (string == null) {
            setTextOfTips(this.f5106m);
        } else {
            setTextOfTips(string);
        }
        obtainStyledAttributes3.recycle();
        m5633a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f5094a.getDrawable() == null) {
            this.f5105l = (int) (((double) ((RelativeLayout) this.f5104k.getParent()).getMeasuredHeight()) * 0.48d);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f5104k.getLayoutParams();
            layoutParams.addRule(10);
            layoutParams.topMargin = this.f5105l;
            this.f5104k.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: a */
    private void m5633a() {
        if (!TextUtils.isEmpty(this.f5107n) && TextUtils.isEmpty(this.f5108o) && (this.f5106m == null || this.f5106m.size() == 0)) {
            this.f5096c.setPadding(this.f5096c.getPaddingLeft(), getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_line_space), this.f5096c.getPaddingRight(), this.f5096c.getPaddingBottom());
        } else if (!TextUtils.isEmpty(this.f5107n) && this.f5106m != null && this.f5106m.size() > 0) {
            ((LinearLayout.LayoutParams) this.f5096c.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(R.dimen.mc_empty_title_margin_top);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.f5094a != null) {
            this.f5094a.setImageDrawable(drawable);
        }
    }

    public void setImageResource(int i) {
        if (this.f5094a != null) {
            this.f5094a.setImageResource(i);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EmptyView.class.getName());
    }

    public void setTextOfTips(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        setTextOfTips((ArrayList<String>) arrayList);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void setTextOfTips(ArrayList<String> arrayList) {
        this.f5106m = arrayList == null ? new ArrayList<>() : arrayList;
        this.f5098e.removeAllViews();
        if (this.f5106m == null || this.f5106m.size() == 0) {
            this.f5099f.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = this.f5100g.getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_margin_Bottom);
        layoutParams2.topMargin = this.f5100g.getResources().getDimensionPixelSize(R.dimen.mc_empty_dot_margin_top);
        layoutParams2.rightMargin = this.f5100g.getResources().getDimensionPixelSize(R.dimen.mc_empty_dot_margin_right);
        float dimensionPixelSize = (float) this.f5100g.getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_line_space);
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.mc_default_word_point);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            LinearLayout linearLayout = new LinearLayout(this.f5100g);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(48);
            if (this.f5103j) {
                ImageView imageView = new ImageView(this.f5100g);
                imageView.setLayoutParams(layoutParams2);
                imageView.setImageDrawable(drawable);
                linearLayout.addView(imageView);
            }
            TextView textView = new TextView(this.f5100g);
            textView.setLayoutParams(layoutParams3);
            textView.setTextAppearance(getContext(), R.style.TextAppearance_Small_EmptyView);
            textView.setText(next);
            textView.setLineSpacing(dimensionPixelSize, 1.0f);
            linearLayout.addView(textView);
            this.f5098e.addView(linearLayout);
        }
        if (!TextUtils.isEmpty(this.f5107n) || !TextUtils.isEmpty(this.f5108o)) {
            this.f5099f.setVisibility(0);
        }
    }

    public void setSummary(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f5097d.setVisibility(8);
            return;
        }
        this.f5108o = charSequence;
        this.f5097d.setText(charSequence);
        this.f5097d.setAutoLinkMask(15);
        ViewTreeObserver viewTreeObserver = this.f5097d.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    EmptyView.this.f5097d.getViewTreeObserver().removeOnPreDrawListener(this);
                    EmptyView.this.f5097d.post(new Runnable() {
                        public void run() {
                            EmptyView.this.f5097d.setMovementMethod(LinkMovementMethod.getInstance());
                        }
                    });
                    return true;
                }
            });
        } else {
            this.f5097d.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.f5097d.setLinkTextColor(this.f5101h);
        this.f5097d.setVisibility(0);
        if (this.f5106m != null && this.f5106m.size() > 0) {
            this.f5099f.setVisibility(0);
        }
    }

    public void setEmptyMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f5104k.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.topMargin = i;
        this.f5104k.setLayoutParams(layoutParams);
    }

    public void setEmptyMarginBottom(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f5104k.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.bottomMargin = i;
        this.f5104k.setLayoutParams(layoutParams);
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f5096c.setVisibility(8);
            return;
        }
        this.f5107n = charSequence;
        this.f5096c.setText(charSequence);
        this.f5096c.setVisibility(0);
        if (this.f5106m != null && this.f5106m.size() > 0) {
            this.f5099f.setVisibility(0);
        }
    }

    public void setIgnoreSoftInput(boolean z) {
        this.f5102i = z;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f5095b.getLayoutParams();
        if (!z) {
            layoutParams.bottomMargin = this.f5100g.getResources().getDimensionPixelSize(R.dimen.mc_keyboard_approximate_height);
        } else {
            layoutParams.bottomMargin = 0;
        }
    }

    public void setTitleColor(int i) {
        this.f5096c.setTextColor(i);
    }

    public void setSummaryColor(int i) {
        this.f5097d.setTextColor(i);
    }

    public void setTitleTextSize(float f) {
        this.f5096c.setTextSize(f);
    }

    public void setIsShowDot(boolean z) {
        if (this.f5103j != z) {
            this.f5103j = z;
            setTextOfTips(this.f5106m);
        }
    }

    public void setContentPanelMaxWidth(int i) {
        this.f5095b.setMaxWidth(i);
    }
}
