package com.baidu.p020ar.msghandler;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.p020ar.DuMixCallback;
import com.baidu.p020ar.arplay.core.message.ARPMessage;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.arplay.p034b.C0551a;
import com.baidu.p020ar.arplay.util.MsgParamsUtil;
import com.baidu.p020ar.base.MsgField;
import com.baidu.p020ar.bean.ARConfig;
import com.baidu.p020ar.bean.BrowserBean;
import com.baidu.p020ar.bean.C0625c;
import com.baidu.p020ar.statistic.StatisticHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.baidu.ar.msghandler.a */
public class C0802a extends C0551a {

    /* renamed from: a */
    private Context f1877a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f1878b = 0;

    /* renamed from: c */
    private boolean f1879c = false;

    /* renamed from: d */
    private ComponentMsgHandler f1880d;

    /* renamed from: e */
    private DownloadMsgHandler f1881e;

    /* renamed from: f */
    private C0813f f1882f;

    /* renamed from: g */
    private List<C0811d> f1883g;

    /* renamed from: h */
    private DuMixCallback f1884h;

    public C0802a(Context context) {
        super(context);
        this.f1877a = context.getApplicationContext();
        this.f1878b = ARConfig.getARType();
        this.f1883g = new ArrayList();
        this.f1880d = new ComponentMsgHandler(context);
        this.f1879c = true;
    }

    /* renamed from: a */
    public static void m2100a(int i) {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        if (i == -90) {
            str = "orient";
            str2 = "landscape_left";
        } else if (i == 0) {
            str = "orient";
            str2 = "portrait";
        } else if (i == 90) {
            str = "orient";
            str2 = "landscape_right";
        } else {
            return;
        }
        hashMap.put(str, str2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_DEVICE_ORIENTATION, hashMap);
    }

    /* renamed from: a */
    private void m2101a(HashMap<String, Object> hashMap) {
        if (this.f1884h != null) {
            BrowserBean browserBean = new BrowserBean();
            browserBean.setType(((Integer) hashMap.get("type")).intValue());
            browserBean.setUrl((String) hashMap.get("url"));
            this.f1884h.onStateChange(MsgField.MSG_OPEN_URL, browserBean);
        }
    }

    /* renamed from: b */
    private void m2102b(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            String str = (String) hashMap.get("id");
            String str2 = (String) hashMap.get("type");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                StatisticHelper.getInstance().statisticInfo(str2, str);
            }
        }
    }

    /* renamed from: c */
    private void m2103c(HashMap<String, Object> hashMap) {
        if (MsgParamsUtil.obj2Int(hashMap.get("id"), -1) == 3010 && this.f1881e != null) {
            this.f1881e.onDownloadError();
        }
    }

    /* renamed from: d */
    private void m2104d(HashMap<String, Object> hashMap) {
        if (MsgParamsUtil.obj2Int(hashMap.get("id"), -1) == 9001 && this.f1881e != null) {
            this.f1882f.mo10290a(hashMap);
        }
    }

    /* renamed from: e */
    private void m2105e(HashMap<String, Object> hashMap) {
        if (MsgParamsUtil.obj2Int(hashMap.get("id"), -1) == 10202 && this.f1884h != null) {
            this.f1884h.onStateChange(MsgField.MSG_SWITCH_CAMERA, (Object) null);
        }
    }

    /* renamed from: f */
    private void m2106f(HashMap<String, Object> hashMap) {
        if (MsgParamsUtil.obj2Int(hashMap.get("id"), -1) == 10600 && this.f1884h != null) {
            this.f1884h.onStateChange(MsgField.MSG_TYPE_RENDER_SIZE, true);
        }
    }

    /* renamed from: a */
    public void mo10275a(DuMixCallback duMixCallback) {
        this.f1884h = duMixCallback;
    }

    /* renamed from: a */
    public void mo10276a(C0625c cVar) {
        if (this.f1881e != null) {
            this.f1881e.setResConfigs(cVar);
        }
    }

    /* renamed from: a */
    public void mo10277a(DownloadMsgHandler downloadMsgHandler) {
        this.f1881e = downloadMsgHandler;
    }

    /* renamed from: a */
    public void mo10278a(C0811d dVar) {
        this.f1883g.add(dVar);
    }

    /* renamed from: a */
    public void mo10279a(C0813f fVar) {
        this.f1882f = fVar;
    }

    /* renamed from: b */
    public void mo9084b() {
        super.mo9084b();
        if (this.f1879c) {
            ARPMessage.getInstance().removeMessageHandeler(this);
            this.f1879c = false;
        }
        if (this.f1880d != null) {
            this.f1880d.release();
            this.f1880d = null;
        }
        for (C0811d release : this.f1883g) {
            release.release();
        }
        this.f1883g.clear();
        this.f1884h = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: boolean} */
    /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0213, code lost:
        r4.mo10593a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0222, code lost:
        r4.mo10119a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x022d, code lost:
        r4.processEvent(r5);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(int r4, int r5, java.util.HashMap<java.lang.String, java.lang.Object> r6) {
        /*
            r3 = this;
            super.handleMessage(r4, r5, r6)
            r5 = 8
            r0 = 5
            r1 = 1
            r2 = 0
            switch(r4) {
                case 9: goto L_0x0244;
                case 103: goto L_0x023b;
                case 104: goto L_0x0232;
                case 201: goto L_0x0209;
                case 202: goto L_0x01ec;
                case 301: goto L_0x017a;
                case 303: goto L_0x015a;
                case 305: goto L_0x0138;
                case 306: goto L_0x0115;
                case 401: goto L_0x00e1;
                case 1301: goto L_0x00dc;
                case 1601: goto L_0x02ce;
                case 1801: goto L_0x00d4;
                case 1901: goto L_0x00a6;
                case 4100: goto L_0x004e;
                case 5001: goto L_0x002f;
                case 6001: goto L_0x000d;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x02ce
        L_0x000d:
            java.lang.String r4 = "progress"
            java.lang.Object r4 = r6.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "bdar: MSG_TYPE_MODEL_LOAD_PROGRESS:"
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.baidu.p020ar.util.ARLog.m2696e(r4)
            goto L_0x02ce
        L_0x002f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "bdar: MSG_TYPE_RES_REQUEST:"
            r4.append(r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            com.baidu.p020ar.util.ARLog.m2696e(r4)
            com.baidu.ar.msghandler.DownloadMsgHandler r4 = r3.f1881e
            if (r4 == 0) goto L_0x02ce
            com.baidu.ar.msghandler.DownloadMsgHandler r4 = r3.f1881e
            r4.parseAndExcuteDownloadMsg(r6)
            goto L_0x02ce
        L_0x004e:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r5 = "x"
            java.lang.String r1 = "x"
            java.lang.Object r1 = r6.get(r1)
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            r4.putFloat(r5, r1)
            java.lang.String r5 = "y"
            java.lang.String r1 = "y"
            java.lang.Object r1 = r6.get(r1)
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            r4.putFloat(r5, r1)
            java.lang.String r5 = "type"
            java.lang.String r1 = "type"
            java.lang.Object r1 = r6.get(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r4.putInt(r5, r1)
            java.lang.String r5 = "distance"
            java.lang.String r1 = "distance"
            java.lang.Object r6 = r6.get(r1)
            java.lang.Float r6 = (java.lang.Float) r6
            float r6 = r6.floatValue()
            r4.putFloat(r5, r6)
            int r5 = r3.f1878b
            if (r5 != r0) goto L_0x02ce
            com.baidu.ar.slam.SlamStateMachine r5 = com.baidu.p020ar.slam.SlamStateMachine.m2584a()
            com.baidu.ar.slam.SlamStateMachine$EVENT r6 = com.baidu.p020ar.slam.SlamStateMachine.EVENT.SLAM_GUESTURE_INTERACTION
            r5.mo10594a((com.baidu.p020ar.slam.SlamStateMachine.EVENT) r6, (android.os.Bundle) r4)
            goto L_0x02ce
        L_0x00a6:
            com.baidu.p020ar.base.C0618d.m1302a((java.util.HashMap<java.lang.String, java.lang.Object>) r6)
            r3.m2103c(r6)
            r3.m2104d(r6)
            r3.m2105e(r6)
            r3.m2106f(r6)
            com.baidu.ar.msghandler.ComponentMsgHandler r4 = r3.f1880d
            if (r4 == 0) goto L_0x00be
            com.baidu.ar.msghandler.ComponentMsgHandler r4 = r3.f1880d
            r4.parseComponentData(r6)
        L_0x00be:
            java.util.List<com.baidu.ar.msghandler.d> r4 = r3.f1883g
            java.util.Iterator r4 = r4.iterator()
        L_0x00c4:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x02ce
            java.lang.Object r5 = r4.next()
            com.baidu.ar.msghandler.d r5 = (com.baidu.p020ar.msghandler.C0811d) r5
            r5.parseComponentData(r6)
            goto L_0x00c4
        L_0x00d4:
            com.baidu.p020ar.base.C0618d.m1302a((java.util.HashMap<java.lang.String, java.lang.Object>) r6)
            r3.m2102b(r6)
            goto L_0x02ce
        L_0x00dc:
            r3.m2101a((java.util.HashMap<java.lang.String, java.lang.Object>) r6)
            goto L_0x02ce
        L_0x00e1:
            java.lang.String r4 = "app_type"
            java.lang.Object r4 = r6.get(r4)
            boolean r4 = r4 instanceof java.lang.String
            if (r4 == 0) goto L_0x02ce
            java.lang.String r4 = "app_type"
            java.lang.Object r4 = r6.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "None"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x0104
            com.baidu.ar.a r4 = com.baidu.p020ar.C0482a.m796a()
            r4.mo8916d((boolean) r1)
            goto L_0x02ce
        L_0x0104:
            java.lang.String r5 = "Slam"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x02ce
            com.baidu.ar.a r4 = com.baidu.p020ar.C0482a.m796a()
            r4.mo8916d((boolean) r2)
            goto L_0x02ce
        L_0x0115:
            java.lang.String r4 = "is_mirrored"
            java.lang.Object r4 = r6.get(r4)
            boolean r4 = r4 instanceof java.lang.Integer
            if (r4 == 0) goto L_0x02ce
            java.lang.String r4 = "is_mirrored"
            java.lang.Object r4 = r6.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            com.baidu.ar.a r5 = com.baidu.p020ar.C0482a.m796a()
            if (r4 != r1) goto L_0x0132
            goto L_0x0133
        L_0x0132:
            r1 = 0
        L_0x0133:
            r5.mo8917e((boolean) r1)
            goto L_0x02ce
        L_0x0138:
            if (r6 == 0) goto L_0x0151
            java.lang.String r4 = "with_interaction"
            boolean r4 = r6.containsKey(r4)
            if (r4 == 0) goto L_0x0151
            java.lang.String r4 = "with_interaction"
            java.lang.Object r4 = r6.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 == 0) goto L_0x0151
            r2 = 1
        L_0x0151:
            com.baidu.ar.a r4 = com.baidu.p020ar.C0482a.m796a()
            r4.mo8908a((boolean) r2)
            goto L_0x02ce
        L_0x015a:
            int r4 = r3.f1878b
            if (r4 != r0) goto L_0x0166
            com.baidu.ar.slam.SlamStateMachine r4 = com.baidu.p020ar.slam.SlamStateMachine.m2584a()
            com.baidu.ar.slam.SlamStateMachine$EVENT r5 = com.baidu.p020ar.slam.SlamStateMachine.EVENT.SLAM_IMU_CLOSE
            goto L_0x0213
        L_0x0166:
            int r4 = r3.f1878b
            if (r4 != r5) goto L_0x0172
            com.baidu.ar.imu.ImuStateMachine r4 = com.baidu.p020ar.imu.ImuStateMachine.m1994a()
            com.baidu.ar.imu.ImuStateMachine$EVENT r5 = com.baidu.p020ar.imu.ImuStateMachine.EVENT.IMU_CLOSE
            goto L_0x0222
        L_0x0172:
            com.baidu.ar.track.TrackStateMachine r4 = com.baidu.p020ar.track.TrackStateMachine.getInstance()
            com.baidu.ar.track.TrackStateMachine$EVENT r5 = com.baidu.p020ar.track.TrackStateMachine.EVENT.TRACK_IMU_CLOSE
            goto L_0x022d
        L_0x017a:
            if (r6 == 0) goto L_0x02ce
            java.lang.String r4 = "type"
            boolean r4 = r6.containsKey(r4)
            if (r4 == 0) goto L_0x02ce
            java.lang.String r4 = "type"
            java.lang.Object r4 = r6.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.String r1 = "init_pos"
            java.lang.Object r1 = r6.get(r1)
            boolean r1 = r1 instanceof java.lang.Integer
            if (r1 == 0) goto L_0x01a6
            java.lang.String r1 = "init_pos"
            java.lang.Object r6 = r6.get(r1)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r2 = r6.intValue()
        L_0x01a6:
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            java.lang.String r1 = "type"
            r6.putInt(r1, r4)
            java.lang.String r1 = "init_pos"
            r6.putInt(r1, r2)
            int r1 = r3.f1878b
            if (r1 != r0) goto L_0x01c4
            com.baidu.ar.slam.SlamStateMachine r4 = com.baidu.p020ar.slam.SlamStateMachine.m2584a()
            com.baidu.ar.slam.SlamStateMachine$EVENT r5 = com.baidu.p020ar.slam.SlamStateMachine.EVENT.SLAM_IMU_OPEN
            r4.mo10594a((com.baidu.p020ar.slam.SlamStateMachine.EVENT) r5, (android.os.Bundle) r6)
            goto L_0x02ce
        L_0x01c4:
            int r0 = r3.f1878b
            if (r0 != r5) goto L_0x01da
            com.baidu.ar.imu.ImuStateMachine r5 = com.baidu.p020ar.imu.ImuStateMachine.m1994a()
            com.baidu.ar.imu.ImuStateMachine$EVENT r0 = com.baidu.p020ar.imu.ImuStateMachine.EVENT.IMU_OPEN
            r5.mo10120a((com.baidu.p020ar.imu.ImuStateMachine.EVENT) r0, (android.os.Bundle) r6)
            com.baidu.ar.arplay.core.ARPEngine r5 = com.baidu.p020ar.arplay.core.ARPEngine.getInstance()
            r5.setImuType(r4)
            goto L_0x02ce
        L_0x01da:
            com.baidu.ar.arplay.core.ARPEngine r5 = com.baidu.p020ar.arplay.core.ARPEngine.getInstance()
            r5.setImuType(r4)
            com.baidu.ar.track.TrackStateMachine r4 = com.baidu.p020ar.track.TrackStateMachine.getInstance()
            com.baidu.ar.track.TrackStateMachine$EVENT r5 = com.baidu.p020ar.track.TrackStateMachine.EVENT.TRACK_IMU_OPEN
            r4.processEvent(r5, r6)
            goto L_0x02ce
        L_0x01ec:
            int r4 = r3.f1878b
            if (r4 != r0) goto L_0x01f7
            com.baidu.ar.slam.SlamStateMachine r4 = com.baidu.p020ar.slam.SlamStateMachine.m2584a()
            com.baidu.ar.slam.SlamStateMachine$EVENT r5 = com.baidu.p020ar.slam.SlamStateMachine.EVENT.MODEL_DISAPPEAR
            goto L_0x0213
        L_0x01f7:
            int r4 = r3.f1878b
            if (r4 != r5) goto L_0x0202
            com.baidu.ar.imu.ImuStateMachine r4 = com.baidu.p020ar.imu.ImuStateMachine.m1994a()
            com.baidu.ar.imu.ImuStateMachine$EVENT r5 = com.baidu.p020ar.imu.ImuStateMachine.EVENT.MODEL_DISAPPEAR
            goto L_0x0222
        L_0x0202:
            com.baidu.ar.track.TrackStateMachine r4 = com.baidu.p020ar.track.TrackStateMachine.getInstance()
            com.baidu.ar.track.TrackStateMachine$EVENT r5 = com.baidu.p020ar.track.TrackStateMachine.EVENT.MODEL_DISAPPEAR
            goto L_0x022d
        L_0x0209:
            int r4 = r3.f1878b
            if (r4 != r0) goto L_0x0218
            com.baidu.ar.slam.SlamStateMachine r4 = com.baidu.p020ar.slam.SlamStateMachine.m2584a()
            com.baidu.ar.slam.SlamStateMachine$EVENT r5 = com.baidu.p020ar.slam.SlamStateMachine.EVENT.MODEL_APPEAR
        L_0x0213:
            r4.mo10593a((com.baidu.p020ar.slam.SlamStateMachine.EVENT) r5)
            goto L_0x02ce
        L_0x0218:
            int r4 = r3.f1878b
            if (r4 != r5) goto L_0x0227
            com.baidu.ar.imu.ImuStateMachine r4 = com.baidu.p020ar.imu.ImuStateMachine.m1994a()
            com.baidu.ar.imu.ImuStateMachine$EVENT r5 = com.baidu.p020ar.imu.ImuStateMachine.EVENT.MODEL_APPEAR
        L_0x0222:
            r4.mo10119a((com.baidu.p020ar.imu.ImuStateMachine.EVENT) r5)
            goto L_0x02ce
        L_0x0227:
            com.baidu.ar.track.TrackStateMachine r4 = com.baidu.p020ar.track.TrackStateMachine.getInstance()
            com.baidu.ar.track.TrackStateMachine$EVENT r5 = com.baidu.p020ar.track.TrackStateMachine.EVENT.MODEL_APPEAR
        L_0x022d:
            r4.processEvent(r5)
            goto L_0x02ce
        L_0x0232:
            com.baidu.ar.track.TrackStateMachine r4 = com.baidu.p020ar.track.TrackStateMachine.getInstance()
            r4.setIsEngineSetTrackLostHandler(r1)
            goto L_0x02ce
        L_0x023b:
            com.baidu.ar.track.TrackStateMachine r4 = com.baidu.p020ar.track.TrackStateMachine.getInstance()
            r4.setIsEngineSetTrackOnHandler(r1)
            goto L_0x02ce
        L_0x0244:
            boolean r4 = com.baidu.p020ar.statistic.StatisticConstants.getIsFirst3DModelLoad()
            if (r4 == 0) goto L_0x0257
            com.baidu.ar.statistic.StatisticHelper r4 = com.baidu.p020ar.statistic.StatisticHelper.getInstance()
            java.lang.String r1 = "first_loading_3d_model_success"
            r4.statisticInfo(r1)
            com.baidu.p020ar.statistic.StatisticConstants.setIsFirst3DModelLoad(r2)
            goto L_0x0260
        L_0x0257:
            com.baidu.ar.statistic.StatisticHelper r4 = com.baidu.p020ar.statistic.StatisticHelper.getInstance()
            java.lang.String r1 = "loading_3d_model_success"
            r4.statisticInfo(r1)
        L_0x0260:
            int r4 = r3.f1878b
            if (r4 != r0) goto L_0x026e
            com.baidu.ar.slam.SlamStateMachine r4 = com.baidu.p020ar.slam.SlamStateMachine.m2584a()
            com.baidu.ar.slam.SlamStateMachine$EVENT r5 = com.baidu.p020ar.slam.SlamStateMachine.EVENT.LOAD_MODEL_FINISH
            r4.mo10593a((com.baidu.p020ar.slam.SlamStateMachine.EVENT) r5)
            goto L_0x02c2
        L_0x026e:
            int r4 = r3.f1878b
            if (r4 != r5) goto L_0x027c
            com.baidu.ar.imu.ImuStateMachine r4 = com.baidu.p020ar.imu.ImuStateMachine.m1994a()
            com.baidu.ar.imu.ImuStateMachine$EVENT r5 = com.baidu.p020ar.imu.ImuStateMachine.EVENT.LOAD_MODEL_FINISH
            r4.mo10119a((com.baidu.p020ar.imu.ImuStateMachine.EVENT) r5)
            goto L_0x02c2
        L_0x027c:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            if (r6 == 0) goto L_0x02ae
            java.lang.String r5 = "show_immediately"
            boolean r5 = r6.containsKey(r5)
            if (r5 == 0) goto L_0x0298
            java.lang.String r5 = "show_immediately"
            java.lang.Object r5 = r6.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            goto L_0x0299
        L_0x0298:
            r5 = 0
        L_0x0299:
            java.lang.String r0 = "imu_relay_ctrl_when_track_lost"
            boolean r0 = r6.containsKey(r0)
            if (r0 == 0) goto L_0x02af
            java.lang.String r0 = "imu_relay_ctrl_when_track_lost"
            java.lang.Object r6 = r6.get(r0)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r2 = r6.intValue()
            goto L_0x02af
        L_0x02ae:
            r5 = 0
        L_0x02af:
            java.lang.String r6 = "show_immediately"
            r4.putInt(r6, r5)
            java.lang.String r5 = "imu_relay_ctrl_when_track_lost"
            r4.putInt(r5, r2)
            com.baidu.ar.track.TrackStateMachine r5 = com.baidu.p020ar.track.TrackStateMachine.getInstance()
            com.baidu.ar.track.TrackStateMachine$EVENT r6 = com.baidu.p020ar.track.TrackStateMachine.EVENT.LOAD_MODEL_FINISH
            r5.processEvent(r6, r4)
        L_0x02c2:
            com.baidu.ar.arplay.core.ARPEngine r4 = com.baidu.p020ar.arplay.core.ARPEngine.getInstance()
            com.baidu.ar.msghandler.a$1 r5 = new com.baidu.ar.msghandler.a$1
            r5.<init>()
            r4.executeOnGLThread(r5)
        L_0x02ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.p020ar.msghandler.C0802a.handleMessage(int, int, java.util.HashMap):void");
    }
}
