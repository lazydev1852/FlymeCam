package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/* renamed from: com.loc.cr */
public final class ApsManager {

    /* renamed from: g */
    static boolean f3077g = false;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public LastLocationManager f3078A = null;

    /* renamed from: B */
    private boolean f3079B = true;

    /* renamed from: C */
    private String f3080C = "";

    /* renamed from: D */
    private final int f3081D = 5000;

    /* renamed from: E */
    private String f3082E = "jsonp1";

    /* renamed from: a */
    String f3083a = null;

    /* renamed from: b */
    C1082b f3084b = null;

    /* renamed from: c */
    AMapLocation f3085c = null;

    /* renamed from: d */
    C1081a f3086d = null;

    /* renamed from: e */
    Context f3087e = null;

    /* renamed from: f */
    Aps f3088f = null;

    /* renamed from: h */
    HashMap<Messenger, Long> f3089h = new HashMap<>();

    /* renamed from: i */
    ReportUtil f3090i = null;

    /* renamed from: j */
    long f3091j = 0;

    /* renamed from: k */
    long f3092k = 0;

    /* renamed from: l */
    String f3093l = null;

    /* renamed from: m */
    AMapLocationClientOption f3094m = null;

    /* renamed from: n */
    AMapLocationClientOption f3095n = new AMapLocationClientOption();

    /* renamed from: o */
    ServerSocket f3096o = null;

    /* renamed from: p */
    boolean f3097p = false;

    /* renamed from: q */
    Socket f3098q = null;

    /* renamed from: r */
    boolean f3099r = false;

    /* renamed from: s */
    C1083c f3100s = null;

    /* renamed from: t */
    private boolean f3101t = false;

    /* renamed from: u */
    private boolean f3102u = false;

    /* renamed from: v */
    private long f3103v = 0;

    /* renamed from: w */
    private long f3104w = 0;

    /* renamed from: x */
    private AMapLocationServer f3105x = null;

    /* renamed from: y */
    private long f3106y = 0;

    /* renamed from: z */
    private int f3107z = 0;

    /* renamed from: com.loc.cr$a */
    /* compiled from: ApsManager */
    public class C1081a extends Handler {
        public C1081a(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x004f A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0056 A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005d A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0069 A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0074 A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x007f A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x008a A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0095 A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00aa A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00bf A[Catch:{ Throwable -> 0x00d8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00ca A[Catch:{ Throwable -> 0x00d8 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r7) {
            /*
                r6 = this;
                r0 = 0
                android.os.Bundle r1 = r7.getData()     // Catch:{ Throwable -> 0x003e }
                android.os.Messenger r2 = r7.replyTo     // Catch:{ Throwable -> 0x003b }
                if (r1 == 0) goto L_0x0048
                boolean r3 = r1.isEmpty()     // Catch:{ Throwable -> 0x0039 }
                if (r3 != 0) goto L_0x0048
                java.lang.String r3 = "c"
                java.lang.String r3 = r1.getString(r3)     // Catch:{ Throwable -> 0x0039 }
                com.loc.cr r4 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x0039 }
                boolean r3 = r4.mo13208a((java.lang.String) r3)     // Catch:{ Throwable -> 0x0039 }
                if (r3 != 0) goto L_0x0048
                int r3 = r7.what     // Catch:{ Throwable -> 0x0039 }
                r4 = 1
                if (r3 != r4) goto L_0x0038
                r3 = 2102(0x836, float:2.946E-42)
                com.loc.ReportUtil.m3435a((java.lang.String) r0, (int) r3)     // Catch:{ Throwable -> 0x0039 }
                com.loc.cr r3 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x0039 }
                java.lang.String r3 = "invalid handlder scode!!!#1002"
                com.autonavi.aps.amapapi.model.AMapLocationServer r3 = com.loc.ApsManager.m3560a(10, (java.lang.String) r3)     // Catch:{ Throwable -> 0x0039 }
                com.loc.cr r4 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x0039 }
                java.lang.String r5 = r3.mo8804K()     // Catch:{ Throwable -> 0x0039 }
                r4.m3565a((android.os.Messenger) r2, (com.amap.api.location.AMapLocation) r3, (java.lang.String) r5, 0)     // Catch:{ Throwable -> 0x0039 }
            L_0x0038:
                return
            L_0x0039:
                r3 = move-exception
                goto L_0x0041
            L_0x003b:
                r3 = move-exception
                r2 = r0
                goto L_0x0041
            L_0x003e:
                r3 = move-exception
                r1 = r0
                r2 = r1
            L_0x0041:
                java.lang.String r4 = "ApsServiceCore"
                java.lang.String r5 = "ActionHandler handlerMessage"
                com.loc.CoreUtil.m3389a(r3, r4, r5)     // Catch:{ Throwable -> 0x00d8 }
            L_0x0048:
                int r3 = r7.what     // Catch:{ Throwable -> 0x00d8 }
                switch(r3) {
                    case 0: goto L_0x00ca;
                    case 1: goto L_0x00bf;
                    case 2: goto L_0x00aa;
                    case 3: goto L_0x0095;
                    case 4: goto L_0x008a;
                    case 5: goto L_0x007f;
                    case 6: goto L_0x004d;
                    case 7: goto L_0x0074;
                    case 8: goto L_0x004d;
                    case 9: goto L_0x0069;
                    case 10: goto L_0x005d;
                    case 11: goto L_0x0056;
                    case 12: goto L_0x004f;
                    default: goto L_0x004d;
                }     // Catch:{ Throwable -> 0x00d8 }
            L_0x004d:
                goto L_0x00d4
            L_0x004f:
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                r0.f3089h.remove(r2)     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x0056:
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                r0.mo13213e()     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x005d:
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                r0.m3562a((android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                r0.mo13207a((android.os.Messenger) r2, (android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x0069:
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                r0.m3562a((android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                com.loc.ApsManager.m3569a((com.loc.ApsManager) r0, (android.os.Messenger) r2)     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x0074:
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                r0.m3562a((android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                com.loc.ApsManager.m3579c((com.loc.ApsManager) r0)     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x007f:
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                r0.m3562a((android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                com.loc.ApsManager.m3576b((com.loc.ApsManager) r0)     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x008a:
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                r0.m3562a((android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                com.loc.ApsManager.m3567a((com.loc.ApsManager) r0)     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x0095:
                if (r1 == 0) goto L_0x00a9
                boolean r1 = r1.isEmpty()     // Catch:{ Throwable -> 0x00d8 }
                if (r1 == 0) goto L_0x009e
                goto L_0x00a9
            L_0x009e:
                com.loc.cr r1 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                r1.m3562a((android.os.Bundle) r0)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                r0.mo13212d()     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x00a9:
                return
            L_0x00aa:
                if (r1 == 0) goto L_0x00be
                boolean r1 = r1.isEmpty()     // Catch:{ Throwable -> 0x00d8 }
                if (r1 == 0) goto L_0x00b3
                goto L_0x00be
            L_0x00b3:
                com.loc.cr r1 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                r1.m3562a((android.os.Bundle) r0)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                r0.mo13211c()     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x00be:
                return
            L_0x00bf:
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                r0.m3562a((android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                com.loc.ApsManager.m3578b(r0, r2, r1)     // Catch:{ Throwable -> 0x00d8 }
                goto L_0x00d4
            L_0x00ca:
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                r0.m3562a((android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
                com.loc.cr r0 = com.loc.ApsManager.this     // Catch:{ Throwable -> 0x00d8 }
                com.loc.ApsManager.m3570a((com.loc.ApsManager) r0, (android.os.Messenger) r2, (android.os.Bundle) r1)     // Catch:{ Throwable -> 0x00d8 }
            L_0x00d4:
                super.handleMessage(r7)     // Catch:{ Throwable -> 0x00d8 }
                return
            L_0x00d8:
                r7 = move-exception
                java.lang.String r0 = "actionHandler"
                java.lang.String r1 = "handleMessage"
                com.loc.CoreUtil.m3389a(r7, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.ApsManager.C1081a.handleMessage(android.os.Message):void");
        }
    }

    /* renamed from: com.loc.cr$b */
    /* compiled from: ApsManager */
    class C1082b extends HandlerThread {
        public C1082b(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            try {
                LastLocationManager unused = ApsManager.this.f3078A = new LastLocationManager(ApsManager.this.f3087e);
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "APSManager$ActionThread", "onLooperPrepared");
                return;
            }
            ApsManager.this.f3088f = new Aps();
            super.onLooperPrepared();
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "APSManager$ActionThread", "run");
            }
        }
    }

    /* renamed from: com.loc.cr$c */
    /* compiled from: ApsManager */
    class C1083c extends Thread {
        C1083c() {
        }

        public final void run() {
            try {
                if (!ApsManager.this.f3097p) {
                    ApsManager.this.f3097p = true;
                    ApsManager.this.f3096o = new ServerSocket(43689);
                }
                while (ApsManager.this.f3097p && ApsManager.this.f3096o != null) {
                    ApsManager.this.f3098q = ApsManager.this.f3096o.accept();
                    ApsManager.m3572a(ApsManager.this, ApsManager.this.f3098q);
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ApsServiceCore", "run");
            }
            super.run();
        }
    }

    public ApsManager(Context context) {
        this.f3087e = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static AMapLocationServer m3560a(int i, String str) {
        try {
            AMapLocationServer aMapLocationServer = new AMapLocationServer("");
            aMapLocationServer.mo8485c(i);
            aMapLocationServer.mo8478a(str);
            return aMapLocationServer;
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3562a(Bundle bundle) {
        try {
            if (!this.f3101t) {
                CoreUtil.m3387a(this.f3087e);
                if (bundle != null) {
                    this.f3095n = CoreUtil.m3384a(bundle.getBundle("optBundle"));
                }
                this.f3088f.mo13190a(this.f3087e);
                this.f3088f.mo13189a();
                m3566a(this.f3095n);
                this.f3088f.mo13193b();
                this.f3101t = true;
                this.f3079B = true;
                this.f3080C = "";
            }
        } catch (Throwable th) {
            this.f3079B = false;
            this.f3080C = th.getMessage();
            CoreUtil.m3389a(th, "ApsServiceCore", "init");
        }
    }

    /* renamed from: a */
    private void m3563a(Messenger messenger) {
        try {
            Aps cmVar = this.f3088f;
            Aps.m3454b(this.f3087e);
            if (AuthUtil.m3366k()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("ngpsAble", AuthUtil.m3368m());
                m3564a(messenger, 7, bundle);
                AuthUtil.m3367l();
            }
            if (AuthUtil.m3376u()) {
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("installMockApp", true);
                m3564a(messenger, 9, bundle2);
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ApsServiceCore", "initAuth");
        }
    }

    /* renamed from: a */
    private static void m3564a(Messenger messenger, int i, Bundle bundle) {
        if (messenger != null) {
            try {
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = i;
                messenger.send(obtain);
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ApsServiceCore", "sendMessage");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3565a(Messenger messenger, AMapLocation aMapLocation, String str, long j) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putLong("netUseTime", j);
        this.f3089h.put(messenger, Long.valueOf(C1079cp.m3529c()));
        m3564a(messenger, 1, bundle);
    }

    /* renamed from: a */
    private void m3566a(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (this.f3088f != null) {
                this.f3088f.mo13191a(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                f3077g = aMapLocationClientOption.mo8561j();
                if (!(this.f3094m == null || (aMapLocationClientOption.mo8566o() == this.f3094m.mo8566o() && aMapLocationClientOption.mo8556e() == this.f3094m.mo8556e() && aMapLocationClientOption.mo8567p() == this.f3094m.mo8567p() && this.f3094m.mo8571t() == aMapLocationClientOption.mo8571t()))) {
                    this.f3104w = 0;
                    this.f3085c = null;
                }
                this.f3094m = aMapLocationClientOption;
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ApsServiceCore", "setExtra");
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m3567a(ApsManager crVar) {
        try {
            if (crVar.f3107z < AuthUtil.m3348b()) {
                crVar.f3107z++;
                crVar.f3088f.mo13196e();
                crVar.f3086d.sendEmptyMessageDelayed(4, 2000);
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ApsServiceCore", "doGpsFusion");
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m3569a(ApsManager crVar, Messenger messenger) {
        try {
            crVar.m3563a(messenger);
            AuthUtil.m3355e(crVar.f3087e);
            try {
                Aps cmVar = crVar.f3088f;
                Context context = crVar.f3087e;
                cmVar.mo13199h();
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ApsServiceCore", "doCallOtherSer");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:8|9|10|11|12|(1:16)|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0020 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m3570a(com.loc.ApsManager r2, android.os.Messenger r3, android.os.Bundle r4) {
        /*
            if (r4 == 0) goto L_0x0050
            boolean r0 = r4.isEmpty()     // Catch:{ Throwable -> 0x0048 }
            if (r0 == 0) goto L_0x0009
            goto L_0x0050
        L_0x0009:
            boolean r0 = r2.f3102u     // Catch:{ Throwable -> 0x0048 }
            if (r0 == 0) goto L_0x000e
            return
        L_0x000e:
            r0 = 1
            r2.f3102u = r0     // Catch:{ Throwable -> 0x0048 }
            r2.m3563a((android.os.Messenger) r3)     // Catch:{ Throwable -> 0x0048 }
            android.content.Context r3 = r2.f3087e     // Catch:{ Throwable -> 0x0048 }
            com.loc.AuthUtil.m3355e(r3)     // Catch:{ Throwable -> 0x0048 }
            com.loc.cm r3 = r2.f3088f     // Catch:{ Throwable -> 0x0020 }
            android.content.Context r0 = r2.f3087e     // Catch:{ Throwable -> 0x0020 }
            r3.mo13198g()     // Catch:{ Throwable -> 0x0020 }
        L_0x0020:
            r2.m3582g()     // Catch:{ Throwable -> 0x0048 }
            long r0 = r2.f3106y     // Catch:{ Throwable -> 0x0048 }
            boolean r3 = com.loc.AuthUtil.m3343a((long) r0)     // Catch:{ Throwable -> 0x0048 }
            if (r3 == 0) goto L_0x0044
            java.lang.String r3 = "1"
            java.lang.String r0 = "isCacheLoc"
            java.lang.String r4 = r4.getString(r0)     // Catch:{ Throwable -> 0x0048 }
            boolean r3 = r3.equals(r4)     // Catch:{ Throwable -> 0x0048 }
            if (r3 == 0) goto L_0x0044
            long r3 = com.loc.C1079cp.m3529c()     // Catch:{ Throwable -> 0x0048 }
            r2.f3106y = r3     // Catch:{ Throwable -> 0x0048 }
            com.loc.cm r3 = r2.f3088f     // Catch:{ Throwable -> 0x0048 }
            r3.mo13196e()     // Catch:{ Throwable -> 0x0048 }
        L_0x0044:
            r2.m3584i()     // Catch:{ Throwable -> 0x0048 }
            return
        L_0x0048:
            r2 = move-exception
            java.lang.String r3 = "ApsServiceCore"
            java.lang.String r4 = "doInitAuth"
            com.loc.CoreUtil.m3389a(r2, r3, r4)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ApsManager.m3570a(com.loc.cr, android.os.Messenger, android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        r2.close();
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0109, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        com.loc.CoreUtil.m3389a(r7, "ApsServiceCore", "invokeSocketLocation part3");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0112, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0113, code lost:
        com.loc.CoreUtil.m3389a(r6, "ApsServiceCore", "invokeSocketLocation part4");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x011a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        com.loc.CoreUtil.m3389a(r6, "ApsServiceCore", "invokeSocketLocation part3");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r2.close();
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0053, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        com.loc.CoreUtil.m3389a(r7, "ApsServiceCore", "invokeSocketLocation part3");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00a7, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r2.close();
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00c8, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        com.loc.CoreUtil.m3389a(r7, "ApsServiceCore", "invokeSocketLocation part3");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x00ea, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:13:0x0022, B:24:0x0039, B:34:0x004c, B:46:0x0064, B:66:0x00ae, B:76:0x00c1, B:98:0x00f1, B:106:0x0102] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m3572a(com.loc.ApsManager r6, java.net.Socket r7) {
        /*
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            int r0 = com.loc.CoreUtil.f2982f     // Catch:{ Throwable -> 0x0112 }
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x0062, all -> 0x005e }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Throwable -> 0x0062, all -> 0x005e }
            java.io.InputStream r4 = r7.getInputStream()     // Catch:{ Throwable -> 0x0062, all -> 0x005e }
            java.lang.String r5 = "UTF-8"
            r3.<init>(r4, r5)     // Catch:{ Throwable -> 0x0062, all -> 0x005e }
            r2.<init>(r3)     // Catch:{ Throwable -> 0x0062, all -> 0x005e }
            r6.m3573a((java.io.BufferedReader) r2)     // Catch:{ Throwable -> 0x005c }
            java.lang.String r3 = r6.m3583h()     // Catch:{ Throwable -> 0x005c }
            com.loc.CoreUtil.f2982f = r0     // Catch:{ Throwable -> 0x0112 }
            r6.m3580c((java.lang.String) r3)     // Catch:{ Throwable -> 0x0034 }
            r2.close()     // Catch:{ Throwable -> 0x0029 }
            r7.close()     // Catch:{ Throwable -> 0x0029 }
            return
        L_0x0029:
            r6 = move-exception
            java.lang.String r7 = "ApsServiceCore"
            java.lang.String r0 = "invokeSocketLocation part3"
            com.loc.CoreUtil.m3389a(r6, r7, r0)     // Catch:{ Throwable -> 0x0112 }
            return
        L_0x0032:
            r6 = move-exception
            goto L_0x004c
        L_0x0034:
            r6 = move-exception
            java.lang.String r0 = "ApsServiceCore"
            java.lang.String r1 = "invokeSocketLocation part2"
            com.loc.CoreUtil.m3389a(r6, r0, r1)     // Catch:{ all -> 0x0032 }
            r2.close()     // Catch:{ Throwable -> 0x0043 }
            r7.close()     // Catch:{ Throwable -> 0x0043 }
            return
        L_0x0043:
            r6 = move-exception
            java.lang.String r7 = "ApsServiceCore"
            java.lang.String r0 = "invokeSocketLocation part3"
            com.loc.CoreUtil.m3389a(r6, r7, r0)     // Catch:{ Throwable -> 0x0112 }
            return
        L_0x004c:
            r2.close()     // Catch:{ Throwable -> 0x0053 }
            r7.close()     // Catch:{ Throwable -> 0x0053 }
            goto L_0x005b
        L_0x0053:
            r7 = move-exception
            java.lang.String r0 = "ApsServiceCore"
            java.lang.String r1 = "invokeSocketLocation part3"
            com.loc.CoreUtil.m3389a(r7, r0, r1)     // Catch:{ Throwable -> 0x0112 }
        L_0x005b:
            throw r6     // Catch:{ Throwable -> 0x0112 }
        L_0x005c:
            r3 = move-exception
            goto L_0x0064
        L_0x005e:
            r3 = move-exception
            r2 = r1
            goto L_0x00d5
        L_0x0062:
            r3 = move-exception
            r2 = r1
        L_0x0064:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d4 }
            r4.<init>()     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = r6.f3082E     // Catch:{ all -> 0x00d4 }
            r4.append(r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = "&&"
            r4.append(r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = r6.f3082E     // Catch:{ all -> 0x00d4 }
            r4.append(r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = "({'package':'"
            r4.append(r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = r6.f3083a     // Catch:{ all -> 0x00d4 }
            r4.append(r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = "','error_code':1,'error':'params error'})"
            r4.append(r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00d4 }
            java.lang.String r1 = "ApsServiceCore"
            java.lang.String r5 = "invokeSocketLocation"
            com.loc.CoreUtil.m3389a(r3, r1, r5)     // Catch:{ all -> 0x00d1 }
            com.loc.CoreUtil.f2982f = r0     // Catch:{ Throwable -> 0x0112 }
            r6.m3580c((java.lang.String) r4)     // Catch:{ Throwable -> 0x00a9 }
            r2.close()     // Catch:{ Throwable -> 0x009e }
            r7.close()     // Catch:{ Throwable -> 0x009e }
            return
        L_0x009e:
            r6 = move-exception
            java.lang.String r7 = "ApsServiceCore"
            java.lang.String r0 = "invokeSocketLocation part3"
            com.loc.CoreUtil.m3389a(r6, r7, r0)     // Catch:{ Throwable -> 0x0112 }
            return
        L_0x00a7:
            r6 = move-exception
            goto L_0x00c1
        L_0x00a9:
            r6 = move-exception
            java.lang.String r0 = "ApsServiceCore"
            java.lang.String r1 = "invokeSocketLocation part2"
            com.loc.CoreUtil.m3389a(r6, r0, r1)     // Catch:{ all -> 0x00a7 }
            r2.close()     // Catch:{ Throwable -> 0x00b8 }
            r7.close()     // Catch:{ Throwable -> 0x00b8 }
            return
        L_0x00b8:
            r6 = move-exception
            java.lang.String r7 = "ApsServiceCore"
            java.lang.String r0 = "invokeSocketLocation part3"
            com.loc.CoreUtil.m3389a(r6, r7, r0)     // Catch:{ Throwable -> 0x0112 }
            return
        L_0x00c1:
            r2.close()     // Catch:{ Throwable -> 0x00c8 }
            r7.close()     // Catch:{ Throwable -> 0x00c8 }
            goto L_0x00d0
        L_0x00c8:
            r7 = move-exception
            java.lang.String r0 = "ApsServiceCore"
            java.lang.String r1 = "invokeSocketLocation part3"
            com.loc.CoreUtil.m3389a(r7, r0, r1)     // Catch:{ Throwable -> 0x0112 }
        L_0x00d0:
            throw r6     // Catch:{ Throwable -> 0x0112 }
        L_0x00d1:
            r3 = move-exception
            r1 = r4
            goto L_0x00d5
        L_0x00d4:
            r3 = move-exception
        L_0x00d5:
            com.loc.CoreUtil.f2982f = r0     // Catch:{ Throwable -> 0x0112 }
            r6.m3580c((java.lang.String) r1)     // Catch:{ Throwable -> 0x00ec }
            r2.close()     // Catch:{ Throwable -> 0x00e1 }
            r7.close()     // Catch:{ Throwable -> 0x00e1 }
            goto L_0x0101
        L_0x00e1:
            r6 = move-exception
            java.lang.String r7 = "ApsServiceCore"
            java.lang.String r0 = "invokeSocketLocation part3"
        L_0x00e6:
            com.loc.CoreUtil.m3389a(r6, r7, r0)     // Catch:{ Throwable -> 0x0112 }
            goto L_0x0101
        L_0x00ea:
            r6 = move-exception
            goto L_0x0102
        L_0x00ec:
            r6 = move-exception
            java.lang.String r0 = "ApsServiceCore"
            java.lang.String r1 = "invokeSocketLocation part2"
            com.loc.CoreUtil.m3389a(r6, r0, r1)     // Catch:{ all -> 0x00ea }
            r2.close()     // Catch:{ Throwable -> 0x00fb }
            r7.close()     // Catch:{ Throwable -> 0x00fb }
            goto L_0x0101
        L_0x00fb:
            r6 = move-exception
            java.lang.String r7 = "ApsServiceCore"
            java.lang.String r0 = "invokeSocketLocation part3"
            goto L_0x00e6
        L_0x0101:
            throw r3     // Catch:{ Throwable -> 0x0112 }
        L_0x0102:
            r2.close()     // Catch:{ Throwable -> 0x0109 }
            r7.close()     // Catch:{ Throwable -> 0x0109 }
            goto L_0x0111
        L_0x0109:
            r7 = move-exception
            java.lang.String r0 = "ApsServiceCore"
            java.lang.String r1 = "invokeSocketLocation part3"
            com.loc.CoreUtil.m3389a(r7, r0, r1)     // Catch:{ Throwable -> 0x0112 }
        L_0x0111:
            throw r6     // Catch:{ Throwable -> 0x0112 }
        L_0x0112:
            r6 = move-exception
            java.lang.String r7 = "ApsServiceCore"
            java.lang.String r0 = "invokeSocketLocation part4"
            com.loc.CoreUtil.m3389a(r6, r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ApsManager.m3572a(com.loc.cr, java.net.Socket):void");
    }

    /* renamed from: a */
    private void m3573a(BufferedReader bufferedReader) throws Exception {
        String[] split;
        String[] split2;
        String[] split3;
        String readLine = bufferedReader.readLine();
        int i = 30000;
        if (readLine != null && readLine.length() > 0 && (split = readLine.split(" ")) != null && split.length > 1 && (split2 = split[1].split("\\?")) != null && split2.length > 1 && (split3 = split2[1].split("&")) != null && split3.length > 0) {
            int i2 = 30000;
            for (String split4 : split3) {
                String[] split5 = split4.split("=");
                if (split5 != null && split5.length > 1) {
                    if ("to".equals(split5[0])) {
                        i2 = C1079cp.m3548h(split5[1]);
                    }
                    if ("callback".equals(split5[0])) {
                        this.f3082E = split5[1];
                    }
                }
            }
            i = i2;
        }
        CoreUtil.f2982f = i;
    }

    /* renamed from: b */
    private AMapLocationClientOption m3574b(Bundle bundle) {
        AMapLocationClientOption a = CoreUtil.m3384a(bundle.getBundle("optBundle"));
        m3566a(a);
        try {
            String string = bundle.getString("d");
            if (!TextUtils.isEmpty(string)) {
                DeviceInfo.m3707a(string);
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "APSManager", "parseBundle");
        }
        return a;
    }

    /* renamed from: b */
    static /* synthetic */ void m3576b(ApsManager crVar) {
        Aps cmVar;
        try {
            if (AuthUtil.m3356e()) {
                cmVar = crVar.f3088f;
            } else {
                if (!C1079cp.m3541e(crVar.f3087e)) {
                    cmVar = crVar.f3088f;
                }
                crVar.f3086d.sendEmptyMessageDelayed(5, (long) (AuthUtil.m3353d() * 1000));
            }
            cmVar.mo13196e();
            crVar.f3086d.sendEmptyMessageDelayed(5, (long) (AuthUtil.m3353d() * 1000));
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ApsServiceCore", "doOffFusion");
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m3578b(ApsManager crVar, Messenger messenger, Bundle bundle) {
        String str;
        AMapLocation aMapLocation;
        ApsManager crVar2 = crVar;
        Messenger messenger2 = messenger;
        Bundle bundle2 = bundle;
        if (bundle2 != null) {
            try {
                if (!bundle.isEmpty()) {
                    AMapLocationClientOption b = crVar.m3574b(bundle2);
                    if (crVar2.f3089h.containsKey(messenger) && !b.mo8554d()) {
                        if (C1079cp.m3529c() - crVar2.f3089h.get(messenger).longValue() < 800) {
                            return;
                        }
                    }
                    AMapLocation aMapLocation2 = null;
                    if (!crVar2.f3079B) {
                        crVar2.f3105x = m3560a(9, "init error : " + crVar2.f3080C + "#0901");
                        crVar.m3565a(messenger, (AMapLocation) crVar2.f3105x, crVar2.f3105x.mo8804K(), 0);
                        ReportUtil.m3435a((String) null, 2091);
                        return;
                    }
                    long c = C1079cp.m3529c();
                    long j = 0;
                    if (!C1079cp.m3509a(crVar2.f3105x) || c - crVar2.f3104w >= 600) {
                        ReportEntity ckVar = new ReportEntity();
                        ckVar.mo13175a(C1079cp.m3529c());
                        crVar2.f3105x = crVar2.f3088f.mo13195d();
                        if (crVar2.f3105x.mo8475a() == 6 || crVar2.f3105x.mo8475a() == 5) {
                            j = crVar2.f3105x.mo8803J();
                        }
                        ckVar.mo13176a(crVar2.f3105x);
                        crVar2.f3105x = crVar2.f3088f.mo13187a(crVar2.f3105x, new String[0]);
                        long j2 = j;
                        ckVar.mo13178b(C1079cp.m3529c());
                        if (C1079cp.m3509a(crVar2.f3105x)) {
                            crVar2.f3104w = C1079cp.m3529c();
                        }
                        if (crVar2.f3105x == null) {
                            crVar2.f3105x = m3560a(8, "loc is null#0801");
                        }
                        if (crVar2.f3105x != null) {
                            String K = crVar2.f3105x.mo8804K();
                            aMapLocation2 = crVar2.f3105x.clone();
                            str = K;
                        } else {
                            str = null;
                        }
                        try {
                            aMapLocation = (!b.mo8567p() || crVar2.f3078A == null) ? aMapLocation2 : crVar2.f3078A.mo13239a(aMapLocation2, str, b.mo8570s());
                        } catch (Throwable th) {
                            CoreUtil.m3389a(th, "ApsServiceCore", "fixLastLocation");
                            aMapLocation = aMapLocation2;
                        }
                        crVar.m3565a(messenger, aMapLocation, str, j2);
                        ReportUtil.m3429a(crVar2.f3087e, ckVar);
                    } else {
                        crVar.m3565a(messenger, (AMapLocation) crVar2.f3105x, crVar2.f3105x.mo8804K(), 0);
                    }
                    crVar.m3563a(messenger);
                    if (AuthUtil.m3377v()) {
                        crVar.m3582g();
                    }
                    if (AuthUtil.m3343a(crVar2.f3106y) && crVar2.f3105x != null && (crVar2.f3105x.mo8475a() == 2 || crVar2.f3105x.mo8475a() == 4 || crVar2.f3105x.mo8475a() == 9)) {
                        crVar2.f3106y = C1079cp.m3529c();
                        crVar2.f3088f.mo13196e();
                    }
                    crVar.m3584i();
                }
            } catch (Throwable th2) {
                CoreUtil.m3389a(th2, "ApsServiceCore", "doLocation");
            }
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m3579c(ApsManager crVar) {
        try {
            if (AuthUtil.m3345a(crVar.f3087e, crVar.f3103v)) {
                crVar.f3103v = C1079cp.m3518b();
                crVar.f3088f.mo13196e();
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ApsServiceCore", "doNGps");
        }
    }

    /* renamed from: c */
    private void m3580c(String str) throws UnsupportedEncodingException, IOException {
        PrintStream printStream = new PrintStream(this.f3098q.getOutputStream(), true, "UTF-8");
        printStream.println("HTTP/1.0 200 OK");
        printStream.println("Content-Length:" + str.getBytes("UTF-8").length);
        printStream.println();
        printStream.println(str);
        printStream.close();
    }

    /* renamed from: f */
    public static void m3581f() {
        f3077g = false;
    }

    /* renamed from: g */
    private void m3582g() {
        try {
            this.f3086d.removeMessages(4);
            if (AuthUtil.m3342a()) {
                this.f3086d.sendEmptyMessage(4);
            }
            this.f3086d.removeMessages(5);
            if (AuthUtil.m3351c() && AuthUtil.m3353d() > 2) {
                this.f3086d.sendEmptyMessage(5);
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ApsServiceCore", "checkConfig");
        }
    }

    /* renamed from: h */
    private String m3583h() {
        StringBuilder sb;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        if (C1079cp.m3541e(this.f3087e)) {
            sb = new StringBuilder();
            sb.append(this.f3082E);
            sb.append("&&");
            sb.append(this.f3082E);
            sb.append("({'package':'");
            sb.append(this.f3083a);
            str = "','error_code':36,'error':'app is background'})";
        } else {
            if (this.f3105x == null || currentTimeMillis - this.f3105x.getTime() > 5000) {
                try {
                    this.f3105x = this.f3088f.mo13195d();
                } catch (Throwable th) {
                    CoreUtil.m3389a(th, "ApsServiceCore", "getSocketLocResult");
                }
            }
            if (this.f3105x == null) {
                sb = new StringBuilder();
                sb.append(this.f3082E);
                sb.append("&&");
                sb.append(this.f3082E);
                sb.append("({'package':'");
                sb.append(this.f3083a);
                str = "','error_code':8,'error':'unknown error'})";
            } else if (this.f3105x.mo8484c() != 0) {
                sb = new StringBuilder();
                sb.append(this.f3082E);
                sb.append("&&");
                sb.append(this.f3082E);
                sb.append("({'package':'");
                sb.append(this.f3083a);
                sb.append("','error_code':");
                sb.append(this.f3105x.mo8484c());
                sb.append(",'error':'");
                sb.append(this.f3105x.mo8489d());
                str = "'})";
            } else {
                sb = new StringBuilder();
                sb.append(this.f3082E);
                sb.append("&&");
                sb.append(this.f3082E);
                sb.append("({'package':'");
                sb.append(this.f3083a);
                sb.append("','error_code':0,'error':'','location':{'y':");
                sb.append(this.f3105x.getLatitude());
                sb.append(",'precision':");
                sb.append(this.f3105x.getAccuracy());
                sb.append(",'x':");
                sb.append(this.f3105x.getLongitude());
                str = "},'version_code':'4.7.2','version':'4.7.2'})";
            }
        }
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: i */
    private void m3584i() {
        try {
            if (this.f3088f != null) {
                this.f3088f.mo13202k();
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ApsServiceCore", "startColl");
        }
    }

    /* renamed from: a */
    public final void mo13205a() {
        try {
            this.f3090i = new ReportUtil();
            this.f3084b = new C1082b("amapLocCoreThread");
            this.f3084b.setPriority(5);
            this.f3084b.start();
            this.f3086d = new C1081a(this.f3084b.getLooper());
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ApsServiceCore", "onCreate");
        }
    }

    /* renamed from: a */
    public final void mo13206a(Intent intent) {
        if ("true".equals(intent.getStringExtra(AdvanceSetting.ADVANCE_SETTING)) && this.f3086d != null) {
            this.f3086d.sendEmptyMessageDelayed(9, 100);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo13207a(Messenger messenger, Bundle bundle) {
        float f;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    if (AuthUtil.m3373r()) {
                        double d = bundle.getDouble("lat");
                        double d2 = bundle.getDouble("lon");
                        m3574b(bundle);
                        if (this.f3085c != null) {
                            f = C1079cp.m3498a(new double[]{d, d2, this.f3085c.getLatitude(), this.f3085c.getLongitude()});
                            if (f < ((float) (AuthUtil.m3374s() * 3))) {
                                Bundle bundle2 = new Bundle();
                                bundle2.setClassLoader(AMapLocation.class.getClassLoader());
                                bundle2.putInt("I_MAX_GEO_DIS", AuthUtil.m3374s() * 3);
                                bundle2.putInt("I_MIN_GEO_DIS", AuthUtil.m3374s());
                                bundle2.putParcelable("loc", this.f3085c);
                                m3564a(messenger, 6, bundle2);
                            }
                        } else {
                            f = -1.0f;
                        }
                        if (f == -1.0f || f > ((float) AuthUtil.m3374s())) {
                            m3562a(bundle);
                            this.f3085c = this.f3088f.mo13186a(d, d2);
                        }
                    }
                }
            } catch (Throwable th) {
                CoreUtil.m3389a(th, "ApsServiceCore", "doLocationGeo");
            }
        }
    }

    /* renamed from: a */
    public final boolean mo13208a(String str) {
        if (TextUtils.isEmpty(this.f3093l)) {
            this.f3093l = CoreUtil.m3393b(this.f3087e);
        }
        return !TextUtils.isEmpty(str) && str.equals(this.f3093l);
    }

    /* renamed from: b */
    public final Handler mo13209b() {
        return this.f3086d;
    }

    /* renamed from: b */
    public final void mo13210b(Intent intent) {
        String stringExtra = intent.getStringExtra("a");
        if (!TextUtils.isEmpty(stringExtra)) {
            AuthConfigManager.m3671a(this.f3087e, stringExtra);
        }
        this.f3083a = intent.getStringExtra("b");
        AppInfo.m3659a(this.f3083a);
        String stringExtra2 = intent.getStringExtra("d");
        if (!TextUtils.isEmpty(stringExtra2)) {
            DeviceInfo.m3707a(stringExtra2);
        }
        AuthUtil.f2937a = intent.getBooleanExtra(C1108h.f3354h, true);
    }

    /* renamed from: c */
    public final void mo13211c() {
        try {
            if (!this.f3099r) {
                this.f3100s = new C1083c();
                this.f3100s.start();
                this.f3099r = true;
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ApsServiceCore", "startSocket");
        }
    }

    /* renamed from: d */
    public final void mo13212d() {
        try {
            if (this.f3098q != null) {
                this.f3098q.close();
            }
        } catch (Throwable th) {
            CoreUtil.m3389a(th, "ApsServiceCore", "doStopScocket 1");
        }
        try {
            if (this.f3096o != null) {
                this.f3096o.close();
            }
        } catch (Throwable th2) {
            CoreUtil.m3389a(th2, "ApsServiceCore", "doStopScocket 2");
        }
        try {
            if (this.f3100s != null) {
                this.f3100s.interrupt();
            }
        } catch (Throwable unused) {
        }
        this.f3100s = null;
        this.f3096o = null;
        this.f3097p = false;
        this.f3099r = false;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0033 */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo13213e() {
        /*
            r12 = this;
            java.util.HashMap<android.os.Messenger, java.lang.Long> r0 = r12.f3089h     // Catch:{ Throwable -> 0x00a4 }
            r0.clear()     // Catch:{ Throwable -> 0x00a4 }
            r0 = 0
            r12.f3089h = r0     // Catch:{ Throwable -> 0x00a4 }
            com.loc.cm r1 = r12.f3088f     // Catch:{ Throwable -> 0x00a4 }
            if (r1 == 0) goto L_0x0013
            com.loc.cm r1 = r12.f3088f     // Catch:{ Throwable -> 0x00a4 }
            android.content.Context r1 = r12.f3087e     // Catch:{ Throwable -> 0x00a4 }
            com.loc.Aps.m3454b((android.content.Context) r1)     // Catch:{ Throwable -> 0x00a4 }
        L_0x0013:
            com.loc.cr$a r1 = r12.f3086d     // Catch:{ Throwable -> 0x00a4 }
            if (r1 == 0) goto L_0x001c
            com.loc.cr$a r1 = r12.f3086d     // Catch:{ Throwable -> 0x00a4 }
            r1.removeCallbacksAndMessages(r0)     // Catch:{ Throwable -> 0x00a4 }
        L_0x001c:
            com.loc.cr$b r1 = r12.f3084b     // Catch:{ Throwable -> 0x00a4 }
            r2 = 0
            if (r1 == 0) goto L_0x003c
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x00a4 }
            r3 = 18
            if (r1 < r3) goto L_0x0039
            com.loc.cr$b r1 = r12.f3084b     // Catch:{ Throwable -> 0x0033 }
            java.lang.Class<android.os.HandlerThread> r3 = android.os.HandlerThread.class
            java.lang.String r4 = "quitSafely"
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0033 }
            com.loc.Reflect.m3410a((java.lang.Object) r1, (java.lang.Class<?>) r3, (java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ Throwable -> 0x0033 }
            goto L_0x003c
        L_0x0033:
            com.loc.cr$b r1 = r12.f3084b     // Catch:{ Throwable -> 0x00a4 }
        L_0x0035:
            r1.quit()     // Catch:{ Throwable -> 0x00a4 }
            goto L_0x003c
        L_0x0039:
            com.loc.cr$b r1 = r12.f3084b     // Catch:{ Throwable -> 0x00a4 }
            goto L_0x0035
        L_0x003c:
            r12.f3084b = r0     // Catch:{ Throwable -> 0x00a4 }
            r12.f3086d = r0     // Catch:{ Throwable -> 0x00a4 }
            com.loc.cv r1 = r12.f3078A     // Catch:{ Throwable -> 0x00a4 }
            if (r1 == 0) goto L_0x004b
            com.loc.cv r1 = r12.f3078A     // Catch:{ Throwable -> 0x00a4 }
            r1.mo13243c()     // Catch:{ Throwable -> 0x00a4 }
            r12.f3078A = r0     // Catch:{ Throwable -> 0x00a4 }
        L_0x004b:
            r12.mo13212d()     // Catch:{ Throwable -> 0x00a4 }
            r12.f3101t = r2     // Catch:{ Throwable -> 0x00a4 }
            r12.f3102u = r2     // Catch:{ Throwable -> 0x00a4 }
            com.loc.cm r0 = r12.f3088f     // Catch:{ Throwable -> 0x00a4 }
            r0.mo13197f()     // Catch:{ Throwable -> 0x00a4 }
            android.content.Context r0 = r12.f3087e     // Catch:{ Throwable -> 0x00a4 }
            com.loc.ReportUtil.m3425a((android.content.Context) r0)     // Catch:{ Throwable -> 0x00a4 }
            com.loc.cl r0 = r12.f3090i     // Catch:{ Throwable -> 0x00a4 }
            if (r0 == 0) goto L_0x0095
            long r0 = r12.f3091j     // Catch:{ Throwable -> 0x00a4 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0095
            long r0 = r12.f3092k     // Catch:{ Throwable -> 0x00a4 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0095
            long r0 = com.loc.C1079cp.m3529c()     // Catch:{ Throwable -> 0x00a4 }
            long r2 = r12.f3091j     // Catch:{ Throwable -> 0x00a4 }
            r4 = 0
            long r10 = r0 - r2
            com.loc.cl r0 = r12.f3090i     // Catch:{ Throwable -> 0x00a4 }
            android.content.Context r1 = r12.f3087e     // Catch:{ Throwable -> 0x00a4 }
            int r6 = r0.mo13183c(r1)     // Catch:{ Throwable -> 0x00a4 }
            com.loc.cl r0 = r12.f3090i     // Catch:{ Throwable -> 0x00a4 }
            android.content.Context r1 = r12.f3087e     // Catch:{ Throwable -> 0x00a4 }
            int r7 = r0.mo13184d(r1)     // Catch:{ Throwable -> 0x00a4 }
            android.content.Context r5 = r12.f3087e     // Catch:{ Throwable -> 0x00a4 }
            long r8 = r12.f3092k     // Catch:{ Throwable -> 0x00a4 }
            com.loc.ReportUtil.m3426a(r5, r6, r7, r8, r10)     // Catch:{ Throwable -> 0x00a4 }
            com.loc.cl r0 = r12.f3090i     // Catch:{ Throwable -> 0x00a4 }
            android.content.Context r1 = r12.f3087e     // Catch:{ Throwable -> 0x00a4 }
            r0.mo13185e(r1)     // Catch:{ Throwable -> 0x00a4 }
        L_0x0095:
            com.loc.SDKLogHandler.m3865b()     // Catch:{ Throwable -> 0x00a4 }
            boolean r0 = f3077g     // Catch:{ Throwable -> 0x00a4 }
            if (r0 == 0) goto L_0x00a3
            int r0 = android.os.Process.myPid()     // Catch:{ Throwable -> 0x00a4 }
            android.os.Process.killProcess(r0)     // Catch:{ Throwable -> 0x00a4 }
        L_0x00a3:
            return
        L_0x00a4:
            r0 = move-exception
            java.lang.String r1 = "ApsServiceCore"
            java.lang.String r2 = "threadDestroy"
            com.loc.CoreUtil.m3389a(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ApsManager.mo13213e():void");
    }
}
