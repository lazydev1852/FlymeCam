package com.baidu.p020ar.imu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.p020ar.C0482a;
import com.baidu.p020ar.base.C0611b;
import com.baidu.p020ar.base.C0618d;
import com.baidu.p020ar.base.MsgField;
import com.baidu.p020ar.bean.C0625c;
import com.baidu.p020ar.bean.TrackRes;
import com.baidu.p020ar.imu.C0769b;
import com.baidu.p020ar.imu.ImuStateMachine;
import com.baidu.p020ar.msghandler.C0812e;
import com.baidu.p020ar.msghandler.ComponentMessageType;
import com.baidu.p020ar.parser.C0819a;
import com.baidu.p020ar.parser.ParserJson;
import com.baidu.p020ar.statistic.StatisticConstants;
import com.baidu.p020ar.statistic.StatisticHelper;
import com.baidu.p020ar.util.ARFileUtils;
import com.baidu.p020ar.util.ARLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.ar.imu.e */
public class C0774e extends C0611b {

    /* renamed from: r */
    private C0776a f1746r = null;

    /* renamed from: s */
    private String f1747s;

    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.baidu.ar.imu.e$a */
    public static class C0776a extends Handler {

        /* renamed from: a */
        private WeakReference<C0774e> f1749a;

        public C0776a(C0774e eVar) {
            super(Looper.getMainLooper());
            this.f1749a = new WeakReference<>(eVar);
        }

        /* renamed from: a */
        public void mo10139a() {
            if (this.f1749a != null) {
                this.f1749a.clear();
            }
        }

        public void handleMessage(Message message) {
            C0774e eVar = (C0774e) this.f1749a.get();
            if (eVar != null) {
                int i = message.what;
                if (i == 801) {
                    C0618d.m1300a((int) MsgField.IMSG_MODEL_LOADED, MsgField.SMSG_MODEL_LOADED);
                    if (!eVar.f1014i) {
                        StatisticHelper.getInstance().statisticInfo(StatisticConstants.START_AR_ANIM);
                        boolean unused = eVar.f1014i = true;
                    }
                } else if (i == 804) {
                    C0618d.m1300a((int) MsgField.IMSG_MODE_SHOWING, MsgField.SMSG_MODE_SHOWING);
                } else if (i != 8010) {
                    if (i == 30000) {
                        eVar.mo9529c(message.getData());
                    } else if (i == 999999) {
                        eVar.mo9530c(message.getData().getString(ComponentMessageType.MSG_EXTRA_DEBUG_SCREENSHOT_FILENAME));
                    }
                } else if (message.getData().getInt("type") == 1) {
                    eVar.mo9513a();
                }
            }
        }
    }

    public C0774e(Context context) {
        super(context);
        ImuStateMachine.m1994a().mo10122b();
        ImuStateMachine.m1994a().mo10121a(this.f1015j);
        this.f1015j.mo10126a((C0769b.C0771b) new C0769b.C0771b() {
            /* renamed from: a */
            public void mo10134a(float[] fArr) {
                Bundle bundle = new Bundle();
                bundle.putFloatArray("RMatrix", fArr);
                bundle.putInt("init_pos", C0774e.this.f1015j.mo10124a());
                ImuStateMachine.m1994a().mo10117a(bundle);
            }
        });
        if (this.f1746r == null) {
            this.f1746r = new C0776a(this);
        }
        ImuStateMachine.m1994a().mo10118a((Handler) this.f1746r);
    }

    /* renamed from: m */
    private void m2033m() {
        if (this.f1746r != null) {
            this.f1746r.removeCallbacksAndMessages((Object) null);
            this.f1746r.mo10139a();
            this.f1746r = null;
        }
        ImuStateMachine.m1994a().mo10118a((Handler) null);
    }

    /* renamed from: b */
    public void mo9524b(String str) {
        super.mo9524b(str);
        if (!TextUtils.isEmpty(this.f1747s) && TextUtils.equals(this.f1747s, str)) {
            ImuStateMachine.m1994a().mo10119a(ImuStateMachine.EVENT.DOWNLOAD_RES_FINISH);
        } else if (TextUtils.isEmpty(str)) {
            C0618d.m1298a((int) MsgField.MSG_ON_PARSE_RESOURCE_UNZIP_ERROR);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str2 = (String) jSONObject.opt("unzip_path");
                String str3 = (String) jSONObject.opt("default_json");
                String str4 = (String) jSONObject.opt("target_json");
                String str5 = (String) jSONObject.opt("res_config");
                String str6 = str2 + File.separator + ARFileUtils.AR_UNZIP_ROOT_DIR;
                TrackRes parseCaseConfig = ParserJson.parseCaseConfig(str2, str3, str4);
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
                ImuStateMachine.m1994a().mo10119a(ImuStateMachine.EVENT.DOWNLOAD_RES_FINISH);
                HashMap hashMap = new HashMap();
                if (this.f1012g != null) {
                    System.out.print("initCase in track: " + Arrays.toString(hashMap.entrySet().toArray()) + "\n");
                    mo9519a(str6);
                }
                this.f1747s = str;
                mo9521a(true);
            } catch (JSONException unused) {
                C0618d.m1298a((int) MsgField.MSG_ON_PARSE_RESOURCE_UNZIP_ERROR);
            }
        }
    }

    /* renamed from: d */
    public void mo9533d() {
        super.mo9533d();
        ImuStateMachine.m1997a(ImuStateMachine.STATE.RESUME);
        if (this.f1014i) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.RESUME_AR);
        }
        C0812e.m2129a().mo10288a(this.f1746r);
    }

    /* renamed from: e */
    public void mo9535e() {
        super.mo9535e();
        ImuStateMachine.m1997a(ImuStateMachine.STATE.PAUSE);
        if (this.f1014i) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.INTERRUPT_AR);
        }
    }

    /* renamed from: f */
    public void mo9536f() {
        super.mo9536f();
        m2033m();
        ImuStateMachine.m1997a(ImuStateMachine.STATE.DESTROY);
        ImuStateMachine.m1999c();
        C0482a.m803c();
    }

    /* renamed from: i */
    public void mo9539i() {
        super.mo9539i();
        mo9538h();
        m2033m();
    }
}
