package com.baidu.p020ar.recorder.p048f;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.recorder.filter.FilterManager;
import com.baidu.p020ar.recorder.p043a.C0840a;
import com.baidu.p020ar.recorder.p044b.C0842a;
import com.baidu.p020ar.recorder.p044b.C0846e;
import com.baidu.p020ar.recorder.p046d.C0851c;
import com.baidu.p020ar.recorder.p046d.C0852d;
import com.baidu.p020ar.recorder.p046d.C0853e;
import com.baidu.p020ar.recorder.p046d.C0855g;
import java.util.ArrayList;

/* renamed from: com.baidu.ar.recorder.f.b */
public class C0863b implements C0840a {

    /* renamed from: a */
    private static final String f2145a = "b";

    /* renamed from: i */
    private static volatile C0863b f2146i;

    /* renamed from: b */
    private Context f2147b;

    /* renamed from: c */
    private HandlerThread f2148c;

    /* renamed from: d */
    private Handler f2149d;

    /* renamed from: e */
    private C0846e f2150e;

    /* renamed from: f */
    private C0855g f2151f;

    /* renamed from: g */
    private C0853e f2152g;

    /* renamed from: h */
    private volatile boolean f2153h = false;

    /* renamed from: com.baidu.ar.recorder.f.b$a */
    private class C0864a {

        /* renamed from: a */
        ArrayList<C0842a> f2154a;

        /* renamed from: b */
        C0852d f2155b;

        public C0864a(ArrayList<C0842a> arrayList, C0852d dVar) {
            this.f2154a = arrayList;
            this.f2155b = dVar;
        }
    }

    /* renamed from: com.baidu.ar.recorder.f.b$b */
    private static class C0865b extends Handler {

        /* renamed from: a */
        private C0840a f2157a;

        public C0865b(Looper looper, C0840a aVar) {
            super(looper);
            this.f2157a = aVar;
        }

        public void handleMessage(Message message) {
            this.f2157a.mo10419a(message);
        }
    }

    private C0863b() {
    }

    /* renamed from: a */
    public static C0863b m2483a() {
        if (f2146i == null) {
            synchronized (C0863b.class) {
                if (f2146i == null) {
                    f2146i = new C0863b();
                }
            }
        }
        return f2146i;
    }

    /* renamed from: a */
    private void m2484a(C0853e eVar, C0851c cVar) {
        this.f2148c = new HandlerThread("VideoRecorderThread");
        this.f2148c.start();
        this.f2149d = new C0865b(this.f2148c.getLooper(), this);
        if (Build.VERSION.SDK_INT >= 18) {
            this.f2151f = new C0855g();
            this.f2151f.mo10470a(cVar);
            this.f2152g = eVar;
        }
    }

    /* renamed from: a */
    private void m2485a(ArrayList<C0842a> arrayList, C0852d dVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f2151f.mo10507a(dVar, this.f2152g);
            if (this.f2150e == null) {
                this.f2150e = new C0846e(this.f2147b, this.f2151f.mo10508e(), arrayList);
            }
        }
    }

    /* renamed from: b */
    private void m2486b(FilterManager.FilterType filterType) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f2150e.mo10464a(this.f2147b, filterType);
        }
    }

    /* renamed from: b */
    private void m2487b(ArrayList<C0842a> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f2150e.mo10465a(this.f2147b, arrayList);
        }
    }

    /* renamed from: b */
    private void m2488b(float[] fArr, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f2151f.mo10472a(false);
            this.f2150e.mo10466a(fArr, j);
        }
    }

    /* renamed from: f */
    private void m2489f() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f2151f.mo10476d();
        }
    }

    /* renamed from: g */
    private void m2490g() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f2151f.mo10472a(true);
        }
    }

    /* renamed from: h */
    private void m2491h() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.f2151f.mo10475c();
            this.f2151f.mo10474b();
            this.f2151f = null;
            this.f2152g = null;
            this.f2150e.mo10463a();
            this.f2150e = null;
            this.f2147b = null;
        }
    }

    /* renamed from: i */
    private void m2492i() {
        this.f2148c.getLooper().quit();
        this.f2148c = null;
        this.f2149d = null;
        f2146i = null;
    }

    /* renamed from: a */
    public void mo10419a(Message message) {
        switch (message.what) {
            case 1001:
                C0864a aVar = (C0864a) message.obj;
                m2485a(aVar.f2154a, aVar.f2155b);
                return;
            case 1002:
                m2489f();
                return;
            case 1003:
                m2487b((ArrayList<C0842a>) (ArrayList) message.obj);
                return;
            case 1004:
                m2486b((FilterManager.FilterType) message.obj);
                return;
            case ARPMessageType.MSG_TYPE_RESUME_MUSIC:
                m2488b((float[]) message.obj, (((long) message.arg1) << 32) | (((long) message.arg2) & 4294967295L));
                return;
            case 1006:
                m2490g();
                return;
            case 1007:
                m2491h();
                return;
            case 1008:
                m2492i();
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo10535a(FilterManager.FilterType filterType) {
        if (this.f2149d != null) {
            this.f2149d.sendMessage(this.f2149d.obtainMessage(1004, filterType));
        }
    }

    /* renamed from: a */
    public void mo10536a(ArrayList<C0842a> arrayList) {
        if (this.f2149d != null) {
            this.f2149d.sendMessage(this.f2149d.obtainMessage(1003, arrayList));
        }
    }

    /* renamed from: a */
    public void mo10537a(float[] fArr, long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.f2149d != null && this.f2153h) {
            this.f2149d.sendMessage(this.f2149d.obtainMessage(ARPMessageType.MSG_TYPE_RESUME_MUSIC, i, i2, fArr));
        }
    }

    /* renamed from: a */
    public boolean mo10538a(Context context, ArrayList<C0842a> arrayList, C0852d dVar, C0853e eVar, C0851c cVar) {
        if (mo10539b()) {
            Log.e(f2145a, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        this.f2147b = context;
        m2484a(eVar, cVar);
        this.f2149d.sendMessage(this.f2149d.obtainMessage(1001, new C0864a(arrayList, dVar)));
        this.f2153h = true;
        return true;
    }

    /* renamed from: b */
    public boolean mo10539b() {
        return this.f2148c != null && this.f2148c.isAlive();
    }

    /* renamed from: c */
    public void mo10540c() {
        if (this.f2149d != null) {
            this.f2149d.sendMessage(this.f2149d.obtainMessage(1002));
        }
    }

    /* renamed from: d */
    public void mo10541d() {
        if (this.f2149d != null && this.f2153h) {
            this.f2153h = false;
            this.f2149d.removeCallbacksAndMessages((Object) null);
            this.f2149d.sendMessage(this.f2149d.obtainMessage(1006));
        }
    }

    /* renamed from: e */
    public void mo10542e() {
        if (this.f2149d != null) {
            this.f2149d.sendMessage(this.f2149d.obtainMessage(1007));
            this.f2149d.sendMessage(this.f2149d.obtainMessage(1008));
        }
    }
}
