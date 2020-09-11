package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.meizu.common.R;
import com.meizu.common.util.ResourceUtils;

public class NewBadgeView extends ViewGroup {

    /* renamed from: a */
    public static int f5723a = 0;

    /* renamed from: b */
    public static int f5724b = 1;

    /* renamed from: c */
    public static int f5725c = 2;

    /* renamed from: d */
    public static int f5726d = 3;

    /* renamed from: e */
    public static int f5727e = 4;

    /* renamed from: f */
    public static int f5728f = 5;

    /* renamed from: g */
    public static int f5729g = 6;

    /* renamed from: h */
    public static int f5730h = 7;

    /* renamed from: i */
    public static int f5731i = 8;

    /* renamed from: j */
    public static int f5732j = 0;

    /* renamed from: k */
    public static int f5733k = 1;

    /* renamed from: l */
    public static int f5734l = 0;

    /* renamed from: m */
    public static int f5735m = 1;

    /* renamed from: n */
    public static int f5736n = 2;

    /* renamed from: o */
    public static int f5737o = 3;

    /* renamed from: p */
    private static int f5738p = f5725c;

    /* renamed from: q */
    private static int f5739q = f5733k;

    /* renamed from: r */
    private static Boolean f5740r = false;

    /* renamed from: A */
    private Drawable f5741A;

    /* renamed from: B */
    private int f5742B;

    /* renamed from: C */
    private float f5743C;

    /* renamed from: D */
    private TextView f5744D;

    /* renamed from: E */
    private ImageView f5745E;

    /* renamed from: F */
    private View f5746F;

    /* renamed from: G */
    private NewMessageView f5747G;

    /* renamed from: H */
    private int f5748H;

    /* renamed from: I */
    private int f5749I;

    /* renamed from: J */
    private int f5750J;

    /* renamed from: K */
    private int f5751K;

    /* renamed from: s */
    private int f5752s;

    /* renamed from: t */
    private int f5753t;

    /* renamed from: u */
    private int f5754u;

    /* renamed from: v */
    private Boolean f5755v;

    /* renamed from: w */
    private int f5756w;

    /* renamed from: x */
    private int f5757x;

    /* renamed from: y */
    private int f5758y;

    /* renamed from: z */
    private String f5759z;

    public NewBadgeView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public NewBadgeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewBadgeView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.f5752s = -1;
        this.f5757x = f5739q;
        this.f5758y = f5738p;
        m5908a(context, attributeSet, i);
        m5907a(context);
    }

    /* renamed from: a */
    private void m5907a(Context context) {
        LayoutInflater from = LayoutInflater.from(context);
        this.f5745E = (ImageView) from.inflate(R.layout.mc_badge_view_image_item, this, false);
        this.f5744D = (TextView) from.inflate(R.layout.mc_badge_view_text_item, this, false);
        if (this.f5757x == f5732j) {
            if (this.f5759z != null && !this.f5759z.equals("")) {
                this.f5744D.setText(this.f5759z);
            }
            addView(this.f5744D);
        } else if (this.f5757x == f5733k) {
            if (this.f5742B != 0) {
                this.f5745E.setImageResource(this.f5742B);
            }
            addView(this.f5745E);
        }
        this.f5746F = from.inflate(R.layout.mc_badge_view_point_view_item, this, false);
        addView(this.f5746F);
        this.f5747G = (NewMessageView) findViewById(R.id.mz_new_message_view);
        this.f5753t = this.f5747G.getViewMaxHeight();
        this.f5754u = this.f5747G.getViewMaxWidth();
        setShowPointViewBorder(this.f5755v.booleanValue());
    }

    /* renamed from: a */
    private void m5908a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.mzNewBadgeView);
        this.f5757x = obtainStyledAttributes.getInt(R.styleable.mzNewBadgeView_mcContentViewType, f5739q);
        if (this.f5757x == f5732j) {
            this.f5758y = obtainStyledAttributes.getInt(R.styleable.mzNewBadgeView_mcPointCenterLocation, f5726d);
        } else {
            this.f5758y = obtainStyledAttributes.getInt(R.styleable.mzNewBadgeView_mcPointCenterLocation, f5738p);
        }
        this.f5755v = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.mzNewBadgeView_mcPointViewBorderShow, f5740r.booleanValue()));
        this.f5756w = (int) ResourceUtils.m5160a((float) obtainStyledAttributes.getInt(R.styleable.mzNewBadgeView_mcPointViewBorder, 0), context);
        if (this.f5756w > 0) {
            this.f5755v = true;
        }
        this.f5759z = obtainStyledAttributes.getString(R.styleable.mzNewBadgeView_mcContentTextViewText);
        this.f5742B = obtainStyledAttributes.getResourceId(R.styleable.mzNewBadgeView_mcContentImageViewSrc, 0);
        this.f5743C = obtainStyledAttributes.getFloat(R.styleable.mzNewBadgeView_mcPointViewTextSize, 10.0f);
        obtainStyledAttributes.recycle();
        this.f5748H = getResources().getDimensionPixelOffset(R.dimen.mc_new_badge_view_launch_icon_padding);
        this.f5749I = getResources().getDimensionPixelOffset(R.dimen.mc_new_badge_view_launch_icon_num_padding);
        this.f5750J = getResources().getDimensionPixelOffset(R.dimen.mc_new_badge_view_system_icon_padding_left);
        this.f5751K = getResources().getDimensionPixelOffset(R.dimen.mc_new_badge_view_system_icon_padding_top);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo16951a(View view, int i, int i2) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i6 = size - paddingLeft;
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i7 = size2 - paddingTop;
        if (this.f5757x == f5733k) {
            mo16951a((View) this.f5745E, i6, i7);
        } else if (this.f5757x == f5732j) {
            mo16951a((View) this.f5744D, i6, i7);
        }
        if (this.f5746F != null) {
            mo16951a(this.f5746F, i6, i7);
        }
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i10 == 0) {
                i9 = measuredHeight;
                i8 = measuredWidth;
            } else if (i10 == 1) {
                if (this.f5758y != f5723a) {
                    if (this.f5758y == f5724b) {
                        i4 = this.f5754u;
                        i3 = this.f5753t;
                    } else if (this.f5758y == f5725c) {
                        i4 = this.f5754u / 2;
                        i3 = this.f5753t / 2;
                    } else if (this.f5758y == f5726d) {
                        i4 = this.f5754u;
                        i3 = this.f5753t / 2;
                    } else {
                        if (this.f5758y == f5727e) {
                            i5 = this.f5753t / 2;
                        } else if (this.f5758y == f5728f) {
                            i4 = this.f5754u / 2;
                            i3 = this.f5753t;
                        } else {
                            if (this.f5758y == f5729g) {
                                i4 = this.f5754u / 2;
                            } else if (this.f5758y == f5730h) {
                                i5 = this.f5753t;
                            } else if (this.f5758y == f5731i) {
                                i4 = this.f5754u;
                            }
                            i3 = 0;
                        }
                        i3 = i5;
                        i4 = 0;
                    }
                    i8 += i4 + paddingLeft;
                    i9 += i3 + paddingTop;
                }
                i4 = 0;
                i3 = 0;
                i8 += i4 + paddingLeft;
                i9 += i3 + paddingTop;
            }
        }
        setMeasuredDimension(i8, i9);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        int i5;
        int i6;
        int i7;
        View view2 = this.f5746F;
        if (this.f5757x == f5733k) {
            view = this.f5745E;
        } else {
            view = this.f5757x == f5732j ? this.f5744D : null;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int measuredWidth2 = view2.getMeasuredWidth();
        int measuredHeight2 = view2.getMeasuredHeight();
        int i8 = 0;
        if (this.f5758y == f5723a) {
            i8 = getPaddingLeft();
            i7 = getPaddingTop();
            if (this.f5752s == f5736n) {
                i6 = ((getPaddingLeft() + measuredWidth) - measuredWidth2) - this.f5748H;
                i5 = getPaddingTop() + this.f5748H;
            } else {
                i6 = (getPaddingLeft() + measuredWidth) - measuredWidth2;
                i5 = getPaddingTop();
            }
        } else if (this.f5758y == f5724b) {
            i8 = getPaddingLeft();
            i7 = getPaddingTop() + this.f5753t;
            i6 = getPaddingLeft() + measuredWidth;
            i5 = (getPaddingTop() + this.f5753t) - measuredHeight2;
        } else if (this.f5758y == f5725c) {
            i8 = getPaddingLeft();
            i7 = getPaddingTop() + (this.f5753t / 2);
            if (this.f5752s == f5737o) {
                i6 = ((getPaddingLeft() + measuredWidth) - (measuredWidth2 / 2)) - this.f5750J;
                i5 = getPaddingTop() + ((this.f5753t - measuredHeight2) / 2) + this.f5751K;
            } else {
                i6 = (getPaddingLeft() + measuredWidth) - (measuredWidth2 / 2);
                i5 = getPaddingTop() + ((this.f5753t - measuredHeight2) / 2);
            }
        } else if (this.f5758y == f5726d) {
            i8 = getPaddingLeft();
            i7 = getPaddingTop() + (this.f5753t / 2);
            i6 = getPaddingLeft() + measuredWidth;
            i5 = getPaddingTop() + ((this.f5753t - measuredHeight2) / 2);
        } else if (this.f5758y == f5727e) {
            i8 = getPaddingLeft();
            i7 = getPaddingTop() + (this.f5753t / 2);
            i6 = (getPaddingLeft() + measuredWidth) - measuredWidth2;
            i5 = getPaddingTop() + ((this.f5753t - measuredHeight2) / 2);
        } else if (this.f5758y == f5728f) {
            i8 = getPaddingLeft();
            i7 = getPaddingTop() + this.f5753t;
            i6 = (getPaddingLeft() + measuredWidth) - (measuredWidth2 / 2);
            i5 = (getPaddingTop() + this.f5753t) - measuredHeight2;
        } else if (this.f5758y == f5729g) {
            i8 = getPaddingLeft();
            i7 = getPaddingTop();
            if (this.f5752s == f5736n) {
                i6 = ((getPaddingLeft() + measuredWidth) - (measuredWidth2 / 2)) - this.f5749I;
                i5 = getPaddingTop();
            } else {
                i6 = (getPaddingLeft() + measuredWidth) - (measuredWidth2 / 2);
                i5 = getPaddingTop();
            }
        } else if (this.f5758y == f5730h) {
            i8 = getPaddingLeft();
            i7 = getPaddingTop() + this.f5753t;
            i6 = (getPaddingLeft() + measuredWidth) - measuredWidth2;
            i5 = (getPaddingTop() + this.f5753t) - measuredHeight2;
        } else if (this.f5758y == f5731i) {
            i8 = getPaddingLeft();
            i7 = getPaddingTop();
            i6 = getPaddingLeft() + measuredWidth;
            i5 = getPaddingTop();
        } else {
            i7 = 0;
            i6 = 0;
            i5 = 0;
        }
        view.layout(i8, i7, measuredWidth + i8, measuredHeight + i7);
        view2.layout(i6, i5, measuredWidth2 + i6, measuredHeight2 + i5);
    }

    public int getContentViewType() {
        return this.f5757x;
    }

    public void setContentViewType(int i) {
        this.f5757x = i;
    }

    public void setShowPointViewBorder(boolean z) {
        this.f5755v = Boolean.valueOf(z);
        if (this.f5756w > 0) {
            this.f5747G.setBorderWidth(this.f5756w);
        }
        this.f5747G.setShowBorder(z);
        this.f5747G.requestLayout();
    }

    public void setBadgeViewBorder(int i) {
        this.f5756w = i;
        setShowPointViewBorder(true);
    }

    public int getBadgeViewBorder() {
        return this.f5756w;
    }

    public int getBadgeNumber() {
        return this.f5747G.getNewMessageNum().intValue();
    }

    public void setBadgeNumber(int i) {
        this.f5747G.setNewMessageNum(i);
        if (this.f5752s == f5734l) {
            this.f5758y = f5726d;
        } else if (this.f5752s == f5735m || this.f5752s == f5736n) {
            this.f5758y = f5729g;
        } else if (this.f5752s == f5737o) {
            this.f5758y = f5725c;
        }
        setPointViewTextSize(this.f5743C);
        requestLayout();
    }

    public String getText() {
        return this.f5759z;
    }

    public void setText(String str) {
        this.f5759z = str;
        if (this.f5757x != f5732j) {
            setContentViewType(f5732j);
            removeView(this.f5745E);
            addView(this.f5744D, 0);
        }
        this.f5744D.setText(str);
    }

    public Drawable getDrawable() {
        return this.f5741A;
    }

    public void setDrawable(Drawable drawable) {
        this.f5741A = drawable;
        this.f5742B = 0;
        if (this.f5757x != f5733k) {
            setContentViewType(f5733k);
            removeView(this.f5744D);
            addView(this.f5745E, 0);
        }
        this.f5745E.setImageDrawable(drawable);
    }

    public void setDrawableId(int i) {
        this.f5741A = null;
        this.f5742B = i;
        if (this.f5757x != f5733k) {
            setContentViewType(f5733k);
            removeView(this.f5744D);
            addView(this.f5745E, 0);
        }
        this.f5745E.setImageResource(i);
    }

    public int getPointCenterLocation() {
        return this.f5758y;
    }

    public void setPointCenterLocation(int i) {
        this.f5758y = i;
    }

    public void setBadgeViewVisibility(int i) {
        this.f5746F.setVisibility(i);
    }

    public int getModeType() {
        return this.f5752s;
    }

    public void setModeType(int i) {
        this.f5752s = i;
        if (i == f5734l) {
            if (this.f5757x != f5732j) {
                setContentViewType(f5732j);
                removeView(this.f5745E);
                addView(this.f5744D, 0);
            }
            this.f5758y = f5726d;
        } else if (i == f5735m || i == f5736n || i == f5737o) {
            if (this.f5757x != f5733k) {
                setContentViewType(f5733k);
                removeView(this.f5744D);
                addView(this.f5745E, 0);
            }
            this.f5758y = f5723a;
            if (i == f5735m) {
                setBadgeViewBorder(0);
                setShowPointViewBorder(false);
            } else if (i == f5736n) {
                this.f5747G.setNewMessageSpace(getResources().getDimensionPixelOffset(R.dimen.mc_new_message_view_space_normal));
                setBadgeViewBorder(getResources().getDimensionPixelOffset(R.dimen.mc_new_message_view_launch_border_width));
            } else if (i == f5737o) {
                this.f5747G.setNewMessageSpace(getResources().getDimensionPixelOffset(R.dimen.mc_new_message_view_space_normal));
                setBadgeViewBorder(getResources().getDimensionPixelOffset(R.dimen.mc_new_message_view_border_width));
            }
        }
        requestLayout();
    }

    public void setPointViewTextSize(float f) {
        this.f5743C = f;
        this.f5747G.setTextSize(this.f5743C);
        requestLayout();
    }
}
