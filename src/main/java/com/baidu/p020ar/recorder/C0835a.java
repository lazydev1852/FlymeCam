package com.baidu.p020ar.recorder;

import android.content.Context;
import android.opengl.EGLContext;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.p020ar.arplay.core.message.ARPMessageType;
import com.baidu.p020ar.recorder.filter.FilterManager;
import com.baidu.p020ar.recorder.p044b.C0842a;
import com.baidu.p020ar.recorder.p044b.C0845d;
import com.baidu.p020ar.recorder.p046d.C0851c;
import com.baidu.p020ar.recorder.p046d.C0852d;
import com.baidu.p020ar.recorder.p046d.C0853e;
import com.baidu.p020ar.recorder.p046d.C0854f;
import com.baidu.p020ar.recorder.p048f.C0860a;
import com.baidu.p020ar.recorder.p048f.C0863b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* renamed from: com.baidu.ar.recorder.a */
public class C0835a {

    /* renamed from: a */
    private static final String f2015a = "a";

    /* renamed from: b */
    private static volatile int f2016b = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static volatile boolean f2017k = false;

    /* renamed from: t */
    private static volatile C0835a f2018t;

    /* renamed from: c */
    private int f2019c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public volatile boolean f2020d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0852d f2021e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public MovieRecorderCallback f2022f;

    /* renamed from: g */
    private C0839a f2023g;

    /* renamed from: h */
    private C0841b f2024h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0853e f2025i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C0854f f2026j;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C0860a f2027l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C0851c f2028m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public volatile boolean f2029n = false;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C0863b f2030o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public C0851c f2031p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public volatile boolean f2032q = false;

    /* renamed from: r */
    private ArrayList<C0842a> f2033r;

    /* renamed from: s */
    private int f2034s;

    /* renamed from: com.baidu.ar.recorder.a$a */
    class C0839a extends Handler {
        public C0839a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 6901) {
                switch (i) {
                    case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE:
                        if (C0835a.this.f2022f != null) {
                            C0835a.this.f2022f.onRecorderStart(((Boolean) message.obj).booleanValue());
                        }
                        boolean unused = C0835a.this.f2020d = false;
                        break;
                    case 7002:
                        if (C0835a.this.f2022f != null) {
                            C0835a.this.f2022f.onRecorderProcess(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case 7003:
                        if (C0835a.this.f2022f != null) {
                            String str = null;
                            if (C0835a.this.f2021e != null) {
                                str = C0835a.this.f2021e.mo10477a();
                            }
                            C0835a.this.f2022f.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                            break;
                        }
                        break;
                    case 7004:
                        if (C0835a.this.f2022f != null) {
                            C0835a.this.f2022f.onRecorderError(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                }
            } else {
                boolean unused2 = C0835a.this.f2020d = false;
                C0835a.this.mo10408b();
            }
            super.handleMessage(message);
        }
    }

    private C0835a() {
    }

    /* renamed from: a */
    public static C0835a m2271a() {
        if (f2018t == null) {
            synchronized (C0835a.class) {
                if (f2018t == null) {
                    f2018t = new C0835a();
                }
            }
        }
        return f2018t;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m2278a(int i, boolean z) {
        String str = f2015a;
        Log.d(str, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        m2287b(i, z);
        String str2 = f2015a;
        Log.d(str2, "checkMovieRecordStartState sMovieRecordState = " + f2016b);
        if (m2305k() && this.f2023g != null) {
            this.f2023g.sendMessage(this.f2023g.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(m2306l())));
        }
    }

    /* renamed from: a */
    private void m2279a(long j) {
        if (!this.f2024h.mo10421a()) {
            this.f2024h.mo10420a(j);
            return;
        }
        int b = this.f2024h.mo10422b(j);
        if (b > 0 && this.f2023g != null) {
            this.f2023g.sendMessage(this.f2023g.obtainMessage(7002, Integer.valueOf(b)));
        }
    }

    /* renamed from: a */
    private void m2280a(Context context) {
        m2303i();
        this.f2030o.mo10538a(context, this.f2033r, this.f2021e, this.f2025i, this.f2031p);
    }

    /* renamed from: b */
    private static void m2286b(int i) {
        f2016b = i;
    }

    /* renamed from: b */
    private void m2287b(int i, boolean z) {
        if (z) {
            f2016b = i | f2016b;
        }
        this.f2019c++;
    }

    /* renamed from: b */
    private void m2288b(Context context, C0852d dVar, MovieRecorderCallback movieRecorderCallback) {
        this.f2021e = dVar;
        this.f2022f = movieRecorderCallback;
        if (Build.VERSION.SDK_INT >= 18) {
            this.f2025i = C0853e.m2424a();
        }
        if (dVar.mo10494k()) {
            this.f2027l = C0860a.m2468a();
        } else {
            f2017k = true;
        }
        this.f2030o = C0863b.m2483a();
        this.f2019c = 0;
        this.f2023g = new C0839a(context.getMainLooper());
        this.f2024h = new C0841b(dVar.mo10484c());
    }

    /* renamed from: b */
    private static void m2290b(boolean z) {
        f2017k = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m2293c(int i, boolean z) {
        String str = f2015a;
        Log.d(str, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        m2297d(i, z);
        String str2 = f2015a;
        Log.d(str2, "checkMovieRecordStopState sMovieRecordState = " + f2016b);
        if (m2307m() && this.f2023g != null) {
            this.f2023g.sendMessage(this.f2023g.obtainMessage(7003, Boolean.valueOf(m2308n())));
        }
    }

    /* renamed from: d */
    private static void m2296d() {
        f2018t = null;
    }

    /* renamed from: d */
    private void m2297d(int i, boolean z) {
        if (z) {
            f2016b = i ^ f2016b;
        }
        this.f2019c--;
    }

    /* renamed from: e */
    private void m2299e() {
        if (this.f2023g != null) {
            this.f2023g.sendMessageDelayed(this.f2023g.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 1000);
        }
    }

    /* renamed from: f */
    private void m2300f() {
        this.f2031p = new C0851c() {
            /* renamed from: a */
            public void mo10412a(boolean z) {
                if (z) {
                    C0835a.this.f2030o.mo10540c();
                }
            }

            /* renamed from: b */
            public void mo10413b(boolean z) {
                boolean unused = C0835a.this.f2032q = z;
                C0835a.this.m2278a(2, z);
            }

            /* renamed from: c */
            public void mo10414c(boolean z) {
            }

            /* renamed from: d */
            public void mo10415d(boolean z) {
                C0835a.this.f2030o.mo10542e();
                C0863b unused = C0835a.this.f2030o = null;
                C0851c unused2 = C0835a.this.f2031p = null;
                C0835a.this.m2293c(2, z);
            }
        };
        this.f2028m = new C0851c() {
            /* renamed from: a */
            public void mo10412a(boolean z) {
                if (z) {
                    C0835a.this.f2027l.mo10531c();
                }
            }

            /* renamed from: b */
            public void mo10413b(boolean z) {
                boolean unused = C0835a.this.f2029n = z;
                C0835a.this.m2278a(4, z);
            }

            /* renamed from: c */
            public void mo10414c(boolean z) {
                boolean unused = C0835a.f2017k = z;
            }

            /* renamed from: d */
            public void mo10415d(boolean z) {
                C0835a.this.f2027l.mo10533e();
                C0860a unused = C0835a.this.f2027l = null;
                C0851c unused2 = C0835a.this.f2028m = null;
                C0835a.this.m2293c(4, z);
            }
        };
        this.f2026j = new C0854f() {
            /* renamed from: a */
            public void mo10416a(boolean z) {
                C0835a.this.m2278a(1, z);
            }

            /* renamed from: b */
            public void mo10417b(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    C0835a.this.f2025i.mo10506e();
                    C0853e unused = C0835a.this.f2025i = null;
                }
                C0854f unused2 = C0835a.this.f2026j = null;
                C0835a.this.m2293c(1, z);
            }
        };
    }

    /* renamed from: g */
    private boolean m2301g() {
        String str;
        String str2;
        if (this.f2027l != null && this.f2027l.mo10530b()) {
            str = f2015a;
            str2 = "prepareMovieRecorder mAudioRecorder.isRunning !!!";
        } else if (this.f2030o.mo10539b()) {
            str = f2015a;
            str2 = "prepareMovieRecorder mVideoRecorder.isRunning !!!";
        } else if (this.f2021e == null || this.f2025i.mo10502a(this.f2021e.mo10477a(), this.f2021e.mo10482b(), this.f2026j)) {
            return true;
        } else {
            str = f2015a;
            str2 = "prepareMovieRecorder movieMuxerInit error!!!";
        }
        Log.e(str, str2);
        return false;
    }

    /* renamed from: h */
    private void m2302h() {
        if (this.f2027l != null) {
            this.f2027l.mo10529a(this.f2021e, this.f2025i, this.f2028m);
        }
    }

    /* renamed from: i */
    private void m2303i() {
        m2304j();
    }

    /* renamed from: j */
    private void m2304j() {
        C0845d g;
        int i;
        if (this.f2033r != null) {
            Iterator<C0842a> it = this.f2033r.iterator();
            while (it.hasNext()) {
                C0842a next = it.next();
                next.mo10431b(this.f2034s);
                if (next.mo10438g().mo10462f() == 0) {
                    g = next.mo10438g();
                    i = next.mo10440i() - next.mo10441j();
                } else {
                    g = next.mo10438g();
                    i = next.mo10440i() + next.mo10441j();
                }
                g.mo10458c(i);
            }
        }
    }

    /* renamed from: k */
    private boolean m2305k() {
        if (this.f2021e == null) {
            return false;
        }
        if (this.f2021e.mo10494k()) {
            if (this.f2019c == 3) {
                return true;
            }
        } else if (this.f2019c == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: l */
    private synchronized boolean m2306l() {
        boolean z;
        String str = f2015a;
        Log.d(str, "isMovieRecordStarted sMovieRecordState = " + f2016b);
        z = true;
        int i = (f2016b ^ 1) ^ 2;
        if (this.f2021e != null && this.f2021e.mo10494k()) {
            i ^= 4;
        }
        if (i != 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: m */
    private boolean m2307m() {
        return this.f2019c == 0;
    }

    /* renamed from: n */
    private synchronized boolean m2308n() {
        return f2016b == 0;
    }

    /* renamed from: a */
    public void mo10400a(int i) {
        this.f2034s = i;
    }

    /* renamed from: a */
    public void mo10401a(Context context, C0852d dVar, MovieRecorderCallback movieRecorderCallback) {
        if (this.f2020d) {
            m2299e();
            return;
        }
        this.f2020d = true;
        m2288b(context, dVar, movieRecorderCallback);
        m2300f();
        if (!m2301g()) {
            m2299e();
            return;
        }
        m2302h();
        m2280a(context);
    }

    /* renamed from: a */
    public void mo10402a(EGLContext eGLContext, int i) {
        if (eGLContext != null && this.f2033r != null) {
            C0842a aVar = null;
            Iterator<C0842a> it = this.f2033r.iterator();
            while (it.hasNext()) {
                C0842a next = it.next();
                if (eGLContext.equals(next.mo10424a())) {
                    aVar = next;
                }
            }
            if (aVar != null && aVar.mo10442k()) {
                aVar.mo10425a(i);
            }
        }
    }

    /* renamed from: a */
    public void mo10403a(C0842a aVar) {
        mo10404a(aVar, true);
    }

    /* renamed from: a */
    public void mo10404a(C0842a aVar, boolean z) {
        if (aVar != null && aVar.mo10424a() != null) {
            if (this.f2033r == null) {
                this.f2033r = new ArrayList<>();
            }
            int i = -1;
            for (int i2 = 0; i2 < this.f2033r.size(); i2++) {
                if (this.f2033r.get(i2).mo10435d() == aVar.mo10435d()) {
                    i = i2;
                }
            }
            if (i >= 0 && i < this.f2033r.size()) {
                if (this.f2033r.get(i).mo10424a() != aVar.mo10424a()) {
                    this.f2033r.remove(i);
                } else {
                    return;
                }
            }
            if (z) {
                aVar = (C0842a) aVar.clone();
            }
            this.f2033r.add(aVar);
            Collections.sort(this.f2033r);
        }
    }

    /* renamed from: a */
    public void mo10405a(FilterManager.FilterType filterType) {
        if (this.f2030o != null && this.f2030o.mo10539b() && filterType != null) {
            this.f2030o.mo10535a(filterType);
        }
    }

    /* renamed from: a */
    public void mo10406a(ByteBuffer byteBuffer, int i, long j) {
        if (this.f2029n && this.f2027l != null && this.f2027l.mo10530b()) {
            this.f2027l.mo10528a(byteBuffer, i, j);
        }
    }

    /* renamed from: a */
    public void mo10407a(float[] fArr, long j) {
        if (this.f2030o != null && this.f2030o.mo10539b() && this.f2032q && f2017k) {
            this.f2030o.mo10537a(fArr, j);
            m2279a(j / 1000000);
        }
    }

    /* renamed from: b */
    public void mo10408b() {
        if (this.f2020d) {
            Log.d(f2015a, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.f2023g != null) {
                this.f2023g.sendMessageDelayed(this.f2023g.obtainMessage(6901), 500);
                return;
            }
            return;
        }
        this.f2029n = false;
        this.f2032q = false;
        if (this.f2027l != null && this.f2027l.mo10530b()) {
            this.f2027l.mo10532d();
        }
        if (this.f2030o != null && this.f2030o.mo10539b()) {
            this.f2030o.mo10541d();
        }
        m2290b(false);
    }

    /* renamed from: b */
    public void mo10409b(C0842a aVar) {
        mo10410b(aVar, true);
    }

    /* renamed from: b */
    public void mo10410b(C0842a aVar, boolean z) {
        if (this.f2030o != null) {
            mo10404a(aVar, z);
            this.f2030o.mo10536a(this.f2033r);
        }
    }

    /* renamed from: c */
    public void mo10411c() {
        if (this.f2033r != null) {
            this.f2033r.clear();
            this.f2033r = null;
        }
        this.f2024h = null;
        this.f2021e = null;
        this.f2022f = null;
        if (this.f2023g != null) {
            this.f2023g.removeCallbacksAndMessages((Object) null);
            this.f2023g = null;
        }
        m2286b(0);
        m2296d();
    }
}
