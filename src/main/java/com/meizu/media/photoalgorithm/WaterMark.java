package com.meizu.media.photoalgorithm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.ByteBuffer;

public class WaterMark {
    private static final int DEVICE_MARK_MARGIN = 90;
    private static final int DUALCAM_TIME_MARK_BOTTOM_MARGIN = 117;
    private static final int MEASURE_TEXT_DEVIATION = 100;
    private static final String TAG = "WaterMark";
    private static final int TIME_MARK_4_3_BOTTOM_MARGIN = 126;
    private static final int TIME_MARK_MARGIN = 96;
    private static final int TIME_MARK_NON_4_3_BOTTOM_MARGIN = 117;
    public static ChangeQuickRedirect changeQuickRedirect = null;
    private static String sCustomSign = null;
    private static boolean sScaleRatioUseOffset = false;

    static {
        System.loadLibrary("mz_photo_timestamp");
    }

    public static String getCustomSign() {
        return sCustomSign;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0116  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap getDevicemarkBitmap(android.content.Context r11, java.lang.String r12, java.lang.String r13, boolean r14) {
        /*
            r0 = 4
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r11
            r9 = 1
            r1[r9] = r12
            r10 = 2
            r1[r10] = r13
            java.lang.Byte r2 = new java.lang.Byte
            r2.<init>(r14)
            r3 = 3
            r1[r3] = r2
            com.meizu.savior.ChangeQuickRedirect r4 = changeQuickRedirect
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.content.Context> r0 = android.content.Context.class
            r6[r8] = r0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r9] = r0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r6[r10] = r0
            java.lang.Class r0 = java.lang.Boolean.TYPE
            r6[r3] = r0
            java.lang.Class<android.graphics.Bitmap> r7 = android.graphics.Bitmap.class
            r2 = 0
            r0 = 1
            r5 = 9429(0x24d5, float:1.3213E-41)
            r3 = r4
            r4 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x003d
            java.lang.Object r11 = r0.result
            android.graphics.Bitmap r11 = (android.graphics.Bitmap) r11
            return r11
        L_0x003d:
            java.lang.String r0 = "true"
            java.lang.String r1 = com.meizu.media.photoalgorithm.CameraUtil.getFlymeHideInfo()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004c
            java.lang.String r0 = "test"
            goto L_0x0050
        L_0x004c:
            java.lang.String r0 = r12.toLowerCase()
        L_0x0050:
            java.lang.String r1 = "arcrefocus/WaterMark"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getDevicemarkBitmap deviceType="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = " deviceName="
            r2.append(r3)
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            android.util.Log.i(r1, r12)
            r12 = -1
            if (r14 == 0) goto L_0x00a4
            android.content.res.Resources r14 = r11.getResources()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "watermark_"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r2 = "_intl"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "drawable"
            java.lang.String r3 = r11.getPackageName()
            int r14 = r14.getIdentifier(r1, r2, r3)
            if (r14 == 0) goto L_0x009a
            if (r14 == r12) goto L_0x009a
            goto L_0x00c3
        L_0x009a:
            android.content.res.Resources r14 = r11.getResources()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L_0x00ad
        L_0x00a4:
            android.content.res.Resources r14 = r11.getResources()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L_0x00ad:
            java.lang.String r2 = "watermark_"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "drawable"
            java.lang.String r3 = r11.getPackageName()
            int r14 = r14.getIdentifier(r1, r2, r3)
        L_0x00c3:
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            r1.inPreferredConfig = r2
            r1.inMutable = r9
            android.content.res.Resources r2 = r11.getResources()
            android.graphics.Bitmap r14 = android.graphics.BitmapFactory.decodeResource(r2, r14, r1)
            if (r14 != 0) goto L_0x010b
            java.lang.String r14 = "arcrefocus/WaterMark"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "decode watermark_"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = " fail, use default test watermark!"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r14, r2)
            android.content.res.Resources r14 = r11.getResources()
            java.lang.String r2 = "watermark_test"
            java.lang.String r3 = "drawable"
            java.lang.String r4 = r11.getPackageName()
            int r14 = r14.getIdentifier(r2, r3, r4)
            android.content.res.Resources r2 = r11.getResources()
            android.graphics.Bitmap r14 = android.graphics.BitmapFactory.decodeResource(r2, r14, r1)
        L_0x010b:
            r1 = 0
            if (r14 != 0) goto L_0x0116
            java.lang.String r11 = "arcrefocus/WaterMark"
            java.lang.String r12 = "decode watermark failed, please check resource immediately!"
            android.util.Log.e(r11, r12)
            return r1
        L_0x0116:
            boolean r2 = android.text.TextUtils.isEmpty(r13)
            if (r2 != 0) goto L_0x0272
            java.lang.String r2 = " "
            java.lang.String r3 = ""
            java.lang.String r2 = r13.replaceAll(r2, r3)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x012c
            goto L_0x0272
        L_0x012c:
            java.lang.String r2 = "arcrefocus/WaterMark"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "bitmap.getWidth()="
            r3.append(r4)
            int r4 = r14.getWidth()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.i(r2, r3)
            java.lang.String r2 = "m1926"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x018b
            java.lang.String r2 = "m1928"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0157
            goto L_0x018b
        L_0x0157:
            java.lang.String r2 = "m1973"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0166
            android.content.res.Resources r2 = r11.getResources()
            int r3 = com.meizu.media.photoalgorithm.watermark.R.dimen.mz_device_mark_rect_margin_triple_73
            goto L_0x0191
        L_0x0166:
            java.lang.String r2 = "m2091"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0175
            android.content.res.Resources r2 = r11.getResources()
            int r3 = com.meizu.media.photoalgorithm.watermark.R.dimen.mz_device_mark_rect_margin_triple_91
            goto L_0x0191
        L_0x0175:
            java.lang.String r2 = "m2081"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0184
            android.content.res.Resources r2 = r11.getResources()
            int r3 = com.meizu.media.photoalgorithm.watermark.R.dimen.mz_device_mark_rect_margin_triple_81
            goto L_0x0191
        L_0x0184:
            android.content.res.Resources r2 = r11.getResources()
            int r3 = com.meizu.media.photoalgorithm.watermark.R.dimen.mz_device_mark_rect_margin
            goto L_0x0191
        L_0x018b:
            android.content.res.Resources r2 = r11.getResources()
            int r3 = com.meizu.media.photoalgorithm.watermark.R.dimen.mz_device_mark_rect_margin_triple_26
        L_0x0191:
            int r2 = r2.getDimensionPixelOffset(r3)
            android.content.res.Resources r3 = r11.getResources()
            int r4 = com.meizu.media.photoalgorithm.watermark.R.dimen.mz_device_mark_text_margin
            int r3 = r3.getDimensionPixelOffset(r4)
            android.graphics.Paint r4 = new android.graphics.Paint
            r4.<init>(r9)
            r4.setColor(r12)
            android.graphics.Paint$Align r12 = android.graphics.Paint.Align.LEFT
            r4.setTextAlign(r12)
            android.graphics.Paint$Style r12 = android.graphics.Paint.Style.FILL
            r4.setStyle(r12)
            java.lang.String r12 = "/system/fonts/SFDIN-Medium.otf"
            android.graphics.Typeface r12 = android.graphics.Typeface.createFromFile(r12)     // Catch:{ Exception -> 0x01b8 }
            goto L_0x01bd
        L_0x01b8:
            r12 = move-exception
            r12.printStackTrace()
            r12 = r1
        L_0x01bd:
            if (r12 == 0) goto L_0x01c2
            r4.setTypeface(r12)
        L_0x01c2:
            java.lang.String r1 = "m2081"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x01d4
            java.lang.String r1 = "m2091"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x01d3
            goto L_0x01d4
        L_0x01d3:
            r9 = 0
        L_0x01d4:
            if (r9 == 0) goto L_0x01d9
            r0 = 1114898432(0x42740000, float:61.0)
            goto L_0x01db
        L_0x01d9:
            r0 = 1114374144(0x426c0000, float:59.0)
        L_0x01db:
            int r11 = com.meizu.media.photoalgorithm.CameraUtil.sp2px(r11, r0)
            float r11 = (float) r11
            r4.setTextSize(r11)
            android.graphics.Paint r11 = new android.graphics.Paint
            r11.<init>(r4)
            r0 = 38
            int r0 = android.graphics.Color.argb(r0, r8, r8, r8)
            r11.setColor(r0)
            if (r12 == 0) goto L_0x01f6
            r11.setTypeface(r12)
        L_0x01f6:
            android.graphics.Paint$Style r12 = android.graphics.Paint.Style.STROKE
            r11.setStyle(r12)
            r12 = 1098907648(0x41800000, float:16.0)
            r11.setStrokeWidth(r12)
            float r12 = r4.measureText(r13)
            int r12 = (int) r12
            int r12 = r12 + r2
            int r12 = r12 + 100
            int r0 = r14.getWidth()
            if (r12 <= r0) goto L_0x0219
            int r0 = r14.getHeight()
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r12 = android.graphics.Bitmap.createBitmap(r12, r0, r1)
            goto L_0x021a
        L_0x0219:
            r12 = r14
        L_0x021a:
            android.graphics.Canvas r0 = new android.graphics.Canvas
            r0.<init>(r12)
            android.graphics.Paint r1 = new android.graphics.Paint
            r1.<init>()
            r5 = 0
            r0.drawBitmap(r14, r5, r5, r1)
            r0.save()
            android.graphics.Rect r1 = new android.graphics.Rect
            int r5 = r14.getHeight()
            int r5 = r5 / r10
            if (r9 == 0) goto L_0x0237
            r6 = 60
            goto L_0x0238
        L_0x0237:
            r6 = 0
        L_0x0238:
            int r5 = r5 - r6
            int r6 = r12.getWidth()
            int r14 = r14.getHeight()
            r1.<init>(r2, r5, r6, r14)
            r0.clipRect(r1)
            android.graphics.PorterDuff$Mode r14 = android.graphics.PorterDuff.Mode.CLEAR
            r0.drawColor(r8, r14)
            android.graphics.Paint$FontMetrics r14 = r4.getFontMetrics()
            float r2 = r14.bottom
            float r5 = r14.top
            float r2 = r2 - r5
            r5 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r5
            float r14 = r14.bottom
            float r2 = r2 - r14
            int r14 = r1.centerY()
            float r14 = (float) r14
            float r14 = r14 + r2
            if (r9 != 0) goto L_0x026a
            int r2 = r1.left
            int r2 = r2 + r3
            float r2 = (float) r2
            r0.drawText(r13, r2, r14, r11)
        L_0x026a:
            int r11 = r1.left
            int r11 = r11 + r3
            float r11 = (float) r11
            r0.drawText(r13, r11, r14, r4)
            return r12
        L_0x0272:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.photoalgorithm.WaterMark.getDevicemarkBitmap(android.content.Context, java.lang.String, java.lang.String, boolean):android.graphics.Bitmap");
    }

    public static Bitmap getDevicemarkBitmap(Context context, String str, boolean z) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, str, new Byte(z ? (byte) 1 : 0)}, (Object) null, changeQuickRedirect, true, 9428, new Class[]{Context.class, String.class, Boolean.TYPE}, Bitmap.class);
        return proxy.isSupported ? (Bitmap) proxy.result : getDevicemarkBitmap(context, str, sCustomSign, z);
    }

    public static Rect getDevicemarkRect(int i, int i2, int i3, int i4, int i5) {
        int i6;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4), new Integer(i5)}, (Object) null, changeQuickRedirect, true, 9425, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Rect.class);
        if (proxy.isSupported) {
            return (Rect) proxy.result;
        }
        Rect rect = new Rect();
        int min = Math.min(i3, i4);
        int max = Math.max(i3, i4);
        if (i5 == 90) {
            rect.left = (i - min) - 90;
            rect.top = (i2 - max) - 90;
        } else {
            if (i5 == 180) {
                rect.left = (i - max) - 90;
                rect.top = 90;
            } else if (i5 == 270) {
                rect.left = 90;
                rect.top = 90;
            } else {
                if (i5 == 0) {
                    rect.left = 90;
                    rect.top = (i2 - min) - 90;
                }
                if (rect.left < 0 || rect.top < 0) {
                    rect.left = 0;
                    rect.top = 0;
                }
                return rect;
            }
            rect.right = rect.left + max;
            i6 = rect.top + min;
            rect.bottom = i6;
            rect.left = 0;
            rect.top = 0;
            return rect;
        }
        rect.right = rect.left + min;
        i6 = rect.top + max;
        rect.bottom = i6;
        rect.left = 0;
        rect.top = 0;
        return rect;
    }

    public static float getDevicemarkScaledRaio(int i, int i2, Bitmap bitmap, int i3) {
        Object[] objArr = {new Integer(i), new Integer(i2), bitmap, new Integer(i3)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 9423, new Class[]{Integer.TYPE, Integer.TYPE, Bitmap.class, Integer.TYPE}, Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        if (bitmap == null) {
            return 1.0f;
        }
        int min = Math.min(i, i2);
        float max = (float) Math.max(i, i2);
        float f = (float) min;
        float f2 = max / f;
        float f3 = 13.4f;
        if (((double) (f2 - 1.3333334f)) >= 0.01d) {
            float f4 = 22.22f;
            if (((double) (f2 - 1.7777778f)) < 0.01d) {
                if (sScaleRatioUseOffset) {
                    f4 = 20.22f;
                }
                float height = ((float) ((int) (max / f4))) / ((float) bitmap.getHeight());
                if (((double) Math.abs(height - 1.0f)) < 0.01d) {
                    return 1.0f;
                }
                return height;
            } else if (f2 >= 2.0f) {
                float height2 = ((float) ((int) (max / 22.22f))) / ((float) bitmap.getHeight());
                if (((double) Math.abs(height2 - 1.0f)) < 0.01d) {
                    return 1.0f;
                }
                return height2;
            }
        } else if (sScaleRatioUseOffset) {
            f3 = 12.4f;
        }
        float height3 = ((float) ((int) (f / f3))) / ((float) bitmap.getHeight());
        if (((double) Math.abs(height3 - 1.0f)) < 0.01d) {
            return 1.0f;
        }
        return height3;
    }

    public static Bitmap getTimemarkBitmap(Context context, String str) {
        boolean z = true;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, str}, (Object) null, changeQuickRedirect, true, 9427, new Class[]{Context.class, String.class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        Typeface typeface = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Rect rect = new Rect();
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStyle(Paint.Style.FILL);
        String flymeModel = CameraUtil.getFlymeModel();
        if (!"m2081".equals(flymeModel) && !"m2091".equals(flymeModel)) {
            z = false;
        }
        try {
            typeface = Typeface.createFromFile(z ? "/system/fonts/SFDIN-Bold.otf" : "/system/fonts/SFDIN-Medium.otf");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (typeface != null) {
            paint.setTypeface(typeface);
        }
        paint.setTextSize((float) CameraUtil.sp2px(context, z ? 20.0f : 22.0f));
        paint.getTextBounds(str, 0, str.length(), rect);
        float measureText = paint.measureText(str);
        int height = rect.height();
        Bitmap createBitmap = Bitmap.createBitmap((int) measureText, height + 8, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint2 = new Paint(paint);
        paint2.setColor(Color.argb(38, 0, 0, 0));
        if (typeface != null) {
            paint2.setTypeface(typeface);
        }
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(4.0f);
        if (!z) {
            canvas.drawText(str, measureText / 2.0f, (float) (height + 4), paint2);
        }
        canvas.drawText(str, measureText / 2.0f, (float) (height + 4), paint);
        return createBitmap;
    }

    public static Rect getTimemarkRect(int i, int i2, int i3, int i4, int i5) {
        int i6;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), new Integer(i3), new Integer(i4), new Integer(i5)}, (Object) null, changeQuickRedirect, true, 9426, new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Rect.class);
        if (proxy.isSupported) {
            return (Rect) proxy.result;
        }
        Rect rect = new Rect();
        int min = Math.min(i3, i4);
        int max = Math.max(i3, i4);
        int i7 = ((double) ((((float) Math.max(i, i2)) / ((float) Math.min(i, i2))) - 1.3333334f)) < 0.01d ? 126 : 117;
        if (i5 == 90) {
            rect.left = (i - min) - 96;
            rect.top = 96;
        } else {
            if (i5 == 180) {
                rect.left = 96;
                rect.top = i7;
            } else if (i5 == 270) {
                rect.left = 96;
                rect.top = (i2 - max) - 96;
            } else {
                if (i5 == 0) {
                    rect.left = (i - max) - 96;
                    rect.top = (i2 - min) - i7;
                }
                if (rect.left < 0 || rect.top < 0) {
                    rect.left = 0;
                    rect.top = 0;
                }
                return rect;
            }
            rect.right = rect.left + max;
            i6 = rect.top + min;
            rect.bottom = i6;
            rect.left = 0;
            rect.top = 0;
            return rect;
        }
        rect.right = rect.left + min;
        i6 = rect.top + max;
        rect.bottom = i6;
        rect.left = 0;
        rect.top = 0;
        return rect;
    }

    public static float getTimemarkScaledRaio(int i, int i2, Bitmap bitmap, int i3) {
        Object[] objArr = {new Integer(i), new Integer(i2), bitmap, new Integer(i3)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 9424, new Class[]{Integer.TYPE, Integer.TYPE, Bitmap.class, Integer.TYPE}, Float.TYPE);
        if (proxy.isSupported) {
            return ((Float) proxy.result).floatValue();
        }
        if (bitmap == null) {
            return 1.0f;
        }
        int min = Math.min(i, i2);
        float max = (float) Math.max(i, i2);
        float f = (float) min;
        float f2 = max / f;
        if (((double) (f2 - 1.3333334f)) >= 0.01d) {
            if (((double) (f2 - 1.7777778f)) < 0.01d) {
                float height = ((float) ((int) (max / 67.2f))) / ((float) bitmap.getHeight());
                if (((double) Math.abs(height - 1.0f)) < 0.01d) {
                    return 1.0f;
                }
                return height;
            } else if (f2 >= 2.0f) {
                float height2 = ((float) ((int) (max / 67.2f))) / ((float) bitmap.getHeight());
                if (((double) Math.abs(height2 - 1.0f)) < 0.01d) {
                    return 1.0f;
                }
                return height2;
            }
        }
        int width = bitmap.getWidth();
        if (i3 == 90 || i3 == 270) {
            width = (int) (max / 5.75f);
        } else if (i3 == 180 || i3 == 0) {
            width = (int) (f / 5.75f);
        }
        float width2 = ((float) width) / ((float) bitmap.getWidth());
        if (((double) Math.abs(width2 - 1.0f)) < 0.01d) {
            return 1.0f;
        }
        return width2;
    }

    private static native boolean nativePhotoWaterMarkNV21(byte[] bArr, int i, int i2, Bitmap bitmap, int i3, Rect rect);

    public static native boolean nativePhotoWaterMarkYUV(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, Bitmap bitmap, int i6, Rect rect);

    public static native boolean nativeWaterMark(Bitmap bitmap, Bitmap bitmap2, int i, Rect rect);

    public static boolean renderDeviceWaterMark4NV21(Context context, byte[] bArr, int i, int i2, int i3, String str, boolean z) {
        Context context2 = context;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        String str2 = str;
        boolean z2 = z;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context2, bArr, new Integer(i4), new Integer(i5), new Integer(i6), str2, new Byte(z2 ? (byte) 1 : 0)}, (Object) null, changeQuickRedirect, true, 9433, new Class[]{Context.class, byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        Bitmap devicemarkBitmap = getDevicemarkBitmap(context2, str2, z2);
        if (!CameraUtil.isBitmapValid(devicemarkBitmap)) {
            Log.e(TAG, "renderDeviceWaterMark4NV21 deviceMarkBmp invalid");
            return false;
        }
        int i7 = ((i6 % 360) + 360) % 360;
        float devicemarkScaledRaio = getDevicemarkScaledRaio(i4, i5, devicemarkBitmap, i7);
        int width = (int) (((float) devicemarkBitmap.getWidth()) * devicemarkScaledRaio);
        int height = (int) (((float) devicemarkBitmap.getHeight()) * devicemarkScaledRaio);
        Bitmap scaleBitmap = CameraUtil.scaleBitmap(devicemarkBitmap, width, height, true);
        Rect rect = new Rect(0, 0, width, height);
        rect.offset(90, ((i7 == 90 || i7 == 270) ? i4 - 90 : i5 - 90) - height);
        Log.i(TAG, "renderDeviceWaterMark4NV21 device markRect=" + rect + " yuv size:" + i4 + "x" + i5 + " rotation:" + i7);
        return renderPhotoWaterMarkNV21(bArr, i, i2, scaleBitmap, i7, rect);
    }

    public static boolean renderDeviceWaterMark4RGBA(Context context, Bitmap bitmap, float f, int i, String str, boolean z) {
        String str2;
        String str3;
        Object[] objArr = {context, bitmap, new Float(f), new Integer(i), str, new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 9431, new Class[]{Context.class, Bitmap.class, Float.TYPE, Integer.TYPE, String.class, Boolean.TYPE}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!CameraUtil.isBitmapValid(bitmap)) {
            str2 = TAG;
            str3 = "renderDeviceWaterMark4RGBA image invalid";
        } else {
            Bitmap devicemarkBitmap = getDevicemarkBitmap(context, str, z);
            if (!CameraUtil.isBitmapValid(devicemarkBitmap)) {
                str2 = TAG;
                str3 = "renderDeviceWaterMark4RGBA deviceMarkBmp invalid";
            } else {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i2 = ((i % 360) + 360) % 360;
                float devicemarkScaledRaio = getDevicemarkScaledRaio(width, height, devicemarkBitmap, i2);
                int width2 = (int) (((float) devicemarkBitmap.getWidth()) * devicemarkScaledRaio);
                int height2 = (int) (((float) devicemarkBitmap.getHeight()) * devicemarkScaledRaio);
                Bitmap scaleBitmap = CameraUtil.scaleBitmap(devicemarkBitmap, width2, height2, true);
                Rect rect = new Rect(0, 0, width2, height2);
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                int i3 = (int) (90.0f / f);
                if (i2 == 90 || i2 == 270) {
                    rect.offset(i3, (width - i3) - height2);
                } else {
                    rect.offset(i3, (height - i3) - height2);
                }
                Log.i(TAG, "renderDeviceWaterMark4RGBA device markRect=" + rect);
                return renderPhotoWaterMarkRGBA(bitmap, scaleBitmap, i2, rect);
            }
        }
        Log.e(str2, str3);
        return false;
    }

    private static boolean renderPhotoWaterMarkNV21(byte[] bArr, int i, int i2, Bitmap bitmap, int i3, Rect rect) {
        int i4;
        float f;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bArr, new Integer(i), new Integer(i2), bitmap, new Integer(i3), rect}, (Object) null, changeQuickRedirect, true, 9434, new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, Bitmap.class, Integer.TYPE, Rect.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        int i5 = ((i3 % 360) + 360) % 360;
        Matrix matrix = new Matrix();
        if (i5 == 90 || i5 == 270) {
            f = (float) ((-i2) / 2);
            i4 = -i;
        } else {
            if (i5 == 180) {
                f = (float) ((-i) / 2);
                i4 = -i2;
            }
            RectF rectF = new RectF(rect);
            matrix.mapRect(rectF);
            Rect rect2 = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            Log.i(TAG, "renderPhotoWaterMarkNV21 roundR:" + rect2 + " rotateR=" + rectF);
            return nativePhotoWaterMarkNV21(bArr, i, i2, bitmap, i5, rect2);
        }
        matrix.postTranslate(f, (float) (i4 / 2));
        matrix.postRotate((float) (-i5));
        matrix.postTranslate((float) (i / 2), (float) (i2 / 2));
        RectF rectF2 = new RectF(rect);
        matrix.mapRect(rectF2);
        Rect rect22 = new Rect((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
        Log.i(TAG, "renderPhotoWaterMarkNV21 roundR:" + rect22 + " rotateR=" + rectF2);
        return nativePhotoWaterMarkNV21(bArr, i, i2, bitmap, i5, rect22);
    }

    private static boolean renderPhotoWaterMarkRGBA(Bitmap bitmap, Bitmap bitmap2, int i, Rect rect) {
        int i2;
        float f;
        Object[] objArr = {bitmap, bitmap2, new Integer(i), rect};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect3, true, 9435, new Class[]{Bitmap.class, Bitmap.class, Integer.TYPE, Rect.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = ((i % 360) + 360) % 360;
        Matrix matrix = new Matrix();
        if (i3 == 90 || i3 == 270) {
            f = (float) ((-height) / 2);
            i2 = -width;
        } else {
            if (i3 == 180) {
                f = (float) ((-width) / 2);
                i2 = -height;
            }
            RectF rectF = new RectF(rect);
            matrix.mapRect(rectF);
            Rect rect2 = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            Log.i(TAG, "renderPhotoWaterMarkRGBA roundR:" + rect2 + " rotateR=" + rectF);
            return nativeWaterMark(bitmap, bitmap2, i3, rect2);
        }
        matrix.postTranslate(f, (float) (i2 / 2));
        matrix.postRotate((float) (-i3));
        matrix.postTranslate((float) (width / 2), (float) (height / 2));
        RectF rectF2 = new RectF(rect);
        matrix.mapRect(rectF2);
        Rect rect22 = new Rect((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
        Log.i(TAG, "renderPhotoWaterMarkRGBA roundR:" + rect22 + " rotateR=" + rectF2);
        return nativeWaterMark(bitmap, bitmap2, i3, rect22);
    }

    public static boolean renderTimeWaterMark4NV21(Context context, byte[] bArr, int i, int i2, int i3, String str) {
        int i4;
        int i5;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, bArr, new Integer(i), new Integer(i2), new Integer(i3), str}, (Object) null, changeQuickRedirect, true, 9432, new Class[]{Context.class, byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        Bitmap timemarkBitmap = getTimemarkBitmap(context, str);
        if (!CameraUtil.isBitmapValid(timemarkBitmap)) {
            Log.e(TAG, "renderTimeWaterMark4NV21 timeMarkBmp invalid");
            return false;
        }
        int i6 = ((i3 % 360) + 360) % 360;
        float timemarkScaledRaio = getTimemarkScaledRaio(i, i2, timemarkBitmap, i6);
        int width = (int) (((float) timemarkBitmap.getWidth()) * timemarkScaledRaio);
        int height = (int) (((float) timemarkBitmap.getHeight()) * timemarkScaledRaio);
        Bitmap scaleBitmap = CameraUtil.scaleBitmap(timemarkBitmap, width, height, true);
        Rect rect = new Rect(0, 0, width, height);
        if (i6 == 90 || i6 == 270) {
            if (Math.abs((((float) i2) / ((float) i)) - 0.75f) < 0.01f) {
            }
            i5 = (i2 - 96) - width;
            i4 = i - 117;
        } else {
            if (Math.abs((((float) i) / ((float) i2)) - 0.75f) < 0.01f) {
            }
            i5 = (i - 96) - width;
            i4 = i2 - 117;
        }
        rect.offset(i5, i4 - height);
        Log.i(TAG, "renderTimeWaterMark4NV21 time markRect=" + rect);
        return renderPhotoWaterMarkNV21(bArr, i, i2, scaleBitmap, i6, rect);
    }

    public static boolean renderTimeWaterMark4RGBA(Context context, Bitmap bitmap, float f, int i, String str) {
        String str2;
        String str3;
        Context context2 = context;
        Bitmap bitmap2 = bitmap;
        float f2 = f;
        int i2 = i;
        String str4 = str;
        Object[] objArr = {context2, bitmap2, new Float(f2), new Integer(i2), str4};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        ChangeQuickRedirect changeQuickRedirect3 = changeQuickRedirect2;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect3, true, 9430, new Class[]{Context.class, Bitmap.class, Float.TYPE, Integer.TYPE, String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        if (!CameraUtil.isBitmapValid(bitmap)) {
            str2 = TAG;
            str3 = "renderTimeWaterMark4RGBA image invalid";
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap timemarkBitmap = getTimemarkBitmap(context2, str4);
            if (!CameraUtil.isBitmapValid(timemarkBitmap)) {
                str2 = TAG;
                str3 = "renderTimeWaterMark4RGBA timeMarkBmp invalid";
            } else {
                int i3 = ((i2 % 360) + 360) % 360;
                float timemarkScaledRaio = getTimemarkScaledRaio(width, height, timemarkBitmap, i3);
                int width2 = (int) (((float) timemarkBitmap.getWidth()) * timemarkScaledRaio);
                int height2 = (int) (((float) timemarkBitmap.getHeight()) * timemarkScaledRaio);
                Bitmap scaleBitmap = CameraUtil.scaleBitmap(timemarkBitmap, width2, height2, true);
                Rect rect = new Rect(0, 0, width2, height2);
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                int i4 = (int) (96.0f / f2);
                if (i3 == 90 || i3 == 270) {
                    if (Math.abs((((float) height) / ((float) width)) - 0.75f) >= 0.01f) {
                    }
                    rect.offset((height - i4) - width2, (width - ((int) (((float) 117) / f2))) - height2);
                } else {
                    if (Math.abs((((float) width) / ((float) height)) - 0.75f) >= 0.01f) {
                    }
                    rect.offset((width - i4) - width2, (height - ((int) (((float) 117) / f2))) - height2);
                }
                Log.i(TAG, "renderTimeWaterMark4RGBA time markRect=" + rect);
                return renderPhotoWaterMarkRGBA(bitmap2, scaleBitmap, i3, rect);
            }
        }
        Log.e(str2, str3);
        return false;
    }

    public static void setCustomSign(String str) {
        sCustomSign = str;
    }

    public static void updateScaleRatioUsedStatus(boolean z) {
        sScaleRatioUseOffset = z;
    }
}
