package com.baidu.p020ar.imu;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.p020ar.C0482a;
import com.baidu.p020ar.arplay.core.ARPEngine;
import com.baidu.p020ar.statistic.StatisticConstants;

/* renamed from: com.baidu.ar.imu.ImuStateMachine */
public class ImuStateMachine {

    /* renamed from: a */
    private static volatile ImuStateMachine f1684a;

    /* renamed from: d */
    private static STATE f1685d = STATE.INITIAL_STATE;

    /* renamed from: b */
    private STATE f1686b = STATE.INITIAL_STATE;

    /* renamed from: c */
    private STATE f1687c = STATE.INITIAL_STATE;

    /* renamed from: e */
    private Handler f1688e;

    /* renamed from: f */
    private C0769b f1689f;

    /* renamed from: com.baidu.ar.imu.ImuStateMachine$EVENT */
    public enum EVENT {
        MODEL_APPEAR,
        MODEL_DISAPPEAR,
        IMU_OPEN,
        IMU_CLOSE,
        DOWNLOAD_RES_FINISH,
        LOAD_MODEL_FINISH
    }

    /* renamed from: com.baidu.ar.imu.ImuStateMachine$STATE */
    public enum STATE {
        INITIAL_STATE,
        MODEL_SHOWING,
        MODEL_NOT_SHOWING,
        MODEL_LOADING,
        MODEL_LOAD_FINISH,
        RESUME,
        PAUSE,
        DESTROY
    }

    private ImuStateMachine() {
    }

    /* renamed from: a */
    public static ImuStateMachine m1994a() {
        if (f1684a == null) {
            synchronized (ImuStateMachine.class) {
                if (f1684a == null) {
                    f1684a = new ImuStateMachine();
                }
            }
        }
        return f1684a;
    }

    /* renamed from: a */
    private void m1995a(int i) {
        try {
            if (this.f1688e != null) {
                this.f1688e.sendEmptyMessage(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m1996a(int i, Bundle bundle) {
        try {
            if (this.f1688e != null) {
                Message obtainMessage = this.f1688e.obtainMessage();
                obtainMessage.what = i;
                obtainMessage.setData(bundle);
                this.f1688e.sendMessage(obtainMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m1997a(STATE state) {
        f1685d = state;
    }

    /* renamed from: b */
    private void m1998b(STATE state) {
        this.f1686b = state;
    }

    /* renamed from: c */
    public static void m1999c() {
        m1994a().f1688e = null;
        f1684a = null;
    }

    /* renamed from: c */
    private void m2000c(STATE state) {
        this.f1687c = state;
    }

    /* renamed from: a */
    public synchronized void mo10117a(Bundle bundle) {
        if (this.f1687c == STATE.MODEL_LOAD_FINISH) {
            float[] floatArray = bundle.getFloatArray("RMatrix");
            if (floatArray != null) {
                C0482a.m796a().mo8910a(floatArray, bundle.getInt("init_pos"));
                StatisticConstants.setIsRenderModel(true);
            }
            if (!(ARPEngine.getInstance().getArGLEngineCtl() == null || ARPEngine.getInstance().getArGLEngineCtl().mo9239e() == 1)) {
                ARPEngine.getInstance().getArGLEngineCtl().mo9232a(1);
            }
        }
    }

    /* renamed from: a */
    public void mo10118a(Handler handler) {
        this.f1688e = handler;
    }

    /* renamed from: a */
    public synchronized void mo10119a(EVENT event) {
        mo10120a(event, (Bundle) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f7, code lost:
        m2000c(r5);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo10120a(com.baidu.p020ar.imu.ImuStateMachine.EVENT r5, android.os.Bundle r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r0.<init>()     // Catch:{ all -> 0x0106 }
            java.lang.String r1 = "event="
            r0.append(r1)     // Catch:{ all -> 0x0106 }
            r0.append(r5)     // Catch:{ all -> 0x0106 }
            java.lang.String r1 = ", state="
            r0.append(r1)     // Catch:{ all -> 0x0106 }
            com.baidu.ar.imu.ImuStateMachine$STATE r1 = r4.f1686b     // Catch:{ all -> 0x0106 }
            r0.append(r1)     // Catch:{ all -> 0x0106 }
            java.lang.String r1 = ", BgState="
            r0.append(r1)     // Catch:{ all -> 0x0106 }
            com.baidu.ar.imu.ImuStateMachine$STATE r1 = r4.f1687c     // Catch:{ all -> 0x0106 }
            r0.append(r1)     // Catch:{ all -> 0x0106 }
            java.lang.String r1 = ", AppState="
            r0.append(r1)     // Catch:{ all -> 0x0106 }
            com.baidu.ar.imu.ImuStateMachine$STATE r1 = f1685d     // Catch:{ all -> 0x0106 }
            r0.append(r1)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0106 }
            com.baidu.p020ar.util.ARLog.m2695d(r0)     // Catch:{ all -> 0x0106 }
            com.baidu.ar.imu.ImuStateMachine$STATE r0 = f1685d     // Catch:{ all -> 0x0106 }
            com.baidu.ar.imu.ImuStateMachine$STATE r1 = com.baidu.p020ar.imu.ImuStateMachine.STATE.DESTROY     // Catch:{ all -> 0x0106 }
            if (r0 != r1) goto L_0x003b
            monitor-exit(r4)
            return
        L_0x003b:
            int[] r0 = com.baidu.p020ar.imu.ImuStateMachine.C07671.f1690a     // Catch:{ all -> 0x0106 }
            int r5 = r5.ordinal()     // Catch:{ all -> 0x0106 }
            r5 = r0[r5]     // Catch:{ all -> 0x0106 }
            r0 = 0
            r1 = 1
            switch(r5) {
                case 1: goto L_0x00fb;
                case 2: goto L_0x00df;
                case 3: goto L_0x0089;
                case 4: goto L_0x0059;
                case 5: goto L_0x0051;
                case 6: goto L_0x004a;
                default: goto L_0x0048;
            }     // Catch:{ all -> 0x0106 }
        L_0x0048:
            goto L_0x0104
        L_0x004a:
            com.baidu.ar.imu.ImuStateMachine$STATE r5 = com.baidu.p020ar.imu.ImuStateMachine.STATE.MODEL_NOT_SHOWING     // Catch:{ all -> 0x0106 }
        L_0x004c:
            r4.m1998b(r5)     // Catch:{ all -> 0x0106 }
            goto L_0x0104
        L_0x0051:
            r5 = 804(0x324, float:1.127E-42)
            r4.m1995a((int) r5)     // Catch:{ all -> 0x0106 }
            com.baidu.ar.imu.ImuStateMachine$STATE r5 = com.baidu.p020ar.imu.ImuStateMachine.STATE.MODEL_SHOWING     // Catch:{ all -> 0x0106 }
            goto L_0x004c
        L_0x0059:
            com.baidu.ar.imu.b r5 = r4.f1689f     // Catch:{ all -> 0x0106 }
            if (r5 == 0) goto L_0x0104
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x0106 }
            r5.<init>()     // Catch:{ all -> 0x0106 }
            java.lang.String r6 = "succeeded"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0106 }
            r5.put(r6, r1)     // Catch:{ all -> 0x0106 }
            com.baidu.ar.a r6 = com.baidu.p020ar.C0482a.m796a()     // Catch:{ all -> 0x0106 }
            r6.mo8919g((boolean) r0)     // Catch:{ all -> 0x0106 }
            com.baidu.ar.imu.b r6 = r4.f1689f     // Catch:{ all -> 0x0106 }
            r6.mo10129b()     // Catch:{ all -> 0x0106 }
            com.baidu.ar.a r6 = com.baidu.p020ar.C0482a.m796a()     // Catch:{ all -> 0x0106 }
            r6.mo8911b()     // Catch:{ all -> 0x0106 }
            com.baidu.ar.arplay.core.message.ARPMessage r6 = com.baidu.p020ar.arplay.core.message.ARPMessage.getInstance()     // Catch:{ all -> 0x0106 }
            r0 = 304(0x130, float:4.26E-43)
            r6.sendMessage(r0, r5)     // Catch:{ all -> 0x0106 }
            goto L_0x0104
        L_0x0089:
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x0106 }
            r5.<init>()     // Catch:{ all -> 0x0106 }
            com.baidu.ar.imu.b r2 = r4.f1689f     // Catch:{ NullPointerException -> 0x00d9 }
            r2.mo10125a((android.os.Bundle) r6)     // Catch:{ NullPointerException -> 0x00d9 }
            boolean r2 = com.baidu.p020ar.test.PerformanceTest.isOpenIMU()     // Catch:{ NullPointerException -> 0x00d9 }
            if (r2 == 0) goto L_0x00a6
            com.baidu.ar.imu.b r2 = r4.f1689f     // Catch:{ NullPointerException -> 0x00d9 }
            java.lang.String r3 = "type"
            int r3 = r6.getInt(r3)     // Catch:{ NullPointerException -> 0x00d9 }
            boolean r2 = r2.mo10127a((int) r3)     // Catch:{ NullPointerException -> 0x00d9 }
            goto L_0x00a7
        L_0x00a6:
            r2 = 1
        L_0x00a7:
            if (r2 == 0) goto L_0x00ba
            java.lang.String r0 = "succeeded"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0106 }
            r5.put(r0, r2)     // Catch:{ all -> 0x0106 }
            com.baidu.ar.a r0 = com.baidu.p020ar.C0482a.m796a()     // Catch:{ all -> 0x0106 }
            r0.mo8919g((boolean) r1)     // Catch:{ all -> 0x0106 }
            goto L_0x00ca
        L_0x00ba:
            java.lang.String r1 = "succeeded"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0106 }
            r5.put(r1, r2)     // Catch:{ all -> 0x0106 }
            com.baidu.ar.a r1 = com.baidu.p020ar.C0482a.m796a()     // Catch:{ all -> 0x0106 }
            r1.mo8919g((boolean) r0)     // Catch:{ all -> 0x0106 }
        L_0x00ca:
            com.baidu.ar.arplay.core.message.ARPMessage r0 = com.baidu.p020ar.arplay.core.message.ARPMessage.getInstance()     // Catch:{ all -> 0x0106 }
            r1 = 302(0x12e, float:4.23E-43)
            r0.sendMessage(r1, r5)     // Catch:{ all -> 0x0106 }
            r5 = 8010(0x1f4a, float:1.1224E-41)
            r4.m1996a((int) r5, (android.os.Bundle) r6)     // Catch:{ all -> 0x0106 }
            goto L_0x0104
        L_0x00d9:
            java.lang.String r5 = "bdar:has NullPointerException!!!"
            com.baidu.p020ar.util.ARLog.m2699w(r5)     // Catch:{ all -> 0x0106 }
            goto L_0x0104
        L_0x00df:
            com.baidu.ar.imu.ImuStateMachine$STATE r5 = r4.f1687c     // Catch:{ all -> 0x0106 }
            com.baidu.ar.imu.ImuStateMachine$STATE r6 = com.baidu.p020ar.imu.ImuStateMachine.STATE.MODEL_LOADING     // Catch:{ all -> 0x0106 }
            if (r5 != r6) goto L_0x0104
            com.baidu.ar.rotate.Orientation r5 = com.baidu.p020ar.rotate.OrientationManager.getGlobalOrientation()     // Catch:{ all -> 0x0106 }
            int r5 = r5.getDegree()     // Catch:{ all -> 0x0106 }
            com.baidu.p020ar.msghandler.C0802a.m2100a((int) r5)     // Catch:{ all -> 0x0106 }
            r5 = 801(0x321, float:1.122E-42)
            r4.m1995a((int) r5)     // Catch:{ all -> 0x0106 }
            com.baidu.ar.imu.ImuStateMachine$STATE r5 = com.baidu.p020ar.imu.ImuStateMachine.STATE.MODEL_LOAD_FINISH     // Catch:{ all -> 0x0106 }
        L_0x00f7:
            r4.m2000c(r5)     // Catch:{ all -> 0x0106 }
            goto L_0x0104
        L_0x00fb:
            com.baidu.ar.imu.ImuStateMachine$STATE r5 = r4.f1687c     // Catch:{ all -> 0x0106 }
            com.baidu.ar.imu.ImuStateMachine$STATE r6 = com.baidu.p020ar.imu.ImuStateMachine.STATE.MODEL_LOAD_FINISH     // Catch:{ all -> 0x0106 }
            if (r5 == r6) goto L_0x0104
            com.baidu.ar.imu.ImuStateMachine$STATE r5 = com.baidu.p020ar.imu.ImuStateMachine.STATE.MODEL_LOADING     // Catch:{ all -> 0x0106 }
            goto L_0x00f7
        L_0x0104:
            monitor-exit(r4)
            return
        L_0x0106:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.imu.ImuStateMachine.mo10120a(com.baidu.ar.imu.ImuStateMachine$EVENT, android.os.Bundle):void");
    }

    /* renamed from: a */
    public void mo10121a(C0769b bVar) {
        this.f1689f = bVar;
    }

    /* renamed from: b */
    public void mo10122b() {
        m1997a(STATE.INITIAL_STATE);
        this.f1686b = STATE.INITIAL_STATE;
        this.f1687c = STATE.INITIAL_STATE;
    }
}
