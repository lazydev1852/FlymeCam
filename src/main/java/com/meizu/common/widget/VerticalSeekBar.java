package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import com.meizu.common.R;

public class VerticalSeekBar extends AbsSeekBar {

    /* renamed from: i */
    private C1546a f6317i;

    /* renamed from: com.meizu.common.widget.VerticalSeekBar$a */
    public interface C1546a {
        /* renamed from: a */
        void mo17527a(VerticalSeekBar verticalSeekBar);

        /* renamed from: a */
        void mo17528a(VerticalSeekBar verticalSeekBar, int i, boolean z);

        /* renamed from: b */
        void mo17529b(VerticalSeekBar verticalSeekBar);
    }

    public VerticalSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_VerticalSeekBarStyle);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SeekBar, i, 0);
        setBreakPoint(obtainStyledAttributes.getInt(R.styleable.SeekBar_mcBreakPoint, 0));
        obtainStyledAttributes.recycle();
        setIsVertical(true);
        setTouchMode(1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo16012a(float f, boolean z) {
        super.mo16012a(f, z);
        if (this.f6317i != null) {
            this.f6317i.mo17528a(this, getProgress(), z);
        }
    }

    public void setOnSeekBarChangeListener(C1546a aVar) {
        this.f6317i = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo16014b() {
        super.mo16014b();
        if (this.f6317i != null) {
            this.f6317i.mo17527a(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo16015c() {
        super.mo16015c();
        if (this.f6317i != null) {
            this.f6317i.mo17529b(this);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(VerticalSeekBar.class.getName());
    }
}
