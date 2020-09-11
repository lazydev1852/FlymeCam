package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.CheckBox;

public class AnimCheckBox extends CheckBox {

    /* renamed from: a */
    int f4586a;

    /* renamed from: b */
    private C1354a f4587b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C1358b f4588c;

    /* renamed from: d */
    private boolean f4589d;

    /* renamed from: com.meizu.common.widget.AnimCheckBox$b */
    public interface C1358b {
        /* renamed from: a */
        void mo16129a(float f);
    }

    public AnimCheckBox(Context context) {
        this(context, (AttributeSet) null);
    }

    public AnimCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnimCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4586a = getVisibility();
        setIsAnimation(true);
    }

    public AnimCheckBox(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f4586a = getVisibility();
        setIsAnimation(true);
    }

    public void setInitVisible(int i) {
        if (i == 0 || i == 4 || i == 8) {
            this.f4586a = i;
        }
    }

    public void setChecked(boolean z) {
        if (this.f4587b == null) {
            super.setChecked(z);
        } else {
            this.f4587b.mo16123a(z);
        }
    }

    public void setActivated(boolean z) {
        if (this.f4589d != z) {
            this.f4589d = z;
            sendAccessibilityEvent(32768);
        }
        if (this.f4587b == null) {
            super.setActivated(z);
        } else {
            this.f4587b.mo16124b(z);
        }
    }

    public void setIsAnimation(boolean z) {
        if (this.f4587b == null) {
            this.f4587b = new C1354a(this);
        }
        this.f4587b.mo16125c(z);
    }

    /* renamed from: a */
    public void mo16114a(boolean z) {
        super.setChecked(z);
    }

    /* renamed from: b */
    public void mo16115b(boolean z) {
        super.setActivated(z);
    }

    public void setUpdateListner(C1358b bVar) {
        this.f4588c = bVar;
    }

    /* renamed from: com.meizu.common.widget.AnimCheckBox$a */
    private static class C1354a {

        /* renamed from: a */
        private boolean f4590a = false;

        /* renamed from: b */
        private ObjectAnimator f4591b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public ObjectAnimator f4592c;

        /* renamed from: d */
        private ValueAnimator f4593d;

        /* renamed from: e */
        private AnimatorSet f4594e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public boolean f4595f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public boolean f4596g;

        /* renamed from: h */
        private boolean f4597h = true;

        /* renamed from: i */
        private boolean f4598i = false;

        /* renamed from: j */
        private TimeInterpolator f4599j;

        /* renamed from: k */
        private TimeInterpolator f4600k;

        /* renamed from: l */
        private TimeInterpolator f4601l;

        /* renamed from: m */
        private TimeInterpolator f4602m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public AnimCheckBox f4603n;

        public C1354a(AnimCheckBox animCheckBox) {
            this.f4603n = animCheckBox;
            m5222a();
            this.f4598i = true;
        }

        /* renamed from: a */
        private void m5222a() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f4599j = new PathInterpolator(0.051f, 0.012f, 0.1f, 1.0f);
                this.f4600k = new PathInterpolator(0.051f, 0.012f, 0.1f, 1.0f);
                this.f4601l = new PathInterpolator(0.2f, 0.0601f, 0.1f, 1.0f);
                this.f4602m = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
            } else {
                DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
                this.f4602m = decelerateInterpolator;
                this.f4601l = decelerateInterpolator;
                this.f4600k = decelerateInterpolator;
                this.f4599j = decelerateInterpolator;
            }
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 0.0f});
            this.f4591b = ObjectAnimator.ofPropertyValuesHolder(this.f4603n, new PropertyValuesHolder[]{ofFloat});
            this.f4591b.setInterpolator(this.f4599j);
            this.f4591b.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    C1354a.this.f4603n.mo16114a(C1354a.this.f4595f);
                    C1354a.this.f4603n.mo16115b(C1354a.this.f4596g);
                    if (C1354a.this.f4603n.f4586a != 0) {
                        if (C1354a.this.f4595f) {
                            C1354a.this.f4603n.setVisibility(0);
                        } else {
                            C1354a.this.f4603n.setVisibility(C1354a.this.f4603n.f4586a);
                        }
                    }
                    C1354a.this.f4592c.start();
                }
            });
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", new float[]{0.0f, 1.0f});
            this.f4592c = ObjectAnimator.ofPropertyValuesHolder(this.f4603n, new PropertyValuesHolder[]{ofFloat2});
            this.f4592c.setInterpolator(this.f4600k);
            this.f4593d = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f4593d.setInterpolator(this.f4601l);
            this.f4593d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (C1354a.this.f4603n.f4588c != null) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (!C1354a.this.f4595f) {
                            floatValue = 1.0f - floatValue;
                        }
                        C1354a.this.f4603n.f4588c.mo16129a(floatValue);
                    }
                }
            });
            this.f4593d.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (C1354a.this.f4592c.isRunning()) {
                        C1354a.this.f4592c.end();
                    }
                }
            });
            this.f4594e = new AnimatorSet();
            this.f4594e.playTogether(new Animator[]{this.f4591b, this.f4593d});
        }

        /* renamed from: a */
        public void mo16123a(boolean z) {
            if (!this.f4598i || !this.f4597h) {
                this.f4603n.mo16114a(z);
                this.f4595f = z;
                return;
            }
            if (this.f4590a) {
                Log.i("xx", "setChecked checked = " + z + " mTargetChecekedState = " + this.f4595f + "  " + this.f4594e.isRunning() + " " + this.f4592c.isRunning());
            }
            if (z != this.f4595f) {
                this.f4595f = z;
                if (z) {
                    if (this.f4594e.isRunning() || this.f4592c.isRunning()) {
                        this.f4595f = false;
                        this.f4594e.end();
                        this.f4592c.end();
                        mo16123a(z);
                        return;
                    }
                    this.f4591b.setDuration(150);
                    this.f4592c.setDuration(230);
                    this.f4593d.setDuration(380);
                    this.f4594e.start();
                } else if (this.f4594e.isRunning() || this.f4592c.isRunning()) {
                    this.f4603n.mo16114a(z);
                    this.f4594e.end();
                    this.f4592c.end();
                } else {
                    this.f4591b.setDuration(0);
                    this.f4592c.setDuration(476);
                    this.f4593d.setDuration(476);
                    this.f4594e.start();
                }
            }
        }

        /* renamed from: b */
        public void mo16124b(boolean z) {
            this.f4596g = z;
            if (!this.f4598i || !this.f4597h) {
                this.f4603n.mo16115b(z);
                return;
            }
            if (this.f4590a) {
                Log.i("xx", "setActivated activated = " + z + " " + this.f4603n.isActivated() + " " + this.f4596g + " mTargetChecekedState = " + this.f4595f + " " + this.f4603n.isChecked() + " " + this.f4594e.isRunning() + " " + this.f4592c.isRunning());
            }
            if (z == this.f4603n.isActivated()) {
                return;
            }
            if (!z && !this.f4595f && this.f4603n.isChecked()) {
                return;
            }
            if (this.f4603n.isChecked() && this.f4595f) {
                this.f4603n.mo16115b(z);
                if (!this.f4594e.isRunning() && !this.f4592c.isRunning()) {
                    PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.0f, 1.0f});
                    PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.0f, 1.0f});
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f4603n, new PropertyValuesHolder[]{ofFloat, ofFloat2});
                    ofPropertyValuesHolder.setDuration(40).setInterpolator(this.f4602m);
                    ofPropertyValuesHolder.start();
                }
            } else if (!z) {
                this.f4594e.end();
                this.f4592c.end();
                this.f4603n.mo16115b(z);
            }
        }

        /* renamed from: c */
        public void mo16125c(boolean z) {
            this.f4597h = z;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setChecked(this.f4589d);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setChecked(this.f4589d);
    }
}
