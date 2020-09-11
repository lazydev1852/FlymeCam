package flyme.support.p093v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import flyme.support.p093v7.appcompat.R;
import flyme.support.p093v7.p094a.RippleDrawableComp;

/* renamed from: flyme.support.v7.widget.ControlTitleBar */
public class ControlTitleBar extends LinearLayoutCompat {

    /* renamed from: a */
    private final TextView f17562a;

    /* renamed from: b */
    private final TextView f17563b;

    /* renamed from: c */
    private View f17564c;

    /* renamed from: d */
    private View f17565d;

    /* renamed from: e */
    private View f17566e;

    /* renamed from: f */
    private int f17567f;

    /* renamed from: g */
    private int f17568g;

    /* renamed from: h */
    private int f17569h;

    /* renamed from: i */
    private int f17570i;

    /* renamed from: j */
    private CharSequence f17571j;

    /* renamed from: k */
    private CharSequence f17572k;

    /* renamed from: l */
    private int f17573l;

    /* renamed from: m */
    private int f17574m;

    /* renamed from: n */
    private int f17575n;

    /* renamed from: a */
    protected static int m19227a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    /* renamed from: a */
    private boolean m19229a(int i, int i2, int i3, int i4, boolean z) {
        return z ? i2 + i >= i3 || i <= i4 : i <= i3 || i + i2 >= i4;
    }

    public ControlTitleBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public ControlTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzControlTitleBarStyle);
    }

    public ControlTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17573l = 17;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.MzControlTitleBar, i, 0);
        this.f17569h = obtainStyledAttributes.getResourceId(R.styleable.MzControlTitleBar_titleTextStyle, 0);
        this.f17570i = obtainStyledAttributes.getResourceId(R.styleable.MzControlTitleBar_subtitleTextStyle, 0);
        this.f17567f = obtainStyledAttributes.getResourceId(R.styleable.MzControlTitleBar_mzNegativeButtonLayout, R.layout.mz_control_title_bar_negative_item);
        this.f17568g = obtainStyledAttributes.getResourceId(R.styleable.MzControlTitleBar_mzPositiveButtonLayout, R.layout.mz_control_title_bar_positive_item);
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.f17575n = getResources().getDimensionPixelSize(R.dimen.mz_action_bar_control_title_bar_min_title_width);
        this.f17564c = from.inflate(this.f17567f, this, false);
        addView(this.f17564c);
        this.f17565d = from.inflate(this.f17568g, this, false);
        addView(this.f17565d);
        if (Build.VERSION.SDK_INT < 21) {
            this.f17564c.setBackgroundDrawable(new C3195a(this.f17564c));
            this.f17565d.setBackgroundDrawable(new C3195a(this.f17565d));
            setClipChildren(false);
        }
        this.f17566e = from.inflate(R.layout.mz_action_bar_title_item, this, false);
        addView(this.f17566e);
        this.f17562a = (TextView) this.f17566e.findViewById(R.id.action_bar_title);
        this.f17563b = (TextView) this.f17566e.findViewById(R.id.action_bar_subtitle);
        if (this.f17569h != 0) {
            this.f17562a.setTextAppearance(getContext(), this.f17569h);
        }
        if (this.f17570i != 0) {
            this.f17563b.setTextAppearance(getContext(), this.f17570i);
        }
        this.f17574m = (int) (getResources().getDisplayMetrics().density * 104.0f);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2) - paddingTop, Integer.MIN_VALUE);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f17565d.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f17564c.getLayoutParams();
        int a = (this.f17564c == null || this.f17564c.getVisibility() == 8) ? 0 : mo26012a(this.f17564c, paddingLeft, makeMeasureSpec, 0) + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
        int a2 = (this.f17565d == null || this.f17565d.getVisibility() == 8) ? 0 : mo26012a(this.f17565d, paddingLeft, makeMeasureSpec, 0) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        if (!(this.f17564c == null || this.f17565d == null || a + a2 <= paddingLeft)) {
            if (a < a2) {
                int i3 = paddingLeft / 2;
                if (a <= i3) {
                    a2 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + mo26012a(this.f17565d, ((paddingLeft - a) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, makeMeasureSpec, 0);
                } else {
                    int a3 = mo26012a(this.f17565d, (i3 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, makeMeasureSpec, 0) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    a = mo26012a(this.f17564c, (i3 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, makeMeasureSpec, 0) + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                    a2 = a3;
                }
            } else {
                int i4 = paddingLeft / 2;
                if (a2 <= i4) {
                    a = marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin + mo26012a(this.f17564c, ((paddingLeft - a2) - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, makeMeasureSpec, 0);
                } else {
                    a2 = mo26012a(this.f17565d, (i4 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, makeMeasureSpec, 0) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    a = marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin + mo26012a(this.f17564c, (i4 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, makeMeasureSpec, 0);
                }
            }
        }
        if (this.f17564c != null) {
            paddingLeft -= a;
        }
        if (this.f17565d != null) {
            paddingLeft -= a2;
        }
        if (paddingLeft <= this.f17575n) {
            paddingLeft = 0;
        }
        if (this.f17566e != null) {
            mo26012a(this.f17566e, paddingLeft, makeMeasureSpec, 0);
        }
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            int measuredHeight = getChildAt(i6).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i5) {
                i5 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo26012a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return view.getMeasuredWidth() + i3;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        boolean a = C3352x.m20913a((View) this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f17564c == null || this.f17564c.getVisibility() == 8) {
            i5 = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f17564c.getLayoutParams();
            int i7 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i8 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a2 = m19227a(paddingRight, i7, a);
            i5 = m19227a(a2 + mo26013a(this.f17564c, a2, paddingTop, paddingTop2, a), i8, a);
            setBackgroundHotspotBounds(this.f17564c);
        }
        int paddingLeft = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.f17565d == null || this.f17565d.getVisibility() == 8) {
            i6 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f17565d.getLayoutParams();
            int i9 = a ? marginLayoutParams2.rightMargin : marginLayoutParams2.leftMargin;
            int a3 = m19227a(paddingLeft, a ? marginLayoutParams2.leftMargin : marginLayoutParams2.rightMargin, !a);
            i6 = m19227a(a3 + mo26013a(this.f17565d, a3, paddingTop, paddingTop2, !a), i9, !a);
            setBackgroundHotspotBounds(this.f17565d);
        }
        int i10 = i6;
        if (this.f17566e != null && this.f17566e.getVisibility() != 8) {
            int measuredWidth = this.f17566e.getMeasuredWidth();
            int i11 = (this.f17573l & 7) == 1 ? ((i3 - i) - measuredWidth) / 2 : 0;
            if (m19229a(i11, measuredWidth, i5, i10, a)) {
                mo26013a(this.f17566e, i5, paddingTop, paddingTop2, a);
            } else {
                mo26013a(this.f17566e, i11, paddingTop, paddingTop2, false);
            }
        }
    }

    private void setBackgroundHotspotBounds(View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int width = view.getWidth();
            int i = ((paddingLeft - paddingRight) + width) / 2;
            int i2 = ((width - paddingLeft) - paddingRight) / 2;
            DrawableCompat.setHotspotBounds(background, i - i2, 0, i + i2, view.getHeight());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo26013a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public CharSequence getTitle() {
        return this.f17571j;
    }

    public void setTitle(CharSequence charSequence) {
        this.f17571j = charSequence;
        m19228a();
    }

    public void setTitleColor(int i) {
        if (this.f17562a != null && !TextUtils.isEmpty(this.f17562a.getText())) {
            this.f17562a.setTextColor(i);
        }
    }

    public CharSequence getSubTitle() {
        return this.f17572k;
    }

    public void setSubTitle(CharSequence charSequence) {
        this.f17572k = charSequence;
        m19228a();
    }

    /* renamed from: a */
    private void m19228a() {
        this.f17562a.setText(this.f17571j);
        this.f17563b.setText(this.f17572k);
        boolean z = !TextUtils.isEmpty(this.f17571j);
        boolean z2 = !TextUtils.isEmpty(this.f17572k);
        int i = 8;
        this.f17563b.setVisibility(z2 ? 0 : 8);
        View view = this.f17566e;
        if (z || z2) {
            i = 0;
        }
        view.setVisibility(i);
    }

    public void setOnPositiveItemClickListener(View.OnClickListener onClickListener) {
        if (this.f17565d != null) {
            this.f17565d.setOnClickListener(onClickListener);
        }
    }

    public void setOnNegativeItemClickListener(View.OnClickListener onClickListener) {
        if (this.f17564c != null) {
            this.f17564c.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(int i, View.OnClickListener onClickListener) {
        switch (i) {
            case 0:
                if (this.f17564c != null) {
                    this.f17564c.setOnClickListener(onClickListener);
                    return;
                }
                return;
            case 1:
                if (this.f17565d != null) {
                    this.f17565d.setOnClickListener(onClickListener);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException("Item does not exist");
        }
    }

    public View getNegativeItemView() {
        return this.f17564c;
    }

    public View getPositiveItemView() {
        return this.f17565d;
    }

    /* renamed from: flyme.support.v7.widget.ControlTitleBar$a */
    private class C3195a extends RippleDrawableComp {
        public C3195a(View view) {
            super(view, R.attr.mzActionButtonRippleSplitStyle);
        }
    }

    public void setItemMaxWidth(int i) {
        this.f17574m = i;
    }

    public void setButton(int i, CharSequence charSequence, Drawable drawable, View.OnClickListener onClickListener) {
        View view;
        if (i == 1) {
            try {
                view = this.f17565d;
            } catch (ClassCastException unused) {
                throw new IllegalStateException("the item view of ControlTitleBar is not a TextView, please check the style of mzControlTitleBarStyle ");
            }
        } else {
            view = this.f17564c;
        }
        TextView textView = (TextView) view;
        textView.setText(charSequence);
        if (drawable != null) {
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            textView.setCompoundDrawables(isEmpty ? drawable : null, isEmpty ? null : drawable, (Drawable) null, (Drawable) null);
        }
        textView.setOnClickListener(onClickListener);
        if (TextUtils.isEmpty(charSequence) && drawable == null) {
            textView.setVisibility(8);
        }
    }

    public TextView getTitleView() {
        return this.f17562a;
    }
}
