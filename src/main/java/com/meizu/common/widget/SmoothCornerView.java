package com.meizu.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.meizu.common.R;
import com.meizu.common.util.SmoothCornerPathGenerator;
import java.util.HashMap;
import java.util.Map;

public class SmoothCornerView extends FrameLayout {

    /* renamed from: a */
    private int f6115a;

    /* renamed from: b */
    private Paint f6116b;

    /* renamed from: c */
    private Bitmap f6117c;

    /* renamed from: d */
    private String f6118d;

    /* renamed from: a */
    private int m6121a(int i) {
        return i * 2;
    }

    public SmoothCornerView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public SmoothCornerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmoothCornerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6117c = null;
        this.f6118d = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmoothCornerView, i, 0);
        this.f6115a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SmoothCornerView_mzCornerRadius, 12);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        this.f6116b = new Paint(1);
        this.f6116b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (m6122a(getWidth(), getHeight(), m6121a(this.f6115a)) != null) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), (Paint) null, 31);
            super.dispatchDraw(canvas);
            canvas.save();
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.drawBitmap(this.f6117c, -1.0f, -1.0f, this.f6116b);
            canvas.restore();
            canvas.restoreToCount(saveLayer);
            return;
        }
        super.dispatchDraw(canvas);
    }

    /* renamed from: a */
    private Bitmap m6122a(int i, int i2, int i3) {
        String b = m6123b(i, i2, i3);
        if (this.f6117c != null && b.equals(this.f6118d)) {
            return this.f6117c;
        }
        C1519a a = C1519a.m6124a();
        Bitmap a2 = a.mo17313a(b);
        if (a2 != null) {
            this.f6117c = a2;
            this.f6118d = b;
            return this.f6117c;
        }
        Path path = new Path();
        if (!SmoothCornerPathGenerator.m5169a(path, i3, 4.0f, 0, 0, i, i2)) {
            this.f6117c = null;
            return null;
        }
        this.f6117c = Bitmap.createBitmap(i + 2, i2 + 2, Bitmap.Config.ALPHA_8);
        Canvas canvas = new Canvas(this.f6117c);
        Paint paint = new Paint(1);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.save();
        canvas.translate(1.0f, 1.0f);
        canvas.drawPath(path, paint);
        canvas.restore();
        this.f6118d = b;
        a.mo17314a(this.f6118d, this.f6117c);
        return this.f6117c;
    }

    @NonNull
    /* renamed from: b */
    private String m6123b(int i, int i2, int i3) {
        return "width=" + i + ",height=" + i2 + ",radius=" + i3;
    }

    public void setCornerRadius(int i) {
        this.f6115a = i;
        invalidate();
    }

    /* renamed from: com.meizu.common.widget.SmoothCornerView$a */
    private static class C1519a {

        /* renamed from: d */
        private static volatile C1519a f6119d;
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Map<String, Bitmap> f6120a = new HashMap();

        /* renamed from: b */
        private final Handler f6121b = new Handler(Looper.getMainLooper());

        /* renamed from: c */
        private final Runnable f6122c = new Runnable() {
            public void run() {
                Log.v("SmoothCornerView", "clear cache success.");
                C1519a.this.f6120a.clear();
            }
        };

        private C1519a() {
        }

        /* renamed from: a */
        static C1519a m6124a() {
            if (f6119d == null) {
                synchronized (C1519a.class) {
                    if (f6119d == null) {
                        f6119d = new C1519a();
                    }
                }
            }
            return f6119d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo17314a(String str, Bitmap bitmap) {
            this.f6120a.put(str, bitmap);
            this.f6121b.removeCallbacksAndMessages((Object) null);
            this.f6121b.postDelayed(this.f6122c, 3000);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Bitmap mo17313a(String str) {
            Bitmap bitmap = this.f6120a.get(str);
            if (bitmap != null) {
                Log.v("SmoothCornerView", "hit cache success");
            }
            return bitmap;
        }
    }
}
