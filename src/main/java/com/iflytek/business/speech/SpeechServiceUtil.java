package com.iflytek.business.speech;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.p020ar.constants.HttpConstants;
import com.iflytek.business.speech.IInitServiceListener;
import com.iflytek.business.speech.ISpeechService;
import java.lang.reflect.Method;

/* renamed from: com.iflytek.business.speech.j */
public class SpeechServiceUtil {

    /* renamed from: a */
    private final String f2482a = "SpeechServiceUtil";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Intent f2483b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f2484c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IInitServiceListener f2485d = new IInitServiceListener.C1026a() {
        /* renamed from: a */
        public void mo12879a(int i) throws RemoteException {
            Logging.m2831a("SpeechServiceUtil", "onInitCallBack resultCode = " + i);
            Message obtainMessage = SpeechServiceUtil.this.f2489h.obtainMessage(258);
            obtainMessage.arg1 = i;
            SpeechServiceUtil.this.f2489h.sendMessage(obtainMessage);
        }
    };

    /* renamed from: e */
    private final int f2486e = 257;

    /* renamed from: f */
    private final int f2487f = 258;

    /* renamed from: g */
    private final int f2488g = 259;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Handler f2489h = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 257:
                    SpeechServiceUtil.this.m2880d();
                    int unused = SpeechServiceUtil.this.m2877c();
                    return;
                case 258:
                    if (SpeechServiceUtil.this.f2491j != null) {
                        Logging.m2831a("SpeechServiceUtil", "MSG_INIT onSpeechInit " + message.arg1);
                        SpeechServiceUtil.this.f2491j.mo12940a(message.arg1);
                        return;
                    }
                    return;
                case 259:
                    if (SpeechServiceUtil.this.f2491j != null) {
                        SpeechServiceUtil.this.f2491j.mo12939a();
                        return;
                    }
                    return;
                default:
                    Logging.m2831a("SpeechServiceUtil", "unknown msg " + message.what);
                    return;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ISpeechService f2490i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C1035a f2491j;

    /* renamed from: k */
    private Context f2492k;

    /* renamed from: l */
    private ServiceConnection f2493l = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Method method;
            Logging.m2831a("SpeechServiceUtil", "SpeechServiceUtil | onServiceConnected---package = " + SpeechServiceUtil.this.f2484c);
            try {
                ISpeechService unused = SpeechServiceUtil.this.f2490i = ISpeechService.C1028a.m2804a(iBinder);
                SpeechServiceUtil.this.m2875b(SpeechServiceUtil.this.f2483b);
                SpeechServiceUtil.this.f2490i.mo12884a(SpeechServiceUtil.this.f2483b, SpeechServiceUtil.this.f2485d);
                method = null;
                method = SpeechServiceUtil.this.f2490i.getClass().getDeclaredMethod("initService", new Class[]{Intent.class});
            } catch (Throwable th) {
                Logging.m2832a("SpeechServiceUtil", "", th);
                return;
            }
            if (method != null) {
                SpeechServiceUtil.this.f2489h.sendEmptyMessage(258);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpeechServiceUtil | onServiceDisconnected ComponentName: ");
            sb.append(componentName != null ? componentName.toString() : "null");
            Logging.m2831a("SpeechServiceUtil", sb.toString());
            SpeechServiceUtil.this.f2489h.sendEmptyMessage(259);
            SpeechServiceUtil.this.f2489h.sendEmptyMessage(257);
        }
    };

    /* renamed from: com.iflytek.business.speech.j$a */
    /* compiled from: SpeechServiceUtil */
    public interface C1035a {
        /* renamed from: a */
        void mo12939a();

        /* renamed from: a */
        void mo12940a(int i);
    }

    public SpeechServiceUtil(Context context, C1035a aVar, Intent intent) {
        Logging.m2831a("SpeechServiceUtil", "SpeechServiceUtil | create enter");
        this.f2491j = aVar;
        this.f2492k = context.getApplicationContext();
        this.f2483b = intent;
        this.f2484c = PackageUtils.m2840b(this.f2492k);
        if (this.f2492k != null) {
            if (this.f2483b == null) {
                this.f2483b = new Intent();
            }
            boolean booleanExtra = this.f2483b.getBooleanExtra("client_log_enable", true);
            Logging.m2831a("SpeechServiceUtil", "client_log_enable = " + booleanExtra);
            Logging.m2834a(booleanExtra);
            this.f2483b.removeExtra("client_log_enable");
            int c = m2877c();
            if (c != 0) {
                try {
                    this.f2485d.mo12879a(c);
                } catch (Throwable th) {
                    Logging.m2832a("SpeechServiceUtil", "", th);
                }
            }
            Logging.m2831a("SpeechServiceUtil", "SpeechServiceUtil | create leave---package = " + this.f2484c);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2875b(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        mo12933a(extras);
        intent.putExtras(extras);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo12933a(Bundle bundle) {
        PackageUtils a = PackageUtils.m2838a(this.f2492k);
        String a2 = a.mo12911a();
        String b = a.mo12913b();
        String c = a.mo12914c();
        String a3 = a.mo12912a("caller.name");
        String a4 = a.mo12912a("caller.pkg");
        String a5 = a.mo12912a("caller.ver.name");
        String a6 = a.mo12912a("caller.ver.code");
        bundle.putString("caller.appid", a2);
        bundle.putString("key", b);
        bundle.putString("usrid", c);
        bundle.putString("caller.name", a3);
        bundle.putString("caller.pkg", a4);
        bundle.putString("caller.ver.name", a5);
        bundle.putString("caller.ver.code", a6);
        bundle.putString("sdk_branch", "4.1");
        bundle.putInt(HttpConstants.SDK_VERSION_CODE, 1100);
    }

    /* renamed from: a */
    public void mo12932a(Intent intent) {
        if (this.f2490i != null) {
            try {
                Logging.m2831a("SpeechServiceUtil", "SpeechServiceUtil | startRecognize---package = " + this.f2484c);
                if (intent == null) {
                    intent = new Intent();
                }
                m2875b(intent);
                this.f2490i.mo12894c(intent);
            } catch (Throwable th) {
                Logging.m2832a("SpeechServiceUtil", "", th);
                m2877c();
            }
        }
    }

    /* renamed from: a */
    public void mo12931a() {
        if (this.f2490i != null) {
            try {
                Logging.m2831a("SpeechServiceUtil", "SpeechServiceUtil | stopRecognize---package = " + this.f2484c);
                Intent intent = new Intent();
                m2875b(intent);
                this.f2490i.mo12896e(intent);
            } catch (Throwable th) {
                Logging.m2832a("SpeechServiceUtil", "", th);
                m2877c();
            }
        }
    }

    /* renamed from: a */
    public void mo12934a(RecognitionListener iVar, Intent intent) {
        if (this.f2490i != null && iVar != null) {
            try {
                Logging.m2831a("SpeechServiceUtil", "SpeechServiceUtil | initRecognitionEngine " + iVar + "---package = " + this.f2484c);
                if (intent == null) {
                    intent = new Intent();
                }
                m2875b(intent);
                String a = PackageUtils.m2839a(this.f2492k, "com.iflytek.business.speech.SharedProvider");
                if (!TextUtils.isEmpty(a) && intent != null) {
                    intent.putExtra("content_provider_name", a);
                }
                this.f2490i.mo12885a(iVar, intent);
            } catch (Throwable th) {
                Logging.m2832a("SpeechServiceUtil", "", th);
                m2877c();
            }
        }
    }

    /* renamed from: b */
    public synchronized void mo12935b() {
        Logging.m2831a("SpeechServiceUtil", "SpeechServiceUtil | destroy---package = " + this.f2484c);
        if (this.f2490i != null) {
            Intent intent = new Intent();
            m2875b(intent);
            try {
                this.f2490i.mo12906o(intent);
                Logging.m2831a("SpeechServiceUtil", "after disconnect");
            } catch (Throwable th) {
                Logging.m2833a("SpeechServiceUtil", th);
            }
        }
        m2880d();
        this.f2490i = null;
        this.f2491j = null;
        this.f2493l = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized int m2877c() {
        int i;
        Logging.m2831a("SpeechServiceUtil", "SpeechServiceUtil | startSpeechService---package = " + this.f2484c);
        i = 0;
        if (this.f2493l != null) {
            Intent intent = new Intent("com.iflytek.speech.SpeechService");
            intent.setPackage("com.iflytek.speechsuite");
            boolean bindService = this.f2492k.bindService(intent, this.f2493l, 1);
            Logging.m2831a("SpeechServiceUtil", "bindService = " + bindService);
            if (!bindService) {
                i = 800027;
            }
        } else {
            Logging.m2836c("SpeechServiceUtil", "startSpeechService | mConnection is null");
            i = 800025;
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public synchronized void m2880d() {
        Logging.m2831a("SpeechServiceUtil", "stopSpeechService");
        if (this.f2493l != null) {
            try {
                this.f2492k.unbindService(this.f2493l);
            } catch (Throwable th) {
                Logging.m2833a("SpeechServiceUtil", th);
            }
        } else {
            Logging.m2836c("SpeechServiceUtil", "stopSpeechService | mConnection is null");
        }
    }
}
