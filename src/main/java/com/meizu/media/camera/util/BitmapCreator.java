package com.meizu.media.camera.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Environment;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.reflect.Method;

/* renamed from: com.meizu.media.camera.util.d */
public class BitmapCreator {

    /* renamed from: a */
    public static ChangeQuickRedirect f14213a;

    /* renamed from: b */
    private static final LogUtil.C2630a f14214b = new LogUtil.C2630a(BitmapCreator.class.getSimpleName());

    /* renamed from: c */
    private static final String f14215c = ("/" + Environment.DIRECTORY_DCIM + "/Camera");

    /* renamed from: d */
    private static final String f14216d;

    /* renamed from: e */
    private static Uri f14217e = null;

    /* renamed from: f */
    private static Method f14218f;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString());
        sb.append("/Camera");
        f14216d = sb.toString();
        try {
            Class<?> cls = Class.forName("com.mediatek.storage.StorageManagerEx");
            if (cls != null) {
                f14218f = cls.getDeclaredMethod("getDefaultPath", new Class[0]);
            }
            if (f14218f != null) {
                f14218f.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
            LogUtil.m15949b(f14214b, "NoSuchMethodException: getDefaultPath");
        } catch (ClassNotFoundException unused2) {
            LogUtil.m15949b(f14214b, "ClassNotFoundException: com.mediatek.storage.StorageManagerEx");
        }
    }

    /* renamed from: a */
    public static Bitmap m16127a(Bitmap bitmap, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap, new Integer(i)}, (Object) null, f14213a, true, 7757, new Class[]{Bitmap.class, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (i != 0) {
            Matrix matrix = new Matrix();
            matrix.setRotate((float) i, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (IllegalArgumentException e) {
                LogUtil.m15955d(f14214b, "Failed to rotate bitmap", e);
            }
        }
        return bitmap;
    }
}
