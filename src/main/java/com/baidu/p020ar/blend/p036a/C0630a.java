package com.baidu.p020ar.blend.p036a;

import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.p020ar.arplay.core.ARPEngine;
import com.baidu.p020ar.arplay.core.C0577a;
import com.baidu.p020ar.blend.gpuimage.graphics.C0749a;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.baidu.ar.blend.a.a */
public class C0630a implements C0577a {

    /* renamed from: a */
    boolean f1163a = false;

    /* renamed from: b */
    protected Timer f1164b;

    /* renamed from: c */
    protected TimerTask f1165c;

    /* renamed from: d */
    protected float f1166d = 30.0f;

    /* renamed from: e */
    private C0639b f1167e = new C0639b("ArGLEngineThread");

    /* renamed from: f */
    private C0637a f1168f;

    /* renamed from: g */
    private ArrayList<Runnable> f1169g = new ArrayList<>();

    /* renamed from: h */
    private int[] f1170h = null;

    /* renamed from: i */
    private int f1171i;

    /* renamed from: j */
    private int f1172j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public long f1173k = -1;

    /* renamed from: l */
    private int f1174l = 1;

    /* renamed from: m */
    private boolean f1175m = false;

    /* renamed from: n */
    private long f1176n = System.currentTimeMillis();

    /* renamed from: o */
    private int f1177o = 33;

    /* renamed from: p */
    private C0639b f1178p;

    /* renamed from: q */
    private Handler f1179q;

    /* renamed from: r */
    private BlockingQueue<int[]> f1180r = new ArrayBlockingQueue(3);

    /* renamed from: s */
    private BlockingQueue<int[]> f1181s = new ArrayBlockingQueue(3);

    /* renamed from: t */
    private Object f1182t = new Object();

    /* renamed from: u */
    private volatile int f1183u = 0;

    /* renamed from: v */
    private volatile boolean f1184v = false;

    /* renamed from: w */
    private boolean f1185w = true;

    /* renamed from: x */
    private boolean f1186x = true;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public String f1187y;

    /* renamed from: com.baidu.ar.blend.a.a$a */
    private static class C0637a extends Handler {

        /* renamed from: a */
        C0630a f1200a;

        C0637a(C0630a aVar, Looper looper) {
            super(looper);
            this.f1200a = aVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo9759a() {
            this.f1200a = null;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    if (this.f1200a != null) {
                        this.f1200a.mo9752m();
                        return;
                    }
                    return;
                case 1002:
                    if (this.f1200a != null) {
                        this.f1200a.m1416x();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.ar.blend.a.a$b */
    private static class C0638b extends TimerTask {

        /* renamed from: a */
        SoftReference<C0630a> f1201a;

        C0638b(C0630a aVar) {
            this.f1201a = new SoftReference<>(aVar);
        }

        public boolean cancel() {
            boolean cancel = super.cancel();
            if (this.f1201a != null) {
                this.f1201a.clear();
                this.f1201a = null;
            }
            return cancel;
        }

        public void run() {
            C0630a aVar;
            if (this.f1201a != null && (aVar = this.f1201a.get()) != null) {
                aVar.mo9237c();
            }
        }
    }

    public C0630a(EGLContext eGLContext, EGLConfig eGLConfig) {
        this.f1167e.mo9764a(eGLContext, eGLConfig);
        this.f1167e.start();
        this.f1168f = new C0637a(this, this.f1167e.getLooper());
        mo9236b((Runnable) new Runnable() {
            public void run() {
                long unused = C0630a.this.f1173k = Thread.currentThread().getId();
            }
        });
        this.f1174l = 1;
        if (this.f1175m) {
            m1408p();
        }
    }

    /* renamed from: a */
    private void m1401a(Queue<int[]> queue) {
        for (int[] iArr : queue) {
            if (iArr != null) {
                m1402a(iArr);
            }
        }
        queue.clear();
    }

    /* renamed from: a */
    public static void m1402a(int[] iArr) {
        for (int i = 0; i < 3; i++) {
            if (iArr[i] != -1) {
                C0749a.m1947c(iArr[i]);
                iArr[i] = -1;
            }
            int i2 = i + 3;
            if (iArr[i2] != -1) {
                C0749a.m1943b(iArr[i2]);
                iArr[i2] = -1;
            }
            int i3 = i + 6;
            if (iArr[i3] != -1) {
                C0749a.m1948d(iArr[i3]);
                iArr[i3] = -1;
            }
        }
    }

    /* renamed from: c */
    private void m1404c(int i, int i2) {
        if (!(this.f1171i == i && this.f1172j == i2)) {
            this.f1163a = true;
        }
        this.f1171i = i;
        this.f1172j = i2;
    }

    /* renamed from: n */
    private void m1406n() {
        if (this.f1178p != null) {
            this.f1178p.quit();
            try {
                this.f1178p.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: o */
    private void m1407o() {
        if (this.f1168f != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            C06333 r1 = new Runnable() {
                public void run() {
                    synchronized (this) {
                        C0630a.this.m1417y();
                        atomicBoolean.set(true);
                        notify();
                    }
                }
            };
            this.f1168f.post(r1);
            try {
                synchronized (r1) {
                    while (!atomicBoolean.get()) {
                        r1.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.f1168f.removeCallbacksAndMessages((Object) null);
            this.f1168f.mo9759a();
            this.f1168f = null;
        }
        synchronized (this.f1167e) {
            this.f1169g.clear();
        }
        if (this.f1167e != null) {
            this.f1167e.quit();
            try {
                this.f1167e.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: p */
    private void m1408p() {
        if (this.f1164b != null) {
            this.f1164b.cancel();
            this.f1164b.purge();
        }
        if (this.f1165c != null) {
            this.f1165c.cancel();
            this.f1165c = null;
        }
        this.f1164b = new Timer();
        this.f1165c = new C0638b(this);
        this.f1164b.schedule(this.f1165c, 0, (long) (1000.0f / this.f1166d));
    }

    /* renamed from: q */
    private boolean m1409q() {
        if (this.f1164b == null) {
            return false;
        }
        this.f1164b.cancel();
        this.f1164b.purge();
        this.f1164b = null;
        if (this.f1165c == null) {
            return true;
        }
        this.f1165c.cancel();
        this.f1165c = null;
        return true;
    }

    /* renamed from: r */
    private synchronized void m1410r() {
        if (this.f1178p == null && mo9746g() != null) {
            this.f1178p = new C0639b("GLResLoadThread");
            this.f1178p.mo9764a(mo9746g(), (EGLConfig) null);
            this.f1178p.start();
            this.f1179q = new Handler(this.f1178p.getLooper());
        }
    }

    /* renamed from: s */
    private void m1411s() {
        this.f1183u = 1;
    }

    /* renamed from: t */
    private boolean m1412t() {
        return this.f1183u == 1;
    }

    /* renamed from: u */
    private boolean m1413u() {
        if (this.f1171i == 0 && this.f1172j == 0) {
            return false;
        }
        m1414v();
        int[] w = m1415w();
        if (w != null) {
            if (this.f1170h != null) {
                mo9745c(this.f1170h);
            }
            this.f1170h = w;
        }
        if (this.f1170h != null) {
            return ARPEngine.getInstance().updateFbos(this.f1170h);
        }
        return false;
    }

    /* renamed from: v */
    private void m1414v() {
        if (this.f1163a) {
            m1401a((Queue<int[]>) this.f1180r);
            m1401a((Queue<int[]>) this.f1181s);
            for (int i = 0; i < 3; i++) {
                int[] iArr = new int[9];
                for (int i2 = 0; i2 < 3; i2++) {
                    if (!this.f1185w && i2 == 1) {
                        iArr[i2] = -1;
                        iArr[i2 + 3] = -1;
                        iArr[i2 + 6] = -1;
                    } else if (this.f1186x || i2 != 2) {
                        iArr[i2] = C0749a.m1942b();
                        int i3 = i2 + 3;
                        iArr[i3] = C0749a.m1934a(3553, this.f1171i, this.f1172j);
                        int i4 = i2 + 6;
                        iArr[i4] = C0749a.m1946c();
                        C0749a.m1940a(33189, this.f1171i, this.f1172j, iArr[i4], iArr[i2]);
                        C0749a.m1944b(iArr[i3], 3553, iArr[i2]);
                        Log.d("bdar", "bdar: blend fboIds = " + iArr[i2]);
                        GLES20.glBindFramebuffer(36160, iArr[i2]);
                        GLES20.glViewport(0, 0, this.f1171i, this.f1172j);
                        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                        GLES20.glClear(16640);
                        GLES20.glBindFramebuffer(36160, 0);
                    } else {
                        iArr[i2] = -1;
                        iArr[i2 + 3] = -1;
                        iArr[i2 + 6] = -1;
                    }
                }
                this.f1180r.offer(iArr);
            }
            GLES20.glFlush();
            this.f1163a = false;
        }
    }

    /* renamed from: w */
    private int[] m1415w() {
        return (int[]) this.f1180r.poll();
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m1416x() {
        while (true) {
            Runnable runnable = null;
            synchronized (this.f1167e) {
                if (!this.f1169g.isEmpty()) {
                    runnable = this.f1169g.remove(0);
                }
            }
            if (runnable != null) {
                runnable.run();
            } else {
                return;
            }
        }
        while (true) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m1417y() {
        if (this.f1170h != null) {
            mo9744b(this.f1170h);
            this.f1170h = null;
        }
        m1401a((Queue<int[]>) this.f1180r);
        m1401a((Queue<int[]>) this.f1181s);
    }

    /* renamed from: a */
    public void mo9231a() {
        if (this.f1179q != null) {
            this.f1179q.removeCallbacksAndMessages((Object) null);
            final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
            this.f1179q.post(new Runnable() {
                public void run() {
                    linkedBlockingQueue.add(1);
                }
            });
            while (this.f1178p.isAlive()) {
                try {
                    if (linkedBlockingQueue.poll(50, TimeUnit.MILLISECONDS) != null) {
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo9232a(int i) {
        if (this.f1174l != i) {
            this.f1174l = i;
            if (this.f1174l == 0) {
                m1409q();
            } else if (this.f1175m) {
                m1408p();
            }
        }
    }

    /* renamed from: a */
    public void mo9740a(final int i, final int i2) {
        mo9236b((Runnable) new Runnable() {
            public void run() {
                C0630a.this.mo9743b(i, i2);
            }
        });
    }

    /* renamed from: a */
    public void mo9233a(Runnable runnable) {
        m1410r();
        if (this.f1179q != null) {
            this.f1179q.post(runnable);
        }
    }

    /* renamed from: a */
    public void mo9234a(final String str) {
        mo9236b((Runnable) new Runnable() {
            public void run() {
                String unused = C0630a.this.f1187y = str;
            }
        });
    }

    /* renamed from: a */
    public void mo9741a(boolean z, boolean z2) {
        this.f1185w = z;
        this.f1186x = z2;
    }

    /* renamed from: b */
    public long mo9235b() {
        return this.f1173k;
    }

    /* renamed from: b */
    public void mo9742b(final int i) {
        if (!TextUtils.isEmpty(this.f1187y)) {
            mo9236b((Runnable) new Runnable() {
                public void run() {
                    try {
                        if (!TextUtils.isEmpty(C0630a.this.f1187y) && i != ARPEngine.getInstance().getTextureId(C0630a.this.f1187y)) {
                            ARPEngine.getInstance().bindTexture(true, i, C0630a.this.f1187y);
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9743b(int i, int i2) {
        m1404c(i, i2);
        if (this.f1170h != null) {
            mo9744b(this.f1170h);
            this.f1170h = null;
        }
        m1401a((Queue<int[]>) this.f1180r);
        m1401a((Queue<int[]>) this.f1181s);
        GLES20.glFlush();
        this.f1184v = false;
    }

    /* renamed from: b */
    public void mo9236b(Runnable runnable) {
        if (this.f1168f != null) {
            synchronized (this.f1167e) {
                this.f1169g.add(runnable);
            }
            if (!this.f1168f.hasMessages(1002)) {
                this.f1168f.sendEmptyMessage(1002);
            }
        }
    }

    /* renamed from: b */
    public void mo9744b(int[] iArr) {
        if (iArr != null) {
            this.f1180r.offer(iArr);
        }
    }

    /* renamed from: c */
    public void mo9237c() {
        if (this.f1168f != null && !this.f1168f.hasMessages(1001)) {
            this.f1168f.sendEmptyMessage(1001);
        }
    }

    /* renamed from: c */
    public void mo9745c(int[] iArr) {
        if (iArr != null) {
            this.f1181s.offer(iArr);
        }
    }

    /* renamed from: d */
    public boolean mo9238d() {
        return this.f1175m;
    }

    /* renamed from: e */
    public int mo9239e() {
        return this.f1174l;
    }

    /* renamed from: f */
    public void mo9240f() {
        synchronized (this.f1167e) {
            this.f1169g.clear();
        }
    }

    /* renamed from: g */
    public EGLContext mo9746g() {
        return this.f1167e.mo9763a();
    }

    /* renamed from: h */
    public void mo9747h() {
        m1409q();
        m1406n();
        m1407o();
    }

    /* renamed from: i */
    public void mo9748i() {
        this.f1184v = true;
    }

    /* renamed from: j */
    public void mo9749j() {
        this.f1183u = 0;
    }

    /* renamed from: k */
    public int[] mo9750k() {
        if (this.f1184v) {
            return null;
        }
        return (int[]) this.f1181s.poll();
    }

    /* renamed from: l */
    public int mo9751l() {
        int size;
        synchronized (this.f1182t) {
            size = this.f1181s.size();
        }
        return size;
    }

    /* renamed from: m */
    public void mo9752m() {
        if (!m1412t()) {
            if (this.f1177o > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.f1176n;
                if (currentTimeMillis < ((long) this.f1177o)) {
                    try {
                        Thread.sleep(((long) this.f1177o) - currentTimeMillis);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                this.f1176n = System.currentTimeMillis();
            }
            if (m1413u()) {
                System.currentTimeMillis();
                ARPEngine.getInstance().update();
                this.f1167e.mo9766c();
                synchronized (this.f1182t) {
                    if (this.f1180r.size() != 0) {
                        mo9745c(this.f1170h);
                        this.f1170h = null;
                    }
                }
            }
            m1411s();
        }
    }
}
