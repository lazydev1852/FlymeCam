package com.baidu.p020ar.track;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.p020ar.C0482a;
import com.baidu.p020ar.arplay.core.ARPEngine;
import com.baidu.p020ar.base.C0611b;
import com.baidu.p020ar.base.C0618d;
import com.baidu.p020ar.base.MsgField;
import com.baidu.p020ar.bean.C0625c;
import com.baidu.p020ar.bean.C0629f;
import com.baidu.p020ar.bean.TrackRes;
import com.baidu.p020ar.imu.C0769b;
import com.baidu.p020ar.msghandler.C0812e;
import com.baidu.p020ar.p021a.C0486a;
import com.baidu.p020ar.p021a.p022a.p025c.C0497b;
import com.baidu.p020ar.p021a.p022a.p025c.C0498c;
import com.baidu.p020ar.p021a.p026b.p027a.C0499a;
import com.baidu.p020ar.p042d.C0765a;
import com.baidu.p020ar.parser.C0819a;
import com.baidu.p020ar.parser.ParserJson;
import com.baidu.p020ar.statistic.StatisticConstants;
import com.baidu.p020ar.statistic.StatisticHelper;
import com.baidu.p020ar.track.TrackStateMachine;
import com.baidu.p020ar.util.ARFileUtils;
import com.baidu.p020ar.util.ARLog;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.track.a */
public class C0905a extends C0611b {

    /* renamed from: r */
    private C0909b f2342r = null;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f2343s = false;

    /* renamed from: t */
    private C0497b f2344t;

    /* renamed from: u */
    private boolean f2345u = true;

    /* renamed from: v */
    private String f2346v;

    /* renamed from: w */
    private C0908a f2347w = new C0908a();

    /* renamed from: com.baidu.ar.track.a$a */
    public static class C0908a implements C0499a {

        /* renamed from: a */
        private boolean f2350a = false;

        /* renamed from: b */
        private boolean f2351b = false;

        /* renamed from: a */
        public void mo8959a(Bundle bundle) {
            boolean z;
            if (bundle != null && bundle.getInt("track2D_method_type") != 0) {
                boolean z2 = bundle.getBoolean("isTracked");
                bundle.getBoolean("isTrackStatusValid");
                boolean z3 = bundle.getBoolean("trackedFromTrackLost");
                boolean z4 = bundle.getBoolean("trackLostFromTracked");
                StatisticHelper.getInstance().statisticTrackedStatus(z2);
                if (z2) {
                    this.f2351b = true;
                    if (z3) {
                        StatisticHelper.getInstance().statisticInfo(StatisticConstants.TRACKED);
                        C0618d.m1300a((int) MsgField.IMSG_TRACK_FOUND, MsgField.SMSG_TRACK_FOUND);
                        TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.TRACK_SUCCESS);
                        ARPEngine.getInstance().onResumeByUser();
                        this.f2350a = ARPEngine.getInstance().getCurrentScene().mo9204a(true);
                    }
                    if (!this.f2350a) {
                        z = !ARPEngine.getInstance().getCurrentScene().mo9204a(true);
                    }
                    TrackStateMachine.getInstance().processRtMatrix(bundle);
                }
                z = false;
                if (z4) {
                    C0618d.m1300a((int) MsgField.IMSG_TRACK_LOST, MsgField.SMSG_TRACK_LOST);
                    TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.TRACK_FAILED);
                    if (!TrackStateMachine.getInstance().isShowImmediately() && !TrackStateMachine.getInstance().isImuRelayCtrWhenTrackLost() && !TrackStateMachine.getInstance().isEngineSetTrackLostHandler()) {
                        this.f2350a = false;
                        ARPEngine.getInstance().onPauseByUser();
                        ARPEngine.getInstance().getCurrentScene().mo9204a(false);
                    }
                }
                if (TrackStateMachine.getInstance().isShowImmediately()) {
                    ARPEngine.getInstance().onResumeByUser();
                    if (!this.f2350a) {
                        ARPEngine.getInstance().getCurrentScene().mo9204a(true);
                        this.f2350a = true;
                    }
                } else if (!this.f2351b) {
                    ARPEngine.getInstance().onPauseByUser();
                    if (this.f2350a) {
                        ARPEngine.getInstance().getCurrentScene().mo9204a(false);
                    }
                }
                TrackStateMachine.getInstance().processRtMatrix(bundle);
                this.f2350a = z;
                TrackStateMachine.getInstance().processRtMatrix(bundle);
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.baidu.ar.track.a$b */
    public static class C0909b extends Handler {

        /* renamed from: a */
        private WeakReference<C0905a> f2352a;

        public C0909b(C0905a aVar) {
            super(Looper.getMainLooper());
            this.f2352a = new WeakReference<>(aVar);
        }

        /* renamed from: a */
        public void mo10670a() {
            if (this.f2352a != null) {
                this.f2352a.clear();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
            com.baidu.p020ar.base.C0618d.m1299a(r7, (java.lang.Object) java.lang.Boolean.valueOf(r2));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d8, code lost:
            com.baidu.p020ar.base.C0618d.m1300a(r7, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r7) {
            /*
                r6 = this;
                java.lang.ref.WeakReference<com.baidu.ar.track.a> r0 = r6.f2352a
                java.lang.Object r0 = r0.get()
                com.baidu.ar.track.a r0 = (com.baidu.p020ar.track.C0905a) r0
                if (r0 != 0) goto L_0x000b
                return
            L_0x000b:
                int r1 = r7.what
                r2 = 0
                r3 = 1
                switch(r1) {
                    case 301: goto L_0x00b0;
                    case 302: goto L_0x009f;
                    case 306: goto L_0x0085;
                    case 307: goto L_0x0068;
                    case 309: goto L_0x0063;
                    case 310: goto L_0x005d;
                    case 312: goto L_0x0047;
                    case 313: goto L_0x0036;
                    case 314: goto L_0x00db;
                    case 318: goto L_0x0031;
                    case 319: goto L_0x002c;
                    case 30000: goto L_0x0023;
                    case 999999: goto L_0x0014;
                    default: goto L_0x0012;
                }
            L_0x0012:
                goto L_0x00db
            L_0x0014:
                android.os.Bundle r7 = r7.getData()
                java.lang.String r1 = "debugScreenShotFileName"
                java.lang.String r7 = r7.getString(r1)
                r0.mo9530c((java.lang.String) r7)
                goto L_0x00db
            L_0x0023:
                android.os.Bundle r7 = r7.getData()
                r0.mo9529c((android.os.Bundle) r7)
                goto L_0x00db
            L_0x002c:
                r0.mo10345m()
                goto L_0x00db
            L_0x0031:
                r0.mo10669n()
                goto L_0x00db
            L_0x0036:
                android.os.Bundle r7 = r7.getData()
                java.lang.String r1 = "type"
                int r7 = r7.getInt(r1)
                if (r7 != r3) goto L_0x00db
                r0.mo9513a()
                goto L_0x00db
            L_0x0047:
                android.os.Bundle r0 = r7.getData()
                if (r0 == 0) goto L_0x005a
                android.os.Bundle r7 = r7.getData()
                java.lang.String r0 = "show_immediately"
                int r7 = r7.getInt(r0)
                if (r7 != r3) goto L_0x005a
                r2 = 1
            L_0x005a:
                r7 = 2104(0x838, float:2.948E-42)
                goto L_0x007d
            L_0x005d:
                r7 = 2105(0x839, float:2.95E-42)
                java.lang.String r0 = " track msg id track lost"
                goto L_0x00d8
            L_0x0063:
                r7 = 1880(0x758, float:2.634E-42)
                java.lang.String r0 = " track model disapper!"
                goto L_0x00d8
            L_0x0068:
                android.os.Bundle r0 = r7.getData()
                if (r0 == 0) goto L_0x007b
                android.os.Bundle r7 = r7.getData()
                java.lang.String r0 = "show_immediately"
                int r7 = r7.getInt(r0)
                if (r7 != r3) goto L_0x007b
                r2 = 1
            L_0x007b:
                r7 = 1808(0x710, float:2.534E-42)
            L_0x007d:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
                com.baidu.p020ar.base.C0618d.m1299a((int) r7, (java.lang.Object) r0)
                goto L_0x00db
            L_0x0085:
                com.baidu.p020ar.statistic.StatisticConstants.setIsRenderModel(r3)
                boolean r7 = r0.f1014i
                if (r7 != 0) goto L_0x009a
                com.baidu.ar.statistic.StatisticHelper r7 = com.baidu.p020ar.statistic.StatisticHelper.getInstance()
                java.lang.String r1 = "start_animation"
                r7.statisticInfo(r1)
                boolean unused = r0.f1014i = r3
            L_0x009a:
                r7 = 2101(0x835, float:2.944E-42)
                java.lang.String r0 = " mode showing"
                goto L_0x00d8
            L_0x009f:
                android.os.Bundle r7 = r7.getData()
                r0.mo9515a((android.os.Bundle) r7)
                boolean r7 = r0.f2343s
                if (r7 != 0) goto L_0x00db
                boolean unused = r0.f2343s = r3
                goto L_0x00db
            L_0x00b0:
                java.lang.String r7 = "qatest"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "加载资源: "
                r1.append(r2)
                long r2 = java.lang.System.currentTimeMillis()
                long r4 = r0.f1022q
                long r2 = r2 - r4
                r1.append(r2)
                java.lang.String r0 = " ms"
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                android.util.Log.e(r7, r0)
                r7 = 1817(0x719, float:2.546E-42)
                java.lang.String r0 = "model loaded!"
            L_0x00d8:
                com.baidu.p020ar.base.C0618d.m1300a((int) r7, (java.lang.String) r0)
            L_0x00db:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.track.C0905a.C0909b.handleMessage(android.os.Message):void");
        }
    }

    public C0905a(Context context) {
        super(context);
        ARPEngine.getInstance().registerCaseProcess(new ARPEngine.C0569c() {
            /* renamed from: a */
            public void mo9186a() {
            }

            /* renamed from: b */
            public void mo9187b() {
                synchronized (TrackStateMachine.getInstance()) {
                    if (TrackStateMachine.getInstance().getTrackState() != TrackStateMachine.STATE.TRACKED) {
                        if (!TrackStateMachine.getInstance().isShowImmediately()) {
                            ARPEngine.getInstance().onPauseByUser();
                            ARPEngine.getInstance().getCurrentScene().mo9204a(false);
                        }
                    }
                    ARPEngine.getInstance().onResumeByUser();
                    ARPEngine.getInstance().getCurrentScene().mo9204a(true);
                    TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.MODEL_APPEAR);
                }
            }
        });
        TrackStateMachine.getInstance().init();
        TrackStateMachine.getInstance().setIMUController(this.f1015j);
        this.f1015j.mo10126a((C0769b.C0771b) new C0769b.C0771b() {
            /* renamed from: a */
            public void mo10134a(float[] fArr) {
                Bundle bundle = new Bundle();
                bundle.putFloatArray("RMatrix", fArr);
                bundle.putInt("init_pos", C0905a.this.f1015j.mo10124a());
                TrackStateMachine.getInstance().processRMatrix(bundle);
            }
        });
        if (this.f2342r == null) {
            this.f2342r = new C0909b(this);
        }
        TrackStateMachine.getInstance().setMainThreadHandler(this.f2342r);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e A[SYNTHETIC, Splitter:B:21:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap m2666a(com.baidu.p020ar.bean.TrackRes r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x006d
            com.baidu.ar.bean.TipBean r1 = r6.getTipBean()     // Catch:{ Exception -> 0x0069 }
            if (r1 == 0) goto L_0x006d
            com.baidu.ar.bean.TipBean r6 = r6.getTipBean()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r6 = r6.getTrackTargePicPath()     // Catch:{ Exception -> 0x0069 }
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0069 }
            if (r1 != 0) goto L_0x006d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0069 }
            r1.<init>()     // Catch:{ Exception -> 0x0069 }
            r1.append(r7)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r7 = java.io.File.separator     // Catch:{ Exception -> 0x0069 }
            r1.append(r7)     // Catch:{ Exception -> 0x0069 }
            r1.append(r6)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r6 = r1.toString()     // Catch:{ Exception -> 0x0069 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0069 }
            if (r7 != 0) goto L_0x006d
            android.graphics.BitmapFactory$Options r7 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0069 }
            r7.<init>()     // Catch:{ Exception -> 0x0069 }
            r1 = 1
            r7.inJustDecodeBounds = r1     // Catch:{ Exception -> 0x0069 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeFile(r6, r7)     // Catch:{ Exception -> 0x0069 }
            int r0 = r7.outWidth     // Catch:{ Exception -> 0x0066 }
            int r3 = r7.outHeight     // Catch:{ Exception -> 0x0066 }
            r4 = 0
            if (r3 <= r0) goto L_0x004f
            r0 = 900(0x384, float:1.261E-42)
            if (r3 <= r0) goto L_0x005a
            r7.inJustDecodeBounds = r4     // Catch:{ Exception -> 0x0066 }
            android.graphics.Bitmap r0 = r5.mo10668a(r7, r4, r6)     // Catch:{ Exception -> 0x0066 }
            goto L_0x005c
        L_0x004f:
            r3 = 500(0x1f4, float:7.0E-43)
            if (r0 <= r3) goto L_0x005a
            r7.inJustDecodeBounds = r4     // Catch:{ Exception -> 0x0066 }
            android.graphics.Bitmap r0 = r5.mo10668a(r7, r1, r6)     // Catch:{ Exception -> 0x0066 }
            goto L_0x005c
        L_0x005a:
            r0 = r2
            r1 = 0
        L_0x005c:
            if (r1 != 0) goto L_0x006d
            r7.inJustDecodeBounds = r4     // Catch:{ Exception -> 0x0069 }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeFile(r6, r7)     // Catch:{ Exception -> 0x0069 }
            r0 = r6
            goto L_0x006d
        L_0x0066:
            r6 = move-exception
            r0 = r2
            goto L_0x006a
        L_0x0069:
            r6 = move-exception
        L_0x006a:
            r6.printStackTrace()
        L_0x006d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.track.C0905a.m2666a(com.baidu.ar.bean.TrackRes, java.lang.String):android.graphics.Bitmap");
    }

    /* renamed from: a */
    private C0498c m2667a(C0629f fVar) {
        C0498c cVar = new C0498c();
        String str = fVar.mo9726a() + File.separator + fVar.mo9730b();
        ARLog.m2695d("szModelFile = " + str);
        int c = fVar.mo9733c();
        int d = fVar.mo9736d();
        int[] iArr = {(int) (fVar.mo9739e().f895x - ((float) (fVar.mo9733c() / 2))), (int) (fVar.mo9739e().f896y - ((float) (fVar.mo9736d() / 2))), fVar.mo9733c(), fVar.mo9736d()};
        cVar.f592c = c;
        cVar.f593d = d;
        cVar.f591b = str;
        cVar.f590a = iArr;
        return cVar;
    }

    /* renamed from: a */
    private void m2669a(TrackRes trackRes) {
        if (trackRes != null && this.f2345u) {
            if (trackRes.getTargetBeanList() != null) {
                ARLog.m2695d("enableArTracking");
                C0498c a = m2667a(trackRes.getTargetBeanList().get(0));
                if (this.f2344t == null) {
                    this.f2344t = new C0497b(a);
                    return;
                }
                return;
            }
            throw new NullPointerException("track target info is null !!!");
        }
    }

    /* renamed from: o */
    private void m2677o() {
        if (this.f2342r != null) {
            this.f2342r.removeCallbacksAndMessages((Object) null);
            this.f2342r.mo10670a();
            this.f2342r = null;
        }
        TrackStateMachine.getInstance().setMainThreadHandler((Handler) null);
    }

    /* renamed from: a */
    public Bitmap mo10668a(BitmapFactory.Options options, boolean z, String str) {
        float f;
        float f2 = ((((float) options.outWidth) * 1.0f) / ((float) options.outHeight)) * 1.0f;
        int i = 900;
        int i2 = 500;
        if (z) {
            f = (float) (options.outWidth / 500);
            i = (int) (((float) 500) / f2);
        } else {
            f = (float) (options.outHeight / 900);
            i2 = (int) (((float) 900) * f2);
        }
        options.outWidth = i2;
        options.outHeight = i;
        options.inSampleSize = (int) f;
        return BitmapFactory.decodeFile(str, options);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9515a(Bundle bundle) {
        super.mo9515a(bundle);
        if (!this.f2343s) {
            this.f2343s = true;
        }
    }

    /* renamed from: b */
    public void mo9524b(String str) {
        super.mo9524b(str);
        if (!TextUtils.isEmpty(this.f2346v) && TextUtils.equals(this.f2346v, str)) {
            TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.DOWNLOAD_RES_FINISH);
        } else if (TextUtils.isEmpty(str)) {
            C0618d.m1298a((int) MsgField.MSG_ON_PARSE_RESOURCE_UNZIP_ERROR);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str2 = (String) jSONObject.opt("unzip_path");
                String str3 = (String) jSONObject.opt("default_json");
                String str4 = (String) jSONObject.opt("target_json");
                String str5 = (String) jSONObject.opt("res_config");
                TrackRes parseCaseConfig = ParserJson.parseCaseConfig(str2, str3, str4);
                String str6 = str2 + File.separator + ARFileUtils.AR_UNZIP_ROOT_DIR;
                if (parseCaseConfig == null) {
                    C0618d.m1298a((int) MsgField.MSG_ON_PARSE_RESOURCE_JSON_ERROR);
                    return;
                }
                C0625c a = C0819a.m2168a(str2, str5);
                this.f1012g = parseCaseConfig;
                this.f1021p = a;
                if (this.f1013h != null) {
                    this.f1013h.mo10276a(this.f1021p);
                } else {
                    ARLog.m2696e("ARMessageHandler is null");
                }
                C0618d.m1299a((int) MsgField.IMSG_TRACKED_TIPS_INFO, (Object) parseCaseConfig);
                C0618d.m1299a((int) MsgField.IMSG_TRACKED_TARGET_BITMAP_RES, (Object) m2666a(this.f1012g, str6));
                TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.DOWNLOAD_RES_FINISH);
                if (this.f1012g != null) {
                    if (this.f1012g.getService() != null) {
                        this.f2345u = this.f1012g.getService().mo9710a() == 1;
                    }
                    mo9519a(str6);
                    m2669a(this.f1012g);
                }
                this.f2346v = str;
                mo9521a(true);
            } catch (JSONException unused) {
                C0618d.m1298a((int) MsgField.MSG_ON_PARSE_RESOURCE_UNZIP_ERROR);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9532c(byte[] bArr, C0765a aVar) {
        StatisticHelper.getInstance().statisticFrameRate(StatisticConstants.TRACK_FRAME_AVG_TIME);
        if (this.f2345u && this.f2344t != null) {
            C0486a.m840a(bArr, this.f1016k, this.f1017l, this.f2344t, (C0499a) this.f2347w);
        }
    }

    /* renamed from: d */
    public void mo9533d() {
        super.mo9533d();
        TrackStateMachine.setAppState(TrackStateMachine.STATE.RESUME);
        if (this.f1014i) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.RESUME_AR);
        }
        C0812e.m2129a().mo10288a(this.f2342r);
    }

    /* renamed from: e */
    public void mo9535e() {
        super.mo9535e();
        TrackStateMachine.setAppState(TrackStateMachine.STATE.PAUSE);
        if (this.f1014i) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.INTERRUPT_AR);
        }
    }

    /* renamed from: f */
    public void mo9536f() {
        super.mo9536f();
        m2677o();
        TrackStateMachine.setAppState(TrackStateMachine.STATE.DESTROY);
        TrackStateMachine.destroy();
        C0482a.m803c();
        if (this.f2344t != null) {
            C0486a.m837a(this.f2344t);
        }
        this.f2344t = null;
        mo9535e();
    }

    /* renamed from: i */
    public void mo9539i() {
        super.mo9539i();
        m2677o();
        if (this.f2344t != null) {
            this.f2344t.mo8958a();
            this.f2344t = null;
        }
        C0486a.m832a();
        mo9538h();
    }

    /* renamed from: m */
    public void mo10345m() {
        this.f2345u = false;
        if (this.f2344t != null) {
            C0486a.m837a(this.f2344t);
            this.f2344t = null;
        }
    }

    /* renamed from: n */
    public void mo10669n() {
        if (!this.f2345u) {
            this.f2345u = true;
            m2669a(this.f1012g);
        }
    }
}
