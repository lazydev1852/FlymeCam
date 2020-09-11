package com.meizu.media.camera.util;

import android.graphics.Bitmap;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: com.meizu.media.camera.util.f */
public class BitmapPool {

    /* renamed from: a */
    public static ChangeQuickRedirect f14233a;

    /* renamed from: b */
    private static BitmapPool[] f14234b = {new BitmapPool(), new BitmapPool(), new BitmapPool()};

    /* renamed from: c */
    private ArrayList<WeakReference<Bitmap>> f14235c = new ArrayList<>();

    /* renamed from: a */
    public static BitmapPool m16137a(int i) {
        return f14234b[i];
    }

    /* renamed from: a */
    public synchronized Bitmap mo22726a(int i, int i2) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2)}, this, f14233a, false, 7776, new Class[]{Integer.TYPE, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        for (int size = this.f14235c.size() - 1; size >= 0; size--) {
            WeakReference weakReference = this.f14235c.get(size);
            if (weakReference.get() != null) {
                Bitmap bitmap = (Bitmap) weakReference.get();
                if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
                    this.f14235c.remove(size);
                    return bitmap;
                }
            } else {
                this.f14235c.remove(weakReference);
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo22727a(Bitmap bitmap) {
        if (!PatchProxy.proxy(new Object[]{bitmap}, this, f14233a, false, 7777, new Class[]{Bitmap.class}, Void.TYPE).isSupported && bitmap != null) {
            synchronized (this) {
                for (int size = this.f14235c.size() - 1; size >= 0; size--) {
                    if (this.f14235c.get(size).get() == null) {
                        this.f14235c.remove(size);
                    }
                }
                this.f14235c.add(new WeakReference(bitmap));
            }
        }
    }
}
