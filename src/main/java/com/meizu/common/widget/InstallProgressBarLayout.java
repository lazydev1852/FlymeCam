package com.meizu.common.widget;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.meizu.common.R;
import java.text.NumberFormat;

public class InstallProgressBarLayout extends LinearLayout {

    /* renamed from: A */
    private final String f5476A = "canvasScale";

    /* renamed from: B */
    private final long f5477B = 128;

    /* renamed from: C */
    private final long f5478C = 352;

    /* renamed from: D */
    private TimeInterpolator f5479D;

    /* renamed from: E */
    private boolean f5480E = false;

    /* renamed from: a */
    private InstallProgressBar f5481a;

    /* renamed from: b */
    private InstallProgressBarText f5482b;

    /* renamed from: c */
    private TextView f5483c;

    /* renamed from: d */
    private boolean f5484d = false;

    /* renamed from: e */
    private int f5485e;

    /* renamed from: f */
    private String f5486f;

    /* renamed from: g */
    private String f5487g;

    /* renamed from: h */
    private int f5488h;

    /* renamed from: i */
    private int f5489i;

    /* renamed from: j */
    private int f5490j;

    /* renamed from: k */
    private float f5491k;

    /* renamed from: l */
    private int f5492l;

    /* renamed from: m */
    private Drawable f5493m;

    /* renamed from: n */
    private float f5494n = 1.0f;

    /* renamed from: o */
    private int f5495o;

    /* renamed from: p */
    private int f5496p;

    /* renamed from: q */
    private float f5497q;

    /* renamed from: r */
    private float f5498r;

    /* renamed from: s */
    private float f5499s;

    /* renamed from: t */
    private final int f5500t = -7829368;

    /* renamed from: u */
    private float f5501u = 1.0f;

    /* renamed from: v */
    private float f5502v = 0.95f;

    /* renamed from: w */
    private long f5503w;

    /* renamed from: x */
    private long f5504x;

    /* renamed from: y */
    private ObjectAnimator f5505y;

    /* renamed from: z */
    private ObjectAnimator f5506z;

    public InstallProgressBarLayout(Context context) {
        super(context);
        m5829a(context, (AttributeSet) null);
    }

    public InstallProgressBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5829a(context, attributeSet);
    }

    public InstallProgressBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5829a(context, attributeSet);
    }

    /* renamed from: a */
    private void m5829a(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f5479D = new PathInterpolator(0.33f, 0.0f, 0.33f, 1.0f);
        } else {
            this.f5479D = new AccelerateDecelerateInterpolator();
        }
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.mc_install_progress_bar_layout, this);
        this.f5485e = getContext().getResources().getColor(R.color.white);
        this.f5499s = getResources().getDisplayMetrics().density;
        m5833b(context, attributeSet);
    }

    /* renamed from: b */
    private void m5833b(Context context, AttributeSet attributeSet) {
        TypedArray a = mo16814a(context, attributeSet, R.styleable.InstallProgressBarLayout);
        if (a != null) {
            this.f5481a = (InstallProgressBar) findViewById(R.id.round_corner_progress);
            this.f5481a.setRoundRadius(a.getDimension(R.styleable.InstallProgressBarLayout_mcBackRoundRadius, (float) R.dimen.default_round_radius));
            this.f5482b = (InstallProgressBarText) findViewById(R.id.round_corner_progress_text);
            this.f5483c = (TextView) findViewById(R.id.round_corner_promotion_status_price_text);
            this.f5484d = a.getBoolean(R.styleable.InstallProgressBarLayout_mcAutoTextChange, false);
            this.f5488h = (int) a.getDimension(R.styleable.InstallProgressBarLayout_mcTextProgressSize, (float) getResources().getDimensionPixelOffset(R.dimen.online_theme_download_install_font_size));
            this.f5482b.setTextSize(this.f5488h);
            this.f5485e = a.getColor(R.styleable.InstallProgressBarLayout_mcTextCoverProgressColor, this.f5485e);
            this.f5482b.setTextOriginColor(this.f5485e);
            this.f5482b.setTextChangeColor(this.f5485e);
            this.f5486f = a.getString(R.styleable.InstallProgressBarLayout_mcProgressText);
            this.f5486f = this.f5486f == null ? "" : this.f5486f;
            this.f5482b.setText(this.f5486f);
            this.f5489i = (int) a.getDimension(R.styleable.InstallProgressBarLayout_mcTextProgressPadding, 10.0f);
            this.f5482b.setPadding(0, 0, 0, this.f5489i);
            this.f5487g = a.getString(R.styleable.InstallProgressBarLayout_mcTextProgressUnit);
            this.f5487g = this.f5487g == null ? "" : this.f5487g;
            this.f5490j = a.getColor(R.styleable.InstallProgressBarLayout_mcProgressColor, getContext().getResources().getColor(R.color.progress_color_black));
            this.f5481a.setRoundBtnColor(this.f5490j);
            this.f5492l = a.getColor(R.styleable.InstallProgressBarLayout_mcProgressBackColor, getContext().getResources().getColor(R.color.progress_normal_color));
            this.f5481a.setProgressBackColor(this.f5492l);
            this.f5491k = a.getFloat(R.styleable.InstallProgressBarLayout_mcMinProgress, 0.0f);
            this.f5481a.setMinProgress((int) this.f5491k);
            a.recycle();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public TypedArray mo16814a(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (!isEnabled() || !isClickable()) {
            return false;
        }
        switch (action) {
            case 0:
                m5830a(motionEvent);
                break;
            case 1:
            case 3:
                m5834b(motionEvent);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.scale(this.f5494n, this.f5494n, this.f5497q, this.f5498r);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f5495o = i;
        this.f5496p = i2;
        this.f5497q = (float) (this.f5495o / 2);
        this.f5498r = (float) (this.f5496p / 2);
        if (this.f5493m != null) {
            this.f5493m.setColorFilter(-7829368, PorterDuff.Mode.SRC_IN);
            this.f5493m.setBounds(0, 0, this.f5495o, this.f5496p);
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).setClipChildren(false);
            }
        }
    }

    /* renamed from: a */
    private void m5828a(float f, boolean z, String str) {
        if (z) {
            this.f5481a.setAnimProgress(f);
        } else {
            this.f5481a.setProgress(f);
        }
        if (this.f5484d && str != null) {
            float f2 = f % 1.0f;
            String format = NumberFormat.getInstance().format(m5831a(f2, 0.0f) ? (double) f : (double) (f / 100.0f));
            InstallProgressBarText installProgressBarText = this.f5482b;
            installProgressBarText.setText(str + " " + format + this.f5487g);
            m5831a(f2, 0.0f);
            float f3 = f / 100.0f;
            if (z) {
                this.f5482b.setAnimProgress(f3);
            } else {
                this.f5482b.setProgress(f3);
            }
        }
    }

    /* renamed from: a */
    private static boolean m5831a(float f, float f2) {
        return Math.abs(f - f2) <= 1.0E-6f;
    }

    public void setTextUnit(String str) {
        this.f5487g = str;
    }

    public void setTextProgress(CharSequence charSequence) {
        this.f5482b.setText(charSequence.toString());
    }

    public InstallProgressBarText getProgressText() {
        return this.f5482b;
    }

    public void setPromotionTextViewValue(CharSequence charSequence) {
        this.f5483c.setText(charSequence);
    }

    public void setPromotionTextViewVisibility() {
        this.f5483c.setVisibility(8);
    }

    public void setProgress(float f, boolean z) {
        m5828a(f, z, getContext().getString(R.string.mc_downloading_prefix));
    }

    public void setDownloadPatchProgress(float f, boolean z) {
        m5828a(f, z, getContext().getString(R.string.mc_downloading_patch_prefix));
    }

    public void setUpdateIncrementalProgress(float f, boolean z) {
        m5828a(f, z, getContext().getString(R.string.mc_updating_prefix));
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        this.f5482b.setAlpha(z ? 1.0f : 0.5f);
        this.f5481a.setRoundBtnColor(z ? this.f5490j : getResources().getColor(R.color.progress_color_black));
    }

    public void setTextColor(int i) {
        this.f5482b.setTextOriginColor(i);
    }

    public void setAutoTextChange(boolean z) {
        this.f5484d = z;
    }

    public void setUniformColor(int i) {
        if (isClickable()) {
            this.f5490j = i;
            this.f5481a.setRoundBtnColor(i);
        }
    }

    /* renamed from: a */
    private void m5827a() {
        this.f5501u = this.f5502v;
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("canvasScale", new float[]{1.0f, this.f5501u});
        if (this.f5505y == null) {
            this.f5505y = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat});
            this.f5505y.setInterpolator(this.f5479D);
            this.f5505y.setDuration(128);
            return;
        }
        this.f5505y.setValues(new PropertyValuesHolder[]{ofFloat});
    }

    /* renamed from: b */
    private void m5832b() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("canvasScale", new float[]{this.f5501u, 1.0f});
        if (this.f5506z == null) {
            this.f5506z = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat});
            this.f5506z.setInterpolator(this.f5479D);
            this.f5506z.setDuration(352);
            return;
        }
        this.f5506z.setValues(new PropertyValuesHolder[]{ofFloat});
    }

    /* renamed from: a */
    private void m5830a(MotionEvent motionEvent) {
        this.f5503w = System.currentTimeMillis();
        if (!this.f5480E) {
            m5827a();
            this.f5505y.start();
        }
    }

    /* renamed from: b */
    private void m5834b(MotionEvent motionEvent) {
        if (!this.f5480E) {
            this.f5504x = System.currentTimeMillis();
            long j = this.f5504x - this.f5503w;
            m5832b();
            if (j < 128) {
                this.f5506z.setStartDelay(128 - j);
            } else {
                this.f5506z.setStartDelay(0);
            }
            this.f5506z.start();
        }
    }

    /* access modifiers changed from: protected */
    public float getCanvasScale() {
        return this.f5494n;
    }

    /* access modifiers changed from: protected */
    public void setCanvasScale(float f) {
        this.f5494n = f;
        invalidate();
    }
}
