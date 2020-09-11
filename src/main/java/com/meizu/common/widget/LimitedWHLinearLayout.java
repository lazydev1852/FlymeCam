package com.meizu.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.widget.ActivityChooserView;

public class LimitedWHLinearLayout extends LinearLayout {

    /* renamed from: a */
    private int f5554a = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    /* renamed from: b */
    private int f5555b = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    public LimitedWHLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LimitedWHLinearLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z;
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        if (measuredHeight > this.f5554a) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.f5554a, 1073741824);
            z = true;
        } else {
            z = false;
        }
        if (measuredWidth > this.f5555b) {
            i = View.MeasureSpec.makeMeasureSpec(this.f5555b, 1073741824);
            z = true;
        }
        if (z) {
            super.onMeasure(i, i2);
        }
    }

    public void setMaxHeight(int i) {
        this.f5554a = i;
    }

    public int getMaxHeight() {
        return this.f5554a;
    }

    public void setMaxWidth(int i) {
        this.f5555b = i;
    }

    public int getMaxWidth() {
        return this.f5555b;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LimitedWHLinearLayout.class.getName());
    }
}
