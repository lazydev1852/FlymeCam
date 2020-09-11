package com.meizu.media.camera;

import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;
import com.meizu.media.camera.GMediaStore;
import com.meizu.media.camera.p064a.XmpMetaData;
import com.meizu.media.camera.p067d.ExifInterface;
import com.meizu.media.camera.util.BitmapUtils;
import com.meizu.media.camera.util.CameraUtil;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.io.File;
import java.util.List;

public class MediaSaveService extends Service {

    /* renamed from: a */
    public static ChangeQuickRedirect f6787a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final LogUtil.C2630a f6788b = new LogUtil.C2630a("MediaSaveService");

    /* renamed from: c */
    private IBinder f6789c = new C1638c();

    /* renamed from: d */
    private C1637b f6790d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f6791e;

    /* renamed from: com.meizu.media.camera.MediaSaveService$b */
    public interface C1637b {
        /* renamed from: b */
        void mo17842b(boolean z);
    }

    /* renamed from: com.meizu.media.camera.MediaSaveService$d */
    public interface C1639d {
        /* renamed from: a */
        void mo17844a(Uri uri);

        /* renamed from: a */
        void mo17845a(String str);

        /* renamed from: a */
        void mo17846a(String str, int i, int i2, byte[] bArr);

        /* renamed from: a */
        void mo17847a(List<String> list);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    /* renamed from: com.meizu.media.camera.MediaSaveService$c */
    public class C1638c extends Binder {
        public C1638c() {
        }

        /* renamed from: a */
        public MediaSaveService mo17843a() {
            return MediaSaveService.this;
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f6789c;
    }

    public void onDestroy() {
        this.f6790d = null;
    }

    public void onCreate() {
        this.f6791e = 0;
    }

    /* renamed from: a */
    public boolean mo17832a() {
        return this.f6791e >= 20971520;
    }

    /* renamed from: a */
    public void mo17831a(byte[] bArr, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, C1639d dVar, ContentResolver contentResolver, boolean z, XmpMetaData gVar) {
        Location location2 = location;
        if (!PatchProxy.proxy(new Object[]{bArr, str, new Long(j), location2, new Integer(i), new Integer(i2), new Integer(i3), cVar, dVar, contentResolver, new Byte(z ? (byte) 1 : 0), gVar}, this, f6787a, false, 1116, new Class[]{byte[].class, String.class, Long.TYPE, Location.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, ExifInterface.class, C1639d.class, ContentResolver.class, Boolean.TYPE, XmpMetaData.class}, Void.TYPE).isSupported) {
            if (mo17832a()) {
                LogUtil.m15956e(f6788b, "Cannot add image when the queue is full");
                return;
            }
            byte[] bArr2 = bArr;
            C1636a aVar = r0;
            C1636a aVar2 = new C1636a(bArr2, str, j, location2 == null ? null : new Location(location2), i, i2, i3, cVar, contentResolver, dVar, z, gVar);
            this.f6791e += (long) bArr2.length;
            if (mo17832a()) {
                m6624c();
            }
            aVar.execute(new Void[0]);
        }
    }

    /* renamed from: a */
    public void mo17828a(Bitmap bitmap, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, C1639d dVar, ContentResolver contentResolver, boolean z, boolean z2, String str2, boolean z3, Object... objArr) {
        Location location2 = location;
        if (!PatchProxy.proxy(new Object[]{bitmap, str, new Long(j), location2, new Integer(i), new Integer(i2), new Integer(i3), cVar, dVar, contentResolver, new Byte(z ? (byte) 1 : 0), new Byte(z2 ? (byte) 1 : 0), str2, new Byte(z3 ? (byte) 1 : 0), objArr}, this, f6787a, false, 1117, new Class[]{Bitmap.class, String.class, Long.TYPE, Location.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, ExifInterface.class, C1639d.class, ContentResolver.class, Boolean.TYPE, Boolean.TYPE, String.class, Boolean.TYPE, Object[].class}, Void.TYPE).isSupported) {
            if (mo17832a()) {
                LogUtil.m15956e(f6788b, "Cannot add image when the queue is full");
                return;
            }
            C1636a aVar = r0;
            C1636a aVar2 = new C1636a(this, bitmap, str, j, location2 == null ? null : new Location(location2), i, i2, i3, cVar, contentResolver, dVar, z, z2, str2, z3, objArr);
            if (bitmap == null) {
                LogUtil.m15956e(f6788b, "Cannot add image while data is null!");
                return;
            }
            this.f6791e += (long) bitmap.getAllocationByteCount();
            if (mo17832a()) {
                m6624c();
            }
            aVar.execute(new Void[0]);
        }
    }

    /* renamed from: a */
    public void mo17830a(String str, long j, ContentValues contentValues, C1639d dVar, ContentResolver contentResolver) {
        Object[] objArr = {str, new Long(j), contentValues, dVar, contentResolver};
        ChangeQuickRedirect changeQuickRedirect = f6787a;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect, false, 1124, new Class[]{String.class, Long.TYPE, ContentValues.class, C1639d.class, ContentResolver.class}, Void.TYPE).isSupported) {
            new C1640e(str, j, contentValues, dVar, contentResolver).execute(new Void[0]);
        }
    }

    /* renamed from: a */
    public void mo17829a(C1637b bVar) {
        if (!PatchProxy.proxy(new Object[]{bVar}, this, f6787a, false, 1125, new Class[]{C1637b.class}, Void.TYPE).isSupported) {
            this.f6790d = bVar;
            if (bVar != null) {
                bVar.mo17842b(mo17832a());
            }
        }
    }

    /* renamed from: c */
    private void m6624c() {
        if (!PatchProxy.proxy(new Object[0], this, f6787a, false, 1126, new Class[0], Void.TYPE).isSupported && this.f6790d != null) {
            this.f6790d.mo17842b(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6625d() {
        if (!PatchProxy.proxy(new Object[0], this, f6787a, false, 1127, new Class[0], Void.TYPE).isSupported && this.f6790d != null) {
            this.f6790d.mo17842b(false);
        }
    }

    /* renamed from: com.meizu.media.camera.MediaSaveService$a */
    private class C1636a extends AsyncTask<Void, Void, Uri> {

        /* renamed from: a */
        public static ChangeQuickRedirect f6792a;

        /* renamed from: c */
        private byte[] f6794c;

        /* renamed from: d */
        private Bitmap f6795d;

        /* renamed from: e */
        private String f6796e;

        /* renamed from: f */
        private long f6797f;

        /* renamed from: g */
        private Location f6798g;

        /* renamed from: h */
        private int f6799h;

        /* renamed from: i */
        private int f6800i;

        /* renamed from: j */
        private int f6801j;

        /* renamed from: k */
        private ExifInterface f6802k;

        /* renamed from: l */
        private ContentResolver f6803l;

        /* renamed from: m */
        private C1639d f6804m;

        /* renamed from: n */
        private boolean f6805n;

        /* renamed from: o */
        private boolean f6806o;

        /* renamed from: p */
        private Object[] f6807p;

        /* renamed from: q */
        private boolean f6808q;

        /* renamed from: r */
        private XmpMetaData f6809r;

        /* renamed from: s */
        private String f6810s;

        public void onPreExecute() {
        }

        public C1636a(byte[] bArr, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, ContentResolver contentResolver, C1639d dVar, boolean z, XmpMetaData gVar) {
            this.f6794c = bArr;
            this.f6796e = str;
            this.f6797f = j;
            this.f6798g = location;
            this.f6799h = i;
            this.f6800i = i2;
            this.f6801j = i3;
            this.f6802k = cVar;
            this.f6803l = contentResolver;
            this.f6804m = dVar;
            this.f6805n = z;
            this.f6809r = gVar;
        }

        public C1636a(MediaSaveService mediaSaveService, Bitmap bitmap, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, ContentResolver contentResolver, C1639d dVar, boolean z, boolean z2, String str2, boolean z3, Object... objArr) {
            MediaSaveService.this = mediaSaveService;
            this.f6795d = bitmap;
            this.f6796e = str;
            this.f6797f = j;
            this.f6798g = location;
            this.f6799h = i;
            this.f6800i = i2;
            this.f6801j = i3;
            this.f6802k = cVar;
            this.f6803l = contentResolver;
            this.f6804m = dVar;
            this.f6805n = z;
            this.f6806o = z2;
            this.f6808q = z3;
            this.f6807p = objArr;
            this.f6810s = str2;
        }

        /* renamed from: a */
        public Uri doInBackground(Void... voidArr) {
            String str;
            Uri a;
            String str2;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f6792a, false, 1130, new Class[]{Void[].class}, Uri.class);
            if (proxy.isSupported) {
                return (Uri) proxy.result;
            }
            if (this.f6799h == 0 || this.f6800i == 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(this.f6794c, 0, this.f6794c.length, options);
                this.f6799h = options.outWidth;
                this.f6800i = options.outHeight;
            }
            String a2 = Storage.m7750a().mo18626a(this.f6805n, this.f6796e);
            if (CameraOptTask.m8371a(a2)) {
                if (this.f6794c != null) {
                    a = Storage.m7750a().mo18615a(this.f6803l, this.f6796e, this.f6797f, this.f6798g, this.f6801j, this.f6802k, this.f6794c, this.f6799h, this.f6800i, this.f6805n, this.f6809r);
                    str = a2;
                } else {
                    if (this.f6808q) {
                        this.f6795d = BitmapUtils.m16140a(this.f6795d);
                    }
                    str = a2;
                    a = Storage.m7750a().mo18613a(this.f6803l, this.f6796e, this.f6797f, this.f6798g, this.f6801j, this.f6802k, this.f6795d, this.f6799h, this.f6800i, this.f6805n, this.f6806o, this.f6810s, this.f6807p);
                }
                Uri uri = a;
                if (uri != null) {
                    try {
                        str2 = str;
                        try {
                            Storage.m7750a().mo18641b(str2, ContentUris.parseId(uri));
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str2 = str;
                        LogUtil.C2630a b = MediaSaveService.f6788b;
                        LogUtil.m15949b(b, "Failed to parseId" + th);
                        CameraOptTask.m8379b(str2);
                        return uri;
                    }
                } else {
                    str2 = str;
                }
                CameraOptTask.m8379b(str2);
                return uri;
            }
            File file = new File(a2);
            if (file.exists()) {
                return Uri.fromFile(file);
            }
            return null;
        }

        /* renamed from: a */
        public void onPostExecute(Uri uri) {
            if (!PatchProxy.proxy(new Object[]{uri}, this, f6792a, false, 1131, new Class[]{Uri.class}, Void.TYPE).isSupported) {
                if (!(this.f6804m == null || uri == null)) {
                    this.f6804m.mo17844a(uri);
                    this.f6804m.mo17845a(Storage.m7750a().mo18626a(this.f6805n, this.f6796e));
                }
                boolean a = MediaSaveService.this.mo17832a();
                if (this.f6794c != null) {
                    long unused = MediaSaveService.this.f6791e = MediaSaveService.this.f6791e - ((long) this.f6794c.length);
                } else {
                    long unused2 = MediaSaveService.this.f6791e = MediaSaveService.this.f6791e - ((long) this.f6795d.getAllocationByteCount());
                }
                if (MediaSaveService.this.mo17832a() != a) {
                    MediaSaveService.this.m6625d();
                }
            }
        }
    }

    /* renamed from: com.meizu.media.camera.MediaSaveService$e */
    private class C1640e extends AsyncTask<Void, Void, Uri> {

        /* renamed from: a */
        public static ChangeQuickRedirect f6812a;

        /* renamed from: c */
        private String f6814c;

        /* renamed from: d */
        private long f6815d;

        /* renamed from: e */
        private ContentValues f6816e;

        /* renamed from: f */
        private C1639d f6817f;

        /* renamed from: g */
        private ContentResolver f6818g;

        public C1640e(String str, long j, ContentValues contentValues, C1639d dVar, ContentResolver contentResolver) {
            this.f6814c = str;
            this.f6815d = j;
            this.f6816e = new ContentValues(contentValues);
            this.f6817f = dVar;
            this.f6818g = contentResolver;
        }

        /* renamed from: a */
        public Uri doInBackground(Void... voidArr) {
            Uri uri;
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{voidArr}, this, f6812a, false, 1136, new Class[]{Void[].class}, Uri.class);
            if (proxy.isSupported) {
                return (Uri) proxy.result;
            }
            if (this.f6814c == null) {
                LogUtil.m15956e(MediaSaveService.f6788b, "video file path has been reset!");
                return null;
            } else if (!new File(this.f6814c).exists()) {
                LogUtil.m15956e(MediaSaveService.f6788b, "video file has been deleted!");
                return null;
            } else {
                this.f6816e.put("_size", Long.valueOf(new File(this.f6814c).length()));
                this.f6816e.put("duration", Long.valueOf(this.f6815d));
                try {
                    uri = this.f6818g.insert(Uri.parse("content://media/external/video/media"), this.f6816e);
                    try {
                        if (CameraUtil.m15857a(MediaSaveService.this.getApplicationContext(), "com.meizu.media.gallery", 800001000)) {
                            this.f6818g.insert(GMediaStore.C2121b.C2122a.f10397c, this.f6816e);
                        }
                        String asString = this.f6816e.getAsString("_data");
                        if (new File(this.f6814c).renameTo(new File(asString))) {
                            this.f6814c = asString;
                        }
                        this.f6818g.update(uri, this.f6816e, (String) null, (String[]) null);
                        this.f6817f.mo17845a(asString);
                        LogUtil.m15952c(MediaSaveService.f6788b, "Current video URI: " + uri);
                        return uri;
                    } catch (Exception e) {
                        e = e;
                        try {
                            LogUtil.m15950b(MediaSaveService.f6788b, "failed to add video to media store", e);
                            LogUtil.m15952c(MediaSaveService.f6788b, "Current video URI: " + null);
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            LogUtil.m15952c(MediaSaveService.f6788b, "Current video URI: " + uri);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    uri = null;
                    LogUtil.m15950b(MediaSaveService.f6788b, "failed to add video to media store", e);
                    LogUtil.m15952c(MediaSaveService.f6788b, "Current video URI: " + null);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    uri = null;
                    LogUtil.m15952c(MediaSaveService.f6788b, "Current video URI: " + uri);
                    throw th;
                }
            }
        }

        /* renamed from: a */
        public void onPostExecute(Uri uri) {
            if (!PatchProxy.proxy(new Object[]{uri}, this, f6812a, false, 1137, new Class[]{Uri.class}, Void.TYPE).isSupported && this.f6817f != null && uri != null) {
                if (!new File(this.f6814c).exists()) {
                    LogUtil.m15956e(MediaSaveService.f6788b, "video file is not existed，delete it in database");
                    Storage.m7753a(this.f6818g, uri);
                    uri = null;
                }
                this.f6817f.mo17844a(uri);
            }
        }
    }
}
