package com.meizu.media.camera.singlebokeh;

import android.content.Intent;
import android.graphics.Rect;
import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.media.camera.CameraOptTask;
import com.meizu.media.camera.p064a.CaptureResultData;
import com.meizu.media.camera.p064a.ParamData;
import com.meizu.media.camera.p064a.XmpMetaData;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import com.meizu.statsapp.p081v3.lib.plugin.constants.UxipConstants;
import java.util.UUID;

/* renamed from: com.meizu.media.camera.singlebokeh.a */
public class BokehProcessTask {

    /* renamed from: a */
    public static ChangeQuickRedirect f12172a;

    /* renamed from: b */
    public static final LogUtil.C2630a f12173b = new LogUtil.C2630a("FBProcessTask");

    /* renamed from: d */
    protected static BokehProcessTask f12174d;

    /* renamed from: e */
    public static final Object f12175e = new Object();

    /* renamed from: c */
    protected BokehTaskStack f12176c = new BokehTaskStack();

    /* renamed from: f */
    private volatile Looper f12177f;

    /* renamed from: g */
    private volatile C2363b f12178g;

    public BokehProcessTask() {
        m13564b();
    }

    /* renamed from: b */
    private void m13564b() {
        if (!PatchProxy.proxy(new Object[0], this, f12172a, false, 6214, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f12173b, "OnCreate");
            HandlerThread handlerThread = new HandlerThread("BokehProcessTask[" + System.currentTimeMillis() + "]");
            handlerThread.start();
            this.f12177f = handlerThread.getLooper();
            this.f12178g = new C2363b(this.f12177f);
        }
    }

    /* renamed from: a */
    public void mo21425a(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, this, f12172a, false, 6215, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            LogUtil.m15942a(f12173b, UxipConstants.RESPONSE_KEY_UPLOADPOLICY_ONSTART);
            C2362a aVar = new C2362a();
            aVar.mo21427a(intent);
            this.f12176c.mo21432a(aVar);
            this.f12178g.mo21428a();
            this.f12178g.sendEmptyMessage(1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m13566c(Intent intent) {
        Intent intent2 = intent;
        if (!PatchProxy.proxy(new Object[]{intent2}, this, f12172a, false, 6216, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            UUID uuid = (UUID) intent2.getSerializableExtra("uuid");
            int intExtra = intent2.getIntExtra("width", 0);
            int intExtra2 = intent2.getIntExtra("height", 0);
            int intExtra3 = intent2.getIntExtra("jpegRotation", 0);
            boolean booleanExtra = intent2.getBooleanExtra("mirror", false);
            String stringExtra = intent2.getStringExtra(PushConstants.TITLE);
            long longExtra = intent2.getLongExtra("date", 0);
            byte[] byteArrayExtra = intent2.getByteArrayExtra("Data");
            int intExtra4 = intent2.getIntExtra("rowstrite", 0);
            XmpMetaData gVar = (XmpMetaData) intent2.getSerializableExtra("xmpmetadata");
            CaptureResultData bVar = (CaptureResultData) intent2.getSerializableExtra("captureresult");
            int intExtra5 = intent2.getIntExtra("bokehorientation", 0);
            boolean booleanExtra2 = intent2.getBooleanExtra("deviceMark", false);
            boolean booleanExtra3 = intent2.getBooleanExtra("needTimeMark", false);
            String stringExtra2 = intent2.getStringExtra("timedata");
            boolean booleanExtra4 = intent2.getBooleanExtra("frontFlash", false);
            boolean booleanExtra5 = intent2.getBooleanExtra("needFastThumbnail", false);
            CameraOptTask.m8350a(new ParamData(uuid, (Contants.CameraService.RequestCode) intent2.getSerializableExtra("requestCode")).mo18733a(byteArrayExtra).mo18731a(stringExtra).mo18724a(longExtra).mo18727a((Location) intent2.getParcelableExtra("location")).mo18734b(intExtra).mo18737c(intExtra2).mo18732a(booleanExtra).mo18740d(intExtra3).mo18743e(intExtra4).mo18725a((Rect) intent2.getParcelableExtra("croprect")).mo18726a(bVar.mo18718a()).mo18730a(gVar).mo18745f(intExtra5).mo18736b(booleanExtra2).mo18747g(booleanExtra3).mo18735b(stringExtra2).mo18738c(intent2.getStringExtra("deviceMarkData")).mo18750j(booleanExtra4).mo18748h(booleanExtra5));
            LogUtil.C2630a aVar = f12173b;
            LogUtil.m15942a(aVar, "onHandleIntent:" + stringExtra);
        }
    }

    /* renamed from: b */
    public static void m13565b(Intent intent) {
        if (!PatchProxy.proxy(new Object[]{intent}, (Object) null, f12172a, true, 6217, new Class[]{Intent.class}, Void.TYPE).isSupported) {
            synchronized (f12175e) {
                if (f12174d == null) {
                    f12174d = new BokehProcessTask();
                }
                f12174d.mo21425a(intent);
            }
        }
    }

    /* renamed from: a */
    public void mo21424a() {
        if (!PatchProxy.proxy(new Object[0], this, f12172a, false, 6218, new Class[0], Void.TYPE).isSupported) {
            LogUtil.m15942a(f12173b, "onDestroy");
            synchronized (f12175e) {
                this.f12177f.quit();
                f12174d = null;
            }
        }
    }

    /* renamed from: a */
    public static Intent m13562a(ParamData fVar) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{fVar}, (Object) null, f12172a, true, 6219, new Class[]{ParamData.class}, Intent.class);
        if (proxy.isSupported) {
            return (Intent) proxy.result;
        }
        Intent intent = new Intent();
        intent.putExtra("uuid", fVar.f7464a);
        intent.putExtra("requestCode", fVar.f7471h);
        intent.putExtra("Data", fVar.f7469f);
        LogUtil.C2630a aVar = f12173b;
        LogUtil.m15942a(aVar, "createBokehProcessIntent:length" + fVar.f7469f.length);
        intent.putExtra(PushConstants.TITLE, fVar.f7465b);
        intent.putExtra("date", fVar.f7466c);
        intent.putExtra("location", fVar.f7468e);
        intent.putExtra("width", fVar.f7472i);
        intent.putExtra("height", fVar.f7473j);
        intent.putExtra("mirror", fVar.f7474k);
        intent.putExtra("jpegRotation", fVar.f7477n);
        intent.putExtra("rowstrite", fVar.f7478o);
        intent.putExtra("croprect", fVar.f7479p);
        if (fVar.f7485v != null) {
            intent.putExtra("captureresult", fVar.f7485v);
        }
        intent.putExtra("xmpmetadata", fVar.f7484u);
        intent.putExtra("bokehorientation", fVar.f7486w);
        intent.putExtra("deviceMark", fVar.f7475l);
        intent.putExtra("needTimeMark", fVar.f7487x);
        intent.putExtra("timedata", fVar.f7489z);
        intent.putExtra("deviceMarkData", fVar.f7459A);
        intent.putExtra("frontFlash", fVar.f7462D);
        intent.putExtra("needFastThumbnail", fVar.f7488y);
        return intent;
    }

    /* renamed from: com.meizu.media.camera.singlebokeh.a$a */
    /* compiled from: BokehProcessTask */
    public class C2362a {

        /* renamed from: b */
        private Intent f12180b;

        public C2362a() {
        }

        /* renamed from: a */
        public void mo21427a(Intent intent) {
            this.f12180b = intent;
        }

        /* renamed from: a */
        public Intent mo21426a() {
            return this.f12180b;
        }
    }

    /* renamed from: com.meizu.media.camera.singlebokeh.a$b */
    /* compiled from: BokehProcessTask */
    private final class C2363b extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f12181a;

        /* renamed from: c */
        private volatile Handler f12183c = new Handler(this.f12184d);

        /* renamed from: d */
        private volatile Looper f12184d = Looper.getMainLooper();

        /* renamed from: e */
        private Runnable f12185e = new Runnable() {

            /* renamed from: a */
            public static ChangeQuickRedirect f12186a;

            public void run() {
                if (!PatchProxy.proxy(new Object[0], this, f12186a, false, 6222, new Class[0], Void.TYPE).isSupported) {
                    LogUtil.C2630a aVar = BokehProcessTask.f12173b;
                    LogUtil.m15952c(aVar, "mRequestTasks:" + BokehProcessTask.this.f12176c.mo21433b());
                    BokehProcessTask.this.mo21424a();
                }
            }
        };

        public C2363b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f12181a, false, 6220, new Class[]{Message.class}, Void.TYPE).isSupported) {
                LogUtil.m15942a(BokehProcessTask.f12173b, "handleMessage start");
                while (BokehProcessTask.this.f12176c.mo21433b() > 0) {
                    BokehProcessTask.this.m13566c(BokehProcessTask.this.f12176c.mo21431a().mo21426a());
                }
                LogUtil.m15942a(BokehProcessTask.f12173b, "handleMessage end");
                this.f12183c.post(this.f12185e);
            }
        }

        /* renamed from: a */
        public void mo21428a() {
            if (!PatchProxy.proxy(new Object[0], this, f12181a, false, 6221, new Class[0], Void.TYPE).isSupported) {
                this.f12183c.removeCallbacks(this.f12185e);
            }
        }
    }
}
