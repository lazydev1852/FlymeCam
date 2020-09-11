package com.loc;

import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.LocationManagerBase;
import com.amap.api.location.UmidtokenInfo;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.base.MsgField;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.loc.bz */
public class AmapLocationManager implements LocationManagerBase {
    /* access modifiers changed from: private */

    /* renamed from: E */
    public static boolean f2813E = false;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f2814A = false;

    /* renamed from: B */
    private volatile boolean f2815B = false;

    /* renamed from: C */
    private boolean f2816C = true;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f2817D = true;

    /* renamed from: F */
    private H5LocationClient f2818F = null;

    /* renamed from: G */
    private ServiceConnection f2819G = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                AmapLocationManager.this.f2827h = new Messenger(iBinder);
                boolean unused = AmapLocationManager.this.f2814A = true;
                AmapLocationManager.this.f2836q = true;
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ALManager", "onServiceConnected");
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AmapLocationManager.this.f2827h = null;
            boolean unused = AmapLocationManager.this.f2814A = false;
        }
    };

    /* renamed from: a */
    AMapLocationClientOption f2820a = new AMapLocationClientOption();

    /* renamed from: b */
    public C1073c f2821b;

    /* renamed from: c */
    GpsLocation f2822c = null;

    /* renamed from: d */
    ArrayList<AMapLocationListener> f2823d = new ArrayList<>();

    /* renamed from: e */
    boolean f2824e = false;

    /* renamed from: f */
    public boolean f2825f = true;

    /* renamed from: g */
    LastLocationManager f2826g;

    /* renamed from: h */
    Messenger f2827h = null;

    /* renamed from: i */
    Messenger f2828i = null;

    /* renamed from: j */
    Intent f2829j = null;

    /* renamed from: k */
    int f2830k = 0;

    /* renamed from: l */
    C1072b f2831l = null;

    /* renamed from: m */
    boolean f2832m = false;

    /* renamed from: n */
    AMapLocationClientOption.AMapLocationMode f2833n = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;

    /* renamed from: o */
    Object f2834o = new Object();

    /* renamed from: p */
    ReportUtil f2835p = null;

    /* renamed from: q */
    boolean f2836q = false;

    /* renamed from: r */
    ApsManager f2837r = null;

    /* renamed from: s */
    String f2838s = null;

    /* renamed from: t */
    AMapLocationQualityReport f2839t = null;

    /* renamed from: u */
    boolean f2840u = false;

    /* renamed from: v */
    boolean f2841v = false;

    /* renamed from: w */
    C1071a f2842w = null;

    /* renamed from: x */
    String f2843x = null;

    /* renamed from: y */
    boolean f2844y = false;

    /* renamed from: z */
    private Context f2845z;

    /* renamed from: com.loc.bz$a */
    /* compiled from: AmapLocationManager */
    public class C1071a extends Handler {
        public C1071a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            String str;
            Throwable th;
            String str2;
            try {
                super.handleMessage(message);
                int i = message.what;
                switch (i) {
                    case 11:
                        str2 = "handleMessage ACTION_LBS_LOCATIONSUCCES";
                        AmapLocationManager.m3277b(AmapLocationManager.this, message.getData());
                        return;
                    case 12:
                        str2 = "handleMessage ACTION_GPS_LOCATIONSUCCESS";
                        AmapLocationManager.m3269a(AmapLocationManager.this, message);
                        return;
                    default:
                        switch (i) {
                            case 1002:
                                str2 = "handleMessage SET_LISTENER";
                                AmapLocationManager.m3271a(AmapLocationManager.this, (AMapLocationListener) message.obj);
                                return;
                            case 1003:
                                str = "handleMessage START_LOCATION";
                                AmapLocationManager.this.m3288g();
                                return;
                            case 1004:
                                str = "handleMessage STOP_LOCATION";
                                AmapLocationManager.this.m3290h();
                                return;
                            case ARPMessageType.MSG_TYPE_RESUME_MUSIC:
                                str2 = "handleMessage REMOVE_LISTENER";
                                AmapLocationManager.m3279b(AmapLocationManager.this, (AMapLocationListener) message.obj);
                                return;
                            case 1006:
                            case 1007:
                                return;
                            case 1008:
                                str = "handleMessage START_SOCKET";
                                AmapLocationManager.m3289g(AmapLocationManager.this);
                                return;
                            case 1009:
                                str = "handleMessage STOP_SOCKET";
                                AmapLocationManager.m3291h(AmapLocationManager.this);
                                return;
                            case 1010:
                                return;
                            case 1011:
                                str = "handleMessage DESTROY";
                                AmapLocationManager.this.mo13148e();
                                return;
                            default:
                                switch (i) {
                                    case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW:
                                        str2 = "handleMessage ACTION_SAVE_LAST_LOCATION";
                                        AmapLocationManager.m3278b(AmapLocationManager.this, message);
                                        return;
                                    case PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW:
                                        str = "handleMessage START_GPS_LOCATION";
                                        AmapLocationManager.this.f2822c.mo13222a(AmapLocationManager.this.f2820a);
                                        AmapLocationManager.this.m3263a(1025, (Object) null, 300000);
                                        return;
                                    case PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW:
                                        str = "handleMessage START_LBS_LOCATION";
                                        if (AmapLocationManager.this.f2822c.mo13224b()) {
                                            AmapLocationManager.this.m3263a((int) PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, (Object) null, 1000);
                                            return;
                                        } else {
                                            AmapLocationManager.m3283d(AmapLocationManager.this);
                                            return;
                                        }
                                    case PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW:
                                        str = "handleMessage STOP_GPS_LOCATION";
                                        AmapLocationManager.this.f2822c.mo13219a();
                                        AmapLocationManager.this.m3261a(1025);
                                        return;
                                    case PointerIconCompat.TYPE_ZOOM_IN:
                                        str2 = "handleMessage SET_OPTION";
                                        AmapLocationManager.this.f2820a = (AMapLocationClientOption) message.obj;
                                        if (AmapLocationManager.this.f2820a != null) {
                                            AmapLocationManager.m3286f(AmapLocationManager.this);
                                            return;
                                        }
                                        return;
                                    case PointerIconCompat.TYPE_ZOOM_OUT:
                                    case PointerIconCompat.TYPE_GRAB:
                                    case 1021:
                                    case ARPMessageType.MSG_TYPE_VIDEO_PLAY_RES:
                                        return;
                                    case ARPMessageType.MSG_TYPE_VIDEO_PAUSE:
                                        str2 = "handleMessage ACTION_ENABLE_BACKGROUND";
                                        AmapLocationManager.m3282c(AmapLocationManager.this, message);
                                        return;
                                    case 1024:
                                        str2 = "handleMessage ACTION_DISABLE_BACKGROUND";
                                        try {
                                            AmapLocationManager.m3284d(AmapLocationManager.this, message);
                                            return;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            str = str2;
                                            break;
                                        }
                                    case 1025:
                                        try {
                                            if (AmapLocationManager.this.f2822c.mo13228f()) {
                                                AmapLocationManager.this.f2822c.mo13219a();
                                                AmapLocationManager.this.f2822c.mo13222a(AmapLocationManager.this.f2820a);
                                            }
                                            AmapLocationManager.this.m3263a(1025, (Object) null, 300000);
                                            return;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            break;
                                        }
                                    default:
                                        return;
                                }
                        }
                }
            } catch (Throwable th4) {
                th = th4;
                str = null;
            }
            if (str == null) {
                str = "handleMessage";
            }
            CoreUtil.m3389a(th, "AMapLocationManage$MHandlerr", str);
        }
    }

    /* renamed from: com.loc.bz$b */
    /* compiled from: AmapLocationManager */
    static class C1072b extends HandlerThread {

        /* renamed from: a */
        AmapLocationManager f2849a = null;

        public C1072b(String str, AmapLocationManager bzVar) {
            super(str);
            this.f2849a = bzVar;
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            try {
                this.f2849a.f2826g.mo13240a();
                this.f2849a.m3293j();
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.loc.bz$c */
    /* compiled from: AmapLocationManager */
    public class C1073c extends Handler {
        public C1073c() {
        }

        public C1073c(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x007a, code lost:
            r1 = "handleMessage RESULT_GPS_LOCATIONSUCCESS";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            r0 = android.os.Message.obtain();
            r0.what = 12;
            r0.obj = r4.obj;
            r3.f2850a.f2842w.sendMessage(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x008f, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r4) {
            /*
                r3 = this;
                r0 = 0
                super.handleMessage(r4)     // Catch:{ Throwable -> 0x00b0 }
                com.loc.bz r1 = com.loc.AmapLocationManager.this     // Catch:{ Throwable -> 0x00b0 }
                boolean r1 = r1.f2832m     // Catch:{ Throwable -> 0x00b0 }
                if (r1 == 0) goto L_0x0011
                boolean r1 = com.loc.CoreUtil.m3396d()     // Catch:{ Throwable -> 0x00b0 }
                if (r1 != 0) goto L_0x0011
                return
            L_0x0011:
                int r1 = r4.what     // Catch:{ Throwable -> 0x00b0 }
                switch(r1) {
                    case 1: goto L_0x0090;
                    case 2: goto L_0x007a;
                    case 3: goto L_0x0079;
                    case 4: goto L_0x0016;
                    case 5: goto L_0x0061;
                    case 6: goto L_0x004d;
                    case 7: goto L_0x003b;
                    case 8: goto L_0x0035;
                    case 9: goto L_0x0024;
                    case 10: goto L_0x0018;
                    default: goto L_0x0016;
                }     // Catch:{ Throwable -> 0x00b0 }
            L_0x0016:
                goto L_0x00af
            L_0x0018:
                java.lang.String r1 = "handleMessage RESULT_LBS_ON_CALLBACK"
                java.lang.Object r4 = r4.obj     // Catch:{ Throwable -> 0x00ad }
                com.amap.api.location.AMapLocation r4 = (com.amap.api.location.AMapLocation) r4     // Catch:{ Throwable -> 0x00ad }
                com.loc.bz r0 = com.loc.AmapLocationManager.this     // Catch:{ Throwable -> 0x00ad }
                com.loc.AmapLocationManager.m3270a((com.loc.AmapLocationManager) r0, (com.amap.api.location.AMapLocation) r4)     // Catch:{ Throwable -> 0x00ad }
                return
            L_0x0024:
                java.lang.String r1 = "handleMessage RESULT_INSTALLED_MOCK_APP"
                android.os.Bundle r4 = r4.getData()     // Catch:{ Throwable -> 0x00ad }
                java.lang.String r0 = "installMockApp"
                boolean r4 = r4.getBoolean(r0)     // Catch:{ Throwable -> 0x00ad }
                boolean unused = com.loc.AmapLocationManager.f2813E = r4     // Catch:{ Throwable -> 0x00ad }
                goto L_0x00af
            L_0x0035:
                r1 = 2141(0x85d, float:3.0E-42)
                com.loc.ReportUtil.m3435a((java.lang.String) r0, (int) r1)     // Catch:{ Throwable -> 0x00b0 }
                goto L_0x007a
            L_0x003b:
                java.lang.String r1 = "handleMessage RESULT_NGPS_ABLE"
                android.os.Bundle r4 = r4.getData()     // Catch:{ Throwable -> 0x00ad }
                com.loc.bz r0 = com.loc.AmapLocationManager.this     // Catch:{ Throwable -> 0x00ad }
                java.lang.String r2 = "ngpsAble"
                boolean r4 = r4.getBoolean(r2)     // Catch:{ Throwable -> 0x00ad }
                boolean unused = r0.f2817D = r4     // Catch:{ Throwable -> 0x00ad }
                return
            L_0x004d:
                java.lang.String r1 = "handleMessage RESULT_GPS_GEO_SUCCESS"
                android.os.Bundle r4 = r4.getData()     // Catch:{ Throwable -> 0x00ad }
                com.loc.bz r0 = com.loc.AmapLocationManager.this     // Catch:{ Throwable -> 0x00ad }
                com.loc.ct r0 = r0.f2822c     // Catch:{ Throwable -> 0x00ad }
                if (r0 == 0) goto L_0x00af
                com.loc.bz r0 = com.loc.AmapLocationManager.this     // Catch:{ Throwable -> 0x00ad }
                com.loc.ct r0 = r0.f2822c     // Catch:{ Throwable -> 0x00ad }
                r0.mo13220a((android.os.Bundle) r4)     // Catch:{ Throwable -> 0x00ad }
                return
            L_0x0061:
                java.lang.String r1 = "handleMessage RESULT_GPS_LOCATIONCHANGE"
                android.os.Bundle r4 = r4.getData()     // Catch:{ Throwable -> 0x00ad }
                java.lang.String r0 = "optBundle"
                com.loc.bz r2 = com.loc.AmapLocationManager.this     // Catch:{ Throwable -> 0x00ad }
                com.amap.api.location.AMapLocationClientOption r2 = r2.f2820a     // Catch:{ Throwable -> 0x00ad }
                android.os.Bundle r2 = com.loc.CoreUtil.m3382a((com.amap.api.location.AMapLocationClientOption) r2)     // Catch:{ Throwable -> 0x00ad }
                r4.putBundle(r0, r2)     // Catch:{ Throwable -> 0x00ad }
                com.loc.bz r0 = com.loc.AmapLocationManager.this     // Catch:{ Throwable -> 0x00ad }
                r0.m3262a(10, (android.os.Bundle) r4)     // Catch:{ Throwable -> 0x00ad }
            L_0x0079:
                return
            L_0x007a:
                java.lang.String r1 = "handleMessage RESULT_GPS_LOCATIONSUCCESS"
                android.os.Message r0 = android.os.Message.obtain()     // Catch:{ Throwable -> 0x00ad }
                r2 = 12
                r0.what = r2     // Catch:{ Throwable -> 0x00ad }
                java.lang.Object r4 = r4.obj     // Catch:{ Throwable -> 0x00ad }
                r0.obj = r4     // Catch:{ Throwable -> 0x00ad }
                com.loc.bz r4 = com.loc.AmapLocationManager.this     // Catch:{ Throwable -> 0x00ad }
                com.loc.bz$a r4 = r4.f2842w     // Catch:{ Throwable -> 0x00ad }
                r4.sendMessage(r0)     // Catch:{ Throwable -> 0x00ad }
                return
            L_0x0090:
                java.lang.String r1 = "handleMessage RESULT_LBS_LOCATIONSUCCESS"
                com.loc.bz r0 = com.loc.AmapLocationManager.this     // Catch:{ Throwable -> 0x00ad }
                com.loc.bz$a r0 = r0.f2842w     // Catch:{ Throwable -> 0x00ad }
                android.os.Message r0 = r0.obtainMessage()     // Catch:{ Throwable -> 0x00ad }
                r2 = 11
                r0.what = r2     // Catch:{ Throwable -> 0x00ad }
                android.os.Bundle r4 = r4.getData()     // Catch:{ Throwable -> 0x00ad }
                r0.setData(r4)     // Catch:{ Throwable -> 0x00ad }
                com.loc.bz r4 = com.loc.AmapLocationManager.this     // Catch:{ Throwable -> 0x00ad }
                com.loc.bz$a r4 = r4.f2842w     // Catch:{ Throwable -> 0x00ad }
                r4.sendMessage(r0)     // Catch:{ Throwable -> 0x00ad }
                return
            L_0x00ad:
                r4 = move-exception
                goto L_0x00b2
            L_0x00af:
                return
            L_0x00b0:
                r4 = move-exception
                r1 = r0
            L_0x00b2:
                if (r1 != 0) goto L_0x00b6
                java.lang.String r1 = "handleMessage"
            L_0x00b6:
                java.lang.String r0 = "AmapLocationManager$MainHandler"
                com.loc.CoreUtil.m3389a(r4, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.AmapLocationManager.C1073c.handleMessage(android.os.Message):void");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:2|3)|4|5|(1:7)(1:9)|8|12|13|18|21|22|25|(2:27|28)(1:29)) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0083, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0084, code lost:
        com.loc.CoreUtil.m3389a(r4, "ALManager", "init 1");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0069 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x006f A[Catch:{ Throwable -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x007d A[Catch:{ Throwable -> 0x0083 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AmapLocationManager(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            r3.<init>()
            com.amap.api.location.AMapLocationClientOption r0 = new com.amap.api.location.AMapLocationClientOption
            r0.<init>()
            r3.f2820a = r0
            r0 = 0
            r3.f2822c = r0
            r1 = 0
            r3.f2814A = r1
            r3.f2815B = r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3.f2823d = r2
            r3.f2824e = r1
            r2 = 1
            r3.f2816C = r2
            r3.f2825f = r2
            r3.f2827h = r0
            r3.f2828i = r0
            r3.f2829j = r0
            r3.f2830k = r1
            r3.f2817D = r2
            r3.f2831l = r0
            r3.f2832m = r1
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r2 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
            r3.f2833n = r2
            java.lang.Object r2 = new java.lang.Object
            r2.<init>()
            r3.f2834o = r2
            r3.f2835p = r0
            r3.f2836q = r1
            r3.f2837r = r0
            r3.f2818F = r0
            r3.f2838s = r0
            com.loc.bz$1 r2 = new com.loc.bz$1
            r2.<init>()
            r3.f2819G = r2
            r3.f2839t = r0
            r3.f2840u = r1
            r3.f2841v = r1
            r3.f2842w = r0
            r3.f2843x = r0
            r3.f2844y = r1
            r3.f2845z = r4
            r3.f2829j = r5
            boolean r4 = com.loc.CoreUtil.m3396d()
            if (r4 == 0) goto L_0x0069
            com.loc.di r4 = com.loc.CoreUtil.m3392b()     // Catch:{ Throwable -> 0x0069 }
            android.content.Context r5 = r3.f2845z     // Catch:{ Throwable -> 0x0069 }
            com.loc.RollBackDynamic.m3479a((android.content.Context) r5, (com.loc.SDKInfo) r4)     // Catch:{ Throwable -> 0x0069 }
        L_0x0069:
            android.os.Looper r4 = android.os.Looper.myLooper()     // Catch:{ Throwable -> 0x0083 }
            if (r4 != 0) goto L_0x007d
            com.loc.bz$c r4 = new com.loc.bz$c     // Catch:{ Throwable -> 0x0083 }
            android.content.Context r5 = r3.f2845z     // Catch:{ Throwable -> 0x0083 }
            android.os.Looper r5 = r5.getMainLooper()     // Catch:{ Throwable -> 0x0083 }
            r4.<init>(r5)     // Catch:{ Throwable -> 0x0083 }
        L_0x007a:
            r3.f2821b = r4     // Catch:{ Throwable -> 0x0083 }
            goto L_0x008b
        L_0x007d:
            com.loc.bz$c r4 = new com.loc.bz$c     // Catch:{ Throwable -> 0x0083 }
            r4.<init>()     // Catch:{ Throwable -> 0x0083 }
            goto L_0x007a
        L_0x0083:
            r4 = move-exception
            java.lang.String r5 = "ALManager"
            java.lang.String r0 = "init 1"
            com.loc.CoreUtil.m3389a(r4, r5, r0)
        L_0x008b:
            com.loc.cv r4 = new com.loc.cv     // Catch:{ Throwable -> 0x0095 }
            android.content.Context r5 = r3.f2845z     // Catch:{ Throwable -> 0x0095 }
            r4.<init>(r5)     // Catch:{ Throwable -> 0x0095 }
            r3.f2826g = r4     // Catch:{ Throwable -> 0x0095 }
            goto L_0x009d
        L_0x0095:
            r4 = move-exception
            java.lang.String r5 = "ALManager"
            java.lang.String r0 = "init 2"
            com.loc.CoreUtil.m3389a(r4, r5, r0)     // Catch:{ Throwable -> 0x00be }
        L_0x009d:
            com.loc.bz$b r4 = new com.loc.bz$b     // Catch:{ Throwable -> 0x00be }
            java.lang.String r5 = "amapLocManagerThread"
            r4.<init>(r5, r3)     // Catch:{ Throwable -> 0x00be }
            r3.f2831l = r4     // Catch:{ Throwable -> 0x00be }
            com.loc.bz$b r4 = r3.f2831l     // Catch:{ Throwable -> 0x00be }
            r5 = 5
            r4.setPriority(r5)     // Catch:{ Throwable -> 0x00be }
            com.loc.bz$b r4 = r3.f2831l     // Catch:{ Throwable -> 0x00be }
            r4.start()     // Catch:{ Throwable -> 0x00be }
            com.loc.bz$b r4 = r3.f2831l     // Catch:{ Throwable -> 0x00be }
            android.os.Looper r4 = r4.getLooper()     // Catch:{ Throwable -> 0x00be }
            com.loc.bz$a r4 = r3.m3260a((android.os.Looper) r4)     // Catch:{ Throwable -> 0x00be }
            r3.f2842w = r4     // Catch:{ Throwable -> 0x00be }
            goto L_0x00c6
        L_0x00be:
            r4 = move-exception
            java.lang.String r5 = "ALManager"
            java.lang.String r0 = "init 5"
            com.loc.CoreUtil.m3389a(r4, r5, r0)
        L_0x00c6:
            com.loc.ct r4 = new com.loc.ct     // Catch:{ Throwable -> 0x00d2 }
            android.content.Context r5 = r3.f2845z     // Catch:{ Throwable -> 0x00d2 }
            com.loc.bz$c r0 = r3.f2821b     // Catch:{ Throwable -> 0x00d2 }
            r4.<init>(r5, r0)     // Catch:{ Throwable -> 0x00d2 }
            r3.f2822c = r4     // Catch:{ Throwable -> 0x00d2 }
            goto L_0x00da
        L_0x00d2:
            r4 = move-exception
            java.lang.String r5 = "ALManager"
            java.lang.String r0 = "init 3"
            com.loc.CoreUtil.m3389a(r4, r5, r0)
        L_0x00da:
            com.loc.cl r4 = r3.f2835p
            if (r4 != 0) goto L_0x00e5
            com.loc.cl r4 = new com.loc.cl
            r4.<init>()
            r3.f2835p = r4
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.AmapLocationManager.<init>(android.content.Context, android.content.Intent):void");
    }

    /* renamed from: a */
    private AMapLocationServer m3259a(Aps cmVar) {
        if (!this.f2820a.mo8567p()) {
            return null;
        }
        try {
            return cmVar.mo13201j();
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ALManager", "doFirstCacheLoc");
            return null;
        }
    }

    /* renamed from: a */
    private C1071a m3260a(Looper looper) {
        C1071a aVar;
        synchronized (this.f2834o) {
            this.f2842w = new C1071a(looper);
            aVar = this.f2842w;
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3261a(int i) {
        synchronized (this.f2834o) {
            if (this.f2842w != null) {
                this.f2842w.removeMessages(i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3262a(int i, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable th) {
                boolean z = (th instanceof IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th instanceof RemoteException) || z) {
                    this.f2827h = null;
                    this.f2814A = false;
                }
                CoreUtil.m3389a(th, "ALManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.f2838s)) {
            this.f2838s = CoreUtil.m3393b(this.f2845z);
        }
        bundle.putString("c", this.f2838s);
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.setData(bundle);
        obtain.replyTo = this.f2828i;
        if (this.f2827h != null) {
            this.f2827h.send(obtain);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3263a(int i, Object obj, long j) {
        synchronized (this.f2834o) {
            if (this.f2842w != null) {
                Message obtain = Message.obtain();
                obtain.what = i;
                if (obj instanceof Bundle) {
                    obtain.setData((Bundle) obj);
                } else {
                    obtain.obj = obj;
                }
                this.f2842w.sendMessageDelayed(obtain, j);
            }
        }
    }

    /* renamed from: a */
    private void m3264a(Intent intent, boolean z) {
        if (this.f2845z != null) {
            if (Build.VERSION.SDK_INT >= 26 && z) {
                if (!m3295l()) {
                    Log.e("amapapi", "-------------调用后台定位服务，缺少权限：android.permission.FOREGROUND_SERVICE--------------");
                    return;
                }
                try {
                    this.f2845z.getClass().getMethod("startForegroundService", new Class[]{Intent.class}).invoke(this.f2845z, new Object[]{intent});
                } catch (Throwable unused) {
                }
                this.f2844y = true;
            }
            this.f2845z.startService(intent);
            this.f2844y = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0113, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m3265a(com.amap.api.location.AMapLocation r4, java.lang.Throwable r5, long r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = com.loc.CoreUtil.m3396d()     // Catch:{ Throwable -> 0x0116 }
            if (r0 == 0) goto L_0x0023
            if (r4 != 0) goto L_0x0023
            if (r5 == 0) goto L_0x0018
            android.content.Context r4 = r3.f2845z     // Catch:{ Throwable -> 0x0116 }
            java.lang.String r6 = "loc"
            java.lang.String r5 = r5.getMessage()     // Catch:{ Throwable -> 0x0116 }
            com.loc.RollBackDynamic.m3480a(r4, r6, r5)     // Catch:{ Throwable -> 0x0116 }
            monitor-exit(r3)
            return
        L_0x0018:
            android.content.Context r4 = r3.f2845z     // Catch:{ Throwable -> 0x0116 }
            java.lang.String r5 = "loc"
            java.lang.String r6 = "amaplocation is null"
            com.loc.RollBackDynamic.m3480a(r4, r5, r6)     // Catch:{ Throwable -> 0x0116 }
            monitor-exit(r3)
            return
        L_0x0023:
            if (r4 != 0) goto L_0x0036
            com.amap.api.location.AMapLocation r4 = new com.amap.api.location.AMapLocation     // Catch:{ Throwable -> 0x0116 }
            java.lang.String r5 = ""
            r4.<init>((java.lang.String) r5)     // Catch:{ Throwable -> 0x0116 }
            r5 = 8
            r4.mo8485c((int) r5)     // Catch:{ Throwable -> 0x0116 }
            java.lang.String r5 = "amapLocation is null#0801"
            r4.mo8478a((java.lang.String) r5)     // Catch:{ Throwable -> 0x0116 }
        L_0x0036:
            java.lang.String r5 = "gps"
            java.lang.String r0 = r4.getProvider()     // Catch:{ Throwable -> 0x0116 }
            boolean r5 = r5.equalsIgnoreCase(r0)     // Catch:{ Throwable -> 0x0116 }
            if (r5 != 0) goto L_0x0047
            java.lang.String r5 = "lbs"
            r4.setProvider(r5)     // Catch:{ Throwable -> 0x0116 }
        L_0x0047:
            com.amap.api.location.c r5 = r3.f2839t     // Catch:{ Throwable -> 0x0116 }
            if (r5 != 0) goto L_0x0052
            com.amap.api.location.c r5 = new com.amap.api.location.c     // Catch:{ Throwable -> 0x0116 }
            r5.<init>()     // Catch:{ Throwable -> 0x0116 }
            r3.f2839t = r5     // Catch:{ Throwable -> 0x0116 }
        L_0x0052:
            com.amap.api.location.c r5 = r3.f2839t     // Catch:{ Throwable -> 0x0116 }
            com.amap.api.location.AMapLocationClientOption r0 = r3.f2820a     // Catch:{ Throwable -> 0x0116 }
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r0 = r0.mo8559h()     // Catch:{ Throwable -> 0x0116 }
            r5.mo8602a((com.amap.api.location.AMapLocationClientOption.AMapLocationMode) r0)     // Catch:{ Throwable -> 0x0116 }
            com.loc.ct r5 = r3.f2822c     // Catch:{ Throwable -> 0x0116 }
            if (r5 == 0) goto L_0x0077
            com.amap.api.location.c r5 = r3.f2839t     // Catch:{ Throwable -> 0x0116 }
            com.loc.ct r0 = r3.f2822c     // Catch:{ Throwable -> 0x0116 }
            int r0 = r0.mo13227e()     // Catch:{ Throwable -> 0x0116 }
            r5.mo8605b((int) r0)     // Catch:{ Throwable -> 0x0116 }
            com.amap.api.location.c r5 = r3.f2839t     // Catch:{ Throwable -> 0x0116 }
            com.loc.ct r0 = r3.f2822c     // Catch:{ Throwable -> 0x0116 }
            int r0 = r0.mo13226d()     // Catch:{ Throwable -> 0x0116 }
            r5.mo8600a((int) r0)     // Catch:{ Throwable -> 0x0116 }
        L_0x0077:
            android.content.Context r5 = r3.f2845z     // Catch:{ Throwable -> 0x0116 }
            boolean r5 = com.loc.C1079cp.m3550h((android.content.Context) r5)     // Catch:{ Throwable -> 0x0116 }
            com.amap.api.location.c r0 = r3.f2839t     // Catch:{ Throwable -> 0x0116 }
            r0.mo8604a((boolean) r5)     // Catch:{ Throwable -> 0x0116 }
            com.amap.api.location.c r5 = r3.f2839t     // Catch:{ Throwable -> 0x0116 }
            android.content.Context r0 = r3.f2845z     // Catch:{ Throwable -> 0x0116 }
            java.lang.String r0 = com.loc.C1079cp.m3553i((android.content.Context) r0)     // Catch:{ Throwable -> 0x0116 }
            r5.mo8603a((java.lang.String) r0)     // Catch:{ Throwable -> 0x0116 }
            int r5 = r4.mo8475a()     // Catch:{ Throwable -> 0x0116 }
            r0 = 1
            r1 = 0
            if (r5 == r0) goto L_0x00a2
            java.lang.String r5 = "gps"
            java.lang.String r0 = r4.getProvider()     // Catch:{ Throwable -> 0x0116 }
            boolean r5 = r5.equalsIgnoreCase(r0)     // Catch:{ Throwable -> 0x0116 }
            if (r5 == 0) goto L_0x00a3
        L_0x00a2:
            r6 = r1
        L_0x00a3:
            com.amap.api.location.c r5 = r3.f2839t     // Catch:{ Throwable -> 0x0116 }
            r5.mo8601a((long) r6)     // Catch:{ Throwable -> 0x0116 }
            com.amap.api.location.c r5 = r3.f2839t     // Catch:{ Throwable -> 0x0116 }
            boolean r6 = f2813E     // Catch:{ Throwable -> 0x0116 }
            r5.mo8606b((boolean) r6)     // Catch:{ Throwable -> 0x0116 }
            com.amap.api.location.c r5 = r3.f2839t     // Catch:{ Throwable -> 0x0116 }
            r4.mo8477a((com.amap.api.location.AMapLocationQualityReport) r5)     // Catch:{ Throwable -> 0x0116 }
            boolean r5 = r3.f2815B     // Catch:{ Throwable -> 0x00ee }
            if (r5 == 0) goto L_0x00f6
            java.lang.String r5 = r3.f2843x     // Catch:{ Throwable -> 0x00ee }
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ Throwable -> 0x00ee }
            r6.<init>()     // Catch:{ Throwable -> 0x00ee }
            java.lang.String r7 = "loc"
            r6.putParcelable(r7, r4)     // Catch:{ Throwable -> 0x00ee }
            java.lang.String r7 = "lastLocNb"
            r6.putString(r7, r5)     // Catch:{ Throwable -> 0x00ee }
            r5 = 1014(0x3f6, float:1.421E-42)
            r3.m3263a((int) r5, (java.lang.Object) r6, (long) r1)     // Catch:{ Throwable -> 0x00ee }
            android.content.Context r5 = r3.f2845z     // Catch:{ Throwable -> 0x00ee }
            com.loc.ReportUtil.m3428a((android.content.Context) r5, (com.amap.api.location.AMapLocation) r4)     // Catch:{ Throwable -> 0x00ee }
            android.content.Context r5 = r3.f2845z     // Catch:{ Throwable -> 0x00ee }
            com.loc.ReportUtil.m3441b(r5, r4)     // Catch:{ Throwable -> 0x00ee }
            com.amap.api.location.AMapLocation r4 = r4.clone()     // Catch:{ Throwable -> 0x00ee }
            com.loc.bz$c r5 = r3.f2821b     // Catch:{ Throwable -> 0x00ee }
            android.os.Message r5 = r5.obtainMessage()     // Catch:{ Throwable -> 0x00ee }
            r6 = 10
            r5.what = r6     // Catch:{ Throwable -> 0x00ee }
            r5.obj = r4     // Catch:{ Throwable -> 0x00ee }
            com.loc.bz$c r4 = r3.f2821b     // Catch:{ Throwable -> 0x00ee }
            r4.sendMessage(r5)     // Catch:{ Throwable -> 0x00ee }
            goto L_0x00f6
        L_0x00ee:
            r4 = move-exception
            java.lang.String r5 = "ALManager"
            java.lang.String r6 = "handlerLocation part2"
            com.loc.CoreUtil.m3389a(r4, r5, r6)     // Catch:{ Throwable -> 0x0116 }
        L_0x00f6:
            boolean r4 = r3.f2832m     // Catch:{ Throwable -> 0x0116 }
            if (r4 == 0) goto L_0x0102
            boolean r4 = com.loc.CoreUtil.m3396d()     // Catch:{ Throwable -> 0x0116 }
            if (r4 != 0) goto L_0x0102
            monitor-exit(r3)
            return
        L_0x0102:
            android.content.Context r4 = r3.f2845z     // Catch:{ Throwable -> 0x0116 }
            com.loc.RollBackDynamic.m3481b(r4)     // Catch:{ Throwable -> 0x0116 }
            com.amap.api.location.AMapLocationClientOption r4 = r3.f2820a     // Catch:{ Throwable -> 0x0116 }
            boolean r4 = r4.mo8554d()     // Catch:{ Throwable -> 0x0116 }
            if (r4 == 0) goto L_0x0112
            r3.m3290h()     // Catch:{ Throwable -> 0x0116 }
        L_0x0112:
            monitor-exit(r3)
            return
        L_0x0114:
            r4 = move-exception
            goto L_0x0120
        L_0x0116:
            r4 = move-exception
            java.lang.String r5 = "ALManager"
            java.lang.String r6 = "handlerLocation part3"
            com.loc.CoreUtil.m3389a(r4, r5, r6)     // Catch:{ all -> 0x0114 }
            monitor-exit(r3)
            return
        L_0x0120:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.AmapLocationManager.m3265a(com.amap.api.location.AMapLocation, java.lang.Throwable, long):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m3269a(AmapLocationManager bzVar, Message message) {
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            if (bzVar.f2825f && bzVar.f2827h != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", CoreUtil.m3382a(bzVar.f2820a));
                bzVar.m3262a(0, bundle);
                bzVar.f2825f = false;
            }
            bzVar.m3265a(aMapLocation, (Throwable) null, 0);
            if (bzVar.f2817D) {
                bzVar.m3262a(7, (Bundle) null);
            }
            bzVar.m3261a(1025);
            bzVar.m3263a(1025, (Object) null, 300000);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m3270a(AmapLocationManager bzVar, AMapLocation aMapLocation) {
        try {
            if (aMapLocation.mo8484c() != 0) {
                aMapLocation.mo8481b(0);
            }
            if (aMapLocation.mo8484c() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if ((latitude == 0.0d && longitude == 0.0d) || latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) {
                    ReportUtil.m3436a("errorLatLng", aMapLocation.mo8539w());
                    aMapLocation.mo8481b(0);
                    aMapLocation.mo8485c(8);
                    aMapLocation.mo8478a("LatLng is error#0802");
                }
            }
            if ("gps".equalsIgnoreCase(aMapLocation.getProvider()) || !bzVar.f2822c.mo13224b()) {
                aMapLocation.setAltitude(C1079cp.m3517b(aMapLocation.getAltitude()));
                aMapLocation.setBearing(C1079cp.m3496a(aMapLocation.getBearing()));
                aMapLocation.setSpeed(C1079cp.m3496a(aMapLocation.getSpeed()));
                Iterator<AMapLocationListener> it = bzVar.f2823d.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().mo8598a(aMapLocation);
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m3271a(AmapLocationManager bzVar, AMapLocationListener bVar) {
        if (bVar != null) {
            if (bzVar.f2823d == null) {
                bzVar.f2823d = new ArrayList<>();
            }
            if (!bzVar.f2823d.contains(bVar)) {
                bzVar.f2823d.add(bVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("listener参数不能为null");
    }

    /* renamed from: a */
    private static void m3272a(Aps cmVar, AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null) {
            try {
                if (aMapLocationServer.mo8484c() == 0) {
                    cmVar.mo13192a(aMapLocationServer);
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ALManager", "apsLocation:doFirstAddCache");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:79:0x010e, code lost:
        if (r14 == null) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r14.mo13197f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0122, code lost:
        if (r14 != null) goto L_0x0110;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0092 A[Catch:{ Throwable -> 0x00b9, Throwable -> 0x0114 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c8 A[Catch:{ Throwable -> 0x00ea }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.autonavi.aps.amapapi.model.AMapLocationServer m3275b(com.loc.Aps r14) {
        /*
            r13 = this;
            r0 = 0
            com.loc.ck r1 = new com.loc.ck     // Catch:{ Throwable -> 0x0118 }
            r1.<init>()     // Catch:{ Throwable -> 0x0118 }
            r2 = 0
            long r3 = com.loc.C1079cp.m3529c()     // Catch:{ Throwable -> 0x0118 }
            r1.mo13175a((long) r3)     // Catch:{ Throwable -> 0x0118 }
            java.lang.String r3 = com.amap.api.location.AMapLocationClientOption.m479a()     // Catch:{ Throwable -> 0x001e }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Throwable -> 0x001e }
            if (r4 != 0) goto L_0x0026
            android.content.Context r4 = r13.f2845z     // Catch:{ Throwable -> 0x001e }
            com.loc.AuthConfigManager.m3671a((android.content.Context) r4, (java.lang.String) r3)     // Catch:{ Throwable -> 0x001e }
            goto L_0x0026
        L_0x001e:
            r3 = move-exception
            java.lang.String r4 = "ALManager"
            java.lang.String r5 = "apsLocation setAuthKey"
            com.loc.CoreUtil.m3389a(r3, r4, r5)     // Catch:{ Throwable -> 0x0118 }
        L_0x0026:
            java.lang.String r3 = com.amap.api.location.UmidtokenInfo.m544a()     // Catch:{ Throwable -> 0x0034 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Throwable -> 0x0034 }
            if (r4 != 0) goto L_0x003c
            com.loc.DeviceInfo.m3707a((java.lang.String) r3)     // Catch:{ Throwable -> 0x0034 }
            goto L_0x003c
        L_0x0034:
            r3 = move-exception
            java.lang.String r4 = "ALManager"
            java.lang.String r5 = "apsLocation setUmidToken"
            com.loc.CoreUtil.m3389a(r3, r4, r5)     // Catch:{ Throwable -> 0x0118 }
        L_0x003c:
            android.content.Context r3 = r13.f2845z     // Catch:{ Throwable -> 0x004c }
            r14.mo13190a((android.content.Context) r3)     // Catch:{ Throwable -> 0x004c }
            com.amap.api.location.AMapLocationClientOption r3 = r13.f2820a     // Catch:{ Throwable -> 0x004c }
            r14.mo13191a((com.amap.api.location.AMapLocationClientOption) r3)     // Catch:{ Throwable -> 0x004c }
            android.content.Context r3 = r13.f2845z     // Catch:{ Throwable -> 0x004c }
            r14.mo13200i()     // Catch:{ Throwable -> 0x004c }
            goto L_0x0054
        L_0x004c:
            r3 = move-exception
            java.lang.String r4 = "ALManager"
            java.lang.String r5 = "initApsBase"
            com.loc.CoreUtil.m3389a(r3, r4, r5)     // Catch:{ Throwable -> 0x0118 }
        L_0x0054:
            r3 = 0
            boolean r5 = com.loc.AuthUtil.m3378w()     // Catch:{ Throwable -> 0x0118 }
            com.autonavi.aps.amapapi.model.AMapLocationServer r6 = r13.m3259a((com.loc.Aps) r14)     // Catch:{ Throwable -> 0x0118 }
            r7 = 1
            if (r6 != 0) goto L_0x0084
            r2 = r5 ^ 1
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r14.mo13188a((boolean) r2)     // Catch:{ Throwable -> 0x0078 }
            if (r2 == 0) goto L_0x0071
            long r8 = r2.mo8803J()     // Catch:{ Throwable -> 0x006f }
            r3 = r8
            goto L_0x0071
        L_0x006f:
            r6 = move-exception
            goto L_0x007c
        L_0x0071:
            if (r5 != 0) goto L_0x0076
            m3272a((com.loc.Aps) r14, (com.autonavi.aps.amapapi.model.AMapLocationServer) r2)     // Catch:{ Throwable -> 0x006f }
        L_0x0076:
            r6 = 1
            goto L_0x0086
        L_0x0078:
            r2 = move-exception
            r12 = r6
            r6 = r2
            r2 = r12
        L_0x007c:
            java.lang.String r8 = "ALManager"
            java.lang.String r9 = "apsLocation:doFirstNetLocate"
            com.loc.CoreUtil.m3389a(r6, r8, r9)     // Catch:{ Throwable -> 0x0114 }
            goto L_0x0076
        L_0x0084:
            r2 = r6
            r6 = 0
        L_0x0086:
            long r8 = com.loc.C1079cp.m3529c()     // Catch:{ Throwable -> 0x0114 }
            r1.mo13178b(r8)     // Catch:{ Throwable -> 0x0114 }
            r1.mo13176a((com.autonavi.aps.amapapi.model.AMapLocationServer) r2)     // Catch:{ Throwable -> 0x0114 }
            if (r2 == 0) goto L_0x009e
            java.lang.String r0 = r2.mo8804K()     // Catch:{ Throwable -> 0x0114 }
            com.amap.api.location.AMapLocation r8 = r2.clone()     // Catch:{ Throwable -> 0x0114 }
            r12 = r8
            r8 = r0
            r0 = r12
            goto L_0x009f
        L_0x009e:
            r8 = r0
        L_0x009f:
            com.amap.api.location.AMapLocationClientOption r9 = r13.f2820a     // Catch:{ Throwable -> 0x00b9 }
            boolean r9 = r9.mo8567p()     // Catch:{ Throwable -> 0x00b9 }
            if (r9 == 0) goto L_0x00c1
            com.loc.cv r9 = r13.f2826g     // Catch:{ Throwable -> 0x00b9 }
            if (r9 == 0) goto L_0x00c1
            com.loc.cv r9 = r13.f2826g     // Catch:{ Throwable -> 0x00b9 }
            com.amap.api.location.AMapLocationClientOption r10 = r13.f2820a     // Catch:{ Throwable -> 0x00b9 }
            long r10 = r10.mo8570s()     // Catch:{ Throwable -> 0x00b9 }
            com.amap.api.location.AMapLocation r8 = r9.mo13239a(r0, r8, r10)     // Catch:{ Throwable -> 0x00b9 }
            r0 = r8
            goto L_0x00c1
        L_0x00b9:
            r8 = move-exception
            java.lang.String r9 = "ALManager"
            java.lang.String r10 = "fixLastLocation"
            com.loc.CoreUtil.m3389a(r8, r9, r10)     // Catch:{ Throwable -> 0x0114 }
        L_0x00c1:
            android.os.Bundle r8 = new android.os.Bundle     // Catch:{ Throwable -> 0x00ea }
            r8.<init>()     // Catch:{ Throwable -> 0x00ea }
            if (r0 == 0) goto L_0x00db
            java.lang.String r9 = "loc"
            r8.putParcelable(r9, r0)     // Catch:{ Throwable -> 0x00ea }
            java.lang.String r0 = "nb"
            java.lang.String r9 = r2.mo8804K()     // Catch:{ Throwable -> 0x00ea }
            r8.putString(r0, r9)     // Catch:{ Throwable -> 0x00ea }
            java.lang.String r0 = "netUseTime"
            r8.putLong(r0, r3)     // Catch:{ Throwable -> 0x00ea }
        L_0x00db:
            android.os.Message r0 = android.os.Message.obtain()     // Catch:{ Throwable -> 0x00ea }
            r0.setData(r8)     // Catch:{ Throwable -> 0x00ea }
            r0.what = r7     // Catch:{ Throwable -> 0x00ea }
            com.loc.bz$c r3 = r13.f2821b     // Catch:{ Throwable -> 0x00ea }
            r3.sendMessage(r0)     // Catch:{ Throwable -> 0x00ea }
            goto L_0x00f2
        L_0x00ea:
            r0 = move-exception
            java.lang.String r3 = "ALManager"
            java.lang.String r4 = "apsLocation:callback"
            com.loc.CoreUtil.m3389a(r0, r3, r4)     // Catch:{ Throwable -> 0x0114 }
        L_0x00f2:
            android.content.Context r0 = r13.f2845z     // Catch:{ Throwable -> 0x0114 }
            com.loc.ReportUtil.m3429a((android.content.Context) r0, (com.loc.ReportEntity) r1)     // Catch:{ Throwable -> 0x0114 }
            if (r6 == 0) goto L_0x010e
            if (r5 == 0) goto L_0x010e
            r14.mo13194c()     // Catch:{ Throwable -> 0x0106 }
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = r14.mo13188a((boolean) r7)     // Catch:{ Throwable -> 0x0106 }
            m3272a((com.loc.Aps) r14, (com.autonavi.aps.amapapi.model.AMapLocationServer) r0)     // Catch:{ Throwable -> 0x0106 }
            goto L_0x010e
        L_0x0106:
            r0 = move-exception
            java.lang.String r1 = "ALManager"
            java.lang.String r3 = "apsLocation:doFirstNetLocate 2"
            com.loc.CoreUtil.m3389a(r0, r1, r3)     // Catch:{ Throwable -> 0x0114 }
        L_0x010e:
            if (r14 == 0) goto L_0x0125
        L_0x0110:
            r14.mo13197f()     // Catch:{ Throwable -> 0x0125 }
            goto L_0x0125
        L_0x0114:
            r0 = move-exception
            goto L_0x011b
        L_0x0116:
            r0 = move-exception
            goto L_0x0126
        L_0x0118:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x011b:
            java.lang.String r1 = "ALManager"
            java.lang.String r3 = "apsLocation"
            com.loc.CoreUtil.m3389a(r0, r1, r3)     // Catch:{ all -> 0x0116 }
            if (r14 == 0) goto L_0x0125
            goto L_0x0110
        L_0x0125:
            return r2
        L_0x0126:
            if (r14 == 0) goto L_0x012b
            r14.mo13197f()     // Catch:{ Throwable -> 0x012b }
        L_0x012b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.AmapLocationManager.m3275b(com.loc.cm):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* renamed from: b */
    static /* synthetic */ void m3277b(AmapLocationManager bzVar, Bundle bundle) {
        AMapLocation aMapLocation;
        AMapLocation aMapLocation2;
        long j = 0;
        Throwable th = null;
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                aMapLocation2 = (AMapLocation) bundle.getParcelable("loc");
                bzVar.f2843x = bundle.getString("nb");
                long j2 = bundle.getLong("netUseTime", 0);
                if (aMapLocation2 != null) {
                    try {
                        if (aMapLocation2.mo8484c() == 0 && bzVar.f2822c != null) {
                            bzVar.f2822c.mo13225c();
                            if (!TextUtils.isEmpty(aMapLocation2.mo8518l())) {
                                bzVar.f2822c.f3147y = aMapLocation2;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        j = j2;
                        CoreUtil.m3389a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                        th = th;
                        aMapLocation = null;
                        bzVar.m3265a(aMapLocation, th, j);
                    }
                }
                j = j2;
            } catch (Throwable th3) {
                th = th3;
                CoreUtil.m3389a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                th = th;
                aMapLocation = null;
                bzVar.m3265a(aMapLocation, th, j);
            }
        } else {
            aMapLocation2 = null;
        }
        aMapLocation = bzVar.f2822c != null ? bzVar.f2822c.mo13218a(aMapLocation2, bzVar.f2843x) : aMapLocation2;
        bzVar.m3265a(aMapLocation, th, j);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035 A[Catch:{ Throwable -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m3278b(com.loc.AmapLocationManager r3, android.os.Message r4) {
        /*
            android.os.Bundle r4 = r4.getData()     // Catch:{ Throwable -> 0x003b }
            java.lang.String r0 = "loc"
            android.os.Parcelable r0 = r4.getParcelable(r0)     // Catch:{ Throwable -> 0x003b }
            com.amap.api.location.AMapLocation r0 = (com.amap.api.location.AMapLocation) r0     // Catch:{ Throwable -> 0x003b }
            java.lang.String r1 = "lastLocNb"
            java.lang.String r4 = r4.getString(r1)     // Catch:{ Throwable -> 0x003b }
            if (r0 == 0) goto L_0x002d
            r1 = 0
            com.loc.bw r2 = com.loc.LastLocationManager.f3162b     // Catch:{ Throwable -> 0x002d }
            if (r2 != 0) goto L_0x0024
            com.loc.cv r2 = r3.f2826g     // Catch:{ Throwable -> 0x002d }
            if (r2 == 0) goto L_0x002a
            com.loc.cv r1 = r3.f2826g     // Catch:{ Throwable -> 0x002d }
            com.amap.api.location.AMapLocation r1 = r1.mo13242b()     // Catch:{ Throwable -> 0x002d }
            goto L_0x002a
        L_0x0024:
            com.loc.bw r1 = com.loc.LastLocationManager.f3162b     // Catch:{ Throwable -> 0x002d }
            com.amap.api.location.AMapLocation r1 = r1.mo13131a()     // Catch:{ Throwable -> 0x002d }
        L_0x002a:
            com.loc.ReportUtil.m3434a((com.amap.api.location.AMapLocation) r1, (com.amap.api.location.AMapLocation) r0)     // Catch:{ Throwable -> 0x002d }
        L_0x002d:
            com.loc.cv r1 = r3.f2826g     // Catch:{ Throwable -> 0x003b }
            boolean r4 = r1.mo13241a(r0, r4)     // Catch:{ Throwable -> 0x003b }
            if (r4 == 0) goto L_0x003a
            com.loc.cv r3 = r3.f2826g     // Catch:{ Throwable -> 0x003b }
            r3.mo13244d()     // Catch:{ Throwable -> 0x003b }
        L_0x003a:
            return
        L_0x003b:
            r3 = move-exception
            java.lang.String r4 = "ALManager"
            java.lang.String r0 = "doSaveLastLocation"
            com.loc.CoreUtil.m3389a(r3, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.AmapLocationManager.m3278b(com.loc.bz, android.os.Message):void");
    }

    /* renamed from: b */
    static /* synthetic */ void m3279b(AmapLocationManager bzVar, AMapLocationListener bVar) {
        if (!bzVar.f2823d.isEmpty() && bzVar.f2823d.contains(bVar)) {
            bzVar.f2823d.remove(bVar);
        }
        if (bzVar.f2823d.isEmpty()) {
            bzVar.m3290h();
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m3282c(AmapLocationManager bzVar, Message message) {
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    int i = data.getInt("i", 0);
                    Intent k = bzVar.m3294k();
                    k.putExtra("i", i);
                    k.putExtra(C1108h.f3352f, (Notification) data.getParcelable(C1108h.f3352f));
                    k.putExtra(C1108h.f3351e, 1);
                    bzVar.m3264a(k, true);
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ALManager", "doEnableBackgroundLocation");
            }
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m3283d(AmapLocationManager bzVar) {
        try {
            if (bzVar.f2816C) {
                bzVar.f2816C = false;
                AMapLocationServer b = bzVar.m3275b(new Aps());
                if (bzVar.m3287f()) {
                    Bundle bundle = new Bundle();
                    String str = "0";
                    if (b != null && (b.mo8475a() == 2 || b.mo8475a() == 4)) {
                        str = "1";
                    }
                    bundle.putBundle("optBundle", CoreUtil.m3382a(bzVar.f2820a));
                    bundle.putString("isCacheLoc", str);
                    bzVar.m3262a(0, bundle);
                }
            } else {
                if (bzVar.f2836q && !bzVar.mo13147d() && !bzVar.f2841v) {
                    bzVar.f2841v = true;
                    bzVar.m3293j();
                }
                if (bzVar.m3287f()) {
                    bzVar.f2841v = false;
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("optBundle", CoreUtil.m3382a(bzVar.f2820a));
                    bundle2.putString("d", UmidtokenInfo.m544a());
                    if (!bzVar.f2822c.mo13224b()) {
                        bzVar.m3262a(1, bundle2);
                    }
                }
            }
        } catch (Throwable th) {
            try {
                CoreUtil.m3389a(th, "ALManager", "doLBSLocation");
                try {
                    if (!bzVar.f2820a.mo8554d()) {
                        bzVar.m3292i();
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        try {
            if (!bzVar.f2820a.mo8554d()) {
                bzVar.m3292i();
                return;
            }
            return;
        } catch (Throwable unused3) {
            return;
        }
        throw th;
    }

    /* renamed from: d */
    static /* synthetic */ void m3284d(AmapLocationManager bzVar, Message message) {
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    boolean z = data.getBoolean(C1108h.f3355i, true);
                    Intent k = bzVar.m3294k();
                    k.putExtra(C1108h.f3355i, z);
                    k.putExtra(C1108h.f3351e, 2);
                    bzVar.m3264a(k, false);
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ALManager", "doDisableBackgroundLocation");
            }
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m3286f(AmapLocationManager bzVar) {
        ReportUtil clVar;
        Context context;
        int i;
        bzVar.f2822c.mo13223b(bzVar.f2820a);
        if (bzVar.f2815B && !bzVar.f2820a.mo8559h().equals(bzVar.f2833n)) {
            bzVar.m3290h();
            bzVar.m3288g();
        }
        bzVar.f2833n = bzVar.f2820a.mo8559h();
        if (bzVar.f2835p != null) {
            if (bzVar.f2820a.mo8554d()) {
                clVar = bzVar.f2835p;
                context = bzVar.f2845z;
                i = 0;
            } else {
                clVar = bzVar.f2835p;
                context = bzVar.f2845z;
                i = 1;
            }
            clVar.mo13180a(context, i);
            bzVar.f2835p.mo13181a(bzVar.f2845z, bzVar.f2820a);
        }
    }

    /* renamed from: f */
    private boolean m3287f() {
        boolean z = false;
        int i = 0;
        do {
            try {
                if (this.f2827h != null) {
                    break;
                }
                Thread.sleep(100);
                i++;
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ALManager", "checkAPSManager");
            }
        } while (i < 50);
        if (this.f2827h == null) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.mo8485c(10);
            aMapLocation.mo8478a(!C1079cp.m3557l(this.f2845z.getApplicationContext()) ? "请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003" : "启动ApsServcie失败#1001");
            bundle.putParcelable("loc", aMapLocation);
            obtain.setData(bundle);
            obtain.what = 1;
            this.f2821b.sendMessage(obtain);
        } else {
            z = true;
        }
        if (!z) {
            ReportUtil.m3435a((String) null, !C1079cp.m3557l(this.f2845z.getApplicationContext()) ? 2103 : MsgField.IMSG_MODE_SHOWING);
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005e, code lost:
        return;
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m3288g() {
        /*
            r6 = this;
            monitor-enter(r6)
            com.amap.api.location.AMapLocationClientOption r0 = r6.f2820a     // Catch:{ all -> 0x005f }
            if (r0 != 0) goto L_0x000c
            com.amap.api.location.AMapLocationClientOption r0 = new com.amap.api.location.AMapLocationClientOption     // Catch:{ all -> 0x005f }
            r0.<init>()     // Catch:{ all -> 0x005f }
            r6.f2820a = r0     // Catch:{ all -> 0x005f }
        L_0x000c:
            boolean r0 = r6.f2815B     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r6)
            return
        L_0x0012:
            r0 = 1
            r6.f2815B = r0     // Catch:{ all -> 0x005f }
            int[] r0 = com.loc.AmapLocationManager.C10702.f2847a     // Catch:{ all -> 0x005f }
            com.amap.api.location.AMapLocationClientOption r1 = r6.f2820a     // Catch:{ all -> 0x005f }
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = r1.mo8559h()     // Catch:{ all -> 0x005f }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x005f }
            r0 = r0[r1]     // Catch:{ all -> 0x005f }
            r1 = 1015(0x3f7, float:1.422E-42)
            r2 = 1016(0x3f8, float:1.424E-42)
            r3 = 0
            r5 = 0
            switch(r0) {
                case 1: goto L_0x0053;
                case 2: goto L_0x004b;
                case 3: goto L_0x002e;
                default: goto L_0x002d;
            }     // Catch:{ all -> 0x005f }
        L_0x002d:
            goto L_0x005d
        L_0x002e:
            r6.m3263a((int) r1, (java.lang.Object) r5, (long) r3)     // Catch:{ all -> 0x005f }
            com.amap.api.location.AMapLocationClientOption r0 = r6.f2820a     // Catch:{ all -> 0x005f }
            boolean r0 = r0.mo8562k()     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x0047
            com.amap.api.location.AMapLocationClientOption r0 = r6.f2820a     // Catch:{ all -> 0x005f }
            boolean r0 = r0.mo8554d()     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x0047
            com.amap.api.location.AMapLocationClientOption r0 = r6.f2820a     // Catch:{ all -> 0x005f }
            long r3 = r0.mo8563l()     // Catch:{ all -> 0x005f }
        L_0x0047:
            r6.m3263a((int) r2, (java.lang.Object) r5, (long) r3)     // Catch:{ all -> 0x005f }
            goto L_0x005d
        L_0x004b:
            r6.m3261a((int) r2)     // Catch:{ all -> 0x005f }
            r6.m3263a((int) r1, (java.lang.Object) r5, (long) r3)     // Catch:{ all -> 0x005f }
            monitor-exit(r6)
            return
        L_0x0053:
            r0 = 1017(0x3f9, float:1.425E-42)
            r6.m3263a((int) r0, (java.lang.Object) r5, (long) r3)     // Catch:{ all -> 0x005f }
            r6.m3263a((int) r2, (java.lang.Object) r5, (long) r3)     // Catch:{ all -> 0x005f }
            monitor-exit(r6)
            return
        L_0x005d:
            monitor-exit(r6)
            return
        L_0x005f:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.AmapLocationManager.m3288g():void");
    }

    /* renamed from: g */
    static /* synthetic */ void m3289g(AmapLocationManager bzVar) {
        try {
            if (bzVar.f2827h != null) {
                bzVar.f2830k = 0;
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", CoreUtil.m3382a(bzVar.f2820a));
                bzVar.m3262a(2, bundle);
                return;
            }
            bzVar.f2830k++;
            if (bzVar.f2830k < 10) {
                bzVar.m3263a(1008, (Object) null, 50);
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ALManager", "startAssistantLocationImpl");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m3290h() {
        try {
            m3261a(1025);
            if (this.f2822c != null) {
                this.f2822c.mo13219a();
            }
            m3261a((int) PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
            this.f2815B = false;
            this.f2830k = 0;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ALManager", "stopLocation");
        }
    }

    /* renamed from: h */
    static /* synthetic */ void m3291h(AmapLocationManager bzVar) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBundle("optBundle", CoreUtil.m3382a(bzVar.f2820a));
            bzVar.m3262a(3, bundle);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ALManager", "stopAssistantLocationImpl");
        }
    }

    /* renamed from: i */
    private void m3292i() {
        if (this.f2820a.mo8559h() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            long j = 1000;
            if (this.f2820a.mo8551c() >= 1000) {
                j = this.f2820a.mo8551c();
            }
            m3263a((int) PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, (Object) null, j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m3293j() {
        try {
            if (this.f2828i == null) {
                this.f2828i = new Messenger(this.f2821b);
            }
            this.f2845z.bindService(m3294k(), this.f2819G, 1);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: k */
    private Intent m3294k() {
        String str;
        if (this.f2829j == null) {
            this.f2829j = new Intent(this.f2845z, APSService.class);
        }
        try {
            str = !TextUtils.isEmpty(AMapLocationClientOption.m479a()) ? AMapLocationClientOption.m479a() : AppInfo.m3666f(this.f2845z);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ALManager", "startServiceImpl p2");
            str = "";
        }
        this.f2829j.putExtra("a", str);
        this.f2829j.putExtra("b", AppInfo.m3663c(this.f2845z));
        this.f2829j.putExtra("d", UmidtokenInfo.m544a());
        this.f2829j.putExtra(C1108h.f3354h, AMapLocationClientOption.m484u());
        return this.f2829j;
    }

    /* renamed from: l */
    private boolean m3295l() {
        if (C1079cp.m3556k(this.f2845z)) {
            int i = -1;
            try {
                i = Reflect.m3416b(((Application) this.f2845z.getApplicationContext()).getBaseContext(), "checkSelfPermission", "android.permission.FOREGROUND_SERVICE");
            } catch (Throwable unused) {
            }
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void mo8612a() {
        try {
            m3263a(1003, (Object) null, 0);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ALManager", "startLocation");
        }
    }

    /* renamed from: a */
    public void mo8613a(AMapLocationClientOption aMapLocationClientOption) {
        try {
            m3263a((int) PointerIconCompat.TYPE_ZOOM_IN, (Object) aMapLocationClientOption.clone(), 0);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ALManager", "setLocationOption");
        }
    }

    /* renamed from: a */
    public void mo8614a(AMapLocationListener bVar) {
        try {
            m3263a(1002, (Object) bVar, 0);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ALManager", "setLocationListener");
        }
    }

    /* renamed from: b */
    public void mo8615b() {
        try {
            m3263a(1004, (Object) null, 0);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ALManager", "stopLocation");
        }
    }

    /* renamed from: b */
    public void mo8616b(AMapLocationListener bVar) {
        try {
            m3263a((int) ARPMessageType.MSG_TYPE_RESUME_MUSIC, (Object) bVar, 0);
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ALManager", "unRegisterLocationListener");
        }
    }

    /* renamed from: c */
    public void mo8617c() {
        try {
            if (this.f2818F != null) {
                this.f2818F.mo13234a();
                this.f2818F = null;
            }
            m3263a(1011, (Object) null, 0);
            this.f2832m = true;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ALManager", "onDestroy");
        }
    }

    /* renamed from: d */
    public boolean mo13147d() {
        return this.f2814A;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo13148e() {
        m3262a(12, (Bundle) null);
        this.f2816C = true;
        this.f2825f = true;
        this.f2814A = false;
        this.f2836q = false;
        m3290h();
        if (this.f2835p != null) {
            this.f2835p.mo13182b(this.f2845z);
        }
        ReportUtil.m3425a(this.f2845z);
        if (this.f2837r != null) {
            this.f2837r.mo13209b().sendEmptyMessage(11);
        } else if (this.f2819G != null) {
            this.f2845z.unbindService(this.f2819G);
        }
        try {
            if (this.f2844y) {
                this.f2845z.stopService(m3294k());
            }
        } catch (Throwable unused) {
        }
        this.f2844y = false;
        if (this.f2823d != null) {
            this.f2823d.clear();
            this.f2823d = null;
        }
        this.f2819G = null;
        synchronized (this.f2834o) {
            if (this.f2842w != null) {
                this.f2842w.removeCallbacksAndMessages((Object) null);
            }
            this.f2842w = null;
        }
        if (this.f2831l != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    Reflect.m3410a((Object) this.f2831l, (Class<?>) HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused2) {
                }
            }
            this.f2831l.quit();
        }
        this.f2831l = null;
        if (this.f2821b != null) {
            this.f2821b.removeCallbacksAndMessages((Object) null);
        }
        if (this.f2826g != null) {
            this.f2826g.mo13243c();
            this.f2826g = null;
        }
    }
}
