package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.RemoteViews;
import com.baidu.p020ar.msghandler.ComponentMessageType;
import com.meizu.common.R;

@RemoteViews.RemoteView
public class ProgressBar extends View {

    /* renamed from: a */
    private int f5917a;

    /* renamed from: b */
    private int f5918b;

    /* renamed from: c */
    private int f5919c;

    /* renamed from: d */
    private int f5920d;

    /* renamed from: e */
    int f5921e;

    /* renamed from: f */
    int f5922f;

    /* renamed from: g */
    int f5923g;

    /* renamed from: h */
    int f5924h;

    /* renamed from: i */
    private int f5925i;

    /* renamed from: j */
    private boolean f5926j;

    /* renamed from: k */
    private boolean f5927k;

    /* renamed from: l */
    private Transformation f5928l;

    /* renamed from: m */
    private AlphaAnimation f5929m;

    /* renamed from: n */
    private boolean f5930n;

    /* renamed from: o */
    private Drawable f5931o;

    /* renamed from: p */
    private Drawable f5932p;

    /* renamed from: q */
    private Drawable f5933q;

    /* renamed from: r */
    private boolean f5934r;

    /* renamed from: s */
    private Interpolator f5935s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C1491a f5936t;

    /* renamed from: u */
    private long f5937u;

    /* renamed from: v */
    private boolean f5938v;

    /* renamed from: w */
    private boolean f5939w;

    /* renamed from: x */
    private boolean f5940x;

    /* renamed from: y */
    private int f5941y;

    /* renamed from: z */
    private boolean f5942z;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo16012a(float f, boolean z) {
    }

    public ProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MeizuCommon_ProgressBarStyle);
    }

    public ProgressBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f5941y = 0;
        this.f5942z = false;
        this.f5937u = Thread.currentThread().getId();
        mo16013a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressBar, i, i2);
        boolean z = true;
        this.f5934r = true;
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ProgressBar_mcProgressDrawable);
        if (drawable != null) {
            setProgressDrawable(m5983a(drawable, false));
        }
        this.f5925i = obtainStyledAttributes.getInt(R.styleable.ProgressBar_mcIndeterminateDuration, this.f5925i);
        this.f5921e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ProgressBar_mcMinWidth, this.f5921e);
        this.f5922f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ProgressBar_mcMaxWidth, this.f5922f);
        this.f5923g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ProgressBar_mcMinHeight, this.f5923g);
        this.f5924h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ProgressBar_mcMaxHeight, this.f5924h);
        this.f5920d = obtainStyledAttributes.getInt(R.styleable.ProgressBar_mcIndeterminateBehavior, this.f5920d);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ProgressBar_mcInterpolator, 17432587);
        if (resourceId > 0) {
            setInterpolator(context, resourceId);
        }
        setMax(obtainStyledAttributes.getInt(R.styleable.ProgressBar_mcMax, this.f5919c));
        setProgress(obtainStyledAttributes.getInt(R.styleable.ProgressBar_mcProgress, this.f5917a));
        setSecondaryProgress(obtainStyledAttributes.getInt(R.styleable.ProgressBar_mcSecondaryProgress, this.f5918b));
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ProgressBar_mcIndeterminateDrawable);
        if (drawable2 != null) {
            setIndeterminateDrawable(m5982a(drawable2));
        }
        this.f5927k = obtainStyledAttributes.getBoolean(R.styleable.ProgressBar_mcIndeterminateOnly, this.f5927k);
        this.f5934r = false;
        if (!this.f5927k && !obtainStyledAttributes.getBoolean(R.styleable.ProgressBar_mcIndeterminate, this.f5926j)) {
            z = false;
        }
        setIndeterminate(z);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private Drawable m5983a(Drawable drawable, boolean z) {
        if (!(drawable instanceof LayerDrawable)) {
            return drawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        Drawable[] drawableArr = new Drawable[numberOfLayers];
        for (int i = 0; i < numberOfLayers; i++) {
            int id = layerDrawable.getId(i);
            drawableArr[i] = m5983a(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable2.setId(i2, layerDrawable.getId(i2));
        }
        return layerDrawable2;
    }

    /* access modifiers changed from: package-private */
    public Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, (RectF) null, (float[]) null);
    }

    /* renamed from: a */
    private Drawable m5982a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable a = m5983a(animationDrawable.getFrame(i), true);
            a.setLevel(ComponentMessageType.MSG_TYPE_ON_SHAKE);
            animationDrawable2.addFrame(a, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(ComponentMessageType.MSG_TYPE_ON_SHAKE);
        return animationDrawable2;
    }

    /* renamed from: a */
    private void mo16013a() {
        this.f5919c = 100;
        this.f5917a = 0;
        this.f5918b = 0;
        this.f5926j = false;
        this.f5927k = false;
        this.f5925i = 4000;
        this.f5920d = 1;
        this.f5921e = 24;
        this.f5922f = 48;
        this.f5923g = 24;
        this.f5924h = 48;
    }

    public synchronized void setIndeterminate(boolean z) {
        if ((!this.f5927k || !this.f5926j) && z != this.f5926j) {
            this.f5926j = z;
            if (z) {
                this.f5933q = this.f5931o;
                mo17102e();
            } else {
                this.f5933q = this.f5932p;
                mo17103f();
            }
        }
    }

    public Drawable getIndeterminateDrawable() {
        return this.f5931o;
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.f5931o = drawable;
        if (this.f5926j) {
            this.f5933q = drawable;
            postInvalidate();
        }
    }

    public Drawable getProgressDrawable() {
        return this.f5932p;
    }

    public void setProgressDrawable(Drawable drawable) {
        boolean z;
        if (this.f5932p == null || drawable == this.f5932p) {
            z = false;
        } else {
            this.f5932p.setCallback((Drawable.Callback) null);
            z = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            int minimumHeight = drawable.getMinimumHeight();
            if (this.f5924h < minimumHeight) {
                this.f5924h = minimumHeight;
                requestLayout();
            }
        }
        this.f5932p = drawable;
        if (!this.f5926j) {
            this.f5933q = drawable;
            postInvalidate();
        }
        if (z) {
            m5986a(getWidth(), getHeight());
            mo16014b();
            m5988a(16908301, this.f5917a, false, false);
            m5988a(16908303, this.f5918b, false, false);
        }
    }

    /* access modifiers changed from: package-private */
    public Drawable getCurrentDrawable() {
        return this.f5933q;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f5932p || drawable == this.f5931o || super.verifyDrawable(drawable);
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f5932p != null) {
            this.f5932p.jumpToCurrentState();
        }
        if (this.f5931o != null) {
            this.f5931o.jumpToCurrentState();
        }
    }

    public void postInvalidate() {
        if (!this.f5934r) {
            super.postInvalidate();
        }
    }

    /* renamed from: com.meizu.common.widget.ProgressBar$a */
    private class C1491a implements Runnable {

        /* renamed from: b */
        private int f5946b;

        /* renamed from: c */
        private int f5947c;

        /* renamed from: d */
        private boolean f5948d;

        C1491a(int i, int i2, boolean z) {
            this.f5946b = i;
            this.f5947c = i2;
            this.f5948d = z;
        }

        public void run() {
            ProgressBar.this.m5988a(this.f5946b, this.f5947c, this.f5948d, true);
            C1491a unused = ProgressBar.this.f5936t = this;
        }

        /* renamed from: a */
        public void mo17136a(int i, int i2, boolean z) {
            this.f5946b = i;
            this.f5947c = i2;
            this.f5948d = z;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m5988a(int i, int i2, boolean z, boolean z2) {
        float f = this.f5919c > 0 ? ((float) i2) / ((float) this.f5919c) : 0.0f;
        Drawable drawable = this.f5933q;
        if (drawable != null) {
            Drawable drawable2 = null;
            if (drawable instanceof LayerDrawable) {
                drawable2 = ((LayerDrawable) drawable).findDrawableByLayerId(i);
            }
            int i3 = (int) (10000.0f * f);
            if (drawable2 != null) {
                drawable = drawable2;
            }
            drawable.setLevel(i3);
        } else {
            invalidate();
        }
        if (z2 && i == 16908301) {
            mo16012a(f, z);
        }
    }

    /* renamed from: a */
    private synchronized void m5987a(int i, int i2, boolean z) {
        C1491a aVar;
        if (this.f5937u == Thread.currentThread().getId()) {
            m5988a(i, i2, z, true);
        } else {
            if (this.f5936t != null) {
                aVar = this.f5936t;
                this.f5936t = null;
                aVar.mo17136a(i, i2, z);
            } else {
                aVar = new C1491a(i, i2, z);
            }
            post(aVar);
        }
    }

    public synchronized void setProgress(int i) {
        mo17101a(i, false);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001f, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo17101a(int r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f5926j     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r2 >= 0) goto L_0x000a
            r2 = 0
        L_0x000a:
            int r0 = r1.f5919c     // Catch:{ all -> 0x0020 }
            if (r2 <= r0) goto L_0x0010
            int r2 = r1.f5919c     // Catch:{ all -> 0x0020 }
        L_0x0010:
            int r0 = r1.f5917a     // Catch:{ all -> 0x0020 }
            if (r2 == r0) goto L_0x001e
            r1.f5917a = r2     // Catch:{ all -> 0x0020 }
            r2 = 16908301(0x102000d, float:2.3877265E-38)
            int r0 = r1.f5917a     // Catch:{ all -> 0x0020 }
            r1.m5987a(r2, r0, r3)     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r1)
            return
        L_0x0020:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.ProgressBar.mo17101a(int, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0020, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setSecondaryProgress(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f5926j     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 0
            if (r3 >= 0) goto L_0x000b
            r3 = 0
        L_0x000b:
            int r1 = r2.f5919c     // Catch:{ all -> 0x0021 }
            if (r3 <= r1) goto L_0x0011
            int r3 = r2.f5919c     // Catch:{ all -> 0x0021 }
        L_0x0011:
            int r1 = r2.f5918b     // Catch:{ all -> 0x0021 }
            if (r3 == r1) goto L_0x001f
            r2.f5918b = r3     // Catch:{ all -> 0x0021 }
            r3 = 16908303(0x102000f, float:2.387727E-38)
            int r1 = r2.f5918b     // Catch:{ all -> 0x0021 }
            r2.m5987a(r3, r1, r0)     // Catch:{ all -> 0x0021 }
        L_0x001f:
            monitor-exit(r2)
            return
        L_0x0021:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.widget.ProgressBar.setSecondaryProgress(int):void");
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getProgress() {
        return this.f5926j ? 0 : this.f5917a;
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getSecondaryProgress() {
        return this.f5926j ? 0 : this.f5918b;
    }

    @ViewDebug.ExportedProperty(category = "progress")
    public synchronized int getMax() {
        return this.f5919c;
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i != this.f5919c) {
            this.f5919c = i;
            postInvalidate();
            if (this.f5917a > i) {
                this.f5917a = i;
            }
            m5987a(16908301, this.f5917a, false);
        }
    }

    /* renamed from: a */
    public final synchronized void mo17100a(int i) {
        setProgress(this.f5917a + i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo17102e() {
        if (getVisibility() == 0) {
            if (this.f5931o instanceof Animatable) {
                this.f5938v = true;
                this.f5929m = null;
            } else {
                if (this.f5935s == null) {
                    this.f5935s = new LinearInterpolator();
                }
                this.f5928l = new Transformation();
                this.f5929m = new AlphaAnimation(0.0f, 1.0f);
                this.f5929m.setRepeatMode(this.f5920d);
                this.f5929m.setRepeatCount(-1);
                this.f5929m.setDuration((long) this.f5925i);
                this.f5929m.setInterpolator(this.f5935s);
                this.f5929m.setStartTime(-1);
            }
            postInvalidate();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo17103f() {
        this.f5929m = null;
        this.f5928l = null;
        if (this.f5931o instanceof Animatable) {
            ((Animatable) this.f5931o).stop();
            this.f5938v = false;
        }
        postInvalidate();
    }

    public void setInterpolator(Context context, int i) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i));
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f5935s = interpolator;
    }

    public Interpolator getInterpolator() {
        return this.f5935s;
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (!this.f5926j) {
                return;
            }
            if (i == 8 || i == 4) {
                mo17103f();
            } else {
                mo17102e();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (!this.f5926j) {
            return;
        }
        if (i == 8 || i == 4) {
            mo17103f();
        } else {
            mo17102e();
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.f5939w) {
            return;
        }
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX() + getPaddingLeft();
            int scrollY = getScrollY() + getPaddingTop();
            invalidate(bounds.left + scrollX, bounds.top + scrollY, bounds.right + scrollX, bounds.bottom + scrollY);
            return;
        }
        super.invalidateDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        m5986a(i, i2);
    }

    /* renamed from: a */
    private void m5986a(int i, int i2) {
        int i3;
        int i4;
        int paddingRight = (i - getPaddingRight()) - getPaddingLeft();
        int paddingBottom = (i2 - getPaddingBottom()) - getPaddingTop();
        if (this.f5931o != null) {
            if (this.f5927k && !(this.f5931o instanceof AnimationDrawable)) {
                float intrinsicWidth = ((float) this.f5931o.getIntrinsicWidth()) / ((float) this.f5931o.getIntrinsicHeight());
                float f = (float) i;
                float f2 = (float) i2;
                float f3 = f / f2;
                if (intrinsicWidth != f3) {
                    if (f3 > intrinsicWidth) {
                        int i5 = (int) (f2 * intrinsicWidth);
                        i4 = (i - i5) / 2;
                        paddingRight = i5 + i4;
                        i3 = 0;
                        this.f5931o.setBounds(i4, i3, paddingRight, paddingBottom);
                    } else {
                        int i6 = (int) (f * (1.0f / intrinsicWidth));
                        i3 = (i2 - i6) / 2;
                        paddingBottom = i6 + i3;
                        i4 = 0;
                        this.f5931o.setBounds(i4, i3, paddingRight, paddingBottom);
                    }
                }
            }
            i4 = 0;
            i3 = 0;
            this.f5931o.setBounds(i4, i3, paddingRight, paddingBottom);
        }
        if (this.f5932p != null) {
            this.f5932p.setBounds(0, 0, paddingRight, paddingBottom);
        }
    }

    public void setBreakPoint(int i) {
        this.f5941y = i;
        invalidate();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        int i;
        Rect rect;
        Rect rect2;
        super.onDraw(canvas);
        Drawable drawable = this.f5933q;
        if (drawable != null) {
            if (this.f5942z) {
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                i = (getWidth() - getPaddingLeft()) - getPaddingRight();
            }
            int max = (this.f5941y * i) / getMax();
            if (this.f5942z) {
                int i2 = i - max;
                rect2 = new Rect(0, 0, getWidth(), i2);
                rect = new Rect(0, i2 + 5, getWidth(), i);
            } else {
                rect2 = new Rect(0, 0, max, getHeight());
                rect = new Rect(max + 5, 0, i, getHeight());
            }
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            long drawingTime = getDrawingTime();
            if (this.f5930n) {
                this.f5929m.getTransformation(drawingTime, this.f5928l);
                float alpha = this.f5928l.getAlpha();
                try {
                    this.f5939w = true;
                    drawable.setLevel((int) (alpha * 10000.0f));
                    this.f5939w = false;
                    postInvalidate();
                } catch (Throwable th) {
                    this.f5939w = false;
                    throw th;
                }
            }
            if (this.f5941y == getMax() || this.f5941y == 0) {
                drawable.draw(canvas);
                canvas.restore();
            } else {
                canvas.clipRect(rect2);
                drawable.draw(canvas);
                canvas.restore();
                canvas.save();
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
                canvas.clipRect(rect);
                drawable.draw(canvas);
                canvas.restore();
            }
            if (this.f5938v && (drawable instanceof Animatable)) {
                ((Animatable) drawable).start();
                this.f5938v = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Drawable drawable = this.f5933q;
        if (drawable != null) {
            i3 = Math.max(this.f5921e, Math.min(this.f5922f, drawable.getIntrinsicWidth()));
            i4 = Math.max(this.f5923g, Math.min(this.f5924h, drawable.getIntrinsicHeight()));
        } else {
            i4 = 0;
            i3 = 0;
        }
        mo16014b();
        setMeasuredDimension(resolveSizeAndState(i3 + getPaddingLeft() + getPaddingRight(), i, 0), resolveSizeAndState(i4 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        mo16014b();
    }

    /* renamed from: b */
    private void mo16014b() {
        int[] drawableState = getDrawableState();
        if (this.f5932p != null && this.f5932p.isStateful()) {
            this.f5932p.setState(drawableState);
        }
        if (this.f5931o != null && this.f5931o.isStateful()) {
            this.f5931o.setState(drawableState);
        }
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
        int f5943a;

        /* renamed from: b */
        int f5944b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f5943a = parcel.readInt();
            this.f5944b = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5943a);
            parcel.writeInt(this.f5944b);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5943a = this.f5917a;
        savedState.f5944b = this.f5918b;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.f5943a);
        setSecondaryProgress(savedState.f5944b);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5926j) {
            mo17102e();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.f5926j) {
            mo17103f();
        }
        if (this.f5936t != null) {
            removeCallbacks(this.f5936t);
        }
        if (this.f5936t != null && this.f5940x) {
            removeCallbacks(this.f5936t);
        }
        super.onDetachedFromWindow();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ProgressBar.class.getName());
        accessibilityEvent.setItemCount(this.f5919c);
        accessibilityEvent.setCurrentItemIndex(this.f5917a);
    }

    public void setProgressDrawableResource(int i) {
        Drawable progressDrawable = getProgressDrawable();
        Drawable drawable = getContext().getResources().getDrawable(i);
        drawable.setBounds(progressDrawable.copyBounds());
        setProgressDrawable(drawable);
        if (this.f5917a > 0) {
            mo17100a(-1);
            mo17100a(1);
        }
    }

    /* access modifiers changed from: protected */
    public void setIsVertical(boolean z) {
        this.f5942z = z;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ProgressBar.class.getName());
    }
}
