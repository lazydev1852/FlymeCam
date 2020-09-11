package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;

public class SelectionButton extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final float[] f6082g = {0.0f, 0.215313f, 0.513045f, 0.675783f, 0.777778f, 0.848013f, 0.898385f, 0.934953f, 0.96126f, 0.979572f, 0.991439f, 0.997972f, 1.0f, 1.0f};
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final float[] f6083h = {0.0f, 0.002028f, 0.008561f, 0.020428f, 0.03874f, 0.065047f, 0.101615f, 0.151987f, 0.222222f, 0.324217f, 0.486955f, 0.784687f, 1.0f, 1.0f};

    /* renamed from: a */
    Context f6084a;

    /* renamed from: b */
    Drawable f6085b;

    /* renamed from: c */
    private boolean f6086c;

    /* renamed from: d */
    private ObjectAnimator f6087d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f6088e;

    /* renamed from: f */
    private ColorStateList f6089f;

    /* renamed from: i */
    private TextView f6090i;

    /* renamed from: j */
    private int f6091j;

    /* renamed from: k */
    private int f6092k;

    /* renamed from: l */
    private boolean f6093l;

    public SelectionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6085b = null;
        this.f6086c = false;
        this.f6091j = 0;
        this.f6092k = 0;
        this.f6093l = false;
        this.f6084a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SelectionButton, i, 0);
        this.f6085b = obtainStyledAttributes.getDrawable(R.styleable.SelectionButton_mcBackground);
        this.f6089f = obtainStyledAttributes.getColorStateList(R.styleable.SelectionButton_mcSelectTextColor);
        obtainStyledAttributes.recycle();
        m6106c();
        m6108e();
    }

    public SelectionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_SelectionButtonStyle);
    }

    public SelectionButton(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: c */
    private void m6106c() {
        if (LayoutInflater.from(this.f6084a).inflate(R.layout.mc_selection_button, this) == null) {
            Log.w("SelectionButton", "can not inflate the view");
            return;
        }
        setClickable(true);
        setGravity(17);
        setMinimumWidth(getContext().getResources().getDimensionPixelSize(R.dimen.mz_action_button_min_width));
        this.f6090i = (TextView) findViewById(16908308);
        m6107d();
        this.f6090i.setActivated(false);
        if (this.f6085b != null) {
            this.f6090i.setBackgroundDrawable(this.f6085b);
        }
        if (this.f6089f != null) {
            this.f6090i.setTextColor(this.f6089f);
        }
    }

    public void setTotalCount(int i) {
        if (this.f6091j != i) {
            if (i < 0) {
                i = 0;
            }
            this.f6091j = i;
            m6107d();
        }
    }

    public int getTotalCount() {
        return this.f6091j;
    }

    public void setCurrentCount(int i) {
        if (this.f6092k != i) {
            if (i < 0) {
                i = 0;
            }
            this.f6092k = i;
            m6107d();
        }
    }

    public int getCurrentCount() {
        return this.f6092k;
    }

    public void setAllSelected(boolean z) {
        if (z) {
            this.f6092k = this.f6091j;
        } else {
            this.f6092k = 0;
        }
        m6107d();
    }

    /* renamed from: d */
    private void m6107d() {
        if (this.f6092k > this.f6091j) {
            this.f6092k = this.f6091j;
        }
        if (this.f6091j <= 0 || this.f6092k != this.f6091j) {
            this.f6090i.setText(String.valueOf(this.f6092k));
            this.f6093l = false;
            this.f6090i.setActivated(false);
            return;
        }
        this.f6093l = true;
        this.f6090i.setText(getContext().getResources().getString(R.string.mc_selectionbutton_all));
        this.f6090i.setActivated(true);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f6090i != null) {
            this.f6090i.setEnabled(z);
        }
    }

    public void setVisibility(int i) {
        if (!this.f6086c) {
            super.setVisibility(i);
        } else if (this.f6088e != i) {
            this.f6088e = i;
            if (i == 0) {
                super.setVisibility(i);
                this.f6087d.start();
                return;
            }
            this.f6087d.reverse();
        }
    }

    public void setVisibility(int i, boolean z) {
        if (z) {
            setVisibility(i);
            return;
        }
        super.setVisibility(i);
        this.f6088e = getVisibility();
    }

    /* renamed from: e */
    private void m6108e() {
        if (this.f6087d == null && this.f6090i != null) {
            this.f6086c = true;
            this.f6088e = getVisibility();
            m6109f();
        }
    }

    /* renamed from: f */
    private void m6109f() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", new float[]{0.0f, 1.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", new float[]{0.0f, 1.0f});
        this.f6087d = ObjectAnimator.ofPropertyValuesHolder(this.f6090i, new PropertyValuesHolder[]{ofFloat, ofFloat2}).setDuration(200);
        this.f6087d.setInterpolator(new TimeInterpolator() {
            public float getInterpolation(float f) {
                float[] fArr;
                int round = Math.round(f * 12.0f);
                if (SelectionButton.this.f6088e == 0) {
                    fArr = SelectionButton.f6082g;
                } else {
                    fArr = SelectionButton.f6083h;
                }
                return fArr[round];
            }
        });
        this.f6087d.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                View view = (View) ((ObjectAnimator) animator).getTarget();
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                SelectionButton.this.setVisibility(SelectionButton.this.f6088e, false);
                SelectionButton.this.setClickable(true);
            }

            public void onAnimationStart(Animator animator) {
                SelectionButton.this.setClickable(false);
            }
        });
    }

    public void setIsAnimation(boolean z) {
        this.f6086c = z;
    }

    public void setSelectBackground(Drawable drawable) {
        if (drawable != null) {
            this.f6085b = drawable;
            this.f6090i.setBackgroundDrawable(this.f6085b);
        }
    }

    public void setSelectTextColor(int i) {
        this.f6090i.setTextColor(i);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SelectionButton.class.getName());
    }
}
