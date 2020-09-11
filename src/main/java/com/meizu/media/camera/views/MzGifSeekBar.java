package com.meizu.media.camera.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.meizu.media.camera.R;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

public class MzGifSeekBar extends View {

    /* renamed from: a */
    public static ChangeQuickRedirect f14818a;

    /* renamed from: b */
    private static final LogUtil.C2630a f14819b = new LogUtil.C2630a("GifSeekBar");

    /* renamed from: g */
    private static int f14820g = 5;

    /* renamed from: c */
    private int f14821c;

    /* renamed from: d */
    private int f14822d;

    /* renamed from: e */
    private int f14823e;

    /* renamed from: f */
    private C2712a f14824f;

    /* renamed from: h */
    private Drawable f14825h;

    /* renamed from: i */
    private Drawable f14826i;

    /* renamed from: j */
    private boolean f14827j;

    /* renamed from: k */
    private boolean f14828k;

    /* renamed from: l */
    private int f14829l;

    /* renamed from: m */
    private int f14830m;

    /* renamed from: n */
    private boolean f14831n;

    /* renamed from: o */
    private Paint f14832o;

    /* renamed from: p */
    private int f14833p;

    /* renamed from: q */
    private int f14834q;

    /* renamed from: r */
    private int f14835r;

    /* renamed from: s */
    private float f14836s;

    /* renamed from: t */
    private float f14837t;

    /* renamed from: u */
    private long f14838u;

    /* renamed from: v */
    private long f14839v;

    /* renamed from: w */
    private boolean f14840w;

    /* renamed from: com.meizu.media.camera.views.MzGifSeekBar$a */
    public interface C2712a {
        /* renamed from: a */
        void mo20150a(MzGifSeekBar mzGifSeekBar, int i);

        /* renamed from: b */
        void mo20152b(MzGifSeekBar mzGifSeekBar, int i);
    }

    public MzGifSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public MzGifSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14829l = 0;
        this.f14830m = 0;
        this.f14839v = -1;
        this.f14840w = false;
        setHeadThumb(context.getResources().getDrawable(R.drawable.mz_gif_thumb));
        setTailThumb(context.getResources().getDrawable(R.drawable.mz_gif_thumb));
        this.f14832o = new Paint();
        this.f14834q = getResources().getColor(R.color.mz_gif_seekbar_active_color);
        this.f14835r = getResources().getColor(R.color.mz_gif_seekbar_inactive_color);
        this.f14833p = getResources().getColor(R.color.mz_gif_seekbar_play_color);
        this.f14832o.setColor(this.f14834q);
        this.f14832o.setStrokeWidth(getResources().getDimension(R.dimen.mz_gif_seekbar_thick));
    }

    public void setProgressChangeListener(C2712a aVar) {
        this.f14824f = aVar;
    }

    public void setItemsCount(int i) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i)}, this, f14818a, false, 8589, new Class[]{Integer.TYPE}, Void.TYPE).isSupported) {
            if (i < 1) {
                LogUtil.C2630a aVar = f14819b;
                LogUtil.m15949b(aVar, "count = " + i);
                setMaxProgress(0);
                return;
            }
            int i2 = i - 1;
            setMaxProgress(i2);
            m16513a(i2);
        }
    }

    /* renamed from: a */
    private void m16513a(int i) {
        int width;
        Object[] objArr = {new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f14818a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8590, new Class[]{Integer.TYPE}, Void.TYPE).isSupported && (width = (getWidth() - getPaddingLeft()) - getPaddingRight()) != 0) {
            f14820g = ((int) (((float) (this.f14829l * 2)) / (((float) width) / ((float) i)))) + 1;
        }
    }

    private void setHeadThumb(Drawable drawable) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{drawable}, this, f14818a, false, 8591, new Class[]{Drawable.class}, Void.TYPE).isSupported) {
            if (drawable == null) {
                drawable = getResources().getDrawable(R.drawable.mz_gif_thumb);
            }
            if (this.f14825h == null || drawable == this.f14825h) {
                z = false;
            } else {
                this.f14825h.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable.setCallback(this);
                if (z && !(drawable.getIntrinsicWidth() == this.f14825h.getIntrinsicWidth() && drawable.getIntrinsicHeight() == this.f14825h.getIntrinsicHeight())) {
                    requestLayout();
                }
                this.f14829l = drawable.getIntrinsicWidth() / 2;
                this.f14830m = drawable.getIntrinsicHeight() / 2;
            }
            this.f14825h = drawable;
            invalidate();
            if (z) {
                m16514a(getWidth(), getHeight());
                if (drawable != null && drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
            }
        }
    }

    private void setTailThumb(Drawable drawable) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{drawable}, this, f14818a, false, 8592, new Class[]{Drawable.class}, Void.TYPE).isSupported) {
            if (drawable == null) {
                drawable = getResources().getDrawable(R.drawable.mz_gif_thumb);
            }
            if (this.f14826i == null || drawable == this.f14826i) {
                z = false;
            } else {
                this.f14826i.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable.setCallback(this);
                if (z && !(drawable.getIntrinsicWidth() == this.f14826i.getIntrinsicWidth() && drawable.getIntrinsicHeight() == this.f14826i.getIntrinsicHeight())) {
                    requestLayout();
                }
                if (this.f14829l == 0 || this.f14830m == 0) {
                    this.f14829l = drawable.getIntrinsicWidth() / 2;
                    this.f14830m = drawable.getIntrinsicHeight() / 2;
                }
            }
            this.f14826i = drawable;
            invalidate();
            if (z) {
                m16514a(getWidth(), getHeight());
                if (drawable != null && drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0078, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo23064a(int r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0079 }
            java.lang.Integer r2 = new java.lang.Integer     // Catch:{ all -> 0x0079 }
            r2.<init>(r10)     // Catch:{ all -> 0x0079 }
            r8 = 0
            r1[r8] = r2     // Catch:{ all -> 0x0079 }
            java.lang.Byte r2 = new java.lang.Byte     // Catch:{ all -> 0x0079 }
            r2.<init>(r11)     // Catch:{ all -> 0x0079 }
            r3 = 1
            r1[r3] = r2     // Catch:{ all -> 0x0079 }
            com.meizu.savior.ChangeQuickRedirect r4 = f14818a     // Catch:{ all -> 0x0079 }
            r5 = 0
            r6 = 8593(0x2191, float:1.2041E-41)
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x0079 }
            java.lang.Class r2 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0079 }
            r0[r8] = r2     // Catch:{ all -> 0x0079 }
            java.lang.Class r2 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0079 }
            r0[r3] = r2     // Catch:{ all -> 0x0079 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0079 }
            r2 = r9
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0079 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0034
            monitor-exit(r9)
            return
        L_0x0034:
            if (r10 >= 0) goto L_0x0037
            r10 = 0
        L_0x0037:
            int r0 = r9.f14821c     // Catch:{ all -> 0x0079 }
            if (r10 <= r0) goto L_0x003d
            int r10 = r9.f14821c     // Catch:{ all -> 0x0079 }
        L_0x003d:
            int r0 = r9.f14823e     // Catch:{ all -> 0x0079 }
            int r1 = f14820g     // Catch:{ all -> 0x0079 }
            int r0 = r0 - r1
            if (r10 <= r0) goto L_0x0049
            int r10 = r9.f14823e     // Catch:{ all -> 0x0079 }
            int r0 = f14820g     // Catch:{ all -> 0x0079 }
            int r10 = r10 - r0
        L_0x0049:
            int r0 = r9.f14822d     // Catch:{ all -> 0x0079 }
            if (r10 != r0) goto L_0x0051
            boolean r0 = r9.f14831n     // Catch:{ all -> 0x0079 }
            if (r0 != 0) goto L_0x0077
        L_0x0051:
            r9.f14822d = r10     // Catch:{ all -> 0x0079 }
            if (r11 != 0) goto L_0x0066
            int r10 = r9.f14821c     // Catch:{ all -> 0x0079 }
            if (r10 <= 0) goto L_0x0061
            int r10 = r9.f14822d     // Catch:{ all -> 0x0079 }
            float r10 = (float) r10     // Catch:{ all -> 0x0079 }
            int r11 = r9.f14821c     // Catch:{ all -> 0x0079 }
            float r11 = (float) r11     // Catch:{ all -> 0x0079 }
            float r10 = r10 / r11
            goto L_0x0062
        L_0x0061:
            r10 = 0
        L_0x0062:
            r9.m16512a((float) r10)     // Catch:{ all -> 0x0079 }
            goto L_0x0077
        L_0x0066:
            com.meizu.media.camera.views.MzGifSeekBar$a r10 = r9.f14824f     // Catch:{ all -> 0x0079 }
            if (r10 == 0) goto L_0x0077
            boolean r10 = r9.f14827j     // Catch:{ all -> 0x0079 }
            if (r10 == 0) goto L_0x0077
            com.meizu.media.camera.views.MzGifSeekBar$a r10 = r9.f14824f     // Catch:{ all -> 0x0079 }
            int r11 = r9.getHeadProgress()     // Catch:{ all -> 0x0079 }
            r10.mo20150a(r9, r11)     // Catch:{ all -> 0x0079 }
        L_0x0077:
            monitor-exit(r9)
            return
        L_0x0079:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.views.MzGifSeekBar.mo23064a(int, boolean):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0078, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo23068b(int r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0079 }
            java.lang.Integer r2 = new java.lang.Integer     // Catch:{ all -> 0x0079 }
            r2.<init>(r10)     // Catch:{ all -> 0x0079 }
            r8 = 0
            r1[r8] = r2     // Catch:{ all -> 0x0079 }
            java.lang.Byte r2 = new java.lang.Byte     // Catch:{ all -> 0x0079 }
            r2.<init>(r11)     // Catch:{ all -> 0x0079 }
            r3 = 1
            r1[r3] = r2     // Catch:{ all -> 0x0079 }
            com.meizu.savior.ChangeQuickRedirect r4 = f14818a     // Catch:{ all -> 0x0079 }
            r5 = 0
            r6 = 8594(0x2192, float:1.2043E-41)
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x0079 }
            java.lang.Class r2 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0079 }
            r0[r8] = r2     // Catch:{ all -> 0x0079 }
            java.lang.Class r2 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0079 }
            r0[r3] = r2     // Catch:{ all -> 0x0079 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0079 }
            r2 = r9
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0079 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0034
            monitor-exit(r9)
            return
        L_0x0034:
            if (r10 >= 0) goto L_0x0037
            r10 = 0
        L_0x0037:
            int r0 = r9.f14821c     // Catch:{ all -> 0x0079 }
            if (r10 <= r0) goto L_0x003d
            int r10 = r9.f14821c     // Catch:{ all -> 0x0079 }
        L_0x003d:
            int r0 = r9.f14822d     // Catch:{ all -> 0x0079 }
            int r1 = f14820g     // Catch:{ all -> 0x0079 }
            int r0 = r0 + r1
            if (r10 >= r0) goto L_0x0049
            int r10 = r9.f14822d     // Catch:{ all -> 0x0079 }
            int r0 = f14820g     // Catch:{ all -> 0x0079 }
            int r10 = r10 + r0
        L_0x0049:
            int r0 = r9.f14823e     // Catch:{ all -> 0x0079 }
            if (r10 != r0) goto L_0x0051
            boolean r0 = r9.f14831n     // Catch:{ all -> 0x0079 }
            if (r0 != 0) goto L_0x0077
        L_0x0051:
            r9.f14823e = r10     // Catch:{ all -> 0x0079 }
            if (r11 != 0) goto L_0x0066
            int r10 = r9.f14823e     // Catch:{ all -> 0x0079 }
            if (r10 <= 0) goto L_0x0061
            int r10 = r9.f14823e     // Catch:{ all -> 0x0079 }
            float r10 = (float) r10     // Catch:{ all -> 0x0079 }
            int r11 = r9.f14821c     // Catch:{ all -> 0x0079 }
            float r11 = (float) r11     // Catch:{ all -> 0x0079 }
            float r10 = r10 / r11
            goto L_0x0062
        L_0x0061:
            r10 = 0
        L_0x0062:
            r9.m16518b((float) r10)     // Catch:{ all -> 0x0079 }
            goto L_0x0077
        L_0x0066:
            com.meizu.media.camera.views.MzGifSeekBar$a r10 = r9.f14824f     // Catch:{ all -> 0x0079 }
            if (r10 == 0) goto L_0x0077
            boolean r10 = r9.f14828k     // Catch:{ all -> 0x0079 }
            if (r10 == 0) goto L_0x0077
            com.meizu.media.camera.views.MzGifSeekBar$a r10 = r9.f14824f     // Catch:{ all -> 0x0079 }
            int r11 = r9.getTailProgress()     // Catch:{ all -> 0x0079 }
            r10.mo20152b(r9, r11)     // Catch:{ all -> 0x0079 }
        L_0x0077:
            monitor-exit(r9)
            return
        L_0x0079:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.views.MzGifSeekBar.mo23068b(int, boolean):void");
    }

    public synchronized int getHeadProgress() {
        return this.f14822d;
    }

    public synchronized int getTailProgress() {
        return this.f14823e;
    }

    private synchronized int getMaxProgress() {
        return this.f14821c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void setMaxProgress(int r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0057 }
            java.lang.Integer r2 = new java.lang.Integer     // Catch:{ all -> 0x0057 }
            r2.<init>(r10)     // Catch:{ all -> 0x0057 }
            r8 = 0
            r1[r8] = r2     // Catch:{ all -> 0x0057 }
            com.meizu.savior.ChangeQuickRedirect r3 = f14818a     // Catch:{ all -> 0x0057 }
            r4 = 0
            r5 = 8595(0x2193, float:1.2044E-41)
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0057 }
            java.lang.Class r0 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0057 }
            r6[r8] = r0     // Catch:{ all -> 0x0057 }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ all -> 0x0057 }
            r2 = r9
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0057 }
            boolean r0 = r0.isSupported     // Catch:{ all -> 0x0057 }
            if (r0 == 0) goto L_0x0024
            monitor-exit(r9)
            return
        L_0x0024:
            if (r10 >= 0) goto L_0x0027
            r10 = 0
        L_0x0027:
            int r0 = r9.f14821c     // Catch:{ all -> 0x0057 }
            if (r10 == r0) goto L_0x0055
            r9.f14821c = r10     // Catch:{ all -> 0x0057 }
            int r0 = r9.f14822d     // Catch:{ all -> 0x0057 }
            if (r0 <= r10) goto L_0x0033
            r9.f14822d = r10     // Catch:{ all -> 0x0057 }
        L_0x0033:
            int r0 = r9.f14821c     // Catch:{ all -> 0x0057 }
            r1 = 0
            if (r0 <= 0) goto L_0x0040
            int r0 = r9.f14822d     // Catch:{ all -> 0x0057 }
            float r0 = (float) r0     // Catch:{ all -> 0x0057 }
            int r2 = r9.f14821c     // Catch:{ all -> 0x0057 }
            float r2 = (float) r2     // Catch:{ all -> 0x0057 }
            float r0 = r0 / r2
            goto L_0x0041
        L_0x0040:
            r0 = 0
        L_0x0041:
            r9.m16512a((float) r0)     // Catch:{ all -> 0x0057 }
            r9.f14823e = r10     // Catch:{ all -> 0x0057 }
            int r10 = r9.f14821c     // Catch:{ all -> 0x0057 }
            if (r10 <= 0) goto L_0x0052
            int r10 = r9.f14823e     // Catch:{ all -> 0x0057 }
            float r10 = (float) r10     // Catch:{ all -> 0x0057 }
            int r0 = r9.f14821c     // Catch:{ all -> 0x0057 }
            float r0 = (float) r0     // Catch:{ all -> 0x0057 }
            float r1 = r10 / r0
        L_0x0052:
            r9.m16518b((float) r1)     // Catch:{ all -> 0x0057 }
        L_0x0055:
            monitor-exit(r9)
            return
        L_0x0057:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.views.MzGifSeekBar.setMaxProgress(int):void");
    }

    /* renamed from: a */
    private void m16512a(float f) {
        Drawable drawable;
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f14818a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8596, new Class[]{Float.TYPE}, Void.TYPE).isSupported && (drawable = this.f14825h) != null) {
            m16515a(getWidth(), drawable, f, Integer.MIN_VALUE);
        }
    }

    /* renamed from: b */
    private void m16518b(float f) {
        Drawable drawable;
        Object[] objArr = {new Float(f)};
        ChangeQuickRedirect changeQuickRedirect = f14818a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8597, new Class[]{Float.TYPE}, Void.TYPE).isSupported && (drawable = this.f14826i) != null) {
            m16520b(getWidth(), drawable, f, Integer.MIN_VALUE);
        }
    }

    public void drawableStateChanged() {
        if (!PatchProxy.proxy(new Object[0], this, f14818a, false, 8598, new Class[0], Void.TYPE).isSupported) {
            super.drawableStateChanged();
            if (this.f14825h != null && this.f14825h.isStateful()) {
                this.f14825h.setState(getDrawableState());
            }
            if (this.f14826i != null && this.f14826i.isStateful()) {
                this.f14826i.setState(getDrawableState());
            }
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Object[] objArr = {new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4)};
        ChangeQuickRedirect changeQuickRedirect = f14818a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8599, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            m16514a(i, i2);
            m16519b(i, i2);
        }
    }

    /* renamed from: a */
    private void m16514a(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f14818a, false, 8600, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            Drawable drawable = this.f14825h;
            int maxProgress = getMaxProgress();
            float headProgress = maxProgress > 0 ? ((float) getHeadProgress()) / ((float) maxProgress) : 0.0f;
            if (drawable != null) {
                m16515a(i, drawable, headProgress, 0);
            }
        }
    }

    /* renamed from: b */
    private void m16519b(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f14818a, false, 8601, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            Drawable drawable = this.f14826i;
            int maxProgress = getMaxProgress();
            float tailProgress = maxProgress > 0 ? ((float) getTailProgress()) / ((float) maxProgress) : 0.0f;
            if (drawable != null) {
                m16520b(i, drawable, tailProgress, 0);
            }
        }
    }

    /* renamed from: a */
    private void m16515a(int i, Drawable drawable, float f, int i2) {
        int i3;
        Object[] objArr = {new Integer(i), drawable, new Float(f), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14818a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8602, new Class[]{Integer.TYPE, Drawable.class, Float.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int i4 = paddingLeft - intrinsicWidth;
            int round = i4 - Math.round((1.0f - f) * ((float) i4));
            if (i2 == Integer.MIN_VALUE) {
                Rect bounds = drawable.getBounds();
                i2 = bounds.top;
                i3 = bounds.bottom;
            } else {
                i3 = drawable.getIntrinsicHeight() + i2;
            }
            this.f14825h.setBounds(round, i2, intrinsicWidth + round, i3);
            invalidate();
            this.f14831n = true;
        }
    }

    /* renamed from: b */
    private void m16520b(int i, Drawable drawable, float f, int i2) {
        int i3;
        Object[] objArr = {new Integer(i), drawable, new Float(f), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14818a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8603, new Class[]{Integer.TYPE, Drawable.class, Float.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int i4 = paddingLeft - intrinsicWidth;
            int round = i4 - Math.round((1.0f - f) * ((float) i4));
            if (i2 == Integer.MIN_VALUE) {
                Rect bounds = drawable.getBounds();
                i2 = bounds.top;
                i3 = bounds.bottom;
            } else {
                i3 = drawable.getIntrinsicHeight() + i2;
            }
            this.f14826i.setBounds(round, i2, intrinsicWidth + round, i3);
            invalidate();
            this.f14831n = true;
        }
    }

    public synchronized void onDraw(Canvas canvas) {
        if (!PatchProxy.proxy(new Object[]{canvas}, this, f14818a, false, 8604, new Class[]{Canvas.class}, Void.TYPE).isSupported) {
            super.onDraw(canvas);
            if (this.f14825h != null) {
                if (this.f14826i != null) {
                    canvas.save();
                    canvas.translate((float) (getPaddingLeft() + this.f14829l), (float) (getPaddingTop() + this.f14830m));
                    float width = (float) (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.f14829l * 2));
                    float headProgress = (((float) getHeadProgress()) / ((float) getMaxProgress())) * width;
                    float tailProgress = (((float) getTailProgress()) / ((float) getMaxProgress())) * width;
                    this.f14832o.setColor(this.f14834q);
                    this.f14832o.setAntiAlias(true);
                    canvas.drawLine(headProgress, 0.0f, tailProgress, 0.0f, this.f14832o);
                    this.f14832o.setColor(this.f14835r);
                    canvas.drawLine(0.0f, 0.0f, headProgress, 0.0f, this.f14832o);
                    canvas.drawLine(tailProgress, 0.0f, width, 0.0f, this.f14832o);
                    if (this.f14840w) {
                        m16521b(System.currentTimeMillis());
                        this.f14832o.setColor(this.f14833p);
                        canvas.drawLine(headProgress, 0.0f, headProgress + this.f14836s, 0.0f, this.f14832o);
                        canvas.restore();
                        return;
                    }
                    canvas.restore();
                    canvas.save();
                    canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
                    this.f14825h.draw(canvas);
                    this.f14826i.draw(canvas);
                    canvas.restore();
                    return;
                }
            }
            LogUtil.m15949b(f14819b, "head thumb or tail thumb not set...");
        }
    }

    public synchronized void onMeasure(int i, int i2) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f14818a, false, 8605, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            int intrinsicHeight = this.f14825h == null ? 0 : this.f14825h.getIntrinsicHeight();
            int i3 = 26;
            int paddingLeft = getPaddingLeft() + 64 + getPaddingRight();
            if (intrinsicHeight != 0) {
                i3 = Math.max(intrinsicHeight, 26);
            }
            setMeasuredDimension(resolveSizeAndState(Math.max(paddingLeft, View.MeasureSpec.getSize(i)), i, 0), resolveSizeAndState(i3 + getPaddingTop() + getPaddingBottom(), i2, 0));
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{motionEvent}, this, f14818a, false, 8606, new Class[]{MotionEvent.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!isEnabled() || getMaxProgress() == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (m16523c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    setPressed(true);
                    if (this.f14825h != null) {
                        invalidate(this.f14825h.getBounds());
                    }
                    mo23066a(true);
                } else if (m16525d((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    setPressed(true);
                    if (this.f14826i != null) {
                        invalidate(this.f14826i.getBounds());
                    }
                    mo23066a(false);
                }
                m16524d();
                break;
            case 1:
                if (!this.f14827j) {
                    if (this.f14828k) {
                        m16517a(motionEvent, false);
                        mo23063a();
                        setPressed(false);
                        break;
                    }
                } else {
                    m16517a(motionEvent, true);
                    mo23063a();
                    setPressed(false);
                    break;
                }
                break;
            case 2:
                if (!this.f14827j) {
                    if (this.f14828k) {
                        this.f14831n = false;
                        m16522b(motionEvent);
                        m16524d();
                        break;
                    }
                } else {
                    this.f14831n = false;
                    m16516a(motionEvent);
                    m16524d();
                    break;
                }
                break;
            case 3:
                if (this.f14827j || this.f14828k) {
                    mo23063a();
                    setPressed(false);
                }
                invalidate();
                break;
        }
        return true;
    }

    /* renamed from: c */
    private boolean m16523c(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14818a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 8607, new Class[]{Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f14825h.getBounds().contains(i, i2);
    }

    /* renamed from: d */
    private boolean m16525d(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect = f14818a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 8608, new Class[]{Integer.TYPE, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return this.f14826i.getBounds().contains(i, i2);
    }

    /* renamed from: a */
    private void m16516a(MotionEvent motionEvent) {
        int i = 0;
        if (!PatchProxy.proxy(new Object[]{motionEvent}, this, f14818a, false, 8609, new Class[]{MotionEvent.class}, Void.TYPE).isSupported) {
            float width = (float) (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.f14829l * 2));
            int i2 = (int) ((((float) (this.f14823e - f14820g)) / ((float) this.f14821c)) * width);
            int x = (int) motionEvent.getX();
            if (x >= getPaddingLeft()) {
                if (x > i2) {
                    i = i2;
                } else {
                    i = x - getPaddingLeft();
                }
            }
            mo23064a(Math.round(((motionEvent.getX() - ((float) getPaddingLeft())) / width) * ((float) getMaxProgress())), true);
            Rect bounds = this.f14825h.getBounds();
            this.f14825h.setBounds(i, bounds.top, this.f14825h.getIntrinsicWidth() + i, bounds.bottom);
            invalidate();
        }
    }

    /* renamed from: b */
    private void m16522b(MotionEvent motionEvent) {
        if (!PatchProxy.proxy(new Object[]{motionEvent}, this, f14818a, false, 8610, new Class[]{MotionEvent.class}, Void.TYPE).isSupported) {
            int width = getWidth();
            float paddingLeft = (float) (((width - getPaddingLeft()) - getPaddingRight()) - (this.f14829l * 2));
            int i = (int) ((((float) (this.f14822d + f14820g)) / ((float) this.f14821c)) * paddingLeft);
            int x = (int) motionEvent.getX();
            if (x >= i) {
                if (x > (width - getPaddingRight()) - (this.f14829l * 2)) {
                    i = (width - getPaddingRight()) - (this.f14829l * 2);
                } else {
                    i = x - getPaddingLeft();
                }
            }
            mo23068b(Math.round(((motionEvent.getX() - ((float) getPaddingLeft())) / paddingLeft) * ((float) getMaxProgress())), true);
            Rect bounds = this.f14826i.getBounds();
            this.f14826i.setBounds(i, bounds.top, this.f14826i.getIntrinsicWidth() + i, bounds.bottom);
            invalidate();
        }
    }

    /* renamed from: a */
    private void m16517a(MotionEvent motionEvent, boolean z) {
        float f;
        Object[] objArr = {motionEvent, new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f14818a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 8611, new Class[]{MotionEvent.class, Boolean.TYPE}, Void.TYPE).isSupported) {
            int width = getWidth();
            int paddingLeft = ((width - getPaddingLeft()) - getPaddingRight()) - (this.f14829l * 2);
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft()) {
                f = 0.0f;
            } else if (x > (width - getPaddingRight()) - this.f14829l) {
                f = 1.0f;
            } else {
                f = ((float) (x - getPaddingLeft())) / ((float) paddingLeft);
            }
            float maxProgress = 0.0f + (f * ((float) getMaxProgress()));
            if (z) {
                mo23064a(Math.round(maxProgress), false);
            } else {
                mo23068b(Math.round(maxProgress), false);
            }
        }
    }

    /* renamed from: d */
    private void m16524d() {
        if (!PatchProxy.proxy(new Object[0], this, f14818a, false, 8612, new Class[0], Void.TYPE).isSupported && getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo23066a(boolean z) {
        if (z) {
            this.f14827j = true;
        } else {
            this.f14828k = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo23063a() {
        this.f14827j = false;
        this.f14828k = false;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {

            /* renamed from: a */
            public static ChangeQuickRedirect f14844a;

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                PatchProxyResult proxy = PatchProxy.proxy(new Object[]{parcel}, this, f14844a, false, 8618, new Class[]{Parcel.class}, SavedState.class);
                return proxy.isSupported ? (SavedState) proxy.result : new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        public static ChangeQuickRedirect f14841a;

        /* renamed from: b */
        int f14842b;

        /* renamed from: c */
        int f14843c;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f14842b = parcel.readInt();
            this.f14843c = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (!PatchProxy.proxy(new Object[]{parcel, new Integer(i)}, this, f14841a, false, 8617, new Class[]{Parcel.class, Integer.TYPE}, Void.TYPE).isSupported) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f14842b);
                parcel.writeInt(this.f14843c);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f14818a, false, 8613, new Class[0], Parcelable.class);
        if (proxy.isSupported) {
            return (Parcelable) proxy.result;
        }
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f14842b = this.f14822d;
        savedState.f14843c = this.f14823e;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!PatchProxy.proxy(new Object[]{parcelable}, this, f14818a, false, 8614, new Class[]{Parcelable.class}, Void.TYPE).isSupported) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            mo23064a(savedState.f14842b, true);
            mo23068b(savedState.f14843c, true);
        }
    }

    /* renamed from: b */
    public void mo23067b() {
        if (!PatchProxy.proxy(new Object[0], this, f14818a, false, 8615, new Class[0], Void.TYPE).isSupported) {
            this.f14840w = true;
            this.f14838u = (long) ((this.f14823e - this.f14822d) * 100);
            float width = (float) (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.f14829l * 2));
            this.f14837t = ((((float) getTailProgress()) / ((float) getMaxProgress())) * width) - ((((float) getHeadProgress()) / ((float) getMaxProgress())) * width);
            invalidate();
        }
    }

    /* renamed from: c */
    public void mo23069c() {
        this.f14840w = false;
        this.f14839v = -1;
    }

    /* renamed from: a */
    public void mo23065a(long j) {
        this.f14838u += j;
    }

    /* renamed from: b */
    private void m16521b(long j) {
        boolean z = true;
        if (!PatchProxy.proxy(new Object[]{new Long(j)}, this, f14818a, false, 8616, new Class[]{Long.TYPE}, Void.TYPE).isSupported) {
            if (this.f14839v == -1) {
                this.f14839v = j;
            }
            float f = ((float) (j - this.f14839v)) / ((float) this.f14838u);
            if (f < 1.0f) {
                z = false;
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.f14836s = this.f14837t * f;
            }
            if (z) {
                this.f14836s = this.f14837t;
            }
            invalidate();
            if (z) {
                this.f14839v = -1;
                this.f14840w = false;
            }
        }
    }
}
