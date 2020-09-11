package com.meizu.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.SeekBar;

public class SkipPosSeekBar extends SeekBar {

    /* renamed from: a */
    protected int f6096a;

    /* renamed from: b */
    protected int f6097b;

    /* renamed from: c */
    protected int f6098c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public float f6099d;

    /* renamed from: e */
    private Interpolator f6100e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f6101f;

    /* renamed from: g */
    private ValueAnimator f6102g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C1517a f6103h;

    /* renamed from: i */
    private float f6104i;

    /* renamed from: j */
    private int f6105j;

    /* renamed from: k */
    private boolean f6106k;

    /* renamed from: com.meizu.common.widget.SkipPosSeekBar$a */
    public interface C1517a {
        /* renamed from: a */
        void mo17306a();

        /* renamed from: b */
        void mo17307b();
    }

    public SkipPosSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public SkipPosSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkipPosSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6101f = 0;
        this.f6106k = false;
        m6112a();
    }

    /* renamed from: com.meizu.common.widget.SkipPosSeekBar$b */
    private class C1518b implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: b */
        private SeekBar.OnSeekBarChangeListener f6114b;

        public C1518b(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
            this.f6114b = onSeekBarChangeListener;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (SkipPosSeekBar.this.f6098c != 0) {
                SkipPosSeekBar.this.f6097b = (i / SkipPosSeekBar.this.f6098c) + (i % SkipPosSeekBar.this.f6098c > SkipPosSeekBar.this.f6098c / 2 ? 1 : 0);
            } else {
                SkipPosSeekBar.this.f6097b = i;
            }
            if (this.f6114b != null) {
                this.f6114b.onProgressChanged(seekBar, i, z);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            if (this.f6114b != null) {
                this.f6114b.onStartTrackingTouch(seekBar);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            if (SkipPosSeekBar.this.f6098c != 0) {
                int progress = SkipPosSeekBar.this.getProgress();
                if (progress % SkipPosSeekBar.this.f6098c != 0) {
                    SkipPosSeekBar.this.setSkipProgress((progress + (progress % SkipPosSeekBar.this.f6098c > SkipPosSeekBar.this.f6098c / 2 ? SkipPosSeekBar.this.f6098c - (progress % SkipPosSeekBar.this.f6098c) : (-progress) % SkipPosSeekBar.this.f6098c)) / SkipPosSeekBar.this.f6098c);
                }
            }
            if (this.f6114b != null) {
                this.f6114b.onStopTrackingTouch(seekBar);
            }
        }
    }

    /* renamed from: a */
    private void m6112a() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f6100e = new PathInterpolator(0.2f, 0.31f, 0.34f, 1.0f);
        } else {
            this.f6100e = new AccelerateInterpolator();
        }
        setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
        this.f6105j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        super.setOnSeekBarChangeListener(new C1518b(onSeekBarChangeListener));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (getProgressDrawable() != null) {
            this.f6099d = (float) (getProgressDrawable().getBounds().width() / this.f6096a);
        }
    }

    public void setAntiAlias(boolean z) {
        if (z) {
            if (this.f6098c != 20) {
                this.f6098c = 20;
                setMax(getMax());
                setProgress(getProgress());
            }
        } else if (this.f6098c != 0) {
            this.f6098c = 0;
            setProgress(getProgress() / 20);
            setMax(getMax() / 20);
        }
    }

    public void setSkipProgress(int i) {
        float paddingLeft = ((float) getPaddingLeft()) + (((float) i) * this.f6099d);
        float paddingLeft2 = ((float) getPaddingLeft()) + (((float) getRealProgress()) * this.f6099d);
        int realProgress = getRealProgress();
        if (this.f6102g != null && this.f6102g.isRunning()) {
            this.f6102g.cancel();
        }
        m6113a(realProgress, paddingLeft2, paddingLeft, (int) (Math.abs(paddingLeft - paddingLeft2) * 0.44444445f));
    }

    public void setSkipProgress(float f) {
        setSkipProgress(Math.round(f * ((float) this.f6096a)));
    }

    /* renamed from: a */
    private void m6113a(final int i, final float f, final float f2, int i2) {
        this.f6102g = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f6102g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (f2 > f) {
                    int unused = SkipPosSeekBar.this.f6101f = i + ((int) ((floatValue * (f2 - f)) / SkipPosSeekBar.this.f6099d));
                } else {
                    int unused2 = SkipPosSeekBar.this.f6101f = i - ((int) ((floatValue * (f - f2)) / SkipPosSeekBar.this.f6099d));
                }
                SkipPosSeekBar.this.setProgress(SkipPosSeekBar.this.f6101f);
            }
        });
        this.f6102g.setInterpolator(this.f6100e);
        this.f6102g.setDuration((long) i2);
        this.f6102g.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                if (SkipPosSeekBar.this.f6103h != null) {
                    SkipPosSeekBar.this.f6103h.mo17307b();
                }
                super.onAnimationStart(animator);
            }

            public void onAnimationEnd(Animator animator) {
                if (SkipPosSeekBar.this.f6103h != null) {
                    SkipPosSeekBar.this.f6103h.mo17306a();
                }
                super.onAnimationEnd(animator);
            }
        });
        this.f6102g.start();
    }

    public void setSkipAnimationListener(C1517a aVar) {
        this.f6103h = aVar;
    }

    public void setSkipPosMax(int i) {
        if (this.f6096a != i) {
            setMax(i);
            setProgress(Math.round((((float) getRealProgress()) / ((float) this.f6096a)) * ((float) this.f6096a)));
            if (getProgressDrawable() != null) {
                this.f6099d = ((float) getProgressDrawable().getBounds().width()) / ((float) this.f6096a);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SkipPosSeekBar.class.getName());
    }

    public synchronized void setMax(int i) {
        super.setMax((this.f6098c == 0 ? 1 : this.f6098c) * i);
        this.f6096a = i;
    }

    public synchronized void setProgress(int i) {
        super.setProgress((this.f6098c == 0 ? 1 : this.f6098c) * i);
        this.f6097b = i;
    }

    public int getRealProgress() {
        return this.f6097b;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        switch (motionEvent.getAction()) {
            case 0:
                this.f6104i = x;
                break;
            case 1:
                if (!this.f6106k) {
                    m6114a(motionEvent);
                }
                this.f6106k = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.f6104i) > ((float) this.f6105j)) {
                    this.f6106k = true;
                    break;
                }
                break;
            case 3:
                if (this.f6106k) {
                    this.f6106k = false;
                    break;
                }
                break;
        }
        super.onTouchEvent(motionEvent);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0079  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6114a(android.view.MotionEvent r7) {
        /*
            r6 = this;
            float r0 = r7.getX()
            int r0 = java.lang.Math.round(r0)
            float r7 = r7.getY()
            java.lang.Math.round(r7)
            int r7 = r6.getWidth()
            int r1 = r6.getPaddingLeft()
            int r1 = r7 - r1
            int r2 = r6.getPaddingRight()
            int r1 = r1 - r2
            int r2 = r6.getLayoutDirection()
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 1
            r5 = 0
            if (r2 != r4) goto L_0x0044
            int r2 = r6.getPaddingRight()
            int r7 = r7 - r2
            if (r0 <= r7) goto L_0x0031
        L_0x002f:
            r3 = 0
            goto L_0x005c
        L_0x0031:
            int r7 = r6.getPaddingLeft()
            if (r0 >= r7) goto L_0x0038
            goto L_0x005c
        L_0x0038:
            int r7 = r1 - r0
            int r0 = r6.getPaddingLeft()
            int r7 = r7 + r0
            float r7 = (float) r7
            float r0 = (float) r1
            float r3 = r7 / r0
            goto L_0x005c
        L_0x0044:
            int r2 = r6.getPaddingLeft()
            if (r0 >= r2) goto L_0x004b
            goto L_0x002f
        L_0x004b:
            int r2 = r6.getPaddingRight()
            int r7 = r7 - r2
            if (r0 <= r7) goto L_0x0053
            goto L_0x005c
        L_0x0053:
            int r7 = r6.getPaddingLeft()
            int r0 = r0 - r7
            float r7 = (float) r0
            float r0 = (float) r1
            float r3 = r7 / r0
        L_0x005c:
            int r7 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r7 < r0) goto L_0x006c
            int r7 = r6.getMax()
            int r0 = r6.getMin()
            int r7 = r7 - r0
            goto L_0x0072
        L_0x006c:
            int r7 = r6.getMax()
            int r7 = r7 + 0
        L_0x0072:
            float r0 = (float) r7
            float r3 = r3 * r0
            float r5 = r5 + r3
            if (r7 == 0) goto L_0x0079
            goto L_0x007a
        L_0x0079:
            r7 = 1
        L_0x007a:
            float r7 = (float) r7
            float r5 = r5 / r7
            r6.setSkipProgress((float) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.SkipPosSeekBar.m6114a(android.view.MotionEvent):void");
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f6097b = savedState.f6112a;
        setProgress(this.f6097b);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState((Parcelable) (View.BaseSavedState) super.onSaveInstanceState());
        savedState.f6112a = this.f6097b;
        return savedState;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        int f6112a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f6112a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f6112a);
        }
    }
}
