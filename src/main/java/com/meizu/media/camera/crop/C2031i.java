package com.meizu.media.camera.crop;

import android.database.Cursor;
import android.os.Build;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import java.io.Closeable;
import java.io.IOException;

/* renamed from: com.meizu.media.camera.crop.i */
/* compiled from: Utils */
public class C2031i {

    /* renamed from: a */
    public static ChangeQuickRedirect f9270a;

    /* renamed from: b */
    private static final LogUtil.C2630a f9271b = new LogUtil.C2630a("CropUtils");

    /* renamed from: c */
    private static long[] f9272c = new long[256];

    /* renamed from: d */
    private static final boolean f9273d = (Build.TYPE.equals("eng") || Build.TYPE.equals("userdebug"));

    static {
        for (int i = 0; i < 256; i++) {
            long j = (long) i;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (j >> 1) ^ ((((int) j) & 1) != 0 ? -7661587058870466123L : 0);
            }
            f9272c[i] = j;
        }
    }

    /* renamed from: a */
    public static void m9775a(Closeable closeable) {
        if (!PatchProxy.proxy(new Object[]{closeable}, (Object) null, f9270a, true, 3390, new Class[]{Closeable.class}, Void.TYPE).isSupported && closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                LogUtil.m15955d(f9271b, "close fail ", e);
            }
        }
    }

    /* renamed from: a */
    public static void m9774a(Cursor cursor) {
        if (!PatchProxy.proxy(new Object[]{cursor}, (Object) null, f9270a, true, 3392, new Class[]{Cursor.class}, Void.TYPE).isSupported && cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                LogUtil.m15955d(f9271b, "fail to close", th);
            }
        }
    }
}
