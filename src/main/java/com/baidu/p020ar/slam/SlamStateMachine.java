package com.baidu.p020ar.slam;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.p020ar.C0482a;
import com.baidu.p020ar.arplay.core.ARPEngine;
import com.baidu.p020ar.imu.C0769b;
import com.baidu.p020ar.statistic.StatisticConstants;

/* renamed from: com.baidu.ar.slam.SlamStateMachine */
public class SlamStateMachine {

    /* renamed from: a */
    private static volatile SlamStateMachine f2214a;

    /* renamed from: d */
    private static STATE f2215d = STATE.INITIAL_STATE;

    /* renamed from: b */
    private STATE f2216b = STATE.INITIAL_STATE;

    /* renamed from: c */
    private STATE f2217c = STATE.INITIAL_STATE;

    /* renamed from: e */
    private Handler f2218e;

    /* renamed from: f */
    private C0769b f2219f;

    /* renamed from: com.baidu.ar.slam.SlamStateMachine$EVENT */
    public enum EVENT {
        MODEL_APPEAR,
        MODEL_DISAPPEAR,
        SLAM_IMU_OPEN,
        SLAM_IMU_CLOSE,
        SLAM_GUESTURE_INTERACTION,
        SLAM_START_FROM_LUA,
        DOWNLOAD_RES_START,
        DOWNLOAD_RES_FINISH,
        LOAD_MODEL_START,
        LOAD_MODEL_FINISH
    }

    /* renamed from: com.baidu.ar.slam.SlamStateMachine$STATE */
    public enum STATE {
        INITIAL_STATE,
        SLAM_START,
        MODEL_SHOWING,
        MODEL_NOT_SHOWING,
        MODEL_LOADING,
        MODEL_LOAD_FINISH,
        TRACKED,
        NOT_TRACKED,
        RESUME,
        PAUSE,
        DESTROY
    }

    private SlamStateMachine() {
    }

    /* renamed from: a */
    public static SlamStateMachine m2584a() {
        if (f2214a == null) {
            synchronized (SlamStateMachine.class) {
                if (f2214a == null) {
                    f2214a = new SlamStateMachine();
                }
            }
        }
        return f2214a;
    }

    /* renamed from: a */
    private void m2585a(int i) {
        try {
            if (this.f2218e != null) {
                this.f2218e.sendEmptyMessage(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m2586a(int i, long j) {
        try {
            if (this.f2218e != null) {
                this.f2218e.sendEmptyMessageDelayed(i, j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m2587a(Message message) {
        try {
            if (this.f2218e != null) {
                this.f2218e.sendMessage(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m2588a(STATE state) {
        f2215d = state;
    }

    /* renamed from: b */
    private void m2589b(STATE state) {
        this.f2216b = state;
    }

    /* renamed from: c */
    public static void m2590c() {
        m2584a().f2218e = null;
        f2214a = null;
    }

    /* renamed from: c */
    private void m2591c(STATE state) {
        this.f2217c = state;
    }

    /* renamed from: a */
    public synchronized void mo10590a(Bundle bundle, float[] fArr) {
        C0482a.m796a().mo8909a(fArr);
        StatisticConstants.setIsRenderModel(true);
        if (ARPEngine.getInstance().getArGLEngineCtl() != null) {
            int e = ARPEngine.getInstance().getArGLEngineCtl().mo9239e();
            if (bundle.getInt("averageTime") <= 40) {
                if (e != 0) {
                    ARPEngine.getInstance().getArGLEngineCtl().mo9232a(0);
                }
                ARPEngine.getInstance().getArGLEngineCtl().mo9237c();
            } else if (e != 1) {
                ARPEngine.getInstance().getArGLEngineCtl().mo9232a(1);
            }
        }
    }

    /* renamed from: a */
    public void mo10591a(Handler handler) {
        this.f2218e = handler;
    }

    /* renamed from: a */
    public void mo10592a(C0769b bVar) {
        this.f2219f = bVar;
    }

    /* renamed from: a */
    public synchronized void mo10593a(EVENT event) {
        mo10594a(event, (Bundle) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        m2589b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0107, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo10594a(com.baidu.p020ar.slam.SlamStateMachine.EVENT r4, android.os.Bundle r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.baidu.ar.slam.SlamStateMachine$STATE r0 = f2215d     // Catch:{ all -> 0x0108 }
            com.baidu.ar.slam.SlamStateMachine$STATE r1 = com.baidu.p020ar.slam.SlamStateMachine.STATE.DESTROY     // Catch:{ all -> 0x0108 }
            if (r0 != r1) goto L_0x0009
            monitor-exit(r3)
            return
        L_0x0009:
            int[] r0 = com.baidu.p020ar.slam.SlamStateMachine.C08911.f2221b     // Catch:{ all -> 0x0108 }
            int r4 = r4.ordinal()     // Catch:{ all -> 0x0108 }
            r4 = r0[r4]     // Catch:{ all -> 0x0108 }
            r0 = 1
            r1 = 506(0x1fa, float:7.09E-43)
            r2 = 507(0x1fb, float:7.1E-43)
            switch(r4) {
                case 1: goto L_0x00ba;
                case 2: goto L_0x00aa;
                case 3: goto L_0x007d;
                case 4: goto L_0x005b;
                case 5: goto L_0x003f;
                case 6: goto L_0x0033;
                case 7: goto L_0x0022;
                case 8: goto L_0x001b;
                default: goto L_0x0019;
            }     // Catch:{ all -> 0x0108 }
        L_0x0019:
            goto L_0x0106
        L_0x001b:
            r4 = 525(0x20d, float:7.36E-43)
            r3.m2585a((int) r4)     // Catch:{ all -> 0x0108 }
            goto L_0x0106
        L_0x0022:
            android.os.Message r4 = new android.os.Message     // Catch:{ all -> 0x0108 }
            r4.<init>()     // Catch:{ all -> 0x0108 }
            r0 = 524(0x20c, float:7.34E-43)
            r4.what = r0     // Catch:{ all -> 0x0108 }
            r4.setData(r5)     // Catch:{ all -> 0x0108 }
            r3.m2587a((android.os.Message) r4)     // Catch:{ all -> 0x0108 }
            goto L_0x0106
        L_0x0033:
            r4 = 100
            r3.m2586a((int) r2, (long) r4)     // Catch:{ all -> 0x0108 }
            com.baidu.ar.slam.SlamStateMachine$STATE r4 = com.baidu.p020ar.slam.SlamStateMachine.STATE.MODEL_NOT_SHOWING     // Catch:{ all -> 0x0108 }
        L_0x003a:
            r3.m2589b(r4)     // Catch:{ all -> 0x0108 }
            goto L_0x0106
        L_0x003f:
            android.os.Handler r4 = r3.f2218e     // Catch:{ Exception -> 0x0051 }
            if (r4 == 0) goto L_0x0055
            android.os.Handler r4 = r3.f2218e     // Catch:{ Exception -> 0x0051 }
            boolean r4 = r4.hasMessages(r2)     // Catch:{ Exception -> 0x0051 }
            if (r4 == 0) goto L_0x0055
            android.os.Handler r4 = r3.f2218e     // Catch:{ Exception -> 0x0051 }
            r4.removeMessages(r2)     // Catch:{ Exception -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ all -> 0x0108 }
        L_0x0055:
            r3.m2585a((int) r1)     // Catch:{ all -> 0x0108 }
            com.baidu.ar.slam.SlamStateMachine$STATE r4 = com.baidu.p020ar.slam.SlamStateMachine.STATE.MODEL_SHOWING     // Catch:{ all -> 0x0108 }
            goto L_0x003a
        L_0x005b:
            com.baidu.ar.imu.b r4 = r3.f2219f     // Catch:{ all -> 0x0108 }
            if (r4 == 0) goto L_0x0106
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x0108 }
            r4.<init>()     // Catch:{ all -> 0x0108 }
            java.lang.String r5 = "succeeded"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0108 }
            r4.put(r5, r0)     // Catch:{ all -> 0x0108 }
            com.baidu.ar.imu.b r5 = r3.f2219f     // Catch:{ all -> 0x0108 }
            r5.mo10129b()     // Catch:{ all -> 0x0108 }
            com.baidu.ar.arplay.core.message.ARPMessage r5 = com.baidu.p020ar.arplay.core.message.ARPMessage.getInstance()     // Catch:{ all -> 0x0108 }
            r0 = 304(0x130, float:4.26E-43)
            r5.sendMessage(r0, r4)     // Catch:{ all -> 0x0108 }
            goto L_0x0106
        L_0x007d:
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x0108 }
            r4.<init>()     // Catch:{ all -> 0x0108 }
            com.baidu.ar.imu.b r5 = r3.f2219f     // Catch:{ all -> 0x0108 }
            if (r5 == 0) goto L_0x0106
            com.baidu.ar.imu.b r5 = r3.f2219f     // Catch:{ all -> 0x0108 }
            r1 = 0
            boolean r5 = r5.mo10127a((int) r1)     // Catch:{ all -> 0x0108 }
            if (r5 == 0) goto L_0x0099
            java.lang.String r5 = "succeeded"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0108 }
        L_0x0095:
            r4.put(r5, r0)     // Catch:{ all -> 0x0108 }
            goto L_0x00a0
        L_0x0099:
            java.lang.String r5 = "succeeded"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0108 }
            goto L_0x0095
        L_0x00a0:
            com.baidu.ar.arplay.core.message.ARPMessage r5 = com.baidu.p020ar.arplay.core.message.ARPMessage.getInstance()     // Catch:{ all -> 0x0108 }
            r0 = 302(0x12e, float:4.23E-43)
            r5.sendMessage(r0, r4)     // Catch:{ all -> 0x0108 }
            goto L_0x0106
        L_0x00aa:
            java.lang.String r4 = "LOAD_MODEL_FINISH "
            com.baidu.p020ar.util.ARLog.m2695d(r4)     // Catch:{ all -> 0x0108 }
            r4 = 501(0x1f5, float:7.02E-43)
            r3.m2585a((int) r4)     // Catch:{ all -> 0x0108 }
            com.baidu.ar.slam.SlamStateMachine$STATE r4 = com.baidu.p020ar.slam.SlamStateMachine.STATE.MODEL_LOAD_FINISH     // Catch:{ all -> 0x0108 }
        L_0x00b6:
            r3.m2591c(r4)     // Catch:{ all -> 0x0108 }
            goto L_0x0106
        L_0x00ba:
            java.lang.String r4 = "DOWNLOAD_RES_FINISH "
            com.baidu.p020ar.util.ARLog.m2695d(r4)     // Catch:{ all -> 0x0108 }
            com.baidu.ar.slam.SlamStateMachine$STATE r4 = r3.f2217c     // Catch:{ all -> 0x0108 }
            com.baidu.ar.slam.SlamStateMachine$STATE r5 = com.baidu.p020ar.slam.SlamStateMachine.STATE.MODEL_LOAD_FINISH     // Catch:{ all -> 0x0108 }
            if (r4 != r5) goto L_0x00f7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0108 }
            r4.<init>()     // Catch:{ all -> 0x0108 }
            java.lang.String r5 = "mCurrentState "
            r4.append(r5)     // Catch:{ all -> 0x0108 }
            com.baidu.ar.slam.SlamStateMachine$STATE r5 = r3.f2216b     // Catch:{ all -> 0x0108 }
            r4.append(r5)     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0108 }
            com.baidu.p020ar.util.ARLog.m2695d(r4)     // Catch:{ all -> 0x0108 }
            int[] r4 = com.baidu.p020ar.slam.SlamStateMachine.C08911.f2220a     // Catch:{ all -> 0x0108 }
            com.baidu.ar.slam.SlamStateMachine$STATE r5 = r3.f2216b     // Catch:{ all -> 0x0108 }
            int r5 = r5.ordinal()     // Catch:{ all -> 0x0108 }
            r4 = r4[r5]     // Catch:{ all -> 0x0108 }
            switch(r4) {
                case 1: goto L_0x00f1;
                case 2: goto L_0x00ed;
                case 3: goto L_0x00e9;
                default: goto L_0x00e8;
            }     // Catch:{ all -> 0x0108 }
        L_0x00e8:
            goto L_0x0106
        L_0x00e9:
            r3.m2585a((int) r1)     // Catch:{ all -> 0x0108 }
            goto L_0x0106
        L_0x00ed:
            r3.m2585a((int) r2)     // Catch:{ all -> 0x0108 }
            goto L_0x0106
        L_0x00f1:
            r4 = 512(0x200, float:7.175E-43)
            r3.m2585a((int) r4)     // Catch:{ all -> 0x0108 }
            goto L_0x0106
        L_0x00f7:
            com.baidu.ar.slam.SlamStateMachine$STATE r4 = r3.f2216b     // Catch:{ all -> 0x0108 }
            com.baidu.ar.slam.SlamStateMachine$STATE r5 = com.baidu.p020ar.slam.SlamStateMachine.STATE.SLAM_START     // Catch:{ all -> 0x0108 }
            if (r4 != r5) goto L_0x00fe
            goto L_0x00ed
        L_0x00fe:
            com.baidu.ar.slam.SlamStateMachine$STATE r4 = com.baidu.p020ar.slam.SlamStateMachine.STATE.SLAM_START     // Catch:{ all -> 0x0108 }
            r3.m2589b(r4)     // Catch:{ all -> 0x0108 }
            com.baidu.ar.slam.SlamStateMachine$STATE r4 = com.baidu.p020ar.slam.SlamStateMachine.STATE.MODEL_LOADING     // Catch:{ all -> 0x0108 }
            goto L_0x00b6
        L_0x0106:
            monitor-exit(r3)
            return
        L_0x0108:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.slam.SlamStateMachine.mo10594a(com.baidu.ar.slam.SlamStateMachine$EVENT, android.os.Bundle):void");
    }

    /* renamed from: b */
    public void mo10595b() {
        m2588a(STATE.INITIAL_STATE);
        this.f2216b = STATE.INITIAL_STATE;
        this.f2217c = STATE.INITIAL_STATE;
    }
}
