package com.baidu.p020ar.recg;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.p020ar.base.C0611b;
import com.baidu.p020ar.base.C0618d;
import com.baidu.p020ar.base.MsgField;
import com.baidu.p020ar.p042d.C0765a;
import com.baidu.p020ar.util.NetworkUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.recg.b */
public class C0822b extends C0611b {
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ImageRecognitionManager f1970r = new ImageRecognitionManager();

    /* renamed from: s */
    private ExecutorService f1971s = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f1972t = -1;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public String f1973u;

    public C0822b(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2185a(int i) {
        this.f1972t = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9522a(final byte[] bArr, final C0765a aVar) {
        if (this.f1972t == 0) {
            C0618d.m1300a((int) MsgField.IMSG_ON_DEVICE_IR_START, " recg inited!");
            m2185a(1);
            if (aVar != null) {
                this.f1971s.execute(new Runnable() {
                    public void run() {
                        if (C0822b.this.f1970r != null) {
                            C0822b.this.f1970r.recognizeFrame(aVar.f1679a, aVar.f1680b, bArr);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: d */
    public void mo9533d() {
        super.mo9533d();
        mo10345m();
        if (this.f1972t == 4) {
            m2185a(0);
        }
    }

    /* renamed from: e */
    public void mo9535e() {
        super.mo9535e();
        if (this.f1972t != 3) {
            m2185a(4);
        }
    }

    /* renamed from: f */
    public void mo9536f() {
        if (this.f1970r != null) {
            this.f1970r.release();
        }
        super.mo9536f();
    }

    /* renamed from: i */
    public void mo9539i() {
        super.mo9539i();
        if (this.f1970r != null) {
            this.f1970r.release();
        }
    }

    /* renamed from: m */
    public void mo10345m() {
        if (!NetworkUtil.isNetworkConnected(this.f1006a)) {
            Log.e("bdar", "no network");
            C0618d.m1300a((int) MsgField.IMSG_NO_NETWORK, MsgField.SMSG_NO_NETWORK);
        } else if (TextUtils.isEmpty(this.f1973u)) {
            this.f1970r.initRecognition(this.f1006a, new ImageRecognitionCallback() {
                public void onFeatureDBInit(boolean z) {
                    if (!z) {
                        C0618d.m1300a(1401, "特征库初始化失败");
                        return;
                    }
                    C0618d.m1298a((int) MsgField.IMSG_ON_DEVICE_IR_TIMERR_START);
                    C0822b.this.m2185a(0);
                }

                public void onFeatureDownloadStart() {
                }

                public void onRecognizeResult(boolean z, String str, String str2) {
                    C0822b bVar;
                    int i;
                    if (C0822b.this.f1972t != 4) {
                        if (TextUtils.isEmpty(str)) {
                            bVar = C0822b.this;
                            i = 0;
                        } else {
                            bVar = C0822b.this;
                            i = 3;
                        }
                        bVar.m2185a(i);
                        if (z && !TextUtils.isEmpty(str)) {
                            String unused = C0822b.this.f1973u = str;
                            if (C0822b.this.f1970r != null) {
                                C0822b.this.f1970r.stopRecognition();
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("ar_key", str);
                                jSONObject.put("ar_type", str2);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            C0618d.m1299a((int) MsgField.MSG_ON_DEVICE_IR_RESULT, (Object) jSONObject);
                        }
                    }
                }

                public void onResourceDownload(boolean z) {
                    if (!z) {
                        C0618d.m1300a(1401, "特征库下载失败");
                        return;
                    }
                    if (C0822b.this.f1970r != null) {
                        C0822b.this.f1970r.startRecognition();
                    }
                    C0618d.m1298a((int) MsgField.IMSG_ON_DEVICE_IR_TIMERR_START);
                }

                public void onResourceRequest(boolean z, int i, String str) {
                    if (!z) {
                        C0618d.m1300a(1401, str);
                    }
                }

                public void onSoLoadDownloadStart() {
                }

                public void onSoLoadState(boolean z) {
                }
            });
        }
    }
}
