package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.meizu.common.R;

public class GradientRectangleLayout extends LinearLayout implements View.OnTouchListener {

    /* renamed from: a */
    private TransitionDrawable f5367a;

    /* renamed from: b */
    private TransitionDrawable f5368b;

    /* renamed from: c */
    private TransitionDrawable f5369c;

    /* renamed from: d */
    private int[] f5370d;

    /* renamed from: e */
    private int[] f5371e;

    /* renamed from: f */
    private int[] f5372f;

    /* renamed from: g */
    private int[] f5373g;

    /* renamed from: h */
    private int[] f5374h;

    /* renamed from: i */
    private int[] f5375i;

    /* renamed from: j */
    private StateListDrawable f5376j;

    /* renamed from: k */
    private StateListDrawable f5377k;

    /* renamed from: l */
    private StateListDrawable f5378l;

    /* renamed from: m */
    private final int f5379m;

    public GradientRectangleLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public GradientRectangleLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientRectangleLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5379m = 128;
    }

    /* renamed from: a */
    private void m5793a() {
        setOrientation(0);
        setGravity(17);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R.styleable.MZTheme);
        int i = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColorLevel4, -15102483);
        int i2 = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColorLevel5, -15102483);
        int i3 = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColorLevel6, -15102483);
        int i4 = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColorLevel7, -15102483);
        int i5 = obtainStyledAttributes.getInt(R.styleable.MZTheme_mzThemeColorLevel8, -15102483);
        obtainStyledAttributes.recycle();
        this.f5370d = new int[]{i2, i4};
        this.f5371e = new int[]{i3, i5};
        this.f5372f = new int[]{i, i2};
        this.f5373g = new int[]{i2, i3};
        this.f5374h = new int[]{i3, i4};
        this.f5375i = new int[]{i4, i5};
        m5795b();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        m5793a();
        if (Build.VERSION.SDK_INT >= 16) {
            switch (getChildCount()) {
                case 1:
                    getChildAt(0).setBackground(this.f5376j);
                    break;
                case 2:
                    getChildAt(0).setBackground(this.f5377k);
                    getChildAt(1).setBackground(this.f5378l);
                    break;
                default:
                    for (int i = 0; i < getChildCount(); i++) {
                        getChildAt(i).setBackground(this.f5376j);
                    }
                    break;
            }
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof TextView) {
                ((TextView) getChildAt(i2)).setTextColor(-1);
                ((TextView) getChildAt(i2)).setGravity(17);
            }
            getChildAt(i2).setClickable(true);
            getChildAt(i2).setOnTouchListener(this);
            getChildAt(i2).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        }
    }

    /* renamed from: a */
    private void m5794a(View view, boolean z) {
        if (view == null || Build.VERSION.SDK_INT < 16 || view.getBackground() == null || !(view.getBackground() instanceof StateListDrawable) || !(view.getBackground().getCurrent() instanceof TransitionDrawable)) {
            return;
        }
        if (z) {
            ((TransitionDrawable) view.getBackground().getCurrent()).startTransition(128);
        } else {
            ((TransitionDrawable) view.getBackground().getCurrent()).reverseTransition(128);
        }
    }

    /* renamed from: b */
    private void m5795b() {
        this.f5367a = new TransitionDrawable(new Drawable[]{new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, this.f5370d), new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, this.f5371e)});
        this.f5368b = new TransitionDrawable(new Drawable[]{new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, this.f5372f), new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, this.f5373g)});
        this.f5369c = new TransitionDrawable(new Drawable[]{new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, this.f5374h), new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, this.f5375i)});
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#19000000"));
        this.f5376j = new StateListDrawable();
        this.f5376j.addState(new int[]{-16842910}, colorDrawable);
        this.f5376j.addState(new int[]{16842910}, this.f5367a);
        this.f5377k = new StateListDrawable();
        this.f5377k.addState(new int[]{-16842910}, colorDrawable);
        this.f5377k.addState(new int[]{16842910}, this.f5368b);
        this.f5378l = new StateListDrawable();
        this.f5378l.addState(new int[]{-16842910}, colorDrawable);
        this.f5378l.addState(new int[]{16842910}, this.f5369c);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                m5794a(view, true);
                break;
            case 1:
                m5794a(view, false);
                break;
        }
        return false;
    }
}
