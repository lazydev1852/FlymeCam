package com.meizu.media.camera.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.text.DecimalFormat;
import java.util.List;

public class MzEnhanceSeekBar extends View {

    /* renamed from: a */
    public static ChangeQuickRedirect f14765a;

    /* renamed from: A */
    private XYHolder f14766A;

    /* renamed from: B */
    private ObjectAnimator f14767B;

    /* renamed from: C */
    private XYEvaluator f14768C;

    /* renamed from: D */
    private DrawableXYHolder f14769D;

    /* renamed from: E */
    private Interpolator f14770E;

    /* renamed from: F */
    private int f14771F;

    /* renamed from: G */
    private boolean f14772G;

    /* renamed from: H */
    private float f14773H;

    /* renamed from: I */
    private float f14774I;

    /* renamed from: J */
    private float f14775J;

    /* renamed from: K */
    private AccessibilityEventSender f14776K;

    /* renamed from: L */
    private boolean f14777L;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f14778b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f14779c;

    /* renamed from: d */
    private int f14780d;

    /* renamed from: e */
    private boolean f14781e;

    /* renamed from: f */
    private int f14782f;

    /* renamed from: g */
    private int f14783g;

    /* renamed from: h */
    private int f14784h;

    /* renamed from: i */
    private int f14785i;

    /* renamed from: j */
    private int f14786j;

    /* renamed from: k */
    private int f14787k;

    /* renamed from: l */
    private int f14788l;

    /* renamed from: m */
    private boolean f14789m;

    /* renamed from: n */
    private boolean f14790n;

    /* renamed from: o */
    private Drawable f14791o;

    /* renamed from: p */
    private Drawable f14792p;

    /* renamed from: q */
    private int f14793q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f14794r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public CharSequence[] f14795s;

    /* renamed from: t */
    private Drawable[] f14796t;

    /* renamed from: u */
    private Drawable[] f14797u;

    /* renamed from: v */
    private List<Integer> f14798v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public OnEnhanceSeekBarChangeListener f14799w;

    /* renamed from: x */
    private OnInterceptTouchEventListener f14800x;

    /* renamed from: y */
    private Paint f14801y;

    /* renamed from: z */
    private XYHolder f14802z;

    public interface OnEnhanceSeekBarChangeListener {
        void onProgressChanged(MzEnhanceSeekBar mzEnhanceSeekBar, int i);

        void onProgressDragging(MzEnhanceSeekBar mzEnhanceSeekBar, int i);

        void onStartTrackingTouch(MzEnhanceSeekBar mzEnhanceSeekBar);

        void onStopTrackingTouch(MzEnhanceSeekBar mzEnhanceSeekBar);
    }

    public interface OnInterceptTouchEventListener {
        boolean isInterceptTouchEvent();
    }

    /* renamed from: b */
    private boolean m16500b(int i, int i2) {
        return true;
    }

    public MzEnhanceSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public MzEnhanceSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f19115MeizuCommonEnhanceSeekBarStyle);
    }

    public MzEnhanceSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14781e = false;
        this.f14782f = 0;
        this.f14783g = 0;
        this.f14784h = 0;
        this.f14794r = 0;
        this.f14802z = new XYHolder();
        this.f14766A = new XYHolder();
        this.f14768C = new XYEvaluator();
        this.f14769D = new DrawableXYHolder();
        this.f14772G = false;
        this.f14777L = false;
        this.f14771F = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f14788l = getResources().getDimensionPixelOffset(R.dimen.mz_manual_seekbar_text_height);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EnhanceSeekBar, i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(5);
        setThumb(drawable == null ? context.getResources().getDrawable(R.drawable.mz_scrubber_control_selector) : drawable);
        obtainStyledAttributes.recycle();
        this.f14801y = new Paint();
        this.f14785i = getResources().getColor(R.color.mz_enhance_seekbar_unselect_color);
        this.f14786j = getResources().getColor(R.color.mz_enhance_seekbar_select_color);
        this.f14787k = getResources().getColor(R.color.mz_enhance_seekbar_line_color);
        this.f14801y.setColor(this.f14785i);
        this.f14801y.setStrokeWidth((float) CameraUtil.m15810a(3));
        this.f14801y.setTextSize(getResources().getDimension(R.dimen.mz_font_size_12sp));
        this.f14801y.setFakeBoldText(true);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f14770E = new PathInterpolator(0.33f, 0.0f, 0.1f, 1.0f);
        } else {
            this.f14770E = new AccelerateInterpolator();
        }
    }

    public void setOnEnhanceSeekBarChangeListener(OnEnhanceSeekBarChangeListener onEnhanceSeekBarChangeListener) {
        this.f14799w = onEnhanceSeekBarChangeListener;
    }

    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.f14800x = onInterceptTouchEventListener;
    }

    public void setFilterIndexs(List<Integer> list) {
        this.f14798v = list;
    }

    /* renamed from: a */
    private boolean m16498a(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f14765a, false, 8519, new Class[]{Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f14798v != null && !this.f14798v.contains(Integer.valueOf(i));
    }

    public void setItems(CharSequence[] charSequenceArr) {
        if (!PatchProxy.proxy(new Object[]{charSequenceArr}, this, f14765a, false, 8520, new Class[]{CharSequence[].class}, Void.TYPE).isSupported) {
            if (charSequenceArr == null || charSequenceArr.length == 0) {
                this.f14795s = null;
                setMax(0);
                return;
            }
            this.f14794r = charSequenceArr.length;
            this.f14795s = new CharSequence[this.f14794r];
            System.arraycopy(charSequenceArr, 0, this.f14795s, 0, this.f14794r);
            setMax(this.f14794r - 1);
        }
    }

    public void setIconItems(List<Integer> list) {
        if (!PatchProxy.proxy(new Object[]{list}, this, f14765a, false, 8521, new Class[]{List.class}, Void.TYPE).isSupported) {
            if (list == null || list.size() == 0) {
                this.f14796t = null;
                setMax(0);
                return;
            }
            this.f14794r = list.size();
            this.f14796t = new Drawable[this.f14794r];
            for (int i = 0; i < this.f14794r; i++) {
                if (list.get(i).intValue() == -1) {
                    this.f14796t[i] = null;
                } else {
                    this.f14796t[i] = getResources().getDrawable(list.get(i).intValue());
                }
            }
        }
    }

    public void setIconSelectedItems(List<Integer> list) {
        if (!PatchProxy.proxy(new Object[]{list}, this, f14765a, false, 8522, new Class[]{List.class}, Void.TYPE).isSupported) {
            if (list == null || list.size() == 0) {
                this.f14796t = null;
                setMax(0);
                return;
            }
            this.f14794r = list.size();
            this.f14797u = new Drawable[this.f14794r];
            for (int i = 0; i < this.f14794r; i++) {
                if (list.get(i).intValue() == -1) {
                    this.f14797u[i] = null;
                } else {
                    this.f14797u[i] = getResources().getDrawable(list.get(i).intValue());
                }
            }
        }
    }

    private void setThumb(Drawable drawable) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{drawable}, this, f14765a, false, 8523, new Class[]{Drawable.class}, Void.TYPE).isSupported) {
            if (drawable == null) {
                drawable = getResources().getDrawable(R.drawable.mz_scrubber_control_selector);
            }
            if (this.f14791o == null || drawable == this.f14791o) {
                z = false;
            } else {
                this.f14791o.setCallback((Drawable.Callback) null);
                this.f14791o.getIntrinsicWidth();
            }
            if (drawable != null) {
                drawable.setCallback(this);
                this.f14780d = drawable.getIntrinsicWidth() / 2;
                if (z && !(drawable.getIntrinsicWidth() == this.f14791o.getIntrinsicWidth() && drawable.getIntrinsicHeight() == this.f14791o.getIntrinsicHeight())) {
                    requestLayout();
                }
                this.f14783g = drawable.getIntrinsicWidth() / 2;
                this.f14784h = drawable.getIntrinsicHeight() / 2;
            }
            this.f14791o = drawable;
            invalidate();
            if (z) {
                m16495a(getWidth(), getHeight());
                if (drawable != null && drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
            }
        }
    }

    private void setThumbOffset(int i) {
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14765a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8524, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            this.f14780d = i;
            invalidate();
        }
    }

    public synchronized void setProgress(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f14765a, false, 8525, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            mo23021a(i, false);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0087, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo23021a(int r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0088 }
            java.lang.Integer r2 = new java.lang.Integer     // Catch:{ all -> 0x0088 }
            r2.<init>(r10)     // Catch:{ all -> 0x0088 }
            r8 = 0
            r1[r8] = r2     // Catch:{ all -> 0x0088 }
            java.lang.Byte r2 = new java.lang.Byte     // Catch:{ all -> 0x0088 }
            r2.<init>(r11)     // Catch:{ all -> 0x0088 }
            r3 = 1
            r1[r3] = r2     // Catch:{ all -> 0x0088 }
            com.meizu.savior.ChangeQuickRedirect r4 = f14765a     // Catch:{ all -> 0x0088 }
            r5 = 0
            r6 = 8526(0x214e, float:1.1947E-41)
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x0088 }
            java.lang.Class r2 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0088 }
            r0[r8] = r2     // Catch:{ all -> 0x0088 }
            java.lang.Class r2 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0088 }
            r0[r3] = r2     // Catch:{ all -> 0x0088 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0088 }
            r2 = r9
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0088 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x0034
            monitor-exit(r9)
            return
        L_0x0034:
            if (r10 >= 0) goto L_0x0037
            r10 = 0
        L_0x0037:
            int r0 = r9.f14778b     // Catch:{ all -> 0x0088 }
            if (r10 <= r0) goto L_0x003d
            int r10 = r9.f14778b     // Catch:{ all -> 0x0088 }
        L_0x003d:
            int r0 = r9.f14779c     // Catch:{ all -> 0x0088 }
            if (r10 != r0) goto L_0x0045
            boolean r0 = r9.f14790n     // Catch:{ all -> 0x0088 }
            if (r0 != 0) goto L_0x0086
        L_0x0045:
            r9.f14779c = r10     // Catch:{ all -> 0x0088 }
            if (r11 != 0) goto L_0x005a
            int r10 = r9.f14778b     // Catch:{ all -> 0x0088 }
            if (r10 <= 0) goto L_0x0055
            int r10 = r9.f14779c     // Catch:{ all -> 0x0088 }
            float r10 = (float) r10     // Catch:{ all -> 0x0088 }
            int r11 = r9.f14778b     // Catch:{ all -> 0x0088 }
            float r11 = (float) r11     // Catch:{ all -> 0x0088 }
            float r10 = r10 / r11
            goto L_0x0056
        L_0x0055:
            r10 = 0
        L_0x0056:
            r9.m16494a((float) r10)     // Catch:{ all -> 0x0088 }
            goto L_0x006b
        L_0x005a:
            com.meizu.media.camera.views.MzEnhanceSeekBar$OnEnhanceSeekBarChangeListener r10 = r9.f14799w     // Catch:{ all -> 0x0088 }
            if (r10 == 0) goto L_0x006b
            boolean r10 = r9.f14789m     // Catch:{ all -> 0x0088 }
            if (r10 == 0) goto L_0x006b
            com.meizu.media.camera.views.MzEnhanceSeekBar$OnEnhanceSeekBarChangeListener r10 = r9.f14799w     // Catch:{ all -> 0x0088 }
            int r11 = r9.getProgress()     // Catch:{ all -> 0x0088 }
            r10.onProgressDragging(r9, r11)     // Catch:{ all -> 0x0088 }
        L_0x006b:
            android.content.Context r10 = r9.getContext()     // Catch:{ all -> 0x0088 }
            java.lang.String r11 = "accessibility"
            java.lang.Object r10 = r10.getSystemService(r11)     // Catch:{ all -> 0x0088 }
            android.view.accessibility.AccessibilityManager r10 = (android.view.accessibility.AccessibilityManager) r10     // Catch:{ all -> 0x0088 }
            if (r10 == 0) goto L_0x0086
            boolean r10 = r10.isTouchExplorationEnabled()     // Catch:{ all -> 0x0088 }
            if (r10 == 0) goto L_0x0086
            boolean r10 = r9.f14777L     // Catch:{ all -> 0x0088 }
            if (r10 == 0) goto L_0x0086
            r9.m16507d()     // Catch:{ all -> 0x0088 }
        L_0x0086:
            monitor-exit(r9)
            return
        L_0x0088:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.views.MzEnhanceSeekBar.mo23021a(int, boolean):void");
    }

    public synchronized int getProgress() {
        return this.f14779c;
    }

    private synchronized int getMax() {
        return this.f14778b;
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i != this.f14778b) {
            this.f14778b = i;
            if (this.f14779c > i) {
                this.f14779c = i;
            }
        }
        this.f14790n = false;
    }

    /* renamed from: a */
    private void m16494a(float f) {
        Drawable drawable;
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f14765a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8527, new Class[]{Float.TYPE}, Void.TYPE).isSupported && (drawable = this.f14791o) != null) {
            m16496a(getWidth(), drawable, f, Integer.MIN_VALUE);
        }
    }

    public void drawableStateChanged() {
        if (!PatchProxy.proxy(new Object[0], this, f14765a, false, 8528, new Class[0], Void.TYPE).isSupported) {
            super.drawableStateChanged();
            if (this.f14791o != null && this.f14791o.isStateful()) {
                this.f14791o.setState(getDrawableState());
            }
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Object[] objArr = {new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)};
        ChangeQuickRedirect changeQuickRedirect = f14765a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8529, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            m16495a(i, i2);
        }
    }

    /* renamed from: a */
    private void m16495a(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f14765a, false, 8530, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            Drawable drawable = this.f14791o;
            int max = getMax();
            float progress = max > 0 ? ((float) getProgress()) / ((float) max) : 0.0f;
            if (drawable != null) {
                m16496a(i, drawable, progress, 0);
            }
        }
    }

    /* renamed from: a */
    private void m16496a(int i, Drawable drawable, float f, int i2) {
        int i3;
        int i4;
        boolean z;
        Object[] objArr = {new Integer(i), drawable, new Float(f), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14765a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8531, new Class[]{Integer.TYPE, Drawable.class, Float.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            int paddingLeft = ((i - getPaddingLeft()) - getPaddingRight()) - (this.f14793q * 2);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int i5 = paddingLeft - intrinsicWidth;
            if (f <= 0.0f) {
                f = 0.0f;
            }
            if (f >= 1.0f) {
                f = 1.0f;
            }
            int round = i5 - Math.round((1.0f - f) * ((float) i5));
            if (i2 == Integer.MIN_VALUE) {
                Rect bounds = drawable.getBounds();
                i4 = bounds.top;
                i3 = bounds.bottom;
                z = true;
            } else {
                i4 = i2;
                i3 = drawable.getIntrinsicHeight() + i2;
                z = false;
            }
            if (this.f14767B != null) {
                if (!z) {
                    this.f14767B.cancel();
                    this.f14767B = null;
                } else if (this.f14767B.isStarted()) {
                    this.f14767B.cancel();
                    this.f14767B = null;
                    z = false;
                }
            }
            if (z) {
                int i6 = drawable.getBounds().left;
                if (i6 == round) {
                    this.f14790n = true;
                    if (i2 == Integer.MIN_VALUE && this.f14799w != null) {
                        this.f14799w.onProgressChanged(this, getProgress());
                        return;
                    }
                    return;
                }
                float f2 = (float) i6;
                float f3 = (float) i4;
                this.f14802z.setXY(f2, f3);
                this.f14766A.setXY((float) round, f3);
                this.f14769D.setDrawable(drawable);
                this.f14767B = ObjectAnimator.ofObject(this.f14769D, "xY", this.f14768C, new Object[]{this.f14802z, this.f14766A});
                this.f14767B.setDuration(256);
                this.f14767B.setInterpolator(this.f14770E);
                this.f14767B.addListener(new AnimatorListenerAdapter() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f14803a;

                    public void onAnimationCancel(Animator animator) {
                        if (!PatchProxy.proxy(new Object[]{animator}, this, f14803a, false, 8550, new Class[]{Animator.class}, Void.TYPE).isSupported && MzEnhanceSeekBar.this.f14799w != null) {
                            MzEnhanceSeekBar.this.f14799w.onProgressChanged(MzEnhanceSeekBar.this, MzEnhanceSeekBar.this.getProgress());
                        }
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (!PatchProxy.proxy(new Object[]{animator}, this, f14803a, false, 8551, new Class[]{Animator.class}, Void.TYPE).isSupported && MzEnhanceSeekBar.this.f14799w != null) {
                            MzEnhanceSeekBar.this.f14799w.onProgressChanged(MzEnhanceSeekBar.this, MzEnhanceSeekBar.this.getProgress());
                        }
                    }
                });
                this.f14767B.start();
            } else {
                this.f14791o.setBounds(round, i4, intrinsicWidth + round, i3);
                invalidate();
            }
            this.f14790n = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x021f, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x016d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onDraw(android.graphics.Canvas r14) {
        /*
            r13 = this;
            monitor-enter(r13)
            r8 = 1
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ all -> 0x0220 }
            r9 = 0
            r1[r9] = r14     // Catch:{ all -> 0x0220 }
            com.meizu.savior.ChangeQuickRedirect r3 = f14765a     // Catch:{ all -> 0x0220 }
            r4 = 0
            r5 = 8532(0x2154, float:1.1956E-41)
            java.lang.Class[] r6 = new java.lang.Class[r8]     // Catch:{ all -> 0x0220 }
            java.lang.Class<android.graphics.Canvas> r2 = android.graphics.Canvas.class
            r6[r9] = r2     // Catch:{ all -> 0x0220 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0220 }
            r2 = r13
            com.meizu.savior.PatchProxyResult r1 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0220 }
            boolean r1 = r1.isSupported     // Catch:{ all -> 0x0220 }
            if (r1 == 0) goto L_0x001f
            monitor-exit(r13)
            return
        L_0x001f:
            super.onDraw(r14)     // Catch:{ all -> 0x0220 }
            android.graphics.drawable.Drawable r1 = r13.f14791o     // Catch:{ all -> 0x0220 }
            if (r1 == 0) goto L_0x021e
            r14.save()     // Catch:{ all -> 0x0220 }
            int r1 = r13.getPaddingLeft()     // Catch:{ all -> 0x0220 }
            int r2 = r13.f14783g     // Catch:{ all -> 0x0220 }
            int r1 = r1 + r2
            int r2 = r13.f14793q     // Catch:{ all -> 0x0220 }
            int r7 = r1 + r2
            java.lang.CharSequence[] r1 = r13.f14795s     // Catch:{ all -> 0x0220 }
            if (r1 == 0) goto L_0x0052
            int r1 = r13.getPaddingLeft()     // Catch:{ all -> 0x0220 }
            int r2 = r13.f14783g     // Catch:{ all -> 0x0220 }
            int r1 = r1 + r2
            int r2 = r13.f14793q     // Catch:{ all -> 0x0220 }
            int r1 = r1 + r2
            float r1 = (float) r1     // Catch:{ all -> 0x0220 }
            int r2 = r13.getPaddingTop()     // Catch:{ all -> 0x0220 }
            int r3 = r13.f14788l     // Catch:{ all -> 0x0220 }
            int r2 = r2 + r3
            int r3 = r13.f14784h     // Catch:{ all -> 0x0220 }
            int r2 = r2 + r3
            float r2 = (float) r2     // Catch:{ all -> 0x0220 }
            r14.translate(r1, r2)     // Catch:{ all -> 0x0220 }
            goto L_0x0068
        L_0x0052:
            int r1 = r13.getPaddingLeft()     // Catch:{ all -> 0x0220 }
            int r2 = r13.f14783g     // Catch:{ all -> 0x0220 }
            int r1 = r1 + r2
            int r2 = r13.f14793q     // Catch:{ all -> 0x0220 }
            int r1 = r1 + r2
            float r1 = (float) r1     // Catch:{ all -> 0x0220 }
            int r2 = r13.getPaddingTop()     // Catch:{ all -> 0x0220 }
            int r3 = r13.f14784h     // Catch:{ all -> 0x0220 }
            int r2 = r2 + r3
            float r2 = (float) r2     // Catch:{ all -> 0x0220 }
            r14.translate(r1, r2)     // Catch:{ all -> 0x0220 }
        L_0x0068:
            int r1 = r13.getWidth()     // Catch:{ all -> 0x0220 }
            int r2 = r13.getPaddingLeft()     // Catch:{ all -> 0x0220 }
            int r1 = r1 - r2
            int r2 = r13.getPaddingRight()     // Catch:{ all -> 0x0220 }
            int r1 = r1 - r2
            int r2 = r13.f14783g     // Catch:{ all -> 0x0220 }
            int r2 = r2 * 2
            int r1 = r1 - r2
            int r2 = r13.f14793q     // Catch:{ all -> 0x0220 }
            int r2 = r2 * 2
            int r1 = r1 - r2
            float r10 = (float) r1     // Catch:{ all -> 0x0220 }
            int r1 = r13.f14794r     // Catch:{ all -> 0x0220 }
            r11 = 0
            if (r1 <= 0) goto L_0x008e
            int r1 = r13.f14794r     // Catch:{ all -> 0x0220 }
            int r1 = r1 - r8
            float r1 = (float) r1     // Catch:{ all -> 0x0220 }
            float r1 = r10 / r1
            r12 = r1
            goto L_0x008f
        L_0x008e:
            r12 = 0
        L_0x008f:
            android.graphics.drawable.Drawable r1 = r13.f14791o     // Catch:{ all -> 0x0220 }
            android.graphics.Rect r1 = r1.getBounds()     // Catch:{ all -> 0x0220 }
            int r1 = r1.left     // Catch:{ all -> 0x0220 }
            float r1 = (float) r1     // Catch:{ all -> 0x0220 }
            r13.f14775J = r1     // Catch:{ all -> 0x0220 }
            android.graphics.Paint r1 = r13.f14801y     // Catch:{ all -> 0x0220 }
            int r2 = r13.f14786j     // Catch:{ all -> 0x0220 }
            r1.setColor(r2)     // Catch:{ all -> 0x0220 }
            android.graphics.Paint r1 = r13.f14801y     // Catch:{ all -> 0x0220 }
            r1.setAntiAlias(r8)     // Catch:{ all -> 0x0220 }
            r2 = 0
            r3 = 0
            float r4 = r13.f14775J     // Catch:{ all -> 0x0220 }
            r5 = 0
            android.graphics.Paint r6 = r13.f14801y     // Catch:{ all -> 0x0220 }
            r1 = r14
            r1.drawLine(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0220 }
            android.graphics.Paint r1 = r13.f14801y     // Catch:{ all -> 0x0220 }
            int r2 = r13.f14787k     // Catch:{ all -> 0x0220 }
            r1.setColor(r2)     // Catch:{ all -> 0x0220 }
            android.graphics.Paint r1 = r13.f14801y     // Catch:{ all -> 0x0220 }
            r1.setAntiAlias(r8)     // Catch:{ all -> 0x0220 }
            float r2 = r13.f14775J     // Catch:{ all -> 0x0220 }
            r3 = 0
            r5 = 0
            android.graphics.Paint r6 = r13.f14801y     // Catch:{ all -> 0x0220 }
            r1 = r14
            r4 = r10
            r1.drawLine(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0220 }
            r1 = 0
            r2 = 0
        L_0x00ca:
            int r3 = r13.f14794r     // Catch:{ all -> 0x0220 }
            if (r1 >= r3) goto L_0x01a1
            int r3 = r13.f14794r     // Catch:{ all -> 0x0220 }
            int r4 = r13.getMax()     // Catch:{ all -> 0x0220 }
            int r4 = r4 - r8
            if (r3 != r4) goto L_0x00ef
            int r2 = r13.getProgress()     // Catch:{ all -> 0x0220 }
            if (r2 != r1) goto L_0x00e6
            android.graphics.Paint r2 = r13.f14801y     // Catch:{ all -> 0x0220 }
            int r3 = r13.f14786j     // Catch:{ all -> 0x0220 }
            r2.setColor(r3)     // Catch:{ all -> 0x0220 }
        L_0x00e4:
            r2 = 1
            goto L_0x0111
        L_0x00e6:
            android.graphics.Paint r2 = r13.f14801y     // Catch:{ all -> 0x0220 }
            int r3 = r13.f14785i     // Catch:{ all -> 0x0220 }
            r2.setColor(r3)     // Catch:{ all -> 0x0220 }
        L_0x00ed:
            r2 = 0
            goto L_0x0111
        L_0x00ef:
            int r3 = r13.f14794r     // Catch:{ all -> 0x0220 }
            int r3 = r3 - r8
            if (r3 == 0) goto L_0x0111
            int r2 = r13.getProgress()     // Catch:{ all -> 0x0220 }
            int r4 = r13.getMax()     // Catch:{ all -> 0x0220 }
            int r4 = r4 * r1
            int r4 = r4 / r3
            if (r2 != r4) goto L_0x0109
            android.graphics.Paint r2 = r13.f14801y     // Catch:{ all -> 0x0220 }
            int r3 = r13.f14786j     // Catch:{ all -> 0x0220 }
            r2.setColor(r3)     // Catch:{ all -> 0x0220 }
            goto L_0x00e4
        L_0x0109:
            android.graphics.Paint r2 = r13.f14801y     // Catch:{ all -> 0x0220 }
            int r3 = r13.f14785i     // Catch:{ all -> 0x0220 }
            r2.setColor(r3)     // Catch:{ all -> 0x0220 }
            goto L_0x00ed
        L_0x0111:
            android.graphics.drawable.Drawable[] r3 = r13.f14796t     // Catch:{ all -> 0x0220 }
            if (r3 == 0) goto L_0x0159
            android.graphics.drawable.Drawable[] r3 = r13.f14797u     // Catch:{ all -> 0x0220 }
            if (r3 == 0) goto L_0x0159
            if (r2 == 0) goto L_0x0120
            android.graphics.drawable.Drawable[] r3 = r13.f14797u     // Catch:{ all -> 0x0220 }
            r3 = r3[r1]     // Catch:{ all -> 0x0220 }
            goto L_0x0124
        L_0x0120:
            android.graphics.drawable.Drawable[] r3 = r13.f14796t     // Catch:{ all -> 0x0220 }
            r3 = r3[r1]     // Catch:{ all -> 0x0220 }
        L_0x0124:
            if (r3 == 0) goto L_0x0159
            float r4 = (float) r1     // Catch:{ all -> 0x0220 }
            float r4 = r4 * r12
            int r5 = r3.getIntrinsicWidth()     // Catch:{ all -> 0x0220 }
            int r5 = r5 / 2
            float r5 = (float) r5     // Catch:{ all -> 0x0220 }
            float r4 = r4 - r5
            java.lang.Float r4 = java.lang.Float.valueOf(r4)     // Catch:{ all -> 0x0220 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x0220 }
            int r5 = r13.f14784h     // Catch:{ all -> 0x0220 }
            int r6 = r3.getIntrinsicHeight()     // Catch:{ all -> 0x0220 }
            int r5 = r5 + r6
            r6 = 5
            int r6 = com.meizu.media.camera.util.CameraUtil.m15810a((int) r6)     // Catch:{ all -> 0x0220 }
            int r5 = r5 - r6
            int r5 = -r5
            int r6 = r3.getIntrinsicWidth()     // Catch:{ all -> 0x0220 }
            int r6 = r6 + r4
            int r10 = r3.getIntrinsicHeight()     // Catch:{ all -> 0x0220 }
            int r10 = r10 + r5
            r3.setBounds(r4, r5, r6, r10)     // Catch:{ all -> 0x0220 }
            r3.draw(r14)     // Catch:{ all -> 0x0220 }
            r3 = 1
            goto L_0x015a
        L_0x0159:
            r3 = 0
        L_0x015a:
            java.lang.CharSequence[] r4 = r13.f14795s     // Catch:{ all -> 0x0220 }
            if (r4 == 0) goto L_0x019d
            if (r3 != 0) goto L_0x019d
            java.lang.CharSequence[] r3 = r13.f14795s     // Catch:{ all -> 0x0220 }
            r3 = r3[r1]     // Catch:{ all -> 0x0220 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0220 }
            boolean r4 = r13.m16498a((int) r1)     // Catch:{ all -> 0x0220 }
            if (r4 == 0) goto L_0x016d
            goto L_0x019d
        L_0x016d:
            float r4 = (float) r1     // Catch:{ all -> 0x0220 }
            float r4 = r4 * r12
            android.graphics.Paint r5 = r13.f14801y     // Catch:{ all -> 0x0220 }
            float r5 = r5.measureText(r3)     // Catch:{ all -> 0x0220 }
            r6 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 / r6
            float r4 = r4 - r5
            float r5 = (float) r7     // Catch:{ all -> 0x0220 }
            android.graphics.Paint r10 = r13.f14801y     // Catch:{ all -> 0x0220 }
            float r10 = r10.measureText(r3)     // Catch:{ all -> 0x0220 }
            float r10 = r10 / r6
            float r5 = r5 - r10
            int r6 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r6 >= 0) goto L_0x0192
            if (r1 != 0) goto L_0x018b
            float r5 = -r5
            goto L_0x0191
        L_0x018b:
            int r6 = r13.f14794r     // Catch:{ all -> 0x0220 }
            int r6 = r6 - r8
            if (r1 == r6) goto L_0x0191
            r5 = 0
        L_0x0191:
            float r4 = r4 + r5
        L_0x0192:
            int r5 = r13.f14784h     // Catch:{ all -> 0x0220 }
            int r5 = -r5
            int r5 = r5 + -12
            float r5 = (float) r5     // Catch:{ all -> 0x0220 }
            android.graphics.Paint r6 = r13.f14801y     // Catch:{ all -> 0x0220 }
            r14.drawText(r3, r4, r5, r6)     // Catch:{ all -> 0x0220 }
        L_0x019d:
            int r1 = r1 + 1
            goto L_0x00ca
        L_0x01a1:
            r14.restore()     // Catch:{ all -> 0x0220 }
            r14.save()     // Catch:{ all -> 0x0220 }
            java.lang.CharSequence[] r1 = r13.f14795s     // Catch:{ all -> 0x0220 }
            if (r1 == 0) goto L_0x01bf
            int r1 = r13.getPaddingLeft()     // Catch:{ all -> 0x0220 }
            int r2 = r13.f14793q     // Catch:{ all -> 0x0220 }
            int r1 = r1 + r2
            float r1 = (float) r1     // Catch:{ all -> 0x0220 }
            int r2 = r13.getPaddingTop()     // Catch:{ all -> 0x0220 }
            int r3 = r13.f14788l     // Catch:{ all -> 0x0220 }
            int r2 = r2 + r3
            float r2 = (float) r2     // Catch:{ all -> 0x0220 }
            r14.translate(r1, r2)     // Catch:{ all -> 0x0220 }
            goto L_0x01cf
        L_0x01bf:
            int r1 = r13.getPaddingLeft()     // Catch:{ all -> 0x0220 }
            int r2 = r13.f14793q     // Catch:{ all -> 0x0220 }
            int r1 = r1 + r2
            float r1 = (float) r1     // Catch:{ all -> 0x0220 }
            int r2 = r13.getPaddingTop()     // Catch:{ all -> 0x0220 }
            float r2 = (float) r2     // Catch:{ all -> 0x0220 }
            r14.translate(r1, r2)     // Catch:{ all -> 0x0220 }
        L_0x01cf:
            boolean r1 = r13.f14781e     // Catch:{ all -> 0x0220 }
            if (r1 == 0) goto L_0x0216
            android.graphics.drawable.Drawable r1 = r13.f14792p     // Catch:{ all -> 0x0220 }
            if (r1 == 0) goto L_0x0216
            android.graphics.drawable.Drawable r1 = r13.f14791o     // Catch:{ all -> 0x0220 }
            android.graphics.Rect r1 = r1.getBounds()     // Catch:{ all -> 0x0220 }
            int r1 = r1.centerX()     // Catch:{ all -> 0x0220 }
            android.graphics.drawable.Drawable r2 = r13.f14791o     // Catch:{ all -> 0x0220 }
            android.graphics.Rect r2 = r2.getBounds()     // Catch:{ all -> 0x0220 }
            int r2 = r2.centerY()     // Catch:{ all -> 0x0220 }
            android.graphics.drawable.Drawable r3 = r13.f14791o     // Catch:{ all -> 0x0220 }
            int r3 = r3.getIntrinsicWidth()     // Catch:{ all -> 0x0220 }
            int r3 = r3 / 2
            android.graphics.drawable.Drawable r4 = r13.f14792p     // Catch:{ all -> 0x0220 }
            int r5 = r1 - r3
            int r6 = r13.f14793q     // Catch:{ all -> 0x0220 }
            int r5 = r5 - r6
            int r6 = r2 - r3
            int r7 = r13.f14793q     // Catch:{ all -> 0x0220 }
            int r6 = r6 - r7
            int r1 = r1 + r3
            int r7 = r13.f14793q     // Catch:{ all -> 0x0220 }
            int r1 = r1 + r7
            int r2 = r2 + r3
            int r3 = r13.f14793q     // Catch:{ all -> 0x0220 }
            int r2 = r2 + r3
            r4.setBounds(r5, r6, r1, r2)     // Catch:{ all -> 0x0220 }
            android.graphics.drawable.Drawable r1 = r13.f14792p     // Catch:{ all -> 0x0220 }
            r2 = 204(0xcc, float:2.86E-43)
            r1.setAlpha(r2)     // Catch:{ all -> 0x0220 }
            android.graphics.drawable.Drawable r1 = r13.f14792p     // Catch:{ all -> 0x0220 }
            r1.draw(r14)     // Catch:{ all -> 0x0220 }
        L_0x0216:
            android.graphics.drawable.Drawable r1 = r13.f14791o     // Catch:{ all -> 0x0220 }
            r1.draw(r14)     // Catch:{ all -> 0x0220 }
            r14.restore()     // Catch:{ all -> 0x0220 }
        L_0x021e:
            monitor-exit(r13)
            return
        L_0x0220:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.views.MzEnhanceSeekBar.onDraw(android.graphics.Canvas):void");
    }

    public synchronized void onMeasure(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f14765a, false, 8533, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            int intrinsicHeight = this.f14791o == null ? 0 : this.f14791o.getIntrinsicHeight();
            int i3 = 20;
            if (this.f14795s != null) {
                i3 = 20 + this.f14788l;
            }
            int paddingLeft = getPaddingLeft() + 64 + getPaddingRight();
            if (intrinsicHeight != 0) {
                i3 = Math.max(intrinsicHeight + (this.f14795s != null ? this.f14788l : 0), i3);
            }
            setMeasuredDimension(resolveSizeAndState(Math.max(paddingLeft, View.MeasureSpec.getSize(i)), i, 0), resolveSizeAndState(i3 + getPaddingTop() + getPaddingBottom() + this.f14793q, i2, 0));
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14765a, false, 8534, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!isEnabled()) {
            return false;
        }
        if ((this.f14800x != null && this.f14800x.isInterceptTouchEvent()) || getMax() == 0) {
            return false;
        }
        float x = motionEvent.getX();
        switch (motionEvent.getAction()) {
            case 0:
                this.f14773H = x;
                if (this.f14791o != null) {
                    this.f14774I = (float) this.f14791o.getBounds().left;
                }
                this.f14782f = Math.round((((x - ((float) getPaddingLeft())) - ((float) this.f14783g)) / ((float) ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.f14783g * 2)) - (this.f14793q * 2)))) * ((float) getMax()));
                if (m16500b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    setPressed(true);
                    if (this.f14791o != null) {
                        invalidate(this.f14791o.getBounds());
                    }
                    mo23020a();
                }
                m16504c();
                this.f14772G = false;
                break;
            case 1:
                if (this.f14772G) {
                    this.f14781e = false;
                    if (this.f14792p != null) {
                        invalidate(this.f14792p.getBounds());
                    }
                    if (!this.f14789m) {
                        mo23021a(this.f14782f, false);
                        break;
                    } else {
                        m16499b(motionEvent);
                        mo23022b();
                        setPressed(false);
                        break;
                    }
                } else {
                    m16505c(motionEvent);
                    break;
                }
            case 2:
                if (this.f14789m) {
                    this.f14790n = false;
                    m16497a(motionEvent);
                    m16504c();
                }
                if (Math.abs(motionEvent.getX() - this.f14773H) <= ((float) this.f14771F)) {
                    this.f14772G = false;
                    break;
                } else {
                    this.f14772G = true;
                    this.f14781e = true;
                    if (this.f14792p != null) {
                        invalidate(this.f14792p.getBounds());
                        break;
                    }
                }
                break;
            case 3:
                if (this.f14789m) {
                    mo23022b();
                    setPressed(false);
                }
                invalidate();
                break;
        }
        return true;
    }

    /* renamed from: a */
    private void m16497a(MotionEvent motionEvent) {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{motionEvent}, this, f14765a, false, 8535, new Class[]{MotionEvent.class}, Void.TYPE).isSupported) {
            int width = getWidth();
            int paddingLeft = (((width - getPaddingLeft()) - getPaddingRight()) - (this.f14783g * 2)) - (this.f14793q * 2);
            Rect bounds = this.f14791o.getBounds();
            int x = (int) ((this.f14774I + ((float) ((int) motionEvent.getX()))) - this.f14773H);
            if (x >= 0) {
                i = x > ((width - getPaddingRight()) - (this.f14783g * 2)) - (this.f14793q * 2) ? ((width - getPaddingRight()) - (this.f14783g * 2)) - (this.f14793q * 2) : x;
            }
            mo23021a(Math.round((((float) ((i - getPaddingLeft()) - this.f14793q)) / ((float) paddingLeft)) * ((float) getMax())), true);
            this.f14791o.setBounds(i, bounds.top, this.f14791o.getIntrinsicWidth() + i, bounds.bottom);
            invalidate();
        }
    }

    /* renamed from: b */
    private void m16499b(MotionEvent motionEvent) {
        float f;
        if (!PatchProxy.proxy(new Object[]{motionEvent}, this, f14765a, false, 8536, new Class[]{MotionEvent.class}, Void.TYPE).isSupported) {
            int width = getWidth();
            int paddingLeft = (((width - getPaddingLeft()) - getPaddingRight()) - (this.f14783g * 2)) - (this.f14793q * 2);
            int x = (int) ((this.f14774I + ((float) ((int) motionEvent.getX()))) - this.f14773H);
            if (x < 0) {
                f = 0.0f;
            } else if (x > (width - getPaddingRight()) - (this.f14783g * 2)) {
                f = 1.0f;
            } else {
                f = ((float) ((x - getPaddingLeft()) - this.f14793q)) / ((float) paddingLeft);
            }
            mo23021a(Math.round(0.0f + (f * ((float) getMax()))), false);
        }
    }

    /* renamed from: c */
    private void m16505c(MotionEvent motionEvent) {
        if (!PatchProxy.proxy(new Object[]{motionEvent}, this, f14765a, false, 8537, new Class[]{MotionEvent.class}, Void.TYPE).isSupported) {
            float round = (float) Math.round((((((float) ((int) motionEvent.getX())) - ((float) getPaddingLeft())) - ((float) this.f14783g)) / ((float) ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.f14783g * 2)) - (this.f14793q * 2)))) * ((float) getMax()));
            float f = round / ((float) this.f14778b);
            mo23021a((int) round, true);
            m16496a(getWidth(), this.f14791o, f, Integer.MIN_VALUE);
        }
    }

    /* renamed from: c */
    private void m16504c() {
        if (!PatchProxy.proxy(new Object[0], this, f14765a, false, 8538, new Class[0], Void.TYPE).isSupported && getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo23020a() {
        if (!PatchProxy.proxy(new Object[0], this, f14765a, false, 8539, new Class[0], Void.TYPE).isSupported) {
            this.f14789m = true;
            if (this.f14799w != null) {
                this.f14799w.onStartTrackingTouch(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo23022b() {
        if (!PatchProxy.proxy(new Object[0], this, f14765a, false, 8540, new Class[0], Void.TYPE).isSupported) {
            this.f14789m = false;
            if (this.f14799w != null) {
                this.f14799w.onStopTrackingTouch(this);
            }
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {

            /* renamed from: a */
            public static ChangeQuickRedirect f14812a;

            public SavedState createFromParcel(Parcel parcel) {
                PatchProxyResult proxy = PatchProxy.proxy(new Object[]{parcel}, this, f14812a, false, 8556, new Class[]{Parcel.class}, SavedState.class);
                return proxy.isSupported ? (SavedState) proxy.result : new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        public static ChangeQuickRedirect f14810a;

        /* renamed from: b */
        int f14811b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f14811b = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (!PatchProxy.proxy(new Object[]{parcel, new Integer(i)}, this, f14810a, false, 8555, new Class[]{Parcel.class, Integer.TYPE}, Void.TYPE).isSupported) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f14811b);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14765a, false, 8541, new Class[0], Parcelable.class);
        if (proxy.isSupported) {
            return (Parcelable) proxy.result;
        }
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f14811b = this.f14779c;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!PatchProxy.proxy(new Object[]{parcelable}, this, f14765a, false, 8542, new Class[]{Parcelable.class}, Void.TYPE).isSupported) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            mo23021a(savedState.f14811b, true);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!PatchProxy.proxy(new Object[]{accessibilityEvent}, this, f14765a, false, 8543, new Class[]{AccessibilityEvent.class}, Void.TYPE).isSupported) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(MzEnhanceSeekBar.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (!PatchProxy.proxy(new Object[]{accessibilityNodeInfo}, this, f14765a, false, 8544, new Class[]{AccessibilityNodeInfo.class}, Void.TYPE).isSupported) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(MzEnhanceSeekBar.class.getName());
            if (isEnabled()) {
                int progress = getProgress();
                if (progress > 0) {
                    accessibilityNodeInfo.addAction(8192);
                }
                if (progress < getMax()) {
                    accessibilityNodeInfo.addAction(4096);
                }
            }
        }
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), bundle}, this, f14765a, false, 8545, new Class[]{Integer.TYPE, Bundle.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (i == 64) {
            this.f14777L = true;
        } else if (i == 128) {
            this.f14777L = false;
        }
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (!isEnabled()) {
            return false;
        }
        int progress = getProgress();
        int max = Math.max(1, Math.round(((float) getMax()) / 5.0f));
        if (i != 4096) {
            if (i != 8192 || progress <= 0) {
                return false;
            }
            mo23021a(progress - max, false);
            return true;
        } else if (progress >= getMax()) {
            return false;
        } else {
            mo23021a(progress + max, false);
            return true;
        }
    }

    private class DrawableXYHolder {

        /* renamed from: a */
        public static ChangeQuickRedirect f14807a;

        /* renamed from: c */
        private Drawable f14809c;

        public DrawableXYHolder() {
        }

        public DrawableXYHolder(Drawable drawable) {
            this.f14809c = drawable;
        }

        public void setDrawable(Drawable drawable) {
            this.f14809c = drawable;
        }

        public void setXY(XYHolder xYHolder) {
            if (!PatchProxy.proxy(new Object[]{xYHolder}, this, f14807a, false, 8553, new Class[]{XYHolder.class}, Void.TYPE).isSupported && this.f14809c != null) {
                this.f14809c.setBounds((int) xYHolder.getX(), (int) xYHolder.getY(), (int) (xYHolder.getX() + ((float) this.f14809c.getIntrinsicWidth())), (int) (xYHolder.getY() + ((float) this.f14809c.getIntrinsicHeight())));
                MzEnhanceSeekBar.this.invalidate();
            }
        }

        public XYHolder getXY() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14807a, false, 8554, new Class[0], XYHolder.class);
            if (proxy.isSupported) {
                return (XYHolder) proxy.result;
            }
            if (this.f14809c == null) {
                return null;
            }
            Rect bounds = this.f14809c.getBounds();
            return new XYHolder((float) bounds.left, (float) bounds.top);
        }
    }

    private class XYHolder {

        /* renamed from: b */
        private float f14816b;

        /* renamed from: c */
        private float f14817c;

        public XYHolder() {
            this.f14817c = 0.0f;
            this.f14816b = 0.0f;
        }

        public XYHolder(float f, float f2) {
            this.f14816b = f;
            this.f14817c = f2;
        }

        public float getX() {
            return this.f14816b;
        }

        public void setXY(float f, float f2) {
            this.f14816b = f;
            this.f14817c = f2;
        }

        public void setX(float f) {
            this.f14816b = f;
        }

        public float getY() {
            return this.f14817c;
        }

        public void setY(float f) {
            this.f14817c = f;
        }
    }

    private class XYEvaluator implements TypeEvaluator {

        /* renamed from: a */
        public static ChangeQuickRedirect f14813a;

        private XYEvaluator() {
        }

        public Object evaluate(float f, Object obj, Object obj2) {
            Object[] objArr = {new Float(f), obj, obj2};
            ChangeQuickRedirect changeQuickRedirect = f14813a;
            ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
            PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 8557, new Class[]{Float.TYPE, Object.class, Object.class}, Object.class);
            if (proxy.isSupported) {
                return proxy.result;
            }
            XYHolder xYHolder = (XYHolder) obj;
            XYHolder xYHolder2 = (XYHolder) obj2;
            return new XYHolder(xYHolder.getX() + ((xYHolder2.getX() - xYHolder.getX()) * f), xYHolder.getY() + (f * (xYHolder2.getY() - xYHolder.getY())));
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14765a, false, 8546, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action != 7) {
                switch (action) {
                    case 9:
                        motionEvent.setAction(0);
                        break;
                    case 10:
                        motionEvent.setAction(1);
                        break;
                }
            } else {
                motionEvent.setAction(2);
            }
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    /* renamed from: d */
    private void m16507d() {
        if (!PatchProxy.proxy(new Object[0], this, f14765a, false, 8547, new Class[0], Void.TYPE).isSupported) {
            if (this.f14776K == null) {
                this.f14776K = new AccessibilityEventSender();
            } else {
                removeCallbacks(this.f14776K);
            }
            postDelayed(this.f14776K, 200);
        }
    }

    private class AccessibilityEventSender implements Runnable {

        /* renamed from: a */
        public static ChangeQuickRedirect f14805a;

        private AccessibilityEventSender() {
        }

        public void run() {
            if (!PatchProxy.proxy(new Object[0], this, f14805a, false, 8552, new Class[0], Void.TYPE).isSupported) {
                MzEnhanceSeekBar.this.sendAccessibilityEvent(4);
                MzEnhanceSeekBar.this.sendAccessibilityEvent(4);
                if (MzEnhanceSeekBar.this.f14795s == null) {
                    return;
                }
                if (MzEnhanceSeekBar.this.f14794r - 1 == MzEnhanceSeekBar.this.f14778b) {
                    MzEnhanceSeekBar mzEnhanceSeekBar = MzEnhanceSeekBar.this;
                    mzEnhanceSeekBar.announceForAccessibility("进入滑块控件, 当前设置为" + MzEnhanceSeekBar.this.f14795s[MzEnhanceSeekBar.this.f14779c]);
                    return;
                }
                MzEnhanceSeekBar mzEnhanceSeekBar2 = MzEnhanceSeekBar.this;
                mzEnhanceSeekBar2.announceForAccessibility("进入滑块控件, 当前设置为" + MzEnhanceSeekBar.this.m16503c(MzEnhanceSeekBar.this.f14779c, MzEnhanceSeekBar.this.f14778b));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public String m16503c(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14765a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 8548, new Class[]{Integer.TYPE, Integer.TYPE}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        return new DecimalFormat("0%").format((double) ((((float) i) * 1.0f) / ((float) i2)));
    }

    public void onDetachedFromWindow() {
        if (!PatchProxy.proxy(new Object[0], this, f14765a, false, 8549, new Class[0], Void.TYPE).isSupported) {
            super.onDetachedFromWindow();
            if (this.f14776K != null) {
                this.f14777L = false;
                removeCallbacks(this.f14776K);
            }
        }
    }
}
