package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ProgressTextButtonView extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CircularProgressButton f5949a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f5950b;

    /* renamed from: c */
    private boolean f5951c = false;

    /* renamed from: d */
    private ValueAnimator f5952d;

    public ProgressTextButtonView(Context context) {
        super(context);
    }

    public ProgressTextButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 2) {
            for (int i = 0; i < getChildCount(); i++) {
                if (getChildAt(i) instanceof CircularProgressButton) {
                    this.f5949a = (CircularProgressButton) getChildAt(i);
                } else if (getChildAt(i) instanceof TextView) {
                    this.f5950b = (TextView) getChildAt(i);
                }
            }
            mo17138a(this.f5951c, false);
            return;
        }
        throw new IllegalStateException("ProgressTextButtonView must has two children");
    }

    /* renamed from: a */
    public void mo17138a(final boolean z, boolean z2) {
        if (!z2) {
            if (z) {
                this.f5950b.setAlpha(1.0f);
                this.f5949a.setVisibility(8);
                this.f5950b.setVisibility(0);
                return;
            }
            this.f5949a.setAlpha(1.0f);
            this.f5949a.setVisibility(0);
            this.f5950b.setVisibility(8);
        } else if (z && this.f5950b.getVisibility() == 0) {
        } else {
            if (z || this.f5949a.getVisibility() != 0) {
                this.f5952d = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                this.f5952d.setDuration(100);
                this.f5952d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (z) {
                            ProgressTextButtonView.this.f5949a.setAlpha(1.0f - floatValue);
                            ProgressTextButtonView.this.f5950b.setAlpha(floatValue);
                            return;
                        }
                        ProgressTextButtonView.this.f5949a.setAlpha(floatValue);
                        ProgressTextButtonView.this.f5950b.setAlpha(1.0f - floatValue);
                    }
                });
                this.f5952d.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (z) {
                            ProgressTextButtonView.this.f5950b.setVisibility(0);
                            ProgressTextButtonView.this.f5949a.setVisibility(8);
                            return;
                        }
                        ProgressTextButtonView.this.f5950b.setVisibility(8);
                        ProgressTextButtonView.this.f5949a.setVisibility(0);
                    }
                });
                this.f5952d.start();
            }
        }
    }

    public TextView getTextView() {
        return this.f5950b;
    }

    public CircularProgressButton getButton() {
        return this.f5949a;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ProgressTextButtonView.class.getName());
    }
}
