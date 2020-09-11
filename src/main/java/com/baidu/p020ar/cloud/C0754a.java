package com.baidu.p020ar.cloud;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.p020ar.base.C0611b;
import com.baidu.p020ar.base.C0618d;
import com.baidu.p020ar.base.MsgField;
import com.baidu.p020ar.bean.ARConfig;
import com.baidu.p020ar.cloud.CloudRecognitionManager;
import com.baidu.p020ar.p042d.C0765a;
import com.baidu.p020ar.util.Debug;
import com.baidu.p020ar.util.UiThreadUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.cloud.a */
public class C0754a extends C0611b implements CloudRecognitionManager.C0753a {
    /* access modifiers changed from: private */

    /* renamed from: r */
    public CloudRecognitionManager f1654r;

    /* renamed from: s */
    private int f1655s = -1;

    /* renamed from: t */
    private ExecutorService f1656t = Executors.newSingleThreadExecutor();

    public C0754a(Context context) {
        super(context);
        Debug.resetBaseTime();
        this.f1654r = new CloudRecognitionManager();
    }

    /* renamed from: a */
    public void mo10091a(int i) {
        this.f1655s = i;
    }

    /* renamed from: a */
    public void mo10090a(int i, final String str, final String str2, final String str3) {
        Runnable r1;
        if (i == 0) {
            this.f1655s = 0;
            if (!TextUtils.isEmpty(str2)) {
                r1 = new Runnable() {
                    public void run() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("ar_key", str2);
                            jSONObject.put("ar_type", str3);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        C0618d.m1299a((int) MsgField.IMSG_CLOUDAR_RECG_RESULT, (Object) jSONObject);
                    }
                };
            } else {
                return;
            }
        } else if (i == 1054 || i == 1057) {
            this.f1655s = -1;
            return;
        } else {
            this.f1655s = 2;
            r1 = new Runnable() {
                public void run() {
                    C0618d.m1300a((int) MsgField.IMSG_CLOUDAR_TOAST_ERROR, TextUtils.isEmpty(str) ? "出错啦" : str);
                }
            };
        }
        UiThreadUtil.runOnUiThread(r1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9522a(final byte[] bArr, final C0765a aVar) {
        if (this.f1655s == -1) {
            if (TextUtils.isEmpty(ARConfig.getARKey())) {
                C0618d.m1300a((int) MsgField.IMSG_CLORD_ID_START, " recg inited!");
            }
            this.f1655s = 2;
            this.f1656t.execute(new Runnable() {
                public void run() {
                    Debug.print("previewFrame start");
                    if (C0754a.this.f1654r != null) {
                        C0754a.this.f1654r.setYUVFile(bArr, aVar.f1679a, aVar.f1680b);
                    }
                }
            });
        }
    }

    /* renamed from: d */
    public void mo9533d() {
        super.mo9533d();
        if (this.f1654r != null) {
            this.f1654r.initCloudRecognition(this.f1006a, this);
        }
        this.f1655s = -1;
    }

    /* renamed from: e */
    public void mo9535e() {
        super.mo9535e();
        if (this.f1654r != null) {
            this.f1654r.release();
        }
        this.f1655s = 2;
    }

    /* renamed from: f */
    public void mo9536f() {
        super.mo9536f();
        if (this.f1654r != null) {
            this.f1654r.release();
        }
    }

    /* renamed from: i */
    public void mo9539i() {
        super.mo9539i();
        if (this.f1654r != null) {
            this.f1654r.release();
        }
    }
}
