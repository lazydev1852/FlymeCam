package com.baidu.p020ar.slam;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.p020ar.C0482a;
import com.baidu.p020ar.arplay.core.ARPEngine;
import com.baidu.p020ar.arplay.core.message.ARPMessage;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.base.C0611b;
import com.baidu.p020ar.base.C0618d;
import com.baidu.p020ar.base.MsgField;
import com.baidu.p020ar.bean.C0625c;
import com.baidu.p020ar.bean.C0628e;
import com.baidu.p020ar.bean.TrackRes;
import com.baidu.p020ar.imu.C0769b;
import com.baidu.p020ar.msghandler.C0812e;
import com.baidu.p020ar.msghandler.ComponentMessageType;
import com.baidu.p020ar.p021a.C0486a;
import com.baidu.p020ar.p021a.p022a.p024b.C0494b;
import com.baidu.p020ar.p021a.p026b.p027a.C0499a;
import com.baidu.p020ar.p042d.C0765a;
import com.baidu.p020ar.parser.C0819a;
import com.baidu.p020ar.parser.ParserJson;
import com.baidu.p020ar.slam.SlamStateMachine;
import com.baidu.p020ar.statistic.StatisticConstants;
import com.baidu.p020ar.statistic.StatisticHelper;
import com.baidu.p020ar.test.PerformanceTest;
import com.baidu.p020ar.util.ARFileUtils;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.MsgConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.slam.a */
public class C0893a extends C0611b {

    /* renamed from: w */
    private static float[] f2246w = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f2247A = false;

    /* renamed from: B */
    private boolean f2248B = false;

    /* renamed from: C */
    private final int f2249C = 2;

    /* renamed from: D */
    private final int f2250D = 3;

    /* renamed from: r */
    private C0897c f2251r;

    /* renamed from: s */
    private C0494b f2252s;

    /* renamed from: t */
    private C0895a f2253t;

    /* renamed from: u */
    private boolean f2254u;

    /* renamed from: v */
    private C0628e f2255v;

    /* renamed from: x */
    private C0896b f2256x = new C0896b();

    /* renamed from: y */
    private String f2257y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f2258z = true;

    /* renamed from: com.baidu.ar.slam.a$a */
    public static class C0895a implements C0494b.C0495a {

        /* renamed from: a */
        C0769b f2260a;

        C0895a(C0769b bVar) {
            this.f2260a = bVar;
        }

        /* renamed from: a */
        public float[] mo8951a() {
            if (this.f2260a != null) {
                return this.f2260a.mo10131d();
            }
            return null;
        }

        /* renamed from: b */
        public float mo8952b() {
            return C0769b.f1711k;
        }

        /* renamed from: c */
        public void mo10606c() {
            if (this.f2260a != null) {
                this.f2260a.mo10130c();
                this.f2260a = null;
            }
        }
    }

    /* renamed from: com.baidu.ar.slam.a$b */
    public static class C0896b implements C0499a {

        /* renamed from: a */
        private int f2261a = 0;

        /* renamed from: a */
        public void mo8959a(Bundle bundle) {
            if (bundle == null) {
                ARLog.m2696e("bdar:slam imu data error!!!!!");
            } else if (this.f2261a >= 3) {
                C0893a.m2613f(bundle);
            } else {
                this.f2261a++;
            }
        }
    }

    /* renamed from: com.baidu.ar.slam.a$c */
    public static class C0897c extends Handler {

        /* renamed from: a */
        private WeakReference<C0893a> f2262a;

        public C0897c(C0893a aVar) {
            super(Looper.getMainLooper());
            this.f2262a = new WeakReference<>(aVar);
        }

        /* renamed from: a */
        public void mo10607a() {
            if (this.f2262a != null) {
                this.f2262a.clear();
            }
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            C0893a aVar = (C0893a) this.f2262a.get();
            if (aVar != null) {
                int i = message.what;
                if (i == 501) {
                    boolean unused = aVar.f2247A = true;
                    aVar.m2615n();
                    C0618d.m1300a((int) MsgField.IMSG_MODEL_LOADED, MsgField.SMSG_MODEL_LOADED);
                } else if (i != 506 && i != 512) {
                    if (i == 30000) {
                        aVar.mo9529c(message.getData());
                    } else if (i != 999999) {
                        switch (i) {
                            case MsgConstants.SLAM_GESTURE_INTERACTION /*524*/:
                                aVar.m2612e(message.getData());
                                return;
                            case MsgConstants.SLAM_START_FROM_LUA /*525*/:
                                boolean unused2 = aVar.f2258z = true;
                                return;
                            default:
                                return;
                        }
                    } else {
                        aVar.mo9530c(message.getData().getString(ComponentMessageType.MSG_EXTRA_DEBUG_SCREENSHOT_FILENAME));
                    }
                }
            }
        }
    }

    public C0893a(Context context) {
        super(context);
        SlamStateMachine.m2584a().mo10595b();
        SlamStateMachine.m2584a().mo10592a(this.f1015j);
        if (PerformanceTest.isOpenSlam()) {
            this.f1015j.mo10127a(0);
        }
        this.f2253t = new C0895a(this.f1015j);
        if (this.f2251r == null) {
            this.f2251r = new C0897c(this);
        }
        SlamStateMachine.m2584a().mo10591a((Handler) this.f2251r);
        ARPEngine.getInstance().setInteraction(new ARPEngine.C0570d() {
            /* renamed from: a */
            public void mo9188a(float f, float f2, float f3) {
                C0893a.this.m2600a(f, f2, f3);
            }
        });
    }

    /* renamed from: a */
    private int m2599a(float[] fArr, int i) {
        return 90.0f - ((float) (((Math.acos((double) (-fArr[10])) * 180.0d) * 1.0d) / 3.141592653589793d)) > ((float) i) ? 0 : 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2600a(float f, float f2, float f3) {
        C0486a.m843c(this.f2252s);
        C0486a.m831a((this.f2255v == null || TextUtils.isEmpty(this.f2255v.mo9712a())) ? "slam_model_1" : this.f2255v.mo9712a(), (int) f, (int) f2, (float[]) null, (int) f3, this.f2252s);
        C0482a.m796a().mo8912b(true);
    }

    /* renamed from: a */
    private void m2601a(int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", 4101);
        hashMap.put(ComponentMessageType.MSG_TYPE_SLAM_PLACE_GUIDE_DIRCTION, Integer.valueOf(i2));
        hashMap.put(ComponentMessageType.MSG_TYPE_SLAM_PLACE_GUIDE_DATA, Integer.valueOf(i));
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* renamed from: b */
    private void m2607b(float f, float f2, float f3) {
        C0486a.m843c(this.f2252s);
        C0486a.m831a((this.f2255v == null || TextUtils.isEmpty(this.f2255v.mo9712a())) ? "slam_model_1" : this.f2255v.mo9712a(), (int) f, (int) f2, (float[]) null, (int) f3, this.f2252s);
        ARPEngine.getInstance().sceneRotateToCamera();
    }

    /* renamed from: d */
    private void m2611d(String str) {
        if (this.f1012g != null) {
            mo9519a(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2612e(Bundle bundle) {
        float f;
        float f2;
        if (bundle.getBoolean("is_from_lua", false)) {
            int[] a = mo10605a(bundle.getFloat("x", 0.5f), bundle.getFloat("y", 0.5f));
            f = (float) a[0];
            f2 = (float) a[1];
        } else {
            f = bundle.getFloat("x", 640.0f);
            f2 = bundle.getFloat("y", 360.0f);
        }
        int intValue = ((Integer) bundle.get("type")).intValue();
        float floatValue = ((Float) bundle.get("distance")).floatValue();
        if (intValue == 3) {
            m2607b(f, f2, floatValue);
        } else if (intValue == 2) {
            m2600a(f, f2, floatValue);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static void m2613f(Bundle bundle) {
        ArrayList parcelableArrayList;
        float[] fArr;
        if (bundle != null && (parcelableArrayList = bundle.getParcelableArrayList("slam_track_result")) != null) {
            if (parcelableArrayList.size() > 0) {
                fArr = ((TrackModel) parcelableArrayList.get(0)).pose;
                C0482a.m796a().mo8914c(false);
            } else {
                fArr = f2246w;
                C0482a.m796a().mo8914c(true);
            }
            SlamStateMachine.m2584a().mo10590a(bundle, fArr);
        }
    }

    /* renamed from: m */
    private void m2614m() {
        if (this.f2251r != null) {
            this.f2251r.removeCallbacksAndMessages((Object) null);
            this.f2251r.mo10607a();
            this.f2251r = null;
        }
        SlamStateMachine.m2584a().mo10591a((Handler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m2615n() {
        m2617p();
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fe  */
    /* renamed from: o */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2616o() {
        /*
            r12 = this;
            com.baidu.ar.d.a r0 = r12.f1011f
            if (r0 != 0) goto L_0x000a
            java.lang.String r0 = "bdar: mPreviewSize is null!!!!"
            com.baidu.p020ar.util.ARLog.m2699w(r0)
            return
        L_0x000a:
            com.baidu.ar.bean.e r0 = r12.f2255v
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x010f
            com.baidu.ar.d.a r0 = r12.f1011f
            int r0 = r0.f1679a
            int r0 = r0 / r1
            com.baidu.ar.d.a r3 = r12.f1011f
            int r3 = r3.f1680b
            int r3 = r3 / r1
            com.baidu.ar.bean.e r4 = r12.f2255v
            int r4 = r4.mo9716b()
            r5 = 0
            if (r4 != r2) goto L_0x00b0
            com.baidu.ar.bean.e r0 = r12.f2255v
            int r0 = r0.mo9723e()
            float r0 = (float) r0
            com.baidu.ar.imu.b r3 = r12.f1015j
            float[] r3 = r3.mo10131d()
            com.baidu.ar.a.a.b.b r4 = r12.f2252s
            float[] r0 = com.baidu.p020ar.p021a.C0486a.m841a((float) r0, (float[]) r3, (com.baidu.p020ar.p021a.p022a.p024b.C0494b) r4)
            if (r0 == 0) goto L_0x0133
            r3 = r0[r5]
            int r3 = (int) r3
            if (r3 != 0) goto L_0x0065
            com.baidu.ar.imu.b r0 = r12.f1015j
            float[] r0 = r0.mo10131d()
            com.baidu.ar.bean.e r1 = r12.f2255v
            int r1 = r1.mo9723e()
            int r0 = r12.m2599a((float[]) r0, (int) r1)
            if (r0 != 0) goto L_0x0053
            r12.m2601a((int) r2, (int) r5)
            goto L_0x0058
        L_0x0053:
            if (r0 != r2) goto L_0x0058
            r12.m2601a((int) r2, (int) r2)
        L_0x0058:
            com.baidu.ar.a r0 = com.baidu.p020ar.C0482a.m796a()
            r1 = 16
            float[] r1 = new float[r1]
            r0.mo8909a((float[]) r1)
            goto L_0x0133
        L_0x0065:
            if (r3 != r2) goto L_0x0133
            r3 = r0[r2]
            int r7 = (int) r3
            r0 = r0[r1]
            int r8 = (int) r0
            com.baidu.ar.bean.e r0 = r12.f2255v
            if (r0 == 0) goto L_0x0084
            com.baidu.ar.bean.e r0 = r12.f2255v
            java.lang.String r0 = r0.mo9712a()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0084
            com.baidu.ar.bean.e r0 = r12.f2255v
            java.lang.String r0 = r0.mo9712a()
            goto L_0x0086
        L_0x0084:
            java.lang.String r0 = "slam_model_1"
        L_0x0086:
            r6 = r0
            r0 = 1000(0x3e8, float:1.401E-42)
            com.baidu.ar.bean.e r1 = r12.f2255v
            if (r1 == 0) goto L_0x0095
            com.baidu.ar.bean.e r0 = r12.f2255v
            int r0 = r0.mo9722d()
            r10 = r0
            goto L_0x0097
        L_0x0095:
            r10 = 1000(0x3e8, float:1.401E-42)
        L_0x0097:
            float[] r9 = f2246w
            com.baidu.ar.a.a.b.b r11 = r12.f2252s
            com.baidu.p020ar.p021a.C0486a.m831a((java.lang.String) r6, (int) r7, (int) r8, (float[]) r9, (int) r10, (com.baidu.p020ar.p021a.p022a.p024b.C0494b) r11)
            r12.f2254u = r2
            com.baidu.ar.statistic.StatisticHelper r0 = com.baidu.p020ar.statistic.StatisticHelper.getInstance()
            java.lang.String r1 = "slam_track_on"
            r0.statisticInfo(r1)
            r12.f1014i = r2
            r12.m2601a((int) r5, (int) r2)
            goto L_0x0133
        L_0x00b0:
            com.baidu.ar.bean.e r1 = r12.f2255v
            int r1 = r1.mo9716b()
            if (r1 != 0) goto L_0x0133
            com.baidu.ar.bean.e r1 = r12.f2255v
            java.lang.String r1 = r1.mo9719c()
            java.lang.String r4 = ","
            java.lang.String[] r1 = r1.split(r4)
            r4 = r1[r5]     // Catch:{ NumberFormatException -> 0x00e2 }
            java.lang.String r4 = r4.trim()     // Catch:{ NumberFormatException -> 0x00e2 }
            float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ NumberFormatException -> 0x00e2 }
            r1 = r1[r2]     // Catch:{ NumberFormatException -> 0x00e2 }
            java.lang.String r1 = r1.trim()     // Catch:{ NumberFormatException -> 0x00e2 }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x00e2 }
            int[] r1 = r12.mo10605a((float) r4, (float) r1)     // Catch:{ NumberFormatException -> 0x00e2 }
            r4 = r1[r5]     // Catch:{ NumberFormatException -> 0x00e2 }
            r0 = r1[r2]     // Catch:{ NumberFormatException -> 0x00e3 }
            r7 = r0
            goto L_0x00e9
        L_0x00e2:
            r4 = r0
        L_0x00e3:
            java.lang.String r0 = "model position is not number !!!"
            com.baidu.p020ar.util.ARLog.m2696e(r0)
            r7 = r3
        L_0x00e9:
            r6 = r4
            com.baidu.ar.bean.e r0 = r12.f2255v
            java.lang.String r0 = r0.mo9712a()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00fe
            com.baidu.ar.bean.e r0 = r12.f2255v
            java.lang.String r0 = r0.mo9712a()
        L_0x00fc:
            r5 = r0
            goto L_0x0101
        L_0x00fe:
            java.lang.String r0 = "slam_model_1"
            goto L_0x00fc
        L_0x0101:
            float[] r8 = f2246w
            com.baidu.ar.bean.e r0 = r12.f2255v
            int r9 = r0.mo9722d()
            com.baidu.ar.a.a.b.b r10 = r12.f2252s
            com.baidu.p020ar.p021a.C0486a.m831a((java.lang.String) r5, (int) r6, (int) r7, (float[]) r8, (int) r9, (com.baidu.p020ar.p021a.p022a.p024b.C0494b) r10)
            goto L_0x0126
        L_0x010f:
            java.lang.String r3 = "slam_model_1"
            com.baidu.ar.d.a r0 = r12.f1011f
            int r0 = r0.f1679a
            int r4 = r0 / 2
            com.baidu.ar.d.a r0 = r12.f1011f
            int r0 = r0.f1680b
            int r5 = r0 / 2
            float[] r6 = f2246w
            r7 = 1000(0x3e8, float:1.401E-42)
            com.baidu.ar.a.a.b.b r8 = r12.f2252s
            com.baidu.p020ar.p021a.C0486a.m831a((java.lang.String) r3, (int) r4, (int) r5, (float[]) r6, (int) r7, (com.baidu.p020ar.p021a.p022a.p024b.C0494b) r8)
        L_0x0126:
            r12.f2254u = r2
            com.baidu.ar.statistic.StatisticHelper r0 = com.baidu.p020ar.statistic.StatisticHelper.getInstance()
            java.lang.String r1 = "slam_track_on"
            r0.statisticInfo(r1)
            r12.f1014i = r2
        L_0x0133:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.slam.C0893a.m2616o():void");
    }

    /* renamed from: p */
    private void m2617p() {
        if (this.f2252s == null) {
            this.f2252s = new C0494b(this.f1016k, this.f1017l, false);
            C0486a.m836a(this.f2252s, this.f2253t);
        }
        C0486a.m835a(this.f2252s);
    }

    /* renamed from: a */
    public int[] mo10605a(float f, float f2) {
        int[] iArr = new int[2];
        if (this.f1011f != null) {
            iArr[1] = this.f1011f.f1680b - ((int) (f * 720.0f));
            iArr[0] = (int) (f2 * 1280.0f);
        } else {
            iArr[1] = 640;
            iArr[0] = 360;
        }
        return iArr;
    }

    /* renamed from: b */
    public void mo9524b(String str) {
        super.mo9524b(str);
        if (!TextUtils.isEmpty(this.f2257y) && TextUtils.equals(this.f2257y, str)) {
            SlamStateMachine.m2584a().mo10593a(SlamStateMachine.EVENT.DOWNLOAD_RES_FINISH);
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
                if (parseCaseConfig == null) {
                    C0618d.m1298a((int) MsgField.MSG_ON_PARSE_RESOURCE_JSON_ERROR);
                    return;
                }
                C0625c a = C0819a.m2168a(str2, str5);
                String str6 = str2 + File.separator + ARFileUtils.AR_UNZIP_ROOT_DIR;
                this.f1012g = parseCaseConfig;
                this.f1021p = a;
                if (this.f1013h != null) {
                    this.f1013h.mo10276a(this.f1021p);
                } else {
                    ARLog.m2696e("ARMessageHandler is null");
                }
                C0618d.m1299a((int) MsgField.IMSG_TRACKED_TIPS_INFO, (Object) parseCaseConfig);
                SlamStateMachine.m2584a().mo10593a(SlamStateMachine.EVENT.DOWNLOAD_RES_FINISH);
                this.f2255v = this.f1012g.getSlamModel();
                if (this.f2255v != null) {
                    this.f2258z = this.f2255v.mo9724f();
                }
                m2611d(str6);
                this.f2257y = str;
            } catch (JSONException unused) {
                C0618d.m1298a((int) MsgField.MSG_ON_PARSE_RESOURCE_UNZIP_ERROR);
            }
        }
    }

    /* renamed from: c */
    public void mo9531c(boolean z) {
        super.mo9531c(z);
        this.f2248B = z;
        C0482a.m796a().mo8918f(z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9532c(byte[] bArr, C0765a aVar) {
        if (this.f1011f == null) {
            ARLog.m2699w("bdar: mPreviewSize is null!!!!");
        } else if (!PerformanceTest.isOpenSlam() || !this.f2258z || this.f2252s == null) {
        } else {
            if (!this.f2254u) {
                m2616o();
                return;
            }
            C0486a.m839a(bArr, this.f1011f.f1679a, this.f1011f.f1680b, this.f2252s, (C0499a) this.f2256x);
            StatisticHelper.getInstance().statisticFrameRate(StatisticConstants.SLAM_TRACK_FRAME_AVG_TIME);
        }
    }

    /* renamed from: d */
    public void mo9533d() {
        super.mo9533d();
        SlamStateMachine.m2588a(SlamStateMachine.STATE.RESUME);
        C0812e.m2129a().mo10288a(this.f2251r);
        if (this.f1014i) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.RESUME_AR);
        }
    }

    /* renamed from: e */
    public void mo9535e() {
        super.mo9535e();
        SlamStateMachine.m2588a(SlamStateMachine.STATE.PAUSE);
        if (this.f1014i) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.INTERRUPT_AR);
        }
    }

    /* renamed from: f */
    public void mo9536f() {
        super.mo9536f();
        if (this.f2252s != null) {
            C0486a.m842b(this.f2252s);
            this.f2252s = null;
        }
        SlamStateMachine.m2588a(SlamStateMachine.STATE.DESTROY);
        SlamStateMachine.m2590c();
        m2614m();
        this.f2253t.mo10606c();
    }

    /* renamed from: i */
    public void mo9539i() {
        super.mo9539i();
        SlamStateMachine.m2588a(SlamStateMachine.STATE.PAUSE);
        if (this.f2252s != null) {
            C0486a.m842b(this.f2252s);
            this.f2252s = null;
        }
        SlamStateMachine.m2588a(SlamStateMachine.STATE.DESTROY);
        SlamStateMachine.m2590c();
        m2614m();
        C0482a.m803c();
        this.f2253t.mo10606c();
        C0486a.m832a();
        mo9538h();
    }

    /* renamed from: l */
    public boolean mo9542l() {
        return this.f2247A;
    }
}
