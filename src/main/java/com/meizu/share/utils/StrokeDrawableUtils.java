package com.meizu.share.utils;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.PictureDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.LruCache;

/* renamed from: com.meizu.share.utils.g */
public class StrokeDrawableUtils {

    /* renamed from: a */
    private static final Object f15806a = new Object();

    /* renamed from: b */
    private static final Object f15807b = new Object();

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        r6 = r3.getHeight() + 2;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.drawable.Drawable m17210a(android.graphics.drawable.Drawable r15, int r16, int r17, android.content.res.Resources r18, java.lang.Boolean r19) {
        /*
            r0 = r16
            r1 = r17
            java.lang.Object r2 = f15806a
            monitor-enter(r2)
            android.graphics.Bitmap r3 = m17209a(r15)     // Catch:{ all -> 0x0094 }
            r4 = 0
            if (r3 == 0) goto L_0x008e
            r5 = 1
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createScaledBitmap(r3, r0, r1, r5)     // Catch:{ all -> 0x0094 }
            if (r3 == 0) goto L_0x008e
            int r6 = r3.getHeight()     // Catch:{ all -> 0x0094 }
            r7 = 2
            int r6 = r6 + r7
            int r8 = r3.getWidth()     // Catch:{ all -> 0x0094 }
            int r8 = r8 + r7
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0094 }
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r8, r6, r9)     // Catch:{ all -> 0x0094 }
            if (r9 == 0) goto L_0x008e
            int r10 = r15.hashCode()     // Catch:{ all -> 0x0094 }
            r11 = 0
            r9.eraseColor(r11)     // Catch:{ all -> 0x0094 }
            android.graphics.Canvas r12 = com.meizu.share.utils.StrokeDrawableUtils.C2847a.m17213b()     // Catch:{ all -> 0x0094 }
            r12.setBitmap(r9)     // Catch:{ all -> 0x0094 }
            android.graphics.Paint r13 = com.meizu.share.utils.StrokeDrawableUtils.C2847a.m17212a()     // Catch:{ all -> 0x0094 }
            int[] r14 = new int[r7]     // Catch:{ all -> 0x0094 }
            android.graphics.Bitmap r10 = com.meizu.share.utils.StrokeDrawableUtils.C2847a.m17211a(r8, r6, r10, r3, r14)     // Catch:{ all -> 0x0094 }
            r13.reset()     // Catch:{ all -> 0x0094 }
            r14 = 1610612736(0x60000000, float:3.6893488E19)
            r13.setColor(r14)     // Catch:{ all -> 0x0094 }
            int r0 = r0 + r7
            int r1 = r1 + r7
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createScaledBitmap(r3, r0, r1, r5)     // Catch:{ all -> 0x0094 }
            int r1 = r9.getDensity()     // Catch:{ all -> 0x0094 }
            r0.setDensity(r1)     // Catch:{ all -> 0x0094 }
            int r1 = r0.getWidth()     // Catch:{ all -> 0x0094 }
            int r1 = r8 - r1
            int r1 = r1 >> r5
            float r1 = (float) r1     // Catch:{ all -> 0x0094 }
            int r3 = r0.getHeight()     // Catch:{ all -> 0x0094 }
            int r3 = r6 - r3
            int r3 = r3 >> r5
            float r3 = (float) r3     // Catch:{ all -> 0x0094 }
            r12.drawBitmap(r0, r1, r3, r4)     // Catch:{ all -> 0x0094 }
            int r0 = r9.getDensity()     // Catch:{ all -> 0x0094 }
            r10.setDensity(r0)     // Catch:{ all -> 0x0094 }
            int r0 = r10.getWidth()     // Catch:{ all -> 0x0094 }
            int r0 = r8 - r0
            int r0 = r0 >> r5
            float r0 = (float) r0     // Catch:{ all -> 0x0094 }
            int r1 = r10.getHeight()     // Catch:{ all -> 0x0094 }
            int r1 = r6 - r1
            int r1 = r1 >> r5
            float r1 = (float) r1     // Catch:{ all -> 0x0094 }
            r12.drawBitmap(r10, r0, r1, r13)     // Catch:{ all -> 0x0094 }
            android.graphics.drawable.BitmapDrawable r0 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x0094 }
            r1 = r18
            r0.<init>(r1, r9)     // Catch:{ all -> 0x0094 }
            r0.setBounds(r11, r11, r8, r6)     // Catch:{ all -> 0x0094 }
            goto L_0x008f
        L_0x008e:
            r0 = r4
        L_0x008f:
            if (r0 != 0) goto L_0x0092
            r0 = r15
        L_0x0092:
            monitor-exit(r2)     // Catch:{ all -> 0x0094 }
            return r0
        L_0x0094:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0094 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.share.utils.StrokeDrawableUtils.m17210a(android.graphics.drawable.Drawable, int, int, android.content.res.Resources, java.lang.Boolean):android.graphics.drawable.Drawable");
    }

    /* renamed from: a */
    private static Bitmap m17209a(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null || drawable.getIntrinsicHeight() > 1000 || drawable.getIntrinsicWidth() > 1000) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if ((!(drawable instanceof NinePatchDrawable) && !(drawable instanceof StateListDrawable) && !(drawable instanceof GradientDrawable) && !(drawable instanceof InsetDrawable) && !(drawable instanceof LayerDrawable) && !(drawable instanceof LevelListDrawable) && !(drawable instanceof PaintDrawable) && !(drawable instanceof PictureDrawable) && !(drawable instanceof RotateDrawable) && !(drawable instanceof ScaleDrawable) && !(drawable instanceof ShapeDrawable) && !(drawable instanceof ClipDrawable) && !(drawable instanceof AdaptiveIconDrawable)) || drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0 || (createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888)) == null) {
            return null;
        }
        Canvas b = C2847a.m17213b();
        b.setBitmap(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(b);
        return createBitmap;
    }

    /* renamed from: com.meizu.share.utils.g$a */
    /* compiled from: StrokeDrawableUtils */
    private static class C2847a {

        /* renamed from: a */
        private static Paint f15808a;

        /* renamed from: b */
        private static Canvas f15809b;

        /* renamed from: c */
        private static BlurMaskFilter f15810c;

        /* renamed from: d */
        private static final int f15811d = ((int) (Runtime.getRuntime().maxMemory() / 1024));

        /* renamed from: e */
        private static final int f15812e = (f15811d / 8);

        /* renamed from: f */
        private static LruCache<String, Bitmap> f15813f = new LruCache<String, Bitmap>(f15812e) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public int sizeOf(String str, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }
        };

        /* renamed from: a */
        public static Bitmap m17211a(int i, int i2, int i3, Bitmap bitmap, int[] iArr) {
            String str = String.valueOf(i3) + String.valueOf(i) + String.valueOf(i2);
            Bitmap bitmap2 = f15813f.get(str);
            if (bitmap2 != null) {
                return bitmap2;
            }
            BlurMaskFilter c = m17214c();
            Paint a = m17212a();
            a.setMaskFilter(c);
            Bitmap extractAlpha = bitmap.extractAlpha(a, iArr);
            f15813f.put(str, extractAlpha);
            return extractAlpha;
        }

        /* renamed from: a */
        public static Paint m17212a() {
            if (f15808a == null) {
                f15808a = new Paint();
                f15808a.setColor(1610612736);
            }
            return f15808a;
        }

        /* renamed from: b */
        public static Canvas m17213b() {
            if (f15809b == null) {
                f15809b = new Canvas();
            }
            return f15809b;
        }

        /* renamed from: c */
        public static BlurMaskFilter m17214c() {
            if (f15810c == null) {
                f15810c = new BlurMaskFilter(2.0f, BlurMaskFilter.Blur.OUTER);
            }
            return f15810c;
        }
    }
}
