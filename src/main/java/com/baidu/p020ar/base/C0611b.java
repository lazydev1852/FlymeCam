package com.baidu.p020ar.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.p020ar.ARController;
import com.baidu.p020ar.C0482a;
import com.baidu.p020ar.DuMixCallback;
import com.baidu.p020ar.arplay.core.ARPEngine;
import com.baidu.p020ar.arplay.core.C0577a;
import com.baidu.p020ar.arplay.core.message.ARPMessage;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.arplay.p032a.C0535c;
import com.baidu.p020ar.arplay.webview.GLWebViewManager;
import com.baidu.p020ar.bean.ARConfig;
import com.baidu.p020ar.bean.ARResource;
import com.baidu.p020ar.bean.C0624b;
import com.baidu.p020ar.bean.C0625c;
import com.baidu.p020ar.bean.TipBean;
import com.baidu.p020ar.bean.TrackRes;
import com.baidu.p020ar.imu.C0769b;
import com.baidu.p020ar.logo.IttRecognitionManager;
import com.baidu.p020ar.msghandler.C0802a;
import com.baidu.p020ar.msghandler.C0808c;
import com.baidu.p020ar.msghandler.C0811d;
import com.baidu.p020ar.msghandler.C0813f;
import com.baidu.p020ar.msghandler.DownloadMsgHandler;
import com.baidu.p020ar.p021a.C0486a;
import com.baidu.p020ar.p041c.C0752b;
import com.baidu.p020ar.p042d.C0765a;
import com.baidu.p020ar.paddle.PaddleManager;
import com.baidu.p020ar.rotate.OrientationManager;
import com.baidu.p020ar.statistic.StatisticConstants;
import com.baidu.p020ar.statistic.StatisticHelper;
import com.baidu.p020ar.track.TrackStateMachine;
import com.baidu.p020ar.util.ARFileUtils;
import com.baidu.p020ar.util.ARLog;
import com.baidu.p020ar.util.Constants;
import com.baidu.p020ar.util.ImageUtils;
import com.baidu.p020ar.util.MsgConstants;
import com.baidu.p020ar.util.UiThreadUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.base.b */
public abstract class C0611b {

    /* renamed from: t */
    private static volatile boolean f1004t = false;

    /* renamed from: A */
    private C0813f f1005A;

    /* renamed from: a */
    protected Context f1006a;

    /* renamed from: b */
    protected boolean f1007b = true;

    /* renamed from: c */
    protected ARResource f1008c;

    /* renamed from: d */
    protected DuMixCallback f1009d;

    /* renamed from: e */
    protected ARController f1010e;

    /* renamed from: f */
    protected C0765a f1011f;

    /* renamed from: g */
    protected TrackRes f1012g;

    /* renamed from: h */
    protected C0802a f1013h;
    /* access modifiers changed from: protected */

    /* renamed from: i */
    public boolean f1014i;
    /* access modifiers changed from: protected */

    /* renamed from: j */
    public C0769b f1015j;

    /* renamed from: k */
    protected int f1016k;

    /* renamed from: l */
    protected int f1017l;

    /* renamed from: m */
    protected boolean f1018m = false;

    /* renamed from: n */
    protected boolean f1019n = false;

    /* renamed from: o */
    protected C0535c f1020o;

    /* renamed from: p */
    protected C0625c f1021p;
    /* access modifiers changed from: protected */

    /* renamed from: q */
    public long f1022q;

    /* renamed from: r */
    private Timer f1023r;

    /* renamed from: s */
    private TimerTask f1024s;

    /* renamed from: u */
    private boolean f1025u = false;

    /* renamed from: v */
    private String f1026v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f1027w = false;

    /* renamed from: x */
    private boolean f1028x = false;

    /* renamed from: y */
    private float f1029y = 1.0f;

    /* renamed from: z */
    private DownloadMsgHandler f1030z;

    public C0611b(Context context) {
        this.f1006a = context.getApplicationContext();
        this.f1013h = new C0802a(context);
        this.f1015j = new C0769b(this.f1006a);
        this.f1020o = new C0535c(this.f1006a);
    }

    /* renamed from: a */
    private void m1256a(C0765a aVar) {
        ARLog.m2695d("onFirstPreviewFrameBack !!!!");
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                C0611b.this.mo10669n();
            }
        });
    }

    /* renamed from: e */
    private void m1260e(byte[] bArr, C0765a aVar) {
        if (f1004t) {
            f1004t = false;
            File file = new File("/sdcard/DCIM/camera/" + ("YUVImage-" + System.currentTimeMillis() + ".jpg"));
            ImageUtils.saveYUVImage2Jpg(file.getPath(), bArr, aVar.f1679a, aVar.f1680b);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(file));
            this.f1006a.sendBroadcast(intent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void mo10345m() {
        this.f1022q = System.currentTimeMillis();
        this.f1025u = true;
        C0482a.m796a().mo8915d();
        ARPEngine.getInstance().createSceneAppWithViewPortSize(this.f1026v, (HashMap<String, Object>) null, this.f1017l, this.f1016k, this.f1029y);
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.START_LOADING_3D_MODEL);
        mo9540j();
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void mo10669n() {
        boolean b = mo9527b();
        ARLog.m2696e("onFirstPreviewFrameBack !!!!");
        if (b) {
            C0802a.m2100a(OrientationManager.getGlobalOrientation().getDegree());
        }
        mo9524b(this.f1008c.getCaseConfigJsonInfo());
    }

    /* renamed from: o */
    private void m1263o() {
        if (this.f1023r != null) {
            this.f1023r.cancel();
            this.f1023r.purge();
            this.f1023r = null;
        }
        if (this.f1024s != null) {
            this.f1024s.cancel();
            this.f1024s = null;
        }
    }

    /* renamed from: p */
    private void m1264p() {
        if (this.f1015j != null) {
            this.f1015j.mo10129b();
            this.f1015j.mo10130c();
        }
    }

    /* renamed from: q */
    private void m1265q() {
        StringBuilder sb;
        String aRCaseFullPath;
        String str;
        String str2;
        if (this.f1008c.getType() == 0 || this.f1008c.getType() == 8) {
            HashMap hashMap = new HashMap();
            String str3 = null;
            if (this.f1012g.getPaddle() != null && this.f1012g.getPaddle().size() > 0) {
                C0624b bVar = this.f1012g.getPaddle().get(0);
                if (!TextUtils.isEmpty(ARConfig.getARPath())) {
                    sb = new StringBuilder();
                    sb.append(ARConfig.getARPath());
                    sb.append(File.separator);
                    aRCaseFullPath = ARFileUtils.AR_UNZIP_ROOT_DIR;
                } else {
                    sb = new StringBuilder();
                    aRCaseFullPath = ARFileUtils.getARCaseFullPath(this.f1008c.getKey());
                }
                sb.append(aRCaseFullPath);
                sb.append(File.separator);
                sb.append(bVar.mo9674a());
                String sb2 = sb.toString();
                hashMap.put("paddleNum", Integer.valueOf(this.f1012g.getPaddle().size()));
                if (!TextUtils.isEmpty(bVar.mo9678b())) {
                    str = "type0";
                    str2 = bVar.mo9678b();
                } else {
                    str = "type0";
                    str2 = "1";
                }
                hashMap.put(str, str2);
                hashMap.put("width0", Integer.valueOf(bVar.mo9682c()));
                hashMap.put("height0", Integer.valueOf(bVar.mo9699m()));
                hashMap.put("fgThres0", Float.valueOf(bVar.mo9685d()));
                hashMap.put("bgThres0", Float.valueOf(bVar.mo9687e()));
                hashMap.put("nodeName0", bVar.mo9689f());
                hashMap.put("rMean0", Float.valueOf(bVar.mo9691g()));
                hashMap.put("gMean0", Float.valueOf(bVar.mo9693h()));
                hashMap.put("bMean0", Float.valueOf(bVar.mo9695i()));
                hashMap.put("rScale0", Float.valueOf(bVar.mo9696j()));
                hashMap.put("gScale0", Float.valueOf(bVar.mo9697k()));
                hashMap.put("bScale0", Float.valueOf(bVar.mo9698l()));
                if (this.f1012g.getPaddle().size() > 1) {
                    for (int i = 1; i < this.f1012g.getPaddle().size(); i++) {
                        C0624b bVar2 = this.f1012g.getPaddle().get(i);
                        hashMap.put("path" + i, ARFileUtils.getARCaseFullPath(this.f1008c.getKey()) + File.separator + bVar2.mo9674a());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("type");
                        sb3.append(i);
                        hashMap.put(sb3.toString(), bVar2.mo9678b());
                        hashMap.put("width" + i, Integer.valueOf(bVar2.mo9682c()));
                        hashMap.put("height" + i, Integer.valueOf(bVar2.mo9699m()));
                        hashMap.put("fgThres" + i, Float.valueOf(bVar2.mo9685d()));
                        hashMap.put("bgThres" + i, Float.valueOf(bVar2.mo9687e()));
                        hashMap.put("nodeName" + i, bVar2.mo9689f());
                        hashMap.put("rMean" + i, Float.valueOf(bVar2.mo9691g()));
                        hashMap.put("gMean" + i, Float.valueOf(bVar2.mo9693h()));
                        hashMap.put("bMean" + i, Float.valueOf(bVar2.mo9695i()));
                        hashMap.put("rScale" + i, Float.valueOf(bVar2.mo9696j()));
                        hashMap.put("gScale" + i, Float.valueOf(bVar2.mo9697k()));
                        hashMap.put("bScale" + i, Float.valueOf(bVar2.mo9698l()));
                    }
                }
                str3 = sb2;
            }
            hashMap.put("path0", str3);
            hashMap.put("secretKey", "bai@!duA84$[|secu&^rity*");
            if (this.f1009d != null) {
                this.f1009d.onStateChange(MsgField.MSG_PADDLE_INIT, hashMap);
            }
        }
    }

    /* renamed from: a */
    public void mo9513a() {
        if (this.f1020o != null) {
            this.f1020o.mo9052b();
        }
    }

    /* renamed from: a */
    public void mo9514a(float f) {
        this.f1029y = f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9515a(Bundle bundle) {
        mo9523b(bundle);
    }

    /* renamed from: a */
    public void mo9516a(ARController aRController) {
        this.f1010e = aRController;
    }

    /* renamed from: a */
    public void mo9517a(DuMixCallback duMixCallback) {
        this.f1009d = duMixCallback;
        this.f1013h.mo10275a(duMixCallback);
    }

    /* renamed from: a */
    public void mo9518a(ARResource aRResource) {
        this.f1008c = aRResource;
    }

    /* renamed from: a */
    public void mo9519a(String str) {
        this.f1019n = true;
        this.f1026v = str;
        if (!this.f1027w) {
            if (this.f1018m) {
                mo10345m();
            }
            m1265q();
        }
    }

    /* renamed from: a */
    public void mo9520a(HashMap<String, Object> hashMap) {
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* renamed from: a */
    public void mo9521a(boolean z) {
        this.f1010e.setUserInteractionEnabled(z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9522a(byte[] bArr, C0765a aVar) {
        ARLog.m2695d("previewFrame mIsResumed = " + this.f1007b);
        if (this.f1007b && bArr != null) {
            if (this.f1011f == null) {
                try {
                    this.f1011f = aVar;
                    this.f1016k = this.f1011f.f1679a;
                    this.f1017l = this.f1011f.f1680b;
                    ARLog.m2697i("bdar: width = " + this.f1011f.f1679a + ", height = " + this.f1011f.f1680b);
                    m1256a(this.f1011f);
                    C0486a.m833a(this.f1011f.f1679a, this.f1011f.f1680b, bArr.length);
                } catch (Exception e) {
                    ARLog.m2696e("previewFrame error!!!");
                    e.printStackTrace();
                    return;
                }
            }
            if (Constants.DEBUG_PREVIEW_FRAME) {
                m1260e(bArr, aVar);
            }
            mo9526b(bArr, aVar);
            if (this.f1018m && this.f1019n && !this.f1025u) {
                UiThreadUtil.runOnUiThread(new Runnable() {
                    public void run() {
                        if (!C0611b.this.f1027w) {
                            C0611b.this.mo10345m();
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9523b(Bundle bundle) {
        int i;
        String str;
        ARLog.m2699w(StatisticConstants.TRACKED);
        if (bundle == null) {
            ARLog.m2696e("track result is null!");
        } else if (TrackStateMachine.getInstance().getTrackState() == TrackStateMachine.STATE.TRACKED) {
            float f = bundle.getFloat("distance");
            try {
                TipBean tipBean = this.f1012g.getTipBean();
                if (!Float.isNaN(tipBean.getFarThreshold())) {
                    if (!Float.isNaN(tipBean.getNearThreshold())) {
                        if (f > tipBean.getFarThreshold()) {
                            i = MsgField.IMSG_TRACK_DISTANCE_TOO_FAR;
                            str = MsgField.SMSG_TRACK_DISTANCE_TOO_FAR;
                        } else if (f < tipBean.getNearThreshold()) {
                            i = MsgField.IMSG_TRACK_DISTANCE_TOO_NEAR;
                            str = MsgField.SMSG_TRACK_DISTANCE_TOO_NEAR;
                        } else {
                            i = MsgField.IMSG_TRACK_DISTANCE_NORMAL;
                            str = MsgField.SMSG_TRACK_DISTANCE_NORMAL;
                        }
                        C0618d.m1300a(i, str);
                        return;
                    }
                }
                ARLog.m2695d("Far or Near Threshold is NaN");
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void mo9524b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = (String) new JSONObject(str).opt("unzip_path");
                GLWebViewManager.getInstance().setResDir(str2.concat(File.separator).concat(ARFileUtils.AR_UNZIP_ROOT_DIR));
                IttRecognitionManager.getInstance().parseRecognition((str2 + File.separator + ARFileUtils.AR_UNZIP_ROOT_DIR).concat(File.separator).concat("res/logo.json"));
                if (!TextUtils.isEmpty(str2) && this.f1013h != null) {
                    this.f1013h.mo10278a((C0811d) new C0808c(str2.concat(File.separator).concat(ARFileUtils.AR_UNZIP_ROOT_DIR), this.f1010e.getBlender()));
                }
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: b */
    public void mo9525b(boolean z) {
        this.f1018m = z;
        if (z) {
            mo9528c();
            mo9537g();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9526b(byte[] bArr, C0765a aVar) {
        long currentTimeMillis = Constants.DEBUG_PREVIEW_FRAME ? System.currentTimeMillis() : 0;
        if (this.f1018m) {
            mo9532c(bArr, aVar);
            if (PaddleManager.getInstance().isValid()) {
                PaddleManager.getInstance().runPaddle(bArr, aVar.f1679a, aVar.f1680b);
            }
            if (Constants.DEBUG_PREVIEW_FRAME) {
                ARLog.m2696e("bdar: processPreviewFrame time = " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    /* renamed from: b */
    public boolean mo9527b() {
        return this.f1010e != null && this.f1010e.isEnginSoLoaded();
    }

    /* renamed from: c */
    public void mo9528c() {
        if (this.f1013h != null) {
            this.f1013h.mo9083a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9529c(Bundle bundle) {
        int i;
        if (bundle != null) {
            switch (((Integer) bundle.get(MsgConstants.MSG_EXTRA_VIEW_VISIBLE_ID)).intValue()) {
                case 0:
                    i = 100;
                    break;
                case 1:
                    i = 101;
                    break;
                case 2:
                    i = 110;
                    break;
                case 3:
                    i = 111;
                    break;
                case 4:
                    i = 102;
                    break;
                case 5:
                    i = 103;
                    break;
                default:
                    return;
            }
            C0618d.m1298a(i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9530c(String str) {
    }

    /* renamed from: c */
    public void mo9531c(boolean z) {
        this.f1028x = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9532c(byte[] bArr, C0765a aVar) {
    }

    /* renamed from: d */
    public void mo9533d() {
        this.f1007b = true;
        C0752b.m1958a(this.f1006a).mo10085a(true);
        try {
            this.f1020o.mo9051a();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public void mo9534d(byte[] bArr, C0765a aVar) {
        mo9522a(bArr, aVar);
    }

    /* renamed from: e */
    public void mo9535e() {
        this.f1007b = false;
        this.f1011f = null;
        C0752b.m1958a(this.f1006a).mo10085a(false);
        m1263o();
        if (this.f1020o != null) {
            this.f1020o.mo9053c();
        }
    }

    /* renamed from: f */
    public void mo9536f() {
        if (this.f1020o != null) {
            this.f1020o.mo9053c();
            this.f1020o = null;
        }
        if (mo9527b()) {
            C0577a arGLEngineCtl = ARPEngine.getInstance().getArGLEngineCtl();
            if (arGLEngineCtl != null) {
                arGLEngineCtl.mo9240f();
            }
            ARPEngine.getInstance().destroySceneApp();
            ARLog.m2696e("bdar:destroyCase");
        }
        if (this.f1020o != null) {
            this.f1020o.mo9053c();
            this.f1020o = null;
        }
        this.f1027w = true;
        PaddleManager.getInstance().release();
        if (this.f1013h != null) {
            this.f1013h.mo9084b();
            this.f1013h = null;
        }
        if (this.f1009d != null) {
            this.f1009d = null;
        }
        if (this.f1030z != null) {
            this.f1030z.release();
            this.f1030z = null;
        }
        if (this.f1005A != null) {
            this.f1005A.mo10289a();
            this.f1005A = null;
        }
        m1263o();
        C0752b.m1958a(this.f1006a).mo10083a();
        C0486a.m832a();
        m1264p();
        ARPMessage.getInstance().release();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo9537g() {
        if (Constants.AR_IS_NEED_PRINT_FRAME_LOG) {
            this.f1023r = new Timer();
            this.f1024s = new TimerTask() {
                public void run() {
                    ARLog.m2695d("the engine fps is : " + ARPEngine.getInstance().getFps());
                }
            };
            this.f1023r.schedule(this.f1024s, 0, (long) Constants.PRINT_FPS_INTERVAL);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo9538h() {
        C0577a arGLEngineCtl = ARPEngine.getInstance().getArGLEngineCtl();
        if (arGLEngineCtl != null) {
            arGLEngineCtl.mo9240f();
        }
        ARPMessage.getInstance().removeMessageHandeler(this.f1013h);
        if (this.f1013h != null) {
            this.f1013h.mo9084b();
            this.f1013h = null;
        }
        ARPEngine.getInstance().onPauseByUser();
        ARPEngine.getInstance().clearScreen();
        if (ARPEngine.getInstance().getArGLEngineCtl() != null) {
            ARPEngine.getInstance().getArGLEngineCtl().mo9232a(1);
        }
        ARPEngine.getInstance().destroySceneApp();
    }

    /* renamed from: i */
    public void mo9539i() {
        this.f1027w = true;
        m1264p();
        m1263o();
        C0752b.m1958a(this.f1006a).mo10083a();
        mo9536f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo9540j() {
        ARPEngine.getInstance().executeOnGLThread(new Runnable() {
            public void run() {
                UiThreadUtil.runOnUiThread(new Runnable() {
                    public void run() {
                        C0618d.m1299a(2201, (Object) C0611b.this.f1008c);
                    }
                });
            }
        });
    }

    /* renamed from: k */
    public void mo9541k() {
        try {
            this.f1030z = new DownloadMsgHandler(this.f1008c.getKey(), this.f1006a);
            this.f1013h.mo10277a(this.f1030z);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            this.f1005A = new C0813f(this.f1008c.getKey(), this.f1006a);
            this.f1013h.mo10279a(this.f1005A);
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: l */
    public boolean mo9542l() {
        return true;
    }
}
