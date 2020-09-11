package com.meizu.media.camera.crop;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* renamed from: com.meizu.media.camera.crop.g */
/* compiled from: ImageLoader */
public final class C2027g {

    /* renamed from: a */
    public static ChangeQuickRedirect f9262a;

    /* renamed from: b */
    private static final LogUtil.C2630a f9263b = new LogUtil.C2630a("ImageLoader");

    /* renamed from: a */
    public static String m9758a(Uri uri) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uri}, (Object) null, f9262a, true, 3343, new Class[]{Uri.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    /* renamed from: a */
    public static String m9757a(Context context, Uri uri) {
        Cursor cursor;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uri}, (Object) null, f9262a, true, 3344, new Class[]{Context.class, Uri.class}, String.class);
        if (proxy.isSupported) {
            return (String) proxy.result;
        }
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
            if (cursor == null) {
                C2031i.m9774a(cursor);
                return null;
            }
            try {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                cursor.moveToFirst();
                if (cursor.getCount() == 0) {
                    C2031i.m9774a(cursor);
                    return null;
                }
                String string = cursor.getString(columnIndexOrThrow);
                C2031i.m9774a(cursor);
                return string;
            } catch (Exception unused) {
                C2031i.m9774a(cursor);
                return null;
            } catch (Throwable th) {
                th = th;
                C2031i.m9774a(cursor);
                throw th;
            }
        } catch (Exception unused2) {
            cursor = null;
            C2031i.m9774a(cursor);
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            C2031i.m9774a(cursor);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0098 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0099  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m9759b(android.content.Context r10, android.net.Uri r11) {
        /*
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r10
            r9 = 1
            r1[r9] = r11
            com.meizu.savior.ChangeQuickRedirect r3 = f9262a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.content.Context> r0 = android.content.Context.class
            r6[r8] = r0
            java.lang.Class<android.net.Uri> r0 = android.net.Uri.class
            r6[r9] = r0
            java.lang.Class r7 = java.lang.Integer.TYPE
            r2 = 0
            r4 = 1
            r5 = 3345(0xd11, float:4.687E-42)
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x002c
            java.lang.Object r10 = r0.result
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            return r10
        L_0x002c:
            if (r11 == 0) goto L_0x00bf
            if (r10 == 0) goto L_0x00bf
            r0 = 0
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch:{ SQLiteException | IllegalArgumentException | IllegalStateException -> 0x007d, all -> 0x0078 }
            java.lang.String r10 = "orientation"
            java.lang.String[] r3 = new java.lang.String[]{r10}     // Catch:{ SQLiteException | IllegalArgumentException | IllegalStateException -> 0x007d, all -> 0x0078 }
            r4 = 0
            r5 = 0
            r6 = 0
            r2 = r11
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ SQLiteException | IllegalArgumentException | IllegalStateException -> 0x007d, all -> 0x0078 }
            if (r10 == 0) goto L_0x0074
            boolean r0 = r10.moveToNext()     // Catch:{ SQLiteException | IllegalArgumentException | IllegalStateException -> 0x0072, all -> 0x006f }
            if (r0 == 0) goto L_0x0074
            int r0 = r10.getInt(r8)     // Catch:{ SQLiteException | IllegalArgumentException | IllegalStateException -> 0x0072, all -> 0x006f }
            r11 = 90
            if (r0 == r11) goto L_0x006a
            r11 = 180(0xb4, float:2.52E-43)
            if (r0 == r11) goto L_0x0065
            r11 = 270(0x10e, float:3.78E-43)
            if (r0 == r11) goto L_0x005f
            com.meizu.media.camera.crop.C2031i.m9774a((android.database.Cursor) r10)
            return r9
        L_0x005f:
            r11 = 8
            com.meizu.media.camera.crop.C2031i.m9774a((android.database.Cursor) r10)
            return r11
        L_0x0065:
            r11 = 3
            com.meizu.media.camera.crop.C2031i.m9774a((android.database.Cursor) r10)
            return r11
        L_0x006a:
            r11 = 6
            com.meizu.media.camera.crop.C2031i.m9774a((android.database.Cursor) r10)
            return r11
        L_0x006f:
            r11 = move-exception
            r0 = r10
            goto L_0x0079
        L_0x0072:
            r0 = r10
            goto L_0x007d
        L_0x0074:
            com.meizu.media.camera.crop.C2031i.m9774a((android.database.Cursor) r10)
            goto L_0x0080
        L_0x0078:
            r11 = move-exception
        L_0x0079:
            com.meizu.media.camera.crop.C2031i.m9774a((android.database.Cursor) r0)
            throw r11
        L_0x007d:
            com.meizu.media.camera.crop.C2031i.m9774a((android.database.Cursor) r0)
        L_0x0080:
            java.lang.String r10 = "file"
            java.lang.String r0 = r11.getScheme()
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x00be
            java.lang.String r10 = m9758a(r11)
            java.lang.String r0 = "image/jpeg"
            boolean r10 = r0.equals(r10)
            if (r10 != 0) goto L_0x0099
            return r9
        L_0x0099:
            java.lang.String r10 = r11.getPath()
            com.meizu.media.camera.d.c r11 = new com.meizu.media.camera.d.c
            r11.<init>()
            r11.mo19852a((java.lang.String) r10)     // Catch:{ IOException -> 0x00b6 }
            int r10 = com.meizu.media.camera.p067d.ExifInterface.f9398k     // Catch:{ IOException -> 0x00b6 }
            java.lang.Integer r10 = r11.mo19879g(r10)     // Catch:{ IOException -> 0x00b6 }
            if (r10 == 0) goto L_0x00be
            int r10 = r10.intValue()     // Catch:{ IOException -> 0x00b6 }
            switch(r10) {
                case 1: goto L_0x00b5;
                case 2: goto L_0x00b5;
                case 3: goto L_0x00b5;
                case 4: goto L_0x00b5;
                case 5: goto L_0x00b5;
                case 6: goto L_0x00b5;
                case 7: goto L_0x00b5;
                case 8: goto L_0x00b5;
                default: goto L_0x00b4;
            }
        L_0x00b4:
            return r9
        L_0x00b5:
            return r10
        L_0x00b6:
            r10 = move-exception
            com.meizu.media.camera.util.ac$a r11 = f9263b
            java.lang.String r0 = "Failed to read EXIF orientation"
            com.meizu.media.camera.util.LogUtil.m15955d(r11, r0, r10)
        L_0x00be:
            return r9
        L_0x00bf:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "bad argument to getOrientation"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.crop.C2027g.m9759b(android.content.Context, android.net.Uri):int");
    }

    /* renamed from: c */
    public static int m9760c(Context context, Uri uri) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uri}, (Object) null, f9262a, true, 3346, new Class[]{Context.class, Uri.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        int b = m9759b(context, uri);
        if (b == 3) {
            return 180;
        }
        if (b != 6) {
            return b != 8 ? 0 : 270;
        }
        return 90;
    }

    /* renamed from: d */
    public static Rect m9761d(Context context, Uri uri) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uri}, (Object) null, f9262a, true, 3348, new Class[]{Context.class, Uri.class}, Rect.class);
        if (proxy.isSupported) {
            return (Rect) proxy.result;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        m9755a(context, uri, options);
        return new Rect(0, 0, options.outWidth, options.outHeight);
    }

    /* renamed from: a */
    public static Bitmap m9754a(Context context, Uri uri, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uri, new Integer(i)}, (Object) null, f9262a, true, 3349, new Class[]{Context.class, Uri.class, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        options.inSampleSize = i;
        return m9755a(context, uri, options);
    }

    /* renamed from: a */
    public static Bitmap m9755a(Context context, Uri uri, BitmapFactory.Options options) {
        InputStream inputStream;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uri, options}, (Object) null, f9262a, true, 3350, new Class[]{Context.class, Uri.class, BitmapFactory.Options.class}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (uri == null || context == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        try {
            inputStream = context.getContentResolver().openInputStream(uri);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                C2031i.m9775a((Closeable) inputStream);
                return decodeStream;
            } catch (FileNotFoundException e) {
                e = e;
                try {
                    LogUtil.m15950b(f9263b, "FileNotFoundException for " + uri, e);
                    C2031i.m9775a((Closeable) inputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    C2031i.m9775a((Closeable) inputStream);
                    throw th;
                }
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            inputStream = null;
            LogUtil.m15950b(f9263b, "FileNotFoundException for " + uri, e);
            C2031i.m9775a((Closeable) inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            C2031i.m9775a((Closeable) inputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static Bitmap m9756a(Uri uri, Context context, int i, Rect rect, boolean z) {
        int i2;
        int i3 = 1;
        Object[] objArr = {uri, context, new Integer(i), rect, new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9262a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 3351, new Class[]{Uri.class, Context.class, Integer.TYPE, Rect.class, Boolean.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (i <= 0 || uri == null || context == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        Rect d = m9761d(context, uri);
        if (rect != null) {
            rect.set(d);
        }
        int width = d.width();
        int height = d.height();
        if (width <= 0 || height <= 0) {
            return null;
        }
        if (z) {
            i2 = Math.min(width, height);
        } else {
            i2 = Math.max(width, height);
        }
        while (i2 > i) {
            i2 >>>= 1;
            i3 <<= 1;
        }
        if (i3 <= 0 || Math.min(width, height) / i3 <= 0) {
            return null;
        }
        return m9754a(context, uri, i3);
    }
}
