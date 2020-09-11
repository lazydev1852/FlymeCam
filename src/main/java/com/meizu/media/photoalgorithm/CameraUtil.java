package com.meizu.media.photoalgorithm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.reflect.InvocationTargetException;

public class CameraUtil {
    public static ChangeQuickRedirect changeQuickRedirect;

    public static String getFlymeHideInfo() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, changeQuickRedirect, true, 9421, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.flyme.hideinfo"});
            Log.i("Util", "getFlymeHideInfo: result = " + str);
            return str;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return "true";
        }
    }

    public static String getFlymeModel() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], (Object) null, changeQuickRedirect, true, 9422, new Class[0], String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.product.flyme.model"});
            Log.i("Util", "getFlymeModel: result = " + str);
            return str.toLowerCase();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isBitmapValid(Bitmap bitmap) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap}, (Object) null, changeQuickRedirect, true, 9418, new Class[]{Bitmap.class}, Boolean.TYPE);
        return proxy.isSupported ? ((Boolean) proxy.result).booleanValue() : bitmap != null && !bitmap.isRecycled();
    }

    public static void recycleBitmap(Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{bitmap}, (Object) null, changeQuickRedirect, true, 9420, new Class[]{Bitmap.class}, Void.TYPE).isSupported && bitmap != null) {
            bitmap.recycle();
        }
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int i, int i2, boolean z) {
        Object[] objArr = {bitmap, new Integer(i), new Integer(i2), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 9419, new Class[]{Bitmap.class, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, bitmap.getConfig());
        Paint paint = new Paint(7);
        Canvas canvas = new Canvas();
        canvas.setBitmap(createBitmap);
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, i, i2), paint);
        if (z) {
            recycleBitmap(bitmap);
        }
        return createBitmap;
    }

    public static int sp2px(Context context, float f) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, new Float(f)}, (Object) null, changeQuickRedirect, true, 9417, new Class[]{Context.class, Float.TYPE}, Integer.TYPE);
        return proxy.isSupported ? ((Integer) proxy.result).intValue() : (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
