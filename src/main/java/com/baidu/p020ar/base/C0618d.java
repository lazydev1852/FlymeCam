package com.baidu.p020ar.base;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.p020ar.DuMixCallback;
import java.util.HashMap;

/* renamed from: com.baidu.ar.base.d */
public class C0618d implements C0617c {

    /* renamed from: a */
    private static final String f1036a = "d";

    /* renamed from: e */
    private static volatile C0618d f1037e;

    /* renamed from: b */
    private HandlerThread f1038b = new HandlerThread("MsgLoopHandler");

    /* renamed from: c */
    private Handler f1039c;

    /* renamed from: d */
    private DuMixCallback f1040d;

    /* renamed from: com.baidu.ar.base.d$a */
    private static class C0619a extends Handler {

        /* renamed from: a */
        private C0617c f1041a;

        public C0619a(Looper looper, C0617c cVar) {
            super(looper);
            this.f1041a = cVar;
        }

        public void handleMessage(Message message) {
            this.f1041a.mo9548a(message);
        }
    }

    private C0618d(DuMixCallback duMixCallback) {
        this.f1040d = duMixCallback;
        this.f1038b.start();
        this.f1039c = new C0619a(this.f1038b.getLooper(), this);
    }

    /* renamed from: a */
    public static void m1297a() {
        if (f1037e != null) {
            f1037e.m1304c();
        }
        f1037e = null;
    }

    /* renamed from: a */
    public static void m1298a(int i) {
        m1300a(i, "");
    }

    /* renamed from: a */
    public static void m1299a(int i, Object obj) {
        String str = f1036a;
        Log.d(str, "send id = " + i);
        if (f1037e != null && f1037e.m1303b()) {
            f1037e.f1039c.sendMessage(f1037e.f1039c.obtainMessage(i, obj));
        }
    }

    /* renamed from: a */
    public static void m1300a(int i, String str) {
        String str2 = f1036a;
        Log.d(str2, "send id = " + i + " && msg = " + str);
        if (f1037e != null && f1037e.m1303b()) {
            f1037e.f1039c.sendMessage(f1037e.f1039c.obtainMessage(i, str));
        }
    }

    /* renamed from: a */
    public static void m1301a(DuMixCallback duMixCallback) {
        if (f1037e == null) {
            synchronized (C0618d.class) {
                if (f1037e == null) {
                    f1037e = new C0618d(duMixCallback);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m1302a(HashMap<String, Object> hashMap) {
        String str = f1036a;
        Log.d(str, "send luaMsg = " + hashMap.toString());
        if (f1037e != null && f1037e.m1303b()) {
            f1037e.f1039c.sendMessage(f1037e.f1039c.obtainMessage(1001, hashMap));
        }
    }

    /* renamed from: b */
    private boolean m1303b() {
        return this.f1038b.isAlive();
    }

    /* renamed from: c */
    private void m1304c() {
        if (m1303b()) {
            this.f1038b.quitSafely();
        }
        this.f1038b = null;
        this.f1039c = null;
        this.f1040d = null;
    }

    /* renamed from: a */
    public void mo9548a(Message message) {
        if (message.what != 1001) {
            String str = f1036a;
            Log.d(str, "onStateChange state = " + message.what);
            if (this.f1040d != null) {
                this.f1040d.onStateChange(message.what, message.obj);
            }
        } else if (this.f1040d != null) {
            this.f1040d.onLuaMessage((HashMap) message.obj);
        }
    }
}
