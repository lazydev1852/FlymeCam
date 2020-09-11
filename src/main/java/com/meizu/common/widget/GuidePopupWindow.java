package com.meizu.common.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.meizu.common.R;

public class GuidePopupWindow extends PopupWindow {

    /* renamed from: a */
    private HandleView f5380a;

    /* renamed from: b */
    private Context f5381b;

    /* renamed from: c */
    private View f5382c;

    /* renamed from: d */
    private int f5383d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1447a f5384e;

    /* renamed from: com.meizu.common.widget.GuidePopupWindow$a */
    public interface C1447a {
        /* renamed from: a */
        void mo16768a(GuidePopupWindow guidePopupWindow);
    }

    public GuidePopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuidePopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public GuidePopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f5383d = 6;
        this.f5381b = context;
        setTouchable(true);
        setOutsideTouchable(true);
        setClippingEnabled(false);
        setWindowLayoutMode(-2, -2);
        setInputMethodMode(2);
        setBackgroundDrawable(new ColorDrawable(0));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.GuidePopupWindow, R.attr.MeizuCommon_GuidePopupWindow, i2);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.GuidePopupWindow_mcGPWBackGroundLeft);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.GuidePopupWindow_mcGPWBackGroundMidArrowDown);
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.GuidePopupWindow_mcGPWBackGroundMidArrowUp);
        Drawable drawable4 = obtainStyledAttributes.getDrawable(R.styleable.GuidePopupWindow_mcGPWBackGroundRight);
        obtainStyledAttributes.recycle();
        if (drawable == null || drawable2 == null || drawable3 == null || drawable4 == null) {
            drawable = context.getResources().getDrawable(R.drawable.mz_guide_left_color_blue);
            drawable2 = context.getResources().getDrawable(R.drawable.mz_guide_middle_down_color_blue);
            drawable3 = context.getResources().getDrawable(R.drawable.mz_guide_middle_up_color_blue);
            drawable4 = context.getResources().getDrawable(R.drawable.mz_guide_right_color_blue);
        }
        this.f5380a = new HandleView(this.f5381b, drawable, drawable2, drawable3, drawable4);
        setContentView(this.f5380a);
    }

    @TargetApi(19)
    public void update(int i, int i2, int i3, int i4, boolean z) {
        if (Build.VERSION.SDK_INT < 19 || this.f5382c.isAttachedToWindow()) {
            super.update(i, i2, i3, i4, z);
        }
    }

    private class HandleView extends FrameLayout {

        /* renamed from: b */
        private int f5386b = R.layout.mc_guide_popup_window;

        /* renamed from: c */
        private int f5387c;

        /* renamed from: d */
        private Drawable f5388d;

        /* renamed from: e */
        private Drawable f5389e;

        /* renamed from: f */
        private Drawable f5390f;

        /* renamed from: g */
        private Rect f5391g = new Rect();

        /* renamed from: h */
        private int f5392h;

        /* renamed from: i */
        private int f5393i;

        /* renamed from: j */
        private int f5394j;

        /* renamed from: k */
        private int f5395k;

        /* renamed from: l */
        private TextView f5396l;

        /* renamed from: m */
        private ImageView f5397m;

        /* renamed from: n */
        private LinearLayout f5398n;

        /* renamed from: o */
        private View f5399o;

        /* renamed from: p */
        private View f5400p;

        /* renamed from: q */
        private View f5401q;

        /* renamed from: r */
        private LinearLayout f5402r;

        /* renamed from: s */
        private int f5403s;

        /* renamed from: t */
        private int f5404t;

        /* renamed from: u */
        private Drawable f5405u;

        /* renamed from: v */
        private int f5406v = -1;

        /* renamed from: w */
        private boolean f5407w = true;

        /* renamed from: x */
        private Resources f5408x;

        HandleView(Context context, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            super(context);
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(this.f5386b, this, true);
            this.f5408x = context.getResources();
            this.f5396l = (TextView) inflate.findViewById(R.id.guide_message);
            this.f5397m = (ImageView) inflate.findViewById(R.id.guide_close);
            this.f5398n = (LinearLayout) inflate.findViewById(R.id.guide_content);
            this.f5399o = inflate.findViewById(R.id.guide_bg_left);
            this.f5400p = inflate.findViewById(R.id.guide_bg_middle);
            this.f5401q = inflate.findViewById(R.id.guide_bg_right);
            this.f5402r = (LinearLayout) inflate.findViewById(R.id.guide_bg_vertical);
            this.f5387c = this.f5408x.getDimensionPixelSize(R.dimen.mc_guide_popup_min_height);
            this.f5388d = drawable;
            this.f5389e = drawable2;
            this.f5405u = drawable3;
            this.f5390f = drawable4;
            this.f5399o.setBackgroundDrawable(this.f5388d);
            this.f5401q.setBackgroundDrawable(this.f5390f);
            this.f5400p.setBackgroundDrawable(this.f5389e);
            this.f5403s = this.f5408x.getDimensionPixelSize(R.dimen.mc_guide_popup_arrow_padding);
            this.f5404t = this.f5408x.getDimensionPixelSize(R.dimen.mc_guide_popup_marging);
            Rect rect = new Rect();
            this.f5388d.getPadding(rect);
            this.f5391g.left = Math.max(rect.left, this.f5391g.left);
            this.f5391g.top = Math.max(rect.top, this.f5391g.top);
            this.f5391g.bottom = Math.max(rect.bottom, this.f5391g.bottom);
            this.f5389e.getPadding(rect);
            this.f5391g.top = Math.max(rect.top, this.f5391g.top);
            this.f5391g.bottom = Math.max(rect.bottom, this.f5391g.bottom);
            this.f5390f.getPadding(rect);
            this.f5391g.right = Math.max(rect.right, this.f5391g.right);
            this.f5391g.top = Math.max(rect.top, this.f5391g.top);
            this.f5391g.bottom = Math.max(rect.bottom, this.f5391g.bottom);
            this.f5393i = this.f5388d.getIntrinsicWidth();
            this.f5394j = this.f5389e.getIntrinsicWidth();
            this.f5395k = this.f5390f.getIntrinsicWidth();
            this.f5392h = this.f5393i + this.f5394j + this.f5395k;
            this.f5398n.setMinimumWidth(this.f5392h);
            this.f5398n.setMinimumHeight(this.f5387c + this.f5391g.top + this.f5391g.bottom);
            this.f5398n.setPadding(this.f5391g.left, this.f5391g.top, this.f5391g.right, this.f5391g.bottom);
            this.f5397m.setOnClickListener(new View.OnClickListener(GuidePopupWindow.this) {
                public void onClick(View view) {
                    if (GuidePopupWindow.this.f5384e != null) {
                        GuidePopupWindow.this.f5384e.mo16768a(GuidePopupWindow.this);
                    }
                    GuidePopupWindow.this.dismiss();
                }
            });
        }

        public void setText(String str) {
            this.f5396l.setText(str);
        }

        public TextView getMessageTextView() {
            return this.f5396l;
        }

        public void setMessageOnClickListener(View.OnClickListener onClickListener) {
            this.f5396l.setOnClickListener(onClickListener);
        }

        public void setTextSize(int i) {
            this.f5396l.setTextSize(1, (float) i);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            this.f5398n.measure(0, 0);
            int measuredHeight = this.f5398n.getMeasuredHeight();
            int measuredWidth = this.f5398n.getMeasuredWidth();
            setMeasuredDimension(measuredWidth, measuredHeight);
            this.f5402r.measure(measuredWidth, measuredHeight);
            if (!this.f5407w) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f5399o.getLayoutParams();
                layoutParams.width = measuredWidth - this.f5390f.getMinimumWidth();
                layoutParams.height = measuredHeight;
                this.f5399o.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f5401q.getLayoutParams();
                layoutParams2.width = this.f5390f.getMinimumWidth();
                layoutParams2.height = measuredHeight;
                this.f5401q.setLayoutParams(layoutParams2);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f5400p.getLayoutParams();
                layoutParams3.width = 0;
                layoutParams3.height = measuredHeight;
                this.f5400p.setLayoutParams(layoutParams3);
            } else if (this.f5406v > 0) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f5399o.getLayoutParams();
                layoutParams4.width = this.f5406v;
                layoutParams4.height = measuredHeight;
                this.f5399o.setLayoutParams(layoutParams4);
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f5401q.getLayoutParams();
                layoutParams5.width = (measuredWidth - this.f5389e.getMinimumWidth()) - this.f5406v;
                layoutParams5.height = measuredHeight;
                this.f5401q.setLayoutParams(layoutParams5);
                LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.f5400p.getLayoutParams();
                layoutParams6.width = this.f5389e.getMinimumWidth();
                layoutParams6.height = measuredHeight;
                this.f5400p.setLayoutParams(layoutParams6);
            } else {
                LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.f5399o.getLayoutParams();
                layoutParams7.width = (measuredWidth - this.f5389e.getMinimumWidth()) / 2;
                layoutParams7.height = measuredHeight;
                this.f5399o.setLayoutParams(layoutParams7);
                LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.f5401q.getLayoutParams();
                layoutParams8.width = (measuredWidth - this.f5389e.getMinimumWidth()) / 2;
                layoutParams8.height = measuredHeight;
                this.f5401q.setLayoutParams(layoutParams8);
                LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.f5400p.getLayoutParams();
                layoutParams9.width = this.f5389e.getMinimumWidth();
                layoutParams9.height = measuredHeight;
                this.f5400p.setLayoutParams(layoutParams9);
            }
        }

        private void setMessageWidth(int i) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f5396l.getLayoutParams();
            layoutParams.width = i;
            this.f5396l.setLayoutParams(layoutParams);
        }

        private int getPopMarging() {
            return this.f5404t;
        }

        public int getArrowPadding() {
            return this.f5403s;
        }

        public int getPaddingLeft() {
            return this.f5391g.left;
        }

        public int getCloseIconWidth() {
            return this.f5397m.getMeasuredWidth();
        }

        public void setArrowUp() {
            this.f5400p.setBackgroundDrawable(this.f5405u);
        }

        public void setArrowDown() {
            this.f5400p.setBackgroundDrawable(this.f5389e);
        }

        public int getArrowWidth() {
            return this.f5389e.getMinimumWidth();
        }

        public void setArrowPosition(int i) {
            this.f5406v = i;
        }

        public int getBackgroundMinWidth() {
            return this.f5392h;
        }

        public int getBackgroundLeftMinWidth() {
            return this.f5393i;
        }

        public int getBackgroundMidMinWidth() {
            return this.f5394j;
        }

        public int getBackgroundRightMinWidth() {
            return this.f5395k;
        }
    }
}
