package com.baidu.p020ar.track;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.p020ar.C0482a;
import com.baidu.p020ar.arplay.core.ARPEngine;
import com.baidu.p020ar.imu.C0769b;
import com.baidu.p020ar.statistic.StatisticConstants;

/* renamed from: com.baidu.ar.track.TrackStateMachine */
public class TrackStateMachine {

    /* renamed from: a */
    private static volatile TrackStateMachine f2314a;

    /* renamed from: e */
    private static STATE f2315e = STATE.INITIAL_STATE;

    /* renamed from: b */
    private STATE f2316b = STATE.INITIAL_STATE;

    /* renamed from: c */
    private STATE f2317c = STATE.INITIAL_STATE;

    /* renamed from: d */
    private STATE f2318d = STATE.INITIAL_STATE;

    /* renamed from: f */
    private Handler f2319f;

    /* renamed from: g */
    private C0769b f2320g;

    /* renamed from: h */
    private int f2321h = 0;

    /* renamed from: i */
    private int f2322i = 0;

    /* renamed from: j */
    private int f2323j = 0;

    /* renamed from: k */
    private int f2324k = 0;

    /* renamed from: l */
    private long f2325l;

    /* renamed from: m */
    private long f2326m;

    /* renamed from: com.baidu.ar.track.TrackStateMachine$EVENT */
    public enum EVENT {
        MODEL_APPEAR,
        MODEL_DISAPPEAR,
        TRACK_SUCCESS,
        TRACK_FAILED,
        TRACK_IMU_OPEN,
        TRACK_IMU_CLOSE,
        DOWNLOAD_RES_FINISH,
        LOAD_MODEL_START,
        LOAD_MODEL_FINISH,
        OPEN_TRACK_ALGO,
        CLOSE_TRACK_ALGO
    }

    /* renamed from: com.baidu.ar.track.TrackStateMachine$STATE */
    public enum STATE {
        INITIAL_STATE,
        TRACK_START,
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

    private TrackStateMachine() {
    }

    /* renamed from: a */
    private void m2660a(int i) {
        try {
            if (this.f2319f != null) {
                this.f2319f.sendEmptyMessage(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m2661a(int i, Bundle bundle) {
        try {
            if (this.f2319f != null) {
                Message obtainMessage = this.f2319f.obtainMessage();
                obtainMessage.what = i;
                obtainMessage.setData(bundle);
                this.f2319f.sendMessage(obtainMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m2662a(Message message) {
        try {
            if (this.f2319f != null) {
                this.f2319f.sendMessage(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m2663a(Message message, long j) {
        try {
            if (this.f2319f != null) {
                this.f2319f.sendMessageDelayed(message, j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m2664a(STATE state) {
        this.f2316b = state;
    }

    /* renamed from: b */
    private void m2665b(STATE state) {
        this.f2317c = state;
    }

    public static void destroy() {
        TrackStateMachine instance = getInstance();
        instance.f2319f = null;
        instance.f2323j = 0;
        instance.f2324k = 0;
        instance.f2321h = 0;
        instance.f2322i = 0;
        f2314a = null;
    }

    public static TrackStateMachine getInstance() {
        if (f2314a == null) {
            synchronized (TrackStateMachine.class) {
                if (f2314a == null) {
                    f2314a = new TrackStateMachine();
                }
            }
        }
        return f2314a;
    }

    public static void setAppState(STATE state) {
        f2315e = state;
    }

    public STATE getTrackState() {
        return this.f2318d;
    }

    public void init() {
        setAppState(STATE.INITIAL_STATE);
        this.f2316b = STATE.INITIAL_STATE;
        this.f2317c = STATE.INITIAL_STATE;
        this.f2318d = STATE.INITIAL_STATE;
    }

    public boolean isEngineSetTrackLostHandler() {
        return this.f2323j == 1;
    }

    public boolean isImuRelayCtrWhenTrackLost() {
        return this.f2322i == 1;
    }

    public boolean isShowImmediately() {
        return this.f2321h == 1;
    }

    public synchronized void processEvent(EVENT event) {
        processEvent(event, (Bundle) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0213, code lost:
        m2665b(r12);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void processEvent(com.baidu.p020ar.track.TrackStateMachine.EVENT r12, android.os.Bundle r13) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x027e }
            r0.<init>()     // Catch:{ all -> 0x027e }
            java.lang.String r1 = "event="
            r0.append(r1)     // Catch:{ all -> 0x027e }
            r0.append(r12)     // Catch:{ all -> 0x027e }
            java.lang.String r1 = ", state="
            r0.append(r1)     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r1 = r11.f2316b     // Catch:{ all -> 0x027e }
            r0.append(r1)     // Catch:{ all -> 0x027e }
            java.lang.String r1 = ", BgState="
            r0.append(r1)     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r1 = r11.f2317c     // Catch:{ all -> 0x027e }
            r0.append(r1)     // Catch:{ all -> 0x027e }
            java.lang.String r1 = ", AppState="
            r0.append(r1)     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r1 = f2315e     // Catch:{ all -> 0x027e }
            r0.append(r1)     // Catch:{ all -> 0x027e }
            java.lang.String r1 = ", TrackState="
            r0.append(r1)     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r1 = r11.f2318d     // Catch:{ all -> 0x027e }
            r0.append(r1)     // Catch:{ all -> 0x027e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x027e }
            com.baidu.p020ar.util.ARLog.m2695d(r0)     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r0 = f2315e     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r1 = com.baidu.p020ar.track.TrackStateMachine.STATE.DESTROY     // Catch:{ all -> 0x027e }
            if (r0 != r1) goto L_0x0045
            monitor-exit(r11)
            return
        L_0x0045:
            int[] r0 = com.baidu.p020ar.track.TrackStateMachine.C09041.f2328b     // Catch:{ all -> 0x027e }
            int r12 = r12.ordinal()     // Catch:{ all -> 0x027e }
            r12 = r0[r12]     // Catch:{ all -> 0x027e }
            r0 = 312(0x138, float:4.37E-43)
            r1 = 306(0x132, float:4.29E-43)
            r2 = 102(0x66, float:1.43E-43)
            r3 = 101(0x65, float:1.42E-43)
            r4 = 0
            r5 = 307(0x133, float:4.3E-43)
            r6 = 1
            switch(r12) {
                case 1: goto L_0x0217;
                case 2: goto L_0x0217;
                case 3: goto L_0x0178;
                case 4: goto L_0x0165;
                case 5: goto L_0x0146;
                case 6: goto L_0x00f5;
                case 7: goto L_0x00be;
                case 8: goto L_0x0094;
                case 9: goto L_0x006c;
                case 10: goto L_0x0065;
                case 11: goto L_0x005e;
                default: goto L_0x005c;
            }     // Catch:{ all -> 0x027e }
        L_0x005c:
            goto L_0x027c
        L_0x005e:
            r12 = 319(0x13f, float:4.47E-43)
            r11.m2660a((int) r12)     // Catch:{ all -> 0x027e }
            goto L_0x027c
        L_0x0065:
            r12 = 318(0x13e, float:4.46E-43)
            r11.m2660a((int) r12)     // Catch:{ all -> 0x027e }
            goto L_0x027c
        L_0x006c:
            java.lang.String r12 = "bdar"
            java.lang.String r13 = "model disapear"
            android.util.Log.e(r12, r13)     // Catch:{ all -> 0x027e }
            android.os.Bundle r12 = new android.os.Bundle     // Catch:{ all -> 0x027e }
            r12.<init>()     // Catch:{ all -> 0x027e }
            java.lang.String r13 = "show_immediately"
            int r0 = r11.f2321h     // Catch:{ all -> 0x027e }
            r12.putInt(r13, r0)     // Catch:{ all -> 0x027e }
            android.os.Message r13 = android.os.Message.obtain()     // Catch:{ all -> 0x027e }
            r13.what = r5     // Catch:{ all -> 0x027e }
            r13.setData(r12)     // Catch:{ all -> 0x027e }
            r0 = 100
            r11.m2663a((android.os.Message) r13, (long) r0)     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r12 = com.baidu.p020ar.track.TrackStateMachine.STATE.MODEL_NOT_SHOWING     // Catch:{ all -> 0x027e }
        L_0x008f:
            r11.m2664a((com.baidu.p020ar.track.TrackStateMachine.STATE) r12)     // Catch:{ all -> 0x027e }
            goto L_0x027c
        L_0x0094:
            java.lang.String r12 = "bdar"
            java.lang.String r13 = "model appear"
            android.util.Log.e(r12, r13)     // Catch:{ all -> 0x027e }
            r12 = 1809(0x711, float:2.535E-42)
            java.lang.String r13 = " track model disapper!"
            com.baidu.p020ar.base.C0618d.m1300a((int) r12, (java.lang.String) r13)     // Catch:{ all -> 0x027e }
            android.os.Handler r12 = r11.f2319f     // Catch:{ Exception -> 0x00b4 }
            if (r12 == 0) goto L_0x00b8
            android.os.Handler r12 = r11.f2319f     // Catch:{ Exception -> 0x00b4 }
            boolean r12 = r12.hasMessages(r5)     // Catch:{ Exception -> 0x00b4 }
            if (r12 == 0) goto L_0x00b8
            android.os.Handler r12 = r11.f2319f     // Catch:{ Exception -> 0x00b4 }
            r12.removeMessages(r5)     // Catch:{ Exception -> 0x00b4 }
            goto L_0x00b8
        L_0x00b4:
            r12 = move-exception
            r12.printStackTrace()     // Catch:{ all -> 0x027e }
        L_0x00b8:
            r11.m2660a((int) r1)     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r12 = com.baidu.p020ar.track.TrackStateMachine.STATE.MODEL_SHOWING     // Catch:{ all -> 0x027e }
            goto L_0x008f
        L_0x00be:
            com.baidu.ar.imu.b r12 = r11.f2320g     // Catch:{ all -> 0x027e }
            if (r12 == 0) goto L_0x027c
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ all -> 0x027e }
            r12.<init>()     // Catch:{ all -> 0x027e }
            java.lang.String r13 = "succeeded"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x027e }
            r12.put(r13, r0)     // Catch:{ all -> 0x027e }
            com.baidu.ar.imu.b r13 = r11.f2320g     // Catch:{ all -> 0x027e }
            r13.mo10129b()     // Catch:{ all -> 0x027e }
            com.baidu.ar.a r13 = com.baidu.p020ar.C0482a.m796a()     // Catch:{ all -> 0x027e }
            r13.mo8915d()     // Catch:{ all -> 0x027e }
            com.baidu.ar.a r13 = com.baidu.p020ar.C0482a.m796a()     // Catch:{ all -> 0x027e }
            r13.mo8919g((boolean) r6)     // Catch:{ all -> 0x027e }
            com.baidu.ar.a r13 = com.baidu.p020ar.C0482a.m796a()     // Catch:{ all -> 0x027e }
            r13.mo8911b()     // Catch:{ all -> 0x027e }
            com.baidu.ar.arplay.core.message.ARPMessage r13 = com.baidu.p020ar.arplay.core.message.ARPMessage.getInstance()     // Catch:{ all -> 0x027e }
            r0 = 304(0x130, float:4.26E-43)
            r13.sendMessage(r0, r12)     // Catch:{ all -> 0x027e }
            goto L_0x027c
        L_0x00f5:
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ all -> 0x027e }
            r12.<init>()     // Catch:{ all -> 0x027e }
            com.baidu.ar.imu.b r0 = r11.f2320g     // Catch:{ NullPointerException -> 0x013f }
            r0.mo10125a((android.os.Bundle) r13)     // Catch:{ NullPointerException -> 0x013f }
            com.baidu.ar.imu.b r0 = r11.f2320g     // Catch:{ NullPointerException -> 0x013f }
            java.lang.String r1 = "type"
            int r1 = r13.getInt(r1)     // Catch:{ NullPointerException -> 0x013f }
            boolean r0 = r0.mo10127a((int) r1)     // Catch:{ NullPointerException -> 0x013f }
            if (r0 == 0) goto L_0x011e
            java.lang.String r0 = "succeeded"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x027e }
            r12.put(r0, r1)     // Catch:{ all -> 0x027e }
            com.baidu.ar.a r0 = com.baidu.p020ar.C0482a.m796a()     // Catch:{ all -> 0x027e }
            r0.mo8919g((boolean) r6)     // Catch:{ all -> 0x027e }
            goto L_0x012f
        L_0x011e:
            java.lang.String r0 = "succeeded"
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x027e }
            r12.put(r0, r2)     // Catch:{ all -> 0x027e }
            com.baidu.ar.a r0 = com.baidu.p020ar.C0482a.m796a()     // Catch:{ all -> 0x027e }
            r0.mo8919g((boolean) r1)     // Catch:{ all -> 0x027e }
        L_0x012f:
            com.baidu.ar.arplay.core.message.ARPMessage r0 = com.baidu.p020ar.arplay.core.message.ARPMessage.getInstance()     // Catch:{ all -> 0x027e }
            r1 = 302(0x12e, float:4.23E-43)
            r0.sendMessage(r1, r12)     // Catch:{ all -> 0x027e }
            r12 = 313(0x139, float:4.39E-43)
            r11.m2661a((int) r12, (android.os.Bundle) r13)     // Catch:{ all -> 0x027e }
            goto L_0x027c
        L_0x013f:
            java.lang.String r12 = "bdar:has NullPointerException!!!"
            com.baidu.p020ar.util.ARLog.m2699w(r12)     // Catch:{ all -> 0x027e }
            goto L_0x027c
        L_0x0146:
            com.baidu.ar.track.TrackStateMachine$STATE r12 = com.baidu.p020ar.track.TrackStateMachine.STATE.NOT_TRACKED     // Catch:{ all -> 0x027e }
            r11.f2318d = r12     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r12 = r11.f2317c     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r13 = com.baidu.p020ar.track.TrackStateMachine.STATE.MODEL_LOAD_FINISH     // Catch:{ all -> 0x027e }
            if (r12 != r13) goto L_0x027c
            com.baidu.ar.arplay.core.message.ARPMessage r12 = com.baidu.p020ar.arplay.core.message.ARPMessage.getInstance()     // Catch:{ all -> 0x027e }
            r12.sendMessage(r2, r4)     // Catch:{ all -> 0x027e }
            r12 = 310(0x136, float:4.34E-43)
            r11.m2660a((int) r12)     // Catch:{ all -> 0x027e }
            r12 = 1812(0x714, float:2.539E-42)
            java.lang.String r13 = " track lost!"
            com.baidu.p020ar.base.C0618d.m1300a((int) r12, (java.lang.String) r13)     // Catch:{ all -> 0x027e }
            goto L_0x027c
        L_0x0165:
            com.baidu.ar.track.TrackStateMachine$STATE r12 = com.baidu.p020ar.track.TrackStateMachine.STATE.TRACKED     // Catch:{ all -> 0x027e }
            r11.f2318d = r12     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r12 = r11.f2317c     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r13 = com.baidu.p020ar.track.TrackStateMachine.STATE.MODEL_LOAD_FINISH     // Catch:{ all -> 0x027e }
            if (r12 != r13) goto L_0x027c
            com.baidu.ar.arplay.core.message.ARPMessage r12 = com.baidu.p020ar.arplay.core.message.ARPMessage.getInstance()     // Catch:{ all -> 0x027e }
            r12.sendMessage(r3, r4)     // Catch:{ all -> 0x027e }
            goto L_0x027c
        L_0x0178:
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x027e }
            r11.f2326m = r7     // Catch:{ all -> 0x027e }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x027e }
            r12.<init>()     // Catch:{ all -> 0x027e }
            java.lang.String r1 = "[TrackStateMachine]loadModelEnd="
            r12.append(r1)     // Catch:{ all -> 0x027e }
            long r7 = r11.f2326m     // Catch:{ all -> 0x027e }
            r12.append(r7)     // Catch:{ all -> 0x027e }
            java.lang.String r1 = ",cost:"
            r12.append(r1)     // Catch:{ all -> 0x027e }
            long r7 = r11.f2326m     // Catch:{ all -> 0x027e }
            long r9 = r11.f2325l     // Catch:{ all -> 0x027e }
            r1 = 0
            long r7 = r7 - r9
            r12.append(r7)     // Catch:{ all -> 0x027e }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x027e }
            com.baidu.p020ar.util.ARLog.m2695d(r12)     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r12 = r11.f2317c     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r1 = com.baidu.p020ar.track.TrackStateMachine.STATE.MODEL_LOADING     // Catch:{ all -> 0x027e }
            if (r12 != r1) goto L_0x027c
            com.baidu.ar.rotate.Orientation r12 = com.baidu.p020ar.rotate.OrientationManager.getGlobalOrientation()     // Catch:{ all -> 0x027e }
            int r12 = r12.getDegree()     // Catch:{ all -> 0x027e }
            com.baidu.p020ar.msghandler.C0802a.m2100a((int) r12)     // Catch:{ all -> 0x027e }
            r12 = 301(0x12d, float:4.22E-43)
            r11.m2660a((int) r12)     // Catch:{ all -> 0x027e }
            android.os.Message r12 = android.os.Message.obtain()     // Catch:{ all -> 0x027e }
            r12.what = r0     // Catch:{ all -> 0x027e }
            r12.setData(r13)     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r0 = r11.f2318d     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r1 = com.baidu.p020ar.track.TrackStateMachine.STATE.INITIAL_STATE     // Catch:{ all -> 0x027e }
            if (r0 != r1) goto L_0x01cb
            r11.m2662a((android.os.Message) r12)     // Catch:{ all -> 0x027e }
            goto L_0x01e9
        L_0x01cb:
            com.baidu.ar.track.TrackStateMachine$STATE r0 = r11.f2318d     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r1 = com.baidu.p020ar.track.TrackStateMachine.STATE.NOT_TRACKED     // Catch:{ all -> 0x027e }
            if (r0 != r1) goto L_0x01dc
            r11.m2662a((android.os.Message) r12)     // Catch:{ all -> 0x027e }
            com.baidu.ar.arplay.core.message.ARPMessage r12 = com.baidu.p020ar.arplay.core.message.ARPMessage.getInstance()     // Catch:{ all -> 0x027e }
            r12.sendMessage(r2, r4)     // Catch:{ all -> 0x027e }
            goto L_0x01e9
        L_0x01dc:
            com.baidu.ar.track.TrackStateMachine$STATE r12 = r11.f2318d     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r0 = com.baidu.p020ar.track.TrackStateMachine.STATE.TRACKED     // Catch:{ all -> 0x027e }
            if (r12 != r0) goto L_0x01e9
            com.baidu.ar.arplay.core.message.ARPMessage r12 = com.baidu.p020ar.arplay.core.message.ARPMessage.getInstance()     // Catch:{ all -> 0x027e }
            r12.sendMessage(r3, r4)     // Catch:{ all -> 0x027e }
        L_0x01e9:
            if (r13 == 0) goto L_0x0211
            java.lang.String r12 = "show_immediately"
            int r12 = r13.getInt(r12)     // Catch:{ all -> 0x027e }
            r11.f2321h = r12     // Catch:{ all -> 0x027e }
            java.lang.String r12 = "imu_relay_ctrl_when_track_lost"
            int r12 = r13.getInt(r12)     // Catch:{ all -> 0x027e }
            r11.f2322i = r12     // Catch:{ all -> 0x027e }
            int r12 = r11.f2321h     // Catch:{ all -> 0x027e }
            if (r12 != r6) goto L_0x0211
            com.baidu.ar.arplay.core.ARPEngine r12 = com.baidu.p020ar.arplay.core.ARPEngine.getInstance()     // Catch:{ all -> 0x027e }
            r12.onResumeByUser()     // Catch:{ all -> 0x027e }
            com.baidu.ar.arplay.core.ARPEngine r12 = com.baidu.p020ar.arplay.core.ARPEngine.getInstance()     // Catch:{ all -> 0x027e }
            com.baidu.ar.arplay.core.ARPScene r12 = r12.getCurrentScene()     // Catch:{ all -> 0x027e }
            r12.mo9204a((boolean) r6)     // Catch:{ all -> 0x027e }
        L_0x0211:
            com.baidu.ar.track.TrackStateMachine$STATE r12 = com.baidu.p020ar.track.TrackStateMachine.STATE.MODEL_LOAD_FINISH     // Catch:{ all -> 0x027e }
        L_0x0213:
            r11.m2665b(r12)     // Catch:{ all -> 0x027e }
            goto L_0x027c
        L_0x0217:
            com.baidu.ar.track.TrackStateMachine$STATE r12 = r11.f2317c     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r13 = com.baidu.p020ar.track.TrackStateMachine.STATE.MODEL_LOAD_FINISH     // Catch:{ all -> 0x027e }
            if (r12 != r13) goto L_0x0248
            android.os.Bundle r12 = new android.os.Bundle     // Catch:{ all -> 0x027e }
            r12.<init>()     // Catch:{ all -> 0x027e }
            java.lang.String r13 = "show_immediately"
            int r2 = r11.f2321h     // Catch:{ all -> 0x027e }
            r12.putInt(r13, r2)     // Catch:{ all -> 0x027e }
            int[] r13 = com.baidu.p020ar.track.TrackStateMachine.C09041.f2327a     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r2 = r11.f2316b     // Catch:{ all -> 0x027e }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x027e }
            r13 = r13[r2]     // Catch:{ all -> 0x027e }
            switch(r13) {
                case 1: goto L_0x023f;
                case 2: goto L_0x023b;
                case 3: goto L_0x0237;
                default: goto L_0x0236;
            }     // Catch:{ all -> 0x027e }
        L_0x0236:
            goto L_0x0242
        L_0x0237:
            r11.m2660a((int) r1)     // Catch:{ all -> 0x027e }
            goto L_0x0242
        L_0x023b:
            r11.m2661a((int) r5, (android.os.Bundle) r12)     // Catch:{ all -> 0x027e }
            goto L_0x0242
        L_0x023f:
            r11.m2661a((int) r0, (android.os.Bundle) r12)     // Catch:{ all -> 0x027e }
        L_0x0242:
            r12 = 314(0x13a, float:4.4E-43)
            r11.m2660a((int) r12)     // Catch:{ all -> 0x027e }
            goto L_0x027c
        L_0x0248:
            com.baidu.ar.track.TrackStateMachine$STATE r12 = r11.f2316b     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r13 = com.baidu.p020ar.track.TrackStateMachine.STATE.TRACK_START     // Catch:{ all -> 0x027e }
            if (r12 != r13) goto L_0x0258
            com.baidu.ar.track.TrackStateMachine$STATE r12 = r11.f2317c     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r13 = com.baidu.p020ar.track.TrackStateMachine.STATE.MODEL_LOAD_FINISH     // Catch:{ all -> 0x027e }
            if (r12 != r13) goto L_0x027c
            r11.m2660a((int) r5)     // Catch:{ all -> 0x027e }
            goto L_0x027c
        L_0x0258:
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x027e }
            r11.f2325l = r12     // Catch:{ all -> 0x027e }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x027e }
            r12.<init>()     // Catch:{ all -> 0x027e }
            java.lang.String r13 = "[TrackStateMachine]loadModelStart="
            r12.append(r13)     // Catch:{ all -> 0x027e }
            long r0 = r11.f2325l     // Catch:{ all -> 0x027e }
            r12.append(r0)     // Catch:{ all -> 0x027e }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x027e }
            com.baidu.p020ar.util.ARLog.m2695d(r12)     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r12 = com.baidu.p020ar.track.TrackStateMachine.STATE.TRACK_START     // Catch:{ all -> 0x027e }
            r11.m2664a((com.baidu.p020ar.track.TrackStateMachine.STATE) r12)     // Catch:{ all -> 0x027e }
            com.baidu.ar.track.TrackStateMachine$STATE r12 = com.baidu.p020ar.track.TrackStateMachine.STATE.MODEL_LOADING     // Catch:{ all -> 0x027e }
            goto L_0x0213
        L_0x027c:
            monitor-exit(r11)
            return
        L_0x027e:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.track.TrackStateMachine.processEvent(com.baidu.ar.track.TrackStateMachine$EVENT, android.os.Bundle):void");
    }

    public synchronized void processRMatrix(Bundle bundle) {
        float[] floatArray;
        if (!(this.f2317c != STATE.MODEL_LOAD_FINISH || this.f2318d == STATE.TRACKED || (floatArray = bundle.getFloatArray("RMatrix")) == null)) {
            C0482a.m796a().mo8910a(floatArray, bundle.getInt("init_pos"));
            StatisticConstants.setIsRenderModel(true);
            if (!(ARPEngine.getInstance().getArGLEngineCtl() == null || ARPEngine.getInstance().getArGLEngineCtl().mo9239e() == 1)) {
                ARPEngine.getInstance().getArGLEngineCtl().mo9232a(1);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c0, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c2, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void processRtMatrix(android.os.Bundle r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.baidu.ar.track.TrackStateMachine$STATE r0 = f2315e     // Catch:{ all -> 0x00c3 }
            com.baidu.ar.track.TrackStateMachine$STATE r1 = com.baidu.p020ar.track.TrackStateMachine.STATE.PAUSE     // Catch:{ all -> 0x00c3 }
            if (r0 == r1) goto L_0x00c1
            com.baidu.ar.track.TrackStateMachine$STATE r0 = f2315e     // Catch:{ all -> 0x00c3 }
            com.baidu.ar.track.TrackStateMachine$STATE r1 = com.baidu.p020ar.track.TrackStateMachine.STATE.DESTROY     // Catch:{ all -> 0x00c3 }
            if (r0 != r1) goto L_0x000f
            goto L_0x00c1
        L_0x000f:
            com.baidu.ar.track.TrackStateMachine$STATE r0 = r4.f2317c     // Catch:{ all -> 0x00c3 }
            com.baidu.ar.track.TrackStateMachine$STATE r1 = com.baidu.p020ar.track.TrackStateMachine.STATE.MODEL_LOAD_FINISH     // Catch:{ all -> 0x00c3 }
            if (r0 != r1) goto L_0x00bf
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
            r0.<init>()     // Catch:{ all -> 0x00c3 }
            java.lang.String r1 = "bdar: processRtMatrix isTracked = "
            r0.append(r1)     // Catch:{ all -> 0x00c3 }
            java.lang.String r1 = "isTracked"
            boolean r1 = r5.getBoolean(r1)     // Catch:{ all -> 0x00c3 }
            r0.append(r1)     // Catch:{ all -> 0x00c3 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c3 }
            com.baidu.p020ar.util.ARLog.m2695d(r0)     // Catch:{ all -> 0x00c3 }
            if (r5 == 0) goto L_0x00bf
            java.lang.String r0 = "RTMatrix"
            float[] r0 = r5.getFloatArray(r0)     // Catch:{ all -> 0x00c3 }
            com.baidu.ar.track.TrackStateMachine$STATE r1 = r4.f2318d     // Catch:{ all -> 0x00c3 }
            com.baidu.ar.track.TrackStateMachine$STATE r2 = com.baidu.p020ar.track.TrackStateMachine.STATE.TRACKED     // Catch:{ all -> 0x00c3 }
            r3 = 1
            if (r1 != r2) goto L_0x009e
            if (r0 == 0) goto L_0x009e
            com.baidu.ar.a r1 = com.baidu.p020ar.C0482a.m796a()     // Catch:{ all -> 0x00c3 }
            r1.mo8913b((float[]) r0)     // Catch:{ all -> 0x00c3 }
            android.os.Message r0 = new android.os.Message     // Catch:{ all -> 0x00c3 }
            r0.<init>()     // Catch:{ all -> 0x00c3 }
            r1 = 302(0x12e, float:4.23E-43)
            r0.what = r1     // Catch:{ all -> 0x00c3 }
            r0.setData(r5)     // Catch:{ all -> 0x00c3 }
            r4.m2662a((android.os.Message) r0)     // Catch:{ all -> 0x00c3 }
            com.baidu.ar.arplay.core.ARPEngine r0 = com.baidu.p020ar.arplay.core.ARPEngine.getInstance()     // Catch:{ all -> 0x00c3 }
            com.baidu.ar.arplay.core.a r0 = r0.getArGLEngineCtl()     // Catch:{ all -> 0x00c3 }
            if (r0 == 0) goto L_0x00bf
            com.baidu.ar.arplay.core.ARPEngine r0 = com.baidu.p020ar.arplay.core.ARPEngine.getInstance()     // Catch:{ all -> 0x00c3 }
            com.baidu.ar.arplay.core.a r0 = r0.getArGLEngineCtl()     // Catch:{ all -> 0x00c3 }
            int r0 = r0.mo9239e()     // Catch:{ all -> 0x00c3 }
            java.lang.String r1 = "averageTime"
            int r5 = r5.getInt(r1)     // Catch:{ all -> 0x00c3 }
            r1 = 40
            if (r5 <= r1) goto L_0x0084
            if (r0 == r3) goto L_0x00bf
            com.baidu.ar.arplay.core.ARPEngine r5 = com.baidu.p020ar.arplay.core.ARPEngine.getInstance()     // Catch:{ all -> 0x00c3 }
            com.baidu.ar.arplay.core.a r5 = r5.getArGLEngineCtl()     // Catch:{ all -> 0x00c3 }
        L_0x0080:
            r5.mo9232a((int) r3)     // Catch:{ all -> 0x00c3 }
            goto L_0x00bf
        L_0x0084:
            if (r0 == 0) goto L_0x0092
            com.baidu.ar.arplay.core.ARPEngine r5 = com.baidu.p020ar.arplay.core.ARPEngine.getInstance()     // Catch:{ all -> 0x00c3 }
            com.baidu.ar.arplay.core.a r5 = r5.getArGLEngineCtl()     // Catch:{ all -> 0x00c3 }
            r0 = 0
            r5.mo9232a((int) r0)     // Catch:{ all -> 0x00c3 }
        L_0x0092:
            com.baidu.ar.arplay.core.ARPEngine r5 = com.baidu.p020ar.arplay.core.ARPEngine.getInstance()     // Catch:{ all -> 0x00c3 }
            com.baidu.ar.arplay.core.a r5 = r5.getArGLEngineCtl()     // Catch:{ all -> 0x00c3 }
            r5.mo9237c()     // Catch:{ all -> 0x00c3 }
            goto L_0x00bf
        L_0x009e:
            com.baidu.ar.arplay.core.ARPEngine r5 = com.baidu.p020ar.arplay.core.ARPEngine.getInstance()     // Catch:{ all -> 0x00c3 }
            com.baidu.ar.arplay.core.a r5 = r5.getArGLEngineCtl()     // Catch:{ all -> 0x00c3 }
            if (r5 == 0) goto L_0x00bf
            com.baidu.ar.arplay.core.ARPEngine r5 = com.baidu.p020ar.arplay.core.ARPEngine.getInstance()     // Catch:{ all -> 0x00c3 }
            com.baidu.ar.arplay.core.a r5 = r5.getArGLEngineCtl()     // Catch:{ all -> 0x00c3 }
            int r5 = r5.mo9239e()     // Catch:{ all -> 0x00c3 }
            if (r5 == r3) goto L_0x00bf
            com.baidu.ar.arplay.core.ARPEngine r5 = com.baidu.p020ar.arplay.core.ARPEngine.getInstance()     // Catch:{ all -> 0x00c3 }
            com.baidu.ar.arplay.core.a r5 = r5.getArGLEngineCtl()     // Catch:{ all -> 0x00c3 }
            goto L_0x0080
        L_0x00bf:
            monitor-exit(r4)
            return
        L_0x00c1:
            monitor-exit(r4)
            return
        L_0x00c3:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.track.TrackStateMachine.processRtMatrix(android.os.Bundle):void");
    }

    public void setIMUController(C0769b bVar) {
        this.f2320g = bVar;
    }

    public void setIsEngineSetTrackLostHandler(int i) {
        this.f2323j = i;
    }

    public void setIsEngineSetTrackOnHandler(int i) {
        this.f2324k = i;
    }

    public void setMainThreadHandler(Handler handler) {
        this.f2319f = handler;
    }
}
