package com.meizu.media.camera.crop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import com.mediatek.media.MtkMediaStore;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.lib.plugin.constants.Parameters;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

/* renamed from: com.meizu.media.camera.crop.h */
public class SaveImage {

    /* renamed from: a */
    public static ChangeQuickRedirect f9264a;

    /* renamed from: b */
    private static final LogUtil.C2630a f9265b = new LogUtil.C2630a("SaveImage");

    /* renamed from: com.meizu.media.camera.crop.h$a */
    /* compiled from: SaveImage */
    public interface C2030a {
        /* renamed from: a */
        void mo19807a(Cursor cursor);
    }

    /* renamed from: a */
    public static File m9764a(Context context, Uri uri) {
        ChangeQuickRedirect changeQuickRedirect = f9264a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uri}, (Object) null, changeQuickRedirect, true, 3357, new Class[]{Context.class, Uri.class}, File.class);
        if (proxy.isSupported) {
            return (File) proxy.result;
        }
        File c = m9769c(context, uri);
        if (c == null || !c.canWrite()) {
            c = new File(Environment.getExternalStorageDirectory(), "EditedOnlinePhotos");
        }
        if (!c.exists()) {
            c.mkdirs();
        }
        return c;
    }

    /* renamed from: b */
    public static Uri m9768b(Context context, Uri uri) {
        ChangeQuickRedirect changeQuickRedirect = f9264a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uri}, (Object) null, changeQuickRedirect, true, 3366, new Class[]{Context.class, Uri.class}, Uri.class);
        if (proxy.isSupported) {
            return (Uri) proxy.result;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("_yyyyMMdd_HHmmss").format(new Date(currentTimeMillis));
        File a = m9764a(context, uri);
        return m9763a(context, uri, new File(a, format + ".JPG"), currentTimeMillis, false);
    }

    /* renamed from: a */
    public static void m9766a(Context context, Uri uri, String[] strArr, C2030a aVar) {
        if (!PatchProxy.proxy(new Object[]{context, uri, strArr, aVar}, (Object) null, f9264a, true, 3367, new Class[]{Context.class, Uri.class, String[].class, C2030a.class}, Void.TYPE).isSupported) {
            m9765a(context.getContentResolver(), uri, strArr, aVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m9765a(android.content.ContentResolver r8, android.net.Uri r9, java.lang.String[] r10, com.meizu.media.camera.crop.SaveImage.C2030a r11) {
        /*
            r0 = 4
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r8
            r3 = 1
            r1[r3] = r9
            r4 = 2
            r1[r4] = r10
            r5 = 3
            r1[r5] = r11
            com.meizu.savior.ChangeQuickRedirect r6 = f9264a
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class<android.content.ContentResolver> r7 = android.content.ContentResolver.class
            r0[r2] = r7
            java.lang.Class<android.net.Uri> r2 = android.net.Uri.class
            r0[r3] = r2
            java.lang.Class<java.lang.String[]> r2 = java.lang.String[].class
            r0[r4] = r2
            java.lang.Class<com.meizu.media.camera.crop.h$a> r2 = com.meizu.media.camera.crop.SaveImage.C2030a.class
            r0[r5] = r2
            java.lang.Class r7 = java.lang.Void.TYPE
            r2 = 0
            r4 = 1
            r5 = 3368(0xd28, float:4.72E-42)
            r3 = r6
            r6 = r0
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r0.isSupported
            if (r0 == 0) goto L_0x0034
            return
        L_0x0034:
            r0 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r1 = r8
            r2 = r9
            r3 = r10
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0058, all -> 0x0050 }
            if (r8 == 0) goto L_0x004d
            boolean r9 = r8.moveToNext()     // Catch:{ Exception -> 0x0059, all -> 0x004b }
            if (r9 == 0) goto L_0x004d
            r11.mo19807a(r8)     // Catch:{ Exception -> 0x0059, all -> 0x004b }
            goto L_0x004d
        L_0x004b:
            r9 = move-exception
            goto L_0x0052
        L_0x004d:
            if (r8 == 0) goto L_0x005e
            goto L_0x005b
        L_0x0050:
            r9 = move-exception
            r8 = r0
        L_0x0052:
            if (r8 == 0) goto L_0x0057
            r8.close()
        L_0x0057:
            throw r9
        L_0x0058:
            r8 = r0
        L_0x0059:
            if (r8 == 0) goto L_0x005e
        L_0x005b:
            r8.close()
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.crop.SaveImage.m9765a(android.content.ContentResolver, android.net.Uri, java.lang.String[], com.meizu.media.camera.crop.h$a):void");
    }

    /* renamed from: c */
    private static File m9769c(Context context, Uri uri) {
        ChangeQuickRedirect changeQuickRedirect = f9264a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uri}, (Object) null, changeQuickRedirect, true, 3369, new Class[]{Context.class, Uri.class}, File.class);
        if (proxy.isSupported) {
            return (File) proxy.result;
        }
        File d = m9770d(context, uri);
        if (d != null) {
            return d.getParentFile();
        }
        return null;
    }

    /* renamed from: d */
    private static File m9770d(Context context, Uri uri) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, uri}, (Object) null, f9264a, true, 3370, new Class[]{Context.class, Uri.class}, File.class);
        if (proxy.isSupported) {
            return (File) proxy.result;
        }
        if (uri == null) {
            LogUtil.m15949b(f9265b, "srcUri is null.");
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null) {
            LogUtil.m15949b(f9265b, "scheme is null.");
            return null;
        }
        final File[] fileArr = new File[1];
        if (scheme.equals(PushConstants.CONTENT)) {
            if (uri.getAuthority().equals("media")) {
                m9766a(context, uri, new String[]{"_data"}, (C2030a) new C2030a() {

                    /* renamed from: a */
                    public static ChangeQuickRedirect f9266a;

                    /* renamed from: a */
                    public void mo19807a(Cursor cursor) {
                        if (!PatchProxy.proxy(new Object[]{cursor}, this, f9266a, false, 3379, new Class[]{Cursor.class}, Void.TYPE).isSupported) {
                            fileArr[0] = new File(cursor.getString(0));
                        }
                    }
                });
            }
        } else if (scheme.equals("file")) {
            fileArr[0] = new File(uri.getPath());
        }
        return fileArr[0];
    }

    /* renamed from: a */
    public static Uri m9763a(Context context, Uri uri, File file, long j, boolean z) {
        Object[] objArr = {context, uri, file, new Long(j), new Byte(z ? (byte) 1 : 0)};
        ChangeQuickRedirect changeQuickRedirect = f9264a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect, true, 3373, new Class[]{Context.class, Uri.class, File.class, Long.TYPE, Boolean.TYPE}, Uri.class);
        if (proxy.isSupported) {
            return (Uri) proxy.result;
        }
        File d = m9770d(context, uri);
        ContentValues a = m9762a(context, uri, file, j);
        if (m9767a(uri) || d == null || !z) {
            return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, a);
        }
        context.getContentResolver().update(uri, a, (String) null, (String[]) null);
        if (!d.exists()) {
            return uri;
        }
        d.delete();
        return uri;
    }

    /* renamed from: a */
    private static ContentValues m9762a(Context context, Uri uri, File file, long j) {
        Object[] objArr = {context, uri, file, new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f9264a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 3375, new Class[]{Context.class, Uri.class, File.class, Long.TYPE}, ContentValues.class);
        if (proxy.isSupported) {
            return (ContentValues) proxy.result;
        }
        final ContentValues contentValues = new ContentValues();
        long j2 = j / 1000;
        contentValues.put(PushConstants.TITLE, file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("datetaken", Long.valueOf(j2));
        contentValues.put("date_modified", Long.valueOf(j2));
        contentValues.put("date_added", Long.valueOf(j2));
        contentValues.put(MtkMediaStore.VideoColumns.ORIENTATION, 0);
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        m9766a(context, uri, new String[]{"datetaken", Parameters.LATITUDE, Parameters.LONGITUDE}, (C2030a) new C2030a() {

            /* renamed from: a */
            public static ChangeQuickRedirect f9268a;

            /* renamed from: a */
            public void mo19807a(Cursor cursor) {
                if (!PatchProxy.proxy(new Object[]{cursor}, this, f9268a, false, 3381, new Class[]{Cursor.class}, Void.TYPE).isSupported) {
                    contentValues.put("datetaken", Long.valueOf(cursor.getLong(0)));
                    double d = cursor.getDouble(1);
                    double d2 = cursor.getDouble(2);
                    if (d != 0.0d || d2 != 0.0d) {
                        contentValues.put(Parameters.LATITUDE, Double.valueOf(d));
                        contentValues.put(Parameters.LONGITUDE, Double.valueOf(d2));
                    }
                }
            }
        });
        return contentValues;
    }

    /* renamed from: a */
    private static boolean m9767a(Uri uri) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{uri}, (Object) null, f9264a, true, 3376, new Class[]{Uri.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        String scheme = uri.getScheme();
        return scheme != null && scheme.equals("file");
    }
}
