package com.meizu.media.camera.p068e;

import android.content.Intent;
import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.mediatek.media.MtkMediaStore;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.Exif;
import com.meizu.media.camera.p067d.ExifInterface;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.e.b */
public class FBProcessTask {

    /* renamed from: a */
    public static ChangeQuickRedirect f9904a;

    /* renamed from: b */
    public static final LogUtil.C2630a f9905b = new LogUtil.C2630a("FBProcessTask");

    /* renamed from: d */
    protected static FBProcessTask f9906d;

    /* renamed from: e */
    protected static int f9907e = 1;

    /* renamed from: f */
    public static final Object f9908f = new Object();

    /* renamed from: c */
    protected FBTaskStack f9909c = new FBTaskStack();

    /* renamed from: g */
    private volatile Looper f9910g;

    /* renamed from: h */
    private volatile C2041b f9911h;

    public FBProcessTask() {
        m10030b();
    }

    /* renamed from: b */
    private void m10030b() {
        if (!PatchProxy.proxy(new Object[0], this, f9904a, false, 4031, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f9905b, "OnCreate");
            HandlerThread handlerThread = new HandlerThread("FBProcessTask[" + System.currentTimeMillis() + "]");
            handlerThread.start();
            this.f9910g = handlerThread.getLooper();
            this.f9911h = new C2041b(this.f9910g);
        }
    }

    /* renamed from: a */
    public void mo20003a(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f9904a, false, 4032, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f9905b, UxipConstants.RESPONSE_KEY_UPLOADPOLICY_ONSTART);
            C2040a aVar = new C2040a();
            aVar.f9912a = intent;
            this.f9909c.mo20011a(aVar);
            this.f9911h.mo20004a();
            this.f9911h.sendEmptyMessage(f9907e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10032c(Intent intent) {
        Intent intent2 = intent;
        if (!PatchProxy.proxy(new Object[]{intent2}, this, f9904a, false, 4033, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            Contants.CameraService.RequestCode requestCode = (Contants.CameraService.RequestCode) intent2.getSerializableExtra("requestCode");
            UUID uuid = (UUID) intent2.getSerializableExtra("uuid");
            Location location = (Location) intent2.getParcelableExtra("location");
            int intExtra = intent2.getIntExtra("width", 0);
            int intExtra2 = intent2.getIntExtra("height", 0);
            int intExtra3 = intent2.getIntExtra("jpegRotation", 0);
            int intExtra4 = intent2.getIntExtra(MtkMediaStore.VideoColumns.ORIENTATION, 0);
            boolean booleanExtra = intent2.getBooleanExtra("mirror", false);
            boolean booleanExtra2 = intent2.getBooleanExtra("deviceMark", false);
            boolean booleanExtra3 = intent2.getBooleanExtra("isSquareMode", false);
            boolean booleanExtra4 = intent2.getBooleanExtra("isFBOn", false);
            boolean booleanExtra5 = intent2.getBooleanExtra("isStereo", false);
            String stringExtra = intent2.getStringExtra(PushConstants.TITLE);
            long longExtra = intent2.getLongExtra("date", 0);
            byte[] byteArrayExtra = intent2.getByteArrayExtra("Data");
            ExifInterface cVar = null;
            if (byteArrayExtra != null) {
                LogUtil.C2630a aVar = f9905b;
                LogUtil.m15942a(aVar, "getExif:length" + byteArrayExtra.length);
                cVar = Exif.m10044a(byteArrayExtra);
            }
            CameraOptTask.m8367a(uuid, requestCode, byteArrayExtra, stringExtra, longExtra, location, intExtra, intExtra2, intExtra4, cVar, booleanExtra, booleanExtra2, intExtra3, booleanExtra3, booleanExtra5, booleanExtra4);
            LogUtil.C2630a aVar2 = f9905b;
            LogUtil.m15942a(aVar2, "onHandleIntent:" + stringExtra);
        }
    }

    /* renamed from: b */
    public static void m10031b(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, (Object) null, f9904a, true, 4034, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            synchronized (f9908f) {
                if (f9906d == null) {
                    f9906d = new FBProcessTask();
                }
                f9906d.mo20003a(intent);
            }
        }
    }

    /* renamed from: a */
    public void mo20002a() {
        if (!PatchProxy.proxy(new Object[0], this, f9904a, false, 4035, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f9905b, "onDestroy");
            synchronized (f9908f) {
                this.f9910g.quit();
                f9906d = null;
            }
        }
    }

    /* renamed from: a */
    public static Intent m10028a(UUID uuid, Contants.CameraService.RequestCode requestCode, byte[] bArr, String str, long j, Location location, int i, int i2, int i3, ExifInterface cVar, boolean z, boolean z2, int i4, boolean z3, boolean z4, boolean z5) {
        UUID uuid2 = uuid;
        Contants.CameraService.RequestCode requestCode2 = requestCode;
        byte[] bArr2 = bArr;
        String str2 = str;
        long j2 = j;
        Location location2 = location;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        boolean z6 = z;
        boolean z7 = z2;
        int i8 = i4;
        boolean z8 = z4;
        Object[] objArr = new Object[16];
        objArr[0] = uuid2;
        objArr[1] = requestCode2;
        objArr[2] = bArr2;
        objArr[3] = str2;
        objArr[4] = new Long(j2);
        objArr[5] = location2;
        objArr[6] = new Integer(i5);
        objArr[7] = new Integer(i6);
        objArr[8] = new Integer(i7);
        objArr[9] = cVar;
        objArr[10] = new Byte(z6 ? (byte) 1 : 0);
        objArr[11] = new Byte(z7 ? (byte) 1 : 0);
        objArr[12] = new Integer(i8);
        objArr[13] = new Byte(z3 ? (byte) 1 : 0);
        Object[] objArr2 = objArr;
        objArr2[14] = new Byte(z4 ? (byte) 1 : 0);
        boolean z9 = z5;
        objArr2[15] = new Byte(z9 ? (byte) 1 : 0);
        ChangeQuickRedirect changeQuickRedirect = f9904a;
        PatchProxyResult proxy = PatchProxy.proxy(objArr2, (Object) null, changeQuickRedirect, true, 4036, new Class[]{UUID.class, Contants.CameraService.RequestCode.class, byte[].class, String.class, Long.TYPE, Location.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, ExifInterface.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent();
        intent.putExtra("uuid", uuid2);
        intent.putExtra("requestCode", requestCode2);
        intent.putExtra("Data", bArr2);
        LogUtil.C2630a aVar = f9905b;
        LogUtil.m15942a(aVar, "createFBProcessIntent:length" + bArr2.length);
        intent.putExtra(PushConstants.TITLE, str2);
        intent.putExtra("date", j2);
        intent.putExtra("location", location2);
        intent.putExtra("width", i5);
        intent.putExtra("height", i6);
        intent.putExtra(MtkMediaStore.VideoColumns.ORIENTATION, i7);
        intent.putExtra("mirror", z6);
        intent.putExtra("deviceMark", z7);
        intent.putExtra("jpegRotation", i8);
        intent.putExtra("isSquareMode", z3);
        intent.putExtra("isStereo", z4);
        intent.putExtra("isFBOn", z9);
        return intent;
    }

    /* renamed from: com.meizu.media.camera.e.b$a */
    /* compiled from: FBProcessTask */
    public class C2040a {

        /* renamed from: a */
        public Intent f9912a;

        public C2040a() {
        }
    }

    /* renamed from: com.meizu.media.camera.e.b$b */
    /* compiled from: FBProcessTask */
    private final class C2041b extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f9914a;

        /* renamed from: c */
        private volatile Handler f9916c = new Handler(this.f9917d);

        /* renamed from: d */
        private volatile Looper f9917d = Looper.getMainLooper();

        /* renamed from: e */
        private Runnable f9918e = new Runnable() {

            /* renamed from: a */
            public static ChangeQuickRedirect f9919a;

            public void run() {
                if (!PatchProxy.proxy(new Object[0], this, f9919a, false, 4039, new Class[0], Void.TYPE).isSupported) {
                    LogUtil.C2630a aVar = FBProcessTask.f9905b;
                    LogUtil.m15952c(aVar, "mRequestTasks:" + FBProcessTask.this.f9909c.mo20012b());
                    FBProcessTask.this.mo20002a();
                }
            }
        };

        public C2041b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f9914a, false, 4037, new Class[]{Message.class}, Void.TYPE).isSupported) {
                LogUtil.m15942a(FBProcessTask.f9905b, "handleMessage start");
                while (FBProcessTask.this.f9909c.mo20012b() > 0) {
                    FBProcessTask.this.m10032c(FBProcessTask.this.f9909c.mo20010a().f9912a);
                }
                LogUtil.m15942a(FBProcessTask.f9905b, "handleMessage end");
                this.f9916c.post(this.f9918e);
            }
        }

        /* renamed from: a */
        public void mo20004a() {
            if (!PatchProxy.proxy(new Object[0], this, f9914a, false, 4038, new Class[0], Void.TYPE).isSupported) {
                this.f9916c.removeCallbacks(this.f9918e);
            }
        }
    }
}
