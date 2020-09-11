package com.baidu.p020ar.msghandler;

import android.content.Context;
import com.baidu.p020ar.arplay.core.message.ARPMessage;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.p041c.C0750a;
import com.baidu.p020ar.statistic.StatisticConstants;
import com.baidu.p020ar.statistic.StatisticHelper;
import com.baidu.p020ar.util.ARLog;
import java.util.HashMap;

/* renamed from: com.baidu.ar.msghandler.ComponentMsgHandler */
public class ComponentMsgHandler implements C0811d {

    /* renamed from: c */
    private static C0750a.C0751a f1859c = new C0750a.C0751a() {
        /* renamed from: a */
        public void mo10081a() {
        }

        /* renamed from: a */
        public void mo10082a(float f, float f2, float f3, float f4) {
            ARLog.m2696e("acc  x " + f + " , y : " + f2 + " , z " + f3);
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.MODEL_PHONE_SHAKE);
            ComponentMsgHandler.sendAccelerationToLua(f, f2, f3, f4);
        }
    };

    /* renamed from: a */
    private Context f1860a;

    /* renamed from: b */
    private C0804b f1861b;

    public ComponentMsgHandler(Context context) {
        this.f1860a = context.getApplicationContext();
        this.f1861b = new C0804b(context);
    }

    public static void sendAccelerationToLua(float f, float f2, float f3, float f4) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(ComponentMessageType.MSG_TYPE_ON_SHAKE));
        hashMap.put("max_acc", Float.valueOf(f4));
        sendMessageToLua(hashMap);
    }

    public static void sendMessageToLua(HashMap hashMap) {
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00fe, code lost:
        r5.processEvent(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0188, code lost:
        r5.mo10594a(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0056, code lost:
        com.baidu.p020ar.msghandler.C0812e.m2129a().mo10287a(r0, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseComponentData(java.util.HashMap<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x018b
            java.lang.String r0 = "id"
            java.lang.Object r0 = r5.get(r0)
            r1 = -1
            int r0 = com.baidu.p020ar.arplay.util.MsgParamsUtil.obj2Int(r0, r1)
            java.lang.String r1 = "lua  "
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = " ARPEngine.ARPLuaSdkBridgeMessageType = "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            r1 = 5
            r2 = 1
            switch(r0) {
                case 4100: goto L_0x012e;
                case 4200: goto L_0x0124;
                case 10001: goto L_0x0118;
                case 10002: goto L_0x010e;
                case 10004: goto L_0x0103;
                case 10101: goto L_0x00f2;
                case 10102: goto L_0x00e5;
                case 20001: goto L_0x006a;
                case 21111: goto L_0x005f;
                case 21113: goto L_0x005f;
                case 30000: goto L_0x0040;
                case 999999: goto L_0x002d;
                default: goto L_0x0028;
            }
        L_0x0028:
            com.baidu.p020ar.base.C0618d.m1302a((java.util.HashMap<java.lang.String, java.lang.Object>) r5)
            goto L_0x018b
        L_0x002d:
            java.lang.String r1 = "filename"
            java.lang.Object r5 = r5.get(r1)
            java.lang.String r5 = (java.lang.String) r5
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r2 = "debugScreenShotFileName"
            r1.putString(r2, r5)
            goto L_0x0056
        L_0x0040:
            java.lang.String r1 = "visibleType"
            java.lang.Object r5 = r5.get(r1)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r2 = "view_visible_id"
            r1.putInt(r2, r5)
        L_0x0056:
            com.baidu.ar.msghandler.e r5 = com.baidu.p020ar.msghandler.C0812e.m2129a()
            r5.mo10287a(r0, r1)
            goto L_0x018b
        L_0x005f:
            com.baidu.ar.msghandler.b r0 = r4.f1861b
            if (r0 == 0) goto L_0x018b
            com.baidu.ar.msghandler.b r0 = r4.f1861b
            r0.parseComponentData(r5)
            goto L_0x018b
        L_0x006a:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            if (r5 == 0) goto L_0x008a
            java.lang.String r3 = "type"
            boolean r3 = r5.containsKey(r3)
            if (r3 == 0) goto L_0x008a
            java.lang.String r2 = "type"
            java.lang.Object r2 = r5.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.lang.String r3 = "type"
            r0.putInt(r3, r2)
        L_0x008a:
            if (r5 == 0) goto L_0x00a6
            java.lang.String r3 = "resume_original_position"
            boolean r3 = r5.containsKey(r3)
            if (r3 == 0) goto L_0x00a6
            java.lang.String r3 = "resume_original_position"
            java.lang.Object r5 = r5.get(r3)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.String r3 = "resume_original_position"
            r0.putInt(r3, r5)
            goto L_0x00ac
        L_0x00a6:
            java.lang.String r5 = "resume_original_position"
            r3 = 0
            r0.putInt(r5, r3)
        L_0x00ac:
            int r5 = com.baidu.p020ar.bean.ARConfig.getARType()
            if (r5 != 0) goto L_0x00c4
            com.baidu.ar.arplay.core.ARPEngine r5 = com.baidu.p020ar.arplay.core.ARPEngine.getInstance()
            r5.setImuType(r2)
            com.baidu.ar.track.TrackStateMachine r5 = com.baidu.p020ar.track.TrackStateMachine.getInstance()
            com.baidu.ar.track.TrackStateMachine$EVENT r1 = com.baidu.p020ar.track.TrackStateMachine.EVENT.TRACK_IMU_OPEN
            r5.processEvent(r1, r0)
            goto L_0x018b
        L_0x00c4:
            int r5 = com.baidu.p020ar.bean.ARConfig.getARType()
            if (r5 != r1) goto L_0x00d2
            com.baidu.ar.slam.SlamStateMachine r5 = com.baidu.p020ar.slam.SlamStateMachine.m2584a()
            com.baidu.ar.slam.SlamStateMachine$EVENT r1 = com.baidu.p020ar.slam.SlamStateMachine.EVENT.SLAM_IMU_OPEN
            goto L_0x0188
        L_0x00d2:
            int r5 = com.baidu.p020ar.bean.ARConfig.getARType()
            r1 = 8
            if (r5 != r1) goto L_0x018b
            com.baidu.ar.imu.ImuStateMachine r5 = com.baidu.p020ar.imu.ImuStateMachine.m1994a()
            com.baidu.ar.imu.ImuStateMachine$EVENT r1 = com.baidu.p020ar.imu.ImuStateMachine.EVENT.IMU_OPEN
            r5.mo10120a((com.baidu.p020ar.imu.ImuStateMachine.EVENT) r1, (android.os.Bundle) r0)
            goto L_0x018b
        L_0x00e5:
            int r5 = com.baidu.p020ar.bean.ARConfig.getARType()
            if (r5 != 0) goto L_0x018b
            com.baidu.ar.track.TrackStateMachine r5 = com.baidu.p020ar.track.TrackStateMachine.getInstance()
            com.baidu.ar.track.TrackStateMachine$EVENT r0 = com.baidu.p020ar.track.TrackStateMachine.EVENT.CLOSE_TRACK_ALGO
            goto L_0x00fe
        L_0x00f2:
            int r5 = com.baidu.p020ar.bean.ARConfig.getARType()
            if (r5 != 0) goto L_0x018b
            com.baidu.ar.track.TrackStateMachine r5 = com.baidu.p020ar.track.TrackStateMachine.getInstance()
            com.baidu.ar.track.TrackStateMachine$EVENT r0 = com.baidu.p020ar.track.TrackStateMachine.EVENT.OPEN_TRACK_ALGO
        L_0x00fe:
            r5.processEvent(r0)
            goto L_0x018b
        L_0x0103:
            android.content.Context r5 = r4.f1860a
            com.baidu.ar.c.b r5 = com.baidu.p020ar.p041c.C0752b.m1958a((android.content.Context) r5)
            r5.mo10085a((boolean) r2)
            goto L_0x018b
        L_0x010e:
            android.content.Context r5 = r4.f1860a
            com.baidu.ar.c.b r5 = com.baidu.p020ar.p041c.C0752b.m1958a((android.content.Context) r5)
            r5.mo10083a()
            goto L_0x018b
        L_0x0118:
            android.content.Context r5 = r4.f1860a
            com.baidu.ar.c.b r5 = com.baidu.p020ar.p041c.C0752b.m1958a((android.content.Context) r5)
            com.baidu.ar.c.a$a r0 = f1859c
            r5.mo10084a((com.baidu.p020ar.p041c.C0750a.C0751a) r0)
            goto L_0x018b
        L_0x0124:
            com.baidu.ar.slam.SlamStateMachine r5 = com.baidu.p020ar.slam.SlamStateMachine.m2584a()
            com.baidu.ar.slam.SlamStateMachine$EVENT r0 = com.baidu.p020ar.slam.SlamStateMachine.EVENT.SLAM_START_FROM_LUA
            r5.mo10593a((com.baidu.p020ar.slam.SlamStateMachine.EVENT) r0)
            goto L_0x018b
        L_0x012e:
            int r0 = com.baidu.p020ar.bean.ARConfig.getARType()
            if (r0 != r1) goto L_0x018b
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "x"
            java.lang.String r3 = "x"
            java.lang.Object r3 = r5.get(r3)
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            r0.putFloat(r1, r3)
            java.lang.String r1 = "y"
            java.lang.String r3 = "y"
            java.lang.Object r3 = r5.get(r3)
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            r0.putFloat(r1, r3)
            java.lang.String r1 = "type"
            java.lang.String r3 = "type"
            java.lang.Object r3 = r5.get(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.putInt(r1, r3)
            java.lang.String r1 = "distance"
            java.lang.String r3 = "distance"
            java.lang.Object r5 = r5.get(r3)
            java.lang.Float r5 = (java.lang.Float) r5
            float r5 = r5.floatValue()
            r0.putFloat(r1, r5)
            java.lang.String r5 = "is_from_lua"
            r0.putBoolean(r5, r2)
            com.baidu.ar.slam.SlamStateMachine r5 = com.baidu.p020ar.slam.SlamStateMachine.m2584a()
            com.baidu.ar.slam.SlamStateMachine$EVENT r1 = com.baidu.p020ar.slam.SlamStateMachine.EVENT.SLAM_GUESTURE_INTERACTION
        L_0x0188:
            r5.mo10594a((com.baidu.p020ar.slam.SlamStateMachine.EVENT) r1, (android.os.Bundle) r0)
        L_0x018b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.msghandler.ComponentMsgHandler.parseComponentData(java.util.HashMap):void");
    }

    public void release() {
        if (this.f1861b != null) {
            this.f1861b.release();
            this.f1861b = null;
        }
    }
}
