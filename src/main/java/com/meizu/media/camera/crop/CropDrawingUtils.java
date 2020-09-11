package com.meizu.media.camera.crop;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;

/* renamed from: com.meizu.media.camera.crop.b */
public abstract class CropDrawingUtils {

    /* renamed from: a */
    public static ChangeQuickRedirect f9238a;

    /* renamed from: a */
    public static void m9701a(Canvas canvas, RectF rectF) {
        if (!PatchProxy.proxy(new Object[]{canvas, rectF}, (Object) null, f9238a, true, 3283, new Class[]{Canvas.class, RectF.class}, Void.TYPE).isSupported) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.argb(128, 255, 255, 255));
            paint.setStrokeWidth(2.0f);
            float width = rectF.width() / 3.0f;
            float height = rectF.height() / 3.0f;
            float f = rectF.top + height;
            float f2 = rectF.left + width;
            for (int i = 0; i < 2; i++) {
                canvas.drawLine(f2, rectF.top, f2, rectF.bottom, paint);
                f2 += width;
            }
            for (int i2 = 0; i2 < 2; i2++) {
                canvas.drawLine(rectF.left, f, rectF.right, f, paint);
                f += height;
            }
        }
    }

    /* renamed from: b */
    public static void m9706b(Canvas canvas, RectF rectF) {
        Class[] clsArr = {Canvas.class, RectF.class};
        if (!PatchProxy.proxy(new Object[]{canvas, rectF}, (Object) null, f9238a, true, 3284, clsArr, Void.TYPE).isSupported) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(-1);
            paint.setStrokeWidth(3.0f);
            canvas.drawRect(rectF, paint);
        }
    }

    /* renamed from: a */
    public static void m9703a(Canvas canvas, Drawable drawable, int i, float f, float f2) {
        Object[] objArr = {canvas, drawable, new Integer(i), new Float(f), new Float(f2)};
        ChangeQuickRedirect changeQuickRedirect = f9238a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 3286, new Class[]{Canvas.class, Drawable.class, Integer.TYPE, Float.TYPE, Float.TYPE}, Void.TYPE).isSupported) {
            int i2 = i / 2;
            int i3 = ((int) f) - i2;
            int i4 = ((int) f2) - i2;
            drawable.setBounds(i3, i4, i3 + i, i + i4);
            drawable.draw(canvas);
        }
    }

    /* renamed from: a */
    public static void m9704a(Canvas canvas, Drawable drawable, int i, RectF rectF, boolean z, int i2) {
        Canvas canvas2 = canvas;
        Drawable drawable2 = drawable;
        int i3 = i;
        RectF rectF2 = rectF;
        boolean z2 = z;
        int i4 = i2;
        boolean z3 = true;
        if (!PatchProxy.proxy(new Object[]{canvas2, drawable2, new Integer(i3), rectF2, new Byte(z2 ? (byte) 1 : 0), new Integer(i4)}, (Object) null, f9238a, true, 3287, new Class[]{Canvas.class, Drawable.class, Integer.TYPE, RectF.class, Boolean.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            if (i4 != 0) {
                z3 = false;
            }
            if (z2) {
                if (i4 == 3 || z3) {
                    m9703a(canvas2, drawable2, i3, rectF2.left, rectF2.top);
                }
                if (i4 == 6 || z3) {
                    m9703a(canvas2, drawable2, i3, rectF2.right, rectF2.top);
                }
                if (i4 == 9 || z3) {
                    m9703a(canvas2, drawable2, i3, rectF2.left, rectF2.bottom);
                }
                if (i4 == 12 || z3) {
                    m9703a(canvas2, drawable2, i3, rectF2.right, rectF2.bottom);
                    return;
                }
                return;
            }
            if ((i4 & 2) != 0 || z3) {
                m9703a(canvas2, drawable2, i3, rectF.centerX(), rectF2.top);
            }
            if ((i4 & 8) != 0 || z3) {
                m9703a(canvas2, drawable2, i3, rectF.centerX(), rectF2.bottom);
            }
            if ((i4 & 1) != 0 || z3) {
                m9703a(canvas2, drawable2, i3, rectF2.left, rectF.centerY());
            }
            if ((i4 & 4) != 0 || z3) {
                m9703a(canvas2, drawable2, i3, rectF2.right, rectF.centerY());
            }
        }
    }

    /* renamed from: a */
    public static void m9702a(Canvas canvas, RectF rectF, float f, float f2, Paint paint, Paint paint2) {
        Object[] objArr = {canvas, rectF, new Float(f), new Float(f2), paint, paint2};
        ChangeQuickRedirect changeQuickRedirect = f9238a;
        if (!PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 3288, new Class[]{Canvas.class, RectF.class, Float.TYPE, Float.TYPE, Paint.class, Paint.class}, Void.TYPE).isSupported) {
            float width = rectF.width() * f;
            float height = rectF.height() * f2;
            float centerX = rectF.centerX();
            float centerY = rectF.centerY();
            float f3 = width / 2.0f;
            float f4 = height / 2.0f;
            RectF rectF2 = new RectF(centerX - f3, centerY - f4, centerX + f3, centerY + f4);
            RectF rectF3 = new RectF(centerX - f4, centerY - f3, centerX + f4, centerY + f3);
            canvas.save();
            canvas.clipRect(rectF);
            canvas.clipRect(rectF2, Region.Op.DIFFERENCE);
            canvas.clipRect(rectF3, Region.Op.DIFFERENCE);
            canvas.drawPaint(paint2);
            canvas.restore();
            Path path = new Path();
            path.moveTo(rectF2.left, rectF2.top);
            path.lineTo(rectF2.right, rectF2.top);
            path.moveTo(rectF2.left, rectF2.top);
            path.lineTo(rectF2.left, rectF2.bottom);
            path.moveTo(rectF2.left, rectF2.bottom);
            path.lineTo(rectF2.right, rectF2.bottom);
            path.moveTo(rectF2.right, rectF2.top);
            path.lineTo(rectF2.right, rectF2.bottom);
            path.moveTo(rectF3.left, rectF3.top);
            path.lineTo(rectF3.right, rectF3.top);
            path.moveTo(rectF3.right, rectF3.top);
            path.lineTo(rectF3.right, rectF3.bottom);
            path.moveTo(rectF3.left, rectF3.bottom);
            path.lineTo(rectF3.right, rectF3.bottom);
            path.moveTo(rectF3.left, rectF3.top);
            path.lineTo(rectF3.left, rectF3.bottom);
            canvas.drawPath(path, paint);
        }
    }

    /* renamed from: a */
    public static void m9700a(Canvas canvas, Paint paint, RectF rectF, RectF rectF2) {
        if (!PatchProxy.proxy(new Object[]{canvas, paint, rectF, rectF2}, (Object) null, f9238a, true, 3289, new Class[]{Canvas.class, Paint.class, RectF.class, RectF.class}, Void.TYPE).isSupported) {
            canvas.drawRect(rectF2.left, rectF2.top, rectF.right, rectF.top, paint);
            canvas.drawRect(rectF.right, rectF2.top, rectF2.right, rectF.bottom, paint);
            canvas.drawRect(rectF.left, rectF.bottom, rectF2.right, rectF2.bottom, paint);
            canvas.drawRect(rectF2.left, rectF.top, rectF.left, rectF2.bottom, paint);
        }
    }

    /* renamed from: a */
    public static boolean m9705a(Matrix matrix, RectF rectF, RectF rectF2, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{matrix, rectF, rectF2, new Integer(i)}, (Object) null, f9238a, true, 3292, new Class[]{Matrix.class, RectF.class, RectF.class, Integer.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        RectF rectF3 = new RectF();
        float f = (float) i;
        matrix.setRotate(f, rectF.centerX(), rectF.centerY());
        if (!matrix.mapRect(rectF3, rectF)) {
            return false;
        }
        boolean rectToRect = matrix.setRectToRect(rectF3, rectF2, Matrix.ScaleToFit.CENTER);
        boolean preRotate = matrix.preRotate(f, rectF.centerX(), rectF.centerY());
        if (!rectToRect || !preRotate) {
            return false;
        }
        return true;
    }
}
