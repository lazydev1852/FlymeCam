package com.baidu.p020ar.recorder.p048f;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.recorder.p043a.C0840a;
import com.baidu.p020ar.recorder.p046d.C0849a;
import com.baidu.p020ar.recorder.p046d.C0851c;
import com.baidu.p020ar.recorder.p046d.C0852d;
import com.baidu.p020ar.recorder.p046d.C0853e;
import java.nio.ByteBuffer;

/* renamed from: com.baidu.ar.recorder.f.a */
public class C0860a implements C0840a {

    /* renamed from: a */
    private static final String f2133a = "a";

    /* renamed from: g */
    private static volatile C0860a f2134g;

    /* renamed from: b */
    private HandlerThread f2135b;

    /* renamed from: c */
    private Handler f2136c;

    /* renamed from: d */
    private C0849a f2137d;

    /* renamed from: e */
    private C0853e f2138e;

    /* renamed from: f */
    private volatile boolean f2139f = false;

    /* renamed from: com.baidu.ar.recorder.f.a$a */
    private class C0861a {

        /* renamed from: a */
        ByteBuffer f2140a;

        /* renamed from: b */
        int f2141b;

        /* renamed from: c */
        long f2142c;

        public C0861a(ByteBuffer byteBuffer, int i, long j) {
            this.f2140a = byteBuffer;
            this.f2141b = i;
            this.f2142c = j;
        }
    }

    /* renamed from: com.baidu.ar.recorder.f.a$b */
    private static class C0862b extends Handler {

        /* renamed from: a */
        private C0840a f2144a;

        public C0862b(Looper looper, C0840a aVar) {
            super(looper);
            this.f2144a = aVar;
        }

        public void handleMessage(Message message) {
            this.f2144a.mo10419a(message);
        }
    }

    private C0860a() {
    }

    /* renamed from: a */
    public static C0860a m2468a() {
        if (f2134g == null) {
            synchronized (C0860a.class) {
                if (f2134g == null) {
                    f2134g = new C0860a();
                }
            }
        }
        return f2134g;
    }

    /* renamed from: a */
    private void m2469a(C0852d dVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f2137d.mo10471a(dVar, this.f2138e);
        }
    }

    /* renamed from: a */
    private void m2470a(C0853e eVar, C0851c cVar) {
        this.f2135b = new HandlerThread("AudioRecorderThread");
        this.f2135b.start();
        this.f2136c = new C0862b(this.f2135b.getLooper(), this);
        this.f2137d = new C0849a();
        this.f2138e = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.f2137d.mo10470a(cVar);
        }
    }

    /* renamed from: b */
    private void m2471b(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f2137d.mo10473a(false, byteBuffer, i, j);
        }
    }

    /* renamed from: f */
    private void m2472f() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f2137d.mo10476d();
        }
    }

    /* renamed from: g */
    private void m2473g() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f2137d.mo10473a(true, (ByteBuffer) null, 0, 0);
        }
    }

    /* renamed from: h */
    private void m2474h() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f2137d.mo10475c();
            this.f2137d.mo10474b();
            this.f2137d = null;
            this.f2138e = null;
        }
    }

    /* renamed from: i */
    private void m2475i() {
        this.f2135b.quit();
        this.f2135b = null;
        this.f2136c = null;
        f2134g = null;
    }

    /* renamed from: a */
    public void mo10419a(Message message) {
        switch (message.what) {
            case 1001:
                m2469a((C0852d) message.obj);
                return;
            case 1002:
                m2472f();
                return;
            case 1003:
                C0861a aVar = (C0861a) message.obj;
                m2471b(aVar.f2140a, aVar.f2141b, aVar.f2142c);
                return;
            case 1004:
                m2473g();
                return;
            case ARPMessageType.MSG_TYPE_RESUME_MUSIC:
                m2474h();
                return;
            case 1006:
                m2475i();
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo10528a(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0861a aVar = new C0861a(byteBuffer, i, j);
            if (this.f2136c != null && this.f2139f) {
                this.f2136c.sendMessage(this.f2136c.obtainMessage(1003, aVar));
            }
        }
    }

    /* renamed from: a */
    public boolean mo10529a(C0852d dVar, C0853e eVar, C0851c cVar) {
        if (mo10530b()) {
            Log.e(f2133a, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        m2470a(eVar, cVar);
        this.f2136c.sendMessage(this.f2136c.obtainMessage(1001, dVar));
        this.f2139f = true;
        return true;
    }

    /* renamed from: b */
    public boolean mo10530b() {
        return this.f2135b != null && this.f2135b.isAlive();
    }

    /* renamed from: c */
    public void mo10531c() {
        if (this.f2136c != null) {
            this.f2136c.sendMessage(this.f2136c.obtainMessage(1002));
        }
    }

    /* renamed from: d */
    public void mo10532d() {
        if (this.f2136c != null && this.f2139f) {
            this.f2139f = false;
            this.f2136c.sendMessage(this.f2136c.obtainMessage(1004));
        }
    }

    /* renamed from: e */
    public void mo10533e() {
        if (this.f2136c != null) {
            this.f2136c.sendMessage(this.f2136c.obtainMessage(ARPMessageType.MSG_TYPE_RESUME_MUSIC));
            this.f2136c.sendMessage(this.f2136c.obtainMessage(1006));
        }
    }
}
