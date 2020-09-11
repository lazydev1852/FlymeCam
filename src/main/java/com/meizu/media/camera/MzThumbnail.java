package com.meizu.media.camera;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserView;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.DeviceUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* renamed from: com.meizu.media.camera.t */
public class MzThumbnail {

    /* renamed from: a */
    public static ChangeQuickRedirect f12261a;

    /* renamed from: b */
    private static final LogUtil.C2630a f12262b = new LogUtil.C2630a("MzThumbnail");

    /* renamed from: f */
    private static Object f12263f = new Object();

    /* renamed from: c */
    private Uri f12264c;

    /* renamed from: d */
    private Bitmap f12265d;

    /* renamed from: e */
    private int f12266e;

    private MzThumbnail(Uri uri, Bitmap bitmap, int i) {
        this.f12264c = uri;
        this.f12265d = m13612a(bitmap, i);
        this.f12266e = i;
    }

    /* renamed from: a */
    public Uri mo21471a() {
        return this.f12264c;
    }

    /* renamed from: a */
    public void mo21473a(Uri uri) {
        this.f12264c = uri;
    }

    /* renamed from: a */
    public void mo21472a(Bitmap bitmap) {
        synchronized (f12263f) {
            this.f12265d = bitmap;
        }
    }

    /* renamed from: b */
    public int mo21474b() {
        return this.f12266e;
    }

    /* renamed from: c */
    public Bitmap mo21475c() {
        Bitmap bitmap;
        synchronized (f12263f) {
            bitmap = this.f12265d;
        }
        return bitmap;
    }

    /* renamed from: a */
    public static MzThumbnail m13615a(Uri uri, Bitmap bitmap, int i) {
        Object[] objArr = {uri, bitmap, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f12261a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 2053, new Class[]{Uri.class, Bitmap.class, Integer.TYPE}, MzThumbnail.class);
        if (proxy.isSupported) {
            return (MzThumbnail) proxy.result;
        }
        if (bitmap != null) {
            return new MzThumbnail(uri, bitmap, i);
        }
        LogUtil.m15949b(f12262b, "Failed to create thumbnail from null bitmap");
        return null;
    }

    /* renamed from: a */
    public static void m13616a(ContentResolver contentResolver, File file) {
        if (!PatchProxy.proxy(new Object[]{contentResolver, file}, (Object) null, f12261a, true, 2054, new Class[]{ContentResolver.class, File.class}, Void.TYPE).isSupported) {
            MzThumbnail[] tVarArr = new MzThumbnail[1];
            if (m13611a(contentResolver, tVarArr, -1) != 0) {
                Uri a = tVarArr[0].mo21471a();
                Bitmap c = tVarArr[0].mo21475c();
                MzThumbnail b = m13621b(contentResolver, file);
                if (b == null || !CameraUtil.m15862a((Object) a, (Object) b.mo21471a())) {
                    LogUtil.C2630a aVar = f12262b;
                    LogUtil.m15952c(aVar, "save lastMedia uri : " + a);
                    m13617a(file, "last_thumb_file");
                    m13618a(file, "last_thumb_file", a, c);
                    return;
                }
                LogUtil.m15952c(f12262b, "save lastMedia is up-to-date");
                return;
            }
            LogUtil.m15942a(f12262b, "CR file is null");
        }
    }

    /* renamed from: a */
    public static int m13611a(ContentResolver contentResolver, MzThumbnail[] tVarArr, long j) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Object[] objArr = {contentResolver, tVarArr, new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f12261a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 2055, new Class[]{ContentResolver.class, MzThumbnail[].class, Long.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        C2376a a = m13614a(contentResolver, j);
        if (a == null || a.f12272f == null) {
            return 0;
        }
        LogUtil.C2630a aVar = f12262b;
        LogUtil.m15942a(aVar, "get thumbnail from CR uri : " + a.f12270d);
        try {
            synchronized (MzThumbnail.class) {
                if (a.f12271e) {
                    if (DeviceUtil.m16205e() < 29) {
                        bitmap2 = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, a.f12267a, 3, (BitmapFactory.Options) null);
                    } else {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 4;
                        bitmap2 = BitmapFactory.decodeFile(a.f12272f, options);
                    }
                    bitmap = CameraUtil.m15823a(bitmap2, new boolean[0]);
                } else {
                    bitmap = CameraUtil.m15823a(Thumbnail.m7941a(a.f12272f, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, new long[0]), new boolean[0]);
                }
            }
            if (CameraUtil.m15859a(a.f12270d, contentResolver)) {
                tVarArr[0] = m13615a(a.f12270d, bitmap, a.f12268b);
                if (tVarArr[0] != null) {
                    return 1;
                }
                LogUtil.m15956e(f12262b, "getLastMedia thumbnail is null, current last uri is invalid, remove it!");
                contentResolver.delete(a.f12270d, (String) null, (String[]) null);
            }
        } catch (OutOfMemoryError unused) {
            LogUtil.m15949b(f12262b, "get last from cr thumbnail OOM!!!");
        } catch (RuntimeException e) {
            LogUtil.C2630a aVar2 = f12262b;
            LogUtil.m15949b(aVar2, "get last from cr thumbnail Err" + e.getMessage());
        }
        return 0;
    }

    /* renamed from: b */
    public static int m13619b(ContentResolver contentResolver, MzThumbnail[] tVarArr, long j) {
        Object[] objArr = {contentResolver, tVarArr, new Long(j)};
        ChangeQuickRedirect changeQuickRedirect = f12261a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, (Object) null, changeQuickRedirect2, true, 2056, new Class[]{ContentResolver.class, MzThumbnail[].class, Long.TYPE}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        C2376a a = m13614a(contentResolver, j);
        if (a == null) {
            return 0;
        }
        LogUtil.C2630a aVar = f12262b;
        LogUtil.m15942a(aVar, "get thumbnail from file uri: " + a.f12270d);
        Bitmap bitmap = null;
        if (!TextUtils.isEmpty(a.f12272f)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 4;
            bitmap = CameraUtil.m15823a(BitmapFactory.decodeFile(a.f12272f, options), new boolean[0]);
        }
        try {
            if (CameraUtil.m15859a(a.f12270d, contentResolver)) {
                tVarArr[0] = m13615a(a.f12270d, bitmap, a.f12268b);
                return 1;
            }
        } catch (OutOfMemoryError unused) {
            LogUtil.m15949b(f12262b, "get last from file thumbnail OOM!!!");
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.io.DataInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.io.DataInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.io.DataInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v19, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r1v9, types: [android.graphics.Bitmap] */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007a, code lost:
        r9 = th;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007d, code lost:
        r9 = null;
        r4 = null;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r3 = r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:13:0x0044] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.meizu.media.camera.MzThumbnail m13621b(android.content.ContentResolver r9, java.io.File r10) {
        /*
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r8 = 0
            r1[r8] = r9
            r2 = 1
            r1[r2] = r10
            com.meizu.savior.ChangeQuickRedirect r3 = f12261a
            java.lang.Class[] r6 = new java.lang.Class[r0]
            java.lang.Class<android.content.ContentResolver> r0 = android.content.ContentResolver.class
            r6[r8] = r0
            java.lang.Class<java.io.File> r0 = java.io.File.class
            r6[r2] = r0
            java.lang.Class<com.meizu.media.camera.t> r7 = com.meizu.media.camera.MzThumbnail.class
            r2 = 0
            r4 = 1
            r5 = 2057(0x809, float:2.882E-42)
            com.meizu.savior.PatchProxyResult r0 = com.meizu.savior.PatchProxy.proxy(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.isSupported
            if (r1 == 0) goto L_0x0028
            java.lang.Object r9 = r0.result
            com.meizu.media.camera.t r9 = (com.meizu.media.camera.MzThumbnail) r9
            return r9
        L_0x0028:
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "last_thumb_file"
            r0.<init>(r10, r1)
            java.lang.Object r10 = f12263f
            monitor-enter(r10)
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0095, all -> 0x0090 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0095, all -> 0x0090 }
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x008a, all -> 0x0086 }
            r3 = 4096(0x1000, float:5.74E-42)
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x008a, all -> 0x0086 }
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            java.lang.String r4 = r3.readUTF()     // Catch:{ Exception -> 0x007d, all -> 0x007a }
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x007d, all -> 0x007a }
            boolean r9 = com.meizu.media.camera.util.CameraUtil.m15859a((android.net.Uri) r4, (android.content.ContentResolver) r9)     // Catch:{ Exception -> 0x0078, all -> 0x007a }
            if (r9 != 0) goto L_0x0060
            r3.close()     // Catch:{ Exception -> 0x0078, all -> 0x007a }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r2)     // Catch:{ all -> 0x00d1 }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r0)     // Catch:{ all -> 0x00d1 }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r3)     // Catch:{ all -> 0x00d1 }
            monitor-exit(r10)     // Catch:{ all -> 0x00d1 }
            return r1
        L_0x0060:
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch:{ Exception -> 0x0078, all -> 0x007a }
            boolean[] r1 = new boolean[r8]     // Catch:{ Exception -> 0x008e, all -> 0x007a }
            android.graphics.Bitmap r1 = com.meizu.media.camera.util.CameraUtil.m15823a((android.graphics.Bitmap) r9, (boolean[]) r1)     // Catch:{ Exception -> 0x008e, all -> 0x007a }
            r3.close()     // Catch:{ Exception -> 0x0078, all -> 0x007a }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r2)     // Catch:{ all -> 0x00d1 }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r0)     // Catch:{ all -> 0x00d1 }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r3)     // Catch:{ all -> 0x00d1 }
            r9 = r1
            goto L_0x00a9
        L_0x0078:
            r9 = r1
            goto L_0x008e
        L_0x007a:
            r9 = move-exception
            goto L_0x00c7
        L_0x007d:
            r9 = r1
            r4 = r9
            goto L_0x008e
        L_0x0080:
            r9 = move-exception
            r3 = r1
            goto L_0x00c7
        L_0x0083:
            r9 = r1
            r3 = r9
            goto L_0x008d
        L_0x0086:
            r9 = move-exception
            r0 = r1
            r3 = r0
            goto L_0x00c7
        L_0x008a:
            r9 = r1
            r0 = r9
            r3 = r0
        L_0x008d:
            r4 = r3
        L_0x008e:
            r1 = r2
            goto L_0x0099
        L_0x0090:
            r9 = move-exception
            r0 = r1
            r2 = r0
            r3 = r2
            goto L_0x00c7
        L_0x0095:
            r9 = r1
            r0 = r9
            r3 = r0
            r4 = r3
        L_0x0099:
            com.meizu.media.camera.util.ac$a r2 = f12262b     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = "getLastThumbnailFromCache Exception"
            com.meizu.media.camera.util.LogUtil.m15956e(r2, r5)     // Catch:{ all -> 0x00c5 }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r1)     // Catch:{ all -> 0x00d1 }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r0)     // Catch:{ all -> 0x00d1 }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r3)     // Catch:{ all -> 0x00d1 }
        L_0x00a9:
            monitor-exit(r10)     // Catch:{ all -> 0x00d1 }
            com.meizu.media.camera.util.ac$a r10 = f12262b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "get thumbnail from cache uri: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.meizu.media.camera.util.LogUtil.m15942a((com.meizu.media.camera.util.LogUtil.C2630a) r10, (java.lang.String) r0)
            com.meizu.media.camera.t r9 = m13615a((android.net.Uri) r4, (android.graphics.Bitmap) r9, (int) r8)
            return r9
        L_0x00c5:
            r9 = move-exception
            r2 = r1
        L_0x00c7:
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r2)     // Catch:{ all -> 0x00d1 }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r0)     // Catch:{ all -> 0x00d1 }
            com.meizu.media.camera.util.CameraUtil.m15853a((java.io.Closeable) r3)     // Catch:{ all -> 0x00d1 }
            throw r9     // Catch:{ all -> 0x00d1 }
        L_0x00d1:
            r9 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x00d1 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.MzThumbnail.m13621b(android.content.ContentResolver, java.io.File):com.meizu.media.camera.t");
    }

    /* renamed from: a */
    private static Bitmap m13612a(Bitmap bitmap, int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{bitmap, new Integer(i)}, (Object) null, f12261a, true, 2058, new Class[]{Bitmap.class, Integer.TYPE}, Bitmap.class);
        if (proxy.isSupported) {
            return (Bitmap) proxy.result;
        }
        if (i != 0) {
            Matrix matrix = new Matrix();
            matrix.setRotate((float) i, ((float) bitmap.getWidth()) * 0.5f, ((float) bitmap.getHeight()) * 0.5f);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (createBitmap != bitmap) {
                    bitmap.recycle();
                }
                return createBitmap;
            } catch (Throwable unused) {
                LogUtil.m15956e(f12262b, "rotateImage Exception");
            }
        }
        return bitmap;
    }

    /* renamed from: a */
    private static C2376a m13614a(ContentResolver contentResolver, long j) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{contentResolver, new Long(j)}, (Object) null, f12261a, true, 2059, new Class[]{ContentResolver.class, Long.TYPE}, C2376a.class);
        if (proxy.isSupported) {
            return (C2376a) proxy.result;
        }
        C2376a b = m13620b(contentResolver, j);
        C2376a c = m13622c(contentResolver, j);
        if (b == null && c == null) {
            return null;
        }
        return (b == null || c == null) ? b != null ? b : c : b.f12269c > c.f12269c ? b : c;
    }

    /* renamed from: a */
    public static Uri m13613a(ContentResolver contentResolver) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{contentResolver}, (Object) null, f12261a, true, 2060, new Class[]{ContentResolver.class}, Uri.class);
        if (proxy.isSupported) {
            return (Uri) proxy.result;
        }
        C2376a a = m13614a(contentResolver, -1);
        if (a != null) {
            return a.f12270d;
        }
        return null;
    }

    /* renamed from: com.meizu.media.camera.t$a */
    /* compiled from: MzThumbnail */
    private static class C2376a {

        /* renamed from: a */
        public final long f12267a;

        /* renamed from: b */
        public final int f12268b;

        /* renamed from: c */
        public final long f12269c;

        /* renamed from: d */
        public final Uri f12270d;

        /* renamed from: e */
        public final boolean f12271e;

        /* renamed from: f */
        public final String f12272f;

        public C2376a(long j, int i, long j2, Uri uri, boolean z, String str) {
            this.f12267a = j;
            this.f12268b = i;
            this.f12269c = j2;
            this.f12270d = uri;
            this.f12271e = z;
            this.f12272f = str;
        }
    }

    /* renamed from: a */
    public static void m13617a(File file, String str) {
        Class[] clsArr = {File.class, String.class};
        if (!PatchProxy.proxy(new Object[]{file, str}, (Object) null, f12261a, true, 2061, clsArr, Void.TYPE).isSupported) {
            File file2 = new File(file, str);
            if (file2.exists()) {
                file2.delete();
            }
        }
    }

    /* renamed from: a */
    private static void m13618a(File file, String str, Uri uri, Bitmap bitmap) {
        DataOutputStream dataOutputStream;
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        if (!PatchProxy.proxy(new Object[]{file, str, uri, bitmap}, (Object) null, f12261a, true, 2062, new Class[]{File.class, String.class, Uri.class, Bitmap.class}, Void.TYPE).isSupported && bitmap != null && uri != null) {
            File file2 = new File(file, str);
            synchronized (f12263f) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 4096);
                    } catch (Exception unused) {
                        bufferedOutputStream = null;
                        dataOutputStream = null;
                        fileOutputStream2 = fileOutputStream;
                        try {
                            LogUtil.m15949b(f12262b, "saveBmpInFile Exception");
                            CameraUtil.m15853a((Closeable) fileOutputStream2);
                            CameraUtil.m15853a((Closeable) bufferedOutputStream);
                            CameraUtil.m15853a((Closeable) dataOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            CameraUtil.m15853a((Closeable) fileOutputStream);
                            CameraUtil.m15853a((Closeable) bufferedOutputStream);
                            CameraUtil.m15853a((Closeable) dataOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = null;
                        dataOutputStream = null;
                        CameraUtil.m15853a((Closeable) fileOutputStream);
                        CameraUtil.m15853a((Closeable) bufferedOutputStream);
                        CameraUtil.m15853a((Closeable) dataOutputStream);
                        throw th;
                    }
                    try {
                        dataOutputStream = new DataOutputStream(bufferedOutputStream);
                    } catch (Exception unused2) {
                        dataOutputStream = null;
                        fileOutputStream2 = fileOutputStream;
                        LogUtil.m15949b(f12262b, "saveBmpInFile Exception");
                        CameraUtil.m15853a((Closeable) fileOutputStream2);
                        CameraUtil.m15853a((Closeable) bufferedOutputStream);
                        CameraUtil.m15853a((Closeable) dataOutputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        dataOutputStream = null;
                        CameraUtil.m15853a((Closeable) fileOutputStream);
                        CameraUtil.m15853a((Closeable) bufferedOutputStream);
                        CameraUtil.m15853a((Closeable) dataOutputStream);
                        throw th;
                    }
                    try {
                        dataOutputStream.writeUTF(uri.toString());
                        if (!bitmap.isRecycled()) {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, dataOutputStream);
                        }
                        dataOutputStream.close();
                        CameraUtil.m15853a((Closeable) fileOutputStream);
                        CameraUtil.m15853a((Closeable) bufferedOutputStream);
                    } catch (Exception unused3) {
                        fileOutputStream2 = fileOutputStream;
                        LogUtil.m15949b(f12262b, "saveBmpInFile Exception");
                        CameraUtil.m15853a((Closeable) fileOutputStream2);
                        CameraUtil.m15853a((Closeable) bufferedOutputStream);
                        CameraUtil.m15853a((Closeable) dataOutputStream);
                    } catch (Throwable th4) {
                        th = th4;
                        CameraUtil.m15853a((Closeable) fileOutputStream);
                        CameraUtil.m15853a((Closeable) bufferedOutputStream);
                        CameraUtil.m15853a((Closeable) dataOutputStream);
                        throw th;
                    }
                } catch (Exception unused4) {
                    bufferedOutputStream = null;
                    dataOutputStream = null;
                    LogUtil.m15949b(f12262b, "saveBmpInFile Exception");
                    CameraUtil.m15853a((Closeable) fileOutputStream2);
                    CameraUtil.m15853a((Closeable) bufferedOutputStream);
                    CameraUtil.m15853a((Closeable) dataOutputStream);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = null;
                    fileOutputStream = null;
                    dataOutputStream = null;
                    CameraUtil.m15853a((Closeable) fileOutputStream);
                    CameraUtil.m15853a((Closeable) bufferedOutputStream);
                    CameraUtil.m15853a((Closeable) dataOutputStream);
                    throw th;
                }
                CameraUtil.m15853a((Closeable) dataOutputStream);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:38|39) */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0280, code lost:
        if (r4 != null) goto L_0x0282;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0282, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        com.meizu.media.camera.util.LogUtil.m15949b(f12262b, "getLastPictureMedia Exception");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0291, code lost:
        if (r4 == null) goto L_0x0294;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0294, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0295, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0298, code lost:
        r4.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x028a */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0298  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.meizu.media.camera.MzThumbnail.C2376a m13620b(android.content.ContentResolver r24, long r25) {
        /*
            r0 = r25
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r10 = 0
            r3[r10] = r24
            java.lang.Long r4 = new java.lang.Long
            r4.<init>(r0)
            r11 = 1
            r3[r11] = r4
            com.meizu.savior.ChangeQuickRedirect r5 = f12261a
            java.lang.Class[] r8 = new java.lang.Class[r2]
            java.lang.Class<android.content.ContentResolver> r4 = android.content.ContentResolver.class
            r8[r10] = r4
            java.lang.Class r4 = java.lang.Long.TYPE
            r8[r11] = r4
            java.lang.Class<com.meizu.media.camera.t$a> r9 = com.meizu.media.camera.MzThumbnail.C2376a.class
            r4 = 0
            r6 = 1
            r7 = 2063(0x80f, float:2.891E-42)
            com.meizu.savior.PatchProxyResult r3 = com.meizu.savior.PatchProxy.proxy(r3, r4, r5, r6, r7, r8, r9)
            boolean r4 = r3.isSupported
            if (r4 == 0) goto L_0x002f
            java.lang.Object r0 = r3.result
            com.meizu.media.camera.t$a r0 = (com.meizu.media.camera.MzThumbnail.C2376a) r0
            return r0
        L_0x002f:
            android.net.Uri r3 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            android.net.Uri$Builder r4 = r3.buildUpon()
            java.lang.String r5 = "limit"
            java.lang.String r6 = "1"
            android.net.Uri$Builder r4 = r4.appendQueryParameter(r5, r6)
            android.net.Uri r12 = r4.build()
            java.lang.String r4 = "_id"
            java.lang.String r5 = "orientation"
            java.lang.String r6 = "datetaken"
            java.lang.String r7 = "_data"
            java.lang.String r8 = "bucket_id"
            java.lang.String[] r13 = new java.lang.String[]{r4, r5, r6, r7, r8}
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "(description IS NULL OR description NOT IN ('glr_dlt', 'glr_dlt_sub')) AND ( mime_type='image/gif' OR mime_type='image/jpeg') AND (bucket_id="
            r4.append(r5)
            java.lang.String r5 = com.meizu.media.camera.Storage.m7751a((boolean) r11)
            r4.append(r5)
            java.lang.String r5 = " OR "
            r4.append(r5)
            java.lang.String r5 = "bucket_id"
            r4.append(r5)
            r5 = 61
            r4.append(r5)
            java.lang.String r5 = com.meizu.media.camera.Storage.m7751a((boolean) r10)
            r4.append(r5)
            java.lang.String r5 = " OR "
            r4.append(r5)
            java.lang.String r5 = "_data"
            r4.append(r5)
            java.lang.String r5 = " LIKE '"
            r4.append(r5)
            com.meizu.media.camera.Storage$DIRECTION r5 = com.meizu.media.camera.Storage.DIRECTION.SELFIE
            java.lang.String r5 = com.meizu.media.camera.Storage.m7752a((boolean) r11, (com.meizu.media.camera.Storage.DIRECTION) r5)
            r4.append(r5)
            java.lang.String r5 = "%' OR "
            r4.append(r5)
            java.lang.String r5 = "_data"
            r4.append(r5)
            java.lang.String r5 = " LIKE '"
            r4.append(r5)
            com.meizu.media.camera.Storage$DIRECTION r5 = com.meizu.media.camera.Storage.DIRECTION.SELFIE
            java.lang.String r5 = com.meizu.media.camera.Storage.m7752a((boolean) r10, (com.meizu.media.camera.Storage.DIRECTION) r5)
            r4.append(r5)
            java.lang.String r5 = "%' OR "
            r4.append(r5)
            java.lang.String r5 = "_data"
            r4.append(r5)
            java.lang.String r5 = " LIKE '"
            r4.append(r5)
            com.meizu.media.camera.Storage$DIRECTION r5 = com.meizu.media.camera.Storage.DIRECTION.PANORAMA
            java.lang.String r5 = com.meizu.media.camera.Storage.m7752a((boolean) r11, (com.meizu.media.camera.Storage.DIRECTION) r5)
            r4.append(r5)
            java.lang.String r5 = "%' OR "
            r4.append(r5)
            java.lang.String r5 = "_data"
            r4.append(r5)
            java.lang.String r5 = " LIKE '"
            r4.append(r5)
            com.meizu.media.camera.Storage$DIRECTION r5 = com.meizu.media.camera.Storage.DIRECTION.PANORAMA
            java.lang.String r5 = com.meizu.media.camera.Storage.m7752a((boolean) r10, (com.meizu.media.camera.Storage.DIRECTION) r5)
            r4.append(r5)
            java.lang.String r5 = "%' OR "
            r4.append(r5)
            java.lang.String r5 = "_data"
            r4.append(r5)
            java.lang.String r5 = " LIKE '"
            r4.append(r5)
            com.meizu.media.camera.Storage$DIRECTION r5 = com.meizu.media.camera.Storage.DIRECTION.BURST
            java.lang.String r5 = com.meizu.media.camera.Storage.m7752a((boolean) r11, (com.meizu.media.camera.Storage.DIRECTION) r5)
            r4.append(r5)
            java.lang.String r5 = "%' OR "
            r4.append(r5)
            java.lang.String r5 = "_data"
            r4.append(r5)
            java.lang.String r5 = " LIKE '"
            r4.append(r5)
            com.meizu.media.camera.Storage$DIRECTION r5 = com.meizu.media.camera.Storage.DIRECTION.BURST
            java.lang.String r5 = com.meizu.media.camera.Storage.m7752a((boolean) r10, (com.meizu.media.camera.Storage.DIRECTION) r5)
            r4.append(r5)
            java.lang.String r5 = "%' OR "
            r4.append(r5)
            java.lang.String r5 = "_data"
            r4.append(r5)
            java.lang.String r5 = " LIKE '"
            r4.append(r5)
            com.meizu.media.camera.Storage$DIRECTION r5 = com.meizu.media.camera.Storage.DIRECTION.BACKTRACE
            java.lang.String r5 = com.meizu.media.camera.Storage.m7752a((boolean) r11, (com.meizu.media.camera.Storage.DIRECTION) r5)
            r4.append(r5)
            java.lang.String r5 = "%' OR "
            r4.append(r5)
            java.lang.String r5 = "_data"
            r4.append(r5)
            java.lang.String r5 = " LIKE '"
            r4.append(r5)
            com.meizu.media.camera.Storage$DIRECTION r5 = com.meizu.media.camera.Storage.DIRECTION.BACKTRACE
            java.lang.String r5 = com.meizu.media.camera.Storage.m7752a((boolean) r10, (com.meizu.media.camera.Storage.DIRECTION) r5)
            r4.append(r5)
            java.lang.String r5 = "%' OR "
            r4.append(r5)
            java.lang.String r5 = "_data"
            r4.append(r5)
            java.lang.String r5 = " LIKE '"
            r4.append(r5)
            com.meizu.media.camera.Storage$DIRECTION r5 = com.meizu.media.camera.Storage.DIRECTION.AR
            java.lang.String r5 = com.meizu.media.camera.Storage.m7752a((boolean) r11, (com.meizu.media.camera.Storage.DIRECTION) r5)
            r4.append(r5)
            java.lang.String r5 = "%' OR "
            r4.append(r5)
            java.lang.String r5 = "_data"
            r4.append(r5)
            java.lang.String r5 = " LIKE '"
            r4.append(r5)
            com.meizu.media.camera.Storage$DIRECTION r5 = com.meizu.media.camera.Storage.DIRECTION.AR
            java.lang.String r5 = com.meizu.media.camera.Storage.m7752a((boolean) r10, (com.meizu.media.camera.Storage.DIRECTION) r5)
            r4.append(r5)
            java.lang.String r5 = "%' OR "
            r4.append(r5)
            java.lang.String r5 = "_data"
            r4.append(r5)
            java.lang.String r5 = " LIKE '"
            r4.append(r5)
            com.meizu.media.camera.Storage$DIRECTION r5 = com.meizu.media.camera.Storage.DIRECTION.DOCUMENTS
            java.lang.String r5 = com.meizu.media.camera.Storage.m7752a((boolean) r11, (com.meizu.media.camera.Storage.DIRECTION) r5)
            r4.append(r5)
            java.lang.String r5 = "%' OR "
            r4.append(r5)
            java.lang.String r5 = "_data"
            r4.append(r5)
            java.lang.String r5 = " LIKE '"
            r4.append(r5)
            com.meizu.media.camera.Storage$DIRECTION r5 = com.meizu.media.camera.Storage.DIRECTION.DOCUMENTS
            java.lang.String r5 = com.meizu.media.camera.Storage.m7752a((boolean) r10, (com.meizu.media.camera.Storage.DIRECTION) r5)
            r4.append(r5)
            java.lang.String r5 = "%' OR "
            r4.append(r5)
            java.lang.String r5 = "_data"
            r4.append(r5)
            java.lang.String r5 = " LIKE '"
            r4.append(r5)
            com.meizu.media.camera.Storage$DIRECTION r5 = com.meizu.media.camera.Storage.DIRECTION.REFOCUS
            java.lang.String r5 = com.meizu.media.camera.Storage.m7752a((boolean) r11, (com.meizu.media.camera.Storage.DIRECTION) r5)
            r4.append(r5)
            java.lang.String r5 = "%' OR "
            r4.append(r5)
            java.lang.String r5 = "_data"
            r4.append(r5)
            java.lang.String r5 = " LIKE '"
            r4.append(r5)
            com.meizu.media.camera.Storage$DIRECTION r5 = com.meizu.media.camera.Storage.DIRECTION.REFOCUS
            java.lang.String r5 = com.meizu.media.camera.Storage.m7752a((boolean) r10, (com.meizu.media.camera.Storage.DIRECTION) r5)
            r4.append(r5)
            java.lang.String r5 = "%')"
            r4.append(r5)
            r5 = -1
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x01d4
            java.lang.String r0 = ""
            goto L_0x01ea
        L_0x01d4:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = " AND (datetaken>="
            r5.append(r6)
            r5.append(r0)
            java.lang.String r0 = ")"
            r5.append(r0)
            java.lang.String r0 = r5.toString()
        L_0x01ea:
            r4.append(r0)
            java.lang.String r7 = r4.toString()
            java.lang.String r9 = "datetaken DESC,_id DESC"
            r8 = 0
            r1 = 0
            r4 = r24
            r5 = r12
            r6 = r13
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0289, all -> 0x0286 }
            if (r4 == 0) goto L_0x0280
            boolean r0 = r4.moveToFirst()     // Catch:{ Exception -> 0x028a }
            if (r0 == 0) goto L_0x0280
            long r5 = r4.getLong(r10)     // Catch:{ Exception -> 0x028a }
            r0 = 4
            java.lang.String r0 = r4.getString(r0)     // Catch:{ Exception -> 0x028a }
            r14 = 3
            java.lang.String r7 = r4.getString(r14)     // Catch:{ Exception -> 0x028a }
            com.meizu.media.camera.Storage$DIRECTION r8 = com.meizu.media.camera.Storage.DIRECTION.BURST     // Catch:{ Exception -> 0x028a }
            java.lang.String r8 = com.meizu.media.camera.Storage.m7752a((boolean) r10, (com.meizu.media.camera.Storage.DIRECTION) r8)     // Catch:{ Exception -> 0x028a }
            boolean r8 = r7.contains(r8)     // Catch:{ Exception -> 0x028a }
            if (r8 != 0) goto L_0x022b
            com.meizu.media.camera.Storage$DIRECTION r8 = com.meizu.media.camera.Storage.DIRECTION.BURST     // Catch:{ Exception -> 0x028a }
            java.lang.String r8 = com.meizu.media.camera.Storage.m7752a((boolean) r11, (com.meizu.media.camera.Storage.DIRECTION) r8)     // Catch:{ Exception -> 0x028a }
            boolean r7 = r7.contains(r8)     // Catch:{ Exception -> 0x028a }
            if (r7 == 0) goto L_0x025e
        L_0x022b:
            r4.close()     // Catch:{ Exception -> 0x028a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0289, all -> 0x0286 }
            r4.<init>()     // Catch:{ Exception -> 0x0289, all -> 0x0286 }
            java.lang.String r5 = "(description IS NULL OR description NOT IN ('glr_dlt', 'glr_dlt_sub')) AND ( mime_type='image/gif' OR mime_type='image/jpeg') AND (bucket_id="
            r4.append(r5)     // Catch:{ Exception -> 0x0289, all -> 0x0286 }
            r4.append(r0)     // Catch:{ Exception -> 0x0289, all -> 0x0286 }
            java.lang.String r0 = ")"
            r4.append(r0)     // Catch:{ Exception -> 0x0289, all -> 0x0286 }
            java.lang.String r7 = r4.toString()     // Catch:{ Exception -> 0x0289, all -> 0x0286 }
            java.lang.String r9 = "datetaken,_id"
            r8 = 0
            r4 = r24
            r5 = r12
            r6 = r13
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0289, all -> 0x0286 }
            if (r4 != 0) goto L_0x0257
            if (r4 == 0) goto L_0x0256
            r4.close()
        L_0x0256:
            return r1
        L_0x0257:
            r4.moveToFirst()     // Catch:{ Exception -> 0x028a }
            long r5 = r4.getLong(r10)     // Catch:{ Exception -> 0x028a }
        L_0x025e:
            com.meizu.media.camera.t$a r0 = new com.meizu.media.camera.t$a     // Catch:{ Exception -> 0x028a }
            long r16 = r4.getLong(r10)     // Catch:{ Exception -> 0x028a }
            int r18 = r4.getInt(r11)     // Catch:{ Exception -> 0x028a }
            long r19 = r4.getLong(r2)     // Catch:{ Exception -> 0x028a }
            android.net.Uri r21 = android.content.ContentUris.withAppendedId(r3, r5)     // Catch:{ Exception -> 0x028a }
            r22 = 1
            java.lang.String r23 = r4.getString(r14)     // Catch:{ Exception -> 0x028a }
            r15 = r0
            r15.<init>(r16, r18, r19, r21, r22, r23)     // Catch:{ Exception -> 0x028a }
            if (r4 == 0) goto L_0x027f
            r4.close()
        L_0x027f:
            return r0
        L_0x0280:
            if (r4 == 0) goto L_0x0294
        L_0x0282:
            r4.close()
            goto L_0x0294
        L_0x0286:
            r0 = move-exception
            r4 = r1
            goto L_0x0296
        L_0x0289:
            r4 = r1
        L_0x028a:
            com.meizu.media.camera.util.ac$a r0 = f12262b     // Catch:{ all -> 0x0295 }
            java.lang.String r2 = "getLastPictureMedia Exception"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r2)     // Catch:{ all -> 0x0295 }
            if (r4 == 0) goto L_0x0294
            goto L_0x0282
        L_0x0294:
            return r1
        L_0x0295:
            r0 = move-exception
        L_0x0296:
            if (r4 == 0) goto L_0x029b
            r4.close()
        L_0x029b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.MzThumbnail.m13620b(android.content.ContentResolver, long):com.meizu.media.camera.t$a");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:25|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00f9, code lost:
        if (r4 != null) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00fb, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        com.meizu.media.camera.util.LogUtil.m15949b(f12262b, "getLastRecordMedia Exception");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x010a, code lost:
        if (r4 == null) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x010d, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x010e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0103 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0111  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.meizu.media.camera.MzThumbnail.C2376a m13622c(android.content.ContentResolver r20, long r21) {
        /*
            r0 = r21
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r10 = 0
            r3[r10] = r20
            java.lang.Long r4 = new java.lang.Long
            r4.<init>(r0)
            r12 = 1
            r3[r12] = r4
            com.meizu.savior.ChangeQuickRedirect r5 = f12261a
            java.lang.Class[] r8 = new java.lang.Class[r2]
            java.lang.Class<android.content.ContentResolver> r4 = android.content.ContentResolver.class
            r8[r10] = r4
            java.lang.Class r4 = java.lang.Long.TYPE
            r8[r12] = r4
            java.lang.Class<com.meizu.media.camera.t$a> r9 = com.meizu.media.camera.MzThumbnail.C2376a.class
            r4 = 0
            r6 = 1
            r7 = 2064(0x810, float:2.892E-42)
            com.meizu.savior.PatchProxyResult r3 = com.meizu.savior.PatchProxy.proxy(r3, r4, r5, r6, r7, r8, r9)
            boolean r4 = r3.isSupported
            if (r4 == 0) goto L_0x002f
            java.lang.Object r0 = r3.result
            com.meizu.media.camera.t$a r0 = (com.meizu.media.camera.MzThumbnail.C2376a) r0
            return r0
        L_0x002f:
            android.net.Uri r3 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            android.net.Uri$Builder r4 = r3.buildUpon()
            java.lang.String r5 = "limit"
            java.lang.String r6 = "1"
            android.net.Uri$Builder r4 = r4.appendQueryParameter(r5, r6)
            android.net.Uri r5 = r4.build()
            java.lang.String r4 = "_id"
            java.lang.String r6 = "_data"
            java.lang.String r7 = "datetaken"
            java.lang.String r8 = "_data"
            java.lang.String[] r6 = new java.lang.String[]{r4, r6, r7, r8}
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = "(description IS NULL OR description NOT IN ('glr_dlt', 'glr_dlt_sub')) AND (bucket_id="
            r4.append(r7)
            java.lang.String r7 = com.meizu.media.camera.Storage.m7758b((boolean) r12)
            r4.append(r7)
            java.lang.String r7 = " OR "
            r4.append(r7)
            java.lang.String r7 = "bucket_id"
            r4.append(r7)
            r7 = 61
            r4.append(r7)
            java.lang.String r8 = com.meizu.media.camera.Storage.m7758b((boolean) r10)
            r4.append(r8)
            java.lang.String r8 = " OR "
            r4.append(r8)
            java.lang.String r8 = "bucket_id"
            r4.append(r8)
            r4.append(r7)
            java.lang.String r8 = com.meizu.media.camera.Storage.m7759c((boolean) r12)
            r4.append(r8)
            java.lang.String r8 = " OR "
            r4.append(r8)
            java.lang.String r8 = "bucket_id"
            r4.append(r8)
            r4.append(r7)
            java.lang.String r7 = com.meizu.media.camera.Storage.m7759c((boolean) r10)
            r4.append(r7)
            java.lang.String r7 = ")"
            r4.append(r7)
            r7 = -1
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x00aa
            java.lang.String r0 = ""
            goto L_0x00c0
        L_0x00aa:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = " AND (datetaken>="
            r7.append(r8)
            r7.append(r0)
            java.lang.String r0 = ")"
            r7.append(r0)
            java.lang.String r0 = r7.toString()
        L_0x00c0:
            r4.append(r0)
            java.lang.String r7 = r4.toString()
            java.lang.String r9 = "datetaken DESC,_id DESC"
            r8 = 0
            r1 = 0
            r4 = r20
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0102, all -> 0x00ff }
            if (r4 == 0) goto L_0x00f9
            boolean r0 = r4.moveToFirst()     // Catch:{ Exception -> 0x0103 }
            if (r0 == 0) goto L_0x00f9
            long r12 = r4.getLong(r10)     // Catch:{ Exception -> 0x0103 }
            com.meizu.media.camera.t$a r0 = new com.meizu.media.camera.t$a     // Catch:{ Exception -> 0x0103 }
            r14 = 0
            long r15 = r4.getLong(r2)     // Catch:{ Exception -> 0x0103 }
            android.net.Uri r17 = android.content.ContentUris.withAppendedId(r3, r12)     // Catch:{ Exception -> 0x0103 }
            r18 = 0
            r2 = 3
            java.lang.String r19 = r4.getString(r2)     // Catch:{ Exception -> 0x0103 }
            r11 = r0
            r11.<init>(r12, r14, r15, r17, r18, r19)     // Catch:{ Exception -> 0x0103 }
            if (r4 == 0) goto L_0x00f8
            r4.close()
        L_0x00f8:
            return r0
        L_0x00f9:
            if (r4 == 0) goto L_0x010d
        L_0x00fb:
            r4.close()
            goto L_0x010d
        L_0x00ff:
            r0 = move-exception
            r4 = r1
            goto L_0x010f
        L_0x0102:
            r4 = r1
        L_0x0103:
            com.meizu.media.camera.util.ac$a r0 = f12262b     // Catch:{ all -> 0x010e }
            java.lang.String r2 = "getLastRecordMedia Exception"
            com.meizu.media.camera.util.LogUtil.m15949b((com.meizu.media.camera.util.LogUtil.C2630a) r0, (java.lang.String) r2)     // Catch:{ all -> 0x010e }
            if (r4 == 0) goto L_0x010d
            goto L_0x00fb
        L_0x010d:
            return r1
        L_0x010e:
            r0 = move-exception
        L_0x010f:
            if (r4 == 0) goto L_0x0114
            r4.close()
        L_0x0114:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.media.camera.MzThumbnail.m13622c(android.content.ContentResolver, long):com.meizu.media.camera.t$a");
    }
}
