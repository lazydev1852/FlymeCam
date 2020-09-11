package com.meizu.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.meizu.common.R;

public class PartitionItemLayout extends FrameLayout implements AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a */
    protected Drawable f5843a;

    /* renamed from: b */
    private Rect f5844b;

    public PartitionItemLayout(Context context) {
        super(context);
    }

    public PartitionItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartitionItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Drawable drawable = getResources().getDrawable(R.drawable.mz_list_new_item_bg_light_activated);
        if (drawable != null) {
            setContentBackground(drawable);
        }
        if (this.f5844b == null) {
            this.f5844b = new Rect();
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        rect.left += this.f5844b.left;
        rect.top += this.f5844b.top;
        rect.right -= this.f5844b.right;
        rect.bottom -= this.f5844b.bottom;
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f5844b == null) {
            this.f5844b = new Rect();
        }
        if (drawable != null) {
            drawable.getPadding(this.f5844b);
        } else {
            this.f5844b.setEmpty();
        }
    }

    public void setContentBackground(Drawable drawable) {
        if (this.f5843a != drawable) {
            if (this.f5843a != null) {
                this.f5843a.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.f5843a);
            }
            this.f5843a = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public Drawable getContentBackground() {
        return this.f5843a;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5843a;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f5843a != null) {
            this.f5843a.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f5843a != null && this.f5843a.isStateful()) {
            this.f5843a.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f5843a.setBounds(this.f5844b.left, this.f5844b.top, getMeasuredWidth() - this.f5844b.right, getMeasuredHeight() - this.f5844b.bottom);
        this.f5843a.draw(canvas);
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(PartitionItemLayout.class.getName());
    }
}
